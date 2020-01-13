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
/* loaded from: classes5.dex */
public final class DefaultAudioSink implements AudioSink {
    public static boolean mam = false;
    public static boolean man = false;
    private int bufferSize;
    private boolean gbO;
    private q lXV;
    private int lZo;
    private com.google.android.exoplayer2.audio.b lZp;
    private AudioTrack maA;
    private AudioTrack maB;
    private int maC;
    private int maD;
    private int maE;
    private int maF;
    private boolean maG;
    private long maH;
    private q maI;
    private long maJ;
    private long maK;
    private ByteBuffer maL;
    private int maM;
    private int maN;
    private int maO;
    private long maP;
    private long maQ;
    private boolean maR;
    private long maS;
    private Method maT;
    private int maU;
    private long maV;
    private long maW;
    private int maX;
    private long maY;
    private long maZ;
    private ByteBuffer mak;
    @Nullable
    private final com.google.android.exoplayer2.audio.c mao;
    private final e maq;
    private final k mar;
    private final j mas;
    private final AudioProcessor[] mat;
    private final ConditionVariable mau = new ConditionVariable(true);
    private final long[] mav;
    private final a maw;
    private final LinkedList<c> may;
    @Nullable
    private AudioSink.a maz;
    private int mba;
    private int mbb;
    private long mbc;
    private long mbd;
    private long mbe;
    private AudioProcessor[] mbf;
    private ByteBuffer[] mbg;
    private ByteBuffer mbh;
    private byte[] mbi;
    private int mbj;
    private int mbk;
    private boolean mbl;
    private boolean mbm;
    private boolean mbn;
    private long mbo;
    private int sampleRate;
    private float volume;

