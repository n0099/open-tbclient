package d.a.p0.h2.k.e.z0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.z0.l;
import d.a.p0.h2.h.e;
import d.a.p0.h2.k.e.o;
/* loaded from: classes8.dex */
public class a extends o<d.a.p0.h2.h.a, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.h2.k.e.z0.b s;
    public d.a.p0.h2.h.a t;
    public e u;
    public View.OnClickListener v;

    /* renamed from: d.a.p0.h2.k.e.z0.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1424a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f57535e;

        public View$OnClickListenerC1424a(a aVar) {
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
            this.f57535e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57535e.t == null || this.f57535e.t.f56879e == null || l.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(this.f57535e.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = this.f57535e;
            aVar.m0(aVar.t);
            if (this.f57535e.t.f56879e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) this.f57535e.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (this.f57535e.t.f56879e.a()) {
                this.f57535e.s.u(this.f57535e.t);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f57536a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f57537b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57538c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f57539d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57540e;

        /* renamed from: f  reason: collision with root package name */
        public View f57541f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f57542g;

        /* renamed from: d.a.p0.h2.k.e.z0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class View$OnClickListenerC1425a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f57543e;

            public View$OnClickListenerC1425a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57543e = bVar;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57543e.f57542g == null) {
                    return;
                }
                this.f57543e.f57542g.onClick(view);
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1424a view$OnClickListenerC1424a) {
            this(view);
        }

        public final void d(Context context, d.a.p0.h2.h.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) || bVar == null) {
                return;
            }
            this.f57540e.setText(bVar.f56883c);
            this.f57537b.M(bVar.f56882b, 38, false);
            this.f57536a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f56884d) + "%");
            int d2 = d.a.c.e.m.b.d(bVar.f56884d, 0);
            if (d2 > 100) {
                d2 = 100;
            } else if (d2 < 0) {
                d2 = 0;
            }
            this.f57539d.setProgress(d2);
            if (bVar.a()) {
                this.f57538c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f57538c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f57538c, R.drawable.btn_pb_ad_card_gift_get);
                this.f57538c.setClickable(true);
            } else if (bVar.b()) {
                this.f57538c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f57538c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f57538c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f57538c.setClickable(true);
            } else {
                this.f57538c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f57538c, R.color.CAM_X0109);
                this.f57538c.setBackgroundResource(R.drawable.transparent_bg);
                this.f57538c.setClickable(false);
            }
            e();
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SkinManager.setBackgroundResource(this.f57541f, R.drawable.bg_pb_ad_card_gift);
                SkinManager.setViewTextColor(this.f57540e, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f57536a, R.color.CAM_X0107);
                this.f57539d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
            }
        }

        public void f(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
                this.f57542g = onClickListener;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.f57541f = view.findViewById(R.id.bg_ad_card_gift);
            this.f57537b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.f57536a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f57538c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f57539d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f57540e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f57537b.setRadius(d.a.c.e.p.l.g(a().getContext(), R.dimen.tbds20));
            this.f57537b.setConrers(5);
            this.f57537b.setDefaultBgResource(R.color.cp_atp_a);
            this.f57537b.setDrawCorner(true);
            this.f57538c.setOnClickListener(new View$OnClickListenerC1425a(this));
            this.f57539d.setMax(100);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.p0.h2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = new View$OnClickListenerC1424a(this);
        this.s = new d.a.p0.h2.k.e.z0.b(pbFragment);
    }

    @Override // d.a.p0.h2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i2, view, viewGroup, (d.a.p0.h2.h.a) obj, (b) viewHolder);
        return view;
    }

    public final void m0(d.a.p0.h2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            d.a.p0.g3.c.g().c(this.n.getUniqueId(), d.a.p0.g3.a.e(this.u.N(), "a005", "common_click", 1, aVar.f56880f, true, aVar.f56879e.f56881a + "", null, 18));
        }
    }

    public void onDestroy() {
        d.a.p0.h2.k.e.z0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.s) == null) {
            return;
        }
        bVar.q();
    }

    public final void p0(d.a.p0.h2.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            String str = aVar.f56879e.f56881a + "";
            d.a.p0.g3.c.g().d(this.n.getUniqueId(), d.a.p0.g3.a.c(this.u.N().n1(), str, "", null), d.a.p0.g3.a.g(this.u.N(), "a005", "common_exp", aVar.f56880f, true, str, "", 18));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: q0 */
    public b Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            b bVar = new b(LayoutInflater.from(this.f41837e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
            bVar.f(this.v);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public View s0(int i2, View view, ViewGroup viewGroup, d.a.p0.h2.h.a aVar, b bVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, bVar})) == null) {
            super.X(i2, view, viewGroup, aVar, bVar);
            if (aVar != null && bVar != null) {
                aVar.f56880f = i2 + 1;
                this.t = aVar;
                p0(aVar);
                bVar.d(this.f41837e, aVar.f56879e);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void t(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.u = eVar;
            d.a.p0.h2.k.e.z0.b bVar = this.s;
            if (bVar != null) {
                bVar.v(eVar);
            }
        }
    }
}
