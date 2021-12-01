package com.faceunity.gles;

import android.opengl.GLES20;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.Buffer;
import java.nio.FloatBuffer;
/* loaded from: classes2.dex */
public class FlatShadedProgram {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FRAGMENT_SHADER = "precision mediump float;uniform vec4 uColor;void main() {    gl_FragColor = uColor;}";
    public static final String TAG = "Grafika";
    public static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;attribute vec4 aPosition;void main() {    gl_Position = uMVPMatrix * aPosition;}";
    public transient /* synthetic */ FieldHolder $fh;
    public int mProgramHandle;
    public int maPositionLoc;
    public int muColorLoc;
    public int muMVPMatrixLoc;

    public FlatShadedProgram() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mProgramHandle = -1;
        this.muColorLoc = -1;
        this.muMVPMatrixLoc = -1;
        this.maPositionLoc = -1;
        int createProgram = GlUtil.createProgram(VERTEX_SHADER, FRAGMENT_SHADER);
        this.mProgramHandle = createProgram;
        if (createProgram != 0) {
            String str = "Created program " + this.mProgramHandle;
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
            this.maPositionLoc = glGetAttribLocation;
            GlUtil.checkLocation(glGetAttribLocation, "aPosition");
            int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uMVPMatrix");
            this.muMVPMatrixLoc = glGetUniformLocation;
            GlUtil.checkLocation(glGetUniformLocation, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mProgramHandle, "uColor");
            this.muColorLoc = glGetUniformLocation2;
            GlUtil.checkLocation(glGetUniformLocation2, "uColor");
            return;
        }
        throw new RuntimeException("Unable to create program");
    }

    public void draw(float[] fArr, float[] fArr2, FloatBuffer floatBuffer, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{fArr, fArr2, floatBuffer, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            GlUtil.checkGlError("draw start");
            GLES20.glUseProgram(this.mProgramHandle);
            GlUtil.checkGlError("glUseProgram");
            GLES20.glUniformMatrix4fv(this.muMVPMatrixLoc, 1, false, fArr, 0);
            GlUtil.checkGlError("glUniformMatrix4fv");
            GLES20.glUniform4fv(this.muColorLoc, 1, fArr2, 0);
            GlUtil.checkGlError("glUniform4fv ");
            GLES20.glEnableVertexAttribArray(this.maPositionLoc);
            GlUtil.checkGlError("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.maPositionLoc, i4, 5126, false, i5, (Buffer) floatBuffer);
            GlUtil.checkGlError("glVertexAttribPointer");
            GLES20.glDrawArrays(5, i2, i3);
            GlUtil.checkGlError("glDrawArrays");
            GLES20.glDisableVertexAttribArray(this.maPositionLoc);
            GLES20.glUseProgram(0);
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            GLES20.glDeleteProgram(this.mProgramHandle);
            this.mProgramHandle = -1;
        }
    }
}
