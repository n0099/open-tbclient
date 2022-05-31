package com.repackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.txt.SelectorTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.t31;
import com.repackage.v31;
import com.repackage.zz0;
/* loaded from: classes7.dex */
public class w31 extends t31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View i;
    public TextView j;
    public SelectorTextView k;
    public c l;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w31 a;

        public a(w31 w31Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w31Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w31Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.l.k == null) {
                return;
            }
            this.a.l.k.a(view2);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w31 a;

        public b(w31 w31Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w31Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w31Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.l.j == null) {
                return;
            }
            this.a.l.j.a(view2);
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends t31.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int g;
        public int h;
        public int i;
        public t31.c j;
        public t31.c k;

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

        public c A(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                super.q(i);
                return this;
            }
            return (c) invokeI.objValue;
        }

        @Override // com.repackage.t31.b, com.repackage.v31.a
        public v31 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                w31 w31Var = (w31) super.a();
                w31Var.p(this);
                return w31Var;
            }
            return (v31) invokeV.objValue;
        }

        @Override // com.repackage.v31.a
        public v31 f(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) ? new w31(context) : (v31) invokeL.objValue;
        }

        @Override // com.repackage.v31.a
        public /* bridge */ /* synthetic */ v31.a q(int i) {
            A(i);
            return this;
        }

        public c z(int i, t31.c cVar) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048580, this, i, cVar)) == null) {
                this.g = i;
                this.k = cVar;
                return this;
            }
            return (c) invokeIL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w31(Context context) {
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

    @Override // com.repackage.t31
    public View i(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.e).inflate(R.layout.obfuscated_res_0x7f0d05c8, viewGroup, false);
            this.i = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091af9);
            this.j = textView;
            textView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060846));
            SelectorTextView selectorTextView = (SelectorTextView) this.i.findViewById(R.id.obfuscated_res_0x7f091afa);
            this.k = selectorTextView;
            selectorTextView.setTextColor(getContext().getResources().getColor(R.color.obfuscated_res_0x7f060845));
            o();
            return this.i;
        }
        return (View) invokeL.objValue;
    }

    public final void o() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.l) == null) {
            return;
        }
        this.j.setText(this.e.getText(cVar.g));
        this.j.setOnClickListener(new a(this));
        if (this.l.h > 0) {
            this.k.setVisibility(0);
            this.k.setText(this.e.getText(this.l.h));
            this.k.setOnClickListener(new b(this));
        } else {
            this.k.setVisibility(8);
        }
        if (this.l.i > 0) {
            Drawable drawable = this.e.getResources().getDrawable(this.l.i);
            s41.c(getContext(), drawable);
            drawable.setBounds(0, 0, zz0.c.a(this.e, 12.0f), zz0.c.a(this.e, 12.0f));
            this.k.setCompoundDrawables(drawable, null, null, null);
        }
    }

    public void p(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.l = cVar;
        }
    }
}
