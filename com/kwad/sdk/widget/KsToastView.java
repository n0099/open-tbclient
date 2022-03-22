package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class KsToastView extends LinearLayout {
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public int f41493b;

    /* renamed from: c  reason: collision with root package name */
    public String f41494c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f41495d;

    public KsToastView(Context context) {
        super(context);
        this.f41493b = 3;
        this.f41494c = "%ss后自动进入";
        this.f41495d = null;
        a(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41493b = 3;
        this.f41494c = "%ss后自动进入";
        this.f41495d = null;
        a(context);
    }

    public KsToastView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f41493b = 3;
        this.f41494c = "%ss后自动进入";
        this.f41495d = null;
        a(context);
    }

    public KsToastView(Context context, boolean z) {
        super(context);
        this.f41493b = 3;
        this.f41494c = "%ss后自动进入";
        this.f41495d = null;
        a(context);
    }

    private void a(Context context) {
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d044b, this);
        this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f091158);
    }

    public static /* synthetic */ int b(KsToastView ksToastView) {
        int i = ksToastView.f41493b;
        ksToastView.f41493b = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.a.setText(String.format(this.f41494c, Integer.valueOf(i)));
    }

    public void a(int i) {
        if (i <= 0) {
            return;
        }
        if (this.f41495d == null) {
            this.f41495d = new Runnable() { // from class: com.kwad.sdk.widget.KsToastView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (KsToastView.this.f41493b == 0) {
                        return;
                    }
                    KsToastView ksToastView = KsToastView.this;
                    ksToastView.b(ksToastView.f41493b);
                    KsToastView.b(KsToastView.this);
                    KsToastView.this.postDelayed(this, 1000L);
                }
            };
        }
        this.f41493b = i;
        post(this.f41495d);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f41495d);
    }
}
