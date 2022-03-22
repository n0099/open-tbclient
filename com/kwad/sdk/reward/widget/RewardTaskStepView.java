package com.kwad.sdk.reward.widget;

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
import com.kwad.sdk.reward.b.b;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class RewardTaskStepView extends LinearLayout {
    public List<b> a;

    /* renamed from: b  reason: collision with root package name */
    public int f41102b;

    /* renamed from: c  reason: collision with root package name */
    public int f41103c;

    public RewardTaskStepView(Context context) {
        super(context);
        this.a = new ArrayList();
        a(context, (AttributeSet) null, 0);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new ArrayList();
        a(context, attributeSet, 0);
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new ArrayList();
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = new ArrayList();
        a(context, attributeSet, i);
    }

    private void a() {
        int size = this.a.size();
        int i = 0;
        while (i < size) {
            b bVar = this.a.get(i);
            int i2 = i + 1;
            a(i2, bVar.c(), bVar.d());
            if (i < size - 1) {
                a(this.a.get(i2).d());
            }
            i = i2;
        }
    }

    private void a(int i, String str, boolean z) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(z ? R.layout.obfuscated_res_0x7f0d0470 : R.layout.obfuscated_res_0x7f0d0471, (ViewGroup) this, false);
        if (z) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i, str);
        }
        addView(viewGroup);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i) {
        setOrientation(1);
        this.f41102b = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070371);
        this.f41103c = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070372);
    }

    private void a(ViewGroup viewGroup, int i, String str) {
        ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09112e)).setText(str);
        ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09112d)).setText(String.valueOf(i));
    }

    private void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09112e)).setText(str);
    }

    private void a(boolean z) {
        DividerView dividerView = (DividerView) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d046e, (ViewGroup) this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070371);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07036f);
        dividerView.setDividerColor(getResources().getColor(z ? R.color.obfuscated_res_0x7f060757 : R.color.obfuscated_res_0x7f06075a));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private int getStepIconSize() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070371);
    }

    public void a(List<b> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.a.clear();
        this.a.addAll(list);
        a();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
