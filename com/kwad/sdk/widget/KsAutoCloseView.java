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
/* loaded from: classes7.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public static String f41476b = "%s秒后自动关闭";
    public int a;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41477c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f41478d;

    /* renamed from: e  reason: collision with root package name */
    public a f41479e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41480f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41481g;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.a = 10;
        this.f41480f = true;
        this.f41481g = false;
        a(context, null, 0);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 10;
        this.f41480f = true;
        this.f41481g = false;
        a(context, attributeSet, 0);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 10;
        this.f41480f = true;
        this.f41481g = false;
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = 10;
        this.f41480f = true;
        this.f41481g = false;
        a(context, attributeSet, i);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i) {
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0446, this);
        this.f41477c = (TextView) findViewById(R.id.obfuscated_res_0x7f091043);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091042);
        this.f41478d = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.f41477c.setText(String.format(f41476b, Integer.valueOf(i)));
    }

    public static /* synthetic */ int e(KsAutoCloseView ksAutoCloseView) {
        int i = ksAutoCloseView.a;
        ksAutoCloseView.a = i - 1;
        return i;
    }

    public void a(int i) {
        if (i <= 0) {
            return;
        }
        this.a = i;
        post(new Runnable() { // from class: com.kwad.sdk.widget.KsAutoCloseView.1
            @Override // java.lang.Runnable
            public void run() {
                if (KsAutoCloseView.this.f41480f) {
                    if (!KsAutoCloseView.this.f41481g) {
                        if (KsAutoCloseView.this.a == 0) {
                            if (KsAutoCloseView.this.f41479e != null) {
                                KsAutoCloseView.this.f41479e.a();
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
        this.f41480f = z;
        int i = z ? 0 : 8;
        TextView textView = this.f41477c;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f41479e != null && view.equals(this.f41478d)) {
            this.f41479e.b();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.f41481g = z;
    }

    public void setViewListener(a aVar) {
        this.f41479e = aVar;
    }
}
