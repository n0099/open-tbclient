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
    public static boolean maZ = false;
    public static boolean mba = false;
    private int bufferSize;
    private boolean gdP;
    private q lYG;
    private int lZZ;
    private ByteBuffer maX;
    private com.google.android.exoplayer2.audio.b maa;
    private long mbA;
    private long mbB;
    private boolean mbC;
    private long mbD;
    private Method mbE;
    private int mbF;
    private long mbG;
    private long mbH;
    private int mbI;
    private long mbJ;
    private long mbK;
    private int mbL;
    private int mbM;
    private long mbN;
    private long mbO;
    private long mbP;
    private AudioProcessor[] mbQ;
    private ByteBuffer[] mbR;
    private ByteBuffer mbS;
    private byte[] mbT;
    private int mbU;
    private int mbV;
    private boolean mbW;
    private boolean mbX;
    private boolean mbY;
    private long mbZ;
    @Nullable
    private final com.google.android.exoplayer2.audio.c mbb;
    private final e mbc;
    private final k mbd;
    private final j mbe;
    private final AudioProcessor[] mbf;
    private final ConditionVariable mbg = new ConditionVariable(true);
    private final long[] mbh;
    private final a mbi;
    private final LinkedList<c> mbj;
    @Nullable
    private AudioSink.a mbk;
    private AudioTrack mbl;
    private AudioTrack mbm;
    private int mbn;
    private int mbo;
    private int mbp;
    private int mbq;
    private boolean mbr;
    private long mbs;
    private q mbt;
    private long mbu;
    private long mbv;
    private ByteBuffer mbw;
    private int mbx;
    private int mby;
    private int mbz;
    private int sampleRate;
    private float volume;

    /* loaded from: classes6.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public DefaultAudioSink(@Nullable com.google.android.exoplayer2.audio.c cVar, AudioProcessor[] audioProcessorArr) {
        this.mbb = cVar;
        if (v.SDK_INT >= 18) {
            try {
                this.mbE = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (v.SDK_INT >= 19) {
            this.mbi = new b();
        } else {
            this.mbi = new a();
        }
        this.mbc = new e();
        this.mbd = new k();
        this.mbe = new j();
        this.mbf = new AudioProcessor[audioProcessorArr.length + 4];
        this.mbf[0] = new h();
        this.mbf[1] = this.mbc;
        this.mbf[2] = this.mbd;
        System.arraycopy(audioProcessorArr, 0, this.mbf, 3, audioProcessorArr.length);
        this.mbf[audioProcessorArr.length + 3] = this.mbe;
        this.mbh = new long[10];
        this.volume = 1.0f;
        this.mbM = 0;
        this.maa = com.google.android.exoplayer2.audio.b.maC;
        this.lZZ = 0;
        this.lYG = q.lZH;
        this.mbV = -1;
        this.mbQ = new AudioProcessor[0];
        this.mbR = new ByteBuffer[0];
        this.mbj = new LinkedList<>();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(AudioSink.a aVar) {
        this.mbk = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean Pm(String str) {
        return this.mbb != null && this.mbb.Jd(Pn(str));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long vF(boolean z) {
        long j;
        if (!dtZ()) {
            return Long.MIN_VALUE;
        }
        if (this.mbm.getPlayState() == 3) {
            dua();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.mbC) {
            j = fF(fG(nanoTime - (this.mbi.dul() / 1000)) + this.mbi.dum());
        } else {
            if (this.mbz == 0) {
                j = this.mbi.duj();
            } else {
                j = nanoTime + this.mbA;
            }
            if (!z) {
                j -= this.mbP;
            }
        }
        long min = Math.min(j, fF(duc()));
        return fD(min) + this.mbN;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        int Pn;
        boolean z;
        int i7;
        this.mbn = i2;
        boolean z2 = !"audio/raw".equals(str);
        if (!z2) {
            this.mbF = v.ea(i3, i);
            this.mbd.dJ(i5, i6);
            this.mbc.n(iArr);
            AudioProcessor[] audioProcessorArr = this.mbf;
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
                        i9 = audioProcessor.dtL();
                        i10 = audioProcessor.dtN();
                        i11 = audioProcessor.dtM();
                    }
                    i8++;
                    z = af;
                } catch (AudioProcessor.UnhandledFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            if (z) {
                dtV();
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
                i7 = com.google.android.exoplayer2.b.lYc;
                break;
            default:
                throw new AudioSink.ConfigurationException("Unsupported channel count: " + i);
        }
        if (v.SDK_INT <= 23 && "foster".equals(v.mHL) && "NVIDIA".equals(v.MANUFACTURER)) {
            switch (i) {
                case 3:
                case 5:
                    i7 = 252;
                    break;
                case 7:
                    i7 = com.google.android.exoplayer2.b.lYc;
                    break;
            }
        }
        int i12 = (v.SDK_INT <= 25 && "fugu".equals(v.mHL) && z2 && i == 1) ? 12 : i7;
        if (z || !isInitialized() || this.mbp != Pn || this.sampleRate != i2 || this.mbo != i12) {
            reset();
            this.mbp = Pn;
            this.mbr = z2;
            this.sampleRate = i2;
            this.mbo = i12;
            this.mbq = z2 ? Pn : 2;
            this.mbI = v.ea(2, i);
            if (i4 != 0) {
                this.bufferSize = i4;
            } else if (z2) {
                if (this.mbq == 5 || this.mbq == 6) {
                    this.bufferSize = 20480;
                } else {
                    this.bufferSize = 49152;
                }
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i12, this.mbq);
                com.google.android.exoplayer2.util.a.checkState(minBufferSize != -2);
                int i13 = minBufferSize * 4;
                int fG = ((int) fG(250000L)) * this.mbI;
                int max = (int) Math.max(minBufferSize, fG(750000L) * this.mbI);
                if (i13 >= fG) {
                    fG = i13 > max ? max : i13;
                }
                this.bufferSize = fG;
            }
            this.mbs = z2 ? -9223372036854775807L : fF(this.bufferSize / this.mbI);
            d(this.lYG);
        }
    }

    private void dtV() {
        AudioProcessor[] audioProcessorArr;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : this.mbf) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.mbQ = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.mbR = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            AudioProcessor audioProcessor2 = this.mbQ[i];
            audioProcessor2.flush();
            this.mbR[i] = audioProcessor2.dtP();
        }
    }

    private void initialize() throws AudioSink.InitializationException {
        this.mbg.block();
        this.mbm = dug();
        int audioSessionId = this.mbm.getAudioSessionId();
        if (maZ && v.SDK_INT < 21) {
            if (this.mbl != null && audioSessionId != this.mbl.getAudioSessionId()) {
                dtY();
            }
            if (this.mbl == null) {
                this.mbl = Jg(audioSessionId);
            }
        }
        if (this.lZZ != audioSessionId) {
            this.lZZ = audioSessionId;
            if (this.mbk != null) {
                this.mbk.EU(audioSessionId);
            }
        }
        this.mbi.a(this.mbm, due());
        dtX();
        this.gdP = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.mbX = true;
        if (isInitialized()) {
            this.mbO = System.nanoTime() / 1000;
            this.mbm.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dtQ() {
        if (this.mbM == 1) {
            this.mbM = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        com.google.android.exoplayer2.util.a.checkArgument(this.mbS == null || byteBuffer == this.mbS);
        if (!isInitialized()) {
            initialize();
            if (this.mbX) {
                play();
            }
        }
        if (due()) {
            if (this.mbm.getPlayState() == 2) {
                this.gdP = false;
                return false;
            } else if (this.mbm.getPlayState() == 1 && this.mbi.dui() != 0) {
                return false;
            }
        }
        boolean z = this.gdP;
        this.gdP = dtS();
        if (z && !this.gdP && this.mbm.getPlayState() != 1 && this.mbk != null) {
            this.mbk.i(this.bufferSize, com.google.android.exoplayer2.b.fn(this.mbs), SystemClock.elapsedRealtime() - this.mbZ);
        }
        if (this.mbS == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.mbr && this.mbL == 0) {
                this.mbL = a(this.mbq, byteBuffer);
            }
            if (this.mbt != null) {
                if (!dtW()) {
                    return false;
                }
                this.mbj.add(new c(this.mbt, Math.max(0L, j), fF(duc())));
                this.mbt = null;
                dtV();
            }
            if (this.mbM == 0) {
                this.mbN = Math.max(0L, j);
                this.mbM = 1;
            } else {
                long fE = this.mbN + fE(dub());
                if (this.mbM == 1 && Math.abs(fE - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + fE + ", got " + j + "]");
                    this.mbM = 2;
                }
                if (this.mbM == 2) {
                    this.mbN = (j - fE) + this.mbN;
                    this.mbM = 1;
                    if (this.mbk != null) {
                        this.mbk.dtU();
                    }
                }
            }
            if (this.mbr) {
                this.mbH += this.mbL;
            } else {
                this.mbG += byteBuffer.remaining();
            }
            this.mbS = byteBuffer;
        }
        if (this.mbr) {
            b(this.mbS, j);
        } else {
            fC(j);
        }
        if (!this.mbS.hasRemaining()) {
            this.mbS = null;
            return true;
        } else if (this.mbi.fI(duc())) {
            Log.w("AudioTrack", "Resetting stalled audio track");
            reset();
            return true;
        } else {
            return false;
        }
    }

    private void fC(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.mbQ.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.mbR[i - 1];
            } else {
                byteBuffer = this.mbS != null ? this.mbS : AudioProcessor.EMPTY_BUFFER;
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.mbQ[i];
                audioProcessor.i(byteBuffer);
                ByteBuffer dtP = audioProcessor.dtP();
                this.mbR[i] = dtP;
                if (dtP.hasRemaining()) {
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
            if (this.maX != null) {
                com.google.android.exoplayer2.util.a.checkArgument(this.maX == byteBuffer);
            } else {
                this.maX = byteBuffer;
                if (v.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    if (this.mbT == null || this.mbT.length < remaining) {
                        this.mbT = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.mbT, 0, remaining);
                    byteBuffer.position(position);
                    this.mbU = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (v.SDK_INT < 21) {
                int dui = this.bufferSize - ((int) (this.mbJ - (this.mbi.dui() * this.mbI)));
                if (dui > 0) {
                    a2 = this.mbm.write(this.mbT, this.mbU, Math.min(remaining2, dui));
                    if (a2 > 0) {
                        this.mbU += a2;
                        byteBuffer.position(byteBuffer.position() + a2);
                    }
                } else {
                    a2 = 0;
                }
            } else if (this.mbY) {
                com.google.android.exoplayer2.util.a.checkState(j != -9223372036854775807L);
                a2 = a(this.mbm, byteBuffer, remaining2, j);
            } else {
                a2 = a(this.mbm, byteBuffer, remaining2);
            }
            this.mbZ = SystemClock.elapsedRealtime();
            if (a2 < 0) {
                throw new AudioSink.WriteException(a2);
            }
            if (!this.mbr) {
                this.mbJ += a2;
            }
            if (a2 == remaining2) {
                if (this.mbr) {
                    this.mbK += this.mbL;
                }
                this.maX = null;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dtR() throws AudioSink.WriteException {
        if (!this.mbW && isInitialized() && dtW()) {
            this.mbi.fH(duc());
            this.mbx = 0;
            this.mbW = true;
        }
    }

    private boolean dtW() throws AudioSink.WriteException {
        boolean z;
        if (this.mbV == -1) {
            this.mbV = this.mbr ? this.mbQ.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.mbV < this.mbQ.length) {
            AudioProcessor audioProcessor = this.mbQ[this.mbV];
            if (z) {
                audioProcessor.dtO();
            }
            fC(-9223372036854775807L);
            if (!audioProcessor.avP()) {
                return false;
            }
            this.mbV++;
            z = true;
        }
        if (this.maX != null) {
            b(this.maX, -9223372036854775807L);
            if (this.maX != null) {
                return false;
            }
        }
        this.mbV = -1;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean avP() {
        return !isInitialized() || (this.mbW && !dtS());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean dtS() {
        return isInitialized() && (duc() > this.mbi.dui() || duf());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q d(q qVar) {
        q qVar2;
        if (this.mbr) {
            this.lYG = q.lZH;
            return this.lYG;
        }
        q qVar3 = new q(this.mbe.bw(qVar.speed), this.mbe.bx(qVar.pitch));
        if (this.mbt != null) {
            qVar2 = this.mbt;
        } else {
            qVar2 = !this.mbj.isEmpty() ? this.mbj.getLast().lYG : this.lYG;
        }
        if (!qVar3.equals(qVar2)) {
            if (isInitialized()) {
                this.mbt = qVar3;
            } else {
                this.lYG = qVar3;
            }
        }
        return this.lYG;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q dsT() {
        return this.lYG;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(com.google.android.exoplayer2.audio.b bVar) {
        if (!this.maa.equals(bVar)) {
            this.maa = bVar;
            if (!this.mbY) {
                reset();
                this.lZZ = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Jf(int i) {
        com.google.android.exoplayer2.util.a.checkState(v.SDK_INT >= 21);
        if (!this.mbY || this.lZZ != i) {
            this.mbY = true;
            this.lZZ = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dtT() {
        if (this.mbY) {
            this.mbY = false;
            this.lZZ = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            dtX();
        }
    }

    private void dtX() {
        if (isInitialized()) {
            if (v.SDK_INT >= 21) {
                a(this.mbm, this.volume);
            } else {
                b(this.mbm, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.mbX = false;
        if (isInitialized()) {
            dud();
            this.mbi.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$1] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.mbG = 0L;
            this.mbH = 0L;
            this.mbJ = 0L;
            this.mbK = 0L;
            this.mbL = 0;
            if (this.mbt != null) {
                this.lYG = this.mbt;
                this.mbt = null;
            } else if (!this.mbj.isEmpty()) {
                this.lYG = this.mbj.getLast().lYG;
            }
            this.mbj.clear();
            this.mbu = 0L;
            this.mbv = 0L;
            this.mbS = null;
            this.maX = null;
            for (int i = 0; i < this.mbQ.length; i++) {
                AudioProcessor audioProcessor = this.mbQ[i];
                audioProcessor.flush();
                this.mbR[i] = audioProcessor.dtP();
            }
            this.mbW = false;
            this.mbV = -1;
            this.mbw = null;
            this.mbx = 0;
            this.mbM = 0;
            this.mbP = 0L;
            dud();
            if (this.mbm.getPlayState() == 3) {
                this.mbm.pause();
            }
            final AudioTrack audioTrack = this.mbm;
            this.mbm = null;
            this.mbi.a(null, false);
            this.mbg.close();
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.mbg.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        dtY();
        for (AudioProcessor audioProcessor : this.mbf) {
            audioProcessor.reset();
        }
        this.lZZ = 0;
        this.mbX = false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$2] */
    private void dtY() {
        if (this.mbl != null) {
            final AudioTrack audioTrack = this.mbl;
            this.mbl = null;
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean dtZ() {
        return isInitialized() && this.mbM != 0;
    }

    private long fD(long j) {
        while (!this.mbj.isEmpty() && j >= this.mbj.getFirst().lZF) {
            c remove = this.mbj.remove();
            this.lYG = remove.lYG;
            this.mbv = remove.lZF;
            this.mbu = remove.mco - this.mbN;
        }
        if (this.lYG.speed == 1.0f) {
            return (this.mbu + j) - this.mbv;
        }
        if (this.mbj.isEmpty()) {
            return this.mbu + this.mbe.fJ(j - this.mbv);
        }
        return this.mbu + ((long) (this.lYG.speed * (j - this.mbv)));
    }

    private void dua() {
        long duj = this.mbi.duj();
        if (duj != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.mbB >= 30000) {
                this.mbh[this.mby] = duj - nanoTime;
                this.mby = (this.mby + 1) % 10;
                if (this.mbz < 10) {
                    this.mbz++;
                }
                this.mbB = nanoTime;
                this.mbA = 0L;
                for (int i = 0; i < this.mbz; i++) {
                    this.mbA += this.mbh[i] / this.mbz;
                }
            }
            if (!due() && nanoTime - this.mbD >= 500000) {
                this.mbC = this.mbi.duk();
                if (this.mbC) {
                    long dul = this.mbi.dul() / 1000;
                    long dum = this.mbi.dum();
                    if (dul < this.mbO) {
                        this.mbC = false;
                    } else if (Math.abs(dul - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + dum + ", " + dul + ", " + nanoTime + ", " + duj + ", " + dub() + ", " + duc();
                        if (mba) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w("AudioTrack", str);
                        this.mbC = false;
                    } else if (Math.abs(fF(dum) - duj) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + dum + ", " + dul + ", " + nanoTime + ", " + duj + ", " + dub() + ", " + duc();
                        if (mba) {
                            throw new InvalidAudioTrackTimestampException(str2);
                        }
                        Log.w("AudioTrack", str2);
                        this.mbC = false;
                    }
                }
                if (this.mbE != null && !this.mbr) {
                    try {
                        this.mbP = (((Integer) this.mbE.invoke(this.mbm, null)).intValue() * 1000) - this.mbs;
                        this.mbP = Math.max(this.mbP, 0L);
                        if (this.mbP > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.mbP);
                            this.mbP = 0L;
                        }
                    } catch (Exception e) {
                        this.mbE = null;
                    }
                }
                this.mbD = nanoTime;
            }
        }
    }

    private boolean isInitialized() {
        return this.mbm != null;
    }

    private long fE(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mbn;
    }

    private long fF(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    private long fG(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    private long dub() {
        return this.mbr ? this.mbH : this.mbG / this.mbF;
    }

    private long duc() {
        return this.mbr ? this.mbK : this.mbJ / this.mbI;
    }

    private void dud() {
        this.mbA = 0L;
        this.mbz = 0;
        this.mby = 0;
        this.mbB = 0L;
        this.mbC = false;
        this.mbD = 0L;
    }

    private boolean due() {
        return v.SDK_INT < 23 && (this.mbq == 5 || this.mbq == 6);
    }

    private boolean duf() {
        return due() && this.mbm.getPlayState() == 2 && this.mbm.getPlaybackHeadPosition() == 0;
    }

    private AudioTrack dug() throws AudioSink.InitializationException {
        AudioTrack audioTrack;
        if (v.SDK_INT >= 21) {
            audioTrack = duh();
        } else {
            int Ma = v.Ma(this.maa.maD);
            if (this.lZZ == 0) {
                audioTrack = new AudioTrack(Ma, this.sampleRate, this.mbo, this.mbq, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(Ma, this.sampleRate, this.mbo, this.mbq, this.bufferSize, 1, this.lZZ);
            }
        }
        int state = audioTrack.getState();
        if (state != 1) {
            try {
                audioTrack.release();
            } catch (Exception e) {
            }
            throw new AudioSink.InitializationException(state, this.sampleRate, this.mbo, this.bufferSize);
        }
        return audioTrack;
    }

    @TargetApi(21)
    private AudioTrack duh() {
        AudioAttributes dtJ;
        if (this.mbY) {
            dtJ = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            dtJ = this.maa.dtJ();
        }
        return new AudioTrack(dtJ, new AudioFormat.Builder().setChannelMask(this.mbo).setEncoding(this.mbq).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.lZZ != 0 ? this.lZZ : 0);
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
            return com.google.android.exoplayer2.audio.a.dtI();
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
        if (this.mbw == null) {
            this.mbw = ByteBuffer.allocate(16);
            this.mbw.order(ByteOrder.BIG_ENDIAN);
            this.mbw.putInt(1431633921);
        }
        if (this.mbx == 0) {
            this.mbw.putInt(4, i);
            this.mbw.putLong(8, 1000 * j);
            this.mbw.position(0);
            this.mbx = i;
        }
        int remaining = this.mbw.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.mbw, remaining, 1);
            if (write < 0) {
                this.mbx = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i);
        if (a2 < 0) {
            this.mbx = 0;
            return a2;
        }
        this.mbx -= a2;
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
        protected AudioTrack mbm;
        private boolean mcc;
        private long mcd;
        private long mce;
        private long mcf;
        private long mcg;
        private long mch;
        private long mci;
        private long mcj;
        private int sampleRate;

        private a() {
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.mbm = audioTrack;
            this.mcc = z;
            this.mcg = -9223372036854775807L;
            this.mch = -9223372036854775807L;
            this.mcd = 0L;
            this.mce = 0L;
            this.mcf = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }

        public void fH(long j) {
            this.mci = dui();
            this.mcg = SystemClock.elapsedRealtime() * 1000;
            this.mcj = j;
            this.mbm.stop();
        }

        public void pause() {
            if (this.mcg == -9223372036854775807L) {
                this.mbm.pause();
            }
        }

        public boolean fI(long j) {
            return this.mch != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.mch >= 200;
        }

        public long dui() {
            if (this.mcg != -9223372036854775807L) {
                return Math.min(this.mcj, ((((SystemClock.elapsedRealtime() * 1000) - this.mcg) * this.sampleRate) / TimeUtils.NANOS_PER_MS) + this.mci);
            }
            int playState = this.mbm.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.mbm.getPlaybackHeadPosition();
            if (this.mcc) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.mcf = this.mcd;
                }
                playbackHeadPosition += this.mcf;
            }
            if (v.SDK_INT <= 26) {
                if (playbackHeadPosition == 0 && this.mcd > 0 && playState == 3) {
                    if (this.mch == -9223372036854775807L) {
                        this.mch = SystemClock.elapsedRealtime();
                    }
                    return this.mcd;
                }
                this.mch = -9223372036854775807L;
            }
            if (this.mcd > playbackHeadPosition) {
                this.mce++;
            }
            this.mcd = playbackHeadPosition;
            return playbackHeadPosition + (this.mce << 32);
        }

        public long duj() {
            return (dui() * TimeUtils.NANOS_PER_MS) / this.sampleRate;
        }

        public boolean duk() {
            return false;
        }

        public long dul() {
            throw new UnsupportedOperationException();
        }

        public long dum() {
            throw new UnsupportedOperationException();
        }
    }

    @TargetApi(19)
    /* loaded from: classes6.dex */
    private static class b extends a {
        private final AudioTimestamp mck;
        private long mcl;
        private long mcm;
        private long mcn;

        public b() {
            super();
            this.mck = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.mcl = 0L;
            this.mcm = 0L;
            this.mcn = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public boolean duk() {
            boolean timestamp = this.mbm.getTimestamp(this.mck);
            if (timestamp) {
                long j = this.mck.framePosition;
                if (this.mcm > j) {
                    this.mcl++;
                }
                this.mcm = j;
                this.mcn = j + (this.mcl << 32);
            }
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long dul() {
            return this.mck.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long dum() {
            return this.mcn;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        private final q lYG;
        private final long lZF;
        private final long mco;

        private c(q qVar, long j, long j2) {
            this.lYG = qVar;
            this.mco = j;
            this.lZF = j2;
        }
    }
}
