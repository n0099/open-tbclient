package d.b.i0.q0.r1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.FeedForumData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.c.a.e;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.d3.w;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<FrsMoreFeedForumsActivity> f60119e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeedForumData> f60120f;

    /* renamed from: g  reason: collision with root package name */
    public int f60121g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f60122h;
    public View.OnClickListener i = new a();
    public e j = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            d.b.i0.q0.r1.b bVar = (d.b.i0.q0.r1.b) view.getTag();
            if (bVar == null || (feedForumData = (FeedForumData) d.this.getItem(bVar.f60118h)) == null) {
                return;
            }
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (((FrsMoreFeedForumsActivity) d.this.f60119e.getOrignalPage()).checkUpIsLogin()) {
                    d.this.f60122h.H(feedForumData.getForumName(), feedForumData.getForumId());
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", feedForumData.getForumId());
                    if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                d.this.f60119e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f60119e.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new StatisticItem("c10050").param("fid", feedForumData.getForumId()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends e {
        public b() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (AntiHelper.m(d.this.f60122h.getErrorCode(), d.this.f60122h.getErrorString())) {
                AntiHelper.u(d.this.f60119e.getPageActivity(), d.this.f60122h.getErrorString());
            } else if (obj == null) {
                if (StringUtils.isNull(d.this.f60122h.getErrorString())) {
                    return;
                }
                l.L(TbadkCoreApplication.getInst(), d.this.f60122h.getErrorString());
            } else {
                w wVar = (w) obj;
                wVar.v(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
        }
    }

    public d(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.f60119e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f60122h = likeModel;
        likeModel.setLoadDataCallBack(this.j);
    }

    public final void c(d.b.i0.q0.r1.b bVar) {
        if (bVar.i != this.f60121g) {
            SkinManager.setBackgroundResource(bVar.f60111a, R.drawable.frs_like_feed_forum_item_bg);
            SkinManager.setViewTextColor(bVar.f60113c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(bVar.f60114d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColor(bVar.f60115e, R.color.CAM_X0305, 1);
            View view = bVar.f60117g;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
            }
            bVar.i = this.f60121g;
        }
    }

    public final String d(int i) {
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

    public final void e(d.b.i0.q0.r1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        if (bVar == null || (entelechyUserLikeButton = bVar.f60116f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        bVar.f60116f.setEnabled(false);
    }

    public void f(List<FeedForumData> list, w wVar) {
        if (list == null || list.size() <= 0 || wVar == null) {
            return;
        }
        for (FeedForumData feedForumData : list) {
            if (feedForumData.getForumId() != null && feedForumData.getForumId().equals(wVar.g())) {
                feedForumData.setIsLike(wVar.l());
                notifyDataSetChanged();
                return;
            }
        }
    }

    public void g(List<FeedForumData> list) {
        this.f60120f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FeedForumData> list = this.f60120f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<FeedForumData> list = this.f60120f;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        d.b.i0.q0.r1.b bVar;
        this.f60121g = TbadkCoreApplication.getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.f60119e.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            bVar = new d.b.i0.q0.r1.b(view);
            view.setTag(bVar);
            bVar.f60116f.setTag(bVar);
        } else {
            bVar = (d.b.i0.q0.r1.b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i);
        if (bVar == null) {
            return null;
        }
        bVar.f60118h = i;
        bVar.f60111a.setOnClickListener(this.i);
        bVar.f60112b.setPlaceHolder(1);
        bVar.f60112b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.f60112b.W(feedForumData.getAvatar(), 15, false);
        bVar.f60113c.setText(feedForumData.getForumName());
        bVar.f60114d.setText(String.format(this.f60119e.getPageActivity().getString(R.string.attention_post_count), d(feedForumData.getMemberCount()), d(feedForumData.getPostNum())));
        bVar.f60115e.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.f60116f.setClickable(true);
            bVar.f60116f.setOnClickListener(this.i);
            bVar.f60116f.setEnabled(true);
            bVar.f60116f.h(false);
        } else {
            e(bVar);
        }
        c(bVar);
        return view;
    }
}
