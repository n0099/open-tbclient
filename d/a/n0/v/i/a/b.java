package d.a.n0.v.i.a;

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
import d.a.m0.r.q.a2;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f65683e;

    /* renamed from: f  reason: collision with root package name */
    public List<a2> f65684f;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public View f65685a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65686b;

        /* renamed from: c  reason: collision with root package name */
        public AlaCardBottomUserInfoLayout f65687c;

        /* renamed from: d  reason: collision with root package name */
        public RelativeLayout f65688d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65689e;

        public a(View view) {
            this.f65685a = view;
            this.f65686b = (TbImageView) view.findViewById(R.id.img_thumbnail);
            this.f65687c = (AlaCardBottomUserInfoLayout) view.findViewById(R.id.ala_card_bottom_user_info_layout);
            this.f65688d = (RelativeLayout) view.findViewById(R.id.ala_card_live_top);
            this.f65689e = (TextView) view.findViewById(R.id.ala_card_live_title);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        this.f65683e = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public a2 getItem(int i2) {
        List<a2> list = this.f65684f;
        if (list != null && i2 >= 0 && i2 <= list.size()) {
            return this.f65684f.get(i2);
        }
        return null;
    }

    public void b(List<a2> list) {
        this.f65684f = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (ListUtils.isEmpty(this.f65684f)) {
            return 0;
        }
        return this.f65684f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AlaInfoData s1;
        if (view == null) {
            view = LayoutInflater.from(this.f65683e.getPageActivity()).inflate(R.layout.ala_card_live_item, (ViewGroup) null);
            aVar = new a(view);
            aVar.f65686b.setIsRound(true);
            aVar.f65686b.setDrawBorder(false);
            aVar.f65686b.setAutoChangeStyle(true);
            aVar.f65686b.setGifIconSupport(false);
            int k = (l.k(this.f65683e.getPageActivity()) - this.f65683e.getPageActivity().getResources().getDimensionPixelSize(R.dimen.ds100)) / 3;
            int i3 = (k * 16) / 9;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.f65688d.getLayoutParams();
            layoutParams.height = k;
            layoutParams.width = i3;
            aVar.f65688d.setLayoutParams(layoutParams);
            AbsHListView.LayoutParams layoutParams2 = new AbsHListView.LayoutParams(-1, -1);
            ((ViewGroup.LayoutParams) layoutParams2).width = i3;
            view.setLayoutParams(layoutParams2);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a2 item = getItem(i2);
        if (item == null || (s1 = item.s1()) == null) {
            return null;
        }
        aVar.f65686b.U(s1.cover, 10, false);
        aVar.f65687c.setData(item);
        aVar.f65687c.setUserHeadImgVisible(8);
        aVar.f65689e.setText(item.A1());
        aVar.f65687c.onChangeSkinType(this.f65683e);
        SkinManager.setViewTextColor(aVar.f65689e, R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundResource(view, R.drawable.addresslist_item_bg);
        return view;
    }
}
