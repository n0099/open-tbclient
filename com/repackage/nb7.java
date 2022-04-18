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
public class nb7 implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public List<String> c;
    public cb8 d;
    public List<AdvertAppInfo> e;
    public boolean f;
    public q98 g;
    public boolean h;
    public long i;
    public int j;
    public boolean k;
    public Map<String, ImageUrlData> l;
    public TbPageContext<ImageViewerActivity> m;

    public nb7(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<ImageViewerActivity> tbPageContext, DragImageView.h hVar, @Nullable Map<String, ImageUrlData> map) {
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
            cb8 cb8Var = (cb8) ma8.q().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.d = cb8Var;
            cb8Var.j(tbPageContext, hVar, z);
        } catch (ClassCastException e) {
            if (um4.e()) {
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
            String str = (String) jd7.d(this.c, i);
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
            AdvertAppInfo e = this.d.e(str);
            if (e != null && (this.m.getPageActivity() instanceof lh0)) {
                e.u = nh0.b(e.u, (lh0) this.m.getPageActivity(), b);
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
        String str = (String) jd7.d(this.c, i);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.d.q(str);
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
                this.d.m(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = jd7.k(this.c);
            String f = n98.f(advertAppInfo);
            if (i >= k) {
                if (!n98.l((String) jd7.d(this.c, k - 1)) && (z || !this.d.p())) {
                    this.k = true;
                    i = k;
                    z2 = true;
                } else {
                    this.d.m(advertAppInfo);
                    return;
                }
            }
            advertAppInfo.position = z2 ? this.j + d() : (int) (i + this.i);
            if (n98.n(advertAppInfo)) {
                if (i >= k) {
                    this.d.m(advertAppInfo);
                }
                String str = (String) jd7.d(this.c, i);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.d.f(str, advertAppInfo);
                return;
            }
            jd7.b(this.c, f, i);
            String str2 = (String) jd7.d(this.c, i);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.d.f(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || jd7.e(list) || jd7.e(this.c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdvertAppInfo next = it.next();
            if (next != null) {
                if (d() == rg5.h().j() - 1 && rg5.h().v()) {
                    if (!i()) {
                        break;
                    } else if (mg.e(next.g, -1) - 1 <= jd7.k(this.c)) {
                        g(next);
                        break;
                    }
                }
                e(next, mg.e(next.g, -1) - 1, false);
                it.remove();
            }
        }
        q98 q98Var = this.g;
        if (q98Var != null) {
            q98Var.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, jd7.k(this.c), true);
            q98 q98Var = this.g;
            if (q98Var != null) {
                q98Var.onCallback(null);
            }
        }
    }

    public boolean h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            String str = (String) jd7.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.d.g(str);
        }
        return invokeI.booleanValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            List<String> list = this.c;
            String str = (String) jd7.d(list, list.size() - 1);
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
            String str = (String) jd7.d(this.c, i);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.d.l(str);
        }
    }

    public void n(@Nullable q98 q98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, q98Var) == null) && this.f) {
            this.h = false;
            this.g = q98Var;
            this.d.n();
            vb5 vb5Var = new vb5();
            vb5Var.l = this.a;
            vb5Var.m = this.b;
            this.d.h(vb5Var);
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
