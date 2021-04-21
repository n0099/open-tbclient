package d.b.m.d;
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ com.baidu.crabsdk.sender.d f65009e;

    public a(com.baidu.crabsdk.sender.d dVar) {
        this.f65009e = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        com.baidu.crabsdk.sender.d dVar = this.f65009e;
        i = dVar.i;
        dVar.i = (i + 1) % 10;
    }
}
