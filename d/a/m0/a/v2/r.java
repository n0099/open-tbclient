package d.a.m0.a.v2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49246a = d.a.m0.a.k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f49247b = "aiapps_folder" + File.separator + "feed_back_record.txt";

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49248e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f49249f;

        public a(String str, boolean z) {
            this.f49248e = str;
            this.f49249f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + r.f49247b;
            if (r.f49246a) {
                Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + this.f49248e);
            }
            d.a.m0.a.b1.a.b(str, this.f49248e, this.f49249f);
        }
    }

    public static void c(@NonNull String str, boolean z) {
        q.j(new a(str, z), "record_feedback_ext_info");
    }
}
