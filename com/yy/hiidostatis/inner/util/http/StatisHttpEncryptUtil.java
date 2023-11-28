package com.yy.hiidostatis.inner.util.http;

import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.io.ByteArrayInputStream;
/* loaded from: classes2.dex */
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

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String getUrlFormat() {
        return "http://%s/c.gif";
    }

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
    public String getUrlService() {
        return String.format("http://%s/c.gif", HiidoSDK.getHiidoHost());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x00ae
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
            if (r0 == 0) goto L26a
            boolean r2 = r21.isEmpty()
            if (r2 == 0) goto L22
            goto L26a
        L22:
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
            java.lang.String r3 = com.yy.hiidostatis.inner.util.Util.getRandStringEx(r3)     // Catch: java.lang.Throwable -> L230
            com.yy.hiidostatis.inner.util.cipher.AesCipher r4 = new com.yy.hiidostatis.inner.util.cipher.AesCipher     // Catch: java.lang.Throwable -> L230
            byte[] r5 = r3.getBytes()     // Catch: java.lang.Throwable -> L230
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L230
            java.lang.String r5 = "UTF-8"
            byte[] r5 = r9.getBytes(r5)     // Catch: java.lang.Throwable -> L230
            java.lang.String r7 = r4.encryptTlogBytesBase64(r5)     // Catch: java.lang.Throwable -> L230
            java.lang.String r4 = "%s&enc=b64"
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch: java.lang.Throwable -> L230
            r5[r14] = r2     // Catch: java.lang.Throwable -> L230
            java.lang.String r2 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L230
            com.yy.hiidostatis.inner.util.cipher.RsaCipher r4 = r20.getRsaCipher()     // Catch: java.lang.Throwable -> L230
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> L230
            java.lang.String r3 = r4.encryptTlogAesKey(r3)     // Catch: java.lang.Throwable -> L230
            java.lang.String r4 = "$smkdata"
            java.lang.String r2 = r2.replace(r4, r3)     // Catch: java.lang.Throwable -> L230
            java.lang.String r4 = "$appkey"
            java.lang.String r5 = "appkey"
            java.lang.String r5 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r5)     // Catch: java.lang.Throwable -> L230
            java.lang.String r2 = r2.replace(r4, r5)     // Catch: java.lang.Throwable -> L230
            java.lang.String r4 = "$item"
            java.lang.String r5 = "act"
            java.lang.String r5 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r5)     // Catch: java.lang.Throwable -> L230
            java.lang.String r6 = r2.replace(r4, r5)     // Catch: java.lang.Throwable -> L230
            r1.mLastSmkData = r3     // Catch: java.lang.Throwable -> L230
            java.net.URI r2 = new java.net.URI     // Catch: java.lang.Throwable -> L230
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L230
            java.lang.String r0 = r2.getHost()     // Catch: java.lang.Throwable -> L230
            r1.mLastHost = r0     // Catch: java.lang.Throwable -> L230
            r5 = r10
        L92:
            int r0 = r20.getLastTryTimes()     // Catch: java.lang.Throwable -> L1a3
            if (r0 <= 0) goto Lb5
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
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L19d
            goto Lb8
        Lae:
            r0 = move-exception
            r15 = r5
            r13 = r7
            r19 = r6
            goto L1a0
        Lb5:
            r15 = r5
            r8 = r6
            r13 = r7
        Lb8:
            java.lang.String r0 = "$EC"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L19d
            r2.<init>()     // Catch: java.lang.Throwable -> L19d
            int r3 = r1.lastTryTimes     // Catch: java.lang.Throwable -> L19d
            r2.append(r3)     // Catch: java.lang.Throwable -> L19d
            r2.append(r11)     // Catch: java.lang.Throwable -> L19d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L19d
            java.lang.String r0 = r8.replace(r0, r2)     // Catch: java.lang.Throwable -> L19d
            if (r10 == r15) goto Le7
            java.lang.String r2 = "Try again to send %s with url %s, tried times %d."
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L19d
            r3[r14] = r13     // Catch: java.lang.Throwable -> L19d
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L19d
            int r4 = r10 - r15
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L19d
            r5 = 2
            r3[r5] = r4     // Catch: java.lang.Throwable -> L19d
            com.yy.hiidostatis.inner.util.log.L.brief(r2, r3)     // Catch: java.lang.Throwable -> L19d
        Le7:
            int r2 = r1.lastTryTimes     // Catch: java.lang.Throwable -> L19d
            r3 = 1
            int r2 = r2 + r3
            r1.lastTryTimes = r2     // Catch: java.lang.Throwable -> L19d
            java.lang.String r2 = "?"
            int r2 = r0.indexOf(r2)     // Catch: java.lang.Throwable -> L19d
            int r2 = r2 + r3
            java.lang.String r2 = r0.substring(r2)     // Catch: java.lang.Throwable -> L19d
            r1.urlParams = r2     // Catch: java.lang.Throwable -> L19d
            r1.body = r13     // Catch: java.lang.Throwable -> L19d
            boolean r2 = r1.post(r0, r13)     // Catch: java.lang.Throwable -> L19d
            if (r2 != 0) goto L162
            java.lang.String r2 = "Failed to send %s to %s."
            r7 = 2
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L15c
            r3[r14] = r13     // Catch: java.lang.Throwable -> L15c
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L15c
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r2, r3)     // Catch: java.lang.Throwable -> L15c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L15c
            r0.<init>()     // Catch: java.lang.Throwable -> L15c
            int r2 = r1.statusCode     // Catch: java.lang.Throwable -> L15c
            r0.append(r2)     // Catch: java.lang.Throwable -> L15c
            r0.append(r12)     // Catch: java.lang.Throwable -> L15c
            java.lang.String r2 = r1.reasonPhrase     // Catch: java.lang.Throwable -> L15c
            r0.append(r2)     // Catch: java.lang.Throwable -> L15c
            r0.append(r12)     // Catch: java.lang.Throwable -> L15c
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L15c
            r2 = 0
            java.lang.String r3 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L15c
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L15c
            int r0 = r20.getLastStatusCode()     // Catch: java.lang.Throwable -> L15c
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L15c
            int r5 = r20.getLastTryTimes()     // Catch: java.lang.Throwable -> L15c
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L15c
            r5 = r22
            r19 = 2
            r7 = r0
            r19 = r8
            r14 = 2
            r8 = r17
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L15a
            r2 = 0
            java.lang.String r3 = "Fail"
            r5 = 0
            r6 = 0
            r7 = 0
            r4 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L15a
            r2 = 0
            r18 = 0
            goto L221
        L15a:
            r0 = move-exception
            goto L160
        L15c:
            r0 = move-exception
            r19 = r8
            r14 = 2
        L160:
            r8 = 0
            goto L1aa
        L162:
            r19 = r8
            r8 = 0
            r14 = 2
            r1.mThrowable = r8     // Catch: java.lang.Throwable -> L19b
            java.lang.String r2 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L19b
            java.lang.String r3 = r1.mLastHost     // Catch: java.lang.Throwable -> L19b
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendSucLog(r8, r2, r3, r9)     // Catch: java.lang.Throwable -> L19b
            r2 = 0
            java.lang.String r3 = "Suc"
            java.lang.String r5 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L19b
            java.lang.String r4 = r1.lastRemoteIp     // Catch: java.lang.Throwable -> L19b
            if (r4 == 0) goto L184
            java.lang.String r4 = r1.lastRemoteIp     // Catch: java.lang.Throwable -> L19b
            boolean r4 = r4.isEmpty()     // Catch: java.lang.Throwable -> L19b
            if (r4 == 0) goto L181
            goto L184
        L181:
            java.lang.String r4 = r1.lastRemoteIp     // Catch: java.lang.Throwable -> L19b
            goto L186
        L184:
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L19b
        L186:
            r6 = r4
            r7 = 0
            r4 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L19b
            java.lang.String r2 = "Successfully sent %s to %s"
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch: java.lang.Throwable -> L19b
            r4 = 0
            r3[r4] = r13     // Catch: java.lang.Throwable -> L19b
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L19b
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r2, r3)     // Catch: java.lang.Throwable -> L19b
            return r4
        L19b:
            r0 = move-exception
            goto L1aa
        L19d:
            r0 = move-exception
            r19 = r8
        L1a0:
            r8 = 0
            r14 = 2
            goto L1aa
        L1a3:
            r0 = move-exception
            r19 = r6
            r13 = r7
            r8 = r15
            r14 = 2
            r15 = r5
        L1aa:
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
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L215
            r2.<init>()     // Catch: java.lang.Throwable -> L215
            int r3 = r1.statusCode     // Catch: java.lang.Throwable -> L215
            r2.append(r3)     // Catch: java.lang.Throwable -> L215
            r2.append(r12)     // Catch: java.lang.Throwable -> L215
            r2.append(r0)     // Catch: java.lang.Throwable -> L215
            r2.append(r12)     // Catch: java.lang.Throwable -> L215
            java.lang.Throwable r3 = r0.getCause()     // Catch: java.lang.Throwable -> L215
            r2.append(r3)     // Catch: java.lang.Throwable -> L215
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L215
            r2 = 0
            java.lang.String r3 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L215
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L215
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L215
            r5.<init>()     // Catch: java.lang.Throwable -> L215
            int r7 = r20.getLastStatusCode()     // Catch: java.lang.Throwable -> L215
            r5.append(r7)     // Catch: java.lang.Throwable -> L215
            r5.append(r11)     // Catch: java.lang.Throwable -> L215
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L215
            int r5 = r20.getLastTryTimes()     // Catch: java.lang.Throwable -> L215
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L215
            r5 = r22
            r18 = r8
            r8 = r17
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L217
            r2 = 0
            java.lang.String r3 = "Fail"
            r5 = 0
            r6 = 0
            r7 = 0
            r4 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L217
            r2 = 0
            goto L221
        L215:
            r18 = r8
        L217:
            java.lang.String r0 = r0.getMessage()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r0, r3)
        L221:
            int r5 = r15 + (-1)
            if (r15 > 0) goto L226
            return r2
        L226:
            r7 = r13
            r15 = r18
            r6 = r19
            r8 = 2
            r13 = 1
            r14 = 0
            goto L92
        L230:
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
        L26a:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.hiidostatis.inner.util.http.StatisHttpEncryptUtil.sendContent(java.lang.String, java.lang.String, int):boolean");
    }
}
