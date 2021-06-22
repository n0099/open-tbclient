package d.a.n0.r.q;

import com.baidu.tieba.pushdialog.PushDialogActivity;
import org.json.JSONObject;
import tbclient.MultiForumPerm;
/* loaded from: classes3.dex */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f53771a;

    /* renamed from: b  reason: collision with root package name */
    public int f53772b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53773c;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f53771a = jSONObject.optInt("is_bawu") == 1;
        this.f53772b = "manager".equals(jSONObject.optString("bawu_type")) ? 1 : PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(jSONObject.optString("bawu_type")) ? 2 : 0;
        this.f53773c = jSONObject.optInt("is_deleted") == 1;
    }

    public void b(MultiForumPerm multiForumPerm) {
        if (multiForumPerm == null) {
            return;
        }
        this.f53771a = multiForumPerm.is_bawu.intValue() == 1;
        this.f53772b = "manager".equals(multiForumPerm.bawu_type) ? 1 : PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(multiForumPerm.bawu_type) ? 2 : 0;
        this.f53773c = multiForumPerm.is_deleted.intValue() == 1;
    }
}
