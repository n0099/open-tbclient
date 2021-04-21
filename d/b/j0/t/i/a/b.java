package d.b.j0.t.i.a;

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
import d.b.c.e.p.l;
import d.b.i0.r.q.a2;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f62760e;

    /* renamed from: f  reason: collision with root package name */
    public List<a2> f62761f;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f62762a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f62763b;

        /* renamed from: c  reason: collision with root package name */
        public AlaCardBottomUserInfoLayout f62764c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f62765d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62766e;

        public a(View view) {
            this.f62762a = view;
            this.f62763b = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.f62764c = (AlaCardBottomUserInfoLayout) view.findViewById(R.id.ala_card_bottom_user_info_layout);
            this.f62765d = (RelativeLayout) view.findViewById(R.id.ala_card_live_top);
            this.f62766e = (TextView) view.findViewById(R.id.ala_card_live_title);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f62760e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public a2 getItem(int i) {
        List<a2> list = this.f62761f;
        if (list != null && i >= 0 && i <= list.size()) {
            return this.f62761f.get(i);
        }
        return null;
    }

    public void b(List<a2> list) {
        this.f62761f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f62761f)) {
            return 0;
        }
        return this.f62761f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AlaInfoData q1;
        if (view == null) {
            view = LayoutInflater.from(this.f62760e.getPageActivity()).inflate(R.layout.ala_card_live_item, (ViewGroup) null);
            aVar = new a(view);
            aVar.f62763b.setIsRound(true);
            aVar.f62763b.setDrawBorder(false);
            aVar.f62763b.setAutoChangeStyle(true);
            aVar.f62763b.setGifIconSupport(false);
            int k = (l.k(this.f62760e.getPageActivity()) - this.f62760e.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds100)) / 3;
            int i2 = (k * 16) / 9;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f62765d.getLayoutParams();
            layoutParams.height = k;
            layoutParams.width = i2;
            aVar.f62765d.setLayoutParams(layoutParams);
            AbsHListView.LayoutParams layoutParams2 = new AbsHListView.LayoutParams(-1, -1);
            ((ViewGroup.LayoutParams) layoutParams2).width = i2;
            view.setLayoutParams(layoutParams2);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a2 item = getItem(i);
        if (item == null || (q1 = item.q1()) == null) {
            return null;
        }
        aVar.f62763b.W(q1.cover, 10, false);
        aVar.f62764c.setData(item);
        aVar.f62764c.setUserHeadImgVisible(8);
        aVar.f62766e.setText(item.x1());
        aVar.f62764c.onChangeSkinType(this.f62760e);
        SkinManager.setViewTextColor(aVar.f62766e, R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
