package d.b.j0.v3.p;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final Context f63814e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicChangeFourmActivity f63815f;

    /* renamed from: g  reason: collision with root package name */
    public List<HotTopicBussinessData> f63816g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f63817h = null;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f63818a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f63819b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63820c;

        /* renamed from: d  reason: collision with root package name */
        public View f63821d;

        public b(a aVar) {
        }
    }

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.f63815f = hotTopicChangeFourmActivity;
        this.f63814e = hotTopicChangeFourmActivity.getPageContext().getContext();
    }

    public final b a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        b bVar;
        if (obj == null) {
            bVar = b();
        } else {
            bVar = (b) obj;
        }
        bVar.f63820c.setText(d(hotTopicBussinessData.mForumName));
        bVar.f63819b.W(hotTopicBussinessData.mForumAvatar, 10, false);
        SkinManager.setBackgroundResource(bVar.f63818a, R.drawable.select_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f63820c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(bVar.f63821d, R.color.CAM_X0205);
        return bVar;
    }

    public final b b() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.f63814e).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        bVar.f63818a = inflate;
        SkinManager.setBackgroundResource(inflate, R.drawable.select_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f63820c, R.color.CAM_X0105);
        bVar.f63820c = (TextView) bVar.f63818a.findViewById(R.id.fourm_tv);
        bVar.f63821d = bVar.f63818a.findViewById(R.id.line_view);
        TbImageView tbImageView = (TbImageView) bVar.f63818a.findViewById(R.id.icon_img);
        bVar.f63819b = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        bVar.f63819b.setDefaultResource(R.drawable.transparent_bg);
        bVar.f63818a.setTag(bVar);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public HotTopicBussinessData getItem(int i) {
        List<HotTopicBussinessData> list = this.f63816g;
        if (list != null && i < list.size()) {
            return this.f63816g.get(i);
        }
        return null;
    }

    public final String d(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (str.length() > 14) {
            return str.substring(0, 13) + StringHelper.STRING_MORE;
        }
        return str;
    }

    public void e(List<HotTopicBussinessData> list) {
        this.f63816g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f63816g)) {
            return 0;
        }
        return this.f63816g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.f63817h == null) {
            this.f63817h = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            bVar = a(view != null ? view.getTag() : null, item);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.f63818a;
        }
        return null;
    }
}
