package com.mofamulu.tieba.sign;

import android.view.View;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ AccountSelectBarsToSignActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(AccountSelectBarsToSignActivity accountSelectBarsToSignActivity) {
        this.a = accountSelectBarsToSignActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (au auVar : this.a.l) {
            if (auVar.e) {
                arrayList.add(auVar.b);
            }
        }
        SignServiceBinder signServiceBinder = this.a.g;
        str = this.a.p;
        ar a = signServiceBinder.a(str);
        if (a != null) {
            al t = a.t();
            t.b(arrayList);
            this.a.g.b.a(t);
        }
        this.a.finish();
    }
}
