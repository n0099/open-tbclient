package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.http.HttpHeaders;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public final class CacheControl {
    public static /* synthetic */ Interceptable $ic;
    public static final CacheControl FORCE_CACHE;
    public static final CacheControl FORCE_NETWORK;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public String headerValue;
    public final boolean immutable;
    public final boolean isPrivate;
    public final boolean isPublic;
    public final int maxAgeSeconds;
    public final int maxStaleSeconds;
    public final int minFreshSeconds;
    public final boolean mustRevalidate;
    public final boolean noCache;
    public final boolean noStore;
    public final boolean noTransform;
    public final boolean onlyIfCached;
    public final int sMaxAgeSeconds;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean immutable;
        public int maxAgeSeconds;
        public int maxStaleSeconds;
        public int minFreshSeconds;
        public boolean noCache;
        public boolean noStore;
        public boolean noTransform;
        public boolean onlyIfCached;

        public Builder() {
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
            this.maxAgeSeconds = -1;
            this.maxStaleSeconds = -1;
            this.minFreshSeconds = -1;
        }

        public CacheControl build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new CacheControl(this) : (CacheControl) invokeV.objValue;
        }

        public Builder immutable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.immutable = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder maxAge(int i2, TimeUnit timeUnit) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, timeUnit)) == null) {
                if (i2 >= 0) {
                    long seconds = timeUnit.toSeconds(i2);
                    this.maxAgeSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                    return this;
                }
                throw new IllegalArgumentException("maxAge < 0: " + i2);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder maxStale(int i2, TimeUnit timeUnit) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, timeUnit)) == null) {
                if (i2 >= 0) {
                    long seconds = timeUnit.toSeconds(i2);
                    this.maxStaleSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                    return this;
                }
                throw new IllegalArgumentException("maxStale < 0: " + i2);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder minFresh(int i2, TimeUnit timeUnit) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i2, timeUnit)) == null) {
                if (i2 >= 0) {
                    long seconds = timeUnit.toSeconds(i2);
                    this.minFreshSeconds = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                    return this;
                }
                throw new IllegalArgumentException("minFresh < 0: " + i2);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder noCache() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                this.noCache = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder noStore() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                this.noStore = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder noTransform() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                this.noTransform = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }

        public Builder onlyIfCached() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                this.onlyIfCached = true;
                return this;
            }
            return (Builder) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-81436300, "Lokhttp3/CacheControl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-81436300, "Lokhttp3/CacheControl;");
                return;
            }
        }
        FORCE_NETWORK = new Builder().noCache().build();
        FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();
    }

    public CacheControl(boolean z, boolean z2, int i2, int i3, boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, boolean z7, boolean z8, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z6), Boolean.valueOf(z7), Boolean.valueOf(z8), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.noCache = z;
        this.noStore = z2;
        this.maxAgeSeconds = i2;
        this.sMaxAgeSeconds = i3;
        this.isPrivate = z3;
        this.isPublic = z4;
        this.mustRevalidate = z5;
        this.maxStaleSeconds = i4;
        this.minFreshSeconds = i5;
        this.onlyIfCached = z6;
        this.noTransform = z7;
        this.immutable = z8;
        this.headerValue = str;
    }

    private String headerValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.noCache) {
                sb.append("no-cache, ");
            }
            if (this.noStore) {
                sb.append("no-store, ");
            }
            if (this.maxAgeSeconds != -1) {
                sb.append("max-age=");
                sb.append(this.maxAgeSeconds);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.sMaxAgeSeconds != -1) {
                sb.append("s-maxage=");
                sb.append(this.sMaxAgeSeconds);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.isPrivate) {
                sb.append("private, ");
            }
            if (this.isPublic) {
                sb.append("public, ");
            }
            if (this.mustRevalidate) {
                sb.append("must-revalidate, ");
            }
            if (this.maxStaleSeconds != -1) {
                sb.append("max-stale=");
                sb.append(this.maxStaleSeconds);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.minFreshSeconds != -1) {
                sb.append("min-fresh=");
                sb.append(this.minFreshSeconds);
                sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            }
            if (this.onlyIfCached) {
                sb.append("only-if-cached, ");
            }
            if (this.noTransform) {
                sb.append("no-transform, ");
            }
            if (this.immutable) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CacheControl parse(Headers headers) {
        InterceptResult invokeL;
        int i2;
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, headers)) == null) {
            Headers headers2 = headers;
            int size = headers.size();
            int i4 = 0;
            boolean z = true;
            String str2 = null;
            boolean z2 = false;
            boolean z3 = false;
            int i5 = -1;
            int i6 = -1;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            int i7 = -1;
            int i8 = -1;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            while (i4 < size) {
                String name = headers2.name(i4);
                String value = headers2.value(i4);
                if (name.equalsIgnoreCase("Cache-Control")) {
                    if (str2 == null) {
                        str2 = value;
                        for (i2 = 0; i2 < value.length(); i2 = i3) {
                            int skipUntil = HttpHeaders.skipUntil(value, i2, "=,;");
                            String trim = value.substring(i2, skipUntil).trim();
                            if (skipUntil == value.length() || value.charAt(skipUntil) == ',' || value.charAt(skipUntil) == ';') {
                                i3 = skipUntil + 1;
                                str = null;
                            } else {
                                int skipWhitespace = HttpHeaders.skipWhitespace(value, skipUntil + 1);
                                if (skipWhitespace < value.length() && value.charAt(skipWhitespace) == '\"') {
                                    int i9 = skipWhitespace + 1;
                                    int skipUntil2 = HttpHeaders.skipUntil(value, i9, "\"");
                                    str = value.substring(i9, skipUntil2);
                                    i3 = skipUntil2 + 1;
                                } else {
                                    i3 = HttpHeaders.skipUntil(value, skipWhitespace, ",;");
                                    str = value.substring(skipWhitespace, i3).trim();
                                }
                            }
                            if ("no-cache".equalsIgnoreCase(trim)) {
                                z2 = true;
                            } else if ("no-store".equalsIgnoreCase(trim)) {
                                z3 = true;
                            } else if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(trim)) {
                                i5 = HttpHeaders.parseSeconds(str, -1);
                            } else if ("s-maxage".equalsIgnoreCase(trim)) {
                                i6 = HttpHeaders.parseSeconds(str, -1);
                            } else if (PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE.equalsIgnoreCase(trim)) {
                                z4 = true;
                            } else if ("public".equalsIgnoreCase(trim)) {
                                z5 = true;
                            } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                                z6 = true;
                            } else if ("max-stale".equalsIgnoreCase(trim)) {
                                i7 = HttpHeaders.parseSeconds(str, Integer.MAX_VALUE);
                            } else if ("min-fresh".equalsIgnoreCase(trim)) {
                                i8 = HttpHeaders.parseSeconds(str, -1);
                            } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                                z7 = true;
                            } else if ("no-transform".equalsIgnoreCase(trim)) {
                                z8 = true;
                            } else if ("immutable".equalsIgnoreCase(trim)) {
                                z9 = true;
                            }
                        }
                        i4++;
                        headers2 = headers;
                    }
                } else if (!name.equalsIgnoreCase("Pragma")) {
                    i4++;
                    headers2 = headers;
                }
                z = false;
                while (i2 < value.length()) {
                }
                i4++;
                headers2 = headers;
            }
            return new CacheControl(z2, z3, i5, i6, z4, z5, z6, i7, i8, z7, z8, z9, !z ? null : str2);
        }
        return (CacheControl) invokeL.objValue;
    }

    public boolean immutable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.immutable : invokeV.booleanValue;
    }

    public boolean isPrivate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isPrivate : invokeV.booleanValue;
    }

    public boolean isPublic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isPublic : invokeV.booleanValue;
    }

    public int maxAgeSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.maxAgeSeconds : invokeV.intValue;
    }

    public int maxStaleSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.maxStaleSeconds : invokeV.intValue;
    }

    public int minFreshSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.minFreshSeconds : invokeV.intValue;
    }

    public boolean mustRevalidate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mustRevalidate : invokeV.booleanValue;
    }

    public boolean noCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.noCache : invokeV.booleanValue;
    }

    public boolean noStore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.noStore : invokeV.booleanValue;
    }

    public boolean noTransform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.noTransform : invokeV.booleanValue;
    }

    public boolean onlyIfCached() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.onlyIfCached : invokeV.booleanValue;
    }

    public int sMaxAgeSeconds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.sMaxAgeSeconds : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String str = this.headerValue;
            if (str != null) {
                return str;
            }
            String headerValue = headerValue();
            this.headerValue = headerValue;
            return headerValue;
        }
        return (String) invokeV.objValue;
    }

    public CacheControl(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.noCache = builder.noCache;
        this.noStore = builder.noStore;
        this.maxAgeSeconds = builder.maxAgeSeconds;
        this.sMaxAgeSeconds = -1;
        this.isPrivate = false;
        this.isPublic = false;
        this.mustRevalidate = false;
        this.maxStaleSeconds = builder.maxStaleSeconds;
        this.minFreshSeconds = builder.minFreshSeconds;
        this.onlyIfCached = builder.onlyIfCached;
        this.noTransform = builder.noTransform;
        this.immutable = builder.immutable;
    }
}
