package com.kwad.sdk.core.download.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.x;
/* loaded from: classes5.dex */
public class b extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    private static b f9394a;

    /* renamed from: b  reason: collision with root package name */
    private a f9395b;
    private AdTemplate c;

    private b(Activity activity, @NonNull AdTemplate adTemplate) {
        super(Wrapper.wrapContextIfNeed(activity));
        setOwnerActivity(activity);
        this.c = adTemplate;
    }

    public static boolean a() {
        if (f9394a != null) {
            return f9394a.isShowing();
        }
        return false;
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        if (context instanceof Activity) {
            try {
                if (f9394a == null) {
                    f9394a = new b((Activity) context, adTemplate);
                    f9394a.getWindow().addFlags(1024);
                }
                if (!f9394a.isShowing()) {
                    f9394a.show();
                    com.kwad.sdk.core.report.b.c(adTemplate, 86, null);
                }
                return true;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.a.a(th);
                return false;
            }
        }
        return false;
    }

    public static boolean b(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        AdInfo.DownloadSafeInfo Z;
        if (com.kwad.sdk.core.response.b.c.c(adTemplate) && (Z = com.kwad.sdk.core.response.b.a.Z(com.kwad.sdk.core.response.b.c.j(adTemplate))) != null && URLUtil.isNetworkUrl(Z.windowPopUrl)) {
            int i = Z.windowPopType;
            if (i == 1) {
                return true;
            }
            if (i == 2 && !com.ksad.download.d.b.b(context)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        f9394a = null;
    }

    @Override // android.app.Dialog
    public boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.report.b.o(this.c);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f9395b == null) {
            this.f9395b = new a(Wrapper.wrapContextIfNeed(getOwnerActivity()), this, this.c, x.e(getOwnerActivity()) ? 0 : 1);
            this.f9395b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.kwad.sdk.core.report.b.o(b.this.c);
                    b.this.dismiss();
                }
            });
        }
        setContentView(this.f9395b);
        setCanceledOnTouchOutside(true);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f9395b != null) {
            this.f9395b.c();
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        if (f9394a != null) {
            f9394a.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
