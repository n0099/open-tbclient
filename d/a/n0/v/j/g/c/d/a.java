package d.a.n0.v.j.g.c.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.ala.data.AlaLiveMarkData;
import com.baidu.ala.data.AlaUserInfoData;
import com.baidu.ala.view.AlaNetRefreshView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.l.d;
import d.a.n0.v.j.g.c.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public View f62134a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<BaseFragmentActivity> f62135b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f62136c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.v.j.g.c.b f62137d;

    /* renamed from: e  reason: collision with root package name */
    public HeadImageView f62138e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62139f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62140g;

    /* renamed from: h  reason: collision with root package name */
    public TbImageView f62141h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f62142i;
    public ImageView j;
    public TextView k;
    public LinearLayout l;
    public AlaNetRefreshView m;
    public RelativeLayout n;
    public TextView o;
    public View p;
    public c q;
    public List<AlaLiveMarkData> r = new ArrayList();
    public b.d s = new b();

    /* renamed from: d.a.n0.v.j.g.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1674a extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public C1674a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((C1674a) aVar, str, i2);
            if (aVar == null || aVar.p() == null) {
                return;
            }
            a.this.f62141h.setScaleType(ImageView.ScaleType.CENTER_CROP);
            a.this.f62141h.setImageBitmap(BitmapHelper.fastblur(aVar.p(), 15, 0.75f));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.d {
        public b() {
        }

        @Override // d.a.n0.v.j.g.c.b.d
        public void a(d.a.n0.v.j.g.c.c.b bVar) {
            if (a.this.q != null) {
                a.this.q.a(bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(d.a.n0.v.j.g.c.c.b bVar);
    }

    public a(TbPageContext<BaseFragmentActivity> tbPageContext, c cVar) {
        this.f62135b = tbPageContext;
        this.q = cVar;
        e();
    }

    public View c() {
        return this.f62134a;
    }

    public void d() {
        AlaNetRefreshView alaNetRefreshView = this.m;
        if (alaNetRefreshView != null) {
            alaNetRefreshView.dettachView(this.n);
        }
    }

    public final void e() {
        View inflate = LayoutInflater.from(this.f62135b.getPageActivity()).inflate(R.layout.ala_achievement_mark_fragment_layout, (ViewGroup) null);
        this.f62134a = inflate;
        inflate.setPadding(0, (int) this.f62135b.getResources().getDimension(R.dimen.ds80), 0, 0);
        this.f62138e = (HeadImageView) this.f62134a.findViewById(R.id.ala_person_center_privilege_header_iv);
        this.f62139f = (TextView) this.f62134a.findViewById(R.id.ala_person_center_privilege_header_name_tv);
        this.f62140g = (TextView) this.f62134a.findViewById(R.id.ala_person_center_privilege_header_desc_tv);
        this.f62141h = (TbImageView) this.f62134a.findViewById(R.id.ala_person_center_privilege_header_container_bg);
        this.n = (RelativeLayout) this.f62134a.findViewById(R.id.ala_person_center_privilege_mark_list_container);
        this.l = (LinearLayout) this.f62134a.findViewById(R.id.ala_person_center_privilege_header_has_wears);
        this.o = (TextView) this.f62134a.findViewById(R.id.ala_person_center_privilege_jump_rule_text);
        this.j = (ImageView) this.f62134a.findViewById(R.id.empty_image);
        this.k = (TextView) this.f62134a.findViewById(R.id.empty_text);
        this.p = this.f62134a.findViewById(R.id.ala_person_center_privilege_mask);
        this.f62136c = (BdListView) this.f62134a.findViewById(R.id.ala_person_center_privilege_mark_list);
        d.a.n0.v.j.g.c.b bVar = new d.a.n0.v.j.g.c.b(this.f62135b, this.s);
        this.f62137d = bVar;
        this.f62136c.setAdapter((ListAdapter) bVar);
        RelativeLayout relativeLayout = (RelativeLayout) this.f62134a.findViewById(R.id.emptyview);
        this.f62142i = relativeLayout;
        this.f62136c.setEmptyView(relativeLayout);
        this.f62138e.setIsRound(true);
        this.f62138e.setDefaultBgResource(R.color.transparent);
        this.f62138e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f62141h.setDefaultBgResource(R.color.transparent);
        this.f62141h.setScaleType(ImageView.ScaleType.CENTER_CROP);
        f();
    }

    public final void f() {
        SkinManager.setBackgroundColor(this.f62134a, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f62139f, R.color.common_color_10310);
        SkinManager.setViewTextColor(this.f62140g, R.color.white_alpha70);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
        if (TbadkApplication.getInst().getSkinType() == 1) {
            this.j.setAlpha(0.4f);
            this.p.setBackgroundColor(this.f62135b.getResources().getColor(R.color.black_alpha60));
            return;
        }
        this.j.setAlpha(1.0f);
        this.p.setBackgroundColor(this.f62135b.getResources().getColor(R.color.black_alpha30));
    }

    public void g(AlaUserInfoData alaUserInfoData, List<d.a.n0.v.j.g.c.c.c> list) {
        d.a.n0.v.j.g.c.b bVar = this.f62137d;
        if (bVar != null && list != null) {
            bVar.d(list);
        }
        i(alaUserInfoData);
    }

    public void h(int i2, int i3, boolean z, View.OnClickListener onClickListener) {
        TbPageContext<BaseFragmentActivity> tbPageContext = this.f62135b;
        if (tbPageContext == null) {
            return;
        }
        if (this.m == null) {
            this.m = new AlaNetRefreshView(tbPageContext.getPageActivity());
        }
        this.m.setImageResource(i2);
        this.m.setNetFailTipText(this.f62135b.getString(i3));
        this.m.onChangeSkinType();
        this.m.setIsShowRefreshButton(z);
        if (z) {
            this.m.setOnRefreshClickListener(onClickListener);
        }
        this.m.attachView(this.n);
    }

    public final void i(AlaUserInfoData alaUserInfoData) {
        String format;
        if (alaUserInfoData != null) {
            String str = alaUserInfoData.user_nickname;
            String str2 = alaUserInfoData.user_name;
            if (str == null) {
                str = str2 != null ? str2 : TbadkCoreApplication.getCurrentAccountNameShow();
            }
            String str3 = alaUserInfoData.portrait;
            if (str3 == null) {
                str3 = TbadkCoreApplication.getCurrentPortrait();
            }
            if (alaUserInfoData.mark_count == null) {
                format = String.format(this.f62135b.getString(R.string.ala_achievement_mark_get_text), 0);
            } else {
                format = String.format(this.f62135b.getString(R.string.ala_achievement_mark_get_text), Long.valueOf(alaUserInfoData.mark_count.user_mark_count));
            }
            j(str3, str, format);
            int dimension = (int) this.f62135b.getResources().getDimension(R.dimen.ds32);
            List<AlaLiveMarkData> list = this.r;
            if (list != null && list.size() > 0) {
                this.r.clear();
            }
            LinearLayout linearLayout = this.l;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                List<AlaLiveMarkData> list2 = alaUserInfoData.live_mark_info_new;
                this.r = list2;
                if (list2 != null) {
                    for (int i2 = 0; i2 < this.r.size(); i2++) {
                        TbImageView tbImageView = new TbImageView(this.f62135b.getPageActivity());
                        tbImageView.setDefaultBgResource(R.color.transparent);
                        tbImageView.V(this.r.get(i2).mark_pic, 21, false);
                        tbImageView.setLayoutParams(new LinearLayout.LayoutParams(dimension, dimension));
                        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        ((LinearLayout.LayoutParams) tbImageView.getLayoutParams()).rightMargin = (int) this.f62135b.getResources().getDimension(R.dimen.ds12);
                        this.l.addView(tbImageView);
                    }
                    return;
                }
                return;
            }
            return;
        }
        j(TbadkCoreApplication.getCurrentPortrait(), TbadkCoreApplication.getCurrentAccountNameShow(), String.format(this.f62135b.getString(R.string.ala_achievement_mark_get_text), 0));
        List<AlaLiveMarkData> list3 = this.r;
        if (list3 != null && list3.size() > 0) {
            this.r.clear();
        }
        LinearLayout linearLayout2 = this.l;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
    }

    public final void j(String str, String str2, String str3) {
        if (!StringUtils.isNull(str)) {
            this.f62138e.V(str, 25, false);
            d.h().m(str, 25, new C1674a(), null);
        } else {
            this.f62138e.V(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
            this.f62141h.V(String.valueOf(R.drawable.icon_default_avatar100_bg), 24, false);
        }
        if (!StringUtils.isNull(str2)) {
            this.f62139f.setText(str2);
        } else {
            this.f62139f.setText("");
        }
        if (!StringUtils.isNull(str3)) {
            this.f62140g.setText(str3);
        } else {
            this.f62140g.setText("");
        }
    }
}
