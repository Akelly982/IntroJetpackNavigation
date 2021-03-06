package com.aidankelly.introjetpacknavigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aidankelly.introjetpacknavigation.classes.player;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EndGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EndGameFragment extends Fragment {

    // TODOx: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODOx: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EndGameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EndGameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EndGameFragment newInstance(String param1, String param2) {
        EndGameFragment fragment = new EndGameFragment();
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
        return inflater.inflate(R.layout.fragment_end_game, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button restartButton = view.findViewById(R.id.restartGameButton);   // connect your button
        TextView winLoseTextView = view.findViewById(R.id.endGameWinLoseTextView);   // connect your textViews
        TextView playerNameTextView = view.findViewById(R.id.endGamePlayerNameTextView);
        TextView scoreTextView = view.findViewById(R.id.endGameScoreTextView);
        TextView levelTextView = view.findViewById(R.id.endGameLevelTextView);


        if(getArguments() != null){
            EndGameFragmentArgs args = EndGameFragmentArgs.fromBundle(getArguments()); //get passed arguments / data
            player myPlayer = args.getPlayer(); //assign received player data

            //apply data
            playerNameTextView.setText(myPlayer.getPlayerName());
            scoreTextView.setText(myPlayer.getScore());
            levelTextView.setText(myPlayer.getLevel());
            if(myPlayer.getWinLose()){
                winLoseTextView.setText("Winner");
            }else{
                winLoseTextView.setText("Loser");
            }

        }







        final NavController navController = Navigation.findNavController(view);  // establish the nav controller for the current view (view is grabbed from the above used onViewCreated method)



        restartButton.setOnClickListener(new View.OnClickListener() {  //button listener
            @Override
            public void onClick(View v) {
                //navController.navigate(R.id.action_endGameFragment_to_startFragment);    //use navController to get your action to move to the next destination

                //Above works great for adding to the stack but bellow pops you back through the stack to the beginning. this way when u press back from the
                //start screen in exits the application rather than returns you to the last screen
                NavOptions navOptions = new NavOptions.Builder().setPopUpTo(R.id.startFragment,true).build();

                navController.navigate(R.id.action_endGameFragment_to_startFragment, null,navOptions);

            }
        });

    }




}