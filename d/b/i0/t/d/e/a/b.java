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
import d.b.c.e.p.k;
import d.b.h0.r.q.a2;
import d.b.i0.t.d.e.b.b;
/* loaded from: classes4.dex */
public class b extends d.b.i0.t.d.e.a.a {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.d.e.b.b f62051e;

        public a(d.b.i0.t.d.e.b.b bVar) {
            this.f62051e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c12659");
            statisticItem.param("tid", this.f62051e.f62073a.w1());
            TiebaStatic.log(statisticItem);
            b bVar = b.this;
            bVar.b(bVar.f62047e, this.f62051e.f62073a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
        }
    }

    /* renamed from: d.b.i0.t.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1602b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62053a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62054b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62055c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62056d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62057e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f62058f;

        public C1602b() {
        }

        public /* synthetic */ C1602b(a aVar) {
            this();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1602b c1602b;
        a2 a2Var;
        if (view == null) {
            c1602b = new C1602b(null);
            view2 = LayoutInflater.from(this.f62048f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
            c1602b.f62053a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            c1602b.f62054b = (TextView) view2.findViewById(R.id.recent_history_living_title);
            c1602b.f62055c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
            c1602b.f62056d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
            c1602b.f62057e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
            c1602b.f62058f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(c1602b.f62054b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(c1602b.f62055c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(c1602b.f62056d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(c1602b.f62058f, R.color.CAM_X0301);
            view2.setTag(c1602b);
        } else {
            view2 = view;
            c1602b = (C1602b) view.getTag();
        }
        d.b.i0.t.d.e.b.b item = getItem(i);
        if (item != null && (a2Var = item.f62073a) != null && a2Var.T() != null && item.f62073a.q1() != null) {
            MetaData T = item.f62073a.T();
            c1602b.f62053a.W(item.f62073a.q1().cover, 10, false);
            c1602b.f62054b.setText(item.f62073a.x1());
            this.f62050h = 0;
            c1602b.f62057e.setVisibility(8);
            c1602b.f62058f.setVisibility(8);
            if (!ListUtils.isEmpty(item.f62076d)) {
                for (b.a aVar : item.f62076d) {
                    if (aVar != null) {
                        int i2 = aVar.f62077a;
                        if (1 == i2) {
                            c1602b.f62057e.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f62078b)) {
                                c1602b.f62057e.setText(aVar.f62078b);
                            }
                            this.f62050h++;
                        } else if (2 == i2) {
                            c1602b.f62058f.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f62078b)) {
                                c1602b.f62058f.setText(aVar.f62078b);
                            }
                            this.f62050h++;
                        }
                    }
                }
            }
            String name_show = T.getName_show();
            int i3 = this.f62050h <= 1 ? 14 : 13;
            if (k.byteLength(name_show) > i3) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
            }
            c1602b.f62056d.setText(name_show);
            c1602b.f62055c.setText(this.f62048f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f62073a.q1().audience_count)));
            view2.setOnClickListener(new a(item));
            StatisticItem statisticItem = new StatisticItem("c12658");
            statisticItem.param("tid", item.f62073a.w1());
            d.b.i0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }
}
