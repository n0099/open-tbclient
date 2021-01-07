package org.java_websocket.d;
/* loaded from: classes4.dex */
public class b implements a {
    private final String qrP;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.qrP = str;
    }

    @Override // org.java_websocket.d.a
    public boolean acA(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.qrP.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eNQ() {
        return this.qrP;
    }

    @Override // org.java_websocket.d.a
    public a eNR() {
        return new b(eNQ());
    }

    @Override // org.java_websocket.d.a
    public String toString() {
        return eNQ();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.qrP.equals(((b) obj).qrP);
    }

    public int hashCode() {
        return this.qrP.hashCode();
    }
}
