package d.a.i0.c.a.i;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f46291a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.c.a.k.c f46292b;

    public c(String str, d.a.i0.c.a.k.c cVar) {
        this.f46291a = str;
        this.f46292b = cVar;
    }

    public final d.a.i0.c.a.k.c a() {
        return this.f46292b;
    }

    public final String b() {
        return this.f46291a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.areEqual(this.f46291a, cVar.f46291a) && Intrinsics.areEqual(this.f46292b, cVar.f46292b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f46291a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d.a.i0.c.a.k.c cVar = this.f46292b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.f46291a + ", bdtlsRequest=" + this.f46292b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
