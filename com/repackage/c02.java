package com.repackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.res.ui.SelectorTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gz2;
import com.repackage.mz2;
/* loaded from: classes5.dex */
public class c02 extends gz2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View k;
    public TextView l;
    public SelectorTextView m;
    public c n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c02 a;

        public a(c02 c02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.n.k == null) {
                return;
            }
            this.a.n.k.a(view2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c02 a;

        public b(c02 c02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c02Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.n.j == null) {
                return;
            }
            this.a.n.j.a(view2);
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends gz2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int g;
        public int h;
        public int i;
        public gz2.c j;
        public gz2.c k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.repackage.mz2.a
        public /* bridge */ /* synthetic */ mz2.a U(int i) {
            g0(i);
            return this;
        }

        @Override // com.repackage.gz2.b, com.repackage.mz2.a
        public mz2 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c02 c02Var = (c02) super.c();
                c02Var.r(this);
                return c02Var;
            }
            return (mz2) invokeV.objValue;
        }

        public c e0(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                this.g = i;
                return this;
            }
            return (c) invokeI.objValue;
        }

        public c f0(int i, gz2.c cVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i, cVar)) == null) {
                this.g = i;
                this.k = cVar;
                return this;
            }
            return (c) invokeIL.objValue;
        }

        public c g0(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                super.U(i);
                return this;
            }
            return (c) invokeI.objValue;
        }

        @Override // com.repackage.mz2.a
        public mz2 h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) ? new c02(context) : (mz2) invokeL.objValue;
        }

        @Override // com.repackage.mz2.a
        public /* bridge */ /* synthetic */ mz2.a v(int i) {
            e0(i);
            return this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c02(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.gz2
    public View k(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.g).inflate(R.layout.obfuscated_res_0x7f0d00c9, viewGroup, false);
            this.k = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091b6a);
            this.l = textView;
            textView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603db));
            SelectorTextView selectorTextView = (SelectorTextView) this.k.findViewById(R.id.obfuscated_res_0x7f091b6b);
            this.m = selectorTextView;
            selectorTextView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603da));
            q();
            return this.k;
        }
        return (View) invokeL.objValue;
    }

    public final void q() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.n) == null) {
            return;
        }
        this.l.setText(this.g.getText(cVar.g));
        this.l.setOnClickListener(new a(this));
        if (this.n.h > 0) {
            this.m.setVisibility(0);
            this.m.setText(this.g.getText(this.n.h));
            this.m.setOnClickListener(new b(this));
        } else {
            this.m.setVisibility(8);
        }
        if (this.n.i > 0) {
            Drawable drawable = this.g.getResources().getDrawable(this.n.i);
            nd3.b(getContext(), drawable);
            drawable.setBounds(0, 0, zd3.f(this.g, 12.0f), zd3.f(this.g, 12.0f));
            this.m.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void r(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.n = cVar;
        }
    }
}
