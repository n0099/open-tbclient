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
    public Context f45a;

    /* renamed from: a  reason: collision with other field name */
    public List<x> f46a = new ArrayList();

    public af(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f45a = applicationContext;
        if (applicationContext == null) {
            this.f45a = context;
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
        synchronized (this.f46a) {
            x xVar = new x();
            xVar.f86a = str;
            if (this.f46a.contains(xVar)) {
                for (x xVar2 : this.f46a) {
                    if (xVar2.equals(xVar)) {
                        return xVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(au auVar) {
        return this.f45a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
    }

    public synchronized void a(au auVar, String str) {
        SharedPreferences sharedPreferences = this.f45a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(auVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m211a(String str) {
        synchronized (this.f46a) {
            x xVar = new x();
            xVar.a = 0;
            xVar.f86a = str;
            if (this.f46a.contains(xVar)) {
                this.f46a.remove(xVar);
            }
            this.f46a.add(xVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m212a(String str) {
        synchronized (this.f46a) {
            x xVar = new x();
            xVar.f86a = str;
            return this.f46a.contains(xVar);
        }
    }

    public void b(String str) {
        synchronized (this.f46a) {
            x xVar = new x();
            xVar.f86a = str;
            if (this.f46a.contains(xVar)) {
                Iterator<x> it = this.f46a.iterator();
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
            this.f46a.remove(xVar);
            this.f46a.add(xVar);
        }
    }

    public void c(String str) {
        synchronized (this.f46a) {
            x xVar = new x();
            xVar.f86a = str;
            if (this.f46a.contains(xVar)) {
                this.f46a.remove(xVar);
            }
        }
    }
}
