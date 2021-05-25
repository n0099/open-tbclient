package d.a.n0.p2.d;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f58156a;

    /* renamed from: b  reason: collision with root package name */
    public String f58157b;

    /* renamed from: c  reason: collision with root package name */
    public int f58158c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichText f58159d;

    public TbRichText a() {
        return this.f58159d;
    }

    public int b() {
        return this.f58158c;
    }

    public long c() {
        return this.f58156a;
    }

    public String d() {
        return this.f58157b;
    }

    public void e(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo == null) {
            return;
        }
        this.f58156a = lockWindowThreadInfo.tid.longValue();
        this.f58157b = lockWindowThreadInfo.title;
        this.f58158c = lockWindowThreadInfo.post_num.intValue();
        if (ListUtils.isEmpty(lockWindowThreadInfo.content)) {
            return;
        }
        this.f58159d = TbRichTextView.U(context, lockWindowThreadInfo.content, true);
    }
}
