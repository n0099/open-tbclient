package d.o.a.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f66555a;

    /* renamed from: b  reason: collision with root package name */
    public String f66556b;

    /* renamed from: c  reason: collision with root package name */
    public String f66557c;

    /* renamed from: d  reason: collision with root package name */
    public String f66558d;

    /* renamed from: e  reason: collision with root package name */
    public String f66559e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66560f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f66561g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1860c f66562h;

    /* renamed from: i  reason: collision with root package name */
    public View f66563i;
    public int j;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f66564a;

        /* renamed from: b  reason: collision with root package name */
        public String f66565b;

        /* renamed from: c  reason: collision with root package name */
        public String f66566c;

        /* renamed from: d  reason: collision with root package name */
        public String f66567d;

        /* renamed from: e  reason: collision with root package name */
        public String f66568e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66569f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f66570g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1860c f66571h;

        /* renamed from: i  reason: collision with root package name */
        public View f66572i;
        public int j;

        public b(Context context) {
            this.f66564a = context;
        }

        public b b(int i2) {
            this.j = i2;
            return this;
        }

        public b c(Drawable drawable) {
            this.f66570g = drawable;
            return this;
        }

        public b d(InterfaceC1860c interfaceC1860c) {
            this.f66571h = interfaceC1860c;
            return this;
        }

        public b e(String str) {
            this.f66565b = str;
            return this;
        }

        public b f(boolean z) {
            this.f66569f = z;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(String str) {
            this.f66566c = str;
            return this;
        }

        public b j(String str) {
            this.f66567d = str;
            return this;
        }

        public b l(String str) {
            this.f66568e = str;
            return this;
        }
    }

    /* renamed from: d.o.a.a.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1860c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public c(b bVar) {
        this.f66560f = true;
        this.f66555a = bVar.f66564a;
        this.f66556b = bVar.f66565b;
        this.f66557c = bVar.f66566c;
        this.f66558d = bVar.f66567d;
        this.f66559e = bVar.f66568e;
        this.f66560f = bVar.f66569f;
        this.f66561g = bVar.f66570g;
        this.f66562h = bVar.f66571h;
        this.f66563i = bVar.f66572i;
        this.j = bVar.j;
    }
}
