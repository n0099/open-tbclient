package d.a.m0.a.u.f.b;

import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
/* loaded from: classes2.dex */
public class e {

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49004a;

        static {
            int[] iArr = new int[BasePendingOperation.OperationType.values().length];
            f49004a = iArr;
            try {
                iArr[BasePendingOperation.OperationType.OPERATION_TYPE_MAIN_THREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49004a[BasePendingOperation.OperationType.OPERATION_TYPE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static d.a.m0.a.u.f.b.a a(BasePendingOperation.OperationType operationType) {
        int i2 = a.f49004a[operationType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return new f();
            }
            return new d();
        }
        return new c();
    }
}
