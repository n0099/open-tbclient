package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ag f14100a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f119a;

    /* renamed from: a  reason: collision with other field name */
    private List<z> f120a = new ArrayList();

    private ag(Context context) {
        this.f119a = context.getApplicationContext();
        if (this.f119a == null) {
            this.f119a = context;
        }
    }

    public static ag a(Context context) {
        if (f14100a == null) {
            synchronized (ag.class) {
                if (f14100a == null) {
                    f14100a = new ag(context);
                }
            }
        }
        return f14100a;
    }

    public int a(String str) {
        int i;
        synchronized (this.f120a) {
            z zVar = new z();
            zVar.f167a = str;
            if (this.f120a.contains(zVar)) {
                for (z zVar2 : this.f120a) {
                    if (zVar2.equals(zVar)) {
                        i = zVar2.f14144a;
                        break;
                    }
                }
            }
            i = 0;
        }
        return i;
    }

    public synchronized String a(av avVar) {
        return this.f119a.getSharedPreferences("mipush_extra", 0).getString(avVar.name(), "");
    }

    public synchronized void a(av avVar, String str) {
        SharedPreferences sharedPreferences = this.f119a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(avVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m92a(String str) {
        synchronized (this.f120a) {
            z zVar = new z();
            zVar.f14144a = 0;
            zVar.f167a = str;
            if (this.f120a.contains(zVar)) {
                this.f120a.remove(zVar);
            }
            this.f120a.add(zVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m93a(String str) {
        boolean z;
        synchronized (this.f120a) {
            z zVar = new z();
            zVar.f167a = str;
            z = this.f120a.contains(zVar);
        }
        return z;
    }

    public void b(String str) {
        z zVar;
        synchronized (this.f120a) {
            z zVar2 = new z();
            zVar2.f167a = str;
            if (this.f120a.contains(zVar2)) {
                Iterator<z> it = this.f120a.iterator();
                while (it.hasNext()) {
                    zVar = it.next();
                    if (zVar2.equals(zVar)) {
                        break;
                    }
                }
            }
            zVar = zVar2;
            zVar.f14144a++;
            this.f120a.remove(zVar);
            this.f120a.add(zVar);
        }
    }

    public void c(String str) {
        synchronized (this.f120a) {
            z zVar = new z();
            zVar.f167a = str;
            if (this.f120a.contains(zVar)) {
                this.f120a.remove(zVar);
            }
        }
    }
}
