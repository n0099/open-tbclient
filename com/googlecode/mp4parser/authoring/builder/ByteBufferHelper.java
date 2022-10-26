package com.googlecode.mp4parser.authoring.builder;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class ByteBufferHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ByteBufferHelper() {
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

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008a, code lost:
        if ((r1 instanceof java.nio.MappedByteBuffer) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0092, code lost:
        if ((r0.get(r2) instanceof java.nio.MappedByteBuffer) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ad, code lost:
        if (((java.nio.ByteBuffer) r0.get(r2)).limit() != (((java.nio.ByteBuffer) r0.get(r2)).capacity() - r1.capacity())) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
        r2 = (java.nio.ByteBuffer) r0.get(r2);
        r2.limit(r1.limit() + r2.limit());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List mergeAdjacentBuffers(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ByteBuffer byteBuffer = (ByteBuffer) it.next();
                int size = arrayList.size() - 1;
                if (size >= 0 && byteBuffer.hasArray() && ((ByteBuffer) arrayList.get(size)).hasArray() && byteBuffer.array() == ((ByteBuffer) arrayList.get(size)).array() && ((ByteBuffer) arrayList.get(size)).arrayOffset() + ((ByteBuffer) arrayList.get(size)).limit() == byteBuffer.arrayOffset()) {
                    ByteBuffer byteBuffer2 = (ByteBuffer) arrayList.remove(size);
                    arrayList.add(ByteBuffer.wrap(byteBuffer.array(), byteBuffer2.arrayOffset(), byteBuffer2.limit() + byteBuffer.limit()).slice());
                } else {
                    byteBuffer.reset();
                    arrayList.add(byteBuffer);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
