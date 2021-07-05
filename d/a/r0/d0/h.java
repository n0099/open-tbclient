package d.a.r0.d0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final int f55207i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f55208a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f55209b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f55210c;

    /* renamed from: d  reason: collision with root package name */
    public TBSpecificationBtn f55211d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f55212e;

    /* renamed from: f  reason: collision with root package name */
    public int f55213f;

    /* renamed from: g  reason: collision with root package name */
    public int f55214g;

    /* renamed from: h  reason: collision with root package name */
    public int f55215h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1911042282, "Ld/a/r0/d0/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1911042282, "Ld/a/r0/d0/h;");
                return;
            }
        }
        f55207i = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds312);
        j = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds84);
        k = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
        l = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds32);
        m = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.net_refresh_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55208a = (ImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f55209b = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f55210c = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f55212e = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f55211d = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.a.r0.r.f0.m.a aVar = new d.a.r0.r.f0.m.a();
        this.f55211d.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f55211d.setTextSize(R.dimen.T_X05);
        this.f55211d.setConfig(aVar);
        this.f55213f = R.drawable.new_pic_emotion_08;
        this.f55214g = R.color.CAM_X0107;
        this.f55215h = R.color.CAM_X0109;
        this.f55211d.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
        k(0);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f55211d.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams = this.f55212e.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.topMargin = j;
                    this.f55212e.setLayoutParams(marginLayoutParams);
                }
                this.f55209b.setVisibility(8);
                this.f55214g = R.color.CAM_X0107;
            } else if (this.f55209b.getVisibility() == 8) {
                ViewGroup.LayoutParams layoutParams2 = this.f55212e.getLayoutParams();
                if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams2.topMargin = j;
                    this.f55212e.setLayoutParams(marginLayoutParams2);
                }
                this.f55214g = R.color.CAM_X0107;
            } else if (this.f55210c.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams3 = this.f55212e.getLayoutParams();
                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                    marginLayoutParams3.topMargin = l;
                    this.f55212e.setLayoutParams(marginLayoutParams3);
                }
                ViewGroup.LayoutParams layoutParams4 = this.f55210c.getLayoutParams();
                if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                    marginLayoutParams4.topMargin = m;
                    this.f55210c.setLayoutParams(marginLayoutParams4);
                }
                this.f55214g = R.color.CAM_X0107;
                this.f55215h = R.color.CAM_X0109;
            } else {
                ViewGroup.LayoutParams layoutParams5 = this.f55208a.getLayoutParams();
                int i2 = f55207i;
                layoutParams5.width = i2;
                layoutParams5.height = i2;
                this.f55208a.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.f55212e.getLayoutParams();
                if (layoutParams6 instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams6;
                    marginLayoutParams5.topMargin = k;
                    this.f55212e.setLayoutParams(marginLayoutParams5);
                }
                this.f55215h = R.color.CAM_X0109;
            }
            onChangeSkinType();
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.attachedView : (View) invokeV.objValue;
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f55211d : (View) invokeV.objValue;
    }

    public TextView d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f55210c : (TextView) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f55211d.setVisibility(8);
            this.f55210c.setVisibility(8);
            SkinManager.setViewTextColor(this.f55209b, R.color.CAM_X0109, 1);
            a();
        }
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            SkinManager.setBackgroundColor(this.attachedView, i2);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || str == null) {
            return;
        }
        this.f55211d.setText(str);
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f55213f = i2;
            SkinManager.setImageResource(this.f55208a, i2);
        }
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f55213f = i2;
        }
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            ViewGroup.LayoutParams layoutParams = this.f55208a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = i2;
                this.f55208a.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            int i3 = l.i(TbadkCoreApplication.getInst());
            int dimensionPixelSize = i3 <= 0 ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds200) : (int) (i3 * 0.16d);
            ViewGroup.LayoutParams layoutParams = this.f55208a.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = dimensionPixelSize + i2;
                this.f55208a.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            if (str == null) {
                this.f55209b.setVisibility(8);
            } else {
                this.f55209b.setVisibility(0);
                this.f55209b.setText(str);
            }
            a();
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, str) == null) || str == null) {
            return;
        }
        this.f55210c.setText(str);
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || str == null) {
            return;
        }
        this.f55210c.setText(str);
        this.f55210c.setVisibility(0);
        a();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f55211d.setVisibility(0);
            this.f55210c.setVisibility(0);
            SkinManager.setViewTextColor(this.f55209b, R.color.CAM_X0109, 1);
            a();
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f55208a, this.f55213f);
            SkinManager.setViewTextColor(this.f55209b, this.f55215h, 1, skinType);
            SkinManager.setViewTextColor(this.f55210c, this.f55214g, 1, skinType);
            TBSpecificationBtn tBSpecificationBtn = this.f55211d;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    @Override // d.a.r0.d0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // d.a.r0.d0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onViewDettached();
            this.f55208a.setImageResource(0);
        }
    }
}
