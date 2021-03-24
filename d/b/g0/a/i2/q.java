package d.b.g0.a.i2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44747a = d.b.g0.a.k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f44748b = "aiapps_folder" + File.separator + "feed_back_record.txt";

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44749e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f44750f;

        public a(String str, boolean z) {
            this.f44749e = str;
            this.f44750f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + q.f44748b;
            if (q.f44747a) {
                Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + this.f44749e);
            }
            d.b.g0.a.v0.a.b(str, this.f44749e, this.f44750f);
        }
    }

    public static void c(@NonNull String str, boolean z) {
        p.k(new a(str, z), "record_feedback_ext_info");
    }
}
