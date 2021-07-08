package d.a.p0.j1.b;

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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.data.NewsNotifyMessage;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.f0.f;
import d.a.o0.r.s.l;
import d.a.p0.j1.b.p.e;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends d.a.c.a.d<ChatAggregationFragment> implements f.g, View.OnClickListener {
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
    public View L;
    public ImageView M;
    public TextView N;
    public MessageRedDotView O;
    public d.a.o0.r.s.c P;
    public int Q;
    public int R;
    public d.a.p0.j1.b.p.e S;
    public boolean T;
    public AbsListView.OnScrollListener U;
    public final f.g V;
    public e.b W;
    public final AdapterView.OnItemClickListener X;
    public final AdapterView.OnItemLongClickListener Y;
    public final CustomMessageListener Z;
    public d.a.p0.i1.f.i.a a0;
    public final CustomMessageListener b0;
    public final d.a.p0.i1.f.i.b c0;

    /* renamed from: e  reason: collision with root package name */
    public final ChatAggregationFragment f58967e;

    /* renamed from: f  reason: collision with root package name */
    public ImMessageCenterModel f58968f;

    /* renamed from: g  reason: collision with root package name */
    public ImMessageCenterShowItemData f58969g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f58970h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.r.f0.g f58971i;
    public final CustomMessageListener i0;
    public BdListView j;
    public NavigationBarShadowView k;
    public MessageAggregationListAdapter l;
    public ShutDownValidateTipView m;
    public d.a.o0.r.s.j n;
    public l.e o;
    public NoDataView p;
    public boolean q;
    public RelativeLayout r;
    public View s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public View x;
    public View y;
    public View z;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f58972a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58972a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                this.f58972a.a0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.f58972a.Z(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                this.f58972a.c0(customResponsedMessage);
                this.f58972a.p0(false);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.f58972a.f58968f.setData(null, this.f58972a.a0);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                if (this.f58972a.l != null) {
                    this.f58972a.l.notifyDataSetChanged();
                }
            } else if (customResponsedMessage.getCmd() != 2016011 || this.f58972a.l == null) {
            } else {
                this.f58972a.l.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.p0.i1.f.i.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f58973a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58973a = eVar;
        }

        @Override // d.a.p0.i1.f.i.a
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58973a.O();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f58974e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58974e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58974e.j.F();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f58975a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58975a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                this.f58975a.b0(customResponsedMessage);
            }
        }
    }

    /* renamed from: d.a.p0.j1.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1496e implements d.a.p0.i1.f.i.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f58976a;

        public C1496e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58976a = eVar;
        }

        @Override // d.a.p0.i1.f.i.b
        public void onCanceled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58976a.B();
            }
        }

        @Override // d.a.p0.i1.f.i.b
        public void onPostExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f58976a.B();
                this.f58976a.f58967e.showToast(R.string.delete_success, false);
                this.f58976a.O();
            }
        }

        @Override // d.a.p0.i1.f.i.b
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f58976a.x0();
            }
        }

        @Override // d.a.p0.i1.f.i.b
        public void onProgressUpdate(int i2, String str, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)}) == null) || this.f58976a.P == null) {
                return;
            }
            this.f58976a.P.b(i2);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f58977a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58977a = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                this.f58977a.Q((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f58978e;

        public g(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58978e = eVar;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) && i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                this.f58978e.k.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2) {
                        this.f58978e.k.c();
                        return;
                    }
                    return;
                }
                View childAt = absListView.getChildAt(0);
                if (childAt == null || childAt.getTop() != 0) {
                    return;
                }
                this.f58978e.k.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f58979e;

        public h(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58979e = eVar;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!d.a.c.e.p.j.z()) {
                    if (this.f58979e.f58970h != null) {
                        this.f58979e.f58970h.setRefreshing(false);
                        return;
                    }
                    return;
                }
                this.f58979e.p0(true);
                this.f58979e.d0(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f58980e;

        public i(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58980e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.o0.r.d0.b.j().t("is_shut_down_validate", true);
                this.f58980e.s0(false);
                this.f58980e.t0(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements e.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f58981a;

        public j(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58981a = eVar;
        }

        @Override // d.a.p0.j1.b.p.e.b
        public void onClose() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58981a.S == null) {
                return;
            }
            this.f58981a.j.removeHeaderView(this.f58981a.S.e());
            this.f58981a.T = false;
        }
    }

    /* loaded from: classes8.dex */
    public class k implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f58982e;

        /* loaded from: classes8.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterShowItemData f58983e;

            public a(k kVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, imMessageCenterShowItemData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58983e = imMessageCenterShowItemData;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                InterceptResult invokeL;
                ImMessageCenterShowItemData imMessageCenterShowItemData;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                    if (customMessage == null || (imMessageCenterShowItemData = this.f58983e) == null) {
                        return null;
                    }
                    imMessageCenterShowItemData.setUnReadCount(0);
                    if (this.f58983e.getOwnerName().equals("2")) {
                        d.a.p0.i1.h.d.f().k("apply_join_group");
                    } else if (this.f58983e.getOwnerName().equals("3")) {
                        d.a.p0.i1.h.d.f().k("group_intro_change");
                        d.a.p0.i1.h.d.f().k("group_name_change");
                        d.a.p0.i1.h.d.f().k("group_notice_change");
                        d.a.p0.i1.h.d.f().k("group_level_up");
                        d.a.p0.i1.h.d.f().k("dismiss_group");
                        d.a.p0.i1.h.d.f().k("kick_out");
                        d.a.p0.i1.h.d.f().k("group_activitys_change");
                    }
                    return null;
                }
                return (CustomResponsedMessage) invokeL.objValue;
            }
        }

        public k(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58982e = eVar;
        }

        public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, imMessageCenterShowItemData) == null) {
                if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                    d.a.o0.s.d.b.g0().b0(d.a.o0.s.d.b.g0().x() - imMessageCenterShowItemData.getUnReadCount());
                    imMessageCenterShowItemData.setUnReadCount(0);
                }
                try {
                    long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                    TiebaStatic.log("tab_msg_personal_chat_click");
                    TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.f58982e.f58967e.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
                } catch (Exception e2) {
                    e2.printStackTrace();
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || i2 < 0) {
                return;
            }
            ImMessageCenterShowItemData item = this.f58982e.l.getItem(i2);
            TiebaStatic.eventStat(this.f58982e.f58967e.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            String ownerName = item.getOwnerName();
            if (TextUtils.isEmpty(ownerName)) {
                a(item);
                statisticItem.param("obj_type", 6);
            } else if (ownerName.equals("1")) {
                if (!d.a.p0.j1.a.b.a.a.b(this.f58982e.f58967e.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                    return;
                }
                TiebaStatic.eventStat(this.f58982e.f58967e.getPageContext().getContext(), "chat_list_to_group", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.f58982e.f58967e.getPageContext().getPageActivity(), d.a.c.e.m.b.f(item.getFriendId(), 0L), item.getFriendName(), 0L, "msg_lstb")));
            } else if (item.getOwnerName().equals("2")) {
                if (!d.a.p0.j1.a.b.a.a.a(this.f58982e.f58967e.getPageContext().getOrignalPage(), 2008021)) {
                    return;
                }
                b(item);
                statisticItem.param("obj_type", 7);
                if (d.a.o0.s.d.b.g0().F() != null) {
                    d.a.o0.s.d.b.g0().F().Q(0);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(this.f58982e.f58967e.getPageContext().getPageActivity())));
            } else if (item.getOwnerName().equals("3")) {
                if (!d.a.p0.j1.a.b.a.a.a(this.f58982e.f58967e.getPageContext().getOrignalPage(), 2008013)) {
                    return;
                }
                b(item);
                if (d.a.o0.s.d.b.g0().F() != null) {
                    d.a.o0.s.d.b.g0().F().O(0);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(this.f58982e.f58967e.getPageContext().getPageActivity())));
            } else if (ownerName.equals("5")) {
                TiebaStatic.log("c12931");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(this.f58982e.f58967e.getPageContext().getPageActivity())));
            } else if (ownerName.equals("8")) {
                if (!d.a.p0.j1.a.b.a.a.a(this.f58982e.f58967e.getPageContext().getOrignalPage(), 2002006)) {
                    return;
                }
                long f2 = d.a.c.e.m.b.f(item.getFriendId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.f58982e.f58967e.getPageContext().getPageActivity(), f2, item.getFriendNameShow(), item.getFriendPortrait(), 0, item.getUserType())));
                if ("801001117".equals(String.valueOf(f2))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE_ENTRANCE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                } else if ("3222425470".equals(String.valueOf(f2))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SYSTEM_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            } else if (ownerName.equals("7")) {
                TiebaStatic.log(new StatisticItem("c12614"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(this.f58982e.f58967e.getPageContext().getPageActivity())));
                statisticItem.param("obj_type", 6);
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
        }
    }

    /* loaded from: classes8.dex */
    public class l implements AdapterView.OnItemLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f58984e;

        public l(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58984e = eVar;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                e eVar = this.f58984e;
                eVar.f58969g = eVar.l.getItem(i2);
                e eVar2 = this.f58984e;
                eVar2.Y(eVar2.f58969g);
                if (this.f58984e.n != null) {
                    TiebaStatic.log("c12932");
                    this.f58984e.n.l();
                    if (this.f58984e.f58967e == null || this.f58984e.f58967e.getActivity() == null) {
                        return true;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f58984e.f58967e.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                    return true;
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class m implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f58985e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f58986f;

        public m(e eVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, imMessageCenterShowItemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58986f = eVar;
            this.f58985e = imMessageCenterShowItemData;
        }

        @Override // d.a.o0.r.s.l.e
        public void onItemClick(d.a.o0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (this.f58986f.n != null && this.f58986f.n.isShowing() && this.f58986f.f58967e != null) {
                    this.f58986f.n.dismiss();
                }
                if (i2 != 0) {
                    BdLog.e("error prepareMenuDialog");
                    return;
                }
                TiebaStatic.log("c12933");
                this.f58986f.f58968f.asyncDeleteItem(this.f58985e, this.f58986f.c0);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) d.a.c.a.j.a(chatAggregationFragment.getPageContext().getPageActivity()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatAggregationFragment};
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
        this.f58968f = null;
        this.f58969g = null;
        this.j = null;
        this.l = null;
        this.n = null;
        this.q = true;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = 16;
        this.T = false;
        this.U = new g(this);
        this.V = new h(this);
        this.W = new j(this);
        this.X = new k(this);
        this.Y = new l(this);
        this.Z = new a(this, 0);
        this.a0 = new b(this);
        this.b0 = new d(this, 2001120);
        this.c0 = new C1496e(this);
        this.i0 = new f(this, 2001120);
        this.f58967e = chatAggregationFragment;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.j == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            d.a.p0.j1.b.p.e eVar = this.S;
            if (eVar != null) {
                this.j.removeHeaderView(eVar.e());
                this.T = false;
                return;
            }
            return;
        }
        long l2 = d.a.o0.r.d0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.T) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.S == null) {
                d.a.p0.j1.b.p.e eVar2 = new d.a.p0.j1.b.p.e(this.mContext);
                this.S = eVar2;
                eVar2.g(this.W);
            }
            this.j.x(this.S.e(), 0);
            this.T = true;
        }
    }

    public final void B() {
        d.a.o0.r.s.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cVar = this.P) != null && cVar.isShowing()) {
            this.P.dismiss();
            this.P = null;
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f58968f = new ImMessageCenterModel();
            s0(!d.a.o0.r.d0.b.j().g("is_shut_down_validate", false));
        }
    }

    public final void G(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.r = (RelativeLayout) view.findViewById(R.id.chat_list);
            ShutDownValidateTipView shutDownValidateTipView = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
            this.m = shutDownValidateTipView;
            shutDownValidateTipView.setVisibility(8);
            this.m.setShutDownClickListener(new i(this));
            this.k = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
            BdListView bdListView = (BdListView) view.findViewById(R.id.chat_list_content);
            this.j = bdListView;
            bdListView.setDividerHeight(0);
            MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(this.f58967e.getPageContext().getPageActivity());
            this.l = messageAggregationListAdapter;
            messageAggregationListAdapter.q(this);
            this.j.setAdapter((ListAdapter) this.l);
            this.j.setOnItemClickListener(this.X);
            this.j.setOnItemLongClickListener(this.Y);
            this.j.setOnScrollListener(this.U);
            View inflate = View.inflate(this.mContext.getPageActivity(), R.layout.message_list_header, null);
            this.y = inflate;
            this.z = inflate.findViewById(R.id.at_me_layout);
            this.A = (ImageView) this.y.findViewById(R.id.at_me_icon);
            this.B = (TextView) this.y.findViewById(R.id.at_me_text);
            this.C = (MessageRedDotView) this.y.findViewById(R.id.at_me_new_message);
            this.D = this.y.findViewById(R.id.agree_me_layout);
            this.E = (ImageView) this.y.findViewById(R.id.agree_me_icon);
            this.F = (TextView) this.y.findViewById(R.id.agree_me_text);
            this.G = (MessageRedDotView) this.y.findViewById(R.id.agree_me_new_message);
            this.H = this.y.findViewById(R.id.reply_me_layout);
            this.I = (ImageView) this.y.findViewById(R.id.reply_me_icon);
            this.J = (TextView) this.y.findViewById(R.id.reply_me_text);
            this.K = (MessageRedDotView) this.y.findViewById(R.id.reply_me_new_message);
            this.L = this.y.findViewById(R.id.fans_layout);
            this.M = (ImageView) this.y.findViewById(R.id.fans_icon);
            this.N = (TextView) this.y.findViewById(R.id.fans_text);
            this.O = (MessageRedDotView) this.y.findViewById(R.id.fans_new_message);
            this.C.setThreeDotMode(2);
            this.G.setThreeDotMode(2);
            this.K.setThreeDotMode(2);
            this.O.setThreeDotMode(2);
            this.C.setShadowEnabled(false);
            this.G.setShadowEnabled(false);
            this.K.setShadowEnabled(false);
            this.z.setOnClickListener(this);
            this.D.setOnClickListener(this);
            this.H.setOnClickListener(this);
            this.L.setOnClickListener(this);
            this.j.addHeaderView(this.y);
            A();
            this.f58970h = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
            if (this.f58971i == null) {
                d.a.o0.r.f0.g gVar = new d.a.o0.r.f0.g(this.f58967e.getPageContext());
                this.f58971i = gVar;
                gVar.a(this.V);
            }
            this.f58971i.a0(getPageContext().getUniqueId());
            this.f58970h.setProgressView(this.f58971i);
            this.x = new View(this.f58967e.getFragmentActivity());
            this.x.setLayoutParams(new AbsListView.LayoutParams(-1, d.a.c.e.p.l.g(this.f58967e.getFragmentActivity(), R.dimen.ds150)));
            this.j.addFooterView(this.x);
        }
    }

    public final boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? TbadkCoreApplication.isLogin() : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void J(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            int i2 = MentionActivityConfig.jumpInTab;
            if (i2 != -1) {
                this.w = i2;
                MentionActivityConfig.jumpInTab = -1;
            } else if (bundle != null) {
                this.w = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.w);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.Z);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.i0);
        }
    }

    public void L() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (messageAggregationListAdapter = this.l) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public boolean N(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, tbPageContext, i2)) == null) {
            NoDataView noDataView = this.p;
            if (noDataView != null) {
                noDataView.f(this.f58967e.getPageContext(), i2);
            }
            ShutDownValidateTipView shutDownValidateTipView = this.m;
            if (shutDownValidateTipView != null) {
                shutDownValidateTipView.b(i2);
            }
            MessageAggregationListAdapter messageAggregationListAdapter = this.l;
            if (messageAggregationListAdapter != null) {
                messageAggregationListAdapter.notifyDataSetChanged();
            }
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().j(this.r);
            }
            d.a.o0.r.f0.g gVar = this.f58971i;
            if (gVar != null) {
                gVar.I(i2);
            }
            SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.f58970h, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.B, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.F, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.J, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.N, R.color.CAM_X0105);
            SkinManager.setImageResource(this.A, R.drawable.pic_information_at_me);
            SkinManager.setImageResource(this.E, R.drawable.pic_information_praise);
            SkinManager.setImageResource(this.I, R.drawable.pic_information_reply);
            SkinManager.setImageResource(this.M, R.drawable.pic_information_fans);
            MessageRedDotView messageRedDotView = this.C;
            if (messageRedDotView != null) {
                messageRedDotView.e();
            }
            MessageRedDotView messageRedDotView2 = this.G;
            if (messageRedDotView2 != null) {
                messageRedDotView2.e();
            }
            MessageRedDotView messageRedDotView3 = this.K;
            if (messageRedDotView3 != null) {
                messageRedDotView3.e();
            }
            MessageRedDotView messageRedDotView4 = this.O;
            if (messageRedDotView4 != null) {
                messageRedDotView4.e();
            }
            d.a.p0.j1.b.p.e eVar = this.S;
            if (eVar != null) {
                eVar.f(i2);
                return true;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void O() {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (bdListView = this.j) == null || this.f58968f == null) {
            return;
        }
        bdListView.A(0L);
        if (this.f58968f.getData() != null) {
            this.l.n(this.f58968f.getData());
        } else {
            w0(H(), true);
        }
    }

    public View P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            this.s = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
            F();
            G(this.s);
            TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
            l0();
            X();
            return this.s;
        }
        return (View) invokeV.objValue;
    }

    public void Q(NewsNotifyMessage newsNotifyMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, newsNotifyMessage) == null) || newsNotifyMessage == null) {
            return;
        }
        this.Q = newsNotifyMessage.getMsgAtme();
        this.R = newsNotifyMessage.getMsgAgree();
        g0(this.Q);
        f0(this.R);
        i0(newsNotifyMessage.getMsgFans());
        k0(newsNotifyMessage.getMsgReplyme());
    }

    public void R(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || !z || (bdListView = this.j) == null || bdListView.getWrappedAdapter() == null || this.j.getWrappedAdapter().getCount() > 0) {
            return;
        }
        d.a.c.e.m.e.a().post(new c(this));
    }

    public void S(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, intent) == null) || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
        this.w = intExtra;
        if (intExtra == -1) {
            return;
        }
        q0(true);
        T();
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            MessageAggregationListAdapter messageAggregationListAdapter = this.l;
            if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
                q0(true);
            }
            if (this.v || this.u) {
                this.v = false;
                this.u = false;
                d0(false);
            }
            boolean H = H();
            if (this.t != H) {
                this.t = H;
                U(H);
            }
            NoDataView noDataView = this.p;
            if (noDataView != null) {
                noDataView.d(this.f58967e.getPageContext());
            }
            A();
        }
    }

    public void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            w0(z, true);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.j.F();
            boolean H = H();
            this.t = H;
            if (H) {
                return;
            }
            w0(H, true);
        }
    }

    public final void Y(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, imMessageCenterShowItemData) == null) {
            this.o = new m(this, imMessageCenterShowItemData);
            String string = this.f58967e.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
            d.a.o0.r.s.j jVar = new d.a.o0.r.s.j(this.f58967e.getPageContext());
            this.n = jVar;
            jVar.i(null, new String[]{string}, this.o);
        }
    }

    public final void Z(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage)) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                ImMessageCenterModel imMessageCenterModel2 = this.f58968f;
                if (imMessageCenterModel2 != null) {
                    imMessageCenterModel2.insertOrUpdate(data, this.a0);
                }
            } else if (memoryChangedMessage.getType() != 2 || (imMessageCenterModel = this.f58968f) == null) {
            } else {
                imMessageCenterModel.remove(data, this.a0);
            }
        }
    }

    public final void a0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void b0(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, responsedMessage) == null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            h0();
        }
    }

    public final void c0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedMemoryListMessage)) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 1 || (imMessageCenterModel = this.f58968f) == null) {
                return;
            }
            imMessageCenterModel.setData(data, this.a0);
        }
    }

    public boolean d0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
            if (!z) {
                MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
            } else {
                this.j.A(0L);
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void f0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            if (i2 > 0) {
                if (d.a.o0.s.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!d.a.o0.s.d.d.d().w()) {
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

    public final void g0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            if (i2 > 0) {
                if (d.a.o0.s.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!d.a.o0.s.d.d.d().o()) {
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

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f58967e.getPageContext().getPageActivity() : (Activity) invokeV.objValue;
    }

    public final void h0() {
        MessageAggregationListAdapter messageAggregationListAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (messageAggregationListAdapter = this.l) == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public final void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (i2 > 0) {
                if (d.a.o0.s.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!d.a.o0.s.d.d.d().r()) {
                    i2 = 0;
                }
                this.O.setThreeDotMode(2);
                this.O.f(i2);
                this.O.setVisibility(0);
                return;
            }
            this.O.setVisibility(8);
        }
    }

    public void j0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (bdSwipeRefreshLayout = this.f58970h) == null || bdSwipeRefreshLayout.r()) {
            return;
        }
        p0(true);
    }

    public final void k0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            if (i2 > 0) {
                if (d.a.o0.s.d.d.d().e() == 0) {
                    i2 = 0;
                }
                if (!d.a.o0.s.d.d.d().t()) {
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

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.f58967e.registerListener(2016004, this.Z);
            this.f58967e.registerListener(2016001, this.Z);
            this.f58967e.registerListener(2016010, this.Z);
            this.f58967e.registerListener(2016007, this.Z);
            this.f58967e.registerListener(2016011, this.Z);
            this.f58967e.registerListener(2016002, this.Z);
            this.f58967e.registerListener(this.b0);
            this.f58967e.registerListener(this.i0);
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.v = z;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view) == null) {
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (view == this.z) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(getPageContext().getPageActivity())));
                d.a.o0.s.d.b.g0().k();
                d.a.o0.s.d.b.g0().Z(0);
                this.Q = 0;
                g0(0);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                statisticItem.param("obj_type", 1);
            } else if (view == this.D) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
                d.a.o0.s.d.b.g0().i();
                d.a.o0.s.d.b.g0().Y(0);
                this.R = 0;
                f0(0);
                TiebaStatic.log("c12926");
                statisticItem.param("obj_type", 2);
            } else if (view == this.H) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
                d.a.o0.s.d.b.g0().p();
                d.a.o0.s.d.b.g0().e0(0);
                k0(0);
            } else if (view == this.L) {
                d.a.p0.x2.a.v().L(2, false, true);
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
                d.a.o0.s.d.b.g0().m();
                d.a.o0.s.d.b.g0().c0(0);
                i0(0);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.a.o0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
        }
    }

    public void p0(boolean z) {
        BdListView bdListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048611, this, z) == null) || this.f58970h == null) {
            return;
        }
        if (z && (bdListView = this.j) != null && bdListView.getFirstVisiblePosition() != 0) {
            this.j.setSelection(0);
        }
        this.f58970h.setRefreshing(z);
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.u = z;
        }
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.q = z;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            if (z) {
                if (!I() || this.m.getVisibility() == 0) {
                    return;
                }
                this.m.setVisibility(0);
            } else if (this.m.getVisibility() != 8) {
                this.m.setVisibility(8);
            }
        }
    }

    public void w0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            B();
            if (this.P == null) {
                this.P = d.a.p0.i1.h.e.m().p(getPageContext().getPageActivity());
            }
            this.P.show();
            this.P.b(0);
        }
    }
}
