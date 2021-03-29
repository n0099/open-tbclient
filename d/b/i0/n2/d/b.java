package d.b.i0.n2.d;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f57153a;

    /* renamed from: b  reason: collision with root package name */
    public String f57154b;

    /* renamed from: c  reason: collision with root package name */
    public int f57155c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichText f57156d;

    public TbRichText a() {
        return this.f57156d;
    }

    public int b() {
        return this.f57155c;
    }

    public long c() {
        return this.f57153a;
    }

    public String d() {
        return this.f57154b;
    }

    public void e(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo == null) {
            return;
        }
        this.f57153a = lockWindowThreadInfo.tid.longValue();
        this.f57154b = lockWindowThreadInfo.title;
        this.f57155c = lockWindowThreadInfo.post_num.intValue();
        if (ListUtils.isEmpty(lockWindowThreadInfo.content)) {
            return;
        }
        this.f57156d = TbRichTextView.S(context, lockWindowThreadInfo.content, true);
    }
}
