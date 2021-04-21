package d.b.i0.j0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.pageInfo.TbPageTag;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageTag f50977a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageTag f50978b;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.f50978b = tbPageTag;
        c(intent);
    }

    public TbPageTag a() {
        return this.f50978b;
    }

    public TbPageTag b() {
        return this.f50977a;
    }

    public final void c(Intent intent) {
        if (intent != null) {
            this.f50977a = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }
}
