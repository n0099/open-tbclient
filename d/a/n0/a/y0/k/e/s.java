package d.a.n0.a.y0.k.e;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes7.dex */
public class s extends d.a.n0.a.y0.a<d.a.n0.a.y0.k.g.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f48510b;

    public s() {
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

    @Override // d.a.n0.a.y0.a
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setVolume" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.n0.a.y0.k.g.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, aVar) == null) || command.obj == null) {
            return;
        }
        if (!aVar.P()) {
            d(aVar, command.what, "Not Set!! Volume: " + command.obj, false);
            return;
        }
        Object obj = command.obj;
        if (obj instanceof Double) {
            try {
                double doubleValue = ((Double) obj).doubleValue();
                d(aVar, command.what, "Volume: " + command.obj, false);
                if (doubleValue > 1.0d) {
                    doubleValue = 1.0d;
                }
                if (doubleValue < 0.0d) {
                    doubleValue = 0.0d;
                }
                f(doubleValue, aVar.getContext());
            } catch (Exception unused) {
                if (d.a.n0.a.y0.a.f48397a) {
                    Log.e(b(), "setVolume param type error");
                }
            }
        }
    }

    public final void f(double d2, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Double.valueOf(d2), context}) == null) {
            if (this.f48510b == null) {
                this.f48510b = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            }
            AudioManager audioManager = this.f48510b;
            if (audioManager == null) {
                return;
            }
            int round = (int) Math.round(audioManager.getStreamMaxVolume(3) * d2);
            if (round == this.f48510b.getStreamVolume(3)) {
                if (d.a.n0.a.y0.a.f48397a) {
                    Log.d("【InlineCommand】", "Setting same volume level, ignore : (" + round + SmallTailInfo.EMOTION_SUFFIX);
                    return;
                }
                return;
            }
            if (d2 > 0.0d && round == 0) {
                round = 1;
            }
            if (d.a.n0.a.y0.a.f48397a) {
                Log.d("【InlineCommand】", "setVolumeInt" + round);
            }
            this.f48510b.setStreamVolume(3, round, 0);
        }
    }
}
