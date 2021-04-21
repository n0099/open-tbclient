package d.b.j0.s.b.m;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f61832b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f61833a;

    public static c a() {
        if (f61832b == null) {
            synchronized (c.class) {
                if (f61832b == null) {
                    f61832b = new c();
                }
            }
        }
        return f61832b;
    }

    public void b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.f61833a = createWXAPI;
        createWXAPI.registerApp("wx7088ea0f777314d2");
    }
}
