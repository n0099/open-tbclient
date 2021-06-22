package d.a.m0.a.u.f.b.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.m0.a.a2.e;
import d.a.m0.a.u.e.j.g;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends BasePendingOperation {
    public static final CopyOnWriteArrayList<String> j;

    /* renamed from: e  reason: collision with root package name */
    public g f49009e;

    /* renamed from: f  reason: collision with root package name */
    public e f49010f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f49011g;

    /* renamed from: h  reason: collision with root package name */
    public String f49012h;

    /* renamed from: i  reason: collision with root package name */
    public String f49013i;

    static {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        j = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        j.add("https://dxp.baidu.com/mini");
        j.add("https://mbd.baidu.com/smtapp/recordhandler/getrecordinfo");
        j.add("https://eclick.baidu.com/se.jpg");
        j.add("https://miniapp-ad.cdn.bcebos.com/miniapp_ad/config/cg.json");
    }

    public c(@NonNull g gVar, @NonNull e eVar, @NonNull JSONObject jSONObject, @NonNull String str, @NonNull String str2) {
        this.f49009e = gVar;
        this.f49010f = eVar;
        this.f49011g = jSONObject;
        this.f49012h = str;
        this.f49013i = str2;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public boolean a() {
        return e(this.f49011g.optString("url"));
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public String b() {
        return "request";
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public String c() {
        return String.format("%s : %s", this.f49010f.getAppId(), this.f49011g.optString("url"));
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public BasePendingOperation.OperationType d() {
        return BasePendingOperation.OperationType.OPERATION_TYPE_REQUEST;
    }

    public final boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int size = j.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = j.get(i2);
            if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f49009e.A(this.f49010f, this.f49011g, this.f49012h, this.f49013i);
    }
}
