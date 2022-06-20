package tv.athena.revenue.api.pay;

import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xz9;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\b\tJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/athena/revenue/api/pay/IMiddlePayService;", "Lcom/yy/mobile/framework/revenuesdk/payapi/IAppPayService;", "Lkotlin/Any;", "Ltv/athena/revenue/api/pay/params/MiddlePayWithProductInfoParams;", "params", "", "payWithProductInfo", "(Ltv/athena/revenue/api/pay/params/MiddlePayWithProductInfoParams;)V", "ChargeSource", "SubscriptType", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public interface IMiddlePayService extends IAppPayService {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ltv/athena/revenue/api/pay/IMiddlePayService$ChargeSource;", "Ljava/lang/Enum;", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ROOM_CHARGE", "WALLET_CHARGE", "OTHER_CHARGE", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class ChargeSource {
        public static final /* synthetic */ ChargeSource[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ChargeSource OTHER_CHARGE;
        public static final ChargeSource ROOM_CHARGE;
        public static final ChargeSource WALLET_CHARGE;
        public transient /* synthetic */ FieldHolder $fh;
        public final String value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1280491111, "Ltv/athena/revenue/api/pay/IMiddlePayService$ChargeSource;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1280491111, "Ltv/athena/revenue/api/pay/IMiddlePayService$ChargeSource;");
                    return;
                }
            }
            ChargeSource chargeSource = new ChargeSource("ROOM_CHARGE", 0, "room");
            ROOM_CHARGE = chargeSource;
            ChargeSource chargeSource2 = new ChargeSource("WALLET_CHARGE", 1, AccountConstants.LOGIN_TYPE_NATIVE_SRC_WALLET);
            WALLET_CHARGE = chargeSource2;
            ChargeSource chargeSource3 = new ChargeSource("OTHER_CHARGE", 2, ImageViewerConfig.FROM_OTHER);
            OTHER_CHARGE = chargeSource3;
            $VALUES = new ChargeSource[]{chargeSource, chargeSource2, chargeSource3};
        }

        public ChargeSource(String str, int i, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = str2;
        }

        public static ChargeSource valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ChargeSource) Enum.valueOf(ChargeSource.class, str) : (ChargeSource) invokeL.objValue;
        }

        public static ChargeSource[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ChargeSource[]) $VALUES.clone() : (ChargeSource[]) invokeV.objValue;
        }

        public final String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (String) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Ltv/athena/revenue/api/pay/IMiddlePayService$SubscriptType;", "Ljava/lang/Enum;", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "NORMAL_CHARGE", "SUBSCRIPT_CHARGE", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class SubscriptType {
        public static final /* synthetic */ SubscriptType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SubscriptType NORMAL_CHARGE;
        public static final SubscriptType SUBSCRIPT_CHARGE;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1851245097, "Ltv/athena/revenue/api/pay/IMiddlePayService$SubscriptType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1851245097, "Ltv/athena/revenue/api/pay/IMiddlePayService$SubscriptType;");
                    return;
                }
            }
            SubscriptType subscriptType = new SubscriptType("NORMAL_CHARGE", 0, 0);
            NORMAL_CHARGE = subscriptType;
            SubscriptType subscriptType2 = new SubscriptType("SUBSCRIPT_CHARGE", 1, 1);
            SUBSCRIPT_CHARGE = subscriptType2;
            $VALUES = new SubscriptType[]{subscriptType, subscriptType2};
        }

        public SubscriptType(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i2;
        }

        public static SubscriptType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SubscriptType) Enum.valueOf(SubscriptType.class, str) : (SubscriptType) invokeL.objValue;
        }

        public static SubscriptType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SubscriptType[]) $VALUES.clone() : (SubscriptType[]) invokeV.objValue;
        }

        public final int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    void a(xz9 xz9Var);
}
