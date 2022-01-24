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
/* loaded from: classes3.dex */
public abstract class a extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, d {
    public f a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f56928b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f56929c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC2133a f56930d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Context f56931e;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2133a {
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
        this.f56931e = context;
        d();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC2115a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2115a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2115a
            public void a(View view) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2115a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2115a
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
        FrameLayout.inflate(this.f56931e, getLayoutId(), this);
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
        this.f56928b = adTemplate;
        this.f56929c = com.kwad.sdk.core.response.a.d.j(adTemplate);
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
        InterfaceC2133a interfaceC2133a;
        if (!this.f56928b.mPvReported && (interfaceC2133a = this.f56930d) != null) {
            interfaceC2133a.b();
        }
        com.kwad.sdk.core.report.a.a(this.f56928b, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.a.a(this.f56928b, getTouchCoords());
        InterfaceC2133a interfaceC2133a = this.f56930d;
        if (interfaceC2133a != null) {
            interfaceC2133a.a();
        }
    }

    public void l() {
        InterfaceC2133a interfaceC2133a = this.f56930d;
        if (interfaceC2133a != null) {
            interfaceC2133a.a();
        }
    }

    public void m() {
        com.kwad.sdk.core.report.a.a(this.f56928b);
        InterfaceC2133a interfaceC2133a = this.f56930d;
        if (interfaceC2133a != null) {
            interfaceC2133a.c();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC2133a interfaceC2133a = this.f56930d;
        if (interfaceC2133a != null) {
            interfaceC2133a.e();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        InterfaceC2133a interfaceC2133a = this.f56930d;
        if (interfaceC2133a != null) {
            interfaceC2133a.d();
        }
    }

    public void setInnerAdInteractionListener(InterfaceC2133a interfaceC2133a) {
        this.f56930d = interfaceC2133a;
    }

    public void setMargin(int i2) {
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(-1);
    }
}
