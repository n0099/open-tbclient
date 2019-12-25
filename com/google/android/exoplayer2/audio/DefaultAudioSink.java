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
/* loaded from: classes4.dex */
public final class DefaultAudioSink implements AudioSink {
    public static boolean lWw = false;
    public static boolean lWx = false;
    private int bufferSize;
    private boolean fYF;
    private q lUe;
    private com.google.android.exoplayer2.audio.b lVA;
    private int lVz;
    private final k lWA;
    private final j lWB;
    private final AudioProcessor[] lWC;
    private final ConditionVariable lWD = new ConditionVariable(true);
    private final long[] lWE;
    private final a lWF;
    private final LinkedList<c> lWG;
    @Nullable
    private AudioSink.a lWH;
    private AudioTrack lWI;
    private AudioTrack lWJ;
    private int lWK;
    private int lWL;
    private int lWM;
    private int lWN;
    private boolean lWO;
    private long lWP;
    private q lWQ;
    private long lWR;
    private long lWS;
    private ByteBuffer lWT;
    private int lWU;
    private int lWV;
    private int lWW;
    private long lWX;
    private long lWY;
    private boolean lWZ;
    private ByteBuffer lWu;
    @Nullable
    private final com.google.android.exoplayer2.audio.c lWy;
    private final e lWz;
    private long lXa;
    private Method lXb;
    private int lXc;
    private long lXd;
    private long lXe;
    private int lXf;
    private long lXg;
    private long lXh;
    private int lXi;
    private int lXj;
    private long lXk;
    private long lXl;
    private long lXm;
    private AudioProcessor[] lXn;
    private ByteBuffer[] lXo;
    private ByteBuffer lXp;
    private byte[] lXq;
    private int lXr;
    private int lXs;
    private boolean lXt;
    private boolean lXu;
    private boolean lXv;
    private long lXw;
    private int sampleRate;
    private float volume;

