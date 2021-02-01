package com.yy.mediaframework.gpuimage;
/* loaded from: classes4.dex */
public class GPUImageBeautyFaceFilter extends GPUImageTwoPassTextureFilter {
    public static final String FRAGMENT_SHADER = " uniform     sampler2D inputImageTexture;\n const       lowp      int   GAUSSIN_SAMPLES = 9;\n varying     highp     vec2    textureCoordinate;\n varying     highp     vec2    blurCoordinates[GAUSSIN_SAMPLES];\n\n uniform     mediump   float  distanceNormalizationFactor;\n uniform     mediump     float        gamaVal;\n\nvoid main()\n{\n    lowp vec4 centralColor;\n    lowp float gaussianWeightTotal;\n    lowp vec4 sum;\n    lowp vec4 sampleColor;\n    lowp float distanceFromCentralColor;\n    lowp float gaussianWeight;\n\n    //get right value\n\n    centralColor   = texture2D(inputImageTexture, blurCoordinates[4]);\n    gaussianWeightTotal = 0.50;\n    sum            = centralColor * 0.50;\n\n    //sampleColor 0\n    sampleColor    = texture2D(inputImageTexture, blurCoordinates[0]);\n    distanceFromCentralColor = min(distance(centralColor, sampleColor) * distanceNormalizationFactor, 1.0);\n    gaussianWeight = 0.08 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n\n    //sampleColor 1\n    sampleColor    = texture2D(inputImageTexture, blurCoordinates[1]);\n    distanceFromCentralColor   = min(distance(centralColor, sampleColor)*distanceNormalizationFactor, 1.0);\n    gaussianWeight = 0.10 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n    //sampleColor 2\n    sampleColor    = texture2D(inputImageTexture, blurCoordinates[2]);\n    distanceFromCentralColor   = min(distance(centralColor, sampleColor)*distanceNormalizationFactor, 1.0);\n    gaussianWeight = 0.12 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n    //sampleColor 3\n    sampleColor    = texture2D(inputImageTexture, blurCoordinates[3]);\n    distanceFromCentralColor   = min(distance(centralColor, sampleColor)*distanceNormalizationFactor, 1.0);\n    gaussianWeight = 0.18 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n    //sampleColor 5\n    sampleColor    = texture2D(inputImageTexture, blurCoordinates[5]);\n    distanceFromCentralColor   = min(distance(centralColor, sampleColor)*distanceNormalizationFactor, 1.0);\n    gaussianWeight = 0.18 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n    //sampleColor 6\n    sampleColor    = texture2D(inputImageTexture, blurCoordinates[6]);\n    distanceFromCentralColor   = min(distance(centralColor, sampleColor)*distanceNormalizationFactor, 1.0);\n    gaussianWeight = 0.12 * (1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n    //sampleColor 7\n    sampleColor    = texture2D(inputImageTexture, blurCoordinates[7]);\n    distanceFromCentralColor   = min(distance(centralColor, sampleColor)*distanceNormalizationFactor, 1.0);\n    gaussianWeight = 0.10*(1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n    //sampleColor 8\n    sampleColor    = texture2D(inputImageTexture, blurCoordinates[8]);\n    distanceFromCentralColor   = min(distance(centralColor, sampleColor)*distanceNormalizationFactor, 1.0);\n    gaussianWeight = 0.08*(1.0 - distanceFromCentralColor);\n    gaussianWeightTotal += gaussianWeight;\n    sum += sampleColor * gaussianWeight;\n\n    ///do gama filter\n    highp vec4  textureColor = texture2D(inputImageTexture, textureCoordinate);\n    textureColor = sum/gaussianWeightTotal;\n\n    gl_FragColor = vec4(pow( textureColor.rgb, vec3(gamaVal) ), textureColor.w);\n\n}\n";
    public static final String VERTEX_SHADER = "const int GAUSSIAN_SAMPLES = 9;\n\nattribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[GAUSSIAN_SAMPLES];\nuniform mat4 uTexMatrix;\n\nvoid main()\n{\n\tgl_Position = position;\n\ttextureCoordinate = (uTexMatrix * inputTextureCoordinate).xy;\n\t\n\t// Calculate the positions for the blur\n\tint multiplier = 0;\n\tvec2 blurStep;\n   vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n    \n\tfor (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n   {\n\t\tmultiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n       // Blur in x (horizontal)\n       blurStep = float(multiplier) * singleStepOffset;\n\t\tblurCoordinates[i] = (uTexMatrix * inputTextureCoordinate).xy + blurStep;\n\t}\n}\n";
    protected float mBlurSize;
    protected float mGama;

    public GPUImageBeautyFaceFilter() {
        this(1.0f);
    }

    public GPUImageBeautyFaceFilter(float f) {
        super(VERTEX_SHADER, FRAGMENT_SHADER, VERTEX_SHADER, FRAGMENT_SHADER);
        this.mBlurSize = 1.0f;
        this.mGama = 0.9f;
        this.mBlurSize = f;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageTwoPassTextureFilter
    public float getVerticalTexelOffsetRatio() {
        return this.mBlurSize;
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageTwoPassTextureFilter
    public float getHorizontalTexelOffsetRatio() {
        return this.mBlurSize;
    }

    public float getGamaValue() {
        return this.mGama;
    }

    public void setBlurSize(float f) {
        this.mBlurSize = f;
        runOnDraw(new Runnable() { // from class: com.yy.mediaframework.gpuimage.GPUImageBeautyFaceFilter.1
            @Override // java.lang.Runnable
            public void run() {
                GPUImageBeautyFaceFilter.this.initTexelOffsets();
            }
        });
    }
}
