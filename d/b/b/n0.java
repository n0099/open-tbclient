package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
/* loaded from: classes5.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f64339a;

    public static String a(Context context, i iVar) {
        if (TextUtils.isEmpty(f64339a)) {
            synchronized (n0.class) {
                if (!TextUtils.isEmpty(f64339a)) {
                    return f64339a;
                }
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = iVar.A().getString("google_aid", null);
                } else if (!TextUtils.equals(iVar.A().getString("google_aid", null), id)) {
                    b(context, id, iVar);
                }
                f64339a = id;
            }
        }
        return f64339a;
    }

    public static void b(Context context, String str, i iVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        iVar.A().edit().putString("google_aid", str).apply();
    }
}
