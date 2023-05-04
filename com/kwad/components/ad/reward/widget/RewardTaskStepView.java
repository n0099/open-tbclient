package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
import com.kwad.components.ad.reward.i.c;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class RewardTaskStepView extends LinearLayout {
    public String no;
    public List<c> wG;

    public RewardTaskStepView(Context context) {
        super(context);
        this.wG = new ArrayList();
        je();
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.wG = new ArrayList();
        je();
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.wG = new ArrayList();
        je();
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.wG = new ArrayList();
        je();
    }

    private void a(int i, String str, String str2, boolean z) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(z ? R.layout.obfuscated_res_0x7f0d04a1 : R.layout.obfuscated_res_0x7f0d04a2, (ViewGroup) this, false);
        if (z) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i, str2);
        }
        addView(viewGroup);
    }

    private void a(ViewGroup viewGroup, int i, String str) {
        ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091342)).setText(String.format(str, this.no));
        ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091341)).setText(String.valueOf(i));
    }

    public static void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091342)).setText(str);
    }

    private void ac(boolean z) {
        DividerView dividerView = (DividerView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d049f, (ViewGroup) this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703aa);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703a8);
        dividerView.setDividerColor(getResources().getColor(z ? R.color.obfuscated_res_0x7f060625 : R.color.obfuscated_res_0x7f060627));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private void je() {
        setOrientation(1);
    }

    private void jf() {
        int size = this.wG.size();
        int i = 0;
        while (i < size) {
            c cVar = this.wG.get(i);
            int i2 = i + 1;
            a(i2, cVar.iv(), cVar.iw(), cVar.isCompleted());
            if (i < size - 1) {
                ac(this.wG.get(i2).isCompleted());
            }
            i = i2;
        }
    }

    public final void a(List<c> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.no = str;
        this.wG.clear();
        this.wG.addAll(list);
        jf();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
