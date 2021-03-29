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
    public AdTemplate f34913a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f34914b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0405a f34915c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Context f34916d;

    /* renamed from: e  reason: collision with root package name */
    public s.a f34917e;

    /* renamed from: f  reason: collision with root package name */
    public g f34918f;

    /* renamed from: g  reason: collision with root package name */
    public float f34919g;

    /* renamed from: h  reason: collision with root package name */
    public g.a f34920h;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
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

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34919g = 0.0f;
        this.f34920h = new g.a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                if (z) {
                    a.this.d();
                } else {
                    a.this.e();
                }
            }
        };
        this.f34917e = new s.a();
        this.f34916d = context;
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
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof com.kwad.sdk.core.page.widget.a) {
                return (com.kwad.sdk.core.page.widget.a) childAt;
            }
        }
        return null;
    }

    private void f() {
        FrameLayout.inflate(this.f34916d, getLayoutId(), this);
        setRatio(getHWRatio());
        c();
        this.f34918f = new g(this, 70);
        a(this);
    }

    @Override // com.kwad.sdk.core.view.b
    public void a() {
        this.f34918f.a(this.f34920h);
        this.f34918f.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f34913a = adTemplate;
        this.f34914b = c.j(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.b
    public void b() {
        this.f34918f.b(this.f34920h);
        this.f34918f.b();
    }

    public abstract void c();

    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            s.a aVar = new s.a(getWidth(), getHeight());
            this.f34917e = aVar;
            aVar.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f34917e.b(motionEvent.getX(), motionEvent.getY());
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
        return this.f34919g;
    }

    @MainThread
    public s.a getTouchCoords() {
        return this.f34917e;
    }

    public void j() {
        InterfaceC0405a interfaceC0405a;
        if (!this.f34913a.mPvReported && (interfaceC0405a = this.f34915c) != null) {
            interfaceC0405a.b();
        }
        com.kwad.sdk.core.report.b.a(this.f34913a, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.b.a(this.f34913a, getTouchCoords());
        InterfaceC0405a interfaceC0405a = this.f34915c;
        if (interfaceC0405a != null) {
            interfaceC0405a.a();
        }
    }

    public void l() {
        com.kwad.sdk.core.report.b.a(this.f34913a);
        InterfaceC0405a interfaceC0405a = this.f34915c;
        if (interfaceC0405a != null) {
            interfaceC0405a.c();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f34919g != 0.0f) {
            int size = View.MeasureSpec.getSize(i);
            com.kwad.sdk.core.d.a.a("BaseFeedView", "widthSize:" + size);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * this.f34919g), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setAdClickListener(InterfaceC0405a interfaceC0405a) {
        this.f34915c = interfaceC0405a;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        setBackgroundColor(-1);
    }

    public void setRatio(float f2) {
        this.f34919g = f2;
    }
}
