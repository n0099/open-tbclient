package com.facebook.common.e;
/* loaded from: classes17.dex */
public class a {
    private static volatile b nvx = new C0857a();

    /* loaded from: classes17.dex */
    public interface b {
        void loadLibrary(String str);
    }

    /* renamed from: com.facebook.common.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static class C0857a implements b {
        @Override // com.facebook.common.e.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public static void loadLibrary(String str) {
        nvx.loadLibrary(str);
    }
}
