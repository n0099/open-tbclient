package org.java_websocket.d;
/* loaded from: classes5.dex */
public class b implements a {
    private final String pOF;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.pOF = str;
    }

    @Override // org.java_websocket.d.a
    public boolean aaF(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.pOF.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eFe() {
        return this.pOF;
    }

    @Override // org.java_websocket.d.a
    public a eFf() {
        return new b(eFe());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eFe();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.pOF.equals(((b) obj).pOF);
    }

    public int hashCode() {
        return this.pOF.hashCode();
    }
}
