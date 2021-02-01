package com.yy.mediaframework.opengles;
/* loaded from: classes4.dex */
public class YMFProgramOES extends YMFProgramBase {
    public static String fragmentShader = "#extension GL_OES_EGL_image_external : require                     \nprecision mediump float;                                           \nvarying vec2 vTextureCoord;                                        \nuniform samplerExternalOES uTexture0;                              \nvoid main()                                                        \n{                                                                  \n    vec4 color = texture2D(uTexture0, vTextureCoord);              \n    gl_FragColor = color;                                          \n}";
    public static final String vertexShader = "uniform mat4 uMVPMatrix;           \nuniform mat4 uTexMatrix;           \nattribute vec4 aPosition;          \nattribute vec4 aTextureCoord;      \nvarying vec2 vTextureCoord;        \nvoid main()                        \n{                                  \n    gl_Position = uMVPMatrix * aPosition;       \n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;  \n}";
    private boolean mEnableWaterMark;

    public YMFProgramOES() {
        super(vertexShader, fragmentShader);
        this.mEnableWaterMark = false;
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public int programType() {
        return 4;
    }

    @Override // com.yy.mediaframework.opengles.YMFProgramBase
    protected void onSetAttributeValue() {
        setVertexAttribPointer("aPosition", 2, 5126, false, getVertexCoordStride(), getVertexCoordData());
        setVertexAttribPointer("aTextureCoord", 2, 5126, false, getTextureCoordStride(), getTextureCoordData());
    }

    @Override // com.yy.mediaframework.opengles.YMFProgramBase
    protected void onSetUniformValue() {
        setUniformMatrix4fv("uMVPMatrix", 1, false, getVertexMatrix(), 0);
        setUniformMatrix4fv("uTexMatrix", 1, false, getTextureMatrix(), 0);
        setUniform1i("uTexture0", 0);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void enableWaterMarker(boolean z) {
    }
}
