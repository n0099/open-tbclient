package d.b.i0.s.b.m;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f60110b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f60111a;

    public static c a() {
        if (f60110b == null) {
            synchronized (c.class) {
                if (f60110b == null) {
                    f60110b = new c();
                }
            }
        }
        return f60110b;
    }

    public void b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.f60111a = createWXAPI;
        createWXAPI.registerApp("wx7088ea0f777314d2");
    }
}
