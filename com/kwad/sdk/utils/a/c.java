package com.kwad.sdk.utils.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.kwad.sdk.utils.a.a;
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
import org.chromium.net.NetError;
/* loaded from: classes10.dex */
public final class c {
    public static final int PAGE_SIZE;
    public static final int[] aPK = {0, 1, 4, 4, 8, 8};
    public static final byte[] aPL = new byte[0];
    public static final int aPM;
    public static final int aPN;
    public static final int aPO;
    public final String Vz;
    public final Map<String, b> aPP;
    public FileChannel aPR;
    public FileChannel aPS;
    public RandomAccessFile aPT;
    public RandomAccessFile aPU;
    public MappedByteBuffer aPV;
    public MappedByteBuffer aPW;
    public com.kwad.sdk.utils.a.b aPX;
    public int aPY;
    public long aPZ;
    public int aQc;
    public int aQd;
    public int aQe;
    public boolean aQf;
    public String aQg;
    public int aQh;
    public int aQj;
    public final String name;
    public final d aPQ = com.kwad.sdk.utils.a.d.aQu;
    public final Map<String, a.b> aQa = new HashMap();
    public boolean aQb = false;
    public final ArrayList<e> aQi = new ArrayList<>();
    public boolean aQk = true;
    public final Executor aQl = new f();

    /* loaded from: classes10.dex */
    public interface b<T> {
        String Ml();

        T g(byte[] bArr, int i, int i2);

        byte[] o(T t);
    }

    /* loaded from: classes10.dex */
    public interface d {
        void a(String str, Exception exc);

        void e(String str, Throwable th);

        void i(String str, String str2);
    }

