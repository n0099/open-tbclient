package d.b.g0.g.d.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f48053a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f48054b;

    public f() {
        this(null, null, 3, null);
    }

    public f(String str, Integer num) {
        this.f48053a = str;
        this.f48054b = num;
    }

    public final String a() {
        return this.f48053a;
    }

    public final Integer b() {
        return this.f48054b;
    }

    public final void c(String str) {
        this.f48053a = str;
    }

    public final void d(Integer num) {
        this.f48054b = num;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                return Intrinsics.areEqual(this.f48053a, fVar.f48053a) && Intrinsics.areEqual(this.f48054b, fVar.f48054b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f48053a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.f48054b;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.f48053a + ", responseStatusCode=" + this.f48054b + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ f(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }
}
