package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes18.dex */
public class ag {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ag f4747a = null;

    /* renamed from: a  reason: collision with other field name */
    private Context f43a;

    /* renamed from: a  reason: collision with other field name */
    private List<z> f44a = new ArrayList();

    private ag(Context context) {
        this.f43a = context.getApplicationContext();
        if (this.f43a == null) {
            this.f43a = context;
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
        synchronized (this.f44a) {
            z zVar = new z();
            zVar.f91a = str;
            if (this.f44a.contains(zVar)) {
                for (z zVar2 : this.f44a) {
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
        return this.f43a.getSharedPreferences("mipush_extra", 0).getString(avVar.name(), "");
    }

    public synchronized void a(av avVar, String str) {
        SharedPreferences sharedPreferences = this.f43a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(avVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m76a(String str) {
        synchronized (this.f44a) {
            z zVar = new z();
            zVar.f4784a = 0;
            zVar.f91a = str;
            if (this.f44a.contains(zVar)) {
                this.f44a.remove(zVar);
            }
            this.f44a.add(zVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m77a(String str) {
        boolean z;
        synchronized (this.f44a) {
            z zVar = new z();
            zVar.f91a = str;
            z = this.f44a.contains(zVar);
        }
        return z;
    }

    public void b(String str) {
        z zVar;
        synchronized (this.f44a) {
            z zVar2 = new z();
            zVar2.f91a = str;
            if (this.f44a.contains(zVar2)) {
                Iterator<z> it = this.f44a.iterator();
                while (it.hasNext()) {
                    zVar = it.next();
                    if (zVar2.equals(zVar)) {
                        break;
                    }
                }
            }
            zVar = zVar2;
            zVar.f4784a++;
            this.f44a.remove(zVar);
            this.f44a.add(zVar);
        }
    }

    public void c(String str) {
        synchronized (this.f44a) {
            z zVar = new z();
            zVar.f91a = str;
            if (this.f44a.contains(zVar)) {
                this.f44a.remove(zVar);
            }
        }
    }
}
