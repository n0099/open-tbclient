package tv.athena.revenue.api.pay;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tieba.u6d;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\b\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/athena/revenue/api/pay/IMiddlePayService;", "Lcom/yy/mobile/framework/revenuesdk/payapi/IAppPayService;", "Lkotlin/Any;", "Ltv/athena/revenue/api/pay/params/MiddlePayWithProductInfoParams;", "params", "", "payWithProductInfo", "(Ltv/athena/revenue/api/pay/params/MiddlePayWithProductInfoParams;)V", "ChargeSource", "SubscriptType", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface IMiddlePayService extends IAppPayService {
    void a(u6d u6dVar);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ltv/athena/revenue/api/pay/IMiddlePayService$ChargeSource;", "Ljava/lang/Enum;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ROOM_CHARGE", "WALLET_CHARGE", "OTHER_CHARGE", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public enum ChargeSource {
        ROOM_CHARGE(YYOption.ROOM_ID),
        WALLET_CHARGE(AccountConstants.LOGIN_TYPE_NATIVE_SRC_WALLET),
        OTHER_CHARGE("other");
        
        public final String value;

        public final String getValue() {
            return this.value;
        }

        ChargeSource(String str) {
            this.value = str;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ltv/athena/revenue/api/pay/IMiddlePayService$SubscriptType;", "Ljava/lang/Enum;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "NORMAL_CHARGE", "SUBSCRIPT_CHARGE", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public enum SubscriptType {
        NORMAL_CHARGE(0),
        SUBSCRIPT_CHARGE(1);
        
        public final int value;

        public final int getValue() {
            return this.value;
        }

        SubscriptType(int i) {
            this.value = i;
        }
    }
}
