package javassist.scopedpool;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
class d extends SoftReference {

    /* renamed from: a  reason: collision with root package name */
    public Object f2813a;

    private d(Object obj, Object obj2, ReferenceQueue referenceQueue) {
        super(obj2, referenceQueue);
        this.f2813a = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d b(Object obj, Object obj2, ReferenceQueue referenceQueue) {
        if (obj2 == null) {
            return null;
        }
        return new d(obj, obj2, referenceQueue);
    }
}
