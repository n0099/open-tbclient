package com.repackage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
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
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
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
import com.repackage.av4;
import com.repackage.pc7;
import com.repackage.qo6;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class ec7 extends b9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qo6 A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.e C;
    public Runnable D;
    public final ReplyMeModel.b E;
    public final RecyclerView.OnScrollListener F;
    public final ReplyMessageFragment a;
    public PbListView b;
    public NoDataView c;
    public oc7 d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public NavigationBarShadowView g;
    public ViewGroup h;
    public bv4 i;
    public pc7 j;
    public boolean k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final av4.g q;
    public RecyclerView.OnScrollListener r;
    public pc7.b s;
    public ReplyMeModel t;
    public o45 u;
    public ic7 v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes6.dex */
    public class a extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ec7 ec7Var, d9 d9Var) {
            super(d9Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var, d9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((d9) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.t();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.E();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String F() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData G(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                WriteData writeData = new WriteData();
                writeData.setForumId(this.a.w);
                writeData.setForumName(this.a.x);
                writeData.setThreadId(this.a.v.E());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.a.v.H()) {
                    writeData.setFloor(this.a.y > 0 ? String.valueOf(this.a.y) : this.a.v.r().n);
                } else {
                    writeData.setFloor(this.a.v.t());
                }
                if (this.a.z > 0) {
                    writeData.setRepostId(String.valueOf(this.a.z));
                    writeData.setReSubPostId(this.a.v.H() ? String.valueOf(this.a.z) : null);
                }
                if (this.a.v != null) {
                    writeData.setBaijiahaoData(this.a.v.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }
            return (WriteData) invokeL.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean I() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean J() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean K() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean cancelLoadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.w : (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String getFromForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.adp.base.BdBaseModel
        public boolean loadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements NewWriteModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public b(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.e
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, az4 az4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, az4Var, writeData, antiData}) == null) || this.a.a.getBaseFragmentActivity() == null) {
                return;
            }
            this.a.a.getBaseFragmentActivity().hideProgressBar();
            this.a.u.a().o();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.a.l.setLikeUserData(this.a.m);
                this.a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                return;
            }
            if (postWriteCallBackData != null && az4Var == null && !AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                this.a.a.showToast(postWriteCallBackData.getErrorString());
            }
            if (!z || postWriteCallBackData == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            statisticItem.param("tid", postWriteCallBackData.getPostId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 8);
            o95 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.mContext.getPageActivity());
            if (currentVisiblePageExtra != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements i45 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public c(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.repackage.i45
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.getBaseFragmentActivity() == null) {
                return;
            }
            this.a.a.getBaseFragmentActivity().showProgressBar();
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public d(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.u == null) {
                return;
            }
            this.a.u.y();
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public e(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.u == null || this.a.u.t() == null) {
                return;
            }
            qi.L(this.a.getPageContext().getPageActivity(), this.a.u.t().i());
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public f(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
                this.a.w = String.valueOf(j);
                this.a.x = str;
                this.a.y = j2;
                this.a.z = j3;
                ec7 ec7Var = this.a;
                ec7Var.a0(ec7Var.w, j4);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements qo6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public g(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.repackage.qo6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.qo6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.u == null || this.a.u.s) {
                    this.a.Q(false);
                }
                if (this.a.u == null || this.a.v == null) {
                    return;
                }
                if (!this.a.v.H() || this.a.v.A() == null) {
                    this.a.u.l0(null, null);
                    return;
                }
                this.a.u.l0(this.a.v.A().getName_show(), this.a.v.A().getPortrait());
            }
        }

        @Override // com.repackage.qo6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public h(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                if (i != 0 && this.a.u != null) {
                    this.a.u.y();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public i(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b == null || this.a.a == null) {
                return;
            }
            this.a.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.a.b.B(null);
            this.a.b.Q();
            this.a.a.L1();
        }
    }

    /* loaded from: classes6.dex */
    public class j implements av4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public j(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.repackage.av4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (oi.z()) {
                    if (this.a.a != null) {
                        this.a.a.N1();
                    }
                } else if (this.a.e != null) {
                    this.a.e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public k(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i != 0) {
                    if (i == 1 || i == 2) {
                        this.a.g.c();
                    }
                } else if (recyclerView.canScrollVertically(-1)) {
                    this.a.g.c();
                } else {
                    this.a.g.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public l(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z && this.a.u != null) {
                this.a.u.F();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends b06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 b;

        public m(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ec7Var;
        }

        @Override // com.repackage.b06
        public void a(View view2, BaseCardInfo baseCardInfo) {
            long g;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) && view2 != null && (baseCardInfo instanceof ic7)) {
                ic7 ic7Var = (ic7) baseCardInfo;
                if (ic7Var.F() && view2.getId() != R.id.obfuscated_res_0x7f09197d && view2.getId() != R.id.obfuscated_res_0x7f092450) {
                    ic7Var.K(false);
                    this.b.T();
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f0914f5) {
                    this.b.v = ic7Var;
                    if (ic7Var.H()) {
                        g = og.g(ic7Var.w(), 0L);
                    } else {
                        g = og.g(ic7Var.t(), 0L);
                    }
                    long j = g;
                    if (this.b.u != null) {
                        this.b.u.T(this.b.v.t());
                        this.b.u.b0(ic7Var.H() ? this.b.v.t() : null);
                    }
                    if (this.b.m == null) {
                        this.b.m = new AttentionHostData();
                    }
                    if (this.b.v != null) {
                        this.b.m.parserWithMetaData(this.b.v.D());
                    }
                    this.b.t.C(j, 2, ic7Var.c(), ic7Var.E(), this.b.v != null ? this.b.v.getBaijiahaoData() : null);
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f090555) {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090f7c);
                    if (tag instanceof Boolean) {
                        String w = ic7Var.w();
                        if (((Boolean) tag).booleanValue()) {
                            this.b.a.G1(ic7Var, w);
                        } else if (ic7Var.getThreadType() == 40) {
                            this.b.a.K1(ic7Var, true, w);
                        } else {
                            this.b.a.I1(ic7Var, w);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinearSmoothScroller a;
        public final /* synthetic */ ec7 b;

        /* loaded from: classes6.dex */
        public class a extends LinearSmoothScroller {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(n nVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar, context};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((Context) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public int getVerticalSnapPreference() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return -1;
                }
                return invokeV.intValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(ec7 ec7Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ec7Var;
            this.a = new a(this, this.b.mContext.getContext());
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, recyclerView, state, i) == null) {
                this.a.setTargetPosition(i);
                startSmoothScroll(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) {
                View view2 = viewHolder.itemView;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public p(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.a.b.B(null);
            this.a.b.N();
            this.a.a.L1();
        }
    }

    /* loaded from: classes6.dex */
    public class q implements pc7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ec7 a;

        public q(ec7 ec7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ec7Var;
        }

        @Override // com.repackage.pc7.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            this.a.f.removeHeaderView(this.a.j.e());
            this.a.o = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ec7(ReplyMessageFragment replyMessageFragment) {
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
                super((d9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = R.color.CAM_X0204;
        this.o = false;
        this.p = new i(this);
        this.q = new j(this);
        this.r = new k(this);
        this.s = new q(this);
        this.t = null;
        this.D = new e(this);
        this.E = new f(this);
        this.F = new h(this);
        this.a = replyMessageFragment;
        ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(replyMessageFragment.getPageContext());
        this.l = replyPrivacyCheckController;
        replyPrivacyCheckController.setAttentionCallback(new l(this));
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.getFragmentActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            pc7 pc7Var = this.j;
            if (pc7Var != null) {
                this.f.removeHeaderView(pc7Var.e());
                this.o = false;
                return;
            }
            return;
        }
        long m2 = ru4.k().m("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (m2 == 0 || System.currentTimeMillis() - m2 > 604800000) {
            if (this.j == null) {
                pc7 pc7Var2 = new pc7(this.a.getPageContext());
                this.j = pc7Var2;
                pc7Var2.g(this.s);
            }
            this.f.t(this.j.e(), 0);
            this.o = true;
        }
    }

    public void L(int i2) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (oc7Var = this.d) == null) {
            return;
        }
        oc7Var.a(i2);
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            rg.a().removeCallbacks(this.D);
            o45 o45Var = this.u;
            if (o45Var != null) {
                o45Var.D();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ReplyMeModel replyMeModel = this.t;
            if (replyMeModel != null) {
                replyMeModel.D(null);
                this.t.onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
            if (replyPrivacyCheckController2 != null) {
                replyPrivacyCheckController2.setAttentionCallback(null);
            }
        }
    }

    public final int N(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bdTypeRecyclerView, str)) == null) {
            if (bdTypeRecyclerView != null && !TextUtils.isEmpty(str)) {
                List<on> data = bdTypeRecyclerView.getData();
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                if (data != null && data.size() > 0) {
                    int size = data.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        on onVar = data.get(i2);
                        if ((onVar instanceof ic7) && str.equals(((ic7) onVar).t())) {
                            return i2 + headerViewsCount;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public BdSwipeRefreshLayout O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void P(int i2, Intent intent) {
        t25 t25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i2, intent) == null) {
            this.u.a().q();
            this.u.y();
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
                this.u.B(writeData);
                this.u.d0(pbEditorData.getVoiceModel());
                s25 n2 = this.u.a().n(6);
                if (n2 != null && (t25Var = n2.m) != null) {
                    t25Var.A(new h25(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.u.F();
                }
            }
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            o45 o45Var = this.u;
            if (o45Var != null && o45Var.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            o45 o45Var2 = (o45) new p45(z).a(this.a.getPageContext().getPageActivity());
            this.u = o45Var2;
            o45Var2.N(this.a.getPageContext());
            this.u.a0(this.B);
            this.u.O(3);
            this.u.z(this.a.getPageContext());
            this.u.a().C(true);
            this.u.a().w(TbadkCoreApplication.getInst().getSkinType());
            if (this.u.a() != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(12);
                this.h.addView(this.u.a(), layoutParams);
                this.u.a().o();
            }
            this.u.U(new c(this));
            this.u.Q(this.C);
            if (this.u.a() != null) {
                this.u.a().setOnCancelClickListener(new d(this));
            }
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.B = new a(this, h9.a(this.a.getPageContext().getContext()));
            this.C = new b(this);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            K();
        }
    }

    public void T() {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (oc7Var = this.d) == null) {
            return;
        }
        oc7Var.c();
    }

    public boolean U(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, intent)) == null) {
            o45 o45Var = this.u;
            if (o45Var != null) {
                if (i2 == 12005) {
                    o45Var.k0();
                    rg.a().postDelayed(this.D, 300L);
                }
                this.u.C(i2, i3, intent);
            }
            if (i2 == 25035) {
                P(i3, intent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            o45 o45Var = this.u;
            if (o45Var == null || o45Var.a() == null || this.u.a().getVisibility() != 0) {
                return false;
            }
            this.u.y();
            return true;
        }
        return invokeV.booleanValue;
    }

    public View W(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            this.h = viewGroup;
            this.g = (NavigationBarShadowView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091617);
            if (this.i == null) {
                bv4 bv4Var = new bv4(this.a.getPageContext());
                this.i = bv4Var;
                bv4Var.f(this.q);
            }
            this.i.b0(this.a.getUniqueId());
            if (this.b == null) {
                PbListView pbListView = new PbListView(this.a.getContext());
                this.b = pbListView;
                pbListView.b();
            }
            this.b.p(R.color.CAM_X0205);
            this.b.s();
            this.b.t(qi.f(this.a.getContext(), R.dimen.tbds182));
            this.b.x();
            this.b.G(R.dimen.tbfontsize33);
            this.b.E(SkinManager.getColor(R.color.CAM_X0109));
            this.b.A(R.color.CAM_X0110);
            this.b.B(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.h.findViewById(R.id.obfuscated_res_0x7f091bad);
            this.e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.i);
            this.f = (BdTypeRecyclerView) this.h.findViewById(R.id.obfuscated_res_0x7f091bb9);
            oc7 oc7Var = new oc7(this.a.getPageContext(), this.f);
            this.d = oc7Var;
            oc7Var.h(new m(this));
            ((DefaultItemAnimator) this.f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f.setLayoutManager(new n(this, this.mContext.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.addItemDecoration(new DeviderLineDecoration());
            this.f.setRecyclerListener(new o(this));
            this.f.setOnSrollToBottomListener(new p(this));
            this.f.setOnScrollListener(this.F);
            this.f.addOnScrollListener(this.r);
            S();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.a.getPageContext());
            this.t = replyMeModel;
            replyMeModel.D(this.E);
            R();
            Q(false);
            return this.h;
        }
        return (View) invokeL.objValue;
    }

    public void X(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            K();
        }
    }

    public void Z(boolean z, ArrayList<on> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048591, this, z, arrayList) == null) || this.f == null) {
            return;
        }
        this.e.setVisibility(0);
        f0(false);
        if (z) {
            this.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.f();
            this.b.B(this.p);
        } else {
            this.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.f();
            this.b.C(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f09eb));
            this.b.B(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.c == null) {
                this.c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0ac8)), null);
                this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            if (this.c.getParent() == null && !this.k) {
                this.k = true;
                this.f.s(this.c);
                this.c.setVisibility(0);
                this.c.f(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.f.setNextPage(null);
            if (arrayList != null) {
                this.d.f(arrayList);
            }
            this.n = R.color.CAM_X0205;
        } else {
            this.f.removeHeaderView(this.c);
            this.k = false;
            oc7 oc7Var = this.d;
            if (oc7Var != null) {
                oc7Var.f(arrayList);
                this.d.c();
            }
            this.f.setNextPage(this.b);
            this.n = R.color.CAM_X0204;
        }
        K();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        b0(this.f, this.a.B1());
    }

    public final void a0(String str, long j2) {
        ic7 ic7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048592, this, str, j2) == null) {
            ic7 ic7Var2 = this.v;
            if (ic7Var2 != null && ic7Var2.getBaijiahaoData() != null && this.v.isBjh()) {
                o45 o45Var = this.u;
                if (o45Var == null || !o45Var.s) {
                    Q(true);
                }
                if (this.u == null || (ic7Var = this.v) == null) {
                    return;
                }
                if (ic7Var.H() && this.v.A() != null) {
                    this.u.l0(this.v.A().getName_show(), this.v.A().getPortrait());
                    return;
                } else {
                    this.u.l0(null, null);
                    return;
                }
            }
            if (this.A == null) {
                qo6 qo6Var = new qo6(this.a.getPageContext());
                this.A = qo6Var;
                qo6Var.i(new g(this));
            }
            this.A.g(str, j2);
        }
    }

    public final void b0(BdTypeRecyclerView bdTypeRecyclerView, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, bdTypeRecyclerView, str) == null) || bdTypeRecyclerView == null || str == null) {
            return;
        }
        int N = N(bdTypeRecyclerView, str);
        if (!(bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) || N < 0) {
            return;
        }
        bdTypeRecyclerView.smoothScrollToPosition(N);
    }

    public void d0(zn znVar) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, znVar) == null) || (oc7Var = this.d) == null) {
            return;
        }
        oc7Var.g(znVar);
    }

    public void e0(yn ynVar) {
        oc7 oc7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, ynVar) == null) || (oc7Var = this.d) == null) {
            return;
        }
        oc7Var.e(ynVar);
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, errorData) == null) {
        }
    }

    public void f0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || this.e == null) {
            return;
        }
        if (z && (bdTypeRecyclerView = this.f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.f.setSelection(0);
        }
        this.e.setRefreshing(z);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            o45 o45Var = this.u;
            if (o45Var != null && o45Var.a() != null) {
                this.u.a().w(i2);
            }
            PbListView pbListView = this.b;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.b.d(i2);
            }
            bv4 bv4Var = this.i;
            if (bv4Var != null) {
                bv4Var.H(i2);
            }
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.f(this.mContext, i2);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            T();
            SkinManager.setBackgroundColor(this.f, this.n);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            pc7 pc7Var = this.j;
            if (pc7Var != null) {
                pc7Var.f(i2);
            }
        }
    }
}
