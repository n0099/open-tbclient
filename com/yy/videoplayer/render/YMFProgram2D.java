package com.yy.videoplayer.render;
/* loaded from: classes4.dex */
public class YMFProgram2D extends YMFProgramBase {
    private static String FRAGMENT_SHADER = "precision mediump float;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoordWater;\nuniform sampler2D uTexture0;\nuniform sampler2D uTextureWater;\nuniform int uWaterMarkEnabled;\n\nvoid main()\n{\n    vec4 outputColor = texture2D(uTexture0, vTextureCoord);\n    if (uWaterMarkEnabled == 1) {\n        vec4 overlay = texture2D(uTextureWater, vTextureCoordWater);\n        outputColor.r = overlay.r + outputColor.r * outputColor.a * (1.0 - overlay.a);\n        outputColor.g = overlay.g + outputColor.g * outputColor.a * (1.0 - overlay.a);\n        outputColor.b = overlay.b + outputColor.b * outputColor.a * (1.0 - overlay.a);\n        outputColor.a = overlay.a + outputColor.a * (1.0 - overlay.a);\n    }\n    gl_FragColor = outputColor; //vec4(color.y, color.y, color.y, 1.0);\n}";
    public static final String FRAGMENT_SHADER_2D = "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nattribute vec4 aTextureCoordWater;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoordWater;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n    vTextureCoordWater = (aTextureCoordWater).xy;\n}\n";
    public static final String VERTEX_SHADER_2D = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
    private boolean mEnableWaterMark;

    public YMFProgram2D() {
        super("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.mEnableWaterMark = false;
    }

    @Override // com.yy.videoplayer.render.IProgram
    public int programType() {
        return 0;
    }

    @Override // com.yy.videoplayer.render.YMFProgramBase
    protected void onSetAttributeValue() {
        setVertexAttribPointer("aPosition", 2, 5126, false, getVertexCoordStride(), getVertexCoordData());
        setVertexAttribPointer("aTextureCoord", 2, 5126, false, getTextureCoordStride(), getTextureCoordData());
    }

    @Override // com.yy.videoplayer.render.YMFProgramBase
    protected void onSetUniformValue() {
        setUniformMatrix4fv("uMVPMatrix", 1, false, getVertexMatrix(), 0);
        setUniformMatrix4fv("uTexMatrix", 1, false, getTextureMatrix(), 0);
    }

    @Override // com.yy.videoplayer.render.YMFProgramBase
    protected void onUnSetAttributeValue() {
        unSetVertexAttribPointer("aPosition");
        unSetVertexAttribPointer("aTextureCoord");
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void enableWaterMarker(boolean z) {
        this.mEnableWaterMark = z;
    }
}
