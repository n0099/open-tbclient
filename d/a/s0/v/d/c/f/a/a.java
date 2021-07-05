package d.a.s0.v.d.c.f.a;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.v.d.c.f.d.i;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.s0.v.d.c.f.a.b f67540a;

    /* renamed from: b  reason: collision with root package name */
    public c f67541b;

    /* renamed from: c  reason: collision with root package name */
    public g f67542c;

    /* renamed from: d  reason: collision with root package name */
    public f f67543d;

    /* renamed from: e  reason: collision with root package name */
    public d f67544e;

    /* renamed from: f  reason: collision with root package name */
    public e f67545f;

    /* renamed from: g  reason: collision with root package name */
    public List<d.a.c.k.e.a> f67546g;

    /* renamed from: d.a.s0.v.d.c.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1796a implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f67547a;

        public C1796a(a aVar, TbPageContext tbPageContext) {
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
            this.f67547a = tbPageContext;
        }

        @Override // d.a.s0.v.d.c.f.d.i
        public void a(d.a.s0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null) {
                return;
            }
            if (cVar.getThreadData().g1() != null && cVar.getThreadData().g1().mYyExtData != null) {
                AlaInfoData g1 = cVar.getThreadData().g1();
                TbPageContext tbPageContext = this.f67547a;
                YyExtData yyExtData = g1.mYyExtData;
                String str = yyExtData.mSid;
                String str2 = yyExtData.mSsid;
                String str3 = yyExtData.mTemplateId;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, str, str2, str3, "" + g1.roomId, YYLiveUtil.SOURCE_HOME_LIVE_TAB_FOLLOW_CARD);
                return;
            }
            d.a.s0.v.d.c.c.i(this.f67547a.getPageActivity(), cVar.getThreadData());
        }
    }

    /* loaded from: classes9.dex */
    public class b implements i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbPageContext f67548a;

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
            this.f67548a = tbPageContext;
        }

        @Override // d.a.s0.v.d.c.f.d.i
        public void a(d.a.s0.v.d.a.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null || cVar.getThreadData() == null || cVar.getThreadData().g1() == null || cVar.getThreadData().g1().mYyExtData == null) {
                return;
            }
            AlaInfoData g1 = cVar.getThreadData().g1();
            TbPageContext tbPageContext = this.f67548a;
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
        this.f67546g = new LinkedList();
        this.f67540a = new d.a.s0.v.d.c.f.a.b(tbPageContext);
        this.f67541b = new c(tbPageContext);
        this.f67542c = new g(tbPageContext);
        this.f67543d = new f(tbPageContext);
        this.f67544e = new d(tbPageContext);
        this.f67545f = new e(tbPageContext);
        this.f67541b.h0(new C1796a(this, tbPageContext));
        this.f67543d.h0(new b(this, tbPageContext));
        this.f67546g.add(this.f67540a);
        this.f67546g.add(this.f67541b);
        this.f67546g.add(this.f67542c);
        this.f67546g.add(this.f67543d);
        this.f67546g.add(this.f67544e);
        this.f67546g.add(this.f67545f);
    }

    public List<d.a.c.k.e.a> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67546g : (List) invokeV.objValue;
    }
}
