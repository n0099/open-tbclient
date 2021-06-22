package d.a.n0.r.d0;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.compatible.EditorHelper;
import d.a.c.e.p.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static b f53461f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f53462g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f53463h;

    /* renamed from: a  reason: collision with root package name */
    public String f53464a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f53465b;

    /* renamed from: c  reason: collision with root package name */
    public String f53466c;

    /* renamed from: e  reason: collision with root package name */
    public String f53468e = null;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f53467d = new ConcurrentHashMap<>();

    /* loaded from: classes3.dex */
    public class a implements MessageQueue.IdleHandler {
        public a() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            b.this.d();
            return false;
        }
    }

    /* renamed from: d.a.n0.r.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1191b extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f53470a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f53471b;

        public C1191b(Uri uri, ContentValues contentValues) {
            this.f53470a = uri;
            this.f53471b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.F(this.f53470a, this.f53471b);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f53473a;

        public c(Uri uri) {
            this.f53473a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.f(this.f53473a);
            return null;
        }
    }

    public b() {
        HashMap<String, String> hashMap = new HashMap<>();
        f53463h = hashMap;
        hashMap.put(d.a.n0.r.d0.a.f53452a, "settings");
        f53463h.put(d.a.n0.r.d0.a.f53453b, "remote_settings");
        f53463h.put(d.a.n0.r.d0.a.f53454c, "bdservice_settings");
        f53463h.put(d.a.n0.r.d0.a.f53455d, d.a.n0.r.d0.a.f53458g);
        f53463h.put(d.a.n0.r.d0.a.f53456e, d.a.n0.r.d0.a.f53459h);
        f53463h.put(d.a.n0.r.d0.a.f53457f, d.a.n0.r.d0.a.f53460i);
        f53462g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b j() {
        b bVar;
        synchronized (b.class) {
            if (f53461f == null) {
                f53461f = new b();
            }
            bVar = f53461f;
        }
        return bVar;
    }

    public static String n(String str) {
        return str + "_" + TbadkCoreApplication.getCurrentAccount();
    }

    public final void A(String str, String str2) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        E(parse, contentValues);
    }

    public final void B(String str, boolean z) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        E(parse, contentValues);
    }

    public void C(String str) {
        if (c(str)) {
            D(str);
        } else if (this.f53467d.containsKey(str)) {
            this.f53467d.remove(str);
        } else {
            SharedPreferences o = o();
            this.f53465b = o;
            EditorHelper.remove(o, str);
        }
    }

    public final void D(String str) {
        e(Uri.parse(h() + str));
    }

    public void E(Uri uri, ContentValues contentValues) {
        if (l.C()) {
            new C1191b(uri, contentValues).execute(new Void[0]);
        } else {
            F(uri, contentValues);
        }
    }

    public final void F(Uri uri, ContentValues contentValues) {
        try {
            f53462g.insert(uri, contentValues);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public final boolean c(String str) {
        if (str != null && str.length() != 0) {
            int length = d.a.n0.r.d0.a.j.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (str.equals(d.a.n0.r.d0.a.j[i2])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d() {
        SharedPreferences.Editor edit;
        if (this.f53467d.isEmpty()) {
            return;
        }
        SharedPreferences o = o();
        this.f53465b = o;
        if (o == null || (edit = o.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f53467d.entrySet()) {
            if (entry != null) {
                String valueOf = String.valueOf(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof String) {
                    edit.putString(valueOf, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(valueOf, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(valueOf, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(valueOf, ((Boolean) value).booleanValue());
                } else if (value instanceof Float) {
                    edit.putFloat(valueOf, ((Float) value).floatValue());
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 9) {
            edit.apply();
        } else {
            edit.commit();
        }
        this.f53467d.clear();
    }

    public void e(Uri uri) {
        if (l.C()) {
            new c(uri).execute(new Void[0]);
        } else {
            f(uri);
        }
    }

    public final void f(Uri uri) {
        try {
            f53462g.delete(uri, null, null);
        } catch (SecurityException e2) {
            BdLog.detailException(e2);
        }
    }

    public boolean g(String str, boolean z) {
        if (c(str)) {
            String r = r(str);
            if (r == null) {
                return z;
            }
            try {
                return Boolean.parseBoolean(r);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return z;
            }
        }
        Object obj = this.f53467d.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        SharedPreferences o = o();
        this.f53465b = o;
        return o.getBoolean(str, z);
    }

    public String h() {
        if (this.f53468e == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.f53468e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.f53468e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.f53468e;
    }

    public ContentResolver i() {
        return f53462g;
    }

    public int k(String str, int i2) {
        if (c(str)) {
            String r = r(str);
            if (r == null) {
                return i2;
            }
            try {
                return Integer.parseInt(r);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return i2;
            }
        }
        Object obj = this.f53467d.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        SharedPreferences o = o();
        this.f53465b = o;
        return o.getInt(str, i2);
    }

    public long l(String str, long j) {
        if (c(str)) {
            String r = r(str);
            if (r == null) {
                return j;
            }
            try {
                return Long.parseLong(r);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return j;
            }
        }
        Object obj = this.f53467d.get(str);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        SharedPreferences o = o();
        this.f53465b = o;
        try {
            return o.getLong(str, j);
        } catch (ClassCastException e3) {
            BdLog.e(e3);
            return j;
        }
    }

    public final String m() {
        String str = d.a.n0.r.d0.a.f53452a;
        ActivityManager activityManager = (ActivityManager) TbadkCoreApplication.getInst().getSystemService("activity");
        if (activityManager != null) {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            int myPid = Process.myPid();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return str;
            }
            return str;
        }
        return str;
    }

    public synchronized SharedPreferences o() {
        if (this.f53466c == null || this.f53466c.length() == 0) {
            if (this.f53464a == null || this.f53464a.length() == 0) {
                this.f53464a = m();
            }
            if (f53463h.containsKey(this.f53464a)) {
                this.f53466c = f53463h.get(this.f53464a);
            } else {
                this.f53466c = "settings";
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.f53466c, 0);
    }

    public String p(String str, String str2) {
        if (c(str)) {
            String r = r(str);
            return r != null ? r : str2;
        }
        Object obj = this.f53467d.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        SharedPreferences o = o();
        this.f53465b = o;
        return o.getString(str, str2);
    }

    public String q(Uri uri) {
        try {
            return f53462g.getType(uri);
        } catch (SecurityException e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    public final String r(String str) {
        return q(Uri.parse(h() + str));
    }

    public boolean s(String str) {
        if (c(str)) {
            return false;
        }
        return this.f53467d.containsKey(str) || o().contains(str);
    }

    public void t(String str, boolean z) {
        if (c(str)) {
            B(str, z);
        } else if (l.C()) {
            u(str, Boolean.valueOf(z));
        } else {
            SharedPreferences o = o();
            this.f53465b = o;
            SharedPreferences.Editor edit = o.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public final void u(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.f53467d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a());
    }

    public void v(String str, int i2) {
        if (c(str)) {
            y(str, i2);
        } else if (l.C()) {
            u(str, Integer.valueOf(i2));
        } else {
            SharedPreferences o = o();
            this.f53465b = o;
            SharedPreferences.Editor edit = o.edit();
            edit.putInt(str, i2);
            edit.commit();
        }
    }

    public void w(String str, long j) {
        if (c(str)) {
            z(str, j);
        } else if (l.C()) {
            u(str, Long.valueOf(j));
        } else {
            SharedPreferences o = o();
            this.f53465b = o;
            SharedPreferences.Editor edit = o.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public void x(String str, String str2) {
        if (c(str)) {
            A(str, str2);
        } else if (StringUtil.NULL_STRING.equals(str2)) {
            C(str);
        } else if (l.C()) {
            u(str, str2);
        } else {
            SharedPreferences o = o();
            this.f53465b = o;
            SharedPreferences.Editor edit = o.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public final void y(String str, int i2) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i2));
        E(parse, contentValues);
    }

    public final void z(String str, long j) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        E(parse, contentValues);
    }
}
