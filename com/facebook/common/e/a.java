package com.facebook.common.e;
/* loaded from: classes6.dex */
public class a {
    private static volatile b pzL = new C1042a();

    /* loaded from: classes6.dex */
    public interface b {
        void loadLibrary(String str);
    }

    /* renamed from: com.facebook.common.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1042a implements b {
        @Override // com.facebook.common.e.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public static void loadLibrary(String str) {
        pzL.loadLibrary(str);
    }
}
