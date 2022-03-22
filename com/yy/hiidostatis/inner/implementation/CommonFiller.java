package com.yy.hiidostatis.inner.implementation;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.hiidostatis.inner.util.ArdUtil;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.InsideMode;
import com.yy.hiidostatis.inner.util.StringUtil;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import com.yy.hiidostatis.inner.util.hdid.ClientIdProxy;
import com.yy.hiidostatis.inner.util.hdid.DeviceProxy;
import com.yy.hiidostatis.inner.util.hdid.UuidManager;
import java.util.Locale;
/* loaded from: classes7.dex */
public class CommonFiller {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANDROID_OS = 2;
    public static final String KEY_MAGIC = "HiidoYYSystem";
    public static String mArid = null;
    public static final String mAridKey = "PREF_ARID";
    public static final Object mAridSyncKey;
    public static String mImei = null;
    public static final String mImeiKey = "PREF_IMEI";
    public static final Object mImeiSyncKey;
    public static String mMacAddress = null;
    public static final String mMacAddressKey = "PREF_MAC_ADDRESS";
    public static final Object mMacAddressSyncKey;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-687608017, "Lcom/yy/hiidostatis/inner/implementation/CommonFiller;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-687608017, "Lcom/yy/hiidostatis/inner/implementation/CommonFiller;");
                return;
            }
        }
        mMacAddressSyncKey = new Object();
        mImeiSyncKey = new Object();
        mAridSyncKey = new Object();
    }

    public CommonFiller() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String calKey(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str2);
            sb.append("HiidoYYSystem");
            String sb2 = sb.toString();
            sb.setLength(0);
            try {
                return Coder.encryptMD5(sb2).toLowerCase(Locale.getDefault());
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static BaseStatisContent fillCommonAll(Context context, BaseStatisContent baseStatisContent, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, baseStatisContent, str, str2)) == null) {
            fillCommonNew(context, baseStatisContent, str, str2);
            fillConcreteInfoNew(context, baseStatisContent);
            return baseStatisContent;
        }
        return (BaseStatisContent) invokeLLLL.objValue;
    }

    public static BaseStatisContent fillCommonNew(Context context, BaseStatisContent baseStatisContent, String str, String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, baseStatisContent, str, str2)) == null) {
            fillKey(baseStatisContent, str);
            baseStatisContent.put("imei", getIMEI(context));
            baseStatisContent.put("mac", getMacAddr(context));
            baseStatisContent.put("net", ArdUtil.getNetworkTypeNew(context));
            baseStatisContent.put("act", str);
            baseStatisContent.put(BaseStatisContent.SDKVER, str2);
            baseStatisContent.put("sys", 2);
            baseStatisContent.put(BaseStatisContent.ARID, getAndroidId(context));
            baseStatisContent.put("hdid", DeviceProxy.getHdid(context));
            baseStatisContent.put(BaseStatisContent.OPID, ClientIdProxy.getClientId(context));
            baseStatisContent.put(BaseStatisContent.IMC, String.format("%s,%s", ArdUtil.getImei(context), getMacAddr(context)));
            baseStatisContent.put(BaseStatisContent.IMSI, ArdUtil.getImsi(context));
            baseStatisContent.put(BaseStatisContent.IDFV, UuidManager.fetchUUid(context));
            return baseStatisContent;
        }
        return (BaseStatisContent) invokeLLLL.objValue;
    }

    public static void fillConcreteInfoNew(Context context, BaseStatisContent baseStatisContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, baseStatisContent) == null) {
            baseStatisContent.put(BaseStatisContent.SJP, ArdUtil.getSjp(context));
            baseStatisContent.put("sjm", ArdUtil.getSjm(context));
            baseStatisContent.put("mbos", ArdUtil.getOS());
            baseStatisContent.put(BaseStatisContent.MBL, ArdUtil.getLang());
            baseStatisContent.put(BaseStatisContent.SR, ArdUtil.getScreenResolution(context));
            baseStatisContent.put(BaseStatisContent.NTM, ArdUtil.getNtm(context));
        }
    }

    public static BaseStatisContent fillKey(BaseStatisContent baseStatisContent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, baseStatisContent, str)) == null) {
            String valueOf = String.valueOf(Util.wallTimeSec());
            baseStatisContent.put("act", str);
            baseStatisContent.put("time", valueOf);
            baseStatisContent.put("key", calKey(str, valueOf));
            baseStatisContent.put(BaseStatisContent.GUID, StringUtil.geneGuid());
            return baseStatisContent;
        }
        return (BaseStatisContent) invokeLL.objValue;
    }

    public static String getAndroidId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (!Util.empty(mArid)) {
                return mArid;
            }
            String prefString = DefaultPreference.getPreference().getPrefString(context, mAridKey, null);
            mArid = prefString;
            if (!Util.empty(prefString)) {
                return mArid;
            }
            synchronized (mAridSyncKey) {
                if (!Util.empty(mArid)) {
                    return mArid;
                }
                String androidId = ArdUtil.getAndroidId(context);
                mArid = androidId;
                if (!Util.empty(androidId)) {
                    DefaultPreference.getPreference().setPrefString(context, mAridKey, mArid);
                }
                return mArid;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getIMEI(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (!Util.empty(mImei)) {
                return mImei;
            }
            String prefString = DefaultPreference.getPreference().getPrefString(context, mImeiKey, null);
            mImei = prefString;
            if (!Util.empty(prefString)) {
                return mImei;
            }
            synchronized (mImeiSyncKey) {
                if (!Util.empty(mImei)) {
                    return mImei;
                }
                String imei = ArdUtil.getImei(context);
                mImei = imei;
                if (!Util.empty(imei)) {
                    DefaultPreference.getPreference().setPrefString(context, mImeiKey, mImei);
                }
                return mImei;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String getMacAddr(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (!TextUtils.isEmpty(mMacAddress)) {
                return mMacAddress;
            }
            mMacAddress = DefaultPreference.getPreference().getPrefString(context, mMacAddressKey, null);
            if ((InsideMode.isSafeMac() && !TextUtils.isEmpty(mMacAddress)) || ArdUtil.isValidMac(mMacAddress)) {
                return mMacAddress;
            }
            synchronized (mMacAddressSyncKey) {
                if ((InsideMode.isSafeMac() && !TextUtils.isEmpty(mMacAddress)) || ArdUtil.isValidMac(mMacAddress)) {
                    return mMacAddress;
                }
                String safeMacAddr = ArdUtil.getSafeMacAddr(context);
                mMacAddress = safeMacAddr;
                if (ArdUtil.isValidMac(safeMacAddr)) {
                    DefaultPreference.getPreference().setPrefString(context, mMacAddressKey, mMacAddress);
                    return mMacAddress;
                }
                String str = mMacAddress;
                return str == null ? "" : str;
            }
        }
        return (String) invokeL.objValue;
    }
}
