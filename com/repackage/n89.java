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
public class n89 extends l89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x89 h;
    public int i;
    public int j;

    /* loaded from: classes6.dex */
    public class a extends ma9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ g89 d;
        public final /* synthetic */ n89 e;

        public a(n89 n89Var, String str, int i, AudioPlayData audioPlayData, g89 g89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n89Var, str, Integer.valueOf(i), audioPlayData, g89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n89Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = g89Var;
        }

        @Override // com.repackage.ma9, com.repackage.la9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || q89.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.repackage.ma9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new g89(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.repackage.ma9, com.repackage.la9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                n89 n89Var = this.e;
                n89Var.i((int) (((((n89Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public n89() {
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

    @Override // com.repackage.l89
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            x89 x89Var = this.h;
            if (x89Var != null) {
                x89Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.repackage.l89
    public void d(i89 i89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i89Var) == null) {
            if (i89Var == null || wb9.e(i89Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(i89Var)) {
                l(i89Var);
            } else {
                String a2 = i89Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(i89Var);
                x(i89Var);
                List<k89> c = i89Var.c();
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

    @Override // com.repackage.l89
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            x89 x89Var = this.h;
            if (x89Var != null) {
                x89Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(g89 g89Var, int i) {
        i89 i89Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, g89Var, i) == null) || (i89Var = this.d) == null || i89Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(g89Var);
    }

    public final void r(k89 k89Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, k89Var, i) == null) || k89Var == null || wb9.e(k89Var.a()) || this.f || this.e) {
            return;
        }
        for (g89 g89Var : k89Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(g89Var)) {
                v(g89Var, i);
            } else {
                q(g89Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(g89 g89Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, g89Var)) == null) {
            if (g89Var == null || g89Var.b() == null || !g89Var.c()) {
                return false;
            }
            if (!q89.o(g89Var.b().mSoundTypes) && g89Var.b().mSpeed == 1.0f && g89Var.b().start == 0 && g89Var.b().end == -1 && g89Var.b().volume == 1.0f) {
                return (g89Var.a() == null || "audio/mp4a-latm".equals(g89Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(g89 g89Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, g89Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = g89Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            x89 x89Var = new x89(b.audioPath, a2, b.mSoundTypes);
            this.h = x89Var;
            x89Var.S(new a(this, a2, i, b, g89Var));
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
            g("dealAudioPlayData exception:" + bc9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(i89 i89Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, i89Var) == null) || i89Var == null || wb9.e(i89Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < i89Var.c().size(); i++) {
            arrayList.add(new k89(new ArrayList()));
        }
        i89 i89Var2 = new i89(arrayList);
        this.d = i89Var2;
        i89Var2.e(i89Var.b());
        this.d.d(i89Var.a());
    }

    public final void y(i89 i89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i89Var) == null) {
            this.i = 0;
            this.j = 0;
            List<k89> c = i89Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
