package com.yy.hiidostatis.inner.util.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.io.ByteArrayInputStream;
/* loaded from: classes2.dex */
public class MetricsHttpEncryptUtil extends AbstractStatisHttpUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RSA_PUB_KEY = "MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRSvSVZEbyQwtFwNtNiZKkCAwEAAQ==";
    public static final String URL_FORMAT = "http://%s/c.gif";
    public static final String URL_PARAM = "act=mmetric&smkdata=$smkdata&EC=$EC&appkey=$appkey&item=$item";
    public transient /* synthetic */ FieldHolder $fh;
    public String mLastHost;
    public String mLastSmkData;
    public RsaCipher mRsaCipher;

    public MetricsHttpEncryptUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRsaCipher = null;
    }

    private RsaCipher getRsaCipher() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mRsaCipher == null) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64Util.decode("MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRSvSVZEbyQwtFwNtNiZKkCAwEAAQ=="));
                RsaCipher rsaCipher = new RsaCipher();
                rsaCipher.loadPublicKey(byteArrayInputStream);
                this.mRsaCipher = rsaCipher;
            }
            return this.mRsaCipher;
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
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x00a7
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // com.yy.hiidostatis.inner.util.http.AbstractStatisHttpUtil
    public boolean sendContent(java.lang.String r20, java.lang.String r21, int r22) {
        /*
            r19 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.yy.hiidostatis.inner.util.http.MetricsHttpEncryptUtil.$ic
            if (r0 != 0) goto L244
        L4:
            r1 = r19
            r0 = r20
            r9 = r21
            r10 = r22
            java.lang.String r11 = ""
            java.lang.String r12 = "|"
            r13 = 1
            java.lang.Object[] r2 = new java.lang.Object[r13]
            r14 = 0
            r2[r14] = r0
            java.lang.String r3 = "hiido service address is %s"
            com.yy.hiidostatis.inner.util.log.L.brief(r3, r2)
            r15 = 0
            r1.mThrowable = r15
            r1.mLastHost = r15
            r1.mLastSmkData = r15
            r8 = 2
            java.lang.Object[] r2 = new java.lang.Object[r8]
            r2[r14] = r0
            java.lang.String r3 = "act=mmetric&smkdata=$smkdata&EC=$EC&appkey=$appkey&item=$item"
            r2[r13] = r3
            java.lang.String r3 = "%s?%s"
            java.lang.String r2 = java.lang.String.format(r3, r2)
            r3 = 4
            java.lang.String r3 = com.yy.hiidostatis.inner.util.Util.getRandStringEx(r3)     // Catch: java.lang.Throwable -> L20b
            com.yy.hiidostatis.inner.util.cipher.AesCipher r4 = new com.yy.hiidostatis.inner.util.cipher.AesCipher     // Catch: java.lang.Throwable -> L20b
            byte[] r5 = r3.getBytes()     // Catch: java.lang.Throwable -> L20b
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L20b
            java.lang.String r5 = "UTF-8"
            byte[] r5 = r9.getBytes(r5)     // Catch: java.lang.Throwable -> L20b
            java.lang.String r7 = r4.encryptTlogBytesBase64(r5)     // Catch: java.lang.Throwable -> L20b
            java.lang.String r4 = "%s&enc=b64"
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch: java.lang.Throwable -> L20b
            r5[r14] = r2     // Catch: java.lang.Throwable -> L20b
            java.lang.String r2 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L20b
            com.yy.hiidostatis.inner.util.cipher.RsaCipher r4 = r19.getRsaCipher()     // Catch: java.lang.Throwable -> L20b
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> L20b
            java.lang.String r3 = r4.encryptTlogAesKey(r3)     // Catch: java.lang.Throwable -> L20b
            java.lang.String r4 = "$smkdata"
            java.lang.String r2 = r2.replace(r4, r3)     // Catch: java.lang.Throwable -> L20b
            java.lang.String r4 = "$appkey"
            java.lang.String r5 = "appkey"
            java.lang.String r5 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r5)     // Catch: java.lang.Throwable -> L20b
            java.lang.String r2 = r2.replace(r4, r5)     // Catch: java.lang.Throwable -> L20b
            java.lang.String r4 = "$item"
            java.lang.String r5 = "act"
            java.lang.String r5 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r5)     // Catch: java.lang.Throwable -> L20b
            java.lang.String r6 = r2.replace(r4, r5)     // Catch: java.lang.Throwable -> L20b
            r1.mLastSmkData = r3     // Catch: java.lang.Throwable -> L20b
            java.net.URI r2 = new java.net.URI     // Catch: java.lang.Throwable -> L20b
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L20b
            java.lang.String r0 = r2.getHost()     // Catch: java.lang.Throwable -> L20b
            r1.mLastHost = r0     // Catch: java.lang.Throwable -> L20b
            r5 = r10
        L8b:
            int r0 = r19.getLastTryTimes()     // Catch: java.lang.Throwable -> L17c
            if (r0 <= 0) goto Lae
            r2 = 0
            java.lang.String r3 = "Retry"
            r0 = 0
            r16 = 0
            r17 = 0
            r4 = r21
            r15 = r5
            r5 = r0
            r8 = r6
            r6 = r16
            r13 = r7
            r7 = r17
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L176
            goto Lb1
        La7:
            r0 = move-exception
            r15 = r5
            r13 = r7
            r18 = r6
            goto L179
        Lae:
            r15 = r5
            r8 = r6
            r13 = r7
        Lb1:
            java.lang.String r0 = "$EC"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L176
            r2.<init>()     // Catch: java.lang.Throwable -> L176
            int r3 = r1.lastTryTimes     // Catch: java.lang.Throwable -> L176
            r2.append(r3)     // Catch: java.lang.Throwable -> L176
            r2.append(r11)     // Catch: java.lang.Throwable -> L176
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L176
            java.lang.String r0 = r8.replace(r0, r2)     // Catch: java.lang.Throwable -> L176
            if (r10 == r15) goto Le0
            java.lang.String r2 = "Try again to send %s with url %s, tried times %d."
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L176
            r3[r14] = r13     // Catch: java.lang.Throwable -> L176
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L176
            int r4 = r10 - r15
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L176
            r5 = 2
            r3[r5] = r4     // Catch: java.lang.Throwable -> L176
            com.yy.hiidostatis.inner.util.log.L.brief(r2, r3)     // Catch: java.lang.Throwable -> L176
        Le0:
            int r2 = r1.lastTryTimes     // Catch: java.lang.Throwable -> L176
            r3 = 1
            int r2 = r2 + r3
            r1.lastTryTimes = r2     // Catch: java.lang.Throwable -> L176
            boolean r2 = r1.post(r0, r13)     // Catch: java.lang.Throwable -> L176
            if (r2 != 0) goto L14c
            java.lang.String r2 = "Failed to send %s to %s."
            r7 = 2
            java.lang.Object[] r3 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L146
            r3[r14] = r13     // Catch: java.lang.Throwable -> L146
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L146
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r2, r3)     // Catch: java.lang.Throwable -> L146
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L146
            r0.<init>()     // Catch: java.lang.Throwable -> L146
            int r2 = r1.statusCode     // Catch: java.lang.Throwable -> L146
            r0.append(r2)     // Catch: java.lang.Throwable -> L146
            r0.append(r12)     // Catch: java.lang.Throwable -> L146
            java.lang.String r2 = r1.reasonPhrase     // Catch: java.lang.Throwable -> L146
            r0.append(r2)     // Catch: java.lang.Throwable -> L146
            r0.append(r12)     // Catch: java.lang.Throwable -> L146
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L146
            r2 = 0
            java.lang.String r3 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L146
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L146
            int r0 = r19.getLastStatusCode()     // Catch: java.lang.Throwable -> L146
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L146
            int r5 = r19.getLastTryTimes()     // Catch: java.lang.Throwable -> L146
            java.lang.Integer r17 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L146
            r5 = r21
            r18 = 2
            r7 = r0
            r18 = r8
            r14 = 2
            r8 = r17
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L144
            r2 = 0
            java.lang.String r3 = "Fail"
            r5 = 0
            r6 = 0
            r7 = 0
            r4 = r21
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L144
            r2 = 0
            r17 = 0
            goto L1fc
        L144:
            r0 = move-exception
            goto L14a
        L146:
            r0 = move-exception
            r18 = r8
            r14 = 2
        L14a:
            r8 = 0
            goto L183
        L14c:
            r18 = r8
            r8 = 0
            r14 = 2
            r1.mThrowable = r8     // Catch: java.lang.Throwable -> L174
            java.lang.String r2 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L174
            java.lang.String r3 = r1.mLastHost     // Catch: java.lang.Throwable -> L174
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendSucLog(r8, r2, r3, r9)     // Catch: java.lang.Throwable -> L174
            r2 = 0
            java.lang.String r3 = "Suc"
            java.lang.String r5 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L174
            java.lang.String r6 = r1.mLastHost     // Catch: java.lang.Throwable -> L174
            r7 = 0
            r4 = r21
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L174
            java.lang.String r2 = "Successfully sent %s to %s"
            java.lang.Object[] r3 = new java.lang.Object[r14]     // Catch: java.lang.Throwable -> L174
            r4 = 0
            r3[r4] = r13     // Catch: java.lang.Throwable -> L174
            r4 = 1
            r3[r4] = r0     // Catch: java.lang.Throwable -> L174
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r2, r3)     // Catch: java.lang.Throwable -> L174
            return r4
        L174:
            r0 = move-exception
            goto L183
        L176:
            r0 = move-exception
            r18 = r8
        L179:
            r8 = 0
            r14 = 2
            goto L183
        L17c:
            r0 = move-exception
            r18 = r6
            r13 = r7
            r8 = r15
            r14 = 2
            r15 = r5
        L183:
            r1.mThrowable = r0
            java.lang.Object[] r2 = new java.lang.Object[r14]
            java.lang.String r3 = "guid"
            java.lang.String r3 = com.yy.hiidostatis.inner.util.Util.parseParam(r9, r3)
            r4 = 0
            r2[r4] = r3
            r3 = 1
            r2[r3] = r0
            java.lang.String r3 = "MetricsHttpEncryptUtil"
            java.lang.String r4 = "guid:%s. http statis exception %s"
            com.yy.hiidostatis.inner.util.log.L.debug(r3, r4, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1ef
            r2.<init>()     // Catch: java.lang.Throwable -> L1ef
            int r3 = r1.statusCode     // Catch: java.lang.Throwable -> L1ef
            r2.append(r3)     // Catch: java.lang.Throwable -> L1ef
            r2.append(r12)     // Catch: java.lang.Throwable -> L1ef
            r2.append(r0)     // Catch: java.lang.Throwable -> L1ef
            r2.append(r12)     // Catch: java.lang.Throwable -> L1ef
            java.lang.Throwable r0 = r0.getCause()     // Catch: java.lang.Throwable -> L1ef
            r2.append(r0)     // Catch: java.lang.Throwable -> L1ef
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L1ef
            r2 = 0
            java.lang.String r3 = r1.mLastSmkData     // Catch: java.lang.Throwable -> L1ef
            java.lang.String r4 = r1.mLastHost     // Catch: java.lang.Throwable -> L1ef
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1ef
            r0.<init>()     // Catch: java.lang.Throwable -> L1ef
            int r5 = r19.getLastStatusCode()     // Catch: java.lang.Throwable -> L1ef
            r0.append(r5)     // Catch: java.lang.Throwable -> L1ef
            r0.append(r11)     // Catch: java.lang.Throwable -> L1ef
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L1ef
            int r0 = r19.getLastTryTimes()     // Catch: java.lang.Throwable -> L1ef
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L1ef
            r5 = r21
            r17 = r8
            r8 = r0
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L1ed
            r2 = 0
            java.lang.String r3 = "Fail"
            r5 = 0
            r6 = 0
            r7 = 0
            r4 = r21
            com.yy.hiidostatis.inner.util.log.ActLog.writeActLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L1ed
            r2 = 0
            goto L1fc
        L1ed:
            r0 = move-exception
            goto L1f2
        L1ef:
            r0 = move-exception
            r17 = r8
        L1f2:
            java.lang.String r0 = r0.getMessage()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.yy.hiidostatis.inner.util.log.L.debug(r1, r0, r3)
        L1fc:
            int r5 = r15 + (-1)
            if (r15 > 0) goto L201
            return r2
        L201:
            r7 = r13
            r15 = r17
            r6 = r18
            r8 = 2
            r13 = 1
            r14 = 0
            goto L8b
        L20b:
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
            int r0 = r19.getLastStatusCode()
            java.lang.String r7 = java.lang.String.valueOf(r0)
            r8 = 0
            r5 = r21
            com.yy.hiidostatis.inner.util.log.ActLog.writeSendFailLog(r2, r3, r4, r5, r6, r7, r8)
            r2 = 0
            return r2
        L244:
            r17 = r0
            r18 = 1048582(0x100006, float:1.469376E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r17.invokeLLI(r18, r19, r20, r21, r22)
            if (r0 == 0) goto L4
            boolean r1 = r0.booleanValue
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.hiidostatis.inner.util.http.MetricsHttpEncryptUtil.sendContent(java.lang.String, java.lang.String, int):boolean");
    }

    @Deprecated
    public MetricsHttpEncryptUtil(String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, strArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mRsaCipher = null;
    }
}
