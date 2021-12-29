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
    public View f60345b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60346c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60347d;

    /* renamed from: e  reason: collision with root package name */
    public a f60348e;

    /* renamed from: f  reason: collision with root package name */
    public int f60349f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f60350g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f60351h;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public static class b {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f60352b;

        /* renamed from: c  reason: collision with root package name */
        public int f60353c;

        /* renamed from: d  reason: collision with root package name */
        public int f60354d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f60355e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f60356f;

        public b() {
            this.a = "跳过";
            this.f60352b = "";
            this.f60353c = 5;
            this.f60354d = 5;
            this.f60355e = true;
            this.f60356f = true;
        }

        public static /* synthetic */ int a(b bVar) {
            int i2 = bVar.f60354d;
            bVar.f60354d = i2 - 1;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return this.f60355e && this.f60356f;
        }

        public String a() {
            StringBuilder sb;
            int i2;
            int i3 = this.f60354d;
            if (i3 < 0) {
                return this.f60352b;
            }
            if (i3 == 0) {
                sb = new StringBuilder();
                sb.append(this.f60352b);
                i2 = 1;
            } else {
                sb = new StringBuilder();
                sb.append(this.f60352b);
                i2 = this.f60354d;
            }
            sb.append(i2);
            return sb.toString();
        }

        public void a(int i2) {
            this.f60353c = i2;
            this.f60354d = i2;
        }

        public void a(String str) {
            this.f60354d = -1;
            this.f60352b = str;
        }

        public boolean b() {
            return this.f60354d <= 0;
        }
    }

    public SkipView(Context context) {
        super(context);
        this.a = new b();
        this.f60349f = -1;
        this.f60350g = false;
        this.f60351h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f60350g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f60348e != null) {
                    SkipView.this.f60348e.b();
                }
            }
        };
        a(context, null, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b();
        this.f60349f = -1;
        this.f60350g = false;
        this.f60351h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f60350g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f60348e != null) {
                    SkipView.this.f60348e.b();
                }
            }
        };
        a(context, attributeSet, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new b();
        this.f60349f = -1;
        this.f60350g = false;
        this.f60351h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f60350g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f60348e != null) {
                    SkipView.this.f60348e.b();
                }
            }
        };
        a(context, attributeSet, i2, 0);
    }

    @RequiresApi(api = 21)
    public SkipView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = new b();
        this.f60349f = -1;
        this.f60350g = false;
        this.f60351h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f60350g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f60348e != null) {
                    SkipView.this.f60348e.b();
                }
            }
        };
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.ksad_skip_view, this);
        this.f60346c = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.f60347d = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.f60345b = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SkipView.this.f60348e != null) {
                    SkipView.this.f60348e.a();
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
        if (this.f60346c != null) {
            if (bVar.a != null) {
                this.f60346c.setText(bVar.a);
            }
            this.f60346c.setVisibility(this.a.f60355e ? 0 : 8);
        }
        String a2 = bVar.a();
        TextView textView = this.f60347d;
        if (textView != null) {
            if (a2 != null) {
                textView.setText(a2);
            }
            this.f60347d.setVisibility(this.a.f60356f ? 0 : 8);
        }
        if (this.f60345b != null) {
            boolean c2 = this.a.c();
            this.f60345b.setVisibility(c2 ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (c2) {
                    i2 = this.f60349f;
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
        post(this.f60351h);
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
        this.f60350g = true;
    }

    public void d() {
        this.f60350g = false;
    }

    public void e() {
        setVisibility(8);
    }

    public boolean f() {
        TextView textView = this.f60347d;
        return textView != null && textView.getVisibility() == 0;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f60349f = layoutParams.width;
    }

    public void setOnViewListener(a aVar) {
        this.f60348e = aVar;
    }

    public void setSkipBtnVisible(boolean z) {
        this.a.f60355e = z;
        a(this.a);
    }

    public void setSkipText(String str) {
        this.a.a = str;
        a(this.a);
    }

    public void setTimerBtnVisible(boolean z) {
        this.a.f60356f = z;
        a(this.a);
    }

    public void setTimerPrefixText(String str) {
        this.a.f60352b = str;
        a(this.a);
    }

    public void setTimerSecond(int i2) {
        this.a.a(i2);
        a(this.a);
    }
}
