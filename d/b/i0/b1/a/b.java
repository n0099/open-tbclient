package d.b.i0.b1.a;

import android.os.Build;
import android.view.View;
/* loaded from: classes4.dex */
public class b {

    /* loaded from: classes4.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public View f53288a;

        public a(View view) {
            this.f53288a = view;
        }

        public abstract boolean a();

        public abstract void b(Runnable runnable);

        public abstract void c(int i);
    }

    /* renamed from: d.b.i0.b1.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1179b extends a {
        public C1179b(View view) {
            super(view);
        }

        @Override // d.b.i0.b1.a.b.a
        public boolean a() {
            return false;
        }

        @Override // d.b.i0.b1.a.b.a
        public void b(Runnable runnable) {
            this.f53288a.post(runnable);
        }

        @Override // d.b.i0.b1.a.b.a
        public void c(int i) {
            View view = this.f53288a;
            view.scrollTo(i, view.getScrollY());
        }
    }

    public static final a a(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            return new d.b.i0.b1.a.d.a(view);
        }
        return new C1179b(view);
    }
}
