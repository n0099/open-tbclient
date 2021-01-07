package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.kwai.video.player.NativeErrorCode;
import com.tencent.turingfd.sdk.ams.au.ad;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public class an {

    /* renamed from: a  reason: collision with root package name */
    public static an f13775a = new an();

    /* renamed from: b  reason: collision with root package name */
    public static long f13776b = TimeUnit.MINUTES.toMillis(30);
    public static int[] c = {0, 15, 30, 90, 240, EncoderTextureDrawer.X264_WIDTH, 600, FeatureCodes.FACE, 2400, 3200, 4800, 7200};
    public aq d;
    public Handler e;
    public c g;
    public boolean f = false;
    public final Object h = new Object();
    public final AtomicReference<ap> i = new AtomicReference<>(null);
    public final AtomicReference<Boolean> j = new AtomicReference<>(false);

    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f13777a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f13778b;

        public a(Context context, boolean z) {
            this.f13777a = context;
            this.f13778b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            an.this.b(this.f13777a, this.f13778b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Context f13779a;

        public b(Looper looper, Context context) {
            super(looper);
            this.f13779a = context;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            System.currentTimeMillis();
            int i = message.what;
            if (i == 1) {
                an.this.c(this.f13779a, true);
            } else if (i != 2) {
            } else {
                an.this.a(an.this.a(this.f13779a, true, false, true), false);
                synchronized (an.this.j) {
                    an.this.j.set(false);
                    an.this.j.notifyAll();
                }
            }
        }
    }

    public final int a(ap apVar) {
        if (apVar.d != 0 || TextUtils.isEmpty(apVar.f13784b)) {
            return 2;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis < apVar.c) {
            return Math.abs(currentTimeMillis - this.g.c(aj.a(), "108")) < this.g.c(aj.a()) ? 1 : 3;
        }
        return 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7 A[Catch: all -> 0x00da, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x002a, B:8:0x002f, B:9:0x0035, B:12:0x0041, B:15:0x004a, B:18:0x0054, B:20:0x005d, B:22:0x00b7, B:23:0x00bf, B:31:0x00d1), top: B:37:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d1 A[Catch: all -> 0x00da, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:5:0x0005, B:7:0x002a, B:8:0x002f, B:9:0x0035, B:12:0x0041, B:15:0x004a, B:18:0x0054, B:20:0x005d, B:22:0x00b7, B:23:0x00bf, B:31:0x00d1), top: B:37:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long a(Context context, int i, boolean z) {
        long currentTimeMillis;
        boolean a2;
        synchronized (this) {
            if (z) {
                long currentTimeMillis2 = System.currentTimeMillis();
                if (f.f13822a.a(context, i, this.d.a(), this.g.c(context, TbEnum.SystemMessage.EVENT_ID_UPLOAD_STAT), this.g.b(context).f13784b)) {
                    this.g.l(context);
                }
                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
            } else {
                currentTimeMillis = 0;
            }
            s n = this.d.n();
            if (n != null) {
                try {
                    a2 = n.a();
                } catch (Throwable th) {
                }
                f fVar = f.f13822a;
                fVar.a(u.c.aO, !a2 ? 1 : 0);
                fVar.a(u.g.aO, !a2 ? 1 : 0);
                fVar.a(u.r.aO, a2 ? 1 : 0);
                fVar.a(u.K.aO, this.d.o() ? 1 : 0);
                fVar.b(u.s.aO, z ? 1 : 0);
                fVar.b(u.u.aO, z ? 1 : 0);
                fVar.b(u.w.aO, z ? 1 : 0);
                fVar.b(u.S.aO, z ? 1 : 0);
                fVar.b(u.T.aO, z ? 1 : 0);
                fVar.b(u.Y.aO, z ? 1 : 0);
                fVar.b(u.af.aO, z ? 1 : 0);
                fVar.b(u.ag.aO, z ? 1 : 0);
                fVar.b(u.r.aO, 1);
                fVar.b(u.O.aO, 1);
                if (z) {
                    fVar.b(u.R.aO, 0);
                } else {
                    fVar.b(u.R.aO, 1);
                }
                f.f13822a.a(context);
            }
            a2 = true;
            f fVar2 = f.f13822a;
            fVar2.a(u.c.aO, !a2 ? 1 : 0);
            fVar2.a(u.g.aO, !a2 ? 1 : 0);
            fVar2.a(u.r.aO, a2 ? 1 : 0);
            fVar2.a(u.K.aO, this.d.o() ? 1 : 0);
            fVar2.b(u.s.aO, z ? 1 : 0);
            fVar2.b(u.u.aO, z ? 1 : 0);
            fVar2.b(u.w.aO, z ? 1 : 0);
            fVar2.b(u.S.aO, z ? 1 : 0);
            fVar2.b(u.T.aO, z ? 1 : 0);
            fVar2.b(u.Y.aO, z ? 1 : 0);
            fVar2.b(u.af.aO, z ? 1 : 0);
            fVar2.b(u.ag.aO, z ? 1 : 0);
            fVar2.b(u.r.aO, 1);
            fVar2.b(u.O.aO, 1);
            if (z) {
            }
            f.f13822a.a(context);
        }
        return currentTimeMillis;
    }

    public final ap a(Context context) {
        ap apVar;
        synchronized (this.i) {
            apVar = this.i.get();
            if (apVar == null) {
                apVar = this.g.b(context);
                this.i.set(apVar);
            }
        }
        return apVar;
    }

    public ap a(Context context, boolean z) {
        return c(context, z);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public final com.tencent.turingfd.sdk.ams.au.ap a(android.content.Context r23, boolean r24, boolean r25) {
        /*
            r22 = this;
            r4 = 1
            r0 = r22
            r1 = r23
            r2 = r24
            long r12 = r0.a(r1, r4, r2)
            long r14 = java.lang.System.currentTimeMillis()
            int r4 = com.tencent.turingfd.sdk.ams.au.bh.c(r23)
            r5 = 10
            if (r4 < r5) goto L2f
            r4 = 1
        L18:
            if (r4 == 0) goto L31
            r4 = -10005(0xffffffffffffd8eb, float:NaN)
            com.tencent.turingfd.sdk.ams.au.a r4 = com.tencent.turingfd.sdk.ams.au.a.a(r4)
        L20:
            int r5 = r4.a()
            if (r5 == 0) goto L9ae
            int r4 = r4.a()
            com.tencent.turingfd.sdk.ams.au.ap r4 = com.tencent.turingfd.sdk.ams.au.ap.a(r4)
        L2e:
            return r4
        L2f:
            r4 = 0
            goto L18
        L31:
            r4 = 1
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.aq r5 = r0.d
            com.tencent.turingfd.sdk.ams.au.s r5 = r5.n()
            if (r5 == 0) goto L40
            boolean r4 = r5.a()     // Catch: java.lang.Throwable -> Lb8f
        L40:
            java.util.Map<java.lang.Integer, java.lang.Long> r5 = com.tencent.turingfd.sdk.ams.au.i.f13829a
            r5.clear()
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.lang.String r6 = ""
            java.lang.StringBuilder r6 = com.tencent.turingfd.sdk.ams.au.ab.a(r6)
            int r7 = com.tencent.turingfd.sdk.ams.au.af.f13767a
            java.lang.String r8 = "1"
            com.tencent.turingfd.sdk.ams.au.ab.a(r6, r7, r5, r8)
            java.lang.String r6 = "101"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.aq r7 = r0.d
            java.lang.String r7 = r7.a()
            r5.put(r6, r7)
            java.lang.String r6 = "207"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r7 = r0.g
            r0 = r23
            com.tencent.turingfd.sdk.ams.au.ap r7 = r7.b(r0)
            java.lang.String r7 = r7.f13784b
            r5.put(r6, r7)
            java.lang.String r6 = "209"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.aq r7 = r0.d
            java.lang.String r7 = r7.h()
            r5.put(r6, r7)
            java.lang.String r6 = "210"
            r7 = 1
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.aq r8 = r0.d
            boolean r8 = r8.o()
            r0 = r23
            r1 = r24
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.h.a(r0, r1, r7, r4, r8)
            r5.put(r6, r4)
            java.lang.String r4 = "2001"
            com.tencent.turingfd.sdk.ams.au.f r6 = com.tencent.turingfd.sdk.ams.au.f.f13822a
            java.lang.String r6 = r6.a()
            r5.put(r4, r6)
            if (r24 == 0) goto Lb5
            java.lang.String r4 = "1001"
            java.lang.String r6 = "1"
            r5.put(r4, r6)
        Lb5:
            com.tencent.turingfd.sdk.ams.au.f r11 = com.tencent.turingfd.sdk.ams.au.f.f13822a
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.P
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 != 0) goto L17f
            java.lang.String r4 = "2003"
            java.lang.String r6 = "0"
            r5.put(r4, r6)
        Lca:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.c
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto Lf7
            long r8 = java.lang.System.currentTimeMillis()
            java.lang.String r7 = ""
            java.lang.String r4 = "phone"
            r0 = r23
            java.lang.Object r4 = r0.getSystemService(r4)     // Catch: java.lang.Throwable -> Lb98
            android.telephony.TelephonyManager r4 = (android.telephony.TelephonyManager) r4     // Catch: java.lang.Throwable -> Lb98
            java.lang.String r7 = r4.getDeviceId()     // Catch: java.lang.Throwable -> Lb98
        Lea:
            if (r7 != 0) goto Lef
            java.lang.String r7 = ""
        Lef:
            java.lang.String r6 = "260"
            r10 = 21
            com.tencent.turingfd.sdk.ams.au.ab.a(r5, r6, r7, r8, r10)
        Lf7:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.w
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L11c
            java.lang.String r4 = "205"
            java.lang.String r6 = com.tencent.turingfd.sdk.ams.au.bi.a(r23)
            r5.put(r4, r6)
            r4 = 8
            java.lang.String r6 = com.tencent.turingfd.sdk.ams.au.bi.b()
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            long r6 = r6.longValue()
            com.tencent.turingfd.sdk.ams.au.i.a(r4, r6)
        L11c:
            com.tencent.turingfd.sdk.ams.au.f r11 = com.tencent.turingfd.sdk.ams.au.f.f13822a
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.N
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L138
            java.lang.String r4 = "239"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r6 = r0.g
            r0 = r23
            java.lang.String r6 = r6.j(r0)
            r5.put(r4, r6)
        L138:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.S
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L245
            long r8 = java.lang.System.currentTimeMillis()
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            int[] r4 = com.tencent.turingfd.sdk.ams.au.y.n     // Catch: java.lang.Throwable -> L202
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.y.a(r4)     // Catch: java.lang.Throwable -> L202
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> L202
            byte[] r4 = com.tencent.turingfd.sdk.ams.au.aj.b(r4)     // Catch: java.lang.Throwable -> L202
            r7.<init>(r4)     // Catch: java.lang.Throwable -> L202
            java.lang.String r4 = "\\n"
            java.lang.String[] r7 = r7.split(r4)     // Catch: java.lang.Throwable -> L202
            java.lang.String r10 = r23.getPackageName()     // Catch: java.lang.Throwable -> L202
            int r0 = r7.length     // Catch: java.lang.Throwable -> L202
            r16 = r0
            r4 = 0
        L169:
            r0 = r16
            if (r4 >= r0) goto L203
            r17 = r7[r4]     // Catch: java.lang.Throwable -> L202
            r0 = r17
            java.lang.String r17 = com.tencent.turingfd.sdk.ams.au.aj.a(r0, r10)     // Catch: java.lang.Throwable -> L202
            if (r17 == 0) goto L17c
            r0 = r17
            r6.add(r0)     // Catch: java.lang.Throwable -> L202
        L17c:
            int r4 = r4 + 1
            goto L169
        L17f:
            long r6 = java.lang.System.currentTimeMillis()
            com.tencent.turingfd.sdk.ams.au.n r4 = com.tencent.turingfd.sdk.ams.au.m.f13835b
            if (r4 == 0) goto L1b5
            int r4 = r4.a()
            if (r4 == 0) goto L1b5
            com.tencent.turingfd.sdk.ams.au.n r4 = com.tencent.turingfd.sdk.ams.au.m.f13835b
        L18f:
            java.lang.String r8 = "100"
            java.lang.String r4 = r4.f13838a
            r5.put(r8, r4)
            r4 = 20
            long r8 = java.lang.System.currentTimeMillis()
            long r6 = r8 - r6
            com.tencent.turingfd.sdk.ams.au.i.a(r4, r6)
            r4 = 10001(0x2711, float:1.4014E-41)
            boolean r4 = r11.a(r4)
            if (r4 != 0) goto Lca
            java.lang.String r4 = "2004"
            java.lang.String r6 = "0"
            r5.put(r4, r6)
            goto Lca
        L1b5:
            java.util.Map<java.lang.String, com.tencent.turingfd.sdk.ams.au.m$a> r4 = com.tencent.turingfd.sdk.ams.au.m.f13834a
            java.lang.String r8 = com.tencent.turingfd.sdk.ams.au.m.c
            boolean r4 = r4.containsKey(r8)
            if (r4 != 0) goto L1c6
            r4 = -10
            com.tencent.turingfd.sdk.ams.au.n r4 = com.tencent.turingfd.sdk.ams.au.n.a(r4)
            goto L18f
        L1c6:
            java.lang.String r4 = "main"
            java.lang.Thread r8 = java.lang.Thread.currentThread()
            java.lang.String r8 = r8.getName()
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L1de
            r4 = -11
            com.tencent.turingfd.sdk.ams.au.n r4 = com.tencent.turingfd.sdk.ams.au.n.a(r4)
            goto L18f
        L1de:
            java.util.Map<java.lang.String, com.tencent.turingfd.sdk.ams.au.m$a> r4 = com.tencent.turingfd.sdk.ams.au.m.f13834a
            java.lang.String r8 = com.tencent.turingfd.sdk.ams.au.m.c
            java.lang.Object r4 = r4.get(r8)
            com.tencent.turingfd.sdk.ams.au.m$a r4 = (com.tencent.turingfd.sdk.ams.au.m.a) r4
            if (r4 == 0) goto L1ff
            int r8 = r4.f13837b
            r9 = 3
            if (r8 > r9) goto L1ff
            int r8 = r8 + 1
            r4.f13837b = r8
            com.tencent.turingfd.sdk.ams.au.k r4 = com.tencent.turingfd.sdk.ams.au.m.a.a(r4)
            r0 = r23
            com.tencent.turingfd.sdk.ams.au.n r4 = r4.a(r0)
            com.tencent.turingfd.sdk.ams.au.m.f13835b = r4
        L1ff:
            com.tencent.turingfd.sdk.ams.au.n r4 = com.tencent.turingfd.sdk.ams.au.m.f13835b
            goto L18f
        L202:
            r4 = move-exception
        L203:
            java.util.Set r4 = com.tencent.turingfd.sdk.ams.au.bb.a(r6)
            int r6 = r4.size()
            if (r6 <= 0) goto L569
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r6.addAll(r4)
            java.util.Iterator r10 = r6.iterator()
            r4 = 0
        L21f:
            boolean r6 = r10.hasNext()
            if (r6 == 0) goto L234
            int r6 = r4 + 1
            java.lang.Object r4 = r10.next()
            java.lang.String r4 = (java.lang.String) r4
            r7.append(r4)
            r4 = 8
            if (r6 < r4) goto L55a
        L234:
            java.lang.String r7 = r7.toString()
        L238:
            if (r7 != 0) goto L23d
            java.lang.String r7 = ""
        L23d:
            java.lang.String r6 = "250"
            r10 = 30
            com.tencent.turingfd.sdk.ams.au.ab.a(r5, r6, r7, r8, r10)
        L245:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.T
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L288
            long r8 = java.lang.System.currentTimeMillis()
            android.content.pm.PackageManager r4 = r23.getPackageManager()
            if (r4 != 0) goto L56e
        L259:
            r4 = 0
        L25a:
            r6 = 0
            r7 = 0
            int r6 = com.tencent.turingfd.sdk.ams.au.aj.a(r6, r4, r7)
            int[] r4 = com.tencent.turingfd.sdk.ams.au.y.n     // Catch: java.lang.Throwable -> Lb9b
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.y.a(r4)     // Catch: java.lang.Throwable -> Lb9b
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> Lb9b
            byte[] r4 = com.tencent.turingfd.sdk.ams.au.aj.b(r4)     // Catch: java.lang.Throwable -> Lb9b
            r7.<init>(r4)     // Catch: java.lang.Throwable -> Lb9b
            boolean r4 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lb9b
            if (r4 == 0) goto L57c
        L275:
            r4 = 0
        L276:
            r7 = 1
            int r4 = com.tencent.turingfd.sdk.ams.au.aj.a(r6, r4, r7)
            if (r4 <= 0) goto L5a4
            java.lang.String r7 = "1"
        L280:
            java.lang.String r6 = "251"
            r10 = 31
            com.tencent.turingfd.sdk.ams.au.ab.a(r5, r6, r7, r8, r10)
        L288:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.U
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L2ac
            android.content.ContentResolver r4 = r23.getContentResolver()     // Catch: java.lang.Throwable -> L5a9
            java.lang.String r6 = "mock_location"
            r7 = 0
            int r4 = android.provider.Settings.Secure.getInt(r4, r6, r7)     // Catch: java.lang.Throwable -> L5a9
            if (r4 == 0) goto L5aa
            r4 = 1
        L2a1:
            if (r4 == 0) goto L5ad
            java.lang.String r4 = "1"
        L2a6:
            java.lang.String r6 = "252"
            r5.put(r6, r4)
        L2ac:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.V
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L2ca
            java.lang.String r4 = ""
            java.lang.StringBuilder r7 = com.tencent.turingfd.sdk.ams.au.ab.a(r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 24
            if (r4 < r6) goto L5b2
        L2c3:
            r4 = 0
        L2c4:
            java.lang.String r6 = "253"
            com.tencent.turingfd.sdk.ams.au.ab.a(r7, r4, r5, r6)
        L2ca:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.W
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L2f4
            java.lang.String r4 = ""
            java.lang.StringBuilder r7 = com.tencent.turingfd.sdk.ams.au.ab.a(r4)
            android.content.IntentFilter r4 = new android.content.IntentFilter
            java.lang.String r6 = "android.intent.action.BATTERY_CHANGED"
            r4.<init>(r6)
            r6 = 0
            r0 = r23
            android.content.Intent r4 = r0.registerReceiver(r6, r4)     // Catch: java.lang.Throwable -> L61f
            r6 = r4
        L2eb:
            if (r6 != 0) goto L624
        L2ed:
            r4 = 0
        L2ee:
            java.lang.String r6 = "254"
            com.tencent.turingfd.sdk.ams.au.ab.a(r7, r4, r5, r6)
        L2f4:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.X
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L31e
            java.lang.String r4 = ""
            java.lang.StringBuilder r6 = com.tencent.turingfd.sdk.ams.au.ab.a(r4)
            android.content.IntentFilter r4 = new android.content.IntentFilter     // Catch: java.lang.Throwable -> L68a
            java.lang.String r7 = "android.intent.action.BATTERY_CHANGED"
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L68a
            r7 = 0
            r0 = r23
            android.content.Intent r4 = r0.registerReceiver(r7, r4)     // Catch: java.lang.Throwable -> L68a
            if (r4 != 0) goto L64e
            int r4 = com.tencent.turingfd.sdk.ams.au.bc.f13807a
        L318:
            java.lang.String r7 = "255"
            com.tencent.turingfd.sdk.ams.au.ab.a(r6, r4, r5, r7)
        L31e:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.Y
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L359
            long r8 = java.lang.System.currentTimeMillis()
            java.util.List<com.tencent.turingfd.sdk.ams.au.au> r4 = com.tencent.turingfd.sdk.ams.au.ac.f13762b
            if (r4 == 0) goto L68f
        L330:
            java.util.Iterator r6 = r4.iterator()
        L334:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L939
            java.lang.Object r4 = r6.next()
            com.tencent.turingfd.sdk.ams.au.au r4 = (com.tencent.turingfd.sdk.ams.au.au) r4
            java.lang.String r7 = r4.f13792a
            java.lang.String r10 = com.tencent.turingfd.sdk.ams.au.ax.c
            boolean r7 = r7.contains(r10)
            if (r7 == 0) goto L334
            java.lang.String r7 = r4.f13793b
        L34c:
            if (r7 != 0) goto L351
            java.lang.String r7 = ""
        L351:
            java.lang.String r6 = "256"
            r10 = 32
            com.tencent.turingfd.sdk.ams.au.ab.a(r5, r6, r7, r8, r10)
        L359:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.Z
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L381
            java.util.ArrayList r4 = com.tencent.turingfd.sdk.ams.au.am.a(r23)
            int r6 = r4.size()
            if (r6 == 0) goto L93e
            r6 = 0
            java.lang.Object r4 = r4.get(r6)
            com.tencent.turingfd.sdk.ams.au.au r4 = (com.tencent.turingfd.sdk.ams.au.au) r4
            java.lang.String r4 = r4.f13793b
        L376:
            if (r4 != 0) goto L37b
            java.lang.String r4 = ""
        L37b:
            java.lang.String r6 = "257"
            r5.put(r6, r4)
        L381:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.af
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L3d4
            long r8 = java.lang.System.currentTimeMillis()
            java.util.Enumeration r4 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Throwable -> L943
            if (r4 == 0) goto L944
            java.util.ArrayList r4 = java.util.Collections.list(r4)     // Catch: java.lang.Throwable -> L943
            java.util.Iterator r6 = r4.iterator()     // Catch: java.lang.Throwable -> L943
        L39d:
            boolean r4 = r6.hasNext()     // Catch: java.lang.Throwable -> L943
            if (r4 == 0) goto L944
            java.lang.Object r4 = r6.next()     // Catch: java.lang.Throwable -> L943
            java.net.NetworkInterface r4 = (java.net.NetworkInterface) r4     // Catch: java.lang.Throwable -> L943
            boolean r7 = r4.isUp()     // Catch: java.lang.Throwable -> L943
            if (r7 == 0) goto L39d
            java.util.List r7 = r4.getInterfaceAddresses()     // Catch: java.lang.Throwable -> L943
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L943
            if (r7 == 0) goto L39d
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L943
            java.lang.String r7 = "tun\\d+"
            boolean r4 = r4.matches(r7)     // Catch: java.lang.Throwable -> L943
            if (r4 == 0) goto L39d
            r4 = 1
        L3c7:
            if (r4 == 0) goto L947
            java.lang.String r7 = "1"
        L3cc:
            java.lang.String r6 = "258"
            r10 = 40
            com.tencent.turingfd.sdk.ams.au.ab.a(r5, r6, r7, r8, r10)
        L3d4:
            com.tencent.turingfd.sdk.ams.au.u r4 = com.tencent.turingfd.sdk.ams.au.u.ag
            int r4 = r4.aO
            boolean r4 = r11.a(r4)
            if (r4 == 0) goto L3f3
            long r8 = java.lang.System.currentTimeMillis()
            boolean r4 = com.tencent.turingfd.sdk.ams.au.aj.b(r23)     // Catch: java.lang.Throwable -> L94c
        L3e6:
            if (r4 == 0) goto L950
            java.lang.String r7 = "1"
        L3eb:
            java.lang.String r6 = "259"
            r10 = 41
            com.tencent.turingfd.sdk.ams.au.ab.a(r5, r6, r7, r8, r10)
        L3f3:
            java.lang.String r4 = "403"
            java.lang.String r6 = ""
            java.lang.StringBuilder r6 = com.tencent.turingfd.sdk.ams.au.ab.a(r6)
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.aq r7 = r0.d
            int r7 = r7.k()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.put(r4, r6)
            java.lang.String r4 = "402"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.aq r6 = r0.d
            java.lang.String r6 = r6.i()
            r5.put(r4, r6)
            java.lang.String r4 = "404"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.aq r6 = r0.d
            java.lang.String r6 = r6.j()
            r5.put(r4, r6)
            java.lang.String r4 = "401"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.aq r6 = r0.d
            java.lang.String r6 = r6.l()
            r5.put(r4, r6)
            java.lang.String r4 = "302"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r6 = r0.g
            r0 = r23
            java.lang.String r6 = r6.i(r0)
            r5.put(r4, r6)
            java.lang.String r4 = "303"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r6 = r0.g
            r0 = r23
            java.lang.String r6 = r6.h(r0)
            r5.put(r4, r6)
            java.lang.String r4 = "305"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r6 = r0.g
            r0 = r23
            java.lang.String r6 = r6.g(r0)
            r5.put(r4, r6)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = ""
            java.lang.StringBuilder r6 = r4.append(r6)
            java.lang.String r4 = "connectivity"
            r0 = r23
            java.lang.Object r4 = r0.getSystemService(r4)     // Catch: java.lang.Throwable -> L977
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4     // Catch: java.lang.Throwable -> L977
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L977
            if (r4 == 0) goto L497
            android.net.NetworkInfo$State r7 = r4.getState()     // Catch: java.lang.Throwable -> L977
            android.net.NetworkInfo$State r8 = android.net.NetworkInfo.State.CONNECTING     // Catch: java.lang.Throwable -> L977
            if (r7 == r8) goto L955
            android.net.NetworkInfo$State r7 = r4.getState()     // Catch: java.lang.Throwable -> L977
            android.net.NetworkInfo$State r8 = android.net.NetworkInfo.State.CONNECTED     // Catch: java.lang.Throwable -> L977
            if (r7 == r8) goto L955
        L497:
            r4 = -1
        L498:
            java.lang.String r7 = "308"
            com.tencent.turingfd.sdk.ams.au.ab.a(r6, r4, r5, r7)
            java.lang.String r4 = "309"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r6 = r0.g
            r0 = r23
            java.lang.String r6 = r6.d(r0)
            r5.put(r4, r6)
            java.lang.String r4 = "310"
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r6 = r0.g
            r0 = r23
            java.lang.String r6 = r6.m(r0)
            r5.put(r4, r6)
            com.tencent.turingfd.sdk.ams.au.bh.b(r23)
            android.util.SparseArray r4 = com.tencent.turingfd.sdk.ams.au.aj.d()     // Catch: java.lang.Throwable -> L99e
            r6 = 1
            r0 = r23
            android.util.SparseArray r4 = com.tencent.turingfd.sdk.ams.au.TuringDIDService.aa.a(r4, r0, r5, r6)     // Catch: java.lang.Throwable -> L99e
            java.lang.String r5 = "301"
            r6 = 0
            r0 = r23
            com.tencent.turingfd.sdk.ams.au.bh.a(r0, r5, r6)
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r5 = r0.g
            java.lang.String r6 = "201"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            long r8 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r14
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r8 = "_"
            java.lang.StringBuilder r7 = r7.append(r8)
            r0 = r24
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            r0 = r23
            r5.a(r0, r6, r7)
            int r5 = com.tencent.turingfd.sdk.ams.au.aj.a(r4)
            byte[] r6 = com.tencent.turingfd.sdk.ams.au.aj.b(r4)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r8 = 2
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            java.lang.Object r4 = com.tencent.turingfd.sdk.ams.au.aj.a(r4, r8, r9)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L51b
            java.lang.String r4 = ""
        L51b:
            java.lang.StringBuilder r4 = r7.append(r4)
            java.lang.String r7 = com.tencent.turingfd.sdk.ams.au.i.a()
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r7 = r0.g
            java.lang.String r8 = "205"
            r0 = r23
            r7.a(r0, r8, r4)
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r4 = r0.g
            int r7 = r6.length
            long r8 = (long) r7
            r0 = r23
            r1 = r24
            r4.a(r0, r8, r1)
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.aq r4 = r0.d
            com.tencent.turingfd.sdk.a.a r4 = r4.f()
            if (r4 == 0) goto L552
            r7 = 1
            r4.a(r5, r6, r7)
        L552:
            if (r5 == 0) goto L98b
            com.tencent.turingfd.sdk.ams.au.a r4 = com.tencent.turingfd.sdk.ams.au.a.a(r5)
            goto L20
        L55a:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto Lb8c
            java.lang.String r4 = "_"
            r7.append(r4)
            r4 = r6
            goto L21f
        L569:
            java.lang.String r7 = ""
            goto L238
        L56e:
            int[] r6 = com.tencent.turingfd.sdk.ams.au.y.l
            java.lang.String r6 = com.tencent.turingfd.sdk.ams.au.y.a(r6)
            r7 = 128(0x80, float:1.8E-43)
            r4.getPackageInfo(r6, r7)     // Catch: java.lang.Throwable -> Lb92
            r4 = 1
            goto L25a
        L57c:
            java.lang.String r4 = "\\n"
            java.lang.String[] r7 = r7.split(r4)     // Catch: java.lang.Throwable -> Lb9b
            if (r7 == 0) goto L275
            int r4 = r7.length     // Catch: java.lang.Throwable -> Lb9b
            if (r4 == 0) goto L275
            java.lang.String r10 = r23.getPackageName()     // Catch: java.lang.Throwable -> Lb9b
            int r0 = r7.length     // Catch: java.lang.Throwable -> Lb9b
            r16 = r0
            r4 = 0
        L590:
            r0 = r16
            if (r4 >= r0) goto L275
            r17 = r7[r4]     // Catch: java.lang.Throwable -> Lb9b
            r0 = r17
            boolean r17 = com.tencent.turingfd.sdk.ams.au.ar.a(r10, r0)     // Catch: java.lang.Throwable -> Lb9b
            if (r17 == 0) goto L5a1
            r4 = 1
            goto L276
        L5a1:
            int r4 = r4 + 1
            goto L590
        L5a4:
            java.lang.String r7 = "0"
            goto L280
        L5a9:
            r4 = move-exception
        L5aa:
            r4 = 0
            goto L2a1
        L5ad:
            java.lang.String r4 = "0"
            goto L2a6
        L5b2:
            java.io.File r8 = new java.io.File
            int[] r4 = com.tencent.turingfd.sdk.ams.au.y.an
            java.lang.String r4 = com.tencent.turingfd.sdk.ams.au.y.a(r4)
            r8.<init>(r4)
            java.lang.String r4 = ""
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5fd
            java.io.FileReader r9 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5fd
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L5fd
            r6.<init>(r9)     // Catch: java.lang.Throwable -> L5fd
            java.lang.String r4 = r6.readLine()     // Catch: java.lang.Throwable -> Lb95
            com.tencent.turingfd.sdk.ams.au.aj.a(r6)
        L5d1:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L2c3
            java.lang.String r6 = "CONFIGURED"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L607
            r4 = 0
            android.content.ContentResolver r6 = r23.getContentResolver()     // Catch: java.lang.Throwable -> Lb9e
            java.lang.String r8 = "adb_enabled"
            r9 = 0
            int r4 = android.provider.Settings.Secure.getInt(r6, r8, r9)     // Catch: java.lang.Throwable -> Lb9e
            if (r4 <= 0) goto L605
            r4 = 1
        L5f0:
            if (r4 == 0) goto L61c
            r4 = 1
            goto L2c4
        L5f5:
            r4 = move-exception
            r5 = 0
        L5f7:
            if (r5 == 0) goto L5fc
            com.tencent.turingfd.sdk.ams.au.aj.a(r5)
        L5fc:
            throw r4
        L5fd:
            r6 = move-exception
            r6 = 0
        L5ff:
            if (r6 == 0) goto L5d1
            com.tencent.turingfd.sdk.ams.au.aj.a(r6)
            goto L5d1
        L605:
            r4 = 0
            goto L5f0
        L607:
            java.lang.String r6 = "DISCONNECTED"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L613
            r4 = 2
            goto L2c4
        L613:
            java.lang.String r6 = "CONNECTED"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L2c3
        L61c:
            r4 = 3
            goto L2c4
        L61f:
            r4 = move-exception
            r4 = 0
            r6 = r4
            goto L2eb
        L624:
            java.lang.String r4 = "status"
            r8 = -1
            int r4 = r6.getIntExtra(r4, r8)
            r8 = 2
            if (r4 == r8) goto L632
            r8 = 5
            if (r4 != r8) goto L638
        L632:
            r4 = 1
        L633:
            if (r4 != 0) goto L63a
            r4 = 1
            goto L2ee
        L638:
            r4 = 0
            goto L633
        L63a:
            java.lang.String r4 = "plugged"
            r8 = -1
            int r4 = r6.getIntExtra(r4, r8)
            r6 = 2
            if (r4 != r6) goto L648
            r4 = 3
            goto L2ee
        L648:
            r6 = 1
            if (r4 != r6) goto L2ed
            r4 = 2
            goto L2ee
        L64e:
            java.lang.String r7 = r4.getAction()
            java.lang.String r8 = "android.intent.action.BATTERY_CHANGED"
            boolean r7 = android.text.TextUtils.equals(r7, r8)
            if (r7 != 0) goto L65f
            int r4 = com.tencent.turingfd.sdk.ams.au.bc.f13807a
            goto L318
        L65f:
            java.lang.String r7 = "level"
            r8 = 0
            int r7 = r4.getIntExtra(r7, r8)     // Catch: java.lang.Throwable -> L685
            java.lang.String r8 = "scale"
            r9 = 100
            int r4 = r4.getIntExtra(r8, r9)     // Catch: java.lang.Throwable -> L685
            if (r4 != 0) goto L676
            int r4 = com.tencent.turingfd.sdk.ams.au.bc.f13807a
            goto L318
        L676:
            int r7 = r7 * 100
            int r4 = r7 / r4
            if (r4 >= 0) goto L67d
            r4 = 0
        L67d:
            r7 = 100
            if (r4 <= r7) goto L318
            r4 = 100
            goto L318
        L685:
            r4 = move-exception
            int r4 = com.tencent.turingfd.sdk.ams.au.bc.f13807a
            goto L318
        L68a:
            r4 = move-exception
            int r4 = com.tencent.turingfd.sdk.ams.au.bc.f13807a
            goto L318
        L68f:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r16 = new java.util.ArrayList
            r16.<init>()
            java.io.File r4 = new java.io.File
            java.lang.String r6 = "/proc"
            r4.<init>(r6)
            java.lang.String[] r6 = r4.list()
            if (r6 != 0) goto L6ce
        L6a7:
            java.util.ArrayList r17 = new java.util.ArrayList
            r17.<init>()
            int r7 = android.os.Process.myPid()
            java.util.Iterator r18 = r16.iterator()
            r4 = 0
            r6 = r4
        L6b6:
            boolean r4 = r18.hasNext()
            if (r4 == 0) goto L703
            java.lang.Object r4 = r18.next()
            com.tencent.turingfd.sdk.ams.au.ag r4 = (com.tencent.turingfd.sdk.ams.au.ag) r4
            int r0 = r4.f13768a
            r19 = r0
            r0 = r19
            if (r7 != r0) goto L6b6
            int r4 = r4.e
            r6 = r4
            goto L6b6
        L6ce:
            int r7 = r6.length
            r4 = 0
        L6d0:
            if (r4 >= r7) goto L6a7
            r17 = r6[r4]
            boolean r18 = android.text.TextUtils.isEmpty(r17)
            if (r18 == 0) goto L6dd
        L6da:
            int r4 = r4 + 1
            goto L6d0
        L6dd:
            r18 = 0
            char r18 = r17.charAt(r18)     // Catch: java.lang.Exception -> L701
            r19 = 57
            r0 = r18
            r1 = r19
            if (r0 > r1) goto L6da
            r19 = 48
            r0 = r18
            r1 = r19
            if (r0 < r1) goto L6da
            int r17 = java.lang.Integer.parseInt(r17)     // Catch: java.lang.Exception -> L701
            com.tencent.turingfd.sdk.ams.au.ag r17 = com.tencent.turingfd.sdk.ams.au.aj.b(r17)     // Catch: java.lang.Exception -> L701
            if (r17 == 0) goto L6da
            r16.add(r17)     // Catch: java.lang.Exception -> L701
            goto L6da
        L701:
            r17 = move-exception
            goto L6da
        L703:
            if (r6 != 0) goto L74e
        L705:
            r0 = r17
            r10.addAll(r0)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.util.ArrayList r17 = new java.util.ArrayList
            r17.<init>()
            java.util.Iterator r18 = r16.iterator()
        L718:
            boolean r4 = r18.hasNext()
            if (r4 == 0) goto L79d
            java.lang.Object r4 = r18.next()
            com.tencent.turingfd.sdk.ams.au.ag r4 = (com.tencent.turingfd.sdk.ams.au.ag) r4
            java.util.Set<java.lang.String> r6 = com.tencent.turingfd.sdk.ams.au.ac.f13761a
            java.util.Iterator r19 = r6.iterator()
        L72a:
            boolean r6 = r19.hasNext()
            if (r6 == 0) goto L718
            java.lang.Object r6 = r19.next()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r0 = r4.d
            r20 = r0
            r0 = r20
            boolean r6 = r0.contains(r6)
            if (r6 == 0) goto L72a
            java.lang.String r6 = r4.d
            r7.append(r6)
            java.lang.String r6 = "_"
            r7.append(r6)
            goto L72a
        L74e:
            java.util.Iterator r18 = r16.iterator()
            java.lang.String r4 = ""
            r7 = r4
        L756:
            boolean r4 = r18.hasNext()
            if (r4 == 0) goto L76e
            java.lang.Object r4 = r18.next()
            com.tencent.turingfd.sdk.ams.au.ag r4 = (com.tencent.turingfd.sdk.ams.au.ag) r4
            int r0 = r4.f13768a
            r19 = r0
            r0 = r19
            if (r6 != r0) goto L756
            java.lang.String r4 = r4.d
            r7 = r4
            goto L756
        L76e:
            boolean r4 = android.text.TextUtils.isEmpty(r7)
            if (r4 != 0) goto L705
            com.tencent.turingfd.sdk.ams.au.au r4 = new com.tencent.turingfd.sdk.ams.au.au
            r4.<init>()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r18 = com.tencent.turingfd.sdk.ams.au.ax.f13798a
            r0 = r18
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r18 = com.tencent.turingfd.sdk.ams.au.ax.e
            r0 = r18
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r6 = r6.toString()
            r4.f13792a = r6
            r4.f13793b = r7
            r0 = r17
            r0.add(r4)
            goto L705
        L79d:
            java.lang.String r4 = r7.toString()
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L7db
            com.tencent.turingfd.sdk.ams.au.au r6 = new com.tencent.turingfd.sdk.ams.au.au
            r6.<init>()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r18 = com.tencent.turingfd.sdk.ams.au.ax.f13798a
            r0 = r18
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r18 = com.tencent.turingfd.sdk.ams.au.ax.c
            r0 = r18
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.f13792a = r7
            r7 = 0
            int r18 = r4.length()
            int r18 = r18 + (-1)
            r0 = r18
            java.lang.String r4 = r4.substring(r7, r0)
            r6.f13793b = r4
            r0 = r17
            r0.add(r6)
        L7db:
            r0 = r17
            r10.addAll(r0)
            java.util.ArrayList r17 = new java.util.ArrayList
            r17.<init>()
            java.lang.StringBuilder r18 = new java.lang.StringBuilder
            r18.<init>()
            java.util.HashSet r19 = new java.util.HashSet
            r19.<init>()
            java.util.Iterator r16 = r16.iterator()
            r4 = 0
            r7 = r4
        L7f5:
            boolean r4 = r16.hasNext()
            if (r4 == 0) goto L8d5
            java.lang.Object r4 = r16.next()
            r6 = r4
            com.tencent.turingfd.sdk.ams.au.ag r6 = (com.tencent.turingfd.sdk.ams.au.ag) r6
            int r4 = r6.c
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "/"
            r0 = r20
            boolean r4 = r4.startsWith(r0)
            if (r4 == 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "/system"
            r0 = r20
            boolean r4 = r4.startsWith(r0)
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "/dev"
            r0 = r20
            boolean r4 = r4.startsWith(r0)
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "/sbin"
            r0 = r20
            boolean r4 = r4.startsWith(r0)
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "/init"
            r0 = r20
            boolean r4 = r4.startsWith(r0)
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "/vendor"
            r0 = r20
            boolean r4 = r4.startsWith(r0)
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "/bin"
            r0 = r20
            boolean r4 = r4.startsWith(r0)
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "/usr"
            r0 = r20
            boolean r4 = r4.startsWith(r0)
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "kinguser"
            r0 = r20
            boolean r4 = r4.contains(r0)
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            java.lang.String r20 = "so"
            r0 = r20
            boolean r4 = r4.endsWith(r0)
            if (r4 != 0) goto L7f5
            java.util.Set<java.lang.String> r4 = com.tencent.turingfd.sdk.ams.au.ac.f13761a
            java.util.Iterator r20 = r4.iterator()
        L88e:
            boolean r4 = r20.hasNext()
            if (r4 == 0) goto Lb89
            java.lang.Object r4 = r20.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r0 = r6.d
            r21 = r0
            r0 = r21
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L88e
            r4 = 1
        L8a7:
            if (r4 != 0) goto L7f5
            java.util.Set<java.lang.String> r4 = com.tencent.turingfd.sdk.ams.au.ac.c
            java.util.Iterator r20 = r4.iterator()
        L8af:
            boolean r4 = r20.hasNext()
            if (r4 == 0) goto Lb86
            java.lang.Object r4 = r20.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r0 = r6.d
            r21 = r0
            r0 = r21
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L8af
            r4 = 1
        L8c8:
            if (r4 != 0) goto L7f5
            java.lang.String r4 = r6.d
            r0 = r19
            r0.add(r4)
            r4 = 8
            if (r7 < r4) goto Lb81
        L8d5:
            int r4 = r19.size()
            if (r4 <= 0) goto L931
            java.util.Iterator r6 = r19.iterator()
        L8df:
            boolean r4 = r6.hasNext()
            if (r4 == 0) goto L8f9
            java.lang.Object r4 = r6.next()
            java.lang.String r4 = (java.lang.String) r4
            r0 = r18
            r0.append(r4)
            java.lang.String r4 = "_"
            r0 = r18
            r0.append(r4)
            goto L8df
        L8f9:
            java.lang.String r4 = r18.toString()
            com.tencent.turingfd.sdk.ams.au.au r6 = new com.tencent.turingfd.sdk.ams.au.au
            r6.<init>()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r16 = com.tencent.turingfd.sdk.ams.au.ax.f13798a
            r0 = r16
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r16 = com.tencent.turingfd.sdk.ams.au.ax.d
            r0 = r16
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.f13792a = r7
            r7 = 0
            int r16 = r4.length()
            int r16 = r16 + (-1)
            r0 = r16
            java.lang.String r4 = r4.substring(r7, r0)
            r6.f13793b = r4
            r0 = r17
            r0.add(r6)
        L931:
            r0 = r17
            r10.addAll(r0)
            r4 = r10
            goto L330
        L939:
            java.lang.String r7 = ""
            goto L34c
        L93e:
            java.lang.String r4 = ""
            goto L376
        L943:
            r4 = move-exception
        L944:
            r4 = 0
            goto L3c7
        L947:
            java.lang.String r7 = "0"
            goto L3cc
        L94c:
            r4 = move-exception
            r4 = 0
            goto L3e6
        L950:
            java.lang.String r7 = "0"
            goto L3eb
        L955:
            int r7 = r4.getType()     // Catch: java.lang.Throwable -> L977
            r8 = 1
            if (r7 != r8) goto L95f
            r4 = 0
            goto L498
        L95f:
            int r4 = r4.getType()     // Catch: java.lang.Throwable -> L977
            if (r4 != 0) goto L497
            java.lang.String r4 = android.net.Proxy.getDefaultHost()     // Catch: java.lang.Throwable -> L977
            if (r4 != 0) goto L971
            java.lang.String r4 = android.net.Proxy.getHost(r23)     // Catch: java.lang.Throwable -> L977
            if (r4 == 0) goto L974
        L971:
            r4 = 2
            goto L498
        L974:
            r4 = 1
            goto L498
        L977:
            r4 = move-exception
            java.lang.String r7 = r4.getMessage()
            r4 = -3
            if (r7 == 0) goto L498
            java.lang.String r8 = "ACCESS_NETWORK_STATE"
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L498
            r4 = -2
            goto L498
        L98b:
            int r4 = r6.length
            if (r4 != 0) goto L996
            r4 = -10003(0xffffffffffffd8ed, float:NaN)
            com.tencent.turingfd.sdk.ams.au.a r4 = com.tencent.turingfd.sdk.ams.au.a.a(r4)
            goto L20
        L996:
            com.tencent.turingfd.sdk.ams.au.a r4 = new com.tencent.turingfd.sdk.ams.au.a
            r5 = 0
            r4.<init>(r5, r6)
            goto L20
        L99e:
            r4 = move-exception
            com.tencent.turingfd.sdk.ams.au.g r5 = com.tencent.turingfd.sdk.ams.au.g.a()
            r5.a(r4)
            r4 = -10006(0xffffffffffffd8ea, float:NaN)
            com.tencent.turingfd.sdk.ams.au.a r4 = com.tencent.turingfd.sdk.ams.au.a.a(r4)
            goto L20
        L9ae:
            long r6 = java.lang.System.currentTimeMillis()
            byte[] r4 = r4.c
            r5 = 8117(0x1fb5, float:1.1374E-41)
            r8 = 18117(0x46c5, float:2.5387E-41)
            r0 = r22
            r1 = r23
            com.tencent.turingfd.sdk.ams.au.b r5 = r0.a(r1, r4, r5, r8)
            java.lang.String r4 = "connectivity"
            r0 = r23
            java.lang.Object r4 = r0.getSystemService(r4)     // Catch: java.lang.Throwable -> La51
            android.net.ConnectivityManager r4 = (android.net.ConnectivityManager) r4     // Catch: java.lang.Throwable -> La51
            android.net.NetworkInfo r4 = r4.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> La51
            if (r4 == 0) goto L9e1
            android.net.NetworkInfo$State r8 = r4.getState()     // Catch: java.lang.Throwable -> La51
            android.net.NetworkInfo$State r9 = android.net.NetworkInfo.State.CONNECTING     // Catch: java.lang.Throwable -> La51
            if (r8 == r9) goto La32
            android.net.NetworkInfo$State r8 = r4.getState()     // Catch: java.lang.Throwable -> La51
            android.net.NetworkInfo$State r9 = android.net.NetworkInfo.State.CONNECTED     // Catch: java.lang.Throwable -> La51
            if (r8 == r9) goto La32
        L9e1:
            r4 = -1
        L9e2:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.StringBuilder r4 = r8.append(r4)
            java.lang.String r8 = "_"
            java.lang.StringBuilder r4 = r4.append(r8)
            long r8 = java.lang.System.currentTimeMillis()
            long r6 = r8 - r6
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r6 = "_"
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.StringBuilder r4 = r4.append(r12)
            java.lang.String r6 = "_"
            java.lang.StringBuilder r4 = r4.append(r6)
            r0 = r24
            java.lang.StringBuilder r4 = r4.append(r0)
            java.lang.String r4 = r4.toString()
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r6 = r0.g
            java.lang.String r7 = "202"
            r0 = r23
            r6.a(r0, r7, r4)
            int r4 = r5.f13805b
            if (r4 == 0) goto La66
            int r4 = r5.a()
            com.tencent.turingfd.sdk.ams.au.ap r4 = com.tencent.turingfd.sdk.ams.au.ap.a(r4)
            goto L2e
        La32:
            int r8 = r4.getType()     // Catch: java.lang.Throwable -> La51
            r9 = 1
            if (r8 != r9) goto La3b
        La39:
            r4 = 0
            goto L9e2
        La3b:
            int r4 = r4.getType()     // Catch: java.lang.Throwable -> La51
            if (r4 != 0) goto L9e1
            java.lang.String r4 = android.net.Proxy.getDefaultHost()     // Catch: java.lang.Throwable -> La51
            if (r4 != 0) goto La4d
            java.lang.String r4 = android.net.Proxy.getHost(r23)     // Catch: java.lang.Throwable -> La51
            if (r4 == 0) goto La4f
        La4d:
            r4 = 2
            goto L9e2
        La4f:
            r4 = 1
            goto L9e2
        La51:
            r4 = move-exception
            java.lang.String r8 = r4.getMessage()
            r4 = 0
            if (r8 == 0) goto La63
            java.lang.String r9 = "ACCESS_NETWORK_STATE"
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto La63
            r4 = 1
        La63:
            if (r4 == 0) goto L9e1
            goto La39
        La66:
            byte[] r4 = r5.b()
            android.util.SparseArray r5 = com.tencent.turingfd.sdk.ams.au.aj.d()     // Catch: java.lang.Throwable -> Lb69
            r6 = 1
            android.util.SparseArray r10 = com.tencent.turingfd.sdk.ams.au.TuringDIDService.aa.b(r5, r4, r6)     // Catch: java.lang.Throwable -> Lb69
            int r4 = com.tencent.turingfd.sdk.ams.au.aj.a(r10)
            if (r4 == 0) goto La7f
            com.tencent.turingfd.sdk.ams.au.ap r4 = com.tencent.turingfd.sdk.ams.au.ap.a(r4)
            goto L2e
        La7f:
            r4 = 102(0x66, float:1.43E-43)
            java.lang.Class<java.lang.Integer> r5 = java.lang.Integer.class
            java.lang.Object r4 = com.tencent.turingfd.sdk.ams.au.aj.a(r10, r4, r5)
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 != 0) goto La93
            r4 = -30000(0xffffffffffff8ad0, float:NaN)
            com.tencent.turingfd.sdk.ams.au.ap r4 = com.tencent.turingfd.sdk.ams.au.ap.a(r4)
            goto L2e
        La93:
            int r5 = r4.intValue()
            if (r5 >= 0) goto Laa5
            int r4 = r4.intValue()
            int r4 = r4 + (-30000)
            com.tencent.turingfd.sdk.ams.au.ap r4 = com.tencent.turingfd.sdk.ams.au.ap.a(r4)
            goto L2e
        Laa5:
            r5 = 101(0x65, float:1.42E-43)
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            java.lang.Object r5 = com.tencent.turingfd.sdk.ams.au.aj.a(r10, r5, r6)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto Lb7e
            java.lang.String r5 = ""
            r6 = r5
        Lab5:
            boolean r5 = android.text.TextUtils.isEmpty(r6)
            if (r5 == 0) goto Lac7
            int r4 = r4.intValue()
            int r4 = r4 + (-10010)
            com.tencent.turingfd.sdk.ams.au.ap r4 = com.tencent.turingfd.sdk.ams.au.ap.a(r4)
            goto L2e
        Lac7:
            r4 = 104(0x68, float:1.46E-43)
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            java.lang.Object r4 = com.tencent.turingfd.sdk.ams.au.aj.a(r10, r4, r5)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto Lb7b
            java.lang.String r4 = ""
            r7 = r4
        Lad7:
            r4 = 105(0x69, float:1.47E-43)
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            java.lang.Object r4 = com.tencent.turingfd.sdk.ams.au.aj.a(r10, r4, r5)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto Lb78
            java.lang.String r4 = ""
            r8 = r4
        Lae7:
            r4 = 106(0x6a, float:1.49E-43)
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            java.lang.Object r4 = com.tencent.turingfd.sdk.ams.au.aj.a(r10, r4, r5)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto Lb76
            java.lang.String r4 = ""
            r9 = r4
        Laf7:
            r4 = 107(0x6b, float:1.5E-43)
            java.lang.Class<java.lang.Integer> r5 = java.lang.Integer.class
            java.lang.Object r4 = com.tencent.turingfd.sdk.ams.au.aj.a(r10, r4, r5)
            java.lang.Integer r4 = (java.lang.Integer) r4
            r5 = 108(0x6c, float:1.51E-43)
            java.lang.Class<java.lang.String> r11 = java.lang.String.class
            java.lang.Object r5 = com.tencent.turingfd.sdk.ams.au.aj.a(r10, r5, r11)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto Lba3
            java.lang.String r5 = ""
            r10 = r5
        Lb11:
            if (r4 == 0) goto Lb1b
            int r5 = r4.intValue()
            r11 = 3600(0xe10, float:5.045E-42)
            if (r5 >= r11) goto Lba1
        Lb1b:
            r4 = 3600(0xe10, float:5.045E-42)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = r4
        Lb22:
            long r12 = java.lang.System.currentTimeMillis()
            r14 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 / r14
            int r4 = r5.intValue()
            long r14 = (long) r4
            r4 = 0
            com.tencent.turingfd.sdk.ams.au.ap$b r4 = com.tencent.turingfd.sdk.ams.au.ap.b(r4)
            long r12 = r12 + r14
            com.tencent.turingfd.sdk.ams.au.ap$b r4 = r4.a(r12)
            com.tencent.turingfd.sdk.ams.au.ap$b r4 = r4.a(r6)
            com.tencent.turingfd.sdk.ams.au.ap$b r4 = r4.b(r7)
            com.tencent.turingfd.sdk.ams.au.ap$b r4 = r4.c(r8)
            com.tencent.turingfd.sdk.ams.au.ap$b r4 = r4.d(r9)
            com.tencent.turingfd.sdk.ams.au.ap$b r4 = r4.e(r10)
            com.tencent.turingfd.sdk.ams.au.ap r4 = r4.a()
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r6 = r0.g
            r0 = r23
            r6.a(r0, r4)
            r0 = r22
            com.tencent.turingfd.sdk.ams.au.c r6 = r0.g
            int r5 = r5.intValue()
            long r8 = (long) r5
            r0 = r23
            r6.a(r0, r8)
            goto L2e
        Lb69:
            r4 = move-exception
            r4 = -10007(0xffffffffffffd8e9, float:NaN)
            com.tencent.turingfd.sdk.ams.au.ap r4 = com.tencent.turingfd.sdk.ams.au.ap.a(r4)
            goto L2e
        Lb72:
            r4 = move-exception
            r5 = r6
            goto L5f7
        Lb76:
            r9 = r4
            goto Laf7
        Lb78:
            r8 = r4
            goto Lae7
        Lb7b:
            r7 = r4
            goto Lad7
        Lb7e:
            r6 = r5
            goto Lab5
        Lb81:
            int r4 = r7 + 1
            r7 = r4
            goto L7f5
        Lb86:
            r4 = 0
            goto L8c8
        Lb89:
            r4 = 0
            goto L8a7
        Lb8c:
            r4 = r6
            goto L21f
        Lb8f:
            r5 = move-exception
            goto L40
        Lb92:
            r4 = move-exception
            goto L259
        Lb95:
            r8 = move-exception
            goto L5ff
        Lb98:
            r4 = move-exception
            goto Lea
        Lb9b:
            r4 = move-exception
            goto L275
        Lb9e:
            r6 = move-exception
            goto L5f0
        Lba1:
            r5 = r4
            goto Lb22
        Lba3:
            r10 = r5
            goto Lb11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.an.a(android.content.Context, boolean, boolean):com.tencent.turingfd.sdk.ams.au.ap");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009b, code lost:
        if (r11 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010a, code lost:
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - r0.longValue()) < com.tencent.turingfd.sdk.ams.au.an.f13776b) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ap a(Context context, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        ap a2;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                z4 = false;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        z4 = true;
                    }
                }
                z4 = false;
            }
        } catch (Throwable th) {
            g.a().a("1", Log.getStackTraceString(th));
            String message = th.getMessage();
            z4 = false;
            if (message != null && message.contains("ACCESS_NETWORK_STATE")) {
                z4 = true;
            }
        }
        if (!z4) {
            return ap.a(-10012);
        }
        if (Math.abs((System.currentTimeMillis() / 1000) - (this.g.f(aj.a()) / 1000)) > 3600) {
            ae<Long> a3 = this.g.a(aj.a(), 6);
            if (a3.a() != 0) {
                long e = this.g.e(aj.a());
                if (e > 0) {
                    long abs = Math.abs(System.currentTimeMillis() - a3.f13766b.getLast().longValue());
                    int[] iArr = c;
                    int length = e < ((long) iArr.length) ? (int) e : iArr.length - 1;
                    if (length >= 1) {
                        int[] iArr2 = c;
                        int i = iArr2[length - 1];
                        int i2 = iArr2[length];
                        if (i >= i2) {
                            throw new IllegalArgumentException("");
                        }
                        if (abs <= TimeUnit.SECONDS.toMillis(new Random().nextInt((i2 - i) + 1) + i)) {
                            z5 = false;
                            if (!z5) {
                                Long first = a3.f13766b.getFirst();
                                if (a3.a() >= a3.f13765a) {
                                }
                            }
                            if (z6) {
                                return ap.a(-10011);
                            }
                            ae<Long> a4 = this.g.a(aj.a(), 6);
                            a4.a(Long.valueOf(System.currentTimeMillis()));
                            this.g.a(aj.a(), a4);
                            String b2 = at.b(context);
                            if (!TextUtils.isEmpty(b2)) {
                                this.g.b(context, b2);
                            }
                            j.a(context, this.g);
                            j.b(context, this.g);
                            try {
                                a2 = a(context, z, z3);
                            } catch (Throwable th2) {
                                a2 = ap.a(-10015);
                            }
                            if (a2.d == -30015) {
                                this.g.d(context, System.currentTimeMillis());
                            } else if (this.g.f(context) != 0) {
                                this.g.d(context, 0L);
                            }
                            long e2 = this.g.e(context);
                            if (a2.d < 0) {
                                this.g.c(context, e2 + 1);
                            } else if (e2 != 0) {
                                this.g.c(context, 0L);
                            }
                            if (!TextUtils.isEmpty(this.g.d(context))) {
                                this.g.b(context, "");
                            }
                            if (a2.d == 0) {
                                j.c(context, this.g);
                            }
                            this.g.b(context, a2.d);
                            return a2;
                        }
                    }
                }
                z5 = true;
                if (!z5) {
                }
                if (z6) {
                }
            }
            z6 = true;
            if (z6) {
            }
        }
        z6 = false;
        if (z6) {
        }
    }

    public final ap a(ap apVar, Context context, boolean z, boolean z2) {
        ap a2;
        synchronized (this.h) {
            a2 = a(context);
            if (a2 == apVar || a(a2) != 1) {
                synchronized (this.j) {
                    if (!this.j.get().booleanValue()) {
                        this.j.set(true);
                        this.e.post(new a(context, z));
                    }
                    try {
                        this.j.wait(z2 ? this.d.d() : 10000L);
                    } catch (InterruptedException e) {
                    }
                }
                a2 = a(context);
                if (a2 == apVar) {
                    a2 = ap.a(-10004);
                }
            }
        }
        return a2;
    }

    public final com.tencent.turingfd.sdk.ams.au.b a(Context context, byte[] bArr, int i, int i2) {
        com.tencent.turingfd.sdk.ams.au.b a2;
        ad p = this.d.p();
        if (p == null) {
            a2 = com.tencent.turingfd.sdk.ams.au.b.a(NativeErrorCode.EKS_UNKNOWN_ERROR_BASE);
        } else {
            try {
                System.currentTimeMillis();
                ad.a a3 = ((bd) p).a(1, bArr, 0, 0);
                a2 = a3.f13763a != 0 ? com.tencent.turingfd.sdk.ams.au.b.a(a3.f13763a + NativeErrorCode.EKS_UNKNOWN_ERROR_BASE) : new com.tencent.turingfd.sdk.ams.au.b(0, a3.f13764b);
            } catch (Throwable th) {
                a2 = com.tencent.turingfd.sdk.ams.au.b.a(NativeErrorCode.EKS_UNKNOWN_ERROR_BASE);
            }
        }
        if (a2.f13805b != 0) {
        }
        return a2;
    }

    public final void a() {
        synchronized (this.j) {
            if (this.j.get().booleanValue()) {
                return;
            }
            this.j.set(true);
            this.e.sendEmptyMessage(2);
        }
    }

    public final void a(ap apVar, boolean z) {
        synchronized (this.i) {
            if (apVar != null) {
                if (z || apVar.d == 0) {
                    this.i.set(apVar);
                }
            }
        }
    }

    public final void b(Context context, boolean z) {
        boolean k = this.g.k(context);
        for (int i = 0; i < this.d.e(); i++) {
            ap a2 = a(context, z, k, false);
            a(a2, true);
            if (a2.d == 0 || a2.d == -30014) {
                break;
            }
        }
        if (k) {
            this.g.a(context, false);
        }
        synchronized (this.j) {
            this.j.set(false);
            this.j.notifyAll();
        }
    }

    public final ap c(Context context, boolean z) {
        ap a2 = a(context);
        int a3 = a(a2);
        if (a3 == 1) {
            return a2;
        }
        if (a3 == 2) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
                return ap.a(-10008);
            }
            return a(a2, context, false, z);
        } else if (a3 == 3) {
            a();
            return a2;
        } else {
            return a2;
        }
    }
}
