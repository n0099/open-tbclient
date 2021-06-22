package d.a.o0.w3.k;

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
    public List<d.a.n0.e.a> f66646e;

    /* renamed from: f  reason: collision with root package name */
    public String f66647f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f66648g;

    /* renamed from: h  reason: collision with root package name */
    public int f66649h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f66650i;

    /* renamed from: d.a.o0.w3.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1774b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f66651a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f66652b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f66653c;

        public C1774b(b bVar) {
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f66648g = baseFragmentActivity;
        this.f66650i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f66649h = l.k(this.f66648g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.n0.e.a getItem(int i2) {
        return (d.a.n0.e.a) ListUtils.getItem(this.f66646e, i2);
    }

    public void b(List<d.a.n0.e.a> list, String str) {
        this.f66646e = list;
        this.f66647f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f66646e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1774b c1774b;
        if (view != null && (view.getTag() instanceof C1774b)) {
            c1774b = (C1774b) view.getTag();
        } else {
            view = this.f66650i.inflate(R.layout.album_list_item, viewGroup, false);
            c1774b = new C1774b();
            c1774b.f66651a = (TbImageView) view.findViewById(R.id.item_head);
            c1774b.f66652b = (TextView) view.findViewById(R.id.item_name);
            c1774b.f66653c = (ImageView) view.findViewById(R.id.item_arrow);
            c1774b.f66651a.setGifIconSupport(false);
            c1774b.f66651a.setLongIconSupport(false);
            view.setTag(c1774b);
        }
        d.a.n0.e.a item = getItem(i2);
        if (item == null) {
            view.setVisibility(4);
            return view;
        }
        view.setVisibility(0);
        if (!TextUtils.isEmpty(item.g())) {
            String s = l.s(c1774b.f66652b.getPaint(), item.g(), this.f66649h);
            c1774b.f66652b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            c1774b.f66652b.setText("");
        }
        String b2 = item.b();
        if (!TextUtils.isEmpty(b2) && b2.equals(this.f66647f)) {
            c1774b.f66653c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            c1774b.f66653c.setVisibility(0);
        } else {
            c1774b.f66653c.setVisibility(8);
        }
        MediaFileInfo f2 = item.f();
        if (f2 instanceof VideoFileInfo) {
            c1774b.f66651a.U(((VideoFileInfo) f2).videoPath, 37, false);
        } else if (f2 instanceof ImageFileInfo) {
            c1774b.f66651a.U(((ImageFileInfo) f2).getFilePath(), 35, false);
        }
        SkinManager.setViewTextColor(c1774b.f66652b, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
