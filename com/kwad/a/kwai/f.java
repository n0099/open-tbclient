package com.kwad.a.kwai;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.soloader.MinElf;
import com.kwad.a.kwai.c;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UShort;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes7.dex */
public class f implements c, Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final FileChannel f39072b;

    public f(File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = MinElf.ELF_MAGIC;
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f39072b = new FileInputStream(file).getChannel();
    }

    private long a(c.b bVar, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{bVar, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            for (long j3 = 0; j3 < j; j3++) {
                c.AbstractC1943c a = bVar.a(j3);
                if (a.a == 1) {
                    long j4 = a.f39070c;
                    if (j4 <= j2 && j2 <= a.f39071d + j4) {
                        return (j2 - j4) + a.f39069b;
                    }
                }
            }
            throw new IllegalStateException("Could not map vma to file offset!");
        }
        return invokeCommon.longValue;
    }

    public c.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.f39072b.position(0L);
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            if (c(allocate, 0L) == 1179403647) {
                short e2 = e(allocate, 4L);
                boolean z = e(allocate, 5L) == 2;
                if (e2 == 1) {
                    return new d(z, this);
                }
                if (e2 == 2) {
                    return new e(z, this);
                }
                throw new IllegalStateException("Invalid class type!");
            }
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        return (c.b) invokeV.objValue;
    }

    public String a(ByteBuffer byteBuffer, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer, j)) != null) {
            return (String) invokeLJ.objValue;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short e2 = e(byteBuffer, j);
            if (e2 == 0) {
                return sb.toString();
            }
            sb.append((char) e2);
            j = j2;
        }
    }

    public void a(ByteBuffer byteBuffer, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{byteBuffer, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            byteBuffer.position(0);
            byteBuffer.limit(i);
            long j2 = 0;
            while (j2 < i) {
                int read = this.f39072b.read(byteBuffer, j + j2);
                if (read == -1) {
                    throw new EOFException();
                }
                j2 += read;
            }
            byteBuffer.position(0);
        }
    }

    public long b(ByteBuffer byteBuffer, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, byteBuffer, j)) == null) {
            a(byteBuffer, j, 8);
            return byteBuffer.getLong();
        }
        return invokeLJ.longValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f39072b.position(0L);
            ArrayList arrayList = new ArrayList();
            c.b a = a();
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.order(a.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            long j2 = a.f39066f;
            int i = 0;
            if (j2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                j2 = a.a(0).a;
            }
            long j3 = 0;
            while (true) {
                if (j3 >= j2) {
                    j = 0;
                    break;
                }
                c.AbstractC1943c a2 = a.a(j3);
                if (a2.a == 2) {
                    j = a2.f39069b;
                    break;
                }
                j3++;
            }
            if (j == 0) {
                return Collections.unmodifiableList(arrayList);
            }
            ArrayList<Long> arrayList2 = new ArrayList();
            long j4 = 0;
            while (true) {
                c.a a3 = a.a(j, i);
                long j5 = j;
                long j6 = a3.a;
                if (j6 == 1) {
                    arrayList2.add(Long.valueOf(a3.f39061b));
                } else if (j6 == 5) {
                    j4 = a3.f39061b;
                }
                i++;
                if (a3.a == 0) {
                    break;
                }
                j = j5;
            }
            if (j4 != 0) {
                long a4 = a(a, j2, j4);
                for (Long l : arrayList2) {
                    arrayList.add(a(allocate, l.longValue() + a4));
                }
                return arrayList;
            }
            throw new IllegalStateException("String table offset not found!");
        }
        return (List) invokeV.objValue;
    }

    public long c(ByteBuffer byteBuffer, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, byteBuffer, j)) == null) {
            a(byteBuffer, j, 4);
            return byteBuffer.getInt() & 4294967295L;
        }
        return invokeLJ.longValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f39072b.close();
        }
    }

    public int d(ByteBuffer byteBuffer, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, byteBuffer, j)) == null) {
            a(byteBuffer, j, 2);
            return byteBuffer.getShort() & UShort.MAX_VALUE;
        }
        return invokeLJ.intValue;
    }

    public short e(ByteBuffer byteBuffer, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, j)) == null) {
            a(byteBuffer, j, 1);
            return (short) (byteBuffer.get() & 255);
        }
        return invokeLJ.shortValue;
    }
}
