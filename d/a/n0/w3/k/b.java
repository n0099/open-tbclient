package d.a.n0.w3.k;

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
    public List<d.a.m0.e.a> f66521e;

    /* renamed from: f  reason: collision with root package name */
    public String f66522f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f66523g;

    /* renamed from: h  reason: collision with root package name */
    public int f66524h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f66525i;

    /* renamed from: d.a.n0.w3.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1770b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f66526a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f66527b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f66528c;

        public C1770b(b bVar) {
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f66523g = baseFragmentActivity;
        this.f66525i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f66524h = l.k(this.f66523g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.m0.e.a getItem(int i2) {
        return (d.a.m0.e.a) ListUtils.getItem(this.f66521e, i2);
    }

    public void b(List<d.a.m0.e.a> list, String str) {
        this.f66521e = list;
        this.f66522f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f66521e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1770b c1770b;
        if (view != null && (view.getTag() instanceof C1770b)) {
            c1770b = (C1770b) view.getTag();
        } else {
            view = this.f66525i.inflate(R.layout.album_list_item, viewGroup, false);
            c1770b = new C1770b();
            c1770b.f66526a = (TbImageView) view.findViewById(R.id.item_head);
            c1770b.f66527b = (TextView) view.findViewById(R.id.item_name);
            c1770b.f66528c = (ImageView) view.findViewById(R.id.item_arrow);
            c1770b.f66526a.setGifIconSupport(false);
            c1770b.f66526a.setLongIconSupport(false);
            view.setTag(c1770b);
        }
        d.a.m0.e.a item = getItem(i2);
        if (item == null) {
            view.setVisibility(4);
            return view;
        }
        view.setVisibility(0);
        if (!TextUtils.isEmpty(item.g())) {
            String s = l.s(c1770b.f66527b.getPaint(), item.g(), this.f66524h);
            c1770b.f66527b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            c1770b.f66527b.setText("");
        }
        String b2 = item.b();
        if (!TextUtils.isEmpty(b2) && b2.equals(this.f66522f)) {
            c1770b.f66528c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            c1770b.f66528c.setVisibility(0);
        } else {
            c1770b.f66528c.setVisibility(8);
        }
        MediaFileInfo f2 = item.f();
        if (f2 instanceof VideoFileInfo) {
            c1770b.f66526a.U(((VideoFileInfo) f2).videoPath, 37, false);
        } else if (f2 instanceof ImageFileInfo) {
            c1770b.f66526a.U(((ImageFileInfo) f2).getFilePath(), 35, false);
        }
        SkinManager.setViewTextColor(c1770b.f66527b, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
