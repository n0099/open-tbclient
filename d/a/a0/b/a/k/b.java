package d.a.a0.b.a.k;

import com.baidu.minivideo.effect.core.vlogedit.MediaAEffect;
import com.baidu.minivideo.effect.core.vlogedit.MediaOneAEffect;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static MediaOneAEffect a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65536, null, j)) == null) {
            MediaOneAEffect mediaOneAEffect = new MediaOneAEffect();
            mediaOneAEffect.start = 0L;
            mediaOneAEffect.end = j;
            ArrayList arrayList = new ArrayList();
            mediaOneAEffect.aParams = arrayList;
            arrayList.add(c());
            return mediaOneAEffect;
        }
        return (MediaOneAEffect) invokeJ.objValue;
    }

    public static MediaAEffect b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) {
            MediaAEffect mediaAEffect = new MediaAEffect();
            mediaAEffect.name = "defaultScene";
            mediaAEffect.duration = j;
            mediaAEffect.repeatMode = MediaAEffect.AE_ANIM_ONCE;
            mediaAEffect.effectType = "scene";
            mediaAEffect.shaderConfigKey = c.f41273b;
            ArrayList arrayList = new ArrayList();
            mediaAEffect.mediaOneAEffects = arrayList;
            arrayList.add(a(j));
            return mediaAEffect;
        }
        return (MediaAEffect) invokeJ.objValue;
    }

    public static ShaderParams c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ShaderParams shaderParams = new ShaderParams();
            shaderParams.name = "scale";
            shaderParams.type = ShaderParams.VALUE_TYPE_ANIMATOR;
            shaderParams.values = new float[]{1.0f, 1.2f};
            return shaderParams;
        }
        return (ShaderParams) invokeV.objValue;
    }
}
