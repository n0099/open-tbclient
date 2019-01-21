package kotlin.text;
/* loaded from: classes2.dex */
public final class e {
    private final kotlin.b.c iDj;
    private final String value;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (!kotlin.jvm.internal.p.h(this.value, eVar.value) || !kotlin.jvm.internal.p.h(this.iDj, eVar.iDj)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.value;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.b.c cVar = this.iDj;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.value + ", range=" + this.iDj + ")";
    }

    public e(String str, kotlin.b.c cVar) {
        kotlin.jvm.internal.p.j(str, "value");
        kotlin.jvm.internal.p.j(cVar, "range");
        this.value = str;
        this.iDj = cVar;
    }
}
