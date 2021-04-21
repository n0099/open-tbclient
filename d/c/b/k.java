package d.c.b;

import android.content.Context;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.DisplayMetrics;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.google.ar.core.InstallActivity;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class k extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65969e;

    public k(Context context) {
        super(true, false);
        this.f65969e = context;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        String str;
        DisplayMetrics displayMetrics = this.f65969e.getResources().getDisplayMetrics();
        int i = displayMetrics.densityDpi;
        switch (i) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case 260:
            case InstallActivity.BOX_SIZE_DP /* 280 */:
            case 300:
            case MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP /* 320 */:
                str = "xhdpi";
                break;
            case 340:
            case 360:
            case 400:
            case HttpStatus.SC_METHOD_FAILURE /* 420 */:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case PayBeanFactory.BEAN_ID_PAY_SORT_SAVE /* 560 */:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i);
        jSONObject.put("display_density", str);
        jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        return true;
    }
}
