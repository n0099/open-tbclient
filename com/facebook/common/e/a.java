package com.facebook.common.e;
/* loaded from: classes3.dex */
public class a {
    private static volatile b ptw = new C1015a();

    /* loaded from: classes3.dex */
    public interface b {
        void loadLibrary(String str);
    }

    /* renamed from: com.facebook.common.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1015a implements b {
        @Override // com.facebook.common.e.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public static void loadLibrary(String str) {
        ptw.loadLibrary(str);
    }
}
