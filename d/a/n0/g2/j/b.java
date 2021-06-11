package d.a.n0.g2.j;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import d.a.c.k.e.n;
import d.a.n0.h2.e.h;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f58897a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f58898b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f58899c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f58900d;

    public b(TbPageContext tbPageContext, Bundle bundle, b0<h> b0Var) {
        this.f58898b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.f58897a = cVar;
        cVar.f(b0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f58900d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        this.f58899c = new ArrayList();
        PersonMoreData personMoreData = this.f58900d;
        if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
            return;
        }
        for (PersonMoreItemData personMoreItemData : this.f58900d.mUrlMaps) {
            if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                h hVar = new h();
                hVar.f59249i = personMoreItemData.mName;
                hVar.f59245e = 36;
                hVar.k = personMoreItemData.mUrl;
                hVar.o = personMoreItemData.mId;
                this.f58899c.add(hVar);
            }
        }
    }

    public void b() {
        this.f58898b.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.f58897a.c(this.f58898b.getPageActivity().findViewById(R.id.person_more_layout));
        a();
        this.f58897a.e(this.f58899c);
    }

    public void c() {
        c cVar = this.f58897a;
        if (cVar != null) {
            cVar.d();
        }
    }
}
