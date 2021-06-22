package d.a.m0.f.i.m.b;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public interface b {
    String a();

    boolean b(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull DownloadParams.SwanAppDownloadType swanAppDownloadType, @NonNull d.a.m0.f.i.k.f.a aVar);

    String getAppId();

    String getAppKey();

    String getSdkVersion();

    String k();

    String l(String str);

    String m();

    int n();

    String o(String str);

    int p();

    int q();

    Uri r(@NonNull Context context, @NonNull File file);

    String s();

    String t();

    JSONObject u();

    boolean v(View view);
}
