package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class KsToastView extends LinearLayout {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public int f56614b;

    /* renamed from: c  reason: collision with root package name */
    public String f56615c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f56616d;

    public KsToastView(Context context) {
        super(context);
        this.f56614b = 3;
        this.f56615c = "%ss后自动进入";
        this.f56616d = null;
        a(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f56614b = 3;
        this.f56615c = "%ss后自动进入";
        this.f56616d = null;
        a(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f56614b = 3;
        this.f56615c = "%ss后自动进入";
        this.f56616d = null;
        a(context);
    }

    public KsToastView(Context context, boolean z) {
        super(context);
        this.f56614b = 3;
        this.f56615c = "%ss后自动进入";
        this.f56616d = null;
        a(context);
    }

    private void a(Context context) {
        LinearLayout.inflate(context, R.layout.ksad_interstitial_toast_layout, this);
        this.a = (TextView) findViewById(R.id.ksad_total_count_down_text);
    }

    public static /* synthetic */ int b(KsToastView ksToastView) {
        int i2 = ksToastView.f56614b;
        ksToastView.f56614b = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.a.setText(String.format(this.f56615c, Integer.valueOf(i2)));
    }

    public void a(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (this.f56616d == null) {
            this.f56616d = new Runnable() { // from class: com.kwad.sdk.widget.KsToastView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (KsToastView.this.f56614b == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.b(ksToastView.f56614b);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.f56614b = i2;
        post(this.f56616d);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f56616d);
    }
}
