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
    public Context f50a;

    /* renamed from: a  reason: collision with other field name */
    public List<x> f51a = new ArrayList();

    public af(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f50a = applicationContext;
        if (applicationContext == null) {
            this.f50a = context;
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
        synchronized (this.f51a) {
            x xVar = new x();
            xVar.f91a = str;
            if (this.f51a.contains(xVar)) {
                for (x xVar2 : this.f51a) {
                    if (xVar2.equals(xVar)) {
                        return xVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(au auVar) {
        return this.f50a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
    }

    public synchronized void a(au auVar, String str) {
        SharedPreferences sharedPreferences = this.f50a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(auVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m201a(String str) {
        synchronized (this.f51a) {
            x xVar = new x();
            xVar.a = 0;
            xVar.f91a = str;
            if (this.f51a.contains(xVar)) {
                this.f51a.remove(xVar);
            }
            this.f51a.add(xVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m202a(String str) {
        synchronized (this.f51a) {
            x xVar = new x();
            xVar.f91a = str;
            return this.f51a.contains(xVar);
        }
    }

    public void b(String str) {
        synchronized (this.f51a) {
            x xVar = new x();
            xVar.f91a = str;
            if (this.f51a.contains(xVar)) {
                Iterator<x> it = this.f51a.iterator();
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
            this.f51a.remove(xVar);
            this.f51a.add(xVar);
        }
    }

    public void c(String str) {
        synchronized (this.f51a) {
            x xVar = new x();
            xVar.f91a = str;
            if (this.f51a.contains(xVar)) {
                this.f51a.remove(xVar);
            }
        }
    }
}
