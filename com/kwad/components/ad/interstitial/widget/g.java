package com.kwad.components.ad.interstitial.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ag;
/* loaded from: classes10.dex */
public final class g extends FrameLayout {
    public h fE;
    public boolean jb;
    public boolean jc;
    @NonNull
    public Context mContext;

    public g(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.jb = ag.cB(context);
    }

    private void eg() {
        boolean cB = ag.cB(this.mContext);
        if (!this.jc || cB == this.jb) {
            return;
        }
        this.jb = cB;
        h hVar = this.fE;
        if (hVar != null) {
            hVar.k(!cB);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        eg();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.jc = i == 0;
        eg();
    }

    public final void setOrientationChangeListener(h hVar) {
        this.fE = hVar;
    }
}
