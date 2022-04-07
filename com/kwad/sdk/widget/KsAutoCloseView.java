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
/* loaded from: classes5.dex */
public class KsAutoCloseView extends LinearLayout implements View.OnClickListener {
    public static String b = "%s秒后自动关闭";
    public int a;
    public TextView c;
    public ImageView d;
    public a e;
    public boolean f;
    public boolean g;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    public KsAutoCloseView(Context context) {
        super(context);
        this.a = 10;
        this.f = true;
        this.g = false;
        a(context, null, 0);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 10;
        this.f = true;
        this.g = false;
        a(context, attributeSet, 0);
    }

    public KsAutoCloseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 10;
        this.f = true;
        this.g = false;
        a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KsAutoCloseView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = 10;
        this.f = true;
        this.g = false;
        a(context, attributeSet, i);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i) {
        LinearLayout.inflate(context, R.layout.obfuscated_res_0x7f0d0441, this);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f09103c);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09103b);
        this.d = imageView;
        imageView.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        this.c.setText(String.format(b, Integer.valueOf(i)));
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
                if (KsAutoCloseView.this.f) {
                    if (!KsAutoCloseView.this.g) {
                        if (KsAutoCloseView.this.a == 0) {
                            if (KsAutoCloseView.this.e != null) {
                                KsAutoCloseView.this.e.a();
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
        this.f = z;
        int i = z ? 0 : 8;
        TextView textView = this.c;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.e != null && view2.equals(this.d)) {
            this.e.b();
        }
    }

    public void setCountDownPaused(boolean z) {
        this.g = z;
    }

    public void setViewListener(a aVar) {
        this.e = aVar;
    }
}
