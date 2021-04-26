package d.a.j0.c1.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.RelateTopicForumActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.hottopic.holder.RelateTopicForumItemHolder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class j extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public String f51606f;

    /* renamed from: g  reason: collision with root package name */
    public RelateTopicForumActivity f51607g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<RelateForumItemData> f51605e = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f51608h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (j.this.f51607g == null || !j.this.f51607g.checkUpIsLogin() || view.getId() != R.id.forum_add_love || (intValue = ((Integer) view.getTag()).intValue()) < 0) {
                return;
            }
            RelateForumItemData relateForumItemData = (RelateForumItemData) j.this.f51605e.get(intValue);
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.j0.c1.c.k.f51716b).param("topic_id", j.this.f51606f));
            }
            if (d.a.c.e.p.k.isForumName(relateForumItemData.forumName)) {
                j.this.f51607g.likeModel.H(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
            }
        }
    }

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        this.f51607g = relateTopicForumActivity;
    }

    public void d(List<RelateForumItemData> list, String str) {
        this.f51605e.clear();
        this.f51605e.addAll(list);
        this.f51606f = str;
        notifyDataSetChanged();
    }

    public void e(View view) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        view.setLayoutParams(layoutParams);
    }

    public final void f(TextView textView, boolean z) {
        if (z) {
            textView.setEnabled(false);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            textView.setBackgroundDrawable(null);
            return;
        }
        SkinManager.setViewTextColor(textView, R.color.CAM_X0101, 1);
        textView.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        SkinManager.setBackgroundResource(textView, R.drawable.btn_appdownload);
        textView.setEnabled(true);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f51605e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f51605e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        RelateTopicForumItemHolder relateTopicForumItemHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f51607g.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            relateTopicForumItemHolder = new RelateTopicForumItemHolder(view);
            view.setTag(relateTopicForumItemHolder);
            relateTopicForumItemHolder.f17590h.setOnClickListener(this.f51608h);
        } else {
            relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
        }
        relateTopicForumItemHolder.f17590h.setTag(Integer.valueOf(i2));
        ArrayList<RelateForumItemData> arrayList = this.f51605e;
        if (arrayList != null && arrayList.get(i2) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (relateTopicForumItemHolder.j != skinType) {
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17584b, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17587e, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17588f, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17585c, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17586d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17589g, R.color.CAM_X0109, 1);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.f17591i, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.f17590h, R.drawable.btn_appdownload);
                SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
                relateTopicForumItemHolder.j = skinType;
            }
            relateTopicForumItemHolder.f17584b.setText(this.f51605e.get(i2).forumName);
            if (!StringUtils.isNULL(this.f51605e.get(i2).forumAvatar)) {
                relateTopicForumItemHolder.f17583a.V(this.f51605e.get(i2).forumAvatar, 10, false);
            }
            relateTopicForumItemHolder.f17587e.setText(StringHelper.numberUniformFormat(this.f51605e.get(i2).postNum));
            relateTopicForumItemHolder.f17588f.setText(StringHelper.numberUniformFormat(this.f51605e.get(i2).followNum));
            relateTopicForumItemHolder.f17589g.setText(StringHelper.forceLToR(this.f51605e.get(i2).forumAbstract));
            f(relateTopicForumItemHolder.f17590h, this.f51605e.get(i2).isLiked);
            if (i2 == this.f51605e.size() - 1) {
                e(relateTopicForumItemHolder.f17591i);
            }
        }
        return view;
    }
}
