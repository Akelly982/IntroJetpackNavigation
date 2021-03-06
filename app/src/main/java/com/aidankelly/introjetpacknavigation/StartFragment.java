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
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartFragment extends Fragment {


    //skipped the TODOs due to not worrying about different instances of the same fragment at the moment

    // TODOx: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODOx: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StartFragment.
     */
    // TODOx: Rename and change types and number of parameters
    public static StartFragment newInstance(String param1, String param2) {
        StartFragment fragment = new StartFragment();
        //Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {  //given scenario should always == null
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button startButton = view.findViewById(R.id.startGameButton);   // connect your button
        final TextView playerNameTextView = view.findViewById(R.id.playerNamePlainText); //connect TextView


        final NavController navController = Navigation.findNavController(view);  // establish the nav controller for the current view (view is grabbed from the above used onViewCreated method)



        startButton.setOnClickListener(new View.OnClickListener() {  //button listener
            @Override
            public void onClick(View v) {

                final String playerName = playerNameTextView.getText().toString();  // use Text view to get string of playerName for passing

                //get a a hold of the action to
                StartFragmentDirections.ActionStartFragmentToGameFragment myMoveAction = StartFragmentDirections.actionStartFragmentToGameFragment();
                myMoveAction.setPlayerName(playerName); // set playerName to be passed (string)

                navController.navigate(myMoveAction);  // navigate to new fragment using our action



                //##old way just navigation to new fragment without args
                //navController.navigate(R.id.action_startFragment_to_gameFragment); //use navController to get your action to move to the next destination

            }
        });

    }
}