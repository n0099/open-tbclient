package d.a.q0.v.i.b;

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
import d.a.p0.s.q.b2;
import d.a.q0.a0.m;
import d.a.q0.v.i.d.c;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f65422e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f65423f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f65424g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f65425h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f65426i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public b2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: d.a.q0.v.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1777a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65427e;

        public View$OnClickListenerC1777a(a aVar) {
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
            this.f65427e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f65427e.o == null) {
                return;
            }
            this.f65427e.o.b(view, this.f65427e.m);
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
        this.p = new View$OnClickListenerC1777a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f65422e = inflate;
        this.f65423f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f65422e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f65424g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f65425h = (TextView) this.f65422e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f65422e.findViewById(R.id.ala_video_container);
        this.j = this.f65422e.findViewById(R.id.divider_below_reply_number_layout);
        this.f65426i = (ThreadCommentAndPraiseInfoLayout) this.f65422e.findViewById(R.id.text_bottom);
        this.l = this.f65422e.findViewById(R.id.divider_line);
        this.f65423f.setOnClickListener(this);
        this.f65426i.setOnClickListener(this);
        this.f65426i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65422e : (View) invokeV.objValue;
    }

    public final void d(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) {
            this.f65426i.onChangeSkinType();
            this.f65424g.h();
            this.k.o(TbadkCoreApplication.getInst().getSkinType());
            this.f65423f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (b2Var != null && m.k(b2Var.d0())) {
                SkinManager.setViewTextColor(this.f65425h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f65425h, R.color.CAM_X0105);
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
        this.f65423f.setVisibility(0);
        this.f65424g.j(b2Var);
        if (this.f65424g.getHeaderImg() != null) {
            this.f65424g.getHeaderImg().setData(b2Var);
        }
        this.f65424g.setUserAfterClickListener(this.p);
        b2Var.L2(false, true);
        this.f65425h.setText(b2Var.c1());
        this.k.getController().d(b2Var, str, "", false);
        this.k.getController().c();
        this.f65426i.setReplyTimeVisible(false);
        this.f65426i.setNeedAddReplyIcon(true);
        this.f65426i.setIsBarViewVisible(false);
        this.f65426i.setCommentNumEnable(false);
        this.f65426i.setOnClickListener(this);
        this.f65426i.setLiveShareEnable(false);
        this.f65426i.setShareVisible(true);
        this.f65426i.setShowPraiseNum(true);
        this.f65426i.setNeedAddPraiseIcon(true);
        this.f65426i.setFrom(2);
        if (this.f65426i.setData(b2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(b2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f65426i == null || (threadUserInfoLayout = this.f65424g) == null) {
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
            if (view != this.f65423f && view != this.f65426i.getCommentContainer()) {
                if (view.getId() != R.id.video_container || (cVar = this.o) == null) {
                    return;
                }
                cVar.a(view, this.m);
                return;
            }
            b2 b2Var = this.m;
            if (b2Var != null) {
                m.a(b2Var.d0());
            }
            c cVar2 = this.o;
            if (cVar2 != null) {
                cVar2.a(view, this.m);
            }
        }
    }
}
