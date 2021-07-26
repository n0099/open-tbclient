package d.a.o0.v;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.view.View;
/* loaded from: classes7.dex */
public interface a {

    /* renamed from: d.a.o0.v.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1164a {
        void a(b bVar);

        void b(b bVar, int i2, int i3);

        void c(b bVar, int i2, int i3, int i4);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(MediaPlayer mediaPlayer);

        a b();
    }

    void a(InterfaceC1164a interfaceC1164a);

    void b(InterfaceC1164a interfaceC1164a);

    Bitmap getBitmap();

    View getView();

    void release();

    void setAspectRatio(int i2);

    void setVideoSize(int i2, int i3);
}
