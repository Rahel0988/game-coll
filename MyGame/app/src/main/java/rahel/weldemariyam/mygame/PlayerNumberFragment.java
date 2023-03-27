package rahel.weldemariyam.mygame;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayerNumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PlayerNumberFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PlayerNumberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlayerNumberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PlayerNumberFragment newInstance(String param1, String param2) {
        PlayerNumberFragment fragment = new PlayerNumberFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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
        View view = inflater.inflate(R.layout.fragment_player_number, container, false);


        TextView game = view.findViewById(R.id.textView11);
        TextView onePlayer = view.findViewById(R.id.textView2);
        TextView twoPlayer = view.findViewById(R.id.textView7);
        TextView threePlayer = view.findViewById(R.id.textView8);
        TextView fourPlayer = view.findViewById(R.id.textView9);

        NavController navController = Navigation.findNavController(getActivity(), R.id.fragmentContainerView);
        MyViewModel model = new ViewModelProvider(getActivity()).get(MyViewModel.class);

        if (model.getSelectedGameID() == MyViewModel.TIMER_GAME_ID) {
            threePlayer.setVisibility(View.GONE);
            game.setText("Timer");

            onePlayer.setOnClickListener(v -> {

                model.setSelectedplayerID(MyViewModel.One_PLAYER_ID);

                navController.navigate(R.id.action_playerNumberFragment_to_playersNameFragment);
            });
            twoPlayer.setOnClickListener(V ->{
                model.setSelectedplayerID(MyViewModel.TWO_PLAYER_ID);
                    navController.navigate(R.id.action_gameListFragment_to_playerNumberFragment);
                });
            fourPlayer.setOnClickListener(V ->{
                model.setSelectedplayerID(MyViewModel.FOUR_PLAYER_ID);
                navController.navigate(R.id.action_gameListFragment_to_playerNumberFragment);
            });


        } else if (model.getSelectedGameID() == MyViewModel.RACE_GAME_ID) {
            twoPlayer.setVisibility(view.GONE);
            game.setText("Race");
            onePlayer.setOnClickListener(v -> {

                navController.navigate(R.id.action_gameListFragment_to_playerNumberFragment);
            });
            threePlayer.setOnClickListener(V ->{
                navController.navigate(R.id.action_gameListFragment_to_playerNumberFragment);
            });
            fourPlayer.setOnClickListener(V ->{
                navController.navigate(R.id.action_gameListFragment_to_playerNumberFragment);
            });

        } else if (model.getSelectedGameID() == MyViewModel.CAT_HAND_GAME_ID) {
            onePlayer.setVisibility(view.GONE);
            fourPlayer.setVisibility(view.GONE);
            game.setText("Cat hand");
            twoPlayer.setOnClickListener(V ->{
                navController.navigate(R.id.action_gameListFragment_to_playerNumberFragment);
            });
            fourPlayer.setOnClickListener(V ->{
                navController.navigate(R.id.action_gameListFragment_to_playerNumberFragment);
            });
        }







        return view;


    }

    @Override
    public void onClick(View v) {

    }
}