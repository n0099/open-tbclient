package d.a.r0.s.i;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f56614a;

    /* renamed from: b  reason: collision with root package name */
    public ImageViewerBottomLayout f56615b;

    /* renamed from: c  reason: collision with root package name */
    public AbsFloorImageTextView f56616c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f56617d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56618e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageViewerBottomLayout.a f56619f;

    /* renamed from: d.a.r0.s.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1277a implements ImageViewerBottomLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f56620a;

        public C1277a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56620a = aVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.ImageViewerBottomLayout.a
        public void a(ImageViewerBottomLayout imageViewerBottomLayout, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, imageViewerBottomLayout, z) == null) {
                this.f56620a.f56618e = z;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016496, Boolean.valueOf(this.f56620a.f56618e)));
                this.f56620a.q(z);
            }
        }
    }

    public a(@NonNull Context context, @NonNull RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, relativeLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56618e = true;
        this.f56619f = new C1277a(this);
        this.f56614a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f56617d = linearLayout;
        linearLayout.setOrientation(1);
        this.f56617d.setVisibility(8);
        SkinManager.setBackgroundColorToTransparent(this.f56617d, R.color.CAM_X0607, GradientDrawable.Orientation.BOTTOM_TOP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(this.f56617d, layoutParams);
        d();
        e();
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ImageViewerBottomLayout imageViewerBottomLayout = this.f56615b;
            if (imageViewerBottomLayout == null || this.f56616c == null) {
                return 0;
            }
            return imageViewerBottomLayout.getHeight() + AbsFloorImageTextView.m;
        }
        return invokeV.intValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            FloorImageTextViewNew floorImageTextViewNew = new FloorImageTextViewNew(this.f56614a);
            this.f56616c = floorImageTextViewNew;
            this.f56617d.addView(floorImageTextViewNew, layoutParams);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ImageViewerBottomLayout.v);
            ImageViewerBottomLayout imageViewerBottomLayout = new ImageViewerBottomLayout(this.f56614a);
            this.f56615b = imageViewerBottomLayout;
            this.f56617d.addView(imageViewerBottomLayout, layoutParams);
            this.f56615b.setExpandButtonListener(this.f56619f);
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f56618e : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? h(this.f56617d) : invokeV.booleanValue;
    }

    public final boolean h(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view)) == null) ? view != null && view.getVisibility() == 0 : invokeL.booleanValue;
    }

    public void i(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, imageUrlData) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.f56616c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.f(imageUrlData);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.f56615b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.d(imageUrlData);
            }
        }
    }

    public void j(ImageViewerBottomLayout.b bVar) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) || (imageViewerBottomLayout = this.f56615b) == null) {
            return;
        }
        imageViewerBottomLayout.setOnDownloadImageListener(bVar);
    }

    public void k(View.OnClickListener onClickListener) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onClickListener) == null) || (imageViewerBottomLayout = this.f56615b) == null) {
            return;
        }
        imageViewerBottomLayout.setOnReplyClickListener(onClickListener);
    }

    public void l(ImageViewerBottomLayout.c cVar) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) || (imageViewerBottomLayout = this.f56615b) == null) {
            return;
        }
        imageViewerBottomLayout.setOnShareImageListener(cVar);
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.f56616c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.setUserId(str);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.f56615b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.setUserId(str);
            }
        }
    }

    public void n(int i2) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (linearLayout = this.f56617d) == null) {
            return;
        }
        linearLayout.clearAnimation();
        this.f56617d.setVisibility(i2);
    }

    public void o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            if (i2 == 0) {
                d.a.s0.t3.a.c(this.f56617d, i3);
            } else {
                d.a.s0.t3.a.a(this.f56617d, i3);
            }
        }
    }

    public void p(boolean z) {
        ImageViewerBottomLayout imageViewerBottomLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (imageViewerBottomLayout = this.f56615b) == null) {
            return;
        }
        imageViewerBottomLayout.setYoungterCoverSomeView(z);
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            AbsFloorImageTextView absFloorImageTextView = this.f56616c;
            if (absFloorImageTextView != null) {
                absFloorImageTextView.e(z);
            }
            ImageViewerBottomLayout imageViewerBottomLayout = this.f56615b;
            if (imageViewerBottomLayout != null) {
                imageViewerBottomLayout.e(!z);
            }
        }
    }
}
