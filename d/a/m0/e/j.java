package d.a.m0.e;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.UIMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class j extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43559f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f43560g;

        public a(j jVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43560g = jVar;
            this.f43559f = i2;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f43560g.b(this.f43559f);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                    j jVar = this.f43560g;
                    jVar.d(this.f43559f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f43552c, "cu on getToken unknown error.");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends d.a.m0.k.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43561f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f43562g;

        public b(j jVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43562g = jVar;
            this.f43561f = i2;
        }

        @Override // d.a.m0.k.c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f43562g.g(this.f43561f, this.f43562g.f43552c, this.f43562g.f43557h);
                } catch (Throwable th) {
                    d.a.m0.l.c.d(th);
                    j jVar = this.f43562g;
                    jVar.m(this.f43561f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, jVar.f43552c, "cu on getToken unknown error.");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.m0.e.i
    public void i(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.i(context, i2, j);
            c(i2, 2);
            d.a.m0.k.e.c().b(new a(this, i2));
        }
    }

    @Override // d.a.m0.e.i
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(this.f43554e)) {
                this.f43556g = null;
                this.f43555f = 0L;
                return true;
            } else if (this.f43555f - System.currentTimeMillis() < d.a.m0.l.b.f43636a) {
                this.f43556g = null;
                this.f43555f = 0L;
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.m0.e.i
    public void p(Context context, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            super.p(context, i2, j);
            c(i2, 4);
            d.a.m0.k.e.c().b(new b(this, i2));
        }
    }

    @Override // d.a.m0.e.i
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (TextUtils.isEmpty(this.f43557h)) {
                this.f43558i = 0L;
                return true;
            } else if (this.f43558i - System.currentTimeMillis() < d.a.m0.l.b.f43636a) {
                this.f43558i = 0L;
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
