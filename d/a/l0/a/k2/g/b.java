package d.a.l0.a.k2.g;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.l0.a.k;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f46919e = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0784b f46920b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f46921c;

    /* renamed from: d  reason: collision with root package name */
    public final String f46922d;

    /* renamed from: d.a.l0.a.k2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class SharedPreferences$EditorC0784b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f46923a;

        /* renamed from: d.a.l0.a.k2.g.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46925e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f46926f;

            public a(String str, String str2) {
                this.f46925e = str;
                this.f46926f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putString(this.f46925e, this.f46926f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0785b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46928e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f46929f;

            public RunnableC0785b(String str, Set set) {
                this.f46928e = str;
                this.f46929f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putStringSet(this.f46928e, this.f46929f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$c */
        /* loaded from: classes3.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46931e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f46932f;

            public c(String str, int i2) {
                this.f46931e = str;
                this.f46932f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putInt(this.f46931e, this.f46932f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$d */
        /* loaded from: classes3.dex */
        public class d implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46934e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f46935f;

            public d(String str, long j) {
                this.f46934e = str;
                this.f46935f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putLong(this.f46934e, this.f46935f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$e */
        /* loaded from: classes3.dex */
        public class e implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46937e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f46938f;

            public e(String str, float f2) {
                this.f46937e = str;
                this.f46938f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putFloat(this.f46937e, this.f46938f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$f */
        /* loaded from: classes3.dex */
        public class f implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46940e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f46941f;

            public f(String str, boolean z) {
                this.f46940e = str;
                this.f46941f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putBoolean(this.f46940e, this.f46941f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$g */
        /* loaded from: classes3.dex */
        public class g implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46943e;

            public g(String str) {
                this.f46943e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.remove(this.f46943e);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$h */
        /* loaded from: classes3.dex */
        public class h implements Runnable {
            public h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.clear();
            }
        }

        public SharedPreferences$EditorC0784b() {
            this.f46923a = new ArrayDeque();
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
            synchronized (this.f46923a) {
                while (!this.f46923a.isEmpty()) {
                    Runnable poll = this.f46923a.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            }
            return true;
        }

        public final SharedPreferences$EditorC0784b e(Runnable runnable) {
            synchronized (this.f46923a) {
                this.f46923a.offer(runnable);
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
            e(new RunnableC0785b(str, set));
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
        this.f46920b = new SharedPreferences$EditorC0784b();
        this.f46922d = str;
        this.f46921c = ProcessUtils.isMainProcess() || b();
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        if (this.f46921c) {
            super.clear();
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 100, "", ""));
        }
        return this;
    }

    public boolean e(String str, boolean z) {
        return super.getBoolean(str, z);
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f46921c ? super.edit() : this.f46920b;
    }

    public float f(String str, float f2) {
        return super.getFloat(str, f2);
    }

    public int g(String str, int i2) {
        return super.getInt(str, i2);
    }

    @Override // d.a.l0.a.k2.g.g, d.a.l0.t.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return k() ? super.getAll() : new HashMap(super.getAll());
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            if (this.f46921c) {
                return e(str, z);
            }
            d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 3, str, String.valueOf(z)));
            if (f46919e) {
                Log.d("IpcSp", "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f48971a.getBoolean("result_value"));
            }
            return b2.f48971a.getBoolean("result_value");
        } catch (ClassCastException e2) {
            Log.e("IpcSp", "getBoolean", e2);
            return false;
        }
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        if (this.f46921c) {
            return f(str, f2);
        }
        d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 5, str, String.valueOf(f2)));
        if (f46919e) {
            Log.d("IpcSp", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f48971a.getFloat("result_value"));
        }
        return b2.f48971a.getFloat("result_value");
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        if (this.f46921c) {
            return g(str, i2);
        }
        d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 1, str, String.valueOf(i2)));
        if (f46919e) {
            Log.d("IpcSp", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f48971a.getInt("result_value"));
        }
        return b2.f48971a.getInt("result_value");
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.f46921c) {
            return h(str, j);
        }
        d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 2, str, String.valueOf(j)));
        if (f46919e) {
            Log.d("IpcSp", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f48971a.getLong("result_value"));
        }
        return b2.f48971a.getLong("result_value");
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.f46921c) {
            return j(str, str2);
        }
        d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 4, str, str2));
        if (f46919e) {
            Log.d("IpcSp", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f48971a.getString("result_value"));
        }
        return b2.f48971a.getString("result_value");
    }

    public long h(String str, long j) {
        return super.getLong(str, j);
    }

    public String i() {
        return this.f46922d;
    }

    public String j(String str, String str2) {
        return super.getString(str, str2);
    }

    public boolean k() {
        return this.f46921c;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (this.f46921c) {
            super.putBoolean(str, z);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 3, str, String.valueOf(z)));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        if (this.f46921c) {
            super.putFloat(str, f2);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 5, str, String.valueOf(f2)));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        if (this.f46921c) {
            super.putInt(str, i2);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 1, str, String.valueOf(i2)));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (this.f46921c) {
            super.edit().putLong(str, j).commit();
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 2, str, String.valueOf(j)));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (this.f46921c) {
            super.putString(str, str2);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 4, str, str2));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (this.f46921c) {
            super.remove(str);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 101, str, ""));
        }
        return this;
    }
}
