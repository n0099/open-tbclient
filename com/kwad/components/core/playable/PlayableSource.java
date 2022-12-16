package com.kwad.components.core.playable;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class PlayableSource {
    public static final /* synthetic */ PlayableSource[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final PlayableSource ACTIONBAR_CLICK;
    public static final PlayableSource ENDCARD_CLICK;
    public static final PlayableSource PENDANT_AUTO;
    public static final PlayableSource PENDANT_CLICK_AUTO;
    public static final PlayableSource PENDANT_CLICK_NOT_AUTO;
    public static final PlayableSource PLAY_FINISHED_NORMAL;
    public static final PlayableSource UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    public transient /* synthetic */ FieldHolder $fh;
    public int code;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(928717646, "Lcom/kwad/components/core/playable/PlayableSource;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(928717646, "Lcom/kwad/components/core/playable/PlayableSource;");
                return;
            }
        }
        UNKNOWN_TRYPLAY_ENTRY_SOURCE = new PlayableSource("UNKNOWN_TRYPLAY_ENTRY_SOURCE", 0, 0);
        PLAY_FINISHED_NORMAL = new PlayableSource("PLAY_FINISHED_NORMAL", 1, 1);
        PENDANT_CLICK_NOT_AUTO = new PlayableSource("PENDANT_CLICK_NOT_AUTO", 2, 2);
        PENDANT_CLICK_AUTO = new PlayableSource("PENDANT_CLICK_AUTO", 3, 3);
        PENDANT_AUTO = new PlayableSource("PENDANT_AUTO", 4, 4);
        ACTIONBAR_CLICK = new PlayableSource("ACTIONBAR_CLICK", 5, 5);
        PlayableSource playableSource = new PlayableSource("ENDCARD_CLICK", 6, 6);
        ENDCARD_CLICK = playableSource;
        $VALUES = new PlayableSource[]{UNKNOWN_TRYPLAY_ENTRY_SOURCE, PLAY_FINISHED_NORMAL, PENDANT_CLICK_NOT_AUTO, PENDANT_CLICK_AUTO, PENDANT_AUTO, ACTIONBAR_CLICK, playableSource};
    }

    public PlayableSource(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.code = i2;
    }

    public static PlayableSource valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PlayableSource) Enum.valueOf(PlayableSource.class, str) : (PlayableSource) invokeL.objValue;
    }

    public static PlayableSource[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PlayableSource[]) $VALUES.clone() : (PlayableSource[]) invokeV.objValue;
    }

    public final int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
    }
}
