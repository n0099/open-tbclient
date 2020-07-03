package kotlin.text;
@kotlin.h
/* loaded from: classes7.dex */
public final class f {
    private final kotlin.b.h nQS;
    private final String value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!kotlin.jvm.internal.q.l((Object) this.value, (Object) fVar.value) || !kotlin.jvm.internal.q.l(this.nQS, fVar.nQS)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.b.h hVar = this.nQS;
        return hashCode + (hVar != null ? hVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.nQS + ")";
    }

    public f(String str, kotlin.b.h hVar) {
        kotlin.jvm.internal.q.m(str, "value");
        kotlin.jvm.internal.q.m(hVar, "range");
        this.value = str;
        this.nQS = hVar;
    }
}
