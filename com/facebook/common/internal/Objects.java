package com.facebook.common.internal;

import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes9.dex */
public final class Objects {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.common.internal.Objects$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class ToStringHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String className;
        public ValueHolder holderHead;
        public ValueHolder holderTail;
        public boolean omitNullValues;

        /* loaded from: classes9.dex */
        public static final class ValueHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @Nullable
            public String name;
            public ValueHolder next;
            @Nullable
            public Object value;

            public ValueHolder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public /* synthetic */ ValueHolder(AnonymousClass1 anonymousClass1) {
                this();
            }
        }

        public /* synthetic */ ToStringHelper(String str, AnonymousClass1 anonymousClass1) {
            this(str);
        }

        private ValueHolder addHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                ValueHolder valueHolder = new ValueHolder(null);
                this.holderTail.next = valueHolder;
                this.holderTail = valueHolder;
                return valueHolder;
            }
            return (ValueHolder) invokeV.objValue;
        }

        public ToStringHelper add(String str, @Nullable Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, obj)) == null) ? addHolder(str, obj) : (ToStringHelper) invokeLL.objValue;
        }

        public ToStringHelper addValue(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) ? addHolder(obj) : (ToStringHelper) invokeL.objValue;
        }

        public ToStringHelper omitNullValues() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                this.omitNullValues = true;
                return this;
            }
            return (ToStringHelper) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                boolean z = this.omitNullValues;
                StringBuilder sb = new StringBuilder(32);
                sb.append(this.className);
                sb.append(ExtendedMessageFormat.START_FE);
                String str = "";
                for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                    if (!z || valueHolder.value != null) {
                        sb.append(str);
                        String str2 = valueHolder.name;
                        if (str2 != null) {
                            sb.append(str2);
                            sb.append(a.f35773h);
                        }
                        sb.append(valueHolder.value);
                        str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
                    }
                }
                sb.append(ExtendedMessageFormat.END_FE);
                return sb.toString();
            }
            return (String) invokeV.objValue;
        }

        public ToStringHelper(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ValueHolder valueHolder = new ValueHolder(null);
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        public ToStringHelper add(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) ? addHolder(str, String.valueOf(z)) : (ToStringHelper) invokeLZ.objValue;
        }

        public ToStringHelper addValue(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) ? addHolder(String.valueOf(z)) : (ToStringHelper) invokeZ.objValue;
        }

        private ToStringHelper addHolder(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, obj)) == null) {
                addHolder().value = obj;
                return this;
            }
            return (ToStringHelper) invokeL.objValue;
        }

        public ToStringHelper add(String str, char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Character.valueOf(c2)})) == null) ? addHolder(str, String.valueOf(c2)) : (ToStringHelper) invokeCommon.objValue;
        }

        public ToStringHelper addValue(char c2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Character.valueOf(c2)})) == null) ? addHolder(String.valueOf(c2)) : (ToStringHelper) invokeCommon.objValue;
        }

        public ToStringHelper add(String str, double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Double.valueOf(d2)})) == null) ? addHolder(str, String.valueOf(d2)) : (ToStringHelper) invokeCommon.objValue;
        }

        public ToStringHelper addValue(double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)})) == null) ? addHolder(String.valueOf(d2)) : (ToStringHelper) invokeCommon.objValue;
        }

        private ToStringHelper addHolder(String str, @Nullable Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, obj)) == null) {
                ValueHolder addHolder = addHolder();
                addHolder.value = obj;
                addHolder.name = (String) Preconditions.checkNotNull(str);
                return this;
            }
            return (ToStringHelper) invokeLL.objValue;
        }

        public ToStringHelper add(String str, float f2) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, str, f2)) == null) ? addHolder(str, String.valueOf(f2)) : (ToStringHelper) invokeLF.objValue;
        }

        public ToStringHelper addValue(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f2)) == null) ? addHolder(String.valueOf(f2)) : (ToStringHelper) invokeF.objValue;
        }

        public ToStringHelper add(String str, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i2)) == null) ? addHolder(str, String.valueOf(i2)) : (ToStringHelper) invokeLI.objValue;
        }

        public ToStringHelper addValue(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? addHolder(String.valueOf(i2)) : (ToStringHelper) invokeI.objValue;
        }

        public ToStringHelper add(String str, long j2) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j2)) == null) ? addHolder(str, String.valueOf(j2)) : (ToStringHelper) invokeLJ.objValue;
        }

        public ToStringHelper addValue(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) ? addHolder(String.valueOf(j2)) : (ToStringHelper) invokeJ.objValue;
        }
    }

    public Objects() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, obj2)) == null) ? obj == obj2 || (obj != null && obj.equals(obj2)) : invokeLL.booleanValue;
    }

    public static <T> T firstNonNull(@Nullable T t, @Nullable T t2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, t, t2)) == null) ? t != null ? t : (T) Preconditions.checkNotNull(t2) : (T) invokeLL.objValue;
    }

    public static int hashCode(@Nullable Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, objArr)) == null) ? Arrays.hashCode(objArr) : invokeL.intValue;
    }

    public static String simpleName(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) {
            String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
            int lastIndexOf = replaceAll.lastIndexOf(36);
            if (lastIndexOf == -1) {
                lastIndexOf = replaceAll.lastIndexOf(46);
            }
            return replaceAll.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj)) == null) ? new ToStringHelper(simpleName(obj.getClass()), null) : (ToStringHelper) invokeL.objValue;
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cls)) == null) ? new ToStringHelper(simpleName(cls), null) : (ToStringHelper) invokeL.objValue;
    }

    public static ToStringHelper toStringHelper(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? new ToStringHelper(str, null) : (ToStringHelper) invokeL.objValue;
    }
}
