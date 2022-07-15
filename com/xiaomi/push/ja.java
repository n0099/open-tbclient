package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.jb;
import java.io.ByteArrayOutputStream;
/* loaded from: classes8.dex */
public class ja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jf a;

    /* renamed from: a  reason: collision with other field name */
    public final jm f1520a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteArrayOutputStream f1521a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ja() {
        this(new jb.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((jh) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ja(jh jhVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jhVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f1521a = byteArrayOutputStream;
        jm jmVar = new jm(byteArrayOutputStream);
        this.f1520a = jmVar;
        this.a = jhVar.a(jmVar);
    }

    public byte[] a(iu iuVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iuVar)) == null) {
            this.f1521a.reset();
            iuVar.b(this.a);
            return this.f1521a.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }
}
