package com.facebook.common.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
@Nullsafe(Nullsafe.Mode.STRICT)
/* loaded from: classes7.dex */
public final class Objects {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.common.internal.Objects$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public static final class ToStringHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String className;
        public final ValueHolder holderHead;
        public ValueHolder holderTail;
        public boolean omitNullValues;

        /* loaded from: classes7.dex */
        public static final class ValueHolder {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @Nullable
            public String name;
            @Nullable
            public ValueHolder next;
            @Nullable
            public Object value;

            public ValueHolder() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                sb.append('{');
                String str = "";
                for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                    Object obj = valueHolder.value;
                    if (!z || obj != null) {
                        sb.append(str);
                        String str2 = valueHolder.name;
                        if (str2 != null) {
                            sb.append(str2);
                            sb.append('=');
                        }
                        if (obj != null && obj.getClass().isArray()) {
                            String deepToString = Arrays.deepToString(new Object[]{obj});
                            sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                        } else {
                            sb.append(obj);
                        }
                        str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
                    }
                }
                sb.append('}');
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        public ToStringHelper add(String str, char c) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Character.valueOf(c)})) == null) ? addHolder(str, String.valueOf(c)) : (ToStringHelper) invokeCommon.objValue;
        }

        public ToStringHelper addValue(char c) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Character.valueOf(c)})) == null) ? addHolder(String.valueOf(c)) : (ToStringHelper) invokeCommon.objValue;
        }

        public ToStringHelper add(String str, double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Double.valueOf(d)})) == null) ? addHolder(str, String.valueOf(d)) : (ToStringHelper) invokeCommon.objValue;
        }

        public ToStringHelper addValue(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)})) == null) ? addHolder(String.valueOf(d)) : (ToStringHelper) invokeCommon.objValue;
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

        public ToStringHelper add(String str, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, str, f)) == null) ? addHolder(str, String.valueOf(f)) : (ToStringHelper) invokeLF.objValue;
        }

        public ToStringHelper addValue(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f)) == null) ? addHolder(String.valueOf(f)) : (ToStringHelper) invokeF.objValue;
        }

        public ToStringHelper add(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) ? addHolder(str, String.valueOf(i)) : (ToStringHelper) invokeLI.objValue;
        }

        public ToStringHelper addValue(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? addHolder(String.valueOf(i)) : (ToStringHelper) invokeI.objValue;
        }

        public ToStringHelper add(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j)) == null) ? addHolder(str, String.valueOf(j)) : (ToStringHelper) invokeLJ.objValue;
        }

        public ToStringHelper addValue(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) ? addHolder(String.valueOf(j)) : (ToStringHelper) invokeJ.objValue;
        }
    }

    public Objects() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static ToStringHelper toStringHelper(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? new ToStringHelper(obj.getClass().getSimpleName(), null) : (ToStringHelper) invokeL.objValue;
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) ? new ToStringHelper(cls.getSimpleName(), null) : (ToStringHelper) invokeL.objValue;
    }

    public static ToStringHelper toStringHelper(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) ? new ToStringHelper(str, null) : (ToStringHelper) invokeL.objValue;
    }
}
