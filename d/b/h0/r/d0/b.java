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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static b f50455f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f50456g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f50457h;

    /* renamed from: a  reason: collision with root package name */
    public String f50458a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f50459b;

    /* renamed from: c  reason: collision with root package name */
    public String f50460c;

    /* renamed from: e  reason: collision with root package name */
    public String f50462e = null;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f50461d = new ConcurrentHashMap<>();

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
    public class C1073b extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f50464a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f50465b;

        public C1073b(Uri uri, ContentValues contentValues) {
            this.f50464a = uri;
            this.f50465b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.E(this.f50464a, this.f50465b);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f50467a;

        public c(Uri uri) {
            this.f50467a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.f(this.f50467a);
            return null;
        }
    }

    public b() {
        HashMap<String, String> hashMap = new HashMap<>();
        f50457h = hashMap;
        hashMap.put(d.b.h0.r.d0.a.f50447a, "settings");
        f50457h.put(d.b.h0.r.d0.a.f50448b, "remote_settings");
        f50457h.put(d.b.h0.r.d0.a.f50449c, "bdservice_settings");
        f50457h.put(d.b.h0.r.d0.a.f50450d, d.b.h0.r.d0.a.f50453g);
        f50457h.put(d.b.h0.r.d0.a.f50451e, d.b.h0.r.d0.a.f50454h);
        f50457h.put(d.b.h0.r.d0.a.f50452f, d.b.h0.r.d0.a.i);
        f50456g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b i() {
        b bVar;
        synchronized (b.class) {
            if (f50455f == null) {
                f50455f = new b();
            }
            bVar = f50455f;
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
        } else if (this.f50461d.containsKey(str)) {
            this.f50461d.remove(str);
        } else {
            SharedPreferences n = n();
            this.f50459b = n;
            EditorHelper.remove(n, str);
        }
    }

    public final void C(String str) {
        e(Uri.parse(h() + str));
    }

    public void D(Uri uri, ContentValues contentValues) {
        if (l.B()) {
            new C1073b(uri, contentValues).execute(new Void[0]);
        } else {
            E(uri, contentValues);
        }
    }

    public final void E(Uri uri, ContentValues contentValues) {
        try {
            f50456g.insert(uri, contentValues);
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
        if (this.f50461d.isEmpty()) {
            return;
        }
        SharedPreferences n = n();
        this.f50459b = n;
        if (n == null || (edit = n.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f50461d.entrySet()) {
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
        this.f50461d.clear();
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
            f50456g.delete(uri, null, null);
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
        Object obj = this.f50461d.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        SharedPreferences n = n();
        this.f50459b = n;
        return n.getBoolean(str, z);
    }

    public String h() {
        if (this.f50462e == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.f50462e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.f50462e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.f50462e;
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
        Object obj = this.f50461d.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        SharedPreferences n = n();
        this.f50459b = n;
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
        Object obj = this.f50461d.get(str);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        SharedPreferences n = n();
        this.f50459b = n;
        try {
            return n.getLong(str, j);
        } catch (ClassCastException e3) {
            BdLog.e(e3);
            return j;
        }
    }

    public final String l() {
        String str = d.b.h0.r.d0.a.f50447a;
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
        if (this.f50460c == null || this.f50460c.length() == 0) {
            if (this.f50458a == null || this.f50458a.length() == 0) {
                this.f50458a = l();
            }
            if (f50457h.containsKey(this.f50458a)) {
                this.f50460c = f50457h.get(this.f50458a);
            } else {
                this.f50460c = "settings";
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.f50460c, 0);
    }

    public String o(String str, String str2) {
        if (c(str)) {
            String q = q(str);
            return q != null ? q : str2;
        }
        Object obj = this.f50461d.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        SharedPreferences n = n();
        this.f50459b = n;
        return n.getString(str, str2);
    }

    public String p(Uri uri) {
        try {
            return f50456g.getType(uri);
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
        return this.f50461d.containsKey(str) || n().contains(str);
    }

    public void s(String str, boolean z) {
        if (c(str)) {
            A(str, z);
        } else if (l.B()) {
            t(str, Boolean.valueOf(z));
        } else {
            SharedPreferences n = n();
            this.f50459b = n;
            SharedPreferences.Editor edit = n.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public final void t(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.f50461d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a());
    }

    public void u(String str, int i) {
        if (c(str)) {
            x(str, i);
        } else if (l.B()) {
            t(str, Integer.valueOf(i));
        } else {
            SharedPreferences n = n();
            this.f50459b = n;
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
            this.f50459b = n;
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
            this.f50459b = n;
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
