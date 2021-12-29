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
    public AdTemplate f59109b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f59110c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC2110a f59111d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Context f59112e;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2110a {
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
        this.f59112e = context;
        d();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC2092a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2092a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2092a
            public void a(View view) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2092a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2092a
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
        FrameLayout.inflate(this.f59112e, getLayoutId(), this);
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
        this.f59109b = adTemplate;
        this.f59110c = com.kwad.sdk.core.response.a.d.j(adTemplate);
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
        InterfaceC2110a interfaceC2110a;
        if (!this.f59109b.mPvReported && (interfaceC2110a = this.f59111d) != null) {
            interfaceC2110a.b();
        }
        com.kwad.sdk.core.report.a.a(this.f59109b, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.a.a(this.f59109b, getTouchCoords());
        InterfaceC2110a interfaceC2110a = this.f59111d;
        if (interfaceC2110a != null) {
            interfaceC2110a.a();
        }
    }

    public void l() {
        InterfaceC2110a interfaceC2110a = this.f59111d;
        if (interfaceC2110a != null) {
            interfaceC2110a.a();
        }
    }

    public void m() {
        com.kwad.sdk.core.report.a.a(this.f59109b);
        InterfaceC2110a interfaceC2110a = this.f59111d;
        if (interfaceC2110a != null) {
            interfaceC2110a.c();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC2110a interfaceC2110a = this.f59111d;
        if (interfaceC2110a != null) {
            interfaceC2110a.e();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        InterfaceC2110a interfaceC2110a = this.f59111d;
        if (interfaceC2110a != null) {
            interfaceC2110a.d();
        }
    }

    public void setInnerAdInteractionListener(InterfaceC2110a interfaceC2110a) {
        this.f59111d = interfaceC2110a;
    }

    public void setMargin(int i2) {
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(-1);
    }
}
