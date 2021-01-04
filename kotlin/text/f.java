package kotlin.text;
@kotlin.e
/* loaded from: classes5.dex */
public final class f {
    private final kotlin.b.h qnc;
    private final String value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!kotlin.jvm.internal.p.l(this.value, fVar.value) || !kotlin.jvm.internal.p.l(this.qnc, fVar.qnc)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.b.h hVar = this.qnc;
        return hashCode + (hVar != null ? hVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.qnc + ")";
    }

    public f(String str, kotlin.b.h hVar) {
        kotlin.jvm.internal.p.o(str, "value");
        kotlin.jvm.internal.p.o(hVar, "range");
        this.value = str;
        this.qnc = hVar;
    }
}
