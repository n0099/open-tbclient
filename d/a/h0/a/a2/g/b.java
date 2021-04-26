package d.a.h0.a.a2.g;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.h0.a.k;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f41229e = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0569b f41230b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f41231c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41232d;

    /* renamed from: d.a.h0.a.a2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class SharedPreferences$EditorC0569b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f41233a;

        /* renamed from: d.a.h0.a.a2.g.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41235e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f41236f;

            public a(String str, String str2) {
                this.f41235e = str;
                this.f41236f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putString(this.f41235e, this.f41236f);
            }
        }

        /* renamed from: d.a.h0.a.a2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0570b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41238e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f41239f;

            public RunnableC0570b(String str, Set set) {
                this.f41238e = str;
                this.f41239f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putStringSet(this.f41238e, this.f41239f);
            }
        }

        /* renamed from: d.a.h0.a.a2.g.b$b$c */
        /* loaded from: classes3.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41241e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f41242f;

            public c(String str, int i2) {
                this.f41241e = str;
                this.f41242f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putInt(this.f41241e, this.f41242f);
            }
        }

        /* renamed from: d.a.h0.a.a2.g.b$b$d */
        /* loaded from: classes3.dex */
        public class d implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41244e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f41245f;

            public d(String str, long j) {
                this.f41244e = str;
                this.f41245f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putLong(this.f41244e, this.f41245f);
            }
        }

        /* renamed from: d.a.h0.a.a2.g.b$b$e */
        /* loaded from: classes3.dex */
        public class e implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41247e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f41248f;

            public e(String str, float f2) {
                this.f41247e = str;
                this.f41248f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putFloat(this.f41247e, this.f41248f);
            }
        }

        /* renamed from: d.a.h0.a.a2.g.b$b$f */
        /* loaded from: classes3.dex */
        public class f implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41250e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f41251f;

            public f(String str, boolean z) {
                this.f41250e = str;
                this.f41251f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putBoolean(this.f41250e, this.f41251f);
            }
        }

        /* renamed from: d.a.h0.a.a2.g.b$b$g */
        /* loaded from: classes3.dex */
        public class g implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f41253e;

            public g(String str) {
                this.f41253e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.remove(this.f41253e);
            }
        }

        /* renamed from: d.a.h0.a.a2.g.b$b$h */
        /* loaded from: classes3.dex */
        public class h implements Runnable {
            public h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.clear();
            }
        }

        public SharedPreferences$EditorC0569b() {
            this.f41233a = new ArrayDeque();
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
            synchronized (this.f41233a) {
                while (!this.f41233a.isEmpty()) {
                    Runnable poll = this.f41233a.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            }
            return true;
        }

        public final SharedPreferences$EditorC0569b e(Runnable runnable) {
            synchronized (this.f41233a) {
                this.f41233a.offer(runnable);
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
        public SharedPreferences.Editor putInt(String str, int i2) {
            e(new c(str, i2));
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
            e(new RunnableC0570b(str, set));
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
        this.f41230b = new SharedPreferences$EditorC0569b();
        this.f41232d = str;
        this.f41231c = ProcessUtils.isMainProcess() || b();
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        if (this.f41231c) {
            super.clear();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 100, "", ""));
        }
        return this;
    }

    public boolean e(String str, boolean z) {
        return super.getBoolean(str, z);
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f41231c ? super.edit() : this.f41230b;
    }

    public float f(String str, float f2) {
        return super.getFloat(str, f2);
    }

    public int g(String str, int i2) {
        return super.getInt(str, i2);
    }

    @Override // d.a.h0.a.a2.g.g, d.a.h0.p.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return k() ? super.getAll() : new HashMap(super.getAll());
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            if (this.f41231c) {
                return e(str, z);
            }
            DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 3, str, String.valueOf(z)));
            if (f41229e) {
                Log.d("IpcSp", "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getBoolean("result_value"));
            }
            return callOnMainWithContentProvider.mResult.getBoolean("result_value");
        } catch (ClassCastException e2) {
            Log.e("IpcSp", "getBoolean", e2);
            return false;
        }
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        if (this.f41231c) {
            return f(str, f2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 5, str, String.valueOf(f2)));
        if (f41229e) {
            Log.d("IpcSp", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getFloat("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getFloat("result_value");
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        if (this.f41231c) {
            return g(str, i2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 1, str, String.valueOf(i2)));
        if (f41229e) {
            Log.d("IpcSp", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getInt("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getInt("result_value");
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.f41231c) {
            return h(str, j);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 2, str, String.valueOf(j)));
        if (f41229e) {
            Log.d("IpcSp", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getLong("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getLong("result_value");
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.f41231c) {
            return j(str, str2);
        }
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), e.class, c.a(i(), 4, str, str2));
        if (f41229e) {
            Log.d("IpcSp", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + callOnMainWithContentProvider.mResult.getString("result_value"));
        }
        return callOnMainWithContentProvider.mResult.getString("result_value");
    }

    public long h(String str, long j) {
        return super.getLong(str, j);
    }

    public final String i() {
        return this.f41232d;
    }

    public String j(String str, String str2) {
        return super.getString(str, str2);
    }

    public boolean k() {
        return this.f41231c;
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (this.f41231c) {
            super.putBoolean(str, z);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 3, str, String.valueOf(z)));
        }
        return this;
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        if (this.f41231c) {
            super.putFloat(str, f2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 5, str, String.valueOf(f2)));
        }
        return this;
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        if (this.f41231c) {
            super.putInt(str, i2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 1, str, String.valueOf(i2)));
        }
        return this;
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (this.f41231c) {
            super.edit().putLong(str, j).commit();
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 2, str, String.valueOf(j)));
        }
        return this;
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (this.f41231c) {
            super.putString(str, str2);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 4, str, str2));
        }
        return this;
    }

    @Override // d.a.h0.a.a2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (this.f41231c) {
            super.remove(str);
        } else {
            DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), f.class, c.a(i(), 101, str, ""));
        }
        return this;
    }
}
