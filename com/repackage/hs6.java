package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes6.dex */
public class hs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<?> a;
    public ph5 b;
    public c c;
    public final kh5 d;

    /* loaded from: classes6.dex */
    public class a implements kh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs6 a;

        public a(hs6 hs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs6Var;
        }

        @Override // com.repackage.kh5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) || date == null || this.a.a == null) {
                return;
            }
            if (date.getTime() > System.currentTimeMillis()) {
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e04);
                return;
            }
            long time = date.getTime() / 1000;
            if (this.a.c != null) {
                this.a.c.a(date, time);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements fh5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs6 a;

        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.b == null) {
                    return;
                }
                this.a.a.b.f();
            }
        }

        /* renamed from: com.repackage.hs6$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0653b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public View$OnClickListenerC0653b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a.b == null) {
                    return;
                }
                this.a.a.b.A();
                this.a.a.b.f();
            }
        }

        public b(hs6 hs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs6Var;
        }

        @Override // com.repackage.fh5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SkinManager.setBackgroundResource(view2, R.drawable.person_birthday_select_top_bg);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091837);
                textView.setOnClickListener(new a(this));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091836);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new View$OnClickListenerC0653b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(Date date, long j);
    }

    public hs6(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this);
        this.a = baseActivity;
    }

    public final fh5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (fh5) invokeV.objValue;
    }

    public void e(c cVar) {
        BaseActivity<?> baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (baseActivity = this.a) == null || baseActivity.isFinishing()) {
            return;
        }
        this.c = cVar;
        if (this.b == null) {
            dh5 dh5Var = new dh5(this.a, this.d);
            dh5Var.k(R.layout.obfuscated_res_0x7f0d06aa, d());
            dh5Var.p(new boolean[]{true, true, true, false, false, false});
            dh5Var.j(this.a.getString(R.string.obfuscated_res_0x7f0f0e6c), this.a.getString(R.string.obfuscated_res_0x7f0f0e69), this.a.getString(R.string.obfuscated_res_0x7f0f0e66), this.a.getString(R.string.obfuscated_res_0x7f0f0e67), this.a.getString(R.string.obfuscated_res_0x7f0f0e68), this.a.getString(R.string.obfuscated_res_0x7f0f0e6a));
            dh5Var.l(2.0f);
            dh5Var.b(false);
            dh5Var.i(SkinManager.getColor(R.color.CAM_X0206));
            dh5Var.m(SkinManager.getColor(R.color.CAM_X0105));
            dh5Var.n(SkinManager.getColor(R.color.CAM_X0109));
            dh5Var.d(SkinManager.getColor(R.color.black_alpha30));
            dh5Var.e(SkinManager.getColor(R.color.CAM_X0201));
            dh5Var.c(false);
            dh5Var.h((ViewGroup) this.a.findViewById(16908290));
            this.b = dh5Var.a();
        }
        this.b.u();
    }
}
