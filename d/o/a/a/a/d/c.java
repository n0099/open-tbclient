package d.o.a.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f70445a;

    /* renamed from: b  reason: collision with root package name */
    public String f70446b;

    /* renamed from: c  reason: collision with root package name */
    public String f70447c;

    /* renamed from: d  reason: collision with root package name */
    public String f70448d;

    /* renamed from: e  reason: collision with root package name */
    public String f70449e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70450f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f70451g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1923c f70452h;

    /* renamed from: i  reason: collision with root package name */
    public View f70453i;
    public int j;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f70454a;

        /* renamed from: b  reason: collision with root package name */
        public String f70455b;

        /* renamed from: c  reason: collision with root package name */
        public String f70456c;

        /* renamed from: d  reason: collision with root package name */
        public String f70457d;

        /* renamed from: e  reason: collision with root package name */
        public String f70458e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70459f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f70460g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1923c f70461h;

        /* renamed from: i  reason: collision with root package name */
        public View f70462i;
        public int j;

        public b(Context context) {
            this.f70454a = context;
        }

        public b b(int i2) {
            this.j = i2;
            return this;
        }

        public b c(Drawable drawable) {
            this.f70460g = drawable;
            return this;
        }

        public b d(InterfaceC1923c interfaceC1923c) {
            this.f70461h = interfaceC1923c;
            return this;
        }

        public b e(String str) {
            this.f70455b = str;
            return this;
        }

        public b f(boolean z) {
            this.f70459f = z;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(String str) {
            this.f70456c = str;
            return this;
        }

        public b j(String str) {
            this.f70457d = str;
            return this;
        }

        public b l(String str) {
            this.f70458e = str;
            return this;
        }
    }

    /* renamed from: d.o.a.a.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1923c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public c(b bVar) {
        this.f70450f = true;
        this.f70445a = bVar.f70454a;
        this.f70446b = bVar.f70455b;
        this.f70447c = bVar.f70456c;
        this.f70448d = bVar.f70457d;
        this.f70449e = bVar.f70458e;
        this.f70450f = bVar.f70459f;
        this.f70451g = bVar.f70460g;
        this.f70452h = bVar.f70461h;
        this.f70453i = bVar.f70462i;
        this.j = bVar.j;
    }
}
