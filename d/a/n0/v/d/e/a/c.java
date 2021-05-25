package d.a.n0.v.d.e.a;

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
import d.a.m0.r.q.a2;
import d.a.n0.v.d.e.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d.a.n0.v.d.e.a.a {

    /* renamed from: i  reason: collision with root package name */
    public long f61678i;
    public InterfaceC1652c j;
    public Drawable k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.d.e.b.b f61679e;

        public a(d.a.n0.v.d.e.b.b bVar) {
            this.f61679e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.j != null) {
                c.this.j.a(this.f61679e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.v.d.e.b.b f61681e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f61682f;

        public b(d.a.n0.v.d.e.b.b bVar, MetaData metaData) {
            this.f61681e = bVar;
            this.f61682f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean g2 = c.this.g(this.f61681e.f61696d);
            StatisticItem statisticItem = new StatisticItem("c12661");
            statisticItem.param("obj_id", this.f61681e.f61693a.T().getUserId());
            statisticItem.param("obj_type", g2 ? 1 : 0);
            TiebaStatic.log(statisticItem);
            if (!c.this.g(this.f61681e.f61696d)) {
                c.this.h(this.f61682f);
                return;
            }
            c cVar = c.this;
            cVar.b(cVar.f61666e, this.f61681e.f61693a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
        }
    }

    /* renamed from: d.a.n0.v.d.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1652c {
        void a(d.a.n0.v.d.e.b.b bVar);
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f61684a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f61685b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f61686c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f61687d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f61688e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f61689f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f61690g;

        public d(c cVar) {
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f61678i = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f61667f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b.a aVar : list) {
            if (aVar != null && 1 == aVar.f61697a) {
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
            view2 = LayoutInflater.from(this.f61667f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
            dVar.f61684a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            dVar.f61684a.setIsRound(true);
            dVar.f61684a.setAutoChangeStyle(false);
            dVar.f61684a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            dVar.f61685b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
            dVar.f61686c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
            dVar.f61687d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
            dVar.f61688e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
            dVar.f61689f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
            dVar.f61690g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(dVar.f61685b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(dVar.f61688e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(dVar.f61689f, R.color.CAM_X0110);
            SkinManager.setViewTextColor(dVar.f61690g, R.color.square_follow_btn_txt_color);
            dVar.f61686c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(dVar.f61687d, R.color.CAM_X0301);
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        d.a.n0.v.d.e.b.b item = getItem(i2);
        if (item != null && (a2Var = item.f61693a) != null && a2Var.T() != null) {
            com.baidu.tbadk.core.data.MetaData T = item.f61693a.T();
            int i3 = 12;
            dVar.f61684a.V(T.getPortrait(), 12, false);
            this.f61669h = 0;
            dVar.f61686c.setVisibility(8);
            dVar.f61687d.setVisibility(8);
            if (!ListUtils.isEmpty(item.f61696d)) {
                for (b.a aVar : item.f61696d) {
                    if (aVar != null) {
                        int i4 = aVar.f61697a;
                        if (1 == i4) {
                            dVar.f61686c.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f61698b)) {
                                dVar.f61686c.setText(aVar.f61698b);
                            }
                            this.f61669h++;
                        } else if (2 == i4) {
                            dVar.f61687d.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f61698b)) {
                                dVar.f61687d.setText(aVar.f61698b);
                            }
                            this.f61669h++;
                        }
                    }
                }
            }
            boolean z = item.f61694b;
            String name_show = T.getName_show();
            if (this.f61669h <= 1) {
                i3 = 14;
            } else if (!z) {
                i3 = 10;
            }
            if (k.byteLength(name_show) > i3) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
            }
            dVar.f61685b.setText(name_show);
            dVar.f61688e.setText(StringHelper.getFormatTimeShort(item.f61695c * 1000));
            j(z, dVar);
            dVar.f61690g.setOnClickListener(new a(item));
            view2.setOnClickListener(new b(item, T));
            StatisticItem statisticItem = new StatisticItem("c12660");
            statisticItem.param("obj_id", item.f61693a.T().getUserId());
            d.a.n0.v.d.d.a.c().a(statisticItem);
        }
        return view2;
    }

    public final void h(MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f61667f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f61678i).equals(metaData.getUserId()), metaData.isBigV())));
    }

    public void i(InterfaceC1652c interfaceC1652c) {
        this.j = interfaceC1652c;
    }

    public final void j(boolean z, d dVar) {
        if (z) {
            dVar.f61690g.setVisibility(8);
            dVar.f61689f.setVisibility(0);
            dVar.f61689f.setEnabled(false);
            return;
        }
        dVar.f61689f.setVisibility(8);
        dVar.f61690g.setVisibility(0);
    }
}
