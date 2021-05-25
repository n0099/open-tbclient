package d.a.n0.v.d.e.a;

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
import d.a.m0.r.q.a2;
import d.a.n0.v.d.e.b.b;
/* loaded from: classes4.dex */
public class b extends d.a.n0.v.d.e.a.a {

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.d.e.b.b f61670e;

        public a(d.a.n0.v.d.e.b.b bVar) {
            this.f61670e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c12659");
            statisticItem.param("tid", this.f61670e.f61693a.y1());
            TiebaStatic.log(statisticItem);
            b bVar = b.this;
            bVar.b(bVar.f61666e, this.f61670e.f61693a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_LIVING_TAB);
        }
    }

    /* renamed from: d.a.n0.v.d.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1651b {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61672a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61673b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61674c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61675d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61676e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61677f;

        public C1651b() {
        }

        public /* synthetic */ C1651b(a aVar) {
            this();
        }
    }

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        C1651b c1651b;
        a2 a2Var;
        if (view == null) {
            c1651b = new C1651b(null);
            view2 = LayoutInflater.from(this.f61667f).inflate(R.layout.square_recent_history_living_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_living_img);
            c1651b.f61672a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.ala_bitmap_default_color_bg);
            c1651b.f61673b = (TextView) view2.findViewById(R.id.recent_history_living_title);
            c1651b.f61674c = (TextView) view2.findViewById(R.id.recent_history_living_audience_count);
            c1651b.f61675d = (TextView) view2.findViewById(R.id.recent_history_living_user_name);
            c1651b.f61676e = (TextView) view2.findViewById(R.id.recent_history_living_living_tag);
            c1651b.f61677f = (TextView) view2.findViewById(R.id.recent_history_living_send_gift_tag);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(c1651b.f61673b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(c1651b.f61674c, R.color.CAM_X0109);
            SkinManager.setViewTextColor(c1651b.f61675d, R.color.CAM_X0107);
            SkinManager.setViewTextColor(c1651b.f61677f, R.color.CAM_X0301);
            view2.setTag(c1651b);
        } else {
            view2 = view;
            c1651b = (C1651b) view.getTag();
        }
        d.a.n0.v.d.e.b.b item = getItem(i2);
        if (item != null && (a2Var = item.f61693a) != null && a2Var.T() != null && item.f61693a.r1() != null) {
            MetaData T = item.f61693a.T();
            c1651b.f61672a.V(item.f61693a.r1().cover, 10, false);
            c1651b.f61673b.setText(item.f61693a.z1());
            this.f61669h = 0;
            c1651b.f61676e.setVisibility(8);
            c1651b.f61677f.setVisibility(8);
            if (!ListUtils.isEmpty(item.f61696d)) {
                for (b.a aVar : item.f61696d) {
                    if (aVar != null) {
                        int i3 = aVar.f61697a;
                        if (1 == i3) {
                            c1651b.f61676e.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f61698b)) {
                                c1651b.f61676e.setText(aVar.f61698b);
                            }
                            this.f61669h++;
                        } else if (2 == i3) {
                            c1651b.f61677f.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f61698b)) {
                                c1651b.f61677f.setText(aVar.f61698b);
                            }
                            this.f61669h++;
                        }
                    }
                }
            }
            String name_show = T.getName_show();
            int i4 = this.f61669h <= 1 ? 14 : 13;
            if (k.byteLength(name_show) > i4) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i4, StringHelper.STRING_MORE);
            }
            c1651b.f61675d.setText(name_show);
            c1651b.f61674c.setText(this.f61667f.getResources().getString(R.string.sqaure_recent_item_audience_count_tip, StringHelper.numberUniformFormatExtra(item.f61693a.r1().audience_count)));
            view2.setOnClickListener(new a(item));
            StatisticItem statisticItem = new StatisticItem("c12658");
            statisticItem.param("tid", item.f61693a.y1());
            d.a.n0.v.d.d.a.c().a(statisticItem);
        }
        return view2;
    }
}
