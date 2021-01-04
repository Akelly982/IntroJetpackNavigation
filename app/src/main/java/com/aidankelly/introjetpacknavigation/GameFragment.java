package com.aidankelly.introjetpacknavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.aidankelly.introjetpacknavigation.classes.player;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment {

    // TODOx: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODOx: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GameFragment newInstance(String param1, String param2) {
        GameFragment fragment = new GameFragment();
        //Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button stopButton = view.findViewById(R.id.stopGameButton);   // connect your button
        final TextView currentPlayerTextView = view.findViewById(R.id.currentPlayerTextView);
        final TextView scorePlainText = view.findViewById(R.id.scorePlainText);
        final TextView levelPlainText = view.findViewById(R.id.levelPlainText);
        final Switch winLoseSwitch = view.findViewById(R.id.winLoseSwitch);

        final NavController navController = Navigation.findNavController(view);  // establish the nav controller for the current view (view is grabbed from the above used onViewCreated method)

        //getting your passed arguments
        if(getArguments() != null){ //check if args where passed or not
            GameFragmentArgs args = GameFragmentArgs.fromBundle(getArguments()); //connect to the passed args
            String playerName = args.getPlayerName();  //use args to get your passed arguments / values
            currentPlayerTextView.setText(playerName); // set the passed argument to its text field

        }




        stopButton.setOnClickListener(new View.OnClickListener() {  //button listener
            @Override
            public void onClick(View v) {

                player myPlayer = new player();
                myPlayer.setPlayerName(currentPlayerTextView.getText().toString());
                myPlayer.setWinLose(winLoseSwitch.isChecked());
                myPlayer.setScore(scorePlainText.getText().toString());
                myPlayer.setLevel(levelPlainText.getText().toString());

                //pass serializable class through action
                GameFragmentDirections.ActionGameFragmentToEndGameFragment action = GameFragmentDirections.actionGameFragmentToEndGameFragment(myPlayer);
                navController.navigate(action);



                // ## old way of navigating to new fragment without args
                //navController.navigate(R.id.action_gameFragment_to_endGameFragment); //use navController to get your action to move to the next destination

            }
        });

    }




}