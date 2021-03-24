package d.b.i0.e2.j;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import d.b.b.j.e.n;
import d.b.i0.f2.e.h;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f54562a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f54563b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f54564c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f54565d;

    public b(TbPageContext tbPageContext, Bundle bundle, b0<h> b0Var) {
        this.f54563b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.f54562a = cVar;
        cVar.f(b0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f54565d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        this.f54564c = new ArrayList();
        PersonMoreData personMoreData = this.f54565d;
        if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
            return;
        }
        for (PersonMoreItemData personMoreItemData : this.f54565d.mUrlMaps) {
            if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                h hVar = new h();
                hVar.i = personMoreItemData.mName;
                hVar.f54782e = 36;
                hVar.k = personMoreItemData.mUrl;
                hVar.o = personMoreItemData.mId;
                this.f54564c.add(hVar);
            }
        }
    }

    public void b() {
        this.f54563b.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.f54562a.c(this.f54563b.getPageActivity().findViewById(R.id.person_more_layout));
        a();
        this.f54562a.e(this.f54564c);
    }

    public void c() {
        c cVar = this.f54562a;
        if (cVar != null) {
            cVar.d();
        }
    }
}
