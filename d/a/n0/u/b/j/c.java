package d.a.n0.u.b.j;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f61292b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f61293a;

    public static c a() {
        if (f61292b == null) {
            synchronized (c.class) {
                if (f61292b == null) {
                    f61292b = new c();
                }
            }
        }
        return f61292b;
    }

    public void b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.f61293a = createWXAPI;
        createWXAPI.registerApp("wx7088ea0f777314d2");
    }
}
