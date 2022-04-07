package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class xm implements Comparable<xm> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public xm() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(xm xmVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xmVar)) == null) {
            int i = this.a;
            int i2 = xmVar.a;
            if (i - i2 > 0) {
                return 1;
            }
            if (i - i2 < 0) {
                return -1;
            }
            int i3 = this.b;
            int i4 = xmVar.b;
            if (i3 - i4 > 0) {
                return 1;
            }
            if (i3 - i4 < 0) {
                return -1;
            }
            int i5 = this.c;
            int i6 = xmVar.c;
            if (i5 - i6 > 0) {
                return 1;
            }
            if (i5 - i6 < 0) {
                return -1;
            }
            int i7 = this.d;
            int i8 = xmVar.d;
            if (i7 - i8 > 0) {
                return 1;
            }
            if (i7 - i8 < 0) {
                return -1;
            }
            int i9 = this.e;
            int i10 = xmVar.e;
            if (i9 - i10 > 0) {
                return 1;
            }
            if (i9 - i10 < 0) {
                return -1;
            }
            int i11 = this.f;
            int i12 = xmVar.f;
            if (i11 - i12 > 0) {
                return 1;
            }
            return i11 - i12 < 0 ? -1 : 0;
        }
        return invokeL.intValue;
    }

    public final void b(int i, int i2, int i3, int i4, int i5, int i6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? (obj instanceof xm) && compareTo((xm) obj) == 0 : invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a + "-" + this.b + "-" + this.c + " " + this.d + ":" + this.e + ":" + this.f;
        }
        return (String) invokeV.objValue;
    }
}
