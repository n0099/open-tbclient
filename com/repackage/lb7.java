package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class lb7 implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public List<String> c;
    public fa8 d;
    public List<AdvertAppInfo> e;
    public boolean f;
    public y88 g;
    public boolean h;
    public long i;
    public int j;
    public boolean k;
    public Map<String, ImageUrlData> l;
    public TbPageContext<ImageViewerActivity> m;

    public lb7(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<ImageViewerActivity> tbPageContext, DragImageView.h hVar, @Nullable Map<String, ImageUrlData> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), tbPageContext, hVar, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.c = list;
        this.a = str;
        this.b = str2;
        this.f = z2;
        this.m = tbPageContext;
        try {
            fa8 fa8Var = (fa8) s98.l().h(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.d = fa8Var;
            fa8Var.h(tbPageContext, hVar, z);
        } catch (ClassCastException e) {
            if (tm4.e()) {
                throw new RuntimeException(e);
            }
        }
        this.l = map;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i >= this.c.size()) {
                return null;
            }
            String str = (String) gd7.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            boolean z = i == this.c.size() - 1;
            this.k = z;
            View b = this.d.b(str, z);
            if (b == null) {
                return null;
            }
            if (b.getParent() != null && (b.getParent() instanceof ViewGroup)) {
                ((ViewGroup) b.getParent()).removeView(b);
            }
            viewGroup.addView(b);
            AdvertAppInfo d = this.d.d(str);
            if (d != null && (this.m.getPageActivity() instanceof lg0)) {
                d.r = ng0.b(d.r, (lg0) this.m.getPageActivity(), b);
            }
            return b;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void b(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            this.e = list;
            if (this.h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i) == null) || i >= this.c.size()) {
            return;
        }
        String str = (String) gd7.d(this.c, i);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d.o(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d.getAdCount() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && this.f) {
            if (i < 0) {
                this.d.k(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int i2 = gd7.i(this.c);
            String f = w88.f(advertAppInfo);
            if (i >= i2) {
                if (!w88.j((String) gd7.d(this.c, i2 - 1)) && (z || !this.d.n())) {
                    this.k = true;
                    i = i2;
                    z2 = true;
                } else {
                    this.d.k(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.j + d() : (int) (i + this.i);
            if (w88.l(advertAppInfo)) {
                if (i >= i2) {
                    this.d.k(advertAppInfo);
                }
                String str = (String) gd7.d(this.c, i);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.d.e(str, advertAppInfo);
                return;
            }
            gd7.b(this.c, f, i);
            String str2 = (String) gd7.d(this.c, i);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.d.e(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || gd7.e(list) || gd7.e(this.c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdvertAppInfo next = it.next();
            if (next != null) {
                if (d() == di5.a().c() - 1 && di5.a().g()) {
                    if (!i()) {
                        break;
                    } else if (ng.e(next.f, -1) - 1 <= gd7.i(this.c)) {
                        g(next);
                        break;
                    }
                }
                e(next, ng.e(next.f, -1) - 1, false);
                it.remove();
            }
        }
        y88 y88Var = this.g;
        if (y88Var != null) {
            y88Var.a(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, gd7.i(this.c), true);
            y88 y88Var = this.g;
            if (y88Var != null) {
                y88Var.a(null);
            }
        }
    }

    public boolean h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            String str = (String) gd7.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.d.f(str);
        }
        return invokeI.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.c;
            String str = (String) gd7.d(list, list.size() - 1);
            Map<String, ImageUrlData> map = this.l;
            ImageUrlData imageUrlData = (map == null || str == null) ? null : map.get(str);
            return imageUrlData != null && imageUrlData.overAllIndex == ((long) this.j);
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.d.onDestroy();
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h = true;
            f(this.e);
        }
    }

    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String str = (String) gd7.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.d.j(str);
        }
    }

    public void n(@Nullable y88 y88Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, y88Var) == null) && this.f) {
            AdvertAppInfo.s.set(true);
            this.h = false;
            this.g = y88Var;
            this.d.l();
            wc5 wc5Var = new wc5();
            wc5Var.c = this.a;
            wc5Var.d = this.b;
            this.d.g(wc5Var);
        }
    }

    public void o(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.i = j - 1;
            this.j = i;
        }
    }
}
