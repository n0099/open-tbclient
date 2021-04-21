package d.b.h0.g.d.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f48775a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f48776b;

    public f() {
        this(null, null, 3, null);
    }

    public f(String str, Integer num) {
        this.f48775a = str;
        this.f48776b = num;
    }

    public final String a() {
        return this.f48775a;
    }

    public final Integer b() {
        return this.f48776b;
    }

    public final void c(String str) {
        this.f48775a = str;
    }

    public final void d(Integer num) {
        this.f48776b = num;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                return Intrinsics.areEqual(this.f48775a, fVar.f48775a) && Intrinsics.areEqual(this.f48776b, fVar.f48776b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f48775a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.f48776b;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.f48775a + ", responseStatusCode=" + this.f48776b + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ f(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? 0 : num);
    }
}
