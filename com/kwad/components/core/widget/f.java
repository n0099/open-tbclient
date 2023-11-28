package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ai;
/* loaded from: classes10.dex */
public final class f extends FrameLayout {
    public boolean acf;
    public boolean iD;

    /* renamed from: if  reason: not valid java name */
    public g f6if;
    @NonNull
    public Context mContext;

    public f(@NonNull Context context) {
        super(context);
        this.mContext = context;
        this.iD = ai.Kx();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        tk();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        this.acf = z;
        tk();
    }

    public final void setOrientationChangeListener(g gVar) {
        this.f6if = gVar;
    }

    private void tk() {
        boolean Kx = ai.Kx();
        if (this.acf && Kx != this.iD) {
            this.iD = Kx;
            g gVar = this.f6if;
            if (gVar != null) {
                gVar.j(!Kx);
            }
        }
    }
}
