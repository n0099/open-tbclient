package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class ao {
    private static volatile ao a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f37a;

    /* renamed from: a  reason: collision with other field name */
    private List<ab> f38a = new ArrayList();

    private ao(Context context) {
        this.f37a = context.getApplicationContext();
        if (this.f37a == null) {
            this.f37a = context;
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
        synchronized (this.f38a) {
            ab abVar = new ab();
            abVar.f33a = str;
            if (this.f38a.contains(abVar)) {
                for (ab abVar2 : this.f38a) {
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
        return this.f37a.getSharedPreferences("mipush_extra", 0).getString(bdVar.name(), "");
    }

    public synchronized void a(bd bdVar, String str) {
        SharedPreferences sharedPreferences = this.f37a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(bdVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m65a(String str) {
        synchronized (this.f38a) {
            ab abVar = new ab();
            abVar.a = 0;
            abVar.f33a = str;
            if (this.f38a.contains(abVar)) {
                this.f38a.remove(abVar);
            }
            this.f38a.add(abVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m66a(String str) {
        boolean z;
        synchronized (this.f38a) {
            ab abVar = new ab();
            abVar.f33a = str;
            z = this.f38a.contains(abVar);
        }
        return z;
    }

    public void b(String str) {
        ab abVar;
        synchronized (this.f38a) {
            ab abVar2 = new ab();
            abVar2.f33a = str;
            if (this.f38a.contains(abVar2)) {
                Iterator<ab> it = this.f38a.iterator();
                while (it.hasNext()) {
                    abVar = it.next();
                    if (abVar2.equals(abVar)) {
                        break;
                    }
                }
            }
            abVar = abVar2;
            abVar.a++;
            this.f38a.remove(abVar);
            this.f38a.add(abVar);
        }
    }

    public void c(String str) {
        synchronized (this.f38a) {
            ab abVar = new ab();
            abVar.f33a = str;
            if (this.f38a.contains(abVar)) {
                this.f38a.remove(abVar);
            }
        }
    }
}
