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
/* loaded from: classes6.dex */
public class l49 extends j49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v49 h;
    public int i;
    public int j;

    /* loaded from: classes6.dex */
    public class a extends k69 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ e49 d;
        public final /* synthetic */ l49 e;

        public a(l49 l49Var, String str, int i, AudioPlayData audioPlayData, e49 e49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l49Var, str, Integer.valueOf(i), audioPlayData, e49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = l49Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = e49Var;
        }

        @Override // com.repackage.k69, com.repackage.j69
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || o49.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.repackage.k69
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new e49(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.repackage.k69, com.repackage.j69
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                l49 l49Var = this.e;
                l49Var.i((int) (((((l49Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public l49() {
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

    @Override // com.repackage.j49
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            v49 v49Var = this.h;
            if (v49Var != null) {
                v49Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.repackage.j49
    public void d(g49 g49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g49Var) == null) {
            if (g49Var == null || u79.e(g49Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(g49Var)) {
                l(g49Var);
            } else {
                String a2 = g49Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(g49Var);
                x(g49Var);
                List<i49> c = g49Var.c();
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

    @Override // com.repackage.j49
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            v49 v49Var = this.h;
            if (v49Var != null) {
                v49Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(e49 e49Var, int i) {
        g49 g49Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, e49Var, i) == null) || (g49Var = this.d) == null || g49Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(e49Var);
    }

    public final void r(i49 i49Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, i49Var, i) == null) || i49Var == null || u79.e(i49Var.a()) || this.f || this.e) {
            return;
        }
        for (e49 e49Var : i49Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(e49Var)) {
                v(e49Var, i);
            } else {
                q(e49Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(e49 e49Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e49Var)) == null) {
            if (e49Var == null || e49Var.b() == null || !e49Var.c()) {
                return false;
            }
            if (!o49.o(e49Var.b().mSoundTypes) && e49Var.b().mSpeed == 1.0f && e49Var.b().start == 0 && e49Var.b().end == -1 && e49Var.b().volume == 1.0f) {
                return (e49Var.a() == null || "audio/mp4a-latm".equals(e49Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(e49 e49Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, e49Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = e49Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            v49 v49Var = new v49(b.audioPath, a2, b.mSoundTypes);
            this.h = v49Var;
            v49Var.S(new a(this, a2, i, b, e49Var));
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
            g("dealAudioPlayData exception:" + z79.g(e));
            e.printStackTrace();
        }
    }

    public final void x(g49 g49Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, g49Var) == null) || g49Var == null || u79.e(g49Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < g49Var.c().size(); i++) {
            arrayList.add(new i49(new ArrayList()));
        }
        g49 g49Var2 = new g49(arrayList);
        this.d = g49Var2;
        g49Var2.e(g49Var.b());
        this.d.d(g49Var.a());
    }

    public final void y(g49 g49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, g49Var) == null) {
            this.i = 0;
            this.j = 0;
            List<i49> c = g49Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
