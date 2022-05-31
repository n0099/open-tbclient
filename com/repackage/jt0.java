package com.repackage;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.kernel.EmptyKernel;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class jt0 extends et0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public jt0() {
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

    @Override // com.repackage.et0
    public void A(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            nw0.e(EmptyKernel.TAG, "seekTo(" + i + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void B(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            nw0.e(EmptyKernel.TAG, "setClarityInfo(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            nw0.d("player has released, cannot call setDataSourceAndPrepare!!!");
        }
    }

    @Override // com.repackage.et0
    public void D(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) {
            nw0.e(EmptyKernel.TAG, "setExternalInfo(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void E(@Nullable HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, hashMap) == null) {
            nw0.e(EmptyKernel.TAG, "setHttpHeader(" + hashMap + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void F(mt0 mt0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, mt0Var) == null) {
            nw0.e(EmptyKernel.TAG, "setKernelCallBack(" + System.identityHashCode(mt0Var) + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            nw0.e(EmptyKernel.TAG, "setLooping(" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void H(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            nw0.e(EmptyKernel.TAG, "setOption(" + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void I(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            nw0.e(EmptyKernel.TAG, "setPlayConf(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void J(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            nw0.e(EmptyKernel.TAG, "setProxy(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void L(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            nw0.e(EmptyKernel.TAG, "setSpeed(" + f + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            nw0.e(EmptyKernel.TAG, "setUserAgent(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void N(String str, @NonNull HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, hashMap) == null) {
            nw0.e(EmptyKernel.TAG, "setVideoFormatOptions(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void O(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            nw0.e(EmptyKernel.TAG, "setVideoScalingMode(" + i + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void P(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, str, z) == null) {
            nw0.e(EmptyKernel.TAG, "player has released, cannot call setVideoUrl!!! isNeedChangeState = " + z);
        }
    }

    @Override // com.repackage.et0
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            nw0.e(EmptyKernel.TAG, "start()");
        }
    }

    @Override // com.repackage.et0
    public void U(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            nw0.e(EmptyKernel.TAG, "updateFreeProxy(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            nw0.e(EmptyKernel.TAG, "changePlayUrl(" + str + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    @NonNull
    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            nw0.e(EmptyKernel.TAG, "getBVideoView()");
            return new FrameLayout(jo0.b());
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.et0
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            nw0.e(EmptyKernel.TAG, "getBufferingPosition()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.et0
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            nw0.e(EmptyKernel.TAG, "getDuration()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.et0
    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            nw0.e(EmptyKernel.TAG, "getDurationMs()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.et0
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            nw0.e(EmptyKernel.TAG, "getPosition()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.et0
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            nw0.e(EmptyKernel.TAG, "getPositionMs()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.et0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            nw0.e(EmptyKernel.TAG, "getVideoHeight()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.et0
    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            nw0.e(EmptyKernel.TAG, "getVideoWidth()");
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.et0
    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            nw0.e(EmptyKernel.TAG, "mute(" + z + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0, com.repackage.uv0
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // com.repackage.et0
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            nw0.e(EmptyKernel.TAG, "onComplete()");
        }
    }

    @Override // com.repackage.et0
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            nw0.e(EmptyKernel.TAG, "onError()");
        }
    }

    @Override // com.repackage.et0
    public void s(int i, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048606, this, i, i2, obj) == null) {
            nw0.e(EmptyKernel.TAG, "onInfo(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + obj + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    @Override // com.repackage.et0
    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            nw0.e(EmptyKernel.TAG, "onPrepared()");
        }
    }

    @Override // com.repackage.et0, com.repackage.uv0
    public boolean verify(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) ? EmptyKernel.TAG.equals(str) : invokeL.booleanValue;
    }
}
