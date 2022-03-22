package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@TargetApi(18)
/* loaded from: classes6.dex */
public final class HttpMediaDrmCallback implements MediaDrmCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpDataSource.Factory dataSourceFactory;
    public final String defaultLicenseUrl;
    public final boolean forceDefaultLicenseUrl;
    public final Map<String, String> keyRequestProperties;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpMediaDrmCallback(String str, HttpDataSource.Factory factory) {
        this(str, false, factory);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, factory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), (HttpDataSource.Factory) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static byte[] executePost(HttpDataSource.Factory factory, String str, byte[] bArr, Map<String, String> map) throws IOException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, factory, str, bArr, map)) == null) {
            HttpDataSource createDataSource = factory.createDataSource();
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    createDataSource.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(createDataSource, new DataSpec(Uri.parse(str), bArr, 0L, 0L, -1L, null, 1));
            try {
                return Util.toByteArray(dataSourceInputStream);
            } finally {
                Util.closeQuietly(dataSourceInputStream);
            }
        }
        return (byte[]) invokeLLLL.objValue;
    }

    public void clearAllKeyRequestProperties() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.keyRequestProperties) {
                this.keyRequestProperties.clear();
            }
        }
    }

    public void clearKeyRequestProperty(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            Assertions.checkNotNull(str);
            synchronized (this.keyRequestProperties) {
                this.keyRequestProperties.remove(str);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws Exception {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, uuid, keyRequest)) == null) {
            String defaultUrl = keyRequest.getDefaultUrl();
            if (this.forceDefaultLicenseUrl || TextUtils.isEmpty(defaultUrl)) {
                defaultUrl = this.defaultLicenseUrl;
            }
            HashMap hashMap = new HashMap();
            if (C.PLAYREADY_UUID.equals(uuid)) {
                str = "text/xml";
            } else {
                str = C.CLEARKEY_UUID.equals(uuid) ? "application/json" : "application/octet-stream";
            }
            hashMap.put("Content-Type", str);
            if (C.PLAYREADY_UUID.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (this.keyRequestProperties) {
                hashMap.putAll(this.keyRequestProperties);
            }
            return executePost(this.dataSourceFactory, defaultUrl, keyRequest.getData(), hashMap);
        }
        return (byte[]) invokeLL.objValue;
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, uuid, provisionRequest)) == null) {
            return executePost(this.dataSourceFactory, provisionRequest.getDefaultUrl() + "&signedRequest=" + new String(provisionRequest.getData()), new byte[0], null);
        }
        return (byte[]) invokeLL.objValue;
    }

    public void setKeyRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            Assertions.checkNotNull(str);
            Assertions.checkNotNull(str2);
            synchronized (this.keyRequestProperties) {
                this.keyRequestProperties.put(str, str2);
            }
        }
    }

    public HttpMediaDrmCallback(String str, boolean z, HttpDataSource.Factory factory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), factory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.dataSourceFactory = factory;
        this.defaultLicenseUrl = str;
        this.forceDefaultLicenseUrl = z;
        this.keyRequestProperties = new HashMap();
    }
}
