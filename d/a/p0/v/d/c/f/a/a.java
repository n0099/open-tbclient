package d.a.p0.v.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.v.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.p0.v.d.c.f.a.b f64322a;

    /* renamed from: b  reason: collision with root package name */
    public c f64323b;

    /* renamed from: c  reason: collision with root package name */
    public g f64324c;

    /* renamed from: d  reason: collision with root package name */
    public f f64325d;

    /* renamed from: e  reason: collision with root package name */
    public d f64326e;

    /* renamed from: f  reason: collision with root package name */
    public e f64327f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.c.k.e.a> f64328g;

    /* renamed from: d.a.p0.v.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1754a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f64329a;

        public C1754a(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64329a = tbPageContext;
        }

        @Override // d.a.p0.v.d.c.f.d.i
        public void a(d.a.p0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null) {
                return;
            }
            if (cVar.getThreadData().g1() != null && cVar.getThreadData().g1().mYyExtData != null) {
                AlaInfoData g1 = cVar.getThreadData().g1();
                TbPageContext tbPageContext = this.f64329a;
                YyExtData yyExtData = g1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + g1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            d.a.p0.v.d.c.c.i(this.f64329a.getPageActivity(), cVar.getThreadData());
        }
    }

    /* loaded from: classes8.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f64330a;

        public b(a aVar, TbPageContext tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64330a = tbPageContext;
        }

        @Override // d.a.p0.v.d.c.f.d.i
        public void a(d.a.p0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null || cVar.getThreadData().g1() == null || cVar.getThreadData().g1().mYyExtData == null) {
                return;
            }
            AlaInfoData g1 = cVar.getThreadData().g1();
            TbPageContext tbPageContext = this.f64330a;
            YyExtData yyExtData = g1.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + g1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
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
        this.f64328g = new LinkedList();
        this.f64322a = new d.a.p0.v.d.c.f.a.b(tbPageContext);
        this.f64323b = new c(tbPageContext);
        this.f64324c = new g(tbPageContext);
        this.f64325d = new f(tbPageContext);
        this.f64326e = new d(tbPageContext);
        this.f64327f = new e(tbPageContext);
        this.f64323b.h0(new C1754a(this, tbPageContext));
        this.f64325d.h0(new b(this, tbPageContext));
        this.f64328g.add(this.f64322a);
        this.f64328g.add(this.f64323b);
        this.f64328g.add(this.f64324c);
        this.f64328g.add(this.f64325d);
        this.f64328g.add(this.f64326e);
        this.f64328g.add(this.f64327f);
    }

    public List<d.a.c.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64328g : (List) invokeV.objValue;
    }
}
