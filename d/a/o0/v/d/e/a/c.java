package d.a.o0.v.d.e.a;

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
import d.a.n0.r.q.a2;
import d.a.o0.v.d.e.b.b;
import java.util.List;
/* loaded from: classes4.dex */
public class c extends d.a.o0.v.d.e.a.a {

    /* renamed from: i  reason: collision with root package name */
    public long f65517i;
    public InterfaceC1713c j;
    public Drawable k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.v.d.e.b.b f65518e;

        public a(d.a.o0.v.d.e.b.b bVar) {
            this.f65518e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.j != null) {
                c.this.j.a(this.f65518e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.v.d.e.b.b f65520e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ MetaData f65521f;

        public b(d.a.o0.v.d.e.b.b bVar, MetaData metaData) {
            this.f65520e = bVar;
            this.f65521f = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean g2 = c.this.g(this.f65520e.f65535d);
            StatisticItem statisticItem = new StatisticItem("c12661");
            statisticItem.param("obj_id", this.f65520e.f65532a.T().getUserId());
            statisticItem.param("obj_type", g2 ? 1 : 0);
            TiebaStatic.log(statisticItem);
            if (!c.this.g(this.f65520e.f65535d)) {
                c.this.h(this.f65521f);
                return;
            }
            c cVar = c.this;
            cVar.b(cVar.f65505e, this.f65520e.f65532a, AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_RECENT_HISTORY_WHOLE_TAB);
        }
    }

    /* renamed from: d.a.o0.v.d.e.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1713c {
        void a(d.a.o0.v.d.e.b.b bVar);
    }

    /* loaded from: classes4.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f65523a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f65524b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65525c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65526d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f65527e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f65528f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65529g;

        public d(c cVar) {
        }

        public /* synthetic */ d(c cVar, a aVar) {
            this(cVar);
        }
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.f65517i = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.k = SkinManager.getDrawable(this.f65506f.getResources(), R.drawable.icon_video_direct_seeding);
    }

    public final boolean g(List<b.a> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (b.a aVar : list) {
            if (aVar != null && 1 == aVar.f65536a) {
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
            view2 = LayoutInflater.from(this.f65506f).inflate(R.layout.square_recent_history_whole_item, (ViewGroup) null);
            TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.recent_history_whole_img);
            dVar.f65523a = tbImageView;
            tbImageView.setDefaultResource(R.drawable.icon_default_avatar100_bg);
            dVar.f65523a.setIsRound(true);
            dVar.f65523a.setAutoChangeStyle(false);
            dVar.f65523a.setScaleType(ImageView.ScaleType.CENTER_CROP);
            dVar.f65524b = (TextView) view2.findViewById(R.id.recent_history_whole_user_name);
            dVar.f65525c = (TextView) view2.findViewById(R.id.recent_history_whole_living_tag);
            dVar.f65526d = (TextView) view2.findViewById(R.id.recent_history_whole_send_gift_tag);
            dVar.f65527e = (TextView) view2.findViewById(R.id.recent_history_whole_live_begin_time);
            dVar.f65528f = (TextView) view2.findViewById(R.id.recent_history_whole_follow_btn);
            dVar.f65529g = (TextView) view2.findViewById(R.id.recent_history_whole_unfollow_btn);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            SkinManager.setViewTextColor(dVar.f65524b, R.color.CAM_X0105);
            SkinManager.setViewTextColor(dVar.f65527e, R.color.CAM_X0109);
            SkinManager.setViewTextColor(dVar.f65528f, R.color.CAM_X0110);
            SkinManager.setViewTextColor(dVar.f65529g, R.color.square_follow_btn_txt_color);
            dVar.f65525c.setCompoundDrawablesWithIntrinsicBounds(this.k, (Drawable) null, (Drawable) null, (Drawable) null);
            SkinManager.setViewTextColor(dVar.f65526d, R.color.CAM_X0301);
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        d.a.o0.v.d.e.b.b item = getItem(i2);
        if (item != null && (a2Var = item.f65532a) != null && a2Var.T() != null) {
            com.baidu.tbadk.core.data.MetaData T = item.f65532a.T();
            int i3 = 12;
            dVar.f65523a.U(T.getPortrait(), 12, false);
            this.f65508h = 0;
            dVar.f65525c.setVisibility(8);
            dVar.f65526d.setVisibility(8);
            if (!ListUtils.isEmpty(item.f65535d)) {
                for (b.a aVar : item.f65535d) {
                    if (aVar != null) {
                        int i4 = aVar.f65536a;
                        if (1 == i4) {
                            dVar.f65525c.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f65537b)) {
                                dVar.f65525c.setText(aVar.f65537b);
                            }
                            this.f65508h++;
                        } else if (2 == i4) {
                            dVar.f65526d.setVisibility(0);
                            if (!TextUtils.isEmpty(aVar.f65537b)) {
                                dVar.f65526d.setText(aVar.f65537b);
                            }
                            this.f65508h++;
                        }
                    }
                }
            }
            boolean z = item.f65533b;
            String name_show = T.getName_show();
            if (this.f65508h <= 1) {
                i3 = 14;
            } else if (!z) {
                i3 = 10;
            }
            if (k.byteLength(name_show) > i3) {
                name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, i3, StringHelper.STRING_MORE);
            }
            dVar.f65524b.setText(name_show);
            dVar.f65527e.setText(StringHelper.getFormatTimeShort(item.f65534c * 1000));
            j(z, dVar);
            dVar.f65529g.setOnClickListener(new a(item));
            view2.setOnClickListener(new b(item, T));
            StatisticItem statisticItem = new StatisticItem("c12660");
            statisticItem.param("obj_id", item.f65532a.T().getUserId());
            d.a.o0.v.d.d.a.c().a(statisticItem);
        }
        return view2;
    }

    public final void h(MetaData metaData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f65506f).createNormalConfig(Long.valueOf(metaData.getUserId()).longValue(), String.valueOf(this.f65517i).equals(metaData.getUserId()), metaData.isBigV())));
    }

    public void i(InterfaceC1713c interfaceC1713c) {
        this.j = interfaceC1713c;
    }

    public final void j(boolean z, d dVar) {
        if (z) {
            dVar.f65529g.setVisibility(8);
            dVar.f65528f.setVisibility(0);
            dVar.f65528f.setEnabled(false);
            return;
        }
        dVar.f65528f.setVisibility(8);
        dVar.f65529g.setVisibility(0);
    }
}
