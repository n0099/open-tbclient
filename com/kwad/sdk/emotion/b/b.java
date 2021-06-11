package com.kwad.sdk.emotion.b;

import android.text.TextUtils;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f35329a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f35330b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f35331c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f35332d;

    public static b a() {
        if (f35329a == null) {
            synchronized (b.class) {
                if (f35329a == null) {
                    f35329a = new b();
                }
            }
        }
        return f35329a;
    }

    public String a(String str, boolean z) {
        return (z ? this.f35331c : this.f35330b).get(str);
    }

    public void a(String str) {
        File[] listFiles;
        File[] listFiles2;
        this.f35332d = str + File.separator + "message_emoji_resource";
        File file = new File(this.f35332d);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(b());
        if (file2.exists() && file2.isDirectory() && (listFiles2 = file2.listFiles()) != null) {
            for (File file3 : listFiles2) {
                int lastIndexOf = file3.getName().lastIndexOf(46);
                if (lastIndexOf > 0) {
                    this.f35330b.put(file3.getName().substring(0, lastIndexOf), file3.getAbsolutePath());
                }
            }
        }
        File file4 = new File(c());
        if (file4.exists() && file4.isDirectory() && (listFiles = file4.listFiles()) != null) {
            for (File file5 : listFiles) {
                int lastIndexOf2 = file5.getName().lastIndexOf(46);
                if (lastIndexOf2 > 0) {
                    this.f35331c.put(file5.getName().substring(0, lastIndexOf2), file5.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, String str2, boolean z) {
        Map<String, String> map;
        StringBuilder sb;
        String b2;
        if (z) {
            map = this.f35331c;
            sb = new StringBuilder();
            b2 = c();
        } else {
            map = this.f35330b;
            sb = new StringBuilder();
            b2 = b();
        }
        sb.append(b2);
        sb.append(File.separator);
        sb.append(str2);
        map.put(str, sb.toString());
    }

    public String b() {
        if (TextUtils.isEmpty(this.f35332d)) {
            return "";
        }
        return this.f35332d + File.separator + "small";
    }

    public boolean b(String str, boolean z) {
        return (z ? this.f35331c : this.f35330b).containsKey(str);
    }

    public String c() {
        if (TextUtils.isEmpty(this.f35332d)) {
            return "";
        }
        return this.f35332d + File.separator + "big";
    }
}
