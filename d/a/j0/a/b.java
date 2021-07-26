package d.a.j0.a;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j0.a.d.c;
/* loaded from: classes7.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43115c;

    /* renamed from: d  reason: collision with root package name */
    public long f43116d;

    /* renamed from: e  reason: collision with root package name */
    public V8ExceptionInfo f43117e;

    /* renamed from: f  reason: collision with root package name */
    public int f43118f;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43115c = false;
    }

    @Override // d.a.j0.a.d.c
    public synchronized void a(int i2, V8ExceptionInfo v8ExceptionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, v8ExceptionInfo) == null) {
            synchronized (this) {
                if (this.f43117e == null && v8ExceptionInfo != null) {
                    this.f43117e = new V8ExceptionInfo(v8ExceptionInfo.exceptionTime, v8ExceptionInfo.exceptionMsg, v8ExceptionInfo.exceptionTrace, v8ExceptionInfo.exceptionType, v8ExceptionInfo.filePath);
                    this.f43118f = i2;
                    if (this.f43129b != null) {
                        this.f43129b.a();
                    }
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f43117e = null;
            this.f43116d = 0L;
            this.f43118f = -1;
        }
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f43115c) {
                    return;
                }
                if (this.f43129b != null && this.f43116d > 0 && this.f43117e != null) {
                    if (System.currentTimeMillis() - this.f43117e.exceptionTime > this.f43128a && this.f43117e.exceptionTime > this.f43116d) {
                        this.f43129b.b(new d.a.j0.a.d.b(this.f43118f, this.f43117e, this.f43116d));
                        d();
                    }
                    return;
                }
                Log.e("StuckScreenHandler", "[StuckScreen] 未设置冻屏监听器， 或者异常信息已经被清空（需等待下次上屏）。");
            }
        }
    }

    public synchronized void f(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (this) {
                this.f43115c = z;
                if (z) {
                    this.f43116d = j;
                    this.f43117e = null;
                }
            }
        }
    }
}
