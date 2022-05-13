package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import com.repackage.p79;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class n79 implements p79.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m79 a;
    public b b;
    public Thread c;
    public List<p79> d;
    public int e;
    public int f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n79 a;

        public a(n79 n79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n79Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                n79 n79Var = this.a;
                if (n79Var.j(n79Var.a)) {
                    if (ab9.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((p79) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                n79 n79Var2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                n79Var2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(l79 l79Var);
    }

    public n79(m79 m79Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m79Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = m79Var;
        this.d = new ArrayList();
    }

    @Override // com.repackage.p79.a
    public void a(p79 p79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, p79Var) == null) {
            l();
        }
    }

    @Override // com.repackage.p79.a
    public void b(p79 p79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p79Var) == null) {
            int k = this.e + p79Var.k();
            this.e = k;
            n(k);
            if (p79Var == null || !p79Var.m()) {
                return;
            }
            l79 k2 = k(p79Var.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.repackage.p79.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.repackage.p79.a
    public void d(String str, p79 p79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, p79Var) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!ab9.e(this.d)) {
                for (p79 p79Var : this.d) {
                    p79Var.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(m79 m79Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, m79Var)) == null) {
            if (m79Var == null || ab9.e(m79Var.c())) {
                return false;
            }
            List<o79> c = m79Var.c();
            l79 l79Var = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (u79.o(c.get(i2).b())) {
                    z = true;
                }
                if (!ab9.e(c.get(i2).a())) {
                    for (k79 k79Var : c.get(i2).a()) {
                        if (k79Var != null) {
                            if (k79Var.c()) {
                                if (l79Var == null) {
                                    l79Var = k79Var.a();
                                }
                                if (l79Var != null) {
                                    int k = l79Var.k(k79Var.a());
                                    z2 = ((l79.g & k) == 0 && (l79.i & k) == 0 && (k & l79.h) == 0) ? false : true;
                                }
                                if (k79Var.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(k79Var.a().f())) {
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
                r79 r79Var = new r79();
                r79Var.c(z2 ? 50 : 90);
                r79Var.e(this);
                this.d.add(r79Var);
                q79 q79Var = new q79();
                q79Var.c(z2 ? 50 : 10);
                q79Var.e(this);
                this.d.add(q79Var);
                r79Var.f(q79Var);
            } else {
                q79 q79Var2 = new q79();
                q79Var2.c(100);
                q79Var2.e(this);
                this.d.add(q79Var2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final l79 k(m79 m79Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, m79Var)) == null) {
            if (m79Var != null && ab9.b(m79Var.c()) == 1 && ab9.b(m79Var.c().get(0).a()) == 1) {
                k79 k79Var = m79Var.c().get(0).a().get(0);
                if (k79Var.b() == null || k79Var.b().isNeedEdit() || !k79Var.c()) {
                    return null;
                }
                return k79Var.a();
            }
            return null;
        }
        return (l79) invokeL.objValue;
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

    public final void o(l79 l79Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, l79Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(l79Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || ab9.e(this.d)) {
            return;
        }
        for (p79 p79Var : this.d) {
            p79Var.h();
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
            l79 k = k(this.a);
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
