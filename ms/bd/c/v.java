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
/* loaded from: classes10.dex */
public class v extends t.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final w f76111g;

    public v(boolean z, w wVar) throws IOException {
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
        this.f76097a = z;
        this.f76111g = wVar;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(z ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        wVar.h(allocate, 16L, 2);
        allocate.getShort();
        wVar.h(allocate, 32L, 8);
        this.f76098b = allocate.getLong();
        wVar.h(allocate, 40L, 8);
        this.f76099c = allocate.getLong();
        wVar.h(allocate, 54L, 2);
        this.f76100d = allocate.getShort() & UShort.MAX_VALUE;
        wVar.h(allocate, 56L, 2);
        this.f76101e = allocate.getShort() & UShort.MAX_VALUE;
        wVar.h(allocate, 58L, 2);
        this.f76102f = allocate.getShort() & UShort.MAX_VALUE;
        wVar.h(allocate, 60L, 2);
        allocate.getShort();
        wVar.h(allocate, 62L, 2);
        allocate.getShort();
    }

    @Override // ms.bd.c.t.b
    public t.a a(long j, int i2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)})) == null) ? new s(this.f76111g, this, j, i2) : (t.a) invokeCommon.objValue;
    }

    @Override // ms.bd.c.t.b
    public t.c b(long j) throws IOException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) ? new y(this.f76111g, this, j) : (t.c) invokeJ.objValue;
    }

    @Override // ms.bd.c.t.b
    public t.d c(int i2) throws IOException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? new a0(this.f76111g, this, i2) : (t.d) invokeI.objValue;
    }
}
