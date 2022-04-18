package com.repackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedMemoryListMessage;
import com.baidu.tieba.imMessageCenter.StrangerListActivityConfig;
import com.baidu.tieba.imMessageCenter.im.chat.notify.MessageAggregationListAdapter;
import com.baidu.tieba.imMessageCenter.im.model.ImMessageCenterModel;
import com.baidu.tieba.imMessageCenter.im.view.ShutDownValidateTipView;
import com.baidu.tieba.imMessageCenter.mention.ChatAggregationFragment;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumHttpResMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumNetMessage;
import com.baidu.tieba.imMessageCenter.recforum.model.MsgRecForumSocketResMessage;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cu4;
import com.repackage.nr4;
import com.repackage.ua7;
import java.util.ArrayList;
import java.util.List;
import tbclient.Page;
import tbclient.RecommendForumInfo;
/* loaded from: classes5.dex */
public class ba7 extends z8<ChatAggregationFragment> implements cu4.g, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public TextView B;
    public MessageRedDotView C;
    public View D;
    public ImageView E;
    public TextView F;
    public MessageRedDotView G;
    public View H;
    public ImageView I;
    public TextView J;
    public MessageRedDotView K;
    public fr4 L;
    public int M;
    public int N;
    public boolean O;
    public ua7 P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public AbsListView.OnScrollListener U;
    public final cu4.g V;
    public CustomMessageListener W;
    public wa X;
    public ua7.b Y;
    public final AdapterView.OnItemClickListener Z;
    public final ChatAggregationFragment a;
    public ImMessageCenterModel b;
    public ImMessageCenterShowItemData c;
    public BdSwipeRefreshLayout d;
    public du4 e;
    public BdListView f;
    public NavigationBarShadowView g;
    public final AdapterView.OnItemLongClickListener g0;
    public MessageAggregationListAdapter h;
    public final CustomMessageListener h0;
    public ShutDownValidateTipView i;
    public h57 i0;
    public lr4 j;
    public final CustomMessageListener j0;
    public nr4.e k;
    public final i57 k0;
    public NoDataView l;
    public final CustomMessageListener l0;
    public boolean m;
    public RelativeLayout n;
    public View o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public View t;
    public View u;
    public View v;
    public ImageView w;
    public TextView x;
    public MessageRedDotView y;
    public View z;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        public a(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view2, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                ba7 ba7Var = this.a;
                ba7Var.c = ba7Var.h.getItem(i);
                if (TbSingleton.getInstance().isImRecForumShow() && this.a.c != null && this.a.c.getDataType() == 2) {
                    return true;
                }
                ba7 ba7Var2 = this.a;
                ba7Var2.c0(ba7Var2.c);
                if (this.a.j != null) {
                    TiebaStatic.log("c12932");
                    this.a.j.m();
                    if (this.a.a != null && this.a.a.getActivity() != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        this.a.a.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                    }
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImMessageCenterShowItemData a;
        public final /* synthetic */ ba7 b;

        public b(ba7 ba7Var, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var, imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ba7Var;
            this.a = imMessageCenterShowItemData;
        }

        @Override // com.repackage.nr4.e
        public void onItemClick(nr4 nr4Var, int i, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, nr4Var, i, view2) == null) {
                if (this.b.j != null && this.b.j.isShowing() && this.b.a != null) {
                    this.b.j.dismiss();
                }
                if (i != 0) {
                    BdLog.e("error prepareMenuDialog");
                    return;
                }
                TiebaStatic.log("c12933");
                this.b.b.asyncDeleteItem(this.a, this.b.k0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ba7 ba7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.a.e0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.d0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.a.g0(customResponsedMessage);
                this.a.s0(false);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.b.setData(null, this.a.i0);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                if (this.a.h != null) {
                    this.a.h.notifyDataSetChanged();
                }
            } else if (customResponsedMessage.getCmd() != 2016011 || this.a.h == null) {
            } else {
                this.a.h.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements h57 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        public d(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // com.repackage.h57
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        public e(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ba7 ba7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                this.a.f0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements i57 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        public g(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // com.repackage.i57
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K();
            }
        }

        @Override // com.repackage.i57
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.K();
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f04a3, false);
                this.a.U();
            }
        }

        @Override // com.repackage.i57
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.y0();
            }
        }

        @Override // com.repackage.i57
        public void onProgressUpdate(int i, String str, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}) == null) || this.a.L == null) {
                return;
            }
            this.a.L.b(i);
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ba7 ba7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                this.a.W((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        public i(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) && i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.a.g.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (i != 0) {
                    if (i == 1 || i == 2) {
                        this.a.g.c();
                        return;
                    }
                    return;
                }
                View childAt = absListView.getChildAt(0);
                if (childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.a.g.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements cu4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        public j(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // com.repackage.cu4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!mi.z()) {
                    if (this.a.d != null) {
                        this.a.d.setRefreshing(false);
                        return;
                    }
                    return;
                }
                this.a.s0(true);
                this.a.h0(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(ba7 ba7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001371 && TbSingleton.getInstance().isImRecForumShow() && !this.a.T) {
                this.a.q0();
                this.a.U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(ba7 ba7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Page page;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z = responsedMessage instanceof MsgRecForumHttpResMessage;
                if (z || (responsedMessage instanceof MsgRecForumSocketResMessage)) {
                    if (responsedMessage.getError() != 0) {
                        if (this.a.O || this.a.a == null || responsedMessage.getError() == -100000303) {
                            return;
                        }
                        this.a.a.showToast(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0c17));
                        this.a.O = true;
                        return;
                    }
                    List<RecommendForumInfo> list = null;
                    if (z) {
                        MsgRecForumHttpResMessage msgRecForumHttpResMessage = (MsgRecForumHttpResMessage) responsedMessage;
                        list = msgRecForumHttpResMessage.forumList;
                        page = msgRecForumHttpResMessage.pageInfo;
                    } else if (responsedMessage instanceof MsgRecForumSocketResMessage) {
                        MsgRecForumSocketResMessage msgRecForumSocketResMessage = (MsgRecForumSocketResMessage) responsedMessage;
                        list = msgRecForumSocketResMessage.forumList;
                        page = msgRecForumSocketResMessage.pageInfo;
                    } else {
                        page = null;
                    }
                    this.a.u0(list);
                    if (page != null) {
                        this.a.R = page.has_more.intValue() == 1;
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        public m(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                vt4.k().u("is_shut_down_validate", true);
                this.a.v0(false);
                this.a.w0(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements ua7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        public n(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        @Override // com.repackage.ua7.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.P == null) {
                return;
            }
            this.a.f.removeHeaderView(this.a.P.e());
            this.a.Q = false;
        }
    }

    /* loaded from: classes5.dex */
    public class o implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba7 a;

        /* loaded from: classes5.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ImMessageCenterShowItemData a;

            public a(o oVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar, imMessageCenterShowItemData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = imMessageCenterShowItemData;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                ImMessageCenterShowItemData imMessageCenterShowItemData;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage == null || (imMessageCenterShowItemData = this.a) == null) {
                        return null;
                    }
                    imMessageCenterShowItemData.setUnReadCount(0);
                    if (this.a.getOwnerName().equals("2")) {
                        g67.f().k("apply_join_group");
                    } else if (this.a.getOwnerName().equals("3")) {
                        g67.f().k("group_intro_change");
                        g67.f().k("group_name_change");
                        g67.f().k("group_notice_change");
                        g67.f().k("group_level_up");
                        g67.f().k("dismiss_group");
                        g67.f().k("kick_out");
                        g67.f().k("group_activitys_change");
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        public o(ba7 ba7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba7Var;
        }

        public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imMessageCenterShowItemData) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", "1").param("obj_param1", imMessageCenterShowItemData.getUnReadCount()).param(TiebaStatic.Params.FRIEND_UID, imMessageCenterShowItemData.getFriendId()));
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    wx4.g0().b0(wx4.g0().x() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.a.a.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public final void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterShowItemData) == null) {
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterShowItemData));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || i < 0) {
                return;
            }
            ImMessageCenterShowItemData item = this.a.h.getItem(i);
            if (!TbSingleton.getInstance().isImRecForumShow() || item == null || item.getDataType() != 2) {
                TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                String ownerName = item.getOwnerName();
                if (TextUtils.isEmpty(ownerName)) {
                    a(item);
                    statisticItem.param("obj_type", 6);
                } else if (ownerName.equals("1")) {
                    if (!h97.b(this.a.a.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                        return;
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getContext(), "chat_list_to_group", "click", 1, new Object[0]);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.a.a.getPageContext().getPageActivity(), mg.g(item.getFriendId(), 0L), item.getFriendName(), 0L, "msg_lstb")));
                } else if (item.getOwnerName().equals("2")) {
                    if (!h97.a(this.a.a.getPageContext().getOrignalPage(), 2008021)) {
                        return;
                    }
                    b(item);
                    statisticItem.param("obj_type", 7);
                    if (wx4.g0().F() != null) {
                        wx4.g0().F().Q(0);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(this.a.a.getPageContext().getPageActivity())));
                } else if (item.getOwnerName().equals("3")) {
                    if (!h97.a(this.a.a.getPageContext().getOrignalPage(), 2008013)) {
                        return;
                    }
                    b(item);
                    if (wx4.g0().F() != null) {
                        wx4.g0().F().O(0);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(this.a.a.getPageContext().getPageActivity())));
                } else if (ownerName.equals("5")) {
                    TiebaStatic.log("c12931");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(this.a.a.getPageContext().getPageActivity())));
                } else if (ownerName.equals("8")) {
                    if (!h97.a(this.a.a.getPageContext().getOrignalPage(), 2002006)) {
                        return;
                    }
                    long g = mg.g(item.getFriendId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.a.getPageContext().getPageActivity(), g, item.getFriendNameShow(), item.getFriendPortrait(), 0, item.getUserType())));
                    if ("801001117".equals(String.valueOf(g))) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE_ENTRANCE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    } else if ("3222425470".equals(String.valueOf(g))) {
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SYSTEM_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                    }
                } else if (ownerName.equals("7")) {
                    TiebaStatic.log(new StatisticItem("c12614"));
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(this.a.a.getPageContext().getPageActivity())));
                    statisticItem.param("obj_type", 6);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_ITEM_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", "2").param("obj_param1", item.getUnReadCount()).param(TiebaStatic.Params.FRIEND_UID, item.getFriendId()));
                    return;
                } else {
                    a(item);
                    statisticItem.param("obj_type", 6);
                }
                if (!TextUtils.isEmpty(item.getFriendName())) {
                    if ("贴吧热榜".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 8);
                    } else if ("贴吧荣誉墙".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 9);
                    } else if ("贴吧精选".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 10);
                    } else if ("贴吧活动".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 4);
                    } else if ("吧广播".equals(item.getFriendName())) {
                        statisticItem.param("obj_type", 5);
                    }
                }
                TiebaStatic.log(statisticItem);
                if (TextUtils.isEmpty(item.getFriendName()) || !this.a.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f13c2).equals(item.getFriendName())) {
                    return;
                }
                TiebaStatic.log(new StatisticItem("c14446").param("uid", TbadkCoreApplication.getCurrentAccount()));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.mContext.getPageActivity()).createNormalCfg(item.getForumName(), FrsActivityConfig.FRS_FROM_IM_REC_FORUM)));
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.IM_REC_FORUM_ITEM_CLICK);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("fid", item.getForumId());
            statisticItem2.param("fname", item.getForumName());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba7(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) f9.a(chatAggregationFragment.getPageContext().getPageActivity()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatAggregationFragment};
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
        this.b = null;
        this.c = null;
        this.f = null;
        this.h = null;
        this.j = null;
        this.m = true;
        this.p = false;
        this.q = false;
        this.r = true;
        this.s = 16;
        this.O = false;
        this.Q = false;
        this.S = false;
        this.T = false;
        this.U = new i(this);
        this.V = new j(this);
        this.W = new k(this, 2001371);
        this.X = new l(this, CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, 309712);
        this.Y = new n(this);
        this.Z = new o(this);
        this.g0 = new a(this);
        this.h0 = new c(this, 0);
        this.i0 = new d(this);
        this.j0 = new f(this, 2001120);
        this.k0 = new g(this);
        this.l0 = new h(this, 2001120);
        this.a = chatAggregationFragment;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            ua7 ua7Var = this.P;
            if (ua7Var != null) {
                this.f.removeHeaderView(ua7Var.e());
                this.Q = false;
                return;
            }
            return;
        }
        long m2 = vt4.k().m("key_im_open_notification_close_time", 0L);
        if (this.Q) {
            return;
        }
        if (m2 == 0 || System.currentTimeMillis() - m2 > 604800000) {
            if (this.P == null) {
                ua7 ua7Var2 = new ua7(this.mContext);
                this.P = ua7Var2;
                ua7Var2.g(this.Y);
            }
            this.f.x(this.P.e(), 0);
            this.Q = true;
        }
    }

    public final void K() {
        fr4 fr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (fr4Var = this.L) != null && fr4Var.isShowing()) {
            this.L.dismiss();
            this.L = null;
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = new ImMessageCenterModel();
            v0(!vt4.k().h("is_shut_down_validate", false));
        }
    }

    public final void M(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            this.n = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090603);
            ShutDownValidateTipView shutDownValidateTipView = (ShutDownValidateTipView) view2.findViewById(R.id.obfuscated_res_0x7f0923af);
            this.i = shutDownValidateTipView;
            shutDownValidateTipView.setVisibility(8);
            this.i.setShutDownClickListener(new m(this));
            this.g = (NavigationBarShadowView) view2.findViewById(R.id.obfuscated_res_0x7f0914fe);
            BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f090604);
            this.f = bdListView;
            bdListView.setDividerHeight(0);
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(this.a.getPageContext().getPageActivity());
            this.h = messageAggregationListAdapter;
            messageAggregationListAdapter.P(this.a.getPageContext());
            this.h.M(this);
            this.f.setAdapter((ListAdapter) this.h);
            this.f.setOnItemClickListener(this.Z);
            this.f.setOnItemLongClickListener(this.g0);
            this.f.setOnScrollListener(this.U);
            View inflate = View.inflate(this.mContext.getPageActivity(), R.layout.obfuscated_res_0x7f0d0552, null);
            this.u = inflate;
            this.v = inflate.findViewById(R.id.obfuscated_res_0x7f0902bf);
            this.w = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0902be);
            this.x = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f0902c1);
            this.y = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f0902c0);
            this.z = this.u.findViewById(R.id.obfuscated_res_0x7f09015c);
            this.A = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f09015b);
            this.B = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090160);
            this.C = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f09015d);
            this.D = this.u.findViewById(R.id.obfuscated_res_0x7f091a54);
            this.E = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f091a53);
            this.F = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f091a57);
            this.G = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f091a55);
            this.H = this.u.findViewById(R.id.obfuscated_res_0x7f090979);
            this.I = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f090978);
            this.J = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f09097d);
            this.K = (MessageRedDotView) this.u.findViewById(R.id.obfuscated_res_0x7f09097a);
            this.y.setThreeDotMode(2);
            this.C.setThreeDotMode(2);
            this.G.setThreeDotMode(2);
            this.K.setThreeDotMode(2);
            this.y.setShadowEnabled(false);
            this.C.setShadowEnabled(false);
            this.G.setShadowEnabled(false);
            this.v.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.f.addHeaderView(this.u);
            I();
            this.d = (BdSwipeRefreshLayout) view2.findViewById(R.id.obfuscated_res_0x7f091a56);
            if (this.e == null) {
                du4 du4Var = new du4(this.a.getPageContext());
                this.e = du4Var;
                du4Var.f(this.V);
            }
            this.e.a0(getPageContext().getUniqueId());
            this.d.setProgressView(this.e);
            this.t = new View(this.a.getFragmentActivity());
            this.t.setLayoutParams(new AbsListView.LayoutParams(-1, oi.f(this.a.getFragmentActivity(), R.dimen.obfuscated_res_0x7f070250)));
            this.f.addFooterView(this.t);
        }
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TbadkCoreApplication.isLogin() : invokeV.booleanValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void P(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            int i2 = MentionActivityConfig.jumpInTab;
            if (i2 != -1) {
                this.s = i2;
                MentionActivityConfig.jumpInTab = -1;
            } else if (bundle != null) {
                this.s = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.s);
            }
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.h0);
            MessageManager.getInstance().unRegisterListener(this.j0);
            MessageManager.getInstance().unRegisterListener(this.l0);
            if (TbSingleton.getInstance().isImRecForumShow() && this.T) {
                MessageManager.getInstance().unRegisterListener(this.X);
                MessageManager.getInstance().unRegisterTask(309712);
                MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST);
            }
            MessageManager.getInstance().unRegisterListener(this.W);
        }
    }

    public void S() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (messageAggregationListAdapter = this.h) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public boolean T(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, tbPageContext, i2)) == null) {
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.f(this.a.getPageContext(), i2);
            }
            ShutDownValidateTipView shutDownValidateTipView = this.i;
            if (shutDownValidateTipView != null) {
                shutDownValidateTipView.b(i2);
            }
            MessageAggregationListAdapter messageAggregationListAdapter = this.h;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.notifyDataSetChanged();
            }
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().j(this.n);
            }
            du4 du4Var = this.e;
            if (du4Var != null) {
                du4Var.H(i2);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.d, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.B, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.F, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.J, (int) R.color.CAM_X0105);
            SkinManager.setImageResource(this.w, R.drawable.pic_information_at_me);
            SkinManager.setImageResource(this.A, R.drawable.pic_information_praise);
            SkinManager.setImageResource(this.E, R.drawable.pic_information_reply);
            SkinManager.setImageResource(this.I, R.drawable.pic_information_fans);
            MessageRedDotView messageRedDotView = this.y;
            if (messageRedDotView != null) {
                messageRedDotView.e();
            }
            MessageRedDotView messageRedDotView2 = this.C;
            if (messageRedDotView2 != null) {
                messageRedDotView2.e();
            }
            MessageRedDotView messageRedDotView3 = this.G;
            if (messageRedDotView3 != null) {
                messageRedDotView3.e();
            }
            MessageRedDotView messageRedDotView4 = this.K;
            if (messageRedDotView4 != null) {
                messageRedDotView4.e();
            }
            ua7 ua7Var = this.P;
            if (ua7Var != null) {
                ua7Var.f(i2);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void U() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdListView = this.f) == null || this.b == null) {
            return;
        }
        bdListView.A(0L);
        if (this.b.getData() != null && this.b.getData().size() > 0) {
            this.h.n(this.b.getData());
            if (!TbSingleton.getInstance().isImRecForumShow() || this.S) {
                return;
            }
            this.S = true;
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
            statisticItem.param("obj_param1", "0").param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
            return;
        }
        if (TbSingleton.getInstance().isImRecForumShow()) {
            MsgRecForumNetMessage msgRecForumNetMessage = new MsgRecForumNetMessage();
            msgRecForumNetMessage.mPn = 1;
            msgRecForumNetMessage.mRn = 15;
            msgRecForumNetMessage.userId = Long.valueOf(TbadkCoreApplication.getCurrentAccountId());
            this.a.sendMessage(msgRecForumNetMessage);
            if (!this.S) {
                this.S = true;
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.IM_TAB_SHOW_KEY);
                statisticItem2.param("obj_param1", "1").param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem2);
            }
        }
        x0(N(), true);
    }

    public View V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.o = LayoutInflater.from(getActivity()).inflate(R.layout.obfuscated_res_0x7f0d01db, (ViewGroup) null, false);
            L();
            M(this.o);
            TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
            if (TbSingleton.getInstance().isImRecForumShow() && !this.T) {
                q0();
            }
            o0();
            b0();
            return this.o;
        }
        return (View) invokeV.objValue;
    }

    public void W(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, newsNotifyMessage) == null) || newsNotifyMessage == null) {
            return;
        }
        this.M = newsNotifyMessage.getMsgAtme();
        this.N = newsNotifyMessage.getMsgAgree();
        j0(this.M);
        i0(this.N);
        l0(newsNotifyMessage.getMsgFans());
        n0(newsNotifyMessage.getMsgReplyme());
    }

    public void X(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || !z || (bdListView = this.f) == null || bdListView.getWrappedAdapter() == null || this.f.getWrappedAdapter().getCount() > 0) {
            return;
        }
        pg.a().post(new e(this));
    }

    public void Y(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, intent) == null) || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
        this.s = intExtra;
        if (intExtra == -1) {
            return;
        }
        t0(true);
        Z();
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.h;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                t0(true);
            }
            if (this.r || this.q) {
                this.r = false;
                this.q = false;
                h0(false);
            }
            boolean N = N();
            if (this.p != N) {
                this.p = N;
                a0(N);
            }
            NoDataView noDataView = this.l;
            if (noDataView != null) {
                noDataView.d(this.a.getPageContext());
            }
            I();
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            x0(z, true);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.f.F();
            boolean N = N();
            this.p = N;
            if (N) {
                return;
            }
            x0(N, true);
        }
    }

    public final void c0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, imMessageCenterShowItemData) == null) {
            this.k = new b(this, imMessageCenterShowItemData);
            String string = this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f04af);
            lr4 lr4Var = new lr4(this.a.getPageContext());
            this.j = lr4Var;
            lr4Var.j(null, new String[]{string}, this.k);
        }
    }

    public final void d0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                ImMessageCenterModel imMessageCenterModel2 = this.b;
                if (imMessageCenterModel2 != null) {
                    imMessageCenterModel2.insertOrUpdate(data, this.i0);
                }
            } else if (memoryChangedMessage.getType() != 2 || (imMessageCenterModel = this.b) == null) {
            } else {
                imMessageCenterModel.remove(data, this.i0);
            }
        }
    }

    public final void e0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void f0(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            k0();
        }
    }

    public final void g0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 1 || (imMessageCenterModel = this.b) == null) {
                return;
            }
            imMessageCenterModel.setData(data, this.i0);
        }
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.a.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public boolean h0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            if (!z) {
                MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
            } else {
                this.f.A(0L);
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            if (i2 > 0) {
                if (yx4.d().e() == 0) {
                    i2 = 0;
                }
                if (!yx4.d().y()) {
                    i2 = 0;
                }
                this.C.setThreeDotMode(2);
                this.C.f(i2);
                this.C.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public final void j0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            if (i2 > 0) {
                if (yx4.d().e() == 0) {
                    i2 = 0;
                }
                if (!yx4.d().q()) {
                    i2 = 0;
                }
                this.y.setThreeDotMode(2);
                this.y.f(i2);
                this.y.setVisibility(0);
                return;
            }
            this.y.setVisibility(8);
        }
    }

    public final void k0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (messageAggregationListAdapter = this.h) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public final void l0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 > 0) {
                if (yx4.d().e() == 0) {
                    i2 = 0;
                }
                if (!yx4.d().t()) {
                    i2 = 0;
                }
                this.K.setThreeDotMode(2);
                this.K.f(i2);
                this.K.setVisibility(0);
                return;
            }
            this.K.setVisibility(8);
        }
    }

    public void m0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (bdSwipeRefreshLayout = this.d) == null || bdSwipeRefreshLayout.r()) {
            return;
        }
        s0(true);
    }

    public final void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (i2 > 0) {
                if (yx4.d().e() == 0) {
                    i2 = 0;
                }
                if (!yx4.d().v()) {
                    i2 = 0;
                }
                this.G.setThreeDotMode(2);
                this.G.f(i2);
                this.G.setVisibility(0);
                return;
            }
            this.G.setVisibility(8);
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.a.registerListener(2016004, this.h0);
            this.a.registerListener(2016001, this.h0);
            this.a.registerListener(2016010, this.h0);
            this.a.registerListener(2016007, this.h0);
            this.a.registerListener(2016011, this.h0);
            this.a.registerListener(2016002, this.h0);
            this.a.registerListener(this.j0);
            this.a.registerListener(this.l0);
            this.a.registerListener(this.W);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view2) == null) {
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (view2 == this.v) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_AT_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", this.M > 0 ? 1 : 2).param("obj_param1", this.M));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(getPageContext().getPageActivity())));
                wx4.g0().k();
                wx4.g0().Z(0);
                this.M = 0;
                j0(0);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                statisticItem.param("obj_type", 1);
            } else if (view2 == this.z) {
                StatisticItem statisticItem2 = new StatisticItem("c12926");
                MessageRedDotView messageRedDotView = this.C;
                if (messageRedDotView != null && messageRedDotView.getVisibility() == 0) {
                    statisticItem2.addParam("obj_type", 1);
                } else {
                    statisticItem2.addParam("obj_type", 2);
                }
                statisticItem2.eventStat();
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
                wx4.g0().i();
                wx4.g0().Y(0);
                this.N = 0;
                i0(0);
                statisticItem.param("obj_type", 2);
            } else if (view2 == this.D) {
                int A = wx4.g0().A();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_REPLY_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", A > 0 ? 1 : 2).param("obj_param1", A));
                ReplyMeActivityConfig replyMeActivityConfig = new ReplyMeActivityConfig(getPageContext().getPageActivity());
                replyMeActivityConfig.setFrom(1);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, replyMeActivityConfig));
                wx4.g0().p();
                wx4.g0().e0(0);
                n0(0);
            } else if (view2 == this.H) {
                int y = wx4.g0().y();
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_HOME_PAGE_MESSGAE_FANS_CLICK).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", y > 0 ? 1 : 2).param("obj_param1", y));
                PersonRedTipManager.getInstance().updateRedTipState(2, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
                wx4.g0().m();
                wx4.g0().c0(0);
                l0(0);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.repackage.cu4.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            l95 l95Var = new l95(309712);
            l95Var.setResponsedClass(MsgRecForumSocketResMessage.class);
            l95Var.g(true);
            l95Var.h(false);
            l95Var.f(SocketMessageTask.DupLicateMode.NONE);
            MessageManager.getInstance().registerTask(l95Var);
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_GET_MSG_REC_FORUM_LIST, kk8.a("c/f/forum/getMsgRecForumlist", 309712));
            tbHttpMessageTask.setResponsedClass(MsgRecForumHttpResMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.a.registerListener(this.X);
            this.T = true;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.r = z;
        }
    }

    public void s0(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048612, this, z) == null) || this.d == null) {
            return;
        }
        if (z && (bdListView = this.f) != null && bdListView.getFirstVisiblePosition() != 0) {
            this.f.setSelection(0);
        }
        this.d.setRefreshing(z);
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.q = z;
        }
    }

    public final void u0(List<RecommendForumInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ImMessageCenterShowItemData imMessageCenterShowItemData = new ImMessageCenterShowItemData();
        imMessageCenterShowItemData.setDataType(1);
        arrayList.add(imMessageCenterShowItemData);
        ImMessageCenterShowItemData imMessageCenterShowItemData2 = new ImMessageCenterShowItemData();
        imMessageCenterShowItemData2.setDataType(3);
        arrayList.add(imMessageCenterShowItemData2);
        for (RecommendForumInfo recommendForumInfo : list) {
            if (recommendForumInfo != null && !StringUtils.isNull(recommendForumInfo.forum_name)) {
                ImMessageCenterShowItemData imMessageCenterShowItemData3 = new ImMessageCenterShowItemData();
                imMessageCenterShowItemData3.setDataType(2);
                imMessageCenterShowItemData3.setAvatar(recommendForumInfo.avatar);
                imMessageCenterShowItemData3.setForumId(recommendForumInfo.forum_id.longValue());
                imMessageCenterShowItemData3.setForumName(recommendForumInfo.forum_name);
                imMessageCenterShowItemData3.setIsLike(recommendForumInfo.is_like.intValue());
                imMessageCenterShowItemData3.setMemberCount(recommendForumInfo.member_count.intValue());
                imMessageCenterShowItemData3.setSlogan(recommendForumInfo.slogan);
                imMessageCenterShowItemData3.setThreadCount(recommendForumInfo.thread_count.intValue());
                arrayList.add(imMessageCenterShowItemData3);
            }
        }
        ImMessageCenterShowItemData imMessageCenterShowItemData4 = new ImMessageCenterShowItemData();
        imMessageCenterShowItemData4.setDataType(4);
        arrayList.add(imMessageCenterShowItemData4);
        if (this.h.getCount() == 0) {
            this.h.n(arrayList);
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            this.m = z;
        }
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            if (z) {
                if (!O() || this.i.getVisibility() == 0) {
                    return;
                }
                this.i.setVisibility(0);
            } else if (this.i.getVisibility() != 8) {
                this.i.setVisibility(8);
            }
        }
    }

    public void x0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            K();
            if (this.L == null) {
                this.L = h67.m().p(getPageContext().getPageActivity());
            }
            this.L.show();
            this.L.b(0);
        }
    }
}
