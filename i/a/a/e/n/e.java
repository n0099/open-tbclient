package i.a.a.e.n;

import com.yy.mobile.framework.revenuesdk.payapi.PayType;
/* loaded from: classes8.dex */
public class e {
    public static boolean a(PayType payType) {
        if (payType == null) {
            return false;
        }
        return b(payType.getChannel(), payType.getMethod());
    }

    public static boolean b(String str, String str2) {
        return PayType.DXM_PAY_KJ.getChannel().equals(str) && PayType.DXM_PAY_KJ.getMethod().equals(str2);
    }
}
