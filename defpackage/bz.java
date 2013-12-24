package defpackage;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bz  reason: default package */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {
    final /* synthetic */ bw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bw bwVar) {
        this.a = bwVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.onBackPressed();
    }
}
