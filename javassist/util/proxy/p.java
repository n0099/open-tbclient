package javassist.util.proxy;

import java.security.PrivilegedExceptionAction;
/* loaded from: classes.dex */
final class p implements PrivilegedExceptionAction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f2877a;
    final /* synthetic */ String b;
    final /* synthetic */ Class[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Class cls, String str, Class[] clsArr) {
        this.f2877a = cls;
        this.b = str;
        this.c = clsArr;
    }

    @Override // java.security.PrivilegedExceptionAction
    public Object run() {
        return this.f2877a.getDeclaredMethod(this.b, this.c);
    }
}
