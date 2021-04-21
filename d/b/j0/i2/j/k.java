package d.b.j0.i2.j;

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
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57676a;

    /* renamed from: b  reason: collision with root package name */
    public View f57677b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f57678c;

    /* renamed from: d  reason: collision with root package name */
    public View f57679d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57680e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57681f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f57682g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f57683h;
    public d.b.j0.u3.f i;
    public UserData j;
    public int k;
    public boolean l;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.i == null) {
                if (k.this.f57676a != null) {
                    k.this.f57676a.getPageActivity().finish();
                    return;
                }
                return;
            }
            d.b.j0.i2.f.b bVar = new d.b.j0.i2.f.b();
            bVar.f57736a = 8;
            k.this.i.a(view, bVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "1"));
            d.b.j0.i2.f.b bVar = new d.b.j0.i2.f.b();
            bVar.f57736a = 40;
            Bundle bundle = new Bundle();
            bVar.f57737b = bundle;
            bundle.putSerializable(UserData.TYPE_USER, k.this.j);
            if (k.this.i != null) {
                k.this.i.a(view, bVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.b.c.e.p.j.z()) {
                TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "2"));
                if (k.this.i != null) {
                    d.b.j0.i2.f.b bVar = new d.b.j0.i2.f.b();
                    bVar.f57736a = 9;
                    k.this.i.a(view, bVar);
                }
            }
        }
    }

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.k = UtilHelper.getStatusBarHeight();
        this.f57677b = view2;
        d();
    }

    public final void d() {
        if (this.f57677b == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.f57677b.getLayoutParams();
            layoutParams.height = this.k;
            this.f57677b.setLayoutParams(layoutParams);
            return;
        }
        this.f57677b.setVisibility(8);
    }

    public View e() {
        return this.f57678c;
    }

    public boolean f() {
        return this.l;
    }

    public void g(int i) {
        View view = this.f57677b;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        }
        SkinManager.setBackgroundColor(this.f57679d, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f57680e, R.color.CAM_X0105);
        m(this.f57679d.getAlpha() > 0.5f);
    }

    public void h(float f2) {
        float f3 = 0.0f;
        if (f2 >= 0.0f || f2 <= 1.0f) {
            View view = this.f57677b;
            if (view != null) {
                view.setAlpha(f2);
            }
            this.f57679d.setAlpha(f2);
            this.f57680e.setAlpha(f2);
        }
        float f4 = f2 < 0.5f ? 1.0f - (f2 * 2.0f) : (f2 * 2.0f) - 1.0f;
        if (f4 > 1.0f) {
            f3 = 1.0f;
        } else if (f4 >= 0.0f) {
            f3 = f4;
        }
        this.f57681f.setAlpha(f3);
        this.f57683h.setAlpha(f3);
        this.f57682g.setAlpha(f3);
    }

    public void i(boolean z) {
        if (z) {
            this.f57679d.setVisibility(8);
            this.f57680e.setVisibility(8);
            return;
        }
        this.f57679d.setVisibility(0);
        this.f57680e.setVisibility(0);
    }

    public void j(d.b.j0.u3.f fVar) {
        this.i = fVar;
    }

    public void k(PersonStatus personStatus) {
        n();
    }

    public void l(d.b.j0.i2.e.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.j() != null) {
            UserData j = aVar.j();
            this.j = j;
            this.f57680e.setText(j.getName_show());
        }
        n();
    }

    public void m(boolean z) {
        if (this.f57681f == null) {
            return;
        }
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57681f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57683h, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57682g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57681f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57683h, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f57682g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void n() {
        if (this.l) {
            this.f57683h.setVisibility(8);
            this.f57682g.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.f57682g.setVisibility(0);
            this.f57683h.setVisibility(0);
        } else {
            this.f57683h.setVisibility(8);
            this.f57682g.setVisibility(8);
        }
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.f57676a = tbPageContext;
        this.l = z;
        this.f57678c = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.f57679d = view.findViewById(R.id.person_center_nav_bg);
        this.f57680e = (TextView) view.findViewById(R.id.person_center_nav_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.f57681f = imageView;
        imageView.setOnClickListener(new a());
        ImageView imageView2 = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.f57682g = imageView2;
        imageView2.setOnClickListener(new b());
        ImageView imageView3 = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.f57683h = imageView3;
        imageView3.setOnClickListener(new c());
    }
}
