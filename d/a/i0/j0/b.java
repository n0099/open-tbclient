package d.a.i0.j0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.pageInfo.TbPageTag;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageTag f48559a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageTag f48560b;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.f48560b = tbPageTag;
        c(intent);
    }

    public TbPageTag a() {
        return this.f48560b;
    }

    public TbPageTag b() {
        return this.f48559a;
    }

    public final void c(Intent intent) {
        if (intent != null) {
            this.f48559a = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }
}
