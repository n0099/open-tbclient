package d.b.i0.n2.d;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f57152a;

    /* renamed from: b  reason: collision with root package name */
    public String f57153b;

    /* renamed from: c  reason: collision with root package name */
    public int f57154c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichText f57155d;

    public TbRichText a() {
        return this.f57155d;
    }

    public int b() {
        return this.f57154c;
    }

    public long c() {
        return this.f57152a;
    }

    public String d() {
        return this.f57153b;
    }

    public void e(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo == null) {
            return;
        }
        this.f57152a = lockWindowThreadInfo.tid.longValue();
        this.f57153b = lockWindowThreadInfo.title;
        this.f57154c = lockWindowThreadInfo.post_num.intValue();
        if (ListUtils.isEmpty(lockWindowThreadInfo.content)) {
            return;
        }
        this.f57155d = TbRichTextView.S(context, lockWindowThreadInfo.content, true);
    }
}
