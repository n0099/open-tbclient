package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ix;
import java.io.ByteArrayOutputStream;
/* loaded from: classes10.dex */
public class iw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public jb f77644a;

    /* renamed from: a  reason: collision with other field name */
    public final ji f805a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteArrayOutputStream f806a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public iw() {
        this(new ix.a());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f806a = byteArrayOutputStream;
        ji jiVar = new ji(byteArrayOutputStream);
        this.f805a = jiVar;
        this.f77644a = jdVar.a(jiVar);
    }

    public byte[] a(iq iqVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iqVar)) == null) {
            this.f806a.reset();
            iqVar.b(this.f77644a);
            return this.f806a.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }
}
