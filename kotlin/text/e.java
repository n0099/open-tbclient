package kotlin.text;
/* loaded from: classes2.dex */
public final class e {
    private final kotlin.b.c kvI;
    private final String value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (!kotlin.jvm.internal.p.f(this.value, eVar.value) || !kotlin.jvm.internal.p.f(this.kvI, eVar.kvI)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.b.c cVar = this.kvI;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.kvI + ")";
    }

    public e(String str, kotlin.b.c cVar) {
        kotlin.jvm.internal.p.i(str, "value");
        kotlin.jvm.internal.p.i(cVar, "range");
        this.value = str;
        this.kvI = cVar;
    }
}
