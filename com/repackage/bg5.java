package com.repackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
/* loaded from: classes5.dex */
public interface bg5 {
    bg<GifView> getGifViewPool();

    bg<ImageView> getImageViewPool();

    bg<ItemCardView> getItemCardViewPool();

    ListView getListView();

    bg<RelativeLayout> getRelativeLayoutPool();

    int getRichTextViewId();

    bg<TextView> getTextViewPool();

    bg<LinearLayout> getTextVoiceViewPool();

    bg<TiebaPlusRecommendCard> getTiejiaRecommendPool();

    bg<View> getVoiceViewPool();

    void onAtClicked(Context context, String str);

    void onLinkButtonClicked(Context context, String str);

    void onLinkClicked(Context context, String str, boolean z);

    void onPhoneClicked(Context context, String str, String str2);

    void onSongClicked(Context context, String str);

    void onVideoClicked(Context context, String str);

    void onVideoP2PClicked(Context context, String str);
}
