package d.a.k0.o2.d;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f58047a;

    /* renamed from: b  reason: collision with root package name */
    public String f58048b;

    /* renamed from: c  reason: collision with root package name */
    public int f58049c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichText f58050d;

    public TbRichText a() {
        return this.f58050d;
    }

    public int b() {
        return this.f58049c;
    }

    public long c() {
        return this.f58047a;
    }

    public String d() {
        return this.f58048b;
    }

    public void e(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo == null) {
            return;
        }
        this.f58047a = lockWindowThreadInfo.tid.longValue();
        this.f58048b = lockWindowThreadInfo.title;
        this.f58049c = lockWindowThreadInfo.post_num.intValue();
        if (ListUtils.isEmpty(lockWindowThreadInfo.content)) {
            return;
        }
        this.f58050d = TbRichTextView.U(context, lockWindowThreadInfo.content, true);
    }
}
