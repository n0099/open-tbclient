package d.a.s0.v.i.b;

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
import d.a.r0.r.q.b2;
import d.a.s0.a0.m;
import d.a.s0.v.i.d.c;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f67995e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f67996f;

    /* renamed from: g  reason: collision with root package name */
    public ThreadUserInfoLayout f67997g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f67998h;

    /* renamed from: i  reason: collision with root package name */
    public ThreadCommentAndPraiseInfoLayout f67999i;
    public View j;
    public AlaVideoContainer k;
    public View l;
    public b2 m;
    public String n;
    public c o;
    public final View.OnClickListener p;

    /* renamed from: d.a.s0.v.i.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1816a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f68000e;

        public View$OnClickListenerC1816a(a aVar) {
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
            this.f68000e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f68000e.o == null) {
                return;
            }
            this.f68000e.o.b(view, this.f68000e.m);
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
        this.p = new View$OnClickListenerC1816a(this);
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.frs_ala_stage_live_item, (ViewGroup) null);
        this.f67995e = inflate;
        this.f67996f = (RelativeLayout) inflate.findViewById(R.id.layout_root);
        ThreadUserInfoLayout threadUserInfoLayout = (ThreadUserInfoLayout) this.f67995e.findViewById(R.id.card_frs_ala_video_user_info_layout);
        this.f67997g = threadUserInfoLayout;
        threadUserInfoLayout.setFrom(3);
        this.f67998h = (TextView) this.f67995e.findViewById(R.id.text_title);
        this.k = (AlaVideoContainer) this.f67995e.findViewById(R.id.ala_video_container);
        this.j = this.f67995e.findViewById(R.id.divider_below_reply_number_layout);
        this.f67999i = (ThreadCommentAndPraiseInfoLayout) this.f67995e.findViewById(R.id.text_bottom);
        this.l = this.f67995e.findViewById(R.id.divider_line);
        this.f67996f.setOnClickListener(this);
        this.f67999i.setOnClickListener(this);
        this.f67999i.getCommentContainer().setOnClickListener(this);
        this.k.setOnVideoClickListener(this);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67995e : (View) invokeV.objValue;
    }

    public final void d(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) {
            this.f67999i.onChangeSkinType();
            this.f67997g.h();
            this.k.o(TbadkCoreApplication.getInst().getSkinType());
            this.f67996f.setBackgroundDrawable(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0205));
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            if (b2Var != null && m.k(b2Var.c0())) {
                SkinManager.setViewTextColor(this.f67998h, R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.f67998h, R.color.CAM_X0105);
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
        this.f67996f.setVisibility(0);
        this.f67997g.j(b2Var);
        if (this.f67997g.getHeaderImg() != null) {
            this.f67997g.getHeaderImg().setData(b2Var);
        }
        this.f67997g.setUserAfterClickListener(this.p);
        b2Var.J2(false, true);
        this.f67998h.setText(b2Var.b1());
        this.k.getController().d(b2Var, str, "", false);
        this.k.getController().c();
        this.f67999i.setReplyTimeVisible(false);
        this.f67999i.setNeedAddReplyIcon(true);
        this.f67999i.setIsBarViewVisible(false);
        this.f67999i.setCommentNumEnable(false);
        this.f67999i.setOnClickListener(this);
        this.f67999i.setLiveShareEnable(false);
        this.f67999i.setShareVisible(true);
        this.f67999i.setShowPraiseNum(true);
        this.f67999i.setNeedAddPraiseIcon(true);
        this.f67999i.setFrom(2);
        if (this.f67999i.setData(b2Var)) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
        d(b2Var);
    }

    public void g(BdUniqueId bdUniqueId) {
        ThreadUserInfoLayout threadUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) || bdUniqueId == null || this.f67999i == null || (threadUserInfoLayout = this.f67997g) == null) {
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
            if (view != this.f67996f && view != this.f67999i.getCommentContainer()) {
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
