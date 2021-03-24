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
    public final Context f61654e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicChangeFourmActivity f61655f;

    /* renamed from: g  reason: collision with root package name */
    public List<HotTopicBussinessData> f61656g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f61657h = null;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f61658a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61659b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61660c;

        /* renamed from: d  reason: collision with root package name */
        public View f61661d;

        public b(a aVar) {
        }
    }

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.f61655f = hotTopicChangeFourmActivity;
        this.f61654e = hotTopicChangeFourmActivity.getPageContext().getContext();
    }

    public final b a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        b bVar;
        if (obj == null) {
            bVar = b();
        } else {
            bVar = (b) obj;
        }
        bVar.f61660c.setText(d(hotTopicBussinessData.mForumName));
        bVar.f61659b.W(hotTopicBussinessData.mForumAvatar, 10, false);
        SkinManager.setBackgroundResource(bVar.f61658a, R.drawable.select_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f61660c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(bVar.f61661d, R.color.CAM_X0205);
        return bVar;
    }

    public final b b() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.f61654e).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        bVar.f61658a = inflate;
        SkinManager.setBackgroundResource(inflate, R.drawable.select_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f61660c, R.color.CAM_X0105);
        bVar.f61660c = (TextView) bVar.f61658a.findViewById(R.id.fourm_tv);
        bVar.f61661d = bVar.f61658a.findViewById(R.id.line_view);
        TbImageView tbImageView = (TbImageView) bVar.f61658a.findViewById(R.id.icon_img);
        bVar.f61659b = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        bVar.f61659b.setDefaultResource(R.drawable.transparent_bg);
        bVar.f61658a.setTag(bVar);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public HotTopicBussinessData getItem(int i) {
        List<HotTopicBussinessData> list = this.f61656g;
        if (list != null && i < list.size()) {
            return this.f61656g.get(i);
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
        this.f61656g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f61656g)) {
            return 0;
        }
        return this.f61656g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.f61657h == null) {
            this.f61657h = viewGroup;
        }
        HotTopicBussinessData item = getItem(i);
        if (item != null) {
            bVar = a(view != null ? view.getTag() : null, item);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.f61658a;
        }
        return null;
    }
}
