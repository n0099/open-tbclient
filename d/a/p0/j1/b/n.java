package d.a.p0.j1.b;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.imMessageCenter.mention.ReplyMessageFragment;
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.w;
import d.a.c.k.e.x;
import d.a.o0.r.f0.f;
import d.a.o0.s.c.i0;
import d.a.p0.a0.b0;
import d.a.p0.j1.b.p.e;
import d.a.p0.u0.f2.a.c;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class n extends d.a.c.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.u0.f2.a.c A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;

    /* renamed from: a  reason: collision with root package name */
    public final ReplyMessageFragment f59023a;

    /* renamed from: b  reason: collision with root package name */
    public PbListView f59024b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f59025c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.j1.b.p.d f59026d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f59027e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f59028f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f59029g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f59030h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.r.f0.g f59031i;
    public d.a.p0.j1.b.p.e j;
    public boolean k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final f.g q;
    public RecyclerView.OnScrollListener r;
    public e.b s;
    public ReplyMeModel t;
    public d.a.o0.w.w.h u;
    public d.a.p0.j1.b.p.a v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes8.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f59032a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59032a = nVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) || this.f59032a.f59023a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f59032a.f59023a.getBaseFragmentActivity().hideProgressBar();
            this.f59032a.u.a().o();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.f59032a.l.setLikeUserData(this.f59032a.m);
                this.f59032a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            } else if (postWriteCallBackData == null || i0Var != null || AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) || postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278) {
            } else {
                this.f59032a.f59023a.showToast(postWriteCallBackData.getErrorString());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.o0.w.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f59033a;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59033a = nVar;
        }

        @Override // d.a.o0.w.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59033a.f59023a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f59033a.f59023a.getBaseFragmentActivity().showProgressBar();
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f59034e;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59034e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59034e.u == null || this.f59034e.u.s() == null) {
                return;
            }
            d.a.c.e.p.l.K(this.f59034e.getPageContext().getPageActivity(), this.f59034e.u.s().i());
        }
    }

    /* loaded from: classes8.dex */
    public class d implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f59035a;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59035a = nVar;
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
                this.f59035a.w = String.valueOf(j);
                this.f59035a.x = str;
                this.f59035a.y = j2;
                this.f59035a.z = j3;
                n nVar = this.f59035a;
                nVar.U(nVar.w, j4);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f59036a;

        public e(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59036a = nVar;
        }

        @Override // d.a.p0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.p0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f59036a.u == null || this.f59036a.u.v) {
                    this.f59036a.J(false);
                }
                if (this.f59036a.u == null || this.f59036a.v == null) {
                    return;
                }
                if (!this.f59036a.v.C() || this.f59036a.v.q() == null) {
                    this.f59036a.u.f0(null);
                } else {
                    this.f59036a.u.f0(this.f59036a.v.q().getName_show());
                }
            }
        }

        @Override // d.a.p0.u0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f59037a;

        public f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59037a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 != 0 && this.f59037a.u != null) {
                    this.f59037a.u.w();
                }
                super.onScrollStateChanged(recyclerView, i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f59038e;

        public g(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59038e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f59038e.f59024b == null || this.f59038e.f59023a == null) {
                return;
            }
            this.f59038e.f59024b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f59038e.f59024b.z(null);
            this.f59038e.f59024b.O();
            this.f59038e.f59023a.X0();
        }
    }

    /* loaded from: classes8.dex */
    public class h implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f59039e;

        public h(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59039e = nVar;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (d.a.c.e.p.j.z()) {
                    if (this.f59039e.f59023a != null) {
                        this.f59039e.f59023a.Z0();
                    }
                } else if (this.f59039e.f59027e != null) {
                    this.f59039e.f59027e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f59040a;

        public i(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59040a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f59040a.f59029g.c();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.f59040a.f59029g.c();
                } else {
                    this.f59040a.f59029g.a();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f59041a;

        public j(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59041a = nVar;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z && this.f59041a.u != null) {
                this.f59041a.u.D();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f59042b;

        public k(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59042b = nVar;
        }

        @Override // d.a.p0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            long f2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && view != null && (baseCardInfo instanceof d.a.p0.j1.b.p.a)) {
                d.a.p0.j1.b.p.a aVar = (d.a.p0.j1.b.p.a) baseCardInfo;
                if (aVar.B() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                    aVar.F(false);
                    this.f59042b.N();
                }
                if (view.getId() == R.id.message_bottom_reply_container) {
                    this.f59042b.v = aVar;
                    if (aVar.C()) {
                        f2 = d.a.c.e.m.b.f(aVar.p(), 0L);
                    } else {
                        f2 = d.a.c.e.m.b.f(aVar.o(), 0L);
                    }
                    long j = f2;
                    if (this.f59042b.m == null) {
                        this.f59042b.m = new AttentionHostData();
                    }
                    if (this.f59042b.v != null) {
                        this.f59042b.m.parserWithMetaData(this.f59042b.v.x());
                    }
                    this.f59042b.t.z(j, 2, aVar.d(), aVar.y(), this.f59042b.v != null ? this.f59042b.v.c() : null);
                    if (aVar.t() != null) {
                        StatisticItem param = new StatisticItem(aVar.t()).param("obj_locate", 3);
                        if (aVar.getType() == d.a.p0.j1.b.p.a.B) {
                            param.param("obj_type", 1);
                        } else {
                            param.param("obj_type", 2);
                        }
                        TiebaStatic.log(param);
                    }
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f59043e;

        public m(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59043e = nVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59043e.f59024b == null) {
                return;
            }
            this.f59043e.f59024b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f59043e.f59024b.z(null);
            this.f59043e.f59024b.L();
            this.f59043e.f59023a.X0();
        }
    }

    /* renamed from: d.a.p0.j1.b.n$n  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1498n implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f59044a;

        public C1498n(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59044a = nVar;
        }

        @Override // d.a.p0.j1.b.p.e.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59044a.j == null) {
                return;
            }
            this.f59044a.f59028f.removeHeaderView(this.f59044a.j.e());
            this.f59044a.o = false;
        }
    }

    /* loaded from: classes8.dex */
    public class o extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f59045e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(n nVar, d.a.c.a.f fVar) {
            super(fVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((d.a.c.a.f) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59045e = nVar;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean LoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData x(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                WriteData writeData = new WriteData();
                writeData.setForumId(this.f59045e.w);
                writeData.setForumName(this.f59045e.x);
                writeData.setThreadId(this.f59045e.v.y());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.f59045e.v.C()) {
                    writeData.setFloor(this.f59045e.y > 0 ? String.valueOf(this.f59045e.y) : this.f59045e.v.h().n);
                } else {
                    writeData.setFloor(this.f59045e.v.o());
                }
                if (this.f59045e.z > 0) {
                    writeData.setRepostId(String.valueOf(this.f59045e.z));
                }
                if (this.f59045e.v != null) {
                    writeData.setBaijiahaoData(this.f59045e.v.c());
                }
                writeData.setType(2);
                return writeData;
            }
            return (WriteData) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {replyMessageFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = R.color.CAM_X0204;
        this.o = false;
        this.p = new g(this);
        this.q = new h(this);
        this.r = new i(this);
        this.s = new C1498n(this);
        this.t = null;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new f(this);
        this.f59023a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new j(this));
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f59028f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f59023a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            d.a.p0.j1.b.p.e eVar = this.j;
            if (eVar != null) {
                this.f59028f.removeHeaderView(eVar.e());
                this.o = false;
                return;
            }
            return;
        }
        long l2 = d.a.o0.r.d0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.j == null) {
                d.a.p0.j1.b.p.e eVar2 = new d.a.p0.j1.b.p.e(this.f59023a.getPageContext());
                this.j = eVar2;
                eVar2.g(this.s);
            }
            this.f59028f.t(this.j.e(), 0);
            this.o = true;
        }
    }

    public void G(int i2) {
        d.a.p0.j1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (dVar = this.f59026d) == null) {
            return;
        }
        dVar.a(i2);
    }

    public BdSwipeRefreshLayout H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f59027e : (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void I(int i2, Intent intent) {
        d.a.o0.w.n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, intent) == null) {
            this.u.a().q();
            this.u.w();
            this.u.a().y();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.u.z(writeData);
                this.u.Y(pbEditorData.getVoiceModel());
                d.a.o0.w.m n = this.u.a().n(6);
                if (n != null && (nVar = n.k) != null) {
                    nVar.onAction(new d.a.o0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.u.D();
                }
            }
        }
    }

    public final void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            d.a.o0.w.w.h hVar = this.u;
            if (hVar != null && hVar.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            d.a.o0.w.w.h hVar2 = (d.a.o0.w.w.h) new d.a.o0.w.w.i(z).a(this.f59023a.getPageContext().getPageActivity());
            this.u = hVar2;
            hVar2.L(this.f59023a.getPageContext());
            this.u.W(this.B);
            this.u.M(3);
            this.u.x(this.f59023a.getPageContext());
            this.u.a().C(true);
            this.u.a().w(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.f59030h.addView(this.u.a(), layoutParams);
                this.u.a().o();
            }
            this.u.Q(new b(this));
            this.u.N(this.C);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B = new o(this, d.a.c.a.j.a(this.f59023a.getPageContext().getContext()));
            this.C = new a(this);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            F();
        }
    }

    public void N() {
        d.a.p0.j1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f59026d) == null) {
            return;
        }
        dVar.c();
    }

    public boolean O(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent)) == null) {
            d.a.o0.w.w.h hVar = this.u;
            if (hVar != null) {
                if (i2 == 12005) {
                    hVar.e0();
                    d.a.c.e.m.e.a().postDelayed(this.D, 300L);
                }
                this.u.A(i2, i3, intent);
            }
            if (i2 == 25035) {
                I(i3, intent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            d.a.o0.w.w.h hVar = this.u;
            if (hVar == null || hVar.a() == null || this.u.a().getVisibility() != 0) {
                return false;
            }
            this.u.w();
            return true;
        }
        return invokeV.booleanValue;
    }

    public View Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            this.f59030h = viewGroup;
            this.f59029g = (NavigationBarShadowView) viewGroup.findViewById(R.id.navi_shadow_view_reply_me);
            if (this.f59031i == null) {
                d.a.o0.r.f0.g gVar = new d.a.o0.r.f0.g(this.f59023a.getPageContext());
                this.f59031i = gVar;
                gVar.a(this.q);
            }
            this.f59031i.a0(this.f59023a.getUniqueId());
            if (this.f59024b == null) {
                PbListView pbListView = new PbListView(this.f59023a.getContext());
                this.f59024b = pbListView;
                pbListView.b();
            }
            this.f59024b.o(R.color.CAM_X0205);
            this.f59024b.q();
            this.f59024b.r(d.a.c.e.p.l.g(this.f59023a.getContext(), R.dimen.tbds182));
            this.f59024b.v();
            this.f59024b.E(R.dimen.tbfontsize33);
            this.f59024b.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f59024b.y(R.color.CAM_X0110);
            this.f59024b.z(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f59030h.findViewById(R.id.reply_me_pull_refresh_layout);
            this.f59027e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f59031i);
            this.f59028f = (BdTypeRecyclerView) this.f59030h.findViewById(R.id.replyme_lv);
            d.a.p0.j1.b.p.d dVar = new d.a.p0.j1.b.p.d(this.f59023a.getPageContext(), this.f59028f);
            this.f59026d = dVar;
            dVar.h(new k(this));
            ((DefaultItemAnimator) this.f59028f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f59028f.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.f59028f.setFadingEdgeLength(0);
            this.f59028f.setOverScrollMode(2);
            this.f59028f.addItemDecoration(new DeviderLineDecoration());
            this.f59028f.setRecyclerListener(new l(this));
            this.f59028f.setOnSrollToBottomListener(new m(this));
            this.f59028f.setOnScrollListener(this.F);
            this.f59028f.addOnScrollListener(this.r);
            L();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.f59023a.getPageContext());
            this.t = replyMeModel;
            replyMeModel.A(this.E);
            K();
            J(false);
            return this.f59030h;
        }
        return (View) invokeL.objValue;
    }

    public void R(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            F();
        }
    }

    public void T(boolean z, ArrayList<d.a.c.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048589, this, z, arrayList) == null) || this.f59028f == null) {
            return;
        }
        this.f59027e.setVisibility(0);
        Z(false);
        if (z) {
            this.f59024b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f59024b.f();
            this.f59024b.z(this.p);
        } else {
            this.f59024b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f59024b.f();
            this.f59024b.A(this.mContext.getResources().getString(R.string.list_no_more));
            this.f59024b.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f59025c == null) {
                this.f59025c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.f59025c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f59025c, R.color.CAM_X0201);
            }
            if (this.f59025c.getParent() == null && !this.k) {
                this.k = true;
                this.f59028f.s(this.f59025c);
                this.f59025c.setVisibility(0);
                this.f59025c.f(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f59028f.setNextPage(null);
            if (arrayList != null) {
                this.f59026d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f59028f.removeHeaderView(this.f59025c);
            this.k = false;
            d.a.p0.j1.b.p.d dVar = this.f59026d;
            if (dVar != null) {
                dVar.f(arrayList);
                this.f59026d.c();
            }
            this.f59028f.setNextPage(this.f59024b);
            this.n = R.color.CAM_X0204;
        }
        F();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void U(String str, long j2) {
        d.a.p0.j1.b.p.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, str, j2) == null) {
            d.a.p0.j1.b.p.a aVar2 = this.v;
            if (aVar2 != null && aVar2.c() != null && this.v.A()) {
                d.a.o0.w.w.h hVar = this.u;
                if (hVar == null || !hVar.v) {
                    J(true);
                }
                if (this.u == null || (aVar = this.v) == null) {
                    return;
                }
                if (aVar.C() && this.v.q() != null) {
                    this.u.f0(this.v.q().getName_show());
                    return;
                } else {
                    this.u.f0(null);
                    return;
                }
            }
            if (this.A == null) {
                d.a.p0.u0.f2.a.c cVar = new d.a.p0.u0.f2.a.c(this.f59023a.getPageContext());
                this.A = cVar;
                cVar.j(new e(this));
            }
            this.A.h(str, j2);
        }
    }

    public void X(x xVar) {
        d.a.p0.j1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, xVar) == null) || (dVar = this.f59026d) == null) {
            return;
        }
        dVar.g(xVar);
    }

    public void Y(w wVar) {
        d.a.p0.j1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, wVar) == null) || (dVar = this.f59026d) == null) {
            return;
        }
        dVar.e(wVar);
    }

    public void Z(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f59027e == null) {
            return;
        }
        if (z && (bdTypeRecyclerView = this.f59028f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.f59028f.setSelection(0);
        }
        this.f59027e.setRefreshing(z);
    }

    @Override // d.a.c.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.D);
            d.a.o0.w.w.h hVar = this.u;
            if (hVar != null) {
                hVar.B();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ReplyMeModel replyMeModel = this.t;
            if (replyMeModel != null) {
                replyMeModel.A(null);
                this.t.onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
            if (replyPrivacyCheckController2 != null) {
                replyPrivacyCheckController2.setAttentionCallback(null);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            d.a.o0.w.w.h hVar = this.u;
            if (hVar != null && hVar.a() != null) {
                this.u.a().w(i2);
            }
            PbListView pbListView = this.f59024b;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f59024b.d(i2);
            }
            d.a.o0.r.f0.g gVar = this.f59031i;
            if (gVar != null) {
                gVar.I(i2);
            }
            NoDataView noDataView = this.f59025c;
            if (noDataView != null) {
                noDataView.f(this.mContext, i2);
                SkinManager.setBackgroundColor(this.f59025c, R.color.CAM_X0201);
            }
            N();
            SkinManager.setBackgroundColor(this.f59028f, this.n);
            SkinManager.setBackgroundColor(this.f59027e, R.color.CAM_X0205);
            d.a.p0.j1.b.p.e eVar = this.j;
            if (eVar != null) {
                eVar.f(i2);
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, errorData) == null) {
        }
    }
}
