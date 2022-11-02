package com.kwad.sdk.kwai.kwai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
/* loaded from: classes8.dex */
public final class a extends com.kwad.components.core.i.d {
    @SuppressLint({"StaticFieldLeak"})
    public static a QY;
    @Nullable
    public final DialogInterface.OnDismissListener QZ;
    public final AdTemplate mAdTemplate;
    @Nullable
    public final DialogInterface.OnClickListener mOnClickListener;

    public a(@NonNull Activity activity, @NonNull AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        super(activity);
        this.mAdTemplate = adTemplate;
        this.QZ = onDismissListener;
        this.mOnClickListener = onClickListener;
    }

    public static boolean a(Activity activity, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        AdTemplate re;
        if (activity == null || activity.isFinishing() || (re = c.rd().re()) == null) {
            return false;
        }
        return a(activity, re, onDismissListener, onClickListener);
    }

    public static boolean a(Activity activity, AdTemplate adTemplate, @Nullable DialogInterface.OnDismissListener onDismissListener, @Nullable DialogInterface.OnClickListener onClickListener) {
        if (activity != null && !activity.isFinishing() && adTemplate != null) {
            a aVar = QY;
            if (aVar != null && aVar.isShowing()) {
                QY.dismiss();
            }
            try {
                a aVar2 = new a(activity, adTemplate, onDismissListener, onClickListener);
                aVar2.show();
                QY = aVar2;
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean mq() {
        a aVar = QY;
        return aVar != null && aVar.isShowing();
    }

    public static boolean qY() {
        a aVar = QY;
        if (aVar == null || !aVar.isShowing()) {
            return false;
        }
        QY.dismiss();
        return true;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        DialogInterface.OnDismissListener onDismissListener = this.QZ;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(this);
        }
        QY = null;
    }

    @Override // com.kwad.components.core.i.d
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0437;
    }

    @Override // com.kwad.components.core.i.d
    public final void u(View view2) {
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0910f4)).setText(this.mContext.getString(R.string.obfuscated_res_0x7f0f09dd, com.kwad.sdk.core.response.a.a.ae(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))));
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0910f2)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                a.this.dismiss();
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -2);
                }
            }
        });
        ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f0910f7)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                if (a.this.mOnClickListener != null) {
                    a.this.mOnClickListener.onClick(a.this, -1);
                }
                if (ai.X(((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext(), com.kwad.sdk.core.download.a.w(com.kwad.sdk.core.response.a.d.bQ(a.this.mAdTemplate)))) {
                    com.kwad.sdk.core.report.a.h(a.this.mAdTemplate, 1);
                }
            }
        });
    }
}
