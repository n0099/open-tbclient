package d.e.b;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f65350c = {1, 0, 5, 7, 6};

    /* renamed from: d  reason: collision with root package name */
    public static int f65351d = 48000;

    /* renamed from: e  reason: collision with root package name */
    public static int f65352e = 2048;

    /* renamed from: f  reason: collision with root package name */
    public static int f65353f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static b f65354g;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f65355a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65356b;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(f65351d, 16, 2);
        int i2 = f65352e;
        int i3 = f65353f * i2;
        i3 = i3 < minBufferSize ? ((minBufferSize / i2) + 1) * i2 * 2 : i3;
        for (int i4 : f65350c) {
            try {
                AudioRecord audioRecord = new AudioRecord(i4, f65351d, 16, 2, i3);
                this.f65355a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.f65355a = null;
                }
            } catch (Exception unused) {
                this.f65355a = null;
            }
        }
    }

    public AudioRecord a() {
        return this.f65355a;
    }

    public boolean b() {
        return this.f65356b;
    }

    public int c(@NonNull ByteBuffer byteBuffer, int i2) {
        AudioRecord audioRecord = this.f65355a;
        if (audioRecord == null) {
            return 0;
        }
        return audioRecord.read(byteBuffer, i2);
    }

    public void d() {
        if (this.f65356b) {
            return;
        }
        this.f65356b = true;
        AudioRecord audioRecord = this.f65355a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f65355a = null;
        }
    }

    public void e() {
        if (this.f65355a == null) {
            return;
        }
        b bVar = f65354g;
        if (bVar != null && !bVar.b()) {
            f65354g.d();
        }
        this.f65355a.startRecording();
        f65354g = this;
    }

    public void f() {
        AudioRecord audioRecord = this.f65355a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.stop();
    }
}
