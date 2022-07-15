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

    /* renamed from: a  reason: collision with other method in class */
    public abstract double m1480a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract int m1481a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract long m1482a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jc m1483a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jd m1484a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract je m1485a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jj m1486a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract jk m1487a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m1488a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract ByteBuffer m1489a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract short m1490a();

    /* renamed from: a  reason: collision with other method in class */
    public abstract void m1491a();

    public abstract void a(byte b);

    public abstract void a(int i);

    public abstract void a(long j);

    public abstract void a(jc jcVar);

    public abstract void a(jd jdVar);

    public abstract void a(je jeVar);

    public abstract void a(jk jkVar);

    public abstract void a(String str);

    public abstract void a(ByteBuffer byteBuffer);

    public abstract void a(short s);

    public abstract void a(boolean z);

    /* renamed from: a  reason: collision with other method in class */
    public abstract boolean m1492a();

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
