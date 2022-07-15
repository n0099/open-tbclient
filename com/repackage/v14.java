package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.u14;
/* loaded from: classes7.dex */
public class v14 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public r72 a;
    public ou3 b;
    public String c;

    /* loaded from: classes7.dex */
    public class a implements u14.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v14 a;

        public a(v14 v14Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v14Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v14Var;
        }

        @Override // com.repackage.u14.a
        public void a(int i, long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) && this.a.hasEventListener("progressupdate")) {
                w14 w14Var = new w14();
                w14Var.progress = i;
                w14Var.totalBytesWritten = j;
                w14Var.totalBytesExpectedToWrite = j2;
                JSEvent jSEvent = new JSEvent("progressupdate");
                jSEvent.data = w14Var;
                if (v14.d) {
                    Log.i("LoadSubpackageTask", "progress :" + i + "totalBytesWritten :" + j + "totalBytesExpectedToWrite :" + j2);
                }
                this.a.dispatchEvent(jSEvent);
            }
        }

        @Override // com.repackage.u14.a
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                this.a.D(false);
                a14.j(this.a.c, i, "");
            }
        }

        @Override // com.repackage.u14.a
        public void success() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                v14 v14Var = this.a;
                this.a.D(v14Var.E(v14Var.c));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ v14 b;

        public b(v14 v14Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v14Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = v14Var;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a) {
                    if (this.b.b != null) {
                        this.b.b.c();
                        if (v14.d) {
                            Log.i("LoadSubpackageTask", "success call");
                        }
                    }
                } else if (this.b.b != null) {
                    this.b.b.a();
                    if (v14.d) {
                        Log.i("LoadSubpackageTask", "fail call");
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755284040, "Lcom/repackage/v14;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755284040, "Lcom/repackage/v14;");
                return;
            }
        }
        d = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v14(r72 r72Var) {
        super(r72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r72Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = r72Var;
    }

    public final void D(boolean z) {
        r72 r72Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (r72Var = this.a) == null) {
            return;
        }
        r72Var.runOnJSThread(new b(this, z));
    }

    public final boolean E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.a == null) {
                return false;
            }
            String str2 = ul2.U().z() + t14.b().c(str, 2);
            String c = t14.b().c(str, 3);
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(c)) {
                return false;
            }
            this.a.Z(str2, c);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void F(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject) == null) {
            H();
            G(jsObject);
            if (TextUtils.isEmpty(this.c)) {
                if (d) {
                    Log.i("LoadSubpackageTask", IActiveUploadListener.PARAM_ERR_MSG);
                }
                a14.j(this.c, 2111, "");
                return;
            }
            u14.a(this.c, new a(this));
        }
    }

    public final void G(JsObject jsObject) {
        os1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsObject) == null) || jsObject == null || (F = os1.F(jsObject)) == null) {
            return;
        }
        this.b = ou3.e(F);
        try {
            this.c = F.g("name");
        } catch (JSTypeMismatchException e) {
            if (d) {
                e.printStackTrace();
            }
            s24.d(this.a, e);
            H();
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b = null;
            this.c = null;
        }
    }
}
