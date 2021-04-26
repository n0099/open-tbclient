package d.a.g0.l;

import android.content.Context;
import android.os.Build;
import android.os.Process;
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
    public static String f40976a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f40977b = "";

    /* renamed from: c  reason: collision with root package name */
    public static Pair<Integer, String[]> f40978c;

    public static String a(Context context) {
        int checkPermission;
        try {
            if (d.a.g0.b.a.g(context).d()) {
                if (!TextUtils.isEmpty(f40976a)) {
                    return f40976a;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    checkPermission = context.checkSelfPermission("android.permission.READ_PHONE_STATE");
                } else {
                    checkPermission = context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid());
                }
                if (checkPermission != -1 && c.o(context)) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        f40976a = telephonyManager.getSubscriberId();
                    }
                    return f40976a == null ? "" : f40976a;
                }
                return "";
            }
            return "";
        } catch (Throwable th) {
            c.d(th);
            return "";
        }
    }

    public static Pair<Integer, Integer> b(Context context) {
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

    public static Pair<Integer, String[]> c(Context context) {
        int checkPermission;
        try {
            if (!d.a.g0.b.a.g(context).d()) {
                return new Pair<>(-1, new String[4]);
            }
            if (Build.VERSION.SDK_INT < 22) {
                return new Pair<>(-2, new String[4]);
            }
            if (f40978c != null) {
                return f40978c;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                checkPermission = context.checkSelfPermission("android.permission.READ_PHONE_STATE");
            } else {
                checkPermission = context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid());
            }
            if (checkPermission != -1 && c.o(context)) {
                List<SubscriptionInfo> activeSubscriptionInfoList = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
                int i2 = 0;
                if (activeSubscriptionInfoList == null) {
                    return new Pair<>(0, new String[4]);
                }
                String[] strArr = new String[4];
                for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                    int i3 = i2 * 2;
                    int simSlotIndex = subscriptionInfo.getSimSlotIndex();
                    int subscriptionId = subscriptionInfo.getSubscriptionId();
                    strArr[i3] = simSlotIndex + "_" + subscriptionId + "_" + subscriptionInfo.getIccId();
                    CharSequence carrierName = subscriptionInfo.getCarrierName();
                    if (carrierName != null) {
                        strArr[i3 + 1] = carrierName.toString();
                    }
                    i2++;
                    if (i2 >= 2) {
                        break;
                    }
                }
                Pair<Integer, String[]> pair = new Pair<>(Integer.valueOf(i2), strArr);
                f40978c = pair;
                return pair;
            }
            return new Pair<>(-1, new String[4]);
        } catch (Throwable th) {
            c.d(th);
            return new Pair<>(-1, new String[4]);
        }
    }

    public static String d(Context context) {
        int checkPermission;
        try {
            if (d.a.g0.b.a.g(context).d()) {
                if (!TextUtils.isEmpty(f40977b)) {
                    return f40977b;
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    checkPermission = context.checkSelfPermission("android.permission.READ_PHONE_STATE");
                } else {
                    checkPermission = context.checkPermission("android.permission.READ_PHONE_STATE", Process.myPid(), Process.myUid());
                }
                if (checkPermission != -1 && c.o(context)) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        f40977b = telephonyManager.getSimSerialNumber();
                    }
                    return f40977b == null ? "" : f40977b;
                }
                return "";
            }
            return "";
        } catch (Throwable th) {
            c.d(th);
            return "";
        }
    }
}
