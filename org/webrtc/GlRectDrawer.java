package org.webrtc;

import org.webrtc.GlGenericDrawer;
/* loaded from: classes8.dex */
public class GlRectDrawer extends GlGenericDrawer {
    public static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";

    /* loaded from: classes8.dex */
    public static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        public ShaderCallbacks() {
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader glShader) {
        }

        @Override // org.webrtc.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader glShader, float[] fArr, int i2, int i3, int i4, int i5) {
        }
    }

    public GlRectDrawer() {
        super(FRAGMENT_SHADER, new ShaderCallbacks());
    }

    @Override // org.webrtc.GlGenericDrawer, org.webrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawOes(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8) {
        super.drawOes(i2, fArr, i3, i4, i5, i6, i7, i8);
    }

    @Override // org.webrtc.GlGenericDrawer, org.webrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawRgb(int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, int i8) {
        super.drawRgb(i2, fArr, i3, i4, i5, i6, i7, i8);
    }

    @Override // org.webrtc.GlGenericDrawer, org.webrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawYuv(int[] iArr, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super.drawYuv(iArr, fArr, i2, i3, i4, i5, i6, i7);
    }

    @Override // org.webrtc.GlGenericDrawer, org.webrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }
}
