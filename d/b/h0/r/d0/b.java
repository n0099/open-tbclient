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
import d.b.c.e.p.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static b f50862f;

    /* renamed from: g  reason: collision with root package name */
    public static ContentResolver f50863g;

    /* renamed from: h  reason: collision with root package name */
    public static HashMap<String, String> f50864h;

    /* renamed from: a  reason: collision with root package name */
    public String f50865a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f50866b;

    /* renamed from: c  reason: collision with root package name */
    public String f50867c;

    /* renamed from: e  reason: collision with root package name */
    public String f50869e = null;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Object> f50868d = new ConcurrentHashMap<>();

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
    public class C1086b extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f50871a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContentValues f50872b;

        public C1086b(Uri uri, ContentValues contentValues) {
            this.f50871a = uri;
            this.f50872b = contentValues;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.F(this.f50871a, this.f50872b);
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BdAsyncTask<Void, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Uri f50874a;

        public c(Uri uri) {
            this.f50874a = uri;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            b.this.f(this.f50874a);
            return null;
        }
    }

    public b() {
        HashMap<String, String> hashMap = new HashMap<>();
        f50864h = hashMap;
        hashMap.put(d.b.h0.r.d0.a.f50854a, "settings");
        f50864h.put(d.b.h0.r.d0.a.f50855b, "remote_settings");
        f50864h.put(d.b.h0.r.d0.a.f50856c, "bdservice_settings");
        f50864h.put(d.b.h0.r.d0.a.f50857d, d.b.h0.r.d0.a.f50860g);
        f50864h.put(d.b.h0.r.d0.a.f50858e, d.b.h0.r.d0.a.f50861h);
        f50864h.put(d.b.h0.r.d0.a.f50859f, d.b.h0.r.d0.a.i);
        f50863g = TbadkCoreApplication.getInst().getContentResolver();
    }

    public static synchronized b j() {
        b bVar;
        synchronized (b.class) {
            if (f50862f == null) {
                f50862f = new b();
            }
            bVar = f50862f;
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
        } else if (this.f50868d.containsKey(str)) {
            this.f50868d.remove(str);
        } else {
            SharedPreferences o = o();
            this.f50866b = o;
            EditorHelper.remove(o, str);
        }
    }

    public final void D(String str) {
        e(Uri.parse(h() + str));
    }

    public void E(Uri uri, ContentValues contentValues) {
        if (l.B()) {
            new C1086b(uri, contentValues).execute(new Void[0]);
        } else {
            F(uri, contentValues);
        }
    }

    public final void F(Uri uri, ContentValues contentValues) {
        try {
            f50863g.insert(uri, contentValues);
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
        if (this.f50868d.isEmpty()) {
            return;
        }
        SharedPreferences o = o();
        this.f50866b = o;
        if (o == null || (edit = o.edit()) == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : this.f50868d.entrySet()) {
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
        this.f50868d.clear();
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
            f50863g.delete(uri, null, null);
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
        Object obj = this.f50868d.get(str);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        SharedPreferences o = o();
        this.f50866b = o;
        return o.getBoolean(str, z);
    }

    public String h() {
        if (this.f50869e == null) {
            String packageName = TbadkCoreApplication.getInst().getContext().getPackageName();
            if ("com.baidu.tieba".equals(packageName)) {
                this.f50869e = "content://com.baidu.tbadk.core.sharedPref.MainSharedPrefProvider/";
            } else {
                this.f50869e = "content://" + packageName + ".sharedPref.MainSharedPrefProvider/";
            }
        }
        return this.f50869e;
    }

    public ContentResolver i() {
        return f50863g;
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
        Object obj = this.f50868d.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        SharedPreferences o = o();
        this.f50866b = o;
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
        Object obj = this.f50868d.get(str);
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        SharedPreferences o = o();
        this.f50866b = o;
        try {
            return o.getLong(str, j);
        } catch (ClassCastException e3) {
            BdLog.e(e3);
            return j;
        }
    }

    public final String m() {
        String str = d.b.h0.r.d0.a.f50854a;
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
        if (this.f50867c == null || this.f50867c.length() == 0) {
            if (this.f50865a == null || this.f50865a.length() == 0) {
                this.f50865a = m();
            }
            if (f50864h.containsKey(this.f50865a)) {
                this.f50867c = f50864h.get(this.f50865a);
            } else {
                this.f50867c = "settings";
            }
        }
        return TbadkCoreApplication.getInst().getSharedPreferences(this.f50867c, 0);
    }

    public String p(String str, String str2) {
        if (c(str)) {
            String r = r(str);
            return r != null ? r : str2;
        }
        Object obj = this.f50868d.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        SharedPreferences o = o();
        this.f50866b = o;
        return o.getString(str, str2);
    }

    public String q(Uri uri) {
        try {
            return f50863g.getType(uri);
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
        return this.f50868d.containsKey(str) || o().contains(str);
    }

    public void t(String str, boolean z) {
        if (c(str)) {
            B(str, z);
        } else if (l.B()) {
            u(str, Boolean.valueOf(z));
        } else {
            SharedPreferences o = o();
            this.f50866b = o;
            SharedPreferences.Editor edit = o.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    public final void u(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.f50868d.put(str, obj);
        Looper.myQueue().addIdleHandler(new a());
    }

    public void v(String str, int i) {
        if (c(str)) {
            y(str, i);
        } else if (l.B()) {
            u(str, Integer.valueOf(i));
        } else {
            SharedPreferences o = o();
            this.f50866b = o;
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
            this.f50866b = o;
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
            this.f50866b = o;
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
