package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ao {
    private static volatile ao a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f36a;

    /* renamed from: a  reason: collision with other field name */
    private List<ab> f37a = new ArrayList();

    private ao(Context context) {
        this.f36a = context.getApplicationContext();
        if (this.f36a == null) {
            this.f36a = context;
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
        synchronized (this.f37a) {
            ab abVar = new ab();
            abVar.f32a = str;
            if (this.f37a.contains(abVar)) {
                for (ab abVar2 : this.f37a) {
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
        return this.f36a.getSharedPreferences("mipush_extra", 0).getString(bdVar.name(), "");
    }

    public synchronized void a(bd bdVar, String str) {
        SharedPreferences sharedPreferences = this.f36a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(bdVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m45a(String str) {
        synchronized (this.f37a) {
            ab abVar = new ab();
            abVar.a = 0;
            abVar.f32a = str;
            if (this.f37a.contains(abVar)) {
                this.f37a.remove(abVar);
            }
            this.f37a.add(abVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m46a(String str) {
        boolean z;
        synchronized (this.f37a) {
            ab abVar = new ab();
            abVar.f32a = str;
            z = this.f37a.contains(abVar);
        }
        return z;
    }

    public void b(String str) {
        ab abVar;
        synchronized (this.f37a) {
            ab abVar2 = new ab();
            abVar2.f32a = str;
            if (this.f37a.contains(abVar2)) {
                Iterator<ab> it = this.f37a.iterator();
                while (it.hasNext()) {
                    abVar = it.next();
                    if (abVar2.equals(abVar)) {
                        break;
                    }
                }
            }
            abVar = abVar2;
            abVar.a++;
            this.f37a.remove(abVar);
            this.f37a.add(abVar);
        }
    }

    public void c(String str) {
        synchronized (this.f37a) {
            ab abVar = new ab();
            abVar.f32a = str;
            if (this.f37a.contains(abVar)) {
                this.f37a.remove(abVar);
            }
        }
    }
}
