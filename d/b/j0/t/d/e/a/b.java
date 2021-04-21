package d.b.j0.t.d.e.a;

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
import d.b.i0.r.q.a2;
import d.b.j0.t.d.e.b.b;
/* loaded from: classes4.dex */
public class b extends d.b.j0.t.d.e.a.a {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.t.d.e.b.b f62472e;

        public a(d.b.j0.t.d.e.b.b bVar) {
            this.f62472e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c12659");
            statisticItem.param("tid", this.f62472e.f62494a.w1());
            TiebaStatic.log(statisticItem);
            b bVar = b.this;
            bVar.b(bVar.f62468e, this.f62472e.f62494a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
        }
    }

    /* renamed from: d.b.j0.t.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1625b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62474a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62475b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62476c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62477d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62478e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f62479f;

        public C1625b() {
        }

        public /* synthetic */ C1625b(a aVar) {
            this();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C1625b c1625b;
        a2 a2Var;
        if (view == null) {
            c1625b = new C1625b(null);
            view2 = LayoutInflater.from(this.f62469f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
            c1625b.f62474a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            c1625b.f62475b = (TextView) view2.findViewById(R.id.recent_history_living_title);
            c1625b.f62476c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
            c1625b.f62477d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
            c1625b.f62478e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
            c1625b.f62479f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(c1625b.f62475b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(c1625b.f62476c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(c1625b.f62477d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(c1625b.f62479f, R.color.CAM_X0301);
            view2.setTag(c1625b);
        } else {
            view2 = view;
            c1625b = (C1625b) view.getTag();
        }
        d.b.j0.t.d.e.b.b item = getItem(i);
        if (item != null && (a2Var = item.f62494a) != null && a2Var.T() != null && item.f62494a.q1() != null) {
            MetaData T = item.f62494a.T();
            c1625b.f62474a.W(item.f62494a.q1().cover, 10, false);
            c1625b.f62475b.setText(item.f62494a.x1());
            this.f62471h = 0;
            c1625b.f62478e.setVisibility(8);
            c1625b.f62479f.setVisibility(8);
            if (!ListUtils.isEmpty(item.f62497d)) {
                for (b.a aVar : item.f62497d) {
                    if (aVar != null) {
                        int i2 = aVar.f62498a;
                        if (1 == i2) {
                            c1625b.f62478e.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f62499b)) {
                                c1625b.f62478e.setText(aVar.f62499b);
                            }
                            this.f62471h++;
                        } else if (2 == i2) {
                            c1625b.f62479f.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f62499b)) {
                                c1625b.f62479f.setText(aVar.f62499b);
                            }
                            this.f62471h++;
                        }
                    }
                }
            }
            String name_show = T.getName_show();
            int i3 = this.f62471h <= 1 ? 14 : 13;
            if (k.byteLength(name_show) > i3) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
            }
            c1625b.f62477d.setText(name_show);
            c1625b.f62476c.setText(this.f62469f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f62494a.q1().audience_count)));
            view2.setOnClickListener(new a(item));
            StatisticItem statisticItem = new StatisticItem("c12658");
            statisticItem.param("tid", item.f62494a.w1());
            d.b.j0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }
}
