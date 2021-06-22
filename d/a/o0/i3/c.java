package d.a.o0.i3;

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
    public List<InterestFrsData.Card> f59590e;

    /* renamed from: f  reason: collision with root package name */
    public Context f59591f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f59592g;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f59593a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f59594b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f59595c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f59596d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f59597e;

        public b(c cVar) {
        }
    }

    public c(Context context) {
        this.f59591f = context;
    }

    public void a(List<InterestFrsData.Card> list) {
        this.f59590e = list;
        notifyDataSetChanged();
    }

    public void b(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.f59591f.getResources().getDrawable(R.drawable.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.f59591f.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.f59592g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<InterestFrsData.Card> list = this.f59590e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<InterestFrsData.Card> list = this.f59590e;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.f59590e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f59591f).inflate(R.layout.new_user_img_item, viewGroup, false);
            bVar = new b();
            bVar.f59594b = (TbImageView) view.findViewById(R.id.pic);
            bVar.f59595c = (ImageView) view.findViewById(R.id.select_icon);
            bVar.f59596d = (RelativeLayout) view.findViewById(R.id.lay_select);
            bVar.f59597e = (TextView) view.findViewById(R.id.tv_fname);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pic_layout);
            bVar.f59593a = frameLayout;
            frameLayout.setOnClickListener(this.f59592g);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f59594b.setTag(null);
        bVar.f59596d.setTag(null);
        bVar.f59597e.setText("");
        bVar.f59593a.setTag(null);
        Object item = getItem(i2);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(bVar.f59595c, card.getIs_like() == 1);
            bVar.f59596d.setTag(card);
            bVar.f59593a.setTag(card);
            bVar.f59594b.setTag(card.getIcon_url());
            bVar.f59594b.U(card.getIcon_url(), 21, false);
            bVar.f59597e.setText(card.getFname());
        }
        return view;
    }
}
