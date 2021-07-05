package d.a.s0.j1.b;

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
import d.a.r0.r.f0.f;
import d.a.r0.s.c.i0;
import d.a.s0.a0.b0;
import d.a.s0.j1.b.p.e;
import d.a.s0.u0.f2.a.c;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class n extends d.a.c.a.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.s0.u0.f2.a.c A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;

    /* renamed from: a  reason: collision with root package name */
    public final ReplyMessageFragment f62258a;

    /* renamed from: b  reason: collision with root package name */
    public PbListView f62259b;

    /* renamed from: c  reason: collision with root package name */
    public NoDataView f62260c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.s0.j1.b.p.d f62261d;

    /* renamed from: e  reason: collision with root package name */
    public BdSwipeRefreshLayout f62262e;

    /* renamed from: f  reason: collision with root package name */
    public BdTypeRecyclerView f62263f;

    /* renamed from: g  reason: collision with root package name */
    public NavigationBarShadowView f62264g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f62265h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.r0.r.f0.g f62266i;
    public d.a.s0.j1.b.p.e j;
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
    public d.a.r0.w.w.h u;
    public d.a.s0.j1.b.p.a v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes9.dex */
    public class a implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f62267a;

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
            this.f62267a = nVar;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, i0 i0Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, i0Var, writeData, antiData}) == null) || this.f62267a.f62258a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f62267a.f62258a.getBaseFragmentActivity().hideProgressBar();
            this.f62267a.u.a().o();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.f62267a.l.setLikeUserData(this.f62267a.m);
                this.f62267a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
            } else if (postWriteCallBackData == null || i0Var != null || AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) || postWriteCallBackData.getErrorCode() == 230277 || postWriteCallBackData.getErrorCode() == 230278) {
            } else {
                this.f62267a.f62258a.showToast(postWriteCallBackData.getErrorString());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements d.a.r0.w.w.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f62268a;

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
            this.f62268a = nVar;
        }

        @Override // d.a.r0.w.w.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62268a.f62258a.getBaseFragmentActivity() == null) {
                return;
            }
            this.f62268a.f62258a.getBaseFragmentActivity().showProgressBar();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f62269e;

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
            this.f62269e = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62269e.u == null || this.f62269e.u.s() == null) {
                return;
            }
            d.a.c.e.p.l.K(this.f62269e.getPageContext().getPageActivity(), this.f62269e.u.s().i());
        }
    }

    /* loaded from: classes9.dex */
    public class d implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f62270a;

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
            this.f62270a = nVar;
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
                this.f62270a.w = String.valueOf(j);
                this.f62270a.x = str;
                this.f62270a.y = j2;
                this.f62270a.z = j3;
                n nVar = this.f62270a;
                nVar.U(nVar.w, j4);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f62271a;

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
            this.f62271a = nVar;
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.f62271a.u == null || this.f62271a.u.v) {
                    this.f62271a.J(false);
                }
                if (this.f62271a.u == null || this.f62271a.v == null) {
                    return;
                }
                if (!this.f62271a.v.C() || this.f62271a.v.q() == null) {
                    this.f62271a.u.f0(null);
                } else {
                    this.f62271a.u.f0(this.f62271a.v.q().getName_show());
                }
            }
        }

        @Override // d.a.s0.u0.f2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f62272a;

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
            this.f62272a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                if (i2 != 0 && this.f62272a.u != null) {
                    this.f62272a.u.w();
                }
                super.onScrollStateChanged(recyclerView, i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f62273e;

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
            this.f62273e = nVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f62273e.f62259b == null || this.f62273e.f62258a == null) {
                return;
            }
            this.f62273e.f62259b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f62273e.f62259b.z(null);
            this.f62273e.f62259b.O();
            this.f62273e.f62258a.W0();
        }
    }

    /* loaded from: classes9.dex */
    public class h implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f62274e;

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
            this.f62274e = nVar;
        }

        @Override // d.a.r0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (d.a.c.e.p.j.z()) {
                    if (this.f62274e.f62258a != null) {
                        this.f62274e.f62258a.Y0();
                    }
                } else if (this.f62274e.f62262e != null) {
                    this.f62274e.f62262e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f62275a;

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
            this.f62275a = nVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f62275a.f62264g.c();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.f62275a.f62264g.c();
                } else {
                    this.f62275a.f62264g.a();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f62276a;

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
            this.f62276a = nVar;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z && this.f62276a.u != null) {
                this.f62276a.u.D();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k extends b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f62277b;

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
            this.f62277b = nVar;
        }

        @Override // d.a.s0.a0.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            long f2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view, baseCardInfo) == null) && view != null && (baseCardInfo instanceof d.a.s0.j1.b.p.a)) {
                d.a.s0.j1.b.p.a aVar = (d.a.s0.j1.b.p.a) baseCardInfo;
                if (aVar.B() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                    aVar.F(false);
                    this.f62277b.N();
                }
                if (view.getId() == R.id.message_bottom_reply_container) {
                    this.f62277b.v = aVar;
                    if (aVar.C()) {
                        f2 = d.a.c.e.m.b.f(aVar.p(), 0L);
                    } else {
                        f2 = d.a.c.e.m.b.f(aVar.o(), 0L);
                    }
                    long j = f2;
                    if (this.f62277b.m == null) {
                        this.f62277b.m = new AttentionHostData();
                    }
                    if (this.f62277b.v != null) {
                        this.f62277b.m.parserWithMetaData(this.f62277b.v.x());
                    }
                    this.f62277b.t.z(j, 2, aVar.d(), aVar.y(), this.f62277b.v != null ? this.f62277b.v.c() : null);
                    if (aVar.t() != null) {
                        StatisticItem param = new StatisticItem(aVar.t()).param("obj_locate", 3);
                        if (aVar.getType() == d.a.s0.j1.b.p.a.B) {
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

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class m implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f62278e;

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
            this.f62278e = nVar;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62278e.f62259b == null) {
                return;
            }
            this.f62278e.f62259b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f62278e.f62259b.z(null);
            this.f62278e.f62259b.L();
            this.f62278e.f62258a.W0();
        }
    }

    /* renamed from: d.a.s0.j1.b.n$n  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1542n implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f62279a;

        public C1542n(n nVar) {
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
            this.f62279a = nVar;
        }

        @Override // d.a.s0.j1.b.p.e.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62279a.j == null) {
                return;
            }
            this.f62279a.f62263f.removeHeaderView(this.f62279a.j.e());
            this.f62279a.o = false;
        }
    }

    /* loaded from: classes9.dex */
    public class o extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f62280e;

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
            this.f62280e = nVar;
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
                writeData.setForumId(this.f62280e.w);
                writeData.setForumName(this.f62280e.x);
                writeData.setThreadId(this.f62280e.v.y());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.f62280e.v.C()) {
                    writeData.setFloor(this.f62280e.y > 0 ? String.valueOf(this.f62280e.y) : this.f62280e.v.h().n);
                } else {
                    writeData.setFloor(this.f62280e.v.o());
                }
                if (this.f62280e.z > 0) {
                    writeData.setRepostId(String.valueOf(this.f62280e.z));
                }
                if (this.f62280e.v != null) {
                    writeData.setBaijiahaoData(this.f62280e.v.c());
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
        this.s = new C1542n(this);
        this.t = null;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new f(this);
        this.f62258a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new j(this));
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f62263f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.f62258a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            d.a.s0.j1.b.p.e eVar = this.j;
            if (eVar != null) {
                this.f62263f.removeHeaderView(eVar.e());
                this.o = false;
                return;
            }
            return;
        }
        long l2 = d.a.r0.r.d0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.j == null) {
                d.a.s0.j1.b.p.e eVar2 = new d.a.s0.j1.b.p.e(this.f62258a.getPageContext());
                this.j = eVar2;
                eVar2.g(this.s);
            }
            this.f62263f.t(this.j.e(), 0);
            this.o = true;
        }
    }

    public void G(int i2) {
        d.a.s0.j1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (dVar = this.f62261d) == null) {
            return;
        }
        dVar.a(i2);
    }

    public BdSwipeRefreshLayout H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f62262e : (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void I(int i2, Intent intent) {
        d.a.r0.w.n nVar;
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
                d.a.r0.w.m n = this.u.a().n(6);
                if (n != null && (nVar = n.k) != null) {
                    nVar.onAction(new d.a.r0.w.a(52, 0, pbEditorData.getVoiceModel()));
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
            d.a.r0.w.w.h hVar = this.u;
            if (hVar != null && hVar.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            d.a.r0.w.w.h hVar2 = (d.a.r0.w.w.h) new d.a.r0.w.w.i(z).a(this.f62258a.getPageContext().getPageActivity());
            this.u = hVar2;
            hVar2.L(this.f62258a.getPageContext());
            this.u.W(this.B);
            this.u.M(3);
            this.u.x(this.f62258a.getPageContext());
            this.u.a().C(true);
            this.u.a().w(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.f62265h.addView(this.u.a(), layoutParams);
                this.u.a().o();
            }
            this.u.Q(new b(this));
            this.u.N(this.C);
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B = new o(this, d.a.c.a.j.a(this.f62258a.getPageContext().getContext()));
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
        d.a.s0.j1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (dVar = this.f62261d) == null) {
            return;
        }
        dVar.c();
    }

    public boolean O(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent)) == null) {
            d.a.r0.w.w.h hVar = this.u;
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
            d.a.r0.w.w.h hVar = this.u;
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
            this.f62265h = viewGroup;
            this.f62264g = (NavigationBarShadowView) viewGroup.findViewById(R.id.navi_shadow_view_reply_me);
            if (this.f62266i == null) {
                d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(this.f62258a.getPageContext());
                this.f62266i = gVar;
                gVar.a(this.q);
            }
            this.f62266i.a0(this.f62258a.getUniqueId());
            if (this.f62259b == null) {
                PbListView pbListView = new PbListView(this.f62258a.getContext());
                this.f62259b = pbListView;
                pbListView.b();
            }
            this.f62259b.o(R.color.CAM_X0205);
            this.f62259b.q();
            this.f62259b.r(d.a.c.e.p.l.g(this.f62258a.getContext(), R.dimen.tbds182));
            this.f62259b.v();
            this.f62259b.E(R.dimen.tbfontsize33);
            this.f62259b.C(SkinManager.getColor(R.color.CAM_X0109));
            this.f62259b.y(R.color.CAM_X0110);
            this.f62259b.z(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f62265h.findViewById(R.id.reply_me_pull_refresh_layout);
            this.f62262e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.f62266i);
            this.f62263f = (BdTypeRecyclerView) this.f62265h.findViewById(R.id.replyme_lv);
            d.a.s0.j1.b.p.d dVar = new d.a.s0.j1.b.p.d(this.f62258a.getPageContext(), this.f62263f);
            this.f62261d = dVar;
            dVar.h(new k(this));
            ((DefaultItemAnimator) this.f62263f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f62263f.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
            this.f62263f.setFadingEdgeLength(0);
            this.f62263f.setOverScrollMode(2);
            this.f62263f.addItemDecoration(new DeviderLineDecoration());
            this.f62263f.setRecyclerListener(new l(this));
            this.f62263f.setOnSrollToBottomListener(new m(this));
            this.f62263f.setOnScrollListener(this.F);
            this.f62263f.addOnScrollListener(this.r);
            L();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.f62258a.getPageContext());
            this.t = replyMeModel;
            replyMeModel.A(this.E);
            K();
            J(false);
            return this.f62265h;
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
        if (!(interceptable == null || interceptable.invokeZL(1048589, this, z, arrayList) == null) || this.f62263f == null) {
            return;
        }
        this.f62262e.setVisibility(0);
        Z(false);
        if (z) {
            this.f62259b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f62259b.f();
            this.f62259b.z(this.p);
        } else {
            this.f62259b.J(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.f62259b.f();
            this.f62259b.A(this.mContext.getResources().getString(R.string.list_no_more));
            this.f62259b.z(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.f62260c == null) {
                this.f62260c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                this.f62260c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.f62260c, R.color.CAM_X0201);
            }
            if (this.f62260c.getParent() == null && !this.k) {
                this.k = true;
                this.f62263f.s(this.f62260c);
                this.f62260c.setVisibility(0);
                this.f62260c.f(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f62263f.setNextPage(null);
            if (arrayList != null) {
                this.f62261d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f62263f.removeHeaderView(this.f62260c);
            this.k = false;
            d.a.s0.j1.b.p.d dVar = this.f62261d;
            if (dVar != null) {
                dVar.f(arrayList);
                this.f62261d.c();
            }
            this.f62263f.setNextPage(this.f62259b);
            this.n = R.color.CAM_X0204;
        }
        F();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void U(String str, long j2) {
        d.a.s0.j1.b.p.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048590, this, str, j2) == null) {
            d.a.s0.j1.b.p.a aVar2 = this.v;
            if (aVar2 != null && aVar2.c() != null && this.v.A()) {
                d.a.r0.w.w.h hVar = this.u;
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
                d.a.s0.u0.f2.a.c cVar = new d.a.s0.u0.f2.a.c(this.f62258a.getPageContext());
                this.A = cVar;
                cVar.j(new e(this));
            }
            this.A.h(str, j2);
        }
    }

    public void X(x xVar) {
        d.a.s0.j1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, xVar) == null) || (dVar = this.f62261d) == null) {
            return;
        }
        dVar.g(xVar);
    }

    public void Y(w wVar) {
        d.a.s0.j1.b.p.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, wVar) == null) || (dVar = this.f62261d) == null) {
            return;
        }
        dVar.e(wVar);
    }

    public void Z(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z) == null) || this.f62262e == null) {
            return;
        }
        if (z && (bdTypeRecyclerView = this.f62263f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.f62263f.setSelection(0);
        }
        this.f62262e.setRefreshing(z);
    }

    @Override // d.a.c.a.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.D);
            d.a.r0.w.w.h hVar = this.u;
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
            d.a.r0.w.w.h hVar = this.u;
            if (hVar != null && hVar.a() != null) {
                this.u.a().w(i2);
            }
            PbListView pbListView = this.f62259b;
            if (pbListView != null) {
                pbListView.C(SkinManager.getColor(R.color.CAM_X0109));
                this.f62259b.d(i2);
            }
            d.a.r0.r.f0.g gVar = this.f62266i;
            if (gVar != null) {
                gVar.I(i2);
            }
            NoDataView noDataView = this.f62260c;
            if (noDataView != null) {
                noDataView.f(this.mContext, i2);
                SkinManager.setBackgroundColor(this.f62260c, R.color.CAM_X0201);
            }
            N();
            SkinManager.setBackgroundColor(this.f62263f, this.n);
            SkinManager.setBackgroundColor(this.f62262e, R.color.CAM_X0205);
            d.a.s0.j1.b.p.e eVar = this.j;
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
