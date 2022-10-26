package com.kwad.sdk.utils.kwai;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.kwad.sdk.utils.kwai.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.UShort;
/* loaded from: classes8.dex */
public final class c {
    public static final int PAGE_SIZE;
    public static final int apA;
    public static final int apB;
    public static final int[] apx = {0, 1, 4, 4, 8, 8};
    public static final byte[] apy = new byte[0];
    public static final int apz;
    public final String apC;
    public final Map apD;
    public FileChannel apF;
    public FileChannel apG;
    public RandomAccessFile apH;
    public RandomAccessFile apI;
    public MappedByteBuffer apJ;
    public MappedByteBuffer apK;
    public com.kwad.sdk.utils.kwai.b apL;
    public int apM;
    public long apN;
    public int apQ;
    public int apR;
    public int apS;
    public boolean apT;
    public String apU;
    public int apV;
    public int apX;
    public final String name;
    public final d apE = com.kwad.sdk.utils.kwai.d.aqi;
    public final Map apO = new HashMap();
    public boolean apP = false;
    public final ArrayList apW = new ArrayList();
    public boolean apY = true;
    public final Executor apZ = new f();

    /* loaded from: classes8.dex */
    public class a {
        public static int aqb = 11;
        public static final C0615c aqc = new C0615c(11);
        public final String apC;
        public int apX = 0;
        public b[] aqd;
        public final String name;

        public a(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            if (!str.endsWith("/")) {
                str = str + WebvttCueParser.CHAR_SLASH;
            }
            this.apC = str;
            this.name = str2;
        }

        public final c Bq() {
            String str = this.apC + this.name;
            c ei = C0615c.ei(str);
            if (ei == null) {
                synchronized (a.class) {
                    ei = C0615c.ei(str);
                    if (ei == null) {
                        ei = new c(this.apC, this.name, this.aqd, this.apX);
                        C0615c.b(str, ei);
                    }
                }
            }
            Integer num = (Integer) C0615c.aqh.get(str);
            if (num != null) {
                C0615c.aqh.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0615c.aqh.put(str, 1);
            }
            return ei;
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        String Br();

        byte[] f(Object obj);

        Object g(byte[] bArr, int i, int i2);
    }

    /* renamed from: com.kwad.sdk.utils.kwai.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public final class C0615c {
        public static Map aqe;
        public static List aqf;
        public static int aqg;
        public static Map aqh;

        public C0615c(int i) {
            int size = getSize(i);
            aqe = new ConcurrentHashMap(size);
            aqh = new HashMap(size);
            aqf = new CopyOnWriteArrayList();
            aqg = i;
        }

        public static void b(String str, c cVar) {
            if (aqe == null) {
                aqe = new ConcurrentHashMap(getSize(aqg));
            }
            if (aqf == null) {
                aqf = new CopyOnWriteArrayList();
            }
            if (aqe.containsKey(str)) {
                aqf.remove(str);
            }
            aqf.add(str);
            aqe.put(str, cVar);
            if (aqe.size() > aqg) {
                Integer num = (Integer) aqh.get((String) aqf.get(0));
                if (num != null && num.intValue() != 2) {
                    bP(aqg + 1);
                    return;
                }
                c cVar2 = (c) aqe.get(aqf.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                aqe.remove(aqf.get(0));
                aqf.remove(0);
            }
        }

        public static void bP(int i) {
            d dVar = com.kwad.sdk.utils.kwai.d.aqi;
            dVar.i("Ks_UnionKv", "reSize:" + i);
            aqg = i;
        }

        public static c ei(String str) {
            if (aqe == null) {
                aqe = new ConcurrentHashMap(getSize(aqg));
            }
            if (aqf == null) {
                aqf = new CopyOnWriteArrayList();
            }
            c cVar = (c) aqe.get(str);
            if (cVar != null) {
                aqf.remove(str);
                aqf.add(str);
                return cVar;
            }
            return null;
        }

        public static int getSize(int i) {
            return (int) ((i / 0.75f) + 1.0f);
        }

        public static void remove(String str) {
            List list = aqf;
            if (list != null) {
                list.remove(str);
            }
            Map map = aqe;
            if (map != null) {
                map.remove(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        void a(String str, Exception exc);

        void b(String str, Exception exc);

        void i(String str, String str2);
    }

    /* loaded from: classes8.dex */
    public final class e implements Comparable {
        public int end;
        public int start;

        public e(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            return this.start - eVar.start;
        }
    }

    static {
        int Bu = h.Bu();
        PAGE_SIZE = Bu;
        apz = Bu - 192;
        int max = Math.max(Bu << 1, 16384);
        apA = max;
        apB = max << 1;
    }

