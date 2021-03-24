package kotlin.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0004¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u0007*\u00028\u0000H$¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011R$\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00158\u0002@\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", ExifInterface.GPS_DIRECTION_TRUE, "spreadArgument", "", "addSpread", "(Ljava/lang/Object;)V", "", "size", "()I", "values", "result", "toArray", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "position", "I", "getPosition", "setPosition", "(I)V", "", "spreads", "[Ljava/lang/Object;", "spreads$annotations", "()V", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public abstract class PrimitiveSpreadBuilder<T> {
    public int position;
    public final int size;
    public final T[] spreads;

    public PrimitiveSpreadBuilder(int i) {
        this.size = i;
        this.spreads = (T[]) new Object[i];
    }

    public static /* synthetic */ void spreads$annotations() {
    }

    public final void addSpread(T t) {
        T[] tArr = this.spreads;
        int i = this.position;
        this.position = i + 1;
        tArr[i] = t;
    }

    public final int getPosition() {
        return this.position;
    }

    public abstract int getSize(T t);

    public final void setPosition(int i) {
        this.position = i;
    }

    public final int size() {
        int i = this.size - 1;
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            while (true) {
                T t = this.spreads[i3];
                i2 += t != null ? getSize(t) : 1;
                if (i3 == i) {
                    break;
                }
                i3++;
            }
        }
        return i2;
    }

    public final T toArray(T t, T t2) {
        int i;
        int i2 = this.size - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int i4 = 0;
            int i5 = 0;
            i = 0;
            while (true) {
                T t3 = this.spreads[i4];
                if (t3 != null) {
                    if (i5 < i4) {
                        int i6 = i4 - i5;
                        System.arraycopy(t, i5, t2, i, i6);
                        i += i6;
                    }
                    int size = getSize(t3);
                    System.arraycopy(t3, 0, t2, i, size);
                    i += size;
                    i5 = i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4++;
            }
            i3 = i5;
        } else {
            i = 0;
        }
        int i7 = this.size;
        if (i3 < i7) {
            System.arraycopy(t, i3, t2, i, i7 - i3);
        }
        return t2;
    }
}
