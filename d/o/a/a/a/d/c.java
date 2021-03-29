package d.o.a.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f66354a;

    /* renamed from: b  reason: collision with root package name */
    public String f66355b;

    /* renamed from: c  reason: collision with root package name */
    public String f66356c;

    /* renamed from: d  reason: collision with root package name */
    public String f66357d;

    /* renamed from: e  reason: collision with root package name */
    public String f66358e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66359f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f66360g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1818c f66361h;
    public View i;
    public int j;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f66362a;

        /* renamed from: b  reason: collision with root package name */
        public String f66363b;

        /* renamed from: c  reason: collision with root package name */
        public String f66364c;

        /* renamed from: d  reason: collision with root package name */
        public String f66365d;

        /* renamed from: e  reason: collision with root package name */
        public String f66366e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66367f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f66368g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1818c f66369h;
        public View i;
        public int j;

        public b(Context context) {
            this.f66362a = context;
        }

        public b b(int i) {
            this.j = i;
            return this;
        }

        public b c(Drawable drawable) {
            this.f66368g = drawable;
            return this;
        }

        public b d(InterfaceC1818c interfaceC1818c) {
            this.f66369h = interfaceC1818c;
            return this;
        }

        public b e(String str) {
            this.f66363b = str;
            return this;
        }

        public b f(boolean z) {
            this.f66367f = z;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(String str) {
            this.f66364c = str;
            return this;
        }

        public b j(String str) {
            this.f66365d = str;
            return this;
        }

        public b l(String str) {
            this.f66366e = str;
            return this;
        }
    }

    /* renamed from: d.o.a.a.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1818c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public c(b bVar) {
        this.f66359f = true;
        this.f66354a = bVar.f66362a;
        this.f66355b = bVar.f66363b;
        this.f66356c = bVar.f66364c;
        this.f66357d = bVar.f66365d;
        this.f66358e = bVar.f66366e;
        this.f66359f = bVar.f66367f;
        this.f66360g = bVar.f66368g;
        this.f66361h = bVar.f66369h;
        this.i = bVar.i;
        this.j = bVar.j;
    }
}
