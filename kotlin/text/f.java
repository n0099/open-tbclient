package kotlin.text;
/* loaded from: classes5.dex */
public final class f {
    private final kotlin.b.c nCt;
    private final String value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!kotlin.jvm.internal.q.h(this.value, fVar.value) || !kotlin.jvm.internal.q.h(this.nCt, fVar.nCt)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.b.c cVar = this.nCt;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.nCt + ")";
    }

    public f(String str, kotlin.b.c cVar) {
        kotlin.jvm.internal.q.j(str, "value");
        kotlin.jvm.internal.q.j(cVar, "range");
        this.value = str;
        this.nCt = cVar;
    }
}
