package org.java_websocket.d;
/* loaded from: classes4.dex */
public class b implements a {
    private final String qnn;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.qnn = str;
    }

    @Override // org.java_websocket.d.a
    public boolean abs(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.qnn.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eKa() {
        return this.qnn;
    }

    @Override // org.java_websocket.d.a
    public a eKb() {
        return new b(eKa());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eKa();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.qnn.equals(((b) obj).qnn);
    }

    public int hashCode() {
        return this.qnn.hashCode();
    }
}
