package com.repackage;

import android.content.Context;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
/* loaded from: classes6.dex */
public final class mw1 extends pv1<SimpleDraweeView, nw1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lw1 i;
    public SwanAppComponentContainerView j;
    public SimpleDraweeView k;

    /* loaded from: classes6.dex */
    public class a extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SimpleDraweeView b;
        public final /* synthetic */ mw1 c;

        public a(mw1 mw1Var, boolean z, SimpleDraweeView simpleDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mw1Var, Boolean.valueOf(z), simpleDraweeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mw1Var;
            this.a = z;
            this.b = simpleDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, th) == null) {
                super.onFailure(str, th);
                if (!this.a || this.c.i == null) {
                    return;
                }
                this.c.i.a(0, this.b, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageInfo, animatable) == null) {
                super.onFinalImageSet(str, (String) imageInfo, animatable);
                if (!this.a || this.c.i == null) {
                    return;
                }
                this.c.i.a(1, this.b, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mw1(@NonNull Context context, @NonNull nw1 nw1Var) {
        super(context, nw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, nw1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (qv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(4);
        this.j = new SwanAppComponentContainerView(context);
        this.k = new SimpleDraweeView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pv1, com.repackage.uv1, com.repackage.wv1
    @NonNull
    /* renamed from: Y */
    public zw1 k(@NonNull nw1 nw1Var, @NonNull nw1 nw1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, nw1Var, nw1Var2)) == null) {
            zw1 k = super.k(nw1Var, nw1Var2);
            if (nw1Var.u != nw1Var2.u) {
                k.b(9);
            }
            return k;
        }
        return (zw1) invokeLL.objValue;
    }

    public final BaseControllerListener<ImageInfo> Z(@NonNull SimpleDraweeView simpleDraweeView, @NonNull nw1 nw1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, simpleDraweeView, nw1Var)) == null) ? new a(this, nw1Var.u, simpleDraweeView) : (BaseControllerListener) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wv1
    @NonNull
    /* renamed from: a0 */
    public SimpleDraweeView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) ? this.k : (SimpleDraweeView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wv1
    /* renamed from: b0 */
    public void A(@NonNull SimpleDraweeView simpleDraweeView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, simpleDraweeView) == null) {
            super.A(simpleDraweeView);
            simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pv1
    /* renamed from: c0 */
    public void T(@NonNull SimpleDraweeView simpleDraweeView, @NonNull nw1 nw1Var, @NonNull zw1 zw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, simpleDraweeView, nw1Var, zw1Var) == null) {
            super.O(simpleDraweeView, nw1Var, zw1Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.pv1
    /* renamed from: d0 */
    public void U(@NonNull SimpleDraweeView simpleDraweeView, @NonNull nw1 nw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, simpleDraweeView, nw1Var) == null) {
            super.V(simpleDraweeView, nw1Var, Z(simpleDraweeView, nw1Var));
        }
    }

    public void e0(lw1 lw1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, lw1Var) == null) {
            this.i = lw1Var;
        }
    }

    @Override // com.repackage.wv1
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) ? this.j : (SwanAppComponentContainerView) invokeL.objValue;
    }
}
