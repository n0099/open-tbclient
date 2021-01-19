package org.java_websocket.d;
/* loaded from: classes4.dex */
public class b implements a {
    private final String qno;

    public b(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }
        this.qno = str;
    }

    @Override // org.java_websocket.d.a
    public boolean abt(String str) {
        for (String str2 : str.replaceAll(" ", "").split(",")) {
            if (this.qno.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.java_websocket.d.a
    public String eKa() {
        return this.qno;
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
        return this.qno.equals(((b) obj).qno);
    }

    public int hashCode() {
        return this.qno.hashCode();
    }
}
