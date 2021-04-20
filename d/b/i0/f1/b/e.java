package d.b.i0.f1.b;

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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
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
import d.b.h0.r.f0.f;
import d.b.h0.r.s.l;
import d.b.i0.f1.b.p.e;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends d.b.c.a.d<ChatAggregationFragment> implements f.g, View.OnClickListener {
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
    public d.b.h0.r.s.c P;
    public int Q;
    public int R;
    public d.b.i0.f1.b.p.e S;
    public boolean T;
    public AbsListView.OnScrollListener U;
    public final f.g V;
    public e.b W;
    public final AdapterView.OnItemClickListener X;
    public final AdapterView.OnItemLongClickListener Y;
    public final CustomMessageListener Z;
    public d.b.i0.e1.f.i.a a0;
    public final CustomMessageListener b0;
    public final d.b.i0.e1.f.i.b c0;
    public final CustomMessageListener d0;

    /* renamed from: e  reason: collision with root package name */
    public final ChatAggregationFragment f55824e;

    /* renamed from: f  reason: collision with root package name */
    public ImMessageCenterModel f55825f;

    /* renamed from: g  reason: collision with root package name */
    public ImMessageCenterShowItemData f55826g;

    /* renamed from: h  reason: collision with root package name */
    public BdSwipeRefreshLayout f55827h;
    public d.b.h0.r.f0.g i;
    public BdListView j;
    public NavigationBarShadowView k;
    public MessageAggregationListAdapter l;
    public ShutDownValidateTipView m;
    public d.b.h0.r.s.j n;
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

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2016002) {
                e.this.c0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                e.this.b0(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016007) {
                e.this.f0(customResponsedMessage);
                e.this.s0(false);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                e.this.f55825f.setData(null, e.this.a0);
            } else if (customResponsedMessage.getCmd() == 2016010) {
                if (e.this.l != null) {
                    e.this.l.notifyDataSetChanged();
                }
            } else if (customResponsedMessage.getCmd() != 2016011 || e.this.l == null) {
            } else {
                e.this.l.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.e1.f.i.a {
        public b() {
        }

        @Override // d.b.i0.e1.f.i.a
        public void onComplete() {
            e.this.Q();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.j.F();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                e.this.d0(customResponsedMessage);
            }
        }
    }

    /* renamed from: d.b.i0.f1.b.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1295e implements d.b.i0.e1.f.i.b {
        public C1295e() {
        }

        @Override // d.b.i0.e1.f.i.b
        public void onCanceled() {
            e.this.F();
        }

        @Override // d.b.i0.e1.f.i.b
        public void onPostExecute() {
            e.this.F();
            e.this.f55824e.showToast(R.string.delete_success, false);
            e.this.Q();
        }

        @Override // d.b.i0.e1.f.i.b
        public void onPreExecute() {
            e.this.x0();
        }

        @Override // d.b.i0.e1.f.i.b
        public void onProgressUpdate(int i, String str, int i2) {
            if (e.this.P != null) {
                e.this.P.b(i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage)) {
                e.this.S((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements AbsListView.OnScrollListener {
        public g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                e.this.k.a();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                if (i == 1 || i == 2) {
                    e.this.k.c();
                    return;
                }
                return;
            }
            View childAt = absListView.getChildAt(0);
            if (childAt == null || childAt.getTop() != 0) {
                return;
            }
            e.this.k.a();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements f.g {
        public h() {
        }

        @Override // d.b.h0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (!d.b.c.e.p.j.z()) {
                if (e.this.f55827h != null) {
                    e.this.f55827h.setRefreshing(false);
                    return;
                }
                return;
            }
            e.this.s0(true);
            e.this.g0(false);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.r.d0.b.j().t("is_shut_down_validate", true);
            e.this.u0(false);
            e.this.v0(false);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements e.b {
        public j() {
        }

        @Override // d.b.i0.f1.b.p.e.b
        public void onClose() {
            if (e.this.S != null) {
                e.this.j.removeHeaderView(e.this.S.e());
                e.this.T = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements AdapterView.OnItemClickListener {

        /* loaded from: classes4.dex */
        public class a implements CustomMessageTask.CustomRunnable<String> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ ImMessageCenterShowItemData f55839e;

            public a(k kVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
                this.f55839e = imMessageCenterShowItemData;
            }

            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                ImMessageCenterShowItemData imMessageCenterShowItemData;
                if (customMessage == null || (imMessageCenterShowItemData = this.f55839e) == null) {
                    return null;
                }
                imMessageCenterShowItemData.setUnReadCount(0);
                if (this.f55839e.getOwnerName().equals("2")) {
                    d.b.i0.e1.h.d.f().k("apply_join_group");
                } else if (this.f55839e.getOwnerName().equals("3")) {
                    d.b.i0.e1.h.d.f().k("group_intro_change");
                    d.b.i0.e1.h.d.f().k("group_name_change");
                    d.b.i0.e1.h.d.f().k("group_notice_change");
                    d.b.i0.e1.h.d.f().k("group_level_up");
                    d.b.i0.e1.h.d.f().k("dismiss_group");
                    d.b.i0.e1.h.d.f().k("kick_out");
                    d.b.i0.e1.h.d.f().k("group_activitys_change");
                }
                return null;
            }
        }

        public k() {
        }

        public final void a(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            if (imMessageCenterShowItemData.getUnReadCount() > 0) {
                d.b.h0.s.d.b.g0().b0(d.b.h0.s.d.b.g0().x() - imMessageCenterShowItemData.getUnReadCount());
                imMessageCenterShowItemData.setUnReadCount(0);
            }
            try {
                long parseLong = Long.parseLong(imMessageCenterShowItemData.getFriendId());
                TiebaStatic.log("tab_msg_personal_chat_click");
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), TbConfig.ST_TYPE_PCHAT, null, 1, "st_param", "1");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(e.this.f55824e.getPageContext().getPageActivity(), parseLong, imMessageCenterShowItemData.getFriendName(), imMessageCenterShowItemData.getFriendNameShow(), imMessageCenterShowItemData.getFriendPortrait(), 0)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        public final void b(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new a(this, imMessageCenterShowItemData));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0) {
                return;
            }
            ImMessageCenterShowItemData item = e.this.l.getItem(i);
            TiebaStatic.eventStat(e.this.f55824e.getPageContext().getPageActivity(), "list_to_chat", "chatlistclick", 1, new Object[0]);
            StatisticItem statisticItem = new StatisticItem("c13720");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            String ownerName = item.getOwnerName();
            if (TextUtils.isEmpty(ownerName)) {
                a(item);
                statisticItem.param("obj_type", 6);
            } else if (ownerName.equals("1")) {
                if (!d.b.i0.f1.a.b.a.a.b(e.this.f55824e.getPageContext().getOrignalPage(), GroupChatActivityConfig.class)) {
                    return;
                }
                TiebaStatic.eventStat(e.this.f55824e.getPageContext().getContext(), "chat_list_to_group", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(e.this.f55824e.getPageContext().getPageActivity(), d.b.c.e.m.b.f(item.getFriendId(), 0L), item.getFriendName(), 0L, "msg_lstb")));
            } else if (item.getOwnerName().equals("2")) {
                if (!d.b.i0.f1.a.b.a.a.a(e.this.f55824e.getPageContext().getOrignalPage(), 2008021)) {
                    return;
                }
                b(item);
                statisticItem.param("obj_type", 7);
                if (d.b.h0.s.d.b.g0().F() != null) {
                    d.b.h0.s.d.b.g0().F().Q(0);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2008021, new ValidateActivityConfig(e.this.f55824e.getPageContext().getPageActivity())));
            } else if (item.getOwnerName().equals("3")) {
                if (!d.b.i0.f1.a.b.a.a.a(e.this.f55824e.getPageContext().getOrignalPage(), 2008013)) {
                    return;
                }
                b(item);
                if (d.b.h0.s.d.b.g0().F() != null) {
                    d.b.h0.s.d.b.g0().F().O(0);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2008013, new UpdatesActivityConfig(e.this.f55824e.getPageContext().getPageActivity())));
            } else if (ownerName.equals("5")) {
                TiebaStatic.log("c12931");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(e.this.f55824e.getPageContext().getPageActivity())));
            } else if (ownerName.equals("8")) {
                if (!d.b.i0.f1.a.b.a.a.a(e.this.f55824e.getPageContext().getOrignalPage(), 2002006)) {
                    return;
                }
                long f2 = d.b.c.e.m.b.f(item.getFriendId(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(e.this.f55824e.getPageContext().getPageActivity(), f2, item.getFriendNameShow(), item.getFriendPortrait(), 0, item.getUserType())));
                if ("801001117".equals(String.valueOf(f2))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE_ENTRANCE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                } else if ("3222425470".equals(String.valueOf(f2))) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SYSTEM_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            } else if (ownerName.equals("7")) {
                TiebaStatic.log(new StatisticItem("c12614"));
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new StrangerListActivityConfig(e.this.f55824e.getPageContext().getPageActivity())));
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

    /* loaded from: classes4.dex */
    public class l implements AdapterView.OnItemLongClickListener {
        public l() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            e eVar = e.this;
            eVar.f55826g = eVar.l.getItem(i);
            e eVar2 = e.this;
            eVar2.Y(eVar2.f55826g);
            if (e.this.n != null) {
                TiebaStatic.log("c12932");
                e.this.n.l();
                if (e.this.f55824e == null || e.this.f55824e.getActivity() == null) {
                    return true;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                e.this.f55824e.getActivity().getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ImMessageCenterShowItemData f55841e;

        public m(ImMessageCenterShowItemData imMessageCenterShowItemData) {
            this.f55841e = imMessageCenterShowItemData;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(d.b.h0.r.s.l lVar, int i, View view) {
            if (e.this.n != null && e.this.n.isShowing() && e.this.f55824e != null) {
                e.this.n.dismiss();
            }
            if (i != 0) {
                BdLog.e("error prepareMenuDialog");
                return;
            }
            TiebaStatic.log("c12933");
            e.this.f55825f.asyncDeleteItem(this.f55841e, e.this.c0);
        }
    }

    public e(ChatAggregationFragment chatAggregationFragment) {
        super((TbPageContext) d.b.c.a.j.a(chatAggregationFragment.getPageContext().getPageActivity()));
        this.f55825f = null;
        this.f55826g = null;
        this.j = null;
        this.l = null;
        this.n = null;
        this.q = true;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = 16;
        this.T = false;
        this.U = new g();
        this.V = new h();
        this.W = new j();
        this.X = new k();
        this.Y = new l();
        this.Z = new a(0);
        this.a0 = new b();
        this.b0 = new d(2001120);
        this.c0 = new C1295e();
        this.d0 = new f(2001120);
        this.f55824e = chatAggregationFragment;
    }

    public void E() {
        if (this.j == null) {
            return;
        }
        boolean areNotificationsEnabled = NotificationManagerCompat.from(this.mContext.getPageActivity()).areNotificationsEnabled();
        StatisticItem statisticItem = new StatisticItem("c13616");
        statisticItem.param("obj_type", areNotificationsEnabled ? 1 : 2);
        TiebaStatic.log(statisticItem);
        if (areNotificationsEnabled) {
            d.b.i0.f1.b.p.e eVar = this.S;
            if (eVar != null) {
                this.j.removeHeaderView(eVar.e());
                this.T = false;
                return;
            }
            return;
        }
        long l2 = d.b.h0.r.d0.b.j().l("key_im_open_notification_close_time", 0L);
        if (this.T) {
            return;
        }
        if (l2 == 0 || System.currentTimeMillis() - l2 > 604800000) {
            if (this.S == null) {
                d.b.i0.f1.b.p.e eVar2 = new d.b.i0.f1.b.p.e(this.mContext);
                this.S = eVar2;
                eVar2.g(this.W);
            }
            this.j.x(this.S.e(), 0);
            this.T = true;
        }
    }

    public final void F() {
        d.b.h0.r.s.c cVar = this.P;
        if (cVar == null || !cVar.isShowing()) {
            return;
        }
        this.P.dismiss();
        this.P = null;
    }

    public final void G() {
        this.f55825f = new ImMessageCenterModel();
        u0(!d.b.h0.r.d0.b.j().g("is_shut_down_validate", false));
    }

    public final void I(View view) {
        this.r = (RelativeLayout) view.findViewById(R.id.chat_list);
        ShutDownValidateTipView shutDownValidateTipView = (ShutDownValidateTipView) view.findViewById(R.id.view_no_validate);
        this.m = shutDownValidateTipView;
        shutDownValidateTipView.setVisibility(8);
        this.m.setShutDownClickListener(new i());
        this.k = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_chat_list);
        BdListView bdListView = (BdListView) view.findViewById(R.id.chat_list_content);
        this.j = bdListView;
        bdListView.setDividerHeight(0);
        MessageAggregationListAdapter messageAggregationListAdapter = new MessageAggregationListAdapter(this.f55824e.getPageContext().getPageActivity());
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
        E();
        this.f55827h = (BdSwipeRefreshLayout) view.findViewById(R.id.reply_me_pull_refresh_layout);
        if (this.i == null) {
            d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f55824e.getPageContext());
            this.i = gVar;
            gVar.b(this.V);
        }
        this.i.Z(getPageContext().getUniqueId());
        this.f55827h.setProgressView(this.i);
        this.x = new View(this.f55824e.getFragmentActivity());
        this.x.setLayoutParams(new AbsListView.LayoutParams(-1, d.b.c.e.p.l.g(this.f55824e.getFragmentActivity(), R.dimen.ds150)));
        this.j.addFooterView(this.x);
    }

    public final boolean J() {
        return TbadkCoreApplication.isLogin();
    }

    public boolean K() {
        return this.q;
    }

    public void L(Bundle bundle) {
        int i2 = MentionActivityConfig.jumpInTab;
        if (i2 != -1) {
            this.w = i2;
            MentionActivityConfig.jumpInTab = -1;
        } else if (bundle != null) {
            this.w = bundle.getInt(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, this.w);
        }
    }

    public void M() {
        MessageManager.getInstance().unRegisterListener(this.Z);
        MessageManager.getInstance().unRegisterListener(this.b0);
        MessageManager.getInstance().unRegisterListener(this.d0);
    }

    public void O() {
        MessageAggregationListAdapter messageAggregationListAdapter = this.l;
        if (messageAggregationListAdapter != null) {
            messageAggregationListAdapter.notifyDataSetChanged();
        }
    }

    public boolean P(TbPageContext<?> tbPageContext, int i2) {
        NoDataView noDataView = this.p;
        if (noDataView != null) {
            noDataView.f(this.f55824e.getPageContext(), i2);
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
        d.b.h0.r.f0.g gVar = this.i;
        if (gVar != null) {
            gVar.I(i2);
        }
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f55827h, R.color.CAM_X0205);
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
        d.b.i0.f1.b.p.e eVar = this.S;
        if (eVar != null) {
            eVar.f(i2);
            return true;
        }
        return true;
    }

    public final void Q() {
        BdListView bdListView = this.j;
        if (bdListView == null || this.f55825f == null) {
            return;
        }
        bdListView.A(0L);
        if (this.f55825f.getData() != null) {
            this.l.n(this.f55825f.getData());
        } else {
            w0(J(), true);
        }
    }

    public View R() {
        this.s = LayoutInflater.from(getActivity()).inflate(R.layout.chat_list_activity, (ViewGroup) null, false);
        G();
        I(this.s);
        TiebaStatic.eventStat(getActivity(), "enter_chatlist", "chatlistclick", 1, new Object[0]);
        p0();
        X();
        return this.s;
    }

    public void S(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
            return;
        }
        this.Q = newsNotifyMessage.getMsgAtme();
        this.R = newsNotifyMessage.getMsgAgree();
        i0(this.Q);
        h0(this.R);
        m0(newsNotifyMessage.getMsgFans());
        o0(newsNotifyMessage.getMsgReplyme());
    }

    public void T(boolean z) {
        BdListView bdListView;
        if (z && (bdListView = this.j) != null && bdListView.getWrappedAdapter() != null && this.j.getWrappedAdapter().getCount() <= 0) {
            d.b.c.e.m.e.a().post(new c());
        }
    }

    public void U(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1);
            this.w = intExtra;
            if (intExtra == -1) {
                return;
            }
            t0(true);
            V();
        }
    }

    public void V() {
        MessageAggregationListAdapter messageAggregationListAdapter = this.l;
        if (messageAggregationListAdapter != null && messageAggregationListAdapter.getCount() == 0) {
            t0(true);
        }
        if (this.v || this.u) {
            this.v = false;
            this.u = false;
            g0(false);
        }
        boolean J = J();
        if (this.t != J) {
            this.t = J;
            W(J);
        }
        NoDataView noDataView = this.p;
        if (noDataView != null) {
            noDataView.d(this.f55824e.getPageContext());
        }
        E();
    }

    public void W(boolean z) {
        w0(z, true);
    }

    public void X() {
        this.j.F();
        boolean J = J();
        this.t = J;
        if (J) {
            return;
        }
        w0(J, true);
    }

    public final void Y(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        this.o = new m(imMessageCenterShowItemData);
        String string = this.f55824e.getPageContext().getPageActivity().getString(R.string.delete_user_chat);
        d.b.h0.r.s.j jVar = new d.b.h0.r.s.j(this.f55824e.getPageContext());
        this.n = jVar;
        jVar.i(null, new String[]{string}, this.o);
    }

    public final void b0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (memoryChangedMessage.getType() == 1) {
                ImMessageCenterModel imMessageCenterModel2 = this.f55825f;
                if (imMessageCenterModel2 != null) {
                    imMessageCenterModel2.insertOrUpdate(data, this.a0);
                }
            } else if (memoryChangedMessage.getType() != 2 || (imMessageCenterModel = this.f55825f) == null) {
            } else {
                imMessageCenterModel.remove(data, this.a0);
            }
        }
    }

    public final void c0(CustomResponsedMessage<?> customResponsedMessage) {
        if ((customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void d0(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
        } else {
            j0();
        }
    }

    public final void f0(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterModel imMessageCenterModel;
        if (customResponsedMessage instanceof ResponsedMemoryListMessage) {
            ResponsedMemoryListMessage responsedMemoryListMessage = (ResponsedMemoryListMessage) customResponsedMessage;
            List<ImMessageCenterPojo> data = responsedMemoryListMessage.getData();
            if (responsedMemoryListMessage.getType() != 1 || (imMessageCenterModel = this.f55825f) == null) {
                return;
            }
            imMessageCenterModel.setData(data, this.a0);
        }
    }

    public boolean g0(boolean z) {
        if (!z) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        } else {
            this.j.A(0L);
        }
        return true;
    }

    public Activity getActivity() {
        return this.f55824e.getPageContext().getPageActivity();
    }

    public final void h0(int i2) {
        if (i2 > 0) {
            if (d.b.h0.s.d.d.d().e() == 0) {
                i2 = 0;
            }
            if (!d.b.h0.s.d.d.d().w()) {
                i2 = 0;
            }
            this.G.setThreeDotMode(2);
            this.G.f(i2);
            this.G.setVisibility(0);
            return;
        }
        this.G.setVisibility(8);
    }

    public final void i0(int i2) {
        if (i2 > 0) {
            if (d.b.h0.s.d.d.d().e() == 0) {
                i2 = 0;
            }
            if (!d.b.h0.s.d.d.d().o()) {
                i2 = 0;
            }
            this.C.setThreeDotMode(2);
            this.C.f(i2);
            this.C.setVisibility(0);
            return;
        }
        this.C.setVisibility(8);
    }

    public final void j0() {
        MessageAggregationListAdapter messageAggregationListAdapter = this.l;
        if (messageAggregationListAdapter == null) {
            return;
        }
        messageAggregationListAdapter.notifyDataSetChanged();
    }

    public final void m0(int i2) {
        if (i2 > 0) {
            if (d.b.h0.s.d.d.d().e() == 0) {
                i2 = 0;
            }
            if (!d.b.h0.s.d.d.d().r()) {
                i2 = 0;
            }
            this.O.setThreeDotMode(2);
            this.O.f(i2);
            this.O.setVisibility(0);
            return;
        }
        this.O.setVisibility(8);
    }

    public void n0() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f55827h;
        if (bdSwipeRefreshLayout == null || bdSwipeRefreshLayout.r()) {
            return;
        }
        s0(true);
    }

    public final void o0(int i2) {
        if (i2 > 0) {
            if (d.b.h0.s.d.d.d().e() == 0) {
                i2 = 0;
            }
            if (!d.b.h0.s.d.d.d().t()) {
                i2 = 0;
            }
            this.K.setThreeDotMode(2);
            this.K.f(i2);
            this.K.setVisibility(0);
            return;
        }
        this.K.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StatisticItem statisticItem = new StatisticItem("c13720");
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        if (view == this.z) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(getPageContext().getPageActivity())));
            d.b.h0.s.d.b.g0().k();
            d.b.h0.s.d.b.g0().Z(0);
            this.Q = 0;
            i0(0);
            TiebaStatic.log("c12925");
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "msg_atme_tab_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            statisticItem.param("obj_type", 1);
        } else if (view == this.D) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(getPageContext().getPageActivity())));
            d.b.h0.s.d.b.g0().i();
            d.b.h0.s.d.b.g0().Y(0);
            this.R = 0;
            h0(0);
            TiebaStatic.log("c12926");
            statisticItem.param("obj_type", 2);
        } else if (view == this.H) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ReplyMeActivityConfig(getPageContext().getPageActivity())));
            d.b.h0.s.d.b.g0().p();
            d.b.h0.s.d.b.g0().e0(0);
            o0(0);
        } else if (view == this.L) {
            d.b.i0.t2.a.v().L(2, false, true);
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.mContext.getPageActivity(), false, TbadkCoreApplication.getCurrentAccount(), 0)));
            d.b.h0.s.d.b.g0().m();
            d.b.h0.s.d.b.g0().c0(0);
            m0(0);
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // d.b.h0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
    }

    public final void p0() {
        this.f55824e.registerListener(2016004, this.Z);
        this.f55824e.registerListener(2016001, this.Z);
        this.f55824e.registerListener(2016010, this.Z);
        this.f55824e.registerListener(2016007, this.Z);
        this.f55824e.registerListener(2016011, this.Z);
        this.f55824e.registerListener(2016002, this.Z);
        this.f55824e.registerListener(this.b0);
        this.f55824e.registerListener(this.d0);
    }

    public void r0(boolean z) {
        this.v = z;
    }

    public void s0(boolean z) {
        BdListView bdListView;
        if (this.f55827h != null) {
            if (z && (bdListView = this.j) != null && bdListView.getFirstVisiblePosition() != 0) {
                this.j.setSelection(0);
            }
            this.f55827h.setRefreshing(z);
        }
    }

    public void t0(boolean z) {
        this.u = z;
    }

    public void u0(boolean z) {
        this.q = z;
    }

    public void v0(boolean z) {
        if (z) {
            if (!K() || this.m.getVisibility() == 0) {
                return;
            }
            this.m.setVisibility(0);
        } else if (this.m.getVisibility() != 8) {
            this.m.setVisibility(8);
        }
    }

    public void w0(boolean z, boolean z2) {
    }

    public final void x0() {
        F();
        if (this.P == null) {
            this.P = d.b.i0.e1.h.e.m().p(getPageContext().getPageActivity());
        }
        this.P.show();
        this.P.b(0);
    }
}
