package d.b.g0.a.p.d.j;

import android.app.Activity;
import android.content.Intent;
import com.baidu.browser.sailor.BdSailor;
import d.b.g0.a.k;
import d.b.g0.a.p.d.g;
import d.b.g0.a.p.d.h;
import d.b.g0.a.p.d.i;
/* loaded from: classes2.dex */
public class a implements i {

    /* renamed from: a  reason: collision with root package name */
    public g f45449a = new C0754a(this);

    /* renamed from: d.b.g0.a.p.d.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0754a implements g {
        public C0754a(a aVar) {
        }

        @Override // d.b.g0.a.p.d.g
        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            BdSailor.getInstance().onActivityResult(activity, i, i2, intent);
        }
    }

    static {
        boolean z = k.f45051a;
    }

    @Override // d.b.g0.a.p.d.i
    public g a() {
        return this.f45449a;
    }

    @Override // d.b.g0.a.p.d.i
    public h b() {
        return d.b.g0.a.e0.k.d.a.k();
    }
}
