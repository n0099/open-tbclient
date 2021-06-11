package com.yy.hiidostatis.inner.util.http;

import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.io.ByteArrayInputStream;
/* loaded from: classes7.dex */
public class StatisHttpEncryptUtil extends AbstractStatisHttpUtil {
    public static final String[] ADDRESSES_OTHER = new String[0];
    public static final String RSA_PUB_KEY = "MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRSvSVZEbyQwtFwNtNiZKkCAwEAAQ==";
    public static final String URL_FORMAT = "http://%s/c.gif";
    public static final String URL_PARAM = "act=mbsdkdata&smkdata=$smkdata&EC=$EC&appkey=$appkey&item=$item";
    public String body;
    public String mLastHost;
    public String mLastSmkData;
    public RsaCipher mRsaCipher = null;
    public Object rsaLock = new Object();
    public String urlParams;

    private RsaCipher getRsaCipher() throws Exception {
        RsaCipher rsaCipher = this.mRsaCipher;
        if (rsaCipher != null) {
            return rsaCipher;
        }
        synchronized (this.rsaLock) {
            if (this.mRsaCipher != null) {
                return this.mRsaCipher;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64Util.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRSvSVZEbyQwtFwNtNiZKkCAwEAAQ=="));
            RsaCipher rsaCipher2 = new RsaCipher();
            rsaCipher2.loadPublicKey(byteArrayInputStream);
            this.mRsaCipher = rsaCipher2;
            return rsaCipher2;
        }
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public String getHost() {
        return HiidoSDK.getHiidoHost();
    }

    public String getLastHost() {
        return this.mLastHost;
    }

    public String getLastSmkData() {
        return this.mLastSmkData;
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String[] getUrlAddress() {
        return HiidoSDK.getHiidoIps();
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String getUrlFormat() {
        return "http://%s/c.gif";
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String getUrlService() {
        return String.format("http://%s/c.gif", HiidoSDK.getHiidoHost());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x00ad
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public boolean sendContent(java.lang.String r21, java.lang.String r22, int r23) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            r9 = r22
            r10 = r23
            java.lang.String r11 = ""
            java.lang.String r12 = "|"
            r13 = 1
            java.lang.Object[] r2 = new java.lang.Object[r13]
            r14 = 0
            r2[r14] = r0
            java.lang.String r3 = "hiido service address is %s"
            com.yy.hiidostatis.inner.util.log.L.brief(r3, r2)
            if (r0 == 0) goto L268
            boolean r2 = r21.isEmpty()
            if (r2 == 0) goto L21
            goto L268
        L21:
            r15 = 0
            r1.mThrowable = r15
            r1.mLastHost = r15
            r1.mLastSmkData = r15
            r8 = 2
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r2[r14] = r0
            java.lang.String r3 = "act=mbsdkdata&smkdata=$smkdata&EC=$EC&appkey=$appkey&item=$item"
            r2[r13] = r3
            java.lang.String r3 = "%s?%s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r3 = 4
            java.lang.String r3 = com.yy.hiidostatis.inner.util.Util.getRandStringEx(r3)     // Catch: java.lang.Throwable -> L22f
            com.yy.hiidostatis.inner.util.cipher.AesCipher r4 = new com.yy.hiidostatis.inner.util.cipher.AesCipher     // Catch: java.lang.Throwable -> L22f
            byte[] r5 = r3.getBytes()     // Catch: java.lang.Throwable -> L22f
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L22f
            java.lang.String r5 = "UTF-8"
            byte[] r5 = r9.getBytes(r5)     // Catch: java.lang.Throwable -> L22f
            java.lang.String r7 = r4.encryptTlogBytesBase64(r5)     // Catch: java.lang.Throwable -> L22f
            java.lang.String r4 = "%s&enc=b64"
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch: java.lang.Throwable -> L22f
            r5[r14] = r2     // Catch: java.lang.Throwable -> L22f
            java.lang.String r2 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L22f
            com.yy.hiidostatis.inner.util.cipher.RsaCipher r4 = r20.getRsaCipher()     // Catch: java.lang.Throwable -> L22f
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> L22f
            java.lang.String r3 = r4.encryptTlogAesKey(r3)     // Catch: java.lang.Throwable -> L22f
            java.lang.String r4 = "$smkdata"
            java.lang.String r2 = r2.replace(r4, r3)     // Catch: java.lang.Throwable -> L22f
            java.lang.String r4 = "$appkey"
            java.lang.String r5 = "appkey"
            java.lang.String r5 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r5)     // Catch: java.lang.Throwable -> L22f
            java.lang.String r2 = r2.replace(r4, r5)     // Catch: java.lang.Throwable -> L22f
            java.lang.String r4 = "$item"
            java.lang.String r5 = "act"
            java.lang.String r5 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r5)     // Catch: java.lang.Throwable -> L22f
            java.lang.String r6 = r2.replace(r4, r5)     // Catch: java.lang.Throwable -> L22f
            r1.mLastSmkData = r3     // Catch: java.lang.Throwable -> L22f
            java.net.URI r2 = new java.net.URI     // Catch: java.lang.Throwable -> L22f
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L22f
            java.lang.String r0 = r2.getHost()     // Catch: java.lang.Throwable -> L22f
            r1.mLastHost = r0     // Catch: java.lang.Throwable -> L22f
            r5 = r10
        L91:
            int r0 = r20.getLastTryTimes()     // Catch: java.lang.Throwable -> L1a2
            if (r0 <= 0) goto Lb4
            r2 = 0
            java.lang.String r3 = "Retry"
            r0 = 0
            r16 = 0
            r17 = 0
            r4 = r22
            r15 = r5
            r5 = r0
            r8 = r6
            r6 = r16
            r13 = r7
            r7 = r17
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L19c
            goto Lb7
        Lad:
            r0 = move-exception
            r15 = r5
            r13 = r7
            r19 = r6
            goto L19f
        Lb4:
            r15 = r5
            r8 = r6
            r13 = r7
        Lb7:
            java.lang.String r0 = "$EC"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19c
            r2.<init>()     // Catch: java.lang.Throwable -> L19c
            int r3 = r1.lastTryTimes     // Catch: java.lang.Throwable -> L19c
            r2.append(r3)     // Catch: java.lang.Throwable -> L19c
            r2.append(r11)     // Catch: java.lang.Throwable -> L19c
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L19c
            java.lang.String r0 = r8.replace(r0, r2)     // Catch: java.lang.Throwable -> L19c
            if (r10 == r15) goto Le6
            java.lang.String r2 = "Try again to send %s with url %s, tried times %d."
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L19c
            r3[r14] = r13     // Catch: java.lang.Throwable -> L19c
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L19c
            int r4 = r10 - r15
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L19c
            r5 = 2
            r3[r5] = r4     // Catch: java.lang.Throwable -> L19c
            com.yy.hiidostatis.inner.util.log.L.brief(r2, r3)     // Catch: java.lang.Throwable -> L19c
        Le6:
            int r2 = r1.lastTryTimes     // Catch: java.lang.Throwable -> L19c
            r3 = 1
            int r2 = r2 + r3
            r1.lastTryTimes = r2     // Catch: java.lang.Throwable -> L19c
            java.lang.String r2 = "?"
            int r2 = r0.indexOf(r2)     // Catch: java.lang.Throwable -> L19c
            int r2 = r2 + r3
            java.lang.String r2 = r0.substring(r2)     // Catch: java.lang.Throwable -> L19c
            r1.urlParams = r2     // Catch: java.lang.Throwable -> L19c
            r1.body = r13     // Catch: java.lang.Throwable -> L19c
            boolean r2 = r1.post(r0, r13)     // Catch: java.lang.Throwable -> L19c
            if (r2 != 0) goto L161
            java.lang.String r2 = "Failed to send %s to %s."
            r7 = 2
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L15b
            r3[r14] = r13     // Catch: java.lang.Throwable -> L15b
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L15b
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r2, r3)     // Catch: java.lang.Throwable -> L15b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L15b
            r0.<init>()     // Catch: java.lang.Throwable -> L15b
            int r2 = r1.statusCode     // Catch: java.lang.Throwable -> L15b
            r0.append(r2)     // Catch: java.lang.Throwable -> L15b
            r0.append(r12)     // Catch: java.lang.Throwable -> L15b
            java.lang.String r2 = r1.reasonPhrase     // Catch: java.lang.Throwable -> L15b
            r0.append(r2)     // Catch: java.lang.Throwable -> L15b
            r0.append(r12)     // Catch: java.lang.Throwable -> L15b
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L15b
            r2 = 0
            java.lang.String r3 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L15b
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L15b
            int r0 = r20.getLastStatusCode()     // Catch: java.lang.Throwable -> L15b
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L15b
            int r5 = r20.getLastTryTimes()     // Catch: java.lang.Throwable -> L15b
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L15b
            r5 = r22
            r19 = 2
            r7 = r0
            r19 = r8
            r14 = 2
            r8 = r17
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L159
            r2 = 0
            java.lang.String r3 = "Fail"
            r5 = 0
            r6 = 0
            r7 = 0
            r4 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L159
            r2 = 0
            r18 = 0
            goto L220
        L159:
            r0 = move-exception
            goto L15f
        L15b:
            r0 = move-exception
            r19 = r8
            r14 = 2
        L15f:
            r8 = 0
            goto L1a9
        L161:
            r19 = r8
            r8 = 0
            r14 = 2
            r1.mThrowable = r8     // Catch: java.lang.Throwable -> L19a
            java.lang.String r2 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L19a
            java.lang.String r3 = r1.mLastHost     // Catch: java.lang.Throwable -> L19a
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendSucLog(r8, r2, r3, r9)     // Catch: java.lang.Throwable -> L19a
            r2 = 0
            java.lang.String r3 = "Suc"
            java.lang.String r5 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L19a
            java.lang.String r4 = r1.lastRemoteIp     // Catch: java.lang.Throwable -> L19a
            if (r4 == 0) goto L183
            java.lang.String r4 = r1.lastRemoteIp     // Catch: java.lang.Throwable -> L19a
            boolean r4 = r4.isEmpty()     // Catch: java.lang.Throwable -> L19a
            if (r4 == 0) goto L180
            goto L183
        L180:
            java.lang.String r4 = r1.lastRemoteIp     // Catch: java.lang.Throwable -> L19a
            goto L185
        L183:
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L19a
        L185:
            r6 = r4
            r7 = 0
            r4 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L19a
            java.lang.String r2 = "Successfully sent %s to %s"
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch: java.lang.Throwable -> L19a
            r4 = 0
            r3[r4] = r13     // Catch: java.lang.Throwable -> L19a
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L19a
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r2, r3)     // Catch: java.lang.Throwable -> L19a
            return r4
        L19a:
            r0 = move-exception
            goto L1a9
        L19c:
            r0 = move-exception
            r19 = r8
        L19f:
            r8 = 0
            r14 = 2
            goto L1a9
        L1a2:
            r0 = move-exception
            r19 = r6
            r13 = r7
            r8 = r15
            r14 = 2
            r15 = r5
        L1a9:
            r1.mThrowable = r0
            java.lang.Object[] r2 = new java.lang.Object[r14]
            java.lang.String r3 = "guid"
            java.lang.String r3 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r3)
            r4 = 0
            r2[r4] = r3
            r3 = 1
            r2[r3] = r0
            java.lang.String r3 = "StatisHttpEncryptUtil"
            java.lang.String r4 = "guid:%s. http statis exception %s"
            com.yy.hiidostatis.inner.util.log.L.debug(r3, r4, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L214
            r2.<init>()     // Catch: java.lang.Throwable -> L214
            int r3 = r1.statusCode     // Catch: java.lang.Throwable -> L214
            r2.append(r3)     // Catch: java.lang.Throwable -> L214
            r2.append(r12)     // Catch: java.lang.Throwable -> L214
            r2.append(r0)     // Catch: java.lang.Throwable -> L214
            r2.append(r12)     // Catch: java.lang.Throwable -> L214
            java.lang.Throwable r3 = r0.getCause()     // Catch: java.lang.Throwable -> L214
            r2.append(r3)     // Catch: java.lang.Throwable -> L214
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L214
            r2 = 0
            java.lang.String r3 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L214
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L214
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L214
            r5.<init>()     // Catch: java.lang.Throwable -> L214
            int r7 = r20.getLastStatusCode()     // Catch: java.lang.Throwable -> L214
            r5.append(r7)     // Catch: java.lang.Throwable -> L214
            r5.append(r11)     // Catch: java.lang.Throwable -> L214
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L214
            int r5 = r20.getLastTryTimes()     // Catch: java.lang.Throwable -> L214
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L214
            r5 = r22
            r18 = r8
            r8 = r17
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L216
            r2 = 0
            java.lang.String r3 = "Fail"
            r5 = 0
            r6 = 0
            r7 = 0
            r4 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L216
            r2 = 0
            goto L220
        L214:
            r18 = r8
        L216:
            java.lang.String r0 = r0.getMessage()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r0, r3)
        L220:
            int r5 = r15 + (-1)
            if (r15 > 0) goto L225
            return r2
        L225:
            r7 = r13
            r15 = r18
            r6 = r19
            r8 = 2
            r13 = 1
            r14 = 0
            goto L91
        L22f:
            r0 = move-exception
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r0
            java.lang.String r3 = "encrypt exception = %s"
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r3, r2)
            r1.mThrowable = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = r1.statusCode
            r2.append(r3)
            java.lang.String r3 = "|encrypt exception="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r6 = r2.toString()
            r2 = 0
            java.lang.String r3 = r1.mLastSmkData
            java.lang.String r4 = r1.mLastHost
            int r0 = r20.getLastStatusCode()
            java.lang.String r7 = java.lang.String.valueOf(r0)
            r8 = 0
            r5 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)
            r2 = 0
            return r2
        L268:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.hiidostatis.inner.util.http.StatisHttpEncryptUtil.sendContent(java.lang.String, java.lang.String, int):boolean");
    }
}
