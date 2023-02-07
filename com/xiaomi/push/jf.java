package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public abstract class jf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jp a;

    public jf(jp jpVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jpVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jpVar;
    }

    public abstract byte a();

    /* renamed from: a */
    public abstract double mo617a();

    /* renamed from: a */
    public abstract int mo618a();

    /* renamed from: a */
    public abstract long mo619a();

    /* renamed from: a */
    public abstract jc mo620a();

    /* renamed from: a */
    public abstract jd mo621a();

    /* renamed from: a */
    public abstract je mo622a();

    /* renamed from: a */
    public abstract jj mo623a();

    /* renamed from: a */
    public abstract jk mo624a();

    /* renamed from: a */
    public abstract String mo625a();

    /* renamed from: a */
    public abstract ByteBuffer mo626a();

    /* renamed from: a */
    public abstract short mo627a();

    /* renamed from: a */
    public abstract void mo628a();

    public abstract void a(byte b);

    /* renamed from: a */
    public abstract void mo629a(int i);

    public abstract void a(long j);

    public abstract void a(jc jcVar);

    public abstract void a(jd jdVar);

    public abstract void a(je jeVar);

    public abstract void a(jk jkVar);

    public abstract void a(String str);

    public abstract void a(ByteBuffer byteBuffer);

    public abstract void a(short s);

    public abstract void a(boolean z);

    /* renamed from: a */
    public abstract boolean mo630a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }
}
