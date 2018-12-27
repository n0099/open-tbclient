package org.java_websocket.d;
/* loaded from: classes2.dex */
public class b implements a {
    private final String iDI;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.iDI = str;
    }

    @Override // org.java_websocket.d.a
    public boolean zR(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.iDI.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cdy() {
        return this.iDI;
    }

    @Override // org.java_websocket.d.a
    public a cdz() {
        return new b(cdy());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cdy();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.iDI.equals(((b) obj).iDI);
    }

    public int hashCode() {
        return this.iDI.hashCode();
    }
}
