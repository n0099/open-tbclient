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
/* loaded from: classes6.dex */
public abstract class a extends com.kwad.sdk.core.view.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public AdTemplate f35297a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f35298b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0422a f35299c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Context f35300d;

    /* renamed from: e  reason: collision with root package name */
    public s.a f35301e;

    /* renamed from: f  reason: collision with root package name */
    public g f35302f;

    /* renamed from: g  reason: collision with root package name */
    public float f35303g;

    /* renamed from: h  reason: collision with root package name */
    public g.a f35304h;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0422a {
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

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f35303g = 0.0f;
        this.f35304h = new g.a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                if (z) {
                    a.this.d();
                } else {
                    a.this.e();
                }
            }
        };
        this.f35301e = new s.a();
        this.f35300d = context;
        f();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC0407a() { // from class: com.kwad.sdk.feed.widget.base.a.2
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0407a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0407a
            public void a(View view) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0407a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0407a
            public void b() {
            }
        });
        b2.setNeedCheckingShow(true);
    }

    private com.kwad.sdk.core.page.widget.a b(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.sdk.core.page.widget.a) {
                return (com.kwad.sdk.core.page.widget.a) childAt;
            }
        }
        return null;
    }

    private void f() {
        FrameLayout.inflate(this.f35300d, getLayoutId(), this);
        setRatio(getHWRatio());
        c();
        this.f35302f = new g(this, 70);
        a(this);
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f35302f.a(this.f35304h);
        this.f35302f.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f35297a = adTemplate;
        this.f35298b = c.j(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        this.f35302f.b(this.f35304h);
        this.f35302f.b();
    }

    public abstract void c();

    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            s.a aVar = new s.a(getWidth(), getHeight());
            this.f35301e = aVar;
            aVar.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f35301e.b(motionEvent.getX(), motionEvent.getY());
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
        return this.f35303g;
    }

    @MainThread
    public s.a getTouchCoords() {
        return this.f35301e;
    }

    public void j() {
        InterfaceC0422a interfaceC0422a;
        if (!this.f35297a.mPvReported && (interfaceC0422a = this.f35299c) != null) {
            interfaceC0422a.b();
        }
        com.kwad.sdk.core.report.b.a(this.f35297a, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.b.a(this.f35297a, getTouchCoords());
        InterfaceC0422a interfaceC0422a = this.f35299c;
        if (interfaceC0422a != null) {
            interfaceC0422a.a();
        }
    }

    public void l() {
        com.kwad.sdk.core.report.b.a(this.f35297a);
        InterfaceC0422a interfaceC0422a = this.f35299c;
        if (interfaceC0422a != null) {
            interfaceC0422a.c();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f35303g != 0.0f) {
            int size = View.MeasureSpec.getSize(i);
            com.kwad.sdk.core.d.a.a("BaseFeedView", "widthSize:" + size);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * this.f35303g), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setAdClickListener(InterfaceC0422a interfaceC0422a) {
        this.f35299c = interfaceC0422a;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        setBackgroundColor(-1);
    }

    public void setRatio(float f2) {
        this.f35303g = f2;
    }
}
