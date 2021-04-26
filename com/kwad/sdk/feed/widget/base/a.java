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
import com.kwad.sdk.core.view.b;
import com.kwad.sdk.utils.q;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class a extends com.kwad.sdk.core.view.a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f34024a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f34025b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0392a f34026c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Context f34027d;

    /* renamed from: e  reason: collision with root package name */
    public q.a f34028e;

    /* renamed from: f  reason: collision with root package name */
    public b f34029f;

    /* renamed from: g  reason: collision with root package name */
    public float f34030g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f34031h;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0392a {
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
        this.f34030g = 0.0f;
        this.f34031h = new b.a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.view.b.a
            public void a(boolean z) {
                if (z) {
                    a.this.d();
                } else {
                    a.this.i();
                }
            }
        };
        this.f34028e = new q.a();
        this.f34027d = context;
        e();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC0381a() { // from class: com.kwad.sdk.feed.widget.base.a.2
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0381a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0381a
            public void a(View view) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0381a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0381a
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

    private void e() {
        FrameLayout.inflate(this.f34027d, getLayoutId(), this);
        setRatio(getHWRatio());
        c();
        this.f34029f = new b(this, 70);
        a(this);
    }

    @Override // com.kwad.sdk.core.view.a
    public void a() {
        this.f34029f.a(this.f34031h);
        this.f34029f.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f34024a = adTemplate;
        this.f34025b = c.g(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.a
    public void b() {
        this.f34029f.b(this.f34031h);
        this.f34029f.b();
    }

    public abstract void c();

    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            q.a aVar = new q.a(getWidth(), getHeight());
            this.f34028e = aVar;
            aVar.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f34028e.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public float getRatio() {
        return this.f34030g;
    }

    @MainThread
    public q.a getTouchCoords() {
        return this.f34028e;
    }

    public void i() {
    }

    public void j() {
        InterfaceC0392a interfaceC0392a;
        if (!this.f34024a.mPvReported && (interfaceC0392a = this.f34026c) != null) {
            interfaceC0392a.b();
        }
        com.kwad.sdk.core.report.b.a(this.f34024a, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.b.a(this.f34024a, getTouchCoords());
        InterfaceC0392a interfaceC0392a = this.f34026c;
        if (interfaceC0392a != null) {
            interfaceC0392a.a();
        }
    }

    public void l() {
        com.kwad.sdk.core.report.b.a(this.f34024a);
        InterfaceC0392a interfaceC0392a = this.f34026c;
        if (interfaceC0392a != null) {
            interfaceC0392a.c();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f34030g != 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            com.kwad.sdk.core.d.a.a("BaseFeedView", "widthSize:" + size);
            i3 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * this.f34030g), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setAdClickListener(InterfaceC0392a interfaceC0392a) {
        this.f34026c = interfaceC0392a;
    }

    public void setMargin(int i2) {
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(-1);
    }

    public void setRatio(float f2) {
        this.f34030g = f2;
    }
}
