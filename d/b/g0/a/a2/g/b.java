package d.b.g0.a.a2.g;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.b.g0.a.k;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class b extends g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43238e = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0598b f43239b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f43240c;

    /* renamed from: d  reason: collision with root package name */
    public final String f43241d;

    /* renamed from: d.b.g0.a.a2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class SharedPreferences$EditorC0598b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f43242a;

        /* renamed from: d.b.g0.a.a2.g.b$b$a */
        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43244e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43245f;

            public a(String str, String str2) {
                this.f43244e = str;
                this.f43245f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putString(this.f43244e, this.f43245f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0599b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43247e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f43248f;

            public RunnableC0599b(String str, Set set) {
                this.f43247e = str;
                this.f43248f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putStringSet(this.f43247e, this.f43248f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$c */
        /* loaded from: classes2.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43250e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f43251f;

            public c(String str, int i) {
                this.f43250e = str;
                this.f43251f = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putInt(this.f43250e, this.f43251f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$d */
        /* loaded from: classes2.dex */
        public class d implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43253e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43254f;

            public d(String str, long j) {
                this.f43253e = str;
                this.f43254f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putLong(this.f43253e, this.f43254f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$e */
        /* loaded from: classes2.dex */
        public class e implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43256e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f43257f;

            public e(String str, float f2) {
                this.f43256e = str;
                this.f43257f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putFloat(this.f43256e, this.f43257f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$f */
        /* loaded from: classes2.dex */
        public class f implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43259e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f43260f;

            public f(String str, boolean z) {
                this.f43259e = str;
                this.f43260f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putBoolean(this.f43259e, this.f43260f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$g */
        /* loaded from: classes2.dex */
        public class g implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43262e;

            public g(String str) {
                this.f43262e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.remove(this.f43262e);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$h */
        /* loaded from: classes2.dex */
        public class h implements Runnable {
            public h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.clear();
            }
        }

        public SharedPreferences$EditorC0598b() {
            this.f43242a = new ArrayDeque();
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            e(new h());
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            synchronized (this.f43242a) {
                while (!this.f43242a.isEmpty()) {
                    Runnable poll = this.f43242a.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            }
            return true;
        }

        public final SharedPreferences$EditorC0598b e(Runnable runnable) {
            synchronized (this.f43242a) {
                this.f43242a.offer(runnable);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            e(new f(str, z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            e(new e(str, f2));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            e(new c(str, i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            e(new d(str, j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, @Nullable String str2) {
            e(new a(str, str2));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
            e(new RunnableC0599b(str, set));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            e(new g(str));
            return this;
        }
    }

    public b(String str) {
        super(str);
        this.f43239b = new SharedPreferences$EditorC0598b();
        this.f43241d = str;
        this.f43240c = ProcessUtils.isMainProcess() || c();
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        if (this.f43240c) {
            super.clear();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 100, "", ""));
        }
        return this;
    }

    public boolean e(String str, boolean z) {
        return super.getBoolean(str, z);
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f43240c ? super.edit() : this.f43239b;
    }

    public float f(String str, float f2) {
        return super.getFloat(str, f2);
    }

    public int g(String str, int i) {
        return super.getInt(str, i);
    }

    @Override // d.b.g0.a.a2.g.g, d.b.g0.p.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return k() ? super.getAll() : new HashMap(super.getAll());
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            if (this.f43240c) {
                return e(str, z);
            }
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 3, str, String.valueOf(z)));
            if (f43238e) {
                Log.d("IpcSp", "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getBoolean("result_value"));
            }
            return callOnMainWithContentProvider.mResult.getBoolean("result_value");
        } catch (ClassCastException e2) {
            Log.e("IpcSp", "getBoolean", e2);
            return false;
        }
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        if (this.f43240c) {
            return f(str, f2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 5, str, String.valueOf(f2)));
        if (f43238e) {
            Log.d("IpcSp", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getFloat("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getFloat("result_value");
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (this.f43240c) {
            return g(str, i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 1, str, String.valueOf(i)));
        if (f43238e) {
            Log.d("IpcSp", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getInt("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getInt("result_value");
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.f43240c) {
            return h(str, j);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 2, str, String.valueOf(j)));
        if (f43238e) {
            Log.d("IpcSp", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getLong("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getLong("result_value");
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.f43240c) {
            return j(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 4, str, str2));
        if (f43238e) {
            Log.d("IpcSp", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getString("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getString("result_value");
    }

    public long h(String str, long j) {
        return super.getLong(str, j);
    }

    public final String i() {
        return this.f43241d;
    }

    public String j(String str, String str2) {
        return super.getString(str, str2);
    }

    public boolean k() {
        return this.f43240c;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (this.f43240c) {
            super.putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 3, str, String.valueOf(z)));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        if (this.f43240c) {
            super.putFloat(str, f2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 5, str, String.valueOf(f2)));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (this.f43240c) {
            super.putInt(str, i);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 1, str, String.valueOf(i)));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (this.f43240c) {
            super.edit().putLong(str, j).commit();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 2, str, String.valueOf(j)));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (this.f43240c) {
            super.putString(str, str2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 4, str, str2));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (this.f43240c) {
            super.remove(str);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 101, str, ""));
        }
        return this;
    }
}
