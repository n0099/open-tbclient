package d.a.l0.a.y0.j;

import androidx.annotation.NonNull;
import com.davemorrissey.labs.subscaleview.ImageSource;
import d.a.l0.a.a2.e;
/* loaded from: classes3.dex */
public class a {
    public static String a(@NonNull String str) {
        if (str.startsWith(ImageSource.FILE_SCHEME)) {
            str = str.substring(8);
        }
        e i2 = e.i();
        return (!d.a.l0.a.k2.b.E(str) || i2 == null) ? str : d.a.l0.a.k2.b.H(str, i2);
    }
}
