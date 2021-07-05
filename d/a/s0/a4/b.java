package d.a.s0.a4;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.a4.q.d.a;
import d.a.s0.e0.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes9.dex */
public class b implements d.a.s0.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.s0.a4.q.d.a f57342a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f57343b;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f57344c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f57345d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57346e;

    /* renamed from: f  reason: collision with root package name */
    public int f57347f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f57348g;

    /* loaded from: classes9.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f57349a;

        public a(b bVar) {
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
            this.f57349a = bVar;
        }

        @Override // d.a.s0.a4.q.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
                this.f57349a.f57344c = list;
                this.f57349a.f57347f = i2;
                this.f57349a.h();
            }
        }

        @Override // d.a.s0.a4.q.d.a.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f57349a.g();
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57343b = new ArrayList<>();
        this.f57348g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        d.a.s0.a4.q.d.a aVar = new d.a.s0.a4.q.d.a(gen);
        this.f57342a = aVar;
        aVar.i(this.f57348g);
        this.f57342a.j(gen);
    }

    @Override // d.a.s0.e0.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f57345d = aVar;
        }
    }

    @Override // d.a.s0.e0.c
    public void b() {
        d.a.s0.a4.q.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f57345d == null || (aVar = this.f57342a) == null) {
            return;
        }
        this.f57346e = false;
        aVar.l(null);
        this.f57342a.k(null);
        this.f57342a.h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f57346e) {
            return;
        }
        c.a aVar = this.f57345d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f57346e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f57343b.clear();
            if (ListUtils.getCount(this.f57344c) > 0) {
                for (SimpleForum simpleForum : this.f57344c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.f57343b.add(transmitForumData);
                    }
                }
            }
            c.a aVar = this.f57345d;
            if (aVar != null) {
                aVar.a(this.f57343b, true, 2, this.f57347f);
            }
        }
    }
}
