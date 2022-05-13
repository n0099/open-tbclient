package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cp7;
import java.util.List;
/* loaded from: classes5.dex */
public class dp7 extends cp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ op7 a;
        public final /* synthetic */ b b;
        public final /* synthetic */ int c;
        public final /* synthetic */ dp7 d;

        public a(dp7 dp7Var, op7 op7Var, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dp7Var, op7Var, bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dp7Var;
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
                this.d.f(this.b.c, this.a);
                this.d.d(this.a);
                dp7 dp7Var = this.d;
                cp7.a aVar = dp7Var.d;
                if (aVar != null) {
                    aVar.A0(dp7Var.a);
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

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ImageView a;
        public TextView b;
        public ImageView c;

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
            this.a = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f21);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f2f);
            this.c = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091cc5);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundResource(view2, R.drawable.bg_interest_item_selection);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp7(List<op7> list, Context context) {
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

    public final void f(ImageView imageView, op7 op7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, imageView, op7Var) == null) {
            if (op7Var.g()) {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.obfuscated_res_0x7f0805f4, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(imageView, R.drawable.obfuscated_res_0x7f0805d9, SvgManager.SvgResourceStateType.NORMAL);
            }
        }
    }

    @Override // com.repackage.cp7, android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<op7> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.cp7, android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // com.repackage.cp7, android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d04f1, viewGroup, false);
                bVar = new b(view2);
                view2.setTag(bVar);
            } else {
                bVar = (b) view2.getTag();
            }
            op7 op7Var = this.c.get(i);
            if (op7Var == null) {
                return view2;
            }
            if (op7Var.d() > 0) {
                SkinManager.setImageResource(bVar.a, op7Var.d());
            }
            bVar.b.setText(op7Var.f());
            f(bVar.c, op7Var);
            if (op7Var.g()) {
                this.a++;
            }
            view2.setOnClickListener(new a(this, op7Var, bVar, i));
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
