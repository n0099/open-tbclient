package kotlin.text;
/* loaded from: classes4.dex */
public final class f {
    private final kotlin.b.c mZK;
    private final String value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!kotlin.jvm.internal.p.h(this.value, fVar.value) || !kotlin.jvm.internal.p.h(this.mZK, fVar.mZK)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.b.c cVar = this.mZK;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.mZK + ")";
    }

    public f(String str, kotlin.b.c cVar) {
        kotlin.jvm.internal.p.j(str, "value");
        kotlin.jvm.internal.p.j(cVar, "range");
        this.value = str;
        this.mZK = cVar;
    }
}
