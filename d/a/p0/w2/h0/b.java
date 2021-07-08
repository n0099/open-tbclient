package d.a.p0.w2.h0;

import android.view.ViewStub;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.p0.w2.e;
import d.a.p0.w2.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b implements d.a.p0.w2.b0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f65981a;

    /* renamed from: b  reason: collision with root package name */
    public final int f65982b;

    /* renamed from: c  reason: collision with root package name */
    public final int f65983c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65984d;

    /* renamed from: e  reason: collision with root package name */
    public final int f65985e;

    /* renamed from: f  reason: collision with root package name */
    public final int f65986f;

    /* renamed from: g  reason: collision with root package name */
    public final int f65987g;

    /* renamed from: h  reason: collision with root package name */
    public final int f65988h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f65989i;
    public int j;
    public final int k;
    public final int l;
    public final int m;

    public b(IAdBaseAsyncController.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65982b = d.a.p0.a.h().n();
        this.f65983c = d.a.p0.a.h().q();
        this.f65984d = d.a.p0.a.h().k();
        this.f65985e = d.a.p0.a.h().l() - 1;
        this.f65986f = d.a.p0.a.h().m();
        this.f65987g = d.a.p0.a.h().p();
        this.f65988h = d.a.p0.a.h().o();
        this.j = e.a("daily_show_count");
        this.f65989i = new HashMap();
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        int r = d.a.p0.a.h().r();
        a aVar2 = new a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", aVar);
        this.f65981a = aVar2;
        aVar2.e(r);
        this.f65981a.f(true);
    }

    @Override // d.a.p0.w2.b0.a
    public AdvertAppInfo a(d.a.o0.z0.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (!cVar.j && !cVar.k) {
                int i2 = cVar.f53628c;
                String str = cVar.f53632g;
                int i3 = cVar.f53629d;
                int i4 = cVar.f53634i;
                float f2 = cVar.f53631f;
                int i5 = cVar.f53633h;
                o(i2, i3, i4, cVar);
                if (this.f65989i.containsKey(str)) {
                    return this.f65989i.get(str);
                }
                if (m(i2, i3) && n(i5, f2, cVar.f53630e)) {
                    AdvertAppInfo i6 = this.f65981a.i();
                    if (i6 != null) {
                        i6.V3 = "PIC_PAGE_BANNER";
                        i6.position = i2;
                        this.f65989i.put(str, i6);
                        int i7 = this.j + 1;
                        this.j = i7;
                        e.g("daily_show_count", i7);
                    }
                    return i6;
                }
            }
            return null;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // d.a.p0.w2.b0.a
    public n f(ViewStub viewStub, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewStub, tbPageContext)) == null) ? new d.a.p0.w2.f0.d.a.c(viewStub, tbPageContext) : (n) invokeLL.objValue;
    }

    public final Map<String, String> l(d.a.o0.z0.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("forum_id", cVar.l);
            hashMap.put("forum_name", cVar.m);
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean m(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            if (i2 >= this.f65985e && i2 > i3) {
                return i3 == 0 || i2 - i3 >= this.f65986f;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final boolean n(int i2, float f2, float f3) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f65982b == 4) {
                return true;
            }
            if (f2 == 0.0f) {
                return false;
            }
            if (!(((float) this.k) / ((float) this.l) > f2)) {
                return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f65982b) == 1 || i3 == 2);
            }
            int i4 = this.f65982b;
            return i4 == 3 || i4 == 1;
        }
        return invokeCommon.booleanValue;
    }

    public final void o(int i2, int i3, int i4, d.a.o0.z0.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), cVar}) == null) || this.j >= this.f65988h) {
            return;
        }
        this.f65981a.h(this.f65984d);
        if (this.f65981a.j()) {
            return;
        }
        int i5 = i3 == 0 ? this.f65985e : this.f65986f + i3;
        if (i2 < i3 || i5 >= i4 || i2 < i5 - this.f65987g) {
            return;
        }
        this.f65981a.d(Math.min(this.f65988h - this.j, this.f65983c), l(cVar));
    }

    @Override // d.a.p0.w2.b0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f65981a.b();
        }
    }
}
