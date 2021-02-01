package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
import java.util.Map;
/* loaded from: classes4.dex */
public class GPUImageSkinWhiteFilter extends GPUImageFilter implements IFilterParams {
    public static final String FRAGMENT_SHADER = " precision highp float;\n \n varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform float white;\n \n float logCurve(float color)\n {\n     return log(color * (white - 1.0) + 1.0) / log(white);\n }\n \n void main()\n {\n     vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     float r = logCurve(textureColor.r);\n     float g = logCurve(textureColor.g);\n     float b = logCurve(textureColor.b);\n     gl_FragColor = vec4(r, g, b, 1.0);\n }";
    private float mWhite;
    private int mWhiteLocation;

    public GPUImageSkinWhiteFilter(float f) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", FRAGMENT_SHADER);
        this.mWhite = 0.2f;
        this.mWhite = f;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        this.mWhiteLocation = GLES20.glGetUniformLocation(getProgram(), "white");
        setFloat(this.mWhiteLocation, getWhite());
    }

    @Override // com.yy.mediaframework.gpuimage.IFilterParams
    public void setFilterParams(Map<String, String> map) {
        this.mWhite = getParamValue(map, "3");
        setFloat(this.mWhiteLocation, getWhite());
    }

    private float getWhite() {
        return 1.05f + (this.mWhite * 2.0f);
    }

    private float getParamValue(Map<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 != null) {
            try {
                return Float.valueOf(str2).floatValue();
            } catch (NumberFormatException e) {
                return 0.0f;
            }
        }
        return 0.0f;
    }
}
