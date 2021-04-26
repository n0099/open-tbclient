package d.a.h0.a.i2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42787a = d.a.h0.a.k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f42788b = "aiapps_folder" + File.separator + "feed_back_record.txt";

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f42789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f42790f;

        public a(String str, boolean z) {
            this.f42789e = str;
            this.f42790f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + q.f42788b;
            if (q.f42787a) {
                Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + this.f42789e);
            }
            d.a.h0.a.v0.a.b(str, this.f42789e, this.f42790f);
        }
    }

    public static void c(@NonNull String str, boolean z) {
        p.k(new a(str, z), "record_feedback_ext_info");
    }
}
