package d.b.i0.t0.a;

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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public Context f60983e;

    /* renamed from: f  reason: collision with root package name */
    public List<GiftCommonList.GiftItem> f60984f;

    /* renamed from: g  reason: collision with root package name */
    public int f60985g = -1;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout.LayoutParams f60986h;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60987a;

        /* renamed from: b  reason: collision with root package name */
        public View f60988b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60989c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60990d;

        public b(a aVar) {
        }
    }

    public a(Context context) {
        this.f60983e = context;
        this.f60986h = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.ds450) - 8) / 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.f60984f.get(i);
    }

    public int b() {
        return this.f60985g;
    }

    public void c(List<GiftCommonList.GiftItem> list) {
        this.f60984f = list;
        notifyDataSetChanged();
    }

    public void d(int i) {
        this.f60985g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<GiftCommonList.GiftItem> list = this.f60984f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null && view.getTag() != null) {
            bVar = (b) view.getTag();
        } else {
            view = LayoutInflater.from(this.f60983e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            bVar = new b();
            bVar.f60987a = (TbImageView) view.findViewById(R.id.image);
            bVar.f60988b = view.findViewById(R.id.mask);
            bVar.f60989c = (TextView) view.findViewById(R.id.name);
            bVar.f60990d = (TextView) view.findViewById(R.id.price);
            view.setTag(bVar);
        }
        bVar.f60988b.setLayoutParams(this.f60986h);
        SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        SkinManager.setViewTextColor(bVar.f60989c, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f60990d, R.color.CAM_X0301, 1);
        if (i == this.f60985g) {
            SkinManager.setBackgroundResource(bVar.f60988b, R.drawable.chx_box_gift_s);
        } else {
            bVar.f60988b.setBackgroundResource(R.color.common_color_10022);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            bVar.f60989c.setText(item.getName());
            bVar.f60990d.setText(String.format(this.f60983e.getString(R.string.tdou_price_format), Integer.valueOf(item.getPrice())));
            bVar.f60987a.W(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }
}
