package common.network;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class RegexValidator implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -8832409930574867162L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Pattern[] patterns;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RegexValidator(String str) {
        this(str, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public String[] match(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            while (true) {
                Pattern[] patternArr = this.patterns;
                if (i2 >= patternArr.length) {
                    return null;
                }
                Matcher matcher = patternArr[i2].matcher(str);
                if (matcher.matches()) {
                    int groupCount = matcher.groupCount();
                    String[] strArr = new String[groupCount];
                    while (i < groupCount) {
                        int i3 = i + 1;
                        strArr[i] = matcher.group(i3);
                        i = i3;
                    }
                    return strArr;
                }
                i2++;
            }
        } else {
            return (String[]) invokeL.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RegexValidator(String str, boolean z) {
        this(new String[]{str}, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String[]) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RegexValidator(String[] strArr) {
        this(strArr, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String[]) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public RegexValidator(String[] strArr, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {strArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (strArr != null && strArr.length != 0) {
            this.patterns = new Pattern[strArr.length];
            if (z) {
                i = 0;
            } else {
                i = 2;
            }
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (strArr[i4] != null && strArr[i4].length() != 0) {
                    this.patterns[i4] = Pattern.compile(strArr[i4], i);
                } else {
                    throw new IllegalArgumentException("Regular expression[" + i4 + "] is missing");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Regular expressions are missing");
    }

    public boolean isValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                return false;
            }
            int i = 0;
            while (true) {
                Pattern[] patternArr = this.patterns;
                if (i >= patternArr.length) {
                    return false;
                }
                if (patternArr[i].matcher(str).matches()) {
                    return true;
                }
                i++;
            }
        } else {
            return invokeL.booleanValue;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("RegexValidator{");
            for (int i = 0; i < this.patterns.length; i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(this.patterns[i].pattern());
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String validate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            while (true) {
                Pattern[] patternArr = this.patterns;
                if (i2 >= patternArr.length) {
                    return null;
                }
                Matcher matcher = patternArr[i2].matcher(str);
                if (matcher.matches()) {
                    int groupCount = matcher.groupCount();
                    if (groupCount == 1) {
                        return matcher.group(1);
                    }
                    StringBuilder sb = new StringBuilder();
                    while (i < groupCount) {
                        i++;
                        String group = matcher.group(i);
                        if (group != null) {
                            sb.append(group);
                        }
                    }
                    return sb.toString();
                }
                i2++;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }
}
