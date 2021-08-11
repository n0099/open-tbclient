package org.webrtc;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes2.dex */
public class GlTextureFrameBuffer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int frameBufferId;
    public int height;
    public final int pixelFormat;
    public int textureId;
    public int width;

    public GlTextureFrameBuffer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        switch (i2) {
            case 6407:
            case GeneratedTexture.FORMAT /* 6408 */:
            case 6409:
                this.pixelFormat = i2;
                this.width = 0;
                this.height = 0;
                return;
            default:
                throw new IllegalArgumentException("Invalid pixel format: " + i2);
        }
    }

    public int getFrameBufferId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.frameBufferId : invokeV.intValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.height : invokeV.intValue;
    }

    public int getTextureId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.textureId : invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.width : invokeV.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            GLES20.glDeleteTextures(1, new int[]{this.textureId}, 0);
            this.textureId = 0;
            GLES20.glDeleteFramebuffers(1, new int[]{this.frameBufferId}, 0);
            this.frameBufferId = 0;
            this.width = 0;
            this.height = 0;
        }
    }

    public void setSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            if (i2 <= 0 || i3 <= 0) {
                throw new IllegalArgumentException("Invalid size: " + i2 + "x" + i3);
            } else if (i2 == this.width && i3 == this.height) {
            } else {
                this.width = i2;
                this.height = i3;
                if (this.textureId == 0) {
                    this.textureId = GlUtil.generateTexture(3553);
                }
                if (this.frameBufferId == 0) {
                    int[] iArr = new int[1];
                    GLES20.glGenFramebuffers(1, iArr, 0);
                    this.frameBufferId = iArr[0];
                }
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, this.textureId);
                int i4 = this.pixelFormat;
                GLES20.glTexImage2D(3553, 0, i4, i2, i3, 0, i4, 5121, null);
                GLES20.glBindTexture(3553, 0);
                GlUtil.checkNoGLES2Error("GlTextureFrameBuffer setSize");
                GLES20.glBindFramebuffer(36160, this.frameBufferId);
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.textureId, 0);
                int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
                if (glCheckFramebufferStatus == 36053) {
                    GLES20.glBindFramebuffer(36160, 0);
                    return;
                }
                throw new IllegalStateException("Framebuffer not complete, status: " + glCheckFramebufferStatus);
            }
        }
    }
}
