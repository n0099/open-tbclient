package d.a.s0.m2.i.a;

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
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63555a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.r0.r.s.a f63556b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63557c;

    /* renamed from: d  reason: collision with root package name */
    public View f63558d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f63559e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63560f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63561g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f63562h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f63563i;

    /* renamed from: d.a.s0.m2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1589a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f63564e;

        public View$OnClickListenerC1589a(a aVar) {
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
            this.f63564e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f63564e.f63556b == null) {
                return;
            }
            this.f63564e.f63556b.dismiss();
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
        this.f63563i = new View$OnClickListenerC1589a(this);
        this.f63555a = tbPageContext;
        this.f63557c = d.a.r0.r.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View inflate = LayoutInflater.from(this.f63555a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
            this.f63558d = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
            this.f63559e = tbImageView;
            e(tbImageView);
            this.f63559e.setAutoChangeStyle(true);
            this.f63559e.setRadius(l.g(this.f63555a.getPageActivity(), R.dimen.tbds24));
            this.f63559e.setConrers(3);
            this.f63559e.setIsBitmapPic(true);
            this.f63560f = (TextView) this.f63558d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
            this.f63561g = (TextView) this.f63558d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
            TextView textView = (TextView) this.f63558d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
            this.f63562h = textView;
            textView.setOnClickListener(this.f63563i);
            d();
        }
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f63557c : invokeV.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SkinManager.setImageResource(this.f63559e, R.drawable.pic_person_center_dynamic_guide);
            SkinManager.setViewTextColor(this.f63560f, R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.f63561g, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f63562h, R.color.CAM_X0302);
        }
    }

    public final void e(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f63555a.getPageActivity()) - (l.g(this.f63555a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.f63557c) {
            return;
        }
        this.f63557c = true;
        d.a.r0.r.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f63555a.getPageActivity());
        this.f63556b = aVar;
        aVar.setContentViewSize(1);
        this.f63556b.setCancelable(true);
        this.f63556b.setCanceledOnTouchOutside(false);
        this.f63556b.setContentView(this.f63558d);
        this.f63556b.create(this.f63555a).show();
    }
}
