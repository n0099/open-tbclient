package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.editortools.imagetool.MultiImgToolView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v15 a;

        public a(v15 v15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = v15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            v15 v15Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (v15Var = this.a) == null) {
                return;
            }
            v15Var.L(new j15(14, -1, Boolean.TRUE));
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public static v15 a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, context, i)) == null) {
            o45 o45Var = new o45();
            MultiImgToolView multiImgToolView = (MultiImgToolView) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0244, (ViewGroup) null);
            multiImgToolView.l();
            if (multiImgToolView == null || multiImgToolView.getDragLayer() == null || multiImgToolView.getDragHorizonScrollView() == null || multiImgToolView.getMutiImageTips() == null) {
                return null;
            }
            multiImgToolView.setAsyncLocalImageLoader(o45Var);
            yi8 yi8Var = new yi8(context);
            yi8Var.e(multiImgToolView.getDragLayer());
            yi8Var.g(multiImgToolView.getDragHorizonScrollView());
            yi8Var.f(multiImgToolView.getDragHorizonScrollView());
            if (i > 1) {
                multiImgToolView.getDragHorizonScrollView().setAddView(b(context, multiImgToolView));
            } else {
                multiImgToolView.getDragHorizonScrollView().setCenterStart(true);
            }
            multiImgToolView.getDragHorizonScrollView().setOnSwapDataListener(multiImgToolView);
            multiImgToolView.getDragHorizonScrollView().setMaxItemNum(i);
            SkinManager.setViewTextColor(multiImgToolView.getMutiImageTips(), R.color.CAM_X0108, 1);
            return multiImgToolView;
        }
        return (v15) invokeLI.objValue;
    }

    public static View b(Context context, v15 v15Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, v15Var)) == null) {
            ImageView imageView = new ImageView(context);
            SkinManager.setImageResource(imageView, R.drawable.btn_add_photo_selector);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setClickable(true);
            imageView.setContentDescription(context.getString(R.string.obfuscated_res_0x7f0f00b8));
            int d = pi.d(context, 3.0f);
            imageView.setPadding(d, context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201) + d + pi.d(context, 1.0f), context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070207) + d, d);
            imageView.setOnClickListener(new a(v15Var));
            return imageView;
        }
        return (View) invokeLL.objValue;
    }
}
