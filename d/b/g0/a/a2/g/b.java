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
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43630e = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0610b f43631b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f43632c;

    /* renamed from: d  reason: collision with root package name */
    public final String f43633d;

    /* renamed from: d.b.g0.a.a2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class SharedPreferences$EditorC0610b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f43634a;

        /* renamed from: d.b.g0.a.a2.g.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43636e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43637f;

            public a(String str, String str2) {
                this.f43636e = str;
                this.f43637f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putString(this.f43636e, this.f43637f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0611b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43639e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f43640f;

            public RunnableC0611b(String str, Set set) {
                this.f43639e = str;
                this.f43640f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putStringSet(this.f43639e, this.f43640f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$c */
        /* loaded from: classes3.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43642e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f43643f;

            public c(String str, int i) {
                this.f43642e = str;
                this.f43643f = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putInt(this.f43642e, this.f43643f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$d */
        /* loaded from: classes3.dex */
        public class d implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43645e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43646f;

            public d(String str, long j) {
                this.f43645e = str;
                this.f43646f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putLong(this.f43645e, this.f43646f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$e */
        /* loaded from: classes3.dex */
        public class e implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43648e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f43649f;

            public e(String str, float f2) {
                this.f43648e = str;
                this.f43649f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putFloat(this.f43648e, this.f43649f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$f */
        /* loaded from: classes3.dex */
        public class f implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43651e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f43652f;

            public f(String str, boolean z) {
                this.f43651e = str;
                this.f43652f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putBoolean(this.f43651e, this.f43652f);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$g */
        /* loaded from: classes3.dex */
        public class g implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43654e;

            public g(String str) {
                this.f43654e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.remove(this.f43654e);
            }
        }

        /* renamed from: d.b.g0.a.a2.g.b$b$h */
        /* loaded from: classes3.dex */
        public class h implements Runnable {
            public h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.clear();
            }
        }

        public SharedPreferences$EditorC0610b() {
            this.f43634a = new ArrayDeque();
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
            synchronized (this.f43634a) {
                while (!this.f43634a.isEmpty()) {
                    Runnable poll = this.f43634a.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            }
            return true;
        }

        public final SharedPreferences$EditorC0610b e(Runnable runnable) {
            synchronized (this.f43634a) {
                this.f43634a.offer(runnable);
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
            e(new RunnableC0611b(str, set));
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
        this.f43631b = new SharedPreferences$EditorC0610b();
        this.f43633d = str;
        this.f43632c = ProcessUtils.isMainProcess() || c();
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        if (this.f43632c) {
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
        return this.f43632c ? super.edit() : this.f43631b;
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
            if (this.f43632c) {
                return e(str, z);
            }
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 3, str, String.valueOf(z)));
            if (f43630e) {
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
        if (this.f43632c) {
            return f(str, f2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 5, str, String.valueOf(f2)));
        if (f43630e) {
            Log.d("IpcSp", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getFloat("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getFloat("result_value");
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i) {
        if (this.f43632c) {
            return g(str, i);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 1, str, String.valueOf(i)));
        if (f43630e) {
            Log.d("IpcSp", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getInt("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getInt("result_value");
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.f43632c) {
            return h(str, j);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 2, str, String.valueOf(j)));
        if (f43630e) {
            Log.d("IpcSp", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getLong("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getLong("result_value");
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.f43632c) {
            return j(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 4, str, str2));
        if (f43630e) {
            Log.d("IpcSp", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getString("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getString("result_value");
    }

    public long h(String str, long j) {
        return super.getLong(str, j);
    }

    public final String i() {
        return this.f43633d;
    }

    public String j(String str, String str2) {
        return super.getString(str, str2);
    }

    public boolean k() {
        return this.f43632c;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (this.f43632c) {
            super.putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 3, str, String.valueOf(z)));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        if (this.f43632c) {
            super.putFloat(str, f2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 5, str, String.valueOf(f2)));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        if (this.f43632c) {
            super.putInt(str, i);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 1, str, String.valueOf(i)));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (this.f43632c) {
            super.edit().putLong(str, j).commit();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 2, str, String.valueOf(j)));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (this.f43632c) {
            super.putString(str, str2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 4, str, str2));
        }
        return this;
    }

    @Override // d.b.g0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (this.f43632c) {
            super.remove(str);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 101, str, ""));
        }
        return this;
    }
}
