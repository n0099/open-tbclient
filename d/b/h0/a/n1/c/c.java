package d.b.h0.a.n1.c;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Message f46088a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<SwanAppProcessInfo> f46089b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f46090c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46091d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f46092e;

    /* renamed from: f  reason: collision with root package name */
    public long f46093f;

    public c(Message message) {
        this.f46089b = new HashSet();
        this.f46090c = new HashSet();
        this.f46091d = false;
        this.f46092e = false;
        this.f46093f = 0L;
        this.f46088a = message == null ? Message.obtain() : message;
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
            this.f46089b.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c c(String... strArr) {
        if (strArr != null) {
            this.f46090c.addAll(Arrays.asList(strArr));
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
        this.f46091d = z;
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
        if (this.f46088a.obj == null) {
            o(new Bundle());
        }
        return this.f46088a;
    }

    public long i() {
        long j = this.f46093f;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public c j(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f46093f = j;
        return this;
    }

    public Set<String> k() {
        return new HashSet(this.f46090c);
    }

    public Set<SwanAppProcessInfo> l() {
        return new HashSet(this.f46089b);
    }

    public boolean m() {
        return this.f46091d;
    }

    public boolean n() {
        return this.f46092e;
    }

    public c o(Object obj) {
        this.f46088a.obj = obj;
        return this;
    }

    public c p(boolean z) {
        this.f46092e = z;
        return this;
    }

    public c(int i, Object obj) {
        this(Message.obtain(null, i, obj));
    }

    public c(int i) {
        this(Message.obtain((Handler) null, i));
    }
}
