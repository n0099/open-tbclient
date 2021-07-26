package d.a.q0.a4.u;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.s.s.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f54973a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.s.s.a f54974b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.a4.t.c.c f54975c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.a4.t.c.b f54976d;

    /* renamed from: e  reason: collision with root package name */
    public BdBaseViewPager f54977e;

    /* renamed from: f  reason: collision with root package name */
    public StickerLayout f54978f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54979g;

    /* renamed from: h  reason: collision with root package name */
    public FragmentTabWidget f54980h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<WriteMultiImgsActivity> f54981i;
    public int j;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public d.a.q0.a4.u.n.b.c n;
    public NavigationBar o;
    public ArrayList<FragmentTabIndicator> p;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f54982e;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54982e = jVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54982e.f54981i == null || this.f54982e.f54981i.getPageActivity() == null) {
                return;
            }
            this.f54982e.f54981i.getPageActivity().setResult(0);
            this.f54982e.f54981i.getPageActivity().finish();
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.q0.a4.u.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f54983a;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54983a = jVar;
        }

        @Override // d.a.q0.a4.u.e
        public void a(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) {
                if (this.f54983a.n == null || !this.f54983a.n.c(bitmap)) {
                    this.f54983a.i(bitmap);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f54984e;

        public c(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54984e = jVar;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                j jVar = this.f54984e;
                if (i2 == jVar.j) {
                    return;
                }
                if (i2 == 0) {
                    jVar.f54975c.e().setVisibility(0);
                    this.f54984e.f54976d.e().setVisibility(8);
                    if (ListUtils.isEmpty(this.f54984e.l)) {
                        if (this.f54984e.n != null) {
                            this.f54984e.n.b();
                        }
                    } else {
                        j jVar2 = this.f54984e;
                        jVar2.f54975c.g(jVar2.l);
                    }
                } else if (i2 == 1) {
                    StickerLayout stickerLayout = jVar.f54978f;
                    if (stickerLayout != null) {
                        stickerLayout.e();
                    }
                    this.f54984e.f54975c.e().setVisibility(8);
                    this.f54984e.f54976d.e().setVisibility(0);
                } else if (i2 == 2) {
                    StickerLayout stickerLayout2 = jVar.f54978f;
                    if (stickerLayout2 != null) {
                        stickerLayout2.e();
                    }
                    this.f54984e.f54975c.e().setVisibility(8);
                    this.f54984e.f54976d.e().setVisibility(0);
                }
                j jVar3 = this.f54984e;
                jVar3.j = i2;
                jVar3.f54980h.setCurrentTab(this.f54984e.j, true, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f54985e;

        public d(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54985e = jVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f54985e.f54974b != null) {
                    this.f54985e.f54974b.dismiss();
                }
                this.f54985e.j(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f54986e;

        public e(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54986e = jVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f54986e.f54974b != null) {
                    this.f54986e.f54974b.dismiss();
                }
                this.f54986e.j(false);
            }
        }
    }

    public j(TbPageContext<WriteMultiImgsActivity> tbPageContext, d.a.q0.a4.u.n.b.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54973a = 3;
        this.f54977e = null;
        this.f54979g = null;
        this.j = 0;
        this.p = new ArrayList<>();
        this.f54981i = tbPageContext;
        this.n = cVar;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.write_multi_imgs_activity, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.l = list;
            this.f54975c.g(list);
        }
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f54973a == i2) {
            return;
        }
        this.f54973a = i2;
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), R.drawable.ic_icon_pure_topbar_return40_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.f54981i, i2);
        SkinManager.setNavbarTitleColor(this.f54979g, R.color.CAM_X0302, R.color.s_navbar_title_color);
        this.f54978f.setRemoveRes(R.drawable.icon_sticker_delete);
        this.f54975c.h();
        this.f54976d.f();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.e(i2);
            }
        }
        this.f54980h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            this.f54978f.setVisibility(0);
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(0.6f, 0.6f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                th.printStackTrace();
            }
            this.f54978f.b(bitmap, this.n);
        }
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (tbPageContext = this.f54981i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f54981i.getOrignalPage().finishActivity(z, this.m);
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, writeImagesInfo) == null) || (tbPageContext = this.f54981i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.f54981i.getOrignalPage().finishActivity(z, writeImagesInfo);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f54980h = (FragmentTabWidget) this.k.findViewById(R.id.tab_widget);
            Resources resources = this.f54981i.getResources();
            String[] stringArray = resources.getStringArray(R.array.edit_pic_no_fliter_tab);
            this.p.clear();
            for (int i2 = 0; i2 < stringArray.length; i2++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.f54981i.getContext());
                fragmentTabIndicator.setText(stringArray[i2]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
                fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.fontsize34));
                fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
                this.f54980h.addView(fragmentTabIndicator, i2);
                this.p.add(fragmentTabIndicator);
            }
            this.f54980h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
            this.f54980h.setCurrentTab(this.j, true, false);
            this.f54980h.setDviderRectWidth(l.g(this.f54981i.getContext(), R.dimen.ds64));
            this.f54980h.setTabSelectionListener(new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f54977e = (BdBaseViewPager) this.k.findViewById(R.id.write_multi_imgs_viewpager);
            this.f54978f = (StickerLayout) this.k.findViewById(R.id.stickers_container);
            Resources resources = this.f54981i.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.f54981i.getResources();
            NavigationBar navigationBar = (NavigationBar) this.k.findViewById(R.id.write_multi_imgs_navibar);
            this.o = navigationBar;
            navigationBar.setCenterTextTitle(resources.getString(R.string.pic_navigation_title));
            this.o.showBottomLine();
            this.f54979g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.done));
            this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            FrameLayout frameLayout = (FrameLayout) this.k.findViewById(R.id.edit_container);
            d.a.q0.a4.t.c.c cVar = new d.a.q0.a4.t.c.c(this.f54981i);
            this.f54975c = cVar;
            cVar.j(new b(this));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0, l.g(this.f54981i.getContext(), R.dimen.ds36), 0, 0);
            this.f54975c.e().setLayoutParams(layoutParams);
            frameLayout.addView(this.f54975c.e());
            d.a.q0.a4.t.c.b bVar = new d.a.q0.a4.t.c.b(this.f54981i);
            this.f54976d = bVar;
            frameLayout.addView(bVar.e());
            this.f54976d.e().setVisibility(8);
            l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f54975c.f();
        }
    }

    public void o() {
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (stickerLayout = this.f54978f) == null) {
            return;
        }
        stickerLayout.f(null);
    }

    public void p(WriteImagesInfo writeImagesInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, writeImagesInfo) == null) {
            this.m = writeImagesInfo;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.f54974b == null) {
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f54981i.getPageActivity());
                this.f54974b = aVar;
                aVar.setMessageId(R.string.orginal_conflict_tip);
                this.f54974b.setPositiveButton(R.string.alert_yes_button, new d(this));
                this.f54974b.setNegativeButton(R.string.cancel, new e(this));
                this.f54974b.create(this.f54981i);
            }
            this.f54974b.show();
        }
    }
}
