package d.a.j0.t.d.e.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.i0.r.q.a2;
import d.a.j0.t.d.e.b.b;
/* loaded from: classes4.dex */
public class b extends d.a.j0.t.d.e.a.a {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.d.e.b.b f60658e;

        public a(d.a.j0.t.d.e.b.b bVar) {
            this.f60658e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c12659");
            statisticItem.param("tid", this.f60658e.f60681a.w1());
            TiebaStatic.log(statisticItem);
            b bVar = b.this;
            bVar.b(bVar.f60654e, this.f60658e.f60681a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
        }
    }

    /* renamed from: d.a.j0.t.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1566b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60660a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60661b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60662c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60663d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60664e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60665f;

        public C1566b() {
        }

        public /* synthetic */ C1566b(a aVar) {
            this();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1566b c1566b;
        a2 a2Var;
        if (view == null) {
            c1566b = new C1566b(null);
            view2 = LayoutInflater.from(this.f60655f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
            c1566b.f60660a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            c1566b.f60661b = (TextView) view2.findViewById(R.id.recent_history_living_title);
            c1566b.f60662c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
            c1566b.f60663d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
            c1566b.f60664e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
            c1566b.f60665f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(c1566b.f60661b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(c1566b.f60662c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(c1566b.f60663d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(c1566b.f60665f, R.color.CAM_X0301);
            view2.setTag(c1566b);
        } else {
            view2 = view;
            c1566b = (C1566b) view.getTag();
        }
        d.a.j0.t.d.e.b.b item = getItem(i2);
        if (item != null && (a2Var = item.f60681a) != null && a2Var.T() != null && item.f60681a.q1() != null) {
            MetaData T = item.f60681a.T();
            c1566b.f60660a.V(item.f60681a.q1().cover, 10, false);
            c1566b.f60661b.setText(item.f60681a.x1());
            this.f60657h = 0;
            c1566b.f60664e.setVisibility(8);
            c1566b.f60665f.setVisibility(8);
            if (!ListUtils.isEmpty(item.f60684d)) {
                for (b.a aVar : item.f60684d) {
                    if (aVar != null) {
                        int i3 = aVar.f60685a;
                        if (1 == i3) {
                            c1566b.f60664e.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60686b)) {
                                c1566b.f60664e.setText(aVar.f60686b);
                            }
                            this.f60657h++;
                        } else if (2 == i3) {
                            c1566b.f60665f.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60686b)) {
                                c1566b.f60665f.setText(aVar.f60686b);
                            }
                            this.f60657h++;
                        }
                    }
                }
            }
            String name_show = T.getName_show();
            int i4 = this.f60657h <= 1 ? 14 : 13;
            if (k.byteLength(name_show) > i4) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, StringHelper.STRING_MORE);
            }
            c1566b.f60663d.setText(name_show);
            c1566b.f60662c.setText(this.f60655f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f60681a.q1().audience_count)));
            view2.setOnClickListener(new a(item));
            StatisticItem statisticItem = new StatisticItem("c12658");
            statisticItem.param("tid", item.f60681a.w1());
            d.a.j0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }
}
