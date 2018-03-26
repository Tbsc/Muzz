package tbsc.muzz.nowplaying;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tbsc.muzz.R;

/**
 * @author tbsc on 26/03/2018
 */
public class NowPlayingBarFragment extends Fragment {

    @BindView(R.id.tv_nowplayingbar_tracktitle)
    public TextView trackTitleTv;

    @BindView(R.id.tv_nowplayingbar_artistalbum)
    public TextView artistAlbumTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_now_playing_bar, container, false);

        ButterKnife.bind(this, view);

        trackTitleTv.setSelected(true);
        artistAlbumTv.setSelected(true);

        return view;
    }
}
