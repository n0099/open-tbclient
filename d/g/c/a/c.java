package d.g.c.a;

import java.nio.charset.Charset;
import org.apache.commons.base.CharEncoding;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f66229a;

    static {
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
        f66229a = Charset.forName("UTF-8");
        Charset.forName(CharEncoding.UTF_16BE);
        Charset.forName(CharEncoding.UTF_16LE);
        Charset.forName("UTF-16");
    }
}
