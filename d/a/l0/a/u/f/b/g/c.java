package d.a.l0.a.u.f.b.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation;
import d.a.l0.a.a2.e;
import d.a.l0.a.u.e.j.g;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends BasePendingOperation {
    public static final CopyOnWriteArrayList<String> j;

    /* renamed from: e  reason: collision with root package name */
    public g f45227e;

    /* renamed from: f  reason: collision with root package name */
    public e f45228f;

    /* renamed from: g  reason: collision with root package name */
    public JSONObject f45229g;

    /* renamed from: h  reason: collision with root package name */
    public String f45230h;

    /* renamed from: i  reason: collision with root package name */
    public String f45231i;

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
        this.f45227e = gVar;
        this.f45228f = eVar;
        this.f45229g = jSONObject;
        this.f45230h = str;
        this.f45231i = str2;
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public boolean a() {
        return e(this.f45229g.optString("url"));
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public String b() {
        return "request";
    }

    @Override // com.baidu.swan.apps.api.pending.queue.operation.BasePendingOperation
    public String c() {
        return String.format("%s : %s", this.f45228f.getAppId(), this.f45229g.optString("url"));
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
        this.f45227e.A(this.f45228f, this.f45229g, this.f45230h, this.f45231i);
    }
}
