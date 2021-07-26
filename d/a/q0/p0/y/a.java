package d.a.q0.p0.y;

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
import d.a.d.e.p.l;
import d.a.p0.s.w.b.d;
import d.a.p0.s.w.b.e;
import d.a.q0.p0.y.c.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Pattern f61943a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f61944b;

    /* renamed from: c  reason: collision with root package name */
    public View f61945c;

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<d.a.p0.s.w.b.a> f61946d;

    /* renamed from: e  reason: collision with root package name */
    public c f61947e;

    /* renamed from: f  reason: collision with root package name */
    public d<d.a.p0.s.w.b.a> f61948f;

    /* renamed from: d.a.q0.p0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1592a extends d.a.p0.s.w.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61949a;

        public C1592a(a aVar) {
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
            this.f61949a = aVar;
        }

        @Override // d.a.p0.s.w.b.b, d.a.p0.s.w.a
        public d.a.p0.s.w.b.c a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                d.a.p0.s.w.b.c a2 = super.a();
                if (a2 != null) {
                    a2.d(81);
                    a2.e(R.dimen.ds20);
                }
                return a2;
            }
            return (d.a.p0.s.w.b.c) invokeV.objValue;
        }

        @Override // d.a.p0.s.w.b.b, d.a.p0.s.w.a
        public e c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                e eVar = new e();
                eVar.a((int) (l.k(this.f61949a.f61944b.getPageActivity()) / 2.5714285f));
                return eVar;
            }
            return (e) invokeV.objValue;
        }

        @Override // d.a.p0.s.w.b.b, d.a.p0.s.w.a
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

    /* loaded from: classes8.dex */
    public class b implements d<d.a.p0.s.w.b.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61950a;

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
            this.f61950a = aVar;
        }

        @Override // d.a.p0.s.w.b.d
        public void a(int i2, d.a.p0.s.w.b.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, aVar) == null) || aVar == null) {
                return;
            }
            boolean z = aVar instanceof c.a;
        }

        @Override // d.a.p0.s.w.b.d
        public void b(int i2, String str) {
            c.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || (aVar = (c.a) this.f61950a.f61946d.n(i2)) == null) {
                return;
            }
            Matcher matcher = this.f61950a.f61943a.matcher(aVar.b());
            if (matcher.find()) {
                this.f61950a.f61944b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(this.f61950a.f61944b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
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
        this.f61943a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");
        this.f61944b = null;
        this.f61946d = null;
        this.f61947e = null;
        this.f61948f = new b(this);
        this.f61944b = tbPageContext;
        d();
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f61945c : (View) invokeV.objValue;
    }

    public final void d() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbPageContext = this.f61944b) == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
        this.f61945c = inflate;
        if (inflate == null) {
            return;
        }
        this.f61946d = (CoverFlowView) inflate.findViewById(R.id.square_banner_cover_flow_view);
        C1592a c1592a = new C1592a(this);
        this.f61946d.setDisableParentEvent(false);
        this.f61946d.setCoverFlowFactory(c1592a);
        this.f61946d.setCallback(this.f61948f);
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null || cVar == this.f61947e) {
            return;
        }
        this.f61946d.setData(cVar.a());
        this.f61947e = cVar;
    }

    public void f(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bdUniqueId) != null) || bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<d.a.p0.s.w.b.a> coverFlowView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (coverFlowView = this.f61946d) == null) {
            return;
        }
        coverFlowView.v();
    }
}
