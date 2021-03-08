package com.win.opensdk;

import android.view.View;
/* loaded from: classes14.dex */
public class df implements Runnable {
    public final /* synthetic */ dj qlJ;

    public df(dj djVar) {
        this.qlJ = djVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            View rootView = this.qlJ.f8152a.getRootView();
            if (rootView == null || rootView.getVisibility() != 0) {
                return;
            }
            ca.iT(this.qlJ.qlM.f8159a).a(new cd(this.qlJ.qlM.qkh), this.qlJ.f8152a.getWidth(), this.qlJ.f8152a.getHeight()).a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
