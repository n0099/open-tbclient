package d.f.b;

import android.media.AudioRecord;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f66940c = {1, 0, 5, 7, 6};

    /* renamed from: d  reason: collision with root package name */
    public static int f66941d = 48000;

    /* renamed from: e  reason: collision with root package name */
    public static int f66942e = 2048;

    /* renamed from: f  reason: collision with root package name */
    public static int f66943f = 24;

    /* renamed from: g  reason: collision with root package name */
    public static b f66944g;

    /* renamed from: a  reason: collision with root package name */
    public AudioRecord f66945a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66946b;

    public b() {
        int minBufferSize = AudioRecord.getMinBufferSize(f66941d, 16, 2);
        int i = f66942e;
        int i2 = f66943f * i;
        i2 = i2 < minBufferSize ? ((minBufferSize / i) + 1) * i * 2 : i2;
        for (int i3 : f66940c) {
            try {
                AudioRecord audioRecord = new AudioRecord(i3, f66941d, 16, 2, i2);
                this.f66945a = audioRecord;
                if (audioRecord.getState() != 1) {
                    this.f66945a = null;
                }
            } catch (Exception unused) {
                this.f66945a = null;
            }
        }
    }

    public AudioRecord a() {
        return this.f66945a;
    }

    public boolean b() {
        return this.f66946b;
    }

    public int c(@NonNull ByteBuffer byteBuffer, int i) {
        AudioRecord audioRecord = this.f66945a;
        if (audioRecord == null) {
            return 0;
        }
        return audioRecord.read(byteBuffer, i);
    }

    public void d() {
        if (this.f66946b) {
            return;
        }
        this.f66946b = true;
        AudioRecord audioRecord = this.f66945a;
        if (audioRecord != null) {
            audioRecord.release();
            this.f66945a = null;
        }
    }

    public void e() {
        if (this.f66945a == null) {
            return;
        }
        b bVar = f66944g;
        if (bVar != null && !bVar.b()) {
            f66944g.d();
        }
        this.f66945a.startRecording();
        f66944g = this;
    }

    public void f() {
        AudioRecord audioRecord = this.f66945a;
        if (audioRecord == null) {
            return;
        }
        audioRecord.stop();
    }
}
