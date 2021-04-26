package tv.athena.revenue.api.pay;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.sapi2.ecommerce.callback.AddressManageCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Ltv/athena/revenue/api/pay/MiddlePayStatus;", "Ljava/lang/Enum;", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "Companion", "RECHARGING", "CAN_NOT_USE", "WRONG_ARGS", "SEVER_ERROR", RomUtils.UNKNOWN, "NOT_SUPPORT", "ORDER_RISK_ERROR", "SERVICE_DISCONNECTED", "USER_CANCELED", "SERVICE_UNAVAILABLE", "ITEM_UNAVAILABLE", "DEVELOPER_ERROR", "ERROR", "ITEM_ALREADY_OWNED", "ITEM_NOT_OWNED", "BILLING_STARTUP", "revenue-wrapper_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public enum MiddlePayStatus {
    RECHARGING(-6, "正在支付"),
    CAN_NOT_USE(-5, "账户已冻结"),
    WRONG_ARGS(-400, "参数错误，特指参数缺失"),
    SEVER_ERROR(AddressManageCallback.VoiceRecognitionResult.ERROR_CODE_VOICE_RECOGNITION_CANCEL, "服务端错误"),
    UNKNOWN(0, "未知状态"),
    NOT_SUPPORT(3, "当前不支持该种支付方式"),
    ORDER_RISK_ERROR(-18, "风控拦截"),
    SERVICE_DISCONNECTED(-1, "服务断开"),
    USER_CANCELED(1, "用户取消"),
    SERVICE_UNAVAILABLE(2, "Network connection is down"),
    ITEM_UNAVAILABLE(4, "Requested product is not available for purchase"),
    DEVELOPER_ERROR(5, "DEVELOPER_ERROR"),
    ERROR(6, "Fatal error during the API action"),
    ITEM_ALREADY_OWNED(7, "Failure to purchase since item is already owned"),
    ITEM_NOT_OWNED(8, "Failure to consume since item is not owned"),
    BILLING_STARTUP(300, "BILLING_STARTUP");
    
    public static final a Companion = new a(null);
    public final int code;
    public final String message;

    /* loaded from: classes7.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    MiddlePayStatus(int i2, String str) {
        this.code = i2;
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
