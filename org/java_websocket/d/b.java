package org.java_websocket.d;
/* loaded from: classes2.dex */
public class b implements a {
    private final String irD;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.irD = str;
    }

    @Override // org.java_websocket.d.a
    public boolean zg(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.irD.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cbf() {
        return this.irD;
    }

    @Override // org.java_websocket.d.a
    public a cbg() {
        return new b(cbf());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return cbf();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.irD.equals(((b) obj).irD);
    }

    public int hashCode() {
        return this.irD.hashCode();
    }
}
