package com.kwad.sdk.core.download.kwai;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.x;
/* loaded from: classes5.dex */
public class b extends AlertDialog {
    public static b a;
    public String b;
    public a c;
    public AdTemplate d;
    public boolean e;

    public b(Activity activity, @NonNull AdTemplate adTemplate, String str) {
        super(Wrapper.wrapContextIfNeed(activity));
        this.e = false;
        setOwnerActivity(activity);
        this.d = adTemplate;
        this.b = str;
    }

    public static b a(Activity activity, AdTemplate adTemplate, String str) {
        b bVar = new b(activity, adTemplate, str);
        bVar.getWindow().addFlags(1024);
        return bVar;
    }

    public static boolean a() {
        b bVar = a;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate, @Nullable String str) {
        return a(context, adTemplate, str, null, null);
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate, @Nullable String str, @Nullable DialogInterface.OnShowListener onShowListener, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        if (context instanceof ResContext) {
            context = ((ResContext) context).getDelegatedContext();
        }
        Activity c = context instanceof Activity ? (Activity) context : x.a().c();
        if (c == null || c.isFinishing()) {
            return false;
        }
        try {
            if (a == null) {
                b a2 = a(c, adTemplate, str);
                a = a2;
                if (onShowListener != null) {
                    a2.setOnShowListener(onShowListener);
                }
                if (onDismissListener != null) {
                    a.setOnDismissListener(onDismissListener);
                }
            }
            if (a.isShowing()) {
                return true;
            }
            a.show();
            com.kwad.sdk.core.report.a.c(adTemplate, 86, null);
            return true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
            return false;
        }
    }

    public void a(boolean z) {
        this.e = z;
        dismiss();
    }

    public boolean b() {
        return this.e;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a = null;
    }

    @Override // android.app.Dialog
    public boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.report.a.n(this.d);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.c == null) {
            a aVar = new a(Wrapper.wrapContextIfNeed(getOwnerActivity()), this, this.d, !af.e(getOwnerActivity()) ? 1 : 0, this.b);
            this.c = aVar;
            aVar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.kwai.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.kwad.sdk.core.report.a.n(b.this.d);
                    b.this.dismiss();
                }
            });
        }
        setContentView(this.c);
        setCanceledOnTouchOutside(true);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
        a = null;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        b bVar = a;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.b(e);
        }
    }
}
