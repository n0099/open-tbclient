package d.a.h0.g.d.g;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f46229a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.g.d.i.b f46230b;

    public c(String str, d.a.h0.g.d.i.b bVar) {
        this.f46229a = str;
        this.f46230b = bVar;
    }

    public final d.a.h0.g.d.i.b a() {
        return this.f46230b;
    }

    public final String b() {
        return this.f46229a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.areEqual(this.f46229a, cVar.f46229a) && Intrinsics.areEqual(this.f46230b, cVar.f46230b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f46229a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d.a.h0.g.d.i.b bVar = this.f46230b;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.f46229a + ", bdtlsRequest=" + this.f46230b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
