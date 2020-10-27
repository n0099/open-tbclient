package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.h;
import com.vivo.push.util.p;
import com.vivo.push.util.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public abstract class d<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f4671a = {34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, 41, 35, 32, 32, 32};
    public static final byte[] b = {33, 34, 35, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, 35, 34, 33};
    protected static final Object c = new Object();
    protected List<T> d = new ArrayList();
    protected Context e;

    protected abstract String a();

    protected abstract List<T> a(String str);

    abstract String b(String str) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        this.e = context.getApplicationContext();
        c();
    }

    public final void c() {
        synchronized (c) {
            h.a(a());
            this.d.clear();
            String a2 = y.b(this.e).a(a(), null);
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
                        this.d.addAll(a3);
                    }
                } catch (Exception e) {
                    d();
                    p.d("CacheSettings", p.a(e));
                }
            }
        }
    }

    public final void d() {
        synchronized (c) {
            this.d.clear();
            y.b(this.e).b(a(), "");
            p.d("CacheSettings", "clear " + a() + " strApps");
        }
    }
}
