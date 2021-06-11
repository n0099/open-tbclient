package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ae {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ae f40905a;

    /* renamed from: a  reason: collision with other field name */
    public Context f56a;

    /* renamed from: a  reason: collision with other field name */
    public List<w> f57a = new ArrayList();

    public ae(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f56a = applicationContext;
        if (applicationContext == null) {
            this.f56a = context;
        }
    }

    public static ae a(Context context) {
        if (f40905a == null) {
            synchronized (ae.class) {
                if (f40905a == null) {
                    f40905a = new ae(context);
                }
            }
        }
        return f40905a;
    }

    public int a(String str) {
        synchronized (this.f57a) {
            w wVar = new w();
            wVar.f95a = str;
            if (this.f57a.contains(wVar)) {
                for (w wVar2 : this.f57a) {
                    if (wVar2.equals(wVar)) {
                        return wVar2.f40962a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String a(at atVar) {
        return this.f56a.getSharedPreferences("mipush_extra", 0).getString(atVar.name(), "");
    }

    public synchronized void a(at atVar, String str) {
        SharedPreferences sharedPreferences = this.f56a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(atVar.name(), str).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m76a(String str) {
        synchronized (this.f57a) {
            w wVar = new w();
            wVar.f40962a = 0;
            wVar.f95a = str;
            if (this.f57a.contains(wVar)) {
                this.f57a.remove(wVar);
            }
            this.f57a.add(wVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m77a(String str) {
        synchronized (this.f57a) {
            w wVar = new w();
            wVar.f95a = str;
            return this.f57a.contains(wVar);
        }
    }

    public void b(String str) {
        synchronized (this.f57a) {
            w wVar = new w();
            wVar.f95a = str;
            if (this.f57a.contains(wVar)) {
                Iterator<w> it = this.f57a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    w next = it.next();
                    if (wVar.equals(next)) {
                        wVar = next;
                        break;
                    }
                }
            }
            wVar.f40962a++;
            this.f57a.remove(wVar);
            this.f57a.add(wVar);
        }
    }

    public void c(String str) {
        synchronized (this.f57a) {
            w wVar = new w();
            wVar.f95a = str;
            if (this.f57a.contains(wVar)) {
                this.f57a.remove(wVar);
            }
        }
    }
}
