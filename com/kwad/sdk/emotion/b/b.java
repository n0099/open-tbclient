package com.kwad.sdk.emotion.b;

import android.text.TextUtils;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f9745a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f9746b = new ConcurrentHashMap();
    private Map<String, String> c = new ConcurrentHashMap();
    private String d;

    private b() {
    }

    public static b a() {
        if (f9745a == null) {
            synchronized (b.class) {
                if (f9745a == null) {
                    f9745a = new b();
                }
            }
        }
        return f9745a;
    }

    public String a(String str, boolean z) {
        return z ? this.c.get(str) : this.f9746b.get(str);
    }

    public void a(String str) {
        File[] listFiles;
        File[] listFiles2;
        this.d = str + File.separator + "message_emoji_resource";
        File file = new File(this.d);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(b());
        if (file2.exists() && file2.isDirectory() && (listFiles2 = file2.listFiles()) != null) {
            for (File file3 : listFiles2) {
                int lastIndexOf = file3.getName().lastIndexOf(46);
                if (lastIndexOf > 0) {
                    this.f9746b.put(file3.getName().substring(0, lastIndexOf), file3.getAbsolutePath());
                }
            }
        }
        File file4 = new File(c());
        if (file4.exists() && file4.isDirectory() && (listFiles = file4.listFiles()) != null) {
            for (File file5 : listFiles) {
                int lastIndexOf2 = file5.getName().lastIndexOf(46);
                if (lastIndexOf2 > 0) {
                    this.c.put(file5.getName().substring(0, lastIndexOf2), file5.getAbsolutePath());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, boolean z) {
        if (z) {
            this.c.put(str, c() + File.separator + str2);
        } else {
            this.f9746b.put(str, b() + File.separator + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return TextUtils.isEmpty(this.d) ? "" : this.d + File.separator + "small";
    }

    public boolean b(String str, boolean z) {
        return z ? this.c.containsKey(str) : this.f9746b.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return TextUtils.isEmpty(this.d) ? "" : this.d + File.separator + "big";
    }
}
