package d.a.q0.w2.h0;

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
import d.a.d.e.p.l;
import d.a.q0.w2.e;
import d.a.q0.w2.n;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b implements d.a.q0.w2.b0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f66656a;

    /* renamed from: b  reason: collision with root package name */
    public final int f66657b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66658c;

    /* renamed from: d  reason: collision with root package name */
    public final int f66659d;

    /* renamed from: e  reason: collision with root package name */
    public final int f66660e;

    /* renamed from: f  reason: collision with root package name */
    public final int f66661f;

    /* renamed from: g  reason: collision with root package name */
    public final int f66662g;

    /* renamed from: h  reason: collision with root package name */
    public final int f66663h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, AdvertAppInfo> f66664i;
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
        this.f66657b = d.a.q0.a.h().n();
        this.f66658c = d.a.q0.a.h().q();
        this.f66659d = d.a.q0.a.h().k();
        this.f66660e = d.a.q0.a.h().l() - 1;
        this.f66661f = d.a.q0.a.h().m();
        this.f66662g = d.a.q0.a.h().p();
        this.f66663h = d.a.q0.a.h().o();
        this.j = e.a("daily_show_count");
        this.f66664i = new HashMap();
        int[] p = l.p(TbadkCoreApplication.getInst());
        this.k = p[0];
        this.l = p[1];
        this.m = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds376);
        int r = d.a.q0.a.h().r();
        a aVar2 = new a(PlaceId.PIC_PAGE_BANNER, "PIC_PAGE_BANNER", aVar);
        this.f66656a = aVar2;
        aVar2.e(r);
        this.f66656a.f(true);
    }

    @Override // d.a.q0.w2.b0.a
    public AdvertAppInfo a(d.a.p0.b1.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            if (!cVar.j && !cVar.k) {
                int i2 = cVar.f52039c;
                String str = cVar.f52043g;
                int i3 = cVar.f52040d;
                int i4 = cVar.f52045i;
                float f2 = cVar.f52042f;
                int i5 = cVar.f52044h;
                p(i2, i3, i4, cVar);
                if (this.f66664i.containsKey(str)) {
                    return this.f66664i.get(str);
                }
                if (n(i2, i3) && o(i5, f2, cVar.f52041e)) {
                    AdvertAppInfo i6 = this.f66656a.i();
                    if (i6 != null) {
                        i6.b4 = "PIC_PAGE_BANNER";
                        i6.position = i2;
                        this.f66664i.put(str, i6);
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

    @Override // d.a.q0.w2.b0.a
    public n g(ViewStub viewStub, TbPageContext tbPageContext) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewStub, tbPageContext)) == null) ? new d.a.q0.w2.f0.d.a.c(viewStub, tbPageContext) : (n) invokeLL.objValue;
    }

    public final Map<String, String> m(d.a.p0.b1.c cVar) {
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

    public final boolean n(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            if (i2 >= this.f66660e && i2 > i3) {
                return i3 == 0 || i2 - i3 >= this.f66661f;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public final boolean o(int i2, float f2, float f3) {
        InterceptResult invokeCommon;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f66657b == 4) {
                return true;
            }
            if (f2 == 0.0f) {
                return false;
            }
            if (!(((float) this.k) / ((float) this.l) > f2)) {
                return ((int) (((((float) this.l) - f3) / 2.0f) - ((float) i2))) > this.m && ((i3 = this.f66657b) == 1 || i3 == 2);
            }
            int i4 = this.f66657b;
            return i4 == 3 || i4 == 1;
        }
        return invokeCommon.booleanValue;
    }

    @Override // d.a.q0.w2.b0.a
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f66656a.b();
        }
    }

    public final void p(int i2, int i3, int i4, d.a.p0.b1.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), cVar}) == null) || this.j >= this.f66663h) {
            return;
        }
        this.f66656a.h(this.f66659d);
        if (this.f66656a.j()) {
            return;
        }
        int i5 = i3 == 0 ? this.f66660e : this.f66661f + i3;
        if (i2 < i3 || i5 >= i4 || i2 < i5 - this.f66662g) {
            return;
        }
        this.f66656a.d(Math.min(this.f66663h - this.j, this.f66658c), m(cVar));
    }
}
