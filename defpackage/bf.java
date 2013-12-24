package defpackage;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bf  reason: default package */
/* loaded from: classes.dex */
public final class bf implements Runnable {
    final /* synthetic */ ba a;

    private bf(ba baVar) {
        this.a = baVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bf(ba baVar, bg bgVar) {
        this(baVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.a.D;
        if (z) {
            this.a.c();
            bb.a(this);
        }
    }
}
