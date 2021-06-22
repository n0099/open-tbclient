package d.e.b;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f69914c = {1, 0, 5, 7, 6};

    /* renamed from: d  reason: collision with root package name */
    public static int f69915d = 48000;

    /* renamed from: e  reason: collision with root package name */
    public static int f69916e = 2048;

    /* renamed from: f  reason: collision with root package name */
    public static int f69917f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static b f69918g;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f69919a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f69920b;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(f69915d, 16, 2);
        int i2 = f69916e;
        int i3 = f69917f * i2;
        i3 = i3 < minBufferSize ? ((minBufferSize / i2) + 1) * i2 * 2 : i3;
        for (int i4 : f69914c) {
            try {
                AudioRecord audioRecord = new AudioRecord(i4, f69915d, 16, 2, i3);
                this.f69919a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.f69919a = null;
                }
            } catch (Exception unused) {
                this.f69919a = null;
            }
        }
    }

    public AudioRecord a() {
        return this.f69919a;
    }

    public boolean b() {
        return this.f69920b;
    }

    public int c(@NonNull ByteBuffer byteBuffer, int i2) {
        AudioRecord audioRecord = this.f69919a;
        if (audioRecord == null) {
            return 0;
        }
        return audioRecord.read(byteBuffer, i2);
    }

    public void d() {
        if (this.f69920b) {
            return;
        }
        this.f69920b = true;
        AudioRecord audioRecord = this.f69919a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f69919a = null;
        }
    }

    public void e() {
        if (this.f69919a == null) {
            return;
        }
        b bVar = f69918g;
        if (bVar != null && !bVar.b()) {
            f69918g.d();
        }
        this.f69919a.startRecording();
        f69918g = this;
    }

    public void f() {
        AudioRecord audioRecord = this.f69919a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.stop();
    }
}
