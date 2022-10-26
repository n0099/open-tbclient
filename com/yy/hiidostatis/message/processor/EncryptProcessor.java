package com.yy.hiidostatis.message.processor;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.inner.util.Util;
import com.yy.hiidostatis.inner.util.cipher.AesCipher;
import com.yy.hiidostatis.inner.util.cipher.Base64Util;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import com.yy.hiidostatis.message.MessageProcessor;
import com.yy.hiidostatis.message.bean.Message;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes8.dex */
public class EncryptProcessor implements MessageProcessor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String RSA_PUB_KEY = "MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRSvSVZEbyQwtFwNtNiZKkCAwEAAQ==";
    public transient /* synthetic */ FieldHolder $fh;
    public RsaCipher mRsaCipher;

    public EncryptProcessor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRsaCipher = null;
    }

    private Message encrypt(Message message) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, message)) == null) {
            String randStringEx = Util.getRandStringEx(4);
            byte[] encrypt = new AesCipher(randStringEx.getBytes()).encrypt(message.getContent());
            String encryptTlogAesKey = getRsaCipher().encryptTlogAesKey(randStringEx.getBytes());
            if (message.isSingle()) {
                Map parseParams = Util.parseParams(message.getUrlParams());
                message.setUrlParams(String.format(Locale.CHINA, "act=mbsdkdata&smkdata=%s&EC=%s&appkey=%s&item=%s&enc=b64&hiido_time=%.3f", URLEncoder.encode(encryptTlogAesKey, "UTF-8"), parseParams.get("EC"), parseParams.get("appkey"), parseParams.get("item"), Double.valueOf(System.currentTimeMillis() / 1000.0d)));
            } else {
                message.setUrlParams(String.format(Locale.CHINA, "smkdata=%s&enc=b64", URLEncoder.encode(encryptTlogAesKey, "UTF-8")));
            }
            message.setContent(encrypt);
            return message;
        }
        return (Message) invokeL.objValue;
    }

    private RsaCipher getRsaCipher() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            RsaCipher rsaCipher = this.mRsaCipher;
            if (rsaCipher != null) {
                return rsaCipher;
            }
            synchronized (this) {
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

    @Override // com.yy.hiidostatis.message.MessageProcessor
    public Message process(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            try {
                return encrypt(message);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Message) invokeL.objValue;
    }
}
