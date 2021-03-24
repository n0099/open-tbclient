package d.b.g0.a.n1.c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Message f45366a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<SwanAppProcessInfo> f45367b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f45368c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f45369d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f45370e;

    /* renamed from: f  reason: collision with root package name */
    public long f45371f;

    public c(Message message) {
        this.f45367b = new HashSet();
        this.f45368c = new HashSet();
        this.f45369d = false;
        this.f45370e = false;
        this.f45371f = 0L;
        this.f45366a = message == null ? Message.obtain() : message;
    }

    public c a(int... iArr) {
        if (iArr != null) {
            for (int i : iArr) {
                if (SwanAppProcessInfo.checkProcessId(i)) {
                    b(SwanAppProcessInfo.indexOf(i));
                }
            }
        }
        return this;
    }

    public c b(SwanAppProcessInfo... swanAppProcessInfoArr) {
        if (swanAppProcessInfoArr != null) {
            this.f45367b.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c c(String... strArr) {
        if (strArr != null) {
            this.f45368c.addAll(Arrays.asList(strArr));
        }
        return this;
    }

    public c d() {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess()) {
                b(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c e(int... iArr) {
        SwanAppProcessInfo[] indices;
        for (SwanAppProcessInfo swanAppProcessInfo : SwanAppProcessInfo.indices()) {
            if (swanAppProcessInfo.isSwanAppProcess() && !g(iArr, swanAppProcessInfo.index)) {
                b(swanAppProcessInfo);
            }
        }
        return this;
    }

    public c f(boolean z) {
        this.f45369d = z;
        return this;
    }

    public final boolean g(int[] iArr, int i) {
        if (iArr != null) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    @NonNull
    public Message h() {
        if (this.f45366a.obj == null) {
            o(new Bundle());
        }
        return this.f45366a;
    }

    public long i() {
        long j = this.f45371f;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public c j(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f45371f = j;
        return this;
    }

    public Set<String> k() {
        return new HashSet(this.f45368c);
    }

    public Set<SwanAppProcessInfo> l() {
        return new HashSet(this.f45367b);
    }

    public boolean m() {
        return this.f45369d;
    }

    public boolean n() {
        return this.f45370e;
    }

    public c o(Object obj) {
        this.f45366a.obj = obj;
        return this;
    }

    public c p(boolean z) {
        this.f45370e = z;
        return this;
    }

    public c(int i, Object obj) {
        this(Message.obtain(null, i, obj));
    }

    public c(int i) {
        this(Message.obtain((Handler) null, i));
    }
}
