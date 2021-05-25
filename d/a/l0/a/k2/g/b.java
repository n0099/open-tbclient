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
    public static final boolean f43243e = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences$EditorC0728b f43244b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f43245c;

    /* renamed from: d  reason: collision with root package name */
    public final String f43246d;

    /* renamed from: d.a.l0.a.k2.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class SharedPreferences$EditorC0728b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Deque<Runnable> f43247a;

        /* renamed from: d.a.l0.a.k2.g.b$b$a */
        /* loaded from: classes3.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43249e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43250f;

            public a(String str, String str2) {
                this.f43249e = str;
                this.f43250f = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putString(this.f43249e, this.f43250f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0729b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43252e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Set f43253f;

            public RunnableC0729b(String str, Set set) {
                this.f43252e = str;
                this.f43253f = set;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putStringSet(this.f43252e, this.f43253f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$c */
        /* loaded from: classes3.dex */
        public class c implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43255e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f43256f;

            public c(String str, int i2) {
                this.f43255e = str;
                this.f43256f = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putInt(this.f43255e, this.f43256f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$d */
        /* loaded from: classes3.dex */
        public class d implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43258e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ long f43259f;

            public d(String str, long j) {
                this.f43258e = str;
                this.f43259f = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putLong(this.f43258e, this.f43259f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$e */
        /* loaded from: classes3.dex */
        public class e implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43261e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ float f43262f;

            public e(String str, float f2) {
                this.f43261e = str;
                this.f43262f = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putFloat(this.f43261e, this.f43262f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$f */
        /* loaded from: classes3.dex */
        public class f implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43264e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ boolean f43265f;

            public f(String str, boolean z) {
                this.f43264e = str;
                this.f43265f = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.putBoolean(this.f43264e, this.f43265f);
            }
        }

        /* renamed from: d.a.l0.a.k2.g.b$b$g */
        /* loaded from: classes3.dex */
        public class g implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43267e;

            public g(String str) {
                this.f43267e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.remove(this.f43267e);
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

        public SharedPreferences$EditorC0728b() {
            this.f43247a = new ArrayDeque();
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
            synchronized (this.f43247a) {
                while (!this.f43247a.isEmpty()) {
                    Runnable poll = this.f43247a.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            }
            return true;
        }

        public final SharedPreferences$EditorC0728b e(Runnable runnable) {
            synchronized (this.f43247a) {
                this.f43247a.offer(runnable);
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
            e(new RunnableC0729b(str, set));
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
        this.f43244b = new SharedPreferences$EditorC0728b();
        this.f43246d = str;
        this.f43245c = ProcessUtils.isMainProcess() || b();
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        if (this.f43245c) {
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
        return this.f43245c ? super.edit() : this.f43244b;
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
            if (this.f43245c) {
                return e(str, z);
            }
            d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 3, str, String.valueOf(z)));
            if (f43243e) {
                Log.d("IpcSp", "getBoolean processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f45297a.getBoolean("result_value"));
            }
            return b2.f45297a.getBoolean("result_value");
        } catch (ClassCastException e2) {
            Log.e("IpcSp", "getBoolean", e2);
            return false;
        }
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        if (this.f43245c) {
            return f(str, f2);
        }
        d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 5, str, String.valueOf(f2)));
        if (f43243e) {
            Log.d("IpcSp", "getFloat processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f45297a.getFloat("result_value"));
        }
        return b2.f45297a.getFloat("result_value");
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public int getInt(String str, int i2) {
        if (this.f43245c) {
            return g(str, i2);
        }
        d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 1, str, String.valueOf(i2)));
        if (f43243e) {
            Log.d("IpcSp", "getInt processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f45297a.getInt("result_value"));
        }
        return b2.f45297a.getInt("result_value");
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public long getLong(String str, long j) {
        if (this.f43245c) {
            return h(str, j);
        }
        d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 2, str, String.valueOf(j)));
        if (f43243e) {
            Log.d("IpcSp", "getLong processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f45297a.getLong("result_value"));
        }
        return b2.f45297a.getLong("result_value");
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences
    public String getString(String str, String str2) {
        if (this.f43245c) {
            return j(str, str2);
        }
        d.a.l0.a.v1.b.f b2 = d.a.l0.a.v1.b.d.b(e.class, c.a(i(), 4, str, str2));
        if (f43243e) {
            Log.d("IpcSp", "getString processName:" + ProcessUtils.getCurProcessName() + " result value:" + b2.f45297a.getString("result_value"));
        }
        return b2.f45297a.getString("result_value");
    }

    public long h(String str, long j) {
        return super.getLong(str, j);
    }

    public String i() {
        return this.f43246d;
    }

    public String j(String str, String str2) {
        return super.getString(str, str2);
    }

    public boolean k() {
        return this.f43245c;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        if (this.f43245c) {
            super.putBoolean(str, z);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 3, str, String.valueOf(z)));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f2) {
        if (this.f43245c) {
            super.putFloat(str, f2);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 5, str, String.valueOf(f2)));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i2) {
        if (this.f43245c) {
            super.putInt(str, i2);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 1, str, String.valueOf(i2)));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        if (this.f43245c) {
            super.edit().putLong(str, j).commit();
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 2, str, String.valueOf(j)));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        if (this.f43245c) {
            super.putString(str, str2);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 4, str, str2));
        }
        return this;
    }

    @Override // d.a.l0.a.k2.g.g, android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        if (this.f43245c) {
            super.remove(str);
        } else {
            d.a.l0.a.v1.b.d.b(f.class, c.a(i(), 101, str, ""));
        }
        return this;
    }
}
