package com.facebook.common.e;
/* loaded from: classes9.dex */
public class a {
    private static volatile b nlx = new C0860a();

    /* loaded from: classes9.dex */
    public interface b {
        void loadLibrary(String str);
    }

    /* renamed from: com.facebook.common.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0860a implements b {
        @Override // com.facebook.common.e.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public static void loadLibrary(String str) {
        nlx.loadLibrary(str);
    }
}
