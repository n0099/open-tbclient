package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes18.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ag f4517a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f41a;

    /* renamed from: a  reason: collision with other field name */
    private List<z> f42a = new ArrayList();

    private ag(Context context) {
        this.f41a = context.getApplicationContext();
        if (this.f41a == null) {
            this.f41a = context;
        }
    }

    public static ag a(Context context) {
        if (f4517a == null) {
            synchronized (ag.class) {
                if (f4517a == null) {
                    f4517a = new ag(context);
                }
            }
        }
        return f4517a;
    }

    public int a(String str) {
        int i;
        synchronized (this.f42a) {
            z zVar = new z();
            zVar.f89a = str;
            if (this.f42a.contains(zVar)) {
                for (z zVar2 : this.f42a) {
                    if (zVar2.equals(zVar)) {
                        i = zVar2.f4554a;
                        break;
                    }
                }
            }
            i = 0;
        }
        return i;
    }

    public synchronized String a(av avVar) {
        return this.f41a.getSharedPreferences("mipush_extra", 0).getString(avVar.name(), "");
    }

    public synchronized void a(av avVar, String str) {
        SharedPreferences sharedPreferences = this.f41a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(avVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m66a(String str) {
        synchronized (this.f42a) {
            z zVar = new z();
            zVar.f4554a = 0;
            zVar.f89a = str;
            if (this.f42a.contains(zVar)) {
                this.f42a.remove(zVar);
            }
            this.f42a.add(zVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m67a(String str) {
        boolean z;
        synchronized (this.f42a) {
            z zVar = new z();
            zVar.f89a = str;
            z = this.f42a.contains(zVar);
        }
        return z;
    }

    public void b(String str) {
        z zVar;
        synchronized (this.f42a) {
            z zVar2 = new z();
            zVar2.f89a = str;
            if (this.f42a.contains(zVar2)) {
                Iterator<z> it = this.f42a.iterator();
                while (it.hasNext()) {
                    zVar = it.next();
                    if (zVar2.equals(zVar)) {
                        break;
                    }
                }
            }
            zVar = zVar2;
            zVar.f4554a++;
            this.f42a.remove(zVar);
            this.f42a.add(zVar);
        }
    }

    public void c(String str) {
        synchronized (this.f42a) {
            z zVar = new z();
            zVar.f89a = str;
            if (this.f42a.contains(zVar)) {
                this.f42a.remove(zVar);
            }
        }
    }
}
