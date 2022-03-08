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
/* loaded from: classes8.dex */
public class RewardTaskStepView extends LinearLayout {
    public List<b> a;

    /* renamed from: b  reason: collision with root package name */
    public int f56170b;

    /* renamed from: c  reason: collision with root package name */
    public int f56171c;

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

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new ArrayList();
        a(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = new ArrayList();
        a(context, attributeSet, i2);
    }

    private void a() {
        int size = this.a.size();
        int i2 = 0;
        while (i2 < size) {
            b bVar = this.a.get(i2);
            int i3 = i2 + 1;
            a(i3, bVar.c(), bVar.d());
            if (i2 < size - 1) {
                a(this.a.get(i3).d());
            }
            i2 = i3;
        }
    }

    private void a(int i2, String str, boolean z) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(z ? R.layout.ksad_reward_task_step_item_checked : R.layout.ksad_reward_task_step_item_unchecked, (ViewGroup) this, false);
        if (z) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i2, str);
        }
        addView(viewGroup);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        setOrientation(1);
        this.f56170b = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
        this.f56171c = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_text_size);
    }

    private void a(ViewGroup viewGroup, int i2, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(str);
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_icon_text)).setText(String.valueOf(i2));
    }

    private void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(str);
    }

    private void a(boolean z) {
        DividerView dividerView = (DividerView) LayoutInflater.from(getContext()).inflate(R.layout.ksad_reward_task_dialog_dash, (ViewGroup) this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_divider_height);
        dividerView.setDividerColor(getResources().getColor(z ? R.color.ksad_reward_main_color : R.color.ksad_reward_undone_color));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private int getStepIconSize() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
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
