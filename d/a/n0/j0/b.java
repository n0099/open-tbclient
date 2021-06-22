package d.a.n0.j0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.pageInfo.TbPageTag;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageTag f53212a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageTag f53213b;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.f53213b = tbPageTag;
        c(intent);
    }

    public TbPageTag a() {
        return this.f53213b;
    }

    public TbPageTag b() {
        return this.f53212a;
    }

    public final void c(Intent intent) {
        if (intent != null) {
            this.f53212a = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }
}
