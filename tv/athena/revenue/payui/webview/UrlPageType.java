package tv.athena.revenue.payui.webview;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class UrlPageType {
    public static final /* synthetic */ UrlPageType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final UrlPageType ACTRD_DETAIL_PAGE;
    public static final UrlPageType ACTRD_HOLD_PAGE;
    public static final UrlPageType ACTRD_LIST_PAGE;
    public static final UrlPageType HELP_PAGE;
    public static final UrlPageType PKG_PAGE;
    public static final UrlPageType PROTOCOL_PAGE;
    public static final UrlPageType RDDETAIL_PAGE;
    public static final UrlPageType RDLIST_PAGE;
    public static final UrlPageType RDTICKET_HOLD_PAGE;
    public static final UrlPageType RD_PAGE;
    public static final UrlPageType RD_TICKET_DETAIL;
    public static final UrlPageType RD_TICKET_LIST;
    public static final UrlPageType WALLET_DETAIL_PAGE;
    public static final UrlPageType Y2RD_PAGE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(139122666, "Ltv/athena/revenue/payui/webview/UrlPageType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(139122666, "Ltv/athena/revenue/payui/webview/UrlPageType;");
                return;
            }
        }
        WALLET_DETAIL_PAGE = new UrlPageType("WALLET_DETAIL_PAGE", 0, 1);
        RD_PAGE = new UrlPageType("RD_PAGE", 1, 2);
        PKG_PAGE = new UrlPageType("PKG_PAGE", 2, 3);
        HELP_PAGE = new UrlPageType("HELP_PAGE", 3, 4);
        PROTOCOL_PAGE = new UrlPageType("PROTOCOL_PAGE", 4, 5);
        RDLIST_PAGE = new UrlPageType("RDLIST_PAGE", 5, 6);
        RDDETAIL_PAGE = new UrlPageType("RDDETAIL_PAGE", 6, 7);
        ACTRD_LIST_PAGE = new UrlPageType("ACTRD_LIST_PAGE", 7, 8);
        ACTRD_DETAIL_PAGE = new UrlPageType("ACTRD_DETAIL_PAGE", 8, 9);
        RD_TICKET_LIST = new UrlPageType("RD_TICKET_LIST", 9, 10);
        RD_TICKET_DETAIL = new UrlPageType("RD_TICKET_DETAIL", 10, 11);
        ACTRD_HOLD_PAGE = new UrlPageType("ACTRD_HOLD_PAGE", 11, 12);
        RDTICKET_HOLD_PAGE = new UrlPageType("RDTICKET_HOLD_PAGE", 12, 13);
        UrlPageType urlPageType = new UrlPageType("Y2RD_PAGE", 13, 14);
        Y2RD_PAGE = urlPageType;
        $VALUES = new UrlPageType[]{WALLET_DETAIL_PAGE, RD_PAGE, PKG_PAGE, HELP_PAGE, PROTOCOL_PAGE, RDLIST_PAGE, RDDETAIL_PAGE, ACTRD_LIST_PAGE, ACTRD_DETAIL_PAGE, RD_TICKET_LIST, RD_TICKET_DETAIL, ACTRD_HOLD_PAGE, RDTICKET_HOLD_PAGE, urlPageType};
    }

    public UrlPageType(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static UrlPageType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (UrlPageType) Enum.valueOf(UrlPageType.class, str) : (UrlPageType) invokeL.objValue;
    }

    public static UrlPageType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (UrlPageType[]) $VALUES.clone() : (UrlPageType[]) invokeV.objValue;
    }
}
