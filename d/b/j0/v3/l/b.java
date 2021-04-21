package d.b.j0.v3.l;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.i0.e.a> f63743e;

    /* renamed from: f  reason: collision with root package name */
    public String f63744f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f63745g;

    /* renamed from: h  reason: collision with root package name */
    public int f63746h;
    public LayoutInflater i;

    /* renamed from: d.b.j0.v3.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1698b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f63747a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63748b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f63749c;

        public C1698b(b bVar) {
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f63745g = baseFragmentActivity;
        this.i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f63746h = l.k(this.f63745g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.i0.e.a getItem(int i) {
        return (d.b.i0.e.a) ListUtils.getItem(this.f63743e, i);
    }

    public void b(List<d.b.i0.e.a> list, String str) {
        this.f63743e = list;
        this.f63744f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f63743e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1698b c1698b;
        if (view != null && (view.getTag() instanceof C1698b)) {
            c1698b = (C1698b) view.getTag();
        } else {
            view = this.i.inflate(R.layout.album_list_item, viewGroup, false);
            c1698b = new C1698b();
            c1698b.f63747a = (TbImageView) view.findViewById(R.id.item_head);
            c1698b.f63748b = (TextView) view.findViewById(R.id.item_name);
            c1698b.f63749c = (ImageView) view.findViewById(R.id.item_arrow);
            c1698b.f63747a.setGifIconSupport(false);
            c1698b.f63747a.setLongIconSupport(false);
            view.setTag(c1698b);
        }
        d.b.i0.e.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
            return view;
        }
        view.setVisibility(0);
        if (!TextUtils.isEmpty(item.g())) {
            String s = l.s(c1698b.f63748b.getPaint(), item.g(), this.f63746h);
            c1698b.f63748b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            c1698b.f63748b.setText("");
        }
        String b2 = item.b();
        if (!TextUtils.isEmpty(b2) && b2.equals(this.f63744f)) {
            c1698b.f63749c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            c1698b.f63749c.setVisibility(0);
        } else {
            c1698b.f63749c.setVisibility(8);
        }
        MediaFileInfo f2 = item.f();
        if (f2 instanceof VideoFileInfo) {
            c1698b.f63747a.W(((VideoFileInfo) f2).videoPath, 37, false);
        } else if (f2 instanceof ImageFileInfo) {
            c1698b.f63747a.W(((ImageFileInfo) f2).getFilePath(), 35, false);
        }
        SkinManager.setViewTextColor(c1698b.f63748b, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
