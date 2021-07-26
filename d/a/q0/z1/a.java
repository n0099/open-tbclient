package d.a.q0.z1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a extends Animation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f67197e;

    /* renamed from: f  reason: collision with root package name */
    public int f67198f;

    /* renamed from: g  reason: collision with root package name */
    public int f67199g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f67200h;

    public a(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (view == null) {
            return;
        }
        this.f67197e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f67198f = i3;
        } else {
            this.f67198f = this.f67197e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f67200h = layoutParams;
        this.f67199g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f67198f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), transformation}) == null) {
            super.applyTransformation(f2, transformation);
            if (f2 < 1.0f) {
                if (this.f67199g == 0) {
                    FrameLayout.LayoutParams layoutParams = this.f67200h;
                    int i2 = this.f67198f;
                    layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
                } else {
                    this.f67200h.bottomMargin = -((int) (this.f67198f * f2));
                }
                this.f67197e.requestLayout();
            } else if (this.f67199g == 0) {
                this.f67200h.bottomMargin = 0;
                this.f67197e.requestLayout();
                this.f67198f = this.f67197e.getMeasuredHeight();
            } else {
                this.f67200h.bottomMargin = -this.f67198f;
                this.f67197e.setVisibility(8);
                this.f67197e.requestLayout();
            }
        }
    }
}
