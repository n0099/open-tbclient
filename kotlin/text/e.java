package kotlin.text;

import com.baidu.ubc.UBC;
/* loaded from: classes2.dex */
public final class e {
    private final kotlin.b.c kvR;
    private final String value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (!kotlin.jvm.internal.p.h(this.value, eVar.value) || !kotlin.jvm.internal.p.h(this.kvR, eVar.kvR)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.b.c cVar = this.kvR;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.kvR + ")";
    }

    public e(String str, kotlin.b.c cVar) {
        kotlin.jvm.internal.p.k(str, UBC.CONTENT_KEY_VALUE);
        kotlin.jvm.internal.p.k(cVar, "range");
        this.value = str;
        this.kvR = cVar;
    }
}
