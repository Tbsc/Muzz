package tbsc.muzz.nowplaying

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_now_playing_bar.*
import tbsc.muzz.R

/**
 * @author tbsc on 26/03/2018
 */
class NowPlayingBarFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_now_playing_bar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.trackTitleNowPlayingBarTv.isSelected = true
        this.artistAlbumNowPlayingBarTv.isSelected = true
    }

}
