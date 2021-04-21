package d.b.i0.r.d0;

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
import d.b.c.e.p.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static b f51198f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f51199g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f51200h;

    /* renamed from: a  reason: collision with root package name */
    public String f51201a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f51202b;

    /* renamed from: c  reason: collision with root package name */
    public String f51203c;

    /* renamed from: e  reason: collision with root package name */
    public String f51205e = null;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f51204d = new ConcurrentHashMap<>();

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

    /* renamed from: d.b.i0.r.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1108b extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f51207a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f51208b;

        public C1108b(Uri uri, ContentValues contentValues) {
            this.f51207a = uri;
            this.f51208b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.F(this.f51207a, this.f51208b);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f51210a;

        public c(Uri uri) {
            this.f51210a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.f(this.f51210a);
            return null;
        }
    }

    public b() {
        HashMap<String, String> hashMap = new HashMap<>();
        f51200h = hashMap;
        hashMap.put(d.b.i0.r.d0.a.f51190a, "settings");
        f51200h.put(d.b.i0.r.d0.a.f51191b, "remote_settings");
        f51200h.put(d.b.i0.r.d0.a.f51192c, "bdservice_settings");
        f51200h.put(d.b.i0.r.d0.a.f51193d, d.b.i0.r.d0.a.f51196g);
        f51200h.put(d.b.i0.r.d0.a.f51194e, d.b.i0.r.d0.a.f51197h);
        f51200h.put(d.b.i0.r.d0.a.f51195f, d.b.i0.r.d0.a.i);
        f51199g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b j() {
        b bVar;
        synchronized (b.class) {
            if (f51198f == null) {
                f51198f = new b();
            }
            bVar = f51198f;
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
        } else if (this.f51204d.containsKey(str)) {
            this.f51204d.remove(str);
        } else {
            SharedPreferences o = o();
            this.f51202b = o;
            EditorHelper.remove(o, str);
        }
    }

    public final void D(String str) {
        e(Uri.parse(h() + str));
    }

    public void E(Uri uri, ContentValues contentValues) {
        if (l.B()) {
            new C1108b(uri, contentValues).execute(new Void[0]);
        } else {
            F(uri, contentValues);
        }
    }

    public final void F(Uri uri, ContentValues contentValues) {
        try {
            f51199g.insert(uri, contentValues);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public final boolean c(String str) {
        if (str != null && str.length() != 0) {
            int length = d.b.i0.r.d0.a.j.length;
            for (int i = 0; i < length; i++) {
                if (str.equals(d.b.i0.r.d0.a.j[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d() {
        SharedPreferences.Editor edit;
        if (this.f51204d.isEmpty()) {
            return;
        }
        SharedPreferences o = o();
        this.f51202b = o;
        if (o == null || (edit = o.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f51204d.entrySet()) {
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
        this.f51204d.clear();
    }

    public void e(Uri uri) {
        if (l.B()) {
            new c(uri).execute(new Void[0]);
        } else {
            f(uri);
        }
    }

    public final void f(Uri uri) {
        try {
            f51199g.delete(uri, null, null);
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
        Object obj = this.f51204d.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        SharedPreferences o = o();
        this.f51202b = o;
        return o.getBoolean(str, z);
    }

    public String h() {
        if (this.f51205e == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.f51205e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.f51205e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.f51205e;
    }

    public ContentResolver i() {
        return f51199g;
    }

    public int k(String str, int i) {
        if (c(str)) {
            String r = r(str);
            if (r == null) {
                return i;
            }
            try {
                return Integer.parseInt(r);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return i;
            }
        }
        Object obj = this.f51204d.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        SharedPreferences o = o();
        this.f51202b = o;
        return o.getInt(str, i);
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
        Object obj = this.f51204d.get(str);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        SharedPreferences o = o();
        this.f51202b = o;
        try {
            return o.getLong(str, j);
        } catch (ClassCastException e3) {
            BdLog.e(e3);
            return j;
        }
    }

    public final String m() {
        String str = d.b.i0.r.d0.a.f51190a;
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
        if (this.f51203c == null || this.f51203c.length() == 0) {
            if (this.f51201a == null || this.f51201a.length() == 0) {
                this.f51201a = m();
            }
            if (f51200h.containsKey(this.f51201a)) {
                this.f51203c = f51200h.get(this.f51201a);
            } else {
                this.f51203c = "settings";
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.f51203c, 0);
    }

    public String p(String str, String str2) {
        if (c(str)) {
            String r = r(str);
            return r != null ? r : str2;
        }
        Object obj = this.f51204d.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        SharedPreferences o = o();
        this.f51202b = o;
        return o.getString(str, str2);
    }

    public String q(Uri uri) {
        try {
            return f51199g.getType(uri);
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
        return this.f51204d.containsKey(str) || o().contains(str);
    }

    public void t(String str, boolean z) {
        if (c(str)) {
            B(str, z);
        } else if (l.B()) {
            u(str, Boolean.valueOf(z));
        } else {
            SharedPreferences o = o();
            this.f51202b = o;
            SharedPreferences.Editor edit = o.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public final void u(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.f51204d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a());
    }

    public void v(String str, int i) {
        if (c(str)) {
            y(str, i);
        } else if (l.B()) {
            u(str, Integer.valueOf(i));
        } else {
            SharedPreferences o = o();
            this.f51202b = o;
            SharedPreferences.Editor edit = o.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public void w(String str, long j) {
        if (c(str)) {
            z(str, j);
        } else if (l.B()) {
            u(str, Long.valueOf(j));
        } else {
            SharedPreferences o = o();
            this.f51202b = o;
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
        } else if (l.B()) {
            u(str, str2);
        } else {
            SharedPreferences o = o();
            this.f51202b = o;
            SharedPreferences.Editor edit = o.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public final void y(String str, int i) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        E(parse, contentValues);
    }

    public final void z(String str, long j) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        E(parse, contentValues);
    }
}
