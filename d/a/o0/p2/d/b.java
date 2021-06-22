package d.a.o0.p2.d;

import android.content.Context;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import tbclient.GetLockWindowMsg.LockWindowThreadInfo;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f61972a;

    /* renamed from: b  reason: collision with root package name */
    public String f61973b;

    /* renamed from: c  reason: collision with root package name */
    public int f61974c;

    /* renamed from: d  reason: collision with root package name */
    public TbRichText f61975d;

    public TbRichText a() {
        return this.f61975d;
    }

    public int b() {
        return this.f61974c;
    }

    public long c() {
        return this.f61972a;
    }

    public String d() {
        return this.f61973b;
    }

    public void e(Context context, LockWindowThreadInfo lockWindowThreadInfo) {
        if (lockWindowThreadInfo == null) {
            return;
        }
        this.f61972a = lockWindowThreadInfo.tid.longValue();
        this.f61973b = lockWindowThreadInfo.title;
        this.f61974c = lockWindowThreadInfo.post_num.intValue();
        if (ListUtils.isEmpty(lockWindowThreadInfo.content)) {
            return;
        }
        this.f61975d = TbRichTextView.U(context, lockWindowThreadInfo.content, true);
    }
}
