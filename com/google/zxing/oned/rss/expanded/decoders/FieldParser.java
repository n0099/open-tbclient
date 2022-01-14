package com.google.zxing.oned.rss.expanded.decoders;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.NotFoundException;
import com.kuaishou.weapon.un.g;
import com.sina.weibo.sdk.utils.WbAuthConstants;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
/* loaded from: classes3.dex */
public final class FieldParser {
    public static /* synthetic */ Interceptable $ic;
    public static final Object[][] FOUR_DIGIT_DATA_LENGTH;
    public static final Object[][] THREE_DIGIT_DATA_LENGTH;
    public static final Object[][] THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH;
    public static final Object[][] TWO_DIGIT_DATA_LENGTH;
    public static final Object VARIABLE_LENGTH;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1266915891, "Lcom/google/zxing/oned/rss/expanded/decoders/FieldParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1266915891, "Lcom/google/zxing/oned/rss/expanded/decoders/FieldParser;");
                return;
            }
        }
        VARIABLE_LENGTH = new Object();
        TWO_DIGIT_DATA_LENGTH = new Object[][]{new Object[]{"00", 18}, new Object[]{"01", 14}, new Object[]{"02", 14}, new Object[]{"10", VARIABLE_LENGTH, 20}, new Object[]{"11", 6}, new Object[]{"12", 6}, new Object[]{"13", 6}, new Object[]{"15", 6}, new Object[]{"17", 6}, new Object[]{UVEventType.PAY_WALLET_BANNER_SHOW, 2}, new Object[]{"21", VARIABLE_LENGTH, 20}, new Object[]{"22", VARIABLE_LENGTH, 29}, new Object[]{"30", VARIABLE_LENGTH, 8}, new Object[]{PayConfig.PAYMENT_POS_KEY_MANGA, VARIABLE_LENGTH, 8}, new Object[]{"90", VARIABLE_LENGTH, 30}, new Object[]{"91", VARIABLE_LENGTH, 30}, new Object[]{"92", VARIABLE_LENGTH, 30}, new Object[]{BaseUtils.METHOD_RECEIVEESSAGE, VARIABLE_LENGTH, 30}, new Object[]{HttpConfig.UBC_HTTP_ID, VARIABLE_LENGTH, 30}, new Object[]{"95", VARIABLE_LENGTH, 30}, new Object[]{"96", VARIABLE_LENGTH, 30}, new Object[]{"97", VARIABLE_LENGTH, 30}, new Object[]{"98", VARIABLE_LENGTH, 30}, new Object[]{"99", VARIABLE_LENGTH, 30}};
        THREE_DIGIT_DATA_LENGTH = new Object[][]{new Object[]{"240", VARIABLE_LENGTH, 30}, new Object[]{"241", VARIABLE_LENGTH, 30}, new Object[]{"242", VARIABLE_LENGTH, 6}, new Object[]{"250", VARIABLE_LENGTH, 30}, new Object[]{"251", VARIABLE_LENGTH, 30}, new Object[]{"253", VARIABLE_LENGTH, 17}, new Object[]{"254", VARIABLE_LENGTH, 20}, new Object[]{FontParser.sFontWeightDefault, VARIABLE_LENGTH, 30}, new Object[]{TbEnum.SystemMessage.EVENT_ID_APPLY_FRIEND, VARIABLE_LENGTH, 30}, new Object[]{TbEnum.SystemMessage.EVENT_ID_PASSED_FRIEND, 17}, new Object[]{"403", VARIABLE_LENGTH, 30}, new Object[]{TbEnum.SystemMessage.EVENT_ID_APPLY_ADD_FRIEND, 13}, new Object[]{TbEnum.SystemMessage.EVENT_ID_APPLY_PASS_FRIEND, 13}, new Object[]{TbEnum.SystemMessage.EVENT_ID_APPLY_REPLY_MESSAGE, 13}, new Object[]{"413", 13}, new Object[]{"414", 13}, new Object[]{"420", VARIABLE_LENGTH, 20}, new Object[]{"421", VARIABLE_LENGTH, 15}, new Object[]{"422", 3}, new Object[]{"423", VARIABLE_LENGTH, 15}, new Object[]{"424", 3}, new Object[]{"425", 3}, new Object[]{"426", 3}};
        THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = new Object[][]{new Object[]{"310", 6}, new Object[]{"311", 6}, new Object[]{"312", 6}, new Object[]{"313", 6}, new Object[]{"314", 6}, new Object[]{"315", 6}, new Object[]{"316", 6}, new Object[]{PaymentConfirmRequestData.TERMINAL_ANDROID, 6}, new Object[]{"321", 6}, new Object[]{VideoPlayerUbcConstants.UBC_VIDEO_PLAY_SUCCESS, 6}, new Object[]{"323", 6}, new Object[]{"324", 6}, new Object[]{"325", 6}, new Object[]{UnitedSchemeStatisticUtil.UBC_KEY_SCHEME_INVALID, 6}, new Object[]{UnitedSchemeStatisticUtil.UBC_KEY_SCHEME_INVOKE, 6}, new Object[]{UnitedSchemeStatisticUtil.UBC_KEY_SCHEME_UPDATE, 6}, new Object[]{"329", 6}, new Object[]{"330", 6}, new Object[]{"331", 6}, new Object[]{"332", 6}, new Object[]{"333", 6}, new Object[]{"334", 6}, new Object[]{"335", 6}, new Object[]{"336", 6}, new Object[]{"340", 6}, new Object[]{"341", 6}, new Object[]{"342", 6}, new Object[]{"343", 6}, new Object[]{"344", 6}, new Object[]{"345", 6}, new Object[]{"346", 6}, new Object[]{"347", 6}, new Object[]{"348", 6}, new Object[]{"349", 6}, new Object[]{"350", 6}, new Object[]{"351", 6}, new Object[]{"352", 6}, new Object[]{"353", 6}, new Object[]{"354", 6}, new Object[]{"355", 6}, new Object[]{"356", 6}, new Object[]{"357", 6}, new Object[]{g.f55060h, 6}, new Object[]{"361", 6}, new Object[]{"362", 6}, new Object[]{"363", 6}, new Object[]{"364", 6}, new Object[]{"365", 6}, new Object[]{"366", 6}, new Object[]{"367", 6}, new Object[]{"368", 6}, new Object[]{"369", 6}, new Object[]{"390", VARIABLE_LENGTH, 15}, new Object[]{"391", VARIABLE_LENGTH, 18}, new Object[]{"392", VARIABLE_LENGTH, 15}, new Object[]{"393", VARIABLE_LENGTH, 18}, new Object[]{"703", VARIABLE_LENGTH, 30}};
        FOUR_DIGIT_DATA_LENGTH = new Object[][]{new Object[]{"7001", 13}, new Object[]{"7002", VARIABLE_LENGTH, 30}, new Object[]{"7003", 10}, new Object[]{WbAuthConstants.AUTH_FAILED_INSTALL_APP_COUNTERFEIT_CODE, 14}, new Object[]{WbAuthConstants.AUTH_FAILED_NOT_SUPPORT_QUICK_AUTH_CODE, VARIABLE_LENGTH, 20}, new Object[]{WbAuthConstants.FETCH_FAILED_NOT_SUPPORT_CODE, VARIABLE_LENGTH, 30}, new Object[]{WbAuthConstants.AUTH_FAILED_QUICK_ERROR_CODE, VARIABLE_LENGTH, 30}, new Object[]{WbAuthConstants.AUTH_FAILED_QUICK_NULL_TOKEN_ERROR_CODE, 6}, new Object[]{"8006", 18}, new Object[]{"8007", VARIABLE_LENGTH, 30}, new Object[]{"8008", VARIABLE_LENGTH, 12}, new Object[]{"8018", 18}, new Object[]{"8020", VARIABLE_LENGTH, 25}, new Object[]{"8100", 6}, new Object[]{"8101", 10}, new Object[]{"8102", 2}, new Object[]{"8110", VARIABLE_LENGTH, 70}, new Object[]{"8200", VARIABLE_LENGTH, 70}};
    }

    public FieldParser() {
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

    public static String parseFieldsInGeneralPurpose(String str) throws NotFoundException {
        InterceptResult invokeL;
        Object[][] objArr;
        Object[][] objArr2;
        Object[][] objArr3;
        Object[][] objArr4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.isEmpty()) {
                return null;
            }
            if (str.length() >= 2) {
                String substring = str.substring(0, 2);
                for (Object[] objArr5 : TWO_DIGIT_DATA_LENGTH) {
                    if (objArr5[0].equals(substring)) {
                        if (objArr5[1] == VARIABLE_LENGTH) {
                            return processVariableAI(2, ((Integer) objArr5[2]).intValue(), str);
                        }
                        return processFixedAI(2, ((Integer) objArr5[1]).intValue(), str);
                    }
                }
                if (str.length() >= 3) {
                    String substring2 = str.substring(0, 3);
                    for (Object[] objArr6 : THREE_DIGIT_DATA_LENGTH) {
                        if (objArr6[0].equals(substring2)) {
                            if (objArr6[1] == VARIABLE_LENGTH) {
                                return processVariableAI(3, ((Integer) objArr6[2]).intValue(), str);
                            }
                            return processFixedAI(3, ((Integer) objArr6[1]).intValue(), str);
                        }
                    }
                    for (Object[] objArr7 : THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH) {
                        if (objArr7[0].equals(substring2)) {
                            if (objArr7[1] == VARIABLE_LENGTH) {
                                return processVariableAI(4, ((Integer) objArr7[2]).intValue(), str);
                            }
                            return processFixedAI(4, ((Integer) objArr7[1]).intValue(), str);
                        }
                    }
                    if (str.length() >= 4) {
                        String substring3 = str.substring(0, 4);
                        for (Object[] objArr8 : FOUR_DIGIT_DATA_LENGTH) {
                            if (objArr8[0].equals(substring3)) {
                                if (objArr8[1] == VARIABLE_LENGTH) {
                                    return processVariableAI(4, ((Integer) objArr8[2]).intValue(), str);
                                }
                                return processFixedAI(4, ((Integer) objArr8[1]).intValue(), str);
                            }
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (String) invokeL.objValue;
    }

    public static String processFixedAI(int i2, int i3, String str) throws NotFoundException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, str)) == null) {
            if (str.length() >= i2) {
                String substring = str.substring(0, i2);
                int i4 = i3 + i2;
                if (str.length() >= i4) {
                    String substring2 = str.substring(i2, i4);
                    String str2 = "(" + substring + ')' + substring2;
                    String parseFieldsInGeneralPurpose = parseFieldsInGeneralPurpose(str.substring(i4));
                    if (parseFieldsInGeneralPurpose == null) {
                        return str2;
                    }
                    return str2 + parseFieldsInGeneralPurpose;
                }
                throw NotFoundException.getNotFoundInstance();
            }
            throw NotFoundException.getNotFoundInstance();
        }
        return (String) invokeIIL.objValue;
    }

    public static String processVariableAI(int i2, int i3, String str) throws NotFoundException {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, str)) == null) {
            String substring = str.substring(0, i2);
            int i4 = i3 + i2;
            if (str.length() < i4) {
                i4 = str.length();
            }
            String substring2 = str.substring(i2, i4);
            String str2 = "(" + substring + ')' + substring2;
            String parseFieldsInGeneralPurpose = parseFieldsInGeneralPurpose(str.substring(i4));
            if (parseFieldsInGeneralPurpose == null) {
                return str2;
            }
            return str2 + parseFieldsInGeneralPurpose;
        }
        return (String) invokeIIL.objValue;
    }
}
