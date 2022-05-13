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
public class r79 extends p79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b89 h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a extends q99 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ k79 d;
        public final /* synthetic */ r79 e;

        public a(r79 r79Var, String str, int i, AudioPlayData audioPlayData, k79 k79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r79Var, str, Integer.valueOf(i), audioPlayData, k79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = r79Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = k79Var;
        }

        @Override // com.repackage.q99, com.repackage.p99
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || u79.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.repackage.q99
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new k79(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.repackage.q99, com.repackage.p99
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                r79 r79Var = this.e;
                r79Var.i((int) (((((r79Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public r79() {
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

    @Override // com.repackage.p79
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            b89 b89Var = this.h;
            if (b89Var != null) {
                b89Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.repackage.p79
    public void d(m79 m79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m79Var) == null) {
            if (m79Var == null || ab9.e(m79Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(m79Var)) {
                l(m79Var);
            } else {
                String a2 = m79Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(m79Var);
                x(m79Var);
                List<o79> c = m79Var.c();
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

    @Override // com.repackage.p79
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b89 b89Var = this.h;
            if (b89Var != null) {
                b89Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(k79 k79Var, int i) {
        m79 m79Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, k79Var, i) == null) || (m79Var = this.d) == null || m79Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(k79Var);
    }

    public final void r(o79 o79Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, o79Var, i) == null) || o79Var == null || ab9.e(o79Var.a()) || this.f || this.e) {
            return;
        }
        for (k79 k79Var : o79Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(k79Var)) {
                v(k79Var, i);
            } else {
                q(k79Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(k79 k79Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k79Var)) == null) {
            if (k79Var == null || k79Var.b() == null || !k79Var.c()) {
                return false;
            }
            if (!u79.o(k79Var.b().mSoundTypes) && k79Var.b().mSpeed == 1.0f && k79Var.b().start == 0 && k79Var.b().end == -1 && k79Var.b().volume == 1.0f) {
                return (k79Var.a() == null || "audio/mp4a-latm".equals(k79Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(k79 k79Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, k79Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = k79Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            b89 b89Var = new b89(b.audioPath, a2, b.mSoundTypes);
            this.h = b89Var;
            b89Var.S(new a(this, a2, i, b, k79Var));
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
            g("dealAudioPlayData exception:" + fb9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(m79 m79Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, m79Var) == null) || m79Var == null || ab9.e(m79Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < m79Var.c().size(); i++) {
            arrayList.add(new o79(new ArrayList()));
        }
        m79 m79Var2 = new m79(arrayList);
        this.d = m79Var2;
        m79Var2.e(m79Var.b());
        this.d.d(m79Var.a());
    }

    public final void y(m79 m79Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, m79Var) == null) {
            this.i = 0;
            this.j = 0;
            List<o79> c = m79Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
