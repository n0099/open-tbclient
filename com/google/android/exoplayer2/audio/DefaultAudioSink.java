package com.google.android.exoplayer2.audio;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.util.v;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes6.dex */
public final class DefaultAudioSink implements AudioSink {
    public static boolean mbm = false;
    public static boolean mbn = false;
    private int bufferSize;
    private boolean gee;
    private q lYT;
    private int man;
    private com.google.android.exoplayer2.audio.b mao;
    private int mbA;
    private int mbB;
    private int mbC;
    private int mbD;
    private boolean mbE;
    private long mbF;
    private q mbG;
    private long mbH;
    private long mbI;
    private ByteBuffer mbJ;
    private int mbK;
    private int mbL;
    private int mbM;
    private long mbN;
    private long mbO;
    private boolean mbP;
    private long mbQ;
    private Method mbR;
    private int mbS;
    private long mbT;
    private long mbU;
    private int mbV;
    private long mbW;
    private long mbX;
    private int mbY;
    private int mbZ;
    private ByteBuffer mbk;
    @Nullable
    private final com.google.android.exoplayer2.audio.c mbo;
    private final e mbp;
    private final k mbq;
    private final j mbr;
    private final AudioProcessor[] mbs;
    private final ConditionVariable mbt = new ConditionVariable(true);
    private final long[] mbu;
    private final a mbv;
    private final LinkedList<c> mbw;
    @Nullable
    private AudioSink.a mbx;
    private AudioTrack mby;
    private AudioTrack mbz;
    private long mca;
    private long mcb;
    private long mcc;
    private AudioProcessor[] mcd;
    private ByteBuffer[] mce;
    private ByteBuffer mcf;
    private byte[] mcg;
    private int mch;
    private int mci;
    private boolean mcj;
    private boolean mck;
    private boolean mcl;
    private long mcm;
    private int sampleRate;
    private float volume;

