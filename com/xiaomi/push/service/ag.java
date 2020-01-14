package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ag {
    private static volatile ag a;

    /* renamed from: a  reason: collision with other field name */
    protected SharedPreferences f850a;

    /* renamed from: a  reason: collision with other field name */
    private HashSet<a> f851a = new HashSet<>();

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private String f852a;

        public a(int i, String str) {
            this.a = i;
            this.f852a = str;
        }

        protected abstract void a();

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.a == ((a) obj).a;
        }

        public int hashCode() {
            return this.a;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();
        }
    }

    private ag(Context context) {
        this.f850a = context.getSharedPreferences("mipush_oc", 0);
    }

    public static ag a(Context context) {
        if (a == null) {
            synchronized (ag.class) {
                if (a == null) {
                    a = new ag(context);
                }
            }
        }
        return a;
    }

    private String a(int i) {
        return "normal_oc_" + i;
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (pair.second instanceof String) {
            editor.putString(str, (String) pair.second);
        } else if (pair.second instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
        }
    }

    private String b(int i) {
        return "custom_oc_" + i;
    }

    public int a(int i, int i2) {
        String b = b(i);
        if (this.f850a.contains(b)) {
            return this.f850a.getInt(b, 0);
        }
        String a2 = a(i);
        return this.f850a.contains(a2) ? this.f850a.getInt(a2, 0) : i2;
    }

    public synchronized void a() {
        this.f851a.clear();
    }

    public synchronized void a(a aVar) {
        if (!this.f851a.contains(aVar)) {
            this.f851a.add(aVar);
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.ad.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f850a.edit();
        for (Pair<Integer, Object> pair : list) {
            if (pair.first != null && pair.second != null) {
                a(edit, pair, a(((Integer) pair.first).intValue()));
            }
        }
        edit.commit();
    }

    public boolean a(int i, boolean z) {
        String b = b(i);
        if (this.f850a.contains(b)) {
            return this.f850a.getBoolean(b, false);
        }
        String a2 = a(i);
        return this.f850a.contains(a2) ? this.f850a.getBoolean(a2, false) : z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f851a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public void b(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.ad.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f850a.edit();
        for (Pair<Integer, Object> pair : list) {
            if (pair.first != null) {
                String b = b(((Integer) pair.first).intValue());
                if (pair.second == null) {
                    edit.remove(b);
                } else {
                    a(edit, pair, b);
                }
            }
        }
        edit.commit();
    }
}
