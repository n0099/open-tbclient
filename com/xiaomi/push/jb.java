package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = jlVar;
    }

    public abstract byte a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract double m581a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract int m582a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract long m583a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract iy m584a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract iz m585a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract ja m586a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jf m587a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jg m588a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m589a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract ByteBuffer m590a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract short m591a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract void m592a();

    public abstract void a(byte b2);

    public abstract void a(int i2);

    public abstract void a(long j2);

    public abstract void a(iy iyVar);

    public abstract void a(iz izVar);

    public abstract void a(ja jaVar);

    public abstract void a(jg jgVar);

    public abstract void a(String str);

    public abstract void a(ByteBuffer byteBuffer);

    public abstract void a(short s);

    public abstract void a(boolean z);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m593a();

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
