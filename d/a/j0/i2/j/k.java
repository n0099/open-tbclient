package d.a.j0.i2.j;

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
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55636a;

    /* renamed from: b  reason: collision with root package name */
    public View f55637b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f55638c;

    /* renamed from: d  reason: collision with root package name */
    public View f55639d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55640e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f55641f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55642g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55643h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.j0.u3.f f55644i;
    public UserData j;
    public int k;
    public boolean l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.f55644i == null) {
                if (k.this.f55636a != null) {
                    k.this.f55636a.getPageActivity().finish();
                    return;
                }
                return;
            }
            d.a.j0.i2.f.b bVar = new d.a.j0.i2.f.b();
            bVar.f55699a = 8;
            k.this.f55644i.a(view, bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "1"));
            d.a.j0.i2.f.b bVar = new d.a.j0.i2.f.b();
            bVar.f55699a = 40;
            Bundle bundle = new Bundle();
            bVar.f55700b = bundle;
            bundle.putSerializable(UserData.TYPE_USER, k.this.j);
            if (k.this.f55644i != null) {
                k.this.f55644i.a(view, bVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.c.e.p.j.z()) {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "2"));
                if (k.this.f55644i != null) {
                    d.a.j0.i2.f.b bVar = new d.a.j0.i2.f.b();
                    bVar.f55699a = 9;
                    k.this.f55644i.a(view, bVar);
                }
            }
        }
    }

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.k = UtilHelper.getStatusBarHeight();
        this.f55637b = view2;
        d();
    }

    public final void d() {
        if (this.f55637b == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.f55637b.getLayoutParams();
            layoutParams.height = this.k;
            this.f55637b.setLayoutParams(layoutParams);
            return;
        }
        this.f55637b.setVisibility(8);
    }

    public View e() {
        return this.f55638c;
    }

    public boolean f() {
        return this.l;
    }

    public void g(int i2) {
        View view = this.f55637b;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        }
        SkinManager.setBackgroundColor(this.f55639d, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f55640e, R.color.CAM_X0105);
        m(this.f55639d.getAlpha() > 0.5f);
    }

    public void h(float f2) {
        float f3 = 0.0f;
        if (f2 >= 0.0f || f2 <= 1.0f) {
            View view = this.f55637b;
            if (view != null) {
                view.setAlpha(f2);
            }
            this.f55639d.setAlpha(f2);
            this.f55640e.setAlpha(f2);
        }
        float f4 = f2 < 0.5f ? 1.0f - (f2 * 2.0f) : (f2 * 2.0f) - 1.0f;
        if (f4 > 1.0f) {
            f3 = 1.0f;
        } else if (f4 >= 0.0f) {
            f3 = f4;
        }
        this.f55641f.setAlpha(f3);
        this.f55643h.setAlpha(f3);
        this.f55642g.setAlpha(f3);
    }

    public void i(boolean z) {
        if (z) {
            this.f55639d.setVisibility(8);
            this.f55640e.setVisibility(8);
            return;
        }
        this.f55639d.setVisibility(0);
        this.f55640e.setVisibility(0);
    }

    public void j(d.a.j0.u3.f fVar) {
        this.f55644i = fVar;
    }

    public void k(PersonStatus personStatus) {
        n();
    }

    public void l(d.a.j0.i2.e.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.j() != null) {
            UserData j = aVar.j();
            this.j = j;
            this.f55640e.setText(j.getName_show());
        }
        n();
    }

    public void m(boolean z) {
        if (this.f55641f == null) {
            return;
        }
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55641f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55643h, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55642g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55641f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55643h, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55642g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void n() {
        if (this.l) {
            this.f55643h.setVisibility(8);
            this.f55642g.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.f55642g.setVisibility(0);
            this.f55643h.setVisibility(0);
        } else {
            this.f55643h.setVisibility(8);
            this.f55642g.setVisibility(8);
        }
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.f55636a = tbPageContext;
        this.l = z;
        this.f55638c = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.f55639d = view.findViewById(R.id.person_center_nav_bg);
        this.f55640e = (TextView) view.findViewById(R.id.person_center_nav_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.f55641f = imageView;
        imageView.setOnClickListener(new a());
        ImageView imageView2 = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.f55642g = imageView2;
        imageView2.setOnClickListener(new b());
        ImageView imageView3 = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.f55643h = imageView3;
        imageView3.setOnClickListener(new c());
    }
}
