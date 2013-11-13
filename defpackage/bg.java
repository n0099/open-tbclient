package defpackage;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bg  reason: default package */
/* loaded from: classes.dex */
public class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f376a;
    final /* synthetic */ ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(ba baVar, boolean z) {
        this.b = baVar;
        this.f376a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.setChecked(this.f376a);
    }
}
