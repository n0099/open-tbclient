package d.a.i0.a.v2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45288a = d.a.i0.a.k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f45289b = "aiapps_folder" + File.separator + "feed_back_record.txt";

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45290e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45291f;

        public a(String str, boolean z) {
            this.f45290e = str;
            this.f45291f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + r.f45289b;
            if (r.f45288a) {
                Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + this.f45290e);
            }
            d.a.i0.a.b1.a.b(str, this.f45290e, this.f45291f);
        }
    }

    public static void c(@NonNull String str, boolean z) {
        q.j(new a(str, z), "record_feedback_ext_info");
    }
}
