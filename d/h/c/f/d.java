package d.h.c.f;

import com.baidu.tieba.wallet.pay.WalletPayViewController;
import d.h.c.a.n;
/* loaded from: classes6.dex */
public abstract class d {

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final double f67173a;

        /* renamed from: b  reason: collision with root package name */
        public final double f67174b;

        public d a(double d2) {
            n.d(!Double.isNaN(d2));
            if (d.h.c.f.b.c(d2)) {
                return new C1843d(d2, this.f67174b - (this.f67173a * d2));
            }
            return new e(this.f67173a);
        }

        public b(double d2, double d3) {
            this.f67173a = d2;
            this.f67174b = d3;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f67175a = new c();

        public String toString() {
            return WalletPayViewController.DEF_CHANNEL_TITLE;
        }
    }

    /* renamed from: d.h.c.f.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1843d extends d {

        /* renamed from: a  reason: collision with root package name */
        public final double f67176a;

        /* renamed from: b  reason: collision with root package name */
        public final double f67177b;

        public C1843d(double d2, double d3) {
            this.f67176a = d2;
            this.f67177b = d3;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f67176a), Double.valueOf(this.f67177b));
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends d {

        /* renamed from: a  reason: collision with root package name */
        public final double f67178a;

        public e(double d2) {
            this.f67178a = d2;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f67178a));
        }
    }

    public static d a() {
        return c.f67175a;
    }

    public static d b(double d2) {
        n.d(d.h.c.f.b.c(d2));
        return new C1843d(0.0d, d2);
    }

    public static b c(double d2, double d3) {
        n.d(d.h.c.f.b.c(d2) && d.h.c.f.b.c(d3));
        return new b(d2, d3);
    }

    public static d d(double d2) {
        n.d(d.h.c.f.b.c(d2));
        return new e(d2);
    }
}
