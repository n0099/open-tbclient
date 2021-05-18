package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
/* loaded from: classes5.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f65025a;

    public static String a(Context context, i iVar) {
        if (TextUtils.isEmpty(f65025a)) {
            synchronized (n0.class) {
                if (!TextUtils.isEmpty(f65025a)) {
                    return f65025a;
                }
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = iVar.A().getString("google_aid", null);
                } else if (!TextUtils.equals(iVar.A().getString("google_aid", null), id)) {
                    b(context, id, iVar);
                }
                f65025a = id;
            }
        }
        return f65025a;
    }

    public static void b(Context context, String str, i iVar) {
        if (TextUtils.isEmpty(str) || context == null) {
            return;
        }
        iVar.A().edit().putString("google_aid", str).apply();
    }
}
