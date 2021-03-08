package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
import java.util.Map;
/* loaded from: classes6.dex */
public class GPUImageMagicBeautyFilter extends GPUImageFilter implements IFilterParams {
    public static final String FRAGMENT_SHADER = "precision highp float;\n\nuniform sampler2D inputImageTexture;\nuniform vec2 singleStepOffset; \nuniform highp vec4 params; \n\nvarying highp vec2 textureCoordinate;\n\nconst highp vec3 W = vec3(0.299,0.587,0.114);\nconst mat3 saturateMatrix = mat3(\n\t\t1.1102,-0.0598,-0.061,\n\t\t-0.0774,1.0826,-0.1186,\n\t\t-0.0228,-0.0228,1.1772);\n\t\t\nfloat hardlight(float color)\n{\n\tif(color <= 0.5)\n\t{\n\t\tcolor = color * color * 2.0;\n\t}\n\telse\n\t{\n\t\tcolor = 1.0 - color;\t\tcolor = 1.0 - color * color * 2.0;\n\t}\n\treturn color;\n}\n\nvoid main(){\n\tvec2 blurCoordinates[24];\n\t\n\tblurCoordinates[0] = textureCoordinate.xy + singleStepOffset * vec2(0.0, -10.0);\n\tblurCoordinates[1] = textureCoordinate.xy + singleStepOffset * vec2(0.0, 10.0);\n\tblurCoordinates[2] = textureCoordinate.xy + singleStepOffset * vec2(-10.0, 0.0);\n\tblurCoordinates[3] = textureCoordinate.xy + singleStepOffset * vec2(10.0, 0.0);\n\t\n\tblurCoordinates[4] = textureCoordinate.xy + singleStepOffset * vec2(5.0, -8.0);\n\tblurCoordinates[5] = textureCoordinate.xy + singleStepOffset * vec2(5.0, 8.0);\n\tblurCoordinates[6] = textureCoordinate.xy + singleStepOffset * vec2(-5.0, 8.0);\n\tblurCoordinates[7] = textureCoordinate.xy + singleStepOffset * vec2(-5.0, -8.0);\n\t\n\tblurCoordinates[8] = textureCoordinate.xy + singleStepOffset * vec2(8.0, -5.0);\n\tblurCoordinates[9] = textureCoordinate.xy + singleStepOffset * vec2(8.0, 5.0);\n\tblurCoordinates[10] = textureCoordinate.xy + singleStepOffset * vec2(-8.0, 5.0);\t\n\tblurCoordinates[11] = textureCoordinate.xy + singleStepOffset * vec2(-8.0, -5.0);\n\t\n\tblurCoordinates[12] = textureCoordinate.xy + singleStepOffset * vec2(0.0, -6.0);\n\tblurCoordinates[13] = textureCoordinate.xy + singleStepOffset * vec2(0.0, 6.0);\n\tblurCoordinates[14] = textureCoordinate.xy + singleStepOffset * vec2(6.0, 0.0);\n\tblurCoordinates[15] = textureCoordinate.xy + singleStepOffset * vec2(-6.0, 0.0);\t\n\t\n\tblurCoordinates[16] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, -4.0);\n\tblurCoordinates[17] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, 4.0);\n\tblurCoordinates[18] = textureCoordinate.xy + singleStepOffset * vec2(4.0, -4.0);\n\tblurCoordinates[19] = textureCoordinate.xy + singleStepOffset * vec2(4.0, 4.0);\n\t\n\tblurCoordinates[20] = textureCoordinate.xy + singleStepOffset * vec2(-2.0, -2.0);\n\tblurCoordinates[21] = textureCoordinate.xy + singleStepOffset * vec2(-2.0, 2.0);\n\tblurCoordinates[22] = textureCoordinate.xy + singleStepOffset * vec2(2.0, -2.0);\n\tblurCoordinates[23] = textureCoordinate.xy + singleStepOffset * vec2(2.0, 2.0);\n\t\n\t\n\tfloat sampleColor = texture2D(inputImageTexture, textureCoordinate).g * 22.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[0]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[1]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[2]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[3]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[4]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[5]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[6]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[7]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[8]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[9]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[10]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[11]).g;\n\t\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[12]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[13]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[14]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[15]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[16]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[17]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[18]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[19]).g * 2.0;\t\n\t\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[20]).g * 3.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[21]).g * 3.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[22]).g * 3.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[23]).g * 3.0;\t\n\t\t\n\tsampleColor = sampleColor / 62.0;\n\t\n\tvec3 centralColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n\t\n\tfloat highpass = centralColor.g - sampleColor + 0.5;\n\t\n\tfor(int i = 0; i < 5;i++)\n\t{\n\t\thighpass = hardlight(highpass);\n\t}\n\tfloat lumance = dot(centralColor, W);\n\t\n\tfloat alpha = pow(lumance, params.r);\n\n\tvec3 smoothColor = centralColor + (centralColor-vec3(highpass))*alpha*0.1;\n\t\n\tsmoothColor.r = clamp(pow(smoothColor.r, params.g),0.0,1.0);\n\tsmoothColor.g = clamp(pow(smoothColor.g, params.g),0.0,1.0);\n\tsmoothColor.b = clamp(pow(smoothColor.b, params.g),0.0,1.0);\n\t\n\tvec3 lvse = vec3(1.0)-(vec3(1.0)-smoothColor)*(vec3(1.0)-centralColor);\n\tvec3 bianliang = max(smoothColor, centralColor);\n\tvec3 rouguang = 2.0*centralColor*smoothColor + centralColor*centralColor - 2.0*centralColor*centralColor*smoothColor;\n\t\n\tgl_FragColor = vec4(mix(centralColor, lvse, alpha), 1.0);\n\tgl_FragColor.rgb = mix(gl_FragColor.rgb, bianliang, alpha);\n\tgl_FragColor.rgb = mix(gl_FragColor.rgb, rouguang, params.b);\n\t\n\tvec3 satcolor = gl_FragColor.rgb * saturateMatrix;\n\tgl_FragColor.rgb = mix(gl_FragColor.rgb, satcolor, params.a);\n}";
    public static final String FRAGMENT_SHADER_LOW = "precision highp float;\n\nuniform sampler2D inputImageTexture;\nuniform vec2 singleStepOffset; \nuniform highp vec4 params; \n\nvarying highp vec2 textureCoordinate;\n\nconst highp vec3 W = vec3(0.299,0.587,0.114);\nconst mat3 saturateMatrix = mat3(\n\t\t1.1102,-0.0598,-0.061,\n\t\t-0.0774,1.0826,-0.1186,\n\t\t-0.0228,-0.0228,1.1772);\n\t\t\nfloat hardlight(float color)\n{\n\tif(color <= 0.5)\n\t{\n\t\tcolor = color * color * 2.0;\n\t}\n\telse\n\t{\n\t\tcolor = 1.0 - color;\t\tcolor = 1.0 - color * color * 2.0;\n\t}\n\treturn color;\n}\n\nvoid main(){\n\tvec2 blurCoordinates[12];\n\t\n\tblurCoordinates[0] = textureCoordinate.xy + singleStepOffset * vec2(5.0, -8.0);\n\tblurCoordinates[1] = textureCoordinate.xy + singleStepOffset * vec2(5.0, 8.0);\n\tblurCoordinates[2] = textureCoordinate.xy + singleStepOffset * vec2(-5.0, 8.0);\n\tblurCoordinates[3] = textureCoordinate.xy + singleStepOffset * vec2(-5.0, -8.0);\n\t\n\tblurCoordinates[4] = textureCoordinate.xy + singleStepOffset * vec2(8.0, -5.0);\n\tblurCoordinates[5] = textureCoordinate.xy + singleStepOffset * vec2(8.0, 5.0);\n\tblurCoordinates[6] = textureCoordinate.xy + singleStepOffset * vec2(-8.0, 5.0);\t\n\tblurCoordinates[7] = textureCoordinate.xy + singleStepOffset * vec2(-8.0, -5.0);\n\t\n\tblurCoordinates[8] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, -4.0);\n\tblurCoordinates[9] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, 4.0);\n\tblurCoordinates[10] = textureCoordinate.xy + singleStepOffset * vec2(4.0, -4.0);\n\tblurCoordinates[11] = textureCoordinate.xy + singleStepOffset * vec2(4.0, 4.0);\n\t\n\tfloat sampleColor = texture2D(inputImageTexture, textureCoordinate).g * 22.0;\n\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[0]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[1]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[2]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[3]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[4]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[5]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[6]).g;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[7]).g;\n\t\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[8]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[9]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[10]).g * 2.0;\n\tsampleColor += texture2D(inputImageTexture, blurCoordinates[11]).g * 2.0;\t\n\t\n\tsampleColor = sampleColor / 38.0;\n\t\n\tvec3 centralColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n\t\n\tfloat highpass = centralColor.g - sampleColor + 0.5;\n\t\n\tfor(int i = 0; i < 5;i++)\n\t{\n\t\thighpass = hardlight(highpass);\n\t}\n\tfloat lumance = dot(centralColor, W);\n\t\n\tfloat alpha = pow(lumance, params.r);\n\n\tvec3 smoothColor = centralColor + (centralColor-vec3(highpass))*alpha*0.1;\n\t\n\tsmoothColor.r = clamp(pow(smoothColor.r, params.g),0.0,1.0);\n\tsmoothColor.g = clamp(pow(smoothColor.g, params.g),0.0,1.0);\n\tsmoothColor.b = clamp(pow(smoothColor.b, params.g),0.0,1.0);\n\t\n\tvec3 lvse = vec3(1.0)-(vec3(1.0)-smoothColor)*(vec3(1.0)-centralColor);\n\tvec3 bianliang = max(smoothColor, centralColor);\n\tvec3 rouguang = 2.0*centralColor*smoothColor + centralColor*centralColor - 2.0*centralColor*centralColor*smoothColor;\n\t\n\tgl_FragColor = vec4(mix(centralColor, lvse, alpha), 1.0);\n\tgl_FragColor.rgb = mix(gl_FragColor.rgb, bianliang, alpha);\n\tgl_FragColor.rgb = mix(gl_FragColor.rgb, rouguang, params.b);\n\t\n\tvec3 satcolor = gl_FragColor.rgb * saturateMatrix;\n\tgl_FragColor.rgb = mix(gl_FragColor.rgb, satcolor, params.a);\n}";
    private int mParamsLocation;
    private int mSingleStepOffsetLocation;
    float p0;
    float p1;
    float p2;
    float p3;

