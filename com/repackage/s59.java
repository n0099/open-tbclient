package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class s59 extends q59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c69 h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a extends r79 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ l59 d;
        public final /* synthetic */ s59 e;

        public a(s59 s59Var, String str, int i, AudioPlayData audioPlayData, l59 l59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s59Var, str, Integer.valueOf(i), audioPlayData, l59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = s59Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = l59Var;
        }

        @Override // com.repackage.r79, com.repackage.q79
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || v59.o(audioPlayData.mSoundTypes)) {
                    this.e.g(str);
                    this.e.h.cancel();
                } else {
                    this.e.h.cancel();
                    this.e.q(this.d, this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.repackage.r79
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new l59(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.repackage.r79, com.repackage.q79
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                s59 s59Var = this.e;
                s59Var.i((int) (((((s59Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public s59() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.repackage.q59
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            c69 c69Var = this.h;
            if (c69Var != null) {
                c69Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.repackage.q59
    public void d(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n59Var) == null) {
            if (n59Var == null || b99.e(n59Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(n59Var)) {
                l(n59Var);
            } else {
                String a2 = n59Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(n59Var);
                x(n59Var);
                List<p59> c = n59Var.c();
                int size = c.size();
                for (int i = 0; i < size; i++) {
                    r(c.get(i), i);
                }
                if (this.e || this.f) {
                    return;
                }
                l(this.d);
            }
        }
    }

    @Override // com.repackage.q59
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c69 c69Var = this.h;
            if (c69Var != null) {
                c69Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(l59 l59Var, int i) {
        n59 n59Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, l59Var, i) == null) || (n59Var = this.d) == null || n59Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(l59Var);
    }

    public final void r(p59 p59Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, p59Var, i) == null) || p59Var == null || b99.e(p59Var.a()) || this.f || this.e) {
            return;
        }
        for (l59 l59Var : p59Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(l59Var)) {
                v(l59Var, i);
            } else {
                q(l59Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(l59 l59Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, l59Var)) == null) {
            if (l59Var == null || l59Var.b() == null || !l59Var.c()) {
                return false;
            }
            if (!v59.o(l59Var.b().mSoundTypes) && l59Var.b().mSpeed == 1.0f && l59Var.b().start == 0 && l59Var.b().end == -1 && l59Var.b().volume == 1.0f) {
                return (l59Var.a() == null || "audio/mp4a-latm".equals(l59Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(l59 l59Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, l59Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = l59Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            c69 c69Var = new c69(b.audioPath, a2, b.mSoundTypes);
            this.h = c69Var;
            c69Var.S(new a(this, a2, i, b, l59Var));
            this.h.D(b.mSoundTypes);
            this.h.G(b.mSpeed);
            this.h.H(b.volume);
            this.h.B(b.start);
            this.h.R(b.end);
            this.h.I();
            synchronized (this) {
                wait();
            }
        } catch (Exception e) {
            g("dealAudioPlayData exception:" + g99.g(e));
            e.printStackTrace();
        }
    }

    public final void x(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, n59Var) == null) || n59Var == null || b99.e(n59Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < n59Var.c().size(); i++) {
            arrayList.add(new p59(new ArrayList()));
        }
        n59 n59Var2 = new n59(arrayList);
        this.d = n59Var2;
        n59Var2.e(n59Var.b());
        this.d.d(n59Var.a());
    }

    public final void y(n59 n59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, n59Var) == null) {
            this.i = 0;
            this.j = 0;
            List<p59> c = n59Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
