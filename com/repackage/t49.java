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
public class t49 extends r49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d59 h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a extends s69 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ m49 d;
        public final /* synthetic */ t49 e;

        public a(t49 t49Var, String str, int i, AudioPlayData audioPlayData, m49 m49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t49Var, str, Integer.valueOf(i), audioPlayData, m49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = t49Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = m49Var;
        }

        @Override // com.repackage.s69, com.repackage.r69
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || w49.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.repackage.s69
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new m49(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.repackage.s69, com.repackage.r69
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                t49 t49Var = this.e;
                t49Var.i((int) (((((t49Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public t49() {
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

    @Override // com.repackage.r49
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            d59 d59Var = this.h;
            if (d59Var != null) {
                d59Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.repackage.r49
    public void d(o49 o49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o49Var) == null) {
            if (o49Var == null || c89.e(o49Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(o49Var)) {
                l(o49Var);
            } else {
                String a2 = o49Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(o49Var);
                x(o49Var);
                List<q49> c = o49Var.c();
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

    @Override // com.repackage.r49
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d59 d59Var = this.h;
            if (d59Var != null) {
                d59Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(m49 m49Var, int i) {
        o49 o49Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, m49Var, i) == null) || (o49Var = this.d) == null || o49Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(m49Var);
    }

    public final void r(q49 q49Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, q49Var, i) == null) || q49Var == null || c89.e(q49Var.a()) || this.f || this.e) {
            return;
        }
        for (m49 m49Var : q49Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(m49Var)) {
                v(m49Var, i);
            } else {
                q(m49Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(m49 m49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, m49Var)) == null) {
            if (m49Var == null || m49Var.b() == null || !m49Var.c()) {
                return false;
            }
            if (!w49.o(m49Var.b().mSoundTypes) && m49Var.b().mSpeed == 1.0f && m49Var.b().start == 0 && m49Var.b().end == -1 && m49Var.b().volume == 1.0f) {
                return (m49Var.a() == null || "audio/mp4a-latm".equals(m49Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(m49 m49Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, m49Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = m49Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            d59 d59Var = new d59(b.audioPath, a2, b.mSoundTypes);
            this.h = d59Var;
            d59Var.S(new a(this, a2, i, b, m49Var));
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
            g("dealAudioPlayData exception:" + h89.g(e));
            e.printStackTrace();
        }
    }

    public final void x(o49 o49Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, o49Var) == null) || o49Var == null || c89.e(o49Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < o49Var.c().size(); i++) {
            arrayList.add(new q49(new ArrayList()));
        }
        o49 o49Var2 = new o49(arrayList);
        this.d = o49Var2;
        o49Var2.e(o49Var.b());
        this.d.d(o49Var.a());
    }

    public final void y(o49 o49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, o49Var) == null) {
            this.i = 0;
            this.j = 0;
            List<q49> c = o49Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
