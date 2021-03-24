package kotlin.jvm.internal;

import com.baidu.tieba.wallet.pay.WalletPayViewController;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\bÀ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0005R\u001c\u0010\b\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005R\u001c\u0010\n\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\u0005R\u001c\u0010\f\u001a\u00020\u00018\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u0005¨\u0006\u0010"}, d2 = {"Lkotlin/jvm/internal/DoubleCompanionObject;", "", "MAX_VALUE", "D", "getMAX_VALUE", "()D", "MIN_VALUE", "getMIN_VALUE", "NEGATIVE_INFINITY", "getNEGATIVE_INFINITY", WalletPayViewController.DEF_CHANNEL_TITLE, "getNaN", "POSITIVE_INFINITY", "getPOSITIVE_INFINITY", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class DoubleCompanionObject {
    public static final DoubleCompanionObject INSTANCE = new DoubleCompanionObject();
    public static final double MIN_VALUE = Double.MIN_VALUE;
    public static final double MAX_VALUE = Double.MAX_VALUE;
    public static final double POSITIVE_INFINITY = Double.POSITIVE_INFINITY;
    public static final double NEGATIVE_INFINITY = Double.NEGATIVE_INFINITY;
    public static final double NaN = Double.NaN;

    public final double getMAX_VALUE() {
        return MAX_VALUE;
    }

    public final double getMIN_VALUE() {
        return MIN_VALUE;
    }

    public final double getNEGATIVE_INFINITY() {
        return NEGATIVE_INFINITY;
    }

    public final double getNaN() {
        return NaN;
    }

    public final double getPOSITIVE_INFINITY() {
        return POSITIVE_INFINITY;
    }
}
