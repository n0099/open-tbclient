package com.yy.mediaframework.gpuimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import com.yy.mediaframework.gles.Drawable2d;
import com.yy.mediaframework.gles.GlUtil;
import com.yy.mediaframework.utils.YMFLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
/* loaded from: classes4.dex */
public class GPUImageBlendFilter extends GPUImageFilter {
    private static final String FRAGMENT_SHADER = "precision mediump float;\n\nvarying vec2 vTextureCoord;\nvarying vec2 vExtraTextureCoord;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D uExtraTexture;\n\nvoid main() {\n    vec4 base = texture2D(inputImageTexture, vTextureCoord);\n    vec4 overlay = texture2D(uExtraTexture, vExtraTextureCoord);\n    vec4 outputColor;\n    outputColor.r = overlay.r + base.r * base.a * (1.0 - overlay.a);\n    outputColor.g = overlay.g + base.g * base.a * (1.0 - overlay.a);\n    outputColor.b = overlay.b + base.b * base.a * (1.0 - overlay.a);\n    outputColor.a = overlay.a + base.a * (1.0 - overlay.a);\n    gl_FragColor = outputColor;\n}";
    private static final String VERTEX_SHADER = "uniform mat4 uTexMatrix;\n\nattribute vec4 position;\n\nattribute vec4 inputTextureCoordinate;\nattribute vec4 aExtraTextureCoord;\n\nvarying vec2 vTextureCoord;\nvarying vec2 vExtraTextureCoord;\n\n\nvoid main() {\n    gl_Position = position;\n    vExtraTextureCoord = vec2(aExtraTextureCoord.x, 1.0 - aExtraTextureCoord.y);  //OpenGL纹理系统坐标 与 Android图像坐标 Y轴是颠倒的。这里旋转过来\n    vTextureCoord = (uTexMatrix * inputTextureCoordinate).xy;\n}";
    private FloatBuffer mExtraTexBuffer;
    private int mExtraTextureId;
    private int maExtraTextureCoordLoc;
    private int muExtraTextureLoc;

    public GPUImageBlendFilter(Context context, int i) {
        super(VERTEX_SHADER, FRAGMENT_SHADER);
        this.mExtraTextureId = -1;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        createBlendTexture(BitmapFactory.decodeResource(context.getResources(), i, options), 720, 1280, 40, 100, 2);
    }

    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onInit() {
        super.onInit();
        this.maExtraTextureCoordLoc = GLES20.glGetAttribLocation(getProgram(), "aExtraTextureCoord");
        this.muExtraTextureLoc = GLES20.glGetUniformLocation(getProgram(), "uExtraTexture");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.yy.mediaframework.gpuimage.GPUImageFilter
    public void onDrawArraysPre(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int i2, float[] fArr) {
        super.onDrawArraysPre(i, floatBuffer, floatBuffer2, i2, fArr);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.mExtraTextureId);
        GLES20.glUniform1i(this.muExtraTextureLoc, 1);
        GLES20.glEnableVertexAttribArray(this.maExtraTextureCoordLoc);
        GLES20.glVertexAttribPointer(this.maExtraTextureCoordLoc, 2, 5126, false, 0, (Buffer) this.mExtraTexBuffer);
    }

    private void createBlendTexture(Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (this.mExtraTextureId == -1) {
            this.mExtraTextureId = genAndFillWaterMarkTexture(i, i2);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        switch (i5) {
            case 1:
                i6 = i4;
                i7 = i3;
                break;
            case 2:
            default:
                i6 = i4;
                i7 = (i - width) - i3;
                break;
            case 3:
                i6 = (i2 - height) - i4;
                i7 = i3;
                break;
            case 4:
                i6 = (i2 - height) - i4;
                i7 = (i - width) - i3;
                break;
        }
        YMFLog.debug(this, "[Util    ]", "createBlendTexture txtId:" + this.mExtraTextureId + ", width:" + i + ", height:" + i2 + ", bmpWidth:" + width + ", bmpHeight:" + height + ", offsetX:" + i3 + ", offsetY:" + i4 + ", gravity:" + i5 + ", srcX:" + i7 + ", srcY:" + i6);
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i * i2 * 4];
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = i8;
            if (i10 < i2) {
                int i11 = 0;
                while (i11 < i) {
                    if (i10 >= i6 && i10 < i6 + height && i11 >= i7 && i11 < i7 + width) {
                        int i12 = iArr[(i11 - i7) + ((i10 - i6) * width)];
                        byte b2 = (byte) ((i12 >> 24) & 255);
                        bArr[i9] = (byte) ((((((byte) ((i12 >> 16) & 255)) & 255) * 1.0f) * (b2 & 255)) / 255.0f);
                        bArr[i9 + 1] = (byte) ((((((byte) ((i12 >> 8) & 255)) & 255) * 1.0f) * (b2 & 255)) / 255.0f);
                        bArr[i9 + 2] = (byte) ((((((byte) (i12 & 255)) & 255) * 1.0f) * (b2 & 255)) / 255.0f);
                        bArr[i9 + 3] = b2;
                    } else {
                        bArr[i9] = 0;
                        bArr[i9 + 1] = 0;
                        bArr[i9 + 2] = 0;
                        bArr[i9 + 3] = 0;
                    }
                    i11++;
                    i9 += 4;
                }
                i8 = i10 + 1;
            } else {
                GLES20.glTexSubImage2D(3553, 0, 0, 0, i, i2, 6408, 5121, ByteBuffer.wrap(bArr));
                this.mExtraTexBuffer = GlUtil.createFloatBuffer(Drawable2d.FULL_RECTANGLE_TEX_COORDS);
                return;
            }
        }
    }

    private int genAndFillWaterMarkTexture(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int i3 = i * i2 * 4;
        byte[] bArr = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[i4] = 0;
        }
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, ByteBuffer.wrap(bArr));
        return iArr[0];
    }
}
