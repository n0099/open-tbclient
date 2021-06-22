package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.webkit.internal.Base64;
import com.vivo.push.util.h;
import com.vivo.push.util.p;
import com.vivo.push.util.y;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes7.dex */
public abstract class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f40401a = {34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 37, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 41, Base64.INTERNAL_PADDING, 32, 32, 32};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f40402b = {PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, Base64.INTERNAL_PADDING, 34, PublicSuffixDatabase.EXCEPTION_MARKER};

    /* renamed from: c  reason: collision with root package name */
    public static final Object f40403c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public List<T> f40404d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public Context f40405e;

    public d(Context context) {
        this.f40405e = context.getApplicationContext();
        c();
    }

    public abstract String a();

    public abstract List<T> a(String str);

    public abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (f40403c) {
            h.a(a());
            this.f40404d.clear();
            String a2 = y.b(this.f40405e).a(a(), null);
            if (TextUtils.isEmpty(a2)) {
                p.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            } else if (a2.length() > 10000) {
                p.d("CacheSettings", "sync " + a() + " strApps lenght too large");
                d();
            } else {
                try {
                    p.d("CacheSettings", "ClientManager init " + a() + " strApps : " + a2);
                    List<T> a3 = a(b(a2));
                    if (a3 != null) {
                        this.f40404d.addAll(a3);
                    }
                } catch (Exception e2) {
                    d();
                    p.d("CacheSettings", p.a(e2));
                }
            }
        }
    }

    public final void d() {
        synchronized (f40403c) {
            this.f40404d.clear();
            y.b(this.f40405e).b(a(), "");
            p.d("CacheSettings", "clear " + a() + " strApps");
        }
    }
}
