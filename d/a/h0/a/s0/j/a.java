package d.a.h0.a.s0.j;

import androidx.annotation.NonNull;
import com.davemorrissey.labs.subscaleview.ImageSource;
import d.a.h0.a.r1.e;
/* loaded from: classes2.dex */
public class a {
    public static String a(@NonNull String str) {
        if (str.startsWith(ImageSource.FILE_SCHEME)) {
            str = str.substring(8);
        }
        e h2 = e.h();
        return (!d.a.h0.a.a2.b.m(str) || h2 == null) ? str : d.a.h0.a.a2.b.p(str, h2);
    }
}
