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
        public final /* synthetic */ d.b.i0.t.d.e.b.b f60487e;

        public a(d.b.i0.t.d.e.b.b bVar) {
            this.f60487e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c12659");
            statisticItem.param("tid", this.f60487e.f60509a.w1());
            TiebaStatic.log(statisticItem);
            b bVar = b.this;
            bVar.b(bVar.f60483e, this.f60487e.f60509a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
        }
    }

    /* renamed from: d.b.i0.t.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1549b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60489a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60490b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60491c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60492d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60493e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60494f;

        public C1549b() {
        }

        public /* synthetic */ C1549b(a aVar) {
            this();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1549b c1549b;
        a2 a2Var;
        if (view == null) {
            c1549b = new C1549b(null);
            view2 = LayoutInflater.from(this.f60484f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
            c1549b.f60489a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            c1549b.f60490b = (TextView) view2.findViewById(R.id.recent_history_living_title);
            c1549b.f60491c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
            c1549b.f60492d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
            c1549b.f60493e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
            c1549b.f60494f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(c1549b.f60490b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(c1549b.f60491c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(c1549b.f60492d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(c1549b.f60494f, R.color.CAM_X0301);
            view2.setTag(c1549b);
        } else {
            view2 = view;
            c1549b = (C1549b) view.getTag();
        }
        d.b.i0.t.d.e.b.b item = getItem(i);
        if (item != null && (a2Var = item.f60509a) != null && a2Var.T() != null && item.f60509a.q1() != null) {
            MetaData T = item.f60509a.T();
            c1549b.f60489a.W(item.f60509a.q1().cover, 10, false);
            c1549b.f60490b.setText(item.f60509a.x1());
            this.f60486h = 0;
            c1549b.f60493e.setVisibility(8);
            c1549b.f60494f.setVisibility(8);
            if (!ListUtils.isEmpty(item.f60512d)) {
                for (b.a aVar : item.f60512d) {
                    if (aVar != null) {
                        int i2 = aVar.f60513a;
                        if (1 == i2) {
                            c1549b.f60493e.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60514b)) {
                                c1549b.f60493e.setText(aVar.f60514b);
                            }
                            this.f60486h++;
                        } else if (2 == i2) {
                            c1549b.f60494f.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60514b)) {
                                c1549b.f60494f.setText(aVar.f60514b);
                            }
                            this.f60486h++;
                        }
                    }
                }
            }
            String name_show = T.getName_show();
            int i3 = this.f60486h <= 1 ? 14 : 13;
            if (k.byteLength(name_show) > i3) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
            }
            c1549b.f60492d.setText(name_show);
            c1549b.f60491c.setText(this.f60484f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f60509a.q1().audience_count)));
            view2.setOnClickListener(new a(item));
            StatisticItem statisticItem = new StatisticItem("c12658");
            statisticItem.param("tid", item.f60509a.w1());
            d.b.i0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }
}
