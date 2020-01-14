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
    public static boolean mas = false;
    public static boolean mat = false;
    private int bufferSize;
    private boolean gbO;
    private q lYa;
    private int lZt;
    private com.google.android.exoplayer2.audio.b lZu;
    private final ConditionVariable maA = new ConditionVariable(true);
    private final long[] maB;
    private final a maC;
    private final LinkedList<c> maD;
    @Nullable
    private AudioSink.a maE;
    private AudioTrack maF;
    private AudioTrack maG;
    private int maH;
    private int maI;
    private int maJ;
    private int maK;
    private boolean maL;
    private long maM;
    private q maN;
    private long maO;
    private long maP;
    private ByteBuffer maQ;
    private int maR;
    private int maS;
    private int maT;
    private long maU;
    private long maV;
    private boolean maW;
    private long maX;
    private Method maY;
    private int maZ;
    private ByteBuffer maq;
    @Nullable
    private final com.google.android.exoplayer2.audio.c mau;
    private final e mav;
    private final k maw;
    private final j may;
    private final AudioProcessor[] maz;
    private long mba;
    private long mbb;
    private int mbc;
    private long mbd;
    private long mbe;
    private int mbf;
    private int mbg;
    private long mbh;
    private long mbi;
    private long mbj;
    private AudioProcessor[] mbk;
    private ByteBuffer[] mbl;
    private ByteBuffer mbm;
    private byte[] mbn;
    private int mbo;
    private int mbp;
    private boolean mbq;
    private boolean mbr;
    private boolean mbs;
    private long mbt;
    private int sampleRate;
    private float volume;

    /* loaded from: classes5.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public DefaultAudioSink(@Nullable com.google.android.exoplayer2.audio.c cVar, AudioProcessor[] audioProcessorArr) {
        this.mau = cVar;
        if (v.SDK_INT >= 18) {
            try {
                this.maY = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (v.SDK_INT >= 19) {
            this.maC = new b();
        } else {
            this.maC = new a();
        }
        this.mav = new e();
        this.maw = new k();
        this.may = new j();
        this.maz = new AudioProcessor[audioProcessorArr.length + 4];
        this.maz[0] = new h();
        this.maz[1] = this.mav;
        this.maz[2] = this.maw;
        System.arraycopy(audioProcessorArr, 0, this.maz, 3, audioProcessorArr.length);
        this.maz[audioProcessorArr.length + 3] = this.may;
        this.maB = new long[10];
        this.volume = 1.0f;
        this.mbg = 0;
        this.lZu = com.google.android.exoplayer2.audio.b.lZT;
        this.lZt = 0;
        this.lYa = q.lZb;
        this.mbp = -1;
        this.mbk = new AudioProcessor[0];
        this.mbl = new ByteBuffer[0];
        this.maD = new LinkedList<>();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(AudioSink.a aVar) {
        this.maE = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean OZ(String str) {
        return this.mau != null && this.mau.IY(Pa(str));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long vB(boolean z) {
        long j;
        if (!dsO()) {
            return Long.MIN_VALUE;
        }
        if (this.maG.getPlayState() == 3) {
            dsP();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.maW) {
            j = fH(fI(nanoTime - (this.maC.dta() / 1000)) + this.maC.dtb());
        } else {
            if (this.maT == 0) {
                j = this.maC.dsY();
            } else {
                j = nanoTime + this.maU;
            }
            if (!z) {
                j -= this.mbj;
            }
        }
        long min = Math.min(j, fH(dsR()));
        return fF(min) + this.mbh;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        int Pa;
        boolean z;
        int i7;
        this.maH = i2;
        boolean z2 = !"audio/raw".equals(str);
        if (!z2) {
            this.maZ = v.dX(i3, i);
            this.maw.dG(i5, i6);
            this.mav.o(iArr);
            AudioProcessor[] audioProcessorArr = this.maz;
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
                        i9 = audioProcessor.dsA();
                        i10 = audioProcessor.dsC();
                        i11 = audioProcessor.dsB();
                    }
                    i8++;
                    z = ae;
                } catch (AudioProcessor.UnhandledFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            if (z) {
                dsK();
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
                i7 = com.google.android.exoplayer2.b.lXw;
                break;
            default:
                throw new AudioSink.ConfigurationException("Unsupported channel count: " + i);
        }
        if (v.SDK_INT <= 23 && "foster".equals(v.mHg) && "NVIDIA".equals(v.MANUFACTURER)) {
            switch (i) {
                case 3:
                case 5:
                    i7 = 252;
                    break;
                case 7:
                    i7 = com.google.android.exoplayer2.b.lXw;
                    break;
            }
        }
        int i12 = (v.SDK_INT <= 25 && "fugu".equals(v.mHg) && z2 && i == 1) ? 12 : i7;
        if (z || !isInitialized() || this.maJ != Pa || this.sampleRate != i2 || this.maI != i12) {
            reset();
            this.maJ = Pa;
            this.maL = z2;
            this.sampleRate = i2;
            this.maI = i12;
            this.maK = z2 ? Pa : 2;
            this.mbc = v.dX(2, i);
            if (i4 != 0) {
                this.bufferSize = i4;
            } else if (z2) {
                if (this.maK == 5 || this.maK == 6) {
                    this.bufferSize = 20480;
                } else {
                    this.bufferSize = 49152;
                }
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i12, this.maK);
                com.google.android.exoplayer2.util.a.checkState(minBufferSize != -2);
                int i13 = minBufferSize * 4;
                int fI = ((int) fI(250000L)) * this.mbc;
                int max = (int) Math.max(minBufferSize, fI(750000L) * this.mbc);
                if (i13 >= fI) {
                    fI = i13 > max ? max : i13;
                }
                this.bufferSize = fI;
            }
            this.maM = z2 ? -9223372036854775807L : fH(this.bufferSize / this.mbc);
            d(this.lYa);
        }
    }

    private void dsK() {
        AudioProcessor[] audioProcessorArr;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : this.maz) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.mbk = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.mbl = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            AudioProcessor audioProcessor2 = this.mbk[i];
            audioProcessor2.flush();
            this.mbl[i] = audioProcessor2.dsE();
        }
    }

    private void initialize() throws AudioSink.InitializationException {
        this.maA.block();
        this.maG = dsV();
        int audioSessionId = this.maG.getAudioSessionId();
        if (mas && v.SDK_INT < 21) {
            if (this.maF != null && audioSessionId != this.maF.getAudioSessionId()) {
                dsN();
            }
            if (this.maF == null) {
                this.maF = Jb(audioSessionId);
            }
        }
        if (this.lZt != audioSessionId) {
            this.lZt = audioSessionId;
            if (this.maE != null) {
                this.maE.EP(audioSessionId);
            }
        }
        this.maC.a(this.maG, dsT());
        dsM();
        this.gbO = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.mbr = true;
        if (isInitialized()) {
            this.mbi = System.nanoTime() / 1000;
            this.maG.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dsF() {
        if (this.mbg == 1) {
            this.mbg = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        com.google.android.exoplayer2.util.a.checkArgument(this.mbm == null || byteBuffer == this.mbm);
        if (!isInitialized()) {
            initialize();
            if (this.mbr) {
                play();
            }
        }
        if (dsT()) {
            if (this.maG.getPlayState() == 2) {
                this.gbO = false;
                return false;
            } else if (this.maG.getPlayState() == 1 && this.maC.dsX() != 0) {
                return false;
            }
        }
        boolean z = this.gbO;
        this.gbO = dsH();
        if (z && !this.gbO && this.maG.getPlayState() != 1 && this.maE != null) {
            this.maE.i(this.bufferSize, com.google.android.exoplayer2.b.fp(this.maM), SystemClock.elapsedRealtime() - this.mbt);
        }
        if (this.mbm == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.maL && this.mbf == 0) {
                this.mbf = a(this.maK, byteBuffer);
            }
            if (this.maN != null) {
                if (!dsL()) {
                    return false;
                }
                this.maD.add(new c(this.maN, Math.max(0L, j), fH(dsR())));
                this.maN = null;
                dsK();
            }
            if (this.mbg == 0) {
                this.mbh = Math.max(0L, j);
                this.mbg = 1;
            } else {
                long fG = this.mbh + fG(dsQ());
                if (this.mbg == 1 && Math.abs(fG - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + fG + ", got " + j + "]");
                    this.mbg = 2;
                }
                if (this.mbg == 2) {
                    this.mbh = (j - fG) + this.mbh;
                    this.mbg = 1;
                    if (this.maE != null) {
                        this.maE.dsJ();
                    }
                }
            }
            if (this.maL) {
                this.mbb += this.mbf;
            } else {
                this.mba += byteBuffer.remaining();
            }
            this.mbm = byteBuffer;
        }
        if (this.maL) {
            b(this.mbm, j);
        } else {
            fE(j);
        }
        if (!this.mbm.hasRemaining()) {
            this.mbm = null;
            return true;
        } else if (this.maC.fK(dsR())) {
            Log.w("AudioTrack", "Resetting stalled audio track");
            reset();
            return true;
        } else {
            return false;
        }
    }

    private void fE(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.mbk.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.mbl[i - 1];
            } else {
                byteBuffer = this.mbm != null ? this.mbm : AudioProcessor.EMPTY_BUFFER;
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.mbk[i];
                audioProcessor.i(byteBuffer);
                ByteBuffer dsE = audioProcessor.dsE();
                this.mbl[i] = dsE;
                if (dsE.hasRemaining()) {
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
            if (this.maq != null) {
                com.google.android.exoplayer2.util.a.checkArgument(this.maq == byteBuffer);
            } else {
                this.maq = byteBuffer;
                if (v.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    if (this.mbn == null || this.mbn.length < remaining) {
                        this.mbn = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.mbn, 0, remaining);
                    byteBuffer.position(position);
                    this.mbo = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (v.SDK_INT < 21) {
                int dsX = this.bufferSize - ((int) (this.mbd - (this.maC.dsX() * this.mbc)));
                if (dsX > 0) {
                    a2 = this.maG.write(this.mbn, this.mbo, Math.min(remaining2, dsX));
                    if (a2 > 0) {
                        this.mbo += a2;
                        byteBuffer.position(byteBuffer.position() + a2);
                    }
                } else {
                    a2 = 0;
                }
            } else if (this.mbs) {
                com.google.android.exoplayer2.util.a.checkState(j != -9223372036854775807L);
                a2 = a(this.maG, byteBuffer, remaining2, j);
            } else {
                a2 = a(this.maG, byteBuffer, remaining2);
            }
            this.mbt = SystemClock.elapsedRealtime();
            if (a2 < 0) {
                throw new AudioSink.WriteException(a2);
            }
            if (!this.maL) {
                this.mbd += a2;
            }
            if (a2 == remaining2) {
                if (this.maL) {
                    this.mbe += this.mbf;
                }
                this.maq = null;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dsG() throws AudioSink.WriteException {
        if (!this.mbq && isInitialized() && dsL()) {
            this.maC.fJ(dsR());
            this.maR = 0;
            this.mbq = true;
        }
    }

    private boolean dsL() throws AudioSink.WriteException {
        boolean z;
        if (this.mbp == -1) {
            this.mbp = this.maL ? this.mbk.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.mbp < this.mbk.length) {
            AudioProcessor audioProcessor = this.mbk[this.mbp];
            if (z) {
                audioProcessor.dsD();
            }
            fE(-9223372036854775807L);
            if (!audioProcessor.atB()) {
                return false;
            }
            this.mbp++;
            z = true;
        }
        if (this.maq != null) {
            b(this.maq, -9223372036854775807L);
            if (this.maq != null) {
                return false;
            }
        }
        this.mbp = -1;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean atB() {
        return !isInitialized() || (this.mbq && !dsH());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean dsH() {
        return isInitialized() && (dsR() > this.maC.dsX() || dsU());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q d(q qVar) {
        q qVar2;
        if (this.maL) {
            this.lYa = q.lZb;
            return this.lYa;
        }
        q qVar3 = new q(this.may.bx(qVar.speed), this.may.by(qVar.pitch));
        if (this.maN != null) {
            qVar2 = this.maN;
        } else {
            qVar2 = !this.maD.isEmpty() ? this.maD.getLast().lYa : this.lYa;
        }
        if (!qVar3.equals(qVar2)) {
            if (isInitialized()) {
                this.maN = qVar3;
            } else {
                this.lYa = qVar3;
            }
        }
        return this.lYa;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q drH() {
        return this.lYa;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(com.google.android.exoplayer2.audio.b bVar) {
        if (!this.lZu.equals(bVar)) {
            this.lZu = bVar;
            if (!this.mbs) {
                reset();
                this.lZt = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Ja(int i) {
        com.google.android.exoplayer2.util.a.checkState(v.SDK_INT >= 21);
        if (!this.mbs || this.lZt != i) {
            this.mbs = true;
            this.lZt = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dsI() {
        if (this.mbs) {
            this.mbs = false;
            this.lZt = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            dsM();
        }
    }

    private void dsM() {
        if (isInitialized()) {
            if (v.SDK_INT >= 21) {
                a(this.maG, this.volume);
            } else {
                b(this.maG, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.mbr = false;
        if (isInitialized()) {
            dsS();
            this.maC.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$1] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.mba = 0L;
            this.mbb = 0L;
            this.mbd = 0L;
            this.mbe = 0L;
            this.mbf = 0;
            if (this.maN != null) {
                this.lYa = this.maN;
                this.maN = null;
            } else if (!this.maD.isEmpty()) {
                this.lYa = this.maD.getLast().lYa;
            }
            this.maD.clear();
            this.maO = 0L;
            this.maP = 0L;
            this.mbm = null;
            this.maq = null;
            for (int i = 0; i < this.mbk.length; i++) {
                AudioProcessor audioProcessor = this.mbk[i];
                audioProcessor.flush();
                this.mbl[i] = audioProcessor.dsE();
            }
            this.mbq = false;
            this.mbp = -1;
            this.maQ = null;
            this.maR = 0;
            this.mbg = 0;
            this.mbj = 0L;
            dsS();
            if (this.maG.getPlayState() == 3) {
                this.maG.pause();
            }
            final AudioTrack audioTrack = this.maG;
            this.maG = null;
            this.maC.a(null, false);
            this.maA.close();
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.maA.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        dsN();
        for (AudioProcessor audioProcessor : this.maz) {
            audioProcessor.reset();
        }
        this.lZt = 0;
        this.mbr = false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$2] */
    private void dsN() {
        if (this.maF != null) {
            final AudioTrack audioTrack = this.maF;
            this.maF = null;
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean dsO() {
        return isInitialized() && this.mbg != 0;
    }

    private long fF(long j) {
        while (!this.maD.isEmpty() && j >= this.maD.getFirst().lYZ) {
            c remove = this.maD.remove();
            this.lYa = remove.lYa;
            this.maP = remove.lYZ;
            this.maO = remove.mbI - this.mbh;
        }
        if (this.lYa.speed == 1.0f) {
            return (this.maO + j) - this.maP;
        }
        if (this.maD.isEmpty()) {
            return this.maO + this.may.fL(j - this.maP);
        }
        return this.maO + ((long) (this.lYa.speed * (j - this.maP)));
    }

    private void dsP() {
        long dsY = this.maC.dsY();
        if (dsY != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.maV >= 30000) {
                this.maB[this.maS] = dsY - nanoTime;
                this.maS = (this.maS + 1) % 10;
                if (this.maT < 10) {
                    this.maT++;
                }
                this.maV = nanoTime;
                this.maU = 0L;
                for (int i = 0; i < this.maT; i++) {
                    this.maU += this.maB[i] / this.maT;
                }
            }
            if (!dsT() && nanoTime - this.maX >= 500000) {
                this.maW = this.maC.dsZ();
                if (this.maW) {
                    long dta = this.maC.dta() / 1000;
                    long dtb = this.maC.dtb();
                    if (dta < this.mbi) {
                        this.maW = false;
                    } else if (Math.abs(dta - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + dtb + ", " + dta + ", " + nanoTime + ", " + dsY + ", " + dsQ() + ", " + dsR();
                        if (mat) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w("AudioTrack", str);
                        this.maW = false;
                    } else if (Math.abs(fH(dtb) - dsY) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + dtb + ", " + dta + ", " + nanoTime + ", " + dsY + ", " + dsQ() + ", " + dsR();
                        if (mat) {
                            throw new InvalidAudioTrackTimestampException(str2);
                        }
                        Log.w("AudioTrack", str2);
                        this.maW = false;
                    }
                }
                if (this.maY != null && !this.maL) {
                    try {
                        this.mbj = (((Integer) this.maY.invoke(this.maG, null)).intValue() * 1000) - this.maM;
                        this.mbj = Math.max(this.mbj, 0L);
                        if (this.mbj > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.mbj);
                            this.mbj = 0L;
                        }
                    } catch (Exception e) {
                        this.maY = null;
                    }
                }
                this.maX = nanoTime;
            }
        }
    }

    private boolean isInitialized() {
        return this.maG != null;
    }

    private long fG(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.maH;
    }

    private long fH(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    private long fI(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    private long dsQ() {
        return this.maL ? this.mbb : this.mba / this.maZ;
    }

    private long dsR() {
        return this.maL ? this.mbe : this.mbd / this.mbc;
    }

    private void dsS() {
        this.maU = 0L;
        this.maT = 0;
        this.maS = 0;
        this.maV = 0L;
        this.maW = false;
        this.maX = 0L;
    }

    private boolean dsT() {
        return v.SDK_INT < 23 && (this.maK == 5 || this.maK == 6);
    }

    private boolean dsU() {
        return dsT() && this.maG.getPlayState() == 2 && this.maG.getPlaybackHeadPosition() == 0;
    }

    private AudioTrack dsV() throws AudioSink.InitializationException {
        AudioTrack audioTrack;
        if (v.SDK_INT >= 21) {
            audioTrack = dsW();
        } else {
            int LV = v.LV(this.lZu.lZU);
            if (this.lZt == 0) {
                audioTrack = new AudioTrack(LV, this.sampleRate, this.maI, this.maK, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(LV, this.sampleRate, this.maI, this.maK, this.bufferSize, 1, this.lZt);
            }
        }
        int state = audioTrack.getState();
        if (state != 1) {
            try {
                audioTrack.release();
            } catch (Exception e) {
            }
            throw new AudioSink.InitializationException(state, this.sampleRate, this.maI, this.bufferSize);
        }
        return audioTrack;
    }

    @TargetApi(21)
    private AudioTrack dsW() {
        AudioAttributes dsy;
        if (this.mbs) {
            dsy = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            dsy = this.lZu.dsy();
        }
        return new AudioTrack(dsy, new AudioFormat.Builder().setChannelMask(this.maI).setEncoding(this.maK).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.lZt != 0 ? this.lZt : 0);
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
            return com.google.android.exoplayer2.audio.a.dsx();
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
        if (this.maQ == null) {
            this.maQ = ByteBuffer.allocate(16);
            this.maQ.order(ByteOrder.BIG_ENDIAN);
            this.maQ.putInt(1431633921);
        }
        if (this.maR == 0) {
            this.maQ.putInt(4, i);
            this.maQ.putLong(8, 1000 * j);
            this.maQ.position(0);
            this.maR = i;
        }
        int remaining = this.maQ.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.maQ, remaining, 1);
            if (write < 0) {
                this.maR = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i);
        if (a2 < 0) {
            this.maR = 0;
            return a2;
        }
        this.maR -= a2;
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
        protected AudioTrack maG;
        private long mbA;
        private long mbB;
        private long mbC;
        private long mbD;
        private boolean mbw;
        private long mbx;
        private long mby;
        private long mbz;
        private int sampleRate;

        private a() {
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.maG = audioTrack;
            this.mbw = z;
            this.mbA = -9223372036854775807L;
            this.mbB = -9223372036854775807L;
            this.mbx = 0L;
            this.mby = 0L;
            this.mbz = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }

        public void fJ(long j) {
            this.mbC = dsX();
            this.mbA = SystemClock.elapsedRealtime() * 1000;
            this.mbD = j;
            this.maG.stop();
        }

        public void pause() {
            if (this.mbA == -9223372036854775807L) {
                this.maG.pause();
            }
        }

        public boolean fK(long j) {
            return this.mbB != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.mbB >= 200;
        }

        public long dsX() {
            if (this.mbA != -9223372036854775807L) {
                return Math.min(this.mbD, ((((SystemClock.elapsedRealtime() * 1000) - this.mbA) * this.sampleRate) / TimeUtils.NANOS_PER_MS) + this.mbC);
            }
            int playState = this.maG.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.maG.getPlaybackHeadPosition();
            if (this.mbw) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.mbz = this.mbx;
                }
                playbackHeadPosition += this.mbz;
            }
            if (v.SDK_INT <= 26) {
                if (playbackHeadPosition == 0 && this.mbx > 0 && playState == 3) {
                    if (this.mbB == -9223372036854775807L) {
                        this.mbB = SystemClock.elapsedRealtime();
                    }
                    return this.mbx;
                }
                this.mbB = -9223372036854775807L;
            }
            if (this.mbx > playbackHeadPosition) {
                this.mby++;
            }
            this.mbx = playbackHeadPosition;
            return playbackHeadPosition + (this.mby << 32);
        }

        public long dsY() {
            return (dsX() * TimeUtils.NANOS_PER_MS) / this.sampleRate;
        }

        public boolean dsZ() {
            return false;
        }

        public long dta() {
            throw new UnsupportedOperationException();
        }

        public long dtb() {
            throw new UnsupportedOperationException();
        }
    }

    @TargetApi(19)
    /* loaded from: classes5.dex */
    private static class b extends a {
        private final AudioTimestamp mbE;
        private long mbF;
        private long mbG;
        private long mbH;

        public b() {
            super();
            this.mbE = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.mbF = 0L;
            this.mbG = 0L;
            this.mbH = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public boolean dsZ() {
            boolean timestamp = this.maG.getTimestamp(this.mbE);
            if (timestamp) {
                long j = this.mbE.framePosition;
                if (this.mbG > j) {
                    this.mbF++;
                }
                this.mbG = j;
                this.mbH = j + (this.mbF << 32);
            }
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long dta() {
            return this.mbE.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long dtb() {
            return this.mbH;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c {
        private final long lYZ;
        private final q lYa;
        private final long mbI;

        private c(q qVar, long j, long j2) {
            this.lYa = qVar;
            this.mbI = j;
            this.lYZ = j2;
        }
    }
}
