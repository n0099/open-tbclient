package com.kwad.components.core.e.b;
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: com.kwad.components.core.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0641a {
        public static final c Ka = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long ac(String str) {
        return nf().ad(str);
    }

    public static String t(long j) {
        String u = nf().u(j);
        if (u.endsWith("=")) {
            return u.replace("=", "");
        }
        return u;
    }

    public static c nf() {
        return C0641a.Ka;
    }
}
