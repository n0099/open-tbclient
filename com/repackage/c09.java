package com.repackage;

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
import com.repackage.nr4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class c09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public nr4 b;
    public sz8 c;
    public rz8 d;
    public BdBaseViewPager e;
    public StickerLayout f;
    public TextView g;
    public FragmentTabWidget h;
    public TbPageContext<WriteMultiImgsActivity> i;
    public int j;
    public LinearLayout k;
    public List<String> l;
    public WriteImagesInfo m;
    public j09 n;
    public NavigationBar o;
    public ArrayList<FragmentTabIndicator> p;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c09 a;

        public a(c09 c09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c09Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.i == null || this.a.i.getPageActivity() == null) {
                return;
            }
            this.a.i.getPageActivity().setResult(0);
            this.a.i.getPageActivity().finish();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements xz8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c09 a;

        public b(c09 c09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c09Var;
        }

        @Override // com.repackage.xz8
        public void a(Bitmap bitmap, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, bitmap, z) == null) {
                if (this.a.n == null || !this.a.n.c(bitmap)) {
                    this.a.i(bitmap);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements FragmentTabWidget.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c09 a;

        public c(c09 c09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c09Var;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.b
        public void onTabSelectionChanged(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                c09 c09Var = this.a;
                if (i == c09Var.j) {
                    return;
                }
                if (i == 0) {
                    c09Var.c.g().setVisibility(0);
                    this.a.d.g().setVisibility(8);
                    if (ListUtils.isEmpty(this.a.l)) {
                        if (this.a.n != null) {
                            this.a.n.b();
                        }
                    } else {
                        c09 c09Var2 = this.a;
                        c09Var2.c.i(c09Var2.l);
                    }
                } else if (i == 1) {
                    StickerLayout stickerLayout = c09Var.f;
                    if (stickerLayout != null) {
                        stickerLayout.e();
                    }
                    this.a.c.g().setVisibility(8);
                    this.a.d.g().setVisibility(0);
                } else if (i == 2) {
                    StickerLayout stickerLayout2 = c09Var.f;
                    if (stickerLayout2 != null) {
                        stickerLayout2.e();
                    }
                    this.a.c.g().setVisibility(8);
                    this.a.d.g().setVisibility(0);
                }
                c09 c09Var3 = this.a;
                c09Var3.j = i;
                c09Var3.h.setCurrentTab(this.a.j, true, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c09 a;

        public d(c09 c09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c09Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.j(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements nr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c09 a;

        public e(c09 c09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c09Var;
        }

        @Override // com.repackage.nr4.e
        public void onClick(nr4 nr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                if (this.a.b != null) {
                    this.a.b.dismiss();
                }
                this.a.j(false);
            }
        }
    }

    public c09(TbPageContext<WriteMultiImgsActivity> tbPageContext, j09 j09Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, j09Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.e = null;
        this.g = null;
        this.j = 0;
        this.p = new ArrayList<>();
        this.i = tbPageContext;
        this.n = j09Var;
        this.k = (LinearLayout) LayoutInflater.from(tbPageContext.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08d0, (ViewGroup) null);
        m();
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.l = list;
            this.c.i(list);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.a == i) {
            return;
        }
        this.a = i;
        SkinManager.setBackgroundResource(this.k, R.color.CAM_X0205);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.o.getBackImageView(), R.drawable.obfuscated_res_0x7f080611, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.o.onChangeSkinType(this.i, i);
        SkinManager.setNavbarTitleColor(this.g, R.color.CAM_X0302, R.color.s_navbar_title_color);
        this.f.setRemoveRes(R.drawable.obfuscated_res_0x7f080a58);
        this.c.j();
        this.d.h();
        Iterator<FragmentTabIndicator> it = this.p.iterator();
        while (it.hasNext()) {
            FragmentTabIndicator next = it.next();
            if (next != null) {
                next.e(i);
            }
        }
        this.h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            this.f.setVisibility(0);
            try {
                Matrix matrix = new Matrix();
                matrix.postScale(0.6f, 0.6f);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable th) {
                TbadkCoreApplication.getInst().onAppMemoryLow();
                th.printStackTrace();
            }
            this.f.b(bitmap, this.n);
        }
    }

    public final void j(boolean z) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (tbPageContext = this.i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.i.getOrignalPage().finishActivity(z, this.m);
    }

    public void k(boolean z, WriteImagesInfo writeImagesInfo) {
        TbPageContext<WriteMultiImgsActivity> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048580, this, z, writeImagesInfo) == null) || (tbPageContext = this.i) == null || tbPageContext.getOrignalPage() == null) {
            return;
        }
        this.i.getOrignalPage().finishActivity(z, writeImagesInfo);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.h = (FragmentTabWidget) this.k.findViewById(R.id.obfuscated_res_0x7f091e96);
            Resources resources = this.i.getResources();
            String[] stringArray = resources.getStringArray(R.array.obfuscated_res_0x7f03000f);
            this.p.clear();
            for (int i = 0; i < stringArray.length; i++) {
                FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(this.i.getContext());
                fragmentTabIndicator.setText(stringArray[i]);
                fragmentTabIndicator.setTextColorResId(R.color.edit_pic_tab_title_color);
                fragmentTabIndicator.setTextSize(0, resources.getDimension(R.dimen.obfuscated_res_0x7f070332));
                fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
                this.h.addView(fragmentTabIndicator, i);
                this.p.add(fragmentTabIndicator);
            }
            this.h.setDiverColor(SkinManager.getColor(R.color.CAM_X0107));
            this.h.setCurrentTab(this.j, true, false);
            this.h.setDviderRectWidth(mi.f(this.i.getContext(), R.dimen.obfuscated_res_0x7f070258));
            this.h.setTabSelectionListener(new c(this));
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.e = (BdBaseViewPager) this.k.findViewById(R.id.obfuscated_res_0x7f0924d0);
            this.f = (StickerLayout) this.k.findViewById(R.id.obfuscated_res_0x7f091df6);
            Resources resources = this.i.getResources() == null ? TbadkCoreApplication.getInst().getResources() : this.i.getResources();
            NavigationBar navigationBar = (NavigationBar) this.k.findViewById(R.id.obfuscated_res_0x7f0924cf);
            this.o = navigationBar;
            navigationBar.setCenterTextTitle(resources.getString(R.string.obfuscated_res_0x7f0f0e5c));
            this.o.showBottomLine();
            this.g = this.o.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, resources.getString(R.string.obfuscated_res_0x7f0f04ed));
            this.o.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            FrameLayout frameLayout = (FrameLayout) this.k.findViewById(R.id.obfuscated_res_0x7f09084b);
            sz8 sz8Var = new sz8(this.i);
            this.c = sz8Var;
            sz8Var.k(new b(this));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0, mi.f(this.i.getContext(), R.dimen.obfuscated_res_0x7f070215), 0, 0);
            this.c.g().setLayoutParams(layoutParams);
            frameLayout.addView(this.c.g());
            rz8 rz8Var = new rz8(this.i);
            this.d = rz8Var;
            frameLayout.addView(rz8Var.g());
            this.d.g().setVisibility(8);
            l();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.h();
        }
    }

    public void o() {
        StickerLayout stickerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (stickerLayout = this.f) == null) {
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
            if (this.b == null) {
                nr4 nr4Var = new nr4(this.i.getPageActivity());
                this.b = nr4Var;
                nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0cfb);
                this.b.setPositiveButton(R.string.obfuscated_res_0x7f0f025f, new d(this));
                this.b.setNegativeButton(R.string.obfuscated_res_0x7f0f0374, new e(this));
                this.b.create(this.i);
            }
            this.b.show();
        }
    }
}
