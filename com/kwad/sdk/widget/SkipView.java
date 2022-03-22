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
/* loaded from: classes7.dex */
public class SkipView extends LinearLayout {
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public View f41496b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f41497c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f41498d;

    /* renamed from: e  reason: collision with root package name */
    public a f41499e;

    /* renamed from: f  reason: collision with root package name */
    public int f41500f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f41501g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f41502h;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void b();
    }

    /* loaded from: classes7.dex */
    public static class b {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f41503b;

        /* renamed from: c  reason: collision with root package name */
        public int f41504c;

        /* renamed from: d  reason: collision with root package name */
        public int f41505d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41506e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f41507f;

        public b() {
            this.a = "跳过";
            this.f41503b = "";
            this.f41504c = 5;
            this.f41505d = 5;
            this.f41506e = true;
            this.f41507f = true;
        }

        public static /* synthetic */ int a(b bVar) {
            int i = bVar.f41505d;
            bVar.f41505d = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            return this.f41506e && this.f41507f;
        }

        public String a() {
            StringBuilder sb;
            int i;
            int i2 = this.f41505d;
            if (i2 < 0) {
                return this.f41503b;
            }
            if (i2 == 0) {
                sb = new StringBuilder();
                sb.append(this.f41503b);
                i = 1;
            } else {
                sb = new StringBuilder();
                sb.append(this.f41503b);
                i = this.f41505d;
            }
            sb.append(i);
            return sb.toString();
        }

        public void a(int i) {
            this.f41504c = i;
            this.f41505d = i;
        }

        public void a(String str) {
            this.f41505d = -1;
            this.f41503b = str;
        }

        public boolean b() {
            return this.f41505d <= 0;
        }
    }

    public SkipView(Context context) {
        super(context);
        this.a = new b();
        this.f41500f = -1;
        this.f41501g = false;
        this.f41502h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f41501g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f41499e != null) {
                    SkipView.this.f41499e.b();
                }
            }
        };
        a(context, null, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new b();
        this.f41500f = -1;
        this.f41501g = false;
        this.f41502h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f41501g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f41499e != null) {
                    SkipView.this.f41499e.b();
                }
            }
        };
        a(context, attributeSet, 0, 0);
    }

    public SkipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new b();
        this.f41500f = -1;
        this.f41501g = false;
        this.f41502h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f41501g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f41499e != null) {
                    SkipView.this.f41499e.b();
                }
            }
        };
        a(context, attributeSet, i, 0);
    }

    @RequiresApi(api = 21)
    public SkipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.a = new b();
        this.f41500f = -1;
        this.f41501g = false;
        this.f41502h = new Runnable() { // from class: com.kwad.sdk.widget.SkipView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SkipView.this.f41501g) {
                    SkipView.this.postDelayed(this, 300L);
                    return;
                }
                SkipView skipView = SkipView.this;
                skipView.a(skipView.a);
                if (!SkipView.this.a.b()) {
                    SkipView.this.postDelayed(this, 1000L);
                    b.a(SkipView.this.a);
                } else if (SkipView.this.f41499e != null) {
                    SkipView.this.f41499e.b();
                }
            }
        };
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0473, this);
        this.f41497c = (TextView) findViewById(R.id.obfuscated_res_0x7f09113b);
        this.f41498d = (TextView) findViewById(R.id.obfuscated_res_0x7f09113c);
        this.f41496b = findViewById(R.id.obfuscated_res_0x7f09113a);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.SkipView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SkipView.this.f41499e != null) {
                    SkipView.this.f41499e.a();
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
        if (this.f41497c != null) {
            if (bVar.a != null) {
                this.f41497c.setText(bVar.a);
            }
            this.f41497c.setVisibility(this.a.f41506e ? 0 : 8);
        }
        String a2 = bVar.a();
        TextView textView = this.f41498d;
        if (textView != null) {
            if (a2 != null) {
                textView.setText(a2);
            }
            this.f41498d.setVisibility(this.a.f41507f ? 0 : 8);
        }
        if (this.f41496b != null) {
            boolean c2 = this.a.c();
            this.f41496b.setVisibility(c2 ? 0 : 8);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                if (c2) {
                    i = this.f41500f;
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
        post(this.f41502h);
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
        this.f41501g = true;
    }

    public void d() {
        this.f41501g = false;
    }

    public void e() {
        setVisibility(8);
    }

    public boolean f() {
        TextView textView = this.f41498d;
        return textView != null && textView.getVisibility() == 0;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f41500f = layoutParams.width;
    }

    public void setOnViewListener(a aVar) {
        this.f41499e = aVar;
    }

    public void setSkipBtnVisible(boolean z) {
        this.a.f41506e = z;
        a(this.a);
    }

    public void setSkipText(String str) {
        this.a.a = str;
        a(this.a);
    }

    public void setTimerBtnVisible(boolean z) {
        this.a.f41507f = z;
        a(this.a);
    }

    public void setTimerPrefixText(String str) {
        this.a.f41503b = str;
        a(this.a);
    }

    public void setTimerSecond(int i) {
        this.a.a(i);
        a(this.a);
    }
}
