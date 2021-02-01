package com.yy.videoplayer.render;
/* loaded from: classes4.dex */
public class YMFProgramI420 extends YMFProgramBase {
    private static final String FRAGMENT_SHADER_YUV420P = "precision highp float;varying vec2 vTextureCoord;uniform sampler2D tex_y;uniform sampler2D tex_u;uniform sampler2D tex_v;void main() {    vec3 yuv;    yuv.x = texture2D(tex_y, vTextureCoord).r;    yuv.y = texture2D(tex_u, vTextureCoord).r - 0.5;    yuv.z = texture2D(tex_v, vTextureCoord).r - 0.5;    yuv.x = 1.1643 * yuv.x - 0.0728;    vec3 rgb = vec3(        yuv.x + 1.5958 * yuv.z,        yuv.x - 0.39173 * yuv.y - 0.8129 * yuv.z,        yuv.x + 2.017 * yuv.y    );    gl_FragColor = vec4(rgb, 1);}";
    private static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";

    public YMFProgramI420() {
        super("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision highp float;varying vec2 vTextureCoord;uniform sampler2D tex_y;uniform sampler2D tex_u;uniform sampler2D tex_v;void main() {    vec3 yuv;    yuv.x = texture2D(tex_y, vTextureCoord).r;    yuv.y = texture2D(tex_u, vTextureCoord).r - 0.5;    yuv.z = texture2D(tex_v, vTextureCoord).r - 0.5;    yuv.x = 1.1643 * yuv.x - 0.0728;    vec3 rgb = vec3(        yuv.x + 1.5958 * yuv.z,        yuv.x - 0.39173 * yuv.y - 0.8129 * yuv.z,        yuv.x + 2.017 * yuv.y    );    gl_FragColor = vec4(rgb, 1);}");
    }

    @Override // com.yy.videoplayer.render.IProgram
    public int programType() {
        return 3;
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
        setUniform1i("tex_y", 0);
        setUniform1i("tex_u", 1);
        setUniform1i("tex_v", 2);
    }

    @Override // com.yy.videoplayer.render.YMFProgramBase
    protected void onUnSetAttributeValue() {
        unSetVertexAttribPointer("aPosition");
        unSetVertexAttribPointer("aTextureCoord");
    }

    @Override // com.yy.videoplayer.render.IProgram
    public void enableWaterMarker(boolean z) {
    }
}
