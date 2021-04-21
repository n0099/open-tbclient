package d.b.h0.a.i2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45469a = d.b.h0.a.k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f45470b = "aiapps_folder" + File.separator + "feed_back_record.txt";

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45472f;

        public a(String str, boolean z) {
            this.f45471e = str;
            this.f45472f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + q.f45470b;
            if (q.f45469a) {
                Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + this.f45471e);
            }
            d.b.h0.a.v0.a.b(str, this.f45471e, this.f45472f);
        }
    }

    public static void c(@NonNull String str, boolean z) {
        p.k(new a(str, z), "record_feedback_ext_info");
    }
}
