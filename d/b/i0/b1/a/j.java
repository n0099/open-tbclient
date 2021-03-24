package d.b.i0.b1.a;

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
    public String f52028f;

    /* renamed from: g  reason: collision with root package name */
    public RelateTopicForumActivity f52029g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<RelateForumItemData> f52027e = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f52030h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (j.this.f52029g == null || !j.this.f52029g.checkUpIsLogin() || view.getId() != R.id.forum_add_love || (intValue = ((Integer) view.getTag()).intValue()) < 0) {
                return;
            }
            RelateForumItemData relateForumItemData = (RelateForumItemData) j.this.f52027e.get(intValue);
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.b.i0.b1.c.k.f52130b).param("topic_id", j.this.f52028f));
            }
            if (d.b.b.e.p.k.isForumName(relateForumItemData.forumName)) {
                j.this.f52029g.likeModel.H(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
            }
        }
    }

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        this.f52029g = relateTopicForumActivity;
    }

    public void d(List<RelateForumItemData> list, String str) {
        this.f52027e.clear();
        this.f52027e.addAll(list);
        this.f52028f = str;
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
        return this.f52027e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f52027e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        RelateTopicForumItemHolder relateTopicForumItemHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f52029g.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            relateTopicForumItemHolder = new RelateTopicForumItemHolder(view);
            view.setTag(relateTopicForumItemHolder);
            relateTopicForumItemHolder.f17608h.setOnClickListener(this.f52030h);
        } else {
            relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
        }
        relateTopicForumItemHolder.f17608h.setTag(Integer.valueOf(i));
        ArrayList<RelateForumItemData> arrayList = this.f52027e;
        if (arrayList != null && arrayList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (relateTopicForumItemHolder.j != skinType) {
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17602b, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17605e, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17606f, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17603c, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17604d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17607g, R.color.CAM_X0109, 1);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.i, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.f17608h, R.drawable.btn_appdownload);
                SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
                relateTopicForumItemHolder.j = skinType;
            }
            relateTopicForumItemHolder.f17602b.setText(this.f52027e.get(i).forumName);
            if (!StringUtils.isNULL(this.f52027e.get(i).forumAvatar)) {
                relateTopicForumItemHolder.f17601a.W(this.f52027e.get(i).forumAvatar, 10, false);
            }
            relateTopicForumItemHolder.f17605e.setText(StringHelper.numberUniformFormat(this.f52027e.get(i).postNum));
            relateTopicForumItemHolder.f17606f.setText(StringHelper.numberUniformFormat(this.f52027e.get(i).followNum));
            relateTopicForumItemHolder.f17607g.setText(StringHelper.forceLToR(this.f52027e.get(i).forumAbstract));
            f(relateTopicForumItemHolder.f17608h, this.f52027e.get(i).isLiked);
            if (i == this.f52027e.size() - 1) {
                e(relateTopicForumItemHolder.i);
            }
        }
        return view;
    }
}
