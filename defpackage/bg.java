package defpackage;
/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: bg  reason: default package */
/* loaded from: classes.dex */
public class bg implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ ba b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(ba baVar, boolean z) {
        this.b = baVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.setChecked(this.a);
    }
}
