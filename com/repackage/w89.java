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
public class w89 extends u89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g99 h;
    public int i;
    public int j;

    /* loaded from: classes7.dex */
    public class a extends va9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AudioPlayData c;
        public final /* synthetic */ p89 d;
        public final /* synthetic */ w89 e;

        public a(w89 w89Var, String str, int i, AudioPlayData audioPlayData, p89 p89Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w89Var, str, Integer.valueOf(i), audioPlayData, p89Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = w89Var;
            this.a = str;
            this.b = i;
            this.c = audioPlayData;
            this.d = p89Var;
        }

        @Override // com.repackage.va9, com.repackage.ua9
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.h.cancel();
                AudioPlayData audioPlayData = this.c;
                if (audioPlayData.mSpeed != 1.0f || z89.o(audioPlayData.mSoundTypes)) {
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

        @Override // com.repackage.va9
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.e.q(new p89(new AudioPlayData(this.a, 0, -1, 1.0f)), this.b);
                }
                synchronized (this.e) {
                    this.e.notifyAll();
                }
            }
        }

        @Override // com.repackage.va9, com.repackage.ua9
        public void onProgressChanged(int i, double d, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Double.valueOf(d), Long.valueOf(j)}) == null) {
                w89 w89Var = this.e;
                w89Var.i((int) (((((w89Var.j - 1) + d) * 1.0d) / this.e.i) * 100.0d));
            }
        }
    }

    public w89() {
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

    @Override // com.repackage.u89
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = true;
            g99 g99Var = this.h;
            if (g99Var != null) {
                g99Var.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // com.repackage.u89
    public void d(r89 r89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, r89Var) == null) {
            if (r89Var == null || fc9.e(r89Var.c())) {
                g("input data error: null or length=0");
            } else if (!j(r89Var)) {
                l(r89Var);
            } else {
                String a2 = r89Var.a();
                this.g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.g)) {
                    new File(this.g).mkdir();
                }
                this.e = false;
                this.f = false;
                y(r89Var);
                x(r89Var);
                List<t89> c = r89Var.c();
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

    @Override // com.repackage.u89
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            g99 g99Var = this.h;
            if (g99Var != null) {
                g99Var.J();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(p89 p89Var, int i) {
        r89 r89Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, p89Var, i) == null) || (r89Var = this.d) == null || r89Var.c() == null || this.d.c().get(i) == null) {
            return;
        }
        this.d.c().get(i).a().add(p89Var);
    }

    public final void r(t89 t89Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, t89Var, i) == null) || t89Var == null || fc9.e(t89Var.a()) || this.f || this.e) {
            return;
        }
        for (p89 p89Var : t89Var.a()) {
            if (this.e || this.f) {
                return;
            }
            this.j++;
            if (t(p89Var)) {
                v(p89Var, i);
            } else {
                q(p89Var, i);
                i((int) (((this.j * 1.0f) / this.i) * 100.0f));
            }
        }
    }

    public final boolean t(p89 p89Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, p89Var)) == null) {
            if (p89Var == null || p89Var.b() == null || !p89Var.c()) {
                return false;
            }
            if (!z89.o(p89Var.b().mSoundTypes) && p89Var.b().mSpeed == 1.0f && p89Var.b().start == 0 && p89Var.b().end == -1 && p89Var.b().volume == 1.0f) {
                return (p89Var.a() == null || "audio/mp4a-latm".equals(p89Var.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(p89 p89Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, p89Var, i) == null) || this.f || this.e) {
            return;
        }
        AudioPlayData b = p89Var.b();
        if (b == null || !FileUtils.isExists(b.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            g99 g99Var = new g99(b.audioPath, a2, b.mSoundTypes);
            this.h = g99Var;
            g99Var.S(new a(this, a2, i, b, p89Var));
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
            g("dealAudioPlayData exception:" + kc9.g(e));
            e.printStackTrace();
        }
    }

    public final void x(r89 r89Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, r89Var) == null) || r89Var == null || fc9.e(r89Var.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < r89Var.c().size(); i++) {
            arrayList.add(new t89(new ArrayList()));
        }
        r89 r89Var2 = new r89(arrayList);
        this.d = r89Var2;
        r89Var2.e(r89Var.b());
        this.d.d(r89Var.a());
    }

    public final void y(r89 r89Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, r89Var) == null) {
            this.i = 0;
            this.j = 0;
            List<t89> c = r89Var.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                if (c.get(i) != null && c.get(i).a() != null) {
                    this.i += c.get(i).a().size();
                }
            }
        }
    }
}
