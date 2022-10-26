package com.tencent.open.log;

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
/* loaded from: classes8.dex */
public class f implements Iterable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentLinkedQueue a;
    public AtomicInteger b;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.a = new ConcurrentLinkedQueue();
        this.b = new AtomicInteger(0);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b.get();
        }
        return invokeV.intValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.clear();
            this.b.set(0);
        }
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            int length = str.length();
            this.a.add(str);
            return this.b.addAndGet(length);
        }
        return invokeL.intValue;
    }

    public void a(Writer[] writerArr, char[] cArr) throws IOException {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, writerArr, cArr) == null) && writerArr != null && cArr != null && cArr.length != 0 && writerArr.length >= 2) {
            Writer writer = writerArr[0];
            Writer writer2 = writerArr[1];
            int length = cArr.length;
            Iterator it = iterator();
            int i2 = length;
            int i3 = 0;
            while (it.hasNext()) {
                String str = (String) it.next();
                int length2 = str.length();
                int i4 = 0;
                while (length2 > 0) {
                    if (i2 > length2) {
                        i = length2;
                    } else {
                        i = i2;
                    }
                    int i5 = i4 + i;
                    str.getChars(i4, i5, cArr, i3);
                    i2 -= i;
                    i3 += i;
                    length2 -= i;
                    if (i2 == 0) {
                        if (writer != null) {
                            try {
                                writer.write(cArr, 0, length);
                            } catch (Exception unused) {
                            }
                        }
                        if (writer2 != null) {
                            try {
                                writer2.write(cArr, 0, length);
                            } catch (Exception unused2) {
                            }
                        }
                        i2 = length;
                        i4 = i5;
                        i3 = 0;
                    } else {
                        i4 = i5;
                    }
                }
            }
            if (i3 > 0) {
                if (writer != null) {
                    try {
                        writer.write(cArr, 0, i3);
                    } catch (Exception unused3) {
                    }
                }
                if (writer2 != null) {
                    try {
                        writer2.write(cArr, 0, i3);
                    } catch (Exception unused4) {
                    }
                }
            }
            if (writer != null) {
                try {
                    writer.flush();
                } catch (Exception unused5) {
                }
            }
            if (writer2 != null) {
                try {
                    writer2.flush();
                } catch (Exception unused6) {
                }
            }
        }
    }
}
