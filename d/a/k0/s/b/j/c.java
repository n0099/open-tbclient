package d.a.k0.s.b.j;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f60723b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f60724a;

    public static c a() {
        if (f60723b == null) {
            synchronized (c.class) {
                if (f60723b == null) {
                    f60723b = new c();
                }
            }
        }
        return f60723b;
    }

    public void b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.f60724a = createWXAPI;
        createWXAPI.registerApp("wx7088ea0f777314d2");
    }
}
