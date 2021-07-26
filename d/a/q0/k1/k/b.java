package d.a.q0.k1.k;

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
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.image.ImageViewerActivity;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.c;
import d.a.q0.w2.d;
import d.a.q0.w2.w;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements IAdBaseAsyncController.a, ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f59959a;

    /* renamed from: b  reason: collision with root package name */
    public final String f59960b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f59961c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.w2.b0.b f59962d;

    /* renamed from: e  reason: collision with root package name */
    public List<AdvertAppInfo> f59963e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59964f;

    /* renamed from: g  reason: collision with root package name */
    public d f59965g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59966h;

    /* renamed from: i  reason: collision with root package name */
    public long f59967i;
    public int j;

    public b(List<String> list, String str, String str2, boolean z, boolean z2, TbPageContext<ImageViewerActivity> tbPageContext, DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), tbPageContext, hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59961c = list;
        this.f59959a = str;
        this.f59960b = str2;
        this.f59964f = z2;
        try {
            d.a.q0.w2.b0.b bVar = (d.a.q0.w2.b0.b) w.o().k(IAdBaseAsyncController.Type.PIC_PAGE, this);
            this.f59962d = bVar;
            bVar.h(tbPageContext, hVar, z);
        } catch (ClassCastException unused) {
        }
    }

    @Override // com.baidu.tieba.recapp.async.IAdBaseAsyncController.a
    public void a(@Nullable List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            this.f59963e = list;
            if (this.f59966h) {
                f(list);
            }
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View b(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        View f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2)) == null) {
            if (i2 >= this.f59961c.size()) {
                return null;
            }
            String str = (String) d.a.q0.n1.o.k.a.d(this.f59961c, i2);
            if (TextUtils.isEmpty(str) || (f2 = this.f59962d.f(str)) == null) {
                return null;
            }
            if (f2.getParent() != null && (f2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) f2.getParent()).removeView(f2);
            }
            viewGroup.addView(f2);
            return f2;
        }
        return (View) invokeLI.objValue;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public void c(ViewGroup viewGroup, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2) == null) || i2 >= this.f59961c.size()) {
            return;
        }
        String str = (String) d.a.q0.n1.o.k.a.d(this.f59961c, i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f59962d.l(str);
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59962d.c() : invokeV.intValue;
    }

    public final void e(@NonNull AdvertAppInfo advertAppInfo, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{advertAppInfo, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && this.f59964f) {
            if (i2 < 0) {
                this.f59962d.j(advertAppInfo);
                return;
            }
            boolean z2 = false;
            int k = d.a.q0.n1.o.k.a.k(this.f59961c);
            String f2 = d.a.q0.w2.a.f(advertAppInfo);
            if (i2 >= k) {
                if (d.a.q0.w2.a.l((String) d.a.q0.n1.o.k.a.d(this.f59961c, k - 1)) || (!z && this.f59962d.k())) {
                    this.f59962d.j(advertAppInfo);
                    return;
                } else {
                    z2 = true;
                    i2 = k;
                }
            }
            advertAppInfo.position = z2 ? this.j + d() : (int) (i2 + this.f59967i);
            if (d.a.q0.w2.a.n(advertAppInfo)) {
                if (i2 >= k) {
                    this.f59962d.j(advertAppInfo);
                }
                String str = (String) d.a.q0.n1.o.k.a.d(this.f59961c, i2);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f59962d.b(str, advertAppInfo);
                return;
            }
            d.a.q0.n1.o.k.a.b(this.f59961c, f2, i2);
            String str2 = (String) d.a.q0.n1.o.k.a.d(this.f59961c, i2);
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            this.f59962d.b(str2, advertAppInfo);
        }
    }

    public final void f(List<AdvertAppInfo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || d.a.q0.n1.o.k.a.e(list) || d.a.q0.n1.o.k.a.e(this.f59961c)) {
            return;
        }
        Iterator<AdvertAppInfo> it = list.iterator();
        while (it.hasNext()) {
            AdvertAppInfo next = it.next();
            if (next != null) {
                e(next, d.a.d.e.m.b.d(next.X3, -1) - 1, false);
                it.remove();
            }
        }
        d dVar = this.f59965g;
        if (dVar != null) {
            dVar.onCallback(null);
        }
    }

    public void g(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, advertAppInfo) == null) {
            e(advertAppInfo, d.a.q0.n1.o.k.a.k(this.f59961c), true);
            d dVar = this.f59965g;
            if (dVar != null) {
                dVar.onCallback(null);
            }
        }
    }

    public boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            String str = (String) d.a.q0.n1.o.k.a.d(this.f59961c, i2);
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f59962d.d(str);
        }
        return invokeI.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f59962d.onDestroy();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f59966h = true;
            f(this.f59963e);
        }
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            String str = (String) d.a.q0.n1.o.k.a.d(this.f59961c, i2);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f59962d.i(str);
        }
    }

    public void l(@Nullable d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) && this.f59964f) {
            this.f59966h = false;
            this.f59965g = dVar;
            c cVar = new c();
            cVar.l = this.f59959a;
            cVar.m = this.f59960b;
            this.f59962d.e(cVar);
        }
    }

    public void m(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            this.f59967i = j - 1;
            this.j = i2;
        }
    }
}
