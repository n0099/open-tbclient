package d.a.j0.l;

import android.content.Context;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.cmic.sso.sdk.auth.AuthnHelper;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static String f44160a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f44161b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f44162c = "";

    public static int a(Context context) {
        try {
            if (d.a.j0.b.a.h(context).e()) {
                if (Build.VERSION.SDK_INT < 24) {
                    return -1001;
                }
                if (c.o(context)) {
                    return SubscriptionManager.getDefaultDataSubscriptionId();
                }
                return -1002;
            }
            return -1000;
        } catch (Throwable th) {
            c.d(th);
            return -1001;
        }
    }

    public static String b(Context context, int i2, boolean z, boolean z2) {
        try {
            if (!d.a.j0.b.a.h(context).e()) {
                return c(String.valueOf(-1000), z2);
            }
            if (z) {
                if (i2 == 3 && !TextUtils.isEmpty(f44160a)) {
                    return f44160a;
                }
                if (i2 == 1 && !TextUtils.isEmpty(f44162c)) {
                    return f44162c;
                }
                if (i2 == 2 && !TextUtils.isEmpty(f44161b)) {
                    return f44161b;
                }
            }
            if (!h.a(context, "android.permission.READ_PHONE_STATE")) {
                return c(String.valueOf(-1001), z2);
            }
            if (!c.o(context)) {
                return c(String.valueOf(-1002), z2);
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String str = null;
            if (i2 == 3) {
                str = telephonyManager.getSubscriberId();
            } else if (i2 == 1) {
                str = telephonyManager.getDeviceId();
            } else if (i2 == 2) {
                str = telephonyManager.getSimSerialNumber();
            }
            if (TextUtils.isEmpty(str)) {
                return c(String.valueOf(-1003), z2);
            }
            if (i2 == 3) {
                f44160a = str;
            } else if (i2 == 1) {
                f44162c = str;
            } else if (i2 == 2) {
                f44161b = str;
            }
            return str;
        } catch (Throwable th) {
            c.d(th);
            return c(String.valueOf(-1001), z2);
        }
    }

    public static String c(String str, boolean z) {
        return z ? str : "";
    }

    public static Pair<Integer, Integer> d(Context context) {
        Pair<Integer, Integer> pair = new Pair<>(-1, -1);
        try {
            JSONObject networkType = AuthnHelper.getInstance(context).getNetworkType(context);
            if (networkType != null && networkType.has("networktype")) {
                return Pair.create(Integer.valueOf(networkType.optString("networktype", "-1")), Integer.valueOf(networkType.optString("operatortype", "-1")));
            }
            return pair;
        } catch (Throwable th) {
            c.d(th);
            return pair;
        }
    }

    public static Pair<Integer, String[]> e(Context context) {
        try {
            if (!d.a.j0.b.a.h(context).e()) {
                return new Pair<>(-1, new String[]{String.valueOf(-1000), String.valueOf(-1000), String.valueOf(-1000), String.valueOf(-1000)});
            }
            if (Build.VERSION.SDK_INT < 22) {
                return new Pair<>(-2, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
            }
            if (!h.a(context, "android.permission.READ_PHONE_STATE")) {
                return new Pair<>(-1, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
            }
            if (!c.o(context)) {
                return new Pair<>(-1, new String[]{String.valueOf(-1002), String.valueOf(-1002), String.valueOf(-1002), String.valueOf(-1002)});
            }
            List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList == null) {
                return new Pair<>(0, new String[]{String.valueOf(-1003), String.valueOf(-1003), String.valueOf(-1003), String.valueOf(-1003)});
            }
            String[] strArr = new String[4];
            int i2 = 0;
            for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                int i3 = i2 * 2;
                int simSlotIndex = subscriptionInfo.getSimSlotIndex();
                int subscriptionId = subscriptionInfo.getSubscriptionId();
                String iccId = subscriptionInfo.getIccId();
                if (TextUtils.isEmpty(iccId)) {
                    iccId = String.valueOf(-1003);
                }
                strArr[i3] = simSlotIndex + "_" + subscriptionId + "_" + iccId;
                CharSequence carrierName = subscriptionInfo.getCarrierName();
                if (carrierName != null) {
                    strArr[i3 + 1] = carrierName.toString();
                } else {
                    strArr[i3 + 1] = String.valueOf(-1003);
                }
                i2++;
                if (i2 >= 2) {
                    break;
                }
            }
            for (int i4 = 0; i4 < 4; i4++) {
                if (TextUtils.isEmpty(strArr[i4])) {
                    strArr[i4] = String.valueOf(-1003);
                }
            }
            return new Pair<>(Integer.valueOf(i2), strArr);
        } catch (Throwable th) {
            c.d(th);
            return new Pair<>(-1, new String[]{String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001), String.valueOf(-1001)});
        }
    }

    public static String f(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getSimOperator();
            }
            return String.valueOf(-1003);
        } catch (Throwable unused) {
            return String.valueOf(-1003);
        }
    }
}
