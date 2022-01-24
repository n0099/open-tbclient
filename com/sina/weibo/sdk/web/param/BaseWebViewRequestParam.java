package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.web.BaseWebViewRequestData;
import com.sina.weibo.sdk.web.WebRequestType;
/* loaded from: classes4.dex */
public abstract class BaseWebViewRequestParam {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseWebViewRequestData baseData;
    public Context context;
    public String transaction;

    /* renamed from: com.sina.weibo.sdk.web.param.BaseWebViewRequestParam$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$sina$weibo$sdk$web$WebRequestType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-414801587, "Lcom/sina/weibo/sdk/web/param/BaseWebViewRequestParam$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-414801587, "Lcom/sina/weibo/sdk/web/param/BaseWebViewRequestParam$1;");
                    return;
                }
            }
            int[] iArr = new int[WebRequestType.values().length];
            $SwitchMap$com$sina$weibo$sdk$web$WebRequestType = iArr;
            try {
                iArr[WebRequestType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$sina$weibo$sdk$web$WebRequestType[WebRequestType.SHARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$sina$weibo$sdk$web$WebRequestType[WebRequestType.AUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface ExtraTaskCallback {
        void onComplete(String str);

        void onException(String str);
    }

    public BaseWebViewRequestParam() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract void childFillBundle(Bundle bundle);

    public void doExtraTask(ExtraTaskCallback extraTaskCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, extraTaskCallback) == null) {
        }
    }

    public Bundle fillBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            BaseWebViewRequestData baseWebViewRequestData = this.baseData;
            if (baseWebViewRequestData != null) {
                bundle.putSerializable(SchemeCollecter.CLASSIFY_BASE, baseWebViewRequestData);
                int i2 = AnonymousClass1.$SwitchMap$com$sina$weibo$sdk$web$WebRequestType[this.baseData.getType().ordinal()];
                if (i2 == 1) {
                    bundle.putInt("type", 0);
                } else if (i2 == 2) {
                    bundle.putInt("type", 1);
                } else if (i2 == 3) {
                    bundle.putInt("type", 2);
                }
                bundle.putString(WBConstants.TRAN, this.transaction);
                childFillBundle(bundle);
                return bundle;
            }
            throw new NullPointerException("构造方法错误，请使用全参数的构造方法构建");
        }
        return (Bundle) invokeL.objValue;
    }

    public BaseWebViewRequestData getBaseData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.baseData : (BaseWebViewRequestData) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.context : (Context) invokeV.objValue;
    }

    public abstract String getRequestUrl();

    public boolean hasExtraTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            this.context = context;
        }
    }

    public void transformBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            this.baseData = (BaseWebViewRequestData) bundle.getSerializable(SchemeCollecter.CLASSIFY_BASE);
            this.transaction = bundle.getString(WBConstants.TRAN);
            transformChildBundle(bundle);
        }
    }

    public abstract void transformChildBundle(Bundle bundle);

    public abstract void updateRequestUrl(String str);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        this(authInfo, webRequestType, str, 0, str2, str3, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {authInfo, webRequestType, str, str2, str3, context};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AuthInfo) objArr2[0], (WebRequestType) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), (String) objArr2[4], (String) objArr2[5], (Context) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, int i2, String str2, String str3, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {authInfo, webRequestType, str, Integer.valueOf(i2), str2, str3, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.baseData = new BaseWebViewRequestData(authInfo, webRequestType, str, i2, str2, str3);
        this.context = context;
        this.transaction = String.valueOf(System.currentTimeMillis());
    }
}
