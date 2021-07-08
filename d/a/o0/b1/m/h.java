package d.a.o0.b1.m;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.gif.GifView;
/* loaded from: classes7.dex */
public interface h {
    d.a.c.e.k.b<GifView> getGifViewPool();

    d.a.c.e.k.b<ImageView> getImageViewPool();

    ListView getListView();

    d.a.c.e.k.b<RelativeLayout> getRelativeLayoutPool();

    int getRichTextViewId();

    d.a.c.e.k.b<TextView> getTextViewPool();

    d.a.c.e.k.b<LinearLayout> getTextVoiceViewPool();

    d.a.c.e.k.b<View> getVoiceViewPool();

    void onAtClicked(Context context, String str);

    void onLinkButtonClicked(Context context, String str);

    void onLinkClicked(Context context, String str, boolean z);

    void onPhoneClicked(Context context, String str, String str2);

    void onSongClicked(Context context, String str);

    void onVideoClicked(Context context, String str);

    void onVideoP2PClicked(Context context, String str);
}
