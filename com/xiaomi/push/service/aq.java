package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.hk;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    public static volatile aq f41839a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f895a;

    /* renamed from: a  reason: collision with other field name */
    public HashSet<a> f896a = new HashSet<>();

    /* loaded from: classes7.dex */
    public static abstract class a implements Runnable {
        public String mDescription;
        public int mId;

        public a(int i2, String str) {
            this.mId = i2;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        public abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    public aq(Context context) {
        this.f895a = context.getSharedPreferences("mipush_oc", 0);
    }

    public static aq a(Context context) {
        if (f41839a == null) {
            synchronized (aq.class) {
                if (f41839a == null) {
                    f41839a = new aq(context);
                }
            }
        }
        return f41839a;
    }

    private String a(int i2) {
        return "normal_oc_" + i2;
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            }
        } else {
            String str2 = (String) obj;
            if (str.equals(a(hk.AppIsInstalledList.a()))) {
                str2 = com.xiaomi.push.bj.a(str2);
            }
            editor.putString(str, str2);
        }
    }

    private String b(int i2) {
        return "custom_oc_" + i2;
    }

    public int a(int i2, int i3) {
        try {
            String b2 = b(i2);
            if (this.f895a.contains(b2)) {
                return this.f895a.getInt(b2, 0);
            }
            String a2 = a(i2);
            return this.f895a.contains(a2) ? this.f895a.getInt(a2, 0) : i3;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a(i2 + " oc int error " + e2);
            return i3;
        }
    }

    public String a(int i2, String str) {
        try {
            String b2 = b(i2);
            if (this.f895a.contains(b2)) {
                return this.f895a.getString(b2, null);
            }
            String a2 = a(i2);
            return this.f895a.contains(a2) ? this.f895a.getString(a2, null) : str;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a(i2 + " oc string error " + e2);
            return str;
        }
    }

    public synchronized void a() {
        this.f896a.clear();
    }

    public synchronized void a(a aVar) {
        if (!this.f896a.contains(aVar)) {
            this.f896a.add(aVar);
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.ad.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f895a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null && pair.second != null) {
                a(edit, pair, a(((Integer) obj).intValue()));
            }
        }
        edit.commit();
    }

    public boolean a(int i2, boolean z) {
        try {
            String b2 = b(i2);
            if (this.f895a.contains(b2)) {
                return this.f895a.getBoolean(b2, false);
            }
            String a2 = a(i2);
            return this.f895a.contains(a2) ? this.f895a.getBoolean(a2, false) : z;
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m56a(i2 + " oc boolean error " + e2);
            return z;
        }
    }

    public void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f896a);
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
        SharedPreferences.Editor edit = this.f895a.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String b2 = b(((Integer) obj).intValue());
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
