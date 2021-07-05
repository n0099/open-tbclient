package d.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.a;
import d.b.a.c1;
import d.b.a.v0;
/* loaded from: classes10.dex */
public final class m0 extends k0<com.bytedance.embedapplog.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public class a implements c1.b<com.bytedance.embedapplog.a, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(m0 m0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a.c1.b
        /* renamed from: b */
        public com.bytedance.embedapplog.a a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iBinder)) == null) ? a.AbstractBinderC0305a.a(iBinder) : (com.bytedance.embedapplog.a) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.a.c1.b
        /* renamed from: c */
        public String a(com.bytedance.embedapplog.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, aVar)) == null) {
                if (aVar == null) {
                    return null;
                }
                return aVar.c();
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0() {
        super("com.mdid.msa");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.b.a.k0, d.b.a.v0
    public v0.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            e(context, context.getPackageName());
            return super.b(context);
        }
        return (v0.a) invokeL.objValue;
    }

    @Override // d.b.a.k0
    public Intent d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public final void e(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.setAction("com.bun.msa.action.start.service");
            intent.putExtra("com.bun.msa.param.pkgname", str);
            try {
                intent.putExtra("com.bun.msa.param.runinset", true);
                context.startService(intent);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.b.a.k0
    public c1.b<com.bytedance.embedapplog.a, String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (c1.b) invokeV.objValue;
    }
}
