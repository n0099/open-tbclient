package com.meizu.cloud.pushsdk.platform;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class b {
    public static String a(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(Map<String, String> map, String str) {
        Set<Map.Entry> entrySet = new TreeMap(map).entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : entrySet) {
            sb.append((String) entry.getKey());
            sb.append("=");
            sb.append((String) entry.getValue());
        }
        sb.append(str);
        return a(sb.toString());
    }
}
