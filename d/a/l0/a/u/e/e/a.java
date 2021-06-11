package d.a.l0.a.u.e.e;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.storage.PathType;
import d.a.l0.a.a2.e;
import d.a.l0.a.g1.f;
import d.a.l0.a.u.c.d;
import d.a.l0.a.u.h.b;
import d.a.l0.a.v2.s0;
import java.io.File;
import java.net.URLConnection;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.a.l0.a.u.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0894a implements ActivityResultConsumer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48580a;

        public C0894a(String str) {
            this.f48580a = str;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            if (d.f48486c) {
                Log.d("shareFile", "resultCode:" + i2);
            }
            a.this.d(this.f48580a, new b(0));
            return true;
        }
    }

    public a(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
    }

    public final String r(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf > 0) {
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.substring(lastIndexOf + 1));
            return !TextUtils.isEmpty(contentTypeFor) ? contentTypeFor : "*/*";
        }
        return "*/*";
    }

    public b s(String str) {
        Uri fromFile;
        if (d.f48486c) {
            Log.d("Api-Base", "handle: " + str);
        }
        if (l()) {
            d.a.l0.a.e0.d.b("Api-Base", "Api-Base does not supported when app is invisible.");
            return new b(1001, "Api-Base does not supported when app is invisible.");
        }
        Pair<b, JSONObject> b2 = d.a.l0.a.u.i.b.b("Api-Base", str);
        b bVar = (b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.f48486c) {
                d.a.l0.a.e0.d.b("Api-Base", "parse fail");
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) b2.second;
        String optString = jSONObject.optString("filePath");
        String M = d.a.l0.a.k2.b.M(optString, e.V());
        if (!TextUtils.isEmpty(optString) && d.a.l0.a.k2.b.s(optString) == PathType.BD_FILE && !TextUtils.isEmpty(M)) {
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                d.a.l0.a.e0.d.b("Api-Base", "cb is required");
                return new b(202, "cb is required");
            }
            File file = new File(M);
            if (file.exists() && !file.isDirectory()) {
                SwanAppActivity activity = f.V().getActivity();
                if (activity == null) {
                    d.a.l0.a.e0.d.b("Api-Base", "activity null");
                    return new b(1001, "activity null");
                }
                ActivityResultDispatcher resultDispatcher = activity.getResultDispatcher();
                Intent intent = new Intent();
                if (d.a.l0.a.v2.d.i()) {
                    fromFile = s0.a(activity, file);
                    intent.setFlags(3);
                } else {
                    fromFile = Uri.fromFile(file);
                }
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", fromFile);
                intent.setType(r(M));
                resultDispatcher.addConsumer(new C0894a(optString2));
                resultDispatcher.startActivityForResult(Intent.createChooser(intent, "分享到..."));
                return new b(0);
            }
            d.a.l0.a.e0.d.b("Api-Base", "file not exists");
            return new b(1001, "file not exists");
        }
        d.a.l0.a.e0.d.b("Api-Base", "a valid filePath is required");
        return new b(202, "a valid filePath is required");
    }
}
