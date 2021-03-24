package d.b.i0.g3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public List<InterestFrsData.Card> f55005e;

    /* renamed from: f  reason: collision with root package name */
    public Context f55006f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f55007g;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f55008a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f55009b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f55010c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f55011d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f55012e;

        public b(c cVar) {
        }
    }

    public c(Context context) {
        this.f55006f = context;
    }

    public void a(List<InterestFrsData.Card> list) {
        this.f55005e = list;
        notifyDataSetChanged();
    }

    public void b(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.f55006f.getResources().getDrawable(R.drawable.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.f55006f.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.f55007g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<InterestFrsData.Card> list = this.f55005e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<InterestFrsData.Card> list = this.f55005e;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.f55005e.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f55006f).inflate(R.layout.new_user_img_item, viewGroup, false);
            bVar = new b();
            bVar.f55009b = (TbImageView) view.findViewById(R.id.pic);
            bVar.f55010c = (ImageView) view.findViewById(R.id.select_icon);
            bVar.f55011d = (RelativeLayout) view.findViewById(R.id.lay_select);
            bVar.f55012e = (TextView) view.findViewById(R.id.tv_fname);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pic_layout);
            bVar.f55008a = frameLayout;
            frameLayout.setOnClickListener(this.f55007g);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f55009b.setTag(null);
        bVar.f55011d.setTag(null);
        bVar.f55012e.setText("");
        bVar.f55008a.setTag(null);
        Object item = getItem(i);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(bVar.f55010c, card.getIs_like() == 1);
            bVar.f55011d.setTag(card);
            bVar.f55008a.setTag(card);
            bVar.f55009b.setTag(card.getIcon_url());
            bVar.f55009b.W(card.getIcon_url(), 21, false);
            bVar.f55012e.setText(card.getFname());
        }
        return view;
    }
}
