package d.b.g0.a.k0.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f45056b;

    public b(@NonNull String str) {
        this(str, null);
    }

    @Override // d.b.g0.a.k0.b.a
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f45056b.entrySet()) {
            sb.append(d.b.g0.a.k0.a.e(str, entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }

    public b(@NonNull String str, @Nullable Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.f45056b = hashMap;
        this.f45055a = str;
        if (map != null) {
            hashMap.putAll(map);
        }
    }
}
