package com.repackage;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ec0 extends zb0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Surface l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755742561, "Lcom/repackage/ec0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755742561, "Lcom/repackage/ec0;");
        }
    }

    public ec0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.zb0
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.h == 0) {
                this.h = this.e.presentationTimeUs;
                zb0.j = 0L;
            }
            MediaCodec.BufferInfo bufferInfo = this.e;
            long j = bufferInfo.presentationTimeUs - this.h;
            bufferInfo.presentationTimeUs = j;
            zb0.j = j;
            ub0.x().V(zb0.j / 1000);
        }
    }

    public Surface k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : (Surface) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(bc0 bc0Var, cc0 cc0Var) {
        ac0 ac0Var;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bc0Var, cc0Var) != null) {
            return;
        }
        boolean z = true;
        if (bc0Var != null && cc0Var != null) {
            this.c = cc0Var;
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(bc0Var.j(), bc0Var.n(), bc0Var.l());
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", bc0Var.i());
            createVideoFormat.setInteger("frame-rate", bc0Var.k());
            createVideoFormat.setInteger("i-frame-interval", bc0Var.m());
            try {
                MediaCodec createEncoderByType = MediaCodec.createEncoderByType(bc0Var.j());
                this.d = createEncoderByType;
                createEncoderByType.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.l = this.d.createInputSurface();
                this.g = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            ac0Var = this.f;
            if (ac0Var == null) {
                ac0Var.b(z);
                return;
            }
            return;
        }
        z = false;
        ac0Var = this.f;
        if (ac0Var == null) {
        }
    }
}
