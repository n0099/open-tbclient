package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ag f4747a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f40a;

    /* renamed from: a  reason: collision with other field name */
    private List<z> f41a = new ArrayList();

    private ag(Context context) {
        this.f40a = context.getApplicationContext();
        if (this.f40a == null) {
            this.f40a = context;
        }
    }

    public static ag a(Context context) {
        if (f4747a == null) {
            synchronized (ag.class) {
                if (f4747a == null) {
                    f4747a = new ag(context);
                }
            }
        }
        return f4747a;
    }

    public int a(String str) {
        int i;
        synchronized (this.f41a) {
            z zVar = new z();
            zVar.f88a = str;
            if (this.f41a.contains(zVar)) {
                for (z zVar2 : this.f41a) {
                    if (zVar2.equals(zVar)) {
                        i = zVar2.f4784a;
                        break;
                    }
                }
            }
            i = 0;
        }
        return i;
    }

    public synchronized String a(av avVar) {
        return this.f40a.getSharedPreferences("mipush_extra", 0).getString(avVar.name(), "");
    }

    public synchronized void a(av avVar, String str) {
        SharedPreferences sharedPreferences = this.f40a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(avVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m73a(String str) {
        synchronized (this.f41a) {
            z zVar = new z();
            zVar.f4784a = 0;
            zVar.f88a = str;
            if (this.f41a.contains(zVar)) {
                this.f41a.remove(zVar);
            }
            this.f41a.add(zVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m74a(String str) {
        boolean z;
        synchronized (this.f41a) {
            z zVar = new z();
            zVar.f88a = str;
            z = this.f41a.contains(zVar);
        }
        return z;
    }

    public void b(String str) {
        z zVar;
        synchronized (this.f41a) {
            z zVar2 = new z();
            zVar2.f88a = str;
            if (this.f41a.contains(zVar2)) {
                Iterator<z> it = this.f41a.iterator();
                while (it.hasNext()) {
                    zVar = it.next();
                    if (zVar2.equals(zVar)) {
                        break;
                    }
                }
            }
            zVar = zVar2;
            zVar.f4784a++;
            this.f41a.remove(zVar);
            this.f41a.add(zVar);
        }
    }

    public void c(String str) {
        synchronized (this.f41a) {
            z zVar = new z();
            zVar.f88a = str;
            if (this.f41a.contains(zVar)) {
                this.f41a.remove(zVar);
            }
        }
    }
}
