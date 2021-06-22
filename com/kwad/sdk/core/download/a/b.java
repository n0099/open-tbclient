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
/* loaded from: classes7.dex */
public class b extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    public static b f34266a;

    /* renamed from: b  reason: collision with root package name */
    public a f34267b;

    /* renamed from: c  reason: collision with root package name */
    public AdTemplate f34268c;

    public b(Activity activity, @NonNull AdTemplate adTemplate) {
        super(Wrapper.wrapContextIfNeed(activity));
        setOwnerActivity(activity);
        this.f34268c = adTemplate;
    }

    public static boolean a() {
        b bVar = f34266a;
        if (bVar != null) {
            return bVar.isShowing();
        }
        return false;
    }

    public static boolean a(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        if (context instanceof Activity) {
            try {
                if (f34266a == null) {
                    b bVar = new b((Activity) context, adTemplate);
                    f34266a = bVar;
                    bVar.getWindow().addFlags(1024);
                }
                if (f34266a.isShowing()) {
                    return true;
                }
                f34266a.show();
                com.kwad.sdk.core.report.b.c(adTemplate, 86, null);
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
            int i2 = Z.windowPopType;
            return i2 == 1 || (i2 == 2 && !com.ksad.download.d.b.b(context));
        }
        return false;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        f34266a = null;
    }

    @Override // android.app.Dialog
    public boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        com.kwad.sdk.core.report.b.o(this.f34268c);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f34267b == null) {
            a aVar = new a(Wrapper.wrapContextIfNeed(getOwnerActivity()), this, this.f34268c, !x.e(getOwnerActivity()) ? 1 : 0);
            this.f34267b = aVar;
            aVar.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.core.download.a.b.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.kwad.sdk.core.report.b.o(b.this.f34268c);
                    b.this.dismiss();
                }
            });
        }
        setContentView(this.f34267b);
        setCanceledOnTouchOutside(true);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f34267b;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        b bVar = f34266a;
        if (bVar != null) {
            bVar.setTitle((CharSequence) null);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
