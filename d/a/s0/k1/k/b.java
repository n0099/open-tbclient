package d.a.s0.k1.k;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w2.k;
import d.a.s0.w2.w;
/* loaded from: classes9.dex */
public class b implements ImagePagerAdapter.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f62580a;

    /* renamed from: b  reason: collision with root package name */
    public String f62581b;

    /* renamed from: c  reason: collision with root package name */
    public String f62582c;

    /* renamed from: d  reason: collision with root package name */
    public int f62583d;

    /* renamed from: e  reason: collision with root package name */
    public AdvertAppInfo f62584e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f62585f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f62586g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView.h f62587h;

    /* renamed from: i  reason: collision with root package name */
    public k f62588i;

    public b(boolean z, boolean z2, TbPageContext<?> tbPageContext, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), tbPageContext, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62580a = false;
        this.f62583d = 0;
        this.f62586g = false;
        this.f62580a = z;
        this.f62586g = z2;
        this.f62585f = tbPageContext;
        this.f62581b = str;
        this.f62582c = str2;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i2)) == null) {
            if (this.f62585f == null || this.f62584e == null || !b(i2)) {
                return null;
            }
            k e2 = w.p().e(this.f62585f, this.f62584e.T3, 99, this.f62580a, this.f62581b, this.f62582c);
            this.f62588i = e2;
            if (e2 == null) {
                return null;
            }
            e2.a(this.f62587h);
            View b2 = this.f62588i.b();
            viewGroup.addView(b2);
            return b2;
        }
        return (View) invokeLI.objValue;
    }

    public final boolean b(int i2) {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? d() && (i3 = this.f62583d) != 0 && i2 == i3 : invokeI.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f62584e;
            if (advertAppInfo != null) {
                return advertAppInfo.L3;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.f62586g || (advertAppInfo = this.f62584e) == null) {
                return false;
            }
            return advertAppInfo.v4() || this.f62584e.t4();
        }
        return invokeV.booleanValue;
    }

    public void e() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (kVar = this.f62588i) == null) {
            return;
        }
        kVar.onAdShow();
    }

    public void f() {
        k kVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (kVar = this.f62588i) == null) {
            return;
        }
        kVar.onDestroy();
    }

    public void g(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            this.f62587h = hVar;
        }
    }

    public void h(AdvertAppInfo advertAppInfo, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, advertAppInfo, i2) == null) {
            this.f62584e = advertAppInfo;
            advertAppInfo.V3 = "PIC_PAGE";
            this.f62583d = i2;
        }
    }
}
