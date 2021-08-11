package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.restnet.converter.GsonHttpMessageConverter;
import com.dxmpay.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.VerSig;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
/* loaded from: classes9.dex */
public abstract class BaseBean<T> extends NetworkBean<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COMET_BEAN = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69403a;

    /* renamed from: b  reason: collision with root package name */
    public int f69404b;

    /* renamed from: c  reason: collision with root package name */
    public String f69405c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBean(Context context) {
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
        this.f69403a = 0L;
        this.f69404b = -1;
    }

    private <T> T a(String str, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, cls)) == null) {
            try {
                return (T) JsonUtils.fromJson(str, cls);
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, cls, cls2) == null) {
            this.f69403a = System.currentTimeMillis();
            super.execBean(cls, cls2);
        }
    }

    public String getHttpRealContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f69405c : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean, com.dxmpay.apollon.beans.ApollonBean
    public void handleCommonErrors(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            if (exc != null) {
                a(-2, exc.toString());
            } else {
                a(-2, "Exception is null");
            }
            super.handleCommonErrors(exc);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean, com.dxmpay.apollon.beans.ApollonBean
    public void handleNetworkFailureError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            a(-8, ResUtils.getString(this.mContext, "dxm_ebpay_no_network"));
            super.handleNetworkFailureError();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Class<E> */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.dxmpay.apollon.restnet.RestResponseEntity<? extends com.dxmpay.apollon.beans.BeanResponseBase> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.dxmpay.apollon.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, cls, cls2, restResponseEntity) == null) {
            if (restResponseEntity != 0 && this.mRspCallback != null) {
                handleResponseHeaders(restResponseEntity);
                BeanResponseBase beanResponseBase = (BeanResponseBase) restResponseEntity.getBody();
                if (beanResponseBase != null) {
                    a(beanResponseBase.ret, beanResponseBase.msg);
                    handleSession(beanResponseBase.cashdesk);
                    int serverReturnValue = beanResponseBase.getServerReturnValue(cls);
                    if (serverReturnValue != 0) {
                        if (serverReturnValue == 5003) {
                            String url = getUrl();
                            if (!TextUtils.isEmpty(url)) {
                                StatisticManager.onEventWithValue("#invalidLoginStatus", url);
                            }
                        }
                        String realResponseErrContent = beanResponseBase.getRealResponseErrContent();
                        this.f69405c = realResponseErrContent;
                        if (!TextUtils.isEmpty(realResponseErrContent) && cls2 != 0) {
                            EventBus eventBus = EventBus.getInstance();
                            eventBus.getClass();
                            eventBus.postStickyEvent(new EventBus.Event(eventBus, "ev_bean_execut_err_content", new BeanErrorContent(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg(), a(beanResponseBase.getRealResponseErrContent(), cls2))));
                            return;
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), serverReturnValue, beanResponseBase.getRealResponseMsg());
                        return;
                    }
                    String token = beanResponseBase.getToken();
                    if (!TextUtils.isEmpty(token)) {
                        AccountManager.getInstance(this.mContext).setBfbToken(token);
                    }
                    String str2 = "execBean. ret       . rsp class = " + cls;
                    this.f69405c = beanResponseBase.getRealResponseContent();
                    try {
                        str = new JSONObject(restResponseEntity.a()).getString(beanResponseBase.getNameOfRealResponseContent());
                        if ((needVerifySignature() || beanResponseBase.needVerifySignature()) && !VerSig.verify(beanResponseBase.signature, str, beanResponseBase.mdAlgorithm)) {
                            String url2 = getUrl();
                            if (!TextUtils.isEmpty(url2)) {
                                StatisticManager.onEvent("#verify_sign_failed", url2);
                            }
                            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                            return;
                        }
                    } catch (com.dxmpay.wallet.core.lollipop.json.JSONException e2) {
                        LogUtil.e("BeasBean", e2.getMessage(), e2);
                        str = "";
                    }
                    if (beanResponseBase.needDecryption() && !TextUtils.isEmpty(str)) {
                        this.f69405c = SecurePay.getInstance().decryptProxy(str);
                    }
                    if (cls != null) {
                        if (JsonUtils.DataType.isString(cls)) {
                            this.mRspCallback.onBeanExecSuccess(getBeanId(), null, this.f69405c);
                            return;
                        }
                        T a2 = a(this.f69405c, cls);
                        String str3 = "execBean. ret ok. real response = " + a2;
                        if (a2 != null) {
                            IBeanResponse iBeanResponse = (IBeanResponse) a2;
                            if (iBeanResponse.checkResponseValidity()) {
                                iBeanResponse.storeResponse(this.mContext);
                                this.mRspCallback.onBeanExecSuccess(getBeanId(), a2, beanResponseBase.getRealResponseMsg());
                                return;
                            }
                            this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                            return;
                        }
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                        return;
                    }
                    this.mRspCallback.onBeanExecSuccess(getBeanId(), null, beanResponseBase.getRealResponseMsg());
                    return;
                }
                a(-103, "Callback not null,rsp.getBody() is null");
                this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
            } else if (this.mRspCallback != null) {
                if (restResponseEntity == 0) {
                    a(-100, "Callback not null,Response is null");
                }
                this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
            } else if (restResponseEntity == 0) {
                a(-101, "Callback is null,Response is null");
            } else {
                a(-102, "Callback is null,Response not null");
            }
        }
    }

    public void handleSession(BeanResponseBase.Session session) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, session) == null) {
            BdWalletUtils.dealCashDesk(session);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        RestHttpRequestInterceptor ebpayHttpRequestInterceptor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.mContext;
            this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
            ArrayList arrayList = new ArrayList();
            if (this.f69404b == 1) {
                ebpayHttpRequestInterceptor = new CometHttpRequestInterceptor();
            } else {
                ebpayHttpRequestInterceptor = new EbpayHttpRequestInterceptor();
            }
            arrayList.add(ebpayHttpRequestInterceptor);
            this.mRestTemplate.setRequestInterceptor(arrayList);
            this.mRestTemplate.setMessageConverter(new GsonHttpMessageConverter());
        }
    }

    public void setBeanParams(String... strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, strArr) == null) {
        }
    }

    private void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65539, this, i2, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f69403a;
            try {
                URL url = new URL(getUrl());
                ArrayList arrayList = new ArrayList();
                arrayList.add(url.getPath());
                arrayList.add(i2 + "");
                HashMap hashMap = new HashMap();
                hashMap.put("duration", Long.valueOf(currentTimeMillis));
                hashMap.put("errmsg", str);
                if (!TextUtils.isEmpty(StatHelper.getOrderNo())) {
                    hashMap.put("order_no", StatHelper.getOrderNo());
                }
                if (!TextUtils.isEmpty(StatHelper.getSpNo())) {
                    hashMap.put("sp_no", StatHelper.getSpNo());
                }
                StatisticManager.onEventWithValues(PayStatServiceEvent.CALL_INTERFACE, arrayList, hashMap);
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBean(Context context, int i2) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69403a = 0L;
        this.f69404b = -1;
        this.f69404b = i2;
    }
}
