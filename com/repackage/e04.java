package com.repackage;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes5.dex */
public class e04 extends j04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int e;
    public String f;
    public boolean g;
    public ArrayList<m04> h;
    public List<String> i;
    public List<String> j;

    /* loaded from: classes5.dex */
    public class a implements n04 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs1 a;
        public final /* synthetic */ e04 b;

        public a(e04 e04Var, qs1 qs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e04Var, qs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e04Var;
            this.a = qs1Var;
        }

        @Override // com.repackage.n04
        public void a(o04 o04Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, o04Var, str) == null) {
                this.b.C(this.a, str);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e04(t72 t72Var) {
        super(t72Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t72Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = false;
        this.h = new ArrayList<>();
        this.i = new ArrayList(3);
        this.j = new ArrayList(3);
    }

    public final void C(qs1 qs1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, qs1Var, str) == null) {
            if (j04.d) {
                Log.d("GameRecorderApi", "callFailureCallback: errMsg=" + str);
            }
            v24.call(qs1Var, false, new f04(str));
        }
    }

    @NonNull
    public final String D(String str, @NonNull List<String> list, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, list, i)) == null) {
            if (list.size() >= i) {
                String remove = list.remove(0);
                ng4.k(tc2.N(remove));
                if (j04.d) {
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
            if (j04.d) {
                Log.d("GameRecorderApi", "doStartRecorder:" + this.e + "," + this.f);
            }
            this.h.clear();
            this.g = false;
            k04.a().b().t(this.e, this.f);
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
            GameRecorderController.RecorderState l = k04.a().b().l();
            if (j04.d) {
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
    public final qs1 H(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            qs1 F = qs1.F(jsObject);
            return F == null ? new qs1() : F;
        }
        return (qs1) invokeL.objValue;
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
            qs1 H = H(jsObject);
            String B = H.B("path");
            if (j04.d) {
                Log.d("GameRecorderApi", "clipPath:" + B + "，hasExecutedClip：" + this.g);
            }
            if (this.g) {
                return;
            }
            if (G(GameRecorderController.RecorderState.STOP)) {
                C(H, "clipVideo can only called after onStop");
            } else if (this.h.isEmpty()) {
                C(H, "range is illegal");
            } else {
                new p04(this.h, tc2.B(B), tc2.N(D("bdfile://tmp/SwanVideoRecorder/videoClip_%d.mp4", this.j, 3))).c(new a(this, H));
                this.h.clear();
                this.g = true;
                l73 l73Var = new l73();
                l73Var.b = "clipVideo";
                c73.h(l73Var);
            }
        }
    }

    @JavascriptInterface
    public void pause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (j04.d) {
                Log.d("GameRecorderApi", "pause");
            }
            if (G(GameRecorderController.RecorderState.RECORDING)) {
                return;
            }
            k04.a().b().o();
        }
    }

    @JavascriptInterface
    public void recordClip(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) {
            qs1 H = H(jsObject);
            if (G(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            double[] o = H.o("timeRange");
            I(jsObject);
            if (!F(o)) {
                o = new double[]{3.0d, 3.0d};
            }
            m04 b = m04.b(k04.a().b().k(), o[0], o[1]);
            if (j04.d) {
                Log.d("GameRecorderApi", "recordClip:" + b.toString());
            }
            this.h.add(b);
            l73 l73Var = new l73();
            l73Var.b = "recordClip";
            c73.h(l73Var);
        }
    }

    @JavascriptInterface
    public void resume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (j04.d) {
                Log.d("GameRecorderApi", "resume");
            }
            if (G(GameRecorderController.RecorderState.PAUSE) || k04.a().c()) {
                return;
            }
            k04.a().b().q();
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
            if (j04.d) {
                Log.d("GameRecorderApi", IntentConfig.STOP);
            }
            if (G(GameRecorderController.RecorderState.RECORDING, GameRecorderController.RecorderState.PAUSE)) {
                return;
            }
            k04.a().b().u();
        }
    }

    @JavascriptInterface
    public void start(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jsObject) == null) {
            if (j04.d) {
                Log.d("GameRecorderApi", "start");
            }
            if (G(GameRecorderController.RecorderState.IDLE, GameRecorderController.RecorderState.STOP) || k04.a().c()) {
                return;
            }
            qs1 H = H(jsObject);
            int r = H.r("duration", 10);
            this.e = r;
            if (r <= 0) {
                this.e = 10;
            }
            if (this.e > 120) {
                this.e = 120;
            }
            if (this.i.size() == 0) {
                ng4.k(tc2.N("bdfile://tmp/SwanVideoRecorder/"));
            }
            String D = D("bdfile://tmp/SwanVideoRecorder/video_%d.mp4", this.i, 3);
            A(D);
            String N = tc2.N(D);
            this.f = N;
            if (N == null) {
                if (j04.d) {
                    Log.e("GameRecorderApi", "recordPath == null.");
                    return;
                }
                return;
            }
            if (H.m("microphoneEnabled", false)) {
                z(2);
            }
            E();
            v04.l();
        }
    }
}
