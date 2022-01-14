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
import com.kwad.sdk.R;
/* loaded from: classes3.dex */
public class SkipView extends LinearLayout {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public View f58055b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f58056c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f58057d;

    /* renamed from: e  reason: collision with root package name */
    public a f58058e;

    /* renamed from: f  reason: collision with root package name */
    public int f58059f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f58060g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f58061h;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public static class b {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58062b;

        /* renamed from: c  reason: collision with root package name */
        public int f58063c;

        /* renamed from: d  reason: collision with root package name */
        public int f58064d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f58065e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f58066f;

        public b() {
            this.a = "跳过";
            this.f58062b = "";
            this.f58063c = 5;
            this.f58064d = 5;
            this.f58065e = true;
            this.f58066f = true;
        }

        public static /* synthetic */ int a(b bVar) {
            int i2 = bVar.f58064d;
            bVar.f58064d = i2 - 1;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return this.f58065e && this.f58066f;
        }

        public String a() {
            StringBuilder sb;
            int i2;
            int i3 = this.f58064d;
            if (i3 < 0) {
                return this.f58062b;
            }
            if (i3 == 0) {
                sb = new StringBuilder();
                sb.append(this.f58062b);
                i2 = 1;
            } else {
                sb = new StringBuilder();
                sb.append(this.f58062b);
                i2 = this.f58064d;
            }
            sb.append(i2);
            return sb.toString();
        }

        public void a(int i2) {
            this.f58063c = i2;
            this.f58064d = i2;
        }

        public void a(String str) {
            this.f58064d = -1;
            this.f58062b = str;
        }

        public boolean b() {
            return this.f58064d <= 0;
        }
    }

    public SkipView(Context context) {
        super(context);
        this.a = new b();
        this.f58059f = -1;
        this.f58060g = false;
        this.f58061h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f58060g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f58058e != null) {
                    SkipView.this.f58058e.b();
                }
            }
        };
        a(context, null, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b();
        this.f58059f = -1;
        this.f58060g = false;
        this.f58061h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f58060g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f58058e != null) {
                    SkipView.this.f58058e.b();
                }
            }
        };
        a(context, attributeSet, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new b();
        this.f58059f = -1;
        this.f58060g = false;
        this.f58061h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f58060g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f58058e != null) {
                    SkipView.this.f58058e.b();
                }
            }
        };
        a(context, attributeSet, i2, 0);
    }

    @RequiresApi(api = 21)
    public SkipView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = new b();
        this.f58059f = -1;
        this.f58060g = false;
        this.f58061h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f58060g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f58058e != null) {
                    SkipView.this.f58058e.b();
                }
            }
        };
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.ksad_skip_view, this);
        this.f58056c = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.f58057d = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.f58055b = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SkipView.this.f58058e != null) {
                    SkipView.this.f58058e.a();
                }
            }
        });
        setSkipBtnVisible(true);
        setTimerBtnVisible(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        int i2;
        if (bVar == null) {
            return;
        }
        if (this.f58056c != null) {
            if (bVar.a != null) {
                this.f58056c.setText(bVar.a);
            }
            this.f58056c.setVisibility(this.a.f58065e ? 0 : 8);
        }
        String a2 = bVar.a();
        TextView textView = this.f58057d;
        if (textView != null) {
            if (a2 != null) {
                textView.setText(a2);
            }
            this.f58057d.setVisibility(this.a.f58066f ? 0 : 8);
        }
        if (this.f58055b != null) {
            boolean c2 = this.a.c();
            this.f58055b.setVisibility(c2 ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (c2) {
                    i2 = this.f58059f;
                    if (i2 <= 0) {
                        return;
                    }
                } else {
                    i2 = -2;
                }
                layoutParams.width = i2;
                invalidate();
            }
        }
    }

    public void a() {
        a(this.a);
        post(this.f58061h);
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
        this.f58060g = true;
    }

    public void d() {
        this.f58060g = false;
    }

    public void e() {
        setVisibility(8);
    }

    public boolean f() {
        TextView textView = this.f58057d;
        return textView != null && textView.getVisibility() == 0;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f58059f = layoutParams.width;
    }

    public void setOnViewListener(a aVar) {
        this.f58058e = aVar;
    }

    public void setSkipBtnVisible(boolean z) {
        this.a.f58065e = z;
        a(this.a);
    }

    public void setSkipText(String str) {
        this.a.a = str;
        a(this.a);
    }

    public void setTimerBtnVisible(boolean z) {
        this.a.f58066f = z;
        a(this.a);
    }

    public void setTimerPrefixText(String str) {
        this.a.f58062b = str;
        a(this.a);
    }

    public void setTimerSecond(int i2) {
        this.a.a(i2);
        a(this.a);
    }
}
