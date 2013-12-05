package javassist.util.proxy;

import java.security.PrivilegedExceptionAction;
/* loaded from: classes.dex */
class r implements PrivilegedExceptionAction {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3044a;
    final /* synthetic */ SerializedProxy b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SerializedProxy serializedProxy, String str) {
        this.b = serializedProxy;
        this.f3044a = str;
    }

    @Override // java.security.PrivilegedExceptionAction
    public Object run() {
        return Class.forName(this.f3044a, true, Thread.currentThread().getContextClassLoader());
    }
}
