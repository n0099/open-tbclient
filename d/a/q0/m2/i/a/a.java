package d.a.q0.m2.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60932a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.s.s.a f60933b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60934c;

    /* renamed from: d  reason: collision with root package name */
    public View f60935d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f60936e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60937f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60938g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60939h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f60940i;

    /* renamed from: d.a.q0.m2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1550a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f60941e;

        public View$OnClickListenerC1550a(a aVar) {
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
            this.f60941e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f60941e.f60933b == null) {
                return;
            }
            this.f60941e.f60933b.dismiss();
        }
    }

    public a(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60940i = new View$OnClickListenerC1550a(this);
        this.f60932a = tbPageContext;
        this.f60934c = d.a.p0.s.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f60932a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f60935d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
            this.f60936e = tbImageView;
            e(tbImageView);
            this.f60936e.setAutoChangeStyle(true);
            this.f60936e.setRadius(l.g(this.f60932a.getPageActivity(), R.dimen.tbds24));
            this.f60936e.setConrers(3);
            this.f60936e.setIsBitmapPic(true);
            this.f60937f = (TextView) this.f60935d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
            this.f60938g = (TextView) this.f60935d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f60935d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
            this.f60939h = textView;
            textView.setOnClickListener(this.f60940i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60934c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f60936e, R.drawable.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f60937f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f60938g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60939h, R.color.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f60932a.getPageActivity()) - (l.g(this.f60932a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f60934c) {
            return;
        }
        this.f60934c = true;
        d.a.p0.s.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f60932a.getPageActivity());
        this.f60933b = aVar;
        aVar.setContentViewSize(1);
        this.f60933b.setCancelable(true);
        this.f60933b.setCanceledOnTouchOutside(false);
        this.f60933b.setContentView(this.f60935d);
        this.f60933b.create(this.f60932a).show();
    }
}
