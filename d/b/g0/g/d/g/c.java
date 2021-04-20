package d.b.g0.g.d.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f48433a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.d.i.b f48434b;

    public c(String str, d.b.g0.g.d.i.b bVar) {
        this.f48433a = str;
        this.f48434b = bVar;
    }

    public final d.b.g0.g.d.i.b a() {
        return this.f48434b;
    }

    public final String b() {
        return this.f48433a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.areEqual(this.f48433a, cVar.f48433a) && Intrinsics.areEqual(this.f48434b, cVar.f48434b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f48433a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d.b.g0.g.d.i.b bVar = this.f48434b;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.f48433a + ", bdtlsRequest=" + this.f48434b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
