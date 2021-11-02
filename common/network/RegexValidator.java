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
/* loaded from: classes2.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean isValid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, str)) != null) {
            return invokeL.booleanValue;
        }
        if (str == null) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i2 >= patternArr.length) {
                return false;
            }
            if (patternArr[i2].matcher(str).matches()) {
                return true;
            }
            i2++;
        }
    }

    public String[] match(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
            return (String[]) invokeL.objValue;
        }
        if (str == null) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i3 >= patternArr.length) {
                return null;
            }
            Matcher matcher = patternArr[i3].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                String[] strArr = new String[groupCount];
                while (i2 < groupCount) {
                    int i4 = i2 + 1;
                    strArr[i2] = matcher.group(i4);
                    i2 = i4;
                }
                return strArr;
            }
            i3++;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("RegexValidator{");
            for (int i2 = 0; i2 < this.patterns.length; i2++) {
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append(this.patterns[i2].pattern());
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public String validate(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        if (str == null) {
            return null;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            Pattern[] patternArr = this.patterns;
            if (i3 >= patternArr.length) {
                return null;
            }
            Matcher matcher = patternArr[i3].matcher(str);
            if (matcher.matches()) {
                int groupCount = matcher.groupCount();
                if (groupCount == 1) {
                    return matcher.group(1);
                }
                StringBuilder sb = new StringBuilder();
                while (i2 < groupCount) {
                    i2++;
                    String group = matcher.group(i2);
                    if (group != null) {
                        sb.append(group);
                    }
                }
                return sb.toString();
            }
            i3++;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String[]) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public RegexValidator(String[] strArr, boolean z) {
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
            int i4 = z ? 0 : 2;
            for (int i5 = 0; i5 < strArr.length; i5++) {
                if (strArr[i5] != null && strArr[i5].length() != 0) {
                    this.patterns[i5] = Pattern.compile(strArr[i5], i4);
                } else {
                    throw new IllegalArgumentException("Regular expression[" + i5 + "] is missing");
                }
            }
            return;
        }
        throw new IllegalArgumentException("Regular expressions are missing");
    }
}
