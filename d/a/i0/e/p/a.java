package d.a.i0.e.p;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements ISchemeHeadIoc {
    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc
    public String getSchemeHead() {
        return d.a.i0.a.c1.a.m().getSchemeHeader();
    }
}
