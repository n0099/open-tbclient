package javassist.bytecode;
/* loaded from: classes.dex */
class au {

    /* renamed from: a  reason: collision with root package name */
    int f2746a;

    private au() {
        this.f2746a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, int i) {
        int indexOf = str.indexOf(i, this.f2746a);
        if (indexOf < 0) {
            throw SignatureAttribute.b(str);
        }
        this.f2746a = indexOf + 1;
        return indexOf;
    }
}
