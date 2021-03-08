package com.win.opensdk;

import android.view.ViewTreeObserver;
import com.baidu.mapapi.UIMsg;
/* loaded from: classes14.dex */
public class ec implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ eg qme;
    public final /* synthetic */ ek qmf;

    public ec(ek ekVar, eg egVar) {
        this.qmf = ekVar;
        this.qme = egVar;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        try {
            if (this.qmf.b || !this.qmf.a(this.qmf.f8162a)) {
                return;
            }
            this.qmf.e.removeMessages(UIMsg.f_FUN.FUN_ID_SCH_POI);
            this.qmf.f8162a.getViewTreeObserver().removeOnScrollChangedListener(this);
            if (this.qme != null) {
                this.qme.a();
            }
            this.qmf.b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
