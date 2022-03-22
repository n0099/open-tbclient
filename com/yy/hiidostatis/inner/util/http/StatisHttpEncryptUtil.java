package com.yy.hiidostatis.inner.util.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.io.ByteArrayInputStream;
/* loaded from: classes7.dex */
public class StatisHttpEncryptUtil extends AbstractStatisHttpUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String[] ADDRESSES_OTHER;
    public static final String RSA_PUB_KEY = "MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRSvSVZEbyQwtFwNtNiZKkCAwEAAQ==";
    public static final String URL_FORMAT = "http://%s/c.gif";
    public static final String URL_PARAM = "act=mbsdkdata&smkdata=$smkdata&EC=$EC&appkey=$appkey&item=$item";
    public transient /* synthetic */ FieldHolder $fh;
    public String body;
    public String mLastHost;
    public String mLastSmkData;
    public RsaCipher mRsaCipher;
    public Object rsaLock;
    public String urlParams;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(615863776, "Lcom/yy/hiidostatis/inner/util/http/StatisHttpEncryptUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(615863776, "Lcom/yy/hiidostatis/inner/util/http/StatisHttpEncryptUtil;");
                return;
            }
        }
        ADDRESSES_OTHER = new String[0];
    }

    public StatisHttpEncryptUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRsaCipher = null;
        this.rsaLock = new Object();
    }

    private RsaCipher getRsaCipher() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
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
        return (RsaCipher) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.IStatisHttpUtil
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? HiidoSDK.getHiidoHost() : (String) invokeV.objValue;
    }

    public String getLastHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLastHost : (String) invokeV.objValue;
    }

    public String getLastSmkData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLastSmkData : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String[] getUrlAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? HiidoSDK.getHiidoIps() : (String[]) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String getUrlFormat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "http://%s/c.gif" : (String) invokeV.objValue;
    }

    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public String getUrlService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.format("http://%s/c.gif", HiidoSDK.getHiidoHost()) : (String) invokeV.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x00b1
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public boolean sendContent(java.lang.String r21, java.lang.String r22, int r23) {
        /*
            r20 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.yy.hiidostatis.inner.util.http.StatisHttpEncryptUtil.$ic
            if (r0 != 0) goto L26e
        L4:
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
            if (r0 == 0) goto L26c
            boolean r2 = r21.isEmpty()
            if (r2 == 0) goto L25
            goto L26c
        L25:
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
            java.lang.String r3 = com.yy.hiidostatis.inner.util.Util.getRandStringEx(r3)     // Catch: java.lang.Throwable -> L233
            com.yy.hiidostatis.inner.util.cipher.AesCipher r4 = new com.yy.hiidostatis.inner.util.cipher.AesCipher     // Catch: java.lang.Throwable -> L233
            byte[] r5 = r3.getBytes()     // Catch: java.lang.Throwable -> L233
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L233
            java.lang.String r5 = "UTF-8"
            byte[] r5 = r9.getBytes(r5)     // Catch: java.lang.Throwable -> L233
            java.lang.String r7 = r4.encryptTlogBytesBase64(r5)     // Catch: java.lang.Throwable -> L233
            java.lang.String r4 = "%s&enc=b64"
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch: java.lang.Throwable -> L233
            r5[r14] = r2     // Catch: java.lang.Throwable -> L233
            java.lang.String r2 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L233
            com.yy.hiidostatis.inner.util.cipher.RsaCipher r4 = r20.getRsaCipher()     // Catch: java.lang.Throwable -> L233
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> L233
            java.lang.String r3 = r4.encryptTlogAesKey(r3)     // Catch: java.lang.Throwable -> L233
            java.lang.String r4 = "$smkdata"
            java.lang.String r2 = r2.replace(r4, r3)     // Catch: java.lang.Throwable -> L233
            java.lang.String r4 = "$appkey"
            java.lang.String r5 = "appkey"
            java.lang.String r5 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r5)     // Catch: java.lang.Throwable -> L233
            java.lang.String r2 = r2.replace(r4, r5)     // Catch: java.lang.Throwable -> L233
            java.lang.String r4 = "$item"
            java.lang.String r5 = "act"
            java.lang.String r5 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r5)     // Catch: java.lang.Throwable -> L233
            java.lang.String r6 = r2.replace(r4, r5)     // Catch: java.lang.Throwable -> L233
            r1.mLastSmkData = r3     // Catch: java.lang.Throwable -> L233
            java.net.URI r2 = new java.net.URI     // Catch: java.lang.Throwable -> L233
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L233
            java.lang.String r0 = r2.getHost()     // Catch: java.lang.Throwable -> L233
            r1.mLastHost = r0     // Catch: java.lang.Throwable -> L233
            r5 = r10
        L95:
            int r0 = r20.getLastTryTimes()     // Catch: java.lang.Throwable -> L1a6
            if (r0 <= 0) goto Lb8
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
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L1a0
            goto Lbb
        Lb1:
            r0 = move-exception
            r15 = r5
            r13 = r7
            r19 = r6
            goto L1a3
        Lb8:
            r15 = r5
            r8 = r6
            r13 = r7
        Lbb:
            java.lang.String r0 = "$EC"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1a0
            r2.<init>()     // Catch: java.lang.Throwable -> L1a0
            int r3 = r1.lastTryTimes     // Catch: java.lang.Throwable -> L1a0
            r2.append(r3)     // Catch: java.lang.Throwable -> L1a0
            r2.append(r11)     // Catch: java.lang.Throwable -> L1a0
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L1a0
            java.lang.String r0 = r8.replace(r0, r2)     // Catch: java.lang.Throwable -> L1a0
            if (r10 == r15) goto Lea
            java.lang.String r2 = "Try again to send %s with url %s, tried times %d."
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L1a0
            r3[r14] = r13     // Catch: java.lang.Throwable -> L1a0
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L1a0
            int r4 = r10 - r15
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L1a0
            r5 = 2
            r3[r5] = r4     // Catch: java.lang.Throwable -> L1a0
            com.yy.hiidostatis.inner.util.log.L.brief(r2, r3)     // Catch: java.lang.Throwable -> L1a0
        Lea:
            int r2 = r1.lastTryTimes     // Catch: java.lang.Throwable -> L1a0
            r3 = 1
            int r2 = r2 + r3
            r1.lastTryTimes = r2     // Catch: java.lang.Throwable -> L1a0
            java.lang.String r2 = "?"
            int r2 = r0.indexOf(r2)     // Catch: java.lang.Throwable -> L1a0
            int r2 = r2 + r3
            java.lang.String r2 = r0.substring(r2)     // Catch: java.lang.Throwable -> L1a0
            r1.urlParams = r2     // Catch: java.lang.Throwable -> L1a0
            r1.body = r13     // Catch: java.lang.Throwable -> L1a0
            boolean r2 = r1.post(r0, r13)     // Catch: java.lang.Throwable -> L1a0
            if (r2 != 0) goto L165
            java.lang.String r2 = "Failed to send %s to %s."
            r7 = 2
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L15f
            r3[r14] = r13     // Catch: java.lang.Throwable -> L15f
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L15f
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r2, r3)     // Catch: java.lang.Throwable -> L15f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L15f
            r0.<init>()     // Catch: java.lang.Throwable -> L15f
            int r2 = r1.statusCode     // Catch: java.lang.Throwable -> L15f
            r0.append(r2)     // Catch: java.lang.Throwable -> L15f
            r0.append(r12)     // Catch: java.lang.Throwable -> L15f
            java.lang.String r2 = r1.reasonPhrase     // Catch: java.lang.Throwable -> L15f
            r0.append(r2)     // Catch: java.lang.Throwable -> L15f
            r0.append(r12)     // Catch: java.lang.Throwable -> L15f
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L15f
            r2 = 0
            java.lang.String r3 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L15f
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L15f
            int r0 = r20.getLastStatusCode()     // Catch: java.lang.Throwable -> L15f
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L15f
            int r5 = r20.getLastTryTimes()     // Catch: java.lang.Throwable -> L15f
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L15f
            r5 = r22
            r19 = 2
            r7 = r0
            r19 = r8
            r14 = 2
            r8 = r17
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L15d
            r2 = 0
            java.lang.String r3 = "Fail"
            r5 = 0
            r6 = 0
            r7 = 0
            r4 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L15d
            r2 = 0
            r18 = 0
            goto L224
        L15d:
            r0 = move-exception
            goto L163
        L15f:
            r0 = move-exception
            r19 = r8
            r14 = 2
        L163:
            r8 = 0
            goto L1ad
        L165:
            r19 = r8
            r8 = 0
            r14 = 2
            r1.mThrowable = r8     // Catch: java.lang.Throwable -> L19e
            java.lang.String r2 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L19e
            java.lang.String r3 = r1.mLastHost     // Catch: java.lang.Throwable -> L19e
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendSucLog(r8, r2, r3, r9)     // Catch: java.lang.Throwable -> L19e
            r2 = 0
            java.lang.String r3 = "Suc"
            java.lang.String r5 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L19e
            java.lang.String r4 = r1.lastRemoteIp     // Catch: java.lang.Throwable -> L19e
            if (r4 == 0) goto L187
            java.lang.String r4 = r1.lastRemoteIp     // Catch: java.lang.Throwable -> L19e
            boolean r4 = r4.isEmpty()     // Catch: java.lang.Throwable -> L19e
            if (r4 == 0) goto L184
            goto L187
        L184:
            java.lang.String r4 = r1.lastRemoteIp     // Catch: java.lang.Throwable -> L19e
            goto L189
        L187:
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L19e
        L189:
            r6 = r4
            r7 = 0
            r4 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L19e
            java.lang.String r2 = "Successfully sent %s to %s"
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch: java.lang.Throwable -> L19e
            r4 = 0
            r3[r4] = r13     // Catch: java.lang.Throwable -> L19e
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L19e
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r2, r3)     // Catch: java.lang.Throwable -> L19e
            return r4
        L19e:
            r0 = move-exception
            goto L1ad
        L1a0:
            r0 = move-exception
            r19 = r8
        L1a3:
            r8 = 0
            r14 = 2
            goto L1ad
        L1a6:
            r0 = move-exception
            r19 = r6
            r13 = r7
            r8 = r15
            r14 = 2
            r15 = r5
        L1ad:
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
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L218
            r2.<init>()     // Catch: java.lang.Throwable -> L218
            int r3 = r1.statusCode     // Catch: java.lang.Throwable -> L218
            r2.append(r3)     // Catch: java.lang.Throwable -> L218
            r2.append(r12)     // Catch: java.lang.Throwable -> L218
            r2.append(r0)     // Catch: java.lang.Throwable -> L218
            r2.append(r12)     // Catch: java.lang.Throwable -> L218
            java.lang.Throwable r3 = r0.getCause()     // Catch: java.lang.Throwable -> L218
            r2.append(r3)     // Catch: java.lang.Throwable -> L218
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L218
            r2 = 0
            java.lang.String r3 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L218
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L218
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L218
            r5.<init>()     // Catch: java.lang.Throwable -> L218
            int r7 = r20.getLastStatusCode()     // Catch: java.lang.Throwable -> L218
            r5.append(r7)     // Catch: java.lang.Throwable -> L218
            r5.append(r11)     // Catch: java.lang.Throwable -> L218
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L218
            int r5 = r20.getLastTryTimes()     // Catch: java.lang.Throwable -> L218
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L218
            r5 = r22
            r18 = r8
            r8 = r17
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L21a
            r2 = 0
            java.lang.String r3 = "Fail"
            r5 = 0
            r6 = 0
            r7 = 0
            r4 = r22
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L21a
            r2 = 0
            goto L224
        L218:
            r18 = r8
        L21a:
            java.lang.String r0 = r0.getMessage()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r0, r3)
        L224:
            int r5 = r15 + (-1)
            if (r15 > 0) goto L229
            return r2
        L229:
            r7 = r13
            r15 = r18
            r6 = r19
            r8 = 2
            r13 = 1
            r14 = 0
            goto L95
        L233:
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
        L26c:
            r2 = 0
            return r2
        L26e:
            r18 = r0
            r19 = 1048582(0x100006, float:1.469376E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r18.invokeLLI(r19, r20, r21, r22, r23)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.hiidostatis.inner.util.http.StatisHttpEncryptUtil.sendContent(java.lang.String, java.lang.String, int):boolean");
    }
}
