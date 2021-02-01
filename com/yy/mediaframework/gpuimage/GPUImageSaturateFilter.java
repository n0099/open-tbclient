package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
import java.util.Map;
/* loaded from: classes4.dex */
public class GPUImageSaturateFilter extends GPUImageFilter implements IFilterParams {
    public static final String FRAGMENT_SHADER = "precision highp float;\n\nvarying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform float params; \n\nconst mat3 saturateMatrix = mat3(\n\t\t1.1102,-0.0598,-0.061,\n\t\t-0.0774,1.0826,-0.1186,\n\t\t-0.0228,-0.0228,1.1772);\n\t\t\n\nvoid main(){\n\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n     vec3 satcolor = gl_FragColor.rgb * saturateMatrix;\n     gl_FragColor.rgb = mix(gl_FragColor.rgb, satcolor, params);\n}";
    private int mParamsLocation;
    float p;

    public GPUImageSaturateFilter() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", FRAGMENT_SHADER);
        this.p = 0.1f;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        this.mParamsLocation = GLES20.glGetUniformLocation(getProgram(), "params");
        setDefaultLevel();
    }

    public void setDefaultLevel() {
        setFloat(this.mParamsLocation, this.p);
    }

    @Override // com.yy.mediaframework.gpuimage.IFilterParams
    public void setFilterParams(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.p = getParamValue(map, "3");
            setFloat(this.mParamsLocation, this.p);
        }
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
