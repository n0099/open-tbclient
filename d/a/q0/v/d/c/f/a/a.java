package d.a.q0.v.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.v.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.v.d.c.f.a.b f64967a;

    /* renamed from: b  reason: collision with root package name */
    public c f64968b;

    /* renamed from: c  reason: collision with root package name */
    public g f64969c;

    /* renamed from: d  reason: collision with root package name */
    public f f64970d;

    /* renamed from: e  reason: collision with root package name */
    public d f64971e;

    /* renamed from: f  reason: collision with root package name */
    public e f64972f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.d.k.e.a> f64973g;

    /* renamed from: d.a.q0.v.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1757a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f64974a;

        public C1757a(a aVar, TbPageContext tbPageContext) {
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
            this.f64974a = tbPageContext;
        }

        @Override // d.a.q0.v.d.c.f.d.i
        public void a(d.a.q0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null) {
                return;
            }
            if (cVar.getThreadData().h1() != null && cVar.getThreadData().h1().mYyExtData != null) {
                AlaInfoData h1 = cVar.getThreadData().h1();
                TbPageContext tbPageContext = this.f64974a;
                YyExtData yyExtData = h1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + h1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            d.a.q0.v.d.c.c.i(this.f64974a.getPageActivity(), cVar.getThreadData());
        }
    }

    /* loaded from: classes8.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f64975a;

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
            this.f64975a = tbPageContext;
        }

        @Override // d.a.q0.v.d.c.f.d.i
        public void a(d.a.q0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null || cVar.getThreadData().h1() == null || cVar.getThreadData().h1().mYyExtData == null) {
                return;
            }
            AlaInfoData h1 = cVar.getThreadData().h1();
            TbPageContext tbPageContext = this.f64975a;
            YyExtData yyExtData = h1.mYyExtData;
            String str = yyExtData.mSid;
            String str2 = yyExtData.mSsid;
            String str3 = yyExtData.mTemplateId;
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + h1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_HEAD);
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
        this.f64973g = new LinkedList();
        this.f64967a = new d.a.q0.v.d.c.f.a.b(tbPageContext);
        this.f64968b = new c(tbPageContext);
        this.f64969c = new g(tbPageContext);
        this.f64970d = new f(tbPageContext);
        this.f64971e = new d(tbPageContext);
        this.f64972f = new e(tbPageContext);
        this.f64968b.g0(new C1757a(this, tbPageContext));
        this.f64970d.g0(new b(this, tbPageContext));
        this.f64973g.add(this.f64967a);
        this.f64973g.add(this.f64968b);
        this.f64973g.add(this.f64969c);
        this.f64973g.add(this.f64970d);
        this.f64973g.add(this.f64971e);
        this.f64973g.add(this.f64972f);
    }

    public List<d.a.d.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64973g : (List) invokeV.objValue;
    }
}
