package d.b.j0.i0.m;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import d.b.c.j.e.l;
import d.b.j0.i0.g.a;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f57349a;

    /* renamed from: c  reason: collision with root package name */
    public View f57351c;

    /* renamed from: d  reason: collision with root package name */
    public View f57352d;

    /* renamed from: e  reason: collision with root package name */
    public RecentlyVisitedForumModel f57353e;

    /* renamed from: f  reason: collision with root package name */
    public Vibrator f57354f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57355g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f57356h;
    public TextView i;
    public RecyclerView j;
    public View k;
    public RecentlyVisitedForumListAdapter l;
    public ViewEventCenter o;
    public d.b.j0.i0.h.e p;
    public l q;
    public d.b.j0.i0.d.c r;
    public j s;

    /* renamed from: b  reason: collision with root package name */
    public int f57350b = 3;
    public boolean m = true;
    public boolean n = false;
    public CustomMessageListener t = new a(2156674);
    public CustomMessageListener u = new b(2001011);
    public CustomMessageListener v = new i(2921347);

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (f.this.q == null) {
                    f.this.q = new l(new d.b.c.j.e.j());
                }
                f.this.q.q(f.this.j, 1);
            } else if (f.this.q != null) {
                f.this.q.w();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                f.this.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.B();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.D(false);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements RecentlyVisitedForumListAdapter.a {
        public e() {
        }

        @Override // com.baidu.tieba.enterForum.adapter.RecentlyVisitedForumListAdapter.a
        public void a(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder) {
            View view;
            if (f.this.n || forumViewHolder == null || (view = forumViewHolder.itemView) == null || !(view.getTag() instanceof VisitedForumData)) {
                return;
            }
            VisitedForumData visitedForumData = (VisitedForumData) forumViewHolder.itemView.getTag();
            FrsActivityConfig callFrom = new FrsActivityConfig(f.this.f57349a.getPageActivity()).createNormalCfg(visitedForumData.getForumName(), FrsActivityConfig.FRS_FROM_RECENTLY_VISITED).setCallFrom(4);
            f.this.l(forumViewHolder, callFrom.getIntent(), visitedForumData.v());
            f.this.f57349a.sendMessage(new CustomMessage(2003000, callFrom));
            TiebaStatic.log(new StatisticItem("c13002").param("fid", visitedForumData.getForumId()));
        }
    }

    /* renamed from: d.b.j0.i0.m.f$f  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnLongClickListenerC1360f implements View.OnLongClickListener {
        public View$OnLongClickListenerC1360f() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            f.this.D(true);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.f57353e == null || view.getTag() == null || !(view.getTag() instanceof VisitedForumData)) {
                return;
            }
            VisitedForumData visitedForumData = (VisitedForumData) view.getTag();
            f.this.f57353e.s(visitedForumData);
            TiebaStatic.log(new StatisticItem("c13005").param("fid", visitedForumData.getForumId()));
        }
    }

    /* loaded from: classes4.dex */
    public class h implements a.f {
        public h() {
        }

        @Override // d.b.j0.i0.g.a.f
        public void a(LinkedList<VisitedForumData> linkedList, boolean z) {
            f.this.y(linkedList);
            if (z || f.this.p == null) {
                return;
            }
            f.this.p.c(linkedList, f.this.f57349a.getResources().getDimensionPixelSize(R.dimen.tbds678) + f.this.f57349a.getResources().getDimensionPixelSize(R.dimen.tbds10));
        }

        @Override // d.b.j0.i0.g.a.f
        public void b(int i) {
            f.this.v(i);
        }

        @Override // d.b.j0.i0.g.a.f
        public void onNotify() {
            f.this.u();
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            f.this.m(((Boolean) customResponsedMessage.getData()).booleanValue());
        }
    }

    /* loaded from: classes4.dex */
    public interface j {
        void a();
    }

    /* loaded from: classes4.dex */
    public class k extends RecyclerView.ItemDecoration {

        /* renamed from: a  reason: collision with root package name */
        public int f57366a;

        /* renamed from: b  reason: collision with root package name */
        public int f57367b;

        /* renamed from: c  reason: collision with root package name */
        public int f57368c;

        public k(f fVar, int i, int i2, int i3) {
            this.f57366a = i;
            this.f57367b = i2;
            this.f57368c = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if (linearLayoutManager.getOrientation() == 1) {
                if (recyclerView.getChildAdapterPosition(view) == 0) {
                    rect.top = this.f57366a;
                } else {
                    rect.top = this.f57367b;
                }
                if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                    rect.bottom = this.f57368c;
                    return;
                }
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = this.f57366a;
            } else {
                rect.left = this.f57367b;
            }
            if (recyclerView.getChildAdapterPosition(view) == linearLayoutManager.getItemCount() - 1) {
                rect.right = this.f57368c;
            }
        }
    }

    public f(TbPageContext<?> tbPageContext, RecentlyVisitedForumModel recentlyVisitedForumModel, ViewEventCenter viewEventCenter) {
        this.f57349a = tbPageContext;
        this.f57353e = recentlyVisitedForumModel;
        this.o = viewEventCenter;
        this.f57354f = (Vibrator) tbPageContext.getPageActivity().getSystemService("vibrator");
        this.p = new d.b.j0.i0.h.e(tbPageContext);
        MessageManager.getInstance().registerListener(this.t);
        MessageManager.getInstance().registerListener(this.u);
        p();
        q();
    }

    public final void A() {
        d.b.j0.i0.d.c cVar = this.r;
        if (cVar != null && cVar.f57021a) {
            SkinManager.setViewTextColor(this.f57355g, R.color.CAM_X0101);
            this.f57351c.setBackgroundColor(0);
            SkinManager.setViewTextColorSelector(this.i, R.color.CAM_X0201, R.color.cp_bg_line_d_alpha50, 0);
            this.i.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        } else {
            SkinManager.setViewTextColor(this.f57355g, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.f57351c, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0302);
            this.i.setBackgroundResource(R.drawable.enter_forum_recent_edit_done_trans_bg);
        }
        G();
        u();
    }

    public void B() {
        this.m = !this.m;
        d.b.i0.r.d0.b.j().t("key_recently_visited_forum_extend_state", this.m);
        if (this.m) {
            TiebaStatic.log(new StatisticItem("c13003"));
        } else {
            TiebaStatic.log(new StatisticItem("c13004"));
        }
        G();
    }

    public void C(d.b.j0.i0.d.c cVar) {
        this.r = cVar;
        A();
    }

    public final void D(boolean z) {
        if (this.n == z || this.l == null) {
            return;
        }
        this.n = z;
        if (z) {
            this.i.setVisibility(0);
            this.f57356h.setVisibility(8);
            Vibrator vibrator = this.f57354f;
            if (vibrator != null) {
                vibrator.vibrate(10L);
            }
            ViewEventCenter viewEventCenter = this.o;
            if (viewEventCenter != null) {
                viewEventCenter.dispatchMvcEvent(new d.b.i0.g0.c.b(10, null, null, null));
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007009, 2));
        } else {
            this.i.setVisibility(8);
            this.f57356h.setVisibility(0);
            ViewEventCenter viewEventCenter2 = this.o;
            if (viewEventCenter2 != null) {
                viewEventCenter2.dispatchMvcEvent(new d.b.i0.g0.c.b(11, null, null, null));
            }
        }
        this.l.k(this.n);
    }

    public void E(j jVar) {
        this.s = jVar;
    }

    public void F(BdUniqueId bdUniqueId) {
        this.v.setTag(bdUniqueId);
    }

    public final void G() {
        int i2;
        int i3;
        if (this.m) {
            this.j.setVisibility(0);
            this.k.setVisibility(8);
            d.b.j0.i0.d.c cVar = this.r;
            if (cVar != null && cVar.f57021a) {
                i3 = R.color.white_alpha100;
            } else {
                i3 = R.color.CAM_X0107;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57356h, R.drawable.icon_pure_ba_show24_svg, i3, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            this.j.setVisibility(8);
            this.k.setVisibility(0);
            d.b.j0.i0.d.c cVar2 = this.r;
            if (cVar2 != null && cVar2.f57021a) {
                i2 = R.color.white_alpha100;
            } else {
                i2 = R.color.CAM_X0107;
            }
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57356h, R.drawable.icon_pure_ba_hide24_svg, i2, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        j jVar = this.s;
        if (jVar != null) {
            jVar.a();
        }
    }

    public boolean k() {
        if (this.n) {
            D(false);
            return true;
        }
        return false;
    }

    public final void l(RecentlyVisitedForumListAdapter.ForumViewHolder forumViewHolder, Intent intent, boolean z) {
        if (forumViewHolder == null || intent == null) {
            return;
        }
        if (z && TbSingleton.getInstance().isAnimEnable("anim_switch_trans_frs")) {
            intent.putExtra("transition_type", 1);
            Rect rect = new Rect();
            BarImageView barImageView = forumViewHolder.f15035d;
            barImageView.getGlobalVisibleRect(rect);
            intent.putExtra("info_forum_image_rect", rect);
            intent.putExtra("info_forum_image_url", barImageView.getUrl());
            Rect rect2 = new Rect();
            TextView textView = forumViewHolder.f15033b;
            textView.getGlobalVisibleRect(rect2);
            intent.putExtra("info_forum_name_rect", rect2);
            intent.putExtra("info_forum_name_text", textView.getText());
            Rect rect3 = new Rect();
            LinearGradientView linearGradientView = forumViewHolder.f15038g;
            linearGradientView.getGlobalVisibleRect(rect3);
            intent.putExtra("info_forum_head_background_rect", rect3);
            intent.putExtra("info_forum_head_background_color", linearGradientView.getGradientColor());
            return;
        }
        intent.putExtra("transition_type", 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(boolean z) {
        j jVar;
        if (z) {
            d.b.i0.r.d0.b j2 = d.b.i0.r.d0.b.j();
            if (!j2.g("recnbar" + TbadkCoreApplication.getCurrentAccount(), false)) {
                this.f57352d.setVisibility(0);
                G();
                jVar = this.s;
                if (jVar == null) {
                    jVar.a();
                    return;
                }
                return;
            }
        }
        this.f57352d.setVisibility(8);
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        jVar = this.s;
        if (jVar == null) {
        }
    }

    public d.b.j0.i0.d.c n() {
        return this.r;
    }

    public View o() {
        return this.f57351c;
    }

    public final void p() {
        this.m = d.b.i0.r.d0.b.j().g("key_recently_visited_forum_extend_state", true);
    }

    public final void q() {
        View inflate = this.f57349a.getPageActivity().getLayoutInflater().inflate(R.layout.recently_visited_forum_layout, (ViewGroup) null);
        this.f57351c = inflate;
        this.f57352d = inflate.findViewById(R.id.title_container);
        this.f57355g = (TextView) this.f57351c.findViewById(R.id.title);
        ImageView imageView = (ImageView) this.f57351c.findViewById(R.id.extend_image);
        this.f57356h = imageView;
        imageView.setOnClickListener(new c());
        TextView textView = (TextView) this.f57351c.findViewById(R.id.done);
        this.i = textView;
        textView.setOnClickListener(new d());
        this.k = this.f57351c.findViewById(R.id.gap);
        this.j = (RecyclerView) this.f57351c.findViewById(R.id.list);
        RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter = new RecentlyVisitedForumListAdapter(this.f57349a);
        this.l = recentlyVisitedForumListAdapter;
        this.j.setAdapter(recentlyVisitedForumListAdapter);
        this.j.setClipChildren(false);
        if (TbSingleton.getInstance().isSlideAnimEnable()) {
            l lVar = new l(new d.b.c.j.e.j());
            this.q = lVar;
            lVar.q(this.j, 1);
        }
        this.j.setLayoutManager(new LinearLayoutManager(this.f57349a.getPageActivity(), 0, false));
        this.j.setItemAnimator(new DefaultItemAnimator());
        this.j.addItemDecoration(new k(this, d.b.c.e.p.l.g(this.f57349a.getPageActivity(), R.dimen.tbds44), 0, d.b.c.e.p.l.g(this.f57349a.getPageActivity(), R.dimen.tbds44)));
        this.l.l(new e());
        this.l.m(new View$OnLongClickListenerC1360f());
        this.l.j(new g());
        this.f57353e.v(new h());
        w(TbadkCoreApplication.getInst().getSkinType());
        this.f57349a.registerListener(this.v);
    }

    public boolean r() {
        return this.n;
    }

    public boolean s() {
        return this.m;
    }

    public boolean t() {
        return this.f57352d.getVisibility() == 0;
    }

    public void u() {
        RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter = this.l;
        if (recentlyVisitedForumListAdapter != null) {
            recentlyVisitedForumListAdapter.notifyDataSetChanged();
            if (this.l.getItemCount() > 0) {
                m(true);
            } else {
                m(false);
            }
        }
    }

    public void v(int i2) {
        RecentlyVisitedForumListAdapter recentlyVisitedForumListAdapter = this.l;
        if (recentlyVisitedForumListAdapter == null) {
            return;
        }
        recentlyVisitedForumListAdapter.notifyItemRemoved(i2);
        if (this.l.getItemCount() == 0) {
            D(false);
            m(false);
        }
    }

    public void w(int i2) {
        if (this.f57350b != i2) {
            this.f57350b = i2;
            A();
        }
    }

    public void x() {
        MessageManager.getInstance().unRegisterListener(this.t);
        MessageManager.getInstance().unRegisterListener(this.u);
        d.b.j0.i0.h.e eVar = this.p;
        if (eVar != null) {
            eVar.f();
        }
    }

    public void y(LinkedList<VisitedForumData> linkedList) {
        if (this.l == null || linkedList == null) {
            return;
        }
        G();
        this.l.i(linkedList);
        u();
        w(TbadkCoreApplication.getInst().getSkinType());
    }

    public void z() {
        RecentlyVisitedForumModel recentlyVisitedForumModel = this.f57353e;
        if (recentlyVisitedForumModel != null) {
            recentlyVisitedForumModel.u();
        }
    }
}
