package d.a.q0.w2.a0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.adapter.PbAppLegoViewHolder;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.h3.h0.o;
import d.a.q0.w2.c0.j;
import d.a.q0.w2.q;
import d.a.q0.w2.s;
import d.a.q0.w2.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class f extends d.a.d.k.e.a<o, PbAppLegoViewHolder> implements s, d.a.q0.w2.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity m;
    public boolean n;
    public boolean o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public WeakReference<PbAppLegoViewHolder> s;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f66429a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f66429a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f66429a.k != null && this.f66429a.o) {
                int d2 = ((PbAppLegoViewHolder) this.f66429a.k).d();
                if (((PbAppLegoViewHolder) this.f66429a.k).c()) {
                    if (d2 == -1) {
                        ((PbAppLegoViewHolder) this.f66429a.k).b((int) TimeUnit.SECONDS.toSeconds(1L));
                    }
                } else if (d2 != -1) {
                    ((PbAppLegoViewHolder) this.f66429a.k).stopPlay();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f66430a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f66430a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f66430a.z0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f66431a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f66431a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f66431a.k != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 2) {
                ((PbAppLegoViewHolder) this.f66431a.k).stopPlay();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.n1.o.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AdvertAppInfo f66432a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f66433b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f66434c;

        public d(f fVar, AdvertAppInfo advertAppInfo, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, advertAppInfo, Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66432a = advertAppInfo;
            this.f66433b = i2;
            this.f66434c = str;
        }

        @Override // d.a.q0.n1.o.a
        public void a(int i2, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeIL(1048576, this, i2, hashMap) == null) || i2 == 0) {
                return;
            }
            if (x.p(i2)) {
                d.a.q0.w2.i0.d.g(this.f66432a, this.f66433b, hashMap, i2);
            } else {
                d.a.q0.w2.i0.d.o(this.f66432a, this.f66433b, this.f66434c, null, hashMap);
            }
            AdvertAppInfo advertAppInfo = this.f66432a;
            if (advertAppInfo.W3) {
                return;
            }
            d.a.q0.n1.o.h.c.h(d.a.q0.n1.o.h.c.e(advertAppInfo));
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.a.q0.n1.o.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f66435a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f66436b;

        public e(f fVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66436b = fVar;
            this.f66435a = str;
        }

        @Override // d.a.q0.n1.o.c
        public void a(AdvertAppInfo advertAppInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, advertAppInfo, i2) == null) {
                j.b(this.f66436b.m.getPageContext().getPageActivity(), advertAppInfo, i2, this.f66436b.o0(advertAppInfo, this.f66435a));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity.getPageContext().getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bdUniqueId};
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
        this.o = true;
        this.p = new a(this, 2004013);
        this.q = new b(this, 2004018);
        this.r = new c(this, 2004020);
        this.s = null;
        this.m = baseFragmentActivity;
        baseFragmentActivity.registerListener(this.p);
        this.m.registerListener(this.r);
        this.m.registerListener(this.q);
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder' to match base method */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ PbAppLegoViewHolder Q(ViewGroup viewGroup) {
        u0(viewGroup);
        throw null;
    }

    @Override // d.a.q0.w2.s
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.n = z;
        }
    }

    public final DownloadStaticsData o0(AdvertAppInfo advertAppInfo, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, advertAppInfo, str)) == null) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setDa_page(p0(advertAppInfo));
            downloadStaticsData.setFid(str);
            downloadStaticsData.setApk_name(advertAppInfo.j4);
            downloadStaticsData.setAdPosition(advertAppInfo.X3);
            downloadStaticsData.setExtensionInfo(advertAppInfo.Y3);
            return downloadStaticsData;
        }
        return (DownloadStaticsData) invokeLL.objValue;
    }

    @Override // d.a.q0.w2.o
    public void onDestroy() {
        V v;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (v = this.k) == 0) {
            return;
        }
        ((PbAppLegoViewHolder) v).e();
    }

    @Override // d.a.q0.w2.o
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            V v = this.k;
            if (v != 0) {
                ((PbAppLegoViewHolder) v).stopPlay();
            }
            this.o = false;
        }
    }

    @Override // d.a.q0.w2.o
    public void onResume() {
        V v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (v = this.k) != 0 && ((PbAppLegoViewHolder) v).c()) {
            if (((PbAppLegoViewHolder) this.k).d() == -1) {
                ((PbAppLegoViewHolder) this.k).b((int) TimeUnit.SECONDS.toSeconds(1L));
            }
            this.o = true;
        }
    }

    public final String p0(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, advertAppInfo)) == null) ? TextUtils.isEmpty(advertAppInfo.b4) ? "PB" : advertAppInfo.b4 : (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: r0 */
    public View I(int i2, View view, ViewGroup viewGroup, o oVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar})) == null) {
            if (oVar == null || oVar.F0() == null) {
                return null;
            }
            if (t0(view, oVar)) {
                PbAppLegoViewHolder R = R(viewGroup, oVar);
                this.k = R;
                if (R != null) {
                    view = R.a();
                }
            }
            View view2 = view;
            if (view2 != null) {
                view2 = X(i2, view2, viewGroup, oVar, (PbAppLegoViewHolder) view2.getTag());
                if (q.class.isAssignableFrom(view2.getClass())) {
                    ((PbAppLegoViewHolder) this.k).f(((q) view2).getVideoOrVrView());
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final boolean t0(View view, o oVar) {
        InterceptResult invokeLL;
        V v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view, oVar)) == null) {
            if (view == null || view.getTag() == null || (v = this.k) == 0 || !((PbAppLegoViewHolder) v).getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(((PbAppLegoViewHolder) this.k).getClass())) {
                return true;
            }
            AdvertAppInfo.ILegoAdvert F0 = oVar.F0();
            Object tag = view.getTag(R.id.tag_first);
            if (tag instanceof AdvertAppInfo.ILegoAdvert) {
                return !F0.isReusable((AdvertAppInfo.ILegoAdvert) tag);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public PbAppLegoViewHolder u0(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            throw new IllegalStateException("onCreateViewHolder(ViewGroup parent) unavailable.");
        }
        return (PbAppLegoViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: w0 */
    public PbAppLegoViewHolder R(ViewGroup viewGroup, o oVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, oVar)) == null) {
            View view = (View) d.a.q0.n1.o.b.h().a(this.m.getPageContext(), oVar.F0(), 4);
            if (view != null) {
                PbAppLegoViewHolder pbAppLegoViewHolder = new PbAppLegoViewHolder((d.a.q0.n1.o.l.e) view);
                pbAppLegoViewHolder.setIsRecyclable(false);
                return pbAppLegoViewHolder;
            }
            return null;
        }
        return (PbAppLegoViewHolder) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: x0 */
    public View X(int i2, View view, ViewGroup viewGroup, o oVar, PbAppLegoViewHolder pbAppLegoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), view, viewGroup, oVar, pbAppLegoViewHolder})) == null) {
            if (this.m == null) {
                return null;
            }
            if (oVar.F0() instanceof AdCard) {
                ((AdCard) oVar.F0()).isPBBanner = oVar.D0;
            }
            pbAppLegoViewHolder.setIsRecyclable(false);
            AdvertAppInfo.ILegoAdvert F0 = oVar.F0();
            view.setTag(R.id.tag_first, F0);
            this.m.getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
            this.m.getLayoutMode().j(view);
            d.a.p0.s.q.e.f(oVar);
            if (oVar.L0) {
                d.a.q0.q.e.a.i().k(d.a.q0.q.e.a.g(oVar.getAdvertAppInfo()));
            }
            AdvertAppInfo advertAppInfo = oVar.getAdvertAppInfo();
            if (advertAppInfo.a4 == null) {
                advertAppInfo.a4 = new d.a.p0.s.q.e();
            }
            d.a.p0.s.q.e eVar = advertAppInfo.a4;
            eVar.f53297b = oVar.I0;
            eVar.f53296a = oVar.E0();
            advertAppInfo.position = oVar.K0;
            advertAppInfo.W3 = oVar.L0;
            d.a.q0.n1.o.l.e eVar2 = (d.a.q0.n1.o.l.e) view;
            F0.setAdvertAppInfo(advertAppInfo);
            eVar2.setFromCDN(this.n);
            eVar2.h(F0);
            int i3 = oVar.I0;
            String str = oVar.E0;
            eVar2.setAfterClickSchemeListener(new d(this, advertAppInfo, i3, str));
            eVar2.setDownloadAppCallback(new e(this, str));
            WeakReference<PbAppLegoViewHolder> weakReference = this.s;
            if (weakReference == null || weakReference.get() != pbAppLegoViewHolder) {
                this.s = new WeakReference<>(pbAppLegoViewHolder);
            }
            z0();
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            WeakReference<PbAppLegoViewHolder> weakReference = this.s;
            PbAppLegoViewHolder pbAppLegoViewHolder = weakReference != null ? weakReference.get() : null;
            if (pbAppLegoViewHolder != null) {
                pbAppLegoViewHolder.g();
            }
        }
    }
}
