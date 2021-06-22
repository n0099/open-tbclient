package d.a.m0.b.n.i.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.location.BDLocation;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import com.baidu.swan.apps.impl.nalib.encrypt.EncryptConstant;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.m0.a.a2.e;
import d.a.m0.a.j2.c;
import d.a.m0.a.k;
import d.a.m0.b.n.i.b.a;
import d.a.m0.b.n.i.b.b;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f50225a = k.f46983a;

    @Nullable
    public static String a(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec((EncryptConstant.getPartRecommendAesKey() + "rtad@mic").getBytes(), "AES"), new IvParameterSpec((EncryptConstant.getPartRecommendAesIv() + "21248000").getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 2);
        } catch (Exception e2) {
            e2.printStackTrace();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("info", "encrypt request param fail with exception : " + e2.getMessage());
            } catch (JSONException e3) {
                if (f50225a) {
                    e3.printStackTrace();
                }
            }
            f(jSONObject.toString());
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(d.a.m0.b.n.i.b.a aVar, b bVar) {
        char c2;
        if (aVar == null || bVar == null) {
            return;
        }
        String str = TextUtils.isEmpty(bVar.f50222a) ? "unknown" : bVar.f50222a;
        switch (str.hashCode()) {
            case -1395470197:
                if (str.equals("bd09ll")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3017163:
                if (str.equals(BDLocation.BDLOCATION_GCJ02_TO_BD09)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 98175376:
                if (str.equals("gcj02")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 113079775:
                if (str.equals(CoordinateType.WGS84)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        int i2 = c2 != 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? -1 : 3 : 2 : 1 : 0;
        a.c cVar = aVar.f50205c;
        cVar.f50219a = i2;
        cVar.f50220b = bVar.f50223b;
        cVar.f50221c = bVar.f50224c;
    }

    public static int c() {
        String e2 = SwanAppNetworkUtils.e();
        if ("wifi".equals(e2)) {
            return 1;
        }
        if ("2g".equals(e2)) {
            return 2;
        }
        if ("3g".equals(e2)) {
            return 3;
        }
        return "4g".equals(e2) ? 4 : 0;
    }

    public static int d(Context context) {
        TelephonyManager telephonyManager;
        String simOperator;
        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (simOperator = telephonyManager.getSimOperator()) == null) {
            return 0;
        }
        if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46007".equals(simOperator)) {
            return 1;
        }
        if ("46001".equals(simOperator)) {
            return 3;
        }
        return "46003".equals(simOperator) ? 2 : 0;
    }

    public static boolean e(@NonNull Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (f50225a) {
            Log.d("recommend", "reportInfoWhenResponseIsNull: " + str);
        }
        c.b bVar = new c.b(10003);
        bVar.i(str);
        bVar.h(e.V());
        bVar.m();
    }
}
