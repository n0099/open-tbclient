package javassist.util.proxy;

import java.security.PrivilegedAction;
/* loaded from: classes.dex */
final class n implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f2875a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Class cls) {
        this.f2875a = cls;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        return this.f2875a.getDeclaredMethods();
    }
}
