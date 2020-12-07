package com.github.a.a;
/* loaded from: classes7.dex */
public class h extends a {
    private int mPid;
    private StringBuffer psx;
    private long psy;
    private long psz;

    @Override // com.github.a.a.a
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public h(long j) {
        super(j);
        this.psx = new StringBuffer();
        this.mPid = 0;
        this.psy = 0L;
        this.psz = 0L;
    }

    @Override // com.github.a.a.a
    public void start() {
        super.start();
        reset();
    }

    public String getCpuRateInfo() {
        return this.psx.toString();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.github.a.a.a
    protected void exE() {
        /*
            r8 = this;
            r1 = 0
            java.lang.StringBuffer r0 = r8.psx
            r2 = 0
            r0.setLength(r2)
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L7f
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L7f
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = "/proc/stat"
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L7f
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L7f
            r2 = 1000(0x3e8, float:1.401E-42)
            r3.<init>(r0, r2)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> Lc0
            if (r0 != 0) goto Lc7
            java.lang.String r0 = ""
            r4 = r0
        L25:
            int r0 = r8.mPid     // Catch: java.lang.Throwable -> Lc0
            if (r0 != 0) goto L2f
            int r0 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> Lc0
            r8.mPid = r0     // Catch: java.lang.Throwable -> Lc0
        L2f:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lc0
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lc0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lc0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc0
            r6.<init>()     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r7 = "/proc/"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Lc0
            int r7 = r8.mPid     // Catch: java.lang.Throwable -> Lc0
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r7 = "/stat"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lc0
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lc0
            r0.<init>(r5)     // Catch: java.lang.Throwable -> Lc0
            r5 = 1000(0x3e8, float:1.401E-42)
            r2.<init>(r0, r5)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> Lc3
            if (r0 != 0) goto L66
            java.lang.String r0 = ""
        L66:
            r8.hj(r4, r0)     // Catch: java.lang.Throwable -> Lc3
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.io.IOException -> L74
        L6e:
            if (r2 == 0) goto L73
            r2.close()     // Catch: java.io.IOException -> L74
        L73:
            return
        L74:
            r0 = move-exception
            java.lang.String r1 = "SampleCpuSampler"
            java.lang.String r2 = "doSample: "
            android.util.Log.e(r1, r2, r0)
            goto L73
        L7f:
            r0 = move-exception
            r2 = r1
        L81:
            java.lang.String r3 = "SampleCpuSampler"
            java.lang.String r4 = "doSample: "
            android.util.Log.e(r3, r4, r0)     // Catch: java.lang.Throwable -> Lbd
            if (r2 == 0) goto L8f
            r2.close()     // Catch: java.io.IOException -> L95
        L8f:
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.io.IOException -> L95
            goto L73
        L95:
            r0 = move-exception
            java.lang.String r1 = "SampleCpuSampler"
            java.lang.String r2 = "doSample: "
            android.util.Log.e(r1, r2, r0)
            goto L73
        La0:
            r0 = move-exception
            r3 = r1
        La2:
            if (r3 == 0) goto La7
            r3.close()     // Catch: java.io.IOException -> Lad
        La7:
            if (r1 == 0) goto Lac
            r1.close()     // Catch: java.io.IOException -> Lad
        Lac:
            throw r0
        Lad:
            r1 = move-exception
            java.lang.String r2 = "SampleCpuSampler"
            java.lang.String r3 = "doSample: "
            android.util.Log.e(r2, r3, r1)
            goto Lac
        Lb8:
            r0 = move-exception
            goto La2
        Lba:
            r0 = move-exception
            r1 = r2
            goto La2
        Lbd:
            r0 = move-exception
            r3 = r2
            goto La2
        Lc0:
            r0 = move-exception
            r2 = r3
            goto L81
        Lc3:
            r0 = move-exception
            r1 = r2
            r2 = r3
            goto L81
        Lc7:
            r4 = r0
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.a.a.h.exE():void");
    }

    private void reset() {
        this.psy = 0L;
        this.psz = 0L;
    }

    private void hj(String str, String str2) {
        String[] split = str.split(" ");
        if (split.length >= 9) {
            long parseLong = Long.parseLong(split[2]);
            long parseLong2 = Long.parseLong(split[3]);
            long parseLong3 = Long.parseLong(split[4]);
            long parseLong4 = Long.parseLong(split[5]);
            long parseLong5 = Long.parseLong(split[8]);
            long parseLong6 = parseLong5 + parseLong + parseLong2 + parseLong3 + parseLong4 + Long.parseLong(split[6]) + Long.parseLong(split[7]);
            if (str2.split(" ").length >= 17) {
                if (parseLong6 != 0) {
                    long j = parseLong6 - this.psz;
                    this.psx.append(((j - (parseLong4 - this.psy)) * 100) / j);
                }
                this.psy = parseLong4;
                this.psz = parseLong6;
            }
        }
    }
}
