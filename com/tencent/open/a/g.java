package com.tencent.open.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class g implements Iterable<String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentLinkedQueue<String> f38914a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f38915b;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38914a = null;
        this.f38915b = null;
        this.f38914a = new ConcurrentLinkedQueue<>();
        this.f38915b = new AtomicInteger(0);
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int length = str.length();
            this.f38914a.add(str);
            return this.f38915b.addAndGet(length);
        }
        return invokeL.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f38914a.clear();
            this.f38915b.set(0);
        }
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f38914a.iterator() : (Iterator) invokeV.objValue;
    }

    public void a(Writer writer, char[] cArr) throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, writer, cArr) == null) || writer == null || cArr == null || cArr.length == 0) {
            return;
        }
        int length = cArr.length;
        Iterator<String> it = iterator();
        int i2 = length;
        int i3 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int length2 = next.length();
            int i4 = 0;
            while (length2 > 0) {
                int i5 = i2 > length2 ? length2 : i2;
                int i6 = i4 + i5;
                next.getChars(i4, i6, cArr, i3);
                i2 -= i5;
                i3 += i5;
                length2 -= i5;
                if (i2 == 0) {
                    writer.write(cArr, 0, length);
                    i2 = length;
                    i4 = i6;
                    i3 = 0;
                } else {
                    i4 = i6;
                }
            }
        }
        if (i3 > 0) {
            writer.write(cArr, 0, i3);
        }
        writer.flush();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38915b.get() : invokeV.intValue;
    }
}
