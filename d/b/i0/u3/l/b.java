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
    public List<d.b.h0.e.a> f61584e;

    /* renamed from: f  reason: collision with root package name */
    public String f61585f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f61586g;

    /* renamed from: h  reason: collision with root package name */
    public int f61587h;
    public LayoutInflater i;

    /* renamed from: d.b.i0.u3.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1615b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61588a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61589b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f61590c;

        public C1615b(b bVar) {
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f61586g = baseFragmentActivity;
        this.i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f61587h = l.k(this.f61586g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.h0.e.a getItem(int i) {
        return (d.b.h0.e.a) ListUtils.getItem(this.f61584e, i);
    }

    public void b(List<d.b.h0.e.a> list, String str) {
        this.f61584e = list;
        this.f61585f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f61584e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1615b c1615b;
        if (view != null && (view.getTag() instanceof C1615b)) {
            c1615b = (C1615b) view.getTag();
        } else {
            view = this.i.inflate(R.layout.album_list_item, viewGroup, false);
            c1615b = new C1615b();
            c1615b.f61588a = (TbImageView) view.findViewById(R.id.item_head);
            c1615b.f61589b = (TextView) view.findViewById(R.id.item_name);
            c1615b.f61590c = (ImageView) view.findViewById(R.id.item_arrow);
            c1615b.f61588a.setGifIconSupport(false);
            c1615b.f61588a.setLongIconSupport(false);
            view.setTag(c1615b);
        }
        d.b.h0.e.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
            return view;
        }
        view.setVisibility(0);
        if (!TextUtils.isEmpty(item.g())) {
            String s = l.s(c1615b.f61589b.getPaint(), item.g(), this.f61587h);
            c1615b.f61589b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            c1615b.f61589b.setText("");
        }
        String b2 = item.b();
        if (!TextUtils.isEmpty(b2) && b2.equals(this.f61585f)) {
            c1615b.f61590c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            c1615b.f61590c.setVisibility(0);
        } else {
            c1615b.f61590c.setVisibility(8);
        }
        MediaFileInfo f2 = item.f();
        if (f2 instanceof VideoFileInfo) {
            c1615b.f61588a.W(((VideoFileInfo) f2).videoPath, 37, false);
        } else if (f2 instanceof ImageFileInfo) {
            c1615b.f61588a.W(((ImageFileInfo) f2).getFilePath(), 35, false);
        }
        SkinManager.setViewTextColor(c1615b.f61589b, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
