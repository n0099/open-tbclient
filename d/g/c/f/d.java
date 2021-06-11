package d.g.c.f;

import com.baidu.tieba.wallet.pay.WalletPayViewController;
import d.g.c.a.n;
/* loaded from: classes6.dex */
public abstract class d {

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final double f70049a;

        /* renamed from: b  reason: collision with root package name */
        public final double f70050b;

        public d a(double d2) {
            n.d(!Double.isNaN(d2));
            if (d.g.c.f.b.c(d2)) {
                return new C1910d(d2, this.f70050b - (this.f70049a * d2));
            }
            return new e(this.f70049a);
        }

        public b(double d2, double d3) {
            this.f70049a = d2;
            this.f70050b = d3;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f70051a = new c();

        public String toString() {
            return WalletPayViewController.DEF_CHANNEL_TITLE;
        }
    }

    /* renamed from: d.g.c.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1910d extends d {

        /* renamed from: a  reason: collision with root package name */
        public final double f70052a;

        /* renamed from: b  reason: collision with root package name */
        public final double f70053b;

        public C1910d(double d2, double d3) {
            this.f70052a = d2;
            this.f70053b = d3;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f70052a), Double.valueOf(this.f70053b));
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends d {

        /* renamed from: a  reason: collision with root package name */
        public final double f70054a;

        public e(double d2) {
            this.f70054a = d2;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f70054a));
        }
    }

    public static d a() {
        return c.f70051a;
    }

    public static d b(double d2) {
        n.d(d.g.c.f.b.c(d2));
        return new C1910d(0.0d, d2);
    }

    public static b c(double d2, double d3) {
        n.d(d.g.c.f.b.c(d2) && d.g.c.f.b.c(d3));
        return new b(d2, d3);
    }

    public static d d(double d2) {
        n.d(d.g.c.f.b.c(d2));
        return new e(d2);
    }
}
