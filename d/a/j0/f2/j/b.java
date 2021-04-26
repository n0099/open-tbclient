package d.a.j0.f2.j;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import d.a.c.j.e.n;
import d.a.j0.g2.e.h;
import d.a.j0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f54313a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54314b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f54315c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f54316d;

    public b(TbPageContext tbPageContext, Bundle bundle, b0<h> b0Var) {
        this.f54314b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.f54313a = cVar;
        cVar.f(b0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f54316d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        this.f54315c = new ArrayList();
        PersonMoreData personMoreData = this.f54316d;
        if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
            return;
        }
        for (PersonMoreItemData personMoreItemData : this.f54316d.mUrlMaps) {
            if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                h hVar = new h();
                hVar.f54579i = personMoreItemData.mName;
                hVar.f54575e = 36;
                hVar.k = personMoreItemData.mUrl;
                hVar.o = personMoreItemData.mId;
                this.f54315c.add(hVar);
            }
        }
    }

    public void b() {
        this.f54314b.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.f54313a.c(this.f54314b.getPageActivity().findViewById(R.id.person_more_layout));
        a();
        this.f54313a.e(this.f54315c);
    }

    public void c() {
        c cVar = this.f54313a;
        if (cVar != null) {
            cVar.d();
        }
    }
}
