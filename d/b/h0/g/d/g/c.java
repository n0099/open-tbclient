package d.b.h0.g.d.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f48762a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.g.d.i.b f48763b;

    public c(String str, d.b.h0.g.d.i.b bVar) {
        this.f48762a = str;
        this.f48763b = bVar;
    }

    public final d.b.h0.g.d.i.b a() {
        return this.f48763b;
    }

    public final String b() {
        return this.f48762a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.areEqual(this.f48762a, cVar.f48762a) && Intrinsics.areEqual(this.f48763b, cVar.f48763b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f48762a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d.b.h0.g.d.i.b bVar = this.f48763b;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.f48762a + ", bdtlsRequest=" + this.f48763b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
