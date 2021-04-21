package d.b.j0.t.d.e.a;

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
import d.b.c.e.p.k;
import d.b.i0.r.q.a2;
import d.b.j0.t.d.e.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d.b.j0.t.d.e.a.a {
    public long i;
    public InterfaceC1626c j;
    public Drawable k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.t.d.e.b.b f62480e;

        public a(d.b.j0.t.d.e.b.b bVar) {
            this.f62480e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.j != null) {
                c.this.j.a(this.f62480e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.j0.t.d.e.b.b f62482e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f62483f;

        public b(d.b.j0.t.d.e.b.b bVar, MetaData metaData) {
            this.f62482e = bVar;
            this.f62483f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean g2 = c.this.g(this.f62482e.f62497d);
            StatisticItem statisticItem = new StatisticItem("c12661");
            statisticItem.param("obj_id", this.f62482e.f62494a.T().getUserId());
            statisticItem.param("obj_type", g2 ? 1 : 0);
            TiebaStatic.log(statisticItem);
            if (!c.this.g(this.f62482e.f62497d)) {
                c.this.h(this.f62483f);
                return;
            }
            c cVar = c.this;
            cVar.b(cVar.f62468e, this.f62482e.f62494a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
        }
    }

    /* renamed from: d.b.j0.t.d.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1626c {
        void a(d.b.j0.t.d.e.b.b bVar);
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f62485a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f62486b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f62487c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f62488d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f62489e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f62490f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f62491g;

        public d(c cVar) {
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.i = d.b.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f62469f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b.a aVar : list) {
            if (aVar != null && 1 == aVar.f62498a) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        d dVar;
        a2 a2Var;
        if (view == null) {
            dVar = new d(this, null);
            view2 = LayoutInflater.from(this.f62469f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
            dVar.f62485a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            dVar.f62485a.setIsRound(true);
            dVar.f62485a.setAutoChangeStyle(false);
            dVar.f62485a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            dVar.f62486b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
            dVar.f62487c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
            dVar.f62488d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
            dVar.f62489e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
            dVar.f62490f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
            dVar.f62491g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(dVar.f62486b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(dVar.f62489e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(dVar.f62490f, R.color.CAM_X0110);
            SkinManager.setViewTextColor(dVar.f62491g, R.color.square_follow_btn_txt_color);
            dVar.f62487c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(dVar.f62488d, R.color.CAM_X0301);
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        d.b.j0.t.d.e.b.b item = getItem(i);
        if (item != null && (a2Var = item.f62494a) != null && a2Var.T() != null) {
            com.baidu.tbadk.core.data.MetaData T = item.f62494a.T();
            int i2 = 12;
            dVar.f62485a.W(T.getPortrait(), 12, false);
            this.f62471h = 0;
            dVar.f62487c.setVisibility(8);
            dVar.f62488d.setVisibility(8);
            if (!ListUtils.isEmpty(item.f62497d)) {
                for (b.a aVar : item.f62497d) {
                    if (aVar != null) {
                        int i3 = aVar.f62498a;
                        if (1 == i3) {
                            dVar.f62487c.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f62499b)) {
                                dVar.f62487c.setText(aVar.f62499b);
                            }
                            this.f62471h++;
                        } else if (2 == i3) {
                            dVar.f62488d.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f62499b)) {
                                dVar.f62488d.setText(aVar.f62499b);
                            }
                            this.f62471h++;
                        }
                    }
                }
            }
            boolean z = item.f62495b;
            String name_show = T.getName_show();
            if (this.f62471h <= 1) {
                i2 = 14;
            } else if (!z) {
                i2 = 10;
            }
            if (k.byteLength(name_show) > i2) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE);
            }
            dVar.f62486b.setText(name_show);
            dVar.f62489e.setText(StringHelper.getFormatTimeShort(item.f62496c * 1000));
            j(z, dVar);
            dVar.f62491g.setOnClickListener(new a(item));
            view2.setOnClickListener(new b(item, T));
            StatisticItem statisticItem = new StatisticItem("c12660");
            statisticItem.param("obj_id", item.f62494a.T().getUserId());
            d.b.j0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }

    public final void h(MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f62469f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.i).equals(metaData.getUserId()), metaData.isBigV())));
    }

    public void i(InterfaceC1626c interfaceC1626c) {
        this.j = interfaceC1626c;
    }

    public final void j(boolean z, d dVar) {
        if (z) {
            dVar.f62491g.setVisibility(8);
            dVar.f62490f.setVisibility(0);
            dVar.f62490f.setEnabled(false);
            return;
        }
        dVar.f62490f.setVisibility(8);
        dVar.f62491g.setVisibility(0);
    }
}
