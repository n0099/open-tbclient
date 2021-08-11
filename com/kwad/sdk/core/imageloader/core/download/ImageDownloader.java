package com.kwad.sdk.core.imageloader.core.download;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.HttpVersion;
/* loaded from: classes10.dex */
public interface ImageDownloader {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class Scheme {
        public static final /* synthetic */ Scheme[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Scheme ASSETS;
        public static final Scheme CONTENT;
        public static final Scheme DRAWABLE;
        public static final Scheme FILE;
        public static final Scheme HTTP;
        public static final Scheme HTTPS;
        public static final Scheme UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;
        public String scheme;
        public String uriPrefix;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1284813621, "Lcom/kwad/sdk/core/imageloader/core/download/ImageDownloader$Scheme;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1284813621, "Lcom/kwad/sdk/core/imageloader/core/download/ImageDownloader$Scheme;");
                    return;
                }
            }
            HTTP = new Scheme(HttpVersion.HTTP, 0, "http");
            HTTPS = new Scheme("HTTPS", 1, "https");
            FILE = new Scheme("FILE", 2, "file");
            CONTENT = new Scheme("CONTENT", 3, "content");
            ASSETS = new Scheme("ASSETS", 4, "assets");
            DRAWABLE = new Scheme("DRAWABLE", 5, "drawable");
            Scheme scheme = new Scheme(RomUtils.UNKNOWN, 6, "");
            UNKNOWN = scheme;
            $VALUES = new Scheme[]{HTTP, HTTPS, FILE, CONTENT, ASSETS, DRAWABLE, scheme};
        }

        public Scheme(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.scheme = str2;
            this.uriPrefix = str2 + "://";
        }

        private boolean belongsTo(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? str.toLowerCase(Locale.US).startsWith(this.uriPrefix) : invokeL.booleanValue;
        }

        public static Scheme ofUri(String str) {
            InterceptResult invokeL;
            Scheme[] values;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                if (str != null) {
                    for (Scheme scheme : values()) {
                        if (scheme.belongsTo(str)) {
                            return scheme;
                        }
                    }
                }
                return UNKNOWN;
            }
            return (Scheme) invokeL.objValue;
        }

        public static Scheme valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (Scheme) Enum.valueOf(Scheme.class, str) : (Scheme) invokeL.objValue;
        }

        public static Scheme[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (Scheme[]) $VALUES.clone() : (Scheme[]) invokeV.objValue;
        }

        public String crop(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (belongsTo(str)) {
                    return str.substring(this.uriPrefix.length());
                }
                throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", str, this.scheme));
            }
            return (String) invokeL.objValue;
        }

        public String wrap(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                return this.uriPrefix + str;
            }
            return (String) invokeL.objValue;
        }
    }

    InputStream getStream(String str, Object obj);
}
