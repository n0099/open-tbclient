package javassist.util.proxy;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class k {

    /* renamed from: a  reason: collision with root package name */
    byte[] f2874a;
    WeakReference b;
    boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(byte[] bArr, Class cls, boolean z) {
        this.f2874a = bArr;
        this.b = new WeakReference(cls);
        this.c = z;
    }
}
