package d.b.g0.a.y0.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import d.b.g0.a.i2.q0;
import d.b.g0.a.i2.u0.d;
import d.b.g0.a.y0.e.f.c;
import kotlin.TypeCastException;
/* loaded from: classes3.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {

    /* renamed from: e  reason: collision with root package name */
    public Bundle f47104e;

    /* renamed from: f  reason: collision with root package name */
    public final q0 f47105f;

    /* loaded from: classes3.dex */
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
        return this.f47105f;
    }

    public SelfT C(Bundle bundle) {
        p(bundle);
        return (SelfT) a();
    }

    public SelfT b() {
        if (o()) {
            this.f47104e.clear();
        }
        return (SelfT) a();
    }

    public boolean c(String str) {
        return o() && this.f47104e.containsKey(str);
    }

    public boolean d(String str, boolean z) {
        return d.b.g0.a.y0.e.f.a.f47091a.b(this, str, Boolean.valueOf(z)).booleanValue();
    }

    @Nullable
    public Bundle e(@Nullable String str) {
        return d.b.g0.a.y0.e.f.a.f47097g.a(this, str);
    }

    public float f(String str) {
        return d.b.g0.a.y0.e.f.a.f47094d.a(this, str).floatValue();
    }

    public float g(String str, float f2) {
        return d.b.g0.a.y0.e.f.a.f47094d.b(this, str, Float.valueOf(f2)).floatValue();
    }

    public int h(String str) {
        return d.b.g0.a.y0.e.f.a.f47092b.a(this, str).intValue();
    }

    public int i(String str, int i) {
        return d.b.g0.a.y0.e.f.a.f47092b.b(this, str, Integer.valueOf(i)).intValue();
    }

    public long j(String str) {
        return d.b.g0.a.y0.e.f.a.f47093c.a(this, str).longValue();
    }

    public long k(String str, long j) {
        return d.b.g0.a.y0.e.f.a.f47093c.b(this, str, Long.valueOf(j)).longValue();
    }

    @Nullable
    public <T extends Parcelable> T l(@Nullable String str) {
        try {
            return (T) d.b.g0.a.y0.e.f.a.f47098h.a(this, str);
        } catch (TypeCastException unused) {
            return null;
        }
    }

    @Nullable
    public String m(@Nullable String str) {
        return d.b.g0.a.y0.e.f.a.f47095e.a(this, str);
    }

    public String n(@Nullable String str, String str2) {
        return d.b.g0.a.y0.e.f.a.f47095e.b(this, str, str2);
    }

    public final boolean o() {
        return this.f47104e != null;
    }

    public SelfT p(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            z().putAll(bundle);
        }
        return (SelfT) a();
    }

    public SelfT q(@Nullable String str, boolean z) {
        d.b.g0.a.y0.e.f.a.f47091a.d(this, str, Boolean.valueOf(z));
        return (SelfT) a();
    }

    public SelfT r(@Nullable String str, @Nullable Bundle bundle) {
        d.b.g0.a.y0.e.f.a.f47097g.d(this, str, bundle);
        return (SelfT) a();
    }

    public SelfT s(@Nullable String str, float f2) {
        d.b.g0.a.y0.e.f.a.f47094d.d(this, str, Float.valueOf(f2));
        return (SelfT) a();
    }

    public SelfT t(@Nullable String str, int i) {
        d.b.g0.a.y0.e.f.a.f47092b.d(this, str, Integer.valueOf(i));
        return (SelfT) a();
    }

    public synchronized String toString() {
        return o() ? this.f47104e.toString() : SchemeCollecter.CLASSIFY_EMPTY;
    }

    public SelfT u(@Nullable String str, long j) {
        d.b.g0.a.y0.e.f.a.f47093c.d(this, str, Long.valueOf(j));
        return (SelfT) a();
    }

    public SelfT v(@Nullable String str, @Nullable Parcelable parcelable) {
        d.b.g0.a.y0.e.f.a.f47098h.d(this, str, parcelable);
        return (SelfT) a();
    }

    public SelfT w(@Nullable String str, @Nullable String str2) {
        d.b.g0.a.y0.e.f.a.f47095e.d(this, str, str2);
        return (SelfT) a();
    }

    public SelfT x(@Nullable String str, @Nullable String[] strArr) {
        d.b.g0.a.y0.e.f.a.f47096f.d(this, str, strArr);
        return (SelfT) a();
    }

    public SelfT y(String str) {
        if (o()) {
            this.f47104e.remove(str);
        }
        return (SelfT) a();
    }

    public Bundle z() {
        if (!o()) {
            this.f47104e = new Bundle();
        }
        return this.f47104e;
    }

    public c(Bundle bundle) {
        this.f47105f = new q0();
        this.f47104e = bundle;
    }
}
