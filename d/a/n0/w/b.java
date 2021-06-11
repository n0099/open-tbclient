package d.a.n0.w;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.RestrictTo;
import d.a.n0.w.a;
import d.a.n0.w.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public abstract class b<T extends b<T>> implements a.b {
    public static final l m = new c("translationY");
    public static final l n = new d("scaleX");
    public static final l o = new e("scaleY");
    public static final l p = new f("rotation");
    public static final l q = new g("rotationX");
    public static final l r = new h("rotationY");
    public static final l s = new a("alpha");

    /* renamed from: d  reason: collision with root package name */
    public final Object f66153d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.n0.w.c f66154e;
    public float j;

    /* renamed from: a  reason: collision with root package name */
    public float f66150a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f66151b = Float.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66152c = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66155f = false;

    /* renamed from: g  reason: collision with root package name */
    public float f66156g = Float.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    public float f66157h = -Float.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public long f66158i = 0;
    public final ArrayList<j> k = new ArrayList<>();
    public final ArrayList<k> l = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class a extends l {
        public a(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getAlpha();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            view.setAlpha(f2);
        }
    }

    /* renamed from: d.a.n0.w.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1753b extends l {
    }

    /* loaded from: classes4.dex */
    public static class c extends l {
        public c(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getTranslationY();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            view.setTranslationY(f2);
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends l {
        public d(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getScaleX();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            view.setScaleX(f2);
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends l {
        public e(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getScaleY();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            view.setScaleY(f2);
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends l {
        public f(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getRotation();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            view.setRotation(f2);
        }
    }

    /* loaded from: classes4.dex */
    public static class g extends l {
        public g(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getRotationX();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            view.setRotationX(f2);
        }
    }

    /* loaded from: classes4.dex */
    public static class h extends l {
        public h(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getRotationY();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            view.setRotationY(f2);
        }
    }

    /* loaded from: classes4.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public float f66159a;

        /* renamed from: b  reason: collision with root package name */
        public float f66160b;
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a(b bVar, boolean z, float f2, float f3);
    }

    /* loaded from: classes4.dex */
    public interface k {
        void a(b bVar, float f2, float f3);
    }

    /* loaded from: classes4.dex */
    public static abstract class l extends d.a.n0.w.c<View> {
        public /* synthetic */ l(String str, C1753b c1753b) {
            this(str);
        }

        public l(String str) {
            super(str);
        }
    }

    public <K> b(K k2, d.a.n0.w.c<K> cVar) {
        this.f66153d = k2;
        this.f66154e = cVar;
        if (cVar != p && cVar != q && cVar != r) {
            if (cVar == s) {
                this.j = 0.00390625f;
                return;
            } else if (cVar != n && cVar != o) {
                this.j = 1.0f;
                return;
            } else {
                this.j = 0.00390625f;
                return;
            }
        }
        this.j = 0.1f;
    }

    public static <T> void e(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    @Override // d.a.n0.w.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(long j2) {
        long j3 = this.f66158i;
        if (j3 == 0) {
            this.f66158i = j2;
            f(this.f66151b);
            return false;
        }
        this.f66158i = j2;
        boolean i2 = i(j2 - j3);
        float min = Math.min(this.f66151b, this.f66156g);
        this.f66151b = min;
        float max = Math.max(min, this.f66157h);
        this.f66151b = max;
        f(max);
        if (i2) {
            b(false);
        }
        return i2;
    }

    public final void b(boolean z) {
        this.f66155f = false;
        d.a.n0.w.a.i().l(this);
        this.f66158i = 0L;
        this.f66152c = false;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (this.k.get(i2) != null) {
                this.k.get(i2).a(this, z, this.f66151b, this.f66150a);
            }
        }
        e(this.k);
    }

    public final float c() {
        return this.f66154e.a(this.f66153d);
    }

    public float d() {
        return this.j * 0.75f;
    }

    public void f(float f2) {
        this.f66154e.b(this.f66153d, f2);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            if (this.l.get(i2) != null) {
                this.l.get(i2).a(this, this.f66151b, this.f66150a);
            }
        }
        e(this.l);
    }

    public void g() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.f66155f) {
                return;
            }
            h();
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public final void h() {
        if (this.f66155f) {
            return;
        }
        this.f66155f = true;
        if (!this.f66152c) {
            this.f66151b = c();
        }
        float f2 = this.f66151b;
        if (f2 <= this.f66156g && f2 >= this.f66157h) {
            d.a.n0.w.a.i().f(this, 0L);
            return;
        }
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public abstract boolean i(long j2);
}