    /* loaded from: classes4.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public DefaultAudioSink(@Nullable com.google.android.exoplayer2.audio.c cVar, AudioProcessor[] audioProcessorArr) {
        this.lWy = cVar;
        if (v.SDK_INT >= 18) {
            try {
                this.lXb = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (v.SDK_INT >= 19) {
            this.lWF = new b();
        } else {
            this.lWF = new a();
        }
        this.lWz = new e();
        this.lWA = new k();
        this.lWB = new j();
        this.lWC = new AudioProcessor[audioProcessorArr.length + 4];
        this.lWC[0] = new h();
        this.lWC[1] = this.lWz;
        this.lWC[2] = this.lWA;
        System.arraycopy(audioProcessorArr, 0, this.lWC, 3, audioProcessorArr.length);
        this.lWC[audioProcessorArr.length + 3] = this.lWB;
        this.lWE = new long[10];
        this.volume = 1.0f;
        this.lXj = 0;
        this.lVA = com.google.android.exoplayer2.audio.b.lVZ;
        this.lVz = 0;
        this.lUe = q.lVf;
        this.lXs = -1;
        this.lXn = new AudioProcessor[0];
        this.lXo = new ByteBuffer[0];
        this.lWG = new LinkedList<>();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(AudioSink.a aVar) {
        this.lWH = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean OO(String str) {
        return this.lWy != null && this.lWy.IP(OP(str));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long vp(boolean z) {
        long j;
        if (!drA()) {
            return Long.MIN_VALUE;
        }
        if (this.lWJ.getPlayState() == 3) {
            drB();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.lWZ) {
            j = fC(fD(nanoTime - (this.lWF.drM() / 1000)) + this.lWF.drN());
        } else {
            if (this.lWW == 0) {
                j = this.lWF.drK();
            } else {
                j = nanoTime + this.lWX;
            }
            if (!z) {
                j -= this.lXm;
            }
        }
        long min = Math.min(j, fC(drD()));
        return fA(min) + this.lXk;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        int OP;
        boolean z;
        int i7;
        this.lWK = i2;
        boolean z2 = !"audio/raw".equals(str);
        if (!z2) {
            this.lXc = v.dZ(i3, i);
            this.lWA.dI(i5, i6);
            this.lWz.o(iArr);
            AudioProcessor[] audioProcessorArr = this.lWC;
            int length = audioProcessorArr.length;
            int i8 = 0;
            z = false;
            int i9 = i;
            int i10 = i2;
            int i11 = i3;
            while (i8 < length) {
                AudioProcessor audioProcessor = audioProcessorArr[i8];
                try {
                    boolean ae = audioProcessor.ae(i10, i9, i11) | z;
                    if (audioProcessor.isActive()) {
                        i9 = audioProcessor.drm();
                        i10 = audioProcessor.dro();
                        i11 = audioProcessor.drn();
                    }
                    i8++;
                    z = ae;
                } catch (AudioProcessor.UnhandledFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            if (z) {
                drw();
                i2 = i10;
                i = i9;
                OP = i11;
            } else {
                i2 = i10;
                i = i9;
                OP = i11;
            }
        } else {
            OP = OP(str);
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
                i7 = com.google.android.exoplayer2.b.lTA;
                break;
            default:
                throw new AudioSink.ConfigurationException("Unsupported channel count: " + i);
        }
        if (v.SDK_INT <= 23 && "foster".equals(v.mDl) && "NVIDIA".equals(v.MANUFACTURER)) {
            switch (i) {
                case 3:
                case 5:
                    i7 = 252;
                    break;
                case 7:
                    i7 = com.google.android.exoplayer2.b.lTA;
                    break;
            }
        }
        int i12 = (v.SDK_INT <= 25 && "fugu".equals(v.mDl) && z2 && i == 1) ? 12 : i7;
        if (z || !isInitialized() || this.lWM != OP || this.sampleRate != i2 || this.lWL != i12) {
            reset();
            this.lWM = OP;
            this.lWO = z2;
            this.sampleRate = i2;
            this.lWL = i12;
            this.lWN = z2 ? OP : 2;
            this.lXf = v.dZ(2, i);
            if (i4 != 0) {
                this.bufferSize = i4;
            } else if (z2) {
                if (this.lWN == 5 || this.lWN == 6) {
                    this.bufferSize = 20480;
                } else {
                    this.bufferSize = 49152;
                }
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i12, this.lWN);
                com.google.android.exoplayer2.util.a.checkState(minBufferSize != -2);
                int i13 = minBufferSize * 4;
                int fD = ((int) fD(250000L)) * this.lXf;
                int max = (int) Math.max(minBufferSize, fD(750000L) * this.lXf);
                if (i13 >= fD) {
                    fD = i13 > max ? max : i13;
                }
                this.bufferSize = fD;
            }
            this.lWP = z2 ? -9223372036854775807L : fC(this.bufferSize / this.lXf);
            d(this.lUe);
        }
    }

    private void drw() {
        AudioProcessor[] audioProcessorArr;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : this.lWC) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.lXn = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.lXo = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            AudioProcessor audioProcessor2 = this.lXn[i];
            audioProcessor2.flush();
            this.lXo[i] = audioProcessor2.drq();
        }
    }

    private void initialize() throws AudioSink.InitializationException {
        this.lWD.block();
        this.lWJ = drH();
        int audioSessionId = this.lWJ.getAudioSessionId();
        if (lWw && v.SDK_INT < 21) {
            if (this.lWI != null && audioSessionId != this.lWI.getAudioSessionId()) {
                drz();
            }
            if (this.lWI == null) {
                this.lWI = IS(audioSessionId);
            }
        }
        if (this.lVz != audioSessionId) {
            this.lVz = audioSessionId;
            if (this.lWH != null) {
                this.lWH.EK(audioSessionId);
            }
        }
        this.lWF.a(this.lWJ, drF());
        dry();
        this.fYF = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.lXu = true;
        if (isInitialized()) {
            this.lXl = System.nanoTime() / 1000;
            this.lWJ.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void drr() {
        if (this.lXj == 1) {
            this.lXj = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        com.google.android.exoplayer2.util.a.checkArgument(this.lXp == null || byteBuffer == this.lXp);
        if (!isInitialized()) {
            initialize();
            if (this.lXu) {
                play();
            }
        }
        if (drF()) {
            if (this.lWJ.getPlayState() == 2) {
                this.fYF = false;
                return false;
            } else if (this.lWJ.getPlayState() == 1 && this.lWF.drJ() != 0) {
                return false;
            }
        }
        boolean z = this.fYF;
        this.fYF = drt();
        if (z && !this.fYF && this.lWJ.getPlayState() != 1 && this.lWH != null) {
            this.lWH.i(this.bufferSize, com.google.android.exoplayer2.b.fk(this.lWP), SystemClock.elapsedRealtime() - this.lXw);
        }
        if (this.lXp == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.lWO && this.lXi == 0) {
                this.lXi = a(this.lWN, byteBuffer);
            }
            if (this.lWQ != null) {
                if (!drx()) {
                    return false;
                }
                this.lWG.add(new c(this.lWQ, Math.max(0L, j), fC(drD())));
                this.lWQ = null;
                drw();
            }
            if (this.lXj == 0) {
                this.lXk = Math.max(0L, j);
                this.lXj = 1;
            } else {
                long fB = this.lXk + fB(drC());
                if (this.lXj == 1 && Math.abs(fB - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + fB + ", got " + j + "]");
                    this.lXj = 2;
                }
                if (this.lXj == 2) {
                    this.lXk = (j - fB) + this.lXk;
                    this.lXj = 1;
                    if (this.lWH != null) {
                        this.lWH.drv();
                    }
                }
            }
            if (this.lWO) {
                this.lXe += this.lXi;
            } else {
                this.lXd += byteBuffer.remaining();
            }
            this.lXp = byteBuffer;
        }
        if (this.lWO) {
            b(this.lXp, j);
        } else {
            fz(j);
        }
        if (!this.lXp.hasRemaining()) {
            this.lXp = null;
            return true;
        } else if (this.lWF.fF(drD())) {
            Log.w("AudioTrack", "Resetting stalled audio track");
            reset();
            return true;
        } else {
            return false;
        }
    }

    private void fz(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.lXn.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.lXo[i - 1];
            } else {
                byteBuffer = this.lXp != null ? this.lXp : AudioProcessor.EMPTY_BUFFER;
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.lXn[i];
                audioProcessor.i(byteBuffer);
                ByteBuffer drq = audioProcessor.drq();
                this.lXo[i] = drq;
                if (drq.hasRemaining()) {
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
            if (this.lWu != null) {
                com.google.android.exoplayer2.util.a.checkArgument(this.lWu == byteBuffer);
            } else {
                this.lWu = byteBuffer;
                if (v.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    if (this.lXq == null || this.lXq.length < remaining) {
                        this.lXq = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.lXq, 0, remaining);
                    byteBuffer.position(position);
                    this.lXr = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (v.SDK_INT < 21) {
                int drJ = this.bufferSize - ((int) (this.lXg - (this.lWF.drJ() * this.lXf)));
                if (drJ > 0) {
                    a2 = this.lWJ.write(this.lXq, this.lXr, Math.min(remaining2, drJ));
                    if (a2 > 0) {
                        this.lXr += a2;
                        byteBuffer.position(byteBuffer.position() + a2);
                    }
                } else {
                    a2 = 0;
                }
            } else if (this.lXv) {
                com.google.android.exoplayer2.util.a.checkState(j != -9223372036854775807L);
                a2 = a(this.lWJ, byteBuffer, remaining2, j);
            } else {
                a2 = a(this.lWJ, byteBuffer, remaining2);
            }
            this.lXw = SystemClock.elapsedRealtime();
            if (a2 < 0) {
                throw new AudioSink.WriteException(a2);
            }
            if (!this.lWO) {
                this.lXg += a2;
            }
            if (a2 == remaining2) {
                if (this.lWO) {
                    this.lXh += this.lXi;
                }
                this.lWu = null;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void drs() throws AudioSink.WriteException {
        if (!this.lXt && isInitialized() && drx()) {
            this.lWF.fE(drD());
            this.lWU = 0;
            this.lXt = true;
        }
    }

    private boolean drx() throws AudioSink.WriteException {
        boolean z;
        if (this.lXs == -1) {
            this.lXs = this.lWO ? this.lXn.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.lXs < this.lXn.length) {
            AudioProcessor audioProcessor = this.lXn[this.lXs];
            if (z) {
                audioProcessor.drp();
            }
            fz(-9223372036854775807L);
            if (!audioProcessor.ati()) {
                return false;
            }
            this.lXs++;
            z = true;
        }
        if (this.lWu != null) {
            b(this.lWu, -9223372036854775807L);
            if (this.lWu != null) {
                return false;
            }
        }
        this.lXs = -1;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean ati() {
        return !isInitialized() || (this.lXt && !drt());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean drt() {
        return isInitialized() && (drD() > this.lWF.drJ() || drG());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q d(q qVar) {
        q qVar2;
        if (this.lWO) {
            this.lUe = q.lVf;
            return this.lUe;
        }
        q qVar3 = new q(this.lWB.bx(qVar.speed), this.lWB.by(qVar.pitch));
        if (this.lWQ != null) {
            qVar2 = this.lWQ;
        } else {
            qVar2 = !this.lWG.isEmpty() ? this.lWG.getLast().lUe : this.lUe;
        }
        if (!qVar3.equals(qVar2)) {
            if (isInitialized()) {
                this.lWQ = qVar3;
            } else {
                this.lUe = qVar3;
            }
        }
        return this.lUe;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q dqt() {
        return this.lUe;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(com.google.android.exoplayer2.audio.b bVar) {
        if (!this.lVA.equals(bVar)) {
            this.lVA = bVar;
            if (!this.lXv) {
                reset();
                this.lVz = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void IR(int i) {
        com.google.android.exoplayer2.util.a.checkState(v.SDK_INT >= 21);
        if (!this.lXv || this.lVz != i) {
            this.lXv = true;
            this.lVz = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dru() {
        if (this.lXv) {
            this.lXv = false;
            this.lVz = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            dry();
        }
    }

    private void dry() {
        if (isInitialized()) {
            if (v.SDK_INT >= 21) {
                a(this.lWJ, this.volume);
            } else {
                b(this.lWJ, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.lXu = false;
        if (isInitialized()) {
            drE();
            this.lWF.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$1] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.lXd = 0L;
            this.lXe = 0L;
            this.lXg = 0L;
            this.lXh = 0L;
            this.lXi = 0;
            if (this.lWQ != null) {
                this.lUe = this.lWQ;
                this.lWQ = null;
            } else if (!this.lWG.isEmpty()) {
                this.lUe = this.lWG.getLast().lUe;
            }
            this.lWG.clear();
            this.lWR = 0L;
            this.lWS = 0L;
            this.lXp = null;
            this.lWu = null;
            for (int i = 0; i < this.lXn.length; i++) {
                AudioProcessor audioProcessor = this.lXn[i];
                audioProcessor.flush();
                this.lXo[i] = audioProcessor.drq();
            }
            this.lXt = false;
            this.lXs = -1;
            this.lWT = null;
            this.lWU = 0;
            this.lXj = 0;
            this.lXm = 0L;
            drE();
            if (this.lWJ.getPlayState() == 3) {
                this.lWJ.pause();
            }
            final AudioTrack audioTrack = this.lWJ;
            this.lWJ = null;
            this.lWF.a(null, false);
            this.lWD.close();
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.lWD.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        drz();
        for (AudioProcessor audioProcessor : this.lWC) {
            audioProcessor.reset();
        }
        this.lVz = 0;
        this.lXu = false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$2] */
    private void drz() {
        if (this.lWI != null) {
            final AudioTrack audioTrack = this.lWI;
            this.lWI = null;
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean drA() {
        return isInitialized() && this.lXj != 0;
    }

    private long fA(long j) {
        while (!this.lWG.isEmpty() && j >= this.lWG.getFirst().lVd) {
            c remove = this.lWG.remove();
            this.lUe = remove.lUe;
            this.lWS = remove.lVd;
            this.lWR = remove.lXL - this.lXk;
        }
        if (this.lUe.speed == 1.0f) {
            return (this.lWR + j) - this.lWS;
        }
        if (this.lWG.isEmpty()) {
            return this.lWR + this.lWB.fG(j - this.lWS);
        }
        return this.lWR + ((long) (this.lUe.speed * (j - this.lWS)));
    }

    private void drB() {
        long drK = this.lWF.drK();
        if (drK != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.lWY >= 30000) {
                this.lWE[this.lWV] = drK - nanoTime;
                this.lWV = (this.lWV + 1) % 10;
                if (this.lWW < 10) {
                    this.lWW++;
                }
                this.lWY = nanoTime;
                this.lWX = 0L;
                for (int i = 0; i < this.lWW; i++) {
                    this.lWX += this.lWE[i] / this.lWW;
                }
            }
            if (!drF() && nanoTime - this.lXa >= 500000) {
                this.lWZ = this.lWF.drL();
                if (this.lWZ) {
                    long drM = this.lWF.drM() / 1000;
                    long drN = this.lWF.drN();
                    if (drM < this.lXl) {
                        this.lWZ = false;
                    } else if (Math.abs(drM - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + drN + ", " + drM + ", " + nanoTime + ", " + drK + ", " + drC() + ", " + drD();
                        if (lWx) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w("AudioTrack", str);
                        this.lWZ = false;
                    } else if (Math.abs(fC(drN) - drK) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + drN + ", " + drM + ", " + nanoTime + ", " + drK + ", " + drC() + ", " + drD();
                        if (lWx) {
                            throw new InvalidAudioTrackTimestampException(str2);
                        }
                        Log.w("AudioTrack", str2);
                        this.lWZ = false;
                    }
                }
                if (this.lXb != null && !this.lWO) {
                    try {
                        this.lXm = (((Integer) this.lXb.invoke(this.lWJ, null)).intValue() * 1000) - this.lWP;
                        this.lXm = Math.max(this.lXm, 0L);
                        if (this.lXm > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.lXm);
                            this.lXm = 0L;
                        }
                    } catch (Exception e) {
                        this.lXb = null;
                    }
                }
                this.lXa = nanoTime;
            }
        }
    }

    private boolean isInitialized() {
        return this.lWJ != null;
    }

    private long fB(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.lWK;
    }

    private long fC(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    private long fD(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    private long drC() {
        return this.lWO ? this.lXe : this.lXd / this.lXc;
    }

    private long drD() {
        return this.lWO ? this.lXh : this.lXg / this.lXf;
    }

    private void drE() {
        this.lWX = 0L;
        this.lWW = 0;
        this.lWV = 0;
        this.lWY = 0L;
        this.lWZ = false;
        this.lXa = 0L;
    }

    private boolean drF() {
        return v.SDK_INT < 23 && (this.lWN == 5 || this.lWN == 6);
    }

    private boolean drG() {
        return drF() && this.lWJ.getPlayState() == 2 && this.lWJ.getPlaybackHeadPosition() == 0;
    }

    private AudioTrack drH() throws AudioSink.InitializationException {
        AudioTrack audioTrack;
        if (v.SDK_INT >= 21) {
            audioTrack = drI();
        } else {
            int LM = v.LM(this.lVA.lWa);
            if (this.lVz == 0) {
                audioTrack = new AudioTrack(LM, this.sampleRate, this.lWL, this.lWN, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(LM, this.sampleRate, this.lWL, this.lWN, this.bufferSize, 1, this.lVz);
            }
        }
        int state = audioTrack.getState();
        if (state != 1) {
            try {
                audioTrack.release();
            } catch (Exception e) {
            }
            throw new AudioSink.InitializationException(state, this.sampleRate, this.lWL, this.bufferSize);
        }
        return audioTrack;
    }

    @TargetApi(21)
    private AudioTrack drI() {
        AudioAttributes drk;
        if (this.lXv) {
            drk = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            drk = this.lVA.drk();
        }
        return new AudioTrack(drk, new AudioFormat.Builder().setChannelMask(this.lWL).setEncoding(this.lWN).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.lVz != 0 ? this.lVz : 0);
    }

    private AudioTrack IS(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private static int OP(String str) {
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
            return com.google.android.exoplayer2.audio.a.drj();
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
        if (this.lWT == null) {
            this.lWT = ByteBuffer.allocate(16);
            this.lWT.order(ByteOrder.BIG_ENDIAN);
            this.lWT.putInt(1431633921);
        }
        if (this.lWU == 0) {
            this.lWT.putInt(4, i);
            this.lWT.putLong(8, 1000 * j);
            this.lWT.position(0);
            this.lWU = i;
        }
        int remaining = this.lWT.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.lWT, remaining, 1);
            if (write < 0) {
                this.lWU = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i);
        if (a2 < 0) {
            this.lWU = 0;
            return a2;
        }
        this.lWU -= a2;
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
    /* loaded from: classes4.dex */
    public static class a {
        protected AudioTrack lWJ;
        private long lXA;
        private long lXB;
        private long lXC;
        private long lXD;
        private long lXE;
        private long lXF;
        private long lXG;
        private boolean lXz;
        private int sampleRate;

        private a() {
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.lWJ = audioTrack;
            this.lXz = z;
            this.lXD = -9223372036854775807L;
            this.lXE = -9223372036854775807L;
            this.lXA = 0L;
            this.lXB = 0L;
            this.lXC = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }

        public void fE(long j) {
            this.lXF = drJ();
            this.lXD = SystemClock.elapsedRealtime() * 1000;
            this.lXG = j;
            this.lWJ.stop();
        }

        public void pause() {
            if (this.lXD == -9223372036854775807L) {
                this.lWJ.pause();
            }
        }

        public boolean fF(long j) {
            return this.lXE != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.lXE >= 200;
        }

        public long drJ() {
            if (this.lXD != -9223372036854775807L) {
                return Math.min(this.lXG, ((((SystemClock.elapsedRealtime() * 1000) - this.lXD) * this.sampleRate) / TimeUtils.NANOS_PER_MS) + this.lXF);
            }
            int playState = this.lWJ.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.lWJ.getPlaybackHeadPosition();
            if (this.lXz) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.lXC = this.lXA;
                }
                playbackHeadPosition += this.lXC;
            }
            if (v.SDK_INT <= 26) {
                if (playbackHeadPosition == 0 && this.lXA > 0 && playState == 3) {
                    if (this.lXE == -9223372036854775807L) {
                        this.lXE = SystemClock.elapsedRealtime();
                    }
                    return this.lXA;
                }
                this.lXE = -9223372036854775807L;
            }
            if (this.lXA > playbackHeadPosition) {
                this.lXB++;
            }
            this.lXA = playbackHeadPosition;
            return playbackHeadPosition + (this.lXB << 32);
        }

        public long drK() {
            return (drJ() * TimeUtils.NANOS_PER_MS) / this.sampleRate;
        }

        public boolean drL() {
            return false;
        }

        public long drM() {
            throw new UnsupportedOperationException();
        }

        public long drN() {
            throw new UnsupportedOperationException();
        }
    }

    @TargetApi(19)
    /* loaded from: classes4.dex */
    private static class b extends a {
        private final AudioTimestamp lXH;
        private long lXI;
        private long lXJ;
        private long lXK;

        public b() {
            super();
            this.lXH = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.lXI = 0L;
            this.lXJ = 0L;
            this.lXK = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public boolean drL() {
            boolean timestamp = this.lWJ.getTimestamp(this.lXH);
            if (timestamp) {
                long j = this.lXH.framePosition;
                if (this.lXJ > j) {
                    this.lXI++;
                }
                this.lXJ = j;
                this.lXK = j + (this.lXI << 32);
            }
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long drM() {
            return this.lXH.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long drN() {
            return this.lXK;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c {
        private final q lUe;
        private final long lVd;
        private final long lXL;

        private c(q qVar, long j, long j2) {
            this.lUe = qVar;
            this.lXL = j;
            this.lVd = j2;
        }
    }
}
