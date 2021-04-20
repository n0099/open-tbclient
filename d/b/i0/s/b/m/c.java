package d.b.i0.s.b.m;

import android.content.Context;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f61411b;

    /* renamed from: a  reason: collision with root package name */
    public IWXAPI f61412a;

    public static c a() {
        if (f61411b == null) {
            synchronized (c.class) {
                if (f61411b == null) {
                    f61411b = new c();
                }
            }
        }
        return f61411b;
    }

    public void b(Context context) {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx7088ea0f777314d2", true);
        this.f61412a = createWXAPI;
        createWXAPI.registerApp("wx7088ea0f777314d2");
    }
}
