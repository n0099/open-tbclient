package com.facebook.common.e;
/* loaded from: classes2.dex */
public class a {
    private static volatile b kaJ = new C0554a();

    /* loaded from: classes2.dex */
    public interface b {
        void loadLibrary(String str);
    }

    /* renamed from: com.facebook.common.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0554a implements b {
        @Override // com.facebook.common.e.a.b
        public void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public static void loadLibrary(String str) {
        kaJ.loadLibrary(str);
    }
}
