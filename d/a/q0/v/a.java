package d.a.q0.v;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.View;
/* loaded from: classes8.dex */
public interface a {

    /* renamed from: d.a.q0.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC1206a {
        void a(b bVar);

        void b(b bVar, int i2, int i3);

        void c(b bVar, int i2, int i3, int i4);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(MediaPlayer mediaPlayer);

        a b();
    }

    void a(InterfaceC1206a interfaceC1206a);

    void b(InterfaceC1206a interfaceC1206a);

    Bitmap getBitmap();

    View getView();

    void release();

    void setAspectRatio(int i2);

    void setVideoSize(int i2, int i3);
}
