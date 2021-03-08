package com.win.opensdk;

import android.view.View;
import com.win.opensdk.views.CloseParentView;
/* loaded from: classes14.dex */
public class eb implements View.OnClickListener {
    public final /* synthetic */ CloseParentView qma;

    public eb(CloseParentView closeParentView) {
        this.qma = closeParentView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.qma.a();
    }
}
