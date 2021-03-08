package com.facebook.common.e;
/* loaded from: classes4.dex */
public class a {
    private static volatile b pBQ = new C1057a();

    /* loaded from: classes4.dex */
    public interface b {
        void loadLibrary(String str);
    }

    /* renamed from: com.facebook.common.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1057a implements b {
        @Override // com.facebook.common.e.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public static void loadLibrary(String str) {
        pBQ.loadLibrary(str);
    }
}
