package d.a.p0.w2.a0;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.FrsAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.u0.k;
import d.a.p0.w2.c0.h;
import d.a.p0.w2.q;
import d.a.p0.w2.t;
import d.a.p0.w2.x;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class d extends k<AdvertAppInfo, FrsAppLegoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo.ILegoAdvert x;
    public t y;

    /* loaded from: classes8.dex */
    public class a implements d.a.p0.n1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f65766a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f65767b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f65768c;

        public a(d dVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, advertAppInfo, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65766a = advertAppInfo;
            this.f65767b = i2;
            this.f65768c = str;
        }

        @Override // d.a.p0.n1.o.a
        public void a(int i2, HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) {
                if (x.p(i2)) {
                    d.a.p0.w2.i0.d.g(this.f65766a, this.f65767b, hashMap, i2);
                } else {
                    d.a.p0.w2.i0.d.o(this.f65766a, this.f65767b, this.f65768c, null, hashMap);
                }
                d.a.p0.n1.o.h.c.h(d.a.p0.n1.o.h.c.e(this.f65766a));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.p0.n1.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f65769a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f65770b;

        public b(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65770b = dVar;
            this.f65769a = str;
        }

        @Override // d.a.p0.n1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i2) == null) {
                h.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo, i2, this.f65770b.w0(advertAppInfo, this.f65769a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(t tVar, BdUniqueId bdUniqueId) {
        super(tVar.m(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = null;
        this.y = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: A0 */
    public FrsAppLegoViewHolder R(ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeLL;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, viewGroup, advertAppInfo)) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.T3) == null) {
                return null;
            }
            this.x = iLegoAdvert;
            return Q(viewGroup);
        }
        return (FrsAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.p0.u0.k, d.a.c.k.e.a
    /* renamed from: B0 */
    public View X(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo, FrsAppLegoViewHolder frsAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), view, viewGroup, advertAppInfo, frsAppLegoViewHolder})) == null) {
            super.X(i2, view, viewGroup, advertAppInfo, frsAppLegoViewHolder);
            if (this.y == null) {
                return null;
            }
            AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.T3;
            this.x = iLegoAdvert;
            if (iLegoAdvert == null || view == null) {
                return null;
            }
            this.o.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.o.getLayoutMode().j(view);
            d.a.o0.r.q.e.b(advertAppInfo);
            d.a.p0.n1.o.l.e eVar = (d.a.p0.n1.o.l.e) view;
            eVar.setFromCDN(this.m);
            eVar.h(this.x);
            String A = this.y.A();
            int w0 = this.y.w0();
            this.y.O();
            eVar.setAfterClickSchemeListener(new a(this, advertAppInfo, w0, A));
            eVar.setDownloadAppCallback(new b(this, A));
            if (q.class.isAssignableFrom(view.getClass())) {
                frsAppLegoViewHolder.c(((q) view).getVideoOrVrView());
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // d.a.p0.u0.k
    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            V v = this.k;
            if (v != 0) {
                ((FrsAppLegoViewHolder) v).b();
            }
            super.i0();
        }
    }

    public final DownloadStaticsData w0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(advertAppInfo.V3);
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.d4);
            downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
            downloadStaticsData.setExtensionInfo(advertAppInfo.S3);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: x0 */
    public View I(int i2, View view, ViewGroup viewGroup, AdvertAppInfo advertAppInfo) {
        InterceptResult invokeCommon;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), view, viewGroup, advertAppInfo})) == null) {
            if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.T3) == null) {
                return null;
            }
            this.x = iLegoAdvert;
            if (y0(view)) {
                FrsAppLegoViewHolder Q = Q(viewGroup);
                this.k = Q;
                if (Q == null) {
                    return null;
                }
                view = Q.a();
            }
            View view2 = view;
            return X(i2, view2, viewGroup, advertAppInfo, (FrsAppLegoViewHolder) view2.getTag());
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean y0(View view) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view)) == null) {
            if (view == null || view.getTag() == null || (v = this.k) == 0 || this.x == null || !((FrsAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((FrsAppLegoViewHolder) this.k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.x.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: z0 */
    public FrsAppLegoViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, viewGroup)) == null) {
            if (this.x == null || (view = (View) d.a.p0.n1.o.b.h().a(this.o, this.x, 1)) == null) {
                return null;
            }
            view.setTag(R.id.tag_first, this.x);
            return new FrsAppLegoViewHolder((d.a.p0.n1.o.l.e) view);
        }
        return (FrsAppLegoViewHolder) invokeL.objValue;
    }
}
