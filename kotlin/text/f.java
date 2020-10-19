package kotlin.text;
@kotlin.h
/* loaded from: classes10.dex */
public final class f {
    private final kotlin.b.h oSS;
    private final String value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!kotlin.jvm.internal.q.l(this.value, fVar.value) || !kotlin.jvm.internal.q.l(this.oSS, fVar.oSS)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.b.h hVar = this.oSS;
        return hashCode + (hVar != null ? hVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.oSS + ")";
    }

    public f(String str, kotlin.b.h hVar) {
        kotlin.jvm.internal.q.n(str, "value");
        kotlin.jvm.internal.q.n(hVar, "range");
        this.value = str;
        this.oSS = hVar;
    }
}
