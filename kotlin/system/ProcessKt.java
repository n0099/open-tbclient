package kotlin.system;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "status", "", "exitProcess", "(I)Ljava/lang/Void;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "ProcessKt")
/* loaded from: classes3.dex */
public final class ProcessKt {
    @InlineOnly
    public static final Void exitProcess(int i2) {
        System.exit(i2);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
