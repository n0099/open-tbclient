package d.a.p0.f0;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.widget.NestedScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c extends d.a.p0.f0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public NestedScrollView f52580a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f52581b;

    /* renamed from: c  reason: collision with root package name */
    public TbImageView f52582c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f52583d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f52584e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f52585f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f52586g;

    /* renamed from: h  reason: collision with root package name */
    public int f52587h;

    /* renamed from: i  reason: collision with root package name */
    public Rect f52588i;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f52589e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52589e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52589e.a(-1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52587h = 0;
        this.f52588i = new Rect();
        this.f52580a = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.f52581b = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.f52582c = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.f52583d = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.f52584e = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.f52586g = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.f52585f = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        d.a.p0.s.f0.n.a aVar = new d.a.p0.s.f0.n.a();
        this.f52585f.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.f52585f.setTextSize(R.dimen.tbds42);
        this.f52585f.setConfig(aVar);
        this.f52585f.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (this.f52587h <= 0) {
                this.f52587h = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
            }
            NestedScrollView nestedScrollView = this.f52580a;
            if (nestedScrollView == null) {
                return;
            }
            if (i2 == 0) {
                nestedScrollView.post(new a(this));
            }
            if (this.f52580a.getLocalVisibleRect(this.f52588i)) {
                int i3 = this.f52588i.bottom;
                int abs = Math.abs(this.f52581b.getTop());
                int abs2 = i3 - Math.abs(this.f52581b.getBottom());
                ViewGroup.LayoutParams layoutParams = this.f52581b.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i4 = this.f52587h;
                    if (abs < i4) {
                        marginLayoutParams.topMargin = i4;
                        this.f52581b.setLayoutParams(marginLayoutParams);
                    } else if (abs == i4) {
                        if (abs2 > i4) {
                            marginLayoutParams.topMargin = i4 + ((abs2 - i4) / 2);
                            this.f52581b.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > i4) {
                        if (abs2 < i4) {
                            marginLayoutParams.topMargin = i4;
                        } else if (abs2 == i4) {
                            marginLayoutParams.topMargin = i4;
                        } else if (abs2 > i4) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.f52581b.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.attachedView : (View) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == null) {
            return;
        }
        this.f52585f.setText(str);
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str == null) {
                this.f52583d.setVisibility(8);
                return;
            }
            this.f52583d.setVisibility(0);
            this.f52583d.setText(str);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || str == null) {
            return;
        }
        this.f52584e.setText(str);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f52585f.setVisibility(0);
            this.f52584e.setVisibility(0);
            SkinManager.setViewTextColor(this.f52583d, R.color.CAM_X0109, 1);
        }
    }

    public void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            SkinManager.setImageResource(this.f52582c, R.drawable.new_pic_emotion_08);
            SkinManager.setViewTextColor(this.f52583d, R.color.CAM_X0109, 1, skinType);
            SkinManager.setViewTextColor(this.f52584e, R.color.CAM_X0107, 1, skinType);
            SkinManager.setBackgroundColor(this.attachedView, R.color.CAM_X0201);
            TBSpecificationBtn tBSpecificationBtn = this.f52585f;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.k();
            }
        }
    }

    @Override // d.a.p0.f0.a
    public void onViewAttached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onViewAttached();
            onChangeSkinType();
        }
    }

    @Override // d.a.p0.f0.a
    public void onViewDettached() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onViewDettached();
            this.f52582c.setImageResource(0);
        }
    }
}
