package org.java_websocket.d;
/* loaded from: classes2.dex */
public class b implements a {
    private final String iEP;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.iEP = str;
    }

    @Override // org.java_websocket.d.a
    public boolean Ah(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.iEP.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String ceg() {
        return this.iEP;
    }

    @Override // org.java_websocket.d.a
    public a ceh() {
        return new b(ceg());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return ceg();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.iEP.equals(((b) obj).iEP);
    }

    public int hashCode() {
        return this.iEP.hashCode();
    }
}
