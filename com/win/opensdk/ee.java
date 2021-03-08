package com.win.opensdk;

import android.view.View;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes14.dex */
public class ee implements View.OnClickListener {
    public final /* synthetic */ CloseParentView qma;

    public ee(CloseParentView closeParentView) {
        this.qma = closeParentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ei eiVar = this.qma.qms;
        if (eiVar != null) {
            ((ej) eiVar).qmh.finish();
        }
    }
}
