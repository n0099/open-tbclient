package d.a.o0.a.e0;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h;
import d.a.o0.a.z1.b.b.h;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f44483a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.e0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class DialogInterface$OnClickListenerC0673a implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f44484e;

        public DialogInterface$OnClickListenerC0673a(d.a.o0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44484e = eVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                SwanAppActivity x = this.f44484e.x();
                if (x != null && Build.VERSION.SDK_INT >= 21) {
                    x.finishAndRemoveTask();
                }
                System.exit(0);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f44483a : invokeV.booleanValue;
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            f44483a = z;
        }
    }

    public static void c(Context context, boolean z) {
        d.a.o0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65538, null, context, z) == null) || (i2 = d.a.o0.a.a2.e.i()) == null) {
            return;
        }
        b.c(z);
        int i3 = z ? h.aiapps_open_debug : h.aiapps_close_debug;
        h.a aVar = new h.a(context);
        aVar.V(context.getString(d.a.o0.a.h.aiapps_debug_switch_title));
        aVar.x(context.getString(i3));
        aVar.n(new d.a.o0.a.w2.h.a());
        aVar.m(false);
        aVar.O(d.a.o0.a.h.aiapps_confirm, new DialogInterface$OnClickListenerC0673a(i2));
        aVar.X();
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            c(context, !a());
        }
    }
}
