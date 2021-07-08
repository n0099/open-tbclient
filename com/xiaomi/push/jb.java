package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public abstract class jb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public jl f40515a;

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
        this.f40515a = jlVar;
    }

    public abstract byte a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract double m517a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract int m518a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract long m519a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract iy m520a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract iz m521a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract ja m522a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jf m523a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jg m524a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m525a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract ByteBuffer m526a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract short m527a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract void m528a();

    public abstract void a(byte b2);

    public abstract void a(int i2);

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
    public abstract boolean m529a();

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
