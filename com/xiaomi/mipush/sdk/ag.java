package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ag {
    private static volatile ag a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f46a;

    /* renamed from: a  reason: collision with other field name */
    private List<z> f47a = new ArrayList();

    private ag(Context context) {
        this.f46a = context.getApplicationContext();
        if (this.f46a == null) {
            this.f46a = context;
        }
    }

    public static ag a(Context context) {
        if (a == null) {
            synchronized (ag.class) {
                if (a == null) {
                    a = new ag(context);
                }
            }
        }
        return a;
    }

    public int a(String str) {
        int i;
        synchronized (this.f47a) {
            z zVar = new z();
            zVar.f94a = str;
            if (this.f47a.contains(zVar)) {
                for (z zVar2 : this.f47a) {
                    if (zVar2.equals(zVar)) {
                        i = zVar2.a;
                        break;
                    }
                }
            }
            i = 0;
        }
        return i;
    }

    public synchronized String a(av avVar) {
        return this.f46a.getSharedPreferences("mipush_extra", 0).getString(avVar.name(), "");
    }

    public synchronized void a(av avVar, String str) {
        SharedPreferences sharedPreferences = this.f46a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(avVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m67a(String str) {
        synchronized (this.f47a) {
            z zVar = new z();
            zVar.a = 0;
            zVar.f94a = str;
            if (this.f47a.contains(zVar)) {
                this.f47a.remove(zVar);
            }
            this.f47a.add(zVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m68a(String str) {
        boolean z;
        synchronized (this.f47a) {
            z zVar = new z();
            zVar.f94a = str;
            z = this.f47a.contains(zVar);
        }
        return z;
    }

    public void b(String str) {
        z zVar;
        synchronized (this.f47a) {
            z zVar2 = new z();
            zVar2.f94a = str;
            if (this.f47a.contains(zVar2)) {
                Iterator<z> it = this.f47a.iterator();
                while (it.hasNext()) {
                    zVar = it.next();
                    if (zVar2.equals(zVar)) {
                        break;
                    }
                }
            }
            zVar = zVar2;
            zVar.a++;
            this.f47a.remove(zVar);
            this.f47a.add(zVar);
        }
    }

    public void c(String str) {
        synchronized (this.f47a) {
            z zVar = new z();
            zVar.f94a = str;
            if (this.f47a.contains(zVar)) {
                this.f47a.remove(zVar);
            }
        }
    }
}
