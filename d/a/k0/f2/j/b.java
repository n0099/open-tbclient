package d.a.k0.f2.j;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import d.a.c.j.e.n;
import d.a.k0.g2.e.h;
import d.a.k0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f55020a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f55021b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f55022c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f55023d;

    public b(TbPageContext tbPageContext, Bundle bundle, b0<h> b0Var) {
        this.f55021b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.f55020a = cVar;
        cVar.f(b0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f55023d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        this.f55022c = new ArrayList();
        PersonMoreData personMoreData = this.f55023d;
        if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
            return;
        }
        for (PersonMoreItemData personMoreItemData : this.f55023d.mUrlMaps) {
            if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                h hVar = new h();
                hVar.f55286i = personMoreItemData.mName;
                hVar.f55282e = 36;
                hVar.k = personMoreItemData.mUrl;
                hVar.o = personMoreItemData.mId;
                this.f55022c.add(hVar);
            }
        }
    }

    public void b() {
        this.f55021b.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.f55020a.c(this.f55021b.getPageActivity().findViewById(R.id.person_more_layout));
        a();
        this.f55020a.e(this.f55022c);
    }

    public void c() {
        c cVar = this.f55020a;
        if (cVar != null) {
            cVar.d();
        }
    }
}
