package d.a.m.d;
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ com.baidu.crabsdk.sender.d f63858e;

    public a(com.baidu.crabsdk.sender.d dVar) {
        this.f63858e = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2;
        com.baidu.crabsdk.sender.d dVar = this.f63858e;
        i2 = dVar.f4769i;
        dVar.f4769i = (i2 + 1) % 10;
    }
}
