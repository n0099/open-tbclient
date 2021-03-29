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
    public InterfaceC1550c j;
    public Drawable k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.d.e.b.b f60495e;

        public a(d.b.i0.t.d.e.b.b bVar) {
            this.f60495e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.j != null) {
                c.this.j.a(this.f60495e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.t.d.e.b.b f60497e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f60498f;

        public b(d.b.i0.t.d.e.b.b bVar, MetaData metaData) {
            this.f60497e = bVar;
            this.f60498f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean g2 = c.this.g(this.f60497e.f60512d);
            StatisticItem statisticItem = new StatisticItem("c12661");
            statisticItem.param("obj_id", this.f60497e.f60509a.T().getUserId());
            statisticItem.param("obj_type", g2 ? 1 : 0);
            TiebaStatic.log(statisticItem);
            if (!c.this.g(this.f60497e.f60512d)) {
                c.this.h(this.f60498f);
                return;
            }
            c cVar = c.this;
            cVar.b(cVar.f60483e, this.f60497e.f60509a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
        }
    }

    /* renamed from: d.b.i0.t.d.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1550c {
        void a(d.b.i0.t.d.e.b.b bVar);
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f60500a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f60501b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60502c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60503d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f60504e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60505f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f60506g;

        public d(c cVar) {
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.i = d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f60484f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b.a aVar : list) {
            if (aVar != null && 1 == aVar.f60513a) {
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
            view2 = LayoutInflater.from(this.f60484f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
            dVar.f60500a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            dVar.f60500a.setIsRound(true);
            dVar.f60500a.setAutoChangeStyle(false);
            dVar.f60500a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            dVar.f60501b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
            dVar.f60502c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
            dVar.f60503d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
            dVar.f60504e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
            dVar.f60505f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
            dVar.f60506g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(dVar.f60501b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(dVar.f60504e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(dVar.f60505f, R.color.CAM_X0110);
            SkinManager.setViewTextColor(dVar.f60506g, R.color.square_follow_btn_txt_color);
            dVar.f60502c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(dVar.f60503d, R.color.CAM_X0301);
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        d.b.i0.t.d.e.b.b item = getItem(i);
        if (item != null && (a2Var = item.f60509a) != null && a2Var.T() != null) {
            com.baidu.tbadk.core.data.MetaData T = item.f60509a.T();
            int i2 = 12;
            dVar.f60500a.W(T.getPortrait(), 12, false);
            this.f60486h = 0;
            dVar.f60502c.setVisibility(8);
            dVar.f60503d.setVisibility(8);
            if (!ListUtils.isEmpty(item.f60512d)) {
                for (b.a aVar : item.f60512d) {
                    if (aVar != null) {
                        int i3 = aVar.f60513a;
                        if (1 == i3) {
                            dVar.f60502c.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60514b)) {
                                dVar.f60502c.setText(aVar.f60514b);
                            }
                            this.f60486h++;
                        } else if (2 == i3) {
                            dVar.f60503d.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f60514b)) {
                                dVar.f60503d.setText(aVar.f60514b);
                            }
                            this.f60486h++;
                        }
                    }
                }
            }
            boolean z = item.f60510b;
            String name_show = T.getName_show();
            if (this.f60486h <= 1) {
                i2 = 14;
            } else if (!z) {
                i2 = 10;
            }
            if (k.byteLength(name_show) > i2) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i2, StringHelper.STRING_MORE);
            }
            dVar.f60501b.setText(name_show);
            dVar.f60504e.setText(StringHelper.getFormatTimeShort(item.f60511c * 1000));
            j(z, dVar);
            dVar.f60506g.setOnClickListener(new a(item));
            view2.setOnClickListener(new b(item, T));
            StatisticItem statisticItem = new StatisticItem("c12660");
            statisticItem.param("obj_id", item.f60509a.T().getUserId());
            d.b.i0.t.d.d.a.c().a(statisticItem);
        }
        return view2;
    }

    public final void h(MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f60484f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.i).equals(metaData.getUserId()), metaData.isBigV())));
    }

    public void i(InterfaceC1550c interfaceC1550c) {
        this.j = interfaceC1550c;
    }

    public final void j(boolean z, d dVar) {
        if (z) {
            dVar.f60506g.setVisibility(8);
            dVar.f60505f.setVisibility(0);
            dVar.f60505f.setEnabled(false);
            return;
        }
        dVar.f60505f.setVisibility(8);
        dVar.f60506g.setVisibility(0);
    }
}
