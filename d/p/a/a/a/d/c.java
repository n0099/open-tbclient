package d.p.a.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f67494a;

    /* renamed from: b  reason: collision with root package name */
    public String f67495b;

    /* renamed from: c  reason: collision with root package name */
    public String f67496c;

    /* renamed from: d  reason: collision with root package name */
    public String f67497d;

    /* renamed from: e  reason: collision with root package name */
    public String f67498e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67499f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f67500g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1857c f67501h;
    public View i;
    public int j;

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f67502a;

        /* renamed from: b  reason: collision with root package name */
        public String f67503b;

        /* renamed from: c  reason: collision with root package name */
        public String f67504c;

        /* renamed from: d  reason: collision with root package name */
        public String f67505d;

        /* renamed from: e  reason: collision with root package name */
        public String f67506e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67507f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f67508g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1857c f67509h;
        public View i;
        public int j;

        public b(Context context) {
            this.f67502a = context;
        }

        public b b(int i) {
            this.j = i;
            return this;
        }

        public b c(Drawable drawable) {
            this.f67508g = drawable;
            return this;
        }

        public b d(InterfaceC1857c interfaceC1857c) {
            this.f67509h = interfaceC1857c;
            return this;
        }

        public b e(String str) {
            this.f67503b = str;
            return this;
        }

        public b f(boolean z) {
            this.f67507f = z;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(String str) {
            this.f67504c = str;
            return this;
        }

        public b j(String str) {
            this.f67505d = str;
            return this;
        }

        public b l(String str) {
            this.f67506e = str;
            return this;
        }
    }

    /* renamed from: d.p.a.a.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1857c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public c(b bVar) {
        this.f67499f = true;
        this.f67494a = bVar.f67502a;
        this.f67495b = bVar.f67503b;
        this.f67496c = bVar.f67504c;
        this.f67497d = bVar.f67505d;
        this.f67498e = bVar.f67506e;
        this.f67499f = bVar.f67507f;
        this.f67500g = bVar.f67508g;
        this.f67501h = bVar.f67509h;
        this.i = bVar.i;
        this.j = bVar.j;
    }
}
