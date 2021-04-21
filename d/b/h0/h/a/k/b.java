package d.b.h0.h.a.k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b extends c {
    public b(@NonNull Context context) {
        super("GaodeMap", context.getString(R.string.openlocation_bottommenu_gaodemap), "com.autonavi.minimap");
    }

    @Override // d.b.h0.h.a.k.c
    public void e(Context context, LatLng latLng, LatLng latLng2, String str, String str2) {
        if (latLng == null || latLng2 == null) {
            return;
        }
        Uri.Builder buildUpon = Uri.parse("androidamap://route?").buildUpon();
        buildUpon.appendQueryParameter("sourceApplication", context.getPackageName());
        buildUpon.appendQueryParameter("slat", String.valueOf(latLng.latitude));
        buildUpon.appendQueryParameter("slon", String.valueOf(latLng.longitude));
        buildUpon.appendQueryParameter("sname", str);
        buildUpon.appendQueryParameter("dlat", String.valueOf(latLng2.latitude));
        buildUpon.appendQueryParameter("dlon", String.valueOf(latLng2.longitude));
        buildUpon.appendQueryParameter("dname", str2);
        buildUpon.appendQueryParameter(BdZeusUtil.URL_KEY_MACHINE, "0");
        buildUpon.appendQueryParameter("t", "0");
        Intent intent = new Intent("android.intent.action.VIEW", buildUpon.build());
        intent.setPackage("com.autonavi.minimap");
        context.startActivity(intent);
    }
}
