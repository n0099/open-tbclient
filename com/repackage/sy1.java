package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oy2;
import java.io.File;
/* loaded from: classes7.dex */
public class sy1 extends ny1 implements oy2.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oy2 F0;
    public View G0;
    public String H0;

    /* loaded from: classes7.dex */
    public class a implements ae3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy1 a;

        public a(sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.H0 = str;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sy1 a;

        public b(sy1 sy1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sy1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.Z2();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ae3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ sy1 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c cVar = this.a;
                    cVar.b.setText(cVar.a.toString());
                }
            }
        }

        public c(sy1 sy1Var, StringBuilder sb, TextView textView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sy1Var, sb, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sy1Var;
            this.a = sb;
            this.b = textView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c.H0 = str;
                this.a.append(str);
                bd3.a0(new a(this));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755304314, "Lcom/repackage/sy1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755304314, "Lcom/repackage/sy1;");
                return;
            }
        }
        boolean z = rf1.a;
    }

    public sy1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Nullable
    public static File W2() {
        InterceptResult invokeV;
        String x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            hz2 a0 = hz2.a0();
            if (a0 == null || (x = p63.x(a0.getAppId())) == null) {
                return null;
            }
            return new File(x, "running_info_share_cache");
        }
        return (File) invokeV.objValue;
    }

    public static sy1 Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new sy1() : (sy1) invokeV.objValue;
    }

    @Override // com.repackage.ny1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            oy2 oy2Var = this.F0;
            return oy2Var != null && oy2Var.f();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ny1
    public void T1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            U1(view2);
            I2(false);
            s2(-1);
            B2(-16777216);
            u2(getContext().getResources().getString(R.string.obfuscated_res_0x7f0f1268));
            w2(true);
            a3();
        }
    }

    public final boolean V2() {
        InterceptResult invokeV;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            File W2 = W2();
            if (W2 == null || !W2.exists() || (listFiles = W2.listFiles()) == null) {
                return true;
            }
            for (File file : listFiles) {
                if (!kf4.L(file)) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void X2(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || hz2.a0() == null) {
            return;
        }
        TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091af2);
        textView.setTextIsSelectable(true);
        StringBuilder sb = new StringBuilder();
        sb.append(ac3.l(this.i0));
        sb.append("===== 启动信息 =====");
        sb.append("\n");
        if (!TextUtils.isEmpty(this.H0)) {
            sb.append(this.H0);
            textView.setText(sb.toString());
            return;
        }
        textView.setText(sb.toString());
        ac3.i(this.i0, new c(this, sb, textView));
    }

    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            oi2.o0().a(this.i0);
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TextView textView = new TextView(getContext());
            textView.setText(R.string.obfuscated_res_0x7f0f1267);
            textView.setTextColor(ContextCompat.getColor(getContext(), R.color.obfuscated_res_0x7f060244));
            textView.setOnClickListener(new b(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(15);
            layoutParams.addRule(11);
            layoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700f1);
            textView.setLayoutParams(layoutParams);
            this.l0.addView(textView);
        }
    }

    @Override // com.repackage.ny1
    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.ny1
    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.oy2.a
    public oy2 getFloatLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.F0 == null) {
                View view2 = this.G0;
                if (view2 == null) {
                    return null;
                }
                this.F0 = new oy2(this, (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09019e), 0);
            }
            return this.F0;
        }
        return (oy2) invokeV.objValue;
    }

    @Override // com.repackage.ny1
    public void i2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.repackage.ny1, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            G2(1);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.v0(bundle);
            this.H0 = null;
            ac3.i(this.i0, new a(this));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00c9, viewGroup, false);
            T1(inflate);
            X2(inflate);
            if (S1()) {
                inflate = V1(inflate);
            }
            View C1 = C1(inflate, this);
            this.G0 = C1;
            return C1;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.z0();
            if (V2()) {
                return;
            }
            hw1.b("SwanAppRunningInfoFragment", "分享中间文件删除失败。。。");
        }
    }
}
