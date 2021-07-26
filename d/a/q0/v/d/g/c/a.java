package d.a.q0.v.d.g.c;

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
import d.a.p0.s.f0.f;
import d.a.p0.s.q.b2;
import d.a.q0.v.d.g.d.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65238a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f65239b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.v.d.g.d.c f65240c;

    /* renamed from: d  reason: collision with root package name */
    public AlaNewSquareSubListModel f65241d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65242e;

    /* renamed from: f  reason: collision with root package name */
    public String f65243f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView.p f65244g;

    /* renamed from: h  reason: collision with root package name */
    public AlaNewSquareSubListModel.b f65245h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f65246i;
    public f j;
    public f.g k;

    /* renamed from: d.a.q0.v.d.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1769a implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65247e;

        public C1769a(a aVar) {
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
            this.f65247e = aVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean N = this.f65247e.f65241d != null ? this.f65247e.f65241d.N() : false;
                if (this.f65247e.f65240c != null) {
                    if (!N) {
                        this.f65247e.f65240c.v();
                        return;
                    }
                    this.f65247e.f65241d.P();
                    this.f65247e.f65240c.i();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AlaNewSquareSubListModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65248a;

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
            this.f65248a = aVar;
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f65248a.f65239b == null || this.f65248a.f65240c == null) {
                return;
            }
            this.f65248a.f65240c.d();
            this.f65248a.f65240c.g();
            this.f65248a.f65240c.p(this.f65248a.f65241d.J());
            this.f65248a.f65240c.l(this.f65248a.f65241d.K());
            this.f65248a.f65240c.m(this.f65248a.f65241d.M());
            if (this.f65248a.f65241d != null && this.f65248a.f65241d.getPn() == 0 && this.f65248a.f65240c.e() != null) {
                this.f65248a.f65240c.e().smoothScrollToPosition(0);
            }
            if (ListUtils.getCount(this.f65248a.f65241d.J()) == 0) {
                this.f65248a.f65240c.u(this.f65248a.f65239b.getString(R.string.no_data_text), this.f65248a.f65246i, true);
                this.f65248a.f65240c.o(8);
                return;
            }
            this.f65248a.f65240c.h();
            this.f65248a.f65240c.o(0);
        }

        @Override // com.baidu.tieba.ala.alasquare.subtablist.mvc.AlaNewSquareSubListModel.b
        public void onLoadError(int i2, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) || this.f65248a.f65239b == null || this.f65248a.f65240c == null) {
                return;
            }
            this.f65248a.f65240c.d();
            this.f65248a.f65240c.g();
            d.a.q0.v.d.g.d.c cVar = this.f65248a.f65240c;
            if (TextUtils.isEmpty(str)) {
                str = this.f65248a.f65239b.getString(R.string.no_data_text);
            }
            cVar.u(str, this.f65248a.f65246i, true);
            this.f65248a.f65240c.o(8);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65249e;

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
            this.f65249e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f65249e.k();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.v.d.g.d.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f65250a;

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
            this.f65250a = aVar;
        }

        @Override // d.a.q0.v.d.g.d.f
        public void a(int i2, String str, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, b2Var) == null) {
                a aVar = this.f65250a;
                aVar.g(aVar.f65239b, b2Var, str);
            }
        }

        @Override // d.a.q0.v.d.g.d.f
        public void b(d.a.q0.v.d.g.b.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || this.f65250a.f65241d == null || cVar == null || StringUtils.isNull(cVar.f65234a)) {
                return;
            }
            this.f65250a.f65241d.setSortType(cVar.f65234a);
            this.f65250a.f65241d.setLat(cVar.f65235b);
            this.f65250a.f65241d.setLng(cVar.f65236c);
            this.f65250a.f65241d.T(cVar.f65237d);
            this.f65250a.f65241d.Q();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f65251e;

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
            this.f65251e = aVar;
        }

        @Override // d.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f65251e.f65241d == null) {
                return;
            }
            this.f65251e.f65241d.Q();
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
        this.f65242e = false;
        this.f65244g = new C1769a(this);
        this.f65245h = new b(this);
        this.f65246i = new c(this);
        this.j = new d(this);
        this.k = new e(this);
        this.f65239b = tbPageContext;
        this.f65238a = z;
        AlaNewSquareSubListModel alaNewSquareSubListModel = new AlaNewSquareSubListModel(tbPageContext);
        this.f65241d = alaNewSquareSubListModel;
        alaNewSquareSubListModel.R(this.f65245h);
        d.a.q0.v.d.g.d.c cVar = new d.a.q0.v.d.g.d.c(this.f65239b);
        this.f65240c = cVar;
        cVar.n(this.j);
        this.f65240c.q(this.k);
        this.f65240c.r(this.f65244g);
        this.f65240c.t();
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65240c.f() : (View) invokeV.objValue;
    }

    public final void g(TbPageContext<?> tbPageContext, b2 b2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, b2Var, str) == null) || tbPageContext == null || b2Var == null || b2Var.H() == null || b2Var.h1() == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12116").param("obj_id", b2Var.h1().live_id);
        if (!StringUtils.isNull(this.f65243f)) {
            param.param("locate_type", this.f65243f);
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
        alaLiveInfoCoreData.fillWithInfoData(b2Var.h1());
        AlaLiveInfoListCoreData alaLiveInfoListCoreData = new AlaLiveInfoListCoreData();
        alaLiveInfoListCoreData.mLiveInfoList = new ArrayList();
        for (b2 b2Var2 : this.f65241d.L()) {
            alaLiveInfoListCoreData.mLiveInfoList.add(j(b2Var2));
        }
        Activity pageActivity = tbPageContext.getPageActivity();
        if (!"颜值".equals(str)) {
            str = null;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(pageActivity, alaLiveInfoCoreData, alaLiveInfoListCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_SQUARE_CATOGORY, str2, z, str, null)));
    }

    public void h(TbPageContext tbPageContext, int i2) {
        d.a.q0.v.d.g.d.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || (cVar = this.f65240c) == null) {
            return;
        }
        cVar.j(tbPageContext, i2);
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            AlaNewSquareSubListModel alaNewSquareSubListModel = this.f65241d;
            if (alaNewSquareSubListModel != null) {
                alaNewSquareSubListModel.onDestroy();
                this.f65241d = null;
            }
            d.a.q0.v.d.g.d.c cVar = this.f65240c;
            if (cVar != null) {
                cVar.k();
                this.f65240c = null;
            }
        }
    }

    public final AlaLiveInfoCoreData j(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b2Var)) == null) {
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(b2Var.h1());
            alaLiveInfoCoreData.userName = b2Var.H().getUserName();
            return alaLiveInfoCoreData;
        }
        return (AlaLiveInfoCoreData) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f65241d.Q();
        }
    }

    public void l(String str, String str2, String str3, List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048582, this, str, str2, str3, list) == null) || StringUtils.isNull(str2)) {
            return;
        }
        if (!StringUtils.isNull(str)) {
            this.f65242e = str.equals("16:9");
        }
        this.f65240c.s(this.f65238a, list, str2, str3, this.f65242e, false);
        this.f65241d.setEntryName(str2);
        this.f65241d.setLabelName(str3);
        this.f65241d.setSortType(ListUtils.isEmpty(list) ? "" : list.get(0));
        this.f65241d.S(this.f65242e);
        this.f65243f = str2;
    }
}
