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
    public Context f60982e;

    /* renamed from: f  reason: collision with root package name */
    public List<GiftCommonList.GiftItem> f60983f;

    /* renamed from: g  reason: collision with root package name */
    public int f60984g = -1;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout.LayoutParams f60985h;

    /* loaded from: classes4.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60986a;

        /* renamed from: b  reason: collision with root package name */
        public View f60987b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60988c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60989d;

        public b(a aVar) {
        }
    }

    public a(Context context) {
        this.f60982e = context;
        this.f60985h = new RelativeLayout.LayoutParams(-1, (context.getResources().getDimensionPixelSize(R.dimen.ds450) - 8) / 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GiftCommonList.GiftItem getItem(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.f60983f.get(i);
    }

    public int b() {
        return this.f60984g;
    }

    public void c(List<GiftCommonList.GiftItem> list) {
        this.f60983f = list;
        notifyDataSetChanged();
    }

    public void d(int i) {
        this.f60984g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<GiftCommonList.GiftItem> list = this.f60983f;
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
            view = LayoutInflater.from(this.f60982e).inflate(R.layout.gift_list_item, (ViewGroup) null);
            bVar = new b();
            bVar.f60986a = (TbImageView) view.findViewById(R.id.image);
            bVar.f60987b = view.findViewById(R.id.mask);
            bVar.f60988c = (TextView) view.findViewById(R.id.name);
            bVar.f60989d = (TextView) view.findViewById(R.id.price);
            view.setTag(bVar);
        }
        bVar.f60987b.setLayoutParams(this.f60985h);
        SkinManager.setBackgroundResource(view, R.color.CAM_X0201);
        SkinManager.setViewTextColor(bVar.f60988c, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(bVar.f60989d, R.color.CAM_X0301, 1);
        if (i == this.f60984g) {
            SkinManager.setBackgroundResource(bVar.f60987b, R.drawable.chx_box_gift_s);
        } else {
            bVar.f60987b.setBackgroundResource(R.color.common_color_10022);
        }
        GiftCommonList.GiftItem item = getItem(i);
        if (item != null) {
            bVar.f60988c.setText(item.getName());
            bVar.f60989d.setText(String.format(this.f60982e.getString(R.string.tdou_price_format), Integer.valueOf(item.getPrice())));
            bVar.f60986a.W(item.getThumbnailUrl(), 10, false);
        }
        return view;
    }
}
