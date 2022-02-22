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
/* loaded from: classes4.dex */
public abstract class a extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, d {
    public f a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57095b;

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f57096c;

    /* renamed from: d  reason: collision with root package name */
    public InterfaceC2143a f57097d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Context f57098e;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC2143a {
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
        this.f57098e = context;
        d();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b2 = b(viewGroup);
        if (b2 == null) {
            b2 = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b2);
        }
        b2.setViewCallback(new a.InterfaceC2125a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2125a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2125a
            public void a(View view) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2125a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC2125a
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
        FrameLayout.inflate(this.f57098e, getLayoutId(), this);
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
        this.f57095b = adTemplate;
        this.f57096c = com.kwad.sdk.core.response.a.d.j(adTemplate);
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
        InterfaceC2143a interfaceC2143a;
        if (!this.f57095b.mPvReported && (interfaceC2143a = this.f57097d) != null) {
            interfaceC2143a.b();
        }
        com.kwad.sdk.core.report.a.a(this.f57095b, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.a.a(this.f57095b, getTouchCoords());
        InterfaceC2143a interfaceC2143a = this.f57097d;
        if (interfaceC2143a != null) {
            interfaceC2143a.a();
        }
    }

    public void l() {
        InterfaceC2143a interfaceC2143a = this.f57097d;
        if (interfaceC2143a != null) {
            interfaceC2143a.a();
        }
    }

    public void m() {
        com.kwad.sdk.core.report.a.a(this.f57095b);
        InterfaceC2143a interfaceC2143a = this.f57097d;
        if (interfaceC2143a != null) {
            interfaceC2143a.c();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC2143a interfaceC2143a = this.f57097d;
        if (interfaceC2143a != null) {
            interfaceC2143a.e();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        InterfaceC2143a interfaceC2143a = this.f57097d;
        if (interfaceC2143a != null) {
            interfaceC2143a.d();
        }
    }

    public void setInnerAdInteractionListener(InterfaceC2143a interfaceC2143a) {
        this.f57097d = interfaceC2143a;
    }

    public void setMargin(int i2) {
        setPadding(i2, i2, i2, i2);
        setBackgroundColor(-1);
    }
}
