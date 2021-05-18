package d.a.i0.a.p.e.j;

import android.app.Activity;
import android.content.Intent;
import com.baidu.browser.sailor.BdSailor;
import d.a.i0.a.k;
import d.a.i0.a.p.e.g;
import d.a.i0.a.p.e.h;
import d.a.i0.a.p.e.i;
/* loaded from: classes2.dex */
public class a implements i {

    /* renamed from: a  reason: collision with root package name */
    public g f43821a = new C0779a(this);

    /* renamed from: d.a.i0.a.p.e.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0779a implements g {
        public C0779a(a aVar) {
        }

        @Override // d.a.i0.a.p.e.g
        public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
            BdSailor.getInstance().onActivityResult(activity, i2, i3, intent);
        }
    }

    static {
        boolean z = k.f43025a;
    }

    @Override // d.a.i0.a.p.e.i
    public h a() {
        return d.a.i0.a.h0.f.d.a.k();
    }

    @Override // d.a.i0.a.p.e.i
    public g b() {
        return this.f43821a;
    }
}
