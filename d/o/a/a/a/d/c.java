package d.o.a.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f67347a;

    /* renamed from: b  reason: collision with root package name */
    public String f67348b;

    /* renamed from: c  reason: collision with root package name */
    public String f67349c;

    /* renamed from: d  reason: collision with root package name */
    public String f67350d;

    /* renamed from: e  reason: collision with root package name */
    public String f67351e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67352f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f67353g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1853c f67354h;
    public View i;
    public int j;

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f67355a;

        /* renamed from: b  reason: collision with root package name */
        public String f67356b;

        /* renamed from: c  reason: collision with root package name */
        public String f67357c;

        /* renamed from: d  reason: collision with root package name */
        public String f67358d;

        /* renamed from: e  reason: collision with root package name */
        public String f67359e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f67360f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f67361g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1853c f67362h;
        public View i;
        public int j;

        public b(Context context) {
            this.f67355a = context;
        }

        public b b(int i) {
            this.j = i;
            return this;
        }

        public b c(Drawable drawable) {
            this.f67361g = drawable;
            return this;
        }

        public b d(InterfaceC1853c interfaceC1853c) {
            this.f67362h = interfaceC1853c;
            return this;
        }

        public b e(String str) {
            this.f67356b = str;
            return this;
        }

        public b f(boolean z) {
            this.f67360f = z;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(String str) {
            this.f67357c = str;
            return this;
        }

        public b j(String str) {
            this.f67358d = str;
            return this;
        }

        public b l(String str) {
            this.f67359e = str;
            return this;
        }
    }

    /* renamed from: d.o.a.a.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1853c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public c(b bVar) {
        this.f67352f = true;
        this.f67347a = bVar.f67355a;
        this.f67348b = bVar.f67356b;
        this.f67349c = bVar.f67357c;
        this.f67350d = bVar.f67358d;
        this.f67351e = bVar.f67359e;
        this.f67352f = bVar.f67360f;
        this.f67353g = bVar.f67361g;
        this.f67354h = bVar.f67362h;
        this.i = bVar.i;
        this.j = bVar.j;
    }
}
