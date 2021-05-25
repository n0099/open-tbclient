package d.a.m0.j0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.pageInfo.TbPageTag;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageTag f49431a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageTag f49432b;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.f49432b = tbPageTag;
        c(intent);
    }

    public TbPageTag a() {
        return this.f49432b;
    }

    public TbPageTag b() {
        return this.f49431a;
    }

    public final void c(Intent intent) {
        if (intent != null) {
            this.f49431a = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }
}
