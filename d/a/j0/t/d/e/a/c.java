package d.a.j0.t.d.e.a;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.i0.r.q.a2;
import d.a.j0.t.d.e.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d.a.j0.t.d.e.a.a {

    /* renamed from: i  reason: collision with root package name */
    public long f60666i;
    public InterfaceC1567c j;
    public Drawable k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.d.e.b.b f60667e;

        public a(d.a.j0.t.d.e.b.b bVar) {
            this.f60667e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.j != null) {
                c.this.j.a(this.f60667e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.t.d.e.b.b f60669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f60670f;

        public b(d.a.j0.t.d.e.b.b bVar, MetaData metaData) {
            this.f60669e = bVar;
            this.f60670f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean g2 = c.this.g(this.f60669e.f60684d);
            StatisticItem statisticItem = new StatisticItem("c12661");
            statisticItem.param("obj_id", this.f60669e.f60681a.T().getUserId());
            statisticItem.param("obj_type", g2 ? 1 : 0);
            TiebaStatic.log(statisticItem);
            if (!c.this.g(this.f60669e.f60684d)) {
                c.this.h(this.f60670f);
                return;
            }
            c cVar = c.this;
            cVar.b(cVar.f60654e, this.f60669e.f60681a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
        }
    }

    /* renamed from: d.a.j0.t.d.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1567c {
        void a(d.a.j0.t.d.e.b.b bVar);
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60672a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60673b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60674c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60675d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60676e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60677f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60678g;

        public d(c cVar) {
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f60666i = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f60655f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b.a aVar : list) {
            if (aVar != null && 1 == aVar.f60685a) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        d dVar;
        a2 a2Var;
        if (view == null) {
            dVar = new d(this, null);
            view2 = LayoutInflater.from(this.f60655f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
            dVar.f60672a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            dVar.f60672a.setIsRound(true);
            dVar.f60672a.setAutoChangeStyle(false);
            dVar.f60672a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            dVar.f60673b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
            dVar.f60674c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
            dVar.f60675d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
            dVar.f60676e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
            dVar.f60677f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
            dVar.f60678g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(dVar.f60673b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(dVar.f60676e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(dVar.f60677f, R.color.CAM_X0110);
            SkinManager.setViewTextColor(dVar.f60678g, R.color.square_follow_btn_txt_color);
            dVar.f60674c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(dVar.f60675d, R.color.CAM_X0301);
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        d.a.j0.t.d.e.b.b item = getItem(i2);
        if (item != null && (a2Var = item.f60681a) != null && a2Var.T() != null) {
            com.baidu.tbadk.core.data.MetaData T = item.f60681a.T();
            int i3 = 12;
            dVar.f60672a.V(T.getPortrait(), 12, false);
            this.f60657h = 0;
            dVar.f60674c.setVisibility(8);
            dVar.f60675d.setVisibility(8);
            if (!ListUtils.isEmpty(item.f60684d)) {
                for (b.a aVar : item.f60684d) {
                    if (aVar != null) {
                        int i4 = aVar.f60685a;
                        if (1 == i4) {
                            dVar.f60674c.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60686b)) {
                                dVar.f60674c.setText(aVar.f60686b);
                            }
                            this.f60657h++;
                        } else if (2 == i4) {
                            dVar.f60675d.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60686b)) {
                                dVar.f60675d.setText(aVar.f60686b);
                            }
                            this.f60657h++;
                        }
                    }
                }
            }
            boolean z = item.f60682b;
            String name_show = T.getName_show();
            if (this.f60657h <= 1) {
                i3 = 14;
            } else if (!z) {
                i3 = 10;
            }
            if (k.byteLength(name_show) > i3) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
            }
            dVar.f60673b.setText(name_show);
            dVar.f60676e.setText(StringHelper.getFormatTimeShort(item.f60683c * 1000));
            j(z, dVar);
            dVar.f60678g.setOnClickListener(new a(item));
            view2.setOnClickListener(new b(item, T));
            StatisticItem statisticItem = new StatisticItem("c12660");
            statisticItem.param("obj_id", item.f60681a.T().getUserId());
            d.a.j0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }

    public final void h(MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f60655f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f60666i).equals(metaData.getUserId()), metaData.isBigV())));
    }

    public void i(InterfaceC1567c interfaceC1567c) {
        this.j = interfaceC1567c;
    }

    public final void j(boolean z, d dVar) {
        if (z) {
            dVar.f60678g.setVisibility(8);
            dVar.f60677f.setVisibility(0);
            dVar.f60677f.setEnabled(false);
            return;
        }
        dVar.f60677f.setVisibility(8);
        dVar.f60678g.setVisibility(0);
    }
}
