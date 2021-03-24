package d.b.g0.a.k0.b;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes3.dex */
public class c extends b {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public ContentValues f45057c;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    @Override // d.b.g0.a.k0.b.b, d.b.g0.a.k0.b.a
    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(d.b.g0.a.k0.a.e(str, "cuid", d.b.g0.a.w0.a.O().c(d.b.g0.a.w0.a.c())));
        sb.append(d.b.g0.a.k0.a.e(str, "mtjCuid", d.b.g0.a.w0.a.O().c(d.b.g0.a.w0.a.c())));
        ContentValues contentValues = this.f45057c;
        if (contentValues != null) {
            for (String str2 : contentValues.keySet()) {
                sb.append(d.b.g0.a.k0.a.d(str, str2, this.f45057c.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.f45056b.entrySet()) {
                sb.append(d.b.g0.a.k0.a.e(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.f45057c = contentValues;
    }
}
