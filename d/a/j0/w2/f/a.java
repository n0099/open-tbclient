package d.a.j0.w2.f;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.alibaba.fastjson.asm.Label;
/* loaded from: classes5.dex */
public class a {
    public static boolean a(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity) && intent != null) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }
}
