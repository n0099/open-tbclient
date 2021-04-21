package com.kwad.sdk.emotion.b;

import android.text.TextUtils;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f35056a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f35057b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f35058c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f35059d;

    public static b a() {
        if (f35056a == null) {
            synchronized (b.class) {
                if (f35056a == null) {
                    f35056a = new b();
                }
            }
        }
        return f35056a;
    }

    public String a(String str, boolean z) {
        return (z ? this.f35058c : this.f35057b).get(str);
    }

    public void a(String str) {
        File[] listFiles;
        File[] listFiles2;
        this.f35059d = str + File.separator + "message_emoji_resource";
        File file = new File(this.f35059d);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(b());
        if (file2.exists() && file2.isDirectory() && (listFiles2 = file2.listFiles()) != null) {
            for (File file3 : listFiles2) {
                int lastIndexOf = file3.getName().lastIndexOf(46);
                if (lastIndexOf > 0) {
                    this.f35057b.put(file3.getName().substring(0, lastIndexOf), file3.getAbsolutePath());
                }
            }
        }
        File file4 = new File(c());
        if (file4.exists() && file4.isDirectory() && (listFiles = file4.listFiles()) != null) {
            for (File file5 : listFiles) {
                int lastIndexOf2 = file5.getName().lastIndexOf(46);
                if (lastIndexOf2 > 0) {
                    this.f35058c.put(file5.getName().substring(0, lastIndexOf2), file5.getAbsolutePath());
                }
            }
        }
    }

    public void a(String str, String str2, boolean z) {
        Map<String, String> map;
        StringBuilder sb;
        String b2;
        if (z) {
            map = this.f35058c;
            sb = new StringBuilder();
            b2 = c();
        } else {
            map = this.f35057b;
            sb = new StringBuilder();
            b2 = b();
        }
        sb.append(b2);
        sb.append(File.separator);
        sb.append(str2);
        map.put(str, sb.toString());
    }

    public String b() {
        if (TextUtils.isEmpty(this.f35059d)) {
            return "";
        }
        return this.f35059d + File.separator + "small";
    }

    public boolean b(String str, boolean z) {
        return (z ? this.f35058c : this.f35057b).containsKey(str);
    }

    public String c() {
        if (TextUtils.isEmpty(this.f35059d)) {
            return "";
        }
        return this.f35059d + File.separator + "big";
    }
}
