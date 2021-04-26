package d.a.h0.a.t1;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements ISchemeHeadIoc {
    @Override // com.baidu.searchbox.unitedscheme.security.ISchemeHeadIoc
    public String getSchemeHead() {
        return d.a.h0.a.w0.a.k().getSchemeHeader();
    }
}
