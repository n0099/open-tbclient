package d.a.n0.r0.r1;

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
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.e3.w;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<FrsMoreFeedForumsActivity> f63215e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeedForumData> f63216f;

    /* renamed from: g  reason: collision with root package name */
    public int f63217g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f63218h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f63219i = new a();
    public e j = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            d.a.n0.r0.r1.b bVar = (d.a.n0.r0.r1.b) view.getTag();
            if (bVar == null || (feedForumData = (FeedForumData) d.this.getItem(bVar.f63213h)) == null) {
                return;
            }
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (((FrsMoreFeedForumsActivity) d.this.f63215e.getOrignalPage()).checkUpIsLogin()) {
                    d.this.f63218h.L(feedForumData.getForumName(), feedForumData.getForumId());
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", feedForumData.getForumId());
                    if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                d.this.f63215e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f63215e.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
                TiebaStatic.log(new StatisticItem("c10050").param("fid", feedForumData.getForumId()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends e {
        public b() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (AntiHelper.m(d.this.f63218h.getErrorCode(), d.this.f63218h.getErrorString())) {
                AntiHelper.u(d.this.f63215e.getPageActivity(), d.this.f63218h.getErrorString());
            } else if (obj == null) {
                if (StringUtils.isNull(d.this.f63218h.getErrorString())) {
                    return;
                }
                l.M(TbadkCoreApplication.getInst(), d.this.f63218h.getErrorString());
            } else {
                w wVar = (w) obj;
                wVar.v(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
        }
    }

    public d(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.f63215e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f63218h = likeModel;
        likeModel.setLoadDataCallBack(this.j);
    }

    public final void c(d.a.n0.r0.r1.b bVar) {
        if (bVar.f63214i != this.f63217g) {
            SkinManager.setBackgroundResource(bVar.f63206a, R.drawable.frs_like_feed_forum_item_bg);
            SkinManager.setViewTextColor(bVar.f63208c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(bVar.f63209d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColor(bVar.f63210e, R.color.CAM_X0305, 1);
            View view = bVar.f63212g;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
            }
            bVar.f63214i = this.f63217g;
        }
    }

    public final String d(int i2) {
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

    public final void e(d.a.n0.r0.r1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        if (bVar == null || (entelechyUserLikeButton = bVar.f63211f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        bVar.f63211f.setEnabled(false);
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
        this.f63216f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FeedForumData> list = this.f63216f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<FeedForumData> list = this.f63216f;
        if (list != null) {
            return list.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        d.a.n0.r0.r1.b bVar;
        this.f63217g = TbadkCoreApplication.getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.f63215e.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            bVar = new d.a.n0.r0.r1.b(view);
            view.setTag(bVar);
            bVar.f63211f.setTag(bVar);
        } else {
            bVar = (d.a.n0.r0.r1.b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i2);
        if (bVar == null) {
            return null;
        }
        bVar.f63213h = i2;
        bVar.f63206a.setOnClickListener(this.f63219i);
        bVar.f63207b.setPlaceHolder(1);
        bVar.f63207b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.f63207b.U(feedForumData.getAvatar(), 15, false);
        bVar.f63208c.setText(feedForumData.getForumName());
        bVar.f63209d.setText(String.format(this.f63215e.getPageActivity().getString(R.string.attention_post_count), d(feedForumData.getMemberCount()), d(feedForumData.getPostNum())));
        bVar.f63210e.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.f63211f.setClickable(true);
            bVar.f63211f.setOnClickListener(this.f63219i);
            bVar.f63211f.setEnabled(true);
            bVar.f63211f.h(false);
        } else {
            e(bVar);
        }
        c(bVar);
        return view;
    }
}
