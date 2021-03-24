package d.e.b;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f65947c = {1, 0, 5, 7, 6};

    /* renamed from: d  reason: collision with root package name */
    public static int f65948d = 48000;

    /* renamed from: e  reason: collision with root package name */
    public static int f65949e = 2048;

    /* renamed from: f  reason: collision with root package name */
    public static int f65950f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static b f65951g;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f65952a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65953b;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(f65948d, 16, 2);
        int i = f65949e;
        int i2 = f65950f * i;
        i2 = i2 < minBufferSize ? ((minBufferSize / i) + 1) * i * 2 : i2;
        for (int i3 : f65947c) {
            try {
                AudioRecord audioRecord = new AudioRecord(i3, f65948d, 16, 2, i2);
                this.f65952a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.f65952a = null;
                }
            } catch (Exception unused) {
                this.f65952a = null;
            }
        }
    }

    public AudioRecord a() {
        return this.f65952a;
    }

    public boolean b() {
        return this.f65953b;
    }

    public int c(@NonNull ByteBuffer byteBuffer, int i) {
        AudioRecord audioRecord = this.f65952a;
        if (audioRecord == null) {
            return 0;
        }
        return audioRecord.read(byteBuffer, i);
    }

    public void d() {
        if (this.f65953b) {
            return;
        }
        this.f65953b = true;
        AudioRecord audioRecord = this.f65952a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f65952a = null;
        }
    }

    public void e() {
        if (this.f65952a == null) {
            return;
        }
        b bVar = f65951g;
        if (bVar != null && !bVar.b()) {
            f65951g.d();
        }
        this.f65952a.startRecording();
        f65951g = this;
    }

    public void f() {
        AudioRecord audioRecord = this.f65952a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.stop();
    }
}
