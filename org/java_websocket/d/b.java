package org.java_websocket.d;
/* loaded from: classes4.dex */
public class b implements a {
    private final String qxr;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.qxr = str;
    }

    @Override // org.java_websocket.d.a
    public boolean acu(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.qxr.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eMq() {
        return this.qxr;
    }

    @Override // org.java_websocket.d.a
    public a eMr() {
        return new b(eMq());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eMq();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.qxr.equals(((b) obj).qxr);
    }

    public int hashCode() {
        return this.qxr.hashCode();
    }
}
