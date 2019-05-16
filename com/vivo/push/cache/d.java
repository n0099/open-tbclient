package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.m;
import com.vivo.push.util.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class d<T> {
    protected static final Object a = new Object();
    private static int d = 10000;
    protected List<T> b = new ArrayList();
    protected Context c;

    protected abstract String a();

    protected abstract String a(List<T> list);

    protected abstract List<T> a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Context context) {
        this.c = context.getApplicationContext();
        c();
    }

    public final void c() {
        synchronized (a) {
            com.vivo.push.util.e.a(a());
            this.b.clear();
            String a2 = v.b(this.c).a(a(), null);
            if (TextUtils.isEmpty(a2)) {
                m.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            } else if (a2.length() > d) {
                m.d("CacheSettings", "sync " + a() + " strApps lenght too large");
                d();
            } else {
                try {
                    m.d("CacheSettings", "ClientManager init " + a() + " strApps : " + a2);
                    List<T> a3 = a(new String(com.vivo.push.util.d.b("2015120111293000", "1234567890654321", Base64.decode(a2, 0)), "utf-8"));
                    if (a3 != null) {
                        this.b.addAll(a3);
                    }
                } catch (Exception e) {
                    m.d("CacheSettings", m.a(e));
                }
            }
        }
    }

    public final void a(T t) {
        synchronized (a) {
            Iterator<T> it = this.b.iterator();
            while (it.hasNext()) {
                if (t.equals(it.next())) {
                    it.remove();
                }
            }
            this.b.add(t);
            b(this.b);
        }
    }

    public final String b(List<T> list) {
        String str = null;
        String a2 = a((List) list);
        try {
            String encodeToString = Base64.encodeToString(com.vivo.push.util.d.a("2015120111293000", "1234567890654321", a2.getBytes("utf-8")), 0);
            if (!TextUtils.isEmpty(encodeToString) && encodeToString.length() > d) {
                m.d("CacheSettings", "sync " + a() + " strApps lenght too large");
                d();
            } else {
                m.d("CacheSettings", "sync " + a() + " strApps: " + encodeToString);
                v.b(this.c).b(a(), encodeToString);
                str = a2;
            }
        } catch (Exception e) {
            m.d("CacheSettings", m.a(e));
            d();
        }
        return str;
    }

    public final void d() {
        synchronized (a) {
            this.b.clear();
            v.b(this.c).b(a(), "");
            m.d("CacheSettings", "clear " + a() + " strApps");
        }
    }
}
