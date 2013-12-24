package defpackage;
/* renamed from: be  reason: default package */
/* loaded from: classes.dex */
final class be implements Runnable {
    final /* synthetic */ ba a;

    private be(ba baVar) {
        this.a = baVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ be(ba baVar, bg bgVar) {
        this(baVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.performClick();
    }
}
