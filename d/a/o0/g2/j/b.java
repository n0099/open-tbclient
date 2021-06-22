package d.a.o0.g2.j;

import android.os.Bundle;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import d.a.c.k.e.n;
import d.a.o0.h2.e.h;
import d.a.o0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public c f59022a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext f59023b;

    /* renamed from: c  reason: collision with root package name */
    public List<n> f59024c;

    /* renamed from: d  reason: collision with root package name */
    public PersonMoreData f59025d;

    public b(TbPageContext tbPageContext, Bundle bundle, b0<h> b0Var) {
        this.f59023b = tbPageContext;
        c cVar = new c(tbPageContext);
        this.f59022a = cVar;
        cVar.f(b0Var);
        if (bundle == null || !(OrmObject.objectWithBundle(bundle, PersonMoreData.class) instanceof PersonMoreData)) {
            return;
        }
        this.f59025d = (PersonMoreData) OrmObject.objectWithBundle(bundle, PersonMoreData.class);
    }

    public final void a() {
        this.f59024c = new ArrayList();
        PersonMoreData personMoreData = this.f59025d;
        if (personMoreData == null || ListUtils.isEmpty(personMoreData.mUrlMaps)) {
            return;
        }
        for (PersonMoreItemData personMoreItemData : this.f59025d.mUrlMaps) {
            if (personMoreItemData != null && !StringUtils.isNull(personMoreItemData.mUrl)) {
                h hVar = new h();
                hVar.f59374i = personMoreItemData.mName;
                hVar.f59370e = 36;
                hVar.k = personMoreItemData.mUrl;
                hVar.o = personMoreItemData.mId;
                this.f59024c.add(hVar);
            }
        }
    }

    public void b() {
        this.f59023b.getPageActivity().setContentView(R.layout.person_center_more_layout);
        this.f59022a.c(this.f59023b.getPageActivity().findViewById(R.id.person_more_layout));
        a();
        this.f59022a.e(this.f59024c);
    }

    public void c() {
        c cVar = this.f59022a;
        if (cVar != null) {
            cVar.d();
        }
    }
}
