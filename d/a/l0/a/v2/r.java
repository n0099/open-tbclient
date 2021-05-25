package d.a.l0.a.v2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45464a = d.a.l0.a.k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f45465b = "aiapps_folder" + File.separator + "feed_back_record.txt";

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45466e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45467f;

        public a(String str, boolean z) {
            this.f45466e = str;
            this.f45467f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + r.f45465b;
            if (r.f45464a) {
                Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + this.f45466e);
            }
            d.a.l0.a.b1.a.b(str, this.f45466e, this.f45467f);
        }
    }

    public static void c(@NonNull String str, boolean z) {
        q.j(new a(str, z), "record_feedback_ext_info");
    }
}
