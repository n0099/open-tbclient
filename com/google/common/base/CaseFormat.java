package com.google.common.base;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.a;
import d.f.d.a.b;
import d.f.d.a.n;
import java.io.Serializable;
import org.aspectj.runtime.reflect.SignatureImpl;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public abstract class CaseFormat {
    public static final /* synthetic */ CaseFormat[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CaseFormat LOWER_CAMEL;
    public static final CaseFormat LOWER_HYPHEN;
    public static final CaseFormat LOWER_UNDERSCORE;
    public static final CaseFormat UPPER_CAMEL;
    public static final CaseFormat UPPER_UNDERSCORE;
    public transient /* synthetic */ FieldHolder $fh;
    public final b wordBoundary;
    public final String wordSeparator;

    /* loaded from: classes7.dex */
    public static final class StringConverter extends Converter<String, String> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final CaseFormat sourceFormat;
        public final CaseFormat targetFormat;

        public StringConverter(CaseFormat caseFormat, CaseFormat caseFormat2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {caseFormat, caseFormat2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(caseFormat);
            this.sourceFormat = caseFormat;
            n.p(caseFormat2);
            this.targetFormat = caseFormat2;
        }

        @Override // com.google.common.base.Converter, d.f.d.a.g
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj instanceof StringConverter) {
                    StringConverter stringConverter = (StringConverter) obj;
                    return this.sourceFormat.equals(stringConverter.sourceFormat) && this.targetFormat.equals(stringConverter.targetFormat);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.sourceFormat.hashCode() ^ this.targetFormat.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.sourceFormat + ".converterTo(" + this.targetFormat + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public String doBackward(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.targetFormat.to(this.sourceFormat, str) : (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public String doForward(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.sourceFormat.to(this.targetFormat, str) : (String) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1714433826, "Lcom/google/common/base/CaseFormat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1714433826, "Lcom/google/common/base/CaseFormat;");
                return;
            }
        }
        LOWER_HYPHEN = new CaseFormat("LOWER_HYPHEN", 0, b.e(SignatureImpl.SEP), "-") { // from class: com.google.common.base.CaseFormat.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r12, r13, r14, r15);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r12, Integer.valueOf(r13), r14, r15};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (b) objArr2[2], (String) objArr2[3]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, caseFormat, str)) == null) {
                    if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                        return str.replace(SignatureImpl.SEP, '_');
                    }
                    if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                        return a.e(str.replace(SignatureImpl.SEP, '_'));
                    }
                    return super.convert(caseFormat, str);
                }
                return (String) invokeLL.objValue;
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeWord(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? a.c(str) : (String) invokeL.objValue;
            }
        };
        LOWER_UNDERSCORE = new CaseFormat("LOWER_UNDERSCORE", 1, b.e('_'), "_") { // from class: com.google.common.base.CaseFormat.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r12, r13, r14, r15);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r12, Integer.valueOf(r13), r14, r15};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (b) objArr2[2], (String) objArr2[3]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, caseFormat, str)) == null) {
                    if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                        return str.replace('_', SignatureImpl.SEP);
                    }
                    if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                        return a.e(str);
                    }
                    return super.convert(caseFormat, str);
                }
                return (String) invokeLL.objValue;
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeWord(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? a.c(str) : (String) invokeL.objValue;
            }
        };
        LOWER_CAMEL = new CaseFormat("LOWER_CAMEL", 2, b.c('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r12, r13, r14, r15);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r12, Integer.valueOf(r13), r14, r15};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (b) objArr2[2], (String) objArr2[3]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeFirstWord(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? a.c(str) : (String) invokeL.objValue;
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeWord(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? CaseFormat.firstCharOnlyToUpper(str) : (String) invokeL.objValue;
            }
        };
        UPPER_CAMEL = new CaseFormat("UPPER_CAMEL", 3, b.c('A', 'Z'), "") { // from class: com.google.common.base.CaseFormat.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r12, r13, r14, r15);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r12, Integer.valueOf(r13), r14, r15};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (b) objArr2[2], (String) objArr2[3]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeWord(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? CaseFormat.firstCharOnlyToUpper(str) : (String) invokeL.objValue;
            }
        };
        CaseFormat caseFormat = new CaseFormat("UPPER_UNDERSCORE", 4, b.e('_'), "_") { // from class: com.google.common.base.CaseFormat.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r12, r13, r14, r15);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r12, Integer.valueOf(r13), r14, r15};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (b) objArr2[2], (String) objArr2[3]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // com.google.common.base.CaseFormat
            public String convert(CaseFormat caseFormat2, String str) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, caseFormat2, str)) == null) {
                    if (caseFormat2 == CaseFormat.LOWER_HYPHEN) {
                        return a.c(str.replace('_', SignatureImpl.SEP));
                    }
                    if (caseFormat2 == CaseFormat.LOWER_UNDERSCORE) {
                        return a.c(str);
                    }
                    return super.convert(caseFormat2, str);
                }
                return (String) invokeLL.objValue;
            }

            @Override // com.google.common.base.CaseFormat
            public String normalizeWord(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? a.e(str) : (String) invokeL.objValue;
            }
        };
        UPPER_UNDERSCORE = caseFormat;
        $VALUES = new CaseFormat[]{LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, caseFormat};
    }

    public static String firstCharOnlyToUpper(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            if (str.isEmpty()) {
                return str;
            }
            return a.d(str.charAt(0)) + a.c(str.substring(1));
        }
        return (String) invokeL.objValue;
    }

    public static CaseFormat valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) ? (CaseFormat) Enum.valueOf(CaseFormat.class, str) : (CaseFormat) invokeL.objValue;
    }

    public static CaseFormat[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? (CaseFormat[]) $VALUES.clone() : (CaseFormat[]) invokeV.objValue;
    }

    public String convert(CaseFormat caseFormat, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, caseFormat, str)) == null) {
            StringBuilder sb = null;
            int i2 = 0;
            int i3 = -1;
            while (true) {
                i3 = this.wordBoundary.d(str, i3 + 1);
                if (i3 == -1) {
                    break;
                }
                if (i2 == 0) {
                    sb = new StringBuilder(str.length() + (this.wordSeparator.length() * 4));
                    sb.append(caseFormat.normalizeFirstWord(str.substring(i2, i3)));
                } else {
                    sb.append(caseFormat.normalizeWord(str.substring(i2, i3)));
                }
                sb.append(caseFormat.wordSeparator);
                i2 = this.wordSeparator.length() + i3;
            }
            if (i2 == 0) {
                return caseFormat.normalizeFirstWord(str);
            }
            sb.append(caseFormat.normalizeWord(str.substring(i2)));
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, caseFormat)) == null) ? new StringConverter(this, caseFormat) : (Converter) invokeL.objValue;
    }

    public String normalizeFirstWord(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? normalizeWord(str) : (String) invokeL.objValue;
    }

    public abstract String normalizeWord(String str);

    public final String to(CaseFormat caseFormat, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, caseFormat, str)) == null) {
            n.p(caseFormat);
            n.p(str);
            return caseFormat == this ? str : convert(caseFormat, str);
        }
        return (String) invokeLL.objValue;
    }

    public CaseFormat(String str, int i2, b bVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), bVar, str2};
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
        this.wordBoundary = bVar;
        this.wordSeparator = str2;
    }
}
