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
/* loaded from: classes3.dex */
public class j extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public String f52029f;

    /* renamed from: g  reason: collision with root package name */
    public RelateTopicForumActivity f52030g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<RelateForumItemData> f52028e = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f52031h = new a();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (j.this.f52030g == null || !j.this.f52030g.checkUpIsLogin() || view.getId() != R.id.forum_add_love || (intValue = ((Integer) view.getTag()).intValue()) < 0) {
                return;
            }
            RelateForumItemData relateForumItemData = (RelateForumItemData) j.this.f52028e.get(intValue);
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.b.i0.b1.c.k.f52131b).param("topic_id", j.this.f52029f));
            }
            if (d.b.b.e.p.k.isForumName(relateForumItemData.forumName)) {
                j.this.f52030g.likeModel.H(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
            }
        }
    }

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        this.f52030g = relateTopicForumActivity;
    }

    public void d(List<RelateForumItemData> list, String str) {
        this.f52028e.clear();
        this.f52028e.addAll(list);
        this.f52029f = str;
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
        return this.f52028e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f52028e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        RelateTopicForumItemHolder relateTopicForumItemHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f52030g.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            relateTopicForumItemHolder = new RelateTopicForumItemHolder(view);
            view.setTag(relateTopicForumItemHolder);
            relateTopicForumItemHolder.f17609h.setOnClickListener(this.f52031h);
        } else {
            relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
        }
        relateTopicForumItemHolder.f17609h.setTag(Integer.valueOf(i));
        ArrayList<RelateForumItemData> arrayList = this.f52028e;
        if (arrayList != null && arrayList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (relateTopicForumItemHolder.j != skinType) {
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17603b, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17606e, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17607f, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17604c, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17605d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17608g, R.color.CAM_X0109, 1);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.i, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.f17609h, R.drawable.btn_appdownload);
                SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
                relateTopicForumItemHolder.j = skinType;
            }
            relateTopicForumItemHolder.f17603b.setText(this.f52028e.get(i).forumName);
            if (!StringUtils.isNULL(this.f52028e.get(i).forumAvatar)) {
                relateTopicForumItemHolder.f17602a.W(this.f52028e.get(i).forumAvatar, 10, false);
            }
            relateTopicForumItemHolder.f17606e.setText(StringHelper.numberUniformFormat(this.f52028e.get(i).postNum));
            relateTopicForumItemHolder.f17607f.setText(StringHelper.numberUniformFormat(this.f52028e.get(i).followNum));
            relateTopicForumItemHolder.f17608g.setText(StringHelper.forceLToR(this.f52028e.get(i).forumAbstract));
            f(relateTopicForumItemHolder.f17609h, this.f52028e.get(i).isLiked);
            if (i == this.f52028e.size() - 1) {
                e(relateTopicForumItemHolder.i);
            }
        }
        return view;
    }
}
