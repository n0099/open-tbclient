package com.kwad.components.core.i;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.LayoutRes;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes9.dex */
public abstract class d extends AlertDialog {
    public final Context mContext;

    public d(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mContext = Wrapper.wrapContextIfNeed(activity);
    }

    @LayoutRes
    public abstract int getLayoutId();

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = View.inflate(this.mContext, getLayoutId(), null);
        setContentView(inflate);
        setCanceledOnTouchOutside(false);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().setLayout(-1, -1);
        u(inflate);
    }

    public abstract void u(View view2);
}
