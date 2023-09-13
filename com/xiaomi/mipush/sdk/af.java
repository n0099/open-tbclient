package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class af {
    public static volatile af a;

    /* renamed from: a  reason: collision with other field name */
    public Context f49a;

    /* renamed from: a  reason: collision with other field name */
    public List<x> f50a = new ArrayList();

    public af(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f49a = applicationContext;
        if (applicationContext == null) {
            this.f49a = context;
        }
    }

    public static af a(Context context) {
        if (a == null) {
            synchronized (af.class) {
                if (a == null) {
                    a = new af(context);
                }
            }
        }
        return a;
    }

    public int a(String str) {
        synchronized (this.f50a) {
            x xVar = new x();
            xVar.f90a = str;
            if (this.f50a.contains(xVar)) {
                for (x xVar2 : this.f50a) {
                    if (xVar2.equals(xVar)) {
                        return xVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(au auVar) {
        return this.f49a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
    }

    public synchronized void a(au auVar, String str) {
        SharedPreferences sharedPreferences = this.f49a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(auVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m202a(String str) {
        synchronized (this.f50a) {
            x xVar = new x();
            xVar.a = 0;
            xVar.f90a = str;
            if (this.f50a.contains(xVar)) {
                this.f50a.remove(xVar);
            }
            this.f50a.add(xVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m203a(String str) {
        synchronized (this.f50a) {
            x xVar = new x();
            xVar.f90a = str;
            return this.f50a.contains(xVar);
        }
    }

    public void b(String str) {
        synchronized (this.f50a) {
            x xVar = new x();
            xVar.f90a = str;
            if (this.f50a.contains(xVar)) {
                Iterator<x> it = this.f50a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    x next = it.next();
                    if (xVar.equals(next)) {
                        xVar = next;
                        break;
                    }
                }
            }
            xVar.a++;
            this.f50a.remove(xVar);
            this.f50a.add(xVar);
        }
    }

    public void c(String str) {
        synchronized (this.f50a) {
            x xVar = new x();
            xVar.f90a = str;
            if (this.f50a.contains(xVar)) {
                this.f50a.remove(xVar);
            }
        }
    }
}
