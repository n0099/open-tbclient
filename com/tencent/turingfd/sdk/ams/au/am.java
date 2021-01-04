package com.tencent.turingfd.sdk.ams.au;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class am {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Set<String>> f13772a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Integer> f13773b = new HashMap();

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("18C867F0717AA67B2AB7347505BA07ED");
        f13772a.put(y.a(y.J), hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add("31223B0BDF1DEF1FE8252971ADA3B577");
        hashSet2.add("CCD4AD38DC6669F875BC37E3F8840648");
        hashSet2.add("AA3978F41FD96FF9914A669E186474C7");
        hashSet2.add("775E696D09856872FDD8AB4F3F06B1E0");
        hashSet2.add("A6B745BF24A2C277527716F6F36EB68D");
        hashSet2.add("A01EECAB85E9E3BA2B0F6A158C855C29");
        f13772a.put(y.a(y.K), hashSet2);
        f13773b.put(y.a(y.J), 105118);
        f13773b.put(y.a(y.K), 105178);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static java.util.ArrayList<com.tencent.turingfd.sdk.ams.au.au> a(android.content.Context r6) {
        /*
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = r6.getPackageName()
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L11
        L10:
            return r3
        L11:
            android.content.pm.PackageManager r0 = r6.getPackageManager()     // Catch: java.lang.Throwable -> L8d
            android.content.pm.PackageManager r1 = r6.getPackageManager()     // Catch: java.lang.Throwable -> L8d
            r5 = 0
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo(r4, r5)     // Catch: java.lang.Throwable -> L8d
            int r1 = r1.uid     // Catch: java.lang.Throwable -> L8d
            java.lang.String[] r1 = r0.getPackagesForUid(r1)     // Catch: java.lang.Throwable -> L8d
            r5 = 0
            r1 = r1[r5]     // Catch: java.lang.Throwable -> L8d
            r5 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r1, r5)     // Catch: java.lang.Throwable -> L8d
            android.content.pm.Signature[] r0 = r0.signatures     // Catch: java.lang.Throwable -> L8d
            r1 = 0
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L8d
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L8d
            byte[] r0 = r0.toByteArray()     // Catch: java.lang.Throwable -> L8d
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L8d
            java.lang.String r0 = "X.509"
            java.security.cert.CertificateFactory r0 = java.security.cert.CertificateFactory.getInstance(r0)     // Catch: java.lang.Throwable -> La8
            java.security.cert.Certificate r0 = r0.generateCertificate(r1)     // Catch: java.lang.Throwable -> La8
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0     // Catch: java.lang.Throwable -> La8
            byte[] r0 = r0.getEncoded()     // Catch: java.lang.Throwable -> La8
            java.lang.String r0 = com.tencent.turingfd.sdk.ams.au.aj.b(r0)     // Catch: java.lang.Throwable -> La8
            r1.close()     // Catch: java.lang.Throwable -> La0
        L53:
            com.tencent.turingfd.sdk.ams.au.au r1 = new com.tencent.turingfd.sdk.ams.au.au
            r1.<init>()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = com.tencent.turingfd.sdk.ams.au.ax.f13797a
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r5 = com.tencent.turingfd.sdk.ams.au.ax.f13798b
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.f13791a = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.String r4 = "_"
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.f13792b = r0
            r3.add(r1)
            goto L10
        L8d:
            r0 = move-exception
            r1 = r2
        L8f:
            if (r1 == 0) goto L94
            r1.close()     // Catch: java.lang.Throwable -> La2
        L94:
            java.lang.String r0 = ""
            goto L53
        L98:
            r0 = move-exception
            r1 = r2
        L9a:
            if (r1 == 0) goto L9f
            r1.close()     // Catch: java.lang.Throwable -> La4
        L9f:
            throw r0
        La0:
            r1 = move-exception
            goto L53
        La2:
            r0 = move-exception
            goto L94
        La4:
            r1 = move-exception
            goto L9f
        La6:
            r0 = move-exception
            goto L9a
        La8:
            r0 = move-exception
            goto L8f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.am.a(android.content.Context):java.util.ArrayList");
    }
}
