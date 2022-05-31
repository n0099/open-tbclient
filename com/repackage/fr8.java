package com.repackage;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.df;
/* loaded from: classes5.dex */
public class fr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public cf c;
    public Runnable d;
    public bf e;
    public final Handler f;
    public final Activity g;
    public final ViewGroup h;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr8 a;

        public a(fr8 fr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fr8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.e(this.a.h);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements df.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr8 a;

        public b(fr8 fr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fr8Var;
        }

        @Override // com.repackage.df.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c = null;
                this.a.f.removeCallbacks(this.a.d);
            }
        }

        @Override // com.repackage.df.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fr8 a;

        public c(fr8 fr8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fr8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fr8Var;
        }

        @Override // com.repackage.bf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.bf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.bf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                View inflate = LayoutInflater.from(this.a.g).inflate(R.layout.obfuscated_res_0x7f0d089a, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09207a);
                TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092079);
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0101);
                ((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f092074)).setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809cb, SkinManager.getColor(R.color.CAM_X0101), null));
                textView.setText(this.a.a);
                if (!StringUtils.isNull(this.a.b)) {
                    textView2.setText(this.a.b);
                } else {
                    textView2.setVisibility(8);
                }
                return inflate;
            }
            return (View) invokeL.objValue;
        }

        @Override // com.repackage.bf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.bf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    public fr8(Activity activity, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new Handler();
        this.g = activity;
        this.h = viewGroup;
    }

    public final bf i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new c(this) : (bf) invokeV.objValue;
    }

    public void j() {
        cf cfVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cfVar = this.c) == null) {
            return;
        }
        cfVar.e(this.h);
        this.h.setVisibility(8);
    }

    public fr8 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (fr8) invokeL.objValue;
    }

    public void l() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (viewGroup = this.h) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        cf cfVar = this.c;
        if (cfVar != null) {
            cfVar.e(this.h);
        }
        this.d = new a(this);
        df dfVar = new df();
        dfVar.d(true);
        dfVar.g(new b(this));
        if (this.e == null) {
            this.e = i();
        }
        dfVar.a(this.e);
        cf b2 = dfVar.b();
        this.c = b2;
        b2.s(this.g, this.h, false);
        this.f.postDelayed(this.d, 3000L);
    }
}
