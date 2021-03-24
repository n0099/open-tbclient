package d.b.h0.j0;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.pageInfo.TbPageTag;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public TbPageTag f50233a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageTag f50234b;

    public b(BdUniqueId bdUniqueId, TbPageTag tbPageTag, Intent intent) {
        this.f50234b = tbPageTag;
        c(intent);
    }

    public TbPageTag a() {
        return this.f50234b;
    }

    public TbPageTag b() {
        return this.f50233a;
    }

    public final void c(Intent intent) {
        if (intent != null) {
            this.f50233a = (TbPageTag) intent.getParcelableExtra("tb_page_tag_source_trace");
        }
    }
}