    /* loaded from: classes6.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public DefaultAudioSink(@Nullable com.google.android.exoplayer2.audio.c cVar, AudioProcessor[] audioProcessorArr) {
        this.mbo = cVar;
        if (v.SDK_INT >= 18) {
            try {
                this.mbR = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (v.SDK_INT >= 19) {
            this.mbv = new b();
        } else {
            this.mbv = new a();
        }
        this.mbp = new e();
        this.mbq = new k();
        this.mbr = new j();
        this.mbs = new AudioProcessor[audioProcessorArr.length + 4];
        this.mbs[0] = new h();
        this.mbs[1] = this.mbp;
        this.mbs[2] = this.mbq;
        System.arraycopy(audioProcessorArr, 0, this.mbs, 3, audioProcessorArr.length);
        this.mbs[audioProcessorArr.length + 3] = this.mbr;
        this.mbu = new long[10];
        this.volume = 1.0f;
        this.mbZ = 0;
        this.mao = com.google.android.exoplayer2.audio.b.maP;
        this.man = 0;
        this.lYT = q.lZU;
        this.mci = -1;
        this.mcd = new AudioProcessor[0];
        this.mce = new ByteBuffer[0];
        this.mbw = new LinkedList<>();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(AudioSink.a aVar) {
        this.mbx = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean Pn(String str) {
        return this.mbo != null && this.mbo.Jd(Po(str));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long vF(boolean z) {
        long j;
        if (!duc()) {
            return Long.MIN_VALUE;
        }
        if (this.mbz.getPlayState() == 3) {
            dud();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.mbP) {
            j = fF(fG(nanoTime - (this.mbv.duo() / 1000)) + this.mbv.dup());
        } else {
            if (this.mbM == 0) {
                j = this.mbv.dum();
            } else {
                j = nanoTime + this.mbN;
            }
            if (!z) {
                j -= this.mcc;
            }
        }
        long min = Math.min(j, fF(duf()));
        return fD(min) + this.mca;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        int Po;
        boolean z;
        int i7;
        this.mbA = i2;
        boolean z2 = !"audio/raw".equals(str);
        if (!z2) {
            this.mbS = v.ea(i3, i);
            this.mbq.dJ(i5, i6);
            this.mbp.n(iArr);
            AudioProcessor[] audioProcessorArr = this.mbs;
            int length = audioProcessorArr.length;
            int i8 = 0;
            z = false;
            int i9 = i;
            int i10 = i2;
            int i11 = i3;
            while (i8 < length) {
                AudioProcessor audioProcessor = audioProcessorArr[i8];
                try {
                    boolean af = audioProcessor.af(i10, i9, i11) | z;
                    if (audioProcessor.isActive()) {
                        i9 = audioProcessor.dtO();
                        i10 = audioProcessor.dtQ();
                        i11 = audioProcessor.dtP();
                    }
                    i8++;
                    z = af;
                } catch (AudioProcessor.UnhandledFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            if (z) {
                dtY();
                i2 = i10;
                i = i9;
                Po = i11;
            } else {
                i2 = i10;
                i = i9;
                Po = i11;
            }
        } else {
            Po = Po(str);
            z = false;
        }
        switch (i) {
            case 1:
                i7 = 4;
                break;
            case 2:
                i7 = 12;
                break;
            case 3:
                i7 = 28;
                break;
            case 4:
                i7 = 204;
                break;
            case 5:
                i7 = 220;
                break;
            case 6:
                i7 = 252;
                break;
            case 7:
                i7 = 1276;
                break;
            case 8:
                i7 = com.google.android.exoplayer2.b.lYp;
                break;
            default:
                throw new AudioSink.ConfigurationException("Unsupported channel count: " + i);
        }
        if (v.SDK_INT <= 23 && "foster".equals(v.mHY) && "NVIDIA".equals(v.MANUFACTURER)) {
            switch (i) {
                case 3:
                case 5:
                    i7 = 252;
                    break;
                case 7:
                    i7 = com.google.android.exoplayer2.b.lYp;
                    break;
            }
        }
        int i12 = (v.SDK_INT <= 25 && "fugu".equals(v.mHY) && z2 && i == 1) ? 12 : i7;
        if (z || !isInitialized() || this.mbC != Po || this.sampleRate != i2 || this.mbB != i12) {
            reset();
            this.mbC = Po;
            this.mbE = z2;
            this.sampleRate = i2;
            this.mbB = i12;
            this.mbD = z2 ? Po : 2;
            this.mbV = v.ea(2, i);
            if (i4 != 0) {
                this.bufferSize = i4;
            } else if (z2) {
                if (this.mbD == 5 || this.mbD == 6) {
                    this.bufferSize = 20480;
                } else {
                    this.bufferSize = 49152;
                }
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i12, this.mbD);
                com.google.android.exoplayer2.util.a.checkState(minBufferSize != -2);
                int i13 = minBufferSize * 4;
                int fG = ((int) fG(250000L)) * this.mbV;
                int max = (int) Math.max(minBufferSize, fG(750000L) * this.mbV);
                if (i13 >= fG) {
                    fG = i13 > max ? max : i13;
                }
                this.bufferSize = fG;
            }
            this.mbF = z2 ? -9223372036854775807L : fF(this.bufferSize / this.mbV);
            d(this.lYT);
        }
    }

    private void dtY() {
        AudioProcessor[] audioProcessorArr;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : this.mbs) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.mcd = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.mce = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            AudioProcessor audioProcessor2 = this.mcd[i];
            audioProcessor2.flush();
            this.mce[i] = audioProcessor2.dtS();
        }
    }

    private void initialize() throws AudioSink.InitializationException {
        this.mbt.block();
        this.mbz = duj();
        int audioSessionId = this.mbz.getAudioSessionId();
        if (mbm && v.SDK_INT < 21) {
            if (this.mby != null && audioSessionId != this.mby.getAudioSessionId()) {
                dub();
            }
            if (this.mby == null) {
                this.mby = Jg(audioSessionId);
            }
        }
        if (this.man != audioSessionId) {
            this.man = audioSessionId;
            if (this.mbx != null) {
                this.mbx.EU(audioSessionId);
            }
        }
        this.mbv.a(this.mbz, duh());
        dua();
        this.gee = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.mck = true;
        if (isInitialized()) {
            this.mcb = System.nanoTime() / 1000;
            this.mbz.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dtT() {
        if (this.mbZ == 1) {
            this.mbZ = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        com.google.android.exoplayer2.util.a.checkArgument(this.mcf == null || byteBuffer == this.mcf);
        if (!isInitialized()) {
            initialize();
            if (this.mck) {
                play();
            }
        }
        if (duh()) {
            if (this.mbz.getPlayState() == 2) {
                this.gee = false;
                return false;
            } else if (this.mbz.getPlayState() == 1 && this.mbv.dul() != 0) {
                return false;
            }
        }
        boolean z = this.gee;
        this.gee = dtV();
        if (z && !this.gee && this.mbz.getPlayState() != 1 && this.mbx != null) {
            this.mbx.i(this.bufferSize, com.google.android.exoplayer2.b.fn(this.mbF), SystemClock.elapsedRealtime() - this.mcm);
        }
        if (this.mcf == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.mbE && this.mbY == 0) {
                this.mbY = a(this.mbD, byteBuffer);
            }
            if (this.mbG != null) {
                if (!dtZ()) {
                    return false;
                }
                this.mbw.add(new c(this.mbG, Math.max(0L, j), fF(duf())));
                this.mbG = null;
                dtY();
            }
            if (this.mbZ == 0) {
                this.mca = Math.max(0L, j);
                this.mbZ = 1;
            } else {
                long fE = this.mca + fE(due());
                if (this.mbZ == 1 && Math.abs(fE - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + fE + ", got " + j + "]");
                    this.mbZ = 2;
                }
                if (this.mbZ == 2) {
                    this.mca = (j - fE) + this.mca;
                    this.mbZ = 1;
                    if (this.mbx != null) {
                        this.mbx.dtX();
                    }
                }
            }
            if (this.mbE) {
                this.mbU += this.mbY;
            } else {
                this.mbT += byteBuffer.remaining();
            }
            this.mcf = byteBuffer;
        }
        if (this.mbE) {
            b(this.mcf, j);
        } else {
            fC(j);
        }
        if (!this.mcf.hasRemaining()) {
            this.mcf = null;
            return true;
        } else if (this.mbv.fI(duf())) {
            Log.w("AudioTrack", "Resetting stalled audio track");
            reset();
            return true;
        } else {
            return false;
        }
    }

    private void fC(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.mcd.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.mce[i - 1];
            } else {
                byteBuffer = this.mcf != null ? this.mcf : AudioProcessor.EMPTY_BUFFER;
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.mcd[i];
                audioProcessor.i(byteBuffer);
                ByteBuffer dtS = audioProcessor.dtS();
                this.mce[i] = dtS;
                if (dtS.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    private boolean b(ByteBuffer byteBuffer, long j) throws AudioSink.WriteException {
        int a2;
        if (byteBuffer.hasRemaining()) {
            if (this.mbk != null) {
                com.google.android.exoplayer2.util.a.checkArgument(this.mbk == byteBuffer);
            } else {
                this.mbk = byteBuffer;
                if (v.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    if (this.mcg == null || this.mcg.length < remaining) {
                        this.mcg = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.mcg, 0, remaining);
                    byteBuffer.position(position);
                    this.mch = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (v.SDK_INT < 21) {
                int dul = this.bufferSize - ((int) (this.mbW - (this.mbv.dul() * this.mbV)));
                if (dul > 0) {
                    a2 = this.mbz.write(this.mcg, this.mch, Math.min(remaining2, dul));
                    if (a2 > 0) {
                        this.mch += a2;
                        byteBuffer.position(byteBuffer.position() + a2);
                    }
                } else {
                    a2 = 0;
                }
            } else if (this.mcl) {
                com.google.android.exoplayer2.util.a.checkState(j != -9223372036854775807L);
                a2 = a(this.mbz, byteBuffer, remaining2, j);
            } else {
                a2 = a(this.mbz, byteBuffer, remaining2);
            }
            this.mcm = SystemClock.elapsedRealtime();
            if (a2 < 0) {
                throw new AudioSink.WriteException(a2);
            }
            if (!this.mbE) {
                this.mbW += a2;
            }
            if (a2 == remaining2) {
                if (this.mbE) {
                    this.mbX += this.mbY;
                }
                this.mbk = null;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dtU() throws AudioSink.WriteException {
        if (!this.mcj && isInitialized() && dtZ()) {
            this.mbv.fH(duf());
            this.mbK = 0;
            this.mcj = true;
        }
    }

    private boolean dtZ() throws AudioSink.WriteException {
        boolean z;
        if (this.mci == -1) {
            this.mci = this.mbE ? this.mcd.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.mci < this.mcd.length) {
            AudioProcessor audioProcessor = this.mcd[this.mci];
            if (z) {
                audioProcessor.dtR();
            }
            fC(-9223372036854775807L);
            if (!audioProcessor.avR()) {
                return false;
            }
            this.mci++;
            z = true;
        }
        if (this.mbk != null) {
            b(this.mbk, -9223372036854775807L);
            if (this.mbk != null) {
                return false;
            }
        }
        this.mci = -1;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean avR() {
        return !isInitialized() || (this.mcj && !dtV());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean dtV() {
        return isInitialized() && (duf() > this.mbv.dul() || dui());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q d(q qVar) {
        q qVar2;
        if (this.mbE) {
            this.lYT = q.lZU;
            return this.lYT;
        }
        q qVar3 = new q(this.mbr.bw(qVar.speed), this.mbr.bx(qVar.pitch));
        if (this.mbG != null) {
            qVar2 = this.mbG;
        } else {
            qVar2 = !this.mbw.isEmpty() ? this.mbw.getLast().lYT : this.lYT;
        }
        if (!qVar3.equals(qVar2)) {
            if (isInitialized()) {
                this.mbG = qVar3;
            } else {
                this.lYT = qVar3;
            }
        }
        return this.lYT;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q dsW() {
        return this.lYT;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(com.google.android.exoplayer2.audio.b bVar) {
        if (!this.mao.equals(bVar)) {
            this.mao = bVar;
            if (!this.mcl) {
                reset();
                this.man = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Jf(int i) {
        com.google.android.exoplayer2.util.a.checkState(v.SDK_INT >= 21);
        if (!this.mcl || this.man != i) {
            this.mcl = true;
            this.man = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dtW() {
        if (this.mcl) {
            this.mcl = false;
            this.man = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            dua();
        }
    }

    private void dua() {
        if (isInitialized()) {
            if (v.SDK_INT >= 21) {
                a(this.mbz, this.volume);
            } else {
                b(this.mbz, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.mck = false;
        if (isInitialized()) {
            dug();
            this.mbv.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$1] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.mbT = 0L;
            this.mbU = 0L;
            this.mbW = 0L;
            this.mbX = 0L;
            this.mbY = 0;
            if (this.mbG != null) {
                this.lYT = this.mbG;
                this.mbG = null;
            } else if (!this.mbw.isEmpty()) {
                this.lYT = this.mbw.getLast().lYT;
            }
            this.mbw.clear();
            this.mbH = 0L;
            this.mbI = 0L;
            this.mcf = null;
            this.mbk = null;
            for (int i = 0; i < this.mcd.length; i++) {
                AudioProcessor audioProcessor = this.mcd[i];
                audioProcessor.flush();
                this.mce[i] = audioProcessor.dtS();
            }
            this.mcj = false;
            this.mci = -1;
            this.mbJ = null;
            this.mbK = 0;
            this.mbZ = 0;
            this.mcc = 0L;
            dug();
            if (this.mbz.getPlayState() == 3) {
                this.mbz.pause();
            }
            final AudioTrack audioTrack = this.mbz;
            this.mbz = null;
            this.mbv.a(null, false);
            this.mbt.close();
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.mbt.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        dub();
        for (AudioProcessor audioProcessor : this.mbs) {
            audioProcessor.reset();
        }
        this.man = 0;
        this.mck = false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$2] */
    private void dub() {
        if (this.mby != null) {
            final AudioTrack audioTrack = this.mby;
            this.mby = null;
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean duc() {
        return isInitialized() && this.mbZ != 0;
    }

    private long fD(long j) {
        while (!this.mbw.isEmpty() && j >= this.mbw.getFirst().lZS) {
            c remove = this.mbw.remove();
            this.lYT = remove.lYT;
            this.mbI = remove.lZS;
            this.mbH = remove.mcB - this.mca;
        }
        if (this.lYT.speed == 1.0f) {
            return (this.mbH + j) - this.mbI;
        }
        if (this.mbw.isEmpty()) {
            return this.mbH + this.mbr.fJ(j - this.mbI);
        }
        return this.mbH + ((long) (this.lYT.speed * (j - this.mbI)));
    }

    private void dud() {
        long dum = this.mbv.dum();
        if (dum != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.mbO >= 30000) {
                this.mbu[this.mbL] = dum - nanoTime;
                this.mbL = (this.mbL + 1) % 10;
                if (this.mbM < 10) {
                    this.mbM++;
                }
                this.mbO = nanoTime;
                this.mbN = 0L;
                for (int i = 0; i < this.mbM; i++) {
                    this.mbN += this.mbu[i] / this.mbM;
                }
            }
            if (!duh() && nanoTime - this.mbQ >= 500000) {
                this.mbP = this.mbv.dun();
                if (this.mbP) {
                    long duo = this.mbv.duo() / 1000;
                    long dup = this.mbv.dup();
                    if (duo < this.mcb) {
                        this.mbP = false;
                    } else if (Math.abs(duo - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + dup + ", " + duo + ", " + nanoTime + ", " + dum + ", " + due() + ", " + duf();
                        if (mbn) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w("AudioTrack", str);
                        this.mbP = false;
                    } else if (Math.abs(fF(dup) - dum) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + dup + ", " + duo + ", " + nanoTime + ", " + dum + ", " + due() + ", " + duf();
                        if (mbn) {
                            throw new InvalidAudioTrackTimestampException(str2);
                        }
                        Log.w("AudioTrack", str2);
                        this.mbP = false;
                    }
                }
                if (this.mbR != null && !this.mbE) {
                    try {
                        this.mcc = (((Integer) this.mbR.invoke(this.mbz, null)).intValue() * 1000) - this.mbF;
                        this.mcc = Math.max(this.mcc, 0L);
                        if (this.mcc > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.mcc);
                            this.mcc = 0L;
                        }
                    } catch (Exception e) {
                        this.mbR = null;
                    }
                }
                this.mbQ = nanoTime;
            }
        }
    }

    private boolean isInitialized() {
        return this.mbz != null;
    }

    private long fE(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mbA;
    }

    private long fF(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    private long fG(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    private long due() {
        return this.mbE ? this.mbU : this.mbT / this.mbS;
    }

    private long duf() {
        return this.mbE ? this.mbX : this.mbW / this.mbV;
    }

    private void dug() {
        this.mbN = 0L;
        this.mbM = 0;
        this.mbL = 0;
        this.mbO = 0L;
        this.mbP = false;
        this.mbQ = 0L;
    }

    private boolean duh() {
        return v.SDK_INT < 23 && (this.mbD == 5 || this.mbD == 6);
    }

    private boolean dui() {
        return duh() && this.mbz.getPlayState() == 2 && this.mbz.getPlaybackHeadPosition() == 0;
    }

    private AudioTrack duj() throws AudioSink.InitializationException {
        AudioTrack audioTrack;
        if (v.SDK_INT >= 21) {
            audioTrack = duk();
        } else {
            int Ma = v.Ma(this.mao.maQ);
            if (this.man == 0) {
                audioTrack = new AudioTrack(Ma, this.sampleRate, this.mbB, this.mbD, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(Ma, this.sampleRate, this.mbB, this.mbD, this.bufferSize, 1, this.man);
            }
        }
        int state = audioTrack.getState();
        if (state != 1) {
            try {
                audioTrack.release();
            } catch (Exception e) {
            }
            throw new AudioSink.InitializationException(state, this.sampleRate, this.mbB, this.bufferSize);
        }
        return audioTrack;
    }

    @TargetApi(21)
    private AudioTrack duk() {
        AudioAttributes dtM;
        if (this.mcl) {
            dtM = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            dtM = this.mao.dtM();
        }
        return new AudioTrack(dtM, new AudioFormat.Builder().setChannelMask(this.mbB).setEncoding(this.mbD).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.man != 0 ? this.man : 0);
    }

    private AudioTrack Jg(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private static int Po(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c2 = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 0;
        }
    }

    private static int a(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return f.j(byteBuffer);
        }
        if (i == 5) {
            return com.google.android.exoplayer2.audio.a.dtL();
        }
        if (i == 6) {
            return com.google.android.exoplayer2.audio.a.h(byteBuffer);
        }
        throw new IllegalStateException("Unexpected audio encoding: " + i);
    }

    @TargetApi(21)
    private static int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @TargetApi(21)
    private int a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (this.mbJ == null) {
            this.mbJ = ByteBuffer.allocate(16);
            this.mbJ.order(ByteOrder.BIG_ENDIAN);
            this.mbJ.putInt(1431633921);
        }
        if (this.mbK == 0) {
            this.mbJ.putInt(4, i);
            this.mbJ.putLong(8, 1000 * j);
            this.mbJ.position(0);
            this.mbK = i;
        }
        int remaining = this.mbJ.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.mbJ, remaining, 1);
            if (write < 0) {
                this.mbK = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i);
        if (a2 < 0) {
            this.mbK = 0;
            return a2;
        }
        this.mbK -= a2;
        return a2;
    }

    @TargetApi(21)
    private static void a(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    private static void b(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        protected AudioTrack mbz;
        private boolean mcp;
        private long mcq;
        private long mcr;
        private long mcs;
        private long mct;
        private long mcu;
        private long mcv;
        private long mcw;
        private int sampleRate;

        private a() {
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.mbz = audioTrack;
            this.mcp = z;
            this.mct = -9223372036854775807L;
            this.mcu = -9223372036854775807L;
            this.mcq = 0L;
            this.mcr = 0L;
            this.mcs = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }

        public void fH(long j) {
            this.mcv = dul();
            this.mct = SystemClock.elapsedRealtime() * 1000;
            this.mcw = j;
            this.mbz.stop();
        }

        public void pause() {
            if (this.mct == -9223372036854775807L) {
                this.mbz.pause();
            }
        }

        public boolean fI(long j) {
            return this.mcu != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.mcu >= 200;
        }

        public long dul() {
            if (this.mct != -9223372036854775807L) {
                return Math.min(this.mcw, ((((SystemClock.elapsedRealtime() * 1000) - this.mct) * this.sampleRate) / TimeUtils.NANOS_PER_MS) + this.mcv);
            }
            int playState = this.mbz.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.mbz.getPlaybackHeadPosition();
            if (this.mcp) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.mcs = this.mcq;
                }
                playbackHeadPosition += this.mcs;
            }
            if (v.SDK_INT <= 26) {
                if (playbackHeadPosition == 0 && this.mcq > 0 && playState == 3) {
                    if (this.mcu == -9223372036854775807L) {
                        this.mcu = SystemClock.elapsedRealtime();
                    }
                    return this.mcq;
                }
                this.mcu = -9223372036854775807L;
            }
            if (this.mcq > playbackHeadPosition) {
                this.mcr++;
            }
            this.mcq = playbackHeadPosition;
            return playbackHeadPosition + (this.mcr << 32);
        }

        public long dum() {
            return (dul() * TimeUtils.NANOS_PER_MS) / this.sampleRate;
        }

        public boolean dun() {
            return false;
        }

        public long duo() {
            throw new UnsupportedOperationException();
        }

        public long dup() {
            throw new UnsupportedOperationException();
        }
    }

    @TargetApi(19)
    /* loaded from: classes6.dex */
    private static class b extends a {
        private long mcA;
        private final AudioTimestamp mcx;
        private long mcy;
        private long mcz;

        public b() {
            super();
            this.mcx = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.mcy = 0L;
            this.mcz = 0L;
            this.mcA = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public boolean dun() {
            boolean timestamp = this.mbz.getTimestamp(this.mcx);
            if (timestamp) {
                long j = this.mcx.framePosition;
                if (this.mcz > j) {
                    this.mcy++;
                }
                this.mcz = j;
                this.mcA = j + (this.mcy << 32);
            }
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long duo() {
            return this.mcx.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long dup() {
            return this.mcA;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        private final q lYT;
        private final long lZS;
        private final long mcB;

        private c(q qVar, long j, long j2) {
            this.lYT = qVar;
            this.mcB = j;
            this.lZS = j2;
        }
    }
}
