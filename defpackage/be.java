package defpackage;
/* renamed from: be  reason: default package */
/* loaded from: classes.dex */
final class be implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ba f374a;

    private be(ba baVar) {
        this.f374a = baVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ be(ba baVar, bg bgVar) {
        this(baVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f374a.performClick();
    }
}
