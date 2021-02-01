package com.yy.mediaframework.gpuimage.custom;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.yy.mediaframework.gpuimage.GPUImageFilter;
import com.yy.mediaframework.gpuimage.IFilterParams;
import com.yy.mediaframework.gpuimage.util.GLShaderProgram;
import com.yy.mediaframework.sensor.RotationVectorSensor;
import com.yy.mediaframework.stat.VideoDataStatUtil;
import com.yy.mediaframework.stat.YMFLiveStatisticManager;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Map;
/* loaded from: classes4.dex */
public class GPUImageBeautyFilter extends GPUImageFilter implements IFilterParams {
    private static final String TAG = "GPUImageBeautyFilter";
    public static final String noeffect_vs = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}";
    public static final String passthrouth_fs = "precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture0;\n\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}";
    public static final String passthrouth_vs = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}";
    private String framentShader_2d;
    private IGPUProcess mGPUImageProcess;
    private GPUImageBeautyControl mGpuImageBeautyControl;
    private GLShaderProgram mNoEffectShader;
    private RotationVectorSensor mRotationVectorSensor;
    private FloatBuffer mTextureBuffer;
    private YMFVideoFrame mYMFVideoFrame;
    public static String noeffect_fs = "precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture0;\n\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}";
    public static String noeffectOes_fs = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTexCoord;\nuniform samplerExternalOES uTexture0;\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}";

    public GPUImageBeautyFilter(RotationVectorSensor rotationVectorSensor, GPUImageBeautyControl gPUImageBeautyControl) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        this.framentShader_2d = "precision mediump float;\nvarying vec2 vTexCoord;\nuniform sampler2D uTexture0;\n\nvoid main()\n{\n    vec4 color = texture2D(uTexture0, vTexCoord);\n    gl_FragColor = color; //vec4(color.y, color.y, color.y, 1.0);\n}";
        this.mRotationVectorSensor = null;
        this.mGpuImageBeautyControl = null;
        this.mNoEffectShader = null;
        this.mGPUImageProcess = null;
        this.mTextureBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mYMFVideoFrame = new YMFVideoFrame();
        YMFLog.info(this, "[Beauty  ]", "GPUImageBeautyFilter construct");
        this.mRotationVectorSensor = rotationVectorSensor;
        this.mGpuImageBeautyControl = gPUImageBeautyControl;
        setGPUImageProcess();
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void checkTextureTypeUpdate(int i) {
        if (this.mTextureTarget != i && this.mNoEffectShader != null) {
            YMFLog.info(this, "[Beauty  ]", "checkTextureTypeUpdate " + this.mTextureTarget + ":" + i);
            this.mNoEffectShader.destory();
            this.mTextureTarget = i;
            this.mNoEffectShader = new GLShaderProgram();
            this.mNoEffectShader.setProgram("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}", this.framentShader_2d);
        }
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        YMFLog.info(this, "[Beauty  ]", "onInit");
        super.onInit();
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onDestroy() {
        YMFLog.info(this, "[Beauty  ]", MissionEvent.MESSAGE_DESTROY);
        super.onDestroy();
        this.mYMFVideoFrame.mYUVCaptureBuffer = null;
        if (this.mGPUImageProcess != null) {
            this.mGPUImageProcess.onDestroy();
        } else {
            this.mNoEffectShader.destory();
        }
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    @TargetApi(15)
    public void onInitExt(boolean z) {
        YMFLog.info(this, "[Beauty  ]", "onInitExt isForExternalTextureInput:" + z);
        this.mTextureTarget = 3553;
        if (z) {
            this.mTextureTarget = 36197;
        }
        if (this.mGPUImageProcess != null) {
            this.mYMFVideoFrame.mTextureWidth = this.mOutputWidth;
            this.mYMFVideoFrame.mTextureHeight = this.mOutputHeight;
            this.mGPUImageProcess.onInit(this.mTextureTarget, this.mOutputWidth, this.mOutputHeight);
        } else {
            this.mNoEffectShader = new GLShaderProgram();
            if (this.mTextureTarget == 36197) {
                this.mNoEffectShader.setProgram("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}", noeffectOes_fs);
            } else {
                this.mNoEffectShader.setProgram("attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTexCoord;\n\nvoid main()\n{\n    gl_Position = aPosition;\n    vTexCoord = aTextureCoord.xy;\n}", noeffect_fs);
            }
        }
        this.mIsInitialized = true;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onDraw(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i2, float[] fArr, boolean z, byte[] bArr, long j) {
        YMFLiveStatisticManager.getInstance().endCalcPureCap2PreProcessLatency();
        if (this.mGPUImageProcess != null) {
            FloatBuffer positionTransform = positionTransform(floatBuffer2, fArr);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                if (this.mGPUImageProcess instanceof IYMFGpuProcess) {
                    this.mYMFVideoFrame.mTextureId = i;
                    this.mYMFVideoFrame.mTextureCoord = positionTransform;
                    this.mYMFVideoFrame.mYUVCaptureBuffer = bArr;
                    this.mYMFVideoFrame.mIndex = j;
                    ((IYMFGpuProcess) this.mGPUImageProcess).onDraw(this.mYMFVideoFrame);
                } else {
                    this.mGPUImageProcess.onDraw(i, positionTransform);
                }
            } catch (Exception e) {
                YMFLog.error(this, "[Beauty  ]", " ui code error " + e.toString());
            }
            YMFLiveStatisticManager.getInstance().calcPurePreProcessLatency(currentTimeMillis);
            VideoDataStatUtil.putBeautyTime(System.currentTimeMillis() - currentTimeMillis);
            return;
        }
        FloatBuffer positionTransform2 = positionTransform(floatBuffer2, fArr);
        this.mNoEffectShader.useProgram();
        this.mNoEffectShader.setUniformTexture("uTexture0", 0, i, this.mTextureTarget);
        drawQuad(this.mNoEffectShader, floatBuffer, positionTransform2);
        GLES20.glBindTexture(this.mTextureTarget, 0);
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onOutputSizeChanged(int i, int i2) {
        YMFLog.info(this, "[Beauty  ]", "onOutputSizeChanged width:" + i + " ,height:" + i2);
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
        this.mYMFVideoFrame.mTextureWidth = i;
        this.mYMFVideoFrame.mTextureHeight = i2;
        if (this.mGPUImageProcess != null) {
            this.mGPUImageProcess.onOutputSizeChanged(i, i2);
        }
    }

    private void xyTransform(float[] fArr, int i, float[] fArr2, int i2, float[] fArr3) {
        fArr[i] = (fArr3[0] * fArr2[i2]) + (fArr3[4] * fArr2[i2 + 1]) + fArr3[12];
        fArr[i + 1] = (fArr3[1] * fArr2[i2]) + (fArr3[5] * fArr2[i2 + 1]) + fArr3[13];
    }

    private FloatBuffer positionTransform(FloatBuffer floatBuffer, float[] fArr) {
        float[] fArr2 = new float[8];
        float[] fArr3 = new float[8];
        floatBuffer.get(fArr3);
        floatBuffer.position(0);
        for (int i = 0; i < fArr2.length; i += 2) {
            xyTransform(fArr2, i, fArr3, i, fArr);
        }
        this.mTextureBuffer.put(fArr2).position(0);
        return this.mTextureBuffer;
    }

    private void drawQuad(GLShaderProgram gLShaderProgram, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        floatBuffer.position(0);
        gLShaderProgram.setVertexAttribPointer("aPosition", 2, 5126, false, 0, floatBuffer);
        floatBuffer2.position(0);
        gLShaderProgram.setVertexAttribPointer("aTextureCoord", 2, 5126, false, 0, floatBuffer2);
        GLES20.glDrawArrays(5, 0, 4);
        gLShaderProgram.disableVertexAttribPointer("aPosition");
        gLShaderProgram.disableVertexAttribPointer("aTextureCoord");
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onBeautyParamChanged() {
    }

    @Override // com.yy.mediaframework.gpuimage.IFilterParams
    public void setFilterParams(Map<String, String> map) {
    }

    public void setGPUImageProcess() {
        this.mGPUImageProcess = this.mGpuImageBeautyControl.getGPUImageBeautyFilter();
    }
}
