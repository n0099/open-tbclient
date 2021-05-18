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
    public AdTemplate f33269a;

    /* renamed from: b  reason: collision with root package name */
    public AdInfo f33270b;

    /* renamed from: c  reason: collision with root package name */
    public InterfaceC0379a f33271c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public Context f33272d;

    /* renamed from: e  reason: collision with root package name */
    public q.a f33273e;

    /* renamed from: f  reason: collision with root package name */
    public b f33274f;

    /* renamed from: g  reason: collision with root package name */
    public float f33275g;

    /* renamed from: h  reason: collision with root package name */
    public b.a f33276h;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0379a {
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
        this.f33275g = 0.0f;
        this.f33276h = new b.a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.view.b.a
            public void a(boolean z) {
                if (z) {
                    a.this.d();
                } else {
                    a.this.i();
                }
            }
        };
        this.f33273e = new q.a();
        this.f33272d = context;
        e();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC0368a() { // from class: com.kwad.sdk.feed.widget.base.a.2
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0368a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0368a
            public void a(View view) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0368a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0368a
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
        FrameLayout.inflate(this.f33272d, getLayoutId(), this);
        setRatio(getHWRatio());
        c();
        this.f33274f = new b(this, 70);
        a(this);
    }

    @Override // com.kwad.sdk.core.view.a
    public void a() {
        this.f33274f.a(this.f33276h);
        this.f33274f.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f33269a = adTemplate;
        this.f33270b = c.g(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.a
    public void b() {
        this.f33274f.b(this.f33276h);
        this.f33274f.b();
    }

    public abstract void c();

    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            q.a aVar = new q.a(getWidth(), getHeight());
            this.f33273e = aVar;
            aVar.a(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.f33273e.b(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public float getRatio() {
        return this.f33275g;
    }

    @MainThread
    public q.a getTouchCoords() {
        return this.f33273e;
    }

    public void i() {
    }

    public void j() {
        InterfaceC0379a interfaceC0379a;
        if (!this.f33269a.mPvReported && (interfaceC0379a = this.f33271c) != null) {
            interfaceC0379a.b();
        }
        com.kwad.sdk.core.report.b.a(this.f33269a, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.b.a(this.f33269a, getTouchCoords());
        InterfaceC0379a interfaceC0379a = this.f33271c;
        if (interfaceC0379a != null) {
            interfaceC0379a.a();
        }
    }

    public void l() {
        com.kwad.sdk.core.report.b.a(this.f33269a);
        InterfaceC0379a interfaceC0379a = this.f33271c;
        if (interfaceC0379a != null) {
            interfaceC0379a.c();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f33275g != 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            com.kwad.sdk.core.d.a.a("BaseFeedView", "widthSize:" + size);
            i3 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * this.f33275g), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setAdClickListener(InterfaceC0379a interfaceC0379a) {
        this.f33271c = interfaceC0379a;
    }

    public void setMargin(int i2) {
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(-1);
    }

    public void setRatio(float f2) {
        this.f33275g = f2;
    }
}
