package com.github.a.a;
/* loaded from: classes6.dex */
public class h extends a {
    private int mPid;
    private StringBuffer pGJ;
    private long pGK;
    private long pGL;

    @Override // com.github.a.a.a
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    public h(long j) {
        super(j);
        this.pGJ = new StringBuffer();
        this.mPid = 0;
        this.pGK = 0L;
        this.pGL = 0L;
    }

    @Override // com.github.a.a.a
    public void start() {
        super.start();
        reset();
    }

    public String getCpuRateInfo() {
        return this.pGJ.toString();
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
    protected void eyc() {
        /*
            r8 = this;
            r2 = 0
            java.lang.StringBuffer r0 = r8.pGJ
            r1 = 0
            r0.setLength(r1)
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L7f
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L7f
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = "/proc/stat"
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L7f
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L7f
            r1 = 1000(0x3e8, float:1.401E-42)
            r3.<init>(r0, r1)     // Catch: java.lang.Throwable -> L7f
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> Lbf
            if (r0 != 0) goto Lc4
            java.lang.String r0 = ""
            r4 = r0
        L25:
            int r0 = r8.mPid     // Catch: java.lang.Throwable -> Lbf
            if (r0 != 0) goto L2f
            int r0 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> Lbf
            r8.mPid = r0     // Catch: java.lang.Throwable -> Lbf
        L2f:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lbf
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lbf
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r6.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r7 = "/proc/"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Lbf
            int r7 = r8.mPid     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r7 = "/stat"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Lbf
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lbf
            r0.<init>(r5)     // Catch: java.lang.Throwable -> Lbf
            r5 = 1000(0x3e8, float:1.401E-42)
            r1.<init>(r0, r5)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> Lc2
            if (r0 != 0) goto L66
            java.lang.String r0 = ""
        L66:
            r8.ho(r4, r0)     // Catch: java.lang.Throwable -> Lc2
            if (r3 == 0) goto L6e
            r3.close()     // Catch: java.io.IOException -> L74
        L6e:
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.io.IOException -> L74
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
            r1 = r2
            r3 = r2
        L82:
            java.lang.String r2 = "SampleCpuSampler"
            java.lang.String r4 = "doSample: "
            android.util.Log.e(r2, r4, r0)     // Catch: java.lang.Throwable -> Lbd
            if (r3 == 0) goto L90
            r3.close()     // Catch: java.io.IOException -> L96
        L90:
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.io.IOException -> L96
            goto L73
        L96:
            r0 = move-exception
            java.lang.String r1 = "SampleCpuSampler"
            java.lang.String r2 = "doSample: "
            android.util.Log.e(r1, r2, r0)
            goto L73
        La1:
            r0 = move-exception
            r1 = r2
            r3 = r2
        La4:
            if (r3 == 0) goto La9
            r3.close()     // Catch: java.io.IOException -> Laf
        La9:
            if (r1 == 0) goto Lae
            r1.close()     // Catch: java.io.IOException -> Laf
        Lae:
            throw r0
        Laf:
            r1 = move-exception
            java.lang.String r2 = "SampleCpuSampler"
            java.lang.String r3 = "doSample: "
            android.util.Log.e(r2, r3, r1)
            goto Lae
        Lba:
            r0 = move-exception
            r1 = r2
            goto La4
        Lbd:
            r0 = move-exception
            goto La4
        Lbf:
            r0 = move-exception
            r1 = r2
            goto L82
        Lc2:
            r0 = move-exception
            goto L82
        Lc4:
            r4 = r0
            goto L25
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.a.a.h.eyc():void");
    }

    private void reset() {
        this.pGK = 0L;
        this.pGL = 0L;
    }

    private void ho(String str, String str2) {
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
                    long j = parseLong6 - this.pGL;
                    this.pGJ.append(((j - (parseLong4 - this.pGK)) * 100) / j);
                }
                this.pGK = parseLong4;
                this.pGL = parseLong6;
            }
        }
    }
}
