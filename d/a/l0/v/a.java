package d.a.l0.v;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.View;
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: d.a.l0.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1143a {
        void a(b bVar);

        void b(b bVar, int i2, int i3);

        void c(b bVar, int i2, int i3, int i4);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(MediaPlayer mediaPlayer);

        a b();
    }

    void a(InterfaceC1143a interfaceC1143a);

    void b(InterfaceC1143a interfaceC1143a);

    Bitmap getBitmap();

    View getView();

    void release();

    void setAspectRatio(int i2);

    void setVideoSize(int i2, int i3);
}
