package d.a.k0.v3.o;

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
    public final Context f62775e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicChangeFourmActivity f62776f;

    /* renamed from: g  reason: collision with root package name */
    public List<HotTopicBussinessData> f62777g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f62778h = null;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public View f62779a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62780b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62781c;

        /* renamed from: d  reason: collision with root package name */
        public View f62782d;

        public b(a aVar) {
        }
    }

    public a(HotTopicChangeFourmActivity hotTopicChangeFourmActivity) {
        this.f62776f = hotTopicChangeFourmActivity;
        this.f62775e = hotTopicChangeFourmActivity.getPageContext().getContext();
    }

    public final b a(Object obj, HotTopicBussinessData hotTopicBussinessData) {
        b bVar;
        if (obj == null) {
            bVar = b();
        } else {
            bVar = (b) obj;
        }
        bVar.f62781c.setText(d(hotTopicBussinessData.mForumName));
        bVar.f62780b.V(hotTopicBussinessData.mForumAvatar, 10, false);
        SkinManager.setBackgroundResource(bVar.f62779a, R.drawable.select_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f62781c, R.color.CAM_X0105);
        SkinManager.setBackgroundColor(bVar.f62782d, R.color.CAM_X0205);
        return bVar;
    }

    public final b b() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.f62775e).inflate(R.layout.hot_topic_change_item, (ViewGroup) null);
        bVar.f62779a = inflate;
        SkinManager.setBackgroundResource(inflate, R.drawable.select_forum_item_bg);
        SkinManager.setViewTextColor(bVar.f62781c, R.color.CAM_X0105);
        bVar.f62781c = (TextView) bVar.f62779a.findViewById(R.id.fourm_tv);
        bVar.f62782d = bVar.f62779a.findViewById(R.id.line_view);
        TbImageView tbImageView = (TbImageView) bVar.f62779a.findViewById(R.id.icon_img);
        bVar.f62780b = tbImageView;
        tbImageView.setDefaultBgResource(R.color.CAM_X0205);
        bVar.f62780b.setDefaultResource(R.drawable.transparent_bg);
        bVar.f62779a.setTag(bVar);
        return bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public HotTopicBussinessData getItem(int i2) {
        List<HotTopicBussinessData> list = this.f62777g;
        if (list != null && i2 < list.size()) {
            return this.f62777g.get(i2);
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
        this.f62777g = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f62777g)) {
            return 0;
        }
        return this.f62777g.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (this.f62778h == null) {
            this.f62778h = viewGroup;
        }
        HotTopicBussinessData item = getItem(i2);
        if (item != null) {
            bVar = a(view != null ? view.getTag() : null, item);
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.f62779a;
        }
        return null;
    }
}
