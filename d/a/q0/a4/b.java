package d.a.q0.a4;

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
import d.a.q0.a4.q.d.a;
import d.a.q0.e0.c;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes7.dex */
public class b implements d.a.q0.e0.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.q0.a4.q.d.a f54631a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TransmitForumData> f54632b;

    /* renamed from: c  reason: collision with root package name */
    public List<SimpleForum> f54633c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f54634d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54635e;

    /* renamed from: f  reason: collision with root package name */
    public int f54636f;

    /* renamed from: g  reason: collision with root package name */
    public a.b f54637g;

    /* loaded from: classes7.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f54638a;

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
            this.f54638a = bVar;
        }

        @Override // d.a.q0.a4.q.d.a.b
        public void a(List<SimpleForum> list, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i2) == null) {
                this.f54638a.f54633c = list;
                this.f54638a.f54636f = i2;
                this.f54638a.h();
            }
        }

        @Override // d.a.q0.a4.q.d.a.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f54638a.g();
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
        this.f54632b = new ArrayList<>();
        this.f54637g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        d.a.q0.a4.q.d.a aVar = new d.a.q0.a4.q.d.a(gen);
        this.f54631a = aVar;
        aVar.i(this.f54637g);
        this.f54631a.j(gen);
    }

    @Override // d.a.q0.e0.c
    public void a(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.f54634d = aVar;
        }
    }

    @Override // d.a.q0.e0.c
    public void b() {
        d.a.q0.a4.q.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f54634d == null || (aVar = this.f54631a) == null) {
            return;
        }
        this.f54635e = false;
        aVar.l(null);
        this.f54631a.k(null);
        this.f54631a.h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f54635e) {
            return;
        }
        c.a aVar = this.f54634d;
        if (aVar != null) {
            aVar.a(null, false, 2, 0);
        }
        this.f54635e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f54632b.clear();
            if (ListUtils.getCount(this.f54633c) > 0) {
                for (SimpleForum simpleForum : this.f54633c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.f54632b.add(transmitForumData);
                    }
                }
            }
            c.a aVar = this.f54634d;
            if (aVar != null) {
                aVar.a(this.f54632b, true, 2, this.f54636f);
            }
        }
    }
}
