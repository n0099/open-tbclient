package org.java_websocket.d;
/* loaded from: classes4.dex */
public class b implements a {
    private final String qxR;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.qxR = str;
    }

    @Override // org.java_websocket.d.a
    public boolean acG(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.qxR.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eMy() {
        return this.qxR;
    }

    @Override // org.java_websocket.d.a
    public a eMz() {
        return new b(eMy());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eMy();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.qxR.equals(((b) obj).qxR);
    }

    public int hashCode() {
        return this.qxR.hashCode();
    }
}
