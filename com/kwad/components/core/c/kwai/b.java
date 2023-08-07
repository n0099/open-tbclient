package com.kwad.components.core.c.kwai;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.c.kwai.a;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bj;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends AlertDialog {
    @Nullable
    public static b DG;
    @NonNull
    public final C0649b DH;
    public com.kwad.components.core.c.kwai.a DK;
    public boolean DL;

    /* loaded from: classes10.dex */
    public static class a {
        @Nullable
        public DialogInterface.OnShowListener DN;
        @Nullable
        public DialogInterface.OnDismissListener DO;
        public AdTemplate adTemplate;
        @Nullable
        public Context context;
        public String url;

        public final a K(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final a a(@Nullable DialogInterface.OnShowListener onShowListener) {
            this.DN = onShowListener;
            return this;
        }

        public final a ah(Context context) {
            this.context = context;
            return this;
        }

        public final a ak(String str) {
            this.url = str;
            return this;
        }

        public final a c(@Nullable DialogInterface.OnDismissListener onDismissListener) {
            this.DO = onDismissListener;
            return this;
        }

        public final C0649b ms() {
            if (com.kwad.components.core.a.aw.booleanValue() && (this.context == null || this.adTemplate == null || TextUtils.isEmpty(this.url))) {
                throw new IllegalArgumentException("param is error, please check it");
            }
            return new C0649b(this, (byte) 0);
        }
    }

    /* renamed from: com.kwad.components.core.c.kwai.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0649b {
        @Nullable
        public DialogInterface.OnShowListener DN;
        @Nullable
        public DialogInterface.OnDismissListener DO;
        public final AdTemplate adTemplate;
        public Context context;
        public String url;

        public C0649b(a aVar) {
            this.context = aVar.context;
            this.adTemplate = aVar.adTemplate;
            this.url = aVar.url;
            this.DN = aVar.DN;
            this.DO = aVar.DO;
        }

        public /* synthetic */ C0649b(a aVar, byte b) {
            this(aVar);
        }
    }

    public b(Activity activity, C0649b c0649b) {
        super(activity);
        this.DL = false;
        setOwnerActivity(activity);
        this.DH = c0649b;
        c0649b.context = Wrapper.wrapContextIfNeed(c0649b.context);
        if (com.kwad.sdk.b.kwai.a.a(activity)) {
            getWindow().addFlags(1024);
        }
        setOnShowListener(c0649b.DN);
        setOnDismissListener(c0649b.DO);
    }

    public static boolean a(C0649b c0649b) {
        Activity dB;
        b bVar = DG;
        if ((bVar != null && bVar.isShowing()) || (dB = bj.dB(c0649b.context)) == null || dB.isFinishing()) {
            return false;
        }
        com.kwad.sdk.kwai.kwai.c.rd().dismiss();
        try {
            b bVar2 = new b(dB, c0649b);
            DG = bVar2;
            bVar2.show();
            com.kwad.sdk.core.report.a.c(c0649b.adTemplate, 86, (JSONObject) null);
            return true;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.b.printStackTrace(th);
            return false;
        }
    }

    public static boolean mq() {
        b bVar = DG;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public final void ai(boolean z) {
        this.DL = z;
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        DG = null;
    }

    @Override // android.app.Dialog
    public final boolean isShowing() {
        return super.isShowing();
    }

    public final boolean mr() {
        return this.DL;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.report.a.aB(this.DH.adTemplate);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.DK == null) {
            com.kwad.components.core.c.kwai.a aVar = new com.kwad.components.core.c.kwai.a(this, this.DH);
            this.DK = aVar;
            aVar.setChangeListener(new a.InterfaceC0648a() { // from class: com.kwad.components.core.c.kwai.b.1
                @Override // com.kwad.components.core.c.kwai.a.InterfaceC0648a
                public final void mp() {
                    b.this.dismiss();
                }
            });
        }
        setContentView(this.DK);
        setCanceledOnTouchOutside(true);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        DG = null;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        b bVar = DG;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public final void show() {
        try {
            super.show();
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(e);
        }
    }
}
