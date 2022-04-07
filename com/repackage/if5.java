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
/* loaded from: classes6.dex */
public interface if5 {
    dg<GifView> getGifViewPool();

    dg<ImageView> getImageViewPool();

    dg<ItemCardView> getItemCardViewPool();

    ListView getListView();

    dg<RelativeLayout> getRelativeLayoutPool();

    int getRichTextViewId();

    dg<TextView> getTextViewPool();

    dg<LinearLayout> getTextVoiceViewPool();

    dg<TiebaPlusRecommendCard> getTiejiaRecommendPool();

    dg<View> getVoiceViewPool();

    void onAtClicked(Context context, String str);

    void onLinkButtonClicked(Context context, String str);

    void onLinkClicked(Context context, String str, boolean z);

    void onPhoneClicked(Context context, String str, String str2);

    void onSongClicked(Context context, String str);

    void onVideoClicked(Context context, String str);

    void onVideoP2PClicked(Context context, String str);
}
