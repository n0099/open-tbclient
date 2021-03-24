package d.b.i0.c2.l.b;

import com.baidu.tbadk.TbPageContext;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes5.dex */
public class f {
    public static final c a(TbPageContext<?> tbPageContext, ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null) {
            return null;
        }
        if (l.longValue() == 2) {
            return new a(excContent);
        }
        if (excContent.type.longValue() == 0) {
            return new g(tbPageContext.getPageActivity(), excContent);
        }
        if (excContent.type.longValue() == 1) {
            return new b(tbPageContext, excContent);
        }
        return null;
    }

    public static final d b(ExcContent excContent) {
        Long l;
        if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
            return null;
        }
        return new e(excContent);
    }
}
