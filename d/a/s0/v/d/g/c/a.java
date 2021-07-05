package d.a.s0.v.d.g.c;

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
import d.a.r0.r.f0.f;
import d.a.r0.r.q.b2;
import d.a.s0.v.d.g.d.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67811a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f67812b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.s0.v.d.g.d.c f67813c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f67814d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67815e;

    /* renamed from: f  reason: collision with root package name */
    public String f67816f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f67817g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f67818h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f67819i;
    public f j;
    public f.g k;

    /* renamed from: d.a.s0.v.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1808a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67820e;

        public C1808a(a aVar) {
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
            this.f67820e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f67820e.f67814d != null ? this.f67820e.f67814d.N() : false;
                if (this.f67820e.f67813c != null) {
                    if (!N) {
                        this.f67820e.f67813c.v();
                        return;
                    }
                    this.f67820e.f67814d.P();
                    this.f67820e.f67813c.i();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67821a;

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
            this.f67821a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f67821a.f67812b == null || this.f67821a.f67813c == null) {
                return;
            }
            this.f67821a.f67813c.d();
            this.f67821a.f67813c.g();
            this.f67821a.f67813c.p(this.f67821a.f67814d.J());
            this.f67821a.f67813c.l(this.f67821a.f67814d.K());
            this.f67821a.f67813c.m(this.f67821a.f67814d.M());
            if (this.f67821a.f67814d != null && this.f67821a.f67814d.getPn() == 0 && this.f67821a.f67813c.e() != null) {
                this.f67821a.f67813c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.f67821a.f67814d.J()) == 0) {
                this.f67821a.f67813c.u(this.f67821a.f67812b.getString(R.string.no_data_text), this.f67821a.f67819i, true);
                this.f67821a.f67813c.o(8);
                return;
            }
            this.f67821a.f67813c.h();
            this.f67821a.f67813c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f67821a.f67812b == null || this.f67821a.f67813c == null) {
                return;
            }
            this.f67821a.f67813c.d();
            this.f67821a.f67813c.g();
            d.a.s0.v.d.g.d.c cVar = this.f67821a.f67813c;
            if (TextUtils.isEmpty(str)) {
                str = this.f67821a.f67812b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.f67821a.f67819i, true);
            this.f67821a.f67813c.o(8);
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67822e;

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
            this.f67822e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f67822e.k();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements d.a.s0.v.d.g.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67823a;

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
            this.f67823a = aVar;
        }

        @Override // d.a.s0.v.d.g.d.f
        public void a(int i2, String str, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, b2Var) == null) {
                a aVar = this.f67823a;
                aVar.g(aVar.f67812b, b2Var, str);
            }
        }

        @Override // d.a.s0.v.d.g.d.f
        public void b(d.a.s0.v.d.g.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.f67823a.f67814d == null || cVar == null || StringUtils.isNull(cVar.f67807a)) {
                return;
            }
            this.f67823a.f67814d.setSortType(cVar.f67807a);
            this.f67823a.f67814d.setLat(cVar.f67808b);
            this.f67823a.f67814d.setLng(cVar.f67809c);
            this.f67823a.f67814d.T(cVar.f67810d);
            this.f67823a.f67814d.Q();
        }
    }

    /* loaded from: classes9.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f67824e;

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
            this.f67824e = aVar;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f67824e.f67814d == null) {
                return;
            }
            this.f67824e.f67814d.Q();
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
        this.f67815e = false;
        this.f67817g = new C1808a(this);
        this.f67818h = new b(this);
        this.f67819i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.f67812b = tbPageContext;
        this.f67811a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f67814d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f67818h);
        d.a.s0.v.d.g.d.c cVar = new d.a.s0.v.d.g.d.c(this.f67812b);
        this.f67813c = cVar;
        cVar.n(this.j);
        this.f67813c.q(this.k);
        this.f67813c.r(this.f67817g);
        this.f67813c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67813c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, b2 b2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, b2Var, str) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", b2Var.g1().live_id);
        if (!StringUtils.isNull(this.f67816f)) {
            param.param("locate_type", this.f67816f);
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
        for (b2 b2Var2 : this.f67814d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(b2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        d.a.s0.v.d.g.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f67813c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f67814d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f67814d = null;
            }
            d.a.s0.v.d.g.d.c cVar = this.f67813c;
            if (cVar != null) {
                cVar.k();
                this.f67813c = null;
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
            this.f67814d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f67815e = str.equals("16:9");
        }
        this.f67813c.s(this.f67811a, list, str2, str3, this.f67815e, false);
        this.f67814d.setEntryName(str2);
        this.f67814d.setLabelName(str3);
        this.f67814d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f67814d.S(this.f67815e);
        this.f67816f = str2;
    }
}
