package d.a.h0.g.d.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f46243a;

    /* renamed from: b  reason: collision with root package name */
    public Integer f46244b;

    public f() {
        this(null, null, 3, null);
    }

    public f(String str, Integer num) {
        this.f46243a = str;
        this.f46244b = num;
    }

    public final String a() {
        return this.f46243a;
    }

    public final Integer b() {
        return this.f46244b;
    }

    public final void c(String str) {
        this.f46243a = str;
    }

    public final void d(Integer num) {
        this.f46244b = num;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                return Intrinsics.areEqual(this.f46243a, fVar.f46243a) && Intrinsics.areEqual(this.f46244b, fVar.f46244b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f46243a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.f46244b;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ResponseParams(responseMessage=" + this.f46243a + ", responseStatusCode=" + this.f46244b + SmallTailInfo.EMOTION_SUFFIX;
    }

    public /* synthetic */ f(String str, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : num);
    }
}
