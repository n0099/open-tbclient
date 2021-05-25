package d.e.b;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f66079c = {1, 0, 5, 7, 6};

    /* renamed from: d  reason: collision with root package name */
    public static int f66080d = 48000;

    /* renamed from: e  reason: collision with root package name */
    public static int f66081e = 2048;

    /* renamed from: f  reason: collision with root package name */
    public static int f66082f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static b f66083g;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f66084a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66085b;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(f66080d, 16, 2);
        int i2 = f66081e;
        int i3 = f66082f * i2;
        i3 = i3 < minBufferSize ? ((minBufferSize / i2) + 1) * i2 * 2 : i3;
        for (int i4 : f66079c) {
            try {
                AudioRecord audioRecord = new AudioRecord(i4, f66080d, 16, 2, i3);
                this.f66084a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.f66084a = null;
                }
            } catch (Exception unused) {
                this.f66084a = null;
            }
        }
    }

    public AudioRecord a() {
        return this.f66084a;
    }

    public boolean b() {
        return this.f66085b;
    }

    public int c(@NonNull ByteBuffer byteBuffer, int i2) {
        AudioRecord audioRecord = this.f66084a;
        if (audioRecord == null) {
            return 0;
        }
        return audioRecord.read(byteBuffer, i2);
    }

    public void d() {
        if (this.f66085b) {
            return;
        }
        this.f66085b = true;
        AudioRecord audioRecord = this.f66084a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f66084a = null;
        }
    }

    public void e() {
        if (this.f66084a == null) {
            return;
        }
        b bVar = f66083g;
        if (bVar != null && !bVar.b()) {
            f66083g.d();
        }
        this.f66084a.startRecording();
        f66083g = this;
    }

    public void f() {
        AudioRecord audioRecord = this.f66084a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.stop();
    }
}
