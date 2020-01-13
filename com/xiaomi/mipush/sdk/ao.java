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
    private Context f39a;

    /* renamed from: a  reason: collision with other field name */
    private List<ab> f40a = new ArrayList();

    private ao(Context context) {
        this.f39a = context.getApplicationContext();
        if (this.f39a == null) {
            this.f39a = context;
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
        synchronized (this.f40a) {
            ab abVar = new ab();
            abVar.f35a = str;
            if (this.f40a.contains(abVar)) {
                for (ab abVar2 : this.f40a) {
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
        return this.f39a.getSharedPreferences("mipush_extra", 0).getString(bdVar.name(), "");
    }

    public synchronized void a(bd bdVar, String str) {
        SharedPreferences sharedPreferences = this.f39a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(bdVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m57a(String str) {
        synchronized (this.f40a) {
            ab abVar = new ab();
            abVar.a = 0;
            abVar.f35a = str;
            if (this.f40a.contains(abVar)) {
                this.f40a.remove(abVar);
            }
            this.f40a.add(abVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m58a(String str) {
        boolean z;
        synchronized (this.f40a) {
            ab abVar = new ab();
            abVar.f35a = str;
            z = this.f40a.contains(abVar);
        }
        return z;
    }

    public void b(String str) {
        ab abVar;
        synchronized (this.f40a) {
            ab abVar2 = new ab();
            abVar2.f35a = str;
            if (this.f40a.contains(abVar2)) {
                Iterator<ab> it = this.f40a.iterator();
                while (it.hasNext()) {
                    abVar = it.next();
                    if (abVar2.equals(abVar)) {
                        break;
                    }
                }
            }
            abVar = abVar2;
            abVar.a++;
            this.f40a.remove(abVar);
            this.f40a.add(abVar);
        }
    }

    public void c(String str) {
        synchronized (this.f40a) {
            ab abVar = new ab();
            abVar.f35a = str;
            if (this.f40a.contains(abVar)) {
                this.f40a.remove(abVar);
            }
        }
    }
}
