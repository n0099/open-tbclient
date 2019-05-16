package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ap {
    private static volatile ap a = null;
    private Context b;
    private List<ad> c = new ArrayList();

    private ap(Context context) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
    }

    public static ap a(Context context) {
        if (a == null) {
            synchronized (ap.class) {
                if (a == null) {
                    a = new ap(context);
                }
            }
        }
        return a;
    }

    public synchronized String a(be beVar) {
        return this.b.getSharedPreferences("mipush_extra", 0).getString(beVar.name(), "");
    }

    public synchronized void a(be beVar, String str) {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(beVar.name(), str).commit();
    }

    public void a(String str) {
        synchronized (this.c) {
            ad adVar = new ad();
            adVar.a = 0;
            adVar.b = str;
            if (this.c.contains(adVar)) {
                this.c.remove(adVar);
            }
            this.c.add(adVar);
        }
    }

    public void b(String str) {
        ad adVar;
        synchronized (this.c) {
            ad adVar2 = new ad();
            adVar2.b = str;
            if (this.c.contains(adVar2)) {
                Iterator<ad> it = this.c.iterator();
                while (it.hasNext()) {
                    adVar = it.next();
                    if (adVar2.equals(adVar)) {
                        break;
                    }
                }
            }
            adVar = adVar2;
            adVar.a++;
            this.c.remove(adVar);
            this.c.add(adVar);
        }
    }

    public int c(String str) {
        int i;
        synchronized (this.c) {
            ad adVar = new ad();
            adVar.b = str;
            if (this.c.contains(adVar)) {
                for (ad adVar2 : this.c) {
                    if (adVar2.equals(adVar)) {
                        i = adVar2.a;
                        break;
                    }
                }
            }
            i = 0;
        }
        return i;
    }

    public void d(String str) {
        synchronized (this.c) {
            ad adVar = new ad();
            adVar.b = str;
            if (this.c.contains(adVar)) {
                this.c.remove(adVar);
            }
        }
    }

    public boolean e(String str) {
        boolean z;
        synchronized (this.c) {
            ad adVar = new ad();
            adVar.b = str;
            z = this.c.contains(adVar);
        }
        return z;
    }
}
