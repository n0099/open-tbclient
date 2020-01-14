package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ao {
    private static volatile ao a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f40a;

    /* renamed from: a  reason: collision with other field name */
    private List<ab> f41a = new ArrayList();

    private ao(Context context) {
        this.f40a = context.getApplicationContext();
        if (this.f40a == null) {
            this.f40a = context;
        }
    }

    public static ao a(Context context) {
        if (a == null) {
            synchronized (ao.class) {
                if (a == null) {
                    a = new ao(context);
                }
            }
        }
        return a;
    }

    public int a(String str) {
        int i;
        synchronized (this.f41a) {
            ab abVar = new ab();
            abVar.f36a = str;
            if (this.f41a.contains(abVar)) {
                for (ab abVar2 : this.f41a) {
                    if (abVar2.equals(abVar)) {
                        i = abVar2.a;
                        break;
                    }
                }
            }
            i = 0;
        }
        return i;
    }

    public synchronized String a(bd bdVar) {
        return this.f40a.getSharedPreferences("mipush_extra", 0).getString(bdVar.name(), "");
    }

    public synchronized void a(bd bdVar, String str) {
        SharedPreferences sharedPreferences = this.f40a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(bdVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m57a(String str) {
        synchronized (this.f41a) {
            ab abVar = new ab();
            abVar.a = 0;
            abVar.f36a = str;
            if (this.f41a.contains(abVar)) {
                this.f41a.remove(abVar);
            }
            this.f41a.add(abVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m58a(String str) {
        boolean z;
        synchronized (this.f41a) {
            ab abVar = new ab();
            abVar.f36a = str;
            z = this.f41a.contains(abVar);
        }
        return z;
    }

    public void b(String str) {
        ab abVar;
        synchronized (this.f41a) {
            ab abVar2 = new ab();
            abVar2.f36a = str;
            if (this.f41a.contains(abVar2)) {
                Iterator<ab> it = this.f41a.iterator();
                while (it.hasNext()) {
                    abVar = it.next();
                    if (abVar2.equals(abVar)) {
                        break;
                    }
                }
            }
            abVar = abVar2;
            abVar.a++;
            this.f41a.remove(abVar);
            this.f41a.add(abVar);
        }
    }

    public void c(String str) {
        synchronized (this.f41a) {
            ab abVar = new ab();
            abVar.f36a = str;
            if (this.f41a.contains(abVar)) {
                this.f41a.remove(abVar);
            }
        }
    }
}
