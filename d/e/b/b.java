package d.e.b;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f66793c = {1, 0, 5, 7, 6};

    /* renamed from: d  reason: collision with root package name */
    public static int f66794d = 48000;

    /* renamed from: e  reason: collision with root package name */
    public static int f66795e = 2048;

    /* renamed from: f  reason: collision with root package name */
    public static int f66796f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static b f66797g;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f66798a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66799b;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(f66794d, 16, 2);
        int i = f66795e;
        int i2 = f66796f * i;
        i2 = i2 < minBufferSize ? ((minBufferSize / i) + 1) * i * 2 : i2;
        for (int i3 : f66793c) {
            try {
                AudioRecord audioRecord = new AudioRecord(i3, f66794d, 16, 2, i2);
                this.f66798a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.f66798a = null;
                }
            } catch (Exception unused) {
                this.f66798a = null;
            }
        }
    }

    public AudioRecord a() {
        return this.f66798a;
    }

    public boolean b() {
        return this.f66799b;
    }

    public int c(@NonNull ByteBuffer byteBuffer, int i) {
        AudioRecord audioRecord = this.f66798a;
        if (audioRecord == null) {
            return 0;
        }
        return audioRecord.read(byteBuffer, i);
    }

    public void d() {
        if (this.f66799b) {
            return;
        }
        this.f66799b = true;
        AudioRecord audioRecord = this.f66798a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f66798a = null;
        }
    }

    public void e() {
        if (this.f66798a == null) {
            return;
        }
        b bVar = f66797g;
        if (bVar != null && !bVar.b()) {
            f66797g.d();
        }
        this.f66798a.startRecording();
        f66797g = this;
    }

    public void f() {
        AudioRecord audioRecord = this.f66798a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.stop();
    }
}
