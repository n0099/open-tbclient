package javassist.bytecode;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    k f2816a;
    int b;
    int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(byte[] bArr, k kVar, ab abVar, CodeAttribute codeAttribute) {
        if (kVar != null) {
            return CodeIterator.a(bArr, abVar, codeAttribute, kVar);
        }
        return bArr;
    }
}
