package d.a.y0.h;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.y0.h.f.a;
import d.a.y0.t.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d implements a.InterfaceC1967a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f71050a;

    /* renamed from: b  reason: collision with root package name */
    public b f71051b;

    /* renamed from: c  reason: collision with root package name */
    public Thread f71052c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.y0.h.f.a> f71053d;

    /* renamed from: e  reason: collision with root package name */
    public int f71054e;

    /* renamed from: f  reason: collision with root package name */
    public int f71055f;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f71056e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71056e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d dVar = this.f71056e;
                if (dVar.j(dVar.f71050a)) {
                    if (h.e(this.f71056e.f71053d)) {
                        this.f71056e.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((d.a.y0.h.f.a) this.f71056e.f71053d.get(0)).d(this.f71056e.f71050a);
                        return;
                    }
                }
                d dVar2 = this.f71056e;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.f71056e.f71050a == null);
                dVar2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i2);

        void onAudioMixtureSuccess(d.a.y0.h.b bVar);
    }

    public d(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71050a = cVar;
        this.f71053d = new ArrayList();
    }

    @Override // d.a.y0.h.f.a.InterfaceC1967a
    public void a(d.a.y0.h.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            l();
        }
    }

    @Override // d.a.y0.h.f.a.InterfaceC1967a
    public void b(d.a.y0.h.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            int k = this.f71054e + aVar.k();
            this.f71054e = k;
            n(k);
            if (aVar == null || !aVar.m()) {
                return;
            }
            d.a.y0.h.b k2 = k(aVar.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // d.a.y0.h.f.a.InterfaceC1967a
    public void c(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || (i4 = (int) (this.f71054e + (((i2 * 1.0f) / 100.0f) * i3))) <= this.f71055f) {
            return;
        }
        n(i4);
        this.f71055f = i4;
    }

    @Override // d.a.y0.h.f.a.InterfaceC1967a
    public void d(String str, d.a.y0.h.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, aVar) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!h.e(this.f71053d)) {
                for (d.a.y0.h.f.a aVar : this.f71053d) {
                    aVar.b();
                }
            }
            Thread thread = this.f71052c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, cVar)) == null) {
            if (cVar == null || h.e(cVar.c())) {
                return false;
            }
            List<e> c2 = cVar.c();
            d.a.y0.h.b bVar = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i2 = 0;
            for (int i3 = 0; i3 < c2.size(); i3++) {
                if (d.a.y0.i.c.k(c2.get(i3).b())) {
                    z = true;
                }
                if (!h.e(c2.get(i3).a())) {
                    for (d.a.y0.h.a aVar : c2.get(i3).a()) {
                        if (aVar != null) {
                            if (aVar.c()) {
                                if (bVar == null) {
                                    bVar = aVar.a();
                                }
                                if (bVar != null) {
                                    int k = bVar.k(aVar.a());
                                    z2 = ((d.a.y0.h.b.f71036g & k) == 0 && (d.a.y0.h.b.f71038i & k) == 0 && (k & d.a.y0.h.b.f71037h) == 0) ? false : true;
                                }
                                if (aVar.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if ("audio/raw".equals(aVar.a().f())) {
                                    z = true;
                                }
                                z3 = true;
                            }
                            i2++;
                            if (i2 > 1) {
                                z2 = true;
                            }
                            if (z2 && z && z3) {
                                break;
                            }
                        }
                    }
                }
                if (z2 && z && z3) {
                    break;
                }
            }
            if (z) {
                d.a.y0.h.f.c cVar2 = new d.a.y0.h.f.c();
                cVar2.c(z2 ? 50 : 90);
                cVar2.e(this);
                this.f71053d.add(cVar2);
                d.a.y0.h.f.b bVar2 = new d.a.y0.h.f.b();
                bVar2.c(z2 ? 50 : 10);
                bVar2.e(this);
                this.f71053d.add(bVar2);
                cVar2.f(bVar2);
            } else {
                d.a.y0.h.f.b bVar3 = new d.a.y0.h.f.b();
                bVar3.c(100);
                bVar3.e(this);
                this.f71053d.add(bVar3);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final d.a.y0.h.b k(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cVar)) == null) {
            if (cVar != null && h.b(cVar.c()) == 1 && h.b(cVar.c().get(0).a()) == 1) {
                d.a.y0.h.a aVar = cVar.c().get(0).a().get(0);
                if (aVar.b() == null || aVar.b().isNeedEdit() || !aVar.c()) {
                    return null;
                }
                return aVar.a();
            }
            return null;
        }
        return (d.a.y0.h.b) invokeL.objValue;
    }

    public final void l() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bVar = this.f71051b) == null) {
            return;
        }
        bVar.onAudioMixtureCancel();
    }

    public final void m(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (bVar = this.f71051b) == null) {
            return;
        }
        bVar.onAudioMixtureFail(str);
    }

    public final void n(int i2) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (bVar = this.f71051b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(i2);
    }

    public final void o(d.a.y0.h.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, bVar) == null) || (bVar2 = this.f71051b) == null) {
            return;
        }
        bVar2.onAudioMixtureProgress(100);
        this.f71051b.onAudioMixtureSuccess(bVar);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || h.e(this.f71053d)) {
            return;
        }
        for (d.a.y0.h.f.a aVar : this.f71053d) {
            aVar.h();
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.f71051b = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f71053d.clear();
            this.f71054e = 0;
            this.f71055f = 0;
            d.a.y0.h.b k = k(this.f71050a);
            if (k != null && k.i()) {
                o(k);
                return;
            }
            Thread thread = this.f71052c;
            if (thread != null) {
                thread.interrupt();
                this.f71052c = null;
            }
            Thread thread2 = new Thread(new a(this));
            this.f71052c = thread2;
            thread2.start();
        }
    }
}
