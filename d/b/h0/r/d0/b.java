package d.b.h0.r.d0;

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
import d.b.b.e.p.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static b f50454f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f50455g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f50456h;

    /* renamed from: a  reason: collision with root package name */
    public String f50457a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f50458b;

    /* renamed from: c  reason: collision with root package name */
    public String f50459c;

    /* renamed from: e  reason: collision with root package name */
    public String f50461e = null;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f50460d = new ConcurrentHashMap<>();

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

    /* renamed from: d.b.h0.r.d0.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1072b extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f50463a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f50464b;

        public C1072b(Uri uri, ContentValues contentValues) {
            this.f50463a = uri;
            this.f50464b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.E(this.f50463a, this.f50464b);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f50466a;

        public c(Uri uri) {
            this.f50466a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.f(this.f50466a);
            return null;
        }
    }

    public b() {
        HashMap<String, String> hashMap = new HashMap<>();
        f50456h = hashMap;
        hashMap.put(d.b.h0.r.d0.a.f50446a, "settings");
        f50456h.put(d.b.h0.r.d0.a.f50447b, "remote_settings");
        f50456h.put(d.b.h0.r.d0.a.f50448c, "bdservice_settings");
        f50456h.put(d.b.h0.r.d0.a.f50449d, d.b.h0.r.d0.a.f50452g);
        f50456h.put(d.b.h0.r.d0.a.f50450e, d.b.h0.r.d0.a.f50453h);
        f50456h.put(d.b.h0.r.d0.a.f50451f, d.b.h0.r.d0.a.i);
        f50455g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b i() {
        b bVar;
        synchronized (b.class) {
            if (f50454f == null) {
                f50454f = new b();
            }
            bVar = f50454f;
        }
        return bVar;
    }

    public static String m(String str) {
        return str + "_" + TbadkCoreApplication.getCurrentAccount();
    }

    public final void A(String str, boolean z) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(z));
        D(parse, contentValues);
    }

    public void B(String str) {
        if (c(str)) {
            C(str);
        } else if (this.f50460d.containsKey(str)) {
            this.f50460d.remove(str);
        } else {
            SharedPreferences n = n();
            this.f50458b = n;
            EditorHelper.remove(n, str);
        }
    }

    public final void C(String str) {
        e(Uri.parse(h() + str));
    }

    public void D(Uri uri, ContentValues contentValues) {
        if (l.B()) {
            new C1072b(uri, contentValues).execute(new Void[0]);
        } else {
            E(uri, contentValues);
        }
    }

    public final void E(Uri uri, ContentValues contentValues) {
        try {
            f50455g.insert(uri, contentValues);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public final boolean c(String str) {
        if (str != null && str.length() != 0) {
            int length = d.b.h0.r.d0.a.j.length;
            for (int i = 0; i < length; i++) {
                if (str.equals(d.b.h0.r.d0.a.j[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d() {
        SharedPreferences.Editor edit;
        if (this.f50460d.isEmpty()) {
            return;
        }
        SharedPreferences n = n();
        this.f50458b = n;
        if (n == null || (edit = n.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f50460d.entrySet()) {
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
        this.f50460d.clear();
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
            f50455g.delete(uri, null, null);
        } catch (SecurityException e2) {
            BdLog.detailException(e2);
        }
    }

    public boolean g(String str, boolean z) {
        if (c(str)) {
            String q = q(str);
            if (q == null) {
                return z;
            }
            try {
                return Boolean.parseBoolean(q);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return z;
            }
        }
        Object obj = this.f50460d.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        SharedPreferences n = n();
        this.f50458b = n;
        return n.getBoolean(str, z);
    }

    public String h() {
        if (this.f50461e == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.f50461e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.f50461e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.f50461e;
    }

    public int j(String str, int i) {
        if (c(str)) {
            String q = q(str);
            if (q == null) {
                return i;
            }
            try {
                return Integer.parseInt(q);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return i;
            }
        }
        Object obj = this.f50460d.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        SharedPreferences n = n();
        this.f50458b = n;
        return n.getInt(str, i);
    }

    public long k(String str, long j) {
        if (c(str)) {
            String q = q(str);
            if (q == null) {
                return j;
            }
            try {
                return Long.parseLong(q);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return j;
            }
        }
        Object obj = this.f50460d.get(str);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        SharedPreferences n = n();
        this.f50458b = n;
        try {
            return n.getLong(str, j);
        } catch (ClassCastException e3) {
            BdLog.e(e3);
            return j;
        }
    }

    public final String l() {
        String str = d.b.h0.r.d0.a.f50446a;
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

    public synchronized SharedPreferences n() {
        if (this.f50459c == null || this.f50459c.length() == 0) {
            if (this.f50457a == null || this.f50457a.length() == 0) {
                this.f50457a = l();
            }
            if (f50456h.containsKey(this.f50457a)) {
                this.f50459c = f50456h.get(this.f50457a);
            } else {
                this.f50459c = "settings";
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.f50459c, 0);
    }

    public String o(String str, String str2) {
        if (c(str)) {
            String q = q(str);
            return q != null ? q : str2;
        }
        Object obj = this.f50460d.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        SharedPreferences n = n();
        this.f50458b = n;
        return n.getString(str, str2);
    }

    public String p(Uri uri) {
        try {
            return f50455g.getType(uri);
        } catch (SecurityException e2) {
            BdLog.detailException(e2);
            return null;
        }
    }

    public final String q(String str) {
        return p(Uri.parse(h() + str));
    }

    public boolean r(String str) {
        if (c(str)) {
            return false;
        }
        return this.f50460d.containsKey(str) || n().contains(str);
    }

    public void s(String str, boolean z) {
        if (c(str)) {
            A(str, z);
        } else if (l.B()) {
            t(str, Boolean.valueOf(z));
        } else {
            SharedPreferences n = n();
            this.f50458b = n;
            SharedPreferences.Editor edit = n.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public final void t(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.f50460d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a());
    }

    public void u(String str, int i) {
        if (c(str)) {
            x(str, i);
        } else if (l.B()) {
            t(str, Integer.valueOf(i));
        } else {
            SharedPreferences n = n();
            this.f50458b = n;
            SharedPreferences.Editor edit = n.edit();
            edit.putInt(str, i);
            edit.commit();
        }
    }

    public void v(String str, long j) {
        if (c(str)) {
            y(str, j);
        } else if (l.B()) {
            t(str, Long.valueOf(j));
        } else {
            SharedPreferences n = n();
            this.f50458b = n;
            SharedPreferences.Editor edit = n.edit();
            edit.putLong(str, j);
            edit.commit();
        }
    }

    public void w(String str, String str2) {
        if (c(str)) {
            z(str, str2);
        } else if (StringUtil.NULL_STRING.equals(str2)) {
            B(str);
        } else if (l.B()) {
            t(str, str2);
        } else {
            SharedPreferences n = n();
            this.f50458b = n;
            SharedPreferences.Editor edit = n.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public final void x(String str, int i) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(i));
        D(parse, contentValues);
    }

    public final void y(String str, long j) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, String.valueOf(j));
        D(parse, contentValues);
    }

    public final void z(String str, String str2) {
        Uri parse = Uri.parse(h() + str);
        ContentValues contentValues = new ContentValues();
        contentValues.put(str, str2);
        D(parse, contentValues);
    }
}
