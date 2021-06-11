package d.a.n0.u.b.j;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f65005b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f65006a;

    public static c a() {
        if (f65005b == null) {
            synchronized (c.class) {
                if (f65005b == null) {
                    f65005b = new c();
                }
            }
        }
        return f65005b;
    }

    public void b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.f65006a = createWXAPI;
        createWXAPI.registerApp("wx7088ea0f777314d2");
    }
}
