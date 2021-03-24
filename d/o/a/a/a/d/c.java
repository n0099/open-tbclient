package d.o.a.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f66353a;

    /* renamed from: b  reason: collision with root package name */
    public String f66354b;

    /* renamed from: c  reason: collision with root package name */
    public String f66355c;

    /* renamed from: d  reason: collision with root package name */
    public String f66356d;

    /* renamed from: e  reason: collision with root package name */
    public String f66357e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66358f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f66359g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1817c f66360h;
    public View i;
    public int j;

    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f66361a;

        /* renamed from: b  reason: collision with root package name */
        public String f66362b;

        /* renamed from: c  reason: collision with root package name */
        public String f66363c;

        /* renamed from: d  reason: collision with root package name */
        public String f66364d;

        /* renamed from: e  reason: collision with root package name */
        public String f66365e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66366f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f66367g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1817c f66368h;
        public View i;
        public int j;

        public b(Context context) {
            this.f66361a = context;
        }

        public b b(int i) {
            this.j = i;
            return this;
        }

        public b c(Drawable drawable) {
            this.f66367g = drawable;
            return this;
        }

        public b d(InterfaceC1817c interfaceC1817c) {
            this.f66368h = interfaceC1817c;
            return this;
        }

        public b e(String str) {
            this.f66362b = str;
            return this;
        }

        public b f(boolean z) {
            this.f66366f = z;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(String str) {
            this.f66363c = str;
            return this;
        }

        public b j(String str) {
            this.f66364d = str;
            return this;
        }

        public b l(String str) {
            this.f66365e = str;
            return this;
        }
    }

    /* renamed from: d.o.a.a.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1817c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public c(b bVar) {
        this.f66358f = true;
        this.f66353a = bVar.f66361a;
        this.f66354b = bVar.f66362b;
        this.f66355c = bVar.f66363c;
        this.f66356d = bVar.f66364d;
        this.f66357e = bVar.f66365e;
        this.f66358f = bVar.f66366f;
        this.f66359g = bVar.f66367g;
        this.f66360h = bVar.f66368h;
        this.i = bVar.i;
        this.j = bVar.j;
    }
}
