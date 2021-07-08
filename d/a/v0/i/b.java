package d.a.v0.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import d.a.v0.t.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AudioPlayData> f67889a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f67890b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.v0.i.g.a f67891c;

    /* renamed from: d  reason: collision with root package name */
    public int f67892d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1928b f67893e;

    /* loaded from: classes8.dex */
    public class a extends d.a.v0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f67894e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f67895f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f67896g;

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
            this.f67896g = bVar;
            this.f67894e = str;
            this.f67895f = audioPlayData;
        }

        @Override // d.a.v0.l.d.j.c.a, d.a.v0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f67896g.f67893e == null) {
                return;
            }
            this.f67896g.f67893e.onFailed(str);
        }

        @Override // d.a.v0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f67894e, 0, (int) x.b(this.f67894e), this.f67895f.volume);
                if (this.f67896g.f67890b == null) {
                    this.f67896g.f67890b = new ArrayList();
                }
                this.f67896g.f67890b.add(audioPlayData);
                b.c(this.f67896g);
                this.f67896g.f();
            }
        }

        @Override // d.a.v0.l.d.j.c.a, d.a.v0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // d.a.v0.l.d.j.c.a, d.a.v0.l.d.j.b
        public void onTrackEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* renamed from: d.a.v0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1928b {
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
        int i2 = bVar.f67892d;
        bVar.f67892d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d.a.v0.t.h.c(this.f67889a, this.f67892d) == null) {
                InterfaceC1928b interfaceC1928b = this.f67893e;
                if (interfaceC1928b != null) {
                    interfaceC1928b.onSuccess(this.f67890b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.f67889a.get(this.f67892d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f67890b == null) {
                    arrayList = new ArrayList();
                    this.f67890b = arrayList;
                }
                this.f67890b.add(audioPlayData);
                this.f67892d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f67890b == null) {
                    arrayList = new ArrayList();
                    this.f67890b = arrayList;
                }
                this.f67890b.add(audioPlayData);
                this.f67892d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    d.a.v0.i.g.a aVar = new d.a.v0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f67891c = aVar;
                    aVar.M(new a(this, str2, audioPlayData2));
                    this.f67891c.y(null);
                    this.f67891c.A(audioPlayData2.mSpeed);
                    this.f67891c.w(audioPlayData2.start);
                    this.f67891c.L(audioPlayData2.end);
                    this.f67891c.C();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1928b interfaceC1928b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1928b) == null) {
            this.f67893e = interfaceC1928b;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f67889a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}
