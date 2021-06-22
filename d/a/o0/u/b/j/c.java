package d.a.o0.u.b.j;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f65130b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f65131a;

    public static c a() {
        if (f65130b == null) {
            synchronized (c.class) {
                if (f65130b == null) {
                    f65130b = new c();
                }
            }
        }
        return f65130b;
    }

    public void b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.f65131a = createWXAPI;
        createWXAPI.registerApp("wx7088ea0f777314d2");
    }
}
