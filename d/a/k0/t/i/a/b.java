package d.a.k0.t.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.view.card.AlaCardBottomUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AbsHListView;
import d.a.c.e.p.l;
import d.a.j0.r.q.a2;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f61680e;

    /* renamed from: f  reason: collision with root package name */
    public List<a2> f61681f;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f61682a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f61683b;

        /* renamed from: c  reason: collision with root package name */
        public AlaCardBottomUserInfoLayout f61684c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f61685d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61686e;

        public a(View view) {
            this.f61682a = view;
            this.f61683b = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.f61684c = (AlaCardBottomUserInfoLayout) view.findViewById(R.id.ala_card_bottom_user_info_layout);
            this.f61685d = (RelativeLayout) view.findViewById(R.id.ala_card_live_top);
            this.f61686e = (TextView) view.findViewById(R.id.ala_card_live_title);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f61680e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public a2 getItem(int i2) {
        List<a2> list = this.f61681f;
        if (list != null && i2 >= 0 && i2 <= list.size()) {
            return this.f61681f.get(i2);
        }
        return null;
    }

    public void b(List<a2> list) {
        this.f61681f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f61681f)) {
            return 0;
        }
        return this.f61681f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AlaInfoData q1;
        if (view == null) {
            view = LayoutInflater.from(this.f61680e.getPageActivity()).inflate(R.layout.ala_card_live_item, (ViewGroup) null);
            aVar = new a(view);
            aVar.f61683b.setIsRound(true);
            aVar.f61683b.setDrawBorder(false);
            aVar.f61683b.setAutoChangeStyle(true);
            aVar.f61683b.setGifIconSupport(false);
            int k = (l.k(this.f61680e.getPageActivity()) - this.f61680e.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds100)) / 3;
            int i3 = (k * 16) / 9;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f61685d.getLayoutParams();
            layoutParams.height = k;
            layoutParams.width = i3;
            aVar.f61685d.setLayoutParams(layoutParams);
            AbsHListView.LayoutParams layoutParams2 = new AbsHListView.LayoutParams(-1, -1);
            ((ViewGroup.LayoutParams) layoutParams2).width = i3;
            view.setLayoutParams(layoutParams2);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a2 item = getItem(i2);
        if (item == null || (q1 = item.q1()) == null) {
            return null;
        }
        aVar.f61683b.V(q1.cover, 10, false);
        aVar.f61684c.setData(item);
        aVar.f61684c.setUserHeadImgVisible(8);
        aVar.f61686e.setText(item.y1());
        aVar.f61684c.onChangeSkinType(this.f61680e);
        SkinManager.setViewTextColor(aVar.f61686e, R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
