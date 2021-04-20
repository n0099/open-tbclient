package d.b.h0.f0;

import android.content.Intent;
import com.baidu.tbadk.mutiprocess.DataType;
import com.baidu.tbadk.mutiprocess.ParcelableEvent;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tbadk.mutiprocess.StickyEvent;
/* loaded from: classes3.dex */
public class j {

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f50602a;

        static {
            int[] iArr = new int[DataType.values().length];
            f50602a = iArr;
            try {
                iArr[DataType.ORM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50602a[DataType.PARCELABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50602a[DataType.SERIALIZABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d.b.h0.f0.a a(Intent intent) {
        int intExtra = intent.getIntExtra("value_type", -1);
        if (intExtra < 0) {
            return null;
        }
        int i = a.f50602a[DataType.values()[intExtra].ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return (SerializableEvent) intent.getSerializableExtra("value");
            }
            return (ParcelableEvent) intent.getParcelableExtra("value");
        }
        return (StickyEvent) intent.getSerializableExtra("value");
    }
}
