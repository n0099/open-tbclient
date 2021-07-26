package d.a.q0.w2.a0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.CardAppLegoViewHolder;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.w2.c0.j;
import d.a.q0.w2.o;
import d.a.q0.w2.q;
import d.a.q0.w2.s;
import d.a.q0.w2.x;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class b extends d.a.d.k.e.a<d.a.q0.a0.e0.d, CardAppLegoViewHolder> implements o, s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public int n;
    public boolean o;
    public AdvertAppInfo.ILegoAdvert p;
    public Runnable q;
    public CustomMessageListener r;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.n1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f66417a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f66418b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f66419c;

        public a(b bVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, advertAppInfo, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66417a = advertAppInfo;
            this.f66418b = i2;
            this.f66419c = str;
        }

        @Override // d.a.q0.n1.o.a
        public void a(int i2, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) || i2 == 0) {
                return;
            }
            if (x.p(i2)) {
                d.a.q0.w2.i0.d.g(this.f66417a, this.f66418b, hashMap, i2);
            } else {
                d.a.q0.w2.i0.d.o(this.f66417a, this.f66418b, this.f66419c, null, hashMap);
            }
            d.a.q0.n1.o.h.c.h(d.a.q0.n1.o.h.c.e(this.f66417a));
        }
    }

    /* renamed from: d.a.q0.w2.a0.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1830b implements d.a.q0.n1.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f66420a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f66421b;

        public C1830b(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66421b = bVar;
            this.f66420a = str;
        }

        @Override // d.a.q0.n1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i2) == null) {
                j.b(this.f66421b.m.getPageActivity(), advertAppInfo, i2, this.f66421b.o0(advertAppInfo, this.f66420a));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f66422e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66422e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((CardAppLegoViewHolder) this.f66422e.k).b((int) TimeUnit.SECONDS.toSeconds(1L));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f66423a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66423a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.f66423a.k == null) {
                return;
            }
            if (!(customResponsedMessage.getData() instanceof Boolean)) {
                ((CardAppLegoViewHolder) this.f66423a.k).stopPlay();
            } else if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                ((CardAppLegoViewHolder) this.f66423a.k).stopPlay();
            } else {
                int d2 = ((CardAppLegoViewHolder) this.f66423a.k).d();
                if (!((CardAppLegoViewHolder) this.f66423a.k).c()) {
                    if (d2 != -1) {
                        ((CardAppLegoViewHolder) this.f66423a.k).stopPlay();
                    }
                } else if (d2 == -1) {
                    d.a.d.e.m.e.a().removeCallbacks(this.f66423a.q);
                    d.a.d.e.m.e.a().postDelayed(this.f66423a.q, 500L);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = 3;
        this.o = false;
        this.p = null;
        this.q = new c(this);
        this.r = new d(this, 2921517);
        this.m = tbPageContext;
        if ((tbPageContext.getPageActivity() instanceof BaseFragmentActivity) && TextUtils.equals(str, "CONCERN")) {
            if (bdUniqueId == AdvertAppInfo.r4 || bdUniqueId == AdvertAppInfo.t4) {
                MessageManager.getInstance().registerListener(this.r);
            }
        }
    }

    @Override // d.a.q0.w2.s
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.o = z;
        }
    }

    public final DownloadStaticsData o0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(advertAppInfo.b4);
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.j4);
            downloadStaticsData.setAdPosition(String.valueOf(advertAppInfo.position));
            downloadStaticsData.setExtensionInfo(advertAppInfo.Y3);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    @Override // d.a.q0.w2.o
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    @Override // d.a.q0.w2.o
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // d.a.q0.w2.o
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: p0 */
    public View I(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.d dVar) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar})) == null) {
            if (dVar == null || (advertAppInfo = dVar.f54343e) == null || (iLegoAdvert = advertAppInfo.Z3) == null) {
                return null;
            }
            this.p = iLegoAdvert;
            if (r0(view)) {
                CardAppLegoViewHolder Q = Q(viewGroup);
                this.k = Q;
                if (Q != null) {
                    view = Q.a();
                }
            }
            View view2 = view;
            if (view2 != null) {
                view2 = X(i2, view2, viewGroup, dVar, (CardAppLegoViewHolder) view2.getTag());
                if (q.class.isAssignableFrom(view2.getClass())) {
                    ((CardAppLegoViewHolder) this.k).e(((q) view2).getVideoOrVrView());
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean r0(View view) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            if (view == null || view.getTag() == null || (v = this.k) == 0 || this.p == null || !((CardAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((CardAppLegoViewHolder) this.k).getClass()) || !(view.getTag(R.id.tag_first) instanceof AdvertAppInfo.ILegoAdvert)) {
                return true;
            }
            return !this.p.isReusable((AdvertAppInfo.ILegoAdvert) view.getTag(R.id.tag_first));
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: t0 */
    public CardAppLegoViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            if (this.p == null || (view = (View) d.a.q0.n1.o.b.h().a(this.m, this.p, 2)) == null) {
                return null;
            }
            view.setTag(R.id.tag_first, this.p);
            return new CardAppLegoViewHolder((d.a.q0.n1.o.l.e) view);
        }
        return (CardAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: u0 */
    public CardAppLegoViewHolder R(ViewGroup viewGroup, d.a.q0.a0.e0.d dVar) {
        InterceptResult invokeLL;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, viewGroup, dVar)) == null) {
            if (dVar == null || (advertAppInfo = dVar.f54343e) == null || (iLegoAdvert = advertAppInfo.Z3) == null) {
                return null;
            }
            this.p = iLegoAdvert;
            return Q(viewGroup);
        }
        return (CardAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: w0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.a0.e0.d dVar, CardAppLegoViewHolder cardAppLegoViewHolder) {
        InterceptResult invokeCommon;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, cardAppLegoViewHolder})) == null) {
            if (this.m != null && dVar != null && (advertAppInfo = dVar.f54343e) != null) {
                AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.Z3;
                this.p = iLegoAdvert;
                if (iLegoAdvert != null && view != null) {
                    if (this.k == 0) {
                        this.k = cardAppLegoViewHolder;
                    }
                    d.a.p0.s.q.e.d(dVar);
                    this.m.getLayoutMode().k(this.n == 1);
                    this.m.getLayoutMode().j(view);
                    AdvertAppInfo c2 = dVar.c();
                    d.a.q0.n1.o.l.e eVar = (d.a.q0.n1.o.l.e) view;
                    this.p.setAdvertAppInfo(c2);
                    eVar.setFromCDN(this.o);
                    eVar.h(this.p);
                    int i3 = dVar.f54345g;
                    String str = dVar.f54344f;
                    eVar.setAfterClickSchemeListener(new a(this, c2, i3, str));
                    eVar.setDownloadAppCallback(new C1830b(this, str));
                    if (q.class.isAssignableFrom(view.getClass())) {
                        cardAppLegoViewHolder.e(((q) view).getVideoOrVrView());
                    }
                    return view;
                }
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }
}
