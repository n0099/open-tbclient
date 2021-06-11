package d.a.l0.c.a.i;

import com.baidu.tbadk.core.data.SmallTailInfo;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f50141a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.c.a.k.c f50142b;

    public c(String str, d.a.l0.c.a.k.c cVar) {
        this.f50141a = str;
        this.f50142b = cVar;
    }

    public final d.a.l0.c.a.k.c a() {
        return this.f50142b;
    }

    public final String b() {
        return this.f50141a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return Intrinsics.areEqual(this.f50141a, cVar.f50141a) && Intrinsics.areEqual(this.f50142b, cVar.f50142b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f50141a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        d.a.l0.c.a.k.c cVar = this.f50142b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "BdtlsRequestParams(requestData=" + this.f50141a + ", bdtlsRequest=" + this.f50142b + SmallTailInfo.EMOTION_SUFFIX;
    }
}
