package com.facebook.common.e;
/* loaded from: classes6.dex */
public class a {
    private static volatile b oLC = new C0966a();

    /* loaded from: classes6.dex */
    public interface b {
        void loadLibrary(String str);
    }

    /* renamed from: com.facebook.common.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0966a implements b {
        @Override // com.facebook.common.e.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public static void loadLibrary(String str) {
        oLC.loadLibrary(str);
    }
}
