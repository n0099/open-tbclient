package com.ss.android.socialbase.appdownloader.f.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int[] f69010a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f69011b;

    public f() {
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

    public static f a(d dVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            b.a(dVar, 1835009);
            int b2 = dVar.b();
            int b3 = dVar.b();
            int b4 = dVar.b();
            dVar.b();
            int b5 = dVar.b();
            int b6 = dVar.b();
            f fVar = new f();
            fVar.f69010a = dVar.b(b3);
            if (b4 != 0) {
                dVar.b(b4);
            }
            int i2 = (b6 == 0 ? b2 : b6) - b5;
            if (i2 % 4 == 0) {
                fVar.f69011b = dVar.b(i2 / 4);
                if (b6 != 0) {
                    int i3 = b2 - b6;
                    if (i3 % 4 == 0) {
                        dVar.b(i3 / 4);
                    } else {
                        throw new IOException("Style data size is not multiple of 4 (" + i3 + ").");
                    }
                }
                return fVar;
            }
            throw new IOException("String data size is not multiple of 4 (" + i2 + ").");
        }
        return (f) invokeL.objValue;
    }

    public String a(int i2) {
        InterceptResult invokeI;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (i2 < 0 || (iArr = this.f69010a) == null || i2 >= iArr.length) {
                return null;
            }
            int i3 = iArr[i2];
            int a2 = a(this.f69011b, i3);
            StringBuilder sb = new StringBuilder(a2);
            while (a2 != 0) {
                i3 += 2;
                sb.append((char) a(this.f69011b, i3));
                a2--;
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static final int a(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, iArr, i2)) == null) {
            int i3 = iArr[i2 / 4];
            return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
        }
        return invokeLI.intValue;
    }
}
