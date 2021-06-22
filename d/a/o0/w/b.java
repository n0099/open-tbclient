package d.a.o0.w;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.RestrictTo;
import d.a.o0.w.a;
import d.a.o0.w.b;
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
    public final Object f66278d;

    /* renamed from: e  reason: collision with root package name */
    public final d.a.o0.w.c f66279e;
    public float j;

    /* renamed from: a  reason: collision with root package name */
    public float f66275a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f66276b = Float.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66277c = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66280f = false;

    /* renamed from: g  reason: collision with root package name */
    public float f66281g = Float.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    public float f66282h = -Float.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public long f66283i = 0;
    public final ArrayList<j> k = new ArrayList<>();
    public final ArrayList<k> l = new ArrayList<>();

    /* loaded from: classes4.dex */
    public static class a extends l {
        public a(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getAlpha();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            view.setAlpha(f2);
        }
    }

    /* renamed from: d.a.o0.w.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1757b extends l {
    }

    /* loaded from: classes4.dex */
    public static class c extends l {
        public c(String str) {
            super(str, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getTranslationY();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.w.c
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
        @Override // d.a.o0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getScaleX();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.w.c
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
        @Override // d.a.o0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getScaleY();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.w.c
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
        @Override // d.a.o0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getRotation();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.w.c
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
        @Override // d.a.o0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getRotationX();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.w.c
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
        @Override // d.a.o0.w.c
        /* renamed from: c */
        public float a(View view) {
            return view.getRotationY();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.w.c
        /* renamed from: d */
        public void b(View view, float f2) {
            view.setRotationY(f2);
        }
    }

    /* loaded from: classes4.dex */
    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public float f66284a;

        /* renamed from: b  reason: collision with root package name */
        public float f66285b;
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
    public static abstract class l extends d.a.o0.w.c<View> {
        public /* synthetic */ l(String str, C1757b c1757b) {
            this(str);
        }

        public l(String str) {
            super(str);
        }
    }

    public <K> b(K k2, d.a.o0.w.c<K> cVar) {
        this.f66278d = k2;
        this.f66279e = cVar;
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

    @Override // d.a.o0.w.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(long j2) {
        long j3 = this.f66283i;
        if (j3 == 0) {
            this.f66283i = j2;
            f(this.f66276b);
            return false;
        }
        this.f66283i = j2;
        boolean i2 = i(j2 - j3);
        float min = Math.min(this.f66276b, this.f66281g);
        this.f66276b = min;
        float max = Math.max(min, this.f66282h);
        this.f66276b = max;
        f(max);
        if (i2) {
            b(false);
        }
        return i2;
    }

    public final void b(boolean z) {
        this.f66280f = false;
        d.a.o0.w.a.i().l(this);
        this.f66283i = 0L;
        this.f66277c = false;
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            if (this.k.get(i2) != null) {
                this.k.get(i2).a(this, z, this.f66276b, this.f66275a);
            }
        }
        e(this.k);
    }

    public final float c() {
        return this.f66279e.a(this.f66278d);
    }

    public float d() {
        return this.j * 0.75f;
    }

    public void f(float f2) {
        this.f66279e.b(this.f66278d, f2);
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            if (this.l.get(i2) != null) {
                this.l.get(i2).a(this, this.f66276b, this.f66275a);
            }
        }
        e(this.l);
    }

    public void g() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (this.f66280f) {
                return;
            }
            h();
            return;
        }
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    }

    public final void h() {
        if (this.f66280f) {
            return;
        }
        this.f66280f = true;
        if (!this.f66277c) {
            this.f66276b = c();
        }
        float f2 = this.f66276b;
        if (f2 <= this.f66281g && f2 >= this.f66282h) {
            d.a.o0.w.a.i().f(this, 0L);
            return;
        }
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    }

    public abstract boolean i(long j2);
}
