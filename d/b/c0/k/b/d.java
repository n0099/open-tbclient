package d.b.c0.k.b;
/* loaded from: classes2.dex */
public final class d {
    public static final String a() {
        return a.d() != 1 ? "https://trade.baidu-int.com/sandbox/tradegateway" : "https://etrade-api.baidu.com";
    }

    public static final String b() {
        return a() + "/cps/user/recordBatch/sapp";
    }

    public static final String c() {
        return a() + "/cashier/calcMoney";
    }

    public static final String d() {
        return a() + "/cashier/channelAllInfo";
    }

    public static final String e() {
        return a() + "/cps/user/record/sapp";
    }

    public static final String f() {
        return a() + "/cashier/launchpayment";
    }

    public static final String g() {
        return a() + "/cashier/pay";
    }

    public static final String h() {
        return a() + "/cashier/sdkAdaptH5QueryPay";
    }
}
