package d.a.y0.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import d.a.y0.t.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AudioPlayData> f71086a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f71087b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.y0.i.g.a f71088c;

    /* renamed from: d  reason: collision with root package name */
    public int f71089d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1969b f71090e;

    /* loaded from: classes9.dex */
    public class a extends d.a.y0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f71091e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f71092f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f71093g;

        public a(b bVar, String str, AudioPlayData audioPlayData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, audioPlayData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71093g = bVar;
            this.f71091e = str;
            this.f71092f = audioPlayData;
        }

        @Override // d.a.y0.l.d.j.c.a, d.a.y0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f71093g.f71090e == null) {
                return;
            }
            this.f71093g.f71090e.onFailed(str);
        }

        @Override // d.a.y0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f71091e, 0, (int) x.b(this.f71091e), this.f71092f.volume);
                if (this.f71093g.f71087b == null) {
                    this.f71093g.f71087b = new ArrayList();
                }
                this.f71093g.f71087b.add(audioPlayData);
                b.c(this.f71093g);
                this.f71093g.f();
            }
        }

        @Override // d.a.y0.l.d.j.c.a, d.a.y0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // d.a.y0.l.d.j.c.a, d.a.y0.l.d.j.b
        public void onTrackEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* renamed from: d.a.y0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1969b {
        void onFailed(String str);

        void onSuccess(List<AudioPlayData> list);
    }

    public b() {
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

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f71089d;
        bVar.f71089d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d.a.y0.t.h.c(this.f71086a, this.f71089d) == null) {
                InterfaceC1969b interfaceC1969b = this.f71090e;
                if (interfaceC1969b != null) {
                    interfaceC1969b.onSuccess(this.f71087b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.f71086a.get(this.f71089d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f71087b == null) {
                    arrayList = new ArrayList();
                    this.f71087b = arrayList;
                }
                this.f71087b.add(audioPlayData);
                this.f71089d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f71087b == null) {
                    arrayList = new ArrayList();
                    this.f71087b = arrayList;
                }
                this.f71087b.add(audioPlayData);
                this.f71089d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    d.a.y0.i.g.a aVar = new d.a.y0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f71088c = aVar;
                    aVar.M(new a(this, str2, audioPlayData2));
                    this.f71088c.y(null);
                    this.f71088c.A(audioPlayData2.mSpeed);
                    this.f71088c.w(audioPlayData2.start);
                    this.f71088c.L(audioPlayData2.end);
                    this.f71088c.C();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1969b interfaceC1969b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1969b) == null) {
            this.f71090e = interfaceC1969b;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f71086a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}
