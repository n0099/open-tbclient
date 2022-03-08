package com.kwad.sdk.feed.widget.base;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.j.d;
import com.kwad.sdk.core.j.f;
import com.kwad.sdk.core.page.widget.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class a extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, d {
    public f a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f55445b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f55446c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC2122a f55447d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Context f55448e;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC2122a {
        void a();

        void b();

        void c();

        void d();

        void e();
    }

    public a(@NonNull Context context) {
        this(context, null);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f55448e = context;
        d();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC2104a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2104a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2104a
            public void a(View view) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2104a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2104a
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

    private void d() {
        FrameLayout.inflate(this.f55448e, getLayoutId(), this);
        setRatio(getHWRatio());
        c();
        this.a = new f(this, 70);
        a((ViewGroup) this);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void a() {
        super.a();
        this.a.a(this);
        this.a.a();
    }

    public void a(@NonNull AdTemplate adTemplate) {
        this.f55445b = adTemplate;
        this.f55446c = com.kwad.sdk.core.response.a.d.j(adTemplate);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void b() {
        super.b();
        this.a.b(this);
        this.a.b();
    }

    public abstract void c();

    public void e() {
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
    }

    public float getHWRatio() {
        return 0.0f;
    }

    public abstract int getLayoutId();

    public void j() {
        InterfaceC2122a interfaceC2122a;
        if (!this.f55445b.mPvReported && (interfaceC2122a = this.f55447d) != null) {
            interfaceC2122a.b();
        }
        com.kwad.sdk.core.report.a.a(this.f55445b, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.a.a(this.f55445b, getTouchCoords());
        InterfaceC2122a interfaceC2122a = this.f55447d;
        if (interfaceC2122a != null) {
            interfaceC2122a.a();
        }
    }

    public void l() {
        InterfaceC2122a interfaceC2122a = this.f55447d;
        if (interfaceC2122a != null) {
            interfaceC2122a.a();
        }
    }

    public void m() {
        com.kwad.sdk.core.report.a.a(this.f55445b);
        InterfaceC2122a interfaceC2122a = this.f55447d;
        if (interfaceC2122a != null) {
            interfaceC2122a.c();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC2122a interfaceC2122a = this.f55447d;
        if (interfaceC2122a != null) {
            interfaceC2122a.e();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        InterfaceC2122a interfaceC2122a = this.f55447d;
        if (interfaceC2122a != null) {
            interfaceC2122a.d();
        }
    }

    public void setInnerAdInteractionListener(InterfaceC2122a interfaceC2122a) {
        this.f55447d = interfaceC2122a;
    }

    public void setMargin(int i2) {
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(-1);
    }
}
