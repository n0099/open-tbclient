package com.win.opensdk;

import android.view.View;
import com.win.opensdk.core.Info;
/* loaded from: classes14.dex */
public class h implements View.OnClickListener {
    public final /* synthetic */ Info qkd;
    public final /* synthetic */ l qke;

    public h(l lVar, Info info) {
        this.qke = lVar;
        this.qkd = info;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            ca.iT(this.qke.c).b(new cd(this.qkd)).a();
            if (this.qke.qkl != null) {
                this.qke.qkl.onClosed();
            }
        } catch (Exception e) {
        }
        this.qke.qkj.destroy();
    }
}
