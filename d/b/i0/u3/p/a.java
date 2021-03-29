package d.b.i0.u3.p;

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
    public final Context f61655e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicChangeFourmActivity f61656f;

    /* renamed from: g  reason: collision with root package name */
    public List<HotTopicBussinessData> f61657g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f61658h = null;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f61659a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61660b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61661c;

        /* renamed from: d  reason: collision with root package name */
        public View f61662d;

        public b(a aVar) {
        }
    }

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.f61656f = hotTopicChangeFourmActivity;
        this.f61655e = hotTopicChangeFourmActivity.getPageContext().getContext();
    }

    public final b a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        b bVar;
        if (obj == null) {
            bVar = b();
        } else {
            bVar = (b) obj;
        }
        bVar.f61661c.setText(d(hotTopicBussinessData.mForumName));
        bVar.f61660b.W(hotTopicBussinessData.mForumAvatar, 10, false);
        SkinManager.setBackgroundResource(bVar.f61659a, R.drawable.select_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f61661c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(bVar.f61662d, R.color.CAM_X0205);
        return bVar;
    }

    public final b b() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.f61655e).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        bVar.f61659a = inflate;
        SkinManager.setBackgroundResource(inflate, R.drawable.select_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f61661c, R.color.CAM_X0105);
        bVar.f61661c = (TextView) bVar.f61659a.findViewById(R.id.fourm_tv);
        bVar.f61662d = bVar.f61659a.findViewById(R.id.line_view);
        TbImageView tbImageView = (TbImageView) bVar.f61659a.findViewById(R.id.icon_img);
        bVar.f61660b = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        bVar.f61660b.setDefaultResource(R.drawable.transparent_bg);
        bVar.f61659a.setTag(bVar);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public HotTopicBussinessData getItem(int i) {
        List<HotTopicBussinessData> list = this.f61657g;
        if (list != null && i < list.size()) {
            return this.f61657g.get(i);
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
        this.f61657g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f61657g)) {
            return 0;
        }
        return this.f61657g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.f61658h == null) {
            this.f61658h = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            bVar = a(view != null ? view.getTag() : null, item);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.f61659a;
        }
        return null;
    }
}
