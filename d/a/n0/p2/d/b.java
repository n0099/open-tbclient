package d.a.n0.p2.d;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f61847a;

    /* renamed from: b  reason: collision with root package name */
    public String f61848b;

    /* renamed from: c  reason: collision with root package name */
    public int f61849c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichText f61850d;

    public TbRichText a() {
        return this.f61850d;
    }

    public int b() {
        return this.f61849c;
    }

    public long c() {
        return this.f61847a;
    }

    public String d() {
        return this.f61848b;
    }

    public void e(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo == null) {
            return;
        }
        this.f61847a = lockWindowThreadInfo.tid.longValue();
        this.f61848b = lockWindowThreadInfo.title;
        this.f61849c = lockWindowThreadInfo.post_num.intValue();
        if (ListUtils.isEmpty(lockWindowThreadInfo.content)) {
            return;
        }
        this.f61850d = TbRichTextView.U(context, lockWindowThreadInfo.content, true);
    }
}
