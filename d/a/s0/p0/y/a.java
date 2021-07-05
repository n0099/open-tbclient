package d.a.s0.p0.y;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.w.b.d;
import d.a.r0.r.w.b.e;
import d.a.s0.p0.y.c.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Pattern f64563a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f64564b;

    /* renamed from: c  reason: collision with root package name */
    public View f64565c;

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<d.a.r0.r.w.b.a> f64566d;

    /* renamed from: e  reason: collision with root package name */
    public c f64567e;

    /* renamed from: f  reason: collision with root package name */
    public d<d.a.r0.r.w.b.a> f64568f;

    /* renamed from: d.a.s0.p0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1631a extends d.a.r0.r.w.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64569a;

        public C1631a(a aVar) {
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
            this.f64569a = aVar;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public d.a.r0.r.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.r0.r.w.b.c a2 = super.a();
                if (a2 != null) {
                    a2.d(81);
                    a2.e(R.dimen.ds20);
                }
                return a2;
            }
            return (d.a.r0.r.w.b.c) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a((int) (l.k(this.f64569a.f64564b.getPageActivity()) / 2.5714285f));
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        @Override // d.a.r0.r.w.b.b, d.a.r0.r.w.a
        public TbImageView d(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
                TbImageView tbImageView = new TbImageView(context);
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                tbImageView.setGifIconSupport(false);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d<d.a.r0.r.w.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64570a;

        public b(a aVar) {
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
            this.f64570a = aVar;
        }

        @Override // d.a.r0.r.w.b.d
        public void a(int i2, d.a.r0.r.w.b.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || aVar == null) {
                return;
            }
            boolean z = aVar instanceof c.a;
        }

        @Override // d.a.r0.r.w.b.d
        public void b(int i2, String str) {
            c.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (aVar = (c.a) this.f64570a.f64566d.n(i2)) == null) {
                return;
            }
            Matcher matcher = this.f64570a.f64563a.matcher(aVar.b());
            if (matcher.find()) {
                this.f64570a.f64564b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f64570a.f64564b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
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
        this.f64563a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
        this.f64564b = null;
        this.f64566d = null;
        this.f64567e = null;
        this.f64568f = new b(this);
        this.f64564b = tbPageContext;
        d();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64565c : (View) invokeV.objValue;
    }

    public final void d() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f64564b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
        this.f64565c = inflate;
        if (inflate == null) {
            return;
        }
        this.f64566d = (CoverFlowView) inflate.findViewById(R.id.square_banner_cover_flow_view);
        C1631a c1631a = new C1631a(this);
        this.f64566d.setDisableParentEvent(false);
        this.f64566d.setCoverFlowFactory(c1631a);
        this.f64566d.setCallback(this.f64568f);
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null || cVar == this.f64567e) {
            return;
        }
        this.f64566d.setData(cVar.a());
        this.f64567e = cVar;
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<d.a.r0.r.w.b.a> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (coverFlowView = this.f64566d) == null) {
            return;
        }
        coverFlowView.v();
    }
}
