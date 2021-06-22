package d.a.o0.v.d.e.a;

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
import d.a.n0.r.q.a2;
import d.a.o0.v.d.e.b.b;
/* loaded from: classes4.dex */
public class b extends d.a.o0.v.d.e.a.a {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.v.d.e.b.b f65509e;

        public a(d.a.o0.v.d.e.b.b bVar) {
            this.f65509e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c12659");
            statisticItem.param("tid", this.f65509e.f65532a.z1());
            TiebaStatic.log(statisticItem);
            b bVar = b.this;
            bVar.b(bVar.f65505e, this.f65509e.f65532a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
        }
    }

    /* renamed from: d.a.o0.v.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1712b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f65511a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65512b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65513c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65514d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65515e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f65516f;

        public C1712b() {
        }

        public /* synthetic */ C1712b(a aVar) {
            this();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1712b c1712b;
        a2 a2Var;
        if (view == null) {
            c1712b = new C1712b(null);
            view2 = LayoutInflater.from(this.f65506f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
            c1712b.f65511a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            c1712b.f65512b = (TextView) view2.findViewById(R.id.recent_history_living_title);
            c1712b.f65513c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
            c1712b.f65514d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
            c1712b.f65515e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
            c1712b.f65516f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(c1712b.f65512b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(c1712b.f65513c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(c1712b.f65514d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(c1712b.f65516f, R.color.CAM_X0301);
            view2.setTag(c1712b);
        } else {
            view2 = view;
            c1712b = (C1712b) view.getTag();
        }
        d.a.o0.v.d.e.b.b item = getItem(i2);
        if (item != null && (a2Var = item.f65532a) != null && a2Var.T() != null && item.f65532a.s1() != null) {
            MetaData T = item.f65532a.T();
            c1712b.f65511a.U(item.f65532a.s1().cover, 10, false);
            c1712b.f65512b.setText(item.f65532a.A1());
            this.f65508h = 0;
            c1712b.f65515e.setVisibility(8);
            c1712b.f65516f.setVisibility(8);
            if (!ListUtils.isEmpty(item.f65535d)) {
                for (b.a aVar : item.f65535d) {
                    if (aVar != null) {
                        int i3 = aVar.f65536a;
                        if (1 == i3) {
                            c1712b.f65515e.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f65537b)) {
                                c1712b.f65515e.setText(aVar.f65537b);
                            }
                            this.f65508h++;
                        } else if (2 == i3) {
                            c1712b.f65516f.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f65537b)) {
                                c1712b.f65516f.setText(aVar.f65537b);
                            }
                            this.f65508h++;
                        }
                    }
                }
            }
            String name_show = T.getName_show();
            int i4 = this.f65508h <= 1 ? 14 : 13;
            if (k.byteLength(name_show) > i4) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, StringHelper.STRING_MORE);
            }
            c1712b.f65514d.setText(name_show);
            c1712b.f65513c.setText(this.f65506f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f65532a.s1().audience_count)));
            view2.setOnClickListener(new a(item));
            StatisticItem statisticItem = new StatisticItem("c12658");
            statisticItem.param("tid", item.f65532a.z1());
            d.a.o0.v.d.d.a.c().a(statisticItem);
        }
        return view2;
    }
}
