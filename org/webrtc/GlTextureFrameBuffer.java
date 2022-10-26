package org.webrtc;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.gles.GeneratedTexture;
/* loaded from: classes8.dex */
public class GlTextureFrameBuffer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int frameBufferId;
    public int height;
    public final int pixelFormat;
    public int textureId;
    public int width;

    public GlTextureFrameBuffer(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        switch (i) {
            case 6407:
            case GeneratedTexture.FORMAT /* 6408 */:
            case 6409:
                this.pixelFormat = i;
                this.width = 0;
                this.height = 0;
                return;
            default:
                throw new IllegalArgumentException("Invalid pixel format: " + i);
        }
    }

    public int getFrameBufferId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.frameBufferId;
        }
        return invokeV.intValue;
    }

    public int getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.height;
        }
        return invokeV.intValue;
    }

    public int getTextureId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.textureId;
        }
        return invokeV.intValue;
    }

    public int getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.width;
        }
        return invokeV.intValue;
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

    public void setSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            if (i > 0 && i2 > 0) {
                if (i == this.width && i2 == this.height) {
                    return;
                }
                this.width = i;
                this.height = i2;
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
                int i3 = this.pixelFormat;
                GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, null);
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
            throw new IllegalArgumentException("Invalid size: " + i + "x" + i2);
        }
    }
}
