package javassist.util.proxy;

import java.lang.reflect.AccessibleObject;
import java.security.PrivilegedAction;
/* loaded from: classes.dex */
final class q implements PrivilegedAction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AccessibleObject f3043a;
    final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(AccessibleObject accessibleObject, boolean z) {
        this.f3043a = accessibleObject;
        this.b = z;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        this.f3043a.setAccessible(this.b);
        return null;
    }
}
