package d.b.j0.q0.r1;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.c.a.e;
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
import d.b.j0.d3.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<FrsFragment> f60519a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f60520b;

    /* renamed from: c  reason: collision with root package name */
    public View f60521c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60522d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60523e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60524f;

    /* renamed from: g  reason: collision with root package name */
    public View f60525g;

    /* renamed from: h  reason: collision with root package name */
    public View f60526h;
    public List<FeedForumData> j;
    public LikeModel k;
    public boolean p;
    public List<d.b.j0.q0.r1.b> i = new ArrayList();
    public Handler l = new Handler();
    public int m = 1;
    public String n = "";
    public boolean o = false;
    public View.OnClickListener q = new View$OnClickListenerC1517a();
    public e r = new d();

    /* renamed from: d.b.j0.q0.r1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1517a implements View.OnClickListener {
        public View$OnClickListenerC1517a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (ViewHelper.checkUpIsLogin(a.this.f60519a.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.k.H(feedForumData.getForumName(), feedForumData.getForumId());
                    TiebaStatic.log(new StatisticItem(a.this.m == 1 ? "c10028" : "c10040").param("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.s();
                TiebaStatic.log(new StatisticItem("c10029").param("fid", a.this.n));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() != a.this.f60524f.getId() || ListUtils.getCount(a.this.j) <= 0) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.f60519a.getPageActivity(), (Serializable) a.this.j)));
                TiebaStatic.log(new StatisticItem("c10046").param("fid", a.this.n));
            } else {
                FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                if (feedForumData2 != null) {
                    a.this.f60519a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f60519a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), a.this.m == 1 ? FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND : "")));
                    TiebaStatic.log(new StatisticItem(a.this.m == 2 ? "c10042" : "c10030").param("fid", feedForumData2.getForumId()));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            if (a.this.j != null) {
                a.this.j.clear();
            }
            a.this.m();
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c(a aVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends e {

        /* renamed from: d.b.j0.q0.r1.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1518a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w f60530e;

            public RunnableC1518a(w wVar) {
                this.f60530e = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = a.this.j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FeedForumData feedForumData = (FeedForumData) it.next();
                    if (feedForumData.getForumId().equals(this.f60530e.g())) {
                        a.this.j.remove(feedForumData);
                        break;
                    }
                }
                if (a.this.j.size() > 0) {
                    a.this.p();
                } else {
                    a.this.m();
                }
            }
        }

        public d() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (AntiHelper.m(a.this.k.getErrorCode(), a.this.k.getErrorString())) {
                AntiHelper.u(a.this.f60519a.getPageActivity(), a.this.k.getErrorString());
            } else if (obj == null) {
                if (StringUtils.isNull(a.this.k.getErrorString())) {
                    return;
                }
                l.L(TbadkCoreApplication.getInst(), a.this.k.getErrorString());
            } else {
                w wVar = (w) obj;
                if (ListUtils.getCount(a.this.j) <= 0 || wVar == null) {
                    return;
                }
                Iterator it = a.this.i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d.b.j0.q0.r1.b bVar = (d.b.j0.q0.r1.b) it.next();
                    FeedForumData feedForumData = (FeedForumData) bVar.f60537f.getTag();
                    if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(wVar.g())) {
                        feedForumData.setIsLike(1);
                        a.this.l(bVar);
                        break;
                    }
                }
                if (a.this.m == 1) {
                    a.this.l.postDelayed(new RunnableC1518a(wVar), 1000L);
                }
            }
        }
    }

    public a() {
    }

    public final String k(int i) {
        if (i < 0) {
            return "0";
        }
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i == 10000) {
            return "1W";
        }
        float f2 = i / 10000.0f;
        return f2 <= 9999.9f ? String.format("%.1fW", Float.valueOf(f2)) : "9999.9+W";
    }

    public final void l(d.b.j0.q0.r1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        if (bVar == null || (entelechyUserLikeButton = bVar.f60537f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        bVar.f60537f.setEnabled(false);
    }

    public void m() {
        this.f60520b.setVisibility(8);
    }

    public void n(TbPageContext tbPageContext, View view, int i, boolean z, BdUniqueId bdUniqueId) {
        this.f60519a = tbPageContext;
        this.f60520b = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.f60521c = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.f60525g = view.findViewById(R.id.layout_like_feed_forum_header);
        this.f60522d = (TextView) this.f60520b.findViewById(R.id.like_feed_forums_label);
        ImageView imageView = (ImageView) this.f60520b.findViewById(R.id.like_feed_forums_arrow);
        this.f60523e = imageView;
        imageView.setOnClickListener(this.q);
        this.f60524f = (TextView) this.f60520b.findViewById(R.id.feed_forums_more);
        this.f60526h = view.findViewById(R.id.feed_forum_bottom_line);
        this.f60524f.setOnClickListener(this.q);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.k = likeModel;
        likeModel.setUniqueId(bdUniqueId);
        this.k.setLoadDataCallBack(this.r);
        this.m = i;
        this.p = z;
    }

    public void o(String str, List<FeedForumData> list) {
        this.n = str;
        this.j = list;
        p();
        if (this.m != 2 || this.o) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c10035").param("fid", this.n));
        this.o = true;
    }

    public final void p() {
        int i;
        if (ListUtils.getCount(this.j) == 0) {
            m();
            return;
        }
        r();
        int size = this.j.size() > 2 ? 2 : this.j.size();
        int size2 = size - this.i.size();
        if (size2 > 0) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (this.m == 1) {
                    i = R.layout.frs_header_feed_forum_item;
                } else {
                    i = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.f60519a.getPageActivity()).inflate(i, (ViewGroup) null);
                this.f60520b.addView(inflate);
                this.i.add(new d.b.j0.q0.r1.b(inflate));
            }
        } else if (size2 < 0) {
            for (int i3 = 0; i3 < (-size2); i3++) {
                int size3 = this.i.size() - 1;
                this.f60520b.removeView(this.i.get(size3).f60532a);
                this.i.remove(size3);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            FeedForumData feedForumData = this.j.get(i4);
            d.b.j0.q0.r1.b bVar = this.i.get(i4);
            if (feedForumData != null && bVar != null) {
                bVar.f60532a.setTag(feedForumData);
                bVar.f60532a.setOnClickListener(this.q);
                bVar.f60533b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.f60533b.setPlaceHolder(1);
                bVar.f60533b.W(feedForumData.getAvatar(), 15, false);
                bVar.f60534c.setText(feedForumData.getForumName());
                bVar.f60535d.setText(String.format(this.f60519a.getPageActivity().getString(R.string.attention_post_count), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                bVar.f60536e.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.f60537f.setClickable(true);
                    bVar.f60537f.setOnClickListener(this.q);
                    bVar.f60537f.setTag(feedForumData);
                    bVar.f60537f.h(false);
                    bVar.f60537f.setEnabled(true);
                } else {
                    l(bVar);
                }
            }
        }
        if (this.p) {
            this.f60526h.setVisibility(0);
        } else {
            this.f60526h.setVisibility(8);
        }
        q();
    }

    public final void q() {
        SkinManager.setBackgroundColor(this.f60520b, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f60521c, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f60525g, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f60522d, R.color.CAM_X0108, 1);
        SkinManager.setImageResource(this.f60523e, R.drawable.icon_frs_recommend_arrow_down);
        SkinManager.setViewTextColor(this.f60524f, R.color.CAM_X0110, 1);
        for (d.b.j0.q0.r1.b bVar : this.i) {
            SkinManager.setBackgroundResource(bVar.f60532a, R.drawable.frs_like_feed_forum_item_bg);
            SkinManager.setViewTextColor(bVar.f60534c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(bVar.f60535d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColor(bVar.f60536e, R.color.CAM_X0305, 1);
            EntelechyUserLikeButton entelechyUserLikeButton = bVar.f60537f;
            entelechyUserLikeButton.h(!entelechyUserLikeButton.isEnabled());
        }
    }

    public void r() {
        this.f60520b.setVisibility(0);
    }

    public final void s() {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f60519a.getPageActivity());
        aVar.setMessage(this.f60519a.getPageActivity().getString(R.string.not_intrested));
        aVar.setPositiveButton(R.string.alert_yes_button, new b());
        aVar.setNegativeButton(R.string.cancel, new c(this));
        aVar.create(this.f60519a).show();
    }

    public a(TbPageContext tbPageContext, View view, int i, boolean z, BdUniqueId bdUniqueId) {
        n(tbPageContext, view, i, z, bdUniqueId);
    }
}