    public c(String str, String str2, b[] bVarArr, int i) {
        this.apC = str;
        this.name = str2;
        this.apX = i;
        HashMap hashMap = new HashMap();
        g gVar = g.aqr;
        hashMap.put(gVar.Br(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String Br = bVar.Br();
                if (hashMap.containsKey(Br)) {
                    eh("duplicate encoder tag:" + Br);
                } else {
                    hashMap.put(Br, bVar);
                }
            }
        }
        this.apD = hashMap;
        synchronized (this.apO) {
            com.kwad.sdk.utils.kwai.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.kwai.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.AY();
                }
            });
            while (!this.apP) {
                try {
                    this.apO.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void AY() {
        synchronized (this.apO) {
            this.apP = true;
            this.apO.notify();
        }
        long nanoTime = System.nanoTime();
        if (!Bb() && this.apX == 0) {
            AZ();
        }
        if (this.apL == null) {
            this.apL = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
        }
        if (this.apE != null) {
            info("loading finish, data len:" + this.apM + ", get keys:" + this.apO.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a0 A[Catch: Exception -> 0x01c2, TryCatch #1 {Exception -> 0x01c2, blocks: (B:3:0x0038, B:5:0x003e, B:8:0x0046, B:9:0x0070, B:13:0x0081, B:17:0x009e, B:18:0x00ab, B:21:0x00be, B:22:0x00c2, B:24:0x00e1, B:26:0x00e8, B:28:0x0108, B:30:0x010e, B:35:0x0119, B:37:0x011f, B:39:0x0136, B:41:0x013e, B:43:0x0157, B:44:0x0164, B:46:0x0180, B:48:0x0186, B:51:0x01a0, B:16:0x0099, B:12:0x007e, B:54:0x01aa, B:56:0x01b4), top: B:63:0x0038, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void AZ() {
        boolean z;
        boolean z2;
        String str = this.apC;
        File file = new File(str, this.name + ".kva");
        String str2 = this.apC;
        File file2 = new File(str2, this.name + ".kvb");
        try {
            if (h.aa(file) && h.aa(file2)) {
                this.apH = new RandomAccessFile(file, "rw");
                this.apI = new RandomAccessFile(file2, "rw");
                long length = this.apH.length();
                long length2 = this.apI.length();
                this.apF = this.apH.getChannel();
                this.apG = this.apI.getChannel();
                try {
                    int i = (length > 0L ? 1 : (length == 0L ? 0 : -1));
                    MappedByteBuffer map = this.apF.map(FileChannel.MapMode.READ_WRITE, 0L, i > 0 ? length : PAGE_SIZE);
                    this.apJ = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    int i2 = (length2 > 0L ? 1 : (length2 == 0L ? 0 : -1));
                    MappedByteBuffer map2 = this.apG.map(FileChannel.MapMode.READ_WRITE, 0L, i2 > 0 ? length2 : PAGE_SIZE);
                    this.apK = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                    this.apL = new com.kwad.sdk.utils.kwai.b(this.apJ.capacity());
                    if (i == 0 && i2 == 0) {
                        this.apM = 12;
                        return;
                    }
                    int i3 = this.apJ.getInt();
                    long j = this.apJ.getLong();
                    int i4 = this.apK.getInt();
                    long j2 = this.apK.getLong();
                    if (i3 >= 0 && i3 <= length - 12) {
                        this.apM = i3 + 12;
                        this.apJ.rewind();
                        this.apJ.get(this.apL.apw, 0, this.apM);
                        if (j == this.apL.t(12, i3) && Bc() == 0) {
                            this.apN = j;
                            z = true;
                            if (!z) {
                                if (length == length2 && Ba()) {
                                    return;
                                }
                                c(new Exception("B file error"));
                                a(this.apJ, this.apK, this.apM);
                                return;
                            }
                            if (i4 >= 0 && i4 <= length2 - 12) {
                                this.apO.clear();
                                Bp();
                                this.apM = i4 + 12;
                                if (this.apL.apw.length != this.apK.capacity()) {
                                    this.apL = new com.kwad.sdk.utils.kwai.b(this.apK.capacity());
                                }
                                this.apK.rewind();
                                this.apK.get(this.apL.apw, 0, this.apM);
                                if (j2 == this.apL.t(12, i4) && Bc() == 0) {
                                    c(new Exception("A file error"));
                                    a(this.apK, this.apJ, this.apM);
                                    this.apN = j2;
                                    z2 = true;
                                    if (z2) {
                                        eh("both files error");
                                        Bi();
                                        return;
                                    }
                                    return;
                                }
                            }
                            z2 = false;
                            if (z2) {
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                } catch (IOException e2) {
                    b(e2);
                    Bh();
                    f(file, file2);
                    return;
                }
            }
            b(new Exception("open file failed"));
            Bh();
        } catch (Exception e3) {
            b(e3);
            Bj();
            Bh();
        }
    }

    private boolean Ba() {
        com.kwad.sdk.utils.kwai.b bVar = new com.kwad.sdk.utils.kwai.b(this.apM);
        MappedByteBuffer mappedByteBuffer = this.apK;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.apK.get(bVar.apw, 0, this.apM);
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
        if (bVar2 != null) {
            byte[] bArr = bVar2.apw;
            byte[] bArr2 = bVar.apw;
            for (int i = 0; i < this.apM; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private boolean Bb() {
        String str = this.apC;
        File file = new File(str, this.name + ".kvc");
        String str2 = this.apC;
        File file2 = new File(str2, this.name + ".tmp");
        boolean z = true;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!Z(file)) {
                    Bj();
                    Bg();
                } else if (this.apX == 0) {
                    if (a(this.apL)) {
                        info("recover from c file");
                        try {
                            Bg();
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            b(e);
                            return z;
                        }
                    }
                    this.apX = 1;
                }
            } else if (this.apX != 0) {
                String str3 = this.apC;
                File file3 = new File(str3, this.name + ".kva");
                String str4 = this.apC;
                File file4 = new File(str4, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    f(file3, file4);
                }
            }
            return false;
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x015f, code lost:
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int Bc() {
        Map map;
        a.b cVar;
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        bVar.position = 12;
        while (true) {
            try {
                if (bVar.position >= this.apM) {
                    if (bVar.position != this.apM) {
                        c(new Exception("parse dara failed"));
                        return -1;
                    }
                    return 0;
                }
                int i = bVar.position;
                byte b2 = bVar.get();
                byte b3 = (byte) (b2 & 63);
                if (b3 <= 0 || b3 > 8) {
                    break;
                }
                int i2 = bVar.get() & 255;
                if (b2 < 0) {
                    bVar.position += i2;
                    int i3 = b3 <= 5 ? apx[b3] : bVar.getShort() & UShort.MAX_VALUE;
                    this.apL.position += i3;
                    v(i, this.apL.position);
                } else {
                    String string = bVar.getString(i2);
                    int i4 = bVar.position;
                    if (b3 > 5) {
                        int i5 = bVar.getShort() & UShort.MAX_VALUE;
                        boolean z = (b2 & 64) != 0;
                        e(i5, z);
                        if (b3 == 6) {
                            String bH = z ? bVar.bH(i5) : bVar.getString(i5);
                            map = this.apO;
                            cVar = new a.i(i, i4 + 2, bH, i5, z);
                        } else if (b3 == 7) {
                            Object string2 = z ? bVar.getString(i5) : bVar.getBytes(i5);
                            map = this.apO;
                            cVar = new a.C0614a(i, i4 + 2, string2, i5, z);
                        } else if (z) {
                            String string3 = bVar.getString(i5);
                            map = this.apO;
                            cVar = new a.h(i, i4 + 2, string3, i5, true);
                        } else {
                            int i6 = bVar.get() & 255;
                            String string4 = bVar.getString(i6);
                            b bVar2 = (b) this.apD.get(string4);
                            int i7 = i5 - (i6 + 1);
                            if (i7 < 0) {
                                throw new Exception("parse dara failed");
                            }
                            if (bVar2 != null) {
                                try {
                                    Object g = bVar2.g(bVar.apw, bVar.position, i7);
                                    if (g != null) {
                                        this.apO.put(string, new a.h(i, i4 + 2, g, i5, false));
                                    }
                                } catch (Exception e2) {
                                    b(e2);
                                }
                            } else {
                                eh("object with tag: " + string4 + " without encoder");
                            }
                            bVar.position += i7;
                        }
                    } else if (b3 == 1) {
                        map = this.apO;
                        cVar = new a.c(i4, bVar.get() == 1);
                    } else if (b3 == 2) {
                        map = this.apO;
                        cVar = new a.f(i4, bVar.getInt());
                    } else if (b3 == 3) {
                        map = this.apO;
                        cVar = new a.e(i4, bVar.getFloat());
                    } else if (b3 != 4) {
                        map = this.apO;
                        cVar = new a.d(i4, bVar.getDouble());
                    } else {
                        map = this.apO;
                        cVar = new a.g(i4, bVar.getLong());
                    }
                    map.put(string, cVar);
                }
            } catch (Exception e3) {
                c(e3);
                return -1;
            }
        }
    }

    private void Bd() {
        if (this.apX == 0 || !this.apY) {
            return;
        }
        Be();
    }

    private boolean Be() {
        int i = this.apX;
        if (i == 1) {
            Executor executor = this.apZ;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.kwai.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.Bf();
                    }
                });
            }
        } else if (i == 2) {
            return Bf();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean Bf() {
        try {
            String str = this.apC;
            File file = new File(str, this.name + ".tmp");
            if (h.aa(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.apM);
                randomAccessFile.write(this.apL.apw, 0, this.apM);
                randomAccessFile.close();
                String str2 = this.apC;
                File file2 = new File(str2, this.name + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    c(new Exception("rename failed"));
                }
            }
        } catch (Exception e2) {
            b(e2);
        }
        return false;
    }

    private void Bg() {
        try {
            String str = this.apC;
            h.i(new File(str, this.name + ".kvc"));
            String str2 = this.apC;
            h.i(new File(str2, this.name + ".tmp"));
        } catch (Exception e2) {
            b(e2);
        }
    }

    private void Bh() {
        this.apX = 1;
        h.closeQuietly(this.apF);
        h.closeQuietly(this.apG);
        this.apF = null;
        this.apG = null;
        this.apJ = null;
        this.apK = null;
    }

    private void Bi() {
        if (this.apX == 0) {
            try {
                a(this.apJ);
                a(this.apK);
            } catch (Throwable unused) {
                Bh();
            }
        }
        Bj();
        h.i(new File(this.apC + this.name));
    }

    private void Bj() {
        this.apM = 12;
        this.apN = 0L;
        Bp();
        this.apO.clear();
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        if (bVar == null || bVar.apw.length != PAGE_SIZE) {
            this.apL = new com.kwad.sdk.utils.kwai.b(PAGE_SIZE);
            return;
        }
        bVar.r(0, 0);
        this.apL.b(4, 0L);
    }

    private void Bk() {
        com.kwad.sdk.utils.kwai.b bVar;
        com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
        if (bVar2 != null) {
            this.apN ^= bVar2.t(this.apQ, this.apR);
        }
        if (this.apX == 0) {
            MappedByteBuffer mappedByteBuffer = this.apJ;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.apJ);
                this.apJ.putInt(0, this.apM - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.apK;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.apT && (bVar = this.apL) != null) {
                bVar.r(0, this.apM - 12);
            }
            com.kwad.sdk.utils.kwai.b bVar3 = this.apL;
            if (bVar3 != null) {
                bVar3.b(4, this.apN);
            }
        }
        this.apT = false;
        this.apS = 0;
        this.apR = 0;
    }

    private int Bl() {
        int i = this.apM;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void Bm() {
        bM(this.apR);
        int i = this.apM;
        this.apQ = i;
        this.apM = this.apR + i;
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        if (bVar != null) {
            bVar.position = i;
        }
        this.apT = true;
    }

    private void Bn() {
        if (this.apV < (Bl() << 1)) {
            if (this.apW.size() < (this.apM < 16384 ? 80 : 160)) {
                return;
            }
        }
        bN(0);
    }

    private void Bo() {
        ArrayList arrayList = this.apW;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = (e) this.apW.get(size);
        while (size > 0) {
            size--;
            e eVar2 = (e) this.apW.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.apW.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    private void Bp() {
        this.apV = 0;
        ArrayList arrayList = this.apW;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    private boolean Z(File file) {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i = (int) length;
            int u = u(PAGE_SIZE, i);
            com.kwad.sdk.utils.kwai.b bVar = this.apL;
            if (bVar == null || bVar.apw.length != u) {
                bVar = new com.kwad.sdk.utils.kwai.b(new byte[u]);
                this.apL = bVar;
            } else {
                bVar.position = 0;
            }
            h.a(file, bVar.apw, i);
            int i2 = bVar.getInt();
            long j = bVar.getLong();
            this.apM = i2 + 12;
            if (i2 >= 0 && i2 <= i - 12 && j == bVar.t(12, i2) && Bc() == 0) {
                this.apN = j;
                return true;
            }
        }
        return false;
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.apU = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String Bt = h.Bt();
        if (!h.a(new File(this.apC + this.name, Bt), bArr)) {
            eh("save large value failed");
            return 0;
        }
        this.apU = Bt;
        byte[] bArr2 = new byte[32];
        Bt.getBytes(0, 32, bArr2, 0);
        return b(str, bArr2, (byte) (b2 | 64));
    }

    private Object a(a.h hVar) {
        Exception exc;
        try {
            byte[] ab = h.ab(new File(this.apC + this.name, (String) hVar.value));
            if (ab != null) {
                int i = ab[0] & 255;
                String str = new String(ab, 1, i, com.kwad.sdk.utils.kwai.b.UTF_8);
                b bVar = (b) this.apD.get(str);
                if (bVar != null) {
                    int i2 = i + 1;
                    return bVar.g(ab, i2, ab.length - i2);
                }
                exc = new Exception("No encoder for tag:" + str);
            } else {
                exc = new Exception("Read object data failed");
            }
            c(exc);
            return null;
        } catch (Exception e2) {
            b(e2);
            return null;
        }
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] ab = h.ab(new File(this.apC + this.name, (String) iVar.value));
            String str = new String(ab);
            return (ab == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.kwai.b.j(ab, com.kwad.sdk.utils.kwai.b.ed(str)).getBytes()) == null || bytes.length == 0) ? "" : new String(bytes, com.kwad.sdk.utils.kwai.b.UTF_8);
        } catch (Exception e2) {
            b(e2);
        }
        return "";
    }

    private void a(byte b2, int i) {
        long c = this.apN ^ c(1L, i);
        this.apN = c;
        if (this.apX == 0) {
            MappedByteBuffer mappedByteBuffer = this.apJ;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, c);
                this.apJ.put(i, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.apK;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.apN);
                this.apK.put(i, b2);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.apL;
            if (bVar != null) {
                bVar.b(4, c);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
        if (bVar2 != null) {
            bVar2.apw[i] = b2;
        }
    }

    private void a(byte b2, int i, int i2) {
        byte[] bArr;
        v(i, i2);
        byte b3 = (byte) (b2 | Byte.MIN_VALUE);
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        if (bVar != null && (bArr = bVar.apw) != null) {
            this.apN = (((bArr[i] ^ b3) & 255) << ((i & 7) << 3)) ^ this.apN;
            bArr[i] = b3;
        }
        this.apS = i;
    }

    private void a(int i, long j, int i2) {
        long c = c(j, i2) ^ this.apN;
        this.apN = c;
        if (this.apX == 0) {
            MappedByteBuffer mappedByteBuffer = this.apJ;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, c);
                this.apJ.putInt(i2, i);
            }
            MappedByteBuffer mappedByteBuffer2 = this.apK;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.apN);
                this.apK.putInt(i2, i);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.apL;
            if (bVar != null) {
                bVar.b(4, c);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
        if (bVar2 != null) {
            bVar2.r(i2, i);
        }
    }

    private void a(int i, int[] iArr) {
        Map map = this.apO;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i2 = bVar.offset;
            if (i2 > i) {
                int i3 = iArr[(h.binarySearch(iArr, i2) << 1) + 1];
                bVar.offset -= i3;
                if (bVar.AW() >= 6) {
                    ((a.j) bVar).start -= i3;
                }
            }
        }
    }

    private void a(String str, byte b2) {
        a(str, b2, apx[b2]);
    }

    private void a(String str, byte b2, int i) {
        int ed = com.kwad.sdk.utils.kwai.b.ed(str);
        bL(ed);
        this.apR = ed + 2 + i;
        Bm();
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        if (bVar != null) {
            bVar.b(b2);
        }
        n(str, ed);
    }

    public static void a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 <= str.length() && i2 >= 0) {
            int i5 = 0;
            while (i5 < i2) {
                int i6 = i5 + 1;
                char charAt = str.charAt(i5);
                if (charAt < 128) {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) (((byte) charAt) ^ 1);
                } else {
                    i4 = i3 + 1;
                    bArr[i3] = (byte) charAt;
                }
                i5 = i6;
                i3 = i4;
            }
        }
    }

    private synchronized void a(String str, Object obj, b bVar) {
        eg(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (com.kwad.a.a.aw.booleanValue()) {
                throw illegalArgumentException;
            }
            b(illegalArgumentException);
            return;
        }
        String Br = bVar.Br();
        if (!Br.isEmpty() && Br.length() <= 50) {
            if (!this.apD.containsKey(Br)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (com.kwad.a.a.aw.booleanValue()) {
                    throw illegalArgumentException2;
                }
                b(illegalArgumentException2);
                return;
            } else if (obj == null) {
                remove(str);
                return;
            } else {
                byte[] bArr = null;
                try {
                    bArr = bVar.f(obj);
                } catch (Exception e2) {
                    b(e2);
                }
                if (bArr == null) {
                    remove(str);
                    return;
                }
                int ed = com.kwad.sdk.utils.kwai.b.ed(Br);
                com.kwad.sdk.utils.kwai.b bVar2 = new com.kwad.sdk.utils.kwai.b(ed + 1 + bArr.length);
                bVar2.b((byte) ed);
                bVar2.ec(Br);
                bVar2.n(bArr);
                a(str, obj, bVar2.apw, (a.h) this.apO.get(str), (byte) 8);
                return;
            }
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + Br);
        if (com.kwad.a.a.aw.booleanValue()) {
            throw illegalArgumentException3;
        }
        b(illegalArgumentException3);
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        String str2;
        int length;
        int a2 = a(str, bArr, b2);
        if (a2 != 0) {
            boolean z = this.apU != null;
            if (z) {
                String str3 = this.apU;
                this.apU = null;
                str2 = str3;
                length = 32;
            } else {
                str2 = obj;
                length = bArr.length;
            }
            this.apO.put(str, b2 == 6 ? new a.i(this.apQ, a2, (String) str2, length, z) : b2 == 7 ? new a.C0614a(this.apQ, a2, str2, length, z) : new a.h(this.apQ, a2, str2, length, z));
            Bk();
        }
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar) {
        int a2 = a(str, bArr, jVar.AW());
        if (a2 != 0) {
            String str2 = jVar.apu ? (String) jVar.value : null;
            a(jVar.AW(), jVar.start, jVar.offset + jVar.apt);
            boolean z = this.apU != null;
            jVar.start = this.apQ;
            jVar.offset = a2;
            jVar.apu = z;
            if (z) {
                jVar.value = this.apU;
                jVar.apt = 32;
                this.apU = null;
            } else {
                jVar.value = obj;
                jVar.apt = bArr.length;
            }
            Bk();
            Bn();
            if (str2 != null) {
                h.i(new File(this.apC + this.name, str2));
            }
        }
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (jVar.apu || jVar.apt != bArr.length) {
            a(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        }
        Bd();
    }

    private void a(String str, String str2, a.i iVar) {
        int ed = com.kwad.sdk.utils.kwai.b.ed(str2);
        if (iVar == null) {
            int ed2 = com.kwad.sdk.utils.kwai.b.ed(str);
            bL(ed2);
            int i = ed2 + 4;
            this.apR = i + ed;
            Bm();
            com.kwad.sdk.utils.kwai.b bVar = this.apL;
            if (bVar != null) {
                bVar.b((byte) 6);
            }
            n(str, ed2);
            o(str2, ed);
            Map map = this.apO;
            int i2 = this.apQ;
            map.put(str, new a.i(i2, i2 + i, str2, ed, false));
            Bk();
        } else {
            int i3 = iVar.offset;
            int i4 = i3 - iVar.start;
            int i5 = iVar.apt;
            boolean z = true;
            if (i5 == ed) {
                this.apN = this.apL.t(i3, i5) ^ this.apN;
                if (ed == str2.length()) {
                    a(str2, 0, ed, this.apL.apw, iVar.offset);
                } else {
                    com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.ec(str2);
                    }
                }
                this.apQ = iVar.offset;
                this.apR = ed;
                z = false;
            } else {
                this.apR = i4 + ed;
                Bm();
                com.kwad.sdk.utils.kwai.b bVar3 = this.apL;
                if (bVar3 != null) {
                    bVar3.b((byte) 6);
                }
                int i6 = i4 - 3;
                com.kwad.sdk.utils.kwai.b bVar4 = this.apL;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.apw;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i6);
                }
                com.kwad.sdk.utils.kwai.b bVar5 = this.apL;
                if (bVar5 != null) {
                    bVar5.position += i6;
                }
                o(str2, ed);
                a((byte) 6, iVar.start, iVar.offset + iVar.apt);
                r10 = iVar.apu ? (String) iVar.value : null;
                iVar.apu = false;
                int i7 = this.apQ;
                iVar.start = i7;
                iVar.offset = i7 + i4;
                iVar.apt = ed;
            }
            iVar.value = str2;
            Bk();
            if (z) {
                Bn();
            }
            if (r10 != null) {
                h.i(new File(this.apC + this.name, r10));
            }
        }
        Bd();
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (mappedByteBuffer.capacity() != PAGE_SIZE) {
            FileChannel fileChannel = mappedByteBuffer == this.apJ ? this.apF : this.apG;
            if (fileChannel == null) {
                return;
            }
            fileChannel.truncate(PAGE_SIZE);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, PAGE_SIZE);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.apJ) {
                this.apJ = map;
            } else {
                this.apK = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.apK ? this.apG : this.apF).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.apK) {
                    this.apK = map;
                } else {
                    this.apJ = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                b(e2);
                Bh();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private synchronized void a(Map map, Map map2) {
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str != null && !str.isEmpty()) {
                if (value instanceof String) {
                    putString(str, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(str, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(str, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(str, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(str, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    b(str, (byte[]) value);
                } else {
                    c(new Exception("missing encoders"));
                }
            }
        }
    }

    private boolean a(com.kwad.sdk.utils.kwai.b bVar) {
        int length = bVar.apw.length;
        File file = new File(this.apC, this.name + ".kva");
        File file2 = new File(this.apC, this.name + ".kvb");
        try {
            if (h.aa(file) && h.aa(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j = length;
                randomAccessFile.setLength(j);
                randomAccessFile2.setLength(j);
                this.apF = randomAccessFile.getChannel();
                this.apG = randomAccessFile2.getChannel();
                MappedByteBuffer map = this.apF.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.apJ = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                MappedByteBuffer map2 = this.apG.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.apK = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
                this.apJ.put(bVar.apw, 0, this.apM);
                this.apK.put(bVar.apw, 0, this.apM);
                return true;
            }
            throw new Exception("open file failed");
        } catch (Exception e2) {
            b(e2);
            return false;
        }
    }

    private byte[] a(a.C0614a c0614a) {
        try {
            byte[] ab = h.ab(new File(this.apC + this.name, (String) c0614a.value));
            return ab != null ? ab : apy;
        } catch (Exception e2) {
            b(e2);
            return apy;
        }
    }

    private int b(String str, byte[] bArr, byte b2) {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        if (bVar != null) {
            bVar.a((short) bArr.length);
            com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
            int i = bVar2.position;
            bVar2.n(bArr);
            return i;
        }
        return 0;
    }

    private void b(long j, long j2, int i) {
        long c = c(j2, i) ^ this.apN;
        this.apN = c;
        if (this.apX == 0) {
            MappedByteBuffer mappedByteBuffer = this.apJ;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, c);
                this.apJ.putLong(i, j);
            }
            MappedByteBuffer mappedByteBuffer2 = this.apK;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.apN);
                this.apK.putLong(i, j);
            }
        } else {
            com.kwad.sdk.utils.kwai.b bVar = this.apL;
            if (bVar != null) {
                bVar.b(4, c);
            }
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
        if (bVar2 != null) {
            bVar2.b(i, j);
        }
    }

    private void b(Exception exc) {
        d dVar = this.apE;
        if (dVar != null) {
            dVar.b(this.name, exc);
        }
    }

    private synchronized void b(String str, byte[] bArr) {
        eg(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0614a) this.apO.get(str), (byte) 7);
        }
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.apT && mappedByteBuffer != this.apJ) {
            mappedByteBuffer.putInt(0, this.apM - 12);
        }
        mappedByteBuffer.putLong(4, this.apN);
        int i = this.apS;
        if (i != 0) {
            mappedByteBuffer.put(i, this.apL.apw[i]);
        }
        if (this.apR != 0) {
            mappedByteBuffer.position(this.apQ);
            mappedByteBuffer.put(this.apL.apw, this.apQ, this.apR);
        }
    }

    public static void bL(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void bM(int i) {
        int length = this.apL.apw.length;
        int i2 = this.apM + i;
        if (i2 >= length) {
            int i3 = this.apV;
            if (i3 > i && i3 > Bl()) {
                bN(i);
                return;
            }
            int u = u(length, i2);
            byte[] bArr = new byte[u];
            System.arraycopy(this.apL.apw, 0, bArr, 0, this.apM);
            this.apL.apw = bArr;
            if (this.apX == 0) {
                try {
                    long j = u;
                    MappedByteBuffer map = this.apF.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.apJ = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    MappedByteBuffer map2 = this.apG.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.apK = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                } catch (Throwable th) {
                    b(new Exception("map failed", th));
                    this.apL.r(0, this.apM - 12);
                    this.apL.b(4, this.apN);
                    Bh();
                }
            }
        }
    }

    private void bN(int i) {
        int i2;
        ArrayList arrayList = this.apW;
        if (arrayList == null || this.apL == null) {
            return;
        }
        Collections.sort(arrayList);
        Bo();
        e eVar = (e) this.apW.get(0);
        int i3 = eVar.start;
        int i4 = this.apM;
        int i5 = i4 - this.apV;
        int i6 = i5 - 12;
        int i7 = i5 - i3;
        int i8 = i4 - i3;
        boolean z = i6 < i8 + i7;
        if (!z) {
            this.apN ^= this.apL.t(i3, i8);
        }
        int size = this.apW.size();
        int i9 = size - 1;
        int i10 = this.apM - ((e) this.apW.get(i9)).end;
        int[] iArr = new int[(i10 > 0 ? size : i9) << 1];
        int i11 = eVar.start;
        int i12 = eVar.end;
        for (int i13 = 1; i13 < size; i13++) {
            e eVar2 = (e) this.apW.get(i13);
            int i14 = eVar2.start - i12;
            byte[] bArr = this.apL.apw;
            System.arraycopy(bArr, i12, bArr, i11, i14);
            int i15 = (i13 - 1) << 1;
            iArr[i15] = i12;
            iArr[i15 + 1] = i12 - i11;
            i11 += i14;
            i12 = eVar2.end;
        }
        if (i10 > 0) {
            byte[] bArr2 = this.apL.apw;
            System.arraycopy(bArr2, i12, bArr2, i11, i10);
            int i16 = i9 << 1;
            iArr[i16] = i12;
            iArr[i16 + 1] = i12 - i11;
        }
        Bp();
        this.apN = z ? this.apL.t(12, i6) : this.apN ^ this.apL.t(i3, i7);
        this.apM = i5;
        if (this.apX == 0) {
            MappedByteBuffer mappedByteBuffer = this.apJ;
            if (mappedByteBuffer != null) {
                i2 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.apJ.putLong(4, this.apN);
                this.apJ.position(i3);
                this.apJ.put(this.apL.apw, i3, i7);
                this.apJ.putInt(0, i6);
            } else {
                i2 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.apK;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i2, i6);
                this.apK.putLong(4, this.apN);
                this.apK.position(i3);
                this.apK.put(this.apL.apw, i3, i7);
            }
        } else {
            this.apL.r(0, i6);
            this.apL.b(4, this.apN);
        }
        a(i3, iArr);
        int i17 = i5 + i;
        if (this.apL.apw.length - i17 > apB) {
            bO(i17);
        }
        info("gc finish");
    }

    private void bO(int i) {
        int i2 = PAGE_SIZE;
        int u = u(i2, i + i2);
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        if (bVar != null) {
            byte[] bArr = bVar.apw;
            if (u >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[u];
            System.arraycopy(bArr, 0, bArr2, 0, this.apM);
            this.apL.apw = bArr2;
        }
        if (this.apX == 0) {
            try {
                long j = u;
                this.apF.truncate(j);
                MappedByteBuffer map = this.apF.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.apJ = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                this.apG.truncate(j);
                MappedByteBuffer map2 = this.apG.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.apK = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                b(new Exception("map failed", th));
                Bh();
            }
        }
        info("truncate finish");
    }

    public static long c(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    private void c(Exception exc) {
        d dVar = this.apE;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    public static void e(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    public static void eg(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void eh(String str) {
        d dVar = this.apE;
        if (dVar != null) {
            dVar.b(this.name, new Exception(str));
        }
    }

    private void f(File file, File file2) {
        try {
            if (Z(file)) {
                return;
            }
        } catch (IOException e2) {
            c(e2);
        }
        Bj();
        try {
            if (Z(file2)) {
                return;
            }
        } catch (Exception e3) {
            c(e3);
        }
        Bj();
    }

    private void info(String str) {
        d dVar = this.apE;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private void n(String str, int i) {
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        if (bVar == null) {
            return;
        }
        bVar.b((byte) i);
        if (i != str.length()) {
            this.apL.ec(str);
            return;
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
        a(str, 0, i, bVar2.apw, bVar2.position);
        this.apL.position += i;
    }

    private void o(String str, int i) {
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i);
        if (i != str.length()) {
            this.apL.ec(str);
            return;
        }
        com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
        a(str, 0, i, bVar2.apw, bVar2.position);
    }

    private synchronized void putDouble(String str, double d2) {
        eg(str);
        a.d dVar = (a.d) this.apO.get(str);
        if (dVar != null) {
            if (dVar.value != d2) {
                long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
                dVar.value = d2;
                b(doubleToRawLongBits, Double.doubleToRawLongBits(dVar.value) ^ doubleToRawLongBits, dVar.offset);
                Bd();
            }
            return;
        }
        a(str, (byte) 5);
        if (this.apL != null) {
            int i = this.apL.position;
            this.apL.T(Double.doubleToRawLongBits(d2));
            Bk();
            if (this.apO != null) {
                this.apO.put(str, new a.d(i, d2));
            }
        }
        Bd();
    }

    private synchronized void putFloat(String str, float f) {
        eg(str);
        a.e eVar = (a.e) this.apO.get(str);
        if (eVar != null) {
            if (eVar.value != f) {
                int floatToRawIntBits = Float.floatToRawIntBits(f);
                eVar.value = f;
                a(floatToRawIntBits, (Float.floatToRawIntBits(eVar.value) ^ floatToRawIntBits) & 4294967295L, eVar.offset);
                Bd();
            }
            return;
        }
        a(str, (byte) 3);
        if (this.apL != null) {
            int i = this.apL.position;
            this.apL.bE(Float.floatToRawIntBits(f));
            Bk();
            if (this.apO != null) {
                this.apO.put(str, new a.e(i, f));
            }
        }
        Bd();
    }

    private synchronized void putStringSet(String str, Set set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, set, g.aqr);
        }
    }

    private int u(int i, int i2) {
        if (i2 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (com.kwad.a.a.aw.booleanValue()) {
                throw illegalStateException;
            }
            b(illegalStateException);
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = apA;
            i = i <= i4 ? i << 1 : i + i4;
        }
        return i;
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.kwai.b bVar = this.apL;
        if (bVar != null) {
            this.apN ^= bVar.t(i, length);
            com.kwad.sdk.utils.kwai.b bVar2 = this.apL;
            bVar2.position = i;
            bVar2.n(bArr);
            this.apN ^= this.apL.t(i, length);
        }
        if (this.apX != 0) {
            com.kwad.sdk.utils.kwai.b bVar3 = this.apL;
            if (bVar3 != null) {
                bVar3.b(4, this.apN);
                return;
            }
            return;
        }
        MappedByteBuffer mappedByteBuffer = this.apJ;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.putInt(0, -1);
            this.apJ.putLong(4, this.apN);
            this.apJ.position(i);
            this.apJ.put(bArr);
            this.apJ.putInt(0, this.apM - 12);
        }
        MappedByteBuffer mappedByteBuffer2 = this.apK;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.putLong(4, this.apN);
            this.apK.position(i);
            this.apK.put(bArr);
        }
    }

    private void v(int i, int i2) {
        this.apV += i2 - i;
        ArrayList arrayList = this.apW;
        if (arrayList != null) {
            arrayList.add(new e(i, i2));
        }
    }

    public final synchronized boolean contains(String str) {
        return this.apO.containsKey(str);
    }

    public final synchronized Map getAll() {
        Object valueOf;
        a.j jVar;
        int size = this.apO.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry entry : this.apO.entrySet()) {
            String str = (String) entry.getKey();
            a.b bVar = (a.b) entry.getValue();
            Object obj = null;
            switch (bVar.AW()) {
                case 1:
                    valueOf = Boolean.valueOf(((a.c) bVar).value);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((a.f) bVar).value);
                    break;
                case 3:
                    valueOf = Float.valueOf(((a.e) bVar).value);
                    break;
                case 4:
                    valueOf = Long.valueOf(((a.g) bVar).value);
                    break;
                case 5:
                    valueOf = Double.valueOf(((a.d) bVar).value);
                    break;
                case 6:
                    a.i iVar = (a.i) bVar;
                    boolean z = iVar.apu;
                    jVar = iVar;
                    if (z) {
                        valueOf = a(iVar);
                        break;
                    }
                    valueOf = jVar.value;
                    break;
                case 7:
                    a.C0614a c0614a = (a.C0614a) bVar;
                    boolean z2 = c0614a.apu;
                    jVar = c0614a;
                    if (z2) {
                        valueOf = a(c0614a);
                        break;
                    }
                    valueOf = jVar.value;
                    break;
                case 8:
                    a.h hVar = (a.h) bVar;
                    if (hVar.apu) {
                        valueOf = a(hVar);
                        break;
                    } else {
                        jVar = (a.h) bVar;
                        valueOf = jVar.value;
                        break;
                    }
                default:
                    continue;
                    hashMap.put(str, obj);
            }
            obj = valueOf;
            hashMap.put(str, obj);
        }
        return hashMap;
    }

    public final synchronized boolean getBoolean(String str, boolean z) {
        a.c cVar = (a.c) this.apO.get(str);
        if (cVar == null) {
            return z;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i) {
        a.f fVar = (a.f) this.apO.get(str);
        if (fVar == null) {
            return i;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j) {
        a.g gVar = (a.g) this.apO.get(str);
        if (gVar == null) {
            return j;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.apO.get(str);
        if (iVar != null) {
            if (iVar.apu) {
                return a(iVar);
            }
            return (String) iVar.value;
        }
        return str2;
    }

    public final void putAll(Map map) {
        a(map, (Map) null);
    }

    public final synchronized void putBoolean(String str, boolean z) {
        eg(str);
        a.c cVar = (a.c) this.apO.get(str);
        if (cVar != null) {
            if (cVar.value != z) {
                cVar.value = z;
                a((byte) (z ? 1 : 0), cVar.offset);
                Bd();
            }
            return;
        }
        a(str, (byte) 1);
        if (this.apL != null) {
            int i = this.apL.position;
            this.apL.b((byte) (z ? 1 : 0));
            Bk();
            if (this.apO != null) {
                this.apO.put(str, new a.c(i, z));
            }
        }
        Bd();
    }

    public final synchronized void putInt(String str, int i) {
        eg(str);
        a.f fVar = (a.f) this.apO.get(str);
        if (fVar != null) {
            if (fVar.value != i) {
                fVar.value = i;
                a(i, (fVar.value ^ i) & 4294967295L, fVar.offset);
                Bd();
            }
            return;
        }
        a(str, (byte) 2);
        if (this.apL != null) {
            int i2 = this.apL.position;
            this.apL.bE(i);
            Bk();
            if (this.apO != null) {
                this.apO.put(str, new a.f(i2, i));
            }
        }
        Bd();
    }

    public final synchronized void putLong(String str, long j) {
        eg(str);
        a.g gVar = (a.g) this.apO.get(str);
        if (gVar != null) {
            if (gVar.value != j) {
                gVar.value = j;
                b(j, j ^ gVar.value, gVar.offset);
                Bd();
            }
            return;
        }
        a(str, (byte) 4);
        if (this.apL != null) {
            int i = this.apL.position;
            this.apL.T(j);
            Bk();
            if (this.apO != null) {
                this.apO.put(str, new a.g(i, j));
            }
        }
        Bd();
    }

    public final synchronized void putString(String str, String str2) {
        byte[] bArr;
        byte[] ef;
        byte[] bArr2;
        eg(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.apO.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (str2.isEmpty()) {
            ef = apy;
        } else if (iVar != null || str2.length() >= 2048) {
            if (iVar != null && !iVar.apu) {
                int ed = com.kwad.sdk.utils.kwai.b.ed(str2);
                bArr = new byte[ed];
                if (ed == str2.length()) {
                    a(str2, 0, ed, bArr, 0);
                    bArr2 = bArr;
                    a(str, str2, bArr2, iVar, (byte) 6);
                }
            }
            ef = com.kwad.sdk.utils.kwai.b.ef(str2);
        } else {
            int ed2 = com.kwad.sdk.utils.kwai.b.ed(str2);
            bArr = new byte[ed2];
            if (ed2 == str2.length()) {
                a(str2, 0, ed2, bArr, 0);
                bArr2 = bArr;
                a(str, str2, bArr2, iVar, (byte) 6);
            }
            ef = com.kwad.sdk.utils.kwai.b.ef(str2);
        }
        bArr2 = ef;
        a(str, str2, bArr2, iVar, (byte) 6);
    }

    public final void release() {
        h.closeQuietly(this.apH);
        h.closeQuietly(this.apI);
        h.closeQuietly(this.apF);
        h.closeQuietly(this.apG);
        this.apF = null;
        this.apG = null;
        this.apJ = null;
        this.apK = null;
        C0615c c0615c = a.aqc;
        C0615c.remove(this.apC + this.name);
    }

    public final synchronized void remove(String str) {
        a.b bVar = (a.b) this.apO.get(str);
        if (bVar != null) {
            this.apO.remove(str);
            byte AW = bVar.AW();
            String str2 = null;
            if (AW <= 5) {
                a(AW, bVar.offset - (com.kwad.sdk.utils.kwai.b.ed(str) + 2), bVar.offset + apx[AW]);
            } else {
                a.j jVar = (a.j) bVar;
                a(AW, jVar.start, jVar.offset + jVar.apt);
                if (jVar.apu) {
                    str2 = (String) jVar.value;
                }
            }
            byte b2 = (byte) (AW | Byte.MIN_VALUE);
            if (this.apX == 0) {
                if (this.apJ != null) {
                    this.apJ.putLong(4, this.apN);
                    this.apJ.put(this.apS, b2);
                }
                if (this.apK != null) {
                    this.apK.putLong(4, this.apN);
                    this.apK.put(this.apS, b2);
                }
            } else if (this.apL != null) {
                this.apL.b(4, this.apN);
            }
            this.apS = 0;
            if (str2 != null) {
                h.i(new File(this.apC + this.name, str2));
            }
            Bn();
            Bd();
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.apC + " name:" + this.name;
    }
}
