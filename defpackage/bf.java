package defpackage;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bf  reason: default package */
/* loaded from: classes.dex */
public final class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f375a;

    private bf(ba baVar) {
        this.f375a = baVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bf(ba baVar, bg bgVar) {
        this(baVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f375a.D;
        if (z) {
            this.f375a.c();
            bb.a(this);
        }
    }
}
