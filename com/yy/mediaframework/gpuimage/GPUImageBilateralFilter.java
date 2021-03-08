package com.yy.mediaframework.gpuimage;

import android.opengl.GLES20;
/* loaded from: classes6.dex */
public class GPUImageBilateralFilter extends GPUImageFilter {
    public static final String FRAGMENT_SHADER = "uniform sampler2D inputImageTexture;\nconst lowp int SAMPLES = 9;\nprecision highp float;\n\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[SAMPLES];\n\nuniform mediump float bilateralFilter;\nuniform mediump float contrast;\nuniform mediump float whiten;\n\nvec4 skinProcess(vec4 color)\n{\n    if(bilateralFilter == 0.0)\n    {\n        return color;\n    }\n    lowp vec4 centralColor;\n    lowp float gaussianWeightTotal;\n    lowp vec4 sum;\n    lowp vec4 sampleColor;\n    lowp float distanceFromCentralColor;\n    lowp float gaussianWeight;\n\n    centralColor = texture2D(inputImageTexture, blurCoordinates[2]);\n    gaussianWeightTotal = 0.18;\n    sum = centralColor * 0.18;\n\n    sampleColor = texture2D(inputImageTexture, blurCoordinates[0]);\n    distanceFromCentralColor = min(distance(centralColor, sampleColor) * (10.0 - bilateralFilter/20.0), 1.0);\n    gaussianWeight = 0.05 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n    sampleColor = texture2D(inputImageTexture, blurCoordinates[1]);\n    distanceFromCentralColor = min(distance(centralColor, sampleColor) * (10.0 - bilateralFilter/20.0), 1.0);\n    gaussianWeight = 0.10 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n    sampleColor = texture2D(inputImageTexture, blurCoordinates[3]);\n    distanceFromCentralColor = min(distance(centralColor, sampleColor) * (10.0 - bilateralFilter/20.0), 1.0);\n    gaussianWeight = 0.10 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n    sampleColor = texture2D(inputImageTexture, blurCoordinates[4]);\n    distanceFromCentralColor = min(distance(centralColor, sampleColor) * (10.0 - bilateralFilter/20.0), 1.0);\n    gaussianWeight = 0.05 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n    vec4 skinColor = sum / gaussianWeightTotal;\n\n    return skinColor;\n}\n\nvec4 whitenProcess(vec4 color)\n{\n    if(whiten == 0.0)\n    {\n        return color;\n    }\n    vec4 whitenColor;\n    whitenColor.r = min(color.r + whiten/255.0, 1.0);\n    whitenColor.g = min(color.g + whiten/255.0, 1.0);\n    whitenColor.b = min(color.b + whiten/255.0, 1.0);\n    whitenColor.w = 1.0;\n    return whitenColor;\n}\n\nvec4 whitenWellProcess(vec4 color)\n{\n    lowp float nWhiten_;\n    nWhiten_ = (whiten - 2.0)/7.0 + 2.0;\n    float nR = color.r;\n    float nG = color.g;\n    float nB = color.b;\n\n    float dstR = (log(nR*(nWhiten_ - 1.0) + 1.0) / log(nWhiten_));\n    float dstG = (log(nG*(nWhiten_ - 1.0) + 1.0) / log(nWhiten_));\n    float dstB = (log(nB*(nWhiten_ - 1.0) + 1.0) / log(nWhiten_));\n    return vec4(dstR, dstG, dstB, 1.0);\n}\n\nvec4 contrastProcess(vec4 color)\n{\n    if(contrast == 0.0)\n    {\n        return color;\n    }\n    vec4 contrastColor = vec4(((color.rgb - vec3(0.5)) * contrast / 25.0 + vec3(0.5)), color.w);\n    return contrastColor;\n}\n\nvoid main() {\n    vec4 base = texture2D(inputImageTexture, textureCoordinate);\n    vec4 processColor = skinProcess(base);\n    processColor = whitenWellProcess(processColor);\n    processColor = contrastProcess(processColor);\n    processColor.r = processColor.r + 3.0/255.0;\n    gl_FragColor = processColor;\n}";
    public static final String VERTEX_SHADER = "const int SAMPLES = 9;\n\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[SAMPLES];\nuniform mat4 uTexMatrix;\n\nvoid main() {\n    gl_Position = position;\n    textureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n\n    blurCoordinates[0] = vec2(textureCoordinate.x, textureCoordinate.y - texelHeightOffset * 5.0);\n    blurCoordinates[1] = vec2(textureCoordinate.x - texelWidthOffset * 5.0, textureCoordinate.y);\n    blurCoordinates[2] = textureCoordinate;\n    blurCoordinates[3] = vec2(textureCoordinate.x + texelWidthOffset * 5.0, textureCoordinate.y);\n    blurCoordinates[4] = vec2(textureCoordinate.x, textureCoordinate.y + texelHeightOffset * 5.0);\n}";
    private float mBilateral;
    private int mBilateralLocation;
    private float mContrast;
    private int mContrastLocation;
    private int mLengthScale;
    private float mWhite;
    private int mWhiteLocation;
    private boolean mWidthOrHeight;
    private int muTexelHeightOffset;
    private int muTexelWidthOffset;

    public GPUImageBilateralFilter() {
        this(100.0f, 28.0f, 10.0f, false);
    }

    public GPUImageBilateralFilter(float f, float f2, float f3, boolean z) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        this.mBilateral = 100.0f;
        this.mContrast = 28.0f;
        this.mWhite = 10.0f;
        this.mLengthScale = 16;
        this.mBilateral = f;
        this.mContrast = f2;
        this.mWhite = f3;
        this.mWidthOrHeight = z;
        this.mLengthScale = (int) (16.0d - (f * 0.08d));
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        initParam();
    }

    private void initParam() {
        this.muTexelWidthOffset = GLES20.glGetUniformLocation(getProgram(), "texelWidthOffset");
        this.muTexelHeightOffset = GLES20.glGetUniformLocation(getProgram(), "texelHeightOffset");
        this.mBilateralLocation = GLES20.glGetUniformLocation(getProgram(), "bilateralFilter");
        this.mContrastLocation = GLES20.glGetUniformLocation(getProgram(), "contrast");
        this.mWhiteLocation = GLES20.glGetUniformLocation(getProgram(), "whiten");
        if (this.mWidthOrHeight) {
            setFloat(this.muTexelWidthOffset, 1.0f / (this.mLengthScale * 30.0f));
            setFloat(this.muTexelHeightOffset, 1.0f / (this.mLengthScale * 40.0f));
            setFloat(this.mBilateralLocation, this.mBilateral);
            setFloat(this.mContrastLocation, this.mContrast);
            setFloat(this.mWhiteLocation, this.mWhite);
            return;
        }
        setFloat(this.muTexelWidthOffset, 1.0f / (this.mLengthScale * 30.0f));
        setFloat(this.muTexelHeightOffset, 1.0f / (this.mLengthScale * 40.0f));
        setFloat(this.mBilateralLocation, this.mBilateral);
        setFloat(this.mContrastLocation, this.mContrast);
        setFloat(this.mWhiteLocation, this.mWhite);
    }
}
