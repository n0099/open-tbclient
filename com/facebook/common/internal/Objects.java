package com.facebook.common.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public final class Objects {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.facebook.common.internal.Objects$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public final class ToStringHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String className;
        public final ValueHolder holderHead;
        public ValueHolder holderTail;
        public boolean omitNullValues;

        /* loaded from: classes7.dex */
        public final class ValueHolder {
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

        public /* synthetic */ ToStringHelper(String str, AnonymousClass1 anonymousClass1) {
            this(str);
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

        public ToStringHelper add(String str, char c) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Character.valueOf(c)})) == null) {
                return addHolder(str, String.valueOf(c));
            }
            return (ToStringHelper) invokeCommon.objValue;
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

        public ToStringHelper omitNullValues() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                this.omitNullValues = true;
                return this;
            }
            return (ToStringHelper) invokeV.objValue;
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

        public ToStringHelper addValue(char c) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Character.valueOf(c)})) == null) {
                return addHolder(String.valueOf(c));
            }
            return (ToStringHelper) invokeCommon.objValue;
        }

        public ToStringHelper add(String str, double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Double.valueOf(d)})) == null) {
                return addHolder(str, String.valueOf(d));
            }
            return (ToStringHelper) invokeCommon.objValue;
        }

        public ToStringHelper add(String str, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, str, f)) == null) {
                return addHolder(str, String.valueOf(f));
            }
            return (ToStringHelper) invokeLF.objValue;
        }

        public ToStringHelper add(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
                return addHolder(str, String.valueOf(i));
            }
            return (ToStringHelper) invokeLI.objValue;
        }

        public ToStringHelper add(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j)) == null) {
                return addHolder(str, String.valueOf(j));
            }
            return (ToStringHelper) invokeLJ.objValue;
        }

        public ToStringHelper add(String str, @Nullable Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, obj)) == null) {
                return addHolder(str, obj);
            }
            return (ToStringHelper) invokeLL.objValue;
        }

        public ToStringHelper add(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
                return addHolder(str, String.valueOf(z));
            }
            return (ToStringHelper) invokeLZ.objValue;
        }

        public ToStringHelper addValue(double d) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d)})) == null) {
                return addHolder(String.valueOf(d));
            }
            return (ToStringHelper) invokeCommon.objValue;
        }

        public ToStringHelper addValue(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f)) == null) {
                return addHolder(String.valueOf(f));
            }
            return (ToStringHelper) invokeF.objValue;
        }

        public ToStringHelper addValue(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) {
                return addHolder(String.valueOf(i));
            }
            return (ToStringHelper) invokeI.objValue;
        }

        public ToStringHelper addValue(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j)) == null) {
                return addHolder(String.valueOf(j));
            }
            return (ToStringHelper) invokeJ.objValue;
        }

        public ToStringHelper addValue(@Nullable Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
                return addHolder(obj);
            }
            return (ToStringHelper) invokeL.objValue;
        }

        public ToStringHelper addValue(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                return addHolder(String.valueOf(z));
            }
            return (ToStringHelper) invokeZ.objValue;
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, obj, obj2)) == null) {
            if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static Object firstNonNull(@Nullable Object obj, @Nullable Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, obj2)) == null) {
            if (obj == null) {
                return Preconditions.checkNotNull(obj2);
            }
            return obj;
        }
        return invokeLL.objValue;
    }

    public static int hashCode(@Nullable Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, objArr)) == null) {
            return Arrays.hashCode(objArr);
        }
        return invokeL.intValue;
    }

    public static ToStringHelper toStringHelper(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) {
            return new ToStringHelper(cls.getSimpleName(), null);
        }
        return (ToStringHelper) invokeL.objValue;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) {
            return new ToStringHelper(obj.getClass().getSimpleName(), null);
        }
        return (ToStringHelper) invokeL.objValue;
    }

    public static ToStringHelper toStringHelper(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return new ToStringHelper(str, null);
        }
        return (ToStringHelper) invokeL.objValue;
    }
}
