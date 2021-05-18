package d.a.k0.v3.k;

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
    public List<d.a.j0.e.a> f62699e;

    /* renamed from: f  reason: collision with root package name */
    public String f62700f;

    /* renamed from: g  reason: collision with root package name */
    public BaseFragmentActivity f62701g;

    /* renamed from: h  reason: collision with root package name */
    public int f62702h;

    /* renamed from: i  reason: collision with root package name */
    public LayoutInflater f62703i;

    /* renamed from: d.a.k0.v3.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1700b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62704a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62705b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f62706c;

        public C1700b(b bVar) {
        }
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f62701g = baseFragmentActivity;
        this.f62703i = LayoutInflater.from(baseFragmentActivity.getPageContext().getPageActivity());
        this.f62702h = l.k(this.f62701g.getPageContext().getPageActivity()) / 2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public d.a.j0.e.a getItem(int i2) {
        return (d.a.j0.e.a) ListUtils.getItem(this.f62699e, i2);
    }

    public void b(List<d.a.j0.e.a> list, String str) {
        this.f62699e = list;
        this.f62700f = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f62699e);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C1700b c1700b;
        if (view != null && (view.getTag() instanceof C1700b)) {
            c1700b = (C1700b) view.getTag();
        } else {
            view = this.f62703i.inflate(R.layout.album_list_item, viewGroup, false);
            c1700b = new C1700b();
            c1700b.f62704a = (TbImageView) view.findViewById(R.id.item_head);
            c1700b.f62705b = (TextView) view.findViewById(R.id.item_name);
            c1700b.f62706c = (ImageView) view.findViewById(R.id.item_arrow);
            c1700b.f62704a.setGifIconSupport(false);
            c1700b.f62704a.setLongIconSupport(false);
            view.setTag(c1700b);
        }
        d.a.j0.e.a item = getItem(i2);
        if (item == null) {
            view.setVisibility(4);
            return view;
        }
        view.setVisibility(0);
        if (!TextUtils.isEmpty(item.g())) {
            String s = l.s(c1700b.f62705b.getPaint(), item.g(), this.f62702h);
            c1700b.f62705b.setText(s + "(" + item.c() + SmallTailInfo.EMOTION_SUFFIX);
        } else {
            c1700b.f62705b.setText("");
        }
        String b2 = item.b();
        if (!TextUtils.isEmpty(b2) && b2.equals(this.f62700f)) {
            c1700b.f62706c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_strok324_select, SkinManager.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            c1700b.f62706c.setVisibility(0);
        } else {
            c1700b.f62706c.setVisibility(8);
        }
        MediaFileInfo f2 = item.f();
        if (f2 instanceof VideoFileInfo) {
            c1700b.f62704a.V(((VideoFileInfo) f2).videoPath, 37, false);
        } else if (f2 instanceof ImageFileInfo) {
            c1700b.f62704a.V(((ImageFileInfo) f2).getFilePath(), 35, false);
        }
        SkinManager.setViewTextColor(c1700b.f62705b, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
