package d.b.z.c.a;

import android.view.View;
import com.baidu.nps.interfa.IAlertManager;
import com.baidu.nps.interfa.IAlertManager_AlertManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f64863b = new a();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.d0.a.b.c<IAlertManager> f64864a;

    public a() {
        b();
    }

    public static a a() {
        return f64863b;
    }

    public void b() {
        d.b.d0.a.b.a b2 = d.b.d0.a.b.a.b();
        this.f64864a = b2;
        b2.a(new IAlertManager_AlertManager_Provider());
    }

    public void c(String str, String str2, View.OnClickListener onClickListener, String str3, View.OnClickListener onClickListener2, String str4) {
        this.f64864a.get().onAlert(str, str2, onClickListener, str3, onClickListener2, str4);
    }
}
