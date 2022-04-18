package com.repackage;

import android.annotation.TargetApi;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
@TargetApi(18)
/* loaded from: classes6.dex */
public class ht8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public c f;
    public lt8 g;
    public jt8 h;
    public kt8 i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes6.dex */
    public class a extends lt8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht8 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ht8 ht8Var, Context context, String str, String str2, kt8 kt8Var, c cVar) {
            super(context, str, str2, kt8Var, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht8Var, context, str, str2, kt8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (String) objArr2[2], (kt8) objArr2[3], (c) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ht8Var;
        }

        @Override // com.repackage.lt8
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.j = true;
                this.f.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends jt8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht8 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ht8 ht8Var, Context context, String str, kt8 kt8Var, c cVar) {
            super(context, str, kt8Var, cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht8Var, context, str, kt8Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (String) objArr2[1], (kt8) objArr2[2], (c) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ht8Var;
        }

        @Override // com.repackage.jt8
        public void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.k = true;
                this.f.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void onGenFilterVideoFail(int i, String str);

        void onGenFilterVideoRecordError(int i, String str);

        void onGenFilterVideoSuccess(String str);
    }

    public ht8(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        this.a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.j && this.k && !this.l) {
            this.i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            lt8 lt8Var = this.g;
            if (lt8Var != null) {
                lt8Var.interrupt();
                this.g = null;
            }
            jt8 jt8Var = this.h;
            if (jt8Var != null) {
                jt8Var.interrupt();
                this.h = null;
            }
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.f != null) {
                File file = new File(this.c);
                if (file.exists() && file.length() > 0) {
                    this.f.onGenFilterVideoSuccess(this.c);
                } else {
                    this.f.onGenFilterVideoFail(223, "Err empty outputFile");
                }
            }
            this.e = false;
        }
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.f = cVar;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.e) {
            return;
        }
        this.e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
            c cVar = this.f;
            if (cVar != null) {
                cVar.onGenFilterVideoFail(com.kuaishou.weapon.un.w0.k, tl7.a(e));
            }
        }
        try {
            this.i = new kt8(this.c);
            a aVar = new a(this, this.a, this.b, this.d, this.i, this.f);
            this.g = aVar;
            aVar.start();
            b bVar = new b(this, this.a, this.b, this.i, this.f);
            this.h = bVar;
            bVar.start();
        } catch (Exception unused) {
        }
    }
}
