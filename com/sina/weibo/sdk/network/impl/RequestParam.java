package com.sina.weibo.sdk.network.impl;

import android.content.Context;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.network.IRequestIntercept;
import com.sina.weibo.sdk.network.IRequestParam;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class RequestParam implements IRequestParam {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_PARAM_BODY_BYTE_ARRAY = "body_byte_array";
    public transient /* synthetic */ FieldHolder $fh;
    public Context appContext;
    public Map<String, byte[]> byteArrays;
    public boolean defaultHost;
    public Bundle extraBundle;
    public Map<String, IRequestParam.ValuePart<File>> files;
    public boolean gZip;
    public Bundle getBundle;
    public Bundle headerBundle;
    public ArrayList<IRequestIntercept> interceptList;
    public HashMap<String, Object> interceptResult;
    public boolean needIntercept;
    public Bundle postBundle;
    public int requestTimeout;
    public IRequestParam.RequestType requestType;
    public int responseTimeout;
    public String shortUrl;

    /* loaded from: classes6.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context appContext;
        public Map<String, byte[]> byteArrays;
        public boolean defaultHost;
        public Bundle extraBundle;
        public Map<String, IRequestParam.ValuePart<File>> files;
        public boolean gZip;
        public Bundle getBundle;
        public Bundle headerBundle;
        public ArrayList<IRequestIntercept> interceptList;
        public boolean needIntercept;
        public Bundle postBundle;
        public int requestTimeout;
        public int responseTimeout;
        public String shortUrl;
        public IRequestParam.RequestType type;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.getBundle = new Bundle();
            this.postBundle = new Bundle();
            this.extraBundle = new Bundle();
            this.type = IRequestParam.RequestType.POST;
            this.headerBundle = new Bundle();
            this.defaultHost = true;
            this.interceptList = new ArrayList<>();
            this.files = new HashMap();
            this.byteArrays = new HashMap();
            this.needIntercept = true;
            this.gZip = false;
            this.requestTimeout = 15000;
            this.responseTimeout = 15000;
            this.appContext = context;
        }

        public void addBodyParam(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr) == null) {
                this.postBundle.putByteArray(RequestParam.KEY_PARAM_BODY_BYTE_ARRAY, bArr);
            }
        }

        public void addExtParam(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, str, str2) == null) {
                this.extraBundle.putString(str, str2);
            }
        }

        public void addGetParam(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
                this.getBundle.putString(str, str2);
            }
        }

        public void addHeader(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
                this.headerBundle.putString(str, str2);
            }
        }

        public void addIntercept(IRequestIntercept iRequestIntercept) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, iRequestIntercept) == null) {
                this.interceptList.add(iRequestIntercept);
            }
        }

        public void addPostParam(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
                this.postBundle.putString(str, str2);
            }
        }

        public RequestParam build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new RequestParam(this) : (RequestParam) invokeV.objValue;
        }

        public void defaultHostEnable(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
                this.defaultHost = z;
            }
        }

        public void setNeedIntercept(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
                this.needIntercept = z;
            }
        }

        public void setRequestTimeout(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
                this.requestTimeout = i2;
            }
        }

        public void setRequestType(IRequestParam.RequestType requestType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, requestType) == null) {
                this.type = requestType;
            }
        }

        public void setResponseTimeout(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
                this.responseTimeout = i2;
            }
        }

        public void setShortUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
                this.shortUrl = str;
            }
        }

        public void setgZip(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
                this.gZip = z;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.io.File */
        /* JADX WARN: Multi-variable type inference failed */
        public Builder addBodyParam(String str, File file, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, file, str2)) == null) {
                IRequestParam.ValuePart<File> valuePart = new IRequestParam.ValuePart<>();
                valuePart.value = file;
                valuePart.mimeType = str2;
                this.files.put(str, valuePart);
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public void addExtParam(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, str, i2) == null) {
                this.extraBundle.putInt(str, i2);
            }
        }

        public void addGetParam(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2) == null) {
                this.getBundle.putInt(str, i2);
            }
        }

        public void addPostParam(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048590, this, str, i2) == null) {
                this.postBundle.putInt(str, i2);
            }
        }

        public void addExtParam(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048581, this, str, j) == null) {
                this.extraBundle.putLong(str, j);
            }
        }

        public void addGetParam(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048585, this, str, j) == null) {
                this.getBundle.putLong(str, j);
            }
        }

        public void addPostParam(String str, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048591, this, str, j) == null) {
                this.postBundle.putLong(str, j);
            }
        }

        public void addExtParam(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
                this.extraBundle.putAll(bundle);
            }
        }

        public void addGetParam(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
                this.getBundle.putAll(bundle);
            }
        }

        public void addPostParam(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
                this.postBundle.putAll(bundle);
            }
        }

        public Builder addBodyParam(String str, byte[] bArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr)) == null) {
                this.byteArrays.put(str, bArr);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }
    }

    public RequestParam(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.getBundle = new Bundle();
        this.postBundle = new Bundle();
        this.headerBundle = new Bundle();
        this.extraBundle = new Bundle();
        this.files = new HashMap();
        this.byteArrays = new HashMap();
        this.interceptList = new ArrayList<>();
        this.gZip = false;
        this.requestTimeout = 15000;
        this.responseTimeout = 15000;
        this.needIntercept = true;
        this.shortUrl = builder.shortUrl;
        this.getBundle.putAll(builder.getBundle);
        this.postBundle.putAll(builder.postBundle);
        this.requestType = builder.type;
        this.headerBundle.putAll(builder.headerBundle);
        this.extraBundle.putAll(builder.extraBundle);
        this.defaultHost = builder.defaultHost;
        this.files.putAll(builder.files);
        this.byteArrays.putAll(builder.byteArrays);
        this.needIntercept = builder.needIntercept;
        this.appContext = builder.appContext;
        this.interceptResult = new HashMap<>();
        this.interceptList = builder.interceptList;
        this.gZip = builder.gZip;
        this.requestTimeout = builder.requestTimeout;
        this.responseTimeout = builder.responseTimeout;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public void addInterceptResult(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, obj) == null) {
            this.interceptResult.put(str, obj);
        }
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public Map<String, byte[]> byteArrays() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.byteArrays : (Map) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public Map<String, IRequestParam.ValuePart<File>> files() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.files : (Map) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.appContext : (Context) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public Bundle getExtraBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.extraBundle : (Bundle) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public Bundle getGetBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.getBundle : (Bundle) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public Bundle getHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.headerBundle : (Bundle) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public ArrayList<IRequestIntercept> getIntercept() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.interceptList : (ArrayList) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public Object getInterceptResult(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? this.interceptResult.get(str) : invokeL.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public IRequestParam.RequestType getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.requestType : (IRequestParam.RequestType) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public Bundle getPostBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.postBundle : (Bundle) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public int getRequestTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.requestTimeout : invokeV.intValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public int getResponseTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.responseTimeout : invokeV.intValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.shortUrl : (String) invokeV.objValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public boolean needGzip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public boolean needIntercept() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.needIntercept : invokeV.booleanValue;
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.shortUrl = str;
        }
    }

    @Override // com.sina.weibo.sdk.network.IRequestParam
    public boolean useDefaultHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.defaultHost : invokeV.booleanValue;
    }
}
