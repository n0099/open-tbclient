package okhttp3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
/* loaded from: classes9.dex */
public final class Challenge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, String> authParams;
    public final String scheme;

    public Challenge(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (str != null) {
            if (str2 != null) {
                this.scheme = str;
                this.authParams = Collections.singletonMap("realm", str2);
                return;
            }
            throw new NullPointerException("realm == null");
        }
        throw new NullPointerException("scheme == null");
    }

    public Challenge(String str, Map<String, String> map) {
        String lowerCase;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (str != null) {
            if (map != null) {
                this.scheme = str;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getKey() == null) {
                        lowerCase = null;
                    } else {
                        lowerCase = entry.getKey().toLowerCase(Locale.US);
                    }
                    linkedHashMap.put(lowerCase, entry.getValue());
                }
                this.authParams = Collections.unmodifiableMap(linkedHashMap);
                return;
            }
            throw new NullPointerException("authParams == null");
        }
        throw new NullPointerException("scheme == null");
    }

    public Map<String, String> authParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.authParams;
        }
        return (Map) invokeV.objValue;
    }

    public Charset charset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.authParams.get("charset");
            if (str != null) {
                try {
                    return Charset.forName(str);
                } catch (Exception unused) {
                }
            }
            return Util.ISO_8859_1;
        }
        return (Charset) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
        }
        return invokeV.intValue;
    }

    public String realm() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.authParams.get("realm");
        }
        return (String) invokeV.objValue;
    }

    public String scheme() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.scheme;
        }
        return (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.scheme + " authParams=" + this.authParams;
        }
        return (String) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj instanceof Challenge) {
                Challenge challenge = (Challenge) obj;
                if (challenge.scheme.equals(this.scheme) && challenge.authParams.equals(this.authParams)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Challenge withCharset(Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charset)) == null) {
            if (charset != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(this.authParams);
                linkedHashMap.put("charset", charset.name());
                return new Challenge(this.scheme, linkedHashMap);
            }
            throw new NullPointerException("charset == null");
        }
        return (Challenge) invokeL.objValue;
    }
}
