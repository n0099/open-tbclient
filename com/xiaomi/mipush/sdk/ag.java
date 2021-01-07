package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ag f14101a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f120a;

    /* renamed from: a  reason: collision with other field name */
    private List<z> f121a = new ArrayList();

    private ag(Context context) {
        this.f120a = context.getApplicationContext();
        if (this.f120a == null) {
            this.f120a = context;
        }
    }

    public static ag a(Context context) {
        if (f14101a == null) {
            synchronized (ag.class) {
                if (f14101a == null) {
                    f14101a = new ag(context);
                }
            }
        }
        return f14101a;
    }

    public int a(String str) {
        int i;
        synchronized (this.f121a) {
            z zVar = new z();
            zVar.f168a = str;
            if (this.f121a.contains(zVar)) {
                for (z zVar2 : this.f121a) {
                    if (zVar2.equals(zVar)) {
                        i = zVar2.f14145a;
                        break;
                    }
                }
            }
            i = 0;
        }
        return i;
    }

    public synchronized String a(av avVar) {
        return this.f120a.getSharedPreferences("mipush_extra", 0).getString(avVar.name(), "");
    }

    public synchronized void a(av avVar, String str) {
        SharedPreferences sharedPreferences = this.f120a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(avVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m103a(String str) {
        synchronized (this.f121a) {
            z zVar = new z();
            zVar.f14145a = 0;
            zVar.f168a = str;
            if (this.f121a.contains(zVar)) {
                this.f121a.remove(zVar);
            }
            this.f121a.add(zVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m104a(String str) {
        boolean z;
        synchronized (this.f121a) {
            z zVar = new z();
            zVar.f168a = str;
            z = this.f121a.contains(zVar);
        }
        return z;
    }

    public void b(String str) {
        z zVar;
        synchronized (this.f121a) {
            z zVar2 = new z();
            zVar2.f168a = str;
            if (this.f121a.contains(zVar2)) {
                Iterator<z> it = this.f121a.iterator();
                while (it.hasNext()) {
                    zVar = it.next();
                    if (zVar2.equals(zVar)) {
                        break;
                    }
                }
            }
            zVar = zVar2;
            zVar.f14145a++;
            this.f121a.remove(zVar);
            this.f121a.add(zVar);
        }
    }

    public void c(String str) {
        synchronized (this.f121a) {
            z zVar = new z();
            zVar.f168a = str;
            if (this.f121a.contains(zVar)) {
                this.f121a.remove(zVar);
            }
        }
    }
}
