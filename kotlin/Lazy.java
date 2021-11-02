package kotlin;

import androidx.exifinterface.media.ExifInterface;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\b\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Any;", "", "isInitialized", "()Z", "getValue", "()Ljava/lang/Object;", "value", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public interface Lazy<T> {
    T getValue();

    boolean isInitialized();
}
