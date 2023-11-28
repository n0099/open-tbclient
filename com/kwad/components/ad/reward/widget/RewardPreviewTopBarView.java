package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public class RewardPreviewTopBarView extends KSFrameLayout implements View.OnClickListener {
    public String Bg;
    public String Bh;
    public ProgressBar Bi;
    public TextView Bj;
    public ImageView Bk;
    public long Bl;
    public long Bm;
    public boolean Bn;
    public a Bo;
    public TextView sz;

    /* loaded from: classes10.dex */
    public interface a {
        void F(boolean z);

        void G(boolean z);
    }

    public RewardPreviewTopBarView(@NonNull Context context) {
        super(context);
        this.Bg = " 秒后即可获得奖励";
        this.Bh = "恭喜你获得奖励";
        this.Bl = -1L;
        this.Bn = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        a aVar;
        if (view2.equals(this.Bk) && (aVar = this.Bo) != null) {
            aVar.F(this.Bn);
        }
    }

    @MainThread
    public void setCloseBtnDelayShowDuration(long j) {
        this.Bm = j;
        if (j <= 0) {
            this.Bk.setVisibility(0);
        }
    }

    @MainThread
    public void setRewardTips(String str) {
        TextView textView = this.sz;
        if (textView != null && str != null) {
            textView.setText(str);
        }
    }

    public void setTopBarListener(a aVar) {
        this.Bo = aVar;
    }

    @MainThread
    public void setTotalCountDuration(long j) {
        this.Bl = j;
        this.Bi.setMax((int) j);
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bg = " 秒后即可获得奖励";
        this.Bh = "恭喜你获得奖励";
        this.Bl = -1L;
        this.Bn = false;
    }

    @MainThread
    private void e(long j, long j2) {
        this.Bi.setProgress((int) (j2 - j));
    }

    public RewardPreviewTopBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Bg = " 秒后即可获得奖励";
        this.Bh = "恭喜你获得奖励";
        this.Bl = -1L;
        this.Bn = false;
    }

    @MainThread
    private void e(boolean z, boolean z2) {
        if (!this.Bn) {
            this.sz.setVisibility(8);
            this.Bj.setText(this.Bh);
            a aVar = this.Bo;
            if (aVar != null) {
                aVar.G(false);
            }
        } else {
            this.sz.setVisibility(0);
        }
        this.Bn = true;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        FrameLayout.inflate(getContext(), R.layout.obfuscated_res_0x7f0d04a8, this);
        this.Bi = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091405);
        this.sz = (TextView) findViewById(R.id.obfuscated_res_0x7f091408);
        this.Bj = (TextView) findViewById(R.id.obfuscated_res_0x7f091406);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091404);
        this.Bk = imageView;
        imageView.setVisibility(8);
        this.Bk.setOnClickListener(this);
    }

    public final boolean kc() {
        return this.Bn;
    }

    @MainThread
    public final void n(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        TextView textView = this.Bj;
        if (textView != null) {
            textView.setText(ceil + this.Bg);
        }
        e(j, this.Bl);
        if (this.Bl - j >= this.Bm && this.Bk.getVisibility() != 0) {
            this.Bk.setVisibility(0);
        }
        if (ceil <= 0) {
            e(true, false);
        }
    }
}
