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
/* loaded from: classes8.dex */
public class SkipView extends LinearLayout {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public View f56617b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f56618c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56619d;

    /* renamed from: e  reason: collision with root package name */
    public a f56620e;

    /* renamed from: f  reason: collision with root package name */
    public int f56621f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56622g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f56623h;

    /* loaded from: classes8.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes8.dex */
    public static class b {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f56624b;

        /* renamed from: c  reason: collision with root package name */
        public int f56625c;

        /* renamed from: d  reason: collision with root package name */
        public int f56626d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f56627e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f56628f;

        public b() {
            this.a = "跳过";
            this.f56624b = "";
            this.f56625c = 5;
            this.f56626d = 5;
            this.f56627e = true;
            this.f56628f = true;
        }

        public static /* synthetic */ int a(b bVar) {
            int i2 = bVar.f56626d;
            bVar.f56626d = i2 - 1;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return this.f56627e && this.f56628f;
        }

        public String a() {
            StringBuilder sb;
            int i2;
            int i3 = this.f56626d;
            if (i3 < 0) {
                return this.f56624b;
            }
            if (i3 == 0) {
                sb = new StringBuilder();
                sb.append(this.f56624b);
                i2 = 1;
            } else {
                sb = new StringBuilder();
                sb.append(this.f56624b);
                i2 = this.f56626d;
            }
            sb.append(i2);
            return sb.toString();
        }

        public void a(int i2) {
            this.f56625c = i2;
            this.f56626d = i2;
        }

        public void a(String str) {
            this.f56626d = -1;
            this.f56624b = str;
        }

        public boolean b() {
            return this.f56626d <= 0;
        }
    }

    public SkipView(Context context) {
        super(context);
        this.a = new b();
        this.f56621f = -1;
        this.f56622g = false;
        this.f56623h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f56622g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f56620e != null) {
                    SkipView.this.f56620e.b();
                }
            }
        };
        a(context, null, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b();
        this.f56621f = -1;
        this.f56622g = false;
        this.f56623h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f56622g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f56620e != null) {
                    SkipView.this.f56620e.b();
                }
            }
        };
        a(context, attributeSet, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new b();
        this.f56621f = -1;
        this.f56622g = false;
        this.f56623h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f56622g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f56620e != null) {
                    SkipView.this.f56620e.b();
                }
            }
        };
        a(context, attributeSet, i2, 0);
    }

    @RequiresApi(api = 21)
    public SkipView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a = new b();
        this.f56621f = -1;
        this.f56622g = false;
        this.f56623h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f56622g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f56620e != null) {
                    SkipView.this.f56620e.b();
                }
            }
        };
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.ksad_skip_view, this);
        this.f56618c = (TextView) findViewById(R.id.ksad_skip_view_skip);
        this.f56619d = (TextView) findViewById(R.id.ksad_skip_view_timer);
        this.f56617b = findViewById(R.id.ksad_skip_view_divider);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SkipView.this.f56620e != null) {
                    SkipView.this.f56620e.a();
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
        if (this.f56618c != null) {
            if (bVar.a != null) {
                this.f56618c.setText(bVar.a);
            }
            this.f56618c.setVisibility(this.a.f56627e ? 0 : 8);
        }
        String a2 = bVar.a();
        TextView textView = this.f56619d;
        if (textView != null) {
            if (a2 != null) {
                textView.setText(a2);
            }
            this.f56619d.setVisibility(this.a.f56628f ? 0 : 8);
        }
        if (this.f56617b != null) {
            boolean c2 = this.a.c();
            this.f56617b.setVisibility(c2 ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (c2) {
                    i2 = this.f56621f;
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
        post(this.f56623h);
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
        this.f56622g = true;
    }

    public void d() {
        this.f56622g = false;
    }

    public void e() {
        setVisibility(8);
    }

    public boolean f() {
        TextView textView = this.f56619d;
        return textView != null && textView.getVisibility() == 0;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f56621f = layoutParams.width;
    }

    public void setOnViewListener(a aVar) {
        this.f56620e = aVar;
    }

    public void setSkipBtnVisible(boolean z) {
        this.a.f56627e = z;
        a(this.a);
    }

    public void setSkipText(String str) {
        this.a.a = str;
        a(this.a);
    }

    public void setTimerBtnVisible(boolean z) {
        this.a.f56628f = z;
        a(this.a);
    }

    public void setTimerPrefixText(String str) {
        this.a.f56624b = str;
        a(this.a);
    }

    public void setTimerSecond(int i2) {
        this.a.a(i2);
        a(this.a);
    }
}
