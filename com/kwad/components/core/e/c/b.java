package com.kwad.components.core.e.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.c.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.m.l;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends com.kwad.components.core.proxy.d {
    @Nullable
    public static b Kd;
    @NonNull
    public final C0643b Ke;
    public com.kwad.components.core.e.c.a Kh;
    public boolean Ki;

    @Override // com.kwad.components.core.proxy.d
    public final int getLayoutId() {
        return 0;
    }

    @Override // com.kwad.components.core.proxy.d
    public final boolean nk() {
        return true;
    }

    /* loaded from: classes10.dex */
    public static class a {
        @Nullable
        public DialogInterface.OnShowListener Kk;
        @Nullable
        public DialogInterface.OnDismissListener Kl;
        public AdTemplate adTemplate;
        public String url;

        public final C0643b nm() {
            if (com.kwad.components.core.a.mc.booleanValue() && (this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0643b(this, (byte) 0);
        }

        public final a ae(String str) {
            this.url = str;
            return this;
        }

        public final a ap(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final a a(@Nullable DialogInterface.OnShowListener onShowListener) {
            this.Kk = onShowListener;
            return this;
        }

        public final a c(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            this.Kl = onDismissListener;
            return this;
        }
    }

    /* renamed from: com.kwad.components.core.e.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0643b {
        @Nullable
        public DialogInterface.OnShowListener Kk;
        @Nullable
        public DialogInterface.OnDismissListener Kl;
        public final AdTemplate adTemplate;
        public String url;

        public C0643b(a aVar) {
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.Kk = aVar.Kk;
            this.Kl = aVar.Kl;
        }

        public /* synthetic */ C0643b(a aVar, byte b) {
            this(aVar);
        }
    }

    public b(Activity activity, @NonNull C0643b c0643b) {
        super(activity);
        this.Ki = false;
        this.Ke = c0643b;
        if (com.kwad.sdk.d.a.a.b(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0643b.Kk);
        setOnDismissListener(c0643b.Kl);
    }

    public static boolean a(Context context, C0643b c0643b) {
        Activity m186do;
        b bVar = Kd;
        if ((bVar == null || !bVar.isShowing()) && context != null && (m186do = l.m186do(context)) != null && !m186do.isFinishing()) {
            com.kwad.sdk.a.a.c.yT().dismiss();
            try {
                b bVar2 = new b(m186do, c0643b);
                Kd = bVar2;
                bVar2.show();
                com.kwad.sdk.core.report.a.b(c0643b.adTemplate, 86, (JSONObject) null);
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
        }
        return false;
    }

    public static boolean nj() {
        b bVar = Kd;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.d
    public final ViewGroup ck() {
        com.kwad.components.core.e.c.a aVar = new com.kwad.components.core.e.c.a(this.mContext, this, this.Ke);
        this.Kh = aVar;
        return aVar;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        Kd = null;
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    public final boolean nl() {
        return this.Ki;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.report.a.bR(this.Ke.adTemplate);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Kd = null;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = Kd;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        try {
            super.show();
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    public final void aj(boolean z) {
        this.Ki = z;
        dismiss();
    }

    @Override // com.kwad.components.core.proxy.d
    public final void g(View view2) {
        this.Kh.setChangeListener(new a.InterfaceC0642a() { // from class: com.kwad.components.core.e.c.b.1
            @Override // com.kwad.components.core.e.c.a.InterfaceC0642a
            public final void ni() {
                b.this.dismiss();
            }
        });
    }
}
