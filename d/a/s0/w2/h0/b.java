package d.a.s0.w2.h0;

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
import d.a.s0.w2.d;
import d.a.s0.w2.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class b implements d.a.s0.w2.b0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f69204a;

    /* renamed from: b  reason: collision with root package name */
    public final int f69205b;

    /* renamed from: c  reason: collision with root package name */
    public final int f69206c;

    /* renamed from: d  reason: collision with root package name */
    public final int f69207d;

    /* renamed from: e  reason: collision with root package name */
    public final int f69208e;

    /* renamed from: f  reason: collision with root package name */
    public final int f69209f;

    /* renamed from: g  reason: collision with root package name */
    public final int f69210g;

    /* renamed from: h  reason: collision with root package name */
    public final int f69211h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f69212i;
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
        this.f69205b = d.a.s0.a.h().m();
        this.f69206c = d.a.s0.a.h().p();
        this.f69207d = d.a.s0.a.h().j();
        this.f69208e = d.a.s0.a.h().k() - 1;
        this.f69209f = d.a.s0.a.h().l();
        this.f69210g = d.a.s0.a.h().o();
        this.f69211h = d.a.s0.a.h().n();
        this.j = d.a("daily_show_count");
        this.f69212i = new HashMap();
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        int q = d.a.s0.a.h().q();
        a aVar2 = new a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", null);
        this.f69204a = aVar2;
        aVar2.e(q);
        this.f69204a.f(true);
    }

    @Override // d.a.s0.w2.b0.a
    public AdvertAppInfo a(d.a.r0.z0.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (!cVar.j && !cVar.k) {
                int i2 = cVar.f56907c;
                String str = cVar.f56911g;
                int i3 = cVar.f56908d;
                int i4 = cVar.f56913i;
                float f2 = cVar.f56910f;
                int i5 = cVar.f56912h;
                f(i2, i3, i4, cVar);
                if (this.f69212i.containsKey(str)) {
                    return this.f69212i.get(str);
                }
                if (d(i2, i3) && e(i5, f2, cVar.f56909e)) {
                    AdvertAppInfo i6 = this.f69204a.i();
                    if (i6 != null) {
                        i6.V3 = "PIC_PAGE_BANNER";
                        i6.position = i2;
                        this.f69212i.put(str, i6);
                        int i7 = this.j + 1;
                        this.j = i7;
                        d.g("daily_show_count", i7);
                    }
                    return i6;
                }
            }
            return null;
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    @Override // d.a.s0.w2.b0.a
    public n b(ViewStub viewStub, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewStub, tbPageContext)) == null) ? new d.a.s0.w2.f0.d.a.c(viewStub, tbPageContext) : (n) invokeLL.objValue;
    }

    public final Map<String, String> c(d.a.r0.z0.c cVar) {
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

    public final boolean d(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            if (i2 >= this.f69208e && i2 > i3) {
                return i3 == 0 || i2 - i3 >= this.f69209f;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final boolean e(int i2, float f2, float f3) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f69205b == 4) {
                return true;
            }
            if (f2 == 0.0f) {
                return false;
            }
            if (!(((float) this.k) / ((float) this.l) > f2)) {
                return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f69205b) == 1 || i3 == 2);
            }
            int i4 = this.f69205b;
            return i4 == 3 || i4 == 1;
        }
        return invokeCommon.booleanValue;
    }

    public final void f(int i2, int i3, int i4, d.a.r0.z0.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), cVar}) == null) || this.j >= this.f69211h) {
            return;
        }
        this.f69204a.h(this.f69207d);
        if (this.f69204a.j()) {
            return;
        }
        int i5 = i3 == 0 ? this.f69208e : this.f69209f + i3;
        if (i2 < i3 || i5 >= i4 || i2 < i5 - this.f69210g) {
            return;
        }
        this.f69204a.d(Math.min(this.f69211h - this.j, this.f69206c), c(cVar));
    }

    @Override // d.a.s0.w2.b0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f69204a.b();
        }
    }
}
