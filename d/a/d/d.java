package d.a.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.afd.ParseError;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.n1.o.h.b;
import java.util.Map;
/* loaded from: classes8.dex */
public class d extends BaseCardInfo implements d.a.s0.n1.o.l.i, d.a.s0.n1.o.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public e f45175e;

    /* renamed from: f  reason: collision with root package name */
    public ICardInfo f45176f;

    /* renamed from: g  reason: collision with root package name */
    public h f45177g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f45178h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f45179i;
    public boolean j;
    public AdvertAppInfo k;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = false;
        this.f45178h = BdUniqueId.gen();
    }

    public static d c(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, hVar)) == null) {
            d dVar = new d();
            dVar.f45177g = hVar;
            return dVar;
        }
        return (d) invokeL.objValue;
    }

    public e d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45175e : (e) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h hVar = this.f45177g;
            if (hVar != null) {
                return hVar.e();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.s0.n1.o.h.b
    public b.a getParallelCharge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ICardInfo iCardInfo = this.f45176f;
            if (iCardInfo == null || !(iCardInfo instanceof d.a.s0.n1.o.h.b)) {
                return null;
            }
            return ((d.a.s0.n1.o.h.b) iCardInfo).getParallelCharge();
        }
        return (b.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (h() != null) {
                return b.f45170b;
            }
            return b.f45169a;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public ICardInfo h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45176f : (ICardInfo) invokeV.objValue;
    }

    public BdUniqueId j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f45178h : (BdUniqueId) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!this.j) {
                d.a.s0.w2.i0.e.b().d(d.a.s0.w2.i0.g.o(this, ParseError.ERROR_SMOOTH_SCROLL));
                return;
            }
            d.a.r0.r.q.e.h(this);
        }
    }

    public void p(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            this.f45175e = eVar;
            ICardInfo iCardInfo = eVar != null ? eVar.f45182c : null;
            this.f45176f = iCardInfo;
            if (iCardInfo instanceof i) {
                ((i) iCardInfo).setAdFacadeData(this);
            }
            this.j = true;
        }
    }

    public AdvertAppInfo q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.k == null) {
                this.k = new AdvertAppInfo();
                h hVar = this.f45177g;
                if (hVar != null) {
                    Map<String, String> d2 = hVar.d();
                    this.k.R3 = String.valueOf(this.f45177g.b());
                    this.k.A = d2 != null ? d2.get("thread_id") : "";
                    this.k.l3(d2 != null ? Long.valueOf(d2.get("forum_id")).longValue() : 0L);
                }
                AdvertAppInfo advertAppInfo = this.k;
                e eVar = this.f45175e;
                advertAppInfo.S3 = eVar != null ? eVar.f45181b : "";
                this.k.V3 = "VIDEO_LIST";
            }
            return this.k;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    @Override // d.a.s0.n1.o.l.i
    public void setAutoPlay(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (h() instanceof d.a.s0.n1.o.l.i)) {
            ((d.a.s0.n1.o.l.i) h()).setAutoPlay(z);
        }
    }

    @Override // d.a.s0.n1.o.l.i
    public void setWaitConfirm(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (h() instanceof d.a.s0.n1.o.l.i)) {
            ((d.a.s0.n1.o.l.i) h()).setWaitConfirm(z);
        }
    }
}
