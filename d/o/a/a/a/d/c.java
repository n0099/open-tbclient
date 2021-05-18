package d.o.a.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f66512a;

    /* renamed from: b  reason: collision with root package name */
    public String f66513b;

    /* renamed from: c  reason: collision with root package name */
    public String f66514c;

    /* renamed from: d  reason: collision with root package name */
    public String f66515d;

    /* renamed from: e  reason: collision with root package name */
    public String f66516e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66517f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f66518g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC1856c f66519h;

    /* renamed from: i  reason: collision with root package name */
    public View f66520i;
    public int j;

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f66521a;

        /* renamed from: b  reason: collision with root package name */
        public String f66522b;

        /* renamed from: c  reason: collision with root package name */
        public String f66523c;

        /* renamed from: d  reason: collision with root package name */
        public String f66524d;

        /* renamed from: e  reason: collision with root package name */
        public String f66525e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f66526f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable f66527g;

        /* renamed from: h  reason: collision with root package name */
        public InterfaceC1856c f66528h;

        /* renamed from: i  reason: collision with root package name */
        public View f66529i;
        public int j;

        public b(Context context) {
            this.f66521a = context;
        }

        public b b(int i2) {
            this.j = i2;
            return this;
        }

        public b c(Drawable drawable) {
            this.f66527g = drawable;
            return this;
        }

        public b d(InterfaceC1856c interfaceC1856c) {
            this.f66528h = interfaceC1856c;
            return this;
        }

        public b e(String str) {
            this.f66522b = str;
            return this;
        }

        public b f(boolean z) {
            this.f66526f = z;
            return this;
        }

        public c g() {
            return new c(this);
        }

        public b h(String str) {
            this.f66523c = str;
            return this;
        }

        public b j(String str) {
            this.f66524d = str;
            return this;
        }

        public b l(String str) {
            this.f66525e = str;
            return this;
        }
    }

    /* renamed from: d.o.a.a.a.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1856c {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public c(b bVar) {
        this.f66517f = true;
        this.f66512a = bVar.f66521a;
        this.f66513b = bVar.f66522b;
        this.f66514c = bVar.f66523c;
        this.f66515d = bVar.f66524d;
        this.f66516e = bVar.f66525e;
        this.f66517f = bVar.f66526f;
        this.f66518g = bVar.f66527g;
        this.f66519h = bVar.f66528h;
        this.f66520i = bVar.f66529i;
        this.j = bVar.j;
    }
}