    /* loaded from: classes5.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public DefaultAudioSink(@Nullable com.google.android.exoplayer2.audio.c cVar, AudioProcessor[] audioProcessorArr) {
        this.mao = cVar;
        if (v.SDK_INT >= 18) {
            try {
                this.maT = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (v.SDK_INT >= 19) {
            this.maw = new b();
        } else {
            this.maw = new a();
        }
        this.maq = new e();
        this.mar = new k();
        this.mas = new j();
        this.mat = new AudioProcessor[audioProcessorArr.length + 4];
        this.mat[0] = new h();
        this.mat[1] = this.maq;
        this.mat[2] = this.mar;
        System.arraycopy(audioProcessorArr, 0, this.mat, 3, audioProcessorArr.length);
        this.mat[audioProcessorArr.length + 3] = this.mas;
        this.mav = new long[10];
        this.volume = 1.0f;
        this.mbb = 0;
        this.lZp = com.google.android.exoplayer2.audio.b.lZO;
        this.lZo = 0;
        this.lXV = q.lYW;
        this.mbk = -1;
        this.mbf = new AudioProcessor[0];
        this.mbg = new ByteBuffer[0];
        this.may = new LinkedList<>();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(AudioSink.a aVar) {
        this.maz = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean OZ(String str) {
        return this.mao != null && this.mao.IY(Pa(str));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long vB(boolean z) {
        long j;
        if (!dsM()) {
            return Long.MIN_VALUE;
        }
        if (this.maB.getPlayState() == 3) {
            dsN();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.maR) {
            j = fH(fI(nanoTime - (this.maw.dsY() / 1000)) + this.maw.dsZ());
        } else {
            if (this.maO == 0) {
                j = this.maw.dsW();
            } else {
                j = nanoTime + this.maP;
            }
            if (!z) {
                j -= this.mbe;
            }
        }
        long min = Math.min(j, fH(dsP()));
        return fF(min) + this.mbc;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        int Pa;
        boolean z;
        int i7;
        this.maC = i2;
        boolean z2 = !"audio/raw".equals(str);
        if (!z2) {
            this.maU = v.dX(i3, i);
            this.mar.dG(i5, i6);
            this.maq.o(iArr);
            AudioProcessor[] audioProcessorArr = this.mat;
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
                        i9 = audioProcessor.dsy();
                        i10 = audioProcessor.dsA();
                        i11 = audioProcessor.dsz();
                    }
                    i8++;
                    z = ae;
                } catch (AudioProcessor.UnhandledFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            if (z) {
                dsI();
                i2 = i10;
                i = i9;
                Pa = i11;
            } else {
                i2 = i10;
                i = i9;
                Pa = i11;
            }
        } else {
            Pa = Pa(str);
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
                i7 = com.google.android.exoplayer2.b.lXr;
                break;
            default:
                throw new AudioSink.ConfigurationException("Unsupported channel count: " + i);
        }
        if (v.SDK_INT <= 23 && "foster".equals(v.mHb) && "NVIDIA".equals(v.MANUFACTURER)) {
            switch (i) {
                case 3:
                case 5:
                    i7 = 252;
                    break;
                case 7:
                    i7 = com.google.android.exoplayer2.b.lXr;
                    break;
            }
        }
        int i12 = (v.SDK_INT <= 25 && "fugu".equals(v.mHb) && z2 && i == 1) ? 12 : i7;
        if (z || !isInitialized() || this.maE != Pa || this.sampleRate != i2 || this.maD != i12) {
            reset();
            this.maE = Pa;
            this.maG = z2;
            this.sampleRate = i2;
            this.maD = i12;
            this.maF = z2 ? Pa : 2;
            this.maX = v.dX(2, i);
            if (i4 != 0) {
                this.bufferSize = i4;
            } else if (z2) {
                if (this.maF == 5 || this.maF == 6) {
                    this.bufferSize = 20480;
                } else {
                    this.bufferSize = 49152;
                }
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i12, this.maF);
                com.google.android.exoplayer2.util.a.checkState(minBufferSize != -2);
                int i13 = minBufferSize * 4;
                int fI = ((int) fI(250000L)) * this.maX;
                int max = (int) Math.max(minBufferSize, fI(750000L) * this.maX);
                if (i13 >= fI) {
                    fI = i13 > max ? max : i13;
                }
                this.bufferSize = fI;
            }
            this.maH = z2 ? -9223372036854775807L : fH(this.bufferSize / this.maX);
            d(this.lXV);
        }
    }

    private void dsI() {
        AudioProcessor[] audioProcessorArr;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : this.mat) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.mbf = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.mbg = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            AudioProcessor audioProcessor2 = this.mbf[i];
            audioProcessor2.flush();
            this.mbg[i] = audioProcessor2.dsC();
        }
    }

    private void initialize() throws AudioSink.InitializationException {
        this.mau.block();
        this.maB = dsT();
        int audioSessionId = this.maB.getAudioSessionId();
        if (mam && v.SDK_INT < 21) {
            if (this.maA != null && audioSessionId != this.maA.getAudioSessionId()) {
                dsL();
            }
            if (this.maA == null) {
                this.maA = Jb(audioSessionId);
            }
        }
        if (this.lZo != audioSessionId) {
            this.lZo = audioSessionId;
            if (this.maz != null) {
                this.maz.EP(audioSessionId);
            }
        }
        this.maw.a(this.maB, dsR());
        dsK();
        this.gbO = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.mbm = true;
        if (isInitialized()) {
            this.mbd = System.nanoTime() / 1000;
            this.maB.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dsD() {
        if (this.mbb == 1) {
            this.mbb = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        com.google.android.exoplayer2.util.a.checkArgument(this.mbh == null || byteBuffer == this.mbh);
        if (!isInitialized()) {
            initialize();
            if (this.mbm) {
                play();
            }
        }
        if (dsR()) {
            if (this.maB.getPlayState() == 2) {
                this.gbO = false;
                return false;
            } else if (this.maB.getPlayState() == 1 && this.maw.dsV() != 0) {
                return false;
            }
        }
        boolean z = this.gbO;
        this.gbO = dsF();
        if (z && !this.gbO && this.maB.getPlayState() != 1 && this.maz != null) {
            this.maz.i(this.bufferSize, com.google.android.exoplayer2.b.fp(this.maH), SystemClock.elapsedRealtime() - this.mbo);
        }
        if (this.mbh == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.maG && this.mba == 0) {
                this.mba = a(this.maF, byteBuffer);
            }
            if (this.maI != null) {
                if (!dsJ()) {
                    return false;
                }
                this.may.add(new c(this.maI, Math.max(0L, j), fH(dsP())));
                this.maI = null;
                dsI();
            }
            if (this.mbb == 0) {
                this.mbc = Math.max(0L, j);
                this.mbb = 1;
            } else {
                long fG = this.mbc + fG(dsO());
                if (this.mbb == 1 && Math.abs(fG - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + fG + ", got " + j + "]");
                    this.mbb = 2;
                }
                if (this.mbb == 2) {
                    this.mbc = (j - fG) + this.mbc;
                    this.mbb = 1;
                    if (this.maz != null) {
                        this.maz.dsH();
                    }
                }
            }
            if (this.maG) {
                this.maW += this.mba;
            } else {
                this.maV += byteBuffer.remaining();
            }
            this.mbh = byteBuffer;
        }
        if (this.maG) {
            b(this.mbh, j);
        } else {
            fE(j);
        }
        if (!this.mbh.hasRemaining()) {
            this.mbh = null;
            return true;
        } else if (this.maw.fK(dsP())) {
            Log.w("AudioTrack", "Resetting stalled audio track");
            reset();
            return true;
        } else {
            return false;
        }
    }

    private void fE(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.mbf.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.mbg[i - 1];
            } else {
                byteBuffer = this.mbh != null ? this.mbh : AudioProcessor.EMPTY_BUFFER;
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.mbf[i];
                audioProcessor.i(byteBuffer);
                ByteBuffer dsC = audioProcessor.dsC();
                this.mbg[i] = dsC;
                if (dsC.hasRemaining()) {
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
            if (this.mak != null) {
                com.google.android.exoplayer2.util.a.checkArgument(this.mak == byteBuffer);
            } else {
                this.mak = byteBuffer;
                if (v.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    if (this.mbi == null || this.mbi.length < remaining) {
                        this.mbi = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.mbi, 0, remaining);
                    byteBuffer.position(position);
                    this.mbj = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (v.SDK_INT < 21) {
                int dsV = this.bufferSize - ((int) (this.maY - (this.maw.dsV() * this.maX)));
                if (dsV > 0) {
                    a2 = this.maB.write(this.mbi, this.mbj, Math.min(remaining2, dsV));
                    if (a2 > 0) {
                        this.mbj += a2;
                        byteBuffer.position(byteBuffer.position() + a2);
                    }
                } else {
                    a2 = 0;
                }
            } else if (this.mbn) {
                com.google.android.exoplayer2.util.a.checkState(j != -9223372036854775807L);
                a2 = a(this.maB, byteBuffer, remaining2, j);
            } else {
                a2 = a(this.maB, byteBuffer, remaining2);
            }
            this.mbo = SystemClock.elapsedRealtime();
            if (a2 < 0) {
                throw new AudioSink.WriteException(a2);
            }
            if (!this.maG) {
                this.maY += a2;
            }
            if (a2 == remaining2) {
                if (this.maG) {
                    this.maZ += this.mba;
                }
                this.mak = null;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dsE() throws AudioSink.WriteException {
        if (!this.mbl && isInitialized() && dsJ()) {
            this.maw.fJ(dsP());
            this.maM = 0;
            this.mbl = true;
        }
    }

    private boolean dsJ() throws AudioSink.WriteException {
        boolean z;
        if (this.mbk == -1) {
            this.mbk = this.maG ? this.mbf.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.mbk < this.mbf.length) {
            AudioProcessor audioProcessor = this.mbf[this.mbk];
            if (z) {
                audioProcessor.dsB();
            }
            fE(-9223372036854775807L);
            if (!audioProcessor.atB()) {
                return false;
            }
            this.mbk++;
            z = true;
        }
        if (this.mak != null) {
            b(this.mak, -9223372036854775807L);
            if (this.mak != null) {
                return false;
            }
        }
        this.mbk = -1;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean atB() {
        return !isInitialized() || (this.mbl && !dsF());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean dsF() {
        return isInitialized() && (dsP() > this.maw.dsV() || dsS());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q d(q qVar) {
        q qVar2;
        if (this.maG) {
            this.lXV = q.lYW;
            return this.lXV;
        }
        q qVar3 = new q(this.mas.bx(qVar.speed), this.mas.by(qVar.pitch));
        if (this.maI != null) {
            qVar2 = this.maI;
        } else {
            qVar2 = !this.may.isEmpty() ? this.may.getLast().lXV : this.lXV;
        }
        if (!qVar3.equals(qVar2)) {
            if (isInitialized()) {
                this.maI = qVar3;
            } else {
                this.lXV = qVar3;
            }
        }
        return this.lXV;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q drF() {
        return this.lXV;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(com.google.android.exoplayer2.audio.b bVar) {
        if (!this.lZp.equals(bVar)) {
            this.lZp = bVar;
            if (!this.mbn) {
                reset();
                this.lZo = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Ja(int i) {
        com.google.android.exoplayer2.util.a.checkState(v.SDK_INT >= 21);
        if (!this.mbn || this.lZo != i) {
            this.mbn = true;
            this.lZo = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dsG() {
        if (this.mbn) {
            this.mbn = false;
            this.lZo = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            dsK();
        }
    }

    private void dsK() {
        if (isInitialized()) {
            if (v.SDK_INT >= 21) {
                a(this.maB, this.volume);
            } else {
                b(this.maB, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.mbm = false;
        if (isInitialized()) {
            dsQ();
            this.maw.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$1] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.maV = 0L;
            this.maW = 0L;
            this.maY = 0L;
            this.maZ = 0L;
            this.mba = 0;
            if (this.maI != null) {
                this.lXV = this.maI;
                this.maI = null;
            } else if (!this.may.isEmpty()) {
                this.lXV = this.may.getLast().lXV;
            }
            this.may.clear();
            this.maJ = 0L;
            this.maK = 0L;
            this.mbh = null;
            this.mak = null;
            for (int i = 0; i < this.mbf.length; i++) {
                AudioProcessor audioProcessor = this.mbf[i];
                audioProcessor.flush();
                this.mbg[i] = audioProcessor.dsC();
            }
            this.mbl = false;
            this.mbk = -1;
            this.maL = null;
            this.maM = 0;
            this.mbb = 0;
            this.mbe = 0L;
            dsQ();
            if (this.maB.getPlayState() == 3) {
                this.maB.pause();
            }
            final AudioTrack audioTrack = this.maB;
            this.maB = null;
            this.maw.a(null, false);
            this.mau.close();
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.mau.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        dsL();
        for (AudioProcessor audioProcessor : this.mat) {
            audioProcessor.reset();
        }
        this.lZo = 0;
        this.mbm = false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$2] */
    private void dsL() {
        if (this.maA != null) {
            final AudioTrack audioTrack = this.maA;
            this.maA = null;
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean dsM() {
        return isInitialized() && this.mbb != 0;
    }

    private long fF(long j) {
        while (!this.may.isEmpty() && j >= this.may.getFirst().lYU) {
            c remove = this.may.remove();
            this.lXV = remove.lXV;
            this.maK = remove.lYU;
            this.maJ = remove.mbD - this.mbc;
        }
        if (this.lXV.speed == 1.0f) {
            return (this.maJ + j) - this.maK;
        }
        if (this.may.isEmpty()) {
            return this.maJ + this.mas.fL(j - this.maK);
        }
        return this.maJ + ((long) (this.lXV.speed * (j - this.maK)));
    }

    private void dsN() {
        long dsW = this.maw.dsW();
        if (dsW != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.maQ >= 30000) {
                this.mav[this.maN] = dsW - nanoTime;
                this.maN = (this.maN + 1) % 10;
                if (this.maO < 10) {
                    this.maO++;
                }
                this.maQ = nanoTime;
                this.maP = 0L;
                for (int i = 0; i < this.maO; i++) {
                    this.maP += this.mav[i] / this.maO;
                }
            }
            if (!dsR() && nanoTime - this.maS >= 500000) {
                this.maR = this.maw.dsX();
                if (this.maR) {
                    long dsY = this.maw.dsY() / 1000;
                    long dsZ = this.maw.dsZ();
                    if (dsY < this.mbd) {
                        this.maR = false;
                    } else if (Math.abs(dsY - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + dsZ + ", " + dsY + ", " + nanoTime + ", " + dsW + ", " + dsO() + ", " + dsP();
                        if (man) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w("AudioTrack", str);
                        this.maR = false;
                    } else if (Math.abs(fH(dsZ) - dsW) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + dsZ + ", " + dsY + ", " + nanoTime + ", " + dsW + ", " + dsO() + ", " + dsP();
                        if (man) {
                            throw new InvalidAudioTrackTimestampException(str2);
                        }
                        Log.w("AudioTrack", str2);
                        this.maR = false;
                    }
                }
                if (this.maT != null && !this.maG) {
                    try {
                        this.mbe = (((Integer) this.maT.invoke(this.maB, null)).intValue() * 1000) - this.maH;
                        this.mbe = Math.max(this.mbe, 0L);
                        if (this.mbe > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.mbe);
                            this.mbe = 0L;
                        }
                    } catch (Exception e) {
                        this.maT = null;
                    }
                }
                this.maS = nanoTime;
            }
        }
    }

    private boolean isInitialized() {
        return this.maB != null;
    }

    private long fG(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.maC;
    }

    private long fH(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    private long fI(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    private long dsO() {
        return this.maG ? this.maW : this.maV / this.maU;
    }

    private long dsP() {
        return this.maG ? this.maZ : this.maY / this.maX;
    }

    private void dsQ() {
        this.maP = 0L;
        this.maO = 0;
        this.maN = 0;
        this.maQ = 0L;
        this.maR = false;
        this.maS = 0L;
    }

    private boolean dsR() {
        return v.SDK_INT < 23 && (this.maF == 5 || this.maF == 6);
    }

    private boolean dsS() {
        return dsR() && this.maB.getPlayState() == 2 && this.maB.getPlaybackHeadPosition() == 0;
    }

    private AudioTrack dsT() throws AudioSink.InitializationException {
        AudioTrack audioTrack;
        if (v.SDK_INT >= 21) {
            audioTrack = dsU();
        } else {
            int LV = v.LV(this.lZp.lZP);
            if (this.lZo == 0) {
                audioTrack = new AudioTrack(LV, this.sampleRate, this.maD, this.maF, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(LV, this.sampleRate, this.maD, this.maF, this.bufferSize, 1, this.lZo);
            }
        }
        int state = audioTrack.getState();
        if (state != 1) {
            try {
                audioTrack.release();
            } catch (Exception e) {
            }
            throw new AudioSink.InitializationException(state, this.sampleRate, this.maD, this.bufferSize);
        }
        return audioTrack;
    }

    @TargetApi(21)
    private AudioTrack dsU() {
        AudioAttributes dsw;
        if (this.mbn) {
            dsw = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            dsw = this.lZp.dsw();
        }
        return new AudioTrack(dsw, new AudioFormat.Builder().setChannelMask(this.maD).setEncoding(this.maF).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.lZo != 0 ? this.lZo : 0);
    }

    private AudioTrack Jb(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private static int Pa(String str) {
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
            return com.google.android.exoplayer2.audio.a.dsv();
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
        if (this.maL == null) {
            this.maL = ByteBuffer.allocate(16);
            this.maL.order(ByteOrder.BIG_ENDIAN);
            this.maL.putInt(1431633921);
        }
        if (this.maM == 0) {
            this.maL.putInt(4, i);
            this.maL.putLong(8, 1000 * j);
            this.maL.position(0);
            this.maM = i;
        }
        int remaining = this.maL.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.maL, remaining, 1);
            if (write < 0) {
                this.maM = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i);
        if (a2 < 0) {
            this.maM = 0;
            return a2;
        }
        this.maM -= a2;
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
    /* loaded from: classes5.dex */
    public static class a {
        protected AudioTrack maB;
        private boolean mbr;
        private long mbs;
        private long mbt;
        private long mbu;
        private long mbv;
        private long mbw;
        private long mbx;
        private long mby;
        private int sampleRate;

        private a() {
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.maB = audioTrack;
            this.mbr = z;
            this.mbv = -9223372036854775807L;
            this.mbw = -9223372036854775807L;
            this.mbs = 0L;
            this.mbt = 0L;
            this.mbu = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }

        public void fJ(long j) {
            this.mbx = dsV();
            this.mbv = SystemClock.elapsedRealtime() * 1000;
            this.mby = j;
            this.maB.stop();
        }

        public void pause() {
            if (this.mbv == -9223372036854775807L) {
                this.maB.pause();
            }
        }

        public boolean fK(long j) {
            return this.mbw != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.mbw >= 200;
        }

        public long dsV() {
            if (this.mbv != -9223372036854775807L) {
                return Math.min(this.mby, ((((SystemClock.elapsedRealtime() * 1000) - this.mbv) * this.sampleRate) / TimeUtils.NANOS_PER_MS) + this.mbx);
            }
            int playState = this.maB.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.maB.getPlaybackHeadPosition();
            if (this.mbr) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.mbu = this.mbs;
                }
                playbackHeadPosition += this.mbu;
            }
            if (v.SDK_INT <= 26) {
                if (playbackHeadPosition == 0 && this.mbs > 0 && playState == 3) {
                    if (this.mbw == -9223372036854775807L) {
                        this.mbw = SystemClock.elapsedRealtime();
                    }
                    return this.mbs;
                }
                this.mbw = -9223372036854775807L;
            }
            if (this.mbs > playbackHeadPosition) {
                this.mbt++;
            }
            this.mbs = playbackHeadPosition;
            return playbackHeadPosition + (this.mbt << 32);
        }

        public long dsW() {
            return (dsV() * TimeUtils.NANOS_PER_MS) / this.sampleRate;
        }

        public boolean dsX() {
            return false;
        }

        public long dsY() {
            throw new UnsupportedOperationException();
        }

        public long dsZ() {
            throw new UnsupportedOperationException();
        }
    }

    @TargetApi(19)
    /* loaded from: classes5.dex */
    private static class b extends a {
        private long mbA;
        private long mbB;
        private long mbC;
        private final AudioTimestamp mbz;

        public b() {
            super();
            this.mbz = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.mbA = 0L;
            this.mbB = 0L;
            this.mbC = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public boolean dsX() {
            boolean timestamp = this.maB.getTimestamp(this.mbz);
            if (timestamp) {
                long j = this.mbz.framePosition;
                if (this.mbB > j) {
                    this.mbA++;
                }
                this.mbB = j;
                this.mbC = j + (this.mbA << 32);
            }
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long dsY() {
            return this.mbz.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long dsZ() {
            return this.mbC;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c {
        private final q lXV;
        private final long lYU;
        private final long mbD;

        private c(q qVar, long j, long j2) {
            this.lXV = qVar;
            this.mbD = j;
            this.lYU = j2;
        }
    }
}
