package com.kascend.chushou.player.ui.giftpopup;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.kascend.chushou.constants.ListItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class GiftPopupLayout extends LinearLayout {
    private int a;
    private int b;

    public GiftPopupLayout(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public GiftPopupLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public GiftPopupLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet) {
        this.a = tv.chushou.zues.utils.a.dip2px(context, 36.0f);
        this.b = tv.chushou.zues.utils.a.dip2px(context, 12.0f);
    }

    public void a(List<ListItem> list, int i) {
        if (h.isEmpty(list)) {
            removeAllViews();
            setVisibility(8);
            return;
        }
        removeAllViews();
        ArrayList<ListItem> arrayList = new ArrayList(list);
        if (i == 2) {
            Collections.reverse(arrayList);
        }
        setOrientation(0);
        int i2 = 0;
        for (ListItem listItem : arrayList) {
            b bVar = new b(getContext());
            bVar.a(i, list, listItem);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.a);
            if (i == 1) {
                layoutParams.leftMargin = i2 == 0 ? 0 : this.b;
            } else if (i == 2) {
                layoutParams.leftMargin = i2 == 0 ? 0 : this.b;
            }
            addView(bVar, layoutParams);
            i2++;
        }
    }
}
