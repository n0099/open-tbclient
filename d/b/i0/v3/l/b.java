package d.b.i0.v3.l;

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
    public List<d.b.h0.e.a> f63322e;

    /* renamed from: f  reason: collision with root package name */
    public String f63323f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f63324g;

    /* renamed from: h  reason: collision with root package name */
    public int f63325h;
    public LayoutInflater i;

    /* renamed from: d.b.i0.v3.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1675b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f63326a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f63327b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f63328c;

        public C1675b(b bVar) {
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f63324g = baseFragmentActivity;
        this.i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f63325h = l.k(this.f63324g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.b.h0.e.a getItem(int i) {
        return (d.b.h0.e.a) ListUtils.getItem(this.f63322e, i);
    }

    public void b(List<d.b.h0.e.a> list, String str) {
        this.f63322e = list;
        this.f63323f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f63322e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1675b c1675b;
        if (view != null && (view.getTag() instanceof C1675b)) {
            c1675b = (C1675b) view.getTag();
        } else {
            view = this.i.inflate(R.layout.album_list_item, viewGroup, false);
            c1675b = new C1675b();
            c1675b.f63326a = (TbImageView) view.findViewById(R.id.item_head);
            c1675b.f63327b = (TextView) view.findViewById(R.id.item_name);
            c1675b.f63328c = (ImageView) view.findViewById(R.id.item_arrow);
            c1675b.f63326a.setGifIconSupport(false);
            c1675b.f63326a.setLongIconSupport(false);
            view.setTag(c1675b);
        }
        d.b.h0.e.a item = getItem(i);
        if (item == null) {
            view.setVisibility(4);
            return view;
        }
        view.setVisibility(0);
        if (!TextUtils.isEmpty(item.g())) {
            String s = l.s(c1675b.f63327b.getPaint(), item.g(), this.f63325h);
            c1675b.f63327b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            c1675b.f63327b.setText("");
        }
        String b2 = item.b();
        if (!TextUtils.isEmpty(b2) && b2.equals(this.f63323f)) {
            c1675b.f63328c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            c1675b.f63328c.setVisibility(0);
        } else {
            c1675b.f63328c.setVisibility(8);
        }
        MediaFileInfo f2 = item.f();
        if (f2 instanceof VideoFileInfo) {
            c1675b.f63326a.W(((VideoFileInfo) f2).videoPath, 37, false);
        } else if (f2 instanceof ImageFileInfo) {
            c1675b.f63326a.W(((ImageFileInfo) f2).getFilePath(), 35, false);
        }
        SkinManager.setViewTextColor(c1675b.f63327b, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
