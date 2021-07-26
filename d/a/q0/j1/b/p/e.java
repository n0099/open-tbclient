package d.a.q0.j1.b.p;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.f;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f59695a;

    /* renamed from: b  reason: collision with root package name */
    public View f59696b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59697c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59698d;

    /* renamed from: e  reason: collision with root package name */
    public TBSpecificationBtn f59699e;

    /* renamed from: f  reason: collision with root package name */
    public b f59700f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f59701g;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f59702e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59702e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == this.f59702e.f59699e.getId()) {
                    d.a.p0.t.h.a.c(this.f59702e.f59695a);
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 1));
                } else if (view.getId() == this.f59702e.f59697c.getId()) {
                    d.a.p0.s.d0.b.j().w("key_im_open_notification_close_time", System.currentTimeMillis());
                    if (this.f59702e.f59700f != null) {
                        this.f59702e.f59700f.onClose();
                    }
                    TiebaStatic.log(new StatisticItem("c13705").param("obj_type", 2));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void onClose();
    }

    public e(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59701g = new a(this);
        this.f59695a = fVar;
        View inflate = LayoutInflater.from(fVar.getPageActivity()).inflate(R.layout.open_notification_view, (ViewGroup) null);
        this.f59696b = inflate;
        ImageView imageView = (ImageView) inflate.findViewById(R.id.img_close);
        this.f59697c = imageView;
        imageView.setOnClickListener(this.f59701g);
        this.f59698d = (TextView) this.f59696b.findViewById(R.id.open_desc);
        this.f59699e = (TBSpecificationBtn) this.f59696b.findViewById(R.id.btn_open);
        this.f59699e.setConfig(new d.a.p0.s.f0.n.b());
        this.f59699e.setText(fVar.getString(R.string.go_to_open));
        this.f59699e.setOnClickListener(this.f59701g);
        TiebaStatic.log("c13704");
        f(TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59696b : (View) invokeV.objValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f59696b, R.color.CAM_X0206);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59697c, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SkinManager.setViewTextColor(this.f59698d, R.color.CAM_X0107);
        }
    }

    public void g(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f59700f = bVar;
        }
    }
}
