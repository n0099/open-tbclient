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
/* loaded from: classes7.dex */
public interface sf5 {
    eg<LinearLayout> A();

    int E();

    void H(Context context, String str);

    void J(Context context, String str);

    eg<RelativeLayout> M();

    eg<ImageView> O();

    eg<View> P();

    void Q(Context context, String str);

    void R(Context context, String str, boolean z);

    void V(Context context, String str, String str2);

    void Y(Context context, String str);

    eg<TextView> Z0();

    eg<ItemCardView> e0();

    ListView getListView();

    void h1(Context context, String str);

    eg<GifView> x();

    eg<TiebaPlusRecommendCard> z1();
}
