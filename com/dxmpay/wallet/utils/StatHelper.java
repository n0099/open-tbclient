package com.dxmpay.wallet.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.b.g.a;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.realtimeevent.RealTimeEventHelper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes9.dex */
public class StatHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BANK_CODE = "bank_code";
    public static final String BANK_SIGN_TYPE = "bank_sign_type";
    public static final String BIND_CARD_USER_TYPE = "bind_card_user_type";
    public static final String CARD_TYPE = "card_type";
    public static final String CODE = "code";
    public static final String HAS_BANK_CARD = "has_bank_card";
    public static final String LBS_PAY_CHANNEL = "2";
    public static final String MSG = "msg";
    public static final String PAY_AMOUNT = "pay_amount";
    public static final String PAY_BANKSIGN = "pay_banksign";
    public static final String PAY_CATEGORY = "pay_category";
    public static final String PAY_FROM = "pay_from";
    public static final int PAY_SENSOR_0 = 0;
    public static final int PAY_SENSOR_1 = 1;
    public static final int PAY_SENSOR_2 = 2;
    public static final int PAY_SENSOR_3 = 3;
    public static final int PAY_SENSOR_4 = 4;
    public static final String PAY_WAY = "pay_way";
    public static final String PRECASHIER_PAY_CHANNEL = "1";
    public static final String REMOTE_PAY_CHANNEL = "3";
    public static final String SENSOR_0 = "0";
    public static final String SENSOR_1 = "1";
    public static final String SENSOR_2 = "2";
    public static final String SENSOR_ERR_1 = "-1";
    public static final String SENSOR_ERR_2 = "-2";
    public static final String SENSOR_OK = "OK";
    public static final String SIGN_PAY = "sign_pay";
    public static final String SIGN_PAY_CHANNEL = "4";
    public static final String SP_NO = "sp_no";
    public static final String STD_PAY_CHANNEL = "0";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f70251a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f70252b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f70253c = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class Key {
        public static final /* synthetic */ Key[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Key alipayVersion;
        public static final Key bankCardStartTime;
        public static final Key bankCode;
        public static final Key bindCardUserType;
        public static final Key cardType;
        public static final Key channelId;
        public static final Key code;
        public static final Key fromPkg;
        public static final Key hasBankCard;
        public static final Key hasPwd;
        public static final Key msg;
        public static final Key orderId;
        public static final Key orderNo;
        public static final Key passLoginStatus;
        public static final Key payAmount;
        public static final Key payFrom;
        public static final Key payType;
        public static final Key payWay;
        public static final Key precashierMark;
        public static final Key sessionId;
        public static final Key signPay;
        public static final Key spNo;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(628113936, "Lcom/dxmpay/wallet/utils/StatHelper$Key;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(628113936, "Lcom/dxmpay/wallet/utils/StatHelper$Key;");
                    return;
                }
            }
            orderNo = new Key("orderNo", 0);
            spNo = new Key("spNo", 1);
            fromPkg = new Key("fromPkg", 2);
            hasPwd = new Key("hasPwd", 3);
            payType = new Key("payType", 4);
            payWay = new Key("payWay", 5);
            orderId = new Key("orderId", 6);
            channelId = new Key(AppConfigImp.KEY_CHANNELID, 7);
            passLoginStatus = new Key("passLoginStatus", 8);
            sessionId = new Key("sessionId", 9);
            payAmount = new Key("payAmount", 10);
            precashierMark = new Key("precashierMark", 11);
            bankCode = new Key("bankCode", 12);
            cardType = new Key("cardType", 13);
            payFrom = new Key("payFrom", 14);
            bindCardUserType = new Key("bindCardUserType", 15);
            signPay = new Key("signPay", 16);
            hasBankCard = new Key("hasBankCard", 17);
            code = new Key("code", 18);
            msg = new Key("msg", 19);
            bankCardStartTime = new Key("bankCardStartTime", 20);
            Key key = new Key("alipayVersion", 21);
            alipayVersion = key;
            $VALUES = new Key[]{orderNo, spNo, fromPkg, hasPwd, payType, payWay, orderId, channelId, passLoginStatus, sessionId, payAmount, precashierMark, bankCode, cardType, payFrom, bindCardUserType, signPay, hasBankCard, code, msg, bankCardStartTime, key};
        }

        public Key(String str, int i2) {
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

        public static Key valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Key) Enum.valueOf(Key.class, str) : (Key) invokeL.objValue;
        }

        public static Key[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Key[]) $VALUES.clone() : (Key[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(946657867, "Lcom/dxmpay/wallet/utils/StatHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(946657867, "Lcom/dxmpay/wallet/utils/StatHelper;");
        }
    }

    public StatHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String uuid = UUID.randomUUID().toString();
            return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
        }
        return (String) invokeV.objValue;
    }

    public static void b(String str, Map<String, Object> map, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, str, map, strArr) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<String> collectData = collectData(getOrderNo(), getHasPwd(), getPayType(), getPayWay());
        if (strArr != null) {
            for (String str2 : strArr) {
                collectData.add(str2);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sp_no", getSpNo());
        hashMap.put("pay_amount", getPayAmount());
        hashMap.put(BANK_CODE, getBankCode());
        hashMap.put("card_type", getCardType());
        hashMap.put("pay_from", getPayFrom());
        hashMap.put(HAS_BANK_CARD, getHasBankCard());
        if (f70251a) {
            hashMap.put(PAY_BANKSIGN, "1");
        }
        if (f70252b) {
            hashMap.put(PAY_CATEGORY, "1");
        }
        if ("4".equals(getPayFrom())) {
            hashMap.put(SIGN_PAY, getSignPay());
        }
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        StatisticManager.onEventWithValues(str, collectData, hashMap);
    }

    public static void bankCardDetction(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            bankCardDetctionDuration(str, str2, -1L);
        }
    }

    public static void bankCardDetctionDuration(String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, str2, Long.valueOf(j2)}) == null) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(getPayFrom())) {
                arrayList.add(getSessionId());
                hashMap.put(BIND_CARD_USER_TYPE, getBindCardUserType());
            } else {
                arrayList.add(getOrderNo());
                arrayList.add(getHasPwd());
                hashMap.put("pay_from", getPayFrom());
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("error_code", str2);
            }
            if (j2 >= 0) {
                hashMap.put("duration", Long.valueOf(j2));
            }
            StatisticManager.onEventWithValues(str, arrayList, hashMap);
        }
    }

    public static void c(String str, Map<String, Object> map, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, map, strArr) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<String> collectData = collectData(getSessionId(), new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put(BIND_CARD_USER_TYPE, getBindCardUserType());
        if (strArr != null) {
            for (String str2 : strArr) {
                collectData.add(str2);
            }
        }
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        StatisticManager.onEventWithValues(str, collectData, hashMap);
    }

    public static void cacheAlipayVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            a.c(Key.alipayVersion.name(), str);
        }
    }

    public static void cacheBankCardStartTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65544, null, j2) == null) {
            a.c(Key.bankCardStartTime.name(), Long.valueOf(j2));
        }
    }

    public static void cacheBankCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            a.c(Key.bankCode.name(), str);
        }
    }

    public static void cacheBindCardUserType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
            a.c(Key.bindCardUserType.name(), str);
        }
    }

    public static void cacheCardType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, str) == null) {
            a.c(Key.cardType.name(), str);
        }
    }

    public static void cacheChannelId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, str) == null) {
            a.c(Key.channelId.name(), str);
        }
    }

    public static void cacheCodeAndMsg(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            a.c(Key.code.name(), str);
            a.c(Key.msg.name(), str2);
        }
    }

    public static void cacheFromPkg(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, str) == null) {
            a.c(Key.fromPkg.name(), str);
        }
    }

    public static void cacheHasBankCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65551, null, z) == null) {
            a.c(Key.hasBankCard.name(), z ? "1" : "0");
        }
    }

    public static void cacheHasPwd(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65552, null, z) == null) {
            a.c(Key.hasPwd.name(), z ? "1" : "0");
        }
    }

    public static void cacheOrderId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            a.c(Key.orderId.name(), str);
        }
    }

    public static void cacheOrderNo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            a.c(Key.orderNo.name(), str);
        }
    }

    public static void cachePassLoginStatus(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            a.c(Key.passLoginStatus.name(), str);
        }
    }

    public static void cachePayAmount(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{Double.valueOf(d2)}) == null) {
            a.c(Key.payAmount.name(), Double.valueOf(d2));
        }
    }

    public static void cachePayFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, str) == null) {
            a.c(Key.payFrom.name(), str);
        }
    }

    public static void cachePayType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65558, null, i2) == null) {
            a.c(Key.payType.name(), String.valueOf(i2));
        }
    }

    public static void cachePayWay(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65559, null, i2) == null) {
            a.c(Key.payWay.name(), String.valueOf(i2));
        }
    }

    public static void cacheSessionId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, str) == null) {
            a.c(Key.sessionId.name(), str);
        }
    }

    public static void cacheSignPay(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, str) == null) {
            a.c(Key.signPay.name(), str);
        }
    }

    public static void cacheSpNo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, str) == null) {
            a.c(Key.spNo.name(), str);
        }
    }

    public static void clearProcesssId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, null) == null) {
            f70253c = null;
        }
    }

    public static void clearSensor() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, null) == null) {
            a.c(Key.payWay.name(), null);
            a.c(Key.payType.name(), null);
            a.c(Key.hasPwd.name(), null);
            a.c(Key.bankCode.name(), null);
            a.c(Key.cardType.name(), null);
            a.c(Key.orderNo.name(), null);
            a.c(Key.spNo.name(), null);
            a.c(Key.orderId.name(), null);
            a.c(Key.channelId.name(), null);
            a.c(Key.sessionId.name(), null);
            a.c(Key.payAmount.name(), null);
            a.c(Key.bindCardUserType.name(), null);
            a.c(Key.payFrom.name(), null);
            a.c(Key.signPay.name(), null);
            a.c(Key.code.name(), null);
            a.c(Key.msg.name(), null);
            a.c(Key.alipayVersion.name(), null);
            f70251a = false;
            f70252b = false;
        }
    }

    public static List<String> collectData(String str, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, str, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            if (str != null) {
                arrayList.add(str);
            }
            for (String str2 : strArr) {
                arrayList.add(str2);
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static double fen2YuanBigDecimal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            try {
                return new BigDecimal(str).divide(BigDecimal.valueOf(100L)).setScale(2, 4).doubleValue();
            } catch (Exception unused) {
                return 0.0d;
            }
        }
        return invokeL.doubleValue;
    }

    public static String getAlipayVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) ? (String) a.b(Key.alipayVersion.name()) : (String) invokeV.objValue;
    }

    public static long getBankCardStartTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) ? ((Long) a.b(Key.bankCardStartTime.name())).longValue() : invokeV.longValue;
    }

    public static String getBankCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) ? (String) a.b(Key.bankCode.name()) : (String) invokeV.objValue;
    }

    public static String getBindCardUserType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) ? (String) a.b(Key.bindCardUserType.name()) : (String) invokeV.objValue;
    }

    public static String getCardType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) ? (String) a.b(Key.cardType.name()) : (String) invokeV.objValue;
    }

    public static String getChannelId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) ? (String) a.b(Key.channelId.name()) : (String) invokeV.objValue;
    }

    public static String getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) ? (String) a.b(Key.code.name()) : (String) invokeV.objValue;
    }

    public static String getFromPkg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65574, null)) == null) ? (String) a.b(Key.fromPkg.name()) : (String) invokeV.objValue;
    }

    public static String getHasBankCard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? (String) a.b(Key.hasBankCard.name()) : (String) invokeV.objValue;
    }

    public static String getHasPwd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) ? (String) a.b(Key.hasPwd.name()) : (String) invokeV.objValue;
    }

    public static String getMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) ? (String) a.b(Key.msg.name()) : (String) invokeV.objValue;
    }

    public static String getOrderId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) ? (String) a.b(Key.orderId.name()) : (String) invokeV.objValue;
    }

    public static String getOrderNo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return RealTimeEventHelper.getSinalParam(str, "order_no");
        }
        return (String) invokeL.objValue;
    }

    public static String getPassLoginStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) ? (String) a.b(Key.passLoginStatus.name()) : (String) invokeV.objValue;
    }

    public static String getPayAmount(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return RealTimeEventHelper.getSinalParam(str, "total_amount");
        }
        return (String) invokeL.objValue;
    }

    public static String getPayFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) ? (String) a.b(Key.payFrom.name()) : (String) invokeV.objValue;
    }

    public static String getPayType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65585, null)) == null) ? (String) a.b(Key.payType.name()) : (String) invokeV.objValue;
    }

    public static String getPayWay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65586, null)) == null) ? (String) a.b(Key.payWay.name()) : (String) invokeV.objValue;
    }

    public static String getProcesssId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            if (!TextUtils.isEmpty(f70253c)) {
                return f70253c;
            }
            String a2 = a();
            f70253c = a2;
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public static String getPureSign(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65588, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return RealTimeEventHelper.getSinalParam(str, "pure_sign");
        }
        return (String) invokeL.objValue;
    }

    public static String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65589, null)) == null) ? (String) a.b(Key.sessionId.name()) : (String) invokeV.objValue;
    }

    public static String getSignPay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65590, null)) == null) ? (String) a.b(Key.signPay.name()) : (String) invokeV.objValue;
    }

    public static String getSpNo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65592, null, str)) == null) ? RealTimeEventHelper.getSinalParam(str, "sp_no") : (String) invokeL.objValue;
    }

    public static boolean isPrecashierPay(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65593, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.equals(a.b(Key.precashierMark.name()));
        }
        return invokeL.booleanValue;
    }

    public static void payEventEndWithValues(String str, Map<String, Object> map, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65594, null, str, map, strArr) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<String> collectData = collectData(getOrderNo(), new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("pay_from", getPayFrom());
        hashMap.put("code", getCode());
        hashMap.put("msg", getMsg());
        if (strArr != null) {
            for (String str2 : strArr) {
                collectData.add(str2);
            }
        }
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        StatisticManager.onEventEndWithValues(str, collectData, hashMap);
    }

    public static void payLoginSeneor(String str, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65595, null, str, strArr) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pay_from", getPayFrom());
        ArrayList arrayList = new ArrayList();
        arrayList.add(getOrderNo());
        arrayList.add(getSpNo());
        if (strArr != null) {
            for (String str2 : strArr) {
                arrayList.add(str2);
            }
        }
        StatisticManager.onEventWithValues(str, arrayList, hashMap);
    }

    public static void setDowngrade(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65596, null, z) == null) {
            f70252b = z;
        }
    }

    public static void setPayBankSign(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65597, null, z) == null) {
            f70251a = z;
        }
    }

    public static void setPrecashierMark(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65598, null, str) == null) {
            a.c(Key.precashierMark.name(), str);
        }
    }

    public static void statServiceEvent(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65599, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        statServiceEvent(str, null, new String[0]);
    }

    public static String getSpNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65591, null)) == null) ? (String) a.b(Key.spNo.name()) : (String) invokeV.objValue;
    }

    public static String getOrderNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) ? (String) a.b(Key.orderNo.name()) : (String) invokeV.objValue;
    }

    public static Double getPayAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65582, null)) == null) ? (Double) a.b(Key.payAmount.name()) : (Double) invokeV.objValue;
    }

    public static void statServiceEvent(String str, Map<String, Object> map, String... strArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65600, null, str, map, strArr) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(getPayFrom())) {
            c(str, map, strArr);
        } else {
            b(str, map, strArr);
        }
    }
}
