package d.o.a.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f70341a;

    /* renamed from: b  reason: collision with root package name */
    public String f70342b;

    /* renamed from: c  reason: collision with root package name */
    public String f70343c;

    /* renamed from: d  reason: collision with root package name */
    public String f70344d;

    /* renamed from: e  reason: collision with root package name */
    public String f70345e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70346f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f70347g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1920c f70348h;

    /* renamed from: i  reason: collision with root package name */
    public View f70349i;
    public int j;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f70350a;

        /* renamed from: b  reason: collision with root package name */
        public String f70351b;

        /* renamed from: c  reason: collision with root package name */
        public String f70352c;

        /* renamed from: d  reason: collision with root package name */
        public String f70353d;

        /* renamed from: e  reason: collision with root package name */
        public String f70354e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f70355f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f70356g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1920c f70357h;

        /* renamed from: i  reason: collision with root package name */
        public View f70358i;
        public int j;

        public b(Context context) {
            this.f70350a = context;
        }

        public b b(int i2) {
            this.j = i2;
            return this;
        }

        public b c(Drawable drawable) {
            this.f70356g = drawable;
            return this;
        }

        public b d(InterfaceC1920c interfaceC1920c) {
            this.f70357h = interfaceC1920c;
            return this;
        }

        public b e(String str) {
            this.f70351b = str;
            return this;
        }

        public b f(boolean z) {
            this.f70355f = z;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(String str) {
            this.f70352c = str;
            return this;
        }

        public b j(String str) {
            this.f70353d = str;
            return this;
        }

        public b l(String str) {
            this.f70354e = str;
            return this;
        }
    }

    /* renamed from: d.o.a.a.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1920c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public c(b bVar) {
        this.f70346f = true;
        this.f70341a = bVar.f70350a;
        this.f70342b = bVar.f70351b;
        this.f70343c = bVar.f70352c;
        this.f70344d = bVar.f70353d;
        this.f70345e = bVar.f70354e;
        this.f70346f = bVar.f70355f;
        this.f70347g = bVar.f70356g;
        this.f70348h = bVar.f70357h;
        this.f70349i = bVar.f70358i;
        this.j = bVar.j;
    }
}
