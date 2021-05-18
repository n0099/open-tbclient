package d.a.k0.q0.r1;

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
import d.a.c.a.e;
import d.a.c.e.p.l;
import d.a.j0.r.s.a;
import d.a.k0.d3.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<FrsFragment> f59360a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f59361b;

    /* renamed from: c  reason: collision with root package name */
    public View f59362c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59363d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59364e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f59365f;

    /* renamed from: g  reason: collision with root package name */
    public View f59366g;

    /* renamed from: h  reason: collision with root package name */
    public View f59367h;
    public List<FeedForumData> j;
    public LikeModel k;
    public boolean p;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.k0.q0.r1.b> f59368i = new ArrayList();
    public Handler l = new Handler();
    public int m = 1;
    public String n = "";
    public boolean o = false;
    public View.OnClickListener q = new View$OnClickListenerC1530a();
    public e r = new d();

    /* renamed from: d.a.k0.q0.r1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1530a implements View.OnClickListener {
        public View$OnClickListenerC1530a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (ViewHelper.checkUpIsLogin(a.this.f59360a.getPageActivity()) && (feedForumData = (FeedForumData) view.getTag()) != null) {
                    a.this.k.H(feedForumData.getForumName(), feedForumData.getForumId());
                    TiebaStatic.log(new StatisticItem(a.this.m == 1 ? "c10028" : "c10040").param("fid", feedForumData.getForumId()));
                }
            } else if (view.getId() == R.id.like_feed_forums_arrow) {
                a.this.s();
                TiebaStatic.log(new StatisticItem("c10029").param("fid", a.this.n));
            } else if (view.getId() != R.id.frs_like_feed_forum_item) {
                if (view.getId() != a.this.f59365f.getId() || ListUtils.getCount(a.this.j) <= 0) {
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FrsMoreFeedForumsConfig(a.this.f59360a.getPageActivity(), (Serializable) a.this.j)));
                TiebaStatic.log(new StatisticItem("c10046").param("fid", a.this.n));
            } else {
                FeedForumData feedForumData2 = (FeedForumData) view.getTag();
                if (feedForumData2 != null) {
                    a.this.f59360a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(a.this.f59360a.getPageActivity()).createNormalCfg(feedForumData2.getForumName(), a.this.m == 1 ? FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND : "")));
                    TiebaStatic.log(new StatisticItem(a.this.m == 2 ? "c10042" : "c10030").param("fid", feedForumData2.getForumId()));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
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

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends e {

        /* renamed from: d.a.k0.q0.r1.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1531a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ w f59372e;

            public RunnableC1531a(w wVar) {
                this.f59372e = wVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = a.this.j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FeedForumData feedForumData = (FeedForumData) it.next();
                    if (feedForumData.getForumId().equals(this.f59372e.g())) {
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

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (AntiHelper.m(a.this.k.getErrorCode(), a.this.k.getErrorString())) {
                AntiHelper.u(a.this.f59360a.getPageActivity(), a.this.k.getErrorString());
            } else if (obj == null) {
                if (StringUtils.isNull(a.this.k.getErrorString())) {
                    return;
                }
                l.M(TbadkCoreApplication.getInst(), a.this.k.getErrorString());
            } else {
                w wVar = (w) obj;
                if (ListUtils.getCount(a.this.j) <= 0 || wVar == null) {
                    return;
                }
                Iterator it = a.this.f59368i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d.a.k0.q0.r1.b bVar = (d.a.k0.q0.r1.b) it.next();
                    FeedForumData feedForumData = (FeedForumData) bVar.f59379f.getTag();
                    if (feedForumData != null && feedForumData.getForumId() != null && feedForumData.getForumId().equals(wVar.g())) {
                        feedForumData.setIsLike(1);
                        a.this.l(bVar);
                        break;
                    }
                }
                if (a.this.m == 1) {
                    a.this.l.postDelayed(new RunnableC1531a(wVar), 1000L);
                }
            }
        }
    }

    public a() {
    }

    public final String k(int i2) {
        if (i2 < 0) {
            return "0";
        }
        if (i2 < 10000) {
            return String.valueOf(i2);
        }
        if (i2 == 10000) {
            return "1W";
        }
        float f2 = i2 / 10000.0f;
        return f2 <= 9999.9f ? String.format("%.1fW", Float.valueOf(f2)) : "9999.9+W";
    }

    public final void l(d.a.k0.q0.r1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        if (bVar == null || (entelechyUserLikeButton = bVar.f59379f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        bVar.f59379f.setEnabled(false);
    }

    public void m() {
        this.f59361b.setVisibility(8);
    }

    public void n(TbPageContext tbPageContext, View view, int i2, boolean z, BdUniqueId bdUniqueId) {
        this.f59360a = tbPageContext;
        this.f59361b = (LinearLayout) view.findViewById(R.id.frs_header_feed_forums);
        this.f59362c = view.findViewById(R.id.frs_header_feed_forums_divider);
        this.f59366g = view.findViewById(R.id.layout_like_feed_forum_header);
        this.f59363d = (TextView) this.f59361b.findViewById(R.id.like_feed_forums_label);
        ImageView imageView = (ImageView) this.f59361b.findViewById(R.id.like_feed_forums_arrow);
        this.f59364e = imageView;
        imageView.setOnClickListener(this.q);
        this.f59365f = (TextView) this.f59361b.findViewById(R.id.feed_forums_more);
        this.f59367h = view.findViewById(R.id.feed_forum_bottom_line);
        this.f59365f.setOnClickListener(this.q);
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.k = likeModel;
        likeModel.setUniqueId(bdUniqueId);
        this.k.setLoadDataCallBack(this.r);
        this.m = i2;
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
        int i2;
        if (ListUtils.getCount(this.j) == 0) {
            m();
            return;
        }
        r();
        int size = this.j.size() > 2 ? 2 : this.j.size();
        int size2 = size - this.f59368i.size();
        if (size2 > 0) {
            for (int i3 = 0; i3 < size2; i3++) {
                if (this.m == 1) {
                    i2 = R.layout.frs_header_feed_forum_item;
                } else {
                    i2 = R.layout.frs_feed_forum_item;
                }
                View inflate = LayoutInflater.from(this.f59360a.getPageActivity()).inflate(i2, (ViewGroup) null);
                this.f59361b.addView(inflate);
                this.f59368i.add(new d.a.k0.q0.r1.b(inflate));
            }
        } else if (size2 < 0) {
            for (int i4 = 0; i4 < (-size2); i4++) {
                int size3 = this.f59368i.size() - 1;
                this.f59361b.removeView(this.f59368i.get(size3).f59374a);
                this.f59368i.remove(size3);
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            FeedForumData feedForumData = this.j.get(i5);
            d.a.k0.q0.r1.b bVar = this.f59368i.get(i5);
            if (feedForumData != null && bVar != null) {
                bVar.f59374a.setTag(feedForumData);
                bVar.f59374a.setOnClickListener(this.q);
                bVar.f59375b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
                bVar.f59375b.setPlaceHolder(1);
                bVar.f59375b.V(feedForumData.getAvatar(), 15, false);
                bVar.f59376c.setText(feedForumData.getForumName());
                bVar.f59377d.setText(String.format(this.f59360a.getPageActivity().getString(R.string.attention_post_count), k(feedForumData.getMemberCount()), k(feedForumData.getPostNum())));
                bVar.f59378e.setText(feedForumData.getReason());
                if (feedForumData.getIsLike() == 0) {
                    bVar.f59379f.setClickable(true);
                    bVar.f59379f.setOnClickListener(this.q);
                    bVar.f59379f.setTag(feedForumData);
                    bVar.f59379f.h(false);
                    bVar.f59379f.setEnabled(true);
                } else {
                    l(bVar);
                }
            }
        }
        if (this.p) {
            this.f59367h.setVisibility(0);
        } else {
            this.f59367h.setVisibility(8);
        }
        q();
    }

    public final void q() {
        SkinManager.setBackgroundColor(this.f59361b, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.f59362c, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f59366g, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f59363d, R.color.CAM_X0108, 1);
        SkinManager.setImageResource(this.f59364e, R.drawable.icon_frs_recommend_arrow_down);
        SkinManager.setViewTextColor(this.f59365f, R.color.CAM_X0110, 1);
        for (d.a.k0.q0.r1.b bVar : this.f59368i) {
            SkinManager.setBackgroundResource(bVar.f59374a, R.drawable.frs_like_feed_forum_item_bg);
            SkinManager.setViewTextColor(bVar.f59376c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(bVar.f59377d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColor(bVar.f59378e, R.color.CAM_X0305, 1);
            EntelechyUserLikeButton entelechyUserLikeButton = bVar.f59379f;
            entelechyUserLikeButton.h(!entelechyUserLikeButton.isEnabled());
        }
    }

    public void r() {
        this.f59361b.setVisibility(0);
    }

    public final void s() {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f59360a.getPageActivity());
        aVar.setMessage(this.f59360a.getPageActivity().getString(R.string.not_intrested));
        aVar.setPositiveButton(R.string.alert_yes_button, new b());
        aVar.setNegativeButton(R.string.cancel, new c(this));
        aVar.create(this.f59360a).show();
    }

    public a(TbPageContext tbPageContext, View view, int i2, boolean z, BdUniqueId bdUniqueId) {
        n(tbPageContext, view, i2, z, bdUniqueId);
    }
}
