package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ix;
import java.io.ByteArrayOutputStream;
/* loaded from: classes7.dex */
public class iw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jb a;

    /* renamed from: a  reason: collision with other field name */
    public final ji f782a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteArrayOutputStream f783a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public iw() {
        this(new ix.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((jd) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public iw(jd jdVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jdVar};
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
        this.f783a = byteArrayOutputStream;
        ji jiVar = new ji(byteArrayOutputStream);
        this.f782a = jiVar;
        this.a = jdVar.a(jiVar);
    }

    public byte[] a(iq iqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iqVar)) == null) {
            this.f783a.reset();
            iqVar.b(this.a);
            return this.f783a.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }
}
