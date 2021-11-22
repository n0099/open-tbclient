package com.ss.android.downloadlib.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
/* loaded from: classes2.dex */
public class c<P, R> implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public P f69764a;

    /* renamed from: b  reason: collision with root package name */
    public R f69765b;

    /* renamed from: c  reason: collision with root package name */
    public int f69766c;

    /* renamed from: d  reason: collision with root package name */
    public SoftReference<a<P, R>> f69767d;

    /* renamed from: e  reason: collision with root package name */
    public c<?, P> f69768e;

    /* renamed from: f  reason: collision with root package name */
    public c<R, ?> f69769f;

    /* loaded from: classes2.dex */
    public interface a<PARAM, RESULT> {
        RESULT a(PARAM param);
    }

    public c(int i2, a<P, R> aVar, P p) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), aVar, p};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69766c = i2;
        this.f69767d = new SoftReference<>(aVar);
        this.f69764a = p;
    }

    public static <P, R> c<P, R> a(a<P, R> aVar, P p) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, aVar, p)) == null) ? new c<>(2, aVar, p) : (c) invokeLL.objValue;
    }

    private R b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.f69765b : (R) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        c<?, P> cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f69766c == 0 && !l.a()) {
                com.ss.android.downloadlib.f.a().b().post(this);
            } else if (this.f69766c == 1 && l.a()) {
                com.ss.android.downloadlib.d.a().a(this);
            } else if (this.f69766c == 2 && l.a()) {
                com.ss.android.downloadlib.d.a().b(this);
            } else {
                if (this.f69764a == null && (cVar = this.f69768e) != null) {
                    this.f69764a = cVar.b();
                }
                a<P, R> aVar = this.f69767d.get();
                if (aVar == null) {
                    return;
                }
                this.f69765b = aVar.a(this.f69764a);
                c<R, ?> cVar2 = this.f69769f;
                if (cVar2 != null) {
                    cVar2.run();
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.ss.android.downloadlib.g.c<P, R> */
    /* JADX WARN: Multi-variable type inference failed */
    public <NR> c<R, NR> a(int i2, a<R, NR> aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, aVar)) == null) {
            c cVar = (c<R, ?>) new c(i2, aVar, null);
            this.f69769f = cVar;
            cVar.f69768e = this;
            return cVar;
        }
        return (c) invokeIL.objValue;
    }

    public <NR> c<R, NR> a(a<R, NR> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? a(0, aVar) : (c) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c<?, P> cVar = this.f69768e;
            if (cVar != null) {
                cVar.a();
            } else {
                run();
            }
        }
    }
}
