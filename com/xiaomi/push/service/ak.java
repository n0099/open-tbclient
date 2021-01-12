package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.hr;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class ak {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ak f14236a;

    /* renamed from: a  reason: collision with other field name */
    protected SharedPreferences f925a;

    /* renamed from: a  reason: collision with other field name */
    private HashSet<a> f926a = new HashSet<>();

    /* loaded from: classes6.dex */
    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i, String str) {
            this.mId = i;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        protected abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    private ak(Context context) {
        this.f925a = context.getSharedPreferences("mipush_oc", 0);
    }

    public static ak a(Context context) {
        if (f14236a == null) {
            synchronized (ak.class) {
                if (f14236a == null) {
                    f14236a = new ak(context);
                }
            }
        }
        return f14236a;
    }

    private String a(int i) {
        return "normal_oc_" + i;
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (!(pair.second instanceof String)) {
            if (pair.second instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
            }
        } else {
            String str2 = (String) pair.second;
            if (str.equals(a(hr.AppIsInstalledList.a()))) {
                editor.putString(str, com.xiaomi.push.bc.a(str2));
            } else {
                editor.putString(str, str2);
            }
        }
    }

    private String b(int i) {
        return "custom_oc_" + i;
    }

    public int a(int i, int i2) {
        String b2 = b(i);
        if (this.f925a.contains(b2)) {
            return this.f925a.getInt(b2, 0);
        }
        String a2 = a(i);
        return this.f925a.contains(a2) ? this.f925a.getInt(a2, 0) : i2;
    }

    public String a(int i, String str) {
        String b2 = b(i);
        if (this.f925a.contains(b2)) {
            return this.f925a.getString(b2, null);
        }
        String a2 = a(i);
        return this.f925a.contains(a2) ? this.f925a.getString(a2, null) : str;
    }

    public synchronized void a() {
        this.f926a.clear();
    }

    public synchronized void a(a aVar) {
        if (!this.f926a.contains(aVar)) {
            this.f926a.add(aVar);
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.ad.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f925a.edit();
        for (Pair<Integer, Object> pair : list) {
            if (pair.first != null && pair.second != null) {
                a(edit, pair, a(((Integer) pair.first).intValue()));
            }
        }
        edit.commit();
    }

    public boolean a(int i, boolean z) {
        String b2 = b(i);
        if (this.f925a.contains(b2)) {
            return this.f925a.getBoolean(b2, false);
        }
        String a2 = a(i);
        return this.f925a.contains(a2) ? this.f925a.getBoolean(a2, false) : z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f926a);
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
        SharedPreferences.Editor edit = this.f925a.edit();
        for (Pair<Integer, Object> pair : list) {
            if (pair.first != null) {
                String b2 = b(((Integer) pair.first).intValue());
                if (pair.second == null) {
                    edit.remove(b2);
                } else {
                    a(edit, pair, b2);
                }
            }
        }
        edit.commit();
    }
}
