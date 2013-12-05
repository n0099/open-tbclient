package javassist.util.proxy;

import java.security.PrivilegedAction;
/* loaded from: classes.dex */
final class o implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Class f3041a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Class cls) {
        this.f3041a = cls;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        return this.f3041a.getDeclaredConstructors();
    }
}
