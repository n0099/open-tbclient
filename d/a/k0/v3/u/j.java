package d.a.k0.v3.u;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.WriteMultiImgsActivity;
import com.baidu.tieba.write.write.sticker.view.StickerLayout;
import d.a.c.e.p.l;
import d.a.j0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.r.s.a f62938b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.v3.t.c.c f62939c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.v3.t.c.b f62940d;

    /* renamed from: f  reason: collision with root package name */
    public StickerLayout f62942f;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabWidget f62944h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f62945i;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public d.a.k0.v3.u.n.b.c n;
    public NavigationBar o;

    /* renamed from: a  reason: collision with root package name */
    public int f62937a = 3;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPager f62941e = null;

    /* renamed from: g  reason: collision with root package name */
    public TextView f62943g = null;
    public int j = 0;
    public ArrayList<FragmentTabIndicator> p = new ArrayList<>();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.f62945i == null || j.this.f62945i.getPageActivity() == null) {
                return;
            }
            j.this.f62945i.getPageActivity().setResult(0);
            j.this.f62945i.getPageActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.k0.v3.u.e {
        public b() {
        }

        @Override // d.a.k0.v3.u.e
        public void a(Bitmap bitmap, boolean z) {
            if (j.this.n == null || !j.this.n.c(bitmap)) {
                j.this.i(bitmap);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements FragmentTabWidget.b {
        public c() {
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            j jVar = j.this;
            if (i2 == jVar.j) {
                return;
            }
            if (i2 == 0) {
                jVar.f62939c.e().setVisibility(0);
                j.this.f62940d.e().setVisibility(8);
                if (ListUtils.isEmpty(j.this.l)) {
                    if (j.this.n != null) {
                        j.this.n.b();
                    }
                } else {
                    j jVar2 = j.this;
                    jVar2.f62939c.g(jVar2.l);
                }
            } else if (i2 == 1) {
                StickerLayout stickerLayout = jVar.f62942f;
                if (stickerLayout != null) {
                    stickerLayout.e();
                }
                j.this.f62939c.e().setVisibility(8);
                j.this.f62940d.e().setVisibility(0);
            } else if (i2 == 2) {
                StickerLayout stickerLayout2 = jVar.f62942f;
                if (stickerLayout2 != null) {
                    stickerLayout2.e();
                }
                j.this.f62939c.e().setVisibility(8);
                j.this.f62940d.e().setVisibility(0);
            }
            j jVar3 = j.this;
            jVar3.j = i2;
            jVar3.f62944h.setCurrentTab(j.this.j, true, true);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            if (j.this.f62938b != null) {
                j.this.f62938b.dismiss();
            }
            j.this.j(true);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            if (j.this.f62938b != null) {
                j.this.f62938b.dismiss();
            }
            j.this.j(false);
        }
    }

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, d.a.k0.v3.u.n.b.c cVar) {
        this.f62945i = tbPageContext;
        this.n = cVar;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        this.l = list;
        this.f62939c.g(list);
    }

    public void h(int i2) {
        if (this.f62937a == i2) {
            return;
        }
        this.f62937a = i2;
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.f62945i, i2);
        SkinManager.setNavbarTitleColor(this.f62943g, R.color.CAM_X0302, R.color.s_navbar_title_color);
        this.f62942f.setRemoveRes(R.drawable.icon_sticker_delete);
        this.f62939c.h();
        this.f62940d.f();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.e(i2);
            }
        }
        this.f62944h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        this.f62942f.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.f62942f.b(bitmap, this.n);
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f62945i;
        if (tbPageContext == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f62945i.getOrignalPage().finishActivity(z, this.m);
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f62945i;
        if (tbPageContext == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f62945i.getOrignalPage().finishActivity(z, writeImagesInfo);
    }

    public final void l() {
        this.f62944h = (FragmentTabWidget) this.k.findViewById(R.id.tab_widget);
        Resources resources = this.f62945i.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.p.clear();
        for (int i2 = 0; i2 < stringArray.length; i2++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.f62945i.getContext());
            fragmentTabIndicator.setText(stringArray[i2]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            this.f62944h.addView(fragmentTabIndicator, i2);
            this.p.add(fragmentTabIndicator);
        }
        this.f62944h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
        this.f62944h.setCurrentTab(this.j, true, false);
        this.f62944h.setDviderRectWidth(l.g(this.f62945i.getContext(), R.dimen.ds64));
        this.f62944h.setTabSelectionListener(new c());
    }

    public final void m() {
        this.f62941e = (BdBaseViewPager) this.k.findViewById(R.id.write_multi_imgs_viewpager);
        this.f62942f = (StickerLayout) this.k.findViewById(R.id.stickers_container);
        Resources resources = this.f62945i.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.f62945i.getResources();
        NavigationBar navigationBar = (NavigationBar) this.k.findViewById(R.id.write_multi_imgs_navibar);
        this.o = navigationBar;
        navigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.o.showBottomLine();
        this.f62943g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(R.id.edit_container);
        d.a.k0.v3.t.c.c cVar = new d.a.k0.v3.t.c.c(this.f62945i);
        this.f62939c = cVar;
        cVar.j(new b());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.g(this.f62945i.getContext(), R.dimen.ds36), 0, 0);
        this.f62939c.e().setLayoutParams(layoutParams);
        frameLayout.addView(this.f62939c.e());
        d.a.k0.v3.t.c.b bVar = new d.a.k0.v3.t.c.b(this.f62945i);
        this.f62940d = bVar;
        frameLayout.addView(bVar.e());
        this.f62940d.e().setVisibility(8);
        l();
    }

    public void n() {
        this.f62939c.f();
    }

    public void o() {
        StickerLayout stickerLayout = this.f62942f;
        if (stickerLayout != null) {
            stickerLayout.f(null);
        }
    }

    public void p(WriteImagesInfo writeImagesInfo) {
        this.m = writeImagesInfo;
    }

    public void q() {
        if (this.f62938b == null) {
            d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f62945i.getPageActivity());
            this.f62938b = aVar;
            aVar.setMessageId(R.string.orginal_conflict_tip);
            this.f62938b.setPositiveButton(R.string.alert_yes_button, new d());
            this.f62938b.setNegativeButton(R.string.cancel, new e());
            this.f62938b.create(this.f62945i);
        }
        this.f62938b.show();
    }
}
