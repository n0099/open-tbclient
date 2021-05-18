package d.a.i0.a.f1.e.f;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import d.a.i0.a.f1.e.f.c;
import d.a.i0.a.v2.e1.d;
import d.a.i0.a.v2.y0;
import kotlin.TypeCastException;
/* loaded from: classes3.dex */
public abstract class c<SelfT extends c<SelfT>> implements d<SelfT> {

    /* renamed from: e  reason: collision with root package name */
    public Bundle f41677e;

    /* loaded from: classes3.dex */
    public static final class a extends c<a> {
        public a E() {
            return this;
        }

        @Override // d.a.i0.a.v2.e1.d
        public /* bridge */ /* synthetic */ d a() {
            E();
            return this;
        }
    }

    public c() {
        this(null);
    }

    public SelfT A(String str) {
        if (q()) {
            this.f41677e.remove(str);
        }
        return (SelfT) a();
    }

    public Bundle B() {
        if (!q()) {
            this.f41677e = new Bundle();
        }
        return this.f41677e;
    }

    public Bundle C() {
        return q() ? new Bundle(B()) : new Bundle();
    }

    public SelfT D(Bundle bundle) {
        r(bundle);
        return (SelfT) a();
    }

    public SelfT b() {
        if (q()) {
            this.f41677e.clear();
        }
        return (SelfT) a();
    }

    public boolean c(String str) {
        return q() && this.f41677e.containsKey(str);
    }

    public boolean d(String str) {
        return d.a.i0.a.f1.e.f.a.f41668a.a(this, str).booleanValue();
    }

    public boolean e(String str, boolean z) {
        return d.a.i0.a.f1.e.f.a.f41668a.b(this, str, Boolean.valueOf(z)).booleanValue();
    }

    @Nullable
    public Bundle f(@Nullable String str) {
        return d.a.i0.a.f1.e.f.a.f41674g.a(this, str);
    }

    public float g(String str) {
        return d.a.i0.a.f1.e.f.a.f41671d.a(this, str).floatValue();
    }

    public float h(String str, float f2) {
        return d.a.i0.a.f1.e.f.a.f41671d.b(this, str, Float.valueOf(f2)).floatValue();
    }

    public int i(String str) {
        return d.a.i0.a.f1.e.f.a.f41669b.a(this, str).intValue();
    }

    public int j(String str, int i2) {
        return d.a.i0.a.f1.e.f.a.f41669b.b(this, str, Integer.valueOf(i2)).intValue();
    }

    public long k(String str) {
        return d.a.i0.a.f1.e.f.a.f41670c.a(this, str).longValue();
    }

    public long l(String str, long j) {
        return d.a.i0.a.f1.e.f.a.f41670c.b(this, str, Long.valueOf(j)).longValue();
    }

    @Nullable
    public <T extends Parcelable> T m(@Nullable String str) {
        try {
            return (T) d.a.i0.a.f1.e.f.a.f41675h.a(this, str);
        } catch (TypeCastException unused) {
            return null;
        }
    }

    @Nullable
    public String n(@Nullable String str) {
        return d.a.i0.a.f1.e.f.a.f41672e.a(this, str);
    }

    public String o(@Nullable String str, String str2) {
        return d.a.i0.a.f1.e.f.a.f41672e.b(this, str, str2);
    }

    @Nullable
    public String[] p(@Nullable String str) {
        return d.a.i0.a.f1.e.f.a.f41673f.a(this, str);
    }

    public final boolean q() {
        return this.f41677e != null;
    }

    public SelfT r(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            B().putAll(bundle);
        }
        return (SelfT) a();
    }

    public SelfT s(@Nullable String str, boolean z) {
        d.a.i0.a.f1.e.f.a.f41668a.d(this, str, Boolean.valueOf(z));
        return (SelfT) a();
    }

    public SelfT t(@Nullable String str, @Nullable Bundle bundle) {
        d.a.i0.a.f1.e.f.a.f41674g.d(this, str, bundle);
        return (SelfT) a();
    }

    public synchronized String toString() {
        return q() ? this.f41677e.toString() : "empty";
    }

    public SelfT u(@Nullable String str, float f2) {
        d.a.i0.a.f1.e.f.a.f41671d.d(this, str, Float.valueOf(f2));
        return (SelfT) a();
    }

    public SelfT v(@Nullable String str, int i2) {
        d.a.i0.a.f1.e.f.a.f41669b.d(this, str, Integer.valueOf(i2));
        return (SelfT) a();
    }

    public SelfT w(@Nullable String str, long j) {
        d.a.i0.a.f1.e.f.a.f41670c.d(this, str, Long.valueOf(j));
        return (SelfT) a();
    }

    public SelfT x(@Nullable String str, @Nullable Parcelable parcelable) {
        d.a.i0.a.f1.e.f.a.f41675h.d(this, str, parcelable);
        return (SelfT) a();
    }

    public SelfT y(@Nullable String str, @Nullable String str2) {
        d.a.i0.a.f1.e.f.a.f41672e.d(this, str, str2);
        return (SelfT) a();
    }

    public SelfT z(@Nullable String str, @Nullable String[] strArr) {
        d.a.i0.a.f1.e.f.a.f41673f.d(this, str, strArr);
        return (SelfT) a();
    }

    public c(Bundle bundle) {
        new y0();
        this.f41677e = bundle;
    }
}
