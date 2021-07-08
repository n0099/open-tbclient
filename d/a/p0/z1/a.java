package d.a.p0.z1;

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
    public View f66519e;

    /* renamed from: f  reason: collision with root package name */
    public int f66520f;

    /* renamed from: g  reason: collision with root package name */
    public int f66521g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f66522h;

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
        this.f66519e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f66520f = i3;
        } else {
            this.f66520f = this.f66519e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f66522h = layoutParams;
        this.f66521g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f66520f;
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
                if (this.f66521g == 0) {
                    FrameLayout.LayoutParams layoutParams = this.f66522h;
                    int i2 = this.f66520f;
                    layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
                } else {
                    this.f66522h.bottomMargin = -((int) (this.f66520f * f2));
                }
                this.f66519e.requestLayout();
            } else if (this.f66521g == 0) {
                this.f66522h.bottomMargin = 0;
                this.f66519e.requestLayout();
                this.f66520f = this.f66519e.getMeasuredHeight();
            } else {
                this.f66522h.bottomMargin = -this.f66520f;
                this.f66519e.setVisibility(8);
                this.f66519e.requestLayout();
            }
        }
    }
}
