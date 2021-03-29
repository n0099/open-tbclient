package d.e.b;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f65948c = {1, 0, 5, 7, 6};

    /* renamed from: d  reason: collision with root package name */
    public static int f65949d = 48000;

    /* renamed from: e  reason: collision with root package name */
    public static int f65950e = 2048;

    /* renamed from: f  reason: collision with root package name */
    public static int f65951f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static b f65952g;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f65953a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65954b;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(f65949d, 16, 2);
        int i = f65950e;
        int i2 = f65951f * i;
        i2 = i2 < minBufferSize ? ((minBufferSize / i) + 1) * i * 2 : i2;
        for (int i3 : f65948c) {
            try {
                AudioRecord audioRecord = new AudioRecord(i3, f65949d, 16, 2, i2);
                this.f65953a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.f65953a = null;
                }
            } catch (Exception unused) {
                this.f65953a = null;
            }
        }
    }

    public AudioRecord a() {
        return this.f65953a;
    }

    public boolean b() {
        return this.f65954b;
    }

    public int c(@NonNull ByteBuffer byteBuffer, int i) {
        AudioRecord audioRecord = this.f65953a;
        if (audioRecord == null) {
            return 0;
        }
        return audioRecord.read(byteBuffer, i);
    }

    public void d() {
        if (this.f65954b) {
            return;
        }
        this.f65954b = true;
        AudioRecord audioRecord = this.f65953a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f65953a = null;
        }
    }

    public void e() {
        if (this.f65953a == null) {
            return;
        }
        b bVar = f65952g;
        if (bVar != null && !bVar.b()) {
            f65952g.d();
        }
        this.f65953a.startRecording();
        f65952g = this;
    }

    public void f() {
        AudioRecord audioRecord = this.f65953a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.stop();
    }
}
