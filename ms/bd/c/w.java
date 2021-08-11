package ms.bd.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ms.bd.c.t;
import okhttp3.internal.ws.WebSocketProtocol;
/* loaded from: classes2.dex */
public class w implements Closeable, t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final FileChannel f78902e;

    public w(File file) throws FileNotFoundException {
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
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f78902e = new FileInputStream(file).getChannel();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f78902e.close();
        }
    }

    public List<String> g() throws IOException {
        InterceptResult invokeV;
        t.b vVar;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f78902e.position(0L);
            ArrayList arrayList = new ArrayList();
            this.f78902e.position(0L);
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            h(allocate, 0L, 4);
            if ((allocate.getInt() & 4294967295L) == 1179403647) {
                h(allocate, 4L, 1);
                int i2 = allocate.get() & 255;
                h(allocate, 5L, 1);
                boolean z = (allocate.get() & 255) == 2;
                if (i2 == 1) {
                    vVar = new u(z, this);
                } else if (i2 != 2) {
                    throw new IllegalStateException("Invalid class type!");
                } else {
                    vVar = new v(z, this);
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(8);
                allocate2.order(vVar.f78886a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
                long j4 = vVar.f78890e;
                if (j4 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    j4 = vVar.c(0).f78896a;
                }
                long j5 = 0;
                while (true) {
                    if (j5 >= j4) {
                        j2 = j4;
                        j3 = 0;
                        break;
                    }
                    t.c b2 = vVar.b(j5);
                    j2 = j4;
                    if (b2.f78892a == 2) {
                        j3 = b2.f78893b;
                        break;
                    }
                    j5++;
                    j4 = j2;
                }
                if (j3 == 0) {
                    return Collections.unmodifiableList(arrayList);
                }
                ArrayList<Long> arrayList2 = new ArrayList();
                long j6 = 0;
                int i3 = 0;
                while (true) {
                    t.a a2 = vVar.a(j3, i3);
                    long j7 = a2.f78884a;
                    if (j7 == 1) {
                        arrayList2.add(Long.valueOf(a2.f78885b));
                    } else if (j7 == 5) {
                        j6 = a2.f78885b;
                    }
                    i3++;
                    if (a2.f78884a == 0) {
                        break;
                    }
                }
                if (j6 != 0) {
                    for (long j8 = 0; j8 < j2; j8++) {
                        t.c b3 = vVar.b(j8);
                        if (b3.f78892a == 1) {
                            long j9 = b3.f78894c;
                            if (j9 <= j6 && j6 <= b3.f78895d + j9) {
                                long j10 = (j6 - j9) + b3.f78893b;
                                for (Long l : arrayList2) {
                                    long longValue = l.longValue() + j10;
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        long j11 = longValue + 1;
                                        h(allocate2, longValue, 1);
                                        int i4 = allocate2.get() & 255;
                                        if (i4 != 0) {
                                            sb.append((char) i4);
                                            longValue = j11;
                                        }
                                    }
                                    arrayList.add(sb.toString());
                                }
                                return arrayList;
                            }
                        }
                    }
                    throw new IllegalStateException("Could not map vma to file offset!");
                }
                throw new IllegalStateException("String table offset not found!");
            }
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        return (List) invokeV.objValue;
    }

    public void h(ByteBuffer byteBuffer, long j2, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{byteBuffer, Long.valueOf(j2), Integer.valueOf(i2)}) == null) {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            long j3 = 0;
            while (j3 < i2) {
                int read = this.f78902e.read(byteBuffer, j2 + j3);
                if (read == -1) {
                    throw new EOFException();
                }
                j3 += read;
            }
            byteBuffer.position(0);
        }
    }
}
