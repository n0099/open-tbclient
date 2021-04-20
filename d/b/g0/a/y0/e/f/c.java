package d.b.g0.a.y0.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d.b.g0.a.i2.q0;
import d.b.g0.a.i2.u0.d;
import d.b.g0.a.y0.e.f.c;
import kotlin.TypeCastException;
/* loaded from: classes2.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {

    /* renamed from: e  reason: collision with root package name */
    public Bundle f47497e;

    /* renamed from: f  reason: collision with root package name */
    public final q0 f47498f;

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
        return this.f47498f;
    }

    public SelfT C(Bundle bundle) {
        p(bundle);
        return (SelfT) a();
    }

    public SelfT b() {
        if (o()) {
            this.f47497e.clear();
        }
        return (SelfT) a();
    }

    public boolean c(String str) {
        return o() && this.f47497e.containsKey(str);
    }

    public boolean d(String str, boolean z) {
        return d.b.g0.a.y0.e.f.a.f47484a.b(this, str, Boolean.valueOf(z)).booleanValue();
    }

    @Nullable
    public Bundle e(@Nullable String str) {
        return d.b.g0.a.y0.e.f.a.f47490g.a(this, str);
    }

    public float f(String str) {
        return d.b.g0.a.y0.e.f.a.f47487d.a(this, str).floatValue();
    }

    public float g(String str, float f2) {
        return d.b.g0.a.y0.e.f.a.f47487d.b(this, str, Float.valueOf(f2)).floatValue();
    }

    public int h(String str) {
        return d.b.g0.a.y0.e.f.a.f47485b.a(this, str).intValue();
    }

    public int i(String str, int i) {
        return d.b.g0.a.y0.e.f.a.f47485b.b(this, str, Integer.valueOf(i)).intValue();
    }

    public long j(String str) {
        return d.b.g0.a.y0.e.f.a.f47486c.a(this, str).longValue();
    }

    public long k(String str, long j) {
        return d.b.g0.a.y0.e.f.a.f47486c.b(this, str, Long.valueOf(j)).longValue();
    }

    @Nullable
    public <T extends Parcelable> T l(@Nullable String str) {
        try {
            return (T) d.b.g0.a.y0.e.f.a.f47491h.a(this, str);
        } catch (TypeCastException unused) {
            return null;
        }
    }

    @Nullable
    public String m(@Nullable String str) {
        return d.b.g0.a.y0.e.f.a.f47488e.a(this, str);
    }

    public String n(@Nullable String str, String str2) {
        return d.b.g0.a.y0.e.f.a.f47488e.b(this, str, str2);
    }

    public final boolean o() {
        return this.f47497e != null;
    }

    public SelfT p(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            z().putAll(bundle);
        }
        return (SelfT) a();
    }

    public SelfT q(@Nullable String str, boolean z) {
        d.b.g0.a.y0.e.f.a.f47484a.d(this, str, Boolean.valueOf(z));
        return (SelfT) a();
    }

    public SelfT r(@Nullable String str, @Nullable Bundle bundle) {
        d.b.g0.a.y0.e.f.a.f47490g.d(this, str, bundle);
        return (SelfT) a();
    }

    public SelfT s(@Nullable String str, float f2) {
        d.b.g0.a.y0.e.f.a.f47487d.d(this, str, Float.valueOf(f2));
        return (SelfT) a();
    }

    public SelfT t(@Nullable String str, int i) {
        d.b.g0.a.y0.e.f.a.f47485b.d(this, str, Integer.valueOf(i));
        return (SelfT) a();
    }

    public synchronized String toString() {
        return o() ? this.f47497e.toString() : "empty";
    }

    public SelfT u(@Nullable String str, long j) {
        d.b.g0.a.y0.e.f.a.f47486c.d(this, str, Long.valueOf(j));
        return (SelfT) a();
    }

    public SelfT v(@Nullable String str, @Nullable Parcelable parcelable) {
        d.b.g0.a.y0.e.f.a.f47491h.d(this, str, parcelable);
        return (SelfT) a();
    }

    public SelfT w(@Nullable String str, @Nullable String str2) {
        d.b.g0.a.y0.e.f.a.f47488e.d(this, str, str2);
        return (SelfT) a();
    }

    public SelfT x(@Nullable String str, @Nullable String[] strArr) {
        d.b.g0.a.y0.e.f.a.f47489f.d(this, str, strArr);
        return (SelfT) a();
    }

    public SelfT y(String str) {
        if (o()) {
            this.f47497e.remove(str);
        }
        return (SelfT) a();
    }

    public Bundle z() {
        if (!o()) {
            this.f47497e = new Bundle();
        }
        return this.f47497e;
    }

    public c(Bundle bundle) {
        this.f47498f = new q0();
        this.f47497e = bundle;
    }
}
