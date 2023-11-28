package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.m.l;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class RewardTaskStepView extends LinearLayout {
    public List<c> Bp;
    public String pY;

    public RewardTaskStepView(Context context) {
        super(context);
        this.Bp = new ArrayList();
        kd();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bp = new ArrayList();
        kd();
    }

    public static void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091482)).setText(str);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bp = new ArrayList();
        kd();
    }

    private void a(ViewGroup viewGroup, int i, String str) {
        ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091482)).setText(String.format(str, this.pY));
        ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091481)).setText(String.valueOf(i));
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Bp = new ArrayList();
        kd();
    }

    private void a(int i, String str, String str2, boolean z) {
        int i2;
        if (z) {
            i2 = R.layout.obfuscated_res_0x7f0d050c;
        } else {
            i2 = R.layout.obfuscated_res_0x7f0d050d;
        }
        ViewGroup viewGroup = (ViewGroup) l.a(getContext(), i2, this, false);
        if (z) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i, str2);
        }
        addView(viewGroup);
    }

    private void ad(boolean z) {
        int i;
        DividerView dividerView = (DividerView) l.a(getContext(), R.layout.obfuscated_res_0x7f0d050a, this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704fe);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0704fc);
        if (z) {
            i = R.color.obfuscated_res_0x7f0607a6;
        } else {
            i = R.color.obfuscated_res_0x7f0607a8;
        }
        dividerView.setDividerColor(getResources().getColor(i));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private void kd() {
        setOrientation(1);
    }

    private void ke() {
        int size = this.Bp.size();
        int i = 0;
        while (i < size) {
            c cVar = this.Bp.get(i);
            int i2 = i + 1;
            a(i2, cVar.js(), cVar.jt(), cVar.isCompleted());
            if (i < size - 1) {
                ad(this.Bp.get(i2).isCompleted());
            }
            i = i2;
        }
    }

    public final void a(List<c> list, String str) {
        if (list != null && !list.isEmpty()) {
            this.pY = str;
            this.Bp.clear();
            this.Bp.addAll(list);
            ke();
        }
    }
}
