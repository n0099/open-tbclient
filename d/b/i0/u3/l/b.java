package d.b.i0.u3.l;

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
import d.b.b.e.p.l;
import java.util.List;
/* loaded from: classes5.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.h0.e.a> f61583e;

    /* renamed from: f  reason: collision with root package name */
    public String f61584f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f61585g;

    /* renamed from: h  reason: collision with root package name */
    public int f61586h;
    public LayoutInflater i;

    /* renamed from: d.b.i0.u3.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1614b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61587a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61588b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61589c;

        public C1614b(b bVar) {
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f61585g = baseFragmentActivity;
        this.i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f61586h = l.k(this.f61585g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.h0.e.a getItem(int i) {
        return (d.b.h0.e.a) ListUtils.getItem(this.f61583e, i);
    }

    public void b(List<d.b.h0.e.a> list, String str) {
        this.f61583e = list;
        this.f61584f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f61583e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1614b c1614b;
        if (view != null && (view.getTag() instanceof C1614b)) {
            c1614b = (C1614b) view.getTag();
        } else {
            view = this.i.inflate(R.layout.album_list_item, viewGroup, false);
            c1614b = new C1614b();
            c1614b.f61587a = (TbImageView) view.findViewById(R.id.item_head);
            c1614b.f61588b = (TextView) view.findViewById(R.id.item_name);
            c1614b.f61589c = (ImageView) view.findViewById(R.id.item_arrow);
            c1614b.f61587a.setGifIconSupport(false);
            c1614b.f61587a.setLongIconSupport(false);
            view.setTag(c1614b);
        }
        d.b.h0.e.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
            return view;
        }
        view.setVisibility(0);
        if (!TextUtils.isEmpty(item.g())) {
            String s = l.s(c1614b.f61588b.getPaint(), item.g(), this.f61586h);
            c1614b.f61588b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            c1614b.f61588b.setText("");
        }
        String b2 = item.b();
        if (!TextUtils.isEmpty(b2) && b2.equals(this.f61584f)) {
            c1614b.f61589c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            c1614b.f61589c.setVisibility(0);
        } else {
            c1614b.f61589c.setVisibility(8);
        }
        MediaFileInfo f2 = item.f();
        if (f2 instanceof VideoFileInfo) {
            c1614b.f61587a.W(((VideoFileInfo) f2).videoPath, 37, false);
        } else if (f2 instanceof ImageFileInfo) {
            c1614b.f61587a.W(((ImageFileInfo) f2).getFilePath(), 35, false);
        }
        SkinManager.setViewTextColor(c1614b.f61588b, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
