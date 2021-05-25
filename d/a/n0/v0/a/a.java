package d.a.n0.v0.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.buyGift.GiftCommonList;
import java.util.List;
@Deprecated
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f62184e;

    /* renamed from: f  reason: collision with root package name */
    public List<GiftCommonList.GiftItem> f62185f;

    /* renamed from: g  reason: collision with root package name */
    public int f62186g = -1;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout.LayoutParams f62187h;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62188a;

        /* renamed from: b  reason: collision with root package name */
        public View f62189b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62190c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62191d;

        public b(a aVar) {
        }
    }

    public a(Context context) {
        this.f62184e = context;
        this.f62187h = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.ds450) - 8) / 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.GiftItem getItem(int i2) {
        if (i2 < 0 || i2 >= getCount()) {
            return null;
        }
        return this.f62185f.get(i2);
    }

    public int b() {
        return this.f62186g;
    }

    public void c(List<GiftCommonList.GiftItem> list) {
        this.f62185f = list;
        notifyDataSetChanged();
    }

    public void d(int i2) {
        this.f62186g = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<GiftCommonList.GiftItem> list = this.f62185f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null && view.getTag() != null) {
            bVar = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f62184e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            bVar = new b();
            bVar.f62188a = (TbImageView) view.findViewById(R.id.image);
            bVar.f62189b = view.findViewById(R.id.mask);
            bVar.f62190c = (TextView) view.findViewById(R.id.name);
            bVar.f62191d = (TextView) view.findViewById(R.id.price);
            view.setTag(bVar);
        }
        bVar.f62189b.setLayoutParams(this.f62187h);
        SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        SkinManager.setViewTextColor(bVar.f62190c, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f62191d, R.color.CAM_X0301, 1);
        if (i2 == this.f62186g) {
            SkinManager.setBackgroundResource(bVar.f62189b, R.drawable.chx_box_gift_s);
        } else {
            bVar.f62189b.setBackgroundResource(R.color.common_color_10022);
        }
        GiftCommonList.GiftItem item = getItem(i2);
        if (item != null) {
            bVar.f62190c.setText(item.getName());
            bVar.f62191d.setText(String.format(this.f62184e.getString(R.string.tdou_price_format), Integer.valueOf(item.getPrice())));
            bVar.f62188a.V(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }
}
