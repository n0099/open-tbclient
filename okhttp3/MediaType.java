package okhttp3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.text.Typography;
/* loaded from: classes10.dex */
public final class MediaType {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Pattern PARAMETER;
    public static final String QUOTED = "\"([^\"]*)\"";
    public static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    public static final Pattern TYPE_SUBTYPE;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final String charset;
    public final String mediaType;
    public final String subtype;
    public final String type;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-711967255, "Lokhttp3/MediaType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-711967255, "Lokhttp3/MediaType;");
                return;
            }
        }
        TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
        PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    }

    public MediaType(String str, String str2, String str3, @Nullable String str4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, str4};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public static MediaType get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Matcher matcher = TYPE_SUBTYPE.matcher(str);
            if (matcher.lookingAt()) {
                String lowerCase = matcher.group(1).toLowerCase(Locale.US);
                String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
                String str2 = null;
                Matcher matcher2 = PARAMETER.matcher(str);
                for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
                    matcher2.region(end, str.length());
                    if (matcher2.lookingAt()) {
                        String group = matcher2.group(1);
                        if (group != null && group.equalsIgnoreCase("charset")) {
                            String group2 = matcher2.group(2);
                            if (group2 != null) {
                                if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                                    group2 = group2.substring(1, group2.length() - 1);
                                }
                            } else {
                                group2 = matcher2.group(3);
                            }
                            if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                                throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group2 + "\" for: \"" + str + Typography.quote);
                            }
                            str2 = group2;
                        }
                    } else {
                        throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + Typography.quote);
                    }
                }
                return new MediaType(str, lowerCase, lowerCase2, str2);
            }
            throw new IllegalArgumentException("No subtype found for: \"" + str + Typography.quote);
        }
        return (MediaType) invokeL.objValue;
    }

    @Nullable
    public static MediaType parse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        return (MediaType) invokeL.objValue;
    }

    @Nullable
    public Charset charset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? charset(null) : (Charset) invokeV.objValue;
    }

    public boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? (obj instanceof MediaType) && ((MediaType) obj).mediaType.equals(this.mediaType) : invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mediaType.hashCode() : invokeV.intValue;
    }

    public String subtype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.subtype : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mediaType : (String) invokeV.objValue;
    }

    public String type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.type : (String) invokeV.objValue;
    }

    @Nullable
    public Charset charset(@Nullable Charset charset) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charset)) == null) {
            try {
                return this.charset != null ? Charset.forName(this.charset) : charset;
            } catch (IllegalArgumentException unused) {
                return charset;
            }
        }
        return (Charset) invokeL.objValue;
    }
}
