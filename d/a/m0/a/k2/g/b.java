package d.a.m0.a.k2.g;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import d.a.m0.a.k;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class b extends g {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47027e = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0787b f47028b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f47029c;

    /* renamed from: d  reason: collision with root package name */
    public final String f47030d;

    /* renamed from: d.a.m0.a.k2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class SharedPreferences$EditorC0787b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f47031a;

        /* renamed from: d.a.m0.a.k2.g.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47033e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f47034f;

            public a(String str, String str2) {
                this.f47033e = str;
                this.f47034f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putString(this.f47033e, this.f47034f);
            }
        }

        /* renamed from: d.a.m0.a.k2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0788b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47036e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f47037f;

            public RunnableC0788b(String str, Set set) {
                this.f47036e = str;
                this.f47037f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putStringSet(this.f47036e, this.f47037f);
            }
        }

        /* renamed from: d.a.m0.a.k2.g.b$b$c */
        /* loaded from: classes3.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47039e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f47040f;

            public c(String str, int i2) {
                this.f47039e = str;
                this.f47040f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putInt(this.f47039e, this.f47040f);
            }
        }

        /* renamed from: d.a.m0.a.k2.g.b$b$d */
        /* loaded from: classes3.dex */
        public class d implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47042e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f47043f;

            public d(String str, long j) {
                this.f47042e = str;
                this.f47043f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putLong(this.f47042e, this.f47043f);
            }
        }

        /* renamed from: d.a.m0.a.k2.g.b$b$e */
        /* loaded from: classes3.dex */
        public class e implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47045e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f47046f;

            public e(String str, float f2) {
                this.f47045e = str;
                this.f47046f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putFloat(this.f47045e, this.f47046f);
            }
        }

        /* renamed from: d.a.m0.a.k2.g.b$b$f */
        /* loaded from: classes3.dex */
        public class f implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47048e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f47049f;

            public f(String str, boolean z) {
                this.f47048e = str;
                this.f47049f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putBoolean(this.f47048e, this.f47049f);
            }
        }

        /* renamed from: d.a.m0.a.k2.g.b$b$g */
        /* loaded from: classes3.dex */
        public class g implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f47051e;

            public g(String str) {
                this.f47051e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.remove(this.f47051e);
            }
        }

        /* renamed from: d.a.m0.a.k2.g.b$b$h */
        /* loaded from: classes3.dex */
        public class h implements Runnable {
            public h() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.clear();
            }
        }

        public SharedPreferences$EditorC0787b() {
            this.f47031a = new ArrayDeque();
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
            synchronized (this.f47031a) {
                while (!this.f47031a.isEmpty()) {
                    Runnable poll = this.f47031a.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            }
            return true;
        }

        public final SharedPreferences$EditorC0787b e(Runnable runnable) {
            synchronized (this.f47031a) {
                this.f47031a.offer(runnable);
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
            e(new RunnableC0788b(str, set));
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
        this.f47028b = new SharedPreferences$EditorC0787b();
        this.f47030d = str;
        this.f47029c = ProcessUtils.isMainProcess() || b();
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        if (this.f47029c) {
            super.clear();
        } else {
            d.a.m0.a.v1.b.d.b(f.class, c.a(i(), 100, "", ""));
        }
        return this;
    }

    public boolean e(String str, boolean z) {
        return super.getBoolean(str, z);
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.f47029c ? super.edit() : this.f47028b;
    }

    public float f(String str, float f2) {
        return super.getFloat(str, f2);
    }

    public int g(String str, int i2) {
        return super.getInt(str, i2);
    }

    @Override // d.a.m0.a.k2.g.g, d.a.m0.t.b, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return k() ? super.getAll() : new HashMap(super.getAll());
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            if (this.f47029c) {
                return e(str, z);
            }
            d.a.m0.a.v1.b.f b2 = d.a.m0.a.v1.b.d.b(e.class, c.a(i(), 3, str, String.valueOf(z)));
            if (f47027e) {
                Log.d("IpcSp", "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f49079a.getBoolean("result_value"));
            }
            return b2.f49079a.getBoolean("result_value");
        } catch (ClassCastException e2) {
            Log.e("IpcSp", "getBoolean", e2);
            return false;
        }
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        if (this.f47029c) {
            return f(str, f2);
        }
        d.a.m0.a.v1.b.f b2 = d.a.m0.a.v1.b.d.b(e.class, c.a(i(), 5, str, String.valueOf(f2)));
        if (f47027e) {
            Log.d("IpcSp", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f49079a.getFloat("result_value"));
        }
        return b2.f49079a.getFloat("result_value");
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        if (this.f47029c) {
            return g(str, i2);
        }
        d.a.m0.a.v1.b.f b2 = d.a.m0.a.v1.b.d.b(e.class, c.a(i(), 1, str, String.valueOf(i2)));
        if (f47027e) {
            Log.d("IpcSp", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f49079a.getInt("result_value"));
        }
        return b2.f49079a.getInt("result_value");
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.f47029c) {
            return h(str, j);
        }
        d.a.m0.a.v1.b.f b2 = d.a.m0.a.v1.b.d.b(e.class, c.a(i(), 2, str, String.valueOf(j)));
        if (f47027e) {
            Log.d("IpcSp", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f49079a.getLong("result_value"));
        }
        return b2.f49079a.getLong("result_value");
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.f47029c) {
            return j(str, str2);
        }
        d.a.m0.a.v1.b.f b2 = d.a.m0.a.v1.b.d.b(e.class, c.a(i(), 4, str, str2));
        if (f47027e) {
            Log.d("IpcSp", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f49079a.getString("result_value"));
        }
        return b2.f49079a.getString("result_value");
    }

    public long h(String str, long j) {
        return super.getLong(str, j);
    }

    public String i() {
        return this.f47030d;
    }

    public String j(String str, String str2) {
        return super.getString(str, str2);
    }

    public boolean k() {
        return this.f47029c;
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (this.f47029c) {
            super.putBoolean(str, z);
        } else {
            d.a.m0.a.v1.b.d.b(f.class, c.a(i(), 3, str, String.valueOf(z)));
        }
        return this;
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        if (this.f47029c) {
            super.putFloat(str, f2);
        } else {
            d.a.m0.a.v1.b.d.b(f.class, c.a(i(), 5, str, String.valueOf(f2)));
        }
        return this;
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        if (this.f47029c) {
            super.putInt(str, i2);
        } else {
            d.a.m0.a.v1.b.d.b(f.class, c.a(i(), 1, str, String.valueOf(i2)));
        }
        return this;
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (this.f47029c) {
            super.edit().putLong(str, j).commit();
        } else {
            d.a.m0.a.v1.b.d.b(f.class, c.a(i(), 2, str, String.valueOf(j)));
        }
        return this;
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (this.f47029c) {
            super.putString(str, str2);
        } else {
            d.a.m0.a.v1.b.d.b(f.class, c.a(i(), 4, str, str2));
        }
        return this;
    }

    @Override // d.a.m0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (this.f47029c) {
            super.remove(str);
        } else {
            d.a.m0.a.v1.b.d.b(f.class, c.a(i(), 101, str, ""));
        }
        return this;
    }
}
