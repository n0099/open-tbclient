package com.repackage;

import android.app.Activity;
import android.content.res.Resources;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ly2;
import com.repackage.wv3;
/* loaded from: classes7.dex */
public class vv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FullScreenFloatView a;

    /* loaded from: classes7.dex */
    public class a implements FullScreenFloatView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ vv3 b;

        public a(vv3 vv3Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vv3Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vv3Var;
            this.a = activity;
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.d(this.a);
            }
        }
    }

    public vv3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            FullScreenFloatView a2 = qx2.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.a = a2;
            a2.setFloatButtonText(activity.getString(R.string.obfuscated_res_0x7f0f016e));
            this.a.setFloatImageBackground(R.drawable.obfuscated_res_0x7f08015d);
            this.a.setAutoAttachEnable(false);
            this.a.setDragImageListener(new a(this, activity));
            this.a.setVisibility(0);
        }
    }

    public void c(wv3.c cVar, Activity activity) {
        az3 az3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, activity) == null) && activity != null && this.a == null) {
            if (uv3.f((cVar == null || (az3Var = cVar.c) == null) ? null : az3Var.f).b()) {
                b(activity);
            }
        }
    }

    public final void d(Activity activity) {
        hz2 L;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) || (L = hz2.L()) == null || L.X() == null) {
            return;
        }
        Resources resources = activity.getResources();
        String u = SwanInspectorEndpoint.v().u(resources);
        ly2.a aVar = new ly2.a(activity);
        aVar.V(resources.getString(R.string.obfuscated_res_0x7f0f01d4));
        aVar.x(u);
        aVar.n(new pe3());
        aVar.m(false);
        aVar.O(R.string.obfuscated_res_0x7f0f019b, null);
        aVar.X();
    }
}
