package d.a.n0.c1.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public View f52312a;

        public a(View view) {
            this.f52312a = view;
        }

        public abstract boolean a();

        public abstract void b(Runnable runnable);

        public abstract void c(int i2);
    }

    /* renamed from: d.a.n0.c1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1230b extends a {
        public C1230b(View view) {
            super(view);
        }

        @Override // d.a.n0.c1.a.b.a
        public boolean a() {
            return false;
        }

        @Override // d.a.n0.c1.a.b.a
        public void b(Runnable runnable) {
            this.f52312a.post(runnable);
        }

        @Override // d.a.n0.c1.a.b.a
        public void c(int i2) {
            View view = this.f52312a;
            view.scrollTo(i2, view.getScrollY());
        }
    }

    public static final a a(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new d.a.n0.c1.a.d.a(view);
        }
        return new C1230b(view);
    }
}
