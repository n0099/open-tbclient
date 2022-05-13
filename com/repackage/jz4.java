package com.repackage;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView;
import com.baidu.tbadk.coreExtra.view.FloorImageTextViewNew;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jz4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public ImageViewerBottomLayout b;
    public AbsFloorImageTextView c;
    public LinearLayout d;
    public boolean e;
    public final ImageViewerBottomLayout.a f;

    /* loaded from: classes6.dex */
    public class a implements ImageViewerBottomLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jz4 a;

        public a(jz4 jz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jz4Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, imageViewerBottomLayout, z) == null) {
                this.a.e = z;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(this.a.e)));
                this.a.q(z);
            }
        }
    }

    public jz4(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = true;
        this.f = new a(this);
        this.a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.d = linearLayout;
        linearLayout.setOrientation(1);
        this.d.setVisibility(8);
        SkinManager.setBackgroundColorToTransparent(this.d, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.d, layoutParams);
        d();
        e();
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImageViewerBottomLayout imageViewerBottomLayout = this.b;
            if (imageViewerBottomLayout == null || this.c == null) {
                return 0;
            }
            return imageViewerBottomLayout.getHeight() + AbsFloorImageTextView.i;
        }
        return invokeV.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            FloorImageTextViewNew floorImageTextViewNew = new FloorImageTextViewNew(this.a);
            this.c = floorImageTextViewNew;
            this.d.addView(floorImageTextViewNew, layoutParams);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.r);
            ImageViewerBottomLayout imageViewerBottomLayout = new ImageViewerBottomLayout(this.a);
            this.b = imageViewerBottomLayout;
            this.d.addView(imageViewerBottomLayout, layoutParams);
            this.b.setExpandButtonListener(this.f);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h(this.d) : invokeV.booleanValue;
    }

    public final boolean h(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) ? view2 != null && view2.getVisibility() == 0 : invokeL.booleanValue;
    }

    public void i(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, imageUrlData) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.f(imageUrlData);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.d(imageUrlData);
            }
        }
    }

    public void j(ImageViewerBottomLayout.b bVar) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (imageViewerBottomLayout = this.b) == null) {
            return;
        }
        imageViewerBottomLayout.setOnDownloadImageListener(bVar);
    }

    public void k(View.OnClickListener onClickListener) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) || (imageViewerBottomLayout = this.b) == null) {
            return;
        }
        imageViewerBottomLayout.setOnReplyClickListener(onClickListener);
    }

    public void l(ImageViewerBottomLayout.c cVar) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || (imageViewerBottomLayout = this.b) == null) {
            return;
        }
        imageViewerBottomLayout.setOnShareImageListener(cVar);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.setUserId(str);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.setUserId(str);
            }
        }
    }

    public void n(int i) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i) == null) || (linearLayout = this.d) == null) {
            return;
        }
        linearLayout.clearAnimation();
        this.d.setVisibility(i);
    }

    public void o(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            if (i == 0) {
                cr8.c(this.d, i2);
            } else {
                cr8.a(this.d, i2);
            }
        }
    }

    public void p(boolean z) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (imageViewerBottomLayout = this.b) == null) {
            return;
        }
        imageViewerBottomLayout.setYoungterCoverSomeView(z);
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.e(z);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.e(!z);
            }
        }
    }
}
