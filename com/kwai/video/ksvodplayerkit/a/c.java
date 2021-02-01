package com.kwai.video.ksvodplayerkit.a;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static a f11042a;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, String str2);
    }

    public static void a(a aVar) {
        f11042a = aVar;
    }

    public static void a(String str) {
        a("VP_PLAYFINISHED", str);
    }

    public static void a(String str, String str2) {
        if (f11042a != null) {
            f11042a.a(str, str2);
        } else {
            b.d("LogUploader", "upload logger is null");
        }
    }

    public static void b(String str) {
        a("VP_CDN_RESOURCE", str);
    }
}
