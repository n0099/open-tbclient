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
public interface ji5 {
    int C();

    void F(Context context, String str);

    void H(Context context, String str);

    fg<RelativeLayout> L();

    fg<ImageView> N();

    fg<View> O();

    void Q(Context context, String str);

    void R(Context context, String str, boolean z);

    void V(Context context, String str, String str2);

    void Y(Context context, String str);

    fg<TextView> Y0();

    fg<ItemCardView> e0();

    void g1(Context context, String str);

    ListView getListView();

    fg<GifView> v();

    fg<LinearLayout> y();

    fg<TiebaPlusRecommendCard> y1();
}
