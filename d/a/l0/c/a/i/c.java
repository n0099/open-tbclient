package d.a.l0.c.a.i;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f46467a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.c.a.k.c f46468b;

    public c(String str, d.a.l0.c.a.k.c cVar) {
        this.f46467a = str;
        this.f46468b = cVar;
    }

    public final d.a.l0.c.a.k.c a() {
        return this.f46468b;
    }

    public final String b() {
        return this.f46467a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.areEqual(this.f46467a, cVar.f46467a) && Intrinsics.areEqual(this.f46468b, cVar.f46468b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f46467a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d.a.l0.c.a.k.c cVar = this.f46468b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.f46467a + ", bdtlsRequest=" + this.f46468b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
