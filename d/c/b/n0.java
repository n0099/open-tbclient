package d.c.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
/* loaded from: classes5.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f65981a;

    public static String a(Context context, i iVar) {
        if (TextUtils.isEmpty(f65981a)) {
            synchronized (n0.class) {
                if (!TextUtils.isEmpty(f65981a)) {
                    return f65981a;
                }
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = iVar.A().getString("google_aid", null);
                } else if (!TextUtils.equals(iVar.A().getString("google_aid", null), id)) {
                    b(context, id, iVar);
                }
                f65981a = id;
            }
        }
        return f65981a;
    }

    public static void b(Context context, String str, i iVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        iVar.A().edit().putString("google_aid", str).apply();
    }
}
