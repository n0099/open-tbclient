package d.b.i0.t.d.e.a;

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
import d.b.b.e.p.k;
import d.b.h0.r.q.a2;
import d.b.i0.t.d.e.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d.b.i0.t.d.e.a.a {
    public long i;
    public InterfaceC1549c j;
    public Drawable k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.d.e.b.b f60494e;

        public a(d.b.i0.t.d.e.b.b bVar) {
            this.f60494e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.j != null) {
                c.this.j.a(this.f60494e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.d.e.b.b f60496e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f60497f;

        public b(d.b.i0.t.d.e.b.b bVar, MetaData metaData) {
            this.f60496e = bVar;
            this.f60497f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean g2 = c.this.g(this.f60496e.f60511d);
            StatisticItem statisticItem = new StatisticItem("c12661");
            statisticItem.param("obj_id", this.f60496e.f60508a.T().getUserId());
            statisticItem.param("obj_type", g2 ? 1 : 0);
            TiebaStatic.log(statisticItem);
            if (!c.this.g(this.f60496e.f60511d)) {
                c.this.h(this.f60497f);
                return;
            }
            c cVar = c.this;
            cVar.b(cVar.f60482e, this.f60496e.f60508a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
        }
    }

    /* renamed from: d.b.i0.t.d.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1549c {
        void a(d.b.i0.t.d.e.b.b bVar);
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60499a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60500b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60501c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60502d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60503e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60504f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60505g;

        public d(c cVar) {
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.i = d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f60483f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b.a aVar : list) {
            if (aVar != null && 1 == aVar.f60512a) {
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
            view2 = LayoutInflater.from(this.f60483f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
            dVar.f60499a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            dVar.f60499a.setIsRound(true);
            dVar.f60499a.setAutoChangeStyle(false);
            dVar.f60499a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            dVar.f60500b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
            dVar.f60501c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
            dVar.f60502d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
            dVar.f60503e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
            dVar.f60504f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
            dVar.f60505g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(dVar.f60500b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(dVar.f60503e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(dVar.f60504f, R.color.CAM_X0110);
            SkinManager.setViewTextColor(dVar.f60505g, R.color.square_follow_btn_txt_color);
            dVar.f60501c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(dVar.f60502d, R.color.CAM_X0301);
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        d.b.i0.t.d.e.b.b item = getItem(i);
        if (item != null && (a2Var = item.f60508a) != null && a2Var.T() != null) {
            com.baidu.tbadk.core.data.MetaData T = item.f60508a.T();
            int i2 = 12;
            dVar.f60499a.W(T.getPortrait(), 12, false);
            this.f60485h = 0;
            dVar.f60501c.setVisibility(8);
            dVar.f60502d.setVisibility(8);
            if (!ListUtils.isEmpty(item.f60511d)) {
                for (b.a aVar : item.f60511d) {
                    if (aVar != null) {
                        int i3 = aVar.f60512a;
                        if (1 == i3) {
                            dVar.f60501c.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60513b)) {
                                dVar.f60501c.setText(aVar.f60513b);
                            }
                            this.f60485h++;
                        } else if (2 == i3) {
                            dVar.f60502d.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60513b)) {
                                dVar.f60502d.setText(aVar.f60513b);
                            }
                            this.f60485h++;
                        }
                    }
                }
            }
            boolean z = item.f60509b;
            String name_show = T.getName_show();
            if (this.f60485h <= 1) {
                i2 = 14;
            } else if (!z) {
                i2 = 10;
            }
            if (k.byteLength(name_show) > i2) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE);
            }
            dVar.f60500b.setText(name_show);
            dVar.f60503e.setText(StringHelper.getFormatTimeShort(item.f60510c * 1000));
            j(z, dVar);
            dVar.f60505g.setOnClickListener(new a(item));
            view2.setOnClickListener(new b(item, T));
            StatisticItem statisticItem = new StatisticItem("c12660");
            statisticItem.param("obj_id", item.f60508a.T().getUserId());
            d.b.i0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }

    public final void h(MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f60483f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.i).equals(metaData.getUserId()), metaData.isBigV())));
    }

    public void i(InterfaceC1549c interfaceC1549c) {
        this.j = interfaceC1549c;
    }

    public final void j(boolean z, d dVar) {
        if (z) {
            dVar.f60505g.setVisibility(8);
            dVar.f60504f.setVisibility(0);
            dVar.f60504f.setEnabled(false);
            return;
        }
        dVar.f60504f.setVisibility(8);
        dVar.f60505g.setVisibility(0);
    }
}
