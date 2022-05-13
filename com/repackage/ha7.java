package com.repackage;

import android.content.Context;
import android.content.Intent;
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
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tieba.imMessageCenter.mention.AtMessageFragment;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterActivity;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.db7;
import com.repackage.pu4;
import com.repackage.rm6;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ha7 extends z8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public rm6 A;
    public DataModel<MessageCenterActivity> B;
    public NewWriteModel.g C;
    public ReplyMeModel D;
    public Runnable E;
    public final ReplyMeModel.b F;
    public AtMessageFragment a;
    public PbListView b;
    public NoDataView c;
    public va7 d;
    public BdSwipeRefreshLayout e;
    public BdTypeRecyclerView f;
    public NavigationBarShadowView g;
    public ViewGroup h;
    public qu4 i;
    public db7 j;
    public boolean k;
    public ReplyPrivacyCheckController l;
    public AttentionHostData m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final pu4.g q;
    public RecyclerView.OnScrollListener r;
    public db7.b s;
    public final RecyclerView.OnScrollListener t;
    public e35 u;
    public wa7 v;
    public String w;
    public String x;
    public long y;
    public long z;

    /* loaded from: classes6.dex */
    public class a extends DataModel<MessageCenterActivity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ha7 ha7Var, b9 b9Var) {
            super(b9Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var, b9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((b9) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.r();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.v != null) {
                    return this.a.v.C();
                }
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public String E() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public WriteData F(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                WriteData writeData = new WriteData();
                writeData.setForumId(this.a.w);
                writeData.setForumName(this.a.x);
                writeData.setThreadId(this.a.v.C());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (this.a.v.E()) {
                    writeData.setFloor(this.a.y > 0 ? String.valueOf(this.a.y) : this.a.v.m().n);
                } else {
                    writeData.setFloor(this.a.v.r());
                }
                if (this.a.z > 0) {
                    writeData.setRepostId(String.valueOf(this.a.z));
                    writeData.setReSubPostId(this.a.v.E() ? String.valueOf(this.a.z) : null);
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
        public boolean H() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean I() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tbadk.editortools.pb.DataModel
        public boolean J() {
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
    public class b implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public b(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ey4 ey4Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ey4Var, writeData, antiData}) == null) || this.a.a.getBaseFragmentActivity() == null) {
                return;
            }
            this.a.a.getBaseFragmentActivity().hideProgressBar();
            this.a.u.a().o();
            if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                this.a.l.setLikeUserData(this.a.m);
                this.a.l.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                return;
            }
            if (postWriteCallBackData != null && ey4Var == null && !AntiHelper.m(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                this.a.a.showToast(postWriteCallBackData.getErrorString());
            }
            if (!z || postWriteCallBackData == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
            statisticItem.param("tid", postWriteCallBackData.getPostId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 8);
            g85 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.mContext.getPageActivity());
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
    public class c implements z25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public c(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
        }

        @Override // com.repackage.z25
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
        public final /* synthetic */ ha7 a;

        public d(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
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
        public final /* synthetic */ ha7 a;

        public e(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.u == null || this.a.u.t() == null) {
                return;
            }
            mi.L(this.a.getPageContext().getPageActivity(), this.a.u.t().h());
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ReplyMeModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public f(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.b
        public void a(long j, long j2, long j3, String str, long j4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Long.valueOf(j4)}) == null) {
                this.a.w = String.valueOf(j);
                this.a.x = str;
                this.a.y = j2;
                this.a.z = j3;
                ha7 ha7Var = this.a;
                ha7Var.Z(ha7Var.w, j4);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements rm6.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public g(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
        }

        @Override // com.repackage.rm6.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        @Override // com.repackage.rm6.d
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && z) {
                if (this.a.u == null || this.a.u.s) {
                    this.a.P(false);
                }
                if (this.a.u == null || this.a.v == null) {
                    return;
                }
                if (!this.a.v.E() || this.a.v.y() == null) {
                    this.a.u.k0(null, null);
                    return;
                }
                this.a.u.k0(this.a.v.y().getName_show(), this.a.v.y().getPortrait());
            }
        }

        @Override // com.repackage.rm6.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public h(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
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
            this.a.a.U0();
        }
    }

    /* loaded from: classes6.dex */
    public class i implements pu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public i(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
        }

        @Override // com.repackage.pu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (ki.z()) {
                    if (this.a.a != null) {
                        this.a.a.W0();
                    }
                } else if (this.a.e != null) {
                    this.a.e.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public j(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
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
    public class k extends ux5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 b;

        public k(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ha7Var;
        }

        @Override // com.repackage.ux5
        public void a(View view2, BaseCardInfo baseCardInfo) {
            long g;
            int i;
            String spannableStringBuilder;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, view2, baseCardInfo) == null) && view2 != null && (baseCardInfo instanceof wa7)) {
                wa7 wa7Var = (wa7) baseCardInfo;
                if (wa7Var.D() && view2.getId() != R.id.obfuscated_res_0x7f09187a && view2.getId() != R.id.obfuscated_res_0x7f0922f3) {
                    wa7Var.H(false);
                    this.b.T();
                }
                if (view2.getId() == R.id.obfuscated_res_0x7f09140e) {
                    this.b.v = wa7Var;
                    if (wa7Var.E()) {
                        g = kg.g(wa7Var.s(), 0L);
                    } else {
                        g = kg.g(wa7Var.r(), 0L);
                    }
                    long j = g;
                    int i2 = 2;
                    if (this.b.u == null || this.b.mContext == null) {
                        i = 2;
                    } else {
                        if (wa7Var.k() != null && wa7Var.v() != null) {
                            String userName = UtilHelper.getUserName(wa7Var.y());
                            if (wa7Var.k().size() <= 2) {
                                if (wa7Var.k().size() <= 1 || wa7Var.k().get(1) == null) {
                                    spannableStringBuilder = this.b.mContext.getString(R.string.obfuscated_res_0x7f0f13b2);
                                    i2 = 1;
                                } else {
                                    spannableStringBuilder = xf5.E(wa7Var.k().get(1).content).toString();
                                }
                            } else {
                                spannableStringBuilder = wa7Var.k().get(2) != null ? xf5.E(wa7Var.k().get(2).content).toString() : null;
                            }
                            e35 e35Var = this.b.u;
                            e35Var.p(this.b.mContext.getString(R.string.obfuscated_res_0x7f0f0fac) + userName + this.b.mContext.getString(R.string.obfuscated_res_0x7f0f13b0) + spannableStringBuilder);
                        }
                        this.b.u.T(this.b.v.r());
                        this.b.u.b0(wa7Var.E() ? this.b.v.r() : null);
                        i = i2;
                    }
                    if (this.b.m == null) {
                        this.b.m = new AttentionHostData();
                    }
                    if (this.b.v != null) {
                        this.b.m.parserWithMetaData(this.b.v.B());
                    }
                    this.b.D.B(j, i, wa7Var.e(), wa7Var.C(), this.b.v != null ? this.b.v.getBaijiahaoData() : null);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09055e) {
                    Object tag = view2.getTag(R.id.obfuscated_res_0x7f090f6c);
                    if (tag instanceof Boolean) {
                        String s = wa7Var.s();
                        if (((Boolean) tag).booleanValue()) {
                            this.b.a.P0(wa7Var, s);
                        } else if (wa7Var.getThreadType() == 40) {
                            this.b.a.T0(wa7Var, true, s);
                        } else {
                            this.b.a.R0(wa7Var, s);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends LinearLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinearSmoothScroller a;
        public final /* synthetic */ ha7 b;

        /* loaded from: classes6.dex */
        public class a extends LinearSmoothScroller {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(l lVar, Context context) {
                super(context);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, context};
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
        public l(ha7 ha7Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var, context};
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
            this.b = ha7Var;
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
    public class m implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
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
    public class n implements BdListView.p {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public n(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
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
            this.a.a.U0();
        }
    }

    /* loaded from: classes6.dex */
    public class o implements db7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public o(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
        }

        @Override // com.repackage.db7.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            this.a.f.removeHeaderView(this.a.j.e());
            this.a.o = false;
        }
    }

    /* loaded from: classes6.dex */
    public class p extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha7 a;

        public p(ha7 ha7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha7Var;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha7(AtMessageFragment atMessageFragment) {
        super(atMessageFragment.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atMessageFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = R.color.CAM_X0204;
        this.o = false;
        this.p = new h(this);
        this.q = new i(this);
        this.r = new j(this);
        this.s = new o(this);
        this.t = new p(this);
        this.D = null;
        this.E = new e(this);
        this.F = new f(this);
        this.a = atMessageFragment;
        this.l = new ReplyPrivacyCheckController(atMessageFragment.getPageContext());
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.a.getContext()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            db7 db7Var = this.j;
            if (db7Var != null) {
                this.f.removeHeaderView(db7Var.e());
                this.o = false;
                return;
            }
            return;
        }
        long m2 = iu4.k().m("key_im_open_notification_close_time", 0L);
        if (this.o) {
            return;
        }
        if (m2 == 0 || System.currentTimeMillis() - m2 > 604800000) {
            if (this.j == null) {
                db7 db7Var2 = new db7(this.a.getPageContext());
                this.j = db7Var2;
                db7Var2.g(this.s);
            }
            this.f.t(this.j.e(), 0);
            this.o = true;
        }
    }

    public void M(int i2) {
        va7 va7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || (va7Var = this.d) == null) {
            return;
        }
        va7Var.a(i2);
    }

    public BdSwipeRefreshLayout N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (BdSwipeRefreshLayout) invokeV.objValue;
    }

    public final void O(int i2, Intent intent) {
        j15 j15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, intent) == null) {
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
                i15 n2 = this.u.a().n(6);
                if (n2 != null && (j15Var = n2.m) != null) {
                    j15Var.onAction(new w05(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.u.F();
                }
            }
        }
    }

    public final void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            e35 e35Var = this.u;
            if (e35Var != null && e35Var.a() != null && this.u.a().getParent() != null) {
                ((ViewGroup) this.u.a().getParent()).removeView(this.u.a());
            }
            e35 e35Var2 = (e35) new f35(z).a(this.a.getPageContext().getPageActivity());
            this.u = e35Var2;
            e35Var2.N(this.a.getPageContext());
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

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B = new a(this, f9.a(this.a.getPageContext().getContext()));
            this.C = new b(this);
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            L();
        }
    }

    public void T() {
        va7 va7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (va7Var = this.d) == null) {
            return;
        }
        va7Var.c();
    }

    public boolean U(int i2, int i3, Intent intent) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent)) == null) {
            e35 e35Var = this.u;
            if (e35Var != null) {
                if (i2 == 12005) {
                    e35Var.j0();
                    ng.a().postDelayed(this.E, 300L);
                }
                this.u.C(i2, i3, intent);
            }
            if (i2 == 25035) {
                O(i3, intent);
                return false;
            }
            return false;
        }
        return invokeIIL.booleanValue;
    }

    public View V(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            if (viewGroup == null) {
                return null;
            }
            this.h = viewGroup;
            this.g = (NavigationBarShadowView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09151d);
            if (this.i == null) {
                qu4 qu4Var = new qu4(this.a.getPageContext());
                this.i = qu4Var;
                qu4Var.e(this.q);
            }
            this.i.a0(this.a.getUniqueId());
            if (this.b == null) {
                PbListView pbListView = new PbListView(this.a.getContext());
                this.b = pbListView;
                pbListView.b();
            }
            this.b.p(R.color.CAM_X0205);
            this.b.s();
            this.b.t(mi.f(this.a.getContext(), R.dimen.tbds182));
            this.b.x();
            this.b.G(R.dimen.tbfontsize33);
            this.b.E(SkinManager.getColor(R.color.CAM_X0109));
            this.b.A(R.color.CAM_X0110);
            this.b.B(this.p);
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.h.findViewById(R.id.obfuscated_res_0x7f0902b7);
            this.e = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setProgressView(this.i);
            this.f = (BdTypeRecyclerView) this.h.findViewById(R.id.obfuscated_res_0x7f0902b9);
            va7 va7Var = new va7(this.a.getPageContext(), this.f);
            this.d = va7Var;
            va7Var.g(new k(this));
            ((DefaultItemAnimator) this.f.getItemAnimator()).setSupportsChangeAnimations(false);
            this.f.setLayoutManager(new l(this, this.mContext.getContext()));
            this.f.setFadingEdgeLength(0);
            this.f.setOverScrollMode(2);
            this.f.addItemDecoration(new DeviderLineDecoration());
            this.f.setRecyclerListener(new m(this));
            this.f.setOnSrollToBottomListener(new n(this));
            this.f.setOnScrollListener(this.t);
            this.f.addOnScrollListener(this.r);
            S();
            ReplyMeModel replyMeModel = new ReplyMeModel(this.a.getPageContext());
            this.D = replyMeModel;
            replyMeModel.C(this.F);
            Q();
            P(false);
            return this.h;
        }
        return (View) invokeL.objValue;
    }

    public void W(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, newsNotifyMessage) != null) || newsNotifyMessage == null) {
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            L();
        }
    }

    public void Y(boolean z, ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048588, this, z, arrayList) == null) || this.f == null) {
            return;
        }
        this.e.setVisibility(0);
        c0(false);
        if (z) {
            this.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.f();
            this.b.B(this.p);
        } else {
            this.b.L(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.b.f();
            this.b.C(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f09ee));
            this.b.B(null);
        }
        if (ListUtils.isEmpty(arrayList)) {
            if (this.c == null) {
                this.c = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070275)), NoDataViewFactory.e.d(null, this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f0abd)), null);
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
                this.d.e(arrayList);
            }
            this.n = R.color.CAM_X0205;
            this.e.setEnabled(false);
        } else {
            this.f.removeHeaderView(this.c);
            this.k = false;
            va7 va7Var = this.d;
            if (va7Var != null) {
                va7Var.e(arrayList);
                this.d.c();
            }
            this.f.setNextPage(this.b);
            this.n = R.color.CAM_X0204;
        }
        L();
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public final void Z(String str, long j2) {
        wa7 wa7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048589, this, str, j2) == null) {
            wa7 wa7Var2 = this.v;
            if (wa7Var2 != null && wa7Var2.getBaijiahaoData() != null && this.v.isBjh()) {
                e35 e35Var = this.u;
                if (e35Var == null || !e35Var.s) {
                    P(true);
                }
                if (this.u == null || (wa7Var = this.v) == null) {
                    return;
                }
                if (wa7Var.E() && this.v.y() != null) {
                    this.u.k0(this.v.y().getName_show(), this.v.y().getPortrait());
                    return;
                } else {
                    this.u.k0(null, null);
                    return;
                }
            }
            if (this.A == null) {
                rm6 rm6Var = new rm6(this.a.getPageContext());
                this.A = rm6Var;
                rm6Var.i(new g(this));
            }
            this.A.g(str, j2);
        }
    }

    public void a0(cp cpVar) {
        va7 va7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, cpVar) == null) || (va7Var = this.d) == null) {
            return;
        }
        va7Var.f(cpVar);
    }

    public void b0(bp bpVar) {
        va7 va7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, bpVar) == null) || (va7Var = this.d) == null) {
            return;
        }
        va7Var.d(bpVar);
    }

    public void c0(boolean z) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048592, this, z) == null) || this.e == null) {
            return;
        }
        if (z && (bdTypeRecyclerView = this.f) != null && bdTypeRecyclerView.getFirstVisiblePosition() != 0) {
            this.f.setSelection(0);
        }
        this.e.setRefreshing(z);
    }

    @Override // com.repackage.z8
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ng.a().removeCallbacks(this.E);
            e35 e35Var = this.u;
            if (e35Var != null) {
                e35Var.D();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.l;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController2 = this.l;
            if (replyPrivacyCheckController2 != null) {
                replyPrivacyCheckController2.setAttentionCallback(null);
            }
            ReplyMeModel replyMeModel = this.D;
            if (replyMeModel != null) {
                replyMeModel.C(null);
                this.D.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            e35 e35Var = this.u;
            if (e35Var != null && e35Var.a() != null) {
                this.u.a().w(i2);
            }
            PbListView pbListView = this.b;
            if (pbListView != null) {
                pbListView.E(SkinManager.getColor(R.color.CAM_X0109));
                this.b.d(i2);
            }
            qu4 qu4Var = this.i;
            if (qu4Var != null) {
                qu4Var.H(i2);
            }
            NoDataView noDataView = this.c;
            if (noDataView != null) {
                noDataView.f(this.mContext, i2);
                SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            }
            T();
            SkinManager.setBackgroundColor(this.f, this.n);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            db7 db7Var = this.j;
            if (db7Var != null) {
                db7Var.f(i2);
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, errorData) == null) {
        }
    }
}
