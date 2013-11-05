package defpackage;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bz  reason: default package */
/* loaded from: classes.dex */
public class bz implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bw f392a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bw bwVar) {
        this.f392a = bwVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f392a.onBackPressed();
    }
}
