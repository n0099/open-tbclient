package d.b.g0.a.y0.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import d.b.g0.a.i2.q0;
import d.b.g0.a.i2.u0.d;
import d.b.g0.a.y0.e.f.c;
import kotlin.TypeCastException;
/* loaded from: classes2.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {

    /* renamed from: e  reason: collision with root package name */
    public Bundle f47105e;

    /* renamed from: f  reason: collision with root package name */
    public final q0 f47106f;

    /* loaded from: classes2.dex */
    public static final class a extends c<a> {
        public a D() {
            return this;
        }

        @Override // d.b.g0.a.i2.u0.d
        public /* bridge */ /* synthetic */ d a() {
            D();
            return this;
        }
    }

    public c() {
        this(null);
    }

    public Bundle A() {
        return o() ? new Bundle(z()) : new Bundle();
    }

    public q0 B() {
        return this.f47106f;
    }

    public SelfT C(Bundle bundle) {
        p(bundle);
        return (SelfT) a();
    }

    public SelfT b() {
        if (o()) {
            this.f47105e.clear();
        }
        return (SelfT) a();
    }

    public boolean c(String str) {
        return o() && this.f47105e.containsKey(str);
    }

    public boolean d(String str, boolean z) {
        return d.b.g0.a.y0.e.f.a.f47092a.b(this, str, Boolean.valueOf(z)).booleanValue();
    }

    @Nullable
    public Bundle e(@Nullable String str) {
        return d.b.g0.a.y0.e.f.a.f47098g.a(this, str);
    }

    public float f(String str) {
        return d.b.g0.a.y0.e.f.a.f47095d.a(this, str).floatValue();
    }

    public float g(String str, float f2) {
        return d.b.g0.a.y0.e.f.a.f47095d.b(this, str, Float.valueOf(f2)).floatValue();
    }

    public int h(String str) {
        return d.b.g0.a.y0.e.f.a.f47093b.a(this, str).intValue();
    }

    public int i(String str, int i) {
        return d.b.g0.a.y0.e.f.a.f47093b.b(this, str, Integer.valueOf(i)).intValue();
    }

    public long j(String str) {
        return d.b.g0.a.y0.e.f.a.f47094c.a(this, str).longValue();
    }

    public long k(String str, long j) {
        return d.b.g0.a.y0.e.f.a.f47094c.b(this, str, Long.valueOf(j)).longValue();
    }

    @Nullable
    public <T extends Parcelable> T l(@Nullable String str) {
        try {
            return (T) d.b.g0.a.y0.e.f.a.f47099h.a(this, str);
        } catch (TypeCastException unused) {
            return null;
        }
    }

    @Nullable
    public String m(@Nullable String str) {
        return d.b.g0.a.y0.e.f.a.f47096e.a(this, str);
    }

    public String n(@Nullable String str, String str2) {
        return d.b.g0.a.y0.e.f.a.f47096e.b(this, str, str2);
    }

    public final boolean o() {
        return this.f47105e != null;
    }

    public SelfT p(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            z().putAll(bundle);
        }
        return (SelfT) a();
    }

    public SelfT q(@Nullable String str, boolean z) {
        d.b.g0.a.y0.e.f.a.f47092a.d(this, str, Boolean.valueOf(z));
        return (SelfT) a();
    }

    public SelfT r(@Nullable String str, @Nullable Bundle bundle) {
        d.b.g0.a.y0.e.f.a.f47098g.d(this, str, bundle);
        return (SelfT) a();
    }

    public SelfT s(@Nullable String str, float f2) {
        d.b.g0.a.y0.e.f.a.f47095d.d(this, str, Float.valueOf(f2));
        return (SelfT) a();
    }

    public SelfT t(@Nullable String str, int i) {
        d.b.g0.a.y0.e.f.a.f47093b.d(this, str, Integer.valueOf(i));
        return (SelfT) a();
    }

    public synchronized String toString() {
        return o() ? this.f47105e.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }

    public SelfT u(@Nullable String str, long j) {
        d.b.g0.a.y0.e.f.a.f47094c.d(this, str, Long.valueOf(j));
        return (SelfT) a();
    }

    public SelfT v(@Nullable String str, @Nullable Parcelable parcelable) {
        d.b.g0.a.y0.e.f.a.f47099h.d(this, str, parcelable);
        return (SelfT) a();
    }

    public SelfT w(@Nullable String str, @Nullable String str2) {
        d.b.g0.a.y0.e.f.a.f47096e.d(this, str, str2);
        return (SelfT) a();
    }

    public SelfT x(@Nullable String str, @Nullable String[] strArr) {
        d.b.g0.a.y0.e.f.a.f47097f.d(this, str, strArr);
        return (SelfT) a();
    }

    public SelfT y(String str) {
        if (o()) {
            this.f47105e.remove(str);
        }
        return (SelfT) a();
    }

    public Bundle z() {
        if (!o()) {
            this.f47105e = new Bundle();
        }
        return this.f47105e;
    }

    public c(Bundle bundle) {
        this.f47106f = new q0();
        this.f47105e = bundle;
    }
}
