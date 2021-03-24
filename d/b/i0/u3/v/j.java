package d.b.i0.u3.v;

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
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class j {

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.r.s.a f61809b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.u3.u.c.c f61810c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.u3.u.c.b f61811d;

    /* renamed from: f  reason: collision with root package name */
    public StickerLayout f61813f;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabWidget f61815h;
    public TbPageContext<WriteMultiImgsActivity> i;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public d.b.i0.u3.v.n.b.c n;
    public NavigationBar o;

    /* renamed from: a  reason: collision with root package name */
    public int f61808a = 3;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPager f61812e = null;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61814g = null;
    public int j = 0;
    public ArrayList<FragmentTabIndicator> p = new ArrayList<>();

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.this.i == null || j.this.i.getPageActivity() == null) {
                return;
            }
            j.this.i.getPageActivity().setResult(0);
            j.this.i.getPageActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.b.i0.u3.v.e {
        public b() {
        }

        @Override // d.b.i0.u3.v.e
        public void a(Bitmap bitmap, boolean z) {
            if (j.this.n == null || !j.this.n.b(bitmap)) {
                j.this.i(bitmap);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements FragmentTabWidget.b {
        public c() {
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i, boolean z) {
            j jVar = j.this;
            if (i == jVar.j) {
                return;
            }
            if (i == 0) {
                jVar.f61810c.e().setVisibility(0);
                j.this.f61811d.e().setVisibility(8);
                if (ListUtils.isEmpty(j.this.l)) {
                    if (j.this.n != null) {
                        j.this.n.c();
                    }
                } else {
                    j jVar2 = j.this;
                    jVar2.f61810c.g(jVar2.l);
                }
            } else if (i == 1) {
                StickerLayout stickerLayout = jVar.f61813f;
                if (stickerLayout != null) {
                    stickerLayout.e();
                }
                j.this.f61810c.e().setVisibility(8);
                j.this.f61811d.e().setVisibility(0);
            } else if (i == 2) {
                StickerLayout stickerLayout2 = jVar.f61813f;
                if (stickerLayout2 != null) {
                    stickerLayout2.e();
                }
                j.this.f61810c.e().setVisibility(8);
                j.this.f61811d.e().setVisibility(0);
            }
            j jVar3 = j.this;
            jVar3.j = i;
            jVar3.f61815h.setCurrentTab(j.this.j, true, true);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (j.this.f61809b != null) {
                j.this.f61809b.dismiss();
            }
            j.this.j(true);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {
        public e() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (j.this.f61809b != null) {
                j.this.f61809b.dismiss();
            }
            j.this.j(false);
        }
    }

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, d.b.i0.u3.v.n.b.c cVar) {
        this.i = tbPageContext;
        this.n = cVar;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        this.l = list;
        this.f61810c.g(list);
    }

    public void h(int i) {
        if (this.f61808a == i) {
            return;
        }
        this.f61808a = i;
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.i, i);
        SkinManager.setNavbarTitleColor(this.f61814g, R.color.CAM_X0302, R.color.s_navbar_title_color);
        this.f61813f.setRemoveRes(R.drawable.icon_sticker_delete);
        this.f61810c.h();
        this.f61811d.f();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.e(i);
            }
        }
        this.f61815h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        this.f61813f.setVisibility(0);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(0.6f, 0.6f);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            TbadkCoreApplication.getInst().onAppMemoryLow();
            th.printStackTrace();
        }
        this.f61813f.b(bitmap, this.n);
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.i;
        if (tbPageContext == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.i.getOrignalPage().finishActivity(z, this.m);
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext = this.i;
        if (tbPageContext == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.i.getOrignalPage().finishActivity(z, writeImagesInfo);
    }

    public final void l() {
        this.f61815h = (FragmentTabWidget) this.k.findViewById(R.id.tab_widget);
        Resources resources = this.i.getResources();
        String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
        this.p.clear();
        for (int i = 0; i < stringArray.length; i++) {
            FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.i.getContext());
            fragmentTabIndicator.setText(stringArray[i]);
            fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
            fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
            fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
            this.f61815h.addView(fragmentTabIndicator, i);
            this.p.add(fragmentTabIndicator);
        }
        this.f61815h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
        this.f61815h.setCurrentTab(this.j, true, false);
        this.f61815h.setDviderRectWidth(l.g(this.i.getContext(), R.dimen.ds64));
        this.f61815h.setTabSelectionListener(new c());
    }

    public final void m() {
        this.f61812e = (BdBaseViewPager) this.k.findViewById(R.id.write_multi_imgs_viewpager);
        this.f61813f = (StickerLayout) this.k.findViewById(R.id.stickers_container);
        Resources resources = this.i.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.i.getResources();
        NavigationBar navigationBar = (NavigationBar) this.k.findViewById(R.id.write_multi_imgs_navibar);
        this.o = navigationBar;
        navigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
        this.o.showBottomLine();
        this.f61814g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
        this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a());
        FrameLayout frameLayout = (FrameLayout) this.k.findViewById(R.id.edit_container);
        d.b.i0.u3.u.c.c cVar = new d.b.i0.u3.u.c.c(this.i);
        this.f61810c = cVar;
        cVar.i(new b());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(0, l.g(this.i.getContext(), R.dimen.ds36), 0, 0);
        this.f61810c.e().setLayoutParams(layoutParams);
        frameLayout.addView(this.f61810c.e());
        d.b.i0.u3.u.c.b bVar = new d.b.i0.u3.u.c.b(this.i);
        this.f61811d = bVar;
        frameLayout.addView(bVar.e());
        this.f61811d.e().setVisibility(8);
        l();
    }

    public void n() {
        this.f61810c.f();
    }

    public void o() {
        StickerLayout stickerLayout = this.f61813f;
        if (stickerLayout != null) {
            stickerLayout.f(null);
        }
    }

    public void p(WriteImagesInfo writeImagesInfo) {
        this.m = writeImagesInfo;
    }

    public void q() {
        if (this.f61809b == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.i.getPageActivity());
            this.f61809b = aVar;
            aVar.setMessageId(R.string.orginal_conflict_tip);
            this.f61809b.setPositiveButton(R.string.alert_yes_button, new d());
            this.f61809b.setNegativeButton(R.string.cancel, new e());
            this.f61809b.create(this.i);
        }
        this.f61809b.show();
    }
}
