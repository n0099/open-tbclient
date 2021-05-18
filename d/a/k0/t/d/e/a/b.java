package d.a.k0.t.d.e.a;

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
import d.a.j0.r.q.a2;
import d.a.k0.t.d.e.b.b;
/* loaded from: classes4.dex */
public class b extends d.a.k0.t.d.e.a.a {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.t.d.e.b.b f61382e;

        public a(d.a.k0.t.d.e.b.b bVar) {
            this.f61382e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c12659");
            statisticItem.param("tid", this.f61382e.f61405a.x1());
            TiebaStatic.log(statisticItem);
            b bVar = b.this;
            bVar.b(bVar.f61378e, this.f61382e.f61405a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
        }
    }

    /* renamed from: d.a.k0.t.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1631b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61384a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61385b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61386c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61387d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61388e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61389f;

        public C1631b() {
        }

        public /* synthetic */ C1631b(a aVar) {
            this();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1631b c1631b;
        a2 a2Var;
        if (view == null) {
            c1631b = new C1631b(null);
            view2 = LayoutInflater.from(this.f61379f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
            c1631b.f61384a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            c1631b.f61385b = (TextView) view2.findViewById(R.id.recent_history_living_title);
            c1631b.f61386c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
            c1631b.f61387d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
            c1631b.f61388e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
            c1631b.f61389f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(c1631b.f61385b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(c1631b.f61386c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(c1631b.f61387d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(c1631b.f61389f, R.color.CAM_X0301);
            view2.setTag(c1631b);
        } else {
            view2 = view;
            c1631b = (C1631b) view.getTag();
        }
        d.a.k0.t.d.e.b.b item = getItem(i2);
        if (item != null && (a2Var = item.f61405a) != null && a2Var.T() != null && item.f61405a.q1() != null) {
            MetaData T = item.f61405a.T();
            c1631b.f61384a.V(item.f61405a.q1().cover, 10, false);
            c1631b.f61385b.setText(item.f61405a.y1());
            this.f61381h = 0;
            c1631b.f61388e.setVisibility(8);
            c1631b.f61389f.setVisibility(8);
            if (!ListUtils.isEmpty(item.f61408d)) {
                for (b.a aVar : item.f61408d) {
                    if (aVar != null) {
                        int i3 = aVar.f61409a;
                        if (1 == i3) {
                            c1631b.f61388e.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f61410b)) {
                                c1631b.f61388e.setText(aVar.f61410b);
                            }
                            this.f61381h++;
                        } else if (2 == i3) {
                            c1631b.f61389f.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f61410b)) {
                                c1631b.f61389f.setText(aVar.f61410b);
                            }
                            this.f61381h++;
                        }
                    }
                }
            }
            String name_show = T.getName_show();
            int i4 = this.f61381h <= 1 ? 14 : 13;
            if (k.byteLength(name_show) > i4) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, StringHelper.STRING_MORE);
            }
            c1631b.f61387d.setText(name_show);
            c1631b.f61386c.setText(this.f61379f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f61405a.q1().audience_count)));
            view2.setOnClickListener(new a(item));
            StatisticItem statisticItem = new StatisticItem("c12658");
            statisticItem.param("tid", item.f61405a.x1());
            d.a.k0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }
}
