package d.a.n0.w3.u;

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
import d.a.m0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.r.s.a f66762b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.w3.t.c.c f66763c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.w3.t.c.b f66764d;

    /* renamed from: f  reason: collision with root package name */
    public StickerLayout f66766f;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabWidget f66768h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f66769i;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public d.a.n0.w3.u.n.b.c n;
    public NavigationBar o;

    /* renamed from: a  reason: collision with root package name */
    public int f66761a = 3;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPager f66765e = null;

    /* renamed from: g  reason: collision with root package name */
    public TextView f66767g = null;
    public int j = 0;
    public ArrayList<FragmentTabIndicator> p = new ArrayList<>();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.f66769i == null || j.this.f66769i.getPageActivity() == null) {
                return;
            }
            j.this.f66769i.getPageActivity().setResult(0);
            j.this.f66769i.getPageActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.n0.w3.u.e {
        public b() {
        }

        @Override // d.a.n0.w3.u.e
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
                jVar.f66763c.e().setVisibility(0);
                j.this.f66764d.e().setVisibility(8);
                if (ListUtils.isEmpty(j.this.l)) {
                    if (j.this.n != null) {
                        j.this.n.b();
                    }
                } else {
                    j jVar2 = j.this;
                    jVar2.f66763c.g(jVar2.l);
                }
            } else if (i2 == 1) {
                StickerLayout stickerLayout = jVar.f66766f;
                if (stickerLayout != null) {
                    stickerLayout.e();
                }
                j.this.f66763c.e().setVisibility(8);
                j.this.f66764d.e().setVisibility(0);
            } else if (i2 == 2) {
                StickerLayout stickerLayout2 = jVar.f66766f;
                if (stickerLayout2 != null) {
                    stickerLayout2.e();
                }
                j.this.f66763c.e().setVisibility(8);
                j.this.f66764d.e().setVisibility(0);
            }
            j jVar3 = j.this;
            jVar3.j = i2;
            jVar3.f66768h.setCurrentTab(j.this.j, true, true);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (j.this.f66762b != null) {
                j.this.f66762b.dismiss();
            }
            j.this.j(true);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (j.this.f66762b != null) {
                j.this.f66762b.dismiss();
            }
            j.this.j(false);
        }
    }

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, d.a.n0.w3.u.n.b.c cVar) {
        this.f66769i = tbPageContext;
        this.n = cVar;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        this.l = list;
        this.f66763c.g(list);
    }

    public void h(int i2) {
        if (this.f66761a == i2) {
            return;
        }
        this.f66761a = i2;
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.f66769i, i2);
        SkinManager.setNavbarTitleColor(this.f66767g, R.color.CAM_X0302, R.color.s_navbar_title_color);
        this.f66766f.setRemoveRes(R.drawable.icon_sticker_delete);
        this.f66763c.h();
        this.f66764d.f();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.e(i2);
            }
        }
        this.f66768h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        this.f66766f.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.f66766f.b(bitmap, this.n);
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f66769i;
        if (tbPageContext == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f66769i.getOrignalPage().finishActivity(z, this.m);
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.f66769i;
        if (tbPageContext == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f66769i.getOrignalPage().finishActivity(z, writeImagesInfo);
    }

    public final void l() {
        this.f66768h = (FragmentTabWidget) this.k.findViewById(R.id.tab_widget);
        Resources resources = this.f66769i.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.p.clear();
        for (int i2 = 0; i2 < stringArray.length; i2++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.f66769i.getContext());
            fragmentTabIndicator.setText(stringArray[i2]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            this.f66768h.addView(fragmentTabIndicator, i2);
            this.p.add(fragmentTabIndicator);
        }
        this.f66768h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
        this.f66768h.setCurrentTab(this.j, true, false);
        this.f66768h.setDviderRectWidth(l.g(this.f66769i.getContext(), R.dimen.ds64));
        this.f66768h.setTabSelectionListener(new c());
    }

    public final void m() {
        this.f66765e = (BdBaseViewPager) this.k.findViewById(R.id.write_multi_imgs_viewpager);
        this.f66766f = (StickerLayout) this.k.findViewById(R.id.stickers_container);
        Resources resources = this.f66769i.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.f66769i.getResources();
        NavigationBar navigationBar = (NavigationBar) this.k.findViewById(R.id.write_multi_imgs_navibar);
        this.o = navigationBar;
        navigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.o.showBottomLine();
        this.f66767g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(R.id.edit_container);
        d.a.n0.w3.t.c.c cVar = new d.a.n0.w3.t.c.c(this.f66769i);
        this.f66763c = cVar;
        cVar.i(new b());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.g(this.f66769i.getContext(), R.dimen.ds36), 0, 0);
        this.f66763c.e().setLayoutParams(layoutParams);
        frameLayout.addView(this.f66763c.e());
        d.a.n0.w3.t.c.b bVar = new d.a.n0.w3.t.c.b(this.f66769i);
        this.f66764d = bVar;
        frameLayout.addView(bVar.e());
        this.f66764d.e().setVisibility(8);
        l();
    }

    public void n() {
        this.f66763c.f();
    }

    public void o() {
        StickerLayout stickerLayout = this.f66766f;
        if (stickerLayout != null) {
            stickerLayout.f(null);
        }
    }

    public void p(WriteImagesInfo writeImagesInfo) {
        this.m = writeImagesInfo;
    }

    public void q() {
        if (this.f66762b == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f66769i.getPageActivity());
            this.f66762b = aVar;
            aVar.setMessageId(R.string.orginal_conflict_tip);
            this.f66762b.setPositiveButton(R.string.alert_yes_button, new d());
            this.f66762b.setNegativeButton(R.string.cancel, new e());
            this.f66762b.create(this.f66769i);
        }
        this.f66762b.show();
    }
}
