package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.kwad.sdk.m.l;
import java.util.List;
/* loaded from: classes10.dex */
public class KsAppTagsView extends LinearLayout {
    public int Ic;

    public KsAppTagsView(Context context) {
        super(context);
        this.Ic = 3;
    }

    public void setAppTags(List<String> list) {
        a(list, R.layout.obfuscated_res_0x7f0d04fc);
    }

    public void setMaxCount(int i) {
        this.Ic = i;
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ic = 3;
    }

    public final void a(List<String> list, @LayoutRes int i) {
        if (list == null) {
            return;
        }
        int i2 = 0;
        for (String str : list) {
            i2++;
            if (i2 <= this.Ic) {
                a(this, str, i);
            } else {
                return;
            }
        }
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ic = 3;
    }

    public static void a(LinearLayout linearLayout, String str, @LayoutRes int i) {
        TextView textView = (TextView) l.a(linearLayout.getContext(), i, linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }

    @RequiresApi(api = 21)
    public KsAppTagsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Ic = 3;
    }
}
