package com.kwad.components.ad.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes10.dex */
public class KsAppTagsView extends LinearLayout {
    public int Cu;

    public KsAppTagsView(Context context) {
        super(context);
        this.Cu = 3;
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Cu = 3;
    }

    public KsAppTagsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Cu = 3;
    }

    @RequiresApi(api = 21)
    public KsAppTagsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Cu = 3;
    }

    public static void a(LinearLayout linearLayout, String str, @LayoutRes int i) {
        TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(i, (ViewGroup) linearLayout, false);
        textView.setText(str);
        linearLayout.addView(textView);
    }

    public final void c(List<String> list, @LayoutRes int i) {
        if (list == null) {
            return;
        }
        int i2 = 0;
        for (String str : list) {
            i2++;
            if (i2 > this.Cu) {
                return;
            }
            a(this, str, i);
        }
    }

    public void setAppTags(List<String> list) {
        c(list, R.layout.obfuscated_res_0x7f0d04ca);
    }

    public void setMaxCount(int i) {
        this.Cu = i;
    }
}
