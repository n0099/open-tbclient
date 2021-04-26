package d.a.j0.s.b.m;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f59992b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f59993a;

    public static c a() {
        if (f59992b == null) {
            synchronized (c.class) {
                if (f59992b == null) {
                    f59992b = new c();
                }
            }
        }
        return f59992b;
    }

    public void b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.f59993a = createWXAPI;
        createWXAPI.registerApp("wx7088ea0f777314d2");
    }
}
