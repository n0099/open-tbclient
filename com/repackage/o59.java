package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import com.repackage.q59;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class o59 implements q59.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public n59 a;
    public b b;
    public Thread c;
    public List<q59> d;
    public int e;
    public int f;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o59 a;

        public a(o59 o59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = o59Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o59 o59Var = this.a;
                if (o59Var.j(o59Var.a)) {
                    if (b99.e(this.a.d)) {
                        this.a.m(" start mix chains error:mMixtureChains empty ");
                        return;
                    } else {
                        ((q59) this.a.d.get(0)).d(this.a.a);
                        return;
                    }
                }
                o59 o59Var2 = this.a;
                StringBuilder sb = new StringBuilder();
                sb.append(" start mix chains error:initChainConfig ");
                sb.append(this.a.a == null);
                o59Var2.m(sb.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onAudioMixtureCancel();

        void onAudioMixtureFail(String str);

        void onAudioMixtureProgress(int i);

        void onAudioMixtureSuccess(m59 m59Var);
    }

    public o59(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n59Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = n59Var;
        this.d = new ArrayList();
    }

    @Override // com.repackage.q59.a
    public void a(q59 q59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q59Var) == null) {
            l();
        }
    }

    @Override // com.repackage.q59.a
    public void b(q59 q59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q59Var) == null) {
            int k = this.e + q59Var.k();
            this.e = k;
            n(k);
            if (q59Var == null || !q59Var.m()) {
                return;
            }
            m59 k2 = k(q59Var.n());
            if (k2 != null) {
                o(k2);
            } else {
                m("onChainFinished result error");
            }
        }
    }

    @Override // com.repackage.q59.a
    public void c(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || (i3 = (int) (this.e + (((i * 1.0f) / 100.0f) * i2))) <= this.f) {
            return;
        }
        n(i3);
        this.f = i3;
    }

    @Override // com.repackage.q59.a
    public void d(String str, q59 q59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, q59Var) == null) {
            m(str);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!b99.e(this.d)) {
                for (q59 q59Var : this.d) {
                    q59Var.b();
                }
            }
            Thread thread = this.c;
            if (thread != null) {
                thread.interrupt();
            }
        }
    }

    public final boolean j(n59 n59Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, n59Var)) == null) {
            if (n59Var == null || b99.e(n59Var.c())) {
                return false;
            }
            List<p59> c = n59Var.c();
            m59 m59Var = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 0; i2 < c.size(); i2++) {
                if (v59.o(c.get(i2).b())) {
                    z = true;
                }
                if (!b99.e(c.get(i2).a())) {
                    for (l59 l59Var : c.get(i2).a()) {
                        if (l59Var != null) {
                            if (l59Var.c()) {
                                if (m59Var == null) {
                                    m59Var = l59Var.a();
                                }
                                if (m59Var != null) {
                                    int k = m59Var.k(l59Var.a());
                                    z2 = ((m59.g & k) == 0 && (m59.i & k) == 0 && (k & m59.h) == 0) ? false : true;
                                }
                                if (l59Var.b().mSpeed != 1.0f) {
                                    z = true;
                                }
                                if (MimeTypes.AUDIO_RAW.equals(l59Var.a().f())) {
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
                s59 s59Var = new s59();
                s59Var.c(z2 ? 50 : 90);
                s59Var.e(this);
                this.d.add(s59Var);
                r59 r59Var = new r59();
                r59Var.c(z2 ? 50 : 10);
                r59Var.e(this);
                this.d.add(r59Var);
                s59Var.f(r59Var);
            } else {
                r59 r59Var2 = new r59();
                r59Var2.c(100);
                r59Var2.e(this);
                this.d.add(r59Var2);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final m59 k(n59 n59Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, n59Var)) == null) {
            if (n59Var != null && b99.b(n59Var.c()) == 1 && b99.b(n59Var.c().get(0).a()) == 1) {
                l59 l59Var = n59Var.c().get(0).a().get(0);
                if (l59Var.b() == null || l59Var.b().isNeedEdit() || !l59Var.c()) {
                    return null;
                }
                return l59Var.a();
            }
            return null;
        }
        return (m59) invokeL.objValue;
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

    public final void o(m59 m59Var) {
        b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, m59Var) == null) || (bVar = this.b) == null) {
            return;
        }
        bVar.onAudioMixtureProgress(100);
        this.b.onAudioMixtureSuccess(m59Var);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || b99.e(this.d)) {
            return;
        }
        for (q59 q59Var : this.d) {
            q59Var.h();
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
            m59 k = k(this.a);
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