    public GPUImageMagicBeautyFilter() {
        this(false);
    }

    public GPUImageMagicBeautyFilter(boolean z) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", z ? FRAGMENT_SHADER_LOW : FRAGMENT_SHADER);
        this.p0 = 0.6f;
        this.p1 = 0.8f;
        this.p2 = 0.25f;
        this.p3 = 0.25f;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        this.mSingleStepOffsetLocation = GLES20.glGetUniformLocation(getProgram(), "singleStepOffset");
        this.mParamsLocation = GLES20.glGetUniformLocation(getProgram(), "params");
        setDefaultLevel();
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        setTexelSize(i, i2);
    }

    private void setTexelSize(float f, float f2) {
        setFloatVec2(this.mSingleStepOffsetLocation, new float[]{2.0f / f, 2.0f / f2});
    }

    public void setDefaultLevel() {
        setFloatVec4(this.mParamsLocation, new float[]{this.p0, this.p1, this.p2, this.p3});
    }

    @Override // com.yy.mediaframework.gpuimage.IFilterParams
    public void setFilterParams(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            this.p0 = getParamValue(map, "0");
            this.p1 = getParamValue(map, "1");
            this.p2 = getParamValue(map, "2");
            this.p3 = getParamValue(map, "3");
            setFloatVec4(this.mParamsLocation, new float[]{this.p0, this.p1, this.p2, this.p3});
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
