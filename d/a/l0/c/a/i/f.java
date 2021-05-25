package d.a.l0.c.a.i;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f46481a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f46482b;

    public f() {
        this(null, null, 3, null);
    }

    public f(String str, Integer num) {
        this.f46481a = str;
        this.f46482b = num;
    }

    public final String a() {
        return this.f46481a;
    }

    public final Integer b() {
        return this.f46482b;
    }

    public final void c(String str) {
        this.f46481a = str;
    }

    public final void d(Integer num) {
        this.f46482b = num;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                return Intrinsics.areEqual(this.f46481a, fVar.f46481a) && Intrinsics.areEqual(this.f46482b, fVar.f46482b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f46481a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.f46482b;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.f46481a + ", responseStatusCode=" + this.f46482b + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ f(String str, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : num);
    }
}
