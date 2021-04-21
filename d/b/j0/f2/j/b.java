package d.b.j0.f2.j;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import d.b.c.j.e.n;
import d.b.j0.g2.e.h;
import d.b.j0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f56425a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f56426b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f56427c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f56428d;

    public b(TbPageContext tbPageContext, Bundle bundle, b0<h> b0Var) {
        this.f56426b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.f56425a = cVar;
        cVar.f(b0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f56428d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        this.f56427c = new ArrayList();
        PersonMoreData personMoreData = this.f56428d;
        if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
            return;
        }
        for (PersonMoreItemData personMoreItemData : this.f56428d.mUrlMaps) {
            if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                h hVar = new h();
                hVar.i = personMoreItemData.mName;
                hVar.f56674e = 36;
                hVar.k = personMoreItemData.mUrl;
                hVar.o = personMoreItemData.mId;
                this.f56427c.add(hVar);
            }
        }
    }

    public void b() {
        this.f56426b.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.f56425a.c(this.f56426b.getPageActivity().findViewById(R.id.person_more_layout));
        a();
        this.f56425a.e(this.f56427c);
    }

    public void c() {
        c cVar = this.f56425a;
        if (cVar != null) {
            cVar.d();
        }
    }
}
