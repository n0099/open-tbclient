package org.java_websocket.d;
/* loaded from: classes5.dex */
public class b implements a {
    private final String pOD;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.pOD = str;
    }

    @Override // org.java_websocket.d.a
    public boolean aaF(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.pOD.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eFd() {
        return this.pOD;
    }

    @Override // org.java_websocket.d.a
    public a eFe() {
        return new b(eFd());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eFd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.pOD.equals(((b) obj).pOD);
    }

    public int hashCode() {
        return this.pOD.hashCode();
    }
}
