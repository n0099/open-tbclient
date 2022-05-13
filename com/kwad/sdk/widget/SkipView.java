package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class SkipView extends LinearLayout {
    public final b a;
    public View b;
    public TextView c;
    public TextView d;
    public a e;
    public int f;
    public boolean g;
    public Runnable h;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public static class b {
        public String a;
        public String b;
        public int c;
        public int d;
        public boolean e;
        public boolean f;

        public b() {
            this.a = "跳过";
            this.b = "";
            this.c = 5;
            this.d = 5;
            this.e = true;
            this.f = true;
        }

        public static /* synthetic */ int a(b bVar) {
            int i = bVar.d;
            bVar.d = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return this.e && this.f;
        }

        public String a() {
            StringBuilder sb;
            int i;
            int i2 = this.d;
            if (i2 < 0) {
                return this.b;
            }
            if (i2 == 0) {
                sb = new StringBuilder();
                sb.append(this.b);
                i = 1;
            } else {
                sb = new StringBuilder();
                sb.append(this.b);
                i = this.d;
            }
            sb.append(i);
            return sb.toString();
        }

        public void a(int i) {
            this.c = i;
            this.d = i;
        }

        public void a(String str) {
            this.d = -1;
            this.b = str;
        }

        public boolean b() {
            return this.d <= 0;
        }
    }

    public SkipView(Context context) {
        super(context);
        this.a = new b();
        this.f = -1;
        this.g = false;
        this.h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.e != null) {
                    SkipView.this.e.b();
                }
            }
        };
        a(context, null, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b();
        this.f = -1;
        this.g = false;
        this.h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.e != null) {
                    SkipView.this.e.b();
                }
            }
        };
        a(context, attributeSet, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new b();
        this.f = -1;
        this.g = false;
        this.h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.e != null) {
                    SkipView.this.e.b();
                }
            }
        };
        a(context, attributeSet, i, 0);
    }

    @RequiresApi(api = 21)
    public SkipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = new b();
        this.f = -1;
        this.g = false;
        this.h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.e != null) {
                    SkipView.this.e.b();
                }
            }
        };
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0462, this);
        this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f091144);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f091145);
        this.b = findViewById(R.id.obfuscated_res_0x7f091143);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (SkipView.this.e != null) {
                    SkipView.this.e.a();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        int i;
        if (bVar == null) {
            return;
        }
        if (this.c != null) {
            if (bVar.a != null) {
                this.c.setText(bVar.a);
            }
            this.c.setVisibility(this.a.e ? 0 : 8);
        }
        String a2 = bVar.a();
        TextView textView = this.d;
        if (textView != null) {
            if (a2 != null) {
                textView.setText(a2);
            }
            this.d.setVisibility(this.a.f ? 0 : 8);
        }
        if (this.b != null) {
            boolean c = this.a.c();
            this.b.setVisibility(c ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (c) {
                    i = this.f;
                    if (i <= 0) {
                        return;
                    }
                } else {
                    i = -2;
                }
                layoutParams.width = i;
                invalidate();
            }
        }
    }

    public void a() {
        a(this.a);
        post(this.h);
    }

    public void a(String str) {
        if (str == null) {
            return;
        }
        this.a.a(str);
        a(this.a);
    }

    public void b() {
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        setAlpha(0.0f);
        animate().alpha(1.0f).setDuration(500L).start();
    }

    public void c() {
        this.g = true;
    }

    public void d() {
        this.g = false;
    }

    public void e() {
        setVisibility(8);
    }

    public boolean f() {
        TextView textView = this.d;
        return textView != null && textView.getVisibility() == 0;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f = layoutParams.width;
    }

    public void setOnViewListener(a aVar) {
        this.e = aVar;
    }

    public void setSkipBtnVisible(boolean z) {
        this.a.e = z;
        a(this.a);
    }

    public void setSkipText(String str) {
        this.a.a = str;
        a(this.a);
    }

    public void setTimerBtnVisible(boolean z) {
        this.a.f = z;
        a(this.a);
    }

    public void setTimerPrefixText(String str) {
        this.a.b = str;
        a(this.a);
    }

    public void setTimerSecond(int i) {
        this.a.a(i);
        a(this.a);
    }
}
