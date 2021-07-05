package d.a.y0.h.f;

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
import d.a.y0.h.e;
import d.a.y0.t.h;
import d.a.y0.t.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c extends d.a.y0.h.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public d.a.y0.i.g.a f71079h;

    /* renamed from: i  reason: collision with root package name */
    public int f71080i;
    public int j;

    /* loaded from: classes9.dex */
    public class a extends d.a.y0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f71081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f71082f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f71083g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.y0.h.a f71084h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f71085i;

        public a(c cVar, String str, int i2, AudioPlayData audioPlayData, d.a.y0.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, Integer.valueOf(i2), audioPlayData, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71085i = cVar;
            this.f71081e = str;
            this.f71082f = i2;
            this.f71083g = audioPlayData;
            this.f71084h = aVar;
        }

        @Override // d.a.y0.l.d.j.c.a, d.a.y0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f71085i.f71079h.cancel();
                AudioPlayData audioPlayData = this.f71083g;
                if (audioPlayData.mSpeed != 1.0f || d.a.y0.i.c.k(audioPlayData.mSoundTypes)) {
                    this.f71085i.g(str);
                    this.f71085i.f71079h.cancel();
                } else {
                    this.f71085i.f71079h.cancel();
                    this.f71085i.q(this.f71084h, this.f71082f);
                }
                synchronized (this.f71085i) {
                    this.f71085i.notifyAll();
                }
            }
        }

        @Override // d.a.y0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (z) {
                    this.f71085i.q(new d.a.y0.h.a(new AudioPlayData(this.f71081e, 0, -1, 1.0f)), this.f71082f);
                }
                synchronized (this.f71085i) {
                    this.f71085i.notifyAll();
                }
            }
        }

        @Override // d.a.y0.l.d.j.c.a, d.a.y0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j)}) == null) {
                c cVar = this.f71085i;
                cVar.i((int) (((((cVar.j - 1) + d2) * 1.0d) / this.f71085i.f71080i) * 100.0d));
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.y0.h.f.a
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f71064f = true;
            d.a.y0.i.g.a aVar = this.f71079h;
            if (aVar != null) {
                aVar.cancel();
            }
            synchronized (this) {
                notifyAll();
            }
            o();
        }
    }

    @Override // d.a.y0.h.f.a
    public void d(d.a.y0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar == null || h.e(cVar.c())) {
                g("input data error: null or length=0");
            } else if (!j(cVar)) {
                l(cVar);
            } else {
                String a2 = cVar.a();
                this.f71065g = a2;
                if (!TextUtils.isEmpty(a2) && !FileUtils.isExists(this.f71065g)) {
                    new File(this.f71065g).mkdir();
                }
                this.f71063e = false;
                this.f71064f = false;
                y(cVar);
                x(cVar);
                List<e> c2 = cVar.c();
                int size = c2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    r(c2.get(i2), i2);
                }
                if (this.f71063e || this.f71064f) {
                    return;
                }
                l(this.f71062d);
            }
        }
    }

    @Override // d.a.y0.h.f.a
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.y0.i.g.a aVar = this.f71079h;
            if (aVar != null) {
                aVar.D();
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public final void q(d.a.y0.h.a aVar, int i2) {
        d.a.y0.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, aVar, i2) == null) || (cVar = this.f71062d) == null || cVar.c() == null || this.f71062d.c().get(i2) == null) {
            return;
        }
        this.f71062d.c().get(i2).a().add(aVar);
    }

    public final void r(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, eVar, i2) == null) || eVar == null || h.e(eVar.a()) || this.f71064f || this.f71063e) {
            return;
        }
        for (d.a.y0.h.a aVar : eVar.a()) {
            if (this.f71063e || this.f71064f) {
                return;
            }
            this.j++;
            if (t(aVar)) {
                v(aVar, i2);
            } else {
                q(aVar, i2);
                i((int) (((this.j * 1.0f) / this.f71080i) * 100.0f));
            }
        }
    }

    public final boolean t(d.a.y0.h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            if (aVar == null || aVar.b() == null || !aVar.c()) {
                return false;
            }
            if (!d.a.y0.i.c.k(aVar.b().mSoundTypes) && aVar.b().mSpeed == 1.0f && aVar.b().start == 0 && aVar.b().end == -1 && aVar.b().volume == 1.0f) {
                return (aVar.a() == null || "audio/mp4a-latm".equals(aVar.a().f())) ? false : true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(d.a.y0.h.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, aVar, i2) == null) || this.f71064f || this.f71063e) {
            return;
        }
        AudioPlayData b2 = aVar.b();
        if (b2 == null || !FileUtils.isExists(b2.audioPath)) {
            g("dealAudioPlayData,trackIndx:inputerror");
            return;
        }
        String str = b2.audioPath;
        String a2 = a(str, System.currentTimeMillis() + "_mediacodec.aac");
        try {
            d.a.y0.i.g.a aVar2 = new d.a.y0.i.g.a(b2.audioPath, a2, b2.mSoundTypes);
            this.f71079h = aVar2;
            aVar2.M(new a(this, a2, i2, b2, aVar));
            this.f71079h.y(b2.mSoundTypes);
            this.f71079h.A(b2.mSpeed);
            this.f71079h.B(b2.volume);
            this.f71079h.w(b2.start);
            this.f71079h.L(b2.end);
            this.f71079h.C();
            synchronized (this) {
                wait();
            }
        } catch (Exception e2) {
            g("dealAudioPlayData exception:" + m.g(e2));
            e2.printStackTrace();
        }
    }

    public final void x(d.a.y0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cVar) == null) || cVar == null || h.e(cVar.c())) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cVar.c().size(); i2++) {
            arrayList.add(new e(new ArrayList()));
        }
        d.a.y0.h.c cVar2 = new d.a.y0.h.c(arrayList);
        this.f71062d = cVar2;
        cVar2.e(cVar.b());
        this.f71062d.d(cVar.a());
    }

    public final void y(d.a.y0.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.f71080i = 0;
            this.j = 0;
            List<e> c2 = cVar.c();
            int size = c2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (c2.get(i2) != null && c2.get(i2).a() != null) {
                    this.f71080i += c2.get(i2).a().size();
                }
            }
        }
    }
}
