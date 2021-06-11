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
/* loaded from: classes7.dex */
public class f<TranscodeType> extends com.kwad.sdk.glide.request.a<f<TranscodeType>> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static final com.kwad.sdk.glide.request.f f35838a = new com.kwad.sdk.glide.request.f().a(com.kwad.sdk.glide.load.engine.h.f36226c).a(Priority.LOW).b(true);

    /* renamed from: b  reason: collision with root package name */
    public final Context f35839b;

    /* renamed from: c  reason: collision with root package name */
    public final g f35840c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<TranscodeType> f35841d;

    /* renamed from: e  reason: collision with root package name */
    public final c f35842e;

    /* renamed from: f  reason: collision with root package name */
    public final e f35843f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public h<?, ? super TranscodeType> f35844g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public Object f35845h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public List<com.kwad.sdk.glide.request.e<TranscodeType>> f35846i;
    @Nullable
    public f<TranscodeType> j;
    @Nullable
    public f<TranscodeType> k;
    @Nullable
    public Float l;
    public boolean m = true;
    public boolean n;
    public boolean o;

    /* renamed from: com.kwad.sdk.glide.f$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35847a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f35848b;

        static {
            int[] iArr = new int[Priority.values().length];
            f35848b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35848b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35848b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35848b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f35847a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f35847a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f35847a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f35847a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f35847a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f35847a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f35847a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f35847a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    @SuppressLint({"CheckResult"})
    public f(@NonNull c cVar, g gVar, Class<TranscodeType> cls, Context context) {
        this.f35842e = cVar;
        this.f35840c = gVar;
        this.f35841d = cls;
        this.f35839b = context;
        this.f35844g = gVar.b(cls);
        this.f35843f = cVar.e();
        a(gVar.h());
        a((com.kwad.sdk.glide.request.a<?>) gVar.i());
    }

    private <Y extends j<TranscodeType>> Y a(@NonNull Y y, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        com.kwad.sdk.glide.g.j.a(y);
        if (this.n) {
            com.kwad.sdk.glide.request.c b2 = b(y, eVar, aVar, executor);
            com.kwad.sdk.glide.request.c b3 = y.b();
            if (!b2.a(b3) || a(aVar, b3)) {
                this.f35840c.a((j<?>) y);
                y.a(b2);
                this.f35840c.a(y, b2);
                return y;
            }
            b2.h();
            if (!((com.kwad.sdk.glide.request.c) com.kwad.sdk.glide.g.j.a(b3)).c()) {
                b3.a();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private com.kwad.sdk.glide.request.c a(j<TranscodeType> jVar, com.kwad.sdk.glide.request.e<TranscodeType> eVar, com.kwad.sdk.glide.request.a<?> aVar, com.kwad.sdk.glide.request.d dVar, h<?, ? super TranscodeType> hVar, Priority priority, int i2, int i3, Executor executor) {
        Context context = this.f35839b;
        e eVar2 = this.f35843f;
        return SingleRequest.a(context, eVar2, this.f35845h, this.f35841d, aVar, i2, i3, priority, jVar, eVar, this.f35846i, dVar, eVar2.c(), hVar.b(), executor);
    }

    private com.kwad.sdk.glide.request.c a(j<TranscodeType> jVar, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, @Nullable com.kwad.sdk.glide.request.d dVar, h<?, ? super TranscodeType> hVar, Priority priority, int i2, int i3, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        com.kwad.sdk.glide.request.b bVar;
        com.kwad.sdk.glide.request.b bVar2;
        if (this.k != null) {
            bVar2 = new com.kwad.sdk.glide.request.b(dVar);
            bVar = bVar2;
        } else {
            bVar = null;
            bVar2 = dVar;
        }
        com.kwad.sdk.glide.request.c b2 = b(jVar, eVar, bVar2, hVar, priority, i2, i3, aVar, executor);
        if (bVar == null) {
            return b2;
        }
        int A = this.k.A();
        int C = this.k.C();
        if (k.a(i2, i3) && !this.k.B()) {
            A = aVar.A();
            C = aVar.C();
        }
        f<TranscodeType> fVar = this.k;
        com.kwad.sdk.glide.request.b bVar3 = bVar;
        bVar3.a(b2, fVar.a(jVar, eVar, bVar, fVar.f35844g, fVar.z(), A, C, this.k, executor));
        return bVar3;
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
        int i2 = AnonymousClass1.f35848b[priority.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3 || i2 == 4) {
                    return Priority.IMMEDIATE;
                }
                throw new IllegalArgumentException("unknown priority: " + z());
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    @NonNull
    private f<TranscodeType> b(@Nullable Object obj) {
        this.f35845h = obj;
        this.n = true;
        return this;
    }

    private com.kwad.sdk.glide.request.c b(j<TranscodeType> jVar, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        return a(jVar, eVar, (com.kwad.sdk.glide.request.d) null, this.f35844g, aVar.z(), aVar.A(), aVar.C(), aVar, executor);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.kwad.sdk.glide.request.a] */
    private com.kwad.sdk.glide.request.c b(j<TranscodeType> jVar, com.kwad.sdk.glide.request.e<TranscodeType> eVar, @Nullable com.kwad.sdk.glide.request.d dVar, h<?, ? super TranscodeType> hVar, Priority priority, int i2, int i3, com.kwad.sdk.glide.request.a<?> aVar, Executor executor) {
        f<TranscodeType> fVar = this.j;
        if (fVar == null) {
            if (this.l != null) {
                com.kwad.sdk.glide.request.h hVar2 = new com.kwad.sdk.glide.request.h(dVar);
                hVar2.a(a(jVar, eVar, aVar, hVar2, hVar, priority, i2, i3, executor), a(jVar, eVar, aVar.clone().a(this.l.floatValue()), hVar2, hVar, b(priority), i2, i3, executor));
                return hVar2;
            }
            return a(jVar, eVar, aVar, dVar, hVar, priority, i2, i3, executor);
        } else if (this.o) {
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else {
            h<?, ? super TranscodeType> hVar3 = fVar.m ? hVar : fVar.f35844g;
            Priority z = this.j.y() ? this.j.z() : b(priority);
            int A = this.j.A();
            int C = this.j.C();
            if (k.a(i2, i3) && !this.j.B()) {
                A = aVar.A();
                C = aVar.C();
            }
            int i4 = A;
            int i5 = C;
            com.kwad.sdk.glide.request.h hVar4 = new com.kwad.sdk.glide.request.h(dVar);
            com.kwad.sdk.glide.request.c a2 = a(jVar, eVar, aVar, hVar4, hVar, priority, i2, i3, executor);
            this.o = true;
            f<TranscodeType> fVar2 = this.j;
            com.kwad.sdk.glide.request.c a3 = fVar2.a(jVar, eVar, hVar4, hVar3, z, i4, i5, fVar2, executor);
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
        fVar.f35844g = (h<?, ? super TranscodeType>) fVar.f35844g.clone();
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
        this.f35846i = null;
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
    public j<TranscodeType> a(int i2, int i3) {
        return a((f<TranscodeType>) com.kwad.sdk.glide.request.a.g.a(this.f35840c, i2, i3));
    }

    @NonNull
    public <Y extends j<TranscodeType>> Y a(@NonNull Y y) {
        return (Y) a((f<TranscodeType>) y, (com.kwad.sdk.glide.request.e) null, com.kwad.sdk.glide.g.e.a());
    }

    @NonNull
    public <Y extends j<TranscodeType>> Y a(@NonNull Y y, @Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar, Executor executor) {
        return (Y) a(y, eVar, this, executor);
    }

    @NonNull
    public com.kwad.sdk.glide.request.a.k<ImageView, TranscodeType> a(@NonNull ImageView imageView) {
        com.kwad.sdk.glide.request.a<?> aVar;
        k.a();
        com.kwad.sdk.glide.g.j.a(imageView);
        if (!e() && d() && imageView.getScaleType() != null) {
            switch (AnonymousClass1.f35847a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = c().f();
                    break;
                case 2:
                case 6:
                    aVar = c().h();
                    break;
                case 3:
                case 4:
                case 5:
                    aVar = c().g();
                    break;
            }
            return (com.kwad.sdk.glide.request.a.k) a(this.f35843f.a(imageView, this.f35841d), null, aVar, com.kwad.sdk.glide.g.e.a());
        }
        aVar = this;
        return (com.kwad.sdk.glide.request.a.k) a(this.f35843f.a(imageView, this.f35841d), null, aVar, com.kwad.sdk.glide.g.e.a());
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> b(@Nullable com.kwad.sdk.glide.request.e<TranscodeType> eVar) {
        if (eVar != null) {
            if (this.f35846i == null) {
                this.f35846i = new ArrayList();
            }
            this.f35846i.add(eVar);
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
