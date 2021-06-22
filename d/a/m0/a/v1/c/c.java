package d.a.m0.a.v1.c;

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
    public final Message f49085a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<SwanAppProcessInfo> f49086b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f49087c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f49088d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f49089e;

    /* renamed from: f  reason: collision with root package name */
    public long f49090f;

    public c(Message message) {
        this.f49086b = new HashSet();
        this.f49087c = new HashSet();
        this.f49088d = false;
        this.f49089e = false;
        this.f49090f = 0L;
        this.f49085a = message == null ? Message.obtain() : message;
    }

    public c a(int... iArr) {
        if (iArr != null) {
            for (int i2 : iArr) {
                if (SwanAppProcessInfo.checkProcessId(i2)) {
                    b(SwanAppProcessInfo.indexOf(i2));
                }
            }
        }
        return this;
    }

    public c b(SwanAppProcessInfo... swanAppProcessInfoArr) {
        if (swanAppProcessInfoArr != null) {
            this.f49086b.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c c(String... strArr) {
        if (strArr != null) {
            this.f49087c.addAll(Arrays.asList(strArr));
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
        this.f49088d = z;
        return this;
    }

    public final boolean g(int[] iArr, int i2) {
        if (iArr != null) {
            for (int i3 : iArr) {
                if (i3 == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    @NonNull
    public Message h() {
        if (this.f49085a.obj == null) {
            o(new Bundle());
        }
        return this.f49085a;
    }

    public long i() {
        long j = this.f49090f;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public c j(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f49090f = j;
        return this;
    }

    public Set<String> k() {
        return new HashSet(this.f49087c);
    }

    public Set<SwanAppProcessInfo> l() {
        return new HashSet(this.f49086b);
    }

    public boolean m() {
        return this.f49088d;
    }

    public boolean n() {
        return this.f49089e;
    }

    public c o(Object obj) {
        this.f49085a.obj = obj;
        return this;
    }

    public c p(boolean z) {
        this.f49089e = z;
        return this;
    }

    public c(int i2, Object obj) {
        this(Message.obtain(null, i2, obj));
    }

    public c(int i2) {
        this(Message.obtain((Handler) null, i2));
    }
}
