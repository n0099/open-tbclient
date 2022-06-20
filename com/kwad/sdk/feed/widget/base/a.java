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
/* loaded from: classes5.dex */
public abstract class a extends KSFrameLayout implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, d {
    public f a;
    @NonNull
    public AdTemplate b;
    public AdInfo c;
    public InterfaceC0331a d;
    @NonNull
    public Context e;

    /* renamed from: com.kwad.sdk.feed.widget.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0331a {
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

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = context;
        d();
    }

    private void a(ViewGroup viewGroup) {
        com.kwad.sdk.core.page.widget.a b = b(viewGroup);
        if (b == null) {
            b = new com.kwad.sdk.core.page.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(b);
        }
        b.setViewCallback(new a.InterfaceC0313a() { // from class: com.kwad.sdk.feed.widget.base.a.1
            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0313a
            public void a() {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0313a
            public void a(View view2) {
                a.this.j();
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0313a
            public void a(boolean z) {
            }

            @Override // com.kwad.sdk.core.page.widget.a.InterfaceC0313a
            public void b() {
            }
        });
        b.setNeedCheckingShow(true);
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

    private void d() {
        FrameLayout.inflate(this.e, getLayoutId(), this);
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
        this.b = adTemplate;
        this.c = com.kwad.sdk.core.response.a.d.j(adTemplate);
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
        InterfaceC0331a interfaceC0331a;
        if (!this.b.mPvReported && (interfaceC0331a = this.d) != null) {
            interfaceC0331a.b();
        }
        com.kwad.sdk.core.report.a.a(this.b, (JSONObject) null);
    }

    public void k() {
        com.kwad.sdk.core.report.a.a(this.b, getTouchCoords());
        InterfaceC0331a interfaceC0331a = this.d;
        if (interfaceC0331a != null) {
            interfaceC0331a.a();
        }
    }

    public void l() {
        InterfaceC0331a interfaceC0331a = this.d;
        if (interfaceC0331a != null) {
            interfaceC0331a.a();
        }
    }

    public void m() {
        com.kwad.sdk.core.report.a.a(this.b);
        InterfaceC0331a interfaceC0331a = this.d;
        if (interfaceC0331a != null) {
            interfaceC0331a.c();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        InterfaceC0331a interfaceC0331a = this.d;
        if (interfaceC0331a != null) {
            interfaceC0331a.e();
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        InterfaceC0331a interfaceC0331a = this.d;
        if (interfaceC0331a != null) {
            interfaceC0331a.d();
        }
    }

    public void setInnerAdInteractionListener(InterfaceC0331a interfaceC0331a) {
        this.d = interfaceC0331a;
    }

    public void setMargin(int i) {
        setPadding(i, i, i, i);
        setBackgroundColor(-1);
    }
}
