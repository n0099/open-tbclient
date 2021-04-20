package d.b.i0.o2.d;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f58852a;

    /* renamed from: b  reason: collision with root package name */
    public String f58853b;

    /* renamed from: c  reason: collision with root package name */
    public int f58854c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichText f58855d;

    public TbRichText a() {
        return this.f58855d;
    }

    public int b() {
        return this.f58854c;
    }

    public long c() {
        return this.f58852a;
    }

    public String d() {
        return this.f58853b;
    }

    public void e(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo == null) {
            return;
        }
        this.f58852a = lockWindowThreadInfo.tid.longValue();
        this.f58853b = lockWindowThreadInfo.title;
        this.f58854c = lockWindowThreadInfo.post_num.intValue();
        if (ListUtils.isEmpty(lockWindowThreadInfo.content)) {
            return;
        }
        this.f58855d = TbRichTextView.U(context, lockWindowThreadInfo.content, true);
    }
}
