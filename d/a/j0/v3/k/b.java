package d.a.j0.v3.k;

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
import d.a.c.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.i0.e.a> f61975e;

    /* renamed from: f  reason: collision with root package name */
    public String f61976f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f61977g;

    /* renamed from: h  reason: collision with root package name */
    public int f61978h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f61979i;

    /* renamed from: d.a.j0.v3.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1635b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61980a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61981b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61982c;

        public C1635b(b bVar) {
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f61977g = baseFragmentActivity;
        this.f61979i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f61978h = l.k(this.f61977g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.i0.e.a getItem(int i2) {
        return (d.a.i0.e.a) ListUtils.getItem(this.f61975e, i2);
    }

    public void b(List<d.a.i0.e.a> list, String str) {
        this.f61975e = list;
        this.f61976f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f61975e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1635b c1635b;
        if (view != null && (view.getTag() instanceof C1635b)) {
            c1635b = (C1635b) view.getTag();
        } else {
            view = this.f61979i.inflate(R.layout.album_list_item, viewGroup, false);
            c1635b = new C1635b();
            c1635b.f61980a = (TbImageView) view.findViewById(R.id.item_head);
            c1635b.f61981b = (TextView) view.findViewById(R.id.item_name);
            c1635b.f61982c = (ImageView) view.findViewById(R.id.item_arrow);
            c1635b.f61980a.setGifIconSupport(false);
            c1635b.f61980a.setLongIconSupport(false);
            view.setTag(c1635b);
        }
        d.a.i0.e.a item = getItem(i2);
        if (item == null) {
            view.setVisibility(4);
            return view;
        }
        view.setVisibility(0);
        if (!TextUtils.isEmpty(item.g())) {
            String s = l.s(c1635b.f61981b.getPaint(), item.g(), this.f61978h);
            c1635b.f61981b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            c1635b.f61981b.setText("");
        }
        String b2 = item.b();
        if (!TextUtils.isEmpty(b2) && b2.equals(this.f61976f)) {
            c1635b.f61982c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            c1635b.f61982c.setVisibility(0);
        } else {
            c1635b.f61982c.setVisibility(8);
        }
        MediaFileInfo f2 = item.f();
        if (f2 instanceof VideoFileInfo) {
            c1635b.f61980a.V(((VideoFileInfo) f2).videoPath, 37, false);
        } else if (f2 instanceof ImageFileInfo) {
            c1635b.f61980a.V(((ImageFileInfo) f2).getFilePath(), 35, false);
        }
        SkinManager.setViewTextColor(c1635b.f61981b, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
