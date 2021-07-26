package ms.bd.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;
import ms.bd.c.t;
/* loaded from: classes9.dex */
public class u extends t.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final w f73596g;

    public u(boolean z, w wVar) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73585a = z;
        this.f73596g = wVar;
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        wVar.h(allocate, 16L, 2);
        allocate.getShort();
        wVar.h(allocate, 28L, 4);
        this.f73586b = allocate.getInt() & 4294967295L;
        wVar.h(allocate, 32L, 4);
        this.f73587c = allocate.getInt() & 4294967295L;
        wVar.h(allocate, 42L, 2);
        this.f73588d = allocate.getShort() & UShort.MAX_VALUE;
        wVar.h(allocate, 44L, 2);
        this.f73589e = allocate.getShort() & UShort.MAX_VALUE;
        wVar.h(allocate, 46L, 2);
        this.f73590f = allocate.getShort() & UShort.MAX_VALUE;
        wVar.h(allocate, 48L, 2);
        allocate.getShort();
        wVar.h(allocate, 50L, 2);
        allocate.getShort();
    }

    @Override // ms.bd.c.t.b
    public t.a a(long j, int i2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? new r(this.f73596g, this, j, i2) : (t.a) invokeCommon.objValue;
    }

    @Override // ms.bd.c.t.b
    public t.c b(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new x(this.f73596g, this, j) : (t.c) invokeJ.objValue;
    }

    @Override // ms.bd.c.t.b
    public t.d c(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new z(this.f73596g, this, i2) : (t.d) invokeI.objValue;
    }
}
