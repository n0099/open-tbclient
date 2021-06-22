package d.b.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f68965a = x0.class.getSimpleName() + "#";

    /* renamed from: b  reason: collision with root package name */
    public static t0<f1> f68966b = new a();

    /* loaded from: classes6.dex */
    public static class a extends t0<f1> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.t0
        /* renamed from: c */
        public f1 a(Object... objArr) {
            return new f1((Context) objArr[0]);
        }
    }

    @WorkerThread
    public static String a(SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String a2 = v0.a(sharedPreferences);
        y0.e("TrackerDr", f68965a + "getCdid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return a2;
    }

    @Nullable
    @AnyThread
    public static String b(@Nullable JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString("id", null);
        }
        return null;
    }

    @Nullable
    @WorkerThread
    public static Map<String, String> c(@NonNull Context context, @NonNull SharedPreferences sharedPreferences) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Map<String, String> b2 = f68966b.b(context).b(100L);
        y0.e("TrackerDr", f68965a + "getOaid takes " + (SystemClock.elapsedRealtime() - elapsedRealtime) + " ms");
        return b2;
    }

    @AnyThread
    public static void d(@NonNull Context context) {
        f68966b.b(context).c();
    }

    @AnyThread
    public static void e(@Nullable c cVar) {
        f1.e(cVar);
    }
}
