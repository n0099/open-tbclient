package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
import java.util.Map;
/* loaded from: classes6.dex */
public class GPUImageMagicBeautyNewFilter extends GPUImageFilter implements IFilterParams {
    public static final String FRAGMENT_SHADER = "precision mediump float;\n\nvarying mediump vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform vec2 singleStepOffset;\nuniform highp vec4 params; \n\nconst highp vec3 W = vec3(0.299,0.587,0.114);\nvec2 blurCoordinates[20];\n\nfloat hardLight(float color)\n{\n\tif(color <= 0.5)\n\t\tcolor = color * color * 2.0;\n\telse\n\t\tcolor = 1.0 - ((1.0 - color)*(1.0 - color) * 2.0);\n\treturn color;\n}\n\nvoid main(){\n\n    vec3 centralColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n    blurCoordinates[0] = textureCoordinate.xy + singleStepOffset * vec2(0.0, -10.0);\n    blurCoordinates[1] = textureCoordinate.xy + singleStepOffset * vec2(0.0, 10.0);\n    blurCoordinates[2] = textureCoordinate.xy + singleStepOffset * vec2(-10.0, 0.0);\n    blurCoordinates[3] = textureCoordinate.xy + singleStepOffset * vec2(10.0, 0.0);\n    blurCoordinates[4] = textureCoordinate.xy + singleStepOffset * vec2(5.0, -8.0);\n    blurCoordinates[5] = textureCoordinate.xy + singleStepOffset * vec2(5.0, 8.0);\n    blurCoordinates[6] = textureCoordinate.xy + singleStepOffset * vec2(-5.0, 8.0);\n    blurCoordinates[7] = textureCoordinate.xy + singleStepOffset * vec2(-5.0, -8.0);\n    blurCoordinates[8] = textureCoordinate.xy + singleStepOffset * vec2(8.0, -5.0);\n    blurCoordinates[9] = textureCoordinate.xy + singleStepOffset * vec2(8.0, 5.0);\n    blurCoordinates[10] = textureCoordinate.xy + singleStepOffset * vec2(-8.0, 5.0);\n    blurCoordinates[11] = textureCoordinate.xy + singleStepOffset * vec2(-8.0, -5.0);\n    blurCoordinates[12] = textureCoordinate.xy + singleStepOffset * vec2(0.0, -6.0);\n    blurCoordinates[13] = textureCoordinate.xy + singleStepOffset * vec2(0.0, 6.0);\n    blurCoordinates[14] = textureCoordinate.xy + singleStepOffset * vec2(6.0, 0.0);\n    blurCoordinates[15] = textureCoordinate.xy + singleStepOffset * vec2(-6.0, 0.0);\n    blurCoordinates[16] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, -4.0);\n    blurCoordinates[17] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, 4.0);\n    blurCoordinates[18] = textureCoordinate.xy + singleStepOffset * vec2(4.0, -4.0);\n    blurCoordinates[19] = textureCoordinate.xy + singleStepOffset * vec2(4.0, 4.0);\n\n    float sampleColor = centralColor.g * 20.0;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[0]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[1]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[2]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[3]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[4]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[5]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[6]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[7]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[8]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[9]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[10]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[11]).g;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[12]).g * 2.0;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[13]).g * 2.0;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[14]).g * 2.0;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[15]).g * 2.0;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[16]).g * 2.0;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[17]).g * 2.0;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[18]).g * 2.0;\n    sampleColor += texture2D(inputImageTexture, blurCoordinates[19]).g * 2.0;\n\n    sampleColor = sampleColor / 48.0;\n\n    float highPass = centralColor.g - sampleColor + 0.5;\n\n    for(int i = 0; i < 5;i++)\n    {\n        highPass = hardLight(highPass);\n    }\n    float luminance = dot(centralColor, W);\n\n    float alpha = pow(luminance, params.r);\n\n    vec3 smoothColor = centralColor + (centralColor-vec3(highPass))*alpha*0.15*params.g;\n\n    gl_FragColor = vec4(mix(smoothColor.rgb, max(smoothColor, centralColor), alpha), 1.0);\n}";
    public static final String FRAGMENT_SHADER_LOW = "precision mediump float;\n\nvarying mediump vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform vec2 singleStepOffset;\nuniform highp vec4 params;\n\nconst highp vec3 W = vec3(0.299,0.587,0.114);\nconst mat3 saturateMatrix = mat3(\n\t\t1.1102,-0.0598,-0.061,\n\t\t-0.0774,1.0826,-0.1186,\n\t\t-0.0228,-0.0228,1.1772);\nvec2 blurCoordinates[20];\n\nfloat hardLight(float color)\n{\n\tif(color <= 0.5)\n\t\tcolor = color * color * 2.0;\n\telse\n\t{\n\t\tcolor = 1.0 - color;\n\t\tcolor = 1.0 - color * color * 2.0;\n\t}\n\treturn color;\n}\n\nint isSkin(vec3 color)\n{\n\tint result = 0;\n\tif(color.r > 0.373 && color.g > 0.157 && color.b > 0.078 && color.r > color.b && color.r > color.g && abs(color.r - color.b) > 0.059)\n\t{\n\t}\n\telse\n\t{\n\t\tresult = 1;\n\t}\n\treturn result;\n}\n\nfloat skinColor(float centralColor, vec4 color)\n{\n\tfloat result = 0.5;\n\tif(color.r > 0.373 && color.g > 0.157 && color.b > 0.078 && color.r > color.b && color.r > color.g && abs(color.r - color.b) > 0.059)\n\t{\n\t\tresult=color.g;\n\t}\n\telse\n\t{\n\t\tresult=centralColor;\n\t}\n\treturn result;\n}\n\nvoid main(){\n\n    vec3 centralColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n    int result = isSkin(centralColor);\n    if (result == 0)\n    {\n    blurCoordinates[0] = textureCoordinate.xy + singleStepOffset * vec2(5.0, -8.0);\n    blurCoordinates[1] = textureCoordinate.xy + singleStepOffset * vec2(5.0, 8.0);\n    blurCoordinates[2] = textureCoordinate.xy + singleStepOffset * vec2(-5.0, 8.0);\n    blurCoordinates[3] = textureCoordinate.xy + singleStepOffset * vec2(-5.0, -8.0);\n    blurCoordinates[4] = textureCoordinate.xy + singleStepOffset * vec2(0.0, -6.0);\n    blurCoordinates[5] = textureCoordinate.xy + singleStepOffset * vec2(0.0, 6.0);\n    blurCoordinates[6] = textureCoordinate.xy + singleStepOffset * vec2(6.0, 0.0);\n    blurCoordinates[7] = textureCoordinate.xy + singleStepOffset * vec2(-6.0, 0.0);\n    blurCoordinates[8] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, -4.0);\n    blurCoordinates[9] = textureCoordinate.xy + singleStepOffset * vec2(-4.0, 4.0);\n    blurCoordinates[10] = textureCoordinate.xy + singleStepOffset * vec2(4.0, -4.0);\n    blurCoordinates[11] = textureCoordinate.xy + singleStepOffset * vec2(4.0, 4.0);\n\n    float sampleColor = centralColor.g * 5.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[0])) * 2.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[1])) * 2.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[2])) * 2.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[3])) * 2.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[4])) * 4.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[5])) * 4.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[6])) * 4.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[7])) * 4.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[8])) * 4.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[9])) * 4.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[10])) * 4.0;\n    sampleColor += skinColor(centralColor.g, texture2D(inputImageTexture, blurCoordinates[11])) * 4.0;\n\n    sampleColor = sampleColor / 45.0;\n\n    float highPass = centralColor.g - sampleColor + 0.5;\n\n    for(int i = 0; i < 5;i++)\n    {\n        highPass = hardLight(highPass);\n    }\n    float luminance = dot(centralColor, W);\n\n    float alpha = pow(luminance, 1.0);\n\n    vec3 smoothColor = centralColor + (centralColor-vec3(highPass))*alpha*0.1*params.g;\n    gl_FragColor = vec4(mix(smoothColor.rgb, max(smoothColor, centralColor), alpha), 1.0);\n    vec3 lvse = vec3(1.0)-(vec3(1.0)-smoothColor)*(vec3(1.0)-centralColor);\n    gl_FragColor.rgb = mix(gl_FragColor.rgb, lvse, alpha*0.1);\n    vec3 satcolor = gl_FragColor.rgb * saturateMatrix;\n    gl_FragColor.rgb = mix(gl_FragColor.rgb, satcolor, 0.09);\n    }\n    else\n    {\n    gl_FragColor = vec4(centralColor, 1.0);    }\n}";
    private int mParamsLocation;
    private int mSingleStepOffsetLocation;
    float p0;
    float p1;
    float p2;
    float p3;

    public GPUImageMagicBeautyNewFilter() {
        this(false);
    }

    public GPUImageMagicBeautyNewFilter(boolean z) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 uTexMatrix;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n}", z ? FRAGMENT_SHADER_LOW : FRAGMENT_SHADER);
        this.p0 = 1.0f;
        this.p1 = 1.0f;
        this.p2 = 0.25f;
        this.p3 = 0.1f;
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
