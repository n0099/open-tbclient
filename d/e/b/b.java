package d.e.b;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f66036c = {1, 0, 5, 7, 6};

    /* renamed from: d  reason: collision with root package name */
    public static int f66037d = 48000;

    /* renamed from: e  reason: collision with root package name */
    public static int f66038e = 2048;

    /* renamed from: f  reason: collision with root package name */
    public static int f66039f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static b f66040g;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f66041a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66042b;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(f66037d, 16, 2);
        int i2 = f66038e;
        int i3 = f66039f * i2;
        i3 = i3 < minBufferSize ? ((minBufferSize / i2) + 1) * i2 * 2 : i3;
        for (int i4 : f66036c) {
            try {
                AudioRecord audioRecord = new AudioRecord(i4, f66037d, 16, 2, i3);
                this.f66041a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.f66041a = null;
                }
            } catch (Exception unused) {
                this.f66041a = null;
            }
        }
    }

    public AudioRecord a() {
        return this.f66041a;
    }

    public boolean b() {
        return this.f66042b;
    }

    public int c(@NonNull ByteBuffer byteBuffer, int i2) {
        AudioRecord audioRecord = this.f66041a;
        if (audioRecord == null) {
            return 0;
        }
        return audioRecord.read(byteBuffer, i2);
    }

    public void d() {
        if (this.f66042b) {
            return;
        }
        this.f66042b = true;
        AudioRecord audioRecord = this.f66041a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f66041a = null;
        }
    }

    public void e() {
        if (this.f66041a == null) {
            return;
        }
        b bVar = f66040g;
        if (bVar != null && !bVar.b()) {
            f66040g.d();
        }
        this.f66041a.startRecording();
        f66040g = this;
    }

    public void f() {
        AudioRecord audioRecord = this.f66041a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.stop();
    }
}
