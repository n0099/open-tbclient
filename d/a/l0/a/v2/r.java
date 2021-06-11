package d.a.l0.a.v2;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49138a = d.a.l0.a.k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f49139b = "aiapps_folder" + File.separator + "feed_back_record.txt";

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49140e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f49141f;

        public a(String str, boolean z) {
            this.f49140e = str;
            this.f49141f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + r.f49139b;
            if (r.f49138a) {
                Log.d("SwanAppFeedbackUtils", "recordFeedbackExtInfo: " + this.f49140e);
            }
            d.a.l0.a.b1.a.b(str, this.f49140e, this.f49141f);
        }
    }

    public static void c(@NonNull String str, boolean z) {
        q.j(new a(str, z), "record_feedback_ext_info");
    }
}
