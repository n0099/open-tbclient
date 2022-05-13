package com.repackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cp7;
import java.util.List;
/* loaded from: classes6.dex */
public class fp7 extends cp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ op7 a;
        public final /* synthetic */ b b;
        public final /* synthetic */ int c;
        public final /* synthetic */ fp7 d;

        public a(fp7 fp7Var, op7 op7Var, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fp7Var, op7Var, bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fp7Var;
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
                this.d.g(this.b, this.a);
                this.d.d(this.a);
                fp7 fp7Var = this.d;
                cp7.a aVar = fp7Var.d;
                if (aVar != null) {
                    aVar.A0(fp7Var.a);
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
        public TbImageView b;
        public TextView c;

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
            this.b = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090f21);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f2f);
            int k = (mi.k(TbadkCoreApplication.getInst()) / 4) + mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            this.a.setLayoutParams(new LinearLayout.LayoutParams(k, k));
            int i3 = k / 3;
            this.b.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fp7(List<op7> list, Context context) {
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

    public final Bitmap f(Bitmap bitmap, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, bitmap, i)) == null) {
            if (bitmap == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            paint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        }
        return (Bitmap) invokeLI.objValue;
    }

    public final void g(b bVar, op7 op7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, op7Var) == null) {
            if (op7Var.g()) {
                TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0302).setShapeRadius(mi.f(this.b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0807).setShadowSide(ShadowDrawable.ALL).setShadowRadius(mi.f(this.b, R.dimen.tbds20)).setOffsetX(0).setOffsetY(mi.f(this.b, R.dimen.tbds10)).into(bVar.a);
                gs4 d = gs4.d(bVar.c);
                d.v(R.color.CAM_X0313);
                d.A(R.dimen.T_X06);
                if (bVar.b.getBdImage() == null || StringUtils.isNull(bVar.b.getBdImage().q())) {
                    return;
                }
                bVar.b.setImageBitmap(f(bVar.b.getBdImage().p(), -1));
                return;
            }
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0201).setShapeRadius(mi.f(this.b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(mi.f(this.b, R.dimen.tbds20)).setOffsetX(0).setOffsetY(mi.f(this.b, R.dimen.tbds10)).into(bVar.a);
            gs4 d2 = gs4.d(bVar.c);
            d2.v(R.color.CAM_X0105);
            d2.A(R.dimen.T_X06);
            bVar.b.setImageBitmap(null);
            bVar.b.setPlaceHolder(1);
            bVar.b.K(op7Var.a(), 25, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d04f3, viewGroup, false);
                bVar = new b(view2);
                view2.setTag(bVar);
            } else {
                bVar = (b) view2.getTag();
            }
            op7 op7Var = this.c.get(i);
            if (op7Var == null) {
                return view2;
            }
            bVar.c.setText(op7Var.b());
            g(bVar, op7Var);
            view2.setOnClickListener(new a(this, op7Var, bVar, i));
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
