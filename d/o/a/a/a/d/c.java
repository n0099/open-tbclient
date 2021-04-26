package d.o.a.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f65826a;

    /* renamed from: b  reason: collision with root package name */
    public String f65827b;

    /* renamed from: c  reason: collision with root package name */
    public String f65828c;

    /* renamed from: d  reason: collision with root package name */
    public String f65829d;

    /* renamed from: e  reason: collision with root package name */
    public String f65830e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f65831f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f65832g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1792c f65833h;

    /* renamed from: i  reason: collision with root package name */
    public View f65834i;
    public int j;

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f65835a;

        /* renamed from: b  reason: collision with root package name */
        public String f65836b;

        /* renamed from: c  reason: collision with root package name */
        public String f65837c;

        /* renamed from: d  reason: collision with root package name */
        public String f65838d;

        /* renamed from: e  reason: collision with root package name */
        public String f65839e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f65840f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f65841g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1792c f65842h;

        /* renamed from: i  reason: collision with root package name */
        public View f65843i;
        public int j;

        public b(Context context) {
            this.f65835a = context;
        }

        public b b(int i2) {
            this.j = i2;
            return this;
        }

        public b c(Drawable drawable) {
            this.f65841g = drawable;
            return this;
        }

        public b d(InterfaceC1792c interfaceC1792c) {
            this.f65842h = interfaceC1792c;
            return this;
        }

        public b e(String str) {
            this.f65836b = str;
            return this;
        }

        public b f(boolean z) {
            this.f65840f = z;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(String str) {
            this.f65837c = str;
            return this;
        }

        public b j(String str) {
            this.f65838d = str;
            return this;
        }

        public b l(String str) {
            this.f65839e = str;
            return this;
        }
    }

    /* renamed from: d.o.a.a.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1792c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public c(b bVar) {
        this.f65831f = true;
        this.f65826a = bVar.f65835a;
        this.f65827b = bVar.f65836b;
        this.f65828c = bVar.f65837c;
        this.f65829d = bVar.f65838d;
        this.f65830e = bVar.f65839e;
        this.f65831f = bVar.f65840f;
        this.f65832g = bVar.f65841g;
        this.f65833h = bVar.f65842h;
        this.f65834i = bVar.f65843i;
        this.j = bVar.j;
    }
}
