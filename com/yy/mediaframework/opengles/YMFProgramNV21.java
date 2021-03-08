package com.yy.mediaframework.opengles;
/* loaded from: classes6.dex */
public class YMFProgramNV21 extends YMFProgramBase {
    private static final String FRAGMENT_SHADER_NV21 = "precision highp float;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoordWater;\nuniform sampler2D tex_y;\nuniform sampler2D tex_uv;\nuniform sampler2D uTextureWater;\nuniform int uWaterMarkEnabled;\nvoid main (void) {\n    vec3 yuv;\n    yuv.x = texture2D(tex_y, vTextureCoord).r;\n    yuv.y = texture2D(tex_uv, vTextureCoord).a - 0.5;\n    yuv.z = texture2D(tex_uv, vTextureCoord).r - 0.5;\n    yuv.x = 1.1643 * yuv.x - 0.0728;\n    vec3 rgb = vec3(\n        yuv.x + 1.5958 * yuv.z,        yuv.x - 0.39173 * yuv.y - 0.8129 * yuv.z,        yuv.x + 2.017 * yuv.y    );\n    vec4 outputColor = vec4(rgb, 1);    if (uWaterMarkEnabled == 1) {\n        vec4 overlay = texture2D(uTextureWater, vTextureCoordWater);\n        outputColor.r = overlay.r + outputColor.r * outputColor.a * (1.0 - overlay.a);\n        outputColor.g = overlay.g + outputColor.g * outputColor.a * (1.0 - overlay.a);\n        outputColor.b = overlay.b + outputColor.b * outputColor.a * (1.0 - overlay.a);\n        outputColor.a = overlay.a + outputColor.a * (1.0 - overlay.a);\n    }\n    gl_FragColor = outputColor;}";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nattribute vec4 aTextureCoordWater;\nvarying vec2 vTextureCoord;\nvarying vec2 vTextureCoordWater;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n    vTextureCoordWater = (aTextureCoordWater).xy;\n}\n";
    private boolean mEnableWaterMark;

    public YMFProgramNV21() {
        super(VERTEX_SHADER, FRAGMENT_SHADER_NV21);
        this.mEnableWaterMark = false;
    }

    @Override // com.yy.mediaframework.opengles.IProgram
    public int programType() {
        return 1;
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
        setUniform1i("tex_uv", 1);
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
