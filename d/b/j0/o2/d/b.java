package d.b.j0.o2.d;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f59273a;

    /* renamed from: b  reason: collision with root package name */
    public String f59274b;

    /* renamed from: c  reason: collision with root package name */
    public int f59275c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichText f59276d;

    public TbRichText a() {
        return this.f59276d;
    }

    public int b() {
        return this.f59275c;
    }

    public long c() {
        return this.f59273a;
    }

    public String d() {
        return this.f59274b;
    }

    public void e(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo == null) {
            return;
        }
        this.f59273a = lockWindowThreadInfo.tid.longValue();
        this.f59274b = lockWindowThreadInfo.title;
        this.f59275c = lockWindowThreadInfo.post_num.intValue();
        if (ListUtils.isEmpty(lockWindowThreadInfo.content)) {
            return;
        }
        this.f59276d = TbRichTextView.U(context, lockWindowThreadInfo.content, true);
    }
}
