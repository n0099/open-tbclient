package d.a.s0.v3.k;

import android.hardware.Camera;
import com.faceunity.encoder.TextureMovieEncoder;
/* loaded from: classes9.dex */
public interface g {

    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z, String str);
    }

    void a(Camera camera);

    void b(Camera camera);

    void c(a aVar);

    void d(Camera camera);

    void e(Camera camera);

    void setOnEncoderStatusUpdateListener(TextureMovieEncoder.OnEncoderStatusUpdateListener onEncoderStatusUpdateListener);

    void setPreviewSize(int i2, int i3);
}
