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
    public List<d.a.m0.e.a> f62806e;

    /* renamed from: f  reason: collision with root package name */
    public String f62807f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f62808g;

    /* renamed from: h  reason: collision with root package name */
    public int f62809h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f62810i;

    /* renamed from: d.a.n0.w3.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1713b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62811a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62812b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62813c;

        public C1713b(b bVar) {
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f62808g = baseFragmentActivity;
        this.f62810i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f62809h = l.k(this.f62808g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.m0.e.a getItem(int i2) {
        return (d.a.m0.e.a) ListUtils.getItem(this.f62806e, i2);
    }

    public void b(List<d.a.m0.e.a> list, String str) {
        this.f62806e = list;
        this.f62807f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f62806e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1713b c1713b;
        if (view != null && (view.getTag() instanceof C1713b)) {
            c1713b = (C1713b) view.getTag();
        } else {
            view = this.f62810i.inflate(R.layout.album_list_item, viewGroup, false);
            c1713b = new C1713b();
            c1713b.f62811a = (TbImageView) view.findViewById(R.id.item_head);
            c1713b.f62812b = (TextView) view.findViewById(R.id.item_name);
            c1713b.f62813c = (ImageView) view.findViewById(R.id.item_arrow);
            c1713b.f62811a.setGifIconSupport(false);
            c1713b.f62811a.setLongIconSupport(false);
            view.setTag(c1713b);
        }
        d.a.m0.e.a item = getItem(i2);
        if (item == null) {
            view.setVisibility(4);
            return view;
        }
        view.setVisibility(0);
        if (!TextUtils.isEmpty(item.g())) {
            String s = l.s(c1713b.f62812b.getPaint(), item.g(), this.f62809h);
            c1713b.f62812b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            c1713b.f62812b.setText("");
        }
        String b2 = item.b();
        if (!TextUtils.isEmpty(b2) && b2.equals(this.f62807f)) {
            c1713b.f62813c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            c1713b.f62813c.setVisibility(0);
        } else {
            c1713b.f62813c.setVisibility(8);
        }
        MediaFileInfo f2 = item.f();
        if (f2 instanceof VideoFileInfo) {
            c1713b.f62811a.V(((VideoFileInfo) f2).videoPath, 37, false);
        } else if (f2 instanceof ImageFileInfo) {
            c1713b.f62811a.V(((ImageFileInfo) f2).getFilePath(), 35, false);
        }
        SkinManager.setViewTextColor(c1713b.f62812b, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
