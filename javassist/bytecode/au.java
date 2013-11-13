package javassist.bytecode;
/* loaded from: classes.dex */
class au {

    /* renamed from: a  reason: collision with root package name */
    int f2794a;

    private au() {
        this.f2794a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, int i) {
        int indexOf = str.indexOf(i, this.f2794a);
        if (indexOf < 0) {
            throw SignatureAttribute.b(str);
        }
        this.f2794a = indexOf + 1;
        return indexOf;
    }
}
