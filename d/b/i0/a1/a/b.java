package d.b.i0.a1.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public View f51867a;

        public a(View view) {
            this.f51867a = view;
        }

        public abstract boolean a();

        public abstract void b(Runnable runnable);

        public abstract void c(int i);
    }

    /* renamed from: d.b.i0.a1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1119b extends a {
        public C1119b(View view) {
            super(view);
        }

        @Override // d.b.i0.a1.a.b.a
        public boolean a() {
            return false;
        }

        @Override // d.b.i0.a1.a.b.a
        public void b(Runnable runnable) {
            this.f51867a.post(runnable);
        }

        @Override // d.b.i0.a1.a.b.a
        public void c(int i) {
            View view = this.f51867a;
            view.scrollTo(i, view.getScrollY());
        }
    }

    public static final a a(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new d.b.i0.a1.a.d.a(view);
        }
        return new C1119b(view);
    }
}
