package com.facebook.common.e;
/* loaded from: classes12.dex */
public class a {
    private static volatile b oNg = new C0969a();

    /* loaded from: classes12.dex */
    public interface b {
        void loadLibrary(String str);
    }

    /* renamed from: com.facebook.common.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0969a implements b {
        @Override // com.facebook.common.e.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public static void loadLibrary(String str) {
        oNg.loadLibrary(str);
    }
}
