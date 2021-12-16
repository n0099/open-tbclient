package com.sina.weibo.sdk.web;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.auth.AuthInfo;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class BaseWebViewRequestData implements Parcelable, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<BaseWebViewRequestData> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public AuthInfo authInfo;
    public String callback;
    public int callbackType;
    public String specifyTitle;
    public WebRequestType type;
    public String url;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(615755495, "Lcom/sina/weibo/sdk/web/BaseWebViewRequestData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(615755495, "Lcom/sina/weibo/sdk/web/BaseWebViewRequestData;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<BaseWebViewRequestData>() { // from class: com.sina.weibo.sdk.web.BaseWebViewRequestData.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BaseWebViewRequestData createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) ? new BaseWebViewRequestData(parcel) : (BaseWebViewRequestData) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public BaseWebViewRequestData[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new BaseWebViewRequestData[i2] : (BaseWebViewRequestData[]) invokeI.objValue;
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseWebViewRequestData(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3) {
        this(authInfo, webRequestType, str, 0, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {authInfo, webRequestType, str, str2, str3};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((AuthInfo) objArr2[0], (WebRequestType) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), (String) objArr2[4], (String) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public AuthInfo getAuthInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.authInfo : (AuthInfo) invokeV.objValue;
    }

    public String getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.callback : (String) invokeV.objValue;
    }

    public int getCallbackType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.callbackType : invokeV.intValue;
    }

    public String getSpecifyTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.specifyTitle : (String) invokeV.objValue;
    }

    public WebRequestType getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.type : (WebRequestType) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public void setAuthInfo(AuthInfo authInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, authInfo) == null) {
            this.authInfo = authInfo;
        }
    }

    public void setCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.callback = str;
        }
    }

    public void setCallbackType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.callbackType = i2;
        }
    }

    public void setSpecifyTitle(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.specifyTitle = str;
        }
    }

    public void setType(WebRequestType webRequestType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, webRequestType) == null) {
            this.type = webRequestType;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.url = str;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i2) == null) {
            parcel.writeString(this.url);
            parcel.writeParcelable(this.authInfo, i2);
            WebRequestType webRequestType = this.type;
            parcel.writeInt(webRequestType == null ? -1 : webRequestType.ordinal());
            parcel.writeString(this.callback);
            parcel.writeString(this.specifyTitle);
            parcel.writeInt(this.callbackType);
        }
    }

    public BaseWebViewRequestData(AuthInfo authInfo, WebRequestType webRequestType, String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {authInfo, webRequestType, str, Integer.valueOf(i2), str2, str3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.callbackType = 0;
        this.callback = str;
        this.authInfo = authInfo;
        this.type = webRequestType;
        this.specifyTitle = str2;
        this.url = str3;
        this.callbackType = i2;
    }

    public BaseWebViewRequestData(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.callbackType = 0;
        this.url = parcel.readString();
        this.authInfo = (AuthInfo) parcel.readParcelable(AuthInfo.class.getClassLoader());
        int readInt = parcel.readInt();
        this.type = readInt == -1 ? null : WebRequestType.values()[readInt];
        this.callback = parcel.readString();
        this.specifyTitle = parcel.readString();
        this.callbackType = parcel.readInt();
    }
}
