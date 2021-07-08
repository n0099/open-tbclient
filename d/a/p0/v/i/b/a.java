package d.a.p0.v.i.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadUserInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ala.AlaVideoContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.p0.a0.m;
import d.a.p0.v.i.d.c;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f64777e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f64778f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f64779g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64780h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f64781i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public b2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: d.a.p0.v.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1774a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64782e;

        public View$OnClickListenerC1774a(a aVar) {
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
            this.f64782e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64782e.o == null) {
                return;
            }
            this.f64782e.o.b(view, this.f64782e.m);
        }
    }

    public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new View$OnClickListenerC1774a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f64777e = inflate;
        this.f64778f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f64777e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f64779g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f64780h = (TextView) this.f64777e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f64777e.findViewById(R.id.ala_video_container);
        this.j = this.f64777e.findViewById(R.id.divider_below_reply_number_layout);
        this.f64781i = (ThreadCommentAndPraiseInfoLayout) this.f64777e.findViewById(R.id.text_bottom);
        this.l = this.f64777e.findViewById(R.id.divider_line);
        this.f64778f.setOnClickListener(this);
        this.f64781i.setOnClickListener(this);
        this.f64781i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64777e : (View) invokeV.objValue;
    }

    public final void d(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) {
            this.f64781i.onChangeSkinType();
            this.f64779g.h();
            this.k.o(TbadkCoreApplication.getInst().getSkinType());
            this.f64778f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (b2Var != null && m.k(b2Var.c0())) {
                SkinManager.setViewTextColor(this.f64780h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f64780h, R.color.CAM_X0105);
            }
        }
    }

    public void e() {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (b2Var = this.m) == null || b2Var.H() == null) {
            return;
        }
        f(this.m, this.n);
    }

    public void f(b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, b2Var, str) == null) || b2Var == null || b2Var.H() == null) {
            return;
        }
        this.m = b2Var;
        this.n = str;
        this.f64778f.setVisibility(0);
        this.f64779g.j(b2Var);
        if (this.f64779g.getHeaderImg() != null) {
            this.f64779g.getHeaderImg().setData(b2Var);
        }
        this.f64779g.setUserAfterClickListener(this.p);
        b2Var.J2(false, true);
        this.f64780h.setText(b2Var.b1());
        this.k.getController().d(b2Var, str, "", false);
        this.k.getController().c();
        this.f64781i.setReplyTimeVisible(false);
        this.f64781i.setNeedAddReplyIcon(true);
        this.f64781i.setIsBarViewVisible(false);
        this.f64781i.setCommentNumEnable(false);
        this.f64781i.setOnClickListener(this);
        this.f64781i.setLiveShareEnable(false);
        this.f64781i.setShareVisible(true);
        this.f64781i.setShowPraiseNum(true);
        this.f64781i.setNeedAddPraiseIcon(true);
        this.f64781i.setFrom(2);
        if (this.f64781i.setData(b2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(b2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f64781i == null || (threadUserInfoLayout = this.f64779g) == null) {
            return;
        }
        threadUserInfoLayout.setPageUniqueId(bdUniqueId);
    }

    public void h(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.o = cVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, view) == null) {
            if (view != this.f64778f && view != this.f64781i.getCommentContainer()) {
                if (view.getId() != R.id.video_container || (cVar = this.o) == null) {
                    return;
                }
                cVar.a(view, this.m);
                return;
            }
            b2 b2Var = this.m;
            if (b2Var != null) {
                m.a(b2Var.c0());
            }
            c cVar2 = this.o;
            if (cVar2 != null) {
                cVar2.a(view, this.m);
            }
        }
    }
}
