package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public abstract class jb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jl a;

    public jb(jl jlVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jlVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jlVar;
    }

    public abstract byte a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract double m555a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract int m556a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract long m557a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract iy m558a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract iz m559a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract ja m560a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jf m561a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jg m562a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m563a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract ByteBuffer m564a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract short m565a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract void m566a();

    public abstract void a(byte b);

    public abstract void a(int i);

    public abstract void a(long j);

    public abstract void a(iy iyVar);

    public abstract void a(iz izVar);

    public abstract void a(ja jaVar);

    public abstract void a(jg jgVar);

    public abstract void a(String str);

    public abstract void a(ByteBuffer byteBuffer);

    public abstract void a(short s);

    public abstract void a(boolean z);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m567a();

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
