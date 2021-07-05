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
/* loaded from: classes10.dex */
public class w implements Closeable, t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final FileChannel f76113e;

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
        this.f76113e = new FileInputStream(file).getChannel();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f76113e.close();
        }
    }

    public List<String> g() throws IOException {
        InterceptResult invokeV;
        t.b vVar;
        long j;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.f76113e.position(0L);
            ArrayList arrayList = new ArrayList();
            this.f76113e.position(0L);
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
                allocate2.order(vVar.f76097a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
                long j3 = vVar.f76101e;
                if (j3 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    j3 = vVar.c(0).f76107a;
                }
                long j4 = 0;
                while (true) {
                    if (j4 >= j3) {
                        j = j3;
                        j2 = 0;
                        break;
                    }
                    t.c b2 = vVar.b(j4);
                    j = j3;
                    if (b2.f76103a == 2) {
                        j2 = b2.f76104b;
                        break;
                    }
                    j4++;
                    j3 = j;
                }
                if (j2 == 0) {
                    return Collections.unmodifiableList(arrayList);
                }
                ArrayList<Long> arrayList2 = new ArrayList();
                long j5 = 0;
                int i3 = 0;
                while (true) {
                    t.a a2 = vVar.a(j2, i3);
                    long j6 = a2.f76095a;
                    if (j6 == 1) {
                        arrayList2.add(Long.valueOf(a2.f76096b));
                    } else if (j6 == 5) {
                        j5 = a2.f76096b;
                    }
                    i3++;
                    if (a2.f76095a == 0) {
                        break;
                    }
                }
                if (j5 != 0) {
                    for (long j7 = 0; j7 < j; j7++) {
                        t.c b3 = vVar.b(j7);
                        if (b3.f76103a == 1) {
                            long j8 = b3.f76105c;
                            if (j8 <= j5 && j5 <= b3.f76106d + j8) {
                                long j9 = (j5 - j8) + b3.f76104b;
                                for (Long l : arrayList2) {
                                    long longValue = l.longValue() + j9;
                                    StringBuilder sb = new StringBuilder();
                                    while (true) {
                                        long j10 = longValue + 1;
                                        h(allocate2, longValue, 1);
                                        int i4 = allocate2.get() & 255;
                                        if (i4 != 0) {
                                            sb.append((char) i4);
                                            longValue = j10;
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

    public void h(ByteBuffer byteBuffer, long j, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{byteBuffer, Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            long j2 = 0;
            while (j2 < i2) {
                int read = this.f76113e.read(byteBuffer, j + j2);
                if (read == -1) {
                    throw new EOFException();
                }
                j2 += read;
            }
            byteBuffer.position(0);
        }
    }
}
