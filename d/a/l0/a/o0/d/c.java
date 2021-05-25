package d.a.l0.a.o0.d;

import android.content.ContentValues;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends b {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public ContentValues f43913d;

    public c(@Nullable Map<String, String> map) {
        super("lifecycle", map);
    }

    @Override // d.a.l0.a.o0.d.b, d.a.l0.a.o0.d.a
    public String f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(d.a.l0.a.o0.a.c(str, "cuid", d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b())));
        sb.append(d.a.l0.a.o0.a.c(str, "mtjCuid", d.a.l0.a.c1.a.a0().i(d.a.l0.a.c1.a.b())));
        ContentValues contentValues = this.f43913d;
        if (contentValues != null) {
            for (String str2 : contentValues.keySet()) {
                sb.append(d.a.l0.a.o0.a.b(str, str2, this.f43913d.get(str2)));
            }
        } else {
            for (Map.Entry<String, String> entry : this.f43912c.entrySet()) {
                sb.append(d.a.l0.a.o0.a.c(str, entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }

    public c(@NonNull ContentValues contentValues) {
        super("lifecycle", null);
        this.f43913d = contentValues;
    }
}
