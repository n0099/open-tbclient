package d.a.n0.h.d0;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.screenrecord.GameRecorderController;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.j2.k;
import d.a.n0.a.r0.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes7.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public int f49906i;
    public String j;
    public boolean k;
    public ArrayList<d.a.n0.h.d0.h.b> l;
    public List<String> m;
    public List<String> n;

    /* renamed from: d.a.n0.h.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1087a implements d.a.n0.h.d0.h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.y.b.a f49907a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f49908b;

        public C1087a(a aVar, d.a.n0.a.y.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49908b = aVar;
            this.f49907a = aVar2;
        }

        @Override // d.a.n0.h.d0.h.c
        public void a(d.a.n0.h.d0.h.d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, str) == null) {
                this.f49908b.C(this.f49907a, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d.a.n0.a.l0.c cVar) {
        super(cVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = false;
        this.l = new ArrayList<>();
        this.m = new ArrayList(3);
        this.n = new ArrayList(3);
    }

    public final void C(d.a.n0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            if (f.f49909h) {
                Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
            }
            d.a.n0.h.m0.c.a(aVar, false, new b(str));
        }
    }

    @NonNull
    public final String D(String str, @NonNull List<String> list, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, i2)) == null) {
            if (list.size() >= i2) {
                String remove = list.remove(0);
                d.a.n0.t.d.j(n.K(remove));
                if (f.f49909h) {
                    Log.d("GameRecorderApi", "deleteFile: " + remove);
                }
            }
            String format = String.format(Locale.CHINA, str, Long.valueOf(System.currentTimeMillis()));
            list.add(format);
            return format;
        }
        return (String) invokeLLI.objValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f.f49909h) {
                Log.d("GameRecorderApi", "doStartRecorder:" + this.f49906i + "," + this.j);
            }
            this.l.clear();
            this.k = false;
            g.a().b().t(this.f49906i, this.j);
        }
    }

    public final boolean F(double[] dArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, dArr)) == null) {
            if (dArr == null || dArr.length < 2) {
                return false;
            }
            long j = (long) (dArr[0] * 1000.0d);
            long j2 = (long) (dArr[1] * 1000.0d);
            return j >= 0 && j2 >= 0 && j + j2 > 0;
        }
        return invokeL.booleanValue;
    }

    public final boolean G(GameRecorderController.RecorderState... recorderStateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, recorderStateArr)) == null) {
            GameRecorderController.RecorderState l = g.a().b().l();
            if (f.f49909h) {
                Log.d("GameRecorderApi", "RecorderState:" + l);
            }
            if (recorderStateArr == null) {
                return true;
            }
            for (GameRecorderController.RecorderState recorderState : recorderStateArr) {
                if (l == recorderState) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public final d.a.n0.a.y.b.a H(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            d.a.n0.a.y.b.a G = d.a.n0.a.y.b.a.G(jsObject);
            return G == null ? new d.a.n0.a.y.b.a() : G;
        }
        return (d.a.n0.a.y.b.a) invokeL.objValue;
    }

    public final void I(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, jsObject) == null) || jsObject == null) {
            return;
        }
        jsObject.release();
    }

    @JavascriptInterface
    public void clipVideo(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            d.a.n0.a.y.b.a H = H(jsObject);
            String C = H.C("path");
            if (f.f49909h) {
                Log.d("GameRecorderApi", "clipPath:" + C + "，hasExecutedClip：" + this.k);
            }
            if (this.k) {
                return;
            }
            if (G(GameRecorderController.RecorderState.STOP)) {
                C(H, "clipVideo can only called after onStop");
            } else if (this.l.isEmpty()) {
                C(H, "range is illegal");
            } else {
                new d.a.n0.h.d0.h.e(this.l, n.y(C), n.K(D("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.n, 3))).c(new C1087a(this, H));
                this.l.clear();
                this.k = true;
                d.a.n0.a.j2.p.e eVar = new d.a.n0.a.j2.p.e();
                eVar.f45818b = "clipVideo";
                k.h(eVar);
            }
        }
    }

    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (f.f49909h) {
                Log.d("GameRecorderApi", "pause");
            }
            if (G(GameRecorderController.RecorderState.RECORDING)) {
                return;
            }
            g.a().b().o();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            d.a.n0.a.y.b.a H = H(jsObject);
            if (G(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            double[] p = H.p("timeRange");
            I(jsObject);
            if (!F(p)) {
                p = new double[]{3.0d, 3.0d};
            }
            d.a.n0.h.d0.h.b b2 = d.a.n0.h.d0.h.b.b(g.a().b().k(), p[0], p[1]);
            if (f.f49909h) {
                Log.d("GameRecorderApi", "recordClip:" + b2.toString());
            }
            this.l.add(b2);
            d.a.n0.a.j2.p.e eVar = new d.a.n0.a.j2.p.e();
            eVar.f45818b = "recordClip";
            k.h(eVar);
        }
    }

    @JavascriptInterface
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (f.f49909h) {
                Log.d("GameRecorderApi", "resume");
            }
            if (G(GameRecorderController.RecorderState.PAUSE) || g.a().c()) {
                return;
            }
            g.a().b().q();
        }
    }

    @JavascriptInterface
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            start(null);
        }
    }

    @JavascriptInterface
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (f.f49909h) {
                Log.d("GameRecorderApi", IntentConfig.STOP);
            }
            if (G(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            g.a().b().u();
        }
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            if (f.f49909h) {
                Log.d("GameRecorderApi", "start");
            }
            if (G(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) || g.a().c()) {
                return;
            }
            d.a.n0.a.y.b.a H = H(jsObject);
            int s = H.s("duration", 10);
            this.f49906i = s;
            if (s <= 0) {
                this.f49906i = 10;
            }
            if (this.f49906i > 120) {
                this.f49906i = 120;
            }
            if (this.m.size() == 0) {
                d.a.n0.t.d.j(n.K("bdfile://tmp/SwanVideoRecorder/"));
            }
            String D = D("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.m, 3);
            A(D);
            String K = n.K(D);
            this.j = K;
            if (K == null) {
                if (f.f49909h) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (H.n("microphoneEnabled", false)) {
                z(2);
            }
            E();
            d.a.n0.h.e0.b.a.l();
        }
    }
}
