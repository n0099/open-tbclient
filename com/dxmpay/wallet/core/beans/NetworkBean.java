package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.ApollonBean;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.utils.Base64Utils;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.NetworkUtils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.paysdk.PayUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class NetworkBean<T> extends ApollonBean<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class BizType {
        public static final /* synthetic */ BizType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final BizType BackwardComp;
        public static final BizType BindCard;
        public static final BizType Pwd;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-888997952, "Lcom/dxmpay/wallet/core/beans/NetworkBean$BizType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-888997952, "Lcom/dxmpay/wallet/core/beans/NetworkBean$BizType;");
                    return;
                }
            }
            BackwardComp = new BizType("BackwardComp", 0);
            BindCard = new BizType("BindCard", 1);
            BizType bizType = new BizType("Pwd", 2);
            Pwd = bizType;
            $VALUES = new BizType[]{BackwardComp, BindCard, bizType};
        }

        public BizType(String str, int i2) {
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

        public static BizType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (BizType) Enum.valueOf(BizType.class, str) : (BizType) invokeL.objValue;
        }

        public static BizType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (BizType[]) $VALUES.clone() : (BizType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class SessionCache implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<Integer, BeanResponseBase.Session> mCache;

        /* loaded from: classes9.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static final SessionCache f69802a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(535069696, "Lcom/dxmpay/wallet/core/beans/NetworkBean$SessionCache$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(535069696, "Lcom/dxmpay/wallet/core/beans/NetworkBean$SessionCache$a;");
                        return;
                    }
                }
                f69802a = new SessionCache(null);
            }
        }

        public /* synthetic */ SessionCache(a aVar) {
            this();
        }

        public static SessionCache getInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f69802a : (SessionCache) invokeV.objValue;
        }

        public static synchronized void sync(SessionCache sessionCache) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, null, sessionCache) == null) {
                synchronized (SessionCache.class) {
                    if (sessionCache != null) {
                        a.f69802a.mCache = sessionCache.mCache;
                    }
                }
            }
        }

        public String getSessionId(BizType bizType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bizType)) == null) {
                if (bizType == null) {
                    bizType = BizType.BackwardComp;
                }
                BeanResponseBase.Session session = this.mCache.get(Integer.valueOf(bizType.ordinal()));
                if (session == null) {
                    return null;
                }
                return session.session_id;
            }
            return (String) invokeL.objValue;
        }

        public boolean matchSessionUri(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (str == null) {
                    return false;
                }
                BeanResponseBase.Session session = this.mCache.get(Integer.valueOf(BizType.BackwardComp.ordinal()));
                String[] strArr = session == null ? null : session.session_uri;
                if (strArr == null) {
                    return false;
                }
                for (String str2 : strArr) {
                    if (str.contains(str2)) {
                        return true;
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void put(BizType bizType, BeanResponseBase.Session session) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bizType, session) == null) {
                if (session == null) {
                    this.mCache.remove(Integer.valueOf(BizType.BackwardComp.ordinal()));
                } else if (BizType.BackwardComp.ordinal() == session.biz_code) {
                    if ("1".equals(session.delete_flag)) {
                        this.mCache.remove(Integer.valueOf(BizType.BackwardComp.ordinal()));
                    } else {
                        this.mCache.put(Integer.valueOf(BizType.BackwardComp.ordinal()), session);
                    }
                } else {
                    this.mCache.put(Integer.valueOf(bizType == null ? 0 : bizType.ordinal()), session);
                }
            }
        }

        public SessionCache() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCache = new HashMap<>();
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkBean(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private List<RestNameValuePair> a(Context context, List<RestNameValuePair> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, list)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            if (getAuthLevel() > 0 && !isLbsPayBean()) {
                b(context, list);
            }
            if (!a(list, "session_id") && SessionCache.getInstance().matchSessionUri(getUrl()) && !TextUtils.isEmpty(SessionCache.getInstance().getSessionId(null))) {
                list.add(new RestNameValuePair("session_id", SessionCache.getInstance().getSessionId(null)));
            }
            if (needNonce()) {
                list.add(new RestNameValuePair("nonce", PayUtils.getNonce(list)));
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }

    private void b(Context context, List<RestNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, context, list) == null) {
            list.add(new RestNameValuePair("from", "JT"));
            if ("gbk".equals(getEncode())) {
                list.add(new RestNameValuePair(com.baidu.wallet.core.beans.NetworkBean.PARAM_IE, "gbk"));
                list.add(new RestNameValuePair("ie", "gbk"));
            } else {
                list.add(new RestNameValuePair(com.baidu.wallet.core.beans.NetworkBean.PARAM_IE, "utf-8"));
                list.add(new RestNameValuePair("ie", "utf-8"));
            }
            list.add(new RestNameValuePair("ua", BussinessUtils.getUA(context)));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wime", "");
                jSONObject.put("cuid_1", PayUtils.encrypt("phone_number", PhoneUtils.getCUID(context)));
                jSONObject.put("cuid_2", PayUtils.encrypt("phone_number", PhoneUtils.getCUID2(context)));
                jSONObject.put("fk_wcp", PayUtils.encrypt("phone_number", (((("fp=" + BdWalletUtils.getDeviceFP(this.mContext)) + "&lastModify=" + BdWalletUtils.getFPFileLastModified(this.mContext)) + "&cpuInfo=" + PhoneUtils.getSystemCPUInfo().getCpuPath() + "_" + PhoneUtils.getNumCores()) + "&diskCapacity=" + PhoneUtils.getTotalInternalMemorySize()) + "&upTime=" + (SystemClock.elapsedRealtime() / 1000)));
                jSONObject.put("nettype", NetworkUtils.getNetworkType(context));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            list.add(new RestNameValuePair("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes()))));
            String str = SecurePay.getInstance().getpwProxy();
            boolean z = false;
            Iterator<RestNameValuePair> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if ("key".equals(it.next().getName())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                list.add(new RestNameValuePair("key", str));
            }
            if (isSign()) {
                list.add(new RestNameValuePair("sign", PayUtils.genAPIsig(list)));
            }
            String cookie = PayUtils.getCookie(context);
            String str2 = "appendCertification(" + context + "|" + cookie + SmallTailInfo.EMOTION_SUFFIX;
            if (!TextUtils.isEmpty(cookie)) {
                list.add(new RestNameValuePair(com.baidu.wallet.core.beans.NetworkBean.PARAM_COOKIE, SecurePay.getInstance().encryptProxy(cookie)));
            } else {
                list.add(new RestNameValuePair(com.baidu.wallet.core.beans.NetworkBean.PARAM_COOKIE, ""));
            }
            String newCookie = PayUtils.getNewCookie(context);
            if (!TextUtils.isEmpty(newCookie)) {
                list.add(new RestNameValuePair(com.baidu.wallet.core.beans.NetworkBean.PARAM_NEW_COOKIE, SecurePay.getInstance().encryptProxy(newCookie)));
            } else {
                list.add(new RestNameValuePair(com.baidu.wallet.core.beans.NetworkBean.PARAM_NEW_COOKIE, ""));
            }
        }
    }

    public abstract List<RestNameValuePair> generateRequestParam();

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public List<RestNameValuePair> getRequestParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? a(this.mContext, generateRequestParam()) : (List) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void handleCommonErrors(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            String str = "execBean. exception = " + exc;
            if (exc instanceof RestRuntimeException) {
                if (this.mRspCallback != null) {
                    RestRuntimeException restRuntimeException = (RestRuntimeException) exc;
                    if (restRuntimeException.contains(SocketTimeoutException.class)) {
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -15, ResUtils.getString(this.mContext, "dxm_ebpay_no_network"));
                    } else if (!restRuntimeException.contains(SSLPeerUnverifiedException.class) && !restRuntimeException.contains(CertificateException.class)) {
                        if (restRuntimeException.contains(IllegalArgumentException.class)) {
                            IBeanResponseCallback iBeanResponseCallback = this.mRspCallback;
                            if (iBeanResponseCallback != null) {
                                iBeanResponseCallback.onBeanExecFailure(getBeanId(), -2, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                                return;
                            }
                            return;
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -15, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                    } else {
                        if (exc.getMessage().contains("Pin verification failed")) {
                            String[] strArr = new String[2];
                            strArr[0] = getUrl();
                            strArr[1] = exc.getCause() == null ? exc.getMessage() : exc.getCause().toString();
                            StatisticManager.onEventWithValues("#ssl_pinning_error", Arrays.asList(strArr));
                        } else {
                            StatisticManager.onEvent("#ssl_certificate_error");
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -16, ResUtils.getString(this.mContext, "dxm_ebpay_ssl"));
                    }
                }
            } else if (exc instanceof IllegalArgumentException) {
                IBeanResponseCallback iBeanResponseCallback2 = this.mRspCallback;
                if (iBeanResponseCallback2 != null) {
                    iBeanResponseCallback2.onBeanExecFailure(getBeanId(), -2, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                }
            } else {
                exc.printStackTrace();
            }
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void handleNetworkFailureError() {
        IBeanResponseCallback iBeanResponseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (iBeanResponseCallback = this.mRspCallback) == null) {
            return;
        }
        iBeanResponseCallback.onBeanExecFailure(getBeanId(), -8, ResUtils.getString(this.mContext, "dxm_ebpay_no_network"));
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, restResponseEntity) == null) {
            String b2 = restResponseEntity.b("token");
            if (!TextUtils.isEmpty(b2)) {
                AccountManager.getInstance(this.mContext).setBfbToken(b2);
            }
            List<String> headerValue = restResponseEntity.getHeaderValue("Set-Cookie");
            if (headerValue != null) {
                for (int i2 = 0; i2 < headerValue.size(); i2++) {
                    String str = headerValue.get(i2);
                    try {
                        String[] split = str.substring(0, str.indexOf(";")).split("=");
                        if (split.length > 0 && "token".equals(split[0]) && !TextUtils.isEmpty(split[1]) && TextUtils.isEmpty(AccountManager.getInstance(this.mContext).getBfbToken())) {
                            AccountManager.getInstance(this.mContext).setBfbToken(split[1]);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean isLbsPayBean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public abstract boolean needNonce();

    public boolean needVerifySignature() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean a(List<RestNameValuePair> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, list, str)) == null) {
            if (list == null) {
                return false;
            }
            for (RestNameValuePair restNameValuePair : list) {
                if (str.equals(restNameValuePair.getName())) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
