package d.a.i0.f0;

import android.content.Intent;
import com.baidu.tbadk.mutiprocess.DataType;
import com.baidu.tbadk.mutiprocess.ParcelableEvent;
import com.baidu.tbadk.mutiprocess.SerializableEvent;
import com.baidu.tbadk.mutiprocess.StickyEvent;
/* loaded from: classes3.dex */
public class k {
    public void a(Intent intent, a aVar) {
        if (aVar instanceof StickyEvent) {
            intent.putExtra("value_type", DataType.ORM.ordinal());
            intent.putExtra("value", (StickyEvent) aVar);
        } else if (aVar instanceof ParcelableEvent) {
            intent.putExtra("value_type", DataType.PARCELABLE.ordinal());
            intent.putExtra("value", (ParcelableEvent) aVar);
        } else if (aVar instanceof SerializableEvent) {
            intent.putExtra("value_type", DataType.SERIALIZABLE.ordinal());
            intent.putExtra("value", (SerializableEvent) aVar);
        }
    }
}
