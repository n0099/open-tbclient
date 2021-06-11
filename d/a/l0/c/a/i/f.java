package d.a.l0.c.a.i;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f50155a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f50156b;

    public f() {
        this(null, null, 3, null);
    }

    public f(String str, Integer num) {
        this.f50155a = str;
        this.f50156b = num;
    }

    public final String a() {
        return this.f50155a;
    }

    public final Integer b() {
        return this.f50156b;
    }

    public final void c(String str) {
        this.f50155a = str;
    }

    public final void d(Integer num) {
        this.f50156b = num;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                return Intrinsics.areEqual(this.f50155a, fVar.f50155a) && Intrinsics.areEqual(this.f50156b, fVar.f50156b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f50155a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.f50156b;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.f50155a + ", responseStatusCode=" + this.f50156b + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ f(String str, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : num);
    }
}
