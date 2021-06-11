package d.a.m0.j0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.pageInfo.TbPageTag;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageTag f53105a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageTag f53106b;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.f53106b = tbPageTag;
        c(intent);
    }

    public TbPageTag a() {
        return this.f53106b;
    }

    public TbPageTag b() {
        return this.f53105a;
    }

    public final void c(Intent intent) {
        if (intent != null) {
            this.f53105a = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }
}
