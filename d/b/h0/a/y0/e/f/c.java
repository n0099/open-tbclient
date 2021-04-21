package d.b.h0.a.y0.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d.b.h0.a.i2.q0;
import d.b.h0.a.i2.u0.d;
import d.b.h0.a.y0.e.f.c;
import kotlin.TypeCastException;
/* loaded from: classes2.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {

    /* renamed from: e  reason: collision with root package name */
    public Bundle f47826e;

    /* renamed from: f  reason: collision with root package name */
    public final q0 f47827f;

    /* loaded from: classes2.dex */
    public static final class a extends c<a> {
        public a D() {
            return this;
        }

        @Override // d.b.h0.a.i2.u0.d
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
        return this.f47827f;
    }

    public SelfT C(Bundle bundle) {
        p(bundle);
        return (SelfT) a();
    }

    public SelfT b() {
        if (o()) {
            this.f47826e.clear();
        }
        return (SelfT) a();
    }

    public boolean c(String str) {
        return o() && this.f47826e.containsKey(str);
    }

    public boolean d(String str, boolean z) {
        return d.b.h0.a.y0.e.f.a.f47813a.b(this, str, Boolean.valueOf(z)).booleanValue();
    }

    @Nullable
    public Bundle e(@Nullable String str) {
        return d.b.h0.a.y0.e.f.a.f47819g.a(this, str);
    }

    public float f(String str) {
        return d.b.h0.a.y0.e.f.a.f47816d.a(this, str).floatValue();
    }

    public float g(String str, float f2) {
        return d.b.h0.a.y0.e.f.a.f47816d.b(this, str, Float.valueOf(f2)).floatValue();
    }

    public int h(String str) {
        return d.b.h0.a.y0.e.f.a.f47814b.a(this, str).intValue();
    }

    public int i(String str, int i) {
        return d.b.h0.a.y0.e.f.a.f47814b.b(this, str, Integer.valueOf(i)).intValue();
    }

    public long j(String str) {
        return d.b.h0.a.y0.e.f.a.f47815c.a(this, str).longValue();
    }

    public long k(String str, long j) {
        return d.b.h0.a.y0.e.f.a.f47815c.b(this, str, Long.valueOf(j)).longValue();
    }

    @Nullable
    public <T extends Parcelable> T l(@Nullable String str) {
        try {
            return (T) d.b.h0.a.y0.e.f.a.f47820h.a(this, str);
        } catch (TypeCastException unused) {
            return null;
        }
    }

    @Nullable
    public String m(@Nullable String str) {
        return d.b.h0.a.y0.e.f.a.f47817e.a(this, str);
    }

    public String n(@Nullable String str, String str2) {
        return d.b.h0.a.y0.e.f.a.f47817e.b(this, str, str2);
    }

    public final boolean o() {
        return this.f47826e != null;
    }

    public SelfT p(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            z().putAll(bundle);
        }
        return (SelfT) a();
    }

    public SelfT q(@Nullable String str, boolean z) {
        d.b.h0.a.y0.e.f.a.f47813a.d(this, str, Boolean.valueOf(z));
        return (SelfT) a();
    }

    public SelfT r(@Nullable String str, @Nullable Bundle bundle) {
        d.b.h0.a.y0.e.f.a.f47819g.d(this, str, bundle);
        return (SelfT) a();
    }

    public SelfT s(@Nullable String str, float f2) {
        d.b.h0.a.y0.e.f.a.f47816d.d(this, str, Float.valueOf(f2));
        return (SelfT) a();
    }

    public SelfT t(@Nullable String str, int i) {
        d.b.h0.a.y0.e.f.a.f47814b.d(this, str, Integer.valueOf(i));
        return (SelfT) a();
    }

    public synchronized String toString() {
        return o() ? this.f47826e.toString() : "empty";
    }

    public SelfT u(@Nullable String str, long j) {
        d.b.h0.a.y0.e.f.a.f47815c.d(this, str, Long.valueOf(j));
        return (SelfT) a();
    }

    public SelfT v(@Nullable String str, @Nullable Parcelable parcelable) {
        d.b.h0.a.y0.e.f.a.f47820h.d(this, str, parcelable);
        return (SelfT) a();
    }

    public SelfT w(@Nullable String str, @Nullable String str2) {
        d.b.h0.a.y0.e.f.a.f47817e.d(this, str, str2);
        return (SelfT) a();
    }

    public SelfT x(@Nullable String str, @Nullable String[] strArr) {
        d.b.h0.a.y0.e.f.a.f47818f.d(this, str, strArr);
        return (SelfT) a();
    }

    public SelfT y(String str) {
        if (o()) {
            this.f47826e.remove(str);
        }
        return (SelfT) a();
    }

    public Bundle z() {
        if (!o()) {
            this.f47826e = new Bundle();
        }
        return this.f47826e;
    }

    public c(Bundle bundle) {
        this.f47827f = new q0();
        this.f47826e = bundle;
    }
}
