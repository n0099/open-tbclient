package d.a.o0.j2.j;

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
    public TbPageContext f60341a;

    /* renamed from: b  reason: collision with root package name */
    public View f60342b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f60343c;

    /* renamed from: d  reason: collision with root package name */
    public View f60344d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60345e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60346f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f60347g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f60348h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.v3.f f60349i;
    public UserData j;
    public int k;
    public boolean l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (k.this.f60349i == null) {
                if (k.this.f60341a != null) {
                    k.this.f60341a.getPageActivity().finish();
                    return;
                }
                return;
            }
            d.a.o0.j2.f.b bVar = new d.a.o0.j2.f.b();
            bVar.f60400a = 8;
            k.this.f60349i.a(view, bVar);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log(new StatisticItem("c12503").param("obj_locate", "1"));
            d.a.o0.j2.f.b bVar = new d.a.o0.j2.f.b();
            bVar.f60400a = 40;
            Bundle bundle = new Bundle();
            bVar.f60401b = bundle;
            bundle.putSerializable(UserData.TYPE_USER, k.this.j);
            if (k.this.f60349i != null) {
                k.this.f60349i.a(view, bVar);
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
                if (k.this.f60349i != null) {
                    d.a.o0.j2.f.b bVar = new d.a.o0.j2.f.b();
                    bVar.f60400a = 9;
                    k.this.f60349i.a(view, bVar);
                }
            }
        }
    }

    public k(TbPageContext tbPageContext, View view, View view2, boolean z) {
        this(tbPageContext, view, z);
        this.k = UtilHelper.getStatusBarHeight();
        this.f60342b = view2;
        d();
    }

    public final void d() {
        if (this.f60342b == null) {
            return;
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ViewGroup.LayoutParams layoutParams = this.f60342b.getLayoutParams();
            layoutParams.height = this.k;
            this.f60342b.setLayoutParams(layoutParams);
            return;
        }
        this.f60342b.setVisibility(8);
    }

    public View e() {
        return this.f60343c;
    }

    public boolean f() {
        return this.l;
    }

    public void g(int i2) {
        View view = this.f60342b;
        if (view != null) {
            SkinManager.setBackgroundColor(view, R.color.CAM_X0201);
        }
        SkinManager.setBackgroundColor(this.f60344d, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f60345e, R.color.CAM_X0105);
        m(this.f60344d.getAlpha() > 0.5f);
    }

    public void h(float f2) {
        float f3 = 0.0f;
        if (f2 >= 0.0f || f2 <= 1.0f) {
            View view = this.f60342b;
            if (view != null) {
                view.setAlpha(f2);
            }
            this.f60344d.setAlpha(f2);
            this.f60345e.setAlpha(f2);
        }
        float f4 = f2 < 0.5f ? 1.0f - (f2 * 2.0f) : (f2 * 2.0f) - 1.0f;
        if (f4 > 1.0f) {
            f3 = 1.0f;
        } else if (f4 >= 0.0f) {
            f3 = f4;
        }
        this.f60346f.setAlpha(f3);
        this.f60348h.setAlpha(f3);
        this.f60347g.setAlpha(f3);
    }

    public void i(boolean z) {
        if (z) {
            this.f60344d.setVisibility(8);
            this.f60345e.setVisibility(8);
            return;
        }
        this.f60344d.setVisibility(0);
        this.f60345e.setVisibility(0);
    }

    public void j(d.a.o0.v3.f fVar) {
        this.f60349i = fVar;
    }

    public void k(PersonStatus personStatus) {
        n();
    }

    public void l(d.a.o0.j2.e.a aVar, PersonStatus personStatus) {
        if (aVar != null && aVar.j() != null) {
            UserData j = aVar.j();
            this.j = j;
            this.f60345e.setText(j.getName_show());
        }
        n();
    }

    public void m(boolean z) {
        if (this.f60346f == null) {
            return;
        }
        if (z) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60346f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60348h, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60347g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            return;
        }
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60346f, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60348h, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60347g, R.drawable.icon_pure_topbar_createchat44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void n() {
        if (this.l) {
            this.f60348h.setVisibility(8);
            this.f60347g.setVisibility(8);
        } else if (TbadkCoreApplication.isLogin()) {
            this.f60347g.setVisibility(0);
            this.f60348h.setVisibility(0);
        } else {
            this.f60348h.setVisibility(8);
            this.f60347g.setVisibility(8);
        }
    }

    public k(TbPageContext tbPageContext, View view, boolean z) {
        this.f60341a = tbPageContext;
        this.l = z;
        this.f60343c = (RelativeLayout) view.findViewById(R.id.person_center_nav_layout);
        this.f60344d = view.findViewById(R.id.person_center_nav_bg);
        this.f60345e = (TextView) view.findViewById(R.id.person_center_nav_title);
        ImageView imageView = (ImageView) view.findViewById(R.id.person_center_nav_back_img);
        this.f60346f = imageView;
        imageView.setOnClickListener(new a());
        ImageView imageView2 = (ImageView) view.findViewById(R.id.person_center_nav_chat_img);
        this.f60347g = imageView2;
        imageView2.setOnClickListener(new b());
        ImageView imageView3 = (ImageView) view.findViewById(R.id.person_center_nav_more_img);
        this.f60348h = imageView3;
        imageView3.setOnClickListener(new c());
    }
}
