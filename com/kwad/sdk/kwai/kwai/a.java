package com.kwad.sdk.kwai.kwai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.h.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
/* loaded from: classes5.dex */
public final class a extends d {
    @SuppressLint({"StaticFieldLeak"})
    public static a b;
    public final AdTemplate c;
    @Nullable
    public final DialogInterface.OnDismissListener d;
    @Nullable
    public final DialogInterface.OnClickListener e;

    public a(@NonNull Activity activity, @NonNull AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.c = adTemplate;
        this.d = onDismissListener;
        this.e = onClickListener;
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate b2;
        if (activity == null || activity.isFinishing() || (b2 = b.a().b()) == null) {
            return false;
        }
        return a(activity, b2, onDismissListener, onClickListener);
    }

    public static boolean a(Activity activity, AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            a aVar = b;
            if (aVar != null && aVar.isShowing()) {
                b.dismiss();
            }
            try {
                new a(activity, adTemplate, onDismissListener, onClickListener).show();
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean b() {
        a aVar = b;
        return aVar != null && aVar.isShowing();
    }

    public static void c() {
        a aVar = b;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        b.dismiss();
    }

    @Override // com.kwad.components.core.h.d
    public final int a() {
        return R.layout.obfuscated_res_0x7f0d0427;
    }

    @Override // com.kwad.components.core.h.d
    public final void a(View view2) {
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091056)).setText(this.a.getString(R.string.obfuscated_res_0x7f0f09a9, com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.i(this.c))));
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091054)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                a.this.dismiss();
                if (a.this.e != null) {
                    a.this.e.onClick(a.this, -2);
                }
            }
        });
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f091059)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                if (a.this.e != null) {
                    a.this.e.onClick(a.this, -1);
                }
                if (af.d(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a(), com.kwad.sdk.core.download.a.a(com.kwad.sdk.core.response.a.d.i(a.this.c)))) {
                    com.kwad.sdk.core.report.a.b(a.this.c, 1);
                }
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        DialogInterface.OnDismissListener onDismissListener = this.d;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        b = null;
    }
}
