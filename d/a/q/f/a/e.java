package d.a.q.f.a;

import android.content.Context;
import com.baidu.android.common.util.DeviceId;
/* loaded from: classes2.dex */
public class e implements h {
    @Override // d.a.q.f.a.h
    public String a(Context context) {
        if (context != null) {
            return DeviceId.getCUID(context);
        }
        throw new NullPointerException("context should not be null");
    }
}
