package org.java_websocket.d;
/* loaded from: classes4.dex */
public class b implements a {
    private final String qyt;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.qyt = str;
    }

    @Override // org.java_websocket.d.a
    public boolean acF(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.qyt.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eMg() {
        return this.qyt;
    }

    @Override // org.java_websocket.d.a
    public a eMh() {
        return new b(eMg());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eMg();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.qyt.equals(((b) obj).qyt);
    }

    public int hashCode() {
        return this.qyt.hashCode();
    }
}
