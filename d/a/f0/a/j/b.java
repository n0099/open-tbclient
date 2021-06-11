package d.a.f0.a.j;

import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import com.coremedia.iso.boxes.FreeSpaceBox;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f43526a = 120;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final JSONObject a(String str, boolean z) {
        char c2;
        String str2;
        switch (str.hashCode()) {
            case -1472943047:
                if (str.equals("click_float_lottie")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case -1340273551:
                if (str.equals("wifi_tip")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -1152479161:
                if (str.equals("ad_logo")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -264975480:
                if (str.equals("bd_logo")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 3327403:
                if (str.equals("logo")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3532159:
                if (str.equals(FreeSpaceBox.TYPE)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 31392744:
                if (str.equals("download_desc")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 102727412:
                if (str.equals(NotificationCompatJellybean.KEY_LABEL)) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                if (!z) {
                    str2 = "{\"l_gravity\": 10,\"margin\": \"0_0_0_" + f43526a + "\"}";
                    break;
                } else {
                    str2 = "{\"l_gravity\": 10,\"margin\": \"0_0_0_0\"}";
                    break;
                }
            case 1:
                if (!z) {
                    str2 = "{\"l_gravity\": 10,\"margin\": \"0_0_25_" + f43526a + "\"}";
                    break;
                } else {
                    str2 = "{\"l_gravity\": 10,\"margin\": \"0_0_25_0\"}";
                    break;
                }
            case 2:
                str2 = "{\"l_gravity\": 9,\"margin\": \"0_20_15_0\"}";
                break;
            case 3:
                str2 = "{\"l_gravity\": 5,\"margin\": \"15_20_0_0\"}";
                break;
            case 4:
                if (!z) {
                    str2 = "{\"l_gravity\": 18,\"margin\": \"0_0_0_" + (f43526a + 15) + "\"}";
                    break;
                } else {
                    str2 = "{\"l_gravity\": 18,\"margin\": \"0_0_0_15\"}";
                    break;
                }
            case 5:
                str2 = "{\"l_gravity\": 5,\"margin\": \"14_14_0_0\"}";
                break;
            case 6:
                if (!z) {
                    str2 = "{\"l_gravity\": 6,\"margin\": \"0_0_0_" + f43526a + "\"}";
                    break;
                } else {
                    str2 = "{\"l_gravity\": 6,\"margin\": \"0_0_0_65\"}";
                    break;
                }
            case 7:
                if (!z) {
                    str2 = "{\"is_equal_bottom_logo\":0,\"l_gravity\": 18,\"margin\": \"0_0_0_" + (f43526a + 39) + "\"}";
                    break;
                } else {
                    str2 = "{\"l_gravity\": 18,\"margin\": \"0_0_0_37\"}";
                    break;
                }
            default:
                str2 = "";
                break;
        }
        try {
            return new JSONObject(str2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject b(JSONObject jSONObject, String str, boolean z) {
        String str2;
        JSONObject jSONObject2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (jSONObject != null) {
            if (z) {
                str2 = str + "_f";
            } else {
                str2 = str;
            }
            jSONObject2 = jSONObject.optJSONObject(str2);
        }
        return (jSONObject2 == null || jSONObject2.isNull("l_gravity")) ? a(str, z) : jSONObject2;
    }
}
