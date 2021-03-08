package com.yy.mediaframework.opengles;
/* loaded from: classes6.dex */
public class YMFProgramI420 extends YMFProgramBase {
    private static final String FRAGMENT_SHADER_YUV420P = "precision highp float;varying vec2 vTextureCoord;varying vec2 vTextureCoordWater;\nuniform sampler2D tex_y;uniform sampler2D tex_u;uniform sampler2D tex_v;uniform sampler2D uTextureWater;\nuniform int uWaterMarkEnabled;\nvoid main() {    vec3 yuv;    yuv.x = texture2D(tex_y, vTextureCoord).r;    yuv.y = texture2D(tex_u, vTextureCoord).r - 0.5;    yuv.z = texture2D(tex_v, vTextureCoord).r - 0.5;    yuv.x = 1.1643 * yuv.x - 0.0728;    vec3 rgb = vec3(        yuv.x + 1.5958 * yuv.z,        yuv.x - 0.39173 * yuv.y - 0.8129 * yuv.z,        yuv.x + 2.017 * yuv.y    );    vec4 outputColor = vec4(rgb, 1);    if (uWaterMarkEnabled == 1) {\n        vec4 overlay = texture2D(uTextureWater, vTextureCoordWater);\n        outputColor.r = overlay.r + outputColor.r * outputColor.a * (1.0 - overlay.a);\n        outputColor.g = overlay.g + outputColor.g * outputColor.a * (1.0 - overlay.a);\n        outputColor.b = overlay.b + outputColor.b * outputColor.a * (1.0 - overlay.a);\n        outputColor.a = overlay.a + outputColor.a * (1.0 - overlay.a);\n    }\n    gl_FragColor = outputColor;}";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nattribute vec4 aTextureCoordWater;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoordWater;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n    vTextureCoordWater = (aTextureCoordWater).xy;\n}\n";
    private boolean mEnableWaterMark;

    public YMFProgramI420() {
        super(VERTEX_SHADER, FRAGMENT_SHADER_YUV420P);
        this.mEnableWaterMark = false;
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public int programType() {
        return 3;
    }

    @Override // com.yy.mediaframework.opengles.YMFProgramBase
    protected void onSetAttributeValue() {
        setVertexAttribPointer("aPosition", 2, 5126, false, getVertexCoordStride(), getVertexCoordData());
        setVertexAttribPointer("aTextureCoord", 2, 5126, false, getTextureCoordStride(), getTextureCoordData());
        setVertexAttribPointer("aTextureCoordWater", 2, 5126, false, getTextureCoordStride(), getWaterMarkCoordData());
    }

    @Override // com.yy.mediaframework.opengles.YMFProgramBase
    protected void onSetUniformValue() {
        setUniformMatrix4fv("uMVPMatrix", 1, false, getVertexMatrix(), 0);
        setUniformMatrix4fv("uTexMatrix", 1, false, getTextureMatrix(), 0);
        setUniform1i("tex_y", 0);
        setUniform1i("tex_u", 1);
        setUniform1i("tex_v", 2);
        if (this.mEnableWaterMark) {
            setUniform1i("uWaterMarkEnabled", 1);
        } else {
            setUniform1i("uWaterMarkEnabled", 0);
        }
        setUniform1i("uTextureWater", 3);
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public void enableWaterMarker(boolean z) {
        this.mEnableWaterMark = z;
    }
}
