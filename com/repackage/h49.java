package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import com.repackage.j49;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class h49 implements j49.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g49 a;
    public b b;
    public Thread c;
    public List<j49> d;
    public int e;
    public int f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h49 a;

        public a(h49 h49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h49Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h49 h49Var = this.a;
                if (h49Var.j(h49Var.a)) {
                    if (u79.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((j49) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                h49 h49Var2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                h49Var2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(f49 f49Var);
    }

    public h49(g49 g49Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g49Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = g49Var;
        this.d = new ArrayList();
    }

    @Override // com.repackage.j49.a
    public void a(j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, j49Var) == null) {
            l();
        }
    }

    @Override // com.repackage.j49.a
    public void b(j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j49Var) == null) {
            int k = this.e + j49Var.k();
            this.e = k;
            n(k);
            if (j49Var == null || !j49Var.m()) {
                return;
            }
            f49 k2 = k(j49Var.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.repackage.j49.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.repackage.j49.a
    public void d(String str, j49 j49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, j49Var) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!u79.e(this.d)) {
                for (j49 j49Var : this.d) {
                    j49Var.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(g49 g49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g49Var)) == null) {
            if (g49Var == null || u79.e(g49Var.c())) {
                return false;
            }
            List<i49> c = g49Var.c();
            f49 f49Var = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (o49.o(c.get(i2).b())) {
                    z = true;
                }
                if (!u79.e(c.get(i2).a())) {
                    for (e49 e49Var : c.get(i2).a()) {
                        if (e49Var != null) {
                            if (e49Var.c()) {
                                if (f49Var == null) {
                                    f49Var = e49Var.a();
                                }
                                if (f49Var != null) {
                                    int k = f49Var.k(e49Var.a());
                                    z2 = ((f49.g & k) == 0 && (f49.i & k) == 0 && (k & f49.h) == 0) ? false : true;
                                }
                                if (e49Var.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(e49Var.a().f())) {
                                    z = true;
                                }
                                z3 = true;
                            }
                            i++;
                            if (i > 1) {
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
                l49 l49Var = new l49();
                l49Var.c(z2 ? 50 : 90);
                l49Var.e(this);
                this.d.add(l49Var);
                k49 k49Var = new k49();
                k49Var.c(z2 ? 50 : 10);
                k49Var.e(this);
                this.d.add(k49Var);
                l49Var.f(k49Var);
            } else {
                k49 k49Var2 = new k49();
                k49Var2.c(100);
                k49Var2.e(this);
                this.d.add(k49Var2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final f49 k(g49 g49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, g49Var)) == null) {
            if (g49Var != null && u79.b(g49Var.c()) == 1 && u79.b(g49Var.c().get(0).a()) == 1) {
                e49 e49Var = g49Var.c().get(0).a().get(0);
                if (e49Var.b() == null || e49Var.b().isNeedEdit() || !e49Var.c()) {
                    return null;
                }
                return e49Var.a();
            }
            return null;
        }
        return (f49) invokeL.objValue;
    }

    public final void l() {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureCancel();
    }

    public final void m(String str) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureFail(str);
    }

    public final void n(int i) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(i);
    }

    public final void o(f49 f49Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, f49Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(f49Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || u79.e(this.d)) {
            return;
        }
        for (j49 j49Var : this.d) {
            j49Var.h();
        }
    }

    public void q(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.d.clear();
            this.e = 0;
            this.f = 0;
            f49 k = k(this.a);
            if (k != null && k.i()) {
                o(k);
                return;
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
                this.c = null;
            }
            Thread thread2 = new Thread(new a(this));
            this.c = thread2;
            thread2.start();
        }
    }
}
