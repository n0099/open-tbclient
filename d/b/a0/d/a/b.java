package d.b.a0.d.a;

import android.text.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public abstract class b implements e {
    public static String b(String str, Map<String, String> map) throws URISyntaxException {
        if (map == null || map.size() == 0) {
            return str;
        }
        URI create = URI.create(str);
        StringBuilder sb = new StringBuilder(TextUtils.isEmpty(create.getQuery()) ? "" : create.getQuery());
        if (sb.length() > 0) {
            sb.append(Typography.amp);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append(Typography.amp);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return new URI(create.getScheme(), create.getAuthority(), create.getPath(), sb.toString(), create.getFragment()).toString();
    }
}
