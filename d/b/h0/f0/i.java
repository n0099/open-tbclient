package d.b.h0.f0;

import android.content.Intent;
import com.baidu.tbadk.mutiprocess.DataType;
import com.baidu.tbadk.mutiprocess.ParcelableEvent;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
/* loaded from: classes3.dex */
public class i {

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50195a;

        static {
            int[] iArr = new int[DataType.values().length];
            f50195a = iArr;
            try {
                iArr[DataType.PARCELABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50195a[DataType.SERIALIZABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public d.b.h0.f0.a a(Intent intent) {
        int intExtra = intent.getIntExtra("value_type", -1);
        if (intExtra < 0) {
            return null;
        }
        int i = a.f50195a[DataType.values()[intExtra].ordinal()];
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return (SerializableEvent) intent.getSerializableExtra("value");
        }
        return (ParcelableEvent) intent.getParcelableExtra("value");
    }
}
