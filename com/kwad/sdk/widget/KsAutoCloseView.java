package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static String f56597b = "%s秒后自动关闭";
    public int a;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56598c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f56599d;

    /* renamed from: e  reason: collision with root package name */
    public a f56600e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56601f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56602g;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void b();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.a = 10;
        this.f56601f = true;
        this.f56602g = false;
        a(context, null, 0);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 10;
        this.f56601f = true;
        this.f56602g = false;
        a(context, attributeSet, 0);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 10;
        this.f56601f = true;
        this.f56602g = false;
        a(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = 10;
        this.f56601f = true;
        this.f56602g = false;
        a(context, attributeSet, i2);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        LinearLayout.inflate(context, R.layout.ksad_interstitial_auto_close, this);
        this.f56598c = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.f56599d = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f56598c.setText(String.format(f56597b, Integer.valueOf(i2)));
    }

    public static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i2 = ksAutoCloseView.a;
        ksAutoCloseView.a = i2 - 1;
        return i2;
    }

    public void a(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.a = i2;
        post(new Runnable() { // from class: com.kwad.sdk.widget.KsAutoCloseView.1
            @Override // java.lang.Runnable
            public void run() {
                if (KsAutoCloseView.this.f56601f) {
                    if (!KsAutoCloseView.this.f56602g) {
                        if (KsAutoCloseView.this.a == 0) {
                            if (KsAutoCloseView.this.f56600e != null) {
                                KsAutoCloseView.this.f56600e.a();
                                return;
                            }
                            return;
                        }
                        KsAutoCloseView ksAutoCloseView = KsAutoCloseView.this;
                        ksAutoCloseView.b(ksAutoCloseView.a);
                        KsAutoCloseView.e(KsAutoCloseView.this);
                    }
                    KsAutoCloseView.this.postDelayed(this, 1000L);
                }
            }
        });
    }

    public void a(boolean z) {
        this.f56601f = z;
        int i2 = z ? 0 : 8;
        TextView textView = this.f56598c;
        if (textView != null) {
            textView.setVisibility(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f56600e != null && view.equals(this.f56599d)) {
            this.f56600e.b();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.f56602g = z;
    }

    public void setViewListener(a aVar) {
        this.f56600e = aVar;
    }
}
