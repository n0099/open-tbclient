package d.a.p0.m2.i.a;

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
import d.a.c.e.p.l;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60318a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.r.s.a f60319b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60320c;

    /* renamed from: d  reason: collision with root package name */
    public View f60321d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f60322e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60323f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60324g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60325h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f60326i;

    /* renamed from: d.a.p0.m2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1545a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f60327e;

        public View$OnClickListenerC1545a(a aVar) {
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
            this.f60327e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f60327e.f60319b == null) {
                return;
            }
            this.f60327e.f60319b.dismiss();
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
        this.f60326i = new View$OnClickListenerC1545a(this);
        this.f60318a = tbPageContext;
        this.f60320c = d.a.o0.r.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f60318a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f60321d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
            this.f60322e = tbImageView;
            e(tbImageView);
            this.f60322e.setAutoChangeStyle(true);
            this.f60322e.setRadius(l.g(this.f60318a.getPageActivity(), R.dimen.tbds24));
            this.f60322e.setConrers(3);
            this.f60322e.setIsBitmapPic(true);
            this.f60323f = (TextView) this.f60321d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
            this.f60324g = (TextView) this.f60321d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f60321d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
            this.f60325h = textView;
            textView.setOnClickListener(this.f60326i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60320c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f60322e, R.drawable.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f60323f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f60324g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f60325h, R.color.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f60318a.getPageActivity()) - (l.g(this.f60318a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f60320c) {
            return;
        }
        this.f60320c = true;
        d.a.o0.r.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f60318a.getPageActivity());
        this.f60319b = aVar;
        aVar.setContentViewSize(1);
        this.f60319b.setCancelable(true);
        this.f60319b.setCanceledOnTouchOutside(false);
        this.f60319b.setContentView(this.f60321d);
        this.f60319b.create(this.f60318a).show();
    }
}
