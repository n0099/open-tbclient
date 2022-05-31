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
public class qq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseActivity<?> a;
    public pf5 b;
    public c c;
    public final kf5 d;

    /* loaded from: classes6.dex */
    public class a implements kf5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qq6 a;

        public a(qq6 qq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qq6Var;
        }

        @Override // com.repackage.kf5
        public void a(Date date, View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, date, view2) == null) || date == null || this.a.a == null) {
                return;
            }
            if (date.getTime() > System.currentTimeMillis()) {
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0e06);
                return;
            }
            long time = date.getTime() / 1000;
            if (this.a.c != null) {
                this.a.c.a(date, time);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ff5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qq6 a;

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

        /* renamed from: com.repackage.qq6$b$b  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class View$OnClickListenerC0505b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public View$OnClickListenerC0505b(b bVar) {
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
                this.a.a.b.B();
                this.a.a.b.f();
            }
        }

        public b(qq6 qq6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qq6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qq6Var;
        }

        @Override // com.repackage.ff5
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                SkinManager.setBackgroundResource(view2, R.drawable.person_birthday_select_top_bg);
                TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09179c);
                textView.setOnClickListener(new a(this));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1, TbadkCoreApplication.getInst().getSkinType());
                TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09179b);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0302, 1, TbadkCoreApplication.getInst().getSkinType());
                textView2.setOnClickListener(new View$OnClickListenerC0505b(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(Date date, long j);
    }

    public qq6(BaseActivity<?> baseActivity) {
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

    public final ff5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new b(this) : (ff5) invokeV.objValue;
    }

    public void e(c cVar) {
        BaseActivity<?> baseActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || (baseActivity = this.a) == null || baseActivity.isFinishing()) {
            return;
        }
        this.c = cVar;
        if (this.b == null) {
            df5 df5Var = new df5(this.a, this.d);
            df5Var.k(R.layout.obfuscated_res_0x7f0d068f, d());
            df5Var.p(new boolean[]{true, true, true, false, false, false});
            df5Var.j(this.a.getString(R.string.obfuscated_res_0x7f0f0e6b), this.a.getString(R.string.obfuscated_res_0x7f0f0e68), this.a.getString(R.string.obfuscated_res_0x7f0f0e65), this.a.getString(R.string.obfuscated_res_0x7f0f0e66), this.a.getString(R.string.obfuscated_res_0x7f0f0e67), this.a.getString(R.string.obfuscated_res_0x7f0f0e69));
            df5Var.l(2.0f);
            df5Var.b(false);
            df5Var.i(SkinManager.getColor(R.color.CAM_X0206));
            df5Var.m(SkinManager.getColor(R.color.CAM_X0105));
            df5Var.n(SkinManager.getColor(R.color.CAM_X0109));
            df5Var.d(SkinManager.getColor(R.color.black_alpha30));
            df5Var.e(SkinManager.getColor(R.color.CAM_X0201));
            df5Var.c(false);
            df5Var.h((ViewGroup) this.a.findViewById(16908290));
            this.b = df5Var.a();
        }
        this.b.v();
    }
}
