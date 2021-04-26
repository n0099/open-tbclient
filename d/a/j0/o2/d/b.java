package d.a.j0.o2.d;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f57305a;

    /* renamed from: b  reason: collision with root package name */
    public String f57306b;

    /* renamed from: c  reason: collision with root package name */
    public int f57307c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichText f57308d;

    public TbRichText a() {
        return this.f57308d;
    }

    public int b() {
        return this.f57307c;
    }

    public long c() {
        return this.f57305a;
    }

    public String d() {
        return this.f57306b;
    }

    public void e(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo == null) {
            return;
        }
        this.f57305a = lockWindowThreadInfo.tid.longValue();
        this.f57306b = lockWindowThreadInfo.title;
        this.f57307c = lockWindowThreadInfo.post_num.intValue();
        if (ListUtils.isEmpty(lockWindowThreadInfo.content)) {
            return;
        }
        this.f57308d = TbRichTextView.U(context, lockWindowThreadInfo.content, true);
    }
}
