package org.java_websocket.d;
/* loaded from: classes2.dex */
public class b implements a {
    private final String irE;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.irE = str;
    }

    @Override // org.java_websocket.d.a
    public boolean zg(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.irE.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String cbf() {
        return this.irE;
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
        return this.irE.equals(((b) obj).irE);
    }

    public int hashCode() {
        return this.irE.hashCode();
    }
}
