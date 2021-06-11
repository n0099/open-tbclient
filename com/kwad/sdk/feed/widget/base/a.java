package com.kwad.sdk.feed.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.page.widget.a;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class a extends com.kwad.sdk.core.view.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f35578a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f35579b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0405a f35580c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Context f35581d;

    /* renamed from: e  reason: collision with root package name */
    public s.a f35582e;

    /* renamed from: f  reason: collision with root package name */
    public g f35583f;

    /* renamed from: g  reason: collision with root package name */
    public float f35584g;

    /* renamed from: h  reason: collision with root package name */
    public g.a f35585h;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0405a {
        void a();

        void b();

        void c();
    }

    public a(@NonNull Context context) {
        this(context, null);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35584g = 0.0f;
        this.f35585h = new g.a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                if (z) {
                    a.this.d();
                } else {
                    a.this.e();
                }
            }
        };
        this.f35582e = new s.a();
        this.f35581d = context;
        f();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC0390a() { // from class: com.kwad.sdk.feed.widget.base.a.2
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0390a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0390a
            public void a(View view) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0390a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0390a
            public void b() {
            }
        });
        b2.setNeedCheckingShow(true);
    }

    private com.kwad.sdk.core.page.widget.a b(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.sdk.core.page.widget.a) {
                return (com.kwad.sdk.core.page.widget.a) childAt;
            }
        }
        return null;
    }

    private void f() {
        FrameLayout.inflate(this.f35581d, getLayoutId(), this);
        setRatio(getHWRatio());
        c();
        this.f35583f = new g(this, 70);
        a(this);
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f35583f.a(this.f35585h);
        this.f35583f.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f35578a = adTemplate;
        this.f35579b = c.j(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        this.f35583f.b(this.f35585h);
        this.f35583f.b();
    }

    public abstract void c();

    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            s.a aVar = new s.a(getWidth(), getHeight());
            this.f35582e = aVar;
            aVar.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f35582e.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e() {
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public float getRatio() {
        return this.f35584g;
    }

    @MainThread
    public s.a getTouchCoords() {
        return this.f35582e;
    }

    public void j() {
        InterfaceC0405a interfaceC0405a;
        if (!this.f35578a.mPvReported && (interfaceC0405a = this.f35580c) != null) {
            interfaceC0405a.b();
        }
        com.kwad.sdk.core.report.b.a(this.f35578a, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.b.a(this.f35578a, getTouchCoords());
        InterfaceC0405a interfaceC0405a = this.f35580c;
        if (interfaceC0405a != null) {
            interfaceC0405a.a();
        }
    }

    public void l() {
        com.kwad.sdk.core.report.b.a(this.f35578a);
        InterfaceC0405a interfaceC0405a = this.f35580c;
        if (interfaceC0405a != null) {
            interfaceC0405a.c();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f35584g != 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            com.kwad.sdk.core.d.a.a("BaseFeedView", "widthSize:" + size);
            i3 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * this.f35584g), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setAdClickListener(InterfaceC0405a interfaceC0405a) {
        this.f35580c = interfaceC0405a;
    }

    public void setMargin(int i2) {
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(-1);
    }

    public void setRatio(float f2) {
        this.f35584g = f2;
    }
}
