package d.a.p0.v.d.g.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.f0.f;
import d.a.o0.r.q.b2;
import d.a.p0.v.d.g.d.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f64593a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f64594b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.v.d.g.d.c f64595c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f64596d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64597e;

    /* renamed from: f  reason: collision with root package name */
    public String f64598f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f64599g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f64600h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f64601i;
    public f j;
    public f.g k;

    /* renamed from: d.a.p0.v.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1766a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64602e;

        public C1766a(a aVar) {
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
            this.f64602e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f64602e.f64596d != null ? this.f64602e.f64596d.N() : false;
                if (this.f64602e.f64595c != null) {
                    if (!N) {
                        this.f64602e.f64595c.v();
                        return;
                    }
                    this.f64602e.f64596d.P();
                    this.f64602e.f64595c.i();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64603a;

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
            this.f64603a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f64603a.f64594b == null || this.f64603a.f64595c == null) {
                return;
            }
            this.f64603a.f64595c.d();
            this.f64603a.f64595c.g();
            this.f64603a.f64595c.p(this.f64603a.f64596d.J());
            this.f64603a.f64595c.l(this.f64603a.f64596d.K());
            this.f64603a.f64595c.m(this.f64603a.f64596d.M());
            if (this.f64603a.f64596d != null && this.f64603a.f64596d.getPn() == 0 && this.f64603a.f64595c.e() != null) {
                this.f64603a.f64595c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.f64603a.f64596d.J()) == 0) {
                this.f64603a.f64595c.u(this.f64603a.f64594b.getString(R.string.no_data_text), this.f64603a.f64601i, true);
                this.f64603a.f64595c.o(8);
                return;
            }
            this.f64603a.f64595c.h();
            this.f64603a.f64595c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f64603a.f64594b == null || this.f64603a.f64595c == null) {
                return;
            }
            this.f64603a.f64595c.d();
            this.f64603a.f64595c.g();
            d.a.p0.v.d.g.d.c cVar = this.f64603a.f64595c;
            if (TextUtils.isEmpty(str)) {
                str = this.f64603a.f64594b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.f64603a.f64601i, true);
            this.f64603a.f64595c.o(8);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64604e;

        public c(a aVar) {
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
            this.f64604e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f64604e.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.p0.v.d.g.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f64605a;

        public d(a aVar) {
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
            this.f64605a = aVar;
        }

        @Override // d.a.p0.v.d.g.d.f
        public void a(int i2, String str, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, b2Var) == null) {
                a aVar = this.f64605a;
                aVar.g(aVar.f64594b, b2Var, str);
            }
        }

        @Override // d.a.p0.v.d.g.d.f
        public void b(d.a.p0.v.d.g.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.f64605a.f64596d == null || cVar == null || StringUtils.isNull(cVar.f64589a)) {
                return;
            }
            this.f64605a.f64596d.setSortType(cVar.f64589a);
            this.f64605a.f64596d.setLat(cVar.f64590b);
            this.f64605a.f64596d.setLng(cVar.f64591c);
            this.f64605a.f64596d.T(cVar.f64592d);
            this.f64605a.f64596d.Q();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64606e;

        public e(a aVar) {
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
            this.f64606e = aVar;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f64606e.f64596d == null) {
                return;
            }
            this.f64606e.f64596d.Q();
        }
    }

    public a(TbPageContext tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64597e = false;
        this.f64599g = new C1766a(this);
        this.f64600h = new b(this);
        this.f64601i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.f64594b = tbPageContext;
        this.f64593a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f64596d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f64600h);
        d.a.p0.v.d.g.d.c cVar = new d.a.p0.v.d.g.d.c(this.f64594b);
        this.f64595c = cVar;
        cVar.n(this.j);
        this.f64595c.q(this.k);
        this.f64595c.r(this.f64599g);
        this.f64595c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64595c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, b2 b2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, b2Var, str) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", b2Var.g1().live_id);
        if (!StringUtils.isNull(this.f64598f)) {
            param.param("locate_type", this.f64598f);
        }
        TiebaStatic.log(param);
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            String userId = b2Var.H().getUserId();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            z = TextUtils.equals(userId, currentAccount);
            str2 = currentAccount;
        } else {
            str2 = "";
            z = false;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.fillWithInfoData(b2Var.g1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (b2 b2Var2 : this.f64596d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(b2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        d.a.p0.v.d.g.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f64595c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f64596d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f64596d = null;
            }
            d.a.p0.v.d.g.d.c cVar = this.f64595c;
            if (cVar != null) {
                cVar.k();
                this.f64595c = null;
            }
        }
    }

    public final AlaLiveInfoCoreData j(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(b2Var.g1());
            alaLiveInfoCoreData.userName = b2Var.H().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f64596d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f64597e = str.equals("16:9");
        }
        this.f64595c.s(this.f64593a, list, str2, str3, this.f64597e, false);
        this.f64596d.setEntryName(str2);
        this.f64596d.setLabelName(str3);
        this.f64596d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f64596d.S(this.f64597e);
        this.f64598f = str2;
    }
}
