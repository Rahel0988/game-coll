package rahel.weldemariyam.mygame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayersNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayersNameFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private NavController navController;

    public PlayersNameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayersNameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayersNameFragment newInstance(String param1, String param2) {
        PlayersNameFragment fragment = new PlayersNameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_players_name, container, false);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            TextView name_of_player = view.findViewById(R.id.textView6);

          EditText player_one =  view.findViewById(R.id.editTextTextPersonName);
            EditText player_two  =view.findViewById(R.id.editTextTextPersonName2);
            EditText player_three = view.findViewById(R.id.editTextTextPersonName3);
            EditText player_four  = view.findViewById(R.id.editTextTextPersonName4);
            TextView start = view.findViewById(R.id.button);

            start.setOnClickListener(V ->{
                navController.navigate(R.id.action_playersNameFragment_to_timerFragment);
            });

            NavController navController = Navigation.findNavController(getActivity(), R.id.fragmentContainerView);
            MyViewModel model = new ViewModelProvider(getActivity()).get(MyViewModel.class);



            if (model.getSelectedPlayerID() == MyViewModel.One_PLAYER_ID) {
                player_two.setVisibility(View.GONE);
                player_three.setVisibility(View.GONE);
                player_four.setVisibility(View.GONE);
                name_of_player.setText("player name");

//

        }
            else if (model.getSelectedPlayerID() == MyViewModel.TWO_PLAYER_ID) {
                player_three.setVisibility(View.GONE);
                player_four.setVisibility(View.GONE);


    }
            else  if (model.getSelectedPlayerID() == MyViewModel.THREE_PLAYER_ID) {
                player_four.setVisibility(View.GONE);}

            else if  (model.getSelectedPlayerID() == MyViewModel.FOUR_PLAYER_ID) {

        return view;
    }

        }
        return view;
    }}


