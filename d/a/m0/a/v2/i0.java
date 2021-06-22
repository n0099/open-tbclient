package d.a.m0.a.v2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Label;
import java.io.File;
/* loaded from: classes3.dex */
public class i0 {
    public static void a(@NonNull Context context, @NonNull File file) {
        if (file.exists()) {
            Intent intent = new Intent();
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setAction("android.intent.action.SEND");
            intent.setTypeAndNormalize(q0.s(file));
            if (Build.VERSION.SDK_INT >= 24) {
                intent.putExtra("android.intent.extra.STREAM", s0.a(context, file));
                intent.addFlags(1);
            } else {
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
            }
            context.startActivity(intent);
        }
    }
}
