package com.dxmpay.wallet.core.beans;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.BeanResponseBase;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.RestResponseEntity;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.VerSig;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.List;
import org.json.JSONException;
/* loaded from: classes3.dex */
public abstract class StringBean extends OtherBean<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<RestNameValuePair> mParam;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringBean(Context context) {
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

    @Override // com.dxmpay.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.execBean(String.class);
        }
    }

    @Override // com.dxmpay.wallet.core.beans.OtherBean, com.dxmpay.apollon.beans.ApollonBean
    public <T, E> void executeAndHandleResponse(Class<T> cls, Class<E> cls2) {
        RestResponseEntity<T> n;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2) == null) {
            if (getHttpMethod() == 0) {
                n = this.mRestTemplate.i(getUrl(), getRequestParams(), getEncode(), cls);
            } else {
                n = getHttpMethod() == 1 ? this.mRestTemplate.n(getUrl(), getRequestParams(), getEncode(), cls) : null;
            }
            this.mRetCode = -4;
            this.mRetMsg = ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error");
            if (n != null && this.mRspCallback != null) {
                handleResponseHeaders(n);
                String str = (String) n.getBody();
                if (str == null) {
                    addOnEventWithValues(-100, "Callback not null, response null");
                    this.mRspCallback.onBeanExecFailure(getBeanId(), this.mRetCode, this.mRetMsg);
                    return;
                }
                String str2 = "";
                try {
                    BeanResponseBase beanResponseBase = (BeanResponseBase) JsonUtils.fromJson(str, BeanResponseBase.class);
                    if (beanResponseBase != null) {
                        this.mRetCode = beanResponseBase.ret;
                        this.mRetMsg = beanResponseBase.msg;
                    }
                    if (beanResponseBase != null && beanResponseBase.ret == 0) {
                        str2 = beanResponseBase.getRealResponseContent();
                        if (beanResponseBase.needVerifySignature() || needVerifySignature()) {
                            if (!VerSig.verify(beanResponseBase.signature, str2, beanResponseBase.mdAlgorithm)) {
                                if (!TextUtils.isEmpty(getUrl())) {
                                    StatisticManager.onEvent("#verify_sign_failed");
                                }
                                this.mRetCode = -4;
                                this.mRetMsg = ResUtils.getString(this.mContext, "dxm_ebpay_resolve_error");
                            } else if (beanResponseBase.needDecryption() && !TextUtils.isEmpty(str2)) {
                                str2 = SecurePay.getInstance().decryptProxy(str2);
                            }
                        }
                    }
                } catch (JSONException e2) {
                    this.mRetCode = -4;
                    this.mRetMsg = e2.toString();
                }
                addOnEventWithValues(this.mRetCode, this.mRetMsg);
                if (this.mRetCode == 0) {
                    this.mRspCallback.onBeanExecSuccess(getBeanId(), null, str2);
                } else {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), this.mRetCode, this.mRetMsg);
                }
            } else if (this.mRspCallback != null) {
                addOnEventWithValues(-100, "Callback not null, response null");
                this.mRspCallback.onBeanExecFailure(getBeanId(), this.mRetCode, this.mRetMsg);
            } else {
                addOnEventWithValues(-101, "Callback null, response null");
            }
        }
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mParam : (List) invokeV.objValue;
    }

    @Override // com.dxmpay.wallet.core.beans.NetworkBean
    public boolean needNonce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
