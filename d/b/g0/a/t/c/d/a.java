package d.b.g0.a.t.c.d;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import d.b.g0.a.c0.c;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.d;
import d.b.g0.a.t.e.b;
import d.b.g0.a.z0.f;
import java.io.File;
import java.net.URLConnection;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.b.g0.a.t.c.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0813a implements ActivityResultConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46375a;

        public C0813a(String str) {
            this.f46375a = str;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent) {
            if (d.f46321c) {
                Log.d("shareFile", "resultCode:" + i);
            }
            a.this.c(this.f46375a, new b(0));
            return true;
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public final String q(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf > 0) {
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.substring(lastIndexOf + 1));
            return !TextUtils.isEmpty(contentTypeFor) ? contentTypeFor : "*/*";
        }
        return "*/*";
    }

    public b r(String str) {
        Uri fromFile;
        if (d.f46321c) {
            Log.d("Api-Base", "handle: " + str);
        }
        if (k()) {
            c.b("Api-Base", "Api-Base does not supported when app is invisible.");
            return new b(1001, "Api-Base does not supported when app is invisible.");
        }
        Pair<b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Base", str);
        b bVar = (b) a2.first;
        if (!bVar.b()) {
            if (d.f46321c) {
                c.b("Api-Base", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) a2.second;
        String optString = jSONObject.optString("filePath");
        String u = d.b.g0.a.a2.b.u(optString, e.T());
        if (!TextUtils.isEmpty(optString) && d.b.g0.a.a2.b.c(optString) == PathType.BD_FILE && !TextUtils.isEmpty(u)) {
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                c.b("Api-Base", "cb is required");
                return new b(202, "cb is required");
            }
            File file = new File(u);
            if (file.exists() && !file.isDirectory()) {
                SwanAppActivity activity = f.V().getActivity();
                if (activity == null) {
                    c.b("Api-Base", "activity null");
                    return new b(1001, "activity null");
                }
                ActivityResultDispatcher resultDispatcher = activity.getResultDispatcher();
                Intent intent = new Intent();
                if (d.b.g0.a.i2.c.i()) {
                    fromFile = FileProvider.getUriForFile(activity, activity.getPackageName() + ".swan.fileprovider", file);
                    intent.setFlags(3);
                } else {
                    fromFile = Uri.fromFile(file);
                }
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", fromFile);
                intent.setType(q(u));
                resultDispatcher.addConsumer(new C0813a(optString2));
                resultDispatcher.startActivityForResult(Intent.createChooser(intent, "分享到..."));
                return new b(0);
            }
            c.b("Api-Base", "file not exists");
            return new b(1001, "file not exists");
        }
        c.b("Api-Base", "a valid filePath is required");
        return new b(202, "a valid filePath is required");
    }
}
