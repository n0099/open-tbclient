package com.google.zxing.client.result;

import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class ParsedResultType {
    public static final /* synthetic */ ParsedResultType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final ParsedResultType ADDRESSBOOK;
    public static final ParsedResultType CALENDAR;
    public static final ParsedResultType EMAIL_ADDRESS;
    public static final ParsedResultType GEO;
    public static final ParsedResultType ISBN;
    public static final ParsedResultType PRODUCT;
    public static final ParsedResultType SMS;
    public static final ParsedResultType TEL;
    public static final ParsedResultType TEXT;
    public static final ParsedResultType URI;
    public static final ParsedResultType VIN;
    public static final ParsedResultType WIFI;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1070023198, "Lcom/google/zxing/client/result/ParsedResultType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1070023198, "Lcom/google/zxing/client/result/ParsedResultType;");
                return;
            }
        }
        ADDRESSBOOK = new ParsedResultType("ADDRESSBOOK", 0);
        EMAIL_ADDRESS = new ParsedResultType("EMAIL_ADDRESS", 1);
        PRODUCT = new ParsedResultType("PRODUCT", 2);
        URI = new ParsedResultType(DownloadConstants.DownloadColumns.COLUMN_URI, 3);
        TEXT = new ParsedResultType("TEXT", 4);
        GEO = new ParsedResultType(BdSailorConfig.SAILOR_BASE_GEO, 5);
        TEL = new ParsedResultType("TEL", 6);
        SMS = new ParsedResultType("SMS", 7);
        CALENDAR = new ParsedResultType("CALENDAR", 8);
        WIFI = new ParsedResultType(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 9);
        ISBN = new ParsedResultType("ISBN", 10);
        ParsedResultType parsedResultType = new ParsedResultType("VIN", 11);
        VIN = parsedResultType;
        $VALUES = new ParsedResultType[]{ADDRESSBOOK, EMAIL_ADDRESS, PRODUCT, URI, TEXT, GEO, TEL, SMS, CALENDAR, WIFI, ISBN, parsedResultType};
    }

    public ParsedResultType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ParsedResultType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ParsedResultType) Enum.valueOf(ParsedResultType.class, str) : (ParsedResultType) invokeL.objValue;
    }

    public static ParsedResultType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ParsedResultType[]) $VALUES.clone() : (ParsedResultType[]) invokeV.objValue;
    }
}
