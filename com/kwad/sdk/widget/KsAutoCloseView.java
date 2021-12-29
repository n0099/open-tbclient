package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static String f60325b = "%s秒后自动关闭";
    public int a;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60326c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60327d;

    /* renamed from: e  reason: collision with root package name */
    public a f60328e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60329f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60330g;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.a = 10;
        this.f60329f = true;
        this.f60330g = false;
        a(context, null, 0);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 10;
        this.f60329f = true;
        this.f60330g = false;
        a(context, attributeSet, 0);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 10;
        this.f60329f = true;
        this.f60330g = false;
        a(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = 10;
        this.f60329f = true;
        this.f60330g = false;
        a(context, attributeSet, i2);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        LinearLayout.inflate(context, R.layout.ksad_interstitial_auto_close, this);
        this.f60326c = (TextView) findViewById(R.id.ksad_auto_close_text);
        ImageView imageView = (ImageView) findViewById(R.id.ksad_auto_close_btn);
        this.f60327d = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        this.f60326c.setText(String.format(f60325b, Integer.valueOf(i2)));
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
                if (KsAutoCloseView.this.f60329f) {
                    if (!KsAutoCloseView.this.f60330g) {
                        if (KsAutoCloseView.this.a == 0) {
                            if (KsAutoCloseView.this.f60328e != null) {
                                KsAutoCloseView.this.f60328e.a();
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
        this.f60329f = z;
        int i2 = z ? 0 : 8;
        TextView textView = this.f60326c;
        if (textView != null) {
            textView.setVisibility(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f60328e != null && view.equals(this.f60327d)) {
            this.f60328e.b();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.f60330g = z;
    }

    public void setViewListener(a aVar) {
        this.f60328e = aVar;
    }
}
