package d.b.h0.a.s0.j;

import androidx.annotation.NonNull;
import com.davemorrissey.labs.subscaleview.ImageSource;
import d.b.h0.a.r1.e;
/* loaded from: classes2.dex */
public class a {
    public static String a(@NonNull String str) {
        if (str.startsWith(ImageSource.FILE_SCHEME)) {
            str = str.substring(8);
        }
        e y = e.y();
        return (!d.b.h0.a.a2.b.m(str) || y == null) ? str : d.b.h0.a.a2.b.p(str, y);
    }
}
