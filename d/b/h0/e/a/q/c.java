package d.b.h0.e.a.q;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class c {
    public static String a(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        if (hashMap != null) {
            int i = 0;
            for (String str2 : hashMap.keySet()) {
                i++;
                String str3 = hashMap.get(str2);
                if (i == 1) {
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                } else {
                    sb.append("&");
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("?code2=");
        a aVar = new a();
        sb2.append(aVar.a(sb.toString() + "&b" + System.currentTimeMillis() + "=1"));
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("&b" + System.currentTimeMillis());
        sb4.append("=");
        sb4.append("1");
        return sb3 + sb4.toString();
    }
}
