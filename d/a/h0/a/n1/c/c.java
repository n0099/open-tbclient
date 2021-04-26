package d.a.h0.a.n1.c;

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
    public final Message f43432a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<SwanAppProcessInfo> f43433b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f43434c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f43435d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f43436e;

    /* renamed from: f  reason: collision with root package name */
    public long f43437f;

    public c(Message message) {
        this.f43433b = new HashSet();
        this.f43434c = new HashSet();
        this.f43435d = false;
        this.f43436e = false;
        this.f43437f = 0L;
        this.f43432a = message == null ? Message.obtain() : message;
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
            this.f43433b.addAll(Arrays.asList(swanAppProcessInfoArr));
        }
        return this;
    }

    public c c(String... strArr) {
        if (strArr != null) {
            this.f43434c.addAll(Arrays.asList(strArr));
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
        this.f43435d = z;
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
        if (this.f43432a.obj == null) {
            o(new Bundle());
        }
        return this.f43432a;
    }

    public long i() {
        long j = this.f43437f;
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public c j(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f43437f = j;
        return this;
    }

    public Set<String> k() {
        return new HashSet(this.f43434c);
    }

    public Set<SwanAppProcessInfo> l() {
        return new HashSet(this.f43433b);
    }

    public boolean m() {
        return this.f43435d;
    }

    public boolean n() {
        return this.f43436e;
    }

    public c o(Object obj) {
        this.f43432a.obj = obj;
        return this;
    }

    public c p(boolean z) {
        this.f43436e = z;
        return this;
    }

    public c(int i2, Object obj) {
        this(Message.obtain(null, i2, obj));
    }

    public c(int i2) {
        this(Message.obtain((Handler) null, i2));
    }
}
