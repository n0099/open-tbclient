package d.a.m0.c.a.i;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f50249a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.c.a.k.c f50250b;

    public c(String str, d.a.m0.c.a.k.c cVar) {
        this.f50249a = str;
        this.f50250b = cVar;
    }

    public final d.a.m0.c.a.k.c a() {
        return this.f50250b;
    }

    public final String b() {
        return this.f50249a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.areEqual(this.f50249a, cVar.f50249a) && Intrinsics.areEqual(this.f50250b, cVar.f50250b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f50249a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d.a.m0.c.a.k.c cVar = this.f50250b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.f50249a + ", bdtlsRequest=" + this.f50250b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
