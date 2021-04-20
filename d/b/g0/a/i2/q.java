package d.b.g0.a.i2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45140a = d.b.g0.a.k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f45141b = "aiapps_folder" + File.separator + "feed_back_record.txt";

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45142e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45143f;

        public a(String str, boolean z) {
            this.f45142e = str;
            this.f45143f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + q.f45141b;
            if (q.f45140a) {
                Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + this.f45142e);
            }
            d.b.g0.a.v0.a.b(str, this.f45142e, this.f45143f);
        }
    }

    public static void c(@NonNull String str, boolean z) {
        p.k(new a(str, z), "record_feedback_ext_info");
    }
}
