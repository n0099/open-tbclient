package d.a.h0.a.p.d.j;

import android.app.Activity;
import android.content.Intent;
import com.baidu.browser.sailor.BdSailor;
import d.a.h0.a.k;
import d.a.h0.a.p.d.g;
import d.a.h0.a.p.d.h;
import d.a.h0.a.p.d.i;
/* loaded from: classes2.dex */
public class a implements i {

    /* renamed from: a  reason: collision with root package name */
    public g f43517a = new C0725a(this);

    /* renamed from: d.a.h0.a.p.d.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0725a implements g {
        public C0725a(a aVar) {
        }

        @Override // d.a.h0.a.p.d.g
        public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
            BdSailor.getInstance().onActivityResult(activity, i2, i3, intent);
        }
    }

    static {
        boolean z = k.f43101a;
    }

    @Override // d.a.h0.a.p.d.i
    public h a() {
        return d.a.h0.a.e0.k.d.a.k();
    }

    @Override // d.a.h0.a.p.d.i
    public g b() {
        return this.f43517a;
    }
}
