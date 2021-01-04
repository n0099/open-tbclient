package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, a> f13833a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public static n f13834b;
    public static String c;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public k f13835a;

        /* renamed from: b  reason: collision with root package name */
        public int f13836b = 0;

        public a(k kVar) {
            this.f13835a = kVar;
        }
    }

    static {
        f13833a.put("C892BA2", new a(new q()));
        f13833a.put("43780D5", new a(new q()));
        f13833a.put("22792AF", new a(new p()));
        c = "";
        try {
            c = aj.b(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
        } catch (Throwable th) {
        }
    }
}
