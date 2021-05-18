package d.a.k0.i2.j;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.constant.PersonStatus;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56343a;

    /* renamed from: b  reason: collision with root package name */
    public View f56344b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f56345c;

    /* renamed from: d  reason: collision with root package name */
    public View f56346d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56347e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56348f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56349g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f56350h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.u3.f f56351i;
    public UserData j;
    public int k;
    public boolean l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.f56351i == null) {
                if (k.this.f56343a != null) {
                    k.this.f56343a.getPageActivity().finish();
                    return;
                }
                return;
            }
            d.a.k0.i2.f.b bVar = new d.a.k0.i2.f.b();
            bVar.f56406a = 8;
            k.this.f56351i.a(view, bVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "1"));
            d.a.k0.i2.f.b bVar = new d.a.k0.i2.f.b();
            bVar.f56406a = 40;
            Bundle bundle = new Bundle();
            bVar.f56407b = bundle;
            bundle.putSerializable(UserData.TYPE_USER, k.this.j);
            if (k.this.f56351i != null) {
                k.this.f56351i.a(view, bVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.z()) {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "2"));
                if (k.this.f56351i != null) {
                    d.a.k0.i2.f.b bVar = new d.a.k0.i2.f.b();
                    bVar.f56406a = 9;
                    k.this.f56351i.a(view, bVar);
                }
            }
        }
    }

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.k = UtilHelper.getStatusBarHeight();
        this.f56344b = view2;
        d();
    }

    public final void d() {
        if (this.f56344b == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.f56344b.getLayoutParams();
            layoutParams.height = this.k;
            this.f56344b.setLayoutParams(layoutParams);
            return;
        }
        this.f56344b.setVisibility(8);
    }

    public View e() {
        return this.f56345c;
    }

    public boolean f() {
        return this.l;
    }

    public void g(int i2) {
        View view = this.f56344b;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        }
        SkinManager.setBackgroundColor(this.f56346d, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f56347e, R.color.CAM_X0105);
        m(this.f56346d.getAlpha() > 0.5f);
    }

    public void h(float f2) {
        float f3 = 0.0f;
        if (f2 >= 0.0f || f2 <= 1.0f) {
            View view = this.f56344b;
            if (view != null) {
                view.setAlpha(f2);
            }
            this.f56346d.setAlpha(f2);
            this.f56347e.setAlpha(f2);
        }
        float f4 = f2 < 0.5f ? 1.0f - (f2 * 2.0f) : (f2 * 2.0f) - 1.0f;
        if (f4 > 1.0f) {
            f3 = 1.0f;
        } else if (f4 >= 0.0f) {
            f3 = f4;
        }
        this.f56348f.setAlpha(f3);
        this.f56350h.setAlpha(f3);
        this.f56349g.setAlpha(f3);
    }

    public void i(boolean z) {
        if (z) {
            this.f56346d.setVisibility(8);
            this.f56347e.setVisibility(8);
            return;
        }
        this.f56346d.setVisibility(0);
        this.f56347e.setVisibility(0);
    }

    public void j(d.a.k0.u3.f fVar) {
        this.f56351i = fVar;
    }

    public void k(PersonStatus personStatus) {
        n();
    }

    public void l(d.a.k0.i2.e.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.j() != null) {
            UserData j = aVar.j();
            this.j = j;
            this.f56347e.setText(j.getName_show());
        }
        n();
    }

    public void m(boolean z) {
        if (this.f56348f == null) {
            return;
        }
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56348f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56350h, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56349g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56348f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56350h, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56349g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void n() {
        if (this.l) {
            this.f56350h.setVisibility(8);
            this.f56349g.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.f56349g.setVisibility(0);
            this.f56350h.setVisibility(0);
        } else {
            this.f56350h.setVisibility(8);
            this.f56349g.setVisibility(8);
        }
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.f56343a = tbPageContext;
        this.l = z;
        this.f56345c = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.f56346d = view.findViewById(R.id.person_center_nav_bg);
        this.f56347e = (TextView) view.findViewById(R.id.person_center_nav_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.f56348f = imageView;
        imageView.setOnClickListener(new a());
        ImageView imageView2 = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.f56349g = imageView2;
        imageView2.setOnClickListener(new b());
        ImageView imageView3 = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.f56350h = imageView3;
        imageView3.setOnClickListener(new c());
    }
}
