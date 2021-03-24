package d.b.i0.t.d.e.a;

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
import d.b.b.e.p.k;
import d.b.h0.r.q.a2;
import d.b.i0.t.d.e.b.b;
/* loaded from: classes4.dex */
public class b extends d.b.i0.t.d.e.a.a {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.d.e.b.b f60486e;

        public a(d.b.i0.t.d.e.b.b bVar) {
            this.f60486e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c12659");
            statisticItem.param("tid", this.f60486e.f60508a.w1());
            TiebaStatic.log(statisticItem);
            b bVar = b.this;
            bVar.b(bVar.f60482e, this.f60486e.f60508a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
        }
    }

    /* renamed from: d.b.i0.t.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1548b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60488a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60489b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60490c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60491d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60492e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60493f;

        public C1548b() {
        }

        public /* synthetic */ C1548b(a aVar) {
            this();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1548b c1548b;
        a2 a2Var;
        if (view == null) {
            c1548b = new C1548b(null);
            view2 = LayoutInflater.from(this.f60483f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
            c1548b.f60488a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            c1548b.f60489b = (TextView) view2.findViewById(R.id.recent_history_living_title);
            c1548b.f60490c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
            c1548b.f60491d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
            c1548b.f60492e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
            c1548b.f60493f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(c1548b.f60489b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(c1548b.f60490c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(c1548b.f60491d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(c1548b.f60493f, R.color.CAM_X0301);
            view2.setTag(c1548b);
        } else {
            view2 = view;
            c1548b = (C1548b) view.getTag();
        }
        d.b.i0.t.d.e.b.b item = getItem(i);
        if (item != null && (a2Var = item.f60508a) != null && a2Var.T() != null && item.f60508a.q1() != null) {
            MetaData T = item.f60508a.T();
            c1548b.f60488a.W(item.f60508a.q1().cover, 10, false);
            c1548b.f60489b.setText(item.f60508a.x1());
            this.f60485h = 0;
            c1548b.f60492e.setVisibility(8);
            c1548b.f60493f.setVisibility(8);
            if (!ListUtils.isEmpty(item.f60511d)) {
                for (b.a aVar : item.f60511d) {
                    if (aVar != null) {
                        int i2 = aVar.f60512a;
                        if (1 == i2) {
                            c1548b.f60492e.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60513b)) {
                                c1548b.f60492e.setText(aVar.f60513b);
                            }
                            this.f60485h++;
                        } else if (2 == i2) {
                            c1548b.f60493f.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60513b)) {
                                c1548b.f60493f.setText(aVar.f60513b);
                            }
                            this.f60485h++;
                        }
                    }
                }
            }
            String name_show = T.getName_show();
            int i3 = this.f60485h <= 1 ? 14 : 13;
            if (k.byteLength(name_show) > i3) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
            }
            c1548b.f60491d.setText(name_show);
            c1548b.f60490c.setText(this.f60483f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f60508a.q1().audience_count)));
            view2.setOnClickListener(new a(item));
            StatisticItem statisticItem = new StatisticItem("c12658");
            statisticItem.param("tid", item.f60508a.w1());
            d.b.i0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }
}
