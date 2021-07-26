package d.a.w0.i;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.player.AudioPlayData;
import com.baidu.ugc.utils.FileUtils;
import d.a.w0.t.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<AudioPlayData> f68567a;

    /* renamed from: b  reason: collision with root package name */
    public List<AudioPlayData> f68568b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.w0.i.g.a f68569c;

    /* renamed from: d  reason: collision with root package name */
    public int f68570d;

    /* renamed from: e  reason: collision with root package name */
    public InterfaceC1933b f68571e;

    /* loaded from: classes8.dex */
    public class a extends d.a.w0.l.d.j.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68572e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AudioPlayData f68573f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f68574g;

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
            this.f68574g = bVar;
            this.f68572e = str;
            this.f68573f = audioPlayData;
        }

        @Override // d.a.w0.l.d.j.c.a, d.a.w0.l.d.j.b
        public void onExceptionThrown(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f68574g.f68571e == null) {
                return;
            }
            this.f68574g.f68571e.onFailed(str);
        }

        @Override // d.a.w0.l.d.j.c.a
        public void onFinishedWriting(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                AudioPlayData audioPlayData = new AudioPlayData(this.f68572e, 0, (int) x.b(this.f68572e), this.f68573f.volume);
                if (this.f68574g.f68568b == null) {
                    this.f68574g.f68568b = new ArrayList();
                }
                this.f68574g.f68568b.add(audioPlayData);
                b.c(this.f68574g);
                this.f68574g.f();
            }
        }

        @Override // d.a.w0.l.d.j.c.a, d.a.w0.l.d.j.b
        public void onProgressChanged(int i2, double d2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2), Long.valueOf(j)}) == null) {
            }
        }

        @Override // d.a.w0.l.d.j.c.a, d.a.w0.l.d.j.b
        public void onTrackEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            }
        }
    }

    /* renamed from: d.a.w0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1933b {
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
        int i2 = bVar.f68570d;
        bVar.f68570d = i2 + 1;
        return i2;
    }

    public final void f() {
        AudioPlayData audioPlayData;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (d.a.w0.t.h.c(this.f68567a, this.f68570d) == null) {
                InterfaceC1933b interfaceC1933b = this.f68571e;
                if (interfaceC1933b != null) {
                    interfaceC1933b.onSuccess(this.f68568b);
                    return;
                }
                return;
            }
            AudioPlayData audioPlayData2 = this.f68567a.get(this.f68570d);
            if (!FileUtils.isExists(audioPlayData2.audioPath)) {
                String str = audioPlayData2.audioPath;
                int i2 = audioPlayData2.start;
                audioPlayData = new AudioPlayData(str, i2, audioPlayData2.end - i2, audioPlayData2.volume);
                if (this.f68568b == null) {
                    arrayList = new ArrayList();
                    this.f68568b = arrayList;
                }
                this.f68568b.add(audioPlayData);
                this.f68570d++;
                f();
            } else if (audioPlayData2.mSpeed == 1.0f) {
                audioPlayData = new AudioPlayData(audioPlayData2.audioPath, audioPlayData2.start, audioPlayData2.end, audioPlayData2.volume);
                if (this.f68568b == null) {
                    arrayList = new ArrayList();
                    this.f68568b = arrayList;
                }
                this.f68568b.add(audioPlayData);
                this.f68570d++;
                f();
            } else {
                String str2 = FileUtils.removeExtention(audioPlayData2.audioPath) + "_speed.aac";
                try {
                    d.a.w0.i.g.a aVar = new d.a.w0.i.g.a(audioPlayData2.audioPath, str2, null);
                    this.f68569c = aVar;
                    aVar.M(new a(this, str2, audioPlayData2));
                    this.f68569c.y(null);
                    this.f68569c.A(audioPlayData2.mSpeed);
                    this.f68569c.w(audioPlayData2.start);
                    this.f68569c.L(audioPlayData2.end);
                    this.f68569c.C();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void g(InterfaceC1933b interfaceC1933b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, interfaceC1933b) == null) {
            this.f68571e = interfaceC1933b;
        }
    }

    public void h(List<AudioPlayData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.f68567a = list;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            f();
        }
    }
}
