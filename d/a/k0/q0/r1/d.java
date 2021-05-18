package d.a.k0.q0.r1;

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
import d.a.k0.d3.w;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<FrsMoreFeedForumsActivity> f59383e;

    /* renamed from: f  reason: collision with root package name */
    public List<FeedForumData> f59384f;

    /* renamed from: g  reason: collision with root package name */
    public int f59385g;

    /* renamed from: h  reason: collision with root package name */
    public LikeModel f59386h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f59387i = new a();
    public e j = new b();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedForumData feedForumData;
            d.a.k0.q0.r1.b bVar = (d.a.k0.q0.r1.b) view.getTag();
            if (bVar == null || (feedForumData = (FeedForumData) d.this.getItem(bVar.f59381h)) == null) {
                return;
            }
            if (view.getId() == R.id.frs_feed_forum_attention) {
                if (((FrsMoreFeedForumsActivity) d.this.f59383e.getOrignalPage()).checkUpIsLogin()) {
                    d.this.f59386h.H(feedForumData.getForumName(), feedForumData.getForumId());
                    StatisticItem statisticItem = new StatisticItem("c10048");
                    statisticItem.param("fid", feedForumData.getForumId());
                    if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(statisticItem);
                }
            } else if (view.getId() == R.id.frs_like_feed_forum_item) {
                d.this.f59383e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f59383e.getPageActivity()).createNormalCfg(feedForumData.getForumName(), "")));
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
            if (AntiHelper.m(d.this.f59386h.getErrorCode(), d.this.f59386h.getErrorString())) {
                AntiHelper.u(d.this.f59383e.getPageActivity(), d.this.f59386h.getErrorString());
            } else if (obj == null) {
                if (StringUtils.isNull(d.this.f59386h.getErrorString())) {
                    return;
                }
                l.M(TbadkCoreApplication.getInst(), d.this.f59386h.getErrorString());
            } else {
                w wVar = (w) obj;
                wVar.v(1);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, wVar));
            }
        }
    }

    public d(TbPageContext<FrsMoreFeedForumsActivity> tbPageContext) {
        this.f59383e = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.f59386h = likeModel;
        likeModel.setLoadDataCallBack(this.j);
    }

    public final void c(d.a.k0.q0.r1.b bVar) {
        if (bVar.f59382i != this.f59385g) {
            SkinManager.setBackgroundResource(bVar.f59374a, R.drawable.frs_like_feed_forum_item_bg);
            SkinManager.setViewTextColor(bVar.f59376c, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(bVar.f59377d, R.color.CAM_X0108, 1);
            SkinManager.setViewTextColor(bVar.f59378e, R.color.CAM_X0305, 1);
            View view = bVar.f59380g;
            if (view != null) {
                SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
            }
            bVar.f59382i = this.f59385g;
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

    public final void e(d.a.k0.q0.r1.b bVar) {
        EntelechyUserLikeButton entelechyUserLikeButton;
        if (bVar == null || (entelechyUserLikeButton = bVar.f59379f) == null) {
            return;
        }
        entelechyUserLikeButton.h(true);
        bVar.f59379f.setEnabled(false);
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
        this.f59384f = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FeedForumData> list = this.f59384f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<FeedForumData> list = this.f59384f;
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
        d.a.k0.q0.r1.b bVar;
        this.f59385g = TbadkCoreApplication.getInst().getSkinType();
        if (view == null) {
            view = LayoutInflater.from(this.f59383e.getPageActivity()).inflate(R.layout.frs_more_feed_forum_item, (ViewGroup) null);
            bVar = new d.a.k0.q0.r1.b(view);
            view.setTag(bVar);
            bVar.f59379f.setTag(bVar);
        } else {
            bVar = (d.a.k0.q0.r1.b) view.getTag();
        }
        FeedForumData feedForumData = (FeedForumData) getItem(i2);
        if (bVar == null) {
            return null;
        }
        bVar.f59381h = i2;
        bVar.f59374a.setOnClickListener(this.f59387i);
        bVar.f59375b.setPlaceHolder(1);
        bVar.f59375b.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.f59375b.V(feedForumData.getAvatar(), 15, false);
        bVar.f59376c.setText(feedForumData.getForumName());
        bVar.f59377d.setText(String.format(this.f59383e.getPageActivity().getString(R.string.attention_post_count), d(feedForumData.getMemberCount()), d(feedForumData.getPostNum())));
        bVar.f59378e.setText(feedForumData.getReason());
        if (feedForumData.getIsLike() == 0) {
            bVar.f59379f.setClickable(true);
            bVar.f59379f.setOnClickListener(this.f59387i);
            bVar.f59379f.setEnabled(true);
            bVar.f59379f.h(false);
        } else {
            e(bVar);
        }
        c(bVar);
        return view;
    }
}
