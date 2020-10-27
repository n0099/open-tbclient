package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes12.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ag f4745a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f38a;

    /* renamed from: a  reason: collision with other field name */
    private List<z> f39a = new ArrayList();

    private ag(Context context) {
        this.f38a = context.getApplicationContext();
        if (this.f38a == null) {
            this.f38a = context;
        }
    }

    public static ag a(Context context) {
        if (f4745a == null) {
            synchronized (ag.class) {
                if (f4745a == null) {
                    f4745a = new ag(context);
                }
            }
        }
        return f4745a;
    }

    public int a(String str) {
        int i;
        synchronized (this.f39a) {
            z zVar = new z();
            zVar.f86a = str;
            if (this.f39a.contains(zVar)) {
                for (z zVar2 : this.f39a) {
                    if (zVar2.equals(zVar)) {
                        i = zVar2.f4782a;
                        break;
                    }
                }
            }
            i = 0;
        }
        return i;
    }

    public synchronized String a(av avVar) {
        return this.f38a.getSharedPreferences("mipush_extra", 0).getString(avVar.name(), "");
    }

    public synchronized void a(av avVar, String str) {
        SharedPreferences sharedPreferences = this.f38a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(avVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m73a(String str) {
        synchronized (this.f39a) {
            z zVar = new z();
            zVar.f4782a = 0;
            zVar.f86a = str;
            if (this.f39a.contains(zVar)) {
                this.f39a.remove(zVar);
            }
            this.f39a.add(zVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m74a(String str) {
        boolean z;
        synchronized (this.f39a) {
            z zVar = new z();
            zVar.f86a = str;
            z = this.f39a.contains(zVar);
        }
        return z;
    }

    public void b(String str) {
        z zVar;
        synchronized (this.f39a) {
            z zVar2 = new z();
            zVar2.f86a = str;
            if (this.f39a.contains(zVar2)) {
                Iterator<z> it = this.f39a.iterator();
                while (it.hasNext()) {
                    zVar = it.next();
                    if (zVar2.equals(zVar)) {
                        break;
                    }
                }
            }
            zVar = zVar2;
            zVar.f4782a++;
            this.f39a.remove(zVar);
            this.f39a.add(zVar);
        }
    }

    public void c(String str) {
        synchronized (this.f39a) {
            z zVar = new z();
            zVar.f86a = str;
            if (this.f39a.contains(zVar)) {
                this.f39a.remove(zVar);
            }
        }
    }
}
