package d.b.i0.s.b.m;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f60109b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f60110a;

    public static c a() {
        if (f60109b == null) {
            synchronized (c.class) {
                if (f60109b == null) {
                    f60109b = new c();
                }
            }
        }
        return f60109b;
    }

    public void b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.f60110a = createWXAPI;
        createWXAPI.registerApp("wx7088ea0f777314d2");
    }
}
