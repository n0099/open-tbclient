package d.b.j0.c1.a;

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
    public String f53851f;

    /* renamed from: g  reason: collision with root package name */
    public RelateTopicForumActivity f53852g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<RelateForumItemData> f53850e = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f53853h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (j.this.f53852g == null || !j.this.f53852g.checkUpIsLogin() || view.getId() != R.id.forum_add_love || (intValue = ((Integer) view.getTag()).intValue()) < 0) {
                return;
            }
            RelateForumItemData relateForumItemData = (RelateForumItemData) j.this.f53850e.get(intValue);
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.b.j0.c1.c.k.f53953b).param("topic_id", j.this.f53851f));
            }
            if (d.b.c.e.p.k.isForumName(relateForumItemData.forumName)) {
                j.this.f53852g.likeModel.H(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
            }
        }
    }

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        this.f53852g = relateTopicForumActivity;
    }

    public void d(List<RelateForumItemData> list, String str) {
        this.f53850e.clear();
        this.f53850e.addAll(list);
        this.f53851f = str;
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
        return this.f53850e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f53850e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        RelateTopicForumItemHolder relateTopicForumItemHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f53852g.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            relateTopicForumItemHolder = new RelateTopicForumItemHolder(view);
            view.setTag(relateTopicForumItemHolder);
            relateTopicForumItemHolder.f17294h.setOnClickListener(this.f53853h);
        } else {
            relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
        }
        relateTopicForumItemHolder.f17294h.setTag(Integer.valueOf(i));
        ArrayList<RelateForumItemData> arrayList = this.f53850e;
        if (arrayList != null && arrayList.get(i) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (relateTopicForumItemHolder.j != skinType) {
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17288b, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17291e, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17292f, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17289c, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17290d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f17293g, R.color.CAM_X0109, 1);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.i, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.f17294h, R.drawable.btn_appdownload);
                SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
                relateTopicForumItemHolder.j = skinType;
            }
            relateTopicForumItemHolder.f17288b.setText(this.f53850e.get(i).forumName);
            if (!StringUtils.isNULL(this.f53850e.get(i).forumAvatar)) {
                relateTopicForumItemHolder.f17287a.W(this.f53850e.get(i).forumAvatar, 10, false);
            }
            relateTopicForumItemHolder.f17291e.setText(StringHelper.numberUniformFormat(this.f53850e.get(i).postNum));
            relateTopicForumItemHolder.f17292f.setText(StringHelper.numberUniformFormat(this.f53850e.get(i).followNum));
            relateTopicForumItemHolder.f17293g.setText(StringHelper.forceLToR(this.f53850e.get(i).forumAbstract));
            f(relateTopicForumItemHolder.f17294h, this.f53850e.get(i).isLiked);
            if (i == this.f53850e.size() - 1) {
                e(relateTopicForumItemHolder.i);
            }
        }
        return view;
    }
}
