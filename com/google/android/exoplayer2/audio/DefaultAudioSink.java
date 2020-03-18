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
    public static boolean mcS = false;
    public static boolean mcT = false;
    private int bufferSize;
    private boolean geN;
    private q maC;
    private int mbV;
    private com.google.android.exoplayer2.audio.b mbW;
    private ByteBuffer mcQ;
    @Nullable
    private final com.google.android.exoplayer2.audio.c mcU;
    private final e mcV;
    private final k mcW;
    private final j mcX;
    private final AudioProcessor[] mcY;
    private final ConditionVariable mcZ = new ConditionVariable(true);
    private long mdA;
    private int mdB;
    private long mdC;
    private long mdD;
    private int mdE;
    private int mdF;
    private long mdG;
    private long mdH;
    private long mdI;
    private AudioProcessor[] mdJ;
    private ByteBuffer[] mdK;
    private ByteBuffer mdL;
    private byte[] mdM;
    private int mdN;
    private int mdO;
    private boolean mdP;
    private boolean mdQ;
    private boolean mdR;
    private long mdS;
    private final long[] mda;
    private final a mdb;
    private final LinkedList<c> mdc;
    @Nullable
    private AudioSink.a mdd;
    private AudioTrack mde;
    private AudioTrack mdf;
    private int mdg;
    private int mdh;
    private int mdi;
    private int mdj;
    private boolean mdk;
    private long mdl;
    private q mdm;
    private long mdn;
    private long mdo;
    private ByteBuffer mdp;
    private int mdq;
    private int mdr;
    private int mds;
    private long mdt;
    private long mdu;
    private boolean mdv;
    private long mdw;
    private Method mdx;
    private int mdy;
    private long mdz;
    private int sampleRate;
    private float volume;

    /* loaded from: classes6.dex */
    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public DefaultAudioSink(@Nullable com.google.android.exoplayer2.audio.c cVar, AudioProcessor[] audioProcessorArr) {
        this.mcU = cVar;
        if (v.SDK_INT >= 18) {
            try {
                this.mdx = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (v.SDK_INT >= 19) {
            this.mdb = new b();
        } else {
            this.mdb = new a();
        }
        this.mcV = new e();
        this.mcW = new k();
        this.mcX = new j();
        this.mcY = new AudioProcessor[audioProcessorArr.length + 4];
        this.mcY[0] = new h();
        this.mcY[1] = this.mcV;
        this.mcY[2] = this.mcW;
        System.arraycopy(audioProcessorArr, 0, this.mcY, 3, audioProcessorArr.length);
        this.mcY[audioProcessorArr.length + 3] = this.mcX;
        this.mda = new long[10];
        this.volume = 1.0f;
        this.mdF = 0;
        this.mbW = com.google.android.exoplayer2.audio.b.mcv;
        this.mbV = 0;
        this.maC = q.mbD;
        this.mdO = -1;
        this.mdJ = new AudioProcessor[0];
        this.mdK = new ByteBuffer[0];
        this.mdc = new LinkedList<>();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(AudioSink.a aVar) {
        this.mdd = aVar;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean Pm(String str) {
        return this.mcU != null && this.mcU.Jj(Pn(str));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long vM(boolean z) {
        long j;
        if (!duz()) {
            return Long.MIN_VALUE;
        }
        if (this.mdf.getPlayState() == 3) {
            duA();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.mdv) {
            j = fG(fH(nanoTime - (this.mdb.duL() / 1000)) + this.mdb.duM());
        } else {
            if (this.mds == 0) {
                j = this.mdb.duJ();
            } else {
                j = nanoTime + this.mdt;
            }
            if (!z) {
                j -= this.mdI;
            }
        }
        long min = Math.min(j, fG(duC()));
        return fE(min) + this.mdG;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(String str, int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        int Pn;
        boolean z;
        int i7;
        this.mdg = i2;
        boolean z2 = !"audio/raw".equals(str);
        if (!z2) {
            this.mdy = v.eb(i3, i);
            this.mcW.dK(i5, i6);
            this.mcV.n(iArr);
            AudioProcessor[] audioProcessorArr = this.mcY;
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
                        i9 = audioProcessor.dul();
                        i10 = audioProcessor.dun();
                        i11 = audioProcessor.dum();
                    }
                    i8++;
                    z = af;
                } catch (AudioProcessor.UnhandledFormatException e) {
                    throw new AudioSink.ConfigurationException(e);
                }
            }
            if (z) {
                duv();
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
                i7 = com.google.android.exoplayer2.b.lZV;
                break;
            default:
                throw new AudioSink.ConfigurationException("Unsupported channel count: " + i);
        }
        if (v.SDK_INT <= 23 && "foster".equals(v.mJI) && "NVIDIA".equals(v.MANUFACTURER)) {
            switch (i) {
                case 3:
                case 5:
                    i7 = 252;
                    break;
                case 7:
                    i7 = com.google.android.exoplayer2.b.lZV;
                    break;
            }
        }
        int i12 = (v.SDK_INT <= 25 && "fugu".equals(v.mJI) && z2 && i == 1) ? 12 : i7;
        if (z || !isInitialized() || this.mdi != Pn || this.sampleRate != i2 || this.mdh != i12) {
            reset();
            this.mdi = Pn;
            this.mdk = z2;
            this.sampleRate = i2;
            this.mdh = i12;
            this.mdj = z2 ? Pn : 2;
            this.mdB = v.eb(2, i);
            if (i4 != 0) {
                this.bufferSize = i4;
            } else if (z2) {
                if (this.mdj == 5 || this.mdj == 6) {
                    this.bufferSize = 20480;
                } else {
                    this.bufferSize = 49152;
                }
            } else {
                int minBufferSize = AudioTrack.getMinBufferSize(i2, i12, this.mdj);
                com.google.android.exoplayer2.util.a.checkState(minBufferSize != -2);
                int i13 = minBufferSize * 4;
                int fH = ((int) fH(250000L)) * this.mdB;
                int max = (int) Math.max(minBufferSize, fH(750000L) * this.mdB);
                if (i13 >= fH) {
                    fH = i13 > max ? max : i13;
                }
                this.bufferSize = fH;
            }
            this.mdl = z2 ? -9223372036854775807L : fG(this.bufferSize / this.mdB);
            d(this.maC);
        }
    }

    private void duv() {
        AudioProcessor[] audioProcessorArr;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : this.mcY) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.mdJ = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.mdK = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            AudioProcessor audioProcessor2 = this.mdJ[i];
            audioProcessor2.flush();
            this.mdK[i] = audioProcessor2.dup();
        }
    }

    private void initialize() throws AudioSink.InitializationException {
        this.mcZ.block();
        this.mdf = duG();
        int audioSessionId = this.mdf.getAudioSessionId();
        if (mcS && v.SDK_INT < 21) {
            if (this.mde != null && audioSessionId != this.mde.getAudioSessionId()) {
                duy();
            }
            if (this.mde == null) {
                this.mde = Jm(audioSessionId);
            }
        }
        if (this.mbV != audioSessionId) {
            this.mbV = audioSessionId;
            if (this.mdd != null) {
                this.mdd.Fb(audioSessionId);
            }
        }
        this.mdb.a(this.mdf, duE());
        dux();
        this.geN = false;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.mdQ = true;
        if (isInitialized()) {
            this.mdH = System.nanoTime() / 1000;
            this.mdf.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void duq() {
        if (this.mdF == 1) {
            this.mdF = 2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        com.google.android.exoplayer2.util.a.checkArgument(this.mdL == null || byteBuffer == this.mdL);
        if (!isInitialized()) {
            initialize();
            if (this.mdQ) {
                play();
            }
        }
        if (duE()) {
            if (this.mdf.getPlayState() == 2) {
                this.geN = false;
                return false;
            } else if (this.mdf.getPlayState() == 1 && this.mdb.duI() != 0) {
                return false;
            }
        }
        boolean z = this.geN;
        this.geN = dus();
        if (z && !this.geN && this.mdf.getPlayState() != 1 && this.mdd != null) {
            this.mdd.i(this.bufferSize, com.google.android.exoplayer2.b.fo(this.mdl), SystemClock.elapsedRealtime() - this.mdS);
        }
        if (this.mdL == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.mdk && this.mdE == 0) {
                this.mdE = a(this.mdj, byteBuffer);
            }
            if (this.mdm != null) {
                if (!duw()) {
                    return false;
                }
                this.mdc.add(new c(this.mdm, Math.max(0L, j), fG(duC())));
                this.mdm = null;
                duv();
            }
            if (this.mdF == 0) {
                this.mdG = Math.max(0L, j);
                this.mdF = 1;
            } else {
                long fF = this.mdG + fF(duB());
                if (this.mdF == 1 && Math.abs(fF - j) > 200000) {
                    Log.e("AudioTrack", "Discontinuity detected [expected " + fF + ", got " + j + "]");
                    this.mdF = 2;
                }
                if (this.mdF == 2) {
                    this.mdG = (j - fF) + this.mdG;
                    this.mdF = 1;
                    if (this.mdd != null) {
                        this.mdd.duu();
                    }
                }
            }
            if (this.mdk) {
                this.mdA += this.mdE;
            } else {
                this.mdz += byteBuffer.remaining();
            }
            this.mdL = byteBuffer;
        }
        if (this.mdk) {
            b(this.mdL, j);
        } else {
            fD(j);
        }
        if (!this.mdL.hasRemaining()) {
            this.mdL = null;
            return true;
        } else if (this.mdb.fJ(duC())) {
            Log.w("AudioTrack", "Resetting stalled audio track");
            reset();
            return true;
        } else {
            return false;
        }
    }

    private void fD(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.mdJ.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.mdK[i - 1];
            } else {
                byteBuffer = this.mdL != null ? this.mdL : AudioProcessor.EMPTY_BUFFER;
            }
            if (i == length) {
                b(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.mdJ[i];
                audioProcessor.i(byteBuffer);
                ByteBuffer dup = audioProcessor.dup();
                this.mdK[i] = dup;
                if (dup.hasRemaining()) {
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
            if (this.mcQ != null) {
                com.google.android.exoplayer2.util.a.checkArgument(this.mcQ == byteBuffer);
            } else {
                this.mcQ = byteBuffer;
                if (v.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    if (this.mdM == null || this.mdM.length < remaining) {
                        this.mdM = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.mdM, 0, remaining);
                    byteBuffer.position(position);
                    this.mdN = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (v.SDK_INT < 21) {
                int duI = this.bufferSize - ((int) (this.mdC - (this.mdb.duI() * this.mdB)));
                if (duI > 0) {
                    a2 = this.mdf.write(this.mdM, this.mdN, Math.min(remaining2, duI));
                    if (a2 > 0) {
                        this.mdN += a2;
                        byteBuffer.position(byteBuffer.position() + a2);
                    }
                } else {
                    a2 = 0;
                }
            } else if (this.mdR) {
                com.google.android.exoplayer2.util.a.checkState(j != -9223372036854775807L);
                a2 = a(this.mdf, byteBuffer, remaining2, j);
            } else {
                a2 = a(this.mdf, byteBuffer, remaining2);
            }
            this.mdS = SystemClock.elapsedRealtime();
            if (a2 < 0) {
                throw new AudioSink.WriteException(a2);
            }
            if (!this.mdk) {
                this.mdC += a2;
            }
            if (a2 == remaining2) {
                if (this.mdk) {
                    this.mdD += this.mdE;
                }
                this.mcQ = null;
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dur() throws AudioSink.WriteException {
        if (!this.mdP && isInitialized() && duw()) {
            this.mdb.fI(duC());
            this.mdq = 0;
            this.mdP = true;
        }
    }

    private boolean duw() throws AudioSink.WriteException {
        boolean z;
        if (this.mdO == -1) {
            this.mdO = this.mdk ? this.mdJ.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.mdO < this.mdJ.length) {
            AudioProcessor audioProcessor = this.mdJ[this.mdO];
            if (z) {
                audioProcessor.duo();
            }
            fD(-9223372036854775807L);
            if (!audioProcessor.avU()) {
                return false;
            }
            this.mdO++;
            z = true;
        }
        if (this.mcQ != null) {
            b(this.mcQ, -9223372036854775807L);
            if (this.mcQ != null) {
                return false;
            }
        }
        this.mdO = -1;
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean avU() {
        return !isInitialized() || (this.mdP && !dus());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean dus() {
        return isInitialized() && (duC() > this.mdb.duI() || duF());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q d(q qVar) {
        q qVar2;
        if (this.mdk) {
            this.maC = q.mbD;
            return this.maC;
        }
        q qVar3 = new q(this.mcX.bw(qVar.speed), this.mcX.bx(qVar.pitch));
        if (this.mdm != null) {
            qVar2 = this.mdm;
        } else {
            qVar2 = !this.mdc.isEmpty() ? this.mdc.getLast().maC : this.maC;
        }
        if (!qVar3.equals(qVar2)) {
            if (isInitialized()) {
                this.mdm = qVar3;
            } else {
                this.maC = qVar3;
            }
        }
        return this.maC;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public q dtt() {
        return this.maC;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void a(com.google.android.exoplayer2.audio.b bVar) {
        if (!this.mbW.equals(bVar)) {
            this.mbW = bVar;
            if (!this.mdR) {
                reset();
                this.mbV = 0;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void Jl(int i) {
        com.google.android.exoplayer2.util.a.checkState(v.SDK_INT >= 21);
        if (!this.mdR || this.mbV != i) {
            this.mdR = true;
            this.mbV = i;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void dut() {
        if (this.mdR) {
            this.mdR = false;
            this.mbV = 0;
            reset();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            dux();
        }
    }

    private void dux() {
        if (isInitialized()) {
            if (v.SDK_INT >= 21) {
                a(this.mdf, this.volume);
            } else {
                b(this.mdf, this.volume);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.mdQ = false;
        if (isInitialized()) {
            duD();
            this.mdb.pause();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$1] */
    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.mdz = 0L;
            this.mdA = 0L;
            this.mdC = 0L;
            this.mdD = 0L;
            this.mdE = 0;
            if (this.mdm != null) {
                this.maC = this.mdm;
                this.mdm = null;
            } else if (!this.mdc.isEmpty()) {
                this.maC = this.mdc.getLast().maC;
            }
            this.mdc.clear();
            this.mdn = 0L;
            this.mdo = 0L;
            this.mdL = null;
            this.mcQ = null;
            for (int i = 0; i < this.mdJ.length; i++) {
                AudioProcessor audioProcessor = this.mdJ[i];
                audioProcessor.flush();
                this.mdK[i] = audioProcessor.dup();
            }
            this.mdP = false;
            this.mdO = -1;
            this.mdp = null;
            this.mdq = 0;
            this.mdF = 0;
            this.mdI = 0L;
            duD();
            if (this.mdf.getPlayState() == 3) {
                this.mdf.pause();
            }
            final AudioTrack audioTrack = this.mdf;
            this.mdf = null;
            this.mdb.a(null, false);
            this.mcZ.close();
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.mcZ.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        duy();
        for (AudioProcessor audioProcessor : this.mcY) {
            audioProcessor.reset();
        }
        this.mbV = 0;
        this.mdQ = false;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.exoplayer2.audio.DefaultAudioSink$2] */
    private void duy() {
        if (this.mde != null) {
            final AudioTrack audioTrack = this.mde;
            this.mde = null;
            new Thread() { // from class: com.google.android.exoplayer2.audio.DefaultAudioSink.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    private boolean duz() {
        return isInitialized() && this.mdF != 0;
    }

    private long fE(long j) {
        while (!this.mdc.isEmpty() && j >= this.mdc.getFirst().mbB) {
            c remove = this.mdc.remove();
            this.maC = remove.maC;
            this.mdo = remove.mbB;
            this.mdn = remove.meh - this.mdG;
        }
        if (this.maC.speed == 1.0f) {
            return (this.mdn + j) - this.mdo;
        }
        if (this.mdc.isEmpty()) {
            return this.mdn + this.mcX.fK(j - this.mdo);
        }
        return this.mdn + ((long) (this.maC.speed * (j - this.mdo)));
    }

    private void duA() {
        long duJ = this.mdb.duJ();
        if (duJ != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.mdu >= 30000) {
                this.mda[this.mdr] = duJ - nanoTime;
                this.mdr = (this.mdr + 1) % 10;
                if (this.mds < 10) {
                    this.mds++;
                }
                this.mdu = nanoTime;
                this.mdt = 0L;
                for (int i = 0; i < this.mds; i++) {
                    this.mdt += this.mda[i] / this.mds;
                }
            }
            if (!duE() && nanoTime - this.mdw >= 500000) {
                this.mdv = this.mdb.duK();
                if (this.mdv) {
                    long duL = this.mdb.duL() / 1000;
                    long duM = this.mdb.duM();
                    if (duL < this.mdH) {
                        this.mdv = false;
                    } else if (Math.abs(duL - nanoTime) > 5000000) {
                        String str = "Spurious audio timestamp (system clock mismatch): " + duM + ", " + duL + ", " + nanoTime + ", " + duJ + ", " + duB() + ", " + duC();
                        if (mcT) {
                            throw new InvalidAudioTrackTimestampException(str);
                        }
                        Log.w("AudioTrack", str);
                        this.mdv = false;
                    } else if (Math.abs(fG(duM) - duJ) > 5000000) {
                        String str2 = "Spurious audio timestamp (frame position mismatch): " + duM + ", " + duL + ", " + nanoTime + ", " + duJ + ", " + duB() + ", " + duC();
                        if (mcT) {
                            throw new InvalidAudioTrackTimestampException(str2);
                        }
                        Log.w("AudioTrack", str2);
                        this.mdv = false;
                    }
                }
                if (this.mdx != null && !this.mdk) {
                    try {
                        this.mdI = (((Integer) this.mdx.invoke(this.mdf, null)).intValue() * 1000) - this.mdl;
                        this.mdI = Math.max(this.mdI, 0L);
                        if (this.mdI > 5000000) {
                            Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + this.mdI);
                            this.mdI = 0L;
                        }
                    } catch (Exception e) {
                        this.mdx = null;
                    }
                }
                this.mdw = nanoTime;
            }
        }
    }

    private boolean isInitialized() {
        return this.mdf != null;
    }

    private long fF(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.mdg;
    }

    private long fG(long j) {
        return (TimeUtils.NANOS_PER_MS * j) / this.sampleRate;
    }

    private long fH(long j) {
        return (this.sampleRate * j) / TimeUtils.NANOS_PER_MS;
    }

    private long duB() {
        return this.mdk ? this.mdA : this.mdz / this.mdy;
    }

    private long duC() {
        return this.mdk ? this.mdD : this.mdC / this.mdB;
    }

    private void duD() {
        this.mdt = 0L;
        this.mds = 0;
        this.mdr = 0;
        this.mdu = 0L;
        this.mdv = false;
        this.mdw = 0L;
    }

    private boolean duE() {
        return v.SDK_INT < 23 && (this.mdj == 5 || this.mdj == 6);
    }

    private boolean duF() {
        return duE() && this.mdf.getPlayState() == 2 && this.mdf.getPlaybackHeadPosition() == 0;
    }

    private AudioTrack duG() throws AudioSink.InitializationException {
        AudioTrack audioTrack;
        if (v.SDK_INT >= 21) {
            audioTrack = duH();
        } else {
            int Mg = v.Mg(this.mbW.mcw);
            if (this.mbV == 0) {
                audioTrack = new AudioTrack(Mg, this.sampleRate, this.mdh, this.mdj, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(Mg, this.sampleRate, this.mdh, this.mdj, this.bufferSize, 1, this.mbV);
            }
        }
        int state = audioTrack.getState();
        if (state != 1) {
            try {
                audioTrack.release();
            } catch (Exception e) {
            }
            throw new AudioSink.InitializationException(state, this.sampleRate, this.mdh, this.bufferSize);
        }
        return audioTrack;
    }

    @TargetApi(21)
    private AudioTrack duH() {
        AudioAttributes duj;
        if (this.mdR) {
            duj = new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            duj = this.mbW.duj();
        }
        return new AudioTrack(duj, new AudioFormat.Builder().setChannelMask(this.mdh).setEncoding(this.mdj).setSampleRate(this.sampleRate).build(), this.bufferSize, 1, this.mbV != 0 ? this.mbV : 0);
    }

    private AudioTrack Jm(int i) {
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
            return com.google.android.exoplayer2.audio.a.dui();
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
        if (this.mdp == null) {
            this.mdp = ByteBuffer.allocate(16);
            this.mdp.order(ByteOrder.BIG_ENDIAN);
            this.mdp.putInt(1431633921);
        }
        if (this.mdq == 0) {
            this.mdp.putInt(4, i);
            this.mdp.putLong(8, 1000 * j);
            this.mdp.position(0);
            this.mdq = i;
        }
        int remaining = this.mdp.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.mdp, remaining, 1);
            if (write < 0) {
                this.mdq = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int a2 = a(audioTrack, byteBuffer, i);
        if (a2 < 0) {
            this.mdq = 0;
            return a2;
        }
        this.mdq -= a2;
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
        private boolean mdV;
        private long mdW;
        private long mdX;
        private long mdY;
        private long mdZ;
        protected AudioTrack mdf;
        private long mea;
        private long meb;
        private long mec;
        private int sampleRate;

        private a() {
        }

        public void a(AudioTrack audioTrack, boolean z) {
            this.mdf = audioTrack;
            this.mdV = z;
            this.mdZ = -9223372036854775807L;
            this.mea = -9223372036854775807L;
            this.mdW = 0L;
            this.mdX = 0L;
            this.mdY = 0L;
            if (audioTrack != null) {
                this.sampleRate = audioTrack.getSampleRate();
            }
        }

        public void fI(long j) {
            this.meb = duI();
            this.mdZ = SystemClock.elapsedRealtime() * 1000;
            this.mec = j;
            this.mdf.stop();
        }

        public void pause() {
            if (this.mdZ == -9223372036854775807L) {
                this.mdf.pause();
            }
        }

        public boolean fJ(long j) {
            return this.mea != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.mea >= 200;
        }

        public long duI() {
            if (this.mdZ != -9223372036854775807L) {
                return Math.min(this.mec, ((((SystemClock.elapsedRealtime() * 1000) - this.mdZ) * this.sampleRate) / TimeUtils.NANOS_PER_MS) + this.meb);
            }
            int playState = this.mdf.getPlayState();
            if (playState == 1) {
                return 0L;
            }
            long playbackHeadPosition = 4294967295L & this.mdf.getPlaybackHeadPosition();
            if (this.mdV) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.mdY = this.mdW;
                }
                playbackHeadPosition += this.mdY;
            }
            if (v.SDK_INT <= 26) {
                if (playbackHeadPosition == 0 && this.mdW > 0 && playState == 3) {
                    if (this.mea == -9223372036854775807L) {
                        this.mea = SystemClock.elapsedRealtime();
                    }
                    return this.mdW;
                }
                this.mea = -9223372036854775807L;
            }
            if (this.mdW > playbackHeadPosition) {
                this.mdX++;
            }
            this.mdW = playbackHeadPosition;
            return playbackHeadPosition + (this.mdX << 32);
        }

        public long duJ() {
            return (duI() * TimeUtils.NANOS_PER_MS) / this.sampleRate;
        }

        public boolean duK() {
            return false;
        }

        public long duL() {
            throw new UnsupportedOperationException();
        }

        public long duM() {
            throw new UnsupportedOperationException();
        }
    }

    @TargetApi(19)
    /* loaded from: classes6.dex */
    private static class b extends a {
        private final AudioTimestamp med;
        private long mee;
        private long mef;
        private long meg;

        public b() {
            super();
            this.med = new AudioTimestamp();
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public void a(AudioTrack audioTrack, boolean z) {
            super.a(audioTrack, z);
            this.mee = 0L;
            this.mef = 0L;
            this.meg = 0L;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public boolean duK() {
            boolean timestamp = this.mdf.getTimestamp(this.med);
            if (timestamp) {
                long j = this.med.framePosition;
                if (this.mef > j) {
                    this.mee++;
                }
                this.mef = j;
                this.meg = j + (this.mee << 32);
            }
            return timestamp;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long duL() {
            return this.med.nanoTime;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.a
        public long duM() {
            return this.meg;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        private final q maC;
        private final long mbB;
        private final long meh;

        private c(q qVar, long j, long j2) {
            this.maC = qVar;
            this.meh = j;
            this.mbB = j2;
        }
    }
}
