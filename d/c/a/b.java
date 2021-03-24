package d.c.a;

import android.util.Log;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public interface b {

    /* loaded from: classes5.dex */
    public static class a implements b {
        @Override // d.c.a.b
        public void a(String str, String str2, Throwable th) {
            Log.v(str, str2, th);
        }

        @Override // d.c.a.b
        public void b(String str, String str2, Throwable th) {
            Log.d(str, str2, th);
        }

        @Override // d.c.a.b
        public void c(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }
    }

    void a(String str, String str2, @Nullable Throwable th);

    void b(String str, String str2, @Nullable Throwable th);

    void c(String str, String str2, @Nullable Throwable th);
}
