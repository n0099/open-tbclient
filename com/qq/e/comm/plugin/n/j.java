package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.n.f;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.y.u;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends LinearLayout implements h {

    /* renamed from: a  reason: collision with root package name */
    private com.qq.e.comm.plugin.q.b f12548a;

    /* renamed from: b  reason: collision with root package name */
    private com.qq.e.comm.plugin.ab.d.a f12549b;
    private com.qq.e.comm.plugin.ad.g c;
    private f.a d;
    private com.qq.e.comm.plugin.y.c e;
    private com.qq.e.comm.plugin.y.d f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f12553b;
        private boolean c;
        private float d;
        private float e;
        private int f;

        private a() {
            this.f = ViewConfiguration.get(j.this.getContext()).getScaledTouchSlop();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (j.this.c != null) {
                j.this.c.a(motionEvent, true);
            }
            switch (motionEvent.getAction()) {
                case 0:
                    this.d = motionEvent.getRawX();
                    this.e = motionEvent.getRawY();
                    break;
                case 1:
                    this.c = motionEvent.getRawX() - this.d > ((float) this.f) || motionEvent.getRawY() - this.e > ((float) this.f);
                    if (!this.f12553b && !this.c) {
                        ai.a("LandingPageView", "LandingPageView user click");
                        u.a(1020050, j.this.e);
                        this.f12553b = true;
                        if (j.this.d != null) {
                            j.this.d.a(j.this.e(), true);
                        }
                    }
                    this.c = false;
                    break;
            }
            return j.this.f12549b.b().onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, com.qq.e.comm.plugin.ad.g gVar, com.qq.e.comm.plugin.y.c cVar) {
        super(context);
        this.c = gVar;
        this.e = cVar;
        this.f = new com.qq.e.comm.plugin.y.d();
        d();
    }

    private void d() {
        setOrientation(1);
        this.f12548a = new com.qq.e.comm.plugin.q.b(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ak.a(getContext(), 45));
        layoutParams.gravity = 48;
        this.f12548a.setLayoutParams(layoutParams);
        this.f12548a.setBackgroundColor(-1);
        this.f12548a.a(new View.OnClickListener() { // from class: com.qq.e.comm.plugin.n.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (j.this.f12549b.d()) {
                    j.this.f12549b.e();
                } else if (j.this.d != null) {
                    j.this.d.b();
                }
            }
        });
        addView(this.f12548a);
        this.f12549b = new com.qq.e.comm.plugin.ab.d.e(getContext(), null).a();
        this.f12549b.a(new com.qq.e.comm.plugin.ab.d.f() { // from class: com.qq.e.comm.plugin.n.j.2
            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(int i) {
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(int i, String str, String str2) {
                j.this.f.a("wu", str2);
                u.a(1020052, 0, j.this.e, j.this.f);
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(ValueCallback<Uri> valueCallback, Intent intent) {
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(String str) {
                j.this.f.a("wu", str);
                u.a(1020051, 0, j.this.e, j.this.f);
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void a(String str, Bitmap bitmap) {
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void b(String str) {
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
                return false;
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void c(String str) {
                if (j.this.f12548a != null) {
                    j.this.f12548a.a(str);
                }
            }

            @Override // com.qq.e.comm.plugin.ab.d.f
            public void d_() {
            }
        });
        this.f12549b.b().setOnTouchListener(new a());
        addView(this.f12549b.b(), new RelativeLayout.LayoutParams(-1, -1));
        this.c.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        View b2 = this.f12549b.b();
        this.c.a().a(b2.getHeight());
        this.c.a().b(b2.getWidth());
        this.c.b(System.currentTimeMillis());
        try {
            JSONObject jSONObject = new JSONObject(this.c.b());
            jSONObject.put("click_area", 10);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void a() {
        setVisibility(8);
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void a(ViewGroup viewGroup) {
        if (getParent() == null) {
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void a(f.a aVar) {
        this.d = aVar;
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            ai.a("LandingPageView", "load url is null");
        } else if (this.f12549b != null) {
            this.f12549b.a(str);
        }
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void b() {
        setVisibility(0);
    }

    @Override // com.qq.e.comm.plugin.n.h
    public void c() {
        if (this.f12549b != null) {
            this.f12549b.a();
        }
    }
}
