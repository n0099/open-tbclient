package com.kwad.sdk.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
/* loaded from: classes10.dex */
public final class a extends com.kwad.components.core.proxy.d {
    @SuppressLint({"StaticFieldLeak"})
    public static a akJ;
    @Nullable
    public final DialogInterface.OnDismissListener akK;
    public final AdTemplate mAdTemplate;
    @Nullable
    public final DialogInterface.OnClickListener mOnClickListener;

    @Override // com.kwad.components.core.proxy.d
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04da;
    }

    public a(@NonNull Activity activity, @NonNull AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.akK = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    public static boolean a(Activity activity, AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            a aVar = akJ;
            if (aVar != null && aVar.isShowing()) {
                akJ.dismiss();
            }
            try {
                a aVar2 = new a(activity, adTemplate, onDismissListener, onClickListener);
                aVar2.show();
                akJ = aVar2;
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate yU;
        if (activity == null || activity.isFinishing() || (yU = c.yT().yU()) == null) {
            return false;
        }
        return a(activity, yU, onDismissListener, onClickListener);
    }

    public static boolean nj() {
        a aVar = akJ;
        if (aVar != null && aVar.isShowing()) {
            return true;
        }
        return false;
    }

    public static boolean yO() {
        a aVar = akJ;
        if (aVar != null && aVar.isShowing()) {
            akJ.dismiss();
            return true;
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.d, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        DialogInterface.OnDismissListener onDismissListener = this.akK;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        akJ = null;
    }

    @Override // com.kwad.components.core.proxy.d
    public final void g(View view2) {
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09137c);
        TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09137a);
        TextView textView3 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09137f);
        final AdInfo dP = com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate);
        String F = d.F(com.kwad.sdk.core.response.b.e.dP(this.mAdTemplate));
        if (F.equals("")) {
            F = this.mContext.getString(R.string.obfuscated_res_0x7f0f0b91, com.kwad.sdk.core.response.b.a.av(dP));
        }
        textView.setText(F);
        textView3.setText(d.yZ());
        textView2.setText(d.za());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                a.this.dismiss();
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -2);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.a.a.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -1);
                }
                ak.a(com.kwad.sdk.core.download.a.G(dP), new ak.a() { // from class: com.kwad.sdk.a.a.a.2.1
                    @Override // com.kwad.sdk.utils.ak.a
                    public final void f(Throwable th) {
                        com.kwad.sdk.commercial.b.a.j(a.this.mAdTemplate, 100003, Log.getStackTraceString(th));
                    }

                    @Override // com.kwad.sdk.utils.ak.a
                    public final void ob() {
                        com.kwad.sdk.core.report.a.k(a.this.mAdTemplate, 1);
                        com.kwad.sdk.commercial.b.a.aZ(a.this.mAdTemplate);
                    }
                });
            }
        });
    }
}
