package d.b.g0.g.d.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f48041a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.g.d.i.b f48042b;

    public c(String str, d.b.g0.g.d.i.b bVar) {
        this.f48041a = str;
        this.f48042b = bVar;
    }

    public final d.b.g0.g.d.i.b a() {
        return this.f48042b;
    }

    public final String b() {
        return this.f48041a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.areEqual(this.f48041a, cVar.f48041a) && Intrinsics.areEqual(this.f48042b, cVar.f48042b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f48041a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d.b.g0.g.d.i.b bVar = this.f48042b;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.f48041a + ", bdtlsRequest=" + this.f48042b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
