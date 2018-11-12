package org.java_websocket.d;
/* loaded from: classes2.dex */
public class b implements a {
    private final String ito;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.ito = str;
    }

    @Override // org.java_websocket.d.a
    public boolean zl(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.ito.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String caC() {
        return this.ito;
    }

    @Override // org.java_websocket.d.a
    public a caD() {
        return new b(caC());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return caC();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.ito.equals(((b) obj).ito);
    }

    public int hashCode() {
        return this.ito.hashCode();
    }
}
