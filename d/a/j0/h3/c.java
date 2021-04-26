package d.a.j0.h3;

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
    public List<InterestFrsData.Card> f54881e;

    /* renamed from: f  reason: collision with root package name */
    public Context f54882f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f54883g;

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public FrameLayout f54884a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f54885b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f54886c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f54887d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f54888e;

        public b(c cVar) {
        }
    }

    public c(Context context) {
        this.f54882f = context;
    }

    public void a(List<InterestFrsData.Card> list) {
        this.f54881e = list;
        notifyDataSetChanged();
    }

    public void b(ImageView imageView, boolean z) {
        if (!z) {
            imageView.setBackgroundDrawable(this.f54882f.getResources().getDrawable(R.drawable.icon_startpage2_add_pic_n));
        } else {
            imageView.setBackgroundDrawable(this.f54882f.getResources().getDrawable(R.drawable.icon_startpage2_add_ba_s));
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.f54883g = onClickListener;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<InterestFrsData.Card> list = this.f54881e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        List<InterestFrsData.Card> list = this.f54881e;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return this.f54881e.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f54882f).inflate(R.layout.new_user_img_item, viewGroup, false);
            bVar = new b();
            bVar.f54885b = (TbImageView) view.findViewById(R.id.pic);
            bVar.f54886c = (ImageView) view.findViewById(R.id.select_icon);
            bVar.f54887d = (RelativeLayout) view.findViewById(R.id.lay_select);
            bVar.f54888e = (TextView) view.findViewById(R.id.tv_fname);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.pic_layout);
            bVar.f54884a = frameLayout;
            frameLayout.setOnClickListener(this.f54883g);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f54885b.setTag(null);
        bVar.f54887d.setTag(null);
        bVar.f54888e.setText("");
        bVar.f54884a.setTag(null);
        Object item = getItem(i2);
        if (item != null && (item instanceof InterestFrsData.Card)) {
            InterestFrsData.Card card = (InterestFrsData.Card) item;
            b(bVar.f54886c, card.getIs_like() == 1);
            bVar.f54887d.setTag(card);
            bVar.f54884a.setTag(card);
            bVar.f54885b.setTag(card.getIcon_url());
            bVar.f54885b.V(card.getIcon_url(), 21, false);
            bVar.f54888e.setText(card.getFname());
        }
        return view;
    }
}
