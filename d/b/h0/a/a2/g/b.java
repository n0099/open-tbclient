package d.b.h0.a.a2.g;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.b.h0.a.k;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43959e = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0630b f43960b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f43961c;

    /* renamed from: d  reason: collision with root package name */
    public final String f43962d;

    /* renamed from: d.b.h0.a.a2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class SharedPreferences$EditorC0630b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f43963a;

        /* renamed from: d.b.h0.a.a2.g.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43965e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43966f;

            public a(String str, String str2) {
                this.f43965e = str;
                this.f43966f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putString(this.f43965e, this.f43966f);
            }
        }

        /* renamed from: d.b.h0.a.a2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0631b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43968e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f43969f;

            public RunnableC0631b(String str, Set set) {
                this.f43968e = str;
                this.f43969f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putStringSet(this.f43968e, this.f43969f);
            }
        }

        /* renamed from: d.b.h0.a.a2.g.b$b$c */
        /* loaded from: classes3.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43971e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f43972f;

            public c(String str, int i) {
                this.f43971e = str;
                this.f43972f = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putInt(this.f43971e, this.f43972f);
            }
        }

        /* renamed from: d.b.h0.a.a2.g.b$b$d */
        /* loaded from: classes3.dex */
        public class d implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43974e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43975f;

            public d(String str, long j) {
                this.f43974e = str;
                this.f43975f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putLong(this.f43974e, this.f43975f);
            }
        }

        /* renamed from: d.b.h0.a.a2.g.b$b$e */
        /* loaded from: classes3.dex */
        public class e implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43977e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f43978f;

            public e(String str, float f2) {
                this.f43977e = str;
                this.f43978f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putFloat(this.f43977e, this.f43978f);
            }
        }

        /* renamed from: d.b.h0.a.a2.g.b$b$f */
        /* loaded from: classes3.dex */
        public class f implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43980e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f43981f;

            public f(String str, boolean z) {
                this.f43980e = str;
                this.f43981f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putBoolean(this.f43980e, this.f43981f);
            }
        }

        /* renamed from: d.b.h0.a.a2.g.b$b$g */
        /* loaded from: classes3.dex */
        public class g implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43983e;

            public g(String str) {
                this.f43983e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.remove(this.f43983e);
            }
        }

        /* renamed from: d.b.h0.a.a2.g.b$b$h */
        /* loaded from: classes3.dex */
        public class h implements Runnable {
            public h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.clear();
            }
        }

        public SharedPreferences$EditorC0630b() {
            this.f43963a = new ArrayDeque();
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
            synchronized (this.f43963a) {
                while (!this.f43963a.isEmpty()) {
                    Runnable poll = this.f43963a.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            }
            return true;
        }

        public final SharedPreferences$EditorC0630b e(Runnable runnable) {
            synchronized (this.f43963a) {
                this.f43963a.offer(runnable);
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
            e(new RunnableC0631b(str, set));
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
        this.f43960b = new SharedPreferences$EditorC0630b();
        this.f43962d = str;
        this.f43961c = ProcessUtils.isMainProcess() || c();
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        if (this.f43961c) {
            super.clear();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 100, "", ""));
        }
        return this;
    }

    public boolean e(String str, boolean z) {
        return super.getBoolean(str, z);
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f43961c ? super.edit() : this.f43960b;
    }

    public float f(String str, float f2) {
        return super.getFloat(str, f2);
    }

    public int g(String str, int i) {
        return super.getInt(str, i);
    }

    @Override // d.b.h0.a.a2.g.g, d.b.h0.p.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return k() ? super.getAll() : new HashMap(super.getAll());
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            if (this.f43961c) {
                return e(str, z);
            }
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 3, str, String.valueOf(z)));
            if (f43959e) {
                Log.d("IpcSp", "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getBoolean("result_value"));
            }
            return callOnMainWithContentProvider.mResult.getBoolean("result_value");
        } catch (ClassCastException e2) {
            Log.e("IpcSp", "getBoolean", e2);
            return false;
        }
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        if (this.f43961c) {
            return f(str, f2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 5, str, String.valueOf(f2)));
        if (f43959e) {
            Log.d("IpcSp", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getFloat("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getFloat("result_value");
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (this.f43961c) {
            return g(str, i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 1, str, String.valueOf(i)));
        if (f43959e) {
            Log.d("IpcSp", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getInt("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getInt("result_value");
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.f43961c) {
            return h(str, j);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 2, str, String.valueOf(j)));
        if (f43959e) {
            Log.d("IpcSp", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getLong("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getLong("result_value");
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.f43961c) {
            return j(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 4, str, str2));
        if (f43959e) {
            Log.d("IpcSp", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getString("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getString("result_value");
    }

    public long h(String str, long j) {
        return super.getLong(str, j);
    }

    public final String i() {
        return this.f43962d;
    }

    public String j(String str, String str2) {
        return super.getString(str, str2);
    }

    public boolean k() {
        return this.f43961c;
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (this.f43961c) {
            super.putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 3, str, String.valueOf(z)));
        }
        return this;
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        if (this.f43961c) {
            super.putFloat(str, f2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 5, str, String.valueOf(f2)));
        }
        return this;
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (this.f43961c) {
            super.putInt(str, i);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 1, str, String.valueOf(i)));
        }
        return this;
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (this.f43961c) {
            super.edit().putLong(str, j).commit();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 2, str, String.valueOf(j)));
        }
        return this;
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (this.f43961c) {
            super.putString(str, str2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 4, str, str2));
        }
        return this;
    }

    @Override // d.b.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (this.f43961c) {
            super.remove(str);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 101, str, ""));
        }
        return this;
    }
}
