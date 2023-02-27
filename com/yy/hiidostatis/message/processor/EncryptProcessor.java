package com.yy.hiidostatis.message.processor;

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
    public static final String RSA_PUB_KEY = "MCwwDQYJKoZIhvcNAQEBBQADGwAwGAIRAMRSvSVZEbyQwtFwNtNiZKkCAwEAAQ==";
    public RsaCipher mRsaCipher = null;

    private RsaCipher getRsaCipher() throws Exception {
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

    private Message encrypt(Message message) throws Exception {
        String randStringEx = Util.getRandStringEx(4);
        byte[] encrypt = new AesCipher(randStringEx.getBytes()).encrypt(message.getContent());
        String encryptTlogAesKey = getRsaCipher().encryptTlogAesKey(randStringEx.getBytes());
        if (message.isSingle()) {
            Map<String, String> parseParams = Util.parseParams(message.getUrlParams());
            message.setUrlParams(String.format(Locale.CHINA, "act=mbsdkdata&smkdata=%s&EC=%s&appkey=%s&item=%s&enc=b64&hiido_time=%.3f", URLEncoder.encode(encryptTlogAesKey, "UTF-8"), parseParams.get("EC"), parseParams.get("appkey"), parseParams.get("item"), Double.valueOf(System.currentTimeMillis() / 1000.0d)));
        } else {
            message.setUrlParams(String.format(Locale.CHINA, "smkdata=%s&enc=b64", URLEncoder.encode(encryptTlogAesKey, "UTF-8")));
        }
        message.setContent(encrypt);
        return message;
    }

    @Override // com.yy.hiidostatis.message.MessageProcessor
    public Message process(Message message) {
        try {
            return encrypt(message);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