    public static long e(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    /* renamed from: com.kwad.sdk.utils.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0728c {
        public static Map<String, c> aQq;
        public static List<String> aQr;
        public static int aQs;
        public static Map<String, Integer> aQt;

        public static int getSize(int i) {
            return (int) ((i / 0.75f) + 1.0f);
        }

        public C0728c(int i) {
            int size = getSize(i);
            aQq = new ConcurrentHashMap(size);
            aQt = new HashMap(size);
            aQr = new CopyOnWriteArrayList();
            aQs = i;
        }

        public static void dR(int i) {
            d dVar = com.kwad.sdk.utils.a.d.aQu;
            dVar.i("Ks_UnionKv", "reSize:" + i);
            aQs = i;
        }

        public static void remove(String str) {
            List<String> list = aQr;
            if (list != null) {
                list.remove(str);
            }
            Map<String, c> map = aQq;
            if (map != null) {
                map.remove(str);
            }
        }

        public static void b(String str, c cVar) {
            if (aQq == null) {
                aQq = new ConcurrentHashMap(getSize(aQs));
            }
            if (aQr == null) {
                aQr = new CopyOnWriteArrayList();
            }
            if (aQq.containsKey(str)) {
                aQr.remove(str);
                aQr.add(str);
            } else {
                aQr.add(str);
            }
            aQq.put(str, cVar);
            if (aQq.size() > aQs) {
                Integer num = aQt.get(aQr.get(0));
                if (num != null && num.intValue() != 2) {
                    dR(aQs + 1);
                    return;
                }
                c cVar2 = aQq.get(aQr.get(0));
                if (cVar2 != null) {
                    cVar2.release();
                }
                aQq.remove(aQr.get(0));
                aQr.remove(0);
            }
        }

        public static c gB(String str) {
            if (aQq == null) {
                aQq = new ConcurrentHashMap(getSize(aQs));
            }
            if (aQr == null) {
                aQr = new CopyOnWriteArrayList();
            }
            c cVar = aQq.get(str);
            if (cVar != null) {
                aQr.remove(str);
                aQr.add(str);
                return cVar;
            }
            return null;
        }
    }

    /* loaded from: classes10.dex */
    public static class e implements Comparable<e> {
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
        int Mo = h.Mo();
        PAGE_SIZE = Mo;
        aPM = Mo + NetError.ERR_REQUEST_TIMED_OUT;
        int max = Math.max(Mo << 1, 16384);
        aPN = max;
        aPO = max << 1;
    }

    private void Ma() {
        try {
            String str = this.Vz;
            h.h(new File(str, this.name + ".kvc"));
            String str2 = this.Vz;
            h.h(new File(str2, this.name + ".tmp"));
        } catch (Exception e2) {
            t(e2);
        }
    }

    private void Mi() {
        ArrayList<e> arrayList = this.aQi;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size() - 1;
        e eVar = this.aQi.get(size);
        while (size > 0) {
            size--;
            e eVar2 = this.aQi.get(size);
            if (eVar.start == eVar2.end) {
                eVar2.end = eVar.end;
                this.aQi.remove(size + 1);
            }
            eVar = eVar2;
        }
    }

    public final void release() {
        h.closeQuietly(this.aPT);
        h.closeQuietly(this.aPU);
        h.closeQuietly(this.aPR);
        h.closeQuietly(this.aPS);
        this.aPR = null;
        this.aPS = null;
        this.aPV = null;
        this.aPW = null;
        C0728c c0728c = a.aQo;
        C0728c.remove(this.Vz + this.name);
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static int aQn = 11;
        public static final C0728c aQo = new C0728c(11);
        public final String Vz;
        public int aQj = 0;
        public b[] aQp;
        public final String name;

        public a(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    if (!str.endsWith("/")) {
                        str = str + WebvttCueParser.CHAR_SLASH;
                    }
                    this.Vz = str;
                    this.name = str2;
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("path is empty");
        }

        public final c Mk() {
            String str = this.Vz + this.name;
            c gB = C0728c.gB(str);
            if (gB == null) {
                synchronized (a.class) {
                    gB = C0728c.gB(str);
                    if (gB == null) {
                        gB = new c(this.Vz, this.name, this.aQp, this.aQj);
                        C0728c.b(str, gB);
                    }
                }
            }
            Integer num = C0728c.aQt.get(str);
            if (num != null) {
                C0728c.aQt.put(str, Integer.valueOf(num.intValue() + 1));
            } else {
                C0728c.aQt.put(str, 1);
            }
            return gB;
        }
    }

    public c(String str, String str2, b[] bVarArr, int i) {
        this.Vz = str;
        this.name = str2;
        this.aQj = i;
        HashMap hashMap = new HashMap();
        g gVar = g.aQC;
        hashMap.put(gVar.Ml(), gVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String Ml = bVar.Ml();
                if (hashMap.containsKey(Ml)) {
                    gA("duplicate encoder tag:" + Ml);
                } else {
                    hashMap.put(Ml, bVar);
                }
            }
        }
        this.aPP = hashMap;
        synchronized (this.aQa) {
            com.kwad.sdk.utils.a.d.getExecutor().execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.LS();
                }
            });
            while (!this.aQb) {
                try {
                    this.aQa.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private void a(String str, Object obj, byte[] bArr, @NonNull a.j jVar) {
        String str2;
        boolean z;
        int a2 = a(str, bArr, jVar.LQ());
        if (a2 != 0) {
            if (jVar.aPH) {
                str2 = (String) jVar.value;
            } else {
                str2 = null;
            }
            a(jVar.LQ(), jVar.start, jVar.offset + jVar.aPG);
            if (this.aQg != null) {
                z = true;
            } else {
                z = false;
            }
            jVar.start = this.aQc;
            jVar.offset = a2;
            jVar.aPH = z;
            if (z) {
                jVar.value = this.aQg;
                jVar.aPG = 32;
                this.aQg = null;
            } else {
                jVar.value = obj;
                jVar.aPG = bArr.length;
            }
            Me();
            Mh();
            if (str2 != null) {
                h.h(new File(this.Vz + this.name, str2));
            }
        }
    }

    private int G(int i, int i2) {
        if (i2 > 536870912) {
            IllegalStateException illegalStateException = new IllegalStateException("data size out of limit");
            if (!com.kwad.library.a.a.mc.booleanValue()) {
                t(illegalStateException);
            } else {
                throw illegalStateException;
            }
        }
        int i3 = PAGE_SIZE;
        if (i2 <= i3) {
            return i3;
        }
        while (i < i2) {
            int i4 = aPN;
            if (i <= i4) {
                i <<= 1;
            } else {
                i += i4;
            }
        }
        return i;
    }

    private void H(int i, int i2) {
        this.aQh += i2 - i;
        ArrayList<e> arrayList = this.aQi;
        if (arrayList != null) {
            arrayList.add(new e(i, i2));
        }
    }

    private void a(String str, byte b2) {
        a(str, b2, aPK[b2]);
    }

    private synchronized void b(String str, byte[] bArr) {
        gz(str);
        if (bArr == null) {
            remove(str);
        } else {
            a(str, bArr, bArr, (a.C0727a) this.aQa.get(str), (byte) 7);
        }
    }

    public static void e(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i >= 0 && i < 2048) {
        } else {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void h(File file, File file2) {
        try {
            if (ad(file)) {
                return;
            }
        } catch (IOException e2) {
            g(e2);
        }
        Md();
        try {
            if (ad(file2)) {
                return;
            }
        } catch (Exception e3) {
            g(e3);
        }
        Md();
    }

    private synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            a(str, (String) set, (b<String>) g.aQC);
        }
    }

    private void u(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        if (bVar == null) {
            return;
        }
        bVar.e((byte) i);
        if (i == str.length()) {
            com.kwad.sdk.utils.a.b bVar2 = this.aPX;
            a(str, 0, i, bVar2.aPJ, bVar2.position);
            this.aPX.position += i;
            return;
        }
        this.aPX.gv(str);
    }

    private void v(String str, int i) {
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        if (bVar == null) {
            return;
        }
        bVar.a((short) i);
        if (i == str.length()) {
            com.kwad.sdk.utils.a.b bVar2 = this.aPX;
            a(str, 0, i, bVar2.aPJ, bVar2.position);
            return;
        }
        this.aPX.gv(str);
    }

    public final synchronized boolean getBoolean(String str, boolean z) {
        a.c cVar = (a.c) this.aQa.get(str);
        if (cVar == null) {
            return z;
        }
        return cVar.value;
    }

    public final synchronized int getInt(String str, int i) {
        a.f fVar = (a.f) this.aQa.get(str);
        if (fVar == null) {
            return i;
        }
        return fVar.value;
    }

    public final synchronized long getLong(String str, long j) {
        a.g gVar = (a.g) this.aQa.get(str);
        if (gVar == null) {
            return j;
        }
        return gVar.value;
    }

    public final synchronized String getString(String str, String str2) {
        a.i iVar = (a.i) this.aQa.get(str);
        if (iVar != null) {
            if (iVar.aPH) {
                return a(iVar);
            }
            return (String) iVar.value;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void LS() {
        synchronized (this.aQa) {
            this.aQb = true;
            this.aQa.notify();
        }
        long nanoTime = System.nanoTime();
        if (!LV() && this.aQj == 0) {
            LT();
        }
        if (this.aPX == null) {
            this.aPX = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        if (this.aPQ != null) {
            info("loading finish, data len:" + this.aPY + ", get keys:" + this.aQa.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean LZ() {
        try {
            String str = this.Vz;
            File file = new File(str, this.name + ".tmp");
            if (h.ae(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.aPY);
                randomAccessFile.write(this.aPX.aPJ, 0, this.aPY);
                randomAccessFile.close();
                String str2 = this.Vz;
                File file2 = new File(str2, this.name + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    g(new Exception("rename failed"));
                }
            }
        } catch (Exception e2) {
            t(e2);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a0 A[Catch: all -> 0x01c2, TryCatch #1 {all -> 0x01c2, blocks: (B:3:0x0038, B:5:0x003e, B:8:0x0046, B:9:0x0070, B:13:0x0081, B:17:0x009e, B:18:0x00ab, B:21:0x00be, B:22:0x00c2, B:24:0x00e1, B:26:0x00e8, B:28:0x0108, B:30:0x010e, B:35:0x0119, B:37:0x011f, B:39:0x0136, B:41:0x013e, B:43:0x0157, B:44:0x0164, B:46:0x0180, B:48:0x0186, B:51:0x01a0, B:16:0x0099, B:12:0x007e, B:54:0x01aa, B:56:0x01b4), top: B:63:0x0038, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void LT() {
        long j;
        long j2;
        boolean z;
        boolean z2;
        File file = new File(this.Vz, this.name + ".kva");
        File file2 = new File(this.Vz, this.name + ".kvb");
        try {
            if (h.ae(file) && h.ae(file2)) {
                this.aPT = new RandomAccessFile(file, "rw");
                this.aPU = new RandomAccessFile(file2, "rw");
                long length = this.aPT.length();
                long length2 = this.aPU.length();
                this.aPR = this.aPT.getChannel();
                this.aPS = this.aPU.getChannel();
                try {
                    FileChannel fileChannel = this.aPR;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    int i = (length > 0L ? 1 : (length == 0L ? 0 : -1));
                    if (i > 0) {
                        j = length;
                    } else {
                        j = PAGE_SIZE;
                    }
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, j);
                    this.aPV = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    FileChannel fileChannel2 = this.aPS;
                    FileChannel.MapMode mapMode2 = FileChannel.MapMode.READ_WRITE;
                    int i2 = (length2 > 0L ? 1 : (length2 == 0L ? 0 : -1));
                    if (i2 > 0) {
                        j2 = length2;
                    } else {
                        j2 = PAGE_SIZE;
                    }
                    MappedByteBuffer map2 = fileChannel2.map(mapMode2, 0L, j2);
                    this.aPW = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                    this.aPX = new com.kwad.sdk.utils.a.b(this.aPV.capacity());
                    if (i == 0 && i2 == 0) {
                        this.aPY = 12;
                        return;
                    }
                    int i3 = this.aPV.getInt();
                    long j3 = this.aPV.getLong();
                    int i4 = this.aPW.getInt();
                    long j4 = this.aPW.getLong();
                    if (i3 >= 0 && i3 <= length - 12) {
                        this.aPY = i3 + 12;
                        this.aPV.rewind();
                        this.aPV.get(this.aPX.aPJ, 0, this.aPY);
                        if (j3 == this.aPX.F(12, i3) && LW() == 0) {
                            this.aPZ = j3;
                            z = true;
                            if (!z) {
                                if (length != length2 || !LU()) {
                                    g(new Exception("B file error"));
                                    a(this.aPV, this.aPW, this.aPY);
                                    return;
                                }
                                return;
                            }
                            if (i4 >= 0 && i4 <= length2 - 12) {
                                this.aQa.clear();
                                Mj();
                                this.aPY = i4 + 12;
                                if (this.aPX.aPJ.length != this.aPW.capacity()) {
                                    this.aPX = new com.kwad.sdk.utils.a.b(this.aPW.capacity());
                                }
                                this.aPW.rewind();
                                this.aPW.get(this.aPX.aPJ, 0, this.aPY);
                                if (j4 == this.aPX.F(12, i4) && LW() == 0) {
                                    g(new Exception("A file error"));
                                    a(this.aPW, this.aPV, this.aPY);
                                    this.aPZ = j4;
                                    z2 = true;
                                    if (z2) {
                                        gA("both files error");
                                        Mc();
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
                    t(e2);
                    Mb();
                    h(file, file2);
                    return;
                }
            }
            t(new Exception("open file failed"));
            Mb();
        } catch (Throwable th) {
            t(th);
            Md();
            Mb();
        }
    }

    private boolean LU() {
        com.kwad.sdk.utils.a.b bVar = new com.kwad.sdk.utils.a.b(this.aPY);
        MappedByteBuffer mappedByteBuffer = this.aPW;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.rewind();
            this.aPW.get(bVar.aPJ, 0, this.aPY);
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aPX;
        if (bVar2 != null) {
            byte[] bArr = bVar2.aPJ;
            byte[] bArr2 = bVar.aPJ;
            for (int i = 0; i < this.aPY; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    private void LX() {
        if (this.aQj != 0 && this.aQk) {
            LY();
        }
    }

    private boolean LY() {
        int i = this.aQj;
        if (i == 1) {
            Executor executor = this.aQl;
            if (executor != null) {
                executor.execute(new Runnable() { // from class: com.kwad.sdk.utils.a.c.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.LZ();
                    }
                });
            }
        } else if (i == 2) {
            return LZ();
        }
        return true;
    }

    private void Mb() {
        this.aQj = 1;
        h.closeQuietly(this.aPR);
        h.closeQuietly(this.aPS);
        this.aPR = null;
        this.aPS = null;
        this.aPV = null;
        this.aPW = null;
    }

    private void Mc() {
        if (this.aQj == 0) {
            try {
                a(this.aPV);
                a(this.aPW);
            } catch (Throwable unused) {
                Mb();
            }
        }
        Md();
        h.h(new File(this.Vz + this.name));
    }

    private void Md() {
        this.aPY = 12;
        this.aPZ = 0L;
        Mj();
        this.aQa.clear();
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        if (bVar != null && bVar.aPJ.length == PAGE_SIZE) {
            bVar.D(0, 0);
            this.aPX.g(4, 0L);
            return;
        }
        this.aPX = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
    }

    private int Mf() {
        int i = this.aPY;
        if (i <= 16384) {
            return 4096;
        }
        if (i > 65536) {
            return 16384;
        }
        return 8192;
    }

    private void Mg() {
        dO(this.aQd);
        int i = this.aPY;
        this.aQc = i;
        this.aPY = this.aQd + i;
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        if (bVar != null) {
            bVar.position = i;
        }
        this.aQf = true;
    }

    private void Mh() {
        int i;
        if (this.aQh < (Mf() << 1)) {
            int size = this.aQi.size();
            if (this.aPY < 16384) {
                i = 80;
            } else {
                i = 160;
            }
            if (size < i) {
                return;
            }
        }
        dP(0);
    }

    private void Mj() {
        this.aQh = 0;
        ArrayList<e> arrayList = this.aQi;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    public final synchronized String toString() {
        return "FastKV: path:" + this.Vz + " name:" + this.name;
    }

    private boolean LV() {
        File file = new File(this.Vz, this.name + ".kvc");
        File file2 = new File(this.Vz, this.name + ".tmp");
        boolean z = true;
        try {
            if (!file.exists()) {
                if (file2.exists()) {
                    file = file2;
                } else {
                    file = null;
                }
            }
            if (file != null) {
                if (ad(file)) {
                    if (this.aQj == 0) {
                        if (a(this.aPX)) {
                            info("recover from c file");
                            try {
                                Ma();
                                return true;
                            } catch (Exception e2) {
                                e = e2;
                                t(e);
                                return z;
                            }
                        }
                        this.aQj = 1;
                    }
                } else {
                    Md();
                    Ma();
                }
            } else if (this.aQj != 0) {
                File file3 = new File(this.Vz, this.name + ".kva");
                File file4 = new File(this.Vz, this.name + ".kvb");
                if (file3.exists() && file4.exists()) {
                    h(file3, file4);
                }
            }
            return false;
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    public final synchronized Map<String, Object> getAll() {
        Object valueOf;
        int size = this.aQa.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, a.b> entry : this.aQa.entrySet()) {
            String key = entry.getKey();
            a.b value = entry.getValue();
            Object obj = null;
            switch (value.LQ()) {
                case 1:
                    valueOf = Boolean.valueOf(((a.c) value).value);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((a.f) value).value);
                    break;
                case 3:
                    valueOf = Float.valueOf(((a.e) value).value);
                    break;
                case 4:
                    valueOf = Long.valueOf(((a.g) value).value);
                    break;
                case 5:
                    valueOf = Double.valueOf(((a.d) value).value);
                    break;
                case 6:
                    a.i iVar = (a.i) value;
                    if (iVar.aPH) {
                        valueOf = a(iVar);
                        break;
                    } else {
                        valueOf = iVar.value;
                        break;
                    }
                case 7:
                    a.C0727a c0727a = (a.C0727a) value;
                    if (c0727a.aPH) {
                        valueOf = a(c0727a);
                        break;
                    } else {
                        valueOf = c0727a.value;
                        break;
                    }
                case 8:
                    a.h hVar = (a.h) value;
                    if (hVar.aPH) {
                        valueOf = a(hVar);
                        break;
                    } else {
                        valueOf = ((a.h) value).value;
                        break;
                    }
                default:
                    continue;
                    hashMap.put(key, obj);
            }
            obj = valueOf;
            hashMap.put(key, obj);
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0178, code lost:
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int LW() {
        int i;
        Object bytes;
        String string;
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        bVar.position = 12;
        while (true) {
            try {
                boolean z = false;
                if (bVar.position < this.aPY) {
                    int i2 = bVar.position;
                    byte b2 = bVar.get();
                    byte b3 = (byte) (b2 & 63);
                    if (b3 <= 0 || b3 > 8) {
                        break;
                    }
                    int i3 = bVar.get() & 255;
                    if (b2 < 0) {
                        bVar.position += i3;
                        if (b3 <= 5) {
                            i = aPK[b3];
                        } else {
                            i = bVar.getShort() & UShort.MAX_VALUE;
                        }
                        this.aPX.position += i;
                        H(i2, this.aPX.position);
                    } else {
                        String string2 = bVar.getString(i3);
                        int i4 = bVar.position;
                        if (b3 <= 5) {
                            if (b3 != 1) {
                                if (b3 != 2) {
                                    if (b3 != 3) {
                                        if (b3 != 4) {
                                            this.aQa.put(string2, new a.d(i4, bVar.getDouble()));
                                        } else {
                                            this.aQa.put(string2, new a.g(i4, bVar.getLong()));
                                        }
                                    } else {
                                        this.aQa.put(string2, new a.e(i4, bVar.getFloat()));
                                    }
                                } else {
                                    this.aQa.put(string2, new a.f(i4, bVar.getInt()));
                                }
                            } else {
                                Map<String, a.b> map = this.aQa;
                                if (bVar.get() == 1) {
                                    z = true;
                                }
                                map.put(string2, new a.c(i4, z));
                            }
                        } else {
                            int i5 = bVar.getShort() & UShort.MAX_VALUE;
                            if ((b2 & 64) != 0) {
                                z = true;
                            }
                            e(i5, z);
                            if (b3 != 6) {
                                if (b3 != 7) {
                                    if (z) {
                                        this.aQa.put(string2, new a.h(i2, i4 + 2, bVar.getString(i5), i5, true));
                                    } else {
                                        int i6 = bVar.get() & 255;
                                        String string3 = bVar.getString(i6);
                                        b bVar2 = this.aPP.get(string3);
                                        int i7 = i5 - (i6 + 1);
                                        if (i7 >= 0) {
                                            if (bVar2 != null) {
                                                try {
                                                    Object g = bVar2.g(bVar.aPJ, bVar.position, i7);
                                                    if (g != null) {
                                                        this.aQa.put(string2, new a.h(i2, i4 + 2, g, i5, false));
                                                    }
                                                } catch (Exception e2) {
                                                    t(e2);
                                                }
                                            } else {
                                                gA("object with tag: " + string3 + " without encoder");
                                            }
                                            bVar.position += i7;
                                        } else {
                                            throw new Exception("parse dara failed");
                                        }
                                    }
                                } else {
                                    if (z) {
                                        bytes = bVar.getString(i5);
                                    } else {
                                        bytes = bVar.getBytes(i5);
                                    }
                                    this.aQa.put(string2, new a.C0727a(i2, i4 + 2, bytes, i5, z));
                                }
                            } else {
                                if (z) {
                                    string = bVar.dJ(i5);
                                } else {
                                    string = bVar.getString(i5);
                                }
                                this.aQa.put(string2, new a.i(i2, i4 + 2, string, i5, z));
                            }
                        }
                    }
                } else if (bVar.position == this.aPY) {
                    return 0;
                } else {
                    g(new Exception("parse dara failed"));
                    return -1;
                }
            } catch (Exception e3) {
                g(e3);
                return -1;
            }
        }
    }

    private void Me() {
        com.kwad.sdk.utils.a.b bVar;
        com.kwad.sdk.utils.a.b bVar2 = this.aPX;
        if (bVar2 != null) {
            this.aPZ ^= bVar2.F(this.aQc, this.aQd);
        }
        if (this.aQj == 0) {
            MappedByteBuffer mappedByteBuffer = this.aPV;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                b(this.aPV);
                this.aPV.putInt(0, this.aPY - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aPW;
            if (mappedByteBuffer2 != null) {
                b(mappedByteBuffer2);
            }
        } else {
            if (this.aQf && (bVar = this.aPX) != null) {
                bVar.D(0, this.aPY - 12);
            }
            com.kwad.sdk.utils.a.b bVar3 = this.aPX;
            if (bVar3 != null) {
                bVar3.g(4, this.aPZ);
            }
        }
        this.aQf = false;
        this.aQe = 0;
        this.aQd = 0;
    }

    private int a(String str, byte[] bArr, byte b2) {
        this.aQg = null;
        if (bArr.length < 2048) {
            return b(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String Mn = h.Mn();
        if (h.a(new File(this.Vz + this.name, Mn), bArr)) {
            this.aQg = Mn;
            byte[] bArr2 = new byte[32];
            Mn.getBytes(0, 32, bArr2, 0);
            return b(str, bArr2, (byte) (b2 | 64));
        }
        gA("save large value failed");
        return 0;
    }

    private Object a(a.h hVar) {
        try {
            byte[] af = h.af(new File(this.Vz + this.name, (String) hVar.value));
            if (af != null) {
                int i = af[0] & 255;
                String str = new String(af, 1, i, com.kwad.sdk.utils.a.b.UTF_8);
                b bVar = this.aPP.get(str);
                if (bVar != null) {
                    int i2 = i + 1;
                    return bVar.g(af, i2, af.length - i2);
                }
                g(new Exception("No encoder for tag:" + str));
                return null;
            }
            g(new Exception("Read object data failed"));
            return null;
        } catch (Exception e2) {
            t(e2);
            return null;
        }
    }

    private void dO(int i) {
        if (this.aPX == null) {
            this.aPX = new com.kwad.sdk.utils.a.b(PAGE_SIZE);
        }
        int length = this.aPX.aPJ.length;
        int i2 = this.aPY + i;
        if (i2 >= length) {
            int i3 = this.aQh;
            if (i3 > i && i3 > Mf()) {
                dP(i);
                return;
            }
            int G = G(length, i2);
            byte[] bArr = new byte[G];
            System.arraycopy(this.aPX.aPJ, 0, bArr, 0, this.aPY);
            this.aPX.aPJ = bArr;
            if (this.aQj == 0) {
                try {
                    long j = G;
                    MappedByteBuffer map = this.aPR.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aPV = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    MappedByteBuffer map2 = this.aPS.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                    this.aPW = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                } catch (Throwable th) {
                    t(new Exception("map failed", th));
                    this.aPX.D(0, this.aPY - 12);
                    this.aPX.g(4, this.aPZ);
                    Mb();
                }
            }
        }
    }

    private void dQ(int i) {
        int i2 = PAGE_SIZE;
        int G = G(i2, i + i2);
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        if (bVar != null) {
            byte[] bArr = bVar.aPJ;
            if (G >= bArr.length) {
                return;
            }
            byte[] bArr2 = new byte[G];
            System.arraycopy(bArr, 0, bArr2, 0, this.aPY);
            this.aPX.aPJ = bArr2;
        }
        if (this.aQj == 0) {
            try {
                long j = G;
                this.aPR.truncate(j);
                MappedByteBuffer map = this.aPR.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aPV = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                this.aPS.truncate(j);
                MappedByteBuffer map2 = this.aPS.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aPW = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
            } catch (Throwable th) {
                t(new Exception("map failed", th));
                Mb();
            }
        }
        info("truncate finish");
    }

    private String a(a.i iVar) {
        byte[] bytes;
        try {
            byte[] af = h.af(new File(this.Vz + this.name, (String) iVar.value));
            String str = new String(af);
            if (af == null || TextUtils.isEmpty(str) || (bytes = com.kwad.sdk.utils.a.b.j(af, com.kwad.sdk.utils.a.b.gw(str)).getBytes()) == null || bytes.length == 0) {
                return "";
            }
            return new String(bytes, com.kwad.sdk.utils.a.b.UTF_8);
        } catch (Exception e2) {
            t(e2);
        }
        return "";
    }

    private boolean ad(File file) {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i = (int) length;
            int G = G(PAGE_SIZE, i);
            com.kwad.sdk.utils.a.b bVar = this.aPX;
            if (bVar != null && bVar.aPJ.length == G) {
                bVar.position = 0;
            } else {
                bVar = new com.kwad.sdk.utils.a.b(new byte[G]);
                this.aPX = bVar;
            }
            h.a(file, bVar.aPJ, i);
            int i2 = bVar.getInt();
            long j = bVar.getLong();
            this.aPY = i2 + 12;
            if (i2 >= 0 && i2 <= i - 12 && j == bVar.F(12, i2) && LW() == 0) {
                this.aPZ = j;
                return true;
            }
        }
        return false;
    }

    private void a(byte b2, int i) {
        long e2 = this.aPZ ^ e(1L, i);
        this.aPZ = e2;
        if (this.aQj == 0) {
            MappedByteBuffer mappedByteBuffer = this.aPV;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e2);
                this.aPV.put(i, b2);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aPW;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aPZ);
                this.aPW.put(i, b2);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aPX;
            if (bVar != null) {
                bVar.g(4, e2);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aPX;
        if (bVar2 != null) {
            bVar2.aPJ[i] = b2;
        }
    }

    private void a(byte b2, int i, int i2) {
        byte[] bArr;
        H(i, i2);
        byte b3 = (byte) (b2 | Byte.MIN_VALUE);
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        if (bVar != null && (bArr = bVar.aPJ) != null) {
            this.aPZ = (((bArr[i] ^ b3) & 255) << ((i & 7) << 3)) ^ this.aPZ;
            bArr[i] = b3;
        }
        this.aQe = i;
    }

    private int b(String str, byte[] bArr, byte b2) {
        a(str, b2, bArr.length + 2);
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        if (bVar != null) {
            bVar.a((short) bArr.length);
            com.kwad.sdk.utils.a.b bVar2 = this.aPX;
            int i = bVar2.position;
            bVar2.n(bArr);
            return i;
        }
        return 0;
    }

    private void a(int i, long j, int i2) {
        long e2 = e(j, i2) ^ this.aPZ;
        this.aPZ = e2;
        if (this.aQj == 0) {
            MappedByteBuffer mappedByteBuffer = this.aPV;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e2);
                this.aPV.putInt(i2, i);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aPW;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aPZ);
                this.aPW.putInt(i2, i);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aPX;
            if (bVar != null) {
                bVar.g(4, e2);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aPX;
        if (bVar2 != null) {
            bVar2.D(i2, i);
        }
    }

    private void b(long j, long j2, int i) {
        long e2 = e(j2, i) ^ this.aPZ;
        this.aPZ = e2;
        if (this.aQj == 0) {
            MappedByteBuffer mappedByteBuffer = this.aPV;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putLong(4, e2);
                this.aPV.putLong(i, j);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aPW;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aPZ);
                this.aPW.putLong(i, j);
            }
        } else {
            com.kwad.sdk.utils.a.b bVar = this.aPX;
            if (bVar != null) {
                bVar.g(4, e2);
            }
        }
        com.kwad.sdk.utils.a.b bVar2 = this.aPX;
        if (bVar2 != null) {
            bVar2.g(i, j);
        }
    }

    private void a(int i, int[] iArr) {
        Map<String, a.b> map = this.aQa;
        if (map == null) {
            return;
        }
        for (a.b bVar : map.values()) {
            int i2 = bVar.offset;
            if (i2 > i) {
                int i3 = iArr[(h.binarySearch(iArr, i2) << 1) + 1];
                bVar.offset -= i3;
                if (bVar.LQ() >= 6) {
                    ((a.j) bVar).start -= i3;
                }
            }
        }
    }

    public static void dN(int i) {
        if (i <= 255) {
            return;
        }
        throw new IllegalArgumentException("key's length must less than 256");
    }

    private void g(Exception exc) {
        d dVar = this.aPQ;
        if (dVar != null) {
            dVar.a(this.name, exc);
        }
    }

    private void gA(String str) {
        d dVar = this.aPQ;
        if (dVar != null) {
            dVar.e(this.name, new Exception(str));
        }
    }

    public static void gz(String str) {
        if (str != null && !str.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException("key is empty");
    }

    private void info(String str) {
        d dVar = this.aPQ;
        if (dVar != null) {
            dVar.i(this.name, str);
        }
    }

    private void t(Throwable th) {
        d dVar = this.aPQ;
        if (dVar != null) {
            dVar.e(this.name, th);
        }
    }

    public final synchronized boolean contains(String str) {
        return this.aQa.containsKey(str);
    }

    public final void putAll(Map<String, Object> map) {
        a(map, (Map<Class, b>) null);
    }

    private void a(String str, byte b2, int i) {
        int gw = com.kwad.sdk.utils.a.b.gw(str);
        dN(gw);
        this.aQd = gw + 2 + i;
        Mg();
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        if (bVar != null) {
            bVar.e(b2);
        }
        u(str, gw);
    }

    public static void a(String str, int i, int i2, byte[] bArr, int i3) {
        int i4;
        if (i2 > str.length() || i2 < 0) {
            return;
        }
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

    private synchronized <T> void a(String str, T t, b<T> bVar) {
        gz(str);
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Encoder is null");
            if (!com.kwad.library.a.a.mc.booleanValue()) {
                t(illegalArgumentException);
                return;
            }
            throw illegalArgumentException;
        }
        String Ml = bVar.Ml();
        if (!Ml.isEmpty() && Ml.length() <= 50) {
            if (!this.aPP.containsKey(Ml)) {
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Encoder hasn't been registered");
                if (!com.kwad.library.a.a.mc.booleanValue()) {
                    t(illegalArgumentException2);
                    return;
                }
                throw illegalArgumentException2;
            } else if (t == null) {
                remove(str);
                return;
            } else {
                byte[] bArr = null;
                try {
                    bArr = bVar.o(t);
                } catch (Exception e2) {
                    t(e2);
                }
                if (bArr == null) {
                    remove(str);
                    return;
                }
                int gw = com.kwad.sdk.utils.a.b.gw(Ml);
                com.kwad.sdk.utils.a.b bVar2 = new com.kwad.sdk.utils.a.b(gw + 1 + bArr.length);
                bVar2.e((byte) gw);
                bVar2.gv(Ml);
                bVar2.n(bArr);
                a(str, t, bVar2.aPJ, (a.h) this.aQa.get(str), (byte) 8);
                return;
            }
        }
        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Invalid encoder tag:" + Ml);
        if (!com.kwad.library.a.a.mc.booleanValue()) {
            t(illegalArgumentException3);
            return;
        }
        throw illegalArgumentException3;
    }

    private void a(String str, Object obj, byte[] bArr, byte b2) {
        boolean z;
        String str2;
        int length;
        a.b hVar;
        int a2 = a(str, bArr, b2);
        if (a2 != 0) {
            if (this.aQg != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                String str3 = this.aQg;
                this.aQg = null;
                str2 = str3;
                length = 32;
            } else {
                str2 = obj;
                length = bArr.length;
            }
            if (b2 == 6) {
                hVar = new a.i(this.aQc, a2, (String) str2, length, z);
            } else if (b2 == 7) {
                hVar = new a.C0727a(this.aQc, a2, str2, length, z);
            } else {
                hVar = new a.h(this.aQc, a2, str2, length, z);
            }
            this.aQa.put(str, hVar);
            Me();
        }
    }

    private void a(String str, Object obj, byte[] bArr, a.j jVar, byte b2) {
        if (jVar == null) {
            a(str, obj, bArr, b2);
        } else if (!jVar.aPH && jVar.aPG == bArr.length) {
            updateBytes(jVar.offset, bArr);
            jVar.value = obj;
        } else {
            a(str, obj, bArr, jVar);
        }
        LX();
    }

    private void a(String str, String str2, a.i iVar) {
        int gw = com.kwad.sdk.utils.a.b.gw(str2);
        if (iVar == null) {
            int gw2 = com.kwad.sdk.utils.a.b.gw(str);
            dN(gw2);
            int i = gw2 + 4;
            this.aQd = i + gw;
            Mg();
            com.kwad.sdk.utils.a.b bVar = this.aPX;
            if (bVar != null) {
                bVar.e((byte) 6);
            }
            u(str, gw2);
            v(str2, gw);
            Map<String, a.b> map = this.aQa;
            int i2 = this.aQc;
            map.put(str, new a.i(i2, i2 + i, str2, gw, false));
            Me();
        } else {
            String str3 = null;
            int i3 = iVar.offset;
            int i4 = i3 - iVar.start;
            int i5 = iVar.aPG;
            boolean z = true;
            if (i5 == gw) {
                this.aPZ = this.aPX.F(i3, i5) ^ this.aPZ;
                if (gw == str2.length()) {
                    a(str2, 0, gw, this.aPX.aPJ, iVar.offset);
                } else {
                    com.kwad.sdk.utils.a.b bVar2 = this.aPX;
                    if (bVar2 != null) {
                        bVar2.position = iVar.offset;
                        bVar2.gv(str2);
                    }
                }
                this.aQc = iVar.offset;
                this.aQd = gw;
                z = false;
            } else {
                this.aQd = i4 + gw;
                Mg();
                com.kwad.sdk.utils.a.b bVar3 = this.aPX;
                if (bVar3 != null) {
                    bVar3.e((byte) 6);
                }
                int i6 = i4 - 3;
                com.kwad.sdk.utils.a.b bVar4 = this.aPX;
                if (bVar4 != null) {
                    byte[] bArr = bVar4.aPJ;
                    System.arraycopy(bArr, iVar.start + 1, bArr, bVar4.position, i6);
                }
                com.kwad.sdk.utils.a.b bVar5 = this.aPX;
                if (bVar5 != null) {
                    bVar5.position += i6;
                }
                v(str2, gw);
                a((byte) 6, iVar.start, iVar.offset + iVar.aPG);
                if (iVar.aPH) {
                    str3 = (String) iVar.value;
                }
                iVar.aPH = false;
                int i7 = this.aQc;
                iVar.start = i7;
                iVar.offset = i7 + i4;
                iVar.aPG = gw;
            }
            iVar.value = str2;
            Me();
            if (z) {
                Mh();
            }
            if (str3 != null) {
                h.h(new File(this.Vz + this.name, str3));
            }
        }
        LX();
    }

    private void a(MappedByteBuffer mappedByteBuffer) {
        FileChannel fileChannel;
        if (mappedByteBuffer == null) {
            return;
        }
        if (mappedByteBuffer.capacity() != PAGE_SIZE) {
            if (mappedByteBuffer == this.aPV) {
                fileChannel = this.aPR;
            } else {
                fileChannel = this.aPS;
            }
            FileChannel fileChannel2 = fileChannel;
            if (fileChannel2 == null) {
                return;
            }
            fileChannel2.truncate(PAGE_SIZE);
            MappedByteBuffer map = fileChannel2.map(FileChannel.MapMode.READ_WRITE, 0L, PAGE_SIZE);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aPV) {
                this.aPV = map;
            } else {
                this.aPW = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void b(MappedByteBuffer mappedByteBuffer) {
        if (mappedByteBuffer == null) {
            return;
        }
        if (this.aQf && mappedByteBuffer != this.aPV) {
            mappedByteBuffer.putInt(0, this.aPY - 12);
        }
        mappedByteBuffer.putLong(4, this.aPZ);
        int i = this.aQe;
        if (i != 0) {
            mappedByteBuffer.put(i, this.aPX.aPJ[i]);
        }
        if (this.aQd != 0) {
            mappedByteBuffer.position(this.aQc);
            mappedByteBuffer.put(this.aPX.aPJ, this.aQc, this.aQd);
        }
    }

    private void a(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        FileChannel fileChannel;
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                if (mappedByteBuffer2 == this.aPW) {
                    fileChannel = this.aPS;
                } else {
                    fileChannel = this.aPR;
                }
                MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.aPW) {
                    this.aPW = map;
                } else {
                    this.aPV = map;
                }
                mappedByteBuffer2 = map;
            } catch (Exception e2) {
                t(e2);
                Mb();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private synchronized void a(Map<String, Object> map, Map<Class, b> map2) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    b(key, (byte[]) value);
                } else {
                    g(new Exception("missing encoders"));
                }
            }
        }
    }

    private boolean a(com.kwad.sdk.utils.a.b bVar) {
        int length = bVar.aPJ.length;
        File file = new File(this.Vz, this.name + ".kva");
        File file2 = new File(this.Vz, this.name + ".kvb");
        try {
            if (h.ae(file) && h.ae(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j = length;
                randomAccessFile.setLength(j);
                randomAccessFile2.setLength(j);
                this.aPR = randomAccessFile.getChannel();
                this.aPS = randomAccessFile2.getChannel();
                MappedByteBuffer map = this.aPR.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aPV = map;
                map.order(ByteOrder.LITTLE_ENDIAN);
                MappedByteBuffer map2 = this.aPS.map(FileChannel.MapMode.READ_WRITE, 0L, j);
                this.aPW = map2;
                map2.order(ByteOrder.LITTLE_ENDIAN);
                this.aPV.put(bVar.aPJ, 0, this.aPY);
                this.aPW.put(bVar.aPJ, 0, this.aPY);
                return true;
            }
            throw new Exception("open file failed");
        } catch (Exception e2) {
            t(e2);
            return false;
        }
    }

    public final synchronized void remove(String str) {
        a.b bVar = this.aQa.get(str);
        if (bVar != null) {
            this.aQa.remove(str);
            byte LQ = bVar.LQ();
            String str2 = null;
            if (LQ <= 5) {
                a(LQ, bVar.offset - (com.kwad.sdk.utils.a.b.gw(str) + 2), bVar.offset + aPK[LQ]);
            } else {
                a.j jVar = (a.j) bVar;
                a(LQ, jVar.start, jVar.offset + jVar.aPG);
                if (jVar.aPH) {
                    str2 = (String) jVar.value;
                }
            }
            byte b2 = (byte) (LQ | Byte.MIN_VALUE);
            if (this.aQj == 0) {
                if (this.aPV != null) {
                    this.aPV.putLong(4, this.aPZ);
                    this.aPV.put(this.aQe, b2);
                }
                if (this.aPW != null) {
                    this.aPW.putLong(4, this.aPZ);
                    this.aPW.put(this.aQe, b2);
                }
            } else if (this.aPX != null) {
                this.aPX.g(4, this.aPZ);
            }
            this.aQe = 0;
            if (str2 != null) {
                h.h(new File(this.Vz + this.name, str2));
            }
            Mh();
            LX();
        }
    }

    private byte[] a(a.C0727a c0727a) {
        try {
            byte[] af = h.af(new File(this.Vz + this.name, (String) c0727a.value));
            if (af != null) {
                return af;
            }
            return aPL;
        } catch (Exception e2) {
            t(e2);
            return aPL;
        }
    }

    private void dP(int i) {
        boolean z;
        int i2;
        int i3;
        ArrayList<e> arrayList = this.aQi;
        if (arrayList == null || this.aPX == null) {
            return;
        }
        Collections.sort(arrayList);
        Mi();
        e eVar = this.aQi.get(0);
        int i4 = eVar.start;
        int i5 = this.aPY;
        int i6 = i5 - this.aQh;
        int i7 = i6 - 12;
        int i8 = i6 - i4;
        int i9 = i5 - i4;
        if (i7 < i9 + i8) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            this.aPZ ^= this.aPX.F(i4, i9);
        }
        int size = this.aQi.size();
        int i10 = size - 1;
        int i11 = this.aPY - this.aQi.get(i10).end;
        if (i11 > 0) {
            i2 = size;
        } else {
            i2 = i10;
        }
        int[] iArr = new int[i2 << 1];
        int i12 = eVar.start;
        int i13 = eVar.end;
        for (int i14 = 1; i14 < size; i14++) {
            e eVar2 = this.aQi.get(i14);
            int i15 = eVar2.start - i13;
            byte[] bArr = this.aPX.aPJ;
            System.arraycopy(bArr, i13, bArr, i12, i15);
            int i16 = (i14 - 1) << 1;
            iArr[i16] = i13;
            iArr[i16 + 1] = i13 - i12;
            i12 += i15;
            i13 = eVar2.end;
        }
        if (i11 > 0) {
            byte[] bArr2 = this.aPX.aPJ;
            System.arraycopy(bArr2, i13, bArr2, i12, i11);
            int i17 = i10 << 1;
            iArr[i17] = i13;
            iArr[i17 + 1] = i13 - i12;
        }
        Mj();
        if (z) {
            this.aPZ = this.aPX.F(12, i7);
        } else {
            this.aPZ ^= this.aPX.F(i4, i8);
        }
        this.aPY = i6;
        if (this.aQj == 0) {
            MappedByteBuffer mappedByteBuffer = this.aPV;
            if (mappedByteBuffer != null) {
                i3 = 0;
                mappedByteBuffer.putInt(0, -1);
                this.aPV.putLong(4, this.aPZ);
                this.aPV.position(i4);
                this.aPV.put(this.aPX.aPJ, i4, i8);
                this.aPV.putInt(0, i7);
            } else {
                i3 = 0;
            }
            MappedByteBuffer mappedByteBuffer2 = this.aPW;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putInt(i3, i7);
                this.aPW.putLong(4, this.aPZ);
                this.aPW.position(i4);
                this.aPW.put(this.aPX.aPJ, i4, i8);
            }
        } else {
            this.aPX.D(0, i7);
            this.aPX.g(4, this.aPZ);
        }
        a(i4, iArr);
        int i18 = i6 + i;
        if (this.aPX.aPJ.length - i18 > aPO) {
            dQ(i18);
        }
        info("gc finish");
    }

    private synchronized void putDouble(String str, double d2) {
        gz(str);
        a.d dVar = (a.d) this.aQa.get(str);
        if (dVar == null) {
            a(str, (byte) 5);
            if (this.aPX != null) {
                int i = this.aPX.position;
                this.aPX.az(Double.doubleToRawLongBits(d2));
                Me();
                if (this.aQa != null) {
                    this.aQa.put(str, new a.d(i, d2));
                }
            }
            LX();
            return;
        }
        if (dVar.value != d2) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d2);
            dVar.value = d2;
            b(doubleToRawLongBits, Double.doubleToRawLongBits(dVar.value) ^ doubleToRawLongBits, dVar.offset);
            LX();
        }
    }

    private synchronized void putFloat(String str, float f) {
        gz(str);
        a.e eVar = (a.e) this.aQa.get(str);
        if (eVar == null) {
            a(str, (byte) 3);
            if (this.aPX != null) {
                int i = this.aPX.position;
                this.aPX.dG(Float.floatToRawIntBits(f));
                Me();
                if (this.aQa != null) {
                    this.aQa.put(str, new a.e(i, f));
                }
            }
            LX();
            return;
        }
        if (eVar.value != f) {
            int floatToRawIntBits = Float.floatToRawIntBits(f);
            eVar.value = f;
            a(floatToRawIntBits, (Float.floatToRawIntBits(eVar.value) ^ floatToRawIntBits) & 4294967295L, eVar.offset);
            LX();
        }
    }

    public final synchronized void putBoolean(String str, boolean z) {
        gz(str);
        a.c cVar = (a.c) this.aQa.get(str);
        int i = 0;
        if (cVar == null) {
            a(str, (byte) 1);
            if (this.aPX != null) {
                int i2 = this.aPX.position;
                com.kwad.sdk.utils.a.b bVar = this.aPX;
                if (z) {
                    i = 1;
                }
                bVar.e((byte) i);
                Me();
                if (this.aQa != null) {
                    this.aQa.put(str, new a.c(i2, z));
                }
            }
            LX();
            return;
        }
        if (cVar.value != z) {
            cVar.value = z;
            if (z) {
                i = 1;
            }
            a((byte) i, cVar.offset);
            LX();
        }
    }

    public final synchronized void putInt(String str, int i) {
        gz(str);
        a.f fVar = (a.f) this.aQa.get(str);
        if (fVar == null) {
            a(str, (byte) 2);
            if (this.aPX != null) {
                int i2 = this.aPX.position;
                this.aPX.dG(i);
                Me();
                if (this.aQa != null) {
                    this.aQa.put(str, new a.f(i2, i));
                }
            }
            LX();
            return;
        }
        if (fVar.value != i) {
            fVar.value = i;
            a(i, (fVar.value ^ i) & 4294967295L, fVar.offset);
            LX();
        }
    }

    public final synchronized void putLong(String str, long j) {
        gz(str);
        a.g gVar = (a.g) this.aQa.get(str);
        if (gVar == null) {
            a(str, (byte) 4);
            if (this.aPX != null) {
                int i = this.aPX.position;
                this.aPX.az(j);
                Me();
                if (this.aQa != null) {
                    this.aQa.put(str, new a.g(i, j));
                }
            }
            LX();
            return;
        }
        if (gVar.value != j) {
            gVar.value = j;
            b(j, j ^ gVar.value, gVar.offset);
            LX();
        }
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        com.kwad.sdk.utils.a.b bVar = this.aPX;
        if (bVar != null) {
            this.aPZ ^= bVar.F(i, length);
            com.kwad.sdk.utils.a.b bVar2 = this.aPX;
            bVar2.position = i;
            bVar2.n(bArr);
            this.aPZ ^= this.aPX.F(i, length);
        }
        if (this.aQj == 0) {
            MappedByteBuffer mappedByteBuffer = this.aPV;
            if (mappedByteBuffer != null) {
                mappedByteBuffer.putInt(0, -1);
                this.aPV.putLong(4, this.aPZ);
                this.aPV.position(i);
                this.aPV.put(bArr);
                this.aPV.putInt(0, this.aPY - 12);
            }
            MappedByteBuffer mappedByteBuffer2 = this.aPW;
            if (mappedByteBuffer2 != null) {
                mappedByteBuffer2.putLong(4, this.aPZ);
                this.aPW.position(i);
                this.aPW.put(bArr);
                return;
            }
            return;
        }
        com.kwad.sdk.utils.a.b bVar3 = this.aPX;
        if (bVar3 != null) {
            bVar3.g(4, this.aPZ);
        }
    }

    public final synchronized void putString(String str, String str2) {
        byte[] gy;
        byte[] bArr;
        byte[] bArr2;
        gz(str);
        if (str2 == null) {
            remove(str);
            return;
        }
        a.i iVar = (a.i) this.aQa.get(str);
        if (str2.length() * 3 < 2048) {
            a(str, str2, iVar);
            return;
        }
        if (str2.isEmpty()) {
            gy = aPL;
        } else {
            if (iVar == null && str2.length() < 2048) {
                int gw = com.kwad.sdk.utils.a.b.gw(str2);
                bArr = new byte[gw];
                if (gw == str2.length()) {
                    a(str2, 0, gw, bArr, 0);
                    bArr2 = bArr;
                } else {
                    gy = com.kwad.sdk.utils.a.b.gy(str2);
                }
            } else if (iVar != null && !iVar.aPH) {
                int gw2 = com.kwad.sdk.utils.a.b.gw(str2);
                bArr = new byte[gw2];
                if (gw2 == str2.length()) {
                    a(str2, 0, gw2, bArr, 0);
                    bArr2 = bArr;
                } else {
                    gy = com.kwad.sdk.utils.a.b.gy(str2);
                }
            } else {
                gy = com.kwad.sdk.utils.a.b.gy(str2);
            }
            a(str, str2, bArr2, iVar, (byte) 6);
        }
        bArr2 = gy;
        a(str, str2, bArr2, iVar, (byte) 6);
    }
}
