package com.kwad.sdk.api.loader;

import java.io.File;
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: com.kwad.sdk.api.loader.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0658a {
        public long Se;
        public transient File Sf;
        public int a;
        public String b;
        public String c;
        public String e;

        public final String toString() {
            return "Data{dynamicType=" + this.a + ", dynamicUrl='" + this.b + "', md5='" + this.c + "', interval=" + this.Se + ", sdkVersion='" + this.e + "', downloadFile=" + this.Sf + '}';
        }
    }

    /* loaded from: classes9.dex */
    public static class b {
        public C0658a Sg;
        public long a;
        public String b;

        public final String toString() {
            return "UpdateData{result=" + this.a + ", errorMsg='" + this.b + "', data=" + this.Sg + '}';
        }
    }
}
