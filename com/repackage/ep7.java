package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cp7;
import java.util.List;
/* loaded from: classes6.dex */
public class ep7 extends cp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ op7 a;
        public final /* synthetic */ b b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ep7 d;

        public a(ep7 ep7Var, op7 op7Var, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep7Var, op7Var, bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ep7Var;
            this.a = op7Var;
            this.b = bVar;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                op7 op7Var = this.a;
                op7Var.l(!op7Var.g());
                ep7 ep7Var = this.d;
                b bVar = this.b;
                ep7Var.f(bVar.d, bVar.e, this.a);
                this.d.d(this.a);
                ep7 ep7Var2 = this.d;
                cp7.a aVar = ep7Var2.d;
                if (aVar != null) {
                    aVar.A0(ep7Var2.a);
                }
                if (this.a.g()) {
                    StatisticItem statisticItem = new StatisticItem("c13682");
                    statisticItem.param("obj_type", 2);
                    statisticItem.param("obj_locate", 1);
                    statisticItem.param("obj_source", this.c);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public HeadImageView b;
        public TextView c;
        public ImageView d;
        public View e;

        public b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090f2b);
            this.b = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f21);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f2f);
            this.d = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cc5);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f090f22);
            int k = mi.k(TbadkCoreApplication.getInst()) / 5;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(k, k);
            this.b.setLayoutParams(layoutParams);
            this.e.setLayoutParams(layoutParams);
        }

        public void a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
                gs4 d = gs4.d(this.c);
                d.v(R.color.CAM_X0105);
                d.z(R.dimen.T_X06);
                this.b.setConrers(15);
                this.b.setIsRound(true);
                this.b.setDrawBorder(true);
                this.b.setPlaceHolder(3);
                this.b.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
                this.b.setBorderWidth(mi.f(context, R.dimen.L_X02));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep7(List<op7> list, Context context) {
        super(list, context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((List) objArr2[0], (Context) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void f(ImageView imageView, View view2, op7 op7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, imageView, view2, op7Var) == null) {
            if (op7Var.g()) {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_checked);
                TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0608).into(view2);
                return;
            }
            SkinManager.setImageResource(imageView, R.drawable.icon_interest_unchecked);
            TBSelector.makeDrawableSelector().setShape(1).defaultColor(R.color.CAM_X0601).into(view2);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d04f2, viewGroup, false);
                bVar = new b(view2);
                view2.setTag(bVar);
            } else {
                bVar = (b) view2.getTag();
            }
            bVar.a(this.b);
            op7 op7Var = this.c.get(i);
            if (op7Var == null) {
                return view2;
            }
            bVar.b.K(op7Var.c(), 25, false);
            bVar.c.setText(op7Var.b());
            f(bVar.d, bVar.e, op7Var);
            view2.setOnClickListener(new a(this, op7Var, bVar, i));
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
