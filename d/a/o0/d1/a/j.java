package d.a.o0.d1.a;

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
    public String f56299f;

    /* renamed from: g  reason: collision with root package name */
    public RelateTopicForumActivity f56300g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<RelateForumItemData> f56298e = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f56301h = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            if (j.this.f56300g == null || !j.this.f56300g.checkUpIsLogin() || view.getId() != R.id.forum_add_love || (intValue = ((Integer) view.getTag()).intValue()) < 0) {
                return;
            }
            RelateForumItemData relateForumItemData = (RelateForumItemData) j.this.f56298e.get(intValue);
            if (relateForumItemData.forumId != 0) {
                TiebaStatic.log(new StatisticItem("c10371").param("fid", String.valueOf(relateForumItemData.forumId)).param("obj_type", d.a.o0.d1.c.k.f56409b).param("topic_id", j.this.f56299f));
            }
            if (d.a.c.e.p.k.isForumName(relateForumItemData.forumName)) {
                j.this.f56300g.likeModel.L(relateForumItemData.forumName, String.valueOf(relateForumItemData.forumId));
            }
        }
    }

    public j(RelateTopicForumActivity relateTopicForumActivity) {
        this.f56300g = relateTopicForumActivity;
    }

    public void d(List<RelateForumItemData> list, String str) {
        this.f56298e.clear();
        this.f56298e.addAll(list);
        this.f56299f = str;
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
        return this.f56298e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return this.f56298e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        RelateTopicForumItemHolder relateTopicForumItemHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f56300g.getPageContext().getContext()).inflate(R.layout.hot_topic_list_item, (ViewGroup) null);
            relateTopicForumItemHolder = new RelateTopicForumItemHolder(view);
            view.setTag(relateTopicForumItemHolder);
            relateTopicForumItemHolder.f16973h.setOnClickListener(this.f56301h);
        } else {
            relateTopicForumItemHolder = (RelateTopicForumItemHolder) view.getTag();
        }
        relateTopicForumItemHolder.f16973h.setTag(Integer.valueOf(i2));
        ArrayList<RelateForumItemData> arrayList = this.f56298e;
        if (arrayList != null && arrayList.get(i2) != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (relateTopicForumItemHolder.j != skinType) {
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f16967b, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f16970e, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f16971f, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f16968c, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f16969d, R.color.CAM_X0108, 1);
                SkinManager.setViewTextColor(relateTopicForumItemHolder.f16972g, R.color.CAM_X0109, 1);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.f16974i, R.color.CAM_X0204);
                SkinManager.setBackgroundResource(relateTopicForumItemHolder.f16973h, R.drawable.btn_appdownload);
                SkinManager.setBackgroundResource(view, R.drawable.list_item_selector);
                relateTopicForumItemHolder.j = skinType;
            }
            relateTopicForumItemHolder.f16967b.setText(this.f56298e.get(i2).forumName);
            if (!StringUtils.isNULL(this.f56298e.get(i2).forumAvatar)) {
                relateTopicForumItemHolder.f16966a.U(this.f56298e.get(i2).forumAvatar, 10, false);
            }
            relateTopicForumItemHolder.f16970e.setText(StringHelper.numberUniformFormat(this.f56298e.get(i2).postNum));
            relateTopicForumItemHolder.f16971f.setText(StringHelper.numberUniformFormat(this.f56298e.get(i2).followNum));
            relateTopicForumItemHolder.f16972g.setText(StringHelper.forceLToR(this.f56298e.get(i2).forumAbstract));
            f(relateTopicForumItemHolder.f16973h, this.f56298e.get(i2).isLiked);
            if (i2 == this.f56298e.size() - 1) {
                e(relateTopicForumItemHolder.f16974i);
            }
        }
        return view;
    }
}
