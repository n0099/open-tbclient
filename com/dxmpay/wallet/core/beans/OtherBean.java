package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import c.f.a.g.b.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.restnet.RestTemplate;
import com.dxmpay.apollon.utils.BussinessUtils;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.VerSig;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class OtherBean<T> extends NetworkBean<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public int mRetCode;
    public String mRetMsg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtherBean(Context context) {
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
        this.a = 0L;
        this.mRetCode = -1;
        this.mRetMsg = "";
    }

    public void addOnEventWithValues(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
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

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public <T, E> void execBean(Class<T> cls, Class<E> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2) == null) {
            this.a = System.currentTimeMillis();
            super.execBean(cls, cls2);
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2) == null) {
            if (getHttpMethod() == 0) {
                n = this.mRestTemplate.i(getUrl(), getRequestParams(), getEncode(), cls);
            } else {
                n = getHttpMethod() == 1 ? this.mRestTemplate.n(getUrl(), getRequestParams(), getEncode(), cls) : null;
            }
            if (n != null && this.mRspCallback != null) {
                handleResponseHeaders(n);
                Object body = n.getBody();
                if (body == null) {
                    addOnEventWithValues(-100, "Callback not null,Response is null");
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                    return;
                }
                if (body instanceof String) {
                    try {
                        BeanResponseBase beanResponseBase = (BeanResponseBase) JsonUtils.fromJson((String) body, BeanResponseBase.class);
                        if (beanResponseBase != null) {
                            this.mRetCode = beanResponseBase.ret;
                            this.mRetMsg = beanResponseBase.msg;
                        } else {
                            this.mRetCode = -4;
                            this.mRetMsg = "无效的response";
                        }
                        addOnEventWithValues(this.mRetCode, this.mRetMsg);
                        if (beanResponseBase != null && beanResponseBase.ret == 0 && (beanResponseBase.needVerifySignature() || needVerifySignature())) {
                            String string = new JSONObject(n.a()).getString(beanResponseBase.getNameOfRealResponseContent());
                            if (!VerSig.verify(beanResponseBase.signature, string, beanResponseBase.mdAlgorithm)) {
                                if (!TextUtils.isEmpty(getUrl())) {
                                    StatisticManager.onEvent("#verify_sign_failed");
                                }
                                this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
                                return;
                            } else if (beanResponseBase.needDecryption()) {
                                org.json.JSONObject jSONObject = new org.json.JSONObject((String) body);
                                if (!TextUtils.isEmpty(string)) {
                                    jSONObject.put(beanResponseBase.getNameOfRealResponseContent(), SecurePay.getInstance().decryptProxy(string));
                                }
                                body = jSONObject.toString();
                            }
                        }
                    } catch (JSONException e2) {
                        LogUtil.e("OtherBaseBean", e2.getMessage(), e2);
                    } catch (org.json.JSONException e3) {
                        LogUtil.e("OtherBaseBean", e3.getMessage(), e3);
                    }
                }
                this.mRspCallback.onBeanExecSuccess(getBeanId(), body, null);
            } else if (this.mRspCallback != null) {
                if (n == null) {
                    addOnEventWithValues(-100, "Callback not null,Response is null");
                }
                this.mRspCallback.onBeanExecFailure(getBeanId(), -4, ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error"));
            } else if (n == null) {
                addOnEventWithValues(-101, "Callback is null,Response is null");
            } else {
                addOnEventWithValues(-102, "Callback is null,Response not null");
            }
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean, com.dxmpay.apollon.beans.ApollonBean
    public void handleCommonErrors(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
            if (exc != null) {
                addOnEventWithValues(-2, exc.toString());
            } else {
                addOnEventWithValues(-2, "Exception is null");
            }
            super.handleCommonErrors(exc);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean, com.dxmpay.apollon.beans.ApollonBean
    public void handleNetworkFailureError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            addOnEventWithValues(-8, ResUtils.getString(this.mContext, "dxm_ebpay_no_network"));
            super.handleNetworkFailureError();
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public <T, E> void handleResponse(Class<T> cls, Class<E> cls2, RestResponseEntity<? extends BeanResponseBase> restResponseEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, cls, cls2, restResponseEntity) == null) {
            if (restResponseEntity != null && restResponseEntity.getBody() != null) {
                addOnEventWithValues(restResponseEntity.getBody().ret, restResponseEntity.getBody().msg);
            } else {
                addOnEventWithValues(-104, "Response is error");
            }
        }
    }

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            Context context = this.mContext;
            this.mRestTemplate = new RestTemplate(context, BussinessUtils.getUA(context), "pay bean http request");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EbpayHttpRequestInterceptor());
            this.mRestTemplate.setRequestInterceptor(arrayList);
            this.mRestTemplate.setMessageConverter(new b());
        }
    }
}
