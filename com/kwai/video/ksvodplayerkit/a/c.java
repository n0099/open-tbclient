package com.kwai.video.ksvodplayerkit.a;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static a f37613a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2);
    }

    public static void a(a aVar) {
        f37613a = aVar;
    }

    public static void a(String str) {
        a("VP_PLAYFINISHED", str);
    }

    public static void a(String str, String str2) {
        a aVar = f37613a;
        if (aVar != null) {
            aVar.a(str, str2);
        } else {
            b.d("LogUploader", "upload logger is null");
        }
    }

    public static void b(String str) {
        a("VP_CDN_RESOURCE", str);
    }
}
