package com.squareup.wire;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.ProtoEnum;
import java.util.Arrays;
import java.util.Comparator;
/* loaded from: classes2.dex */
public final class EnumAdapter<E extends ProtoEnum> {
    public static /* synthetic */ Interceptable $ic;
    public static final Comparator<ProtoEnum> COMPARATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final E[] constants;
    public final boolean isDense;
    public final Class<E> type;
    public final int[] values;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(771148570, "Lcom/squareup/wire/EnumAdapter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(771148570, "Lcom/squareup/wire/EnumAdapter;");
                return;
            }
        }
        COMPARATOR = new Comparator<ProtoEnum>() { // from class: com.squareup.wire.EnumAdapter.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ProtoEnum protoEnum, ProtoEnum protoEnum2) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, protoEnum, protoEnum2)) == null) ? protoEnum.getValue() - protoEnum2.getValue() : invokeLL.intValue;
            }
        };
    }

    public EnumAdapter(Class<E> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.constants = enumConstants;
        Arrays.sort(enumConstants, COMPARATOR);
        E[] eArr = this.constants;
        int length = eArr.length;
        if (eArr[0].getValue() == 1 && this.constants[length - 1].getValue() == length) {
            this.isDense = true;
            this.values = null;
            return;
        }
        this.isDense = false;
        this.values = new int[length];
        for (int i4 = 0; i4 < length; i4++) {
            this.values[i4] = this.constants[i4].getValue();
        }
    }

    public E fromInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            try {
                return this.constants[this.isDense ? i2 - 1 : Arrays.binarySearch(this.values, i2)];
            } catch (IndexOutOfBoundsException unused) {
                throw new IllegalArgumentException("Unknown enum tag " + i2 + " for " + this.type.getCanonicalName());
            }
        }
        return (E) invokeI.objValue;
    }

    public int toInt(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2)) == null) ? e2.getValue() : invokeL.intValue;
    }
}
