package d.b.g0.a.i2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44748a = d.b.g0.a.k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f44749b = "aiapps_folder" + File.separator + "feed_back_record.txt";

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44750e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f44751f;

        public a(String str, boolean z) {
            this.f44750e = str;
            this.f44751f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + q.f44749b;
            if (q.f44748a) {
                Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + this.f44750e);
            }
            d.b.g0.a.v0.a.b(str, this.f44750e, this.f44751f);
        }
    }

    public static void c(@NonNull String str, boolean z) {
        p.k(new a(str, z), "record_feedback_ext_info");
    }
}
