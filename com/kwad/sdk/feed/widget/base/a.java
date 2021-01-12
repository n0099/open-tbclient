package com.kwad.sdk.feed.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
/* loaded from: classes4.dex */
public abstract class a extends com.kwad.sdk.core.view.b {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    protected AdTemplate f9860a;

    /* renamed from: b  reason: collision with root package name */
    protected AdInfo f9861b;
    protected InterfaceC1114a c;
    @NonNull
    protected Context d;
    protected s.a e;
    private g f;
    private float g;
    private g.a h;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1114a {
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
        this.g = 0.0f;
        this.h = new g.a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.view.g.a
            public void a(boolean z) {
                if (z) {
                    a.this.d();
                } else {
                    a.this.e();
                }
            }
        };
        this.e = new s.a();
        this.d = context;
        f();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC1099a() { // from class: com.kwad.sdk.feed.widget.base.a.2
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC1099a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC1099a
            public void a(View view) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC1099a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC1099a
            public void b() {
            }
        });
        b2.setNeedCheckingShow(true);
    }

    private com.kwad.sdk.core.page.widget.a b(ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return null;
            }
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.sdk.core.page.widget.a) {
                return (com.kwad.sdk.core.page.widget.a) childAt;
            }
            i = i2 + 1;
        }
    }

    private void f() {
        inflate(this.d, getLayoutId(), this);
        setRatio(getHWRatio());
        c();
        this.f = new g(this, 70);
        a(this);
    }

    @Override // com.kwad.sdk.core.view.b
    protected void a() {
        this.f.a(this.h);
        this.f.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f9860a = adTemplate;
        this.f9861b = c.j(adTemplate);
    }

    @Override // com.kwad.sdk.core.view.b
    protected void b() {
        this.f.b(this.h);
        this.f.b();
    }

    protected abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.e = new s.a(getWidth(), getHeight());
                this.e.a(motionEvent.getX(), motionEvent.getY());
                break;
            case 1:
                this.e.b(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
    }

    protected float getHWRatio() {
        return 0.0f;
    }

    protected abstract int getLayoutId();

    public float getRatio() {
        return this.g;
    }

    @MainThread
    public s.a getTouchCoords() {
        return this.e;
    }

    protected void j() {
        if (!this.f9860a.mPvReported && this.c != null) {
            this.c.b();
        }
        com.kwad.sdk.core.report.b.a(this.f9860a, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        com.kwad.sdk.core.report.b.a(this.f9860a, getTouchCoords());
        if (this.c != null) {
            this.c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        com.kwad.sdk.core.report.b.a(this.f9860a);
        if (this.c != null) {
            this.c.c();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.g != 0.0f) {
            int size = View.MeasureSpec.getSize(i);
            com.kwad.sdk.core.d.a.a("BaseFeedView", "widthSize:" + size);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (size * this.g), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setAdClickListener(InterfaceC1114a interfaceC1114a) {
        this.c = interfaceC1114a;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        setBackgroundColor(-1);
    }

    public void setRatio(float f) {
        this.g = f;
    }
}
