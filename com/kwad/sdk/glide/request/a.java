package com.kwad.sdk.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.g.j;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy;
import com.kwad.sdk.glide.load.resource.bitmap.m;
import com.kwad.sdk.glide.load.resource.bitmap.o;
import com.kwad.sdk.glide.request.a;
import java.util.Map;
/* loaded from: classes3.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f10337a;
    @Nullable
    private Drawable e;
    private int f;
    @Nullable
    private Drawable g;
    private int h;
    private boolean m;
    @Nullable
    private Drawable o;
    private int p;
    private boolean t;
    @Nullable
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean z;

    /* renamed from: b  reason: collision with root package name */
    private float f10338b = 1.0f;
    @NonNull
    private com.kwad.sdk.glide.load.engine.h c = com.kwad.sdk.glide.load.engine.h.e;
    @NonNull
    private Priority d = Priority.NORMAL;
    private boolean i = true;
    private int j = -1;
    private int k = -1;
    @NonNull
    private com.kwad.sdk.glide.load.c l = com.kwad.sdk.glide.f.a.a();
    private boolean n = true;
    @NonNull
    private com.kwad.sdk.glide.load.e q = new com.kwad.sdk.glide.load.e();
    @NonNull
    private Map<Class<?>, com.kwad.sdk.glide.load.h<?>> r = new com.kwad.sdk.glide.g.b();
    @NonNull
    private Class<?> s = Object.class;
    private boolean y = true;

    @NonNull
    private T a() {
        if (this.t) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return b();
    }

    @NonNull
    private T a(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar, boolean z) {
        T b2 = z ? b(downsampleStrategy, hVar) : a(downsampleStrategy, hVar);
        b2.y = true;
        return b2;
    }

    private boolean a(int i) {
        return a(this.f10337a, i);
    }

    private static boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    private T b() {
        return this;
    }

    @NonNull
    private T c(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        return a(downsampleStrategy, hVar, false);
    }

    public final int A() {
        return this.k;
    }

    public final boolean B() {
        return k.a(this.k, this.j);
    }

    public final int C() {
        return this.j;
    }

    public final float D() {
        return this.f10338b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E() {
        return this.y;
    }

    public final boolean F() {
        return this.w;
    }

    public final boolean G() {
        return this.z;
    }

    public final boolean H() {
        return this.x;
    }

    @NonNull
    @CheckResult
    public T a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.v) {
            return (T) clone().a(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f10338b = f;
        this.f10337a |= 2;
        return a();
    }

    @NonNull
    @CheckResult
    public T a(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().a(drawable);
        }
        this.g = drawable;
        this.f10337a |= 64;
        this.h = 0;
        this.f10337a &= -129;
        return a();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull Priority priority) {
        if (this.v) {
            return (T) clone().a(priority);
        }
        this.d = (Priority) j.a(priority);
        this.f10337a |= 8;
        return a();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.kwad.sdk.glide.load.c cVar) {
        if (this.v) {
            return (T) clone().a(cVar);
        }
        this.l = (com.kwad.sdk.glide.load.c) j.a(cVar);
        this.f10337a |= 1024;
        return a();
    }

    @NonNull
    @CheckResult
    public <Y> T a(@NonNull com.kwad.sdk.glide.load.d<Y> dVar, @NonNull Y y) {
        if (this.v) {
            return (T) clone().a(dVar, y);
        }
        j.a(dVar);
        j.a(y);
        this.q.a(dVar, y);
        return a();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.kwad.sdk.glide.load.engine.h hVar) {
        if (this.v) {
            return (T) clone().a(hVar);
        }
        this.c = (com.kwad.sdk.glide.load.engine.h) j.a(hVar);
        this.f10337a |= 4;
        return a();
    }

    @NonNull
    @CheckResult
    public T a(@NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        return a(hVar, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.kwad.sdk.glide.load.h<android.graphics.Bitmap> */
    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: com.kwad.sdk.glide.load.h<android.graphics.drawable.BitmapDrawable>, com.kwad.sdk.glide.load.h<Y> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T a(@NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar, boolean z) {
        if (this.v) {
            return (T) clone().a(hVar, z);
        }
        m mVar = new m(hVar, z);
        a(Bitmap.class, hVar, z);
        a(Drawable.class, mVar, z);
        a(BitmapDrawable.class, mVar.a(), z);
        a(com.kwad.sdk.glide.load.resource.d.c.class, new com.kwad.sdk.glide.load.resource.d.f(hVar), z);
        return a();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: com.kwad.sdk.glide.load.d<com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy>, com.kwad.sdk.glide.load.d<Y> */
    @NonNull
    @CheckResult
    public T a(@NonNull DownsampleStrategy downsampleStrategy) {
        return a((com.kwad.sdk.glide.load.d<com.kwad.sdk.glide.load.d>) DownsampleStrategy.h, (com.kwad.sdk.glide.load.d) j.a(downsampleStrategy));
    }

    @NonNull
    final T a(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        if (this.v) {
            return (T) clone().a(downsampleStrategy, hVar);
        }
        a(downsampleStrategy);
        return a(hVar, false);
    }

    @NonNull
    @CheckResult
    public T a(@NonNull Class<?> cls) {
        if (this.v) {
            return (T) clone().a(cls);
        }
        this.s = (Class) j.a(cls);
        this.f10337a |= 4096;
        return a();
    }

    @NonNull
    @CheckResult
    public <Y> T a(@NonNull Class<Y> cls, @NonNull com.kwad.sdk.glide.load.h<Y> hVar) {
        return a((Class) cls, (com.kwad.sdk.glide.load.h) hVar, false);
    }

    @NonNull
    <Y> T a(@NonNull Class<Y> cls, @NonNull com.kwad.sdk.glide.load.h<Y> hVar, boolean z) {
        if (this.v) {
            return (T) clone().a(cls, hVar, z);
        }
        j.a(cls);
        j.a(hVar);
        this.r.put(cls, hVar);
        this.f10337a |= 2048;
        this.n = true;
        this.f10337a |= 65536;
        this.y = false;
        if (z) {
            this.f10337a |= 131072;
            this.m = true;
        }
        return a();
    }

    @NonNull
    @CheckResult
    public T a(boolean z) {
        if (this.v) {
            return (T) clone().a(z);
        }
        this.z = z;
        this.f10337a |= 1048576;
        return a();
    }

    @NonNull
    @CheckResult
    public T b(int i, int i2) {
        if (this.v) {
            return (T) clone().b(i, i2);
        }
        this.k = i;
        this.j = i2;
        this.f10337a |= 512;
        return a();
    }

    @NonNull
    @CheckResult
    public T b(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().b(drawable);
        }
        this.o = drawable;
        this.f10337a |= 8192;
        this.p = 0;
        this.f10337a &= -16385;
        return a();
    }

    @NonNull
    @CheckResult
    public T b(@NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        return a(hVar, false);
    }

    @NonNull
    @CheckResult
    final T b(@NonNull DownsampleStrategy downsampleStrategy, @NonNull com.kwad.sdk.glide.load.h<Bitmap> hVar) {
        if (this.v) {
            return (T) clone().b(downsampleStrategy, hVar);
        }
        a(downsampleStrategy);
        return a(hVar);
    }

    @NonNull
    @CheckResult
    public T b(@NonNull a<?> aVar) {
        if (this.v) {
            return (T) clone().b(aVar);
        }
        if (a(aVar.f10337a, 2)) {
            this.f10338b = aVar.f10338b;
        }
        if (a(aVar.f10337a, 262144)) {
            this.w = aVar.w;
        }
        if (a(aVar.f10337a, 1048576)) {
            this.z = aVar.z;
        }
        if (a(aVar.f10337a, 4)) {
            this.c = aVar.c;
        }
        if (a(aVar.f10337a, 8)) {
            this.d = aVar.d;
        }
        if (a(aVar.f10337a, 16)) {
            this.e = aVar.e;
            this.f = 0;
            this.f10337a &= -33;
        }
        if (a(aVar.f10337a, 32)) {
            this.f = aVar.f;
            this.e = null;
            this.f10337a &= -17;
        }
        if (a(aVar.f10337a, 64)) {
            this.g = aVar.g;
            this.h = 0;
            this.f10337a &= -129;
        }
        if (a(aVar.f10337a, 128)) {
            this.h = aVar.h;
            this.g = null;
            this.f10337a &= -65;
        }
        if (a(aVar.f10337a, 256)) {
            this.i = aVar.i;
        }
        if (a(aVar.f10337a, 512)) {
            this.k = aVar.k;
            this.j = aVar.j;
        }
        if (a(aVar.f10337a, 1024)) {
            this.l = aVar.l;
        }
        if (a(aVar.f10337a, 4096)) {
            this.s = aVar.s;
        }
        if (a(aVar.f10337a, 8192)) {
            this.o = aVar.o;
            this.p = 0;
            this.f10337a &= -16385;
        }
        if (a(aVar.f10337a, 16384)) {
            this.p = aVar.p;
            this.o = null;
            this.f10337a &= -8193;
        }
        if (a(aVar.f10337a, 32768)) {
            this.u = aVar.u;
        }
        if (a(aVar.f10337a, 65536)) {
            this.n = aVar.n;
        }
        if (a(aVar.f10337a, 131072)) {
            this.m = aVar.m;
        }
        if (a(aVar.f10337a, 2048)) {
            this.r.putAll(aVar.r);
            this.y = aVar.y;
        }
        if (a(aVar.f10337a, 524288)) {
            this.x = aVar.x;
        }
        if (!this.n) {
            this.r.clear();
            this.f10337a &= -2049;
            this.m = false;
            this.f10337a &= -131073;
            this.y = true;
        }
        this.f10337a |= aVar.f10337a;
        this.q.a(aVar.q);
        return a();
    }

    @NonNull
    @CheckResult
    public T b(boolean z) {
        if (this.v) {
            return (T) clone().b(true);
        }
        this.i = z ? false : true;
        this.f10337a |= 256;
        return a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // 
    @CheckResult
    /* renamed from: c */
    public T clone() {
        try {
            T t = (T) super.clone();
            t.q = new com.kwad.sdk.glide.load.e();
            t.q.a(this.q);
            t.r = new com.kwad.sdk.glide.g.b();
            t.r.putAll(this.r);
            t.t = false;
            t.v = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    @CheckResult
    public T c(@Nullable Drawable drawable) {
        if (this.v) {
            return (T) clone().c(drawable);
        }
        this.e = drawable;
        this.f10337a |= 16;
        this.f = 0;
        this.f10337a &= -33;
        return a();
    }

    public final boolean d() {
        return this.n;
    }

    public final boolean e() {
        return a(2048);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return Float.compare(aVar.f10338b, this.f10338b) == 0 && this.f == aVar.f && k.a(this.e, aVar.e) && this.h == aVar.h && k.a(this.g, aVar.g) && this.p == aVar.p && k.a(this.o, aVar.o) && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k && this.m == aVar.m && this.n == aVar.n && this.w == aVar.w && this.x == aVar.x && this.c.equals(aVar.c) && this.d == aVar.d && this.q.equals(aVar.q) && this.r.equals(aVar.r) && this.s.equals(aVar.s) && k.a(this.l, aVar.l) && k.a(this.u, aVar.u);
        }
        return false;
    }

    @NonNull
    @CheckResult
    public T f() {
        return a(DownsampleStrategy.f10265b, new com.kwad.sdk.glide.load.resource.bitmap.g());
    }

    @NonNull
    @CheckResult
    public T g() {
        return c(DownsampleStrategy.f10264a, new o());
    }

    @NonNull
    @CheckResult
    public T h() {
        return c(DownsampleStrategy.e, new com.kwad.sdk.glide.load.resource.bitmap.h());
    }

    public int hashCode() {
        return k.a(this.u, k.a(this.l, k.a(this.s, k.a(this.r, k.a(this.q, k.a(this.d, k.a(this.c, k.a(this.x, k.a(this.w, k.a(this.n, k.a(this.m, k.b(this.k, k.b(this.j, k.a(this.i, k.a(this.o, k.b(this.p, k.a(this.g, k.b(this.h, k.a(this.e, k.b(this.f, k.a(this.f10338b)))))))))))))))))))));
    }

    @NonNull
    public T i() {
        this.t = true;
        return b();
    }

    @NonNull
    public T j() {
        if (!this.t || this.v) {
            this.v = true;
            return i();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    @NonNull
    public final Map<Class<?>, com.kwad.sdk.glide.load.h<?>> k() {
        return this.r;
    }

    public final boolean l() {
        return this.m;
    }

    @NonNull
    public final com.kwad.sdk.glide.load.e m() {
        return this.q;
    }

    @NonNull
    public final Class<?> n() {
        return this.s;
    }

    @NonNull
    public final com.kwad.sdk.glide.load.engine.h o() {
        return this.c;
    }

    @Nullable
    public final Drawable p() {
        return this.e;
    }

    public final int q() {
        return this.f;
    }

    public final int r() {
        return this.h;
    }

    @Nullable
    public final Drawable s() {
        return this.g;
    }

    public final int t() {
        return this.p;
    }

    @Nullable
    public final Drawable u() {
        return this.o;
    }

    @Nullable
    public final Resources.Theme v() {
        return this.u;
    }

    public final boolean w() {
        return this.i;
    }

    @NonNull
    public final com.kwad.sdk.glide.load.c x() {
        return this.l;
    }

    public final boolean y() {
        return a(8);
    }

    @NonNull
    public final Priority z() {
        return this.d;
    }
}
