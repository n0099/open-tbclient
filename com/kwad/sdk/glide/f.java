package com.kwad.sdk.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.request.SingleRequest;
import com.kwad.sdk.glide.request.a.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class f<TranscodeType> extends com.kwad.sdk.glide.request.a<f<TranscodeType>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    protected static final com.kwad.sdk.glide.request.f f10278a = new com.kwad.sdk.glide.request.f().a(com.kwad.sdk.glide.load.engine.h.c).a(Priority.LOW).b(true);

    /* renamed from: b  reason: collision with root package name */
    private final Context f10279b;
    private final g c;
    private final Class<TranscodeType> d;
    private final c e;
    private final e f;
    @NonNull
    private h<?, ? super TranscodeType> g;
    @Nullable
    private Object h;
    @Nullable
    private List<com.kwad.sdk.glide.request.e<TranscodeType>> i;
    @Nullable
    private f<TranscodeType> j;
    @Nullable
    private f<TranscodeType> k;
    @Nullable
    private Float l;
    private boolean m = true;
    private boolean n;
    private boolean o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.glide.f$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10280a;

        static {
            try {
                f10281b[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10281b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10281b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10281b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            f10280a = new int[ImageView.ScaleType.values().length];
            try {
                f10280a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f10280a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f10280a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f10280a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f10280a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f10280a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f10280a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f10280a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public f(@NonNull c cVar, g gVar, Class<TranscodeType> cls, Context context) {
        this.e = cVar;
        this.c = gVar;
        this.d = cls;
        this.f10279b = context;
        this.g = gVar.b(cls);
        this.f = cVar.e();
        a(gVar.h());
        a((com.kwad.sdk.glide.request.a<?>) gVar.i());
    }

    private <Y extends j<TranscodeType>> Y a(@NonNull Y y, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        com.kwad.sdk.glide.g.j.a(y);
        if (this.n) {
            com.kwad.sdk.glide.request.c b2 = b(y, eVar, aVar, executor);
            com.kwad.sdk.glide.request.c b3 = y.b();
            if (!b2.a(b3) || a(aVar, b3)) {
                this.c.a((j<?>) y);
                y.a(b2);
                this.c.a(y, b2);
            } else {
                b2.h();
                if (!((com.kwad.sdk.glide.request.c) com.kwad.sdk.glide.g.j.a(b3)).c()) {
                    b3.a();
                }
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private com.kwad.sdk.glide.request.c a(j<TranscodeType> jVar, com.kwad.sdk.glide.request.e<TranscodeType> eVar, com.kwad.sdk.glide.request.a<?> aVar, com.kwad.sdk.glide.request.d dVar, h<?, ? super TranscodeType> hVar, Priority priority, int i, int i2, Executor executor) {
        return SingleRequest.a(this.f10279b, this.f, this.h, this.d, aVar, i, i2, priority, jVar, eVar, this.i, dVar, this.f.c(), hVar.b(), executor);
    }

    private com.kwad.sdk.glide.request.c a(j<TranscodeType> jVar, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, @Nullable com.kwad.sdk.glide.request.d dVar, h<?, ? super TranscodeType> hVar, Priority priority, int i, int i2, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        com.kwad.sdk.glide.request.b bVar;
        com.kwad.sdk.glide.request.b bVar2;
        if (this.k != null) {
            com.kwad.sdk.glide.request.b bVar3 = new com.kwad.sdk.glide.request.b(dVar);
            bVar = bVar3;
            bVar2 = bVar3;
        } else {
            bVar = null;
            bVar2 = dVar;
        }
        com.kwad.sdk.glide.request.c b2 = b(jVar, eVar, bVar2, hVar, priority, i, i2, aVar, executor);
        if (bVar == null) {
            return b2;
        }
        int A = this.k.A();
        int C = this.k.C();
        if (k.a(i, i2) && !this.k.B()) {
            A = aVar.A();
            C = aVar.C();
        }
        bVar.a(b2, this.k.a(jVar, eVar, bVar, this.k.g, this.k.z(), A, C, this.k, executor));
        return bVar;
    }

    @SuppressLint({"CheckResult"})
    private void a(List<com.kwad.sdk.glide.request.e<Object>> list) {
        for (com.kwad.sdk.glide.request.e<Object> eVar : list) {
            b((com.kwad.sdk.glide.request.e) eVar);
        }
    }

    private boolean a(com.kwad.sdk.glide.request.a<?> aVar, com.kwad.sdk.glide.request.c cVar) {
        return !aVar.w() && cVar.e_();
    }

    @NonNull
    private Priority b(@NonNull Priority priority) {
        switch (priority) {
            case LOW:
                return Priority.NORMAL;
            case NORMAL:
                return Priority.HIGH;
            case HIGH:
            case IMMEDIATE:
                return Priority.IMMEDIATE;
            default:
                throw new IllegalArgumentException("unknown priority: " + z());
        }
    }

    @NonNull
    private f<TranscodeType> b(@Nullable Object obj) {
        this.h = obj;
        this.n = true;
        return this;
    }

    private com.kwad.sdk.glide.request.c b(j<TranscodeType> jVar, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        return a(jVar, eVar, (com.kwad.sdk.glide.request.d) null, this.g, aVar.z(), aVar.A(), aVar.C(), aVar, executor);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.kwad.sdk.glide.request.a] */
    private com.kwad.sdk.glide.request.c b(j<TranscodeType> jVar, com.kwad.sdk.glide.request.e<TranscodeType> eVar, @Nullable com.kwad.sdk.glide.request.d dVar, h<?, ? super TranscodeType> hVar, Priority priority, int i, int i2, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        int i3;
        int i4;
        if (this.j == null) {
            if (this.l != null) {
                com.kwad.sdk.glide.request.h hVar2 = new com.kwad.sdk.glide.request.h(dVar);
                hVar2.a(a(jVar, eVar, aVar, hVar2, hVar, priority, i, i2, executor), a(jVar, eVar, aVar.clone().a(this.l.floatValue()), hVar2, hVar, b(priority), i, i2, executor));
                return hVar2;
            }
            return a(jVar, eVar, aVar, dVar, hVar, priority, i, i2, executor);
        } else if (this.o) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else {
            h<?, ? super TranscodeType> hVar3 = this.j.m ? hVar : this.j.g;
            Priority z = this.j.y() ? this.j.z() : b(priority);
            int A = this.j.A();
            int C = this.j.C();
            if (!k.a(i, i2) || this.j.B()) {
                i3 = C;
                i4 = A;
            } else {
                int A2 = aVar.A();
                i3 = aVar.C();
                i4 = A2;
            }
            com.kwad.sdk.glide.request.h hVar4 = new com.kwad.sdk.glide.request.h(dVar);
            com.kwad.sdk.glide.request.c a2 = a(jVar, eVar, aVar, hVar4, hVar, priority, i, i2, executor);
            this.o = true;
            com.kwad.sdk.glide.request.c a3 = this.j.a(jVar, eVar, hVar4, hVar3, z, i4, i3, this.j, executor);
            this.o = false;
            hVar4.a(a2, a3);
            return hVar4;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.request.a
    @CheckResult
    /* renamed from: a */
    public f<TranscodeType> clone() {
        f<TranscodeType> fVar = (f) super.clone();
        fVar.g = (h<?, ? super TranscodeType>) fVar.g.clone();
        return fVar;
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> a(@NonNull com.kwad.sdk.glide.request.a<?> aVar) {
        com.kwad.sdk.glide.g.j.a(aVar);
        return (f) super.b(aVar);
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> a(@Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar) {
        this.i = null;
        return b((com.kwad.sdk.glide.request.e) eVar);
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> a(@Nullable Object obj) {
        return b(obj);
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> a(@Nullable String str) {
        return b(str);
    }

    @NonNull
    public j<TranscodeType> a(int i, int i2) {
        return a((f<TranscodeType>) com.kwad.sdk.glide.request.a.g.a(this.c, i, i2));
    }

    @NonNull
    public <Y extends j<TranscodeType>> Y a(@NonNull Y y) {
        return (Y) a((f<TranscodeType>) y, (com.kwad.sdk.glide.request.e) null, com.kwad.sdk.glide.g.e.a());
    }

    @NonNull
    <Y extends j<TranscodeType>> Y a(@NonNull Y y, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, Executor executor) {
        return (Y) a(y, eVar, this, executor);
    }

    @NonNull
    public com.kwad.sdk.glide.request.a.k<ImageView, TranscodeType> a(@NonNull ImageView imageView) {
        f<TranscodeType> fVar;
        k.a();
        com.kwad.sdk.glide.g.j.a(imageView);
        if (!e() && d() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f10280a[imageView.getScaleType().ordinal()]) {
                case 1:
                    fVar = clone().f();
                    break;
                case 2:
                    fVar = clone().h();
                    break;
                case 3:
                case 4:
                case 5:
                    fVar = clone().g();
                    break;
                case 6:
                    fVar = clone().h();
                    break;
            }
            return (com.kwad.sdk.glide.request.a.k) a(this.f.a(imageView, this.d), null, fVar, com.kwad.sdk.glide.g.e.a());
        }
        fVar = this;
        return (com.kwad.sdk.glide.request.a.k) a(this.f.a(imageView, this.d), null, fVar, com.kwad.sdk.glide.g.e.a());
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> b(@Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar) {
        if (eVar != null) {
            if (this.i == null) {
                this.i = new ArrayList();
            }
            this.i.add(eVar);
        }
        return this;
    }

    @NonNull
    public j<TranscodeType> b() {
        return a(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.kwad.sdk.glide.request.a
    @NonNull
    @CheckResult
    public /* synthetic */ com.kwad.sdk.glide.request.a b(@NonNull com.kwad.sdk.glide.request.a aVar) {
        return a((com.kwad.sdk.glide.request.a<?>) aVar);
    }
}
