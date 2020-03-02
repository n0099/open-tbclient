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
    public static boolean mbb = false;
    public static boolean mbc = false;
    private int bufferSize;
    private boolean gdR;
    private q lYI;
    private ByteBuffer maZ;
    private int mab;
    private com.google.android.exoplayer2.audio.b mad;
    private int mbA;
    private int mbB;
    private long mbC;
    private long mbD;
    private boolean mbE;
    private long mbF;
    private Method mbG;
    private int mbH;
    private long mbI;
    private long mbJ;
    private int mbK;
    private long mbL;
    private long mbM;
    private int mbN;
    private int mbO;
    private long mbP;
    private long mbQ;
    private long mbR;
    private AudioProcessor[] mbS;
    private ByteBuffer[] mbT;
    private ByteBuffer mbU;
    private byte[] mbV;
    private int mbW;
    private int mbX;
    private boolean mbY;
    private boolean mbZ;
    @Nullable
    private final com.google.android.exoplayer2.audio.c mbd;
    private final e mbe;
    private final k mbf;
    private final j mbg;
    private final AudioProcessor[] mbh;
    private final ConditionVariable mbi = new ConditionVariable(true);
    private final long[] mbj;
    private final a mbk;
    private final LinkedList<c> mbl;
    @Nullable
    private AudioSink.a mbm;
    private AudioTrack mbn;
    private AudioTrack mbo;
    private int mbp;
    private int mbq;
    private int mbr;
    private int mbs;
    private boolean mbt;
    private long mbu;
    private q mbv;
    private long mbw;
    private long mbx;
    private ByteBuffer mby;
    private int mbz;
    private boolean mca;
    private long mcb;
    private int sampleRate;
    private float volume;

    /* loaded from: classes6.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public DefaultAudioSink(@Nullable com.google.android.exoplayer2.audio.c cVar, AudioProcessor[] audioProcessorArr) {
        this.mbd = cVar;
        if (v.SDK_INT >= 18) {
            try {
                this.mbG = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (v.SDK_INT >= 19) {
            this.mbk = new b();
        } else {
            this.mbk = new a();
        }
        this.mbe = new e();
        this.mbf = new k();
        this.mbg = new j();
        this.mbh = new AudioProcessor[audioProcessorArr.length + 4];
        this.mbh[0] = new h();
        this.mbh[1] = this.mbe;
        this.mbh[2] = this.mbf;
        System.arraycopy(audioProcessorArr, 0, this.mbh, 3, audioProcessorArr.length);
        this.mbh[audioProcessorArr.length + 3] = this.mbg;
        this.mbj = new long[10];
        this.volume = 1.0f;
        this.mbO = 0;
        this.mad = com.google.android.exoplayer2.audio.b.maE;
        this.mab = 0;
        this.lYI = q.lZJ;
        this.mbX = -1;
        this.mbS = new AudioProcessor[0];
        this.mbT = new ByteBuffer[0];
        this.mbl = new LinkedList<>();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(AudioSink.a aVar) {
        this.mbm = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean Pm(String str) {
        return this.mbd != null && this.mbd.Jd(Pn(str));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long vF(boolean z) {
        long j;
        if (!dub()) {
            return Long.MIN_VALUE;
        }
        if (this.mbo.getPlayState() == 3) {
            duc();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.mbE) {
            j = fF(fG(nanoTime - (this.mbk.dun() / 1000)) + this.mbk.duo());
        } else {
            if (this.mbB == 0) {
                j = this.mbk.dul();
            } else {
                j = nanoTime + this.mbC;
            }
            if (!z) {
                j -= this.mbR;
            }
        }
        long min = Math.min(j, fF(due()));
        return fD(min) + this.mbP;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        int Pn;
        boolean z;
        int i7;
        this.mbp = i2;
        boolean z2 = !"audio/raw".equals(str);
        if (!z2) {
            this.mbH = v.ea(i3, i);
            this.mbf.dJ(i5, i6);
            this.mbe.n(iArr);
            AudioProcessor[] audioProcessorArr = this.mbh;
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
                        i9 = audioProcessor.dtN();
                        i10 = audioProcessor.dtP();
                        i11 = audioProcessor.dtO();
                    }
                    i8++;
                    z = af;
                } catch (AudioProcessor.UnhandledFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            if (z) {
                dtX();
                i2 = i10;
                i = i9;
                Pn = i11;
            } else {
                i2 = i10;
                i = i9;
                Pn = i11;
            }
        } else {
            Pn = Pn(str);
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
                i7 = com.google.android.exoplayer2.b.lYe;
                break;
            default:
                throw new AudioSink.ConfigurationException("Unsupported channel count: " + i);
        }
        if (v.SDK_INT <= 23 && "foster".equals(v.mHN) && "NVIDIA".equals(v.MANUFACTURER)) {
            switch (i) {
                case 3:
                case 5:
                    i7 = 252;
                    break;
                case 7:
                    i7 = com.google.android.exoplayer2.b.lYe;
                    break;
            }
        }
        int i12 = (v.SDK_INT <= 25 && "fugu".equals(v.mHN) && z2 && i == 1) ? 12 : i7;
        if (z || !isInitialized() || this.mbr != Pn || this.sampleRate != i2 || this.mbq != i12) {
            reset();
            this.mbr = Pn;
            this.mbt = z2;
            this.sampleRate = i2;
            this.mbq = i12;
            this.mbs = z2 ? Pn : 2;
            this.mbK = v.ea(2, i);
            if (i4 != 0) {
                this.bufferSize = i4;
            } else if (z2) {
                if (this.mbs == 5 || this.mbs == 6) {
                    this.bufferSize = 20480;
                } else {
                    this.bufferSize = 49152;
                }
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i12, this.mbs);
                com.google.android.exoplayer2.util.a.checkState(minBufferSize != -2);
                int i13 = minBufferSize * 4;
                int fG = ((int) fG(250000L)) * this.mbK;
                int max = (int) Math.max(minBufferSize, fG(750000L) * this.mbK);
                if (i13 >= fG) {
                    fG = i13 > max ? max : i13;
                }
                this.bufferSize = fG;
            }
            this.mbu = z2 ? -9223372036854775807L : fF(this.bufferSize / this.mbK);
            d(this.lYI);
        }
    }

    private void dtX() {
        AudioProcessor[] audioProcessorArr;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : this.mbh) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.mbS = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.mbT = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            AudioProcessor audioProcessor2 = this.mbS[i];
            audioProcessor2.flush();
            this.mbT[i] = audioProcessor2.dtR();
        }
    }

    private void initialize() throws AudioSink.InitializationException {
        this.mbi.block();
        this.mbo = dui();
        int audioSessionId = this.mbo.getAudioSessionId();
        if (mbb && v.SDK_INT < 21) {
            if (this.mbn != null && audioSessionId != this.mbn.getAudioSessionId()) {
                dua();
            }
            if (this.mbn == null) {
                this.mbn = Jg(audioSessionId);
            }
        }
        if (this.mab != audioSessionId) {
            this.mab = audioSessionId;
            if (this.mbm != null) {
                this.mbm.EU(audioSessionId);
            }
        }
        this.mbk.a(this.mbo, dug());
        dtZ();
        this.gdR = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.mbZ = true;
        if (isInitialized()) {
            this.mbQ = System.nanoTime() / 1000;
            this.mbo.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dtS() {
        if (this.mbO == 1) {
            this.mbO = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        com.google.android.exoplayer2.util.a.checkArgument(this.mbU == null || byteBuffer == this.mbU);
        if (!isInitialized()) {
            initialize();
            if (this.mbZ) {
                play();
            }
        }
        if (dug()) {
            if (this.mbo.getPlayState() == 2) {
                this.gdR = false;
                return false;
            } else if (this.mbo.getPlayState() == 1 && this.mbk.duk() != 0) {
                return false;
            }
        }
        boolean z = this.gdR;
        this.gdR = dtU();
        if (z && !this.gdR && this.mbo.getPlayState() != 1 && this.mbm != null) {
            this.mbm.i(this.bufferSize, com.google.android.exoplayer2.b.fn(this.mbu), SystemClock.elapsedRealtime() - this.mcb);
        }
        if (this.mbU == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.mbt && this.mbN == 0) {
                this.mbN = a(this.mbs, byteBuffer);
            }
            if (this.mbv != null) {
                if (!dtY()) {
                    return false;
                }
                this.mbl.add(new c(this.mbv, Math.max(0L, j), fF(due())));
                this.mbv = null;
                dtX();
            }
            if (this.mbO == 0) {
                this.mbP = Math.max(0L, j);
                this.mbO = 1;
            } else {
                long fE = this.mbP + fE(dud());
                if (this.mbO == 1 && Math.abs(fE - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + fE + ", got " + j + "]");
                    this.mbO = 2;
                }
                if (this.mbO == 2) {
                    this.mbP = (j - fE) + this.mbP;
                    this.mbO = 1;
                    if (this.mbm != null) {
                        this.mbm.dtW();
                    }
                }
            }
            if (this.mbt) {
                this.mbJ += this.mbN;
            } else {
                this.mbI += byteBuffer.remaining();
            }
            this.mbU = byteBuffer;
        }
        if (this.mbt) {
            b(this.mbU, j);
        } else {
            fC(j);
        }
        if (!this.mbU.hasRemaining()) {
            this.mbU = null;
            return true;
        } else if (this.mbk.fI(due())) {
            Log.w("AudioTrack", "Resetting stalled audio track");
            reset();
            return true;
        } else {
            return false;
        }
    }

    private void fC(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.mbS.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.mbT[i - 1];
            } else {
                byteBuffer = this.mbU != null ? this.mbU : AudioProcessor.EMPTY_BUFFER;
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.mbS[i];
                audioProcessor.i(byteBuffer);
                ByteBuffer dtR = audioProcessor.dtR();
                this.mbT[i] = dtR;
                if (dtR.hasRemaining()) {
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
            if (this.maZ != null) {
                com.google.android.exoplayer2.util.a.checkArgument(this.maZ == byteBuffer);
            } else {
                this.maZ = byteBuffer;
                if (v.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    if (this.mbV == null || this.mbV.length < remaining) {
                        this.mbV = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.mbV, 0, remaining);
                    byteBuffer.position(position);
                    this.mbW = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (v.SDK_INT < 21) {
                int duk = this.bufferSize - ((int) (this.mbL - (this.mbk.duk() * this.mbK)));
                if (duk > 0) {
                    a2 = this.mbo.write(this.mbV, this.mbW, Math.min(remaining2, duk));
                    if (a2 > 0) {
                        this.mbW += a2;
                        byteBuffer.position(byteBuffer.position() + a2);
                    }
                } else {
                    a2 = 0;
                }
            } else if (this.mca) {
                com.google.android.exoplayer2.util.a.checkState(j != -9223372036854775807L);
                a2 = a(this.mbo, byteBuffer, remaining2, j);
            } else {
                a2 = a(this.mbo, byteBuffer, remaining2);
            }
            this.mcb = SystemClock.elapsedRealtime();
            if (a2 < 0) {
                throw new AudioSink.WriteException(a2);
            }
            if (!this.mbt) {
                this.mbL += a2;
            }
            if (a2 == remaining2) {
                if (this.mbt) {
                    this.mbM += this.mbN;
                }
                this.maZ = null;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dtT() throws AudioSink.WriteException {
        if (!this.mbY && isInitialized() && dtY()) {
            this.mbk.fH(due());
            this.mbz = 0;
            this.mbY = true;
        }
    }

    private boolean dtY() throws AudioSink.WriteException {
        boolean z;
        if (this.mbX == -1) {
            this.mbX = this.mbt ? this.mbS.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.mbX < this.mbS.length) {
            AudioProcessor audioProcessor = this.mbS[this.mbX];
            if (z) {
                audioProcessor.dtQ();
            }
            fC(-9223372036854775807L);
            if (!audioProcessor.avR()) {
                return false;
            }
            this.mbX++;
            z = true;
        }
        if (this.maZ != null) {
            b(this.maZ, -9223372036854775807L);
            if (this.maZ != null) {
                return false;
            }
        }
        this.mbX = -1;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean avR() {
        return !isInitialized() || (this.mbY && !dtU());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean dtU() {
        return isInitialized() && (due() > this.mbk.duk() || duh());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q d(q qVar) {
        q qVar2;
        if (this.mbt) {
            this.lYI = q.lZJ;
            return this.lYI;
        }
        q qVar3 = new q(this.mbg.bw(qVar.speed), this.mbg.bx(qVar.pitch));
        if (this.mbv != null) {
            qVar2 = this.mbv;
        } else {
            qVar2 = !this.mbl.isEmpty() ? this.mbl.getLast().lYI : this.lYI;
        }
        if (!qVar3.equals(qVar2)) {
            if (isInitialized()) {
                this.mbv = qVar3;
            } else {
                this.lYI = qVar3;
            }
        }
        return this.lYI;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q dsV() {
        return this.lYI;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(com.google.android.exoplayer2.audio.b bVar) {
        if (!this.mad.equals(bVar)) {
            this.mad = bVar;
            if (!this.mca) {
                reset();
                this.mab = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Jf(int i) {
        com.google.android.exoplayer2.util.a.checkState(v.SDK_INT >= 21);
        if (!this.mca || this.mab != i) {
            this.mca = true;
            this.mab = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dtV() {
        if (this.mca) {
            this.mca = false;
            this.mab = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            dtZ();
        }
    }

    private void dtZ() {
        if (isInitialized()) {
            if (v.SDK_INT >= 21) {
                a(this.mbo, this.volume);
            } else {
                b(this.mbo, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.mbZ = false;
        if (isInitialized()) {
            duf();
            this.mbk.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$1] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.mbI = 0L;
            this.mbJ = 0L;
            this.mbL = 0L;
            this.mbM = 0L;
            this.mbN = 0;
            if (this.mbv != null) {
                this.lYI = this.mbv;
                this.mbv = null;
            } else if (!this.mbl.isEmpty()) {
                this.lYI = this.mbl.getLast().lYI;
            }
            this.mbl.clear();
            this.mbw = 0L;
            this.mbx = 0L;
            this.mbU = null;
            this.maZ = null;
            for (int i = 0; i < this.mbS.length; i++) {
                AudioProcessor audioProcessor = this.mbS[i];
                audioProcessor.flush();
                this.mbT[i] = audioProcessor.dtR();
            }
            this.mbY = false;
            this.mbX = -1;
            this.mby = null;
            this.mbz = 0;
            this.mbO = 0;
            this.mbR = 0L;
            duf();
            if (this.mbo.getPlayState() == 3) {
                this.mbo.pause();
            }
            final AudioTrack audioTrack = this.mbo;
            this.mbo = null;
            this.mbk.a(null, false);
            this.mbi.close();
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.mbi.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        dua();
        for (AudioProcessor audioProcessor : this.mbh) {
            audioProcessor.reset();
        }
        this.mab = 0;
        this.mbZ = false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$2] */
    private void dua() {
        if (this.mbn != null) {
            final AudioTrack audioTrack = this.mbn;
            this.mbn = null;
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean dub() {
        return isInitialized() && this.mbO != 0;
    }

    private long fD(long j) {
        while (!this.mbl.isEmpty() && j >= this.mbl.getFirst().lZH) {
            c remove = this.mbl.remove();
            this.lYI = remove.lYI;
            this.mbx = remove.lZH;
            this.mbw = remove.mcq - this.mbP;
        }
        if (this.lYI.speed == 1.0f) {
            return (this.mbw + j) - this.mbx;
        }
        if (this.mbl.isEmpty()) {
            return this.mbw + this.mbg.fJ(j - this.mbx);
        }
        return this.mbw + ((long) (this.lYI.speed * (j - this.mbx)));
    }

    private void duc() {
        long dul = this.mbk.dul();
        if (dul != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.mbD >= 30000) {
                this.mbj[this.mbA] = dul - nanoTime;
                this.mbA = (this.mbA + 1) % 10;
                if (this.mbB < 10) {
                    this.mbB++;
                }
                this.mbD = nanoTime;
                this.mbC = 0L;
                for (int i = 0; i < this.mbB; i++) {
                    this.mbC += this.mbj[i] / this.mbB;
                }
            }
            if (!dug() && nanoTime - this.mbF >= 500000) {
                this.mbE = this.mbk.dum();
                if (this.mbE) {
                    long dun = this.mbk.dun() / 1000;
                    long duo = this.mbk.duo();
                    if (dun < this.mbQ) {
                        this.mbE = false;
                    } else if (Math.abs(dun - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + duo + ", " + dun + ", " + nanoTime + ", " + dul + ", " + dud() + ", " + due();
                        if (mbc) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w("AudioTrack", str);
                        this.mbE = false;
                    } else if (Math.abs(fF(duo) - dul) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + duo + ", " + dun + ", " + nanoTime + ", " + dul + ", " + dud() + ", " + due();
                        if (mbc) {
                            throw new InvalidAudioTrackTimestampException(str2);
                        }
                        Log.w("AudioTrack", str2);
                        this.mbE = false;
                    }
                }
                if (this.mbG != null && !this.mbt) {
                    try {
                        this.mbR = (((Integer) this.mbG.invoke(this.mbo, null)).intValue() * 1000) - this.mbu;
                        this.mbR = Math.max(this.mbR, 0L);
                        if (this.mbR > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.mbR);
                            this.mbR = 0L;
                        }
                    } catch (Exception e) {
                        this.mbG = null;
                    }
                }
                this.mbF = nanoTime;
            }
        }
    }

    private boolean isInitialized() {
        return this.mbo != null;
    }

    private long fE(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mbp;
    }

    private long fF(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    private long fG(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    private long dud() {
        return this.mbt ? this.mbJ : this.mbI / this.mbH;
    }

    private long due() {
        return this.mbt ? this.mbM : this.mbL / this.mbK;
    }

    private void duf() {
        this.mbC = 0L;
        this.mbB = 0;
        this.mbA = 0;
        this.mbD = 0L;
        this.mbE = false;
        this.mbF = 0L;
    }

    private boolean dug() {
        return v.SDK_INT < 23 && (this.mbs == 5 || this.mbs == 6);
    }

    private boolean duh() {
        return dug() && this.mbo.getPlayState() == 2 && this.mbo.getPlaybackHeadPosition() == 0;
    }

    private AudioTrack dui() throws AudioSink.InitializationException {
        AudioTrack audioTrack;
        if (v.SDK_INT >= 21) {
            audioTrack = duj();
        } else {
            int Ma = v.Ma(this.mad.maF);
            if (this.mab == 0) {
                audioTrack = new AudioTrack(Ma, this.sampleRate, this.mbq, this.mbs, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(Ma, this.sampleRate, this.mbq, this.mbs, this.bufferSize, 1, this.mab);
            }
        }
        int state = audioTrack.getState();
        if (state != 1) {
            try {
                audioTrack.release();
            } catch (Exception e) {
            }
            throw new AudioSink.InitializationException(state, this.sampleRate, this.mbq, this.bufferSize);
        }
        return audioTrack;
    }

    @TargetApi(21)
    private AudioTrack duj() {
        AudioAttributes dtL;
        if (this.mca) {
            dtL = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            dtL = this.mad.dtL();
        }
        return new AudioTrack(dtL, new AudioFormat.Builder().setChannelMask(this.mbq).setEncoding(this.mbs).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.mab != 0 ? this.mab : 0);
    }

    private AudioTrack Jg(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private static int Pn(String str) {
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
            return com.google.android.exoplayer2.audio.a.dtK();
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
        if (this.mby == null) {
            this.mby = ByteBuffer.allocate(16);
            this.mby.order(ByteOrder.BIG_ENDIAN);
            this.mby.putInt(1431633921);
        }
        if (this.mbz == 0) {
            this.mby.putInt(4, i);
            this.mby.putLong(8, 1000 * j);
            this.mby.position(0);
            this.mbz = i;
        }
        int remaining = this.mby.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.mby, remaining, 1);
            if (write < 0) {
                this.mbz = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i);
        if (a2 < 0) {
            this.mbz = 0;
            return a2;
        }
        this.mbz -= a2;
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
        protected AudioTrack mbo;
        private boolean mce;
        private long mcf;
        private long mcg;
        private long mch;
        private long mci;
        private long mcj;
        private long mck;
        private long mcl;
        private int sampleRate;

        private a() {
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.mbo = audioTrack;
            this.mce = z;
            this.mci = -9223372036854775807L;
            this.mcj = -9223372036854775807L;
            this.mcf = 0L;
            this.mcg = 0L;
            this.mch = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }

        public void fH(long j) {
            this.mck = duk();
            this.mci = SystemClock.elapsedRealtime() * 1000;
            this.mcl = j;
            this.mbo.stop();
        }

        public void pause() {
            if (this.mci == -9223372036854775807L) {
                this.mbo.pause();
            }
        }

        public boolean fI(long j) {
            return this.mcj != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.mcj >= 200;
        }

        public long duk() {
            if (this.mci != -9223372036854775807L) {
                return Math.min(this.mcl, ((((SystemClock.elapsedRealtime() * 1000) - this.mci) * this.sampleRate) / TimeUtils.NANOS_PER_MS) + this.mck);
            }
            int playState = this.mbo.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.mbo.getPlaybackHeadPosition();
            if (this.mce) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.mch = this.mcf;
                }
                playbackHeadPosition += this.mch;
            }
            if (v.SDK_INT <= 26) {
                if (playbackHeadPosition == 0 && this.mcf > 0 && playState == 3) {
                    if (this.mcj == -9223372036854775807L) {
                        this.mcj = SystemClock.elapsedRealtime();
                    }
                    return this.mcf;
                }
                this.mcj = -9223372036854775807L;
            }
            if (this.mcf > playbackHeadPosition) {
                this.mcg++;
            }
            this.mcf = playbackHeadPosition;
            return playbackHeadPosition + (this.mcg << 32);
        }

        public long dul() {
            return (duk() * TimeUtils.NANOS_PER_MS) / this.sampleRate;
        }

        public boolean dum() {
            return false;
        }

        public long dun() {
            throw new UnsupportedOperationException();
        }

        public long duo() {
            throw new UnsupportedOperationException();
        }
    }

    @TargetApi(19)
    /* loaded from: classes6.dex */
    private static class b extends a {
        private final AudioTimestamp mcm;
        private long mcn;
        private long mco;
        private long mcp;

        public b() {
            super();
            this.mcm = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.mcn = 0L;
            this.mco = 0L;
            this.mcp = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public boolean dum() {
            boolean timestamp = this.mbo.getTimestamp(this.mcm);
            if (timestamp) {
                long j = this.mcm.framePosition;
                if (this.mco > j) {
                    this.mcn++;
                }
                this.mco = j;
                this.mcp = j + (this.mcn << 32);
            }
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long dun() {
            return this.mcm.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long duo() {
            return this.mcp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        private final q lYI;
        private final long lZH;
        private final long mcq;

        private c(q qVar, long j, long j2) {
            this.lYI = qVar;
            this.mcq = j;
            this.lZH = j2;
        }
    }
}
