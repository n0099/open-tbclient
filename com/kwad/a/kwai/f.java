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
/* loaded from: classes3.dex */
public class f implements c, Closeable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final FileChannel f55356b;

    public f(File file) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = MinElf.ELF_MAGIC;
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f55356b = new FileInputStream(file).getChannel();
    }

    private long a(c.b bVar, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{bVar, Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            for (long j4 = 0; j4 < j2; j4++) {
                c.AbstractC2087c a = bVar.a(j4);
                if (a.a == 1) {
                    long j5 = a.f55352c;
                    if (j5 <= j3 && j3 <= a.f55353d + j5) {
                        return (j3 - j5) + a.f55351b;
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
            this.f55356b.position(0L);
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

    public String a(ByteBuffer byteBuffer, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer, j2)) != null) {
            return (String) invokeLJ.objValue;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j3 = 1 + j2;
            short e2 = e(byteBuffer, j2);
            if (e2 == 0) {
                return sb.toString();
            }
            sb.append((char) e2);
            j2 = j3;
        }
    }

    public void a(ByteBuffer byteBuffer, long j2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{byteBuffer, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            long j3 = 0;
            while (j3 < i2) {
                int read = this.f55356b.read(byteBuffer, j2 + j3);
                if (read == -1) {
                    throw new EOFException();
                }
                j3 += read;
            }
            byteBuffer.position(0);
        }
    }

    public long b(ByteBuffer byteBuffer, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, byteBuffer, j2)) == null) {
            a(byteBuffer, j2, 8);
            return byteBuffer.getLong();
        }
        return invokeLJ.longValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.f55356b.position(0L);
            ArrayList arrayList = new ArrayList();
            c.b a = a();
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.order(a.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            long j3 = a.f55347f;
            int i2 = 0;
            if (j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                j3 = a.a(0).a;
            }
            long j4 = 0;
            while (true) {
                if (j4 >= j3) {
                    j2 = 0;
                    break;
                }
                c.AbstractC2087c a2 = a.a(j4);
                if (a2.a == 2) {
                    j2 = a2.f55351b;
                    break;
                }
                j4++;
            }
            if (j2 == 0) {
                return Collections.unmodifiableList(arrayList);
            }
            ArrayList<Long> arrayList2 = new ArrayList();
            long j5 = 0;
            while (true) {
                c.a a3 = a.a(j2, i2);
                long j6 = j2;
                long j7 = a3.a;
                if (j7 == 1) {
                    arrayList2.add(Long.valueOf(a3.f55342b));
                } else if (j7 == 5) {
                    j5 = a3.f55342b;
                }
                i2++;
                if (a3.a == 0) {
                    break;
                }
                j2 = j6;
            }
            if (j5 != 0) {
                long a4 = a(a, j3, j5);
                for (Long l : arrayList2) {
                    arrayList.add(a(allocate, l.longValue() + a4));
                }
                return arrayList;
            }
            throw new IllegalStateException("String table offset not found!");
        }
        return (List) invokeV.objValue;
    }

    public long c(ByteBuffer byteBuffer, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, byteBuffer, j2)) == null) {
            a(byteBuffer, j2, 4);
            return byteBuffer.getInt() & 4294967295L;
        }
        return invokeLJ.longValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f55356b.close();
        }
    }

    public int d(ByteBuffer byteBuffer, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048583, this, byteBuffer, j2)) == null) {
            a(byteBuffer, j2, 2);
            return byteBuffer.getShort() & UShort.MAX_VALUE;
        }
        return invokeLJ.intValue;
    }

    public short e(ByteBuffer byteBuffer, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer, j2)) == null) {
            a(byteBuffer, j2, 1);
            return (short) (byteBuffer.get() & 255);
        }
        return invokeLJ.shortValue;
    }
}
