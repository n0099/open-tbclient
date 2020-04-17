package kotlin.text;
@kotlin.h
/* loaded from: classes7.dex */
public final class f {
    private final kotlin.b.h mYQ;
    private final String value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!kotlin.jvm.internal.q.k(this.value, fVar.value) || !kotlin.jvm.internal.q.k(this.mYQ, fVar.mYQ)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.b.h hVar = this.mYQ;
        return hashCode + (hVar != null ? hVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.mYQ + ")";
    }

    public f(String str, kotlin.b.h hVar) {
        kotlin.jvm.internal.q.j(str, "value");
        kotlin.jvm.internal.q.j(hVar, "range");
        this.value = str;
        this.mYQ = hVar;
    }
}
